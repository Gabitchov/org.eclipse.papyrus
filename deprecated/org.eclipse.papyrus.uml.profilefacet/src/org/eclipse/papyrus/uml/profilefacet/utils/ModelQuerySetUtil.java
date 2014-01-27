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
package org.eclipse.papyrus.uml.profilefacet.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;


public class ModelQuerySetUtil {

	
	private ModelQuerySetUtil() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param eobject
	 *        this object can be an instance of :
	 *        <ul>
	 *        <li>{@link FacetStructuralFeature}</li>
	 *        <li>{@link Facet}</li>
	 *        <li>{@link ProfileFacetSet}</li>
	 *        </ul>
	 * @return
	 *         the {@link ModelQuerySet} used by this eobject. We assume that all {@link Facet} and {@link FacetStructuralFeature} uses the same
	 *         {@link ModelQuerySet} for those queries
	 */
	public static final ModelQuerySet getModelQuerySet(final EObject eobject) {
		if(eobject instanceof FacetStructuralFeature) {
			return ((FacetStructuralFeature)eobject).getValueQuery().getModelQuerySet();
		}
		if(eobject instanceof Facet) {
			return ((Facet)eobject).getConditionQuery().getModelQuerySet();
		}
		if(eobject instanceof FacetSet) {
			if(((FacetSet)eobject).getFacets().size() != 0) {
				return getModelQuerySet(((FacetSet)eobject).getFacets().get(0));
			} else if(((FacetSet)eobject).getESubpackages().size() != 0) {
				return getModelQuerySet(((FacetSet)eobject).getESubpackages().get(0));
			}
		}
		return null;
	}
	
	
}
