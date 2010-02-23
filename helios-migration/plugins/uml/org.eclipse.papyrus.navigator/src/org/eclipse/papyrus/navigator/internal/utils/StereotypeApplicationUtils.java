/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.internal.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.uml2.common.util.CacheAdapter;

/**
 * Class that manages stereotyped element between model explorer and diagram for profile diagram
 * based
 */
public class StereotypeApplicationUtils {

	/**
	 * Unwraps selection. Gets base element from EObject
	 * 
	 * @param selection
	 *            the selection
	 * 
	 * @return the i selection
	 */
	public static ISelection unwrapStereotypedSelection(ISelection selection) {
		if (selection instanceof StructuredSelection && !selection.isEmpty()) {
			StructuredSelection structuredSelection = (StructuredSelection) selection;
			List<EObject> selectionList = new ArrayList<EObject>();
			for (Iterator<?> iterator = structuredSelection.iterator(); iterator.hasNext();) {
				Object next = iterator.next();
				if (next instanceof EObject) {
					EObject element = getBaseElement((EObject) next);
					if (element != null) {
						selectionList.add(element);
					}
				}
			}
			if (!selectionList.isEmpty()) {
				return new StructuredSelection(selectionList);
			}
		}
		return selection;
	}

	/**
	 * Gets the stereotype application selection of a stereotyped element from common viewer.
	 * 
	 * @param selection
	 *            the selection
	 * 
	 * @return the stereotype application selection
	 */
	public static ISelection getStereotypedSelectionFromCommonViewer(ISelection selection) {
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelectionEvent = (TreeSelection) selection;
			Object firstElement = treeSelectionEvent.getFirstElement();
			if (firstElement instanceof EObject) {
				List<EObject> stereotypedApplications = StereotypeApplicationUtils
						.getStereotypedApplications((EObject) firstElement);
				return new StructuredSelection(stereotypedApplications);
			}
		}
		return selection;
	}

	/**
	 * Gets the stereotyped applications for an eObject
	 * 
	 * @param eObject
	 *            the eObject
	 * 
	 * @return the stereotyped applications
	 */
	public static List<EObject> getStereotypedApplications(EObject eObject) {
		List<EObject> references = new ArrayList<EObject>();
		if (eObject != null) {
			Collection<Setting> inverseReferences = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(eObject);
			for (Setting ref : inverseReferences) {
				EObject extension = ref.getEObject();
				EObject baseElement = getBaseElement(extension);
				if (eObject.equals(baseElement)) {
					references.add(extension);
				}
			}
		}
		return references;
	}

	/**
	 * Gets the base element of an eObject
	 * 
	 * @param eObject
	 *            the eObject
	 * 
	 * @return the base element
	 */
	private static EObject getBaseElement(EObject eObject) {
		if (eObject != null) {
			for (EStructuralFeature f : eObject.eClass().getEAllStructuralFeatures()) {
				if (f.getName().startsWith("base_")) {
					Object b = eObject.eGet(f);
					if (b instanceof EObject && b != null) {
						return (EObject) b;
					}
				}
			}
		}
		return null;
	}

}
