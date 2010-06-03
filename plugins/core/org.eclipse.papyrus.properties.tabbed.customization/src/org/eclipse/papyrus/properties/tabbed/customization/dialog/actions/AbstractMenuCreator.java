/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization.dialog.actions;

import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.widgets.Menu;


/**
 * Abstract class for all menu creators for customization dialog
 */
public abstract class AbstractMenuCreator implements IMenuCreator {

	/** identifier for the add group in the menu */
	public static final String ADD_GROUP = "addGroup";

	/**
	 * {@inheritDoc}
	 */
	public Menu getMenu(Menu parent) {
		return null;
	}

}
