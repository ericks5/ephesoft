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
import com.ephesoft.dcma.da.domain.FieldType;

/**
 * A Dao representing field_type table in database.
 * 
 * @author Ephesoft
 * @version 1.0
 */
public interface FieldTypeDao extends CacheableDao<FieldType> {

	/**
	 * An api to fetch all Field types by document type name.
	 * 
	 * @param docTypeName the doc type name{@link String}
	 * @param batchInstanceIdentifierIdentifier the batch instance identifier identifier{@link String}
	 * @return {@link List}< {@link FieldType}>
	 */
	List<FieldType> getFdTypeByDocTypeNameForBatchInstance(String docTypeName, String batchInstanceIdentifierIdentifier);

	/**
	 * An api to fetch all Field types by document type.
	 * 
	 * @param documentType {@link DocumentType}
	 * @return {@link List}< {@link FieldType}>
	 */
	List<FieldType> getFdTypeByDocumentType(DocumentType documentType);

	/**
	 * An api to fetch all Field types by document type name.
	 * 
	 * @param docTypeName String{@link String}
	 * @param batchInstanceIdentifier {@link String}
	 * @param isKVExtraction boolean
	 * @return {@link List}< {@link FieldType}>
	 */
	List<FieldType> getFdTypeByDocumentTypeName(String docTypeName, String batchInstanceIdentifier, boolean isKVExtraction);

	/**
	 * An api to fetch all Field types by document type name.
	 * 
	 * @param docTypeName {@link String}
	 * @param batchInstanceIdentifier {@link String}
	 * @return {@link List}< {@link FieldType}>
	 */
	List<FieldType> getFdTypeAndRegexValidationByDocTypeName(String docTypeName, String batchInstanceIdentifier);

	/**
	 * An api to fetch all Field types by document type name for a batch class.
	 * 
	 * @param docTypeName the doc type name{@link String}
	 * @param batchClassIdentifier the batch class identifier{@link String}
	 * @return {@link List}< {@link FieldType}>
	 */
	List<FieldType> getFdTypeByDocumentTypeNameForBatchClass(String docTypeName, String batchClassIdentifier);

	/**
	 * An api to insert the fieldType object.
	 * 
	 * @param fieldType {@link FieldType}
	 */
	void insertFieldType(FieldType fieldType);

	/**
	 * An api to update the fieldType object.
	 * 
	 * @param fieldType {@link FieldType}
	 */
	void updateFieldType(FieldType fieldType);

	/**
	 * An api to remove the fieldType object.
	 * 
	 * @param fieldType {@link FieldType}
	 */
	void removeFieldType(FieldType fieldType);

	/**
	 * API to get field type for a batch for a particular document.
	 * 
	 * 
	 * @param fieldTypeName {@link String}
	 * @param docTypeName {@link String}
	 * @param batchInstanceIdentifier {@link String}
	 * @return {@link FieldType}
	 */
	FieldType getFieldType(String fieldTypeName, String docTypeName, String batchInstanceIdentifier);

	/**
	 * An api to get field type based on field type identifier.
	 * 
	 * @param identifier the identifier{@link String}
	 * @return {@link FieldType}
	 */
	FieldType getFieldTypeByIdentifier(String identifier);

}
