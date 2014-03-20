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
package org.eclipse.papyrus.eastadl.variability;

import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime;
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Element</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * VariableElement is a marker class that marks an artifact element denoted by association optionalElement as being optional, i.e. it will not be
 * present in all configurations of the complete system. A typical example is an optional FunctionPrototype.
 * 
 * In addition, the VariableElement can be used to extend the EAST-ADL2 variability approach to other languages and standards by pointing from the
 * VariableElement to the respective (non EAST-ADL2) element with association optionalElement, by that marking the non EAST-ADL2 element as optional
 * and providing configuration support within its containing ConfigurableContainer.
 * 
 * Refer to the documentation of meta-class ConfigurableContainer for a detailed explanation of how ConfigurableContainer and VariableElement play
 * together.
 * 
 * 
 * Constraints:
 * [1] Identifies either one FunctionPrototype or one FunctionPort or one FunctionConnector or one HardwareComponentPrototype or one HardwarePort or
 * one ClampConnector.
 * 
 * Semantics:
 * Marks the element identified by association optionalElement as optional.
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getRequiredBindingTime <em>Required Binding Time</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getActualBindingTime <em>Actual Binding Time</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getReuseMetaInformation <em>Reuse Meta Information</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getOptionalElement <em>Optional Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariableElement()
 * @model
 * @generated
 */
public interface VariableElement extends EAElement {

	/**
	 * Returns the value of the '<em><b>Actual Binding Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Actual Binding Time</em>' reference.
	 * @see #setActualBindingTime(BindingTime)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariableElement_ActualBindingTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BindingTime getActualBindingTime();

	/**
	 * Returns the value of the '<em><b>Optional Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Element</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Optional Element</em>' reference.
	 * @see #setOptionalElement(NamedElement)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariableElement_OptionalElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getOptionalElement();

	/**
	 * Returns the value of the '<em><b>Required Binding Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Binding Time</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Required Binding Time</em>' reference.
	 * @see #setRequiredBindingTime(BindingTime)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariableElement_RequiredBindingTime()
	 * @model ordered="false"
	 * @generated
	 */
	BindingTime getRequiredBindingTime();

	/**
	 * Returns the value of the '<em><b>Reuse Meta Information</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reuse Meta Information</em>' reference.
	 * @see #setReuseMetaInformation(ReuseMetaInformation)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariableElement_ReuseMetaInformation()
	 * @model ordered="false"
	 * @generated
	 */
	ReuseMetaInformation getReuseMetaInformation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getActualBindingTime <em>Actual Binding Time</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Actual Binding Time</em>' reference.
	 * @see #getActualBindingTime()
	 * @generated
	 */
	void setActualBindingTime(BindingTime value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getOptionalElement <em>Optional Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Optional Element</em>' reference.
	 * @see #getOptionalElement()
	 * @generated
	 */
	void setOptionalElement(NamedElement value);

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
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariableElement_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getBase_Class <em>Base Class</em>}' reference.
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
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getRequiredBindingTime <em>Required Binding Time</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Required Binding Time</em>' reference.
	 * @see #getRequiredBindingTime()
	 * @generated
	 */
	void setRequiredBindingTime(BindingTime value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getReuseMetaInformation <em>Reuse Meta Information</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Reuse Meta Information</em>' reference.
	 * @see #getReuseMetaInformation()
	 * @generated
	 */
	void setReuseMetaInformation(ReuseMetaInformation value);

} // VariableElement
