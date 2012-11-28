/**
 *  Copyright (c) 2012 CEA LIST.
 *  
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *    Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet;

import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype Property Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * the abstract type used to represent the properties of the stereotype
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement#getPropertyQualifiedName <em>Property Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement#isIsDerived <em>Is Derived</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#getStereotypePropertyElement()
 * @model abstract="true"
 * @generated
 */
public interface StereotypePropertyElement extends EObjectFacetRepresentation, FacetStructuralFeature {
	/**
	 * Returns the value of the '<em><b>Property Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * the name of the represented property of stereotype
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property Qualified Name</em>' attribute.
	 * @see #setPropertyQualifiedName(String)
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#getStereotypePropertyElement_PropertyQualifiedName()
	 * @model required="true"
	 * @generated
	 */
	String getPropertyQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement#getPropertyQualifiedName <em>Property Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Qualified Name</em>' attribute.
	 * @see #getPropertyQualifiedName()
	 * @generated
	 */
	void setPropertyQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * indicates if the property is Derived. This property will probably used by a customization on the header of the columns (to add a '/' to the name column). 
	 * We need it because if we have columns representing a stereotype property and if the concerning profile is not applied on the model, we won' be able to refind the real 
	 * property to know if this property is derived or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Derived</em>' attribute.
	 * @see #setIsDerived(boolean)
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#getStereotypePropertyElement_IsDerived()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsDerived();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement#isIsDerived <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Derived</em>' attribute.
	 * @see #isIsDerived()
	 * @generated
	 */
	void setIsDerived(boolean value);

} // StereotypePropertyElement
