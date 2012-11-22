/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.symbols;

import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;

/**
 * Interface that stores all constants for the symbol profile
 */
public interface ISymbolProfileConstants {

	// profile
	
	/** Profile name */
	public final static String SYMBOL_PROFILE_NAME = "Symbols";

	// stereotypes definition
	
	/** TypeSymbolDefinition stereotype name */
	public final static String TYPE_SYMBOL_DEFINITION_QUALIFIED_NAME = SYMBOL_PROFILE_NAME + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + "TypeSymbolDefinition";

	/** TypeSymbolUsage stereotype name */
	public final static String TYPE_SYMBOL_USAGE_QUALIFIED_NAME = SYMBOL_PROFILE_NAME + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + "TypeSymbolUsage";

	// Stereotype properties definition
	
	/** TypeSymbolDefinition::symbolPath property name */
	public final static String TYPE_SYMBOL_DEFINITION_SYMBOL_PATH = "symbolPath";

}
