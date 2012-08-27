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
 * A representation of the model object '<em><b>Reshape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Reshape#getPatternShape <em>Pattern Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Reshape#getRepetitonShape <em>Repetiton Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getReshape()
 * @model
 * @generated
 */
public interface Reshape extends LinkTopology {
	/**
	 * Returns the value of the '<em><b>Pattern Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Shape</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Shape</em>' attribute.
	 * @see #setPatternShape(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getReshape_PatternShape()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.RS_Library.ShapeSpecification" required="true" ordered="false"
	 * @generated
	 */
	String getPatternShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Reshape#getPatternShape <em>Pattern Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Shape</em>' attribute.
	 * @see #getPatternShape()
	 * @generated
	 */
	void setPatternShape(String value);

	/**
	 * Returns the value of the '<em><b>Repetiton Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repetiton Shape</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repetiton Shape</em>' attribute.
	 * @see #setRepetitonShape(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getReshape_RepetitonShape()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.RS_Library.ShapeSpecification" required="true" ordered="false"
	 * @generated
	 */
	String getRepetitonShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Reshape#getRepetitonShape <em>Repetiton Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repetiton Shape</em>' attribute.
	 * @see #getRepetitonShape()
	 * @generated
	 */
	void setRepetitonShape(String value);

} // Reshape
