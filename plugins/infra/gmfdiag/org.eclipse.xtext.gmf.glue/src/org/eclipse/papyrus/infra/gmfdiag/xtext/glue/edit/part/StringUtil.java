/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part;

/**
 * @author koehnlein
 */
public class StringUtil {

	/**
	 * This element comes from the XText/GMF integration example, and was not originally documented.
	 * @param s 
	 * @return int
	 */
	public static int[] getNumLinesNumColumns(String s) {
		int numLines = 1;
		int numColumns = 0;
		int[] dimensions = new int[2] ;
		dimensions[0] = numLines ;
		dimensions[1] = 0 ;
		for (char c : s.toCharArray()) {
			if (c == '\n') {
				++numLines;
				dimensions[1] = Math.max(dimensions[1], numColumns) ;
				numColumns = 0 ;
			}
			else {
				++numColumns;
			}
		}
		dimensions[0] = numLines ;
		dimensions[1] = Math.max(dimensions[1], numColumns) ;
		return dimensions;
	}

}
