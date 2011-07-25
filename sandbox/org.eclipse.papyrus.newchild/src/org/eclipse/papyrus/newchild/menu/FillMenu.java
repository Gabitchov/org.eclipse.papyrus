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
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.newchild.Menu;
import org.eclipse.papyrus.newchild.runtime.NewchildManager;
import org.eclipse.papyrus.newchild.util.MenuHelper;
import org.eclipse.papyrus.newchild.util.Util;


public class FillMenu extends FillMenuContainer {

	protected Menu menu;

	protected FillMenuGroup parentGroup;

	protected IMenuManager subMenu;

	public FillMenu(FillMenuGroup parentGroup, Menu menu, Object selectedObject) {
		super(menu, selectedObject);
		this.menu = menu;
		this.parentGroup = parentGroup;
	}

	@Override
	public void fill(IMenuManager menuManager) {
		IMenuManager subMenuManager = getSubMenu(menuManager);
		super.fill(subMenuManager);
	}

	protected IMenuManager getSubMenu(IMenuManager fromMenu) {
		if(subMenu == null) {
			subMenu = new MenuManager(menu.getName(), Util.getImage(menu), menu.getId());
			MenuHelper.add(parentGroup, fromMenu, subMenu);

			Separator separator = new Separator();
			separator.setId(NewchildManager.TOP);
			subMenu.add(separator);
		}
		return subMenu;
	}
}
