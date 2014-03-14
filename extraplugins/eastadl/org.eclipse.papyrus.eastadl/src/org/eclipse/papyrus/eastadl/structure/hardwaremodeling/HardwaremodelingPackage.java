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
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * The package HardwareModeling contains the elements to model physical entities of the embedded EE system. These elements allow capturing the
 * hardware in sufficient detail to allow preliminary allocation decisions.
 * 
 * The allocation decisions are based on requirements on timing, storage, data throughput, processing power, etc. that are defined in the Functional
 * Analysis Architecture and the Functional Design Architecture.
 * 
 * Conversely, the Functional Analysis Architecture and the Functional Design Architecture may be revised based on analysis using information from the
 * Hardware Design Architecture. An example is control law design, where algorithms may be modified for expected computational and communication
 * delays. Thus, the Hardware Design Architecture contains information about properties in order to support, e.g., timing analysis and performance in
 * these respects.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingFactory
 * @model kind="package"
 * @generated
 */
public interface HardwaremodelingPackage extends EPackage {

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentTypeImpl
		 * <em>Hardware Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentTypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwareComponentType()
		 * @generated
		 */
		EClass HARDWARE_COMPONENT_TYPE = eINSTANCE.getHardwareComponentType();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_COMPONENT_TYPE__CONNECTOR = eINSTANCE.getHardwareComponentType_Connector();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_COMPONENT_TYPE__PORT = eINSTANCE.getHardwareComponentType_Port();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_COMPONENT_TYPE__BASE_CLASS = eINSTANCE.getHardwareComponentType_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_COMPONENT_TYPE__PART = eINSTANCE.getHardwareComponentType_Part();

