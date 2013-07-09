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
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NattableaxisproviderFactoryImpl extends EFactoryImpl implements NattableaxisproviderFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NattableaxisproviderFactory init() {
		try {
			NattableaxisproviderFactory theNattableaxisproviderFactory = (NattableaxisproviderFactory)EPackage.Registry.INSTANCE.getEFactory(NattableaxisproviderPackage.eNS_URI);
			if (theNattableaxisproviderFactory != null) {
				return theNattableaxisproviderFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NattableaxisproviderFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattableaxisproviderFactoryImpl() {
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
			case NattableaxisproviderPackage.SLAVE_OBJECT_AXIS_PROVIDER: return createSlaveObjectAxisProvider();
			case NattableaxisproviderPackage.MASTER_OBJECT_AXIS_PROVIDER: return createMasterObjectAxisProvider();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlaveObjectAxisProvider createSlaveObjectAxisProvider() {
		SlaveObjectAxisProviderImpl slaveObjectAxisProvider = new SlaveObjectAxisProviderImpl();
		return slaveObjectAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MasterObjectAxisProvider createMasterObjectAxisProvider() {
		MasterObjectAxisProviderImpl masterObjectAxisProvider = new MasterObjectAxisProviderImpl();
		return masterObjectAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattableaxisproviderPackage getNattableaxisproviderPackage() {
		return (NattableaxisproviderPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NattableaxisproviderPackage getPackage() {
		return NattableaxisproviderPackage.eINSTANCE;
	}

} //NattableaxisproviderFactoryImpl
