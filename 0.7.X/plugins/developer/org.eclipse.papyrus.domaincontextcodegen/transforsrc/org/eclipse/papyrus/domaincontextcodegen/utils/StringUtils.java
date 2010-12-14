/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.domaincontextcodegen.utils;

import org.eclipse.emf.codegen.util.CodeGenUtil;

public class StringUtils {

	public String formatUpperWithSep(String str) {
		return CodeGenUtil.format(str, '_', "", false, false).toUpperCase();
	}
}
