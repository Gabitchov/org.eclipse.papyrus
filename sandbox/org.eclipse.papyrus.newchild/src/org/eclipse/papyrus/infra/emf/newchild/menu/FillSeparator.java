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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.infra.emf.newchild.Separator;
import org.eclipse.papyrus.infra.emf.newchild.util.MenuHelper;


public class FillSeparator implements FillElement {

	protected Separator separator;

	protected FillMenuGroup group;

	public FillSeparator(FillMenuGroup parentGroup, Separator separator) {
		this.separator = separator;
		this.group = parentGroup;
	}

	public void fill(IMenuManager menuManager) {
		MenuHelper.add(group, menuManager, new org.eclipse.jface.action.Separator());
	}

}
