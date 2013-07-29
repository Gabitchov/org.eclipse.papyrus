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
package org.eclipse.papyrus.gmf.diagram.common.edit.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;

/**
 * Edit Part that contains editable text.
 */
public interface ITextAwareEditPart extends org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart {

	/**
	 * Get the parser elements.
	 * 
	 * @return the element being parsed.
	 */
	public EObject getParserElement();
	
    /**
     * Gets the default parser options (meaning parser options stored in preferences).
     * 
     * @return ParserOptions the parser options
     */
	public ParserOptions getDefaultParserOptions();
}
