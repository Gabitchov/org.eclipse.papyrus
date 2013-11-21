/*******************************************************************************
 * Copyright (c) 2006 - 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.cpp.codegen;

/**
 * String constants for the code generation
 * 
 * @author ansgar
 * 
 */
public class Constants {

	public static final String includeHFile = "// include associated header file"; //$NON-NLS-1$

	public static final String cppIncPreBodyStart = "// Include from CppInclude stereotype (pre-body)"; //$NON-NLS-1$

	public static final String cppIncPreBodyEnd = "// End of CppInclude stereotype (pre-body)"; //$NON-NLS-1$

	public static final String cppIncBodyStart = "// Include from CppInclude declaration (body)"; //$NON-NLS-1$

	public static final String cppIncBodyEnd = "// End of CppInclude stereotype (body)";//$NON-NLS-1$

	public static final String derivedIncludes = "// Derived includes directives";//$NON-NLS-1$

	public static final String forwardDecl = "// forward declarations"; //$NON-NLS-1$

	public static final String staticAttributes = "// static attributes (if any)"; //$NON-NLS-1$

	public static final String undefinedType = "undefined"; //$NON-NLS-1$

}
