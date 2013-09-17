/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Setter Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry#getPropertySetters <em>Property Setters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry#getSetterMap <em>Setter Map</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getPropertySetterRegistry()
 * @model
 * @generated
 */
public interface PropertySetterRegistry extends EObject {
	/**
	 * Returns the value of the '<em><b>Property Setters</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.layers.stackmodel.layers.PropertySetter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Setters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Setters</em>' reference list.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getPropertySetterRegistry_PropertySetters()
	 * @model
	 * @generated
	 */
	EList<PropertySetter> getPropertySetters();

	/**
	 * Returns the value of the '<em><b>Setter Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.papyrus.layers.stackmodel.layers.PropertySetter},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setter Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setter Map</em>' map.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getPropertySetterRegistry_SetterMap()
	 * @model mapType="org.eclipse.papyrus.layers.stackmodel.layers.StringToPropertySetter<org.eclipse.papyrus.layers.stackmodel.layers.String, org.eclipse.papyrus.layers.stackmodel.layers.PropertySetter>" ordered="false"
	 * @generated
	 */
	EMap<String, PropertySetter> getSetterMap();

	/**
	 * Returns the value of the '<em><b>Application</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getPropertySetterRegistry <em>Property Setter Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' container reference.
	 * @see #setApplication(LayersStackApplication)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getPropertySetterRegistry_Application()
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getPropertySetterRegistry
	 * @model opposite="propertySetterRegistry" ordered="false"
	 * @generated
	 */
	LayersStackApplication getApplication();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry#getApplication <em>Application</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' container reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(LayersStackApplication value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.NotFoundException" propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	PropertySetter getPropertySetter(Property property) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.NotFoundException" propertyDataType="org.eclipse.papyrus.layers.stackmodel.layers.String" propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	PropertySetter getPropertySetter(String property) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model setterRequired="true" setterOrdered="false"
	 * @generated
	 */
	void addPropertySetter(PropertySetter setter);

} // PropertySetterRegistry
