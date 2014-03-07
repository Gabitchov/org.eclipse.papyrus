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
package org.eclipse.papyrus.eastadl.genericconstraints;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Take Rate Constraint</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint#getSource <em>Source</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint#getTakeRate <em>Take Rate</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getTakeRateConstraint()
 * @model
 * @generated
 */
public interface TakeRateConstraint extends GenericConstraint {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getTakeRateConstraint_Source()
	 * @model ordered="false"
	 * @generated
	 */
	EList<NamedElement> getSource();

	/**
	 * Returns the value of the '<em><b>Take Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Take Rate</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Take Rate</em>' attribute.
	 * @see #setTakeRate(Float)
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getTakeRateConstraint_TakeRate()
	 * @model unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" required="true" ordered="false"
	 * @generated
	 */
	Float getTakeRate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint#getTakeRate <em>Take Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Take Rate</em>' attribute.
	 * @see #getTakeRate()
	 * @generated
	 */
	void setTakeRate(Float value);

} // TakeRateConstraint
