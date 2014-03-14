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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The Environment model is used to describe the environment of the vehicle electric and electronic architecture. It is modeled by continuous
 * functions representing the system environment.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.environment.EnvironmentFactory
 * @model kind="package"
 * @generated
 */
public interface EnvironmentPackage extends EPackage {

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.environment.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.environment.impl.EnvironmentImpl
		 * @see org.eclipse.papyrus.eastadl.environment.impl.EnvironmentPackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '<em><b>Environment Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENVIRONMENT__ENVIRONMENT_MODEL = eINSTANCE.getEnvironment_EnvironmentModel();

		/**
		 * The meta object literal for the '<em><b>Clamp Connector</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENVIRONMENT__CLAMP_CONNECTOR = eINSTANCE.getEnvironment_ClampConnector();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENVIRONMENT__BASE_CLASS = eINSTANCE.getEnvironment_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENVIRONMENT__BASE_PACKAGE = eINSTANCE.getEnvironment_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.environment.impl.ClampConnectorImpl <em>Clamp Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.environment.impl.ClampConnectorImpl
		 * @see org.eclipse.papyrus.eastadl.environment.impl.EnvironmentPackageImpl#getClampConnector()
		 * @generated
		 */
		EClass CLAMP_CONNECTOR = eINSTANCE.getClampConnector();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CLAMP_CONNECTOR__PORT = eINSTANCE.getClampConnector_Port();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CLAMP_CONNECTOR__BASE_CONNECTOR = eINSTANCE.getClampConnector_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>Port1 path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CLAMP_CONNECTOR__PORT1_PATH = eINSTANCE.getClampConnector_Port1_path();

		/**
		 * The meta object literal for the '<em><b>Port2 path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CLAMP_CONNECTOR__PORT2_PATH = eINSTANCE.getClampConnector_Port2_path();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "environment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Environment/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Environment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	EnvironmentPackage eINSTANCE = org.eclipse.papyrus.eastadl.environment.impl.EnvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.environment.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.environment.impl.EnvironmentImpl
	 * @see org.eclipse.papyrus.eastadl.environment.impl.EnvironmentPackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Environment Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__ENVIRONMENT_MODEL = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Clamp Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__CLAMP_CONNECTOR = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.environment.impl.ClampConnectorImpl <em>Clamp Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.environment.impl.ClampConnectorImpl
	 * @see org.eclipse.papyrus.eastadl.environment.impl.EnvironmentPackageImpl#getClampConnector()
	 * @generated
	 */
	int CLAMP_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLAMP_CONNECTOR__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLAMP_CONNECTOR__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLAMP_CONNECTOR__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLAMP_CONNECTOR__PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLAMP_CONNECTOR__BASE_CONNECTOR = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port1 path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLAMP_CONNECTOR__PORT1_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port2 path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLAMP_CONNECTOR__PORT2_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Clamp Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLAMP_CONNECTOR_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.environment.ClampConnector <em>Clamp Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Clamp Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.ClampConnector
	 * @generated
	 */
	EClass getClampConnector();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.environment.ClampConnector#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.ClampConnector#getPort()
	 * @see #getClampConnector()
	 * @generated
	 */
	EReference getClampConnector_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.environment.ClampConnector#getBase_Connector
	 * <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.ClampConnector#getBase_Connector()
	 * @see #getClampConnector()
	 * @generated
	 */
	EReference getClampConnector_Base_Connector();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.environment.ClampConnector#getPort1_path
	 * <em>Port1 path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port1 path</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.ClampConnector#getPort1_path()
	 * @see #getClampConnector()
	 * @generated
	 */
	EReference getClampConnector_Port1_path();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.environment.ClampConnector#getPort2_path
	 * <em>Port2 path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port2 path</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.ClampConnector#getPort2_path()
	 * @see #getClampConnector()
	 * @generated
	 */
	EReference getClampConnector_Port2_path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.environment.Environment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.Environment
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.environment.Environment#getClampConnector
	 * <em>Clamp Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Clamp Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.Environment#getClampConnector()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_ClampConnector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.environment.Environment#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.Environment#getBase_Class()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.environment.Environment#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.Environment#getBase_Package()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Base_Package();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.environment.Environment#getEnvironmentModel
	 * <em>Environment Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Environment Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.environment.Environment#getEnvironmentModel()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_EnvironmentModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnvironmentFactory getEnvironmentFactory();

} //EnvironmentPackage
