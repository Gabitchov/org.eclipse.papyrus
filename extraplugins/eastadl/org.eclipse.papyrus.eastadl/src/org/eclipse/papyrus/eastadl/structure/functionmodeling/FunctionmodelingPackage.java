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
package org.eclipse.papyrus.eastadl.structure.functionmodeling;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;


/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc --> The function modeling is performed on the FAA and
 * FDA levels, modeled as AnalysisArchitecture and DesignArchitecture. The compositional hierarchy
 * of these abstraction layers starts with FunctionalAnalysisArchitecture and
 * FunctionalDesignArchitecture respectively. The FAA is modeled with FunctionalDevices and the FDA
 * is modeled with LocalDeviceManagers. The purpose of the metaclasses in the FunctionModeling
 * domain metamodel package is to specify rigorously ("formally") the FunctionModeling concepts for
 * the specific domain. This section contains a specification for each individual metaclass in the
 * FunctionModeling package.
 * 
 * Overview: Essentially the modeling is done via a set of interconnected functions which may be
 * composed hierarchically. Thus the core elements are ADLFunctionType and ADLFunctionPrototype. The
 * latter represents the local use of an instance of the former. Functions are connected through
 * ADLConnectorPrototypes and ADLPorts. <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingFactory
 * @model kind="package"
 * @generated
 */
public interface FunctionmodelingPackage extends EPackage {

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl
		 * <em>Function Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionType()
		 * @generated
		 */
		EClass FUNCTION_TYPE = eINSTANCE.getFunctionType();

		/**
		 * The meta object literal for the '<em><b>Is Elementary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FUNCTION_TYPE__IS_ELEMENTARY = eINSTANCE.getFunctionType_IsElementary();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_TYPE__PORT = eINSTANCE.getFunctionType_Port();

		/**
		 * The meta object literal for the '<em><b>Port Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_TYPE__PORT_GROUP = eINSTANCE.getFunctionType_PortGroup();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_TYPE__CONNECTOR = eINSTANCE.getFunctionType_Connector();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPortImpl
		 * <em>Function Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPortImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionPort()
		 * @generated
		 */
		EClass FUNCTION_PORT = eINSTANCE.getFunctionPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionConnectorImpl
		 * <em>Function Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionConnectorImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionConnector()
		 * @generated
		 */
		EClass FUNCTION_CONNECTOR = eINSTANCE.getFunctionConnector();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_CONNECTOR__PORT = eINSTANCE.getFunctionConnector_Port();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_CONNECTOR__BASE_CONNECTOR = eINSTANCE.getFunctionConnector_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>Port1 path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_CONNECTOR__PORT1_PATH = eINSTANCE.getFunctionConnector_Port1_path();

		/**
		 * The meta object literal for the '<em><b>Port2 path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_CONNECTOR__PORT2_PATH = eINSTANCE.getFunctionConnector_Port2_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AnalysisFunctionPrototypeImpl
		 * <em>Analysis Function Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AnalysisFunctionPrototypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getAnalysisFunctionPrototype()
		 * @generated
		 */
		EClass ANALYSIS_FUNCTION_PROTOTYPE = eINSTANCE.getAnalysisFunctionPrototype();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANALYSIS_FUNCTION_PROTOTYPE__TYPE = eINSTANCE.getAnalysisFunctionPrototype_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionFlowPortImpl
		 * <em>Function Flow Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionFlowPortImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionFlowPort()
		 * @generated
		 */
		EClass FUNCTION_FLOW_PORT = eINSTANCE.getFunctionFlowPort();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_FLOW_PORT__TYPE = eINSTANCE.getFunctionFlowPort_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionClientServerPortImpl
		 * <em>Function Client Server Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionClientServerPortImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionClientServerPort()
		 * @generated
		 */
		EClass FUNCTION_CLIENT_SERVER_PORT = eINSTANCE.getFunctionClientServerPort();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_CLIENT_SERVER_PORT__TYPE = eINSTANCE.getFunctionClientServerPort_Type();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_CLIENT_SERVER_PORT__BASE_PORT = eINSTANCE.getFunctionClientServerPort_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Client Server Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FUNCTION_CLIENT_SERVER_PORT__CLIENT_SERVER_TYPE = eINSTANCE.getFunctionClientServerPort_ClientServerType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionClientServerInterfaceImpl
		 * <em>Function Client Server Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionClientServerInterfaceImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionClientServerInterface()
		 * @generated
		 */
		EClass FUNCTION_CLIENT_SERVER_INTERFACE = eINSTANCE.getFunctionClientServerInterface();

