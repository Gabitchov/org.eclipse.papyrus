/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Configuration specific to element types registered to manipulate graphical elements in GMF diagrams
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration#getSpecializedDiagramTypeID <em>Specialized Diagram Type ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getViewTypeConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface ViewTypeConfiguration extends ElementTypeConfiguration {

	/**
	 * Returns the value of the '<em><b>Specialized Diagram Type ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialized Diagram Type ID</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Specialized Diagram Type ID</em>' attribute.
	 * @see #setSpecializedDiagramTypeID(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getViewTypeConfiguration_SpecializedDiagramTypeID()
	 * @model
	 * @generated
	 */
	String getSpecializedDiagramTypeID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration#getSpecializedDiagramTypeID
	 * <em>Specialized Diagram Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Specialized Diagram Type ID</em>' attribute.
	 * @see #getSpecializedDiagramTypeID()
	 * @generated
	 */
	void setSpecializedDiagramTypeID(String value);
} // ViewTypeConfiguration
