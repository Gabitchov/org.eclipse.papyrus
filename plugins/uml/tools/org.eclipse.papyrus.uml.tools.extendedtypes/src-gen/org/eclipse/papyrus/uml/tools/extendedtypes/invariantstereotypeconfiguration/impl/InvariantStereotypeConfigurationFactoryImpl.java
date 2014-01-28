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
package org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantStereotypeConfigurationFactoryImpl extends EFactoryImpl implements InvariantStereotypeConfigurationFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InvariantStereotypeConfigurationFactory init() {
		try {
			InvariantStereotypeConfigurationFactory theInvariantStereotypeConfigurationFactory = (InvariantStereotypeConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(InvariantStereotypeConfigurationPackage.eNS_URI);
			if(theInvariantStereotypeConfigurationFactory != null) {
				return theInvariantStereotypeConfigurationFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InvariantStereotypeConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantStereotypeConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION:
			return createInvariantStereotypeConfiguration();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantStereotypeConfiguration createInvariantStereotypeConfiguration() {
		InvariantStereotypeConfigurationImpl invariantStereotypeConfiguration = new InvariantStereotypeConfigurationImpl();
		return invariantStereotypeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantStereotypeConfigurationPackage getInvariantStereotypeConfigurationPackage() {
		return (InvariantStereotypeConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InvariantStereotypeConfigurationPackage getPackage() {
		return InvariantStereotypeConfigurationPackage.eINSTANCE;
	}
} //InvariantStereotypeConfigurationFactoryImpl
