/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GeneralOrderingEditPart;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.UMLPackage;

public final class GeneralOrderingUtils {

	private GeneralOrderingUtils() {
		// utility class
	}

	public static boolean isGeneralOrderingEditPart(final int visualID) {
		return visualID == GeneralOrderingEditPart.VISUAL_ID;
	}

	public static boolean isGeneralOrderingEditPart(final EditPart editPart) {
		return editPart instanceof GeneralOrderingEditPart;
	}

	/**
	 * Find {@link GeneralOrdering}s linked to the given element.
	 * 
	 * @param element
	 *        the element for which related {@link GeneralOrdering}s must be found
	 * @param hideOnly
	 *        whether to only return Views
	 * @param expectedParentView
	 *        if not <code>null</code>, then only return Views under this parent View
	 * @return the list of linked {@link GeneralOrdering}s to remove
	 */
	public static Collection<? extends EObject> getReferencingGeneralOrderingsToRemove(final EObject element, final boolean hideOnly, final View expectedParentView) {
		final EReference[] references = new EReference[]{ UMLPackage.eINSTANCE.getGeneralOrdering_Before(), UMLPackage.eINSTANCE.getGeneralOrdering_After() };
		final Class<?>[] expectedClasses = new Class<?>[]{ GeneralOrdering.class };
		return Utils.getReferencingElementsToRemove(element, references, hideOnly, expectedParentView, expectedClasses);
	}
}
