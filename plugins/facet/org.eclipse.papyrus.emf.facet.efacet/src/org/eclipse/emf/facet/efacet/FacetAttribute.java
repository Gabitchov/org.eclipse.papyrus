/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 *  
 */
package org.eclipse.emf.facet.efacet;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A facetAttribute is a virtual attribute added to all the eObjets which are conform to the facet owning the "facetAttribute".
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getFacetAttribute()
 * @model
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface FacetAttribute extends EAttribute, QueryFacetElement {
} // FacetAttribute
