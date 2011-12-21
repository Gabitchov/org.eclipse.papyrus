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
package org.eclipse.papyrus.infra.emf.newchild.policies;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.infra.emf.newchild.MenuItem;
import org.eclipse.papyrus.infra.emf.newchild.menu.FillElement;
import org.eclipse.papyrus.infra.emf.newchild.menu.FillerFactory;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.ReplacePolicy;


public class ReplaceFillPolicy extends AbstractFillPolicy {

	public void fill(IMenuManager menuManager, EObject parentEObject, EClass eClass, EStructuralFeature role, EObject selectedEObject) {
		for(MenuItem menuItem : getPolicy().getReplaceWith()) {
			FillElement filler = FillerFactory.instance.getFiller(menuItem, selectedEObject);
			filler.fill(menuManager);
		}
	}

	public ReplacePolicy getPolicy() {
		return (ReplacePolicy)policy;
	}

}
