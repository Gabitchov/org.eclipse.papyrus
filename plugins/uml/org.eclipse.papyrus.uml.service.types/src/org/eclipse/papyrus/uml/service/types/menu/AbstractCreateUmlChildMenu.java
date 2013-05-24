/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.menu;

import org.eclipse.papyrus.infra.tools.util.AbstractCreateMenuFromCommandCategory;


/**
 * Abstract menu for the creation of SysML elements
 */
public abstract class AbstractCreateUmlChildMenu extends AbstractCreateMenuFromCommandCategory {

	/** the category of the UML Creation Command */
	public static final String UML_CREATION_COMMAND_CATEGORY = "org.eclipse.papyrus.uml.service.types.umlElementCreationCommands"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public AbstractCreateUmlChildMenu() {
		super(UML_CREATION_COMMAND_CATEGORY);
	}

}
