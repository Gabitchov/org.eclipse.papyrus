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
package org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationFactory;
import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StereotypedElementMatcherConfigurationFactoryImpl extends EFactoryImpl implements StereotypedElementMatcherConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StereotypedElementMatcherConfigurationFactory init() {
		try {
			StereotypedElementMatcherConfigurationFactory theStereotypedElementMatcherConfigurationFactory = (StereotypedElementMatcherConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(StereotypedElementMatcherConfigurationPackage.eNS_URI);
			if (theStereotypedElementMatcherConfigurationFactory != null) {
				return theStereotypedElementMatcherConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StereotypedElementMatcherConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypedElementMatcherConfigurationFactoryImpl() {
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
			case StereotypedElementMatcherConfigurationPackage.STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION: return createStereotypedElementMatcherConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypedElementMatcherConfiguration createStereotypedElementMatcherConfiguration() {
		StereotypedElementMatcherConfigurationImpl stereotypedElementMatcherConfiguration = new StereotypedElementMatcherConfigurationImpl();
		return stereotypedElementMatcherConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypedElementMatcherConfigurationPackage getStereotypedElementMatcherConfigurationPackage() {
		return (StereotypedElementMatcherConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StereotypedElementMatcherConfigurationPackage getPackage() {
		return StereotypedElementMatcherConfigurationPackage.eINSTANCE;
	}

} //StereotypedElementMatcherConfigurationFactoryImpl
