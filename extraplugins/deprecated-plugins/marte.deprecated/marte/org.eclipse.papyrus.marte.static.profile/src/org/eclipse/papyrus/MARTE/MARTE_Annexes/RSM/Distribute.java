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

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute#getPatternShape <em>Pattern Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute#getRepetitionSpace <em>Repetition Space</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute#getFromTiler <em>From Tiler</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute#getToTiler <em>To Tiler</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getDistribute()
 * @model
 * @generated
 */
public interface Distribute extends Allocate {
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
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getDistribute_PatternShape()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.RS_Library.ShapeSpecification" required="true" ordered="false"
	 * @generated
	 */
	String getPatternShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute#getPatternShape <em>Pattern Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Shape</em>' attribute.
	 * @see #getPatternShape()
	 * @generated
	 */
	void setPatternShape(String value);

	/**
	 * Returns the value of the '<em><b>Repetition Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repetition Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repetition Space</em>' attribute.
	 * @see #setRepetitionSpace(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getDistribute_RepetitionSpace()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.RS_Library.ShapeSpecification" required="true" ordered="false"
	 * @generated
	 */
	String getRepetitionSpace();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute#getRepetitionSpace <em>Repetition Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repetition Space</em>' attribute.
	 * @see #getRepetitionSpace()
	 * @generated
	 */
	void setRepetitionSpace(String value);

	/**
	 * Returns the value of the '<em><b>From Tiler</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Tiler</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Tiler</em>' attribute.
	 * @see #setFromTiler(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getDistribute_FromTiler()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.RS_Library.TilerSpecification" required="true" ordered="false"
	 * @generated
	 */
	String getFromTiler();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute#getFromTiler <em>From Tiler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Tiler</em>' attribute.
	 * @see #getFromTiler()
	 * @generated
	 */
	void setFromTiler(String value);

	/**
	 * Returns the value of the '<em><b>To Tiler</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Tiler</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Tiler</em>' attribute.
	 * @see #setToTiler(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getDistribute_ToTiler()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.RS_Library.TilerSpecification" required="true" ordered="false"
	 * @generated
	 */
	String getToTiler();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute#getToTiler <em>To Tiler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Tiler</em>' attribute.
	 * @see #getToTiler()
	 * @generated
	 */
	void setToTiler(String value);

} // Distribute
