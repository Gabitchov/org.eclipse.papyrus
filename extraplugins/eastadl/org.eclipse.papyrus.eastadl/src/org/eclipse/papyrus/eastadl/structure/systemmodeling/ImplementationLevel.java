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

import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation Level</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * ImplementationLevel represents the software architecture and components, and the hardware architecture of the EE system in the vehicle. The
 * ImplementationLevel is defined by the AUTOSAR System- and SoftwareArchitecture. For example, functions of the Functional Design Architecture will
 * be realized by AUTOSAR SW-Components in the ImplementationLevel. Traceability is supported from implementation level elements (AUTOSAR) to upper
 * level elements by Realization relationships.
 * 
 * 
 * Extension: Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getAutosarSystem <em>Autosar System</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getImplementationLevel()
 * @model
 * @generated
 */
public interface ImplementationLevel extends Context {

	/**
	 * Returns the value of the '<em><b>Autosar System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Autosar System</em>' reference.
	 * @see #setAutosarSystem(NamedElement)
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getImplementationLevel_AutosarSystem()
	 * @model ordered="false"
	 * @generated
	 */
	NamedElement getAutosarSystem();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getAutosarSystem
	 * <em>Autosar System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Autosar System</em>' reference.
	 * @see #getAutosarSystem()
	 * @generated
	 */
	void setAutosarSystem(NamedElement value);

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
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getImplementationLevel_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getBase_Class <em>Base Class</em>}'
	 * reference.
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
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getImplementationLevel_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getBase_Package <em>Base Package</em>}'
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

} // ImplementationLevel
