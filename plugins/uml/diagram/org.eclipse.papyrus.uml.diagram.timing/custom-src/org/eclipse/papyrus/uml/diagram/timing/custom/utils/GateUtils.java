/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.UMLPackage;

public final class GateUtils {

	private GateUtils() {
		// utility class
	}

	/**
	 * Get all elements to delete when deleting a Gate.
	 * 
	 * @param gate
	 *        the Gate being deleted
	 * @return the elements (EObjects and Views) that should be deleted together with the Gate
	 */
	public static Collection<EObject> getElementsToDelete(final Gate gate) {
		final Set<EObject> elementsToDestroy = new HashSet<EObject>();
		final Collection<Setting> settings = EcoreUtil.UsageCrossReferencer.find(gate, gate.eResource().getResourceSet());
		for(final Setting setting : settings) {
			// delete messages originating from or going to that gate
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getMessage_SendEvent() || setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getMessage_ReceiveEvent()) {
				elementsToDestroy.add(setting.getEObject());
			}
		}
		return elementsToDestroy;
	}
}
