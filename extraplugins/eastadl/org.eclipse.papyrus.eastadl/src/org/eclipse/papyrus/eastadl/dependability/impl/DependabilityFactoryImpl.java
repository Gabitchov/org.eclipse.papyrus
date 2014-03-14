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
package org.eclipse.papyrus.eastadl.dependability.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.dependability.*;
import org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind;
import org.eclipse.papyrus.eastadl.dependability.Dependability;
import org.eclipse.papyrus.eastadl.dependability.DependabilityFactory;
import org.eclipse.papyrus.eastadl.dependability.DependabilityPackage;
import org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind;
import org.eclipse.papyrus.eastadl.dependability.ExposureClassKind;
import org.eclipse.papyrus.eastadl.dependability.FeatureFlaw;
import org.eclipse.papyrus.eastadl.dependability.Hazard;
import org.eclipse.papyrus.eastadl.dependability.HazardousEvent;
import org.eclipse.papyrus.eastadl.dependability.Item;
import org.eclipse.papyrus.eastadl.dependability.SeverityClassKind;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DependabilityFactoryImpl extends EFactoryImpl implements DependabilityFactory {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DependabilityPackage getPackage() {
		return DependabilityPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DependabilityFactory init() {
		try {
			DependabilityFactory theDependabilityFactory = (DependabilityFactory)EPackage.Registry.INSTANCE.getEFactory(DependabilityPackage.eNS_URI);
			if(theDependabilityFactory != null) {
				return theDependabilityFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DependabilityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DependabilityFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertControllabilityClassKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertDevelopmentCategoryKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertExposureClassKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertSeverityClassKindToString(EDataType eDataType, Object instanceValue) {
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
		case DependabilityPackage.CONTROLLABILITY_CLASS_KIND:
			return convertControllabilityClassKindToString(eDataType, instanceValue);
		case DependabilityPackage.EXPOSURE_CLASS_KIND:
			return convertExposureClassKindToString(eDataType, instanceValue);
		case DependabilityPackage.SEVERITY_CLASS_KIND:
			return convertSeverityClassKindToString(eDataType, instanceValue);
		case DependabilityPackage.DEVELOPMENT_CATEGORY_KIND:
			return convertDevelopmentCategoryKindToString(eDataType, instanceValue);
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
		case DependabilityPackage.HAZARDOUS_EVENT:
			return createHazardousEvent();
		case DependabilityPackage.HAZARD:
			return createHazard();
		case DependabilityPackage.FEATURE_FLAW:
			return createFeatureFlaw();
		case DependabilityPackage.ITEM:
			return createItem();
		case DependabilityPackage.DEPENDABILITY:
			return createDependability();
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
	public ControllabilityClassKind createControllabilityClassKindFromString(EDataType eDataType, String initialValue) {
		ControllabilityClassKind result = ControllabilityClassKind.get(initialValue);
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
	public Dependability createDependability() {
		DependabilityImpl dependability = new DependabilityImpl();
		return dependability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DevelopmentCategoryKind createDevelopmentCategoryKindFromString(EDataType eDataType, String initialValue) {
		DevelopmentCategoryKind result = DevelopmentCategoryKind.get(initialValue);
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
	public ExposureClassKind createExposureClassKindFromString(EDataType eDataType, String initialValue) {
		ExposureClassKind result = ExposureClassKind.get(initialValue);
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
	public FeatureFlaw createFeatureFlaw() {
		FeatureFlawImpl featureFlaw = new FeatureFlawImpl();
		return featureFlaw;
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
		case DependabilityPackage.CONTROLLABILITY_CLASS_KIND:
			return createControllabilityClassKindFromString(eDataType, initialValue);
		case DependabilityPackage.EXPOSURE_CLASS_KIND:
			return createExposureClassKindFromString(eDataType, initialValue);
		case DependabilityPackage.SEVERITY_CLASS_KIND:
			return createSeverityClassKindFromString(eDataType, initialValue);
		case DependabilityPackage.DEVELOPMENT_CATEGORY_KIND:
			return createDevelopmentCategoryKindFromString(eDataType, initialValue);
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
	public Hazard createHazard() {
		HazardImpl hazard = new HazardImpl();
		return hazard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HazardousEvent createHazardousEvent() {
		HazardousEventImpl hazardousEvent = new HazardousEventImpl();
		return hazardousEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Item createItem() {
		ItemImpl item = new ItemImpl();
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SeverityClassKind createSeverityClassKindFromString(EDataType eDataType, String initialValue) {
		SeverityClassKind result = SeverityClassKind.get(initialValue);
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
	public DependabilityPackage getDependabilityPackage() {
		return (DependabilityPackage)getEPackage();
	}

} //DependabilityFactoryImpl
