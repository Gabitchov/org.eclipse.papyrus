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
public interface IPapyrusInternalProfileConstants {

	// profile
	/** main profile name */
	public final static String PAPYRUS_INTERNAL_PROFILE_NAME = "PapyrusInternal";

	/** Symbols Sub Profile name */
	public final static String SYMBOL_PROFILE_NAME = PAPYRUS_INTERNAL_PROFILE_NAME + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + "Symbols";

	// stereotypes definition

	/** TypeSymbolDefinition stereotype name */
	public final static String TYPE_SYMBOL_DEFINITION_QUALIFIED_NAME = SYMBOL_PROFILE_NAME + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + "TypeSymbolDefinition";

	// Stereotype properties definition

	/** TypeSymbolDefinition::symbolPath property name */
	public final static String TYPE_SYMBOL_DEFINITION_SYMBOL_PATH = "symbolPath";

	// Extension definition
	/** profile name as defined in the extension point */
	public final static String PAPYRUS_INTERNAL_PROFILE_EXTENSION_NAME = "Papyrus Internal";

}
