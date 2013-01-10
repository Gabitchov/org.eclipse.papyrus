/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Interaction;

/** Utility class for manipulating {@link Interaction}s */
public final class InteractionUtils {

	private InteractionUtils() {
		// utility class
	}

	/**
	 * Return the {@link Interaction} containing the given model element if any, or <code>null</code> if the element is
	 * not recursively contained in any {@link Interaction}.
	 * 
	 * @param eObject
	 *        the model element for which we want to find the containing {@link Interaction}.
	 * @return the parent {@link Interaction} or <code>null</code> if none.
	 */
	public static Interaction getContainingInteraction(final EObject eObject) {
		if(eObject != null) {
			if(eObject instanceof Interaction) {
				return (Interaction)eObject;
			}
			final EObject eContainer = eObject.eContainer();
			return getContainingInteraction(eContainer);
		}
		return null;
	}
}
