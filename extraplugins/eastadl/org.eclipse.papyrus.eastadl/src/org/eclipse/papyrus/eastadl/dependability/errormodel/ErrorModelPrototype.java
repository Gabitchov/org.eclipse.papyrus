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
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Model Prototype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ErrorModelType and ErrorModelPrototype support the hierarchical composition of error models based on the type-prototype pattern also adopted for the nominal architecture composition. The purpose of the error models is to represent information relating to the anomalies of a nominal model element. 
 * 
 * The ErrorModelPrototype is used to define hierarchical error models allowing additional detail or structure to the error model of a particular target. A hierarchal structure can also be defined when several ErrorModels are integrated to a larger ErrorModel representing a system integrated from several targets. 
 * 
 * Typically the target is a system/subsystem, a function, a software component, or a hardware device.
 * 
 * 
 * Semantics:
 * An ErrorModelPrototype represents a unique compositional occurrence of the ErrorModelType that types it in the containing ErrorModelType.
 * 
 * Extension:
 * (See ADLFunctionPrototype)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getFunctionTarget <em>Function Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getHwTarget <em>Hw Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getFunctionTarget_path <em>Function Target path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getHwTarget_path <em>Hw Target path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelPrototype()
 * @model
 * @generated
 */
public interface ErrorModelPrototype extends EAElement {
	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelPrototype_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Returns the value of the '<em><b>Function Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelPrototype_FunctionTarget()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FunctionPrototype> getFunctionTarget();

	/**
	 * Returns the value of the '<em><b>Hw Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hw Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hw Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelPrototype_HwTarget()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HardwareComponentPrototype> getHwTarget();

	/**
	 * Returns the value of the '<em><b>Function Target path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Target path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Target path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelPrototype_FunctionTarget_path()
	 * @model
	 * @generated
	 */
	EList<FunctionPrototype> getFunctionTarget_path();

	/**
	 * Returns the value of the '<em><b>Hw Target path</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hw Target path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hw Target path</em>' containment reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelPrototype_HwTarget_path()
	 * @model containment="true"
	 * @generated
	 */
	EList<HardwareComponentPrototype> getHwTarget_path();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(NamedElement)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelPrototype_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getTarget();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {derived from UML::TypedElement::type}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getErrorModelPrototype_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	ErrorModelType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(NamedElement value);

} // ErrorModelPrototype
