/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2015 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.gxt.admin.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.ephesoft.dcma.batch.service.BatchSchemaService;
import com.ephesoft.dcma.util.EphesoftStringUtil;
import com.ephesoft.gxt.core.server.DCMAHttpServlet;

/**
 * Servlet for importing document types.
 * 
 * @author ephesoft
 * @version 1.0
 * 
 */
public class ImportTableUploadServlet extends DCMAHttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		final BatchSchemaService bSService = this.getSingleBeanOfType(BatchSchemaService.class);

		final String batchClassIdentifier = req.getParameter("batchClassIdentifier");
		attachFile(req, resp, bSService);
	}

	/**
	 * This API is used to get uploaded file and create directory for given path in parameter.
	 * 
	 * @param filePath {@link String} to create directory.
	 * @return {@link ServletFileUpload} uploaded file.
	 */
	private ServletFileUpload getUploadedFile(final String filePath) {
		final FileItemFactory factory = new DiskFileItemFactory();
		final ServletFileUpload upload = new ServletFileUpload(factory);
		final File exportTableFd = new File(filePath);
		if (!exportTableFd.exists()) {
			exportTableFd.mkdir();
		}
		return upload;
	}

	/**
	 * This API is used to get absolute path of table file.
	 * 
	 * @param item {@link FileItem} uploaded file item.
	 * @param parentDirPath {@link String} parent directory path to get absolute path.
	 * @return {@link String} absolute path of table file.
	 */
	private String getTablePath(final FileItem item, final String parentDirPath) {
		String tablePath = "";
		String tableFileName = item.getName();
		if (tableFileName != null) {
			tableFileName = tableFileName.substring(tableFileName.lastIndexOf(File.separator) + 1);
		}
		tablePath = parentDirPath + File.separator + tableFileName;
		return tablePath;
	}

	/**
	 * This API is used to get table file name.
	 * 
	 * @param item {@link FileItem} uploaded file item.
	 * @return {@link String} table file name.
	 */
	private String getTableFileName(final FileItem item) {
		String tableFileName = item.getName();
		if (tableFileName != null) {
			tableFileName = tableFileName.substring(tableFileName.lastIndexOf(File.separator) + 1);
			tableFileName = FilenameUtils.getName(tableFileName);
		}
		return tableFileName;
	}

	/**
	 * This API is used to write content in temp file.
	 * 
	 * @param item {@link FileItem} uploaded file item.
	 * @param filePath {@link String} to create temporary file.
	 * @param printWriter {@link PrintWriter}.
	 * @return {@link File} temporary file.
	 */
	private File copyItemContentInFile(final FileItem item, final String filePath, final PrintWriter printWriter) {
		File tempTableFile = null;
		OutputStream out = null;
		InputStream instream = null;
		try {
			instream = item.getInputStream();
			tempTableFile = new File(filePath);
//			if (tempTableFile.exists()) {
//				tempTableFile.delete();
//			}
			out = new FileOutputStream(tempTableFile);
			final byte buf[] = new byte[1024];
			int len;
			while ((len = instream.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} catch (final FileNotFoundException e) {
			printWriter.write("Unable to create the export folder.Please try again.");
		} catch (final IOException e) {
			printWriter.write("Unable to read the file.Please try again.");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (final IOException ioe) {
					log.error("Could not close stream for file." + tempTableFile);
				}
			}
			if (instream != null) {
				try {
					instream.close();
				} catch (final IOException ioe) {
					log.error("Could not close stream for file." + filePath);
				}
			}
		}
		return tempTableFile;
	}

	/**
	 * This API is used to process uploaded file .
	 * 
	 * @param upload {@link ServletFileUpload} uploaded file.
	 * @param req {@link HttpServletRequest}.
	 * @param printWriter {@link PrintWriter}.
	 * @param parentDirPath {@link String} to copy the file in directory path.
	 * @return {@link File} temporary file after copy.
	 */
	private String processUploadedFile(final ServletFileUpload upload, final HttpServletRequest req, final PrintWriter printWriter,
			final String parentDirPath) {
		String tableFileName = "";
		String tablePathname = "";
		File tempTableFile = null;
		List<FileItem> items;

		try {
			items = upload.parseRequest(req);
			for (final FileItem item : items) {

				if (!item.isFormField()) {// && "importFile".equals(item.getFieldName())) {
					tablePathname = getTablePath(item, parentDirPath);

					tableFileName = getTableFileName(item);

					tempTableFile = copyItemContentInFile(item, tablePathname, printWriter);

				}
			}
		} catch (final FileUploadException e) {
			printWriter.write("Unable to read the form contents.Please try again.");
		}

		return tempTableFile.getAbsolutePath();
	}

	/**
	 * This API is used to process attach file.
	 * 
	 * @param req {@link HttpServletRequest}.
	 * @param resp {@link HttpServletResponse}.
	 * @param bSService {@link BatchSchemaService}.
	 * @return
	 */
	private void attachFile(final HttpServletRequest req, final HttpServletResponse resp, final BatchSchemaService bSService)
			throws IOException {

		final PrintWriter printWriter = resp.getWriter();
		String tempFile = null;

		if (ServletFileUpload.isMultipartContent(req)) {
			final String testTableDirPath = EphesoftStringUtil.concatenate(bSService.getBaseFolderLocation(), File.separator,
					req.getParameter("batchClassIdentifier"), File.separator, bSService.getTestTableFolderName());
			final ServletFileUpload upload = getUploadedFile(testTableDirPath);

			tempFile = processUploadedFile(upload, req, printWriter, testTableDirPath);
			printWriter.write(tempFile);

		} else {
			log.error("Request contents type is not supported.");
			printWriter.write("Request contents type is not supported.");
		}

		printWriter.flush();
	}
}
