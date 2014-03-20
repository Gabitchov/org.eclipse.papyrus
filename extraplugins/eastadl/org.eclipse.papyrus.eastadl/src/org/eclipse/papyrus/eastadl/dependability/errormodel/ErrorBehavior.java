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
import org.eclipse.uml2.uml.Behavior;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Behavior</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * ErrorBehavior represents the descriptions of failure logics or semantics that the target element identified by the ErrorModelType exhibits.
 * Typically the target is a system, a function, a software component, or a hardware device.
 * Each ErrorBehavior description relates the occurrences of internal faults and incoming external faults to failures. The faults and failures that
 * the errorBehavior propagated to and from the target element are declared through the ports of the error model.
 * 
 * Semantics:
 * ErrorBehavior defines the error propagation logic of its containing ErrorModelType.
 * The ErrorBehavior description represents the error propagations from internal faults or incoming faults to external failures. Faults are identified
 * by the internalFault and externalFault associations respectively. The propagated failures are identified by the externalFailure association.
 * The ErrorBehavior is defined in the failureLogic string, either directly or as a url referencing an external specification.
 * The failureLogic can be based on different formalisms, depending on the analysis techniques and tools available. This is indicated by its
 * type:ErrorBehaviorKind attribute. The failureLogic attribute contains the actual failure propagation logic.
 * 
 * Extension:
 * UML:Behavior
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getBase_Behavior <em>Base Behavior</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getFailureLogic <em>Failure Logic</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getInternalFault <em>Internal Fault</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getOwner <em>Owner</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getExternalFailure <em>External Failure</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getExternalFault <em>External Fault</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getProcessFault <em>Process Fault</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorBehavior()
 * @model
 * @generated
 */
public interface ErrorBehavior extends EAElement {

	/**
	 * Returns the value of the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Behavior</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Behavior</em>' reference.
	 * @see #setBase_Behavior(Behavior)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorBehavior_Base_Behavior()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Behavior getBase_Behavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getBase_Behavior <em>Base Behavior</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Behavior</em>' reference.
	 * @see #getBase_Behavior()
	 * @generated
	 */
	void setBase_Behavior(Behavior value);

	/**
	 * Returns the value of the '<em><b>External Failure</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FailureOutPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Failure</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>External Failure</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorBehavior_ExternalFailure()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<FailureOutPort> getExternalFailure();

	/**
	 * Returns the value of the '<em><b>External Fault</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultInPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Fault</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>External Fault</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorBehavior_ExternalFault()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FaultInPort> getExternalFault();

	/**
	 * Returns the value of the '<em><b>Failure Logic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The error logic description based on an external formalism or the path to the file or model entity containing the external error logic
	 * description.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Failure Logic</em>' attribute.
	 * @see #setFailureLogic(String)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorBehavior_FailureLogic()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getFailureLogic();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getFailureLogic <em>Failure Logic</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Failure Logic</em>' attribute.
	 * @see #getFailureLogic()
	 * @generated
	 */
	void setFailureLogic(String value);

	/**
	 * Returns the value of the '<em><b>Internal Fault</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The occurrences of internal faults.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Internal Fault</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorBehavior_InternalFault()
	 * @model ordered="false"
	 * @generated
	 */
	EList<InternalFaultPrototype> getInternalFault();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * It is bidirectional and its opposite is '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getErrorBehaviorDescription <em>Error Behavior Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(ErrorModelType)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorBehavior_Owner()
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getErrorBehaviorDescription
	 * @model opposite="errorBehaviorDescription" ordered="false"
	 * @generated
	 */
	ErrorModelType getOwner();

	/**
	 * Returns the value of the '<em><b>Process Fault</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Fault</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Process Fault</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorBehavior_ProcessFault()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ProcessFaultPrototype> getProcessFault();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of formalism applied for the error behavior description.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind
	 * @see #setType(ErrorBehaviorKind)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorBehavior_Type()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	ErrorBehaviorKind getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(ErrorModelType value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind
	 * @see #getType()
	 * @generated
	 */
	void setType(ErrorBehaviorKind value);

} // ErrorBehavior
