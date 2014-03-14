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
package org.eclipse.papyrus.eastadl.structure.functionmodeling.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.*;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.BasicSoftwareFunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerInterface;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionFlowPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPowerPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionalDevice;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingFactory;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.HardwareFunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.LocalDeviceManager;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup;


/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class FunctionmodelingFactoryImpl extends EFactoryImpl implements FunctionmodelingFactory {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FunctionmodelingPackage getPackage() {
		return FunctionmodelingPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static FunctionmodelingFactory init() {
		try {
			FunctionmodelingFactory theFunctionmodelingFactory = (FunctionmodelingFactory)EPackage.Registry.INSTANCE.getEFactory(FunctionmodelingPackage.eNS_URI);
			if(theFunctionmodelingFactory != null) {
				return theFunctionmodelingFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FunctionmodelingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionmodelingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertClientServerKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EADirectionKind createEADirectionKindFromString(EDataType eDataType, String initialValue) {
		EADirectionKind result = EADirectionKind.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertEADirectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch(eDataType.getClassifierID()) {
		case FunctionmodelingPackage.CLIENT_SERVER_KIND:
			return convertClientServerKindToString(eDataType, instanceValue);
		case FunctionmodelingPackage.EA_DIRECTION_KIND:
			return convertEADirectionKindToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case FunctionmodelingPackage.LOCAL_DEVICE_MANAGER:
			return createLocalDeviceManager();
		case FunctionmodelingPackage.DESIGN_FUNCTION_TYPE:
			return createDesignFunctionType();
		case FunctionmodelingPackage.PORT_GROUP:
			return createPortGroup();
		case FunctionmodelingPackage.FUNCTION_CONNECTOR:
			return createFunctionConnector();
		case FunctionmodelingPackage.DESIGN_FUNCTION_PROTOTYPE:
			return createDesignFunctionPrototype();
		case FunctionmodelingPackage.FUNCTIONAL_DEVICE:
			return createFunctionalDevice();
		case FunctionmodelingPackage.ANALYSIS_FUNCTION_TYPE:
			return createAnalysisFunctionType();
		case FunctionmodelingPackage.ANALYSIS_FUNCTION_PROTOTYPE:
			return createAnalysisFunctionPrototype();
		case FunctionmodelingPackage.FUNCTION_FLOW_PORT:
			return createFunctionFlowPort();
		case FunctionmodelingPackage.FUNCTION_CLIENT_SERVER_PORT:
			return createFunctionClientServerPort();
		case FunctionmodelingPackage.FUNCTION_CLIENT_SERVER_INTERFACE:
			return createFunctionClientServerInterface();
		case FunctionmodelingPackage.OPERATION:
			return createOperation();
		case FunctionmodelingPackage.BASIC_SOFTWARE_FUNCTION_TYPE:
			return createBasicSoftwareFunctionType();
		case FunctionmodelingPackage.HARDWARE_FUNCTION_TYPE:
			return createHardwareFunctionType();
		case FunctionmodelingPackage.FUNCTION_ALLOCATION:
			return createFunctionAllocation();
		case FunctionmodelingPackage.ALLOCATION:
			return createAllocation();
		case FunctionmodelingPackage.FUNCTION_POWER_PORT:
			return createFunctionPowerPort();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Allocation createAllocation() {
		AllocationImpl allocation = new AllocationImpl();
		return allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnalysisFunctionPrototype createAnalysisFunctionPrototype() {
		AnalysisFunctionPrototypeImpl analysisFunctionPrototype = new AnalysisFunctionPrototypeImpl();
		return analysisFunctionPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnalysisFunctionType createAnalysisFunctionType() {
		AnalysisFunctionTypeImpl analysisFunctionType = new AnalysisFunctionTypeImpl();
		return analysisFunctionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BasicSoftwareFunctionType createBasicSoftwareFunctionType() {
		BasicSoftwareFunctionTypeImpl basicSoftwareFunctionType = new BasicSoftwareFunctionTypeImpl();
		return basicSoftwareFunctionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClientServerKind createClientServerKindFromString(EDataType eDataType, String initialValue) {
		ClientServerKind result = ClientServerKind.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignFunctionPrototype createDesignFunctionPrototype() {
		DesignFunctionPrototypeImpl designFunctionPrototype = new DesignFunctionPrototypeImpl();
		return designFunctionPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignFunctionType createDesignFunctionType() {
		DesignFunctionTypeImpl designFunctionType = new DesignFunctionTypeImpl();
		return designFunctionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch(eDataType.getClassifierID()) {
		case FunctionmodelingPackage.CLIENT_SERVER_KIND:
			return createClientServerKindFromString(eDataType, initialValue);
		case FunctionmodelingPackage.EA_DIRECTION_KIND:
			return createEADirectionKindFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionalDevice createFunctionalDevice() {
		FunctionalDeviceImpl functionalDevice = new FunctionalDeviceImpl();
		return functionalDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionAllocation createFunctionAllocation() {
		FunctionAllocationImpl functionAllocation = new FunctionAllocationImpl();
		return functionAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionClientServerInterface createFunctionClientServerInterface() {
		FunctionClientServerInterfaceImpl functionClientServerInterface = new FunctionClientServerInterfaceImpl();
		return functionClientServerInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionClientServerPort createFunctionClientServerPort() {
		FunctionClientServerPortImpl functionClientServerPort = new FunctionClientServerPortImpl();
		return functionClientServerPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionConnector createFunctionConnector() {
		FunctionConnectorImpl functionConnector = new FunctionConnectorImpl();
		return functionConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionFlowPort createFunctionFlowPort() {
		FunctionFlowPortImpl functionFlowPort = new FunctionFlowPortImpl();
		return functionFlowPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionPowerPort createFunctionPowerPort() {
		FunctionPowerPortImpl functionPowerPort = new FunctionPowerPortImpl();
		return functionPowerPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HardwareFunctionType createHardwareFunctionType() {
		HardwareFunctionTypeImpl hardwareFunctionType = new HardwareFunctionTypeImpl();
		return hardwareFunctionType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LocalDeviceManager createLocalDeviceManager() {
		LocalDeviceManagerImpl localDeviceManager = new LocalDeviceManagerImpl();
		return localDeviceManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PortGroup createPortGroup() {
		PortGroupImpl portGroup = new PortGroupImpl();
		return portGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionmodelingPackage getFunctionmodelingPackage() {
		return (FunctionmodelingPackage)getEPackage();
	}

} // FunctionmodelingFactoryImpl
