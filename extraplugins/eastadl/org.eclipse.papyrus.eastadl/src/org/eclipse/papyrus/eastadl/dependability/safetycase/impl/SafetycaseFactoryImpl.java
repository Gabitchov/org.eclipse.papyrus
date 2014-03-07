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
package org.eclipse.papyrus.eastadl.dependability.safetycase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.dependability.safetycase.*;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Claim;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Ground;
import org.eclipse.papyrus.eastadl.dependability.safetycase.LifecycleStageKind;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycaseFactory;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class SafetycaseFactoryImpl extends EFactoryImpl implements SafetycaseFactory {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SafetycasePackage getPackage() {
		return SafetycasePackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SafetycaseFactory init() {
		try {
			SafetycaseFactory theSafetycaseFactory = (SafetycaseFactory)EPackage.Registry.INSTANCE.getEFactory(SafetycasePackage.eNS_URI);
			if(theSafetycaseFactory != null) {
				return theSafetycaseFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SafetycaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SafetycaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertLifecycleStageKindToString(EDataType eDataType, Object instanceValue) {
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
		case SafetycasePackage.LIFECYCLE_STAGE_KIND:
			return convertLifecycleStageKindToString(eDataType, instanceValue);
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
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case SafetycasePackage.SAFETY_CASE:
			return createSafetyCase();
		case SafetycasePackage.GROUND:
			return createGround();
		case SafetycasePackage.WARRANT:
			return createWarrant();
		case SafetycasePackage.CLAIM:
			return createClaim();
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
	public Claim createClaim() {
		ClaimImpl claim = new ClaimImpl();
		return claim;
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
		case SafetycasePackage.LIFECYCLE_STAGE_KIND:
			return createLifecycleStageKindFromString(eDataType, initialValue);
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
	public Ground createGround() {
		GroundImpl ground = new GroundImpl();
		return ground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LifecycleStageKind createLifecycleStageKindFromString(EDataType eDataType, String initialValue) {
		LifecycleStageKind result = LifecycleStageKind.get(initialValue);
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
	public SafetyCase createSafetyCase() {
		SafetyCaseImpl safetyCase = new SafetyCaseImpl();
		return safetyCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Warrant createWarrant() {
		WarrantImpl warrant = new WarrantImpl();
		return warrant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SafetycasePackage getSafetycasePackage() {
		return (SafetycasePackage)getEPackage();
	}

} //SafetycaseFactoryImpl
