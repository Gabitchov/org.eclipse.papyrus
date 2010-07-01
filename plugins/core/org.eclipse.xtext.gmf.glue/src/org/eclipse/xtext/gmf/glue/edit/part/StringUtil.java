/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.edit.part;

/**
 * @author koehnlein
 */
public class StringUtil {

	/**
	 * This element comes from the XText/GMF integration example, and was not originally documented.
	 * @param s 
	 * @return int
	 */
	public static int getNumLines(String s) {
		int numLines = 1;
		for (char c : s.toCharArray()) {
			if (c == '\n') {
				++numLines;
			}
		}
		return numLines;
	}

	/**
	 * This element comes from the XText/GMF integration example, and was not originally documented.
	 * @param s 
	 * @return int
	 */
	public static int getMaxColumns(String s) {
		int maxColumns = 0;
		int currentColumns = 0;
		for (char c : s.toCharArray()) {
			if (c == '\n') {
				maxColumns = Math.max(maxColumns, currentColumns);
				currentColumns = 0;
			} else {
				++currentColumns;
			}
		}
		return Math.max(currentColumns, maxColumns);
	}
}
