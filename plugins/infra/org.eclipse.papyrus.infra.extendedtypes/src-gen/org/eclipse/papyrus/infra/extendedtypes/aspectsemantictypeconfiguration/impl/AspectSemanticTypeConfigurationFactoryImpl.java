/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class AspectSemanticTypeConfigurationFactoryImpl extends EFactoryImpl implements AspectSemanticTypeConfigurationFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static AspectSemanticTypeConfigurationFactory init() {
		try {
			AspectSemanticTypeConfigurationFactory theAspectSemanticTypeConfigurationFactory = (AspectSemanticTypeConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(AspectSemanticTypeConfigurationPackage.eNS_URI);
			if(theAspectSemanticTypeConfigurationFactory != null) {
				return theAspectSemanticTypeConfigurationFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AspectSemanticTypeConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectSemanticTypeConfigurationFactoryImpl() {
		super();
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
		case AspectSemanticTypeConfigurationPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION:
			return createAspectSemanticTypeConfiguration();
		case AspectSemanticTypeConfigurationPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION:
			return createAspectSemanticTypeAdviceConfiguration();
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
	public AspectSemanticTypeConfiguration createAspectSemanticTypeConfiguration() {
		AspectSemanticTypeConfigurationImpl aspectSemanticTypeConfiguration = new AspectSemanticTypeConfigurationImpl();
		return aspectSemanticTypeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectSemanticTypeAdviceConfiguration createAspectSemanticTypeAdviceConfiguration() {
		AspectSemanticTypeAdviceConfigurationImpl aspectSemanticTypeAdviceConfiguration = new AspectSemanticTypeAdviceConfigurationImpl();
		return aspectSemanticTypeAdviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectSemanticTypeConfigurationPackage getAspectSemanticTypeConfigurationPackage() {
		return (AspectSemanticTypeConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AspectSemanticTypeConfigurationPackage getPackage() {
		return AspectSemanticTypeConfigurationPackage.eINSTANCE;
	}
} //AspectSemanticTypeConfigurationFactoryImpl
