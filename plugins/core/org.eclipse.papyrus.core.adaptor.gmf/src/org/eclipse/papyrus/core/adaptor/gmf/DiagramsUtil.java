/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.adaptor.gmf;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


public class DiagramsUtil {

	/**
	 * Gets the diagrams associated to element.
	 * 
	 * @param element
	 * @param resourceSet
	 *        can be null, it will then try to retrieve it from the element.
	 * @return the list of diagrams associated with the given element
	 */
	public static List<Diagram> getAssociatedDiagrams(EObject element) {
		Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {
			public boolean apply(EStructuralFeature.Setting setting) {
				return setting.getEObject() instanceof Diagram;
			}
		};
		Function<EStructuralFeature.Setting, Diagram> f = new Function<EStructuralFeature.Setting, Diagram>() {

			public Diagram apply(EStructuralFeature.Setting setting) {
				return (Diagram) setting.getEObject();
			}

		};
		return Lists.newLinkedList(Iterables.transform(Iterables.filter(PapyrusEcoreUtils.getUsages(element), p), f));
	}
}
