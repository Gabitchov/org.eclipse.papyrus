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
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Model Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ErrorModelType and ErrorModelPrototype support the hierarchical composition of error models based on the type-prototype pattern also adopted for the nominal architecture composition. The purpose of the error models is to represent information relating to the anomalies of a nominal model element. 
 * 
 * An ErrorModelType represents the internal faults and fault propagations of the nominal element that it targets. 
 * 
 * Typically the target is a system/subsystem, a function, a software component, or a hardware device.
 * 
 * ErrorModelType inherits the abstract metaclass TraceableSpecification, allowing the ErrorModelType to be referenced from its design context in a similar way as requirements, test cases and other specifications. 
 * 
 * Constraints:
 * An ErrorModelType without part shall have one errorBehaviorDescription
 * 
 * Semantics:
 * The ErrorModelType represents a specification of the faults and fault propagations of its target element. 
 * 
 * Both types and prototypes may be targets, and the following cases are relevant:
 * - One nominal type: 
 * The ErrorModelType represents the identified nominal type wherever this nominal type is instantiated. 
 * - Several nominal types: 
 * The ErrorModelType represents the identified nominal types individually, i.e. the same error model applies to all nominal types and is reused.
 * - One nominal prototype: 
 * The ErrorModelType represents the identified nominal prototype whenever its context, i.e. its top-level composition is instantiated. 
 * - Several nominal prototypes with instanceref: 
 * The ErrorModelType represents the identified set of nominal prototypes (together) whenever their context, i.e. their top-level composition is instantiated. 
 * 
 * The fault propagation of an errorModelType is defined by its contained parts, the ErrorModelPrototypes and their connections. In case it contains both parts and an errorBehaviorDescription, the errorBehaviorDescription shall be consistent with the parts.
 * FaultFailurePropagationLinks define valid propagation paths in the ErrorModelType. In case the contained FaultInPorts and FailureOutPorts reference nominal ports, the connectivity of the nominal model may serve as a pattern for connecting ports in the ErrorModelType. 
 * The ErrorModelType contains internalFaults and externalFaults, representing faults that are either propagated to externalFailures or masked, according to the definition of its fault propagation.
 * A processFault represents a flaw introduced during design, and may lead to any of the failures represented by the ErrorModelType. A processFault thus has a direct propagation to all externalFailures and cannot be masked. 
 * 
 * Extension:
 * (see ADLTraceableSpecfication)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getGenericDescription <em>Generic Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getFaultFailureConnector <em>Fault Failure Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getFailure <em>Failure</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getExternalFault <em>External Fault</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getInternalFault <em>Internal Fault</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getProcessFault <em>Process Fault</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getHwTarget <em>Hw Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getErrorBehaviorDescription <em>Error Behavior Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType()
 * @model
 * @generated
 */
public interface ErrorModelType extends TraceableSpecification {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Error Behavior Description</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Behavior Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Behavior Description</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_ErrorBehaviorDescription()
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getOwner
	 * @model opposite="owner" required="true" ordered="false"
	 * @generated
	 */
	EList<ErrorBehavior> getErrorBehaviorDescription();

	/**
	 * Returns the value of the '<em><b>External Fault</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultInPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Fault</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Fault</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_ExternalFault()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<FaultInPort> getExternalFault();

	/**
	 * Returns the value of the '<em><b>Failure</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FailureOutPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_Failure()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<FailureOutPort> getFailure();

	/**
	 * Returns the value of the '<em><b>Fault Failure Connector</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The links for the error propagations between subordinate error models.
	 * {derived from UML::StructuredClassifier::ownedConnector}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fault Failure Connector</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_FaultFailureConnector()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<FaultFailurePropagationLink> getFaultFailureConnector();

	/**
	 * Returns the value of the '<em><b>Generic Description</b></em>' attribute.
	 * The default value is <code>"NA"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generic Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generic Description</em>' attribute.
	 * @see #setGenericDescription(String)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_GenericDescription()
	 * @model default="NA" unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getGenericDescription();

	/**
	 * Returns the value of the '<em><b>Hw Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hw Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hw Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_HwTarget()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HardwareComponentType> getHwTarget();

	/**
	 * Returns the value of the '<em><b>Internal Fault</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Fault</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Fault</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_InternalFault()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<InternalFaultPrototype> getInternalFault();

	/**
	 * Returns the value of the '<em><b>Part</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {derived from UML::Classifier::attribute}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Part</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_Part()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<ErrorModelPrototype> getPart();

	/**
	 * Returns the value of the '<em><b>Process Fault</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Fault</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Fault</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_ProcessFault()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<ProcessFaultPrototype> getProcessFault();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelType_Target()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FunctionType> getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getGenericDescription <em>Generic Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generic Description</em>' attribute.
	 * @see #getGenericDescription()
	 * @generated
	 */
	void setGenericDescription(String value);

} // ErrorModelType
