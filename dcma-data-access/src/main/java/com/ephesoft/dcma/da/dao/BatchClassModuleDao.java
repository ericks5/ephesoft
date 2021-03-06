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

import com.ephesoft.dcma.core.common.Order;
import com.ephesoft.dcma.core.dao.CacheableDao;
import com.ephesoft.dcma.da.domain.BatchClassModule;
import com.ephesoft.dcma.da.domain.Module;

/**
 * 
 * @author Ephesoft
 * 
 *         <b>created on</b> Apr 10, 2015 <br/>
 * @version 1.0 <br/>
 *          $LastChangedDate: 2015-04-14 12:40:00 +0530 (Tue, 14 Apr 2015) $ <br/>
 *          $LastChangedRevision: 21592 $ <br/>
 */
public interface BatchClassModuleDao extends CacheableDao<BatchClassModule> {

	/**
	 * API to get the count of modules related to a batch class.
	 * 
	 * @param batchClassId {@link String}
	 * @return Integer {@link Integer}
	 */
	Integer countModules(String batchClassIdentifier);

	/**
	 * API to fetch List of modules corresponding to a batch class.
	 * 
	 * @param batchClassIdentifier {@link String}
	 * @return {@link List}<{@link Module}>
	 */
	List<Module> getBatchClassModule(String batchClassIdentifier);

	/**
	 * API to fetch Modules starting from firstIndex and as many results as MaxResults from a batch class.
	 * 
	 * @param batchClassIdentifier {@link String}
	 * @param firstIndex {@link Integer}
	 * @param maxResults {@link Integer}
	 * @return {@link List}<{@link Module}>
	 */
	List<Module> getModules(String batchClassIdentifier, final int firstIndex, final int maxResults);

	/**
	 * API to fetch the modules by name.
	 * 
	 * @param batchClassIdentifier {@link String}
	 * @param moduleName {@link String}
	 * @return {@link BatchClassModule}
	 */
	BatchClassModule getModuleByName(String batchClassIdentifier, String moduleName);

	/**
	 * API to fetch the modules by workflow name
	 * 
	 * @param batchClassIdentifier {@link String}
	 * @param workflowName {@link String}
	 * @return {@link BatchClassModule}
	 */
	BatchClassModule getModuleByWorkflowName(String batchClassIdentifier, String workflowName);

	/**
	 * 
	 * @param order {@link Order}
	 * @return ({@link List}<{@link BatchClassModule}>
	 */
	List<BatchClassModule> getAllBatchClassModulesInOrder(Order order);

}
