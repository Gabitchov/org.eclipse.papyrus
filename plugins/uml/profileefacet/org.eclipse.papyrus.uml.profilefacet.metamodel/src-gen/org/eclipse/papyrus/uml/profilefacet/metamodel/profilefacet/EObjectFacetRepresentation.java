/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Facet Representation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This element is used to store the XMI_ID of the represented element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#getEObjectFacetRepresentation()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EObjectFacetRepresentation extends EObject {
	/**
	 * Returns the value of the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The XMI_ID of the represented element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Represented Element XMI ID</em>' attribute.
	 * @see #setRepresentedElement_XMI_ID(String)
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#getEObjectFacetRepresentation_RepresentedElement_XMI_ID()
	 * @model required="true"
	 * @generated
	 */
	String getRepresentedElement_XMI_ID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Element XMI ID</em>' attribute.
	 * @see #getRepresentedElement_XMI_ID()
	 * @generated
	 */
	void setRepresentedElement_XMI_ID(String value);

} // EObjectFacetRepresentation