		/**
		 * The meta object literal for the '<em><b>Base Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_CLIENT_SERVER_INTERFACE__BASE_INTERFACE = eINSTANCE.getFunctionClientServerInterface_Base_Interface();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_CLIENT_SERVER_INTERFACE__OPERATION = eINSTANCE.getFunctionClientServerInterface_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.OperationImpl <em>Operation</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.OperationImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION__BASE_OPERATION = eINSTANCE.getOperation_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION__ARGUMENT = eINSTANCE.getOperation_Argument();

		/**
		 * The meta object literal for the '<em><b>Return</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION__RETURN = eINSTANCE.getOperation_Return();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.PortGroupImpl <em>Port Group</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.PortGroupImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getPortGroup()
		 * @generated
		 */
		EClass PORT_GROUP = eINSTANCE.getPortGroup();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PORT_GROUP__PORT = eINSTANCE.getPortGroup_Port();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PORT_GROUP__BASE_CLASS = eINSTANCE.getPortGroup_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PORT_GROUP__BASE_PORT = eINSTANCE.getPortGroup_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Port Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PORT_GROUP__PORT_GROUP = eINSTANCE.getPortGroup_PortGroup();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.BasicSoftwareFunctionTypeImpl
		 * <em>Basic Software Function Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.BasicSoftwareFunctionTypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getBasicSoftwareFunctionType()
		 * @generated
		 */
		EClass BASIC_SOFTWARE_FUNCTION_TYPE = eINSTANCE.getBasicSoftwareFunctionType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.HardwareFunctionTypeImpl
		 * <em>Hardware Function Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.HardwareFunctionTypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getHardwareFunctionType()
		 * @generated
		 */
		EClass HARDWARE_FUNCTION_TYPE = eINSTANCE.getHardwareFunctionType();

		/**
		 * The meta object literal for the '<em><b>Hardware Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_FUNCTION_TYPE__HARDWARE_COMPONENT = eINSTANCE.getHardwareFunctionType_HardwareComponent();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionAllocationImpl
		 * <em>Function Allocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionAllocationImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionAllocation()
		 * @generated
		 */
		EClass FUNCTION_ALLOCATION = eINSTANCE.getFunctionAllocation();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_ALLOCATION__TARGET = eINSTANCE.getFunctionAllocation_Target();

