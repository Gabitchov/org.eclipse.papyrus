/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * ttp://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusTableConfigurationFactoryImpl extends EFactoryImpl implements PapyrusTableConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PapyrusTableConfigurationFactory init() {
		try {
			PapyrusTableConfigurationFactory thePapyrusTableConfigurationFactory = (PapyrusTableConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/PapyrusTableInstance/0.9.1/papyrustableconfiguration"); 
			if (thePapyrusTableConfigurationFactory != null) {
				return thePapyrusTableConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PapyrusTableConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusTableConfigurationFactoryImpl() {
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
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION: return createPapyrusTableConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusTableConfiguration createPapyrusTableConfiguration() {
		PapyrusTableConfigurationImpl papyrusTableConfiguration = new PapyrusTableConfigurationImpl();
		return papyrusTableConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusTableConfigurationPackage getPapyrusTableConfigurationPackage() {
		return (PapyrusTableConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PapyrusTableConfigurationPackage getPackage() {
		return PapyrusTableConfigurationPackage.eINSTANCE;
	}

} //PapyrusTableConfigurationFactoryImpl
