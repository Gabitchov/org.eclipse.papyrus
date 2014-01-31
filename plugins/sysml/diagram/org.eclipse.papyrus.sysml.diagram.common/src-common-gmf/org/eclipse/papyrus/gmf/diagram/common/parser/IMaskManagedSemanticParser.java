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
package org.eclipse.papyrus.gmf.diagram.common.parser;

import java.util.Map;

import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;

/**
 * Interface for semantic parsers that support mask options.
 */
public interface IMaskManagedSemanticParser extends ISemanticParser {

	/** The label to show in case ParserOptions.None is passed as flag (avoid a fully masked label) */
	public static final String MaskedLabel = "<empty label>";

	/**
	 * Get the {@link Map} of masks
	 *
	 * @return the {@link Map} of masks
	 */
	public Map<String, String> getMasks();
}