		/**
		 * The meta object literal for the '<em><b>Bus</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_COMPONENT_TYPE__BUS = eINSTANCE.getHardwareComponentType_Bus();

		/**
		 * The meta object literal for the '<em><b>Port Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_COMPONENT_TYPE__PORT_GROUP = eINSTANCE.getHardwareComponentType_PortGroup();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePinKind
		 * <em>IO Hardware Pin Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePinKind
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getIOHardwarePinKind()
		 * @generated
		 */
		EEnum IO_HARDWARE_PIN_KIND = eINSTANCE.getIOHardwarePinKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBusKind <em>Logical Bus Kind</em>}'
		 * enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBusKind
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getLogicalBusKind()
		 * @generated
		 */
		EEnum LOGICAL_BUS_KIND = eINSTANCE.getLogicalBusKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareConnectorImpl
		 * <em>Hardware Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareConnectorImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwareConnector()
		 * @generated
		 */
		EClass HARDWARE_CONNECTOR = eINSTANCE.getHardwareConnector();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_CONNECTOR__BASE_CONNECTOR = eINSTANCE.getHardwareConnector_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_CONNECTOR__PORT = eINSTANCE.getHardwareConnector_Port();

		/**
		 * The meta object literal for the '<em><b>Port1 path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_CONNECTOR__PORT1_PATH = eINSTANCE.getHardwareConnector_Port1_path();

		/**
		 * The meta object literal for the '<em><b>Port2 path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_CONNECTOR__PORT2_PATH = eINSTANCE.getHardwareConnector_Port2_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl <em>Hardware Pin</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwarePin()
		 * @generated
		 */
		EClass HARDWARE_PIN = eINSTANCE.getHardwarePin();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_PIN__BASE_PORT = eINSTANCE.getHardwarePin_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Is Ground</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HARDWARE_PIN__IS_GROUND = eINSTANCE.getHardwarePin_IsGround();

		/**
		 * The meta object literal for the '<em><b>Voltage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HARDWARE_PIN__VOLTAGE = eINSTANCE.getHardwarePin_Voltage();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HARDWARE_PIN__DIRECTION = eINSTANCE.getHardwarePin_Direction();

		/**
		 * The meta object literal for the '<em><b>Impedance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HARDWARE_PIN__IMPEDANCE = eINSTANCE.getHardwarePin_Impedance();

		/**
		 * The meta object literal for the '<em><b>Power</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HARDWARE_PIN__POWER = eINSTANCE.getHardwarePin_Power();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentPrototypeImpl
		 * <em>Hardware Component Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentPrototypeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwareComponentPrototype()
		 * @generated
		 */
		EClass HARDWARE_COMPONENT_PROTOTYPE = eINSTANCE.getHardwareComponentPrototype();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_COMPONENT_PROTOTYPE__TYPE = eINSTANCE.getHardwareComponentPrototype_Type();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_COMPONENT_PROTOTYPE__BASE_PROPERTY = eINSTANCE.getHardwareComponentPrototype_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.AllocationTargetImpl
		 * <em>Allocation Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.AllocationTargetImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getAllocationTarget()
		 * @generated
		 */
		EClass ALLOCATION_TARGET = eINSTANCE.getAllocationTarget();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.LogicalBusImpl <em>Logical Bus</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.LogicalBusImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getLogicalBus()
		 * @generated
		 */
		EClass LOGICAL_BUS = eINSTANCE.getLogicalBus();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LOGICAL_BUS__BASE_CLASS = eINSTANCE.getLogicalBus_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Bus Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LOGICAL_BUS__BUS_SPEED = eINSTANCE.getLogicalBus_BusSpeed();

		/**
		 * The meta object literal for the '<em><b>Bus Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LOGICAL_BUS__BUS_TYPE = eINSTANCE.getLogicalBus_BusType();

		/**
		 * The meta object literal for the '<em><b>Wire</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LOGICAL_BUS__WIRE = eINSTANCE.getLogicalBus_Wire();

		/**
		 * The meta object literal for the '<em><b>Wire path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LOGICAL_BUS__WIRE_PATH = eINSTANCE.getLogicalBus_Wire_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinGroupImpl
		 * <em>Hardware Pin Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinGroupImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwarePinGroup()
		 * @generated
		 */
		EClass HARDWARE_PIN_GROUP = eINSTANCE.getHardwarePinGroup();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_PIN_GROUP__BASE_PORT = eINSTANCE.getHardwarePinGroup_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_PIN_GROUP__BASE_CLASS = eINSTANCE.getHardwarePinGroup_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Port Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_PIN_GROUP__PORT_GROUP = eINSTANCE.getHardwarePinGroup_PortGroup();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HARDWARE_PIN_GROUP__PORT = eINSTANCE.getHardwarePinGroup_Port();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.PowerHardwarePinImpl
		 * <em>Power Hardware Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.PowerHardwarePinImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getPowerHardwarePin()
		 * @generated
		 */
		EClass POWER_HARDWARE_PIN = eINSTANCE.getPowerHardwarePin();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.IOHardwarePinImpl
		 * <em>IO Hardware Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.IOHardwarePinImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getIOHardwarePin()
		 * @generated
		 */
		EClass IO_HARDWARE_PIN = eINSTANCE.getIOHardwarePin();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IO_HARDWARE_PIN__TYPE = eINSTANCE.getIOHardwarePin_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.CommunicationHardwarePinImpl
		 * <em>Communication Hardware Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.CommunicationHardwarePinImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getCommunicationHardwarePin()
		 * @generated
		 */
		EClass COMMUNICATION_HARDWARE_PIN = eINSTANCE.getCommunicationHardwarePin();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.NodeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Execution Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NODE__EXECUTION_RATE = eINSTANCE.getNode_ExecutionRate();

		/**
		 * The meta object literal for the '<em><b>Non Volatile Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NODE__NON_VOLATILE_MEMORY = eINSTANCE.getNode_NonVolatileMemory();

		/**
		 * The meta object literal for the '<em><b>Volatile Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NODE__VOLATILE_MEMORY = eINSTANCE.getNode_VolatileMemory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.PowerSupplyImpl <em>Power Supply</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.PowerSupplyImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getPowerSupply()
		 * @generated
		 */
		EClass POWER_SUPPLY = eINSTANCE.getPowerSupply();

		/**
		 * The meta object literal for the '<em><b>Is Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute POWER_SUPPLY__IS_ACTIVE = eINSTANCE.getPowerSupply_IsActive();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.SensorImpl <em>Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.SensorImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.ActuatorImpl <em>Actuator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.ActuatorImpl
		 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getActuator()
		 * @generated
		 */
		EClass ACTUATOR = eINSTANCE.getActuator();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "hardwaremodeling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Structure/HardwareModeling/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "HardwareModeling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	HardwaremodelingPackage eINSTANCE = org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentTypeImpl
	 * <em>Hardware Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentTypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwareComponentType()
	 * @generated
	 */
	int HARDWARE_COMPONENT_TYPE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareConnectorImpl
	 * <em>Hardware Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareConnectorImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwareConnector()
	 * @generated
	 */
	int HARDWARE_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_CONNECTOR__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_CONNECTOR__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_CONNECTOR__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_CONNECTOR__BASE_CONNECTOR = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_CONNECTOR__PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port1 path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_CONNECTOR__PORT1_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port2 path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_CONNECTOR__PORT2_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Hardware Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_CONNECTOR_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl <em>Hardware Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwarePin()
	 * @generated
	 */
	int HARDWARE_PIN = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentPrototypeImpl
	 * <em>Hardware Component Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentPrototypeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwareComponentPrototype()
	 * @generated
	 */
	int HARDWARE_COMPONENT_PROTOTYPE = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.AllocationTargetImpl <em>Allocation Target</em>}
	 * ' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.AllocationTargetImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getAllocationTarget()
	 * @generated
	 */
	int ALLOCATION_TARGET = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN__BASE_PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Ground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN__IS_GROUND = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN__VOLTAGE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN__DIRECTION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN__IMPEDANCE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN__POWER = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Hardware Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.PowerHardwarePinImpl
	 * <em>Power Hardware Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.PowerHardwarePinImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getPowerHardwarePin()
	 * @generated
	 */
	int POWER_HARDWARE_PIN = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.IOHardwarePinImpl <em>IO Hardware Pin</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.IOHardwarePinImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getIOHardwarePin()
	 * @generated
	 */
	int IO_HARDWARE_PIN = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.CommunicationHardwarePinImpl
	 * <em>Communication Hardware Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.CommunicationHardwarePinImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getCommunicationHardwarePin()
	 * @generated
	 */
	int COMMUNICATION_HARDWARE_PIN = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.NodeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.PowerSupplyImpl <em>Power Supply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.PowerSupplyImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getPowerSupply()
	 * @generated
	 */
	int POWER_SUPPLY = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.SensorImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getSensor()
	 * @generated
	 */
	int SENSOR = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.ActuatorImpl <em>Actuator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.ActuatorImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getActuator()
	 * @generated
	 */
	int ACTUATOR = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_TARGET__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_TARGET__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_TARGET__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Allocation Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_TARGET_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_PROTOTYPE__NAME = ALLOCATION_TARGET__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_PROTOTYPE__BASE_NAMED_ELEMENT = ALLOCATION_TARGET__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_PROTOTYPE__OWNED_COMMENT = ALLOCATION_TARGET__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_PROTOTYPE__TYPE = ALLOCATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_PROTOTYPE__BASE_PROPERTY = ALLOCATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Hardware Component Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_PROTOTYPE_FEATURE_COUNT = ALLOCATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__NAME = HARDWARE_PIN__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__BASE_NAMED_ELEMENT = HARDWARE_PIN__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__OWNED_COMMENT = HARDWARE_PIN__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__BASE_PORT = HARDWARE_PIN__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Is Ground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__IS_GROUND = HARDWARE_PIN__IS_GROUND;

	/**
	 * The feature id for the '<em><b>Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__VOLTAGE = HARDWARE_PIN__VOLTAGE;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__DIRECTION = HARDWARE_PIN__DIRECTION;

	/**
	 * The feature id for the '<em><b>Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__IMPEDANCE = HARDWARE_PIN__IMPEDANCE;

	/**
	 * The feature id for the '<em><b>Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__POWER = HARDWARE_PIN__POWER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN__TYPE = HARDWARE_PIN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IO Hardware Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IO_HARDWARE_PIN_FEATURE_COUNT = HARDWARE_PIN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN__NAME = HARDWARE_PIN__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN__BASE_NAMED_ELEMENT = HARDWARE_PIN__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN__OWNED_COMMENT = HARDWARE_PIN__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN__BASE_PORT = HARDWARE_PIN__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Is Ground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN__IS_GROUND = HARDWARE_PIN__IS_GROUND;

	/**
	 * The feature id for the '<em><b>Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN__VOLTAGE = HARDWARE_PIN__VOLTAGE;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN__DIRECTION = HARDWARE_PIN__DIRECTION;

	/**
	 * The feature id for the '<em><b>Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN__IMPEDANCE = HARDWARE_PIN__IMPEDANCE;

	/**
	 * The feature id for the '<em><b>Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN__POWER = HARDWARE_PIN__POWER;

	/**
	 * The number of structural features of the '<em>Power Hardware Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_PIN_FEATURE_COUNT = HARDWARE_PIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN__NAME = HARDWARE_PIN__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN__BASE_NAMED_ELEMENT = HARDWARE_PIN__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN__OWNED_COMMENT = HARDWARE_PIN__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN__BASE_PORT = HARDWARE_PIN__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Is Ground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN__IS_GROUND = HARDWARE_PIN__IS_GROUND;

	/**
	 * The feature id for the '<em><b>Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN__VOLTAGE = HARDWARE_PIN__VOLTAGE;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN__DIRECTION = HARDWARE_PIN__DIRECTION;

	/**
	 * The feature id for the '<em><b>Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN__IMPEDANCE = HARDWARE_PIN__IMPEDANCE;

	/**
	 * The feature id for the '<em><b>Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN__POWER = HARDWARE_PIN__POWER;

	/**
	 * The number of structural features of the '<em>Communication Hardware Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_HARDWARE_PIN_FEATURE_COUNT = HARDWARE_PIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__CONNECTOR = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__PORT = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__PART = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Bus</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__BUS = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE__PORT_GROUP = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Hardware Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_COMPONENT_TYPE_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = HARDWARE_COMPONENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__BASE_NAMED_ELEMENT = HARDWARE_COMPONENT_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__OWNED_COMMENT = HARDWARE_COMPONENT_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__TRACEABLE_SPECIFICATION = HARDWARE_COMPONENT_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__OWNED_RELATIONSHIP = HARDWARE_COMPONENT_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__CONNECTOR = HARDWARE_COMPONENT_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__PORT = HARDWARE_COMPONENT_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__PART = HARDWARE_COMPONENT_TYPE__PART;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__BASE_CLASS = HARDWARE_COMPONENT_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Bus</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__BUS = HARDWARE_COMPONENT_TYPE__BUS;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__PORT_GROUP = HARDWARE_COMPONENT_TYPE__PORT_GROUP;

	/**
	 * The feature id for the '<em><b>Execution Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__EXECUTION_RATE = HARDWARE_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Non Volatile Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__NON_VOLATILE_MEMORY = HARDWARE_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Volatile Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE__VOLATILE_MEMORY = HARDWARE_COMPONENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = HARDWARE_COMPONENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__NAME = HARDWARE_COMPONENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__BASE_NAMED_ELEMENT = HARDWARE_COMPONENT_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__OWNED_COMMENT = HARDWARE_COMPONENT_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__TRACEABLE_SPECIFICATION = HARDWARE_COMPONENT_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__OWNED_RELATIONSHIP = HARDWARE_COMPONENT_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__CONNECTOR = HARDWARE_COMPONENT_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__PORT = HARDWARE_COMPONENT_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__PART = HARDWARE_COMPONENT_TYPE__PART;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__BASE_CLASS = HARDWARE_COMPONENT_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Bus</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__BUS = HARDWARE_COMPONENT_TYPE__BUS;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__PORT_GROUP = HARDWARE_COMPONENT_TYPE__PORT_GROUP;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__IS_ACTIVE = HARDWARE_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Power Supply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY_FEATURE_COUNT = HARDWARE_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__NAME = HARDWARE_COMPONENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__BASE_NAMED_ELEMENT = HARDWARE_COMPONENT_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__OWNED_COMMENT = HARDWARE_COMPONENT_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__TRACEABLE_SPECIFICATION = HARDWARE_COMPONENT_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__OWNED_RELATIONSHIP = HARDWARE_COMPONENT_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__CONNECTOR = HARDWARE_COMPONENT_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__PORT = HARDWARE_COMPONENT_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__PART = HARDWARE_COMPONENT_TYPE__PART;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__BASE_CLASS = HARDWARE_COMPONENT_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Bus</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__BUS = HARDWARE_COMPONENT_TYPE__BUS;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__PORT_GROUP = HARDWARE_COMPONENT_TYPE__PORT_GROUP;

	/**
	 * The number of structural features of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_FEATURE_COUNT = HARDWARE_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__NAME = HARDWARE_COMPONENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__BASE_NAMED_ELEMENT = HARDWARE_COMPONENT_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__OWNED_COMMENT = HARDWARE_COMPONENT_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__TRACEABLE_SPECIFICATION = HARDWARE_COMPONENT_TYPE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__OWNED_RELATIONSHIP = HARDWARE_COMPONENT_TYPE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__CONNECTOR = HARDWARE_COMPONENT_TYPE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__PORT = HARDWARE_COMPONENT_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__PART = HARDWARE_COMPONENT_TYPE__PART;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__BASE_CLASS = HARDWARE_COMPONENT_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Bus</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__BUS = HARDWARE_COMPONENT_TYPE__BUS;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__PORT_GROUP = HARDWARE_COMPONENT_TYPE__PORT_GROUP;

	/**
	 * The number of structural features of the '<em>Actuator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_FEATURE_COUNT = HARDWARE_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.LogicalBusImpl <em>Logical Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.LogicalBusImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getLogicalBus()
	 * @generated
	 */
	int LOGICAL_BUS = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOGICAL_BUS__NAME = ALLOCATION_TARGET__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOGICAL_BUS__BASE_NAMED_ELEMENT = ALLOCATION_TARGET__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOGICAL_BUS__OWNED_COMMENT = ALLOCATION_TARGET__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOGICAL_BUS__BASE_CLASS = ALLOCATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bus Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOGICAL_BUS__BUS_SPEED = ALLOCATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bus Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOGICAL_BUS__BUS_TYPE = ALLOCATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Wire</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOGICAL_BUS__WIRE = ALLOCATION_TARGET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wire path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOGICAL_BUS__WIRE_PATH = ALLOCATION_TARGET_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Logical Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOGICAL_BUS_FEATURE_COUNT = ALLOCATION_TARGET_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinGroupImpl
	 * <em>Hardware Pin Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinGroupImpl
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getHardwarePinGroup()
	 * @generated
	 */
	int HARDWARE_PIN_GROUP = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN_GROUP__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN_GROUP__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN_GROUP__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN_GROUP__BASE_PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN_GROUP__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN_GROUP__PORT_GROUP = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN_GROUP__PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Hardware Pin Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_PIN_GROUP_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePinKind <em>IO Hardware Pin Kind</em>}'
	 * enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePinKind
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getIOHardwarePinKind()
	 * @generated
	 */
	int IO_HARDWARE_PIN_KIND = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBusKind <em>Logical Bus Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBusKind
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl#getLogicalBusKind()
	 * @generated
	 */
	int LOGICAL_BUS_KIND = 15;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Actuator <em>Actuator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Actuator</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Actuator
	 * @generated
	 */
	EClass getActuator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.AllocationTarget <em>Allocation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Allocation Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.AllocationTarget
	 * @generated
	 */
	EClass getAllocationTarget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePin <em>IO Hardware Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IO Hardware Pin</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePin
	 * @generated
	 */
	EClass getIOHardwarePin();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePin#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePin#getType()
	 * @see #getIOHardwarePin()
	 * @generated
	 */
	EAttribute getIOHardwarePin_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.CommunicationHardwarePin
	 * <em>Communication Hardware Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Communication Hardware Pin</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.CommunicationHardwarePin
	 * @generated
	 */
	EClass getCommunicationHardwarePin();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype
	 * <em>Hardware Component Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Hardware Component Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype
	 * @generated
	 */
	EClass getHardwareComponentPrototype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype#getType
	 * <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype#getType()
	 * @see #getHardwareComponentPrototype()
	 * @generated
	 */
	EReference getHardwareComponentPrototype_Type();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype#getBase_Property()
	 * @see #getHardwareComponentPrototype()
	 * @generated
	 */
	EReference getHardwareComponentPrototype_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType
	 * <em>Hardware Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Hardware Component Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType
	 * @generated
	 */
	EClass getHardwareComponentType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getBus
	 * <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Bus</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getBus()
	 * @see #getHardwareComponentType()
	 * @generated
	 */
	EReference getHardwareComponentType_Bus();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getConnector()
	 * @see #getHardwareComponentType()
	 * @generated
	 */
	EReference getHardwareComponentType_Connector();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getPart
	 * <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Part</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getPart()
	 * @see #getHardwareComponentType()
	 * @generated
	 */
	EReference getHardwareComponentType_Part();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getBase_Class()
	 * @see #getHardwareComponentType()
	 * @generated
	 */
	EReference getHardwareComponentType_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getPort
	 * <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getPort()
	 * @see #getHardwareComponentType()
	 * @generated
	 */
	EReference getHardwareComponentType_Port();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getPortGroup <em>Port Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType#getPortGroup()
	 * @see #getHardwareComponentType()
	 * @generated
	 */
	EReference getHardwareComponentType_PortGroup();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePinKind
	 * <em>IO Hardware Pin Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>IO Hardware Pin Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePinKind
	 * @generated
	 */
	EEnum getIOHardwarePinKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector <em>Hardware Connector</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Hardware Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector
	 * @generated
	 */
	EClass getHardwareConnector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector#getBase_Connector
	 * <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector#getBase_Connector()
	 * @see #getHardwareConnector()
	 * @generated
	 */
	EReference getHardwareConnector_Base_Connector();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector#getPort
	 * <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector#getPort()
	 * @see #getHardwareConnector()
	 * @generated
	 */
	EReference getHardwareConnector_Port();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector#getPort1_path
	 * <em>Port1 path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port1 path</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector#getPort1_path()
	 * @see #getHardwareConnector()
	 * @generated
	 */
	EReference getHardwareConnector_Port1_path();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector#getPort2_path
	 * <em>Port2 path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port2 path</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector#getPort2_path()
	 * @see #getHardwareConnector()
	 * @generated
	 */
	EReference getHardwareConnector_Port2_path();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HardwaremodelingFactory getHardwaremodelingFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin <em>Hardware Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Hardware Pin</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin
	 * @generated
	 */
	EClass getHardwarePin();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getBase_Port
	 * <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getBase_Port()
	 * @see #getHardwarePin()
	 * @generated
	 */
	EReference getHardwarePin_Base_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getDirection
	 * <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getDirection()
	 * @see #getHardwarePin()
	 * @generated
	 */
	EAttribute getHardwarePin_Direction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getImpedance
	 * <em>Impedance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Impedance</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getImpedance()
	 * @see #getHardwarePin()
	 * @generated
	 */
	EAttribute getHardwarePin_Impedance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#isIsGround
	 * <em>Is Ground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Ground</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#isIsGround()
	 * @see #getHardwarePin()
	 * @generated
	 */
	EAttribute getHardwarePin_IsGround();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getPower <em>Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Power</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getPower()
	 * @see #getHardwarePin()
	 * @generated
	 */
	EAttribute getHardwarePin_Power();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getVoltage
	 * <em>Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Voltage</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getVoltage()
	 * @see #getHardwarePin()
	 * @generated
	 */
	EAttribute getHardwarePin_Voltage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup <em>Hardware Pin Group</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Hardware Pin Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup
	 * @generated
	 */
	EClass getHardwarePinGroup();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup#getBase_Port
	 * <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup#getBase_Port()
	 * @see #getHardwarePinGroup()
	 * @generated
	 */
	EReference getHardwarePinGroup_Base_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup#getBase_Class()
	 * @see #getHardwarePinGroup()
	 * @generated
	 */
	EReference getHardwarePinGroup_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup#getPort
	 * <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup#getPort()
	 * @see #getHardwarePinGroup()
	 * @generated
	 */
	EReference getHardwarePinGroup_Port();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup#getPortGroup
	 * <em>Port Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup#getPortGroup()
	 * @see #getHardwarePinGroup()
	 * @generated
	 */
	EReference getHardwarePinGroup_PortGroup();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus <em>Logical Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Logical Bus</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus
	 * @generated
	 */
	EClass getLogicalBus();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getBase_Class()
	 * @see #getLogicalBus()
	 * @generated
	 */
	EReference getLogicalBus_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getBusSpeed
	 * <em>Bus Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Bus Speed</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getBusSpeed()
	 * @see #getLogicalBus()
	 * @generated
	 */
	EAttribute getLogicalBus_BusSpeed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getBusType
	 * <em>Bus Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Bus Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getBusType()
	 * @see #getLogicalBus()
	 * @generated
	 */
	EAttribute getLogicalBus_BusType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getWire <em>Wire</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Wire</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getWire()
	 * @see #getLogicalBus()
	 * @generated
	 */
	EReference getLogicalBus_Wire();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getWire_path
	 * <em>Wire path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Wire path</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus#getWire_path()
	 * @see #getLogicalBus()
	 * @generated
	 */
	EReference getLogicalBus_Wire_path();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBusKind <em>Logical Bus Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Logical Bus Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBusKind
	 * @generated
	 */
	EEnum getLogicalBusKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getExecutionRate
	 * <em>Execution Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Execution Rate</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getExecutionRate()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_ExecutionRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getNonVolatileMemory
	 * <em>Non Volatile Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Non Volatile Memory</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getNonVolatileMemory()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_NonVolatileMemory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getVolatileMemory
	 * <em>Volatile Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Volatile Memory</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getVolatileMemory()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_VolatileMemory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.PowerHardwarePin <em>Power Hardware Pin</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Power Hardware Pin</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.PowerHardwarePin
	 * @generated
	 */
	EClass getPowerHardwarePin();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.PowerSupply <em>Power Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Power Supply</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.PowerSupply
	 * @generated
	 */
	EClass getPowerSupply();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.PowerSupply#isIsActive
	 * <em>Is Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Active</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.PowerSupply#isIsActive()
	 * @see #getPowerSupply()
	 * @generated
	 */
	EAttribute getPowerSupply_IsActive();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Sensor
	 * @generated
	 */
	EClass getSensor();

} //HardwaremodelingPackage
