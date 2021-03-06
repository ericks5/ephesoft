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

package com.ephesoft.gxt.core.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class OutputDataCarrierDTO implements IsSerializable, Selectable {

	private float confidence;
	private String key;
	private String value;
	private CoordinatesDTO coordinates;
	private String colorCode;
	private String inputFileName;
	private boolean selected;
	private CoordinatesDTO keyCoordinates;
	private String identifier;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public float getConfidence() {
		return confidence;
	}

	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CoordinatesDTO getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(CoordinatesDTO coordinates) {
		this.coordinates = coordinates;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return this.selected;
	}

	@Override
	public void setSelected(boolean selected) {
		// TODO Auto-generated method stub
		this.selected=selected;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}


	public CoordinatesDTO getKeyCoordinates() {
		return keyCoordinates;
	}

	public void setKeyCoordinates(CoordinatesDTO keyCoordinates) {
		this.keyCoordinates = keyCoordinates;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
