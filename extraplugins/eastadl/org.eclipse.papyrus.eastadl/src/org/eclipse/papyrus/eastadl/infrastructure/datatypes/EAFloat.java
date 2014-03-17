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
package org.eclipse.papyrus.eastadl.infrastructure.datatypes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EA Float</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat#getMin <em>Min</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat#getMax <em>Max</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEAFloat()
 * @model
 * @generated
 */
public interface EAFloat extends RangeableDatatype {

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(Float)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEAFloat_Max()
	 * @model unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" ordered="false"
	 * @generated
	 */
	Float getMax();

	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(Float)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEAFloat_Min()
	 * @model unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" ordered="false"
	 * @generated
	 */
	Float getMin();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(Float value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(Float value);

} // EAFloat
