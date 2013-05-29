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
package org.eclipse.papyrus.eastadl.environment;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The collection of the environment functional description. This collection can be done across the EAST-ADL2 abstraction levels.
 * 
 * An environment model can contain functionPrototypes given by either AnalysisFunction or DesignFunction. The environment model does not have abstraction levels as in the system model (e.g., analysisLevel, designLevel).
 * 
 * A functionPrototype of the environment model can have interactions with FAA FunctionalDevice and an FDA HardwareFunction through the ClampConnector.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.environment.Environment#getEnvironmentModel <em>Environment Model</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.environment.Environment#getClampConnector <em>Clamp Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.environment.Environment#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.environment.Environment#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.environment.EnvironmentPackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends Context {
	/**
	 * Returns the value of the '<em><b>Clamp Connector</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.environment.ClampConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clamp Connector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clamp Connector</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.environment.EnvironmentPackage#getEnvironment_ClampConnector()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ClampConnector> getClampConnector();

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
	 * @see org.eclipse.papyrus.eastadl.environment.EnvironmentPackage#getEnvironment_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.environment.Environment#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.eastadl.environment.EnvironmentPackage#getEnvironment_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.environment.Environment#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Environment Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environment Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment Model</em>' reference.
	 * @see #setEnvironmentModel(FunctionPrototype)
	 * @see org.eclipse.papyrus.eastadl.environment.EnvironmentPackage#getEnvironment_EnvironmentModel()
	 * @model ordered="false"
	 * @generated
	 */
	FunctionPrototype getEnvironmentModel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.environment.Environment#getEnvironmentModel <em>Environment Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Environment Model</em>' reference.
	 * @see #getEnvironmentModel()
	 * @generated
	 */
	void setEnvironmentModel(FunctionPrototype value);

} // Environment
