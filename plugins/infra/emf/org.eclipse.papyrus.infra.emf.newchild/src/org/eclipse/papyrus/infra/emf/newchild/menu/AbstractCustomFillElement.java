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
import org.eclipse.papyrus.infra.emf.newchild.CustomFiller;

/**
 * A base implementation for CustomFillElement
 * 
 * @author Camille Letavernier
 */
public abstract class AbstractCustomFillElement implements CustomFillElement {

	protected FillMenuGroup group;

	protected CustomFiller filler;

	protected Object selectedObject;

	public void setMenuItem(CustomFiller filler) {
		this.filler = filler;
	}

	public void setParentGroup(FillMenuGroup group) {
		this.group = group;
	}

	public void setSelectedObject(Object selectedObject) {
		this.selectedObject = selectedObject;
	}

	public abstract void fill(IMenuManager menuManager);

}
