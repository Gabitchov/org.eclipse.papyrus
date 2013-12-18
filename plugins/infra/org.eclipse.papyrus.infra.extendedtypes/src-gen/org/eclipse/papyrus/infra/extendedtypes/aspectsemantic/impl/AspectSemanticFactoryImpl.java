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
package org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class AspectSemanticFactoryImpl extends EFactoryImpl implements
		AspectSemanticFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static AspectSemanticFactory init() {
		try {
			AspectSemanticFactory theAspectSemanticFactory = (AspectSemanticFactory) EPackage.Registry.INSTANCE
					.getEFactory(AspectSemanticPackage.eNS_URI);
			if (theAspectSemanticFactory != null) {
				return theAspectSemanticFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AspectSemanticFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectSemanticFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION:
			return createAspectSemanticTypeConfiguration();
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION:
			return createAspectSemanticTypeAdviceConfiguration();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectSemanticTypeConfiguration createAspectSemanticTypeConfiguration() {
		AspectSemanticTypeConfigurationImpl aspectSemanticTypeConfiguration = new AspectSemanticTypeConfigurationImpl();
		return aspectSemanticTypeConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectSemanticTypeAdviceConfiguration createAspectSemanticTypeAdviceConfiguration() {
		AspectSemanticTypeAdviceConfigurationImpl aspectSemanticTypeAdviceConfiguration = new AspectSemanticTypeAdviceConfigurationImpl();
		return aspectSemanticTypeAdviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectSemanticPackage getAspectSemanticPackage() {
		return (AspectSemanticPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AspectSemanticPackage getPackage() {
		return AspectSemanticPackage.eINSTANCE;
	}

} // AspectSemanticFactoryImpl
