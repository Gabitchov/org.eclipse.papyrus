/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Property Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator#getOperatorInstance <em>Operator Instance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator#getClassBundleID <em>Class Bundle ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getCustomPropertyOperator()
 * @model
 * @generated
 */
public interface CustomPropertyOperator extends PropertyOperator {
	/**
	 * Returns the value of the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classname</em>' attribute.
	 * @see #setClassname(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getCustomPropertyOperator_Classname()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getClassname();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator#getClassname <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classname</em>' attribute.
	 * @see #getClassname()
	 * @generated
	 */
	void setClassname(String value);

	/**
	 * Returns the value of the '<em><b>Operator Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Instance</em>' attribute.
	 * @see #setOperatorInstance(CustomPropertyOperatorsInstance)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getCustomPropertyOperator_OperatorInstance()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOpertorInstance" required="true" ordered="false"
	 * @generated
	 */
	CustomPropertyOperatorsInstance getOperatorInstance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator#getOperatorInstance <em>Operator Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Instance</em>' attribute.
	 * @see #getOperatorInstance()
	 * @generated
	 */
	void setOperatorInstance(CustomPropertyOperatorsInstance value);

	/**
	 * Returns the value of the '<em><b>Class Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Bundle ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Bundle ID</em>' attribute.
	 * @see #setClassBundleID(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getCustomPropertyOperator_ClassBundleID()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getClassBundleID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator#getClassBundleID <em>Class Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Bundle ID</em>' attribute.
	 * @see #getClassBundleID()
	 * @generated
	 */
	void setClassBundleID(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException"
	 * @generated
	 */
	void resetOperatorInstance() throws LayersException;

} // CustomPropertyOperator
