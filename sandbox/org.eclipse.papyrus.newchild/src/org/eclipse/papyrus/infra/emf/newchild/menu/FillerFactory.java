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
package org.eclipse.papyrus.infra.emf.newchild.menu;

import org.eclipse.papyrus.infra.emf.newchild.Activator;
import org.eclipse.papyrus.infra.emf.newchild.CustomFiller;
import org.eclipse.papyrus.infra.emf.newchild.Menu;
import org.eclipse.papyrus.infra.emf.newchild.MenuAction;
import org.eclipse.papyrus.infra.emf.newchild.MenuContainer;
import org.eclipse.papyrus.infra.emf.newchild.MenuGroup;
import org.eclipse.papyrus.infra.emf.newchild.MenuItem;
import org.eclipse.papyrus.infra.emf.newchild.MenuRoot;
import org.eclipse.papyrus.infra.emf.newchild.Separator;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewEMFChildMenu;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;


public class FillerFactory {

	public static FillerFactory instance = new FillerFactory();

	public FillElement getFiller(FillMenuGroup parentGroup, MenuItem menuItem, Object selectedObject) {
		if(menuItem instanceof NewEMFChildMenu) {
			return new FillNewChild(parentGroup, (NewEMFChildMenu)menuItem, selectedObject);
		}

		if(menuItem instanceof Separator) {
			return new FillSeparator(parentGroup, (Separator)menuItem);
		}

		if(menuItem instanceof Menu) {
			return new FillMenu(parentGroup, (Menu)menuItem, selectedObject);
		}

		if(menuItem instanceof MenuAction) {
			return new FillMenuAction(parentGroup, (MenuAction)menuItem, selectedObject);
		}

		if(menuItem instanceof CustomFiller) {
			String className = ((CustomFiller)menuItem).getClassName();
			CustomFillElement filler = ClassLoaderHelper.newInstance(className, CustomFillElement.class);
			filler.setParentGroup(parentGroup);
			filler.setMenuItem((CustomFiller)menuItem);
			return filler;
		}

		Activator.log.warn("Unknown MenuItem type : " + menuItem.eClass().getName());
		return null;
	}

	public FillElement getFiller(MenuItem menuItem, Object selectedObject) {
		return getFiller(null, menuItem, selectedObject);
	}

	public FillElement getFiller(MenuContainer container, Object selectedObject) {
		if(container instanceof MenuGroup) {
			return new FillMenuGroup((MenuGroup)container, selectedObject);
		} else if(container instanceof MenuRoot) {
			return new FillMenuRoot((MenuRoot)container, selectedObject);
		}

		return null;
	}

	private FillerFactory() {

	}
}
