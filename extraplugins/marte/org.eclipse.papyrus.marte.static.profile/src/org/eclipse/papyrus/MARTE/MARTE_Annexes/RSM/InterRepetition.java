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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inter Repetition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.InterRepetition#getRepetitionShapeDependence <em>Repetition Shape Dependence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.InterRepetition#isIsModulo <em>Is Modulo</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getInterRepetition()
 * @model
 * @generated
 */
public interface InterRepetition extends LinkTopology {
	/**
	 * Returns the value of the '<em><b>Repetition Shape Dependence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repetition Shape Dependence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repetition Shape Dependence</em>' attribute.
	 * @see #setRepetitionShapeDependence(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getInterRepetition_RepetitionShapeDependence()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.IntegerVector" required="true" ordered="false"
	 * @generated
	 */
	String getRepetitionShapeDependence();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.InterRepetition#getRepetitionShapeDependence <em>Repetition Shape Dependence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repetition Shape Dependence</em>' attribute.
	 * @see #getRepetitionShapeDependence()
	 * @generated
	 */
	void setRepetitionShapeDependence(String value);

	/**
	 * Returns the value of the '<em><b>Is Modulo</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Modulo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Modulo</em>' attribute.
	 * @see #setIsModulo(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getInterRepetition_IsModulo()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" ordered="false"
	 * @generated
	 */
	boolean isIsModulo();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.InterRepetition#isIsModulo <em>Is Modulo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Modulo</em>' attribute.
	 * @see #isIsModulo()
	 * @generated
	 */
	void setIsModulo(boolean value);

} // InterRepetition
