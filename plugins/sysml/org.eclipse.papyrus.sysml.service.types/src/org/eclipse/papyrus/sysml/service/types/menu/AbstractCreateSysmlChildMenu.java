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
package org.eclipse.papyrus.sysml.service.types.menu;

import org.eclipse.papyrus.infra.tools.util.AbstractCreateMenuFromCommandCategory;


/**
 * Abstract menu for the creation of Sysml elements
 */
public abstract class AbstractCreateSysmlChildMenu extends AbstractCreateMenuFromCommandCategory {

	/** the cateogory of the command used to create SysML elements */
	public static final String SYSML_CREATION_COMMAND_CATEGORY = "org.eclipse.papyrus.sysml.service.types.sysmlElementCreationCommands"; //$NON-NLS-1$

	/**
	 * Constructor.
	 * 
	 */
	public AbstractCreateSysmlChildMenu() {
		super(SYSML_CREATION_COMMAND_CATEGORY);
	}
}
