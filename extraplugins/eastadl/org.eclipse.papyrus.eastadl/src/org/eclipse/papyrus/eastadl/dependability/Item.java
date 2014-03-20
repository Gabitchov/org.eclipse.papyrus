/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.dependability;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The Item entity identifies the scope of safety information and the safety assessment, i.e. the part of the system onto which the ISO26262 related
 * information applies. Safety analyses are carried out on the basis of an item definition and the safety concepts are derived from it.
 * 
 * Semantics:
 * Item represents the scope of safety information and the safety assessment trough its reference to one or several Features.
 * 
 * Extension:
 * UML::Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Item#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Item#getDevelopmentCategory <em>Development Category</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Item#getVehicleFeature <em>Vehicle Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getItem()
 * @model
 * @generated
 */
public interface Item extends EAElement {

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getItem_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.Item#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Development Category</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * It shall be determined whether the item is a modification of an existing item or if it is a new development.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Development Category</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind
	 * @see #setDevelopmentCategory(DevelopmentCategoryKind)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getItem_DevelopmentCategory()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	DevelopmentCategoryKind getDevelopmentCategory();

	/**
	 * Returns the value of the '<em><b>Vehicle Feature</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicle Feature</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Vehicle Feature</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getItem_VehicleFeature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<VehicleFeature> getVehicleFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.Item#getDevelopmentCategory <em>Development Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Development Category</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind
	 * @see #getDevelopmentCategory()
	 * @generated
	 */
	void setDevelopmentCategory(DevelopmentCategoryKind value);

} // Item
