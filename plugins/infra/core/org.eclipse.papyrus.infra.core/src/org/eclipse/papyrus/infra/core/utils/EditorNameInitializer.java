/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.utils;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

/**
 * 
 * This class provides useful method to get an unused name for a new editor
 * 
 */
public class EditorNameInitializer {

	private EditorNameInitializer() {
		//to prenvent instanciation
	}

	/**
	 * 
	 * @param editorModelEClass
	 *        the eclass of the model of the editor
	 * @param nameFeature
	 *        the feature name
	 * @param wantedNameWithoutIndex
	 *        the wantedname for the new editor
	 * @param context
	 *        the context of the editor
	 * @return
	 *         the name for this editor
	 */
	public static final String getNameWithIncrement(final EClass editorModelEClass, final EStructuralFeature nameFeature, final String wantedNameWithoutIndex, final EObject context) {
		//a set of the existing index for the wantedName
		final SortedSet<Integer> existingIndex = new TreeSet<Integer>();
		final ECrossReferenceAdapter crossRef = ECrossReferenceAdapter.getCrossReferenceAdapter(context);
		final Collection<Setting> crossReference = crossRef.getNonNavigableInverseReferences(context, true);
		for(final Setting set : crossReference) {
			final EObject eobject = set.getEObject();
			if(eobject.eClass() == editorModelEClass) {
				if(nameFeature != null) {
					final Object currentName = eobject.eGet(nameFeature);
					if(currentName instanceof String) {
						final String aName = (String)currentName;
						if(aName.contains(wantedNameWithoutIndex)) {
							final String lastChar = aName.substring(aName.length() - 1, aName.length());
							try {
								final Integer value = Integer.parseInt(lastChar);
								existingIndex.add(value);
							} catch (final Exception e) {
								//nothing to do
							}
						}
					}
				}
			}
		}
		int index = 0;
		if(!existingIndex.isEmpty()) {
			index = existingIndex.last().intValue() + 1;
		}
		return wantedNameWithoutIndex + String.valueOf(index);
	}
}
