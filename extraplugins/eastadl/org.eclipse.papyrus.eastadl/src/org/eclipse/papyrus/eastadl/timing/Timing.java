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
package org.eclipse.papyrus.eastadl.timing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Timing</b></em>'. <!--
 * end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The collection of timing constraints and their descriptions in the form of events and event chains. This collection can be done across the
 * EAST-ADL2 abstraction levels.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.Timing#getTimingConstraint <em>Timing Constraint</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.Timing#getTimingDescription <em>Timing Description</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.Timing#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.Timing#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTiming()
 * @model
 * @generated
 */
public interface Timing extends Context {

	/**
	 * Returns the value of the '<em><b>Timing Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.timing.TimingConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timing Constraint</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Timing Constraint</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTiming_TimingConstraint()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TimingConstraint> getTimingConstraint();

	/**
	 * Returns the value of the '<em><b>Timing Description</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.timing.TimingDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timing Description</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Timing Description</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTiming_TimingDescription()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TimingDescription> getTimingDescription();

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
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTiming_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.Timing#getBase_Class <em>Base Class</em>}' reference.
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
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTiming_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.Timing#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // Timing
