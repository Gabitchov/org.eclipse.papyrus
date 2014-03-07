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
package org.eclipse.papyrus.eastadl.behavior.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.behavior.*;
import org.eclipse.papyrus.eastadl.behavior.Behavior;
import org.eclipse.papyrus.eastadl.behavior.BehaviorFactory;
import org.eclipse.papyrus.eastadl.behavior.BehaviorPackage;
import org.eclipse.papyrus.eastadl.behavior.FunctionBehavior;
import org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind;
import org.eclipse.papyrus.eastadl.behavior.FunctionTrigger;
import org.eclipse.papyrus.eastadl.behavior.Mode;
import org.eclipse.papyrus.eastadl.behavior.ModeGroup;
import org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind;


/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class BehaviorFactoryImpl extends EFactoryImpl implements BehaviorFactory {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BehaviorPackage getPackage() {
		return BehaviorPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static BehaviorFactory init() {
		try {
			BehaviorFactory theBehaviorFactory = (BehaviorFactory)EPackage.Registry.INSTANCE.getEFactory(BehaviorPackage.eNS_URI);
			if(theBehaviorFactory != null) {
				return theBehaviorFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BehaviorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BehaviorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertFunctionBehaviorKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch(eDataType.getClassifierID()) {
		case BehaviorPackage.FUNCTION_BEHAVIOR_KIND:
			return convertFunctionBehaviorKindToString(eDataType, instanceValue);
		case BehaviorPackage.TRIGGER_POLICY_KIND:
			return convertTriggerPolicyKindToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertTriggerPolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case BehaviorPackage.FUNCTION_BEHAVIOR:
			return createFunctionBehavior();
		case BehaviorPackage.MODE:
			return createMode();
		case BehaviorPackage.BEHAVIOR:
			return createBehavior();
		case BehaviorPackage.FUNCTION_TRIGGER:
			return createFunctionTrigger();
		case BehaviorPackage.MODE_GROUP:
			return createModeGroup();
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
	public Behavior createBehavior() {
		BehaviorImpl behavior = new BehaviorImpl();
		return behavior;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch(eDataType.getClassifierID()) {
		case BehaviorPackage.FUNCTION_BEHAVIOR_KIND:
			return createFunctionBehaviorKindFromString(eDataType, initialValue);
		case BehaviorPackage.TRIGGER_POLICY_KIND:
			return createTriggerPolicyKindFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionBehavior createFunctionBehavior() {
		FunctionBehaviorImpl functionBehavior = new FunctionBehaviorImpl();
		return functionBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionBehaviorKind createFunctionBehaviorKindFromString(EDataType eDataType, String initialValue) {
		FunctionBehaviorKind result = FunctionBehaviorKind.get(initialValue);
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
	public FunctionTrigger createFunctionTrigger() {
		FunctionTriggerImpl functionTrigger = new FunctionTriggerImpl();
		return functionTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Mode createMode() {
		ModeImpl mode = new ModeImpl();
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModeGroup createModeGroup() {
		ModeGroupImpl modeGroup = new ModeGroupImpl();
		return modeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TriggerPolicyKind createTriggerPolicyKindFromString(EDataType eDataType, String initialValue) {
		TriggerPolicyKind result = TriggerPolicyKind.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BehaviorPackage getBehaviorPackage() {
		return (BehaviorPackage)getEPackage();
	}

} // BehaviorFactoryImpl
