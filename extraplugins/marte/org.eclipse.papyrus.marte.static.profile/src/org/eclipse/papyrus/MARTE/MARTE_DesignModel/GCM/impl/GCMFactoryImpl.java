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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GCMFactoryImpl extends EFactoryImpl implements GCMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GCMFactory init() {
		try {
			GCMFactory theGCMFactory = (GCMFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/GCM/1"); 
			if (theGCMFactory != null) {
				return theGCMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GCMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GCMFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GCMPackage.FLOW_PROPERTY: return createFlowProperty();
			case GCMPackage.FLOW_PORT: return createFlowPort();
			case GCMPackage.CLIENT_SERVER_PORT: return createClientServerPort();
			case GCMPackage.CLIENT_SERVER_SPECIFICATION: return createClientServerSpecification();
			case GCMPackage.FLOW_SPECIFICATION: return createFlowSpecification();
			case GCMPackage.CLIENT_SERVER_FEATURE: return createClientServerFeature();
			case GCMPackage.GCM_TRIGGER: return createGCMTrigger();
			case GCMPackage.GCM_INVOCATION_ACTION: return createGCMInvocationAction();
			case GCMPackage.DATA_EVENT: return createDataEvent();
			case GCMPackage.DATA_POOL: return createDataPool();
			case GCMPackage.GCM_INVOCATING_BEHAVIOR: return createGCMInvocatingBehavior();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GCMPackage.FLOW_DIRECTION_KIND:
				return createFlowDirectionKindFromString(eDataType, initialValue);
			case GCMPackage.PORT_SPECIFICATION_KIND:
				return createPortSpecificationKindFromString(eDataType, initialValue);
			case GCMPackage.CLIENT_SERVER_KIND:
				return createClientServerKindFromString(eDataType, initialValue);
			case GCMPackage.DATA_POOL_ORDERING_KIND:
				return createDataPoolOrderingKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GCMPackage.FLOW_DIRECTION_KIND:
				return convertFlowDirectionKindToString(eDataType, instanceValue);
			case GCMPackage.PORT_SPECIFICATION_KIND:
				return convertPortSpecificationKindToString(eDataType, instanceValue);
			case GCMPackage.CLIENT_SERVER_KIND:
				return convertClientServerKindToString(eDataType, instanceValue);
			case GCMPackage.DATA_POOL_ORDERING_KIND:
				return convertDataPoolOrderingKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowProperty createFlowProperty() {
		FlowPropertyImpl flowProperty = new FlowPropertyImpl();
		return flowProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowPort createFlowPort() {
		FlowPortImpl flowPort = new FlowPortImpl();
		return flowPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClientServerPort createClientServerPort() {
		ClientServerPortImpl clientServerPort = new ClientServerPortImpl();
		return clientServerPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClientServerSpecification createClientServerSpecification() {
		ClientServerSpecificationImpl clientServerSpecification = new ClientServerSpecificationImpl();
		return clientServerSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification createFlowSpecification() {
		FlowSpecificationImpl flowSpecification = new FlowSpecificationImpl();
		return flowSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClientServerFeature createClientServerFeature() {
		ClientServerFeatureImpl clientServerFeature = new ClientServerFeatureImpl();
		return clientServerFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GCMTrigger createGCMTrigger() {
		GCMTriggerImpl gcmTrigger = new GCMTriggerImpl();
		return gcmTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GCMInvocationAction createGCMInvocationAction() {
		GCMInvocationActionImpl gcmInvocationAction = new GCMInvocationActionImpl();
		return gcmInvocationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataEvent createDataEvent() {
		DataEventImpl dataEvent = new DataEventImpl();
		return dataEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPool createDataPool() {
		DataPoolImpl dataPool = new DataPoolImpl();
		return dataPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GCMInvocatingBehavior createGCMInvocatingBehavior() {
		GCMInvocatingBehaviorImpl gcmInvocatingBehavior = new GCMInvocatingBehaviorImpl();
		return gcmInvocatingBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowDirectionKind createFlowDirectionKindFromString(EDataType eDataType, String initialValue) {
		FlowDirectionKind result = FlowDirectionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFlowDirectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortSpecificationKind createPortSpecificationKindFromString(EDataType eDataType, String initialValue) {
		PortSpecificationKind result = PortSpecificationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortSpecificationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClientServerKind createClientServerKindFromString(EDataType eDataType, String initialValue) {
		ClientServerKind result = ClientServerKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClientServerKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPoolOrderingKind createDataPoolOrderingKindFromString(EDataType eDataType, String initialValue) {
		DataPoolOrderingKind result = DataPoolOrderingKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataPoolOrderingKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GCMPackage getGCMPackage() {
		return (GCMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GCMPackage getPackage() {
		return GCMPackage.eINSTANCE;
	}

} //GCMFactoryImpl
