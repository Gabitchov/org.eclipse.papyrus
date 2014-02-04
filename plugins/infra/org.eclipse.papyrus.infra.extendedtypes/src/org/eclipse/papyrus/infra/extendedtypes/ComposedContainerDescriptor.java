/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;

/**
 * @author RS211865
 */
public class ComposedContainerDescriptor implements IContainerDescriptor {

	private final List<IContainerDescriptor> containerDescriptors;

	/**
	 * @param containerDescriptors
	 */
	public ComposedContainerDescriptor(List<IContainerDescriptor> containerDescriptors) {
		this.containerDescriptors = containerDescriptors;
	}

	/**
	 * {@inheritDoc}
	 */
	public IElementMatcher getMatcher() {
		List<IElementMatcher> matchers = new ArrayList<IElementMatcher>();
		// creates a composed matcher from all container descriptors
		for(IContainerDescriptor containerDescriptor : getContainerDescriptors()) {
			// each composed advice should approve the request
			IElementMatcher composedMatcher = containerDescriptor.getMatcher();
			if(composedMatcher != null) {
				matchers.add(composedMatcher);
			}
		}
		if(matchers != null && !matchers.isEmpty()) {
			return new ComposedElementMatcher(matchers);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public EReference[] getContainmentFeatures() {
		// retrieve all references in the intersection of all composed container descriptors
		List<EReference> joinReferences = null;
		// creates a composed matcher from all container descriptors
		for(IContainerDescriptor containerDescriptor : getContainerDescriptors()) {
			// each composed advice should approve the request
			EReference[] eReferencesArray = containerDescriptor.getContainmentFeatures();
			if(eReferencesArray != null) {
				List<EReference> eReferences = Arrays.asList(eReferencesArray);
				// if join references has not been set yet, set the list of possible containment features
				// if not, make the intersection of both list
				if(joinReferences ==null) {
					joinReferences = eReferences;
				} else {
					List<EReference> newReferences = new ArrayList<EReference>();
					for(EReference eReference : joinReferences) {
						if(eReferences.contains(eReference)) {
							newReferences.add(eReference);
						}
					}
					joinReferences = newReferences;
				}
			}
		}
		if(joinReferences != null) {
			return joinReferences.toArray(new EReference[] {});
		}
		return null;
	}

	/**
	 * @return the containerDescriptors
	 */
	protected List<IContainerDescriptor> getContainerDescriptors() {
		return containerDescriptors;
	}
}
