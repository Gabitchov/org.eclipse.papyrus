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
package org.eclipse.papyrus.infra.extendedtypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.extendedtypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ExtendedtypesFactoryImpl extends EFactoryImpl implements ExtendedtypesFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ExtendedtypesFactory init() {
		try {
			ExtendedtypesFactory theExtendedtypesFactory = (ExtendedtypesFactory)EPackage.Registry.INSTANCE.getEFactory(ExtendedtypesPackage.eNS_URI);
			if(theExtendedtypesFactory != null) {
				return theExtendedtypesFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExtendedtypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtendedtypesFactoryImpl() {
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
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET:
			return createExtendedElementTypeSet();
		case ExtendedtypesPackage.ICON_ENTRY:
			return createIconEntry();
		case ExtendedtypesPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION:
			return createAspectSemanticTypeConfiguration();
		case ExtendedtypesPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION:
			return createAspectSemanticTypeAdviceConfiguration();
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION:
			return createAspectViewTypeConfiguration();
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION:
			return createAspectViewTypeAdviceConfiguration();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtendedElementTypeSet createExtendedElementTypeSet() {
		ExtendedElementTypeSetImpl extendedElementTypeSet = new ExtendedElementTypeSetImpl();
		return extendedElementTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IconEntry createIconEntry() {
		IconEntryImpl iconEntry = new IconEntryImpl();
		return iconEntry;
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
	public AspectViewTypeConfiguration createAspectViewTypeConfiguration() {
		AspectViewTypeConfigurationImpl aspectViewTypeConfiguration = new AspectViewTypeConfigurationImpl();
		return aspectViewTypeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectViewTypeAdviceConfiguration createAspectViewTypeAdviceConfiguration() {
		AspectViewTypeAdviceConfigurationImpl aspectViewTypeAdviceConfiguration = new AspectViewTypeAdviceConfigurationImpl();
		return aspectViewTypeAdviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtendedtypesPackage getExtendedtypesPackage() {
		return (ExtendedtypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExtendedtypesPackage getPackage() {
		return ExtendedtypesPackage.eINSTANCE;
	}
} //ExtendedtypesFactoryImpl
