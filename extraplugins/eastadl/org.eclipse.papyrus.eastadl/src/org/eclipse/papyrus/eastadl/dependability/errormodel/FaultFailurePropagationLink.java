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
package org.eclipse.papyrus.eastadl.dependability.errormodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.uml2.uml.Connector;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fault Failure Propagation Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The FaultFailurePropagationLink metaclass represents the links for the propagations of faults/failures across system elements. In particular, it defines that one error model provides the faults/failures that another error model receives.
 * 
 * A fault/failure link can only be applied to compatible ports, either for fault/failure delegation within an error model or for fault/failure transmission across two error models. A FaultFailurePropagationLink can only connect fault/failure ports that have compatible types. 
 * 
 * Constraints:
 * [1] Only compatible fromPort-toPort pairs may be connectedNo additional constraints
 * 
 * [2] Two fault/failure ports are compatible if the EADatatype of the fromPort represents a subset of the Fault/Failure set represented by the toPort’s EADatatype. 
 * 
 * 
 * Semantics:
 * The FaultFailurePropagationLink defines a Failure propagation path, from the fromPort on one error model to the toPort of another error model. 
 * 
 * 
 * Extension:
 * UML::Connector
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#isImmediatePropagation <em>Immediate Propagation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getToPort <em>To Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getFromPort <em>From Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getFromPort_path <em>From Port path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getToPort_path <em>To Port path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePropagationLink()
 * @model
 * @generated
 */
public interface FaultFailurePropagationLink extends EAElement {
	/**
	 * Returns the value of the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Connector</em>' reference.
	 * @see #setBase_Connector(Connector)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePropagationLink_Base_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getBase_Connector <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(Connector value);

	/**
	 * Returns the value of the '<em><b>From Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Port</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePropagationLink_FromPort()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FaultFailurePort getFromPort();

	/**
	 * Returns the value of the '<em><b>From Port path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Port path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Port path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePropagationLink_FromPort_path()
	 * @model
	 * @generated
	 */
	EList<ErrorModelPrototype> getFromPort_path();

	/**
	 * Returns the value of the '<em><b>To Port path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Port path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Port path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePropagationLink_ToPort_path()
	 * @model
	 * @generated
	 */
	EList<ErrorModelPrototype> getToPort_path();

	/**
	 * Returns the value of the '<em><b>To Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Port</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePropagationLink_ToPort()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FaultFailurePort getToPort();

	/**
	 * Returns the value of the '<em><b>Immediate Propagation</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Immediate Propagation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Immediate Propagation</em>' attribute.
	 * @see #setImmediatePropagation(boolean)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePropagationLink_ImmediatePropagation()
	 * @model default="true" unique="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isImmediatePropagation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#isImmediatePropagation <em>Immediate Propagation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immediate Propagation</em>' attribute.
	 * @see #isImmediatePropagation()
	 * @generated
	 */
	void setImmediatePropagation(boolean value);

} // FaultFailurePropagationLink
