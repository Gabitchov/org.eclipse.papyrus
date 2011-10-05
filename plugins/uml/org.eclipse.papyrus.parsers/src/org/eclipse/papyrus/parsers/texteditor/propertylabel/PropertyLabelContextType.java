/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.propertylabel;

import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContextType;

/**
 * A simple context type for PropertyUtil label.
 */
public class PropertyLabelContextType extends TemplateContextType {

	/**
	 * This context's id.
	 */
	public static final String PROPERTYLABEL_CONTEXT_TYPE = "com.cea.papyrus.classdiagram.parsers.texteditor.propertylabel.type";

	/**
	 * The constructor. Creates a new PROPERTY LABEL context type.
	 */
	public PropertyLabelContextType() {
		addGlobalResolvers();
	}

	/**
	 * adds a variable resolver to the context type.
	 */
	private void addGlobalResolvers() {
		addResolver(new GlobalTemplateVariables.Cursor());
		addResolver(new GlobalTemplateVariables.WordSelection());
		addResolver(new GlobalTemplateVariables.LineSelection());
		addResolver(new GlobalTemplateVariables.Dollar());
		addResolver(new GlobalTemplateVariables.Date());
		addResolver(new GlobalTemplateVariables.Year());
		addResolver(new GlobalTemplateVariables.Time());
		addResolver(new GlobalTemplateVariables.User());
	}

}
