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
package org.eclipse.papyrus.infra.nattable.model.nattableconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.nattable.model.nattableconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NattableconfigurationFactoryImpl extends EFactoryImpl implements NattableconfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NattableconfigurationFactory init() {
		try {
			NattableconfigurationFactory theNattableconfigurationFactory = (NattableconfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/nattableconfiguration/model"); //$NON-NLS-1$ 
			if (theNattableconfigurationFactory != null) {
				return theNattableconfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NattableconfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattableconfigurationFactoryImpl() {
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
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION: return createTableEditorConfiguration();
			case NattableconfigurationPackage.LOCAL_TABLE_EDITOR_CONFIGURATION: return createLocalTableEditorConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableEditorConfiguration createTableEditorConfiguration() {
		TableEditorConfigurationImpl tableEditorConfiguration = new TableEditorConfigurationImpl();
		return tableEditorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalTableEditorConfiguration createLocalTableEditorConfiguration() {
		LocalTableEditorConfigurationImpl localTableEditorConfiguration = new LocalTableEditorConfigurationImpl();
		return localTableEditorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattableconfigurationPackage getNattableconfigurationPackage() {
		return (NattableconfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NattableconfigurationPackage getPackage() {
		return NattableconfigurationPackage.eINSTANCE;
	}

} //NattableconfigurationFactoryImpl
