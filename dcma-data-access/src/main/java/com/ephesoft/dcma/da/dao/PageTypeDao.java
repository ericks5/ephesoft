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

package com.ephesoft.dcma.da.dao;

import java.util.List;

import com.ephesoft.dcma.core.dao.CacheableDao;
import com.ephesoft.dcma.da.domain.DocumentType;
import com.ephesoft.dcma.da.domain.PageType;

/**
 * Dao representing page_type table in database
 * 
 * @author Ephesoft
 * 
 */
public interface PageTypeDao extends CacheableDao<PageType> {

	/**
	 * An api to fetch all page types by document type
	 * 
	 * @param documentType {@link DocumentType}
	 * @return {@link List}<{@link PageType}>
	 */
	List<PageType> getPageTypesByDocumentType(DocumentType documentType);

	/**
	 * An api to fetch all Page types by batchInstanceID.
	 * 
	 * @param batchInstanceIdentifierIdentifier {@link String}
	 * @return {@link List}<{@link PageType}>
	 */
	List<PageType> getPageTypesByBatchInstanceID(String batchInstanceIdentifierIdentifier);

	/**
	 * An api to fetch page types by page type name.
	 * 
	 * @param name {@link String}
	 * @param batchClassID {@link String}
	 * @return {@link List}<{@link PageType}>
	 */
	List<PageType> getPageTypeByName(String name, String batchClassID);

	/**
	 * An api to fetch all Page types by document type name.
	 * 
	 * @param docTypeName {@link String}
	 * @return {@link List}<{@link PageType}>
	 */
	List<PageType> getPageTypeByDocTypeName(String docTypeName);

	/**
	 * An api to fetch all the page types for input document type ID.
	 * 
	 * @param documentTypeID {@link String}
	 * @param startResult int
	 * @param maxResult int
	 * @return {@link List}<{@link PageType}>
	 */
	List<PageType> getPageTypes(String documentTypeID, int startResult, int maxResult);

	/**
	 * An api to fetch all batch class id, document type names and Page type names corresponding to each other.
	 * 
	 * @param batchClassIDList List<String>
	 * @return {@link List}<{@link Object[]}>
	 */
	List<Object[]> getDocTypeNameAndPgTypeName(List<String> batchClassIDList);

	/**
	 * An api to insert the page type object.
	 * 
	 * @param pageType {@link PageType}
	 */
	void insertPageType(PageType pageType);

	/**
	 * An api to update the pageType object.
	 * 
	 * @param pageType {@link PageType}
	 */
	void updatePageType(PageType pageType);

	/**
	 * An api to remove the pageType object.
	 * 
	 * @param pageType {@link PageType}
	 */
	void removePageType(PageType pageType);

	/**
	 * API to get the page type by batch class ID.
	 * 
	 * @param batchClassID {@link String}
	 * @return {@link List}<{@link PageType}>
	 */
	List<PageType> getPageTypesByBatchClassID(String batchClassID);
}
