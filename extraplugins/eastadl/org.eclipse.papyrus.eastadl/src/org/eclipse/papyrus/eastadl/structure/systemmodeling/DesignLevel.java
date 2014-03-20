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
package org.eclipse.papyrus.eastadl.structure.systemmodeling;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Design Level</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * DesignLevel represents the vehicle EE system on the design abstraction level. It includes primarily the Functional Design Architecture (FDA), and
 * the HardwareDesignArchitecture (HDA).
 * 
 * FDA represents a top level Function. It is supposed to implement all the functionalities of a vehicle, as specified by a Functional Analysis
 * Architecture or a Vehicle level (if no Functional Analysis Architecture has been defined during the process).
 * 
 * The design level in EAST-ADL2 includes the design architecture containing the functional specification and hardware architecture of the vehicle EE
 * system. The design architecture includes the Functional Design Architecture representing a decomposition of functionalities analyzed on the
 * analysis level. The decomposition has the purpose of making it possible to meet constraints regarding non-functional properties such as allocation,
 * efficiency, reuse, or supplier concerns. There is an n-to-m mapping between entities of the design- and the ones on the analysis level.
 * 
 * Non-transparent infrastructure functionality such as mode changes and error handling are also represented at the design level, such that their
 * impact on applications' behaviors can be estimated.
 * 
 * The Functional Design Architecture parts are typed by FunctionTypes and LocalDeviceManagers. The view of the HardwareArchitecture facilitates the
 * realization of LocalDeviceManager as sensor/actuator HW elements.
 * 
 * The HDA is the hardware design from a system perspective. The HDA has two purposes:
 * 
 * 1) It shows the physical entities and how they are connected.
 * 
 * 2) It is an allocation target for the Functions of the Functional Design Architecture.
 * 
 * The HDA represents the hardware architecture of the embedded system. Its contained HW elements represent the physical aspects of the hardware
 * entities and how they are connected. HardwareFunctionTypes associated to HW components represent the logical behavior of the contained HW elements.
 * 
 * Semantics:
 * The DesignLevel is the representation of the vehicle EE system on the design abstraction level. It corresponds to the design of logical functions
 * and boundaries extended in regards to resource commitment.
 * 
 * Notation:
 * The DesignLevel is shown as a solid-outline rectangle containing the name, with its ports or port groups on the perimeter. Contained entities may
 * be shown with its connectors (White-box view).
 * 
 * 
 * Extension: Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getFunctionalDesignArchitecture <em>Functional Design Architecture
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getHardwareDesignArchitecture <em>Hardware Design Architecture</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getAllocation <em>Allocation</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getDesignLevel()
 * @model
 * @generated
 */
public interface DesignLevel extends Context {

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
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getDesignLevel_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getBase_Class <em>Base Class</em>}' reference.
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
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getDesignLevel_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getBase_Package <em>Base Package</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Allocation</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Allocation</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getDesignLevel_Allocation()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Allocation> getAllocation();

	/**
	 * Returns the value of the '<em><b>Functional Design Architecture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Functional Design Architecture</em>' reference.
	 * @see #setFunctionalDesignArchitecture(DesignFunctionPrototype)
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getDesignLevel_FunctionalDesignArchitecture()
	 * @model ordered="false"
	 * @generated
	 */
	DesignFunctionPrototype getFunctionalDesignArchitecture();

	/**
	 * Returns the value of the '<em><b>Hardware Design Architecture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hardware Design Architecture</em>' containment reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hardware Design Architecture</em>' reference.
	 * @see #setHardwareDesignArchitecture(HardwareComponentPrototype)
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getDesignLevel_HardwareDesignArchitecture()
	 * @model ordered="false"
	 * @generated
	 */
	HardwareComponentPrototype getHardwareDesignArchitecture();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getFunctionalDesignArchitecture
	 * <em>Functional Design Architecture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Functional Design Architecture</em>' reference.
	 * @see #getFunctionalDesignArchitecture()
	 * @generated
	 */
	void setFunctionalDesignArchitecture(DesignFunctionPrototype value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getHardwareDesignArchitecture
	 * <em>Hardware Design Architecture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Hardware Design Architecture</em>' reference.
	 * @see #getHardwareDesignArchitecture()
	 * @generated
	 */
	void setHardwareDesignArchitecture(HardwareComponentPrototype value);

} // DesignLevel
