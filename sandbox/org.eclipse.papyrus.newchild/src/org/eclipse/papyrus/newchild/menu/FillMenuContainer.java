/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.newchild.MenuContainer;
import org.eclipse.papyrus.newchild.MenuItem;


public class FillMenuContainer implements FillElement {

	protected MenuContainer container;

	protected Object selectedObject;

	public FillMenuContainer(MenuContainer container, Object selectedObject) {
		this.container = container;
		this.selectedObject = selectedObject;
	}

	public void fill(IMenuManager menuManager) {
		for(MenuItem menuItem : container.getSubmenus()) {
			FillElement filler = FillerFactory.instance.getFiller(menuItem, selectedObject);
			filler.fill(menuManager);
		}
	}

}
