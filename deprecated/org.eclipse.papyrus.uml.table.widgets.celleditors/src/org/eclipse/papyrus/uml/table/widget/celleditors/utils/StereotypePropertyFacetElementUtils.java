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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.widget.celleditors.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.utils.StereotypePropertyUtils;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * this class provides useful method to find to real elements represented by elements of the ProfileFacetSet metamodel
 * 
 */
public class StereotypePropertyFacetElementUtils {


	private StereotypePropertyFacetElementUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param source
	 *        the source eobject
	 * @param feature
	 *        the feature
	 * @return
	 *         the real element according to the source and the feature
	 */
	public static final EObject getRealSource(final EObject source, final EStructuralFeature feature) {
		if(feature instanceof StereotypePropertyElement) {
			final EObject realSource = StereotypePropertyUtils.getStereotypeApplication((Element)source, (StereotypePropertyElement)feature);
			assert realSource != null;
			return realSource;
		}
		return source;
	}

	/**
	 * 
	 * @param source
	 *        the source
	 * @param feature
	 *        the feature
	 * @return
	 *         the real feature, according to source and the feature
	 */
	public static final EStructuralFeature getRealFeature(final EObject source, final EStructuralFeature feature) {
		if(feature instanceof StereotypePropertyElement) {
			final EStructuralFeature realFeature = StereotypePropertyUtils.getEStructuralFeature((Element)source, (StereotypePropertyElement)feature);
			assert realFeature != null;
			return realFeature;
		}
		return feature;
	}

}
