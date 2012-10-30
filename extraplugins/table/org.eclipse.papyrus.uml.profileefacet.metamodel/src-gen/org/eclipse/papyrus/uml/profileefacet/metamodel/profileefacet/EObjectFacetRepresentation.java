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
package org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet;

import org.eclipse.emf.ecore.EModelElement;
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
 *   <li>{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation#getRepresented_element_xmi_id <em>Represented element xmi id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetPackage#getEObjectFacetRepresentation()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EObjectFacetRepresentation extends EObject, EModelElement {
	/**
	 * Returns the value of the '<em><b>Represented element xmi id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The XMI_ID of the represented element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Represented element xmi id</em>' attribute.
	 * @see #setRepresented_element_xmi_id(String)
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetPackage#getEObjectFacetRepresentation_Represented_element_xmi_id()
	 * @model required="true"
	 * @generated
	 */
	String getRepresented_element_xmi_id();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation#getRepresented_element_xmi_id <em>Represented element xmi id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented element xmi id</em>' attribute.
	 * @see #getRepresented_element_xmi_id()
	 * @generated
	 */
	void setRepresented_element_xmi_id(String value);

} // EObjectFacetRepresentation
