/*******************************************************************************
 * Copyright (c) 2006 - 2012 CEA LIST.
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

	public static final String includeHFile = "// include associated header file";

	public static final String cppIncPreBodyStart = "// Include from CppInclude stereotype (pre-body)";

	public static final String cppIncPreBodyEnd = "// End of CppInclude stereotype (pre-body)";

	public static final String cppIncBodyStart = "// Include from CppInclude declaration (body)";

	public static final String cppIncBodyEnd = "// End of CppInclude stereotype (body)";

	public static final String derivedIncludes = "// Derived includes directives";

	public static final String forwardDecl = "// forward declarations";

	public static final String staticAttributes = "// static attributes (if any)";
}
