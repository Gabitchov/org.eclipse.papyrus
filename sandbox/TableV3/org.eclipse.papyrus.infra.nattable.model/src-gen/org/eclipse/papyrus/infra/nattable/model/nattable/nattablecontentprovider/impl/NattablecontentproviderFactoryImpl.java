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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NattablecontentproviderFactoryImpl extends EFactoryImpl implements NattablecontentproviderFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NattablecontentproviderFactory init() {
		try {
			NattablecontentproviderFactory theNattablecontentproviderFactory = (NattablecontentproviderFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/nattable/model/table/nattablecontentprovider"); //$NON-NLS-1$ 
			if (theNattablecontentproviderFactory != null) {
				return theNattablecontentproviderFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NattablecontentproviderFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattablecontentproviderFactoryImpl() {
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
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER: return createDefaultContentProvider();
			case NattablecontentproviderPackage.EMF_FEATURE_CONTENT_PROVIDER: return createEMFFeatureContentProvider();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultContentProvider createDefaultContentProvider() {
		DefaultContentProviderImpl defaultContentProvider = new DefaultContentProviderImpl();
		return defaultContentProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMFFeatureContentProvider createEMFFeatureContentProvider() {
		EMFFeatureContentProviderImpl emfFeatureContentProvider = new EMFFeatureContentProviderImpl();
		return emfFeatureContentProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattablecontentproviderPackage getNattablecontentproviderPackage() {
		return (NattablecontentproviderPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NattablecontentproviderPackage getPackage() {
		return NattablecontentproviderPackage.eINSTANCE;
	}

} //NattablecontentproviderFactoryImpl
