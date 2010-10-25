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
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;


public class PapyrusEcoreUtils {

	/**
	 * Gets the usages.
	 * 
	 * @param source
	 *        the source
	 * 
	 * @return the usages or null if there is no usages
	 */
	public static Collection<EStructuralFeature.Setting> getUsages(EObject source) {
		Collection<EStructuralFeature.Setting> collection = null;
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(source);
		if(crossReferenceAdapter != null) {
			collection = crossReferenceAdapter.getNonNavigableInverseReferences(source);
		} else {
			collection = EcoreUtil.UsageCrossReferencer.find(source, source.eResource().getResourceSet());
		}
		return collection;
	}

	/**
	 * <pre>
	 * Test if the used element is referenced by other elements than the known
	 * referencer (except its container).
	 * </pre>
	 * 
	 * @param usedObject
	 *        the used object
	 * @param knownReferencer
	 *        the known referencer
	 * @return true if the known referencer is the only referencer.
	 */
	public static boolean isOnlyUsage(EObject usedObject, EObject knownReferencer) {
		boolean isUsed = false;
			
			// Retrieve the list of elements referencing the usedObject.
			Set<EObject> crossReferences = new HashSet<EObject>();
			for(Setting setting : PapyrusEcoreUtils.getUsages(usedObject)) {
				crossReferences.add(setting.getEObject());
			}

			// Remove the container of used object.
			crossReferences.remove(usedObject.eContainer());
			// Remove the knownReferencer from the list of references.
			crossReferences.remove(knownReferencer);
			
			// If no referencer remains in the list, the known element is the only usage. 
			if (crossReferences.isEmpty()) {
				isUsed = true;
			}

		return isUsed;
	}
}
