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
import com.ephesoft.dcma.da.domain.TableColumnsInfo;
import com.ephesoft.dcma.da.domain.TableInfo;

/**
 * A Dao representing table_columns_info table in database.
 * 
 * @author Ephesoft
 * @version 1.0
 */
public interface TableColumnsInfoDao extends CacheableDao<TableColumnsInfo> {

	/**
	 * An api to fetch all TableColumnsInfo by TableInfo.
	 * 
	 * @param tableInfo {@link TableInfo}
	 * @return {@link List}<{@link TableColumnsInfo}>
	 */
	List<TableColumnsInfo> getTableColumnsInfoByTableInfo(TableInfo tableInfo);

	/**
	 * An api to fetch all TableColumnsInfo by document type name and table name for a batch class.
	 * 
	 * @param batchClassIdentifier {@link String} batch class identifier
	 * @param docTypeName {@link String} document type name
	 * @param tableName {@link String} table name
	 * @return {@link List}<{@link TableColumnsInfo}> table columns info list
	 */
	List<TableColumnsInfo> getTableColumnsInfo(String batchClassIdentifier, String docTypeName, String tableName);

	/**
	 * An api to insert the TableColumnsInfo object.
	 * 
	 * @param TableColumnsInfo TableColumnsInfo
	 */
	void insertTableColumnsInfo(TableColumnsInfo TableColumnsInfo);

	/**
	 * An api to update the TableColumnsInfo object.
	 * 
	 * @param TableColumnsInfo {@link TableColumnsInfo}
	 */
	void updateTableColumnsInfo(TableColumnsInfo TableColumnsInfo);

	/**
	 * An api to remove the TableColumnsInfo object.
	 * 
	 * @param TableColumnsInfo {@link TableColumnsInfo}
	 */
	void removeTableColumnsInfo(TableColumnsInfo TableColumnsInfo);

	/**
	 * API to retrieve list of all the table columns from pool.
	 * 
	 * @return {@link List}< {@link TableColumnsInfo}> The list of table columns.
	 */
	List<TableColumnsInfo> getAllTableColumnsFromPool();

	/**
	 * API to update or save the list of table columns from table column pool.
	 * 
	 * @param listTableColumnsInfo {@link List}< {@link TableColumnsInfo}> The list of table columns which need to save or update.
	 * @param listTableColumnsToBeDeleted {@link List}< {@link TableColumnsInfo}> The list of table columns which need to be deleted.
	 */
	void updateTableColumnsInfo(List<TableColumnsInfo> listTableColumnsInfo, List<TableColumnsInfo> listTableColumnsToBeDeleted);

}
