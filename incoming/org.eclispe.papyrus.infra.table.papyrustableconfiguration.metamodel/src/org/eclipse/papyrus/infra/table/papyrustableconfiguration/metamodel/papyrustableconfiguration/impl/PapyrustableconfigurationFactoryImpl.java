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
package org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrustableconfigurationFactoryImpl extends EFactoryImpl implements PapyrustableconfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PapyrustableconfigurationFactory init() {
		try {
			PapyrustableconfigurationFactory thePapyrustableconfigurationFactory = (PapyrustableconfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/Papyrus/PapyrusTableConfiguration/0.9.0/papyrustableconfiguration"); 
			if (thePapyrustableconfigurationFactory != null) {
				return thePapyrustableconfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PapyrustableconfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustableconfigurationFactoryImpl() {
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
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION: return createPapyrusTableConfiguration();
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
	public PapyrustableconfigurationPackage getPapyrustableconfigurationPackage() {
		return (PapyrustableconfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PapyrustableconfigurationPackage getPackage() {
		return PapyrustableconfigurationPackage.eINSTANCE;
	}

} //PapyrustableconfigurationFactoryImpl