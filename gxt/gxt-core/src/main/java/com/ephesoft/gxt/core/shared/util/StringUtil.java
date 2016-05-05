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

package com.ephesoft.gxt.core.shared.util;

import java.util.List;

import com.ephesoft.gxt.core.shared.constant.CoreCommonConstant;

/**
 * This class is utility class containing various string related APIs which can be accessed directly.
 * 
 * @author Ephesoft
 * @version 1.0
 */
public class StringUtil {

	private static final String DOTS = "...";

	/**
	 * This method is used to trim the string to the size of the characters passed with dots appended or in the middle according to the
	 * value of boolean isDotAtEnd.
	 * 
	 * @param text {@link String} text to be trimmed
	 * @param textLength {@link Integer} number of characters to be displayed
	 * @param numberOfDots {@link Integer} number of dots to be displayed
	 * @param isDotAtEnd {@link Integer} position of dots in the output
	 * @return {@link String}
	 */
	public static String getTrimmedText(final String text, final int textLength, final int numberOfDots, final boolean isDotAtEnd) {
		int effectiveTextLength = textLength - numberOfDots;
		StringBuffer trimmedText = null;
		if (text.length() > effectiveTextLength) {
			trimmedText = new StringBuffer(text.substring(0, effectiveTextLength / 2));
			if (isDotAtEnd) {
				trimmedText.append(text.substring(effectiveTextLength / 2, effectiveTextLength));
				for (int numberOfDotsAdded = 0; numberOfDotsAdded < numberOfDots; numberOfDotsAdded++) {
					trimmedText.append(".");
				}
			} else {
				for (int numberOfDotsAdded = 0; numberOfDotsAdded < numberOfDots; numberOfDotsAdded++) {
					trimmedText.append(".");
				}
				trimmedText.append(text.substring(text.length() - effectiveTextLength / 2));
			}
		} else {
			trimmedText = new StringBuffer(text);
		}
		return trimmedText.toString();
	}

	/**
	 * API to check whether a string contains special characters. Only alphabets, digits and space characters are allowed.
	 * 
	 * @param text {@link String}
	 * @return boolean
	 */
	public static boolean checkForSpecialCharacter(final String text) {
		boolean containsSpecialCharacter = false;
		for (Character character : text.toCharArray()) {

			if (!Character.isLetterOrDigit(character) && !character.equals(' ')) {
				containsSpecialCharacter = true;
				break;
			}
		}
		return containsSpecialCharacter;
	}

	/**
	 * The <code>getDotAppendedSubString</code> method returns a substring of a string up to a given limit appended with '...'.
	 * 
	 * @param characterLimit character limit
	 * @param string {@link String} string from which substring has to be returned
	 * @return {@link String} substring of a given string
	 */
	public static String getDotAppendedSubString(int characterLimit, String string) {
		String tempString = string;
		if (null != string && !string.isEmpty() && string.length() > characterLimit && characterLimit > DOTS.length()) {
			tempString = string.substring(0, characterLimit) + DOTS;
		}
		return tempString;
	}

	/**
	 * Returns true is passed string is null or empty otherwise false.
	 * 
	 * @param string {@link String} to be checked for null or empty
	 * @return
	 */
	public static boolean isNullOrEmpty(String string) {
		return isNullOrEmpty(string, false);
	}

	/**
	 * Returns true is passed string is null or empty otherwise false.
	 * 
	 * @param string {@link String} to be checked for null or empty
	 * @param spaceAllowed specifies if space is allowed as a valid value
	 * @return returns true if passed string is null or empty otherwise false
	 */
	public static boolean isNullOrEmpty(final String string, final boolean spaceAllowed) {
		if (spaceAllowed) {
			return string == null || string.isEmpty();
		} else {
			return string == null || string.trim().isEmpty();
		}
	}

	/**
	 * Concatenates a number of objects together in the form of a String.
	 * 
	 * @param objects {@link Object} Objects to be concatenated to form a String.
	 * @return concatenatedString {@link String} The finally concatenated string.
	 */
	public static String concatenate(final Object... objects) {
		String concatenatedString = null;
		if (null != objects) {
			StringBuilder concatenatedStringBuilder = new StringBuilder();
			for (Object object : objects) {
				concatenatedStringBuilder.append(object);
			}
			concatenatedString = concatenatedStringBuilder.toString();
		}
		return concatenatedString;
	}

	/**
	 * Concatenates a number of Strings together in the form of a String.
	 * 
	 * @param strings {@link String} The strings to be concatenated.
	 * @return concatenatedString {@link String} The finally concatenated string.
	 */
	public static String concatenate(final String... strings) {
		String concatenatedString = null;
		if (null != strings) {
			StringBuilder concatenatedStringBuilder = new StringBuilder();
			for (String string : strings) {
				concatenatedStringBuilder.append(string);
			}
			concatenatedString = concatenatedStringBuilder.toString();
		}
		return concatenatedString;
	}



	/**
	 * Removes the specified characters from a given string.
	 * 
	 * @param strToBeModified {@link String} the string to be modified by removing characters from it.
	 * @param charsToBeReplaced {@link String} the array of characters to be removed from the string.
	 * @return {@link String} the string created after removing the characters.
	 */
	public static String removeCharacters(final String strToBeModified, final char[] charsToBeReplaced) {
		String resultString = null;
		if (!StringUtil.isNullOrEmpty(strToBeModified) && charsToBeReplaced != null) {
			StringBuilder resultStringBuilder = new StringBuilder(strToBeModified.length());
			char[] words = strToBeModified.toCharArray();
			for (int index = 0; index < words.length; index++) {
				boolean matchFailed = true;
				for (int charIndex = 0; charIndex < charsToBeReplaced.length; charIndex++) {
					if (words[index] == charsToBeReplaced[charIndex]) {
						resultStringBuilder.append(CoreCommonConstant.EMPTY_STRING);
						matchFailed = false;
						break;
					}
				}
				if (matchFailed) {
					resultStringBuilder.append(words[index]);
				}
			}
			resultString = resultStringBuilder.toString();
		}

		return resultString;
	}

	/**
	 * Gets the integer value from the passed string. If parameter is not correct '0' will be returned.
	 * 
	 * @param stringValue {@link String} passed string value.
	 * @return integer value in passed string.
	 */
	public static int getIntegerValue(final String stringValue) {
		int integerValue = 0;
		if (!isNullOrEmpty(stringValue)) {
			final StringBuilder builder = new StringBuilder();
			for (final char c : stringValue.toCharArray()) {
				if (Character.isDigit(c)) {
					builder.append(c);
				}
			}
			try {
				final String value = builder.toString();
				integerValue =  isNullOrEmpty(value) ? 0 : Integer.parseInt(value);
			} catch (NumberFormatException numberFormatException) {
				integerValue = 0;
			}
		}
		return integerValue;
	}
	
	/**
	 * Validates the {@code value} passed as a parameter and checks if the {@code value} passed is numeric or not.It returns {@code
	 * true} if {@code value} is valid numeric value otherwise returns {@code false}.
	 * 
	 * @param value represents the value which is to be checked.
	 * @return {@code true} if {@code value} passed is a valid numeric value otherwise returns {@code false}.
	 */
	public static boolean isValidNumericValue(final String value) {
		boolean isValid = false;
		if (!StringUtil.isNullOrEmpty(value)) {
			try {
				if (Integer.parseInt(value.trim()) > 0) {
					isValid = true;
				}
			} catch (final NumberFormatException numberFormatException) {
				isValid = false;
			}
		}
		return isValid;
	}
	
	/**
	 * Concatenates the {@link List} of {@link String} using the separator. Final result is the concatenated list of Strings in each
	 * separated by a <code>separator</code>
	 * 
	 * @param objectsToConcatenate []{@link Object} of Strings to concatenate.
	 * @param separator {@link String} separator to separate the two {@link String} in the final String.
	 * @return {@link String} concatenated {@link String} each separated by the <code>separator</code>.
	 */
	public static String concatenateUsingSeperator(String separator, Object... objectsToConcatenate) {
		String concatenatedString = null;
		if (objectsToConcatenate != null && !isNullOrEmpty(separator)) {
			StringBuilder concatenationBuilder = new StringBuilder();
			int listSize = objectsToConcatenate.length;
			for (int listIndex = 0; listIndex < listSize; listIndex++) {
				if (objectsToConcatenate[listIndex] != null) {
					concatenationBuilder.append(objectsToConcatenate[listIndex].toString());
					if (listIndex != listSize - 1) {
						concatenationBuilder.append(separator);
					}
				}
			}
			concatenatedString = concatenationBuilder.toString();
		}
		return concatenatedString;
	}

}