		/**
		 * The meta object literal for the '<em><b>Allocated Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_ALLOCATION__ALLOCATED_ELEMENT = eINSTANCE.getFunctionAllocation_AllocatedElement();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_ALLOCATION__BASE_DEPENDENCY = eINSTANCE.getFunctionAllocation_Base_Dependency();

		/**
		 * The meta object literal for the '<em><b>Allocated Element path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_ALLOCATION__ALLOCATED_ELEMENT_PATH = eINSTANCE.getFunctionAllocation_AllocatedElement_path();

		/**
		 * The meta object literal for the '<em><b>Target path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_ALLOCATION__TARGET_PATH = eINSTANCE.getFunctionAllocation_Target_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AllocationImpl <em>Allocation</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AllocationImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getAllocation()
		 * @generated
		 */
		EClass ALLOCATION = eINSTANCE.getAllocation();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALLOCATION__BASE_CLASS = eINSTANCE.getAllocation_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALLOCATION__BASE_PACKAGE = eINSTANCE.getAllocation_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Function Allocation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALLOCATION__FUNCTION_ALLOCATION = eINSTANCE.getAllocation_FunctionAllocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPowerPortImpl
		 * <em>Function Power Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPowerPortImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionPowerPort()
		 * @generated
		 */
		EClass FUNCTION_POWER_PORT = eINSTANCE.getFunctionPowerPort();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_POWER_PORT__BASE_PORT = eINSTANCE.getFunctionPowerPort_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_POWER_PORT__TYPE = eINSTANCE.getFunctionPowerPort_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind <em>EA Direction Kind</em>}'
		 * enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getEADirectionKind()
		 * @generated
		 */
		EEnum EA_DIRECTION_KIND = eINSTANCE.getEADirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind
		 * <em>Client Server Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getClientServerKind()
		 * @generated
		 */
		EEnum CLIENT_SERVER_KIND = eINSTANCE.getClientServerKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPrototypeImpl
		 * <em>Function Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPrototypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionPrototype()
		 * @generated
		 */
		EClass FUNCTION_PROTOTYPE = eINSTANCE.getFunctionPrototype();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION_PROTOTYPE__BASE_PROPERTY = eINSTANCE.getFunctionPrototype_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AllocateableElementImpl
		 * <em>Allocateable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AllocateableElementImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getAllocateableElement()
		 * @generated
		 */
		EClass ALLOCATEABLE_ELEMENT = eINSTANCE.getAllocateableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.LocalDeviceManagerImpl
		 * <em>Local Device Manager</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.LocalDeviceManagerImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getLocalDeviceManager()
		 * @generated
		 */
		EClass LOCAL_DEVICE_MANAGER = eINSTANCE.getLocalDeviceManager();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.DesignFunctionTypeImpl
		 * <em>Design Function Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.DesignFunctionTypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getDesignFunctionType()
		 * @generated
		 */
		EClass DESIGN_FUNCTION_TYPE = eINSTANCE.getDesignFunctionType();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DESIGN_FUNCTION_TYPE__PART = eINSTANCE.getDesignFunctionType_Part();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.DesignFunctionPrototypeImpl
		 * <em>Design Function Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.DesignFunctionPrototypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getDesignFunctionPrototype()
		 * @generated
		 */
		EClass DESIGN_FUNCTION_PROTOTYPE = eINSTANCE.getDesignFunctionPrototype();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DESIGN_FUNCTION_PROTOTYPE__TYPE = eINSTANCE.getDesignFunctionPrototype_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionalDeviceImpl
		 * <em>Functional Device</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionalDeviceImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionalDevice()
		 * @generated
		 */
		EClass FUNCTIONAL_DEVICE = eINSTANCE.getFunctionalDevice();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AnalysisFunctionTypeImpl
		 * <em>Analysis Function Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AnalysisFunctionTypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getAnalysisFunctionType()
		 * @generated
		 */
		EClass ANALYSIS_FUNCTION_TYPE = eINSTANCE.getAnalysisFunctionType();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANALYSIS_FUNCTION_TYPE__PART = eINSTANCE.getAnalysisFunctionType_Part();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "functionmodeling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Structure/FunctionModeling/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "FunctionModeling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	FunctionmodelingPackage eINSTANCE = org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.DesignFunctionTypeImpl
	 * <em>Design Function Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.DesignFunctionTypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getDesignFunctionType()
	 * @generated
	 */
	int DESIGN_FUNCTION_TYPE = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl <em>Function Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionType()
	 * @generated
	 */
	int FUNCTION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionConnectorImpl
	 * <em>Function Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionConnectorImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionConnector()
	 * @generated
	 */
	int FUNCTION_CONNECTOR = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionFlowPortImpl
	 * <em>Function Flow Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionFlowPortImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionFlowPort()
	 * @generated
	 */
	int FUNCTION_FLOW_PORT = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionClientServerPortImpl
	 * <em>Function Client Server Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionClientServerPortImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionClientServerPort()
	 * @generated
	 */
	int FUNCTION_CLIENT_SERVER_PORT = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionClientServerInterfaceImpl
	 * <em>Function Client Server Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionClientServerInterfaceImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionClientServerInterface()
	 * @generated
	 */
	int FUNCTION_CLIENT_SERVER_INTERFACE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.PortGroupImpl <em>Port Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.PortGroupImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getPortGroup()
	 * @generated
	 */
	int PORT_GROUP = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.LocalDeviceManagerImpl
	 * <em>Local Device Manager</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.LocalDeviceManagerImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getLocalDeviceManager()
	 * @generated
	 */
	int LOCAL_DEVICE_MANAGER = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionalDeviceImpl <em>Functional Device</em>}
	 * ' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionalDeviceImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionalDevice()
	 * @generated
	 */
	int FUNCTIONAL_DEVICE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AnalysisFunctionTypeImpl
	 * <em>Analysis Function Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AnalysisFunctionTypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getAnalysisFunctionType()
	 * @generated
	 */
	int ANALYSIS_FUNCTION_TYPE = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AnalysisFunctionPrototypeImpl
	 * <em>Analysis Function Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AnalysisFunctionPrototypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getAnalysisFunctionPrototype()
	 * @generated
	 */
	int ANALYSIS_FUNCTION_PROTOTYPE = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPrototypeImpl
	 * <em>Function Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPrototypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionPrototype()
	 * @generated
	 */
	int FUNCTION_PROTOTYPE = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.OperationImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.DesignFunctionPrototypeImpl
	 * <em>Design Function Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.DesignFunctionPrototypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getDesignFunctionPrototype()
	 * @generated
	 */
	int DESIGN_FUNCTION_PROTOTYPE = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AllocateableElementImpl
	 * <em>Allocateable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AllocateableElementImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getAllocateableElement()
	 * @generated
	 */
	int ALLOCATEABLE_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__IS_ENCAPSULATED = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Elementary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__IS_ELEMENTARY = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__PORT = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__PORT_GROUP = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE__CONNECTOR = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Function Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__NAME = FUNCTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__BASE_NAMED_ELEMENT = FUNCTION_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__OWNED_COMMENT = FUNCTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__TRACEABLE_SPECIFICATION = FUNCTION_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__OWNED_RELATIONSHIP = FUNCTION_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__IS_ENCAPSULATED = FUNCTION_TYPE__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__BASE_CLASS = FUNCTION_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is Elementary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__IS_ELEMENTARY = FUNCTION_TYPE__IS_ELEMENTARY;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__PORT = FUNCTION_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__PORT_GROUP = FUNCTION_TYPE__PORT_GROUP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__CONNECTOR = FUNCTION_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE__PART = FUNCTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Design Function Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_TYPE_FEATURE_COUNT = FUNCTION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__NAME = DESIGN_FUNCTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__BASE_NAMED_ELEMENT = DESIGN_FUNCTION_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__OWNED_COMMENT = DESIGN_FUNCTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__TRACEABLE_SPECIFICATION = DESIGN_FUNCTION_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__OWNED_RELATIONSHIP = DESIGN_FUNCTION_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__IS_ENCAPSULATED = DESIGN_FUNCTION_TYPE__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__BASE_CLASS = DESIGN_FUNCTION_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is Elementary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__IS_ELEMENTARY = DESIGN_FUNCTION_TYPE__IS_ELEMENTARY;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__PORT = DESIGN_FUNCTION_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__PORT_GROUP = DESIGN_FUNCTION_TYPE__PORT_GROUP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__CONNECTOR = DESIGN_FUNCTION_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER__PART = DESIGN_FUNCTION_TYPE__PART;

	/**
	 * The number of structural features of the '<em>Local Device Manager</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCAL_DEVICE_MANAGER_FEATURE_COUNT = DESIGN_FUNCTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPortImpl <em>Function Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPortImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionPort()
	 * @generated
	 */
	int FUNCTION_PORT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PORT__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PORT__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PORT__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Function Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PORT_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_GROUP__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_GROUP__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_GROUP__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_GROUP__PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_GROUP__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_GROUP__BASE_PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_GROUP__PORT_GROUP = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Port Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_GROUP_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CONNECTOR__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CONNECTOR__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CONNECTOR__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CONNECTOR__PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CONNECTOR__BASE_CONNECTOR = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port1 path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CONNECTOR__PORT1_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port2 path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CONNECTOR__PORT2_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Function Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CONNECTOR_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Allocateable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATEABLE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PROTOTYPE__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PROTOTYPE__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PROTOTYPE__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PROTOTYPE__BASE_PROPERTY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PROTOTYPE_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_PROTOTYPE__NAME = FUNCTION_PROTOTYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_PROTOTYPE__BASE_NAMED_ELEMENT = FUNCTION_PROTOTYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_PROTOTYPE__OWNED_COMMENT = FUNCTION_PROTOTYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_PROTOTYPE__BASE_PROPERTY = FUNCTION_PROTOTYPE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_PROTOTYPE__TYPE = FUNCTION_PROTOTYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Design Function Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_FUNCTION_PROTOTYPE_FEATURE_COUNT = FUNCTION_PROTOTYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__NAME = FUNCTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__BASE_NAMED_ELEMENT = FUNCTION_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__OWNED_COMMENT = FUNCTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__TRACEABLE_SPECIFICATION = FUNCTION_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__OWNED_RELATIONSHIP = FUNCTION_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__IS_ENCAPSULATED = FUNCTION_TYPE__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__BASE_CLASS = FUNCTION_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is Elementary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__IS_ELEMENTARY = FUNCTION_TYPE__IS_ELEMENTARY;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__PORT = FUNCTION_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__PORT_GROUP = FUNCTION_TYPE__PORT_GROUP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__CONNECTOR = FUNCTION_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE__PART = FUNCTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Analysis Function Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_TYPE_FEATURE_COUNT = FUNCTION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__NAME = ANALYSIS_FUNCTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__BASE_NAMED_ELEMENT = ANALYSIS_FUNCTION_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__OWNED_COMMENT = ANALYSIS_FUNCTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__TRACEABLE_SPECIFICATION = ANALYSIS_FUNCTION_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__OWNED_RELATIONSHIP = ANALYSIS_FUNCTION_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__IS_ENCAPSULATED = ANALYSIS_FUNCTION_TYPE__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__BASE_CLASS = ANALYSIS_FUNCTION_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is Elementary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__IS_ELEMENTARY = ANALYSIS_FUNCTION_TYPE__IS_ELEMENTARY;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__PORT = ANALYSIS_FUNCTION_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__PORT_GROUP = ANALYSIS_FUNCTION_TYPE__PORT_GROUP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__CONNECTOR = ANALYSIS_FUNCTION_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE__PART = ANALYSIS_FUNCTION_TYPE__PART;

	/**
	 * The number of structural features of the '<em>Functional Device</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEVICE_FEATURE_COUNT = ANALYSIS_FUNCTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_PROTOTYPE__NAME = FUNCTION_PROTOTYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_PROTOTYPE__BASE_NAMED_ELEMENT = FUNCTION_PROTOTYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_PROTOTYPE__OWNED_COMMENT = FUNCTION_PROTOTYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_PROTOTYPE__BASE_PROPERTY = FUNCTION_PROTOTYPE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_PROTOTYPE__TYPE = FUNCTION_PROTOTYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Analysis Function Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_FUNCTION_PROTOTYPE_FEATURE_COUNT = FUNCTION_PROTOTYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FLOW_PORT__BASE_PORT = PortandflowsPackage.FLOW_PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FLOW_PORT__IS_ATOMIC = PortandflowsPackage.FLOW_PORT__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Is Conjugated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FLOW_PORT__IS_CONJUGATED = PortandflowsPackage.FLOW_PORT__IS_CONJUGATED;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FLOW_PORT__DIRECTION = PortandflowsPackage.FLOW_PORT__DIRECTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FLOW_PORT__NAME = PortandflowsPackage.FLOW_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT = PortandflowsPackage.FLOW_PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FLOW_PORT__OWNED_COMMENT = PortandflowsPackage.FLOW_PORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FLOW_PORT__TYPE = PortandflowsPackage.FLOW_PORT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Function Flow Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FLOW_PORT_FEATURE_COUNT = PortandflowsPackage.FLOW_PORT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_PORT__NAME = FUNCTION_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_PORT__BASE_NAMED_ELEMENT = FUNCTION_PORT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_PORT__OWNED_COMMENT = FUNCTION_PORT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_PORT__TYPE = FUNCTION_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_PORT__BASE_PORT = FUNCTION_PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Client Server Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_PORT__CLIENT_SERVER_TYPE = FUNCTION_PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function Client Server Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_PORT_FEATURE_COUNT = FUNCTION_PORT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_INTERFACE__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_INTERFACE__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_INTERFACE__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_INTERFACE__BASE_INTERFACE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_INTERFACE__OPERATION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Client Server Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CLIENT_SERVER_INTERFACE_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__BASE_OPERATION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__ARGUMENT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Return</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__RETURN = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.BasicSoftwareFunctionTypeImpl
	 * <em>Basic Software Function Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.BasicSoftwareFunctionTypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getBasicSoftwareFunctionType()
	 * @generated
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__NAME = DESIGN_FUNCTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__BASE_NAMED_ELEMENT = DESIGN_FUNCTION_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__OWNED_COMMENT = DESIGN_FUNCTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__TRACEABLE_SPECIFICATION = DESIGN_FUNCTION_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__OWNED_RELATIONSHIP = DESIGN_FUNCTION_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__IS_ENCAPSULATED = DESIGN_FUNCTION_TYPE__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__BASE_CLASS = DESIGN_FUNCTION_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is Elementary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__IS_ELEMENTARY = DESIGN_FUNCTION_TYPE__IS_ELEMENTARY;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__PORT = DESIGN_FUNCTION_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__PORT_GROUP = DESIGN_FUNCTION_TYPE__PORT_GROUP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__CONNECTOR = DESIGN_FUNCTION_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE__PART = DESIGN_FUNCTION_TYPE__PART;

	/**
	 * The number of structural features of the '<em>Basic Software Function Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_SOFTWARE_FUNCTION_TYPE_FEATURE_COUNT = DESIGN_FUNCTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.HardwareFunctionTypeImpl
	 * <em>Hardware Function Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.HardwareFunctionTypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getHardwareFunctionType()
	 * @generated
	 */
	int HARDWARE_FUNCTION_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__NAME = DESIGN_FUNCTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__BASE_NAMED_ELEMENT = DESIGN_FUNCTION_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__OWNED_COMMENT = DESIGN_FUNCTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__TRACEABLE_SPECIFICATION = DESIGN_FUNCTION_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__OWNED_RELATIONSHIP = DESIGN_FUNCTION_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__IS_ENCAPSULATED = DESIGN_FUNCTION_TYPE__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__BASE_CLASS = DESIGN_FUNCTION_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is Elementary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__IS_ELEMENTARY = DESIGN_FUNCTION_TYPE__IS_ELEMENTARY;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__PORT = DESIGN_FUNCTION_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__PORT_GROUP = DESIGN_FUNCTION_TYPE__PORT_GROUP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__CONNECTOR = DESIGN_FUNCTION_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__PART = DESIGN_FUNCTION_TYPE__PART;

	/**
	 * The feature id for the '<em><b>Hardware Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE__HARDWARE_COMPONENT = DESIGN_FUNCTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hardware Function Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FUNCTION_TYPE_FEATURE_COUNT = DESIGN_FUNCTION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionAllocationImpl
	 * <em>Function Allocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionAllocationImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionAllocation()
	 * @generated
	 */
	int FUNCTION_ALLOCATION = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ALLOCATION__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ALLOCATION__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ALLOCATION__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ALLOCATION__TARGET = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allocated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ALLOCATION__ALLOCATED_ELEMENT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ALLOCATION__BASE_DEPENDENCY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Allocated Element path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ALLOCATION__ALLOCATED_ELEMENT_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ALLOCATION__TARGET_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Function Allocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ALLOCATION_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AllocationImpl <em>Allocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AllocationImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getAllocation()
	 * @generated
	 */
	int ALLOCATION = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__BASE_PACKAGE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Function Allocation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__FUNCTION_ALLOCATION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Allocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPowerPortImpl
	 * <em>Function Power Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPowerPortImpl
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getFunctionPowerPort()
	 * @generated
	 */
	int FUNCTION_POWER_PORT = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POWER_PORT__NAME = FUNCTION_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POWER_PORT__BASE_NAMED_ELEMENT = FUNCTION_PORT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POWER_PORT__OWNED_COMMENT = FUNCTION_PORT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POWER_PORT__BASE_PORT = FUNCTION_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POWER_PORT__TYPE = FUNCTION_PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Power Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POWER_PORT_FEATURE_COUNT = FUNCTION_PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind <em>EA Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getEADirectionKind()
	 * @generated
	 */
	int EA_DIRECTION_KIND = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind <em>Client Server Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl#getClientServerKind()
	 * @generated
	 */
	int CLIENT_SERVER_KIND = 21;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.AllocateableElement
	 * <em>Allocateable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Allocateable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.AllocateableElement
	 * @generated
	 */
	EClass getAllocateableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation <em>Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Allocation</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation
	 * @generated
	 */
	EClass getAllocation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation#getBase_Class()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation#getBase_Package()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_Base_Package();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation#getFunctionAllocation
	 * <em>Function Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Function Allocation</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation#getFunctionAllocation()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_FunctionAllocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype
	 * <em>Analysis Function Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Analysis Function Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype
	 * @generated
	 */
	EClass getAnalysisFunctionPrototype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype#getType
	 * <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype#getType()
	 * @see #getAnalysisFunctionPrototype()
	 * @generated
	 */
	EReference getAnalysisFunctionPrototype_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionType
	 * <em>Analysis Function Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Analysis Function Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionType
	 * @generated
	 */
	EClass getAnalysisFunctionType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionType#getPart
	 * <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Part</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionType#getPart()
	 * @see #getAnalysisFunctionType()
	 * @generated
	 */
	EReference getAnalysisFunctionType_Part();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.BasicSoftwareFunctionType
	 * <em>Basic Software Function Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Basic Software Function Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.BasicSoftwareFunctionType
	 * @generated
	 */
	EClass getBasicSoftwareFunctionType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind <em>Client Server Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Client Server Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind
	 * @generated
	 */
	EEnum getClientServerKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind <em>EA Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>EA Direction Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind
	 * @generated
	 */
	EEnum getEADirectionKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype
	 * <em>Design Function Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Design Function Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype
	 * @generated
	 */
	EClass getDesignFunctionPrototype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype#getType
	 * <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype#getType()
	 * @see #getDesignFunctionPrototype()
	 * @generated
	 */
	EReference getDesignFunctionPrototype_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionType
	 * <em>Design Function Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Design Function Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionType
	 * @generated
	 */
	EClass getDesignFunctionType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionType#getPart
	 * <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Part</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionType#getPart()
	 * @see #getDesignFunctionType()
	 * @generated
	 */
	EReference getDesignFunctionType_Part();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionalDevice <em>Functional Device</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Functional Device</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionalDevice
	 * @generated
	 */
	EClass getFunctionalDevice();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation
	 * <em>Function Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Allocation</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation
	 * @generated
	 */
	EClass getFunctionAllocation();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getAllocatedElement <em>Allocated Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Allocated Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getAllocatedElement()
	 * @see #getFunctionAllocation()
	 * @generated
	 */
	EReference getFunctionAllocation_AllocatedElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getBase_Dependency
	 * <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getBase_Dependency()
	 * @see #getFunctionAllocation()
	 * @generated
	 */
	EReference getFunctionAllocation_Base_Dependency();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getAllocatedElement_path <em>Allocated Element path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Allocated Element path</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getAllocatedElement_path()
	 * @see #getFunctionAllocation()
	 * @generated
	 */
	EReference getFunctionAllocation_AllocatedElement_path();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getTarget_path <em>Target path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Target path</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getTarget_path()
	 * @see #getFunctionAllocation()
	 * @generated
	 */
	EReference getFunctionAllocation_Target_path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getTarget
	 * <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getTarget()
	 * @see #getFunctionAllocation()
	 * @generated
	 */
	EReference getFunctionAllocation_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerInterface
	 * <em>Function Client Server Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Client Server Interface</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerInterface
	 * @generated
	 */
	EClass getFunctionClientServerInterface();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerInterface#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerInterface#getBase_Interface()
	 * @see #getFunctionClientServerInterface()
	 * @generated
	 */
	EReference getFunctionClientServerInterface_Base_Interface();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerInterface#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Operation</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerInterface#getOperation()
	 * @see #getFunctionClientServerInterface()
	 * @generated
	 */
	EReference getFunctionClientServerInterface_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort
	 * <em>Function Client Server Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Client Server Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort
	 * @generated
	 */
	EClass getFunctionClientServerPort();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getClientServerType <em>Client Server Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Client Server Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getClientServerType()
	 * @see #getFunctionClientServerPort()
	 * @generated
	 */
	EAttribute getFunctionClientServerPort_ClientServerType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getType
	 * <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getType()
	 * @see #getFunctionClientServerPort()
	 * @generated
	 */
	EReference getFunctionClientServerPort_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getBase_Port
	 * <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getBase_Port()
	 * @see #getFunctionClientServerPort()
	 * @generated
	 */
	EReference getFunctionClientServerPort_Base_Port();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector <em>Function Connector</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector
	 * @generated
	 */
	EClass getFunctionConnector();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getPort
	 * <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getPort()
	 * @see #getFunctionConnector()
	 * @generated
	 */
	EReference getFunctionConnector_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getBase_Connector
	 * <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getBase_Connector()
	 * @see #getFunctionConnector()
	 * @generated
	 */
	EReference getFunctionConnector_Base_Connector();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getPort1_path
	 * <em>Port1 path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port1 path</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getPort1_path()
	 * @see #getFunctionConnector()
	 * @generated
	 */
	EReference getFunctionConnector_Port1_path();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getPort2_path
	 * <em>Port2 path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port2 path</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getPort2_path()
	 * @see #getFunctionConnector()
	 * @generated
	 */
	EReference getFunctionConnector_Port2_path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionFlowPort <em>Function Flow Port</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Flow Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionFlowPort
	 * @generated
	 */
	EClass getFunctionFlowPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionFlowPort#getType
	 * <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionFlowPort#getType()
	 * @see #getFunctionFlowPort()
	 * @generated
	 */
	EReference getFunctionFlowPort_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FunctionmodelingFactory getFunctionmodelingFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort <em>Function Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort
	 * @generated
	 */
	EClass getFunctionPort();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPowerPort
	 * <em>Function Power Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Power Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPowerPort
	 * @generated
	 */
	EClass getFunctionPowerPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPowerPort#getBase_Port
	 * <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPowerPort#getBase_Port()
	 * @see #getFunctionPowerPort()
	 * @generated
	 */
	EReference getFunctionPowerPort_Base_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPowerPort#getType
	 * <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPowerPort#getType()
	 * @see #getFunctionPowerPort()
	 * @generated
	 */
	EReference getFunctionPowerPort_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype <em>Function Prototype</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype
	 * @generated
	 */
	EClass getFunctionPrototype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype#getBase_Property
	 * <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype#getBase_Property()
	 * @see #getFunctionPrototype()
	 * @generated
	 */
	EReference getFunctionPrototype_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType <em>Function Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType
	 * @generated
	 */
	EClass getFunctionType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#getConnector
	 * <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#getConnector()
	 * @see #getFunctionType()
	 * @generated
	 */
	EReference getFunctionType_Connector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#isIsElementary
	 * <em>Is Elementary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Elementary</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#isIsElementary()
	 * @see #getFunctionType()
	 * @generated
	 */
	EAttribute getFunctionType_IsElementary();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#getPort
	 * <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#getPort()
	 * @see #getFunctionType()
	 * @generated
	 */
	EReference getFunctionType_Port();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#getPortGroup
	 * <em>Port Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#getPortGroup()
	 * @see #getFunctionType()
	 * @generated
	 */
	EReference getFunctionType_PortGroup();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.HardwareFunctionType
	 * <em>Hardware Function Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Hardware Function Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.HardwareFunctionType
	 * @generated
	 */
	EClass getHardwareFunctionType();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.HardwareFunctionType#getHardwareComponent <em>Hardware Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Hardware Component</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.HardwareFunctionType#getHardwareComponent()
	 * @see #getHardwareFunctionType()
	 * @generated
	 */
	EReference getHardwareFunctionType_HardwareComponent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.LocalDeviceManager
	 * <em>Local Device Manager</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Local Device Manager</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.LocalDeviceManager
	 * @generated
	 */
	EClass getLocalDeviceManager();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation#getBase_Operation
	 * <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation#getBase_Operation()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Base_Operation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation#getArgument
	 * <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Argument</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation#getArgument()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation#getReturn <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Return</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation#getReturn()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Return();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup <em>Port Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Port Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup
	 * @generated
	 */
	EClass getPortGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup#getPort <em>Port</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup#getPort()
	 * @see #getPortGroup()
	 * @generated
	 */
	EReference getPortGroup_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup#getBase_Class()
	 * @see #getPortGroup()
	 * @generated
	 */
	EReference getPortGroup_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup#getBase_Port
	 * <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup#getBase_Port()
	 * @see #getPortGroup()
	 * @generated
	 */
	EReference getPortGroup_Base_Port();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup#getPortGroup
	 * <em>Port Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup#getPortGroup()
	 * @see #getPortGroup()
	 * @generated
	 */
	EReference getPortGroup_PortGroup();

} // FunctionmodelingPackage
