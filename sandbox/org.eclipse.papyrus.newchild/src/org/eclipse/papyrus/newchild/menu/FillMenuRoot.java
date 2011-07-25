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
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.MenuRoot;


public class FillMenuRoot extends FillMenuContainer {

	protected MenuRoot root;

	public FillMenuRoot(MenuRoot root, Object selectedObject) {
		super(root, selectedObject);

		this.root = root;
	}

	@Override
	public void fill(IMenuManager menuManager) {
		super.fill(menuManager);

		for(MenuGroup group : root.getGroups()) {
			FillerFactory.instance.getFiller(group, selectedObject).fill(menuManager);
		}
	}

}
