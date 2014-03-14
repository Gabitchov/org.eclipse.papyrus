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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.infra.emf.newchild.MenuAction;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;


public class FillMenuAction implements FillElement {

	private FillMenuGroup parentGroup;

	private MenuAction menuAction;

	private EObject selectedEObject;

	private EditingDomain domain;

	public FillMenuAction(FillMenuGroup parentGroup, MenuAction menuAction, Object selectedObject){
		this.parentGroup = parentGroup;
		this.menuAction = menuAction;
		this.selectedEObject = EMFHelper.getEObject(selectedObject);
		if(selectedEObject == null) {
			throw new IllegalArgumentException("ExtendedTypes can only be used on EMF EObject");
		}

		domain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedEObject);
	}

	public void fill(IMenuManager menuManager) {
//		MenuHelper.add(parentGroup, menuManager, new ExtendedTypeAction(selectedEObject, menuAction.getElementType(), domain));
	}

}
