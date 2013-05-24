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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NattablelabelproviderFactoryImpl extends EFactoryImpl implements NattablelabelproviderFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NattablelabelproviderFactory init() {
		try {
			NattablelabelproviderFactory theNattablelabelproviderFactory = (NattablelabelproviderFactory)EPackage.Registry.INSTANCE.getEFactory(NattablelabelproviderPackage.eNS_URI);
			if (theNattablelabelproviderFactory != null) {
				return theNattablelabelproviderFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NattablelabelproviderFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattablelabelproviderFactoryImpl() {
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
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION: return createFeatureLabelProviderConfiguration();
			case NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION: return createObjectLabelProviderConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureLabelProviderConfiguration createFeatureLabelProviderConfiguration() {
		FeatureLabelProviderConfigurationImpl featureLabelProviderConfiguration = new FeatureLabelProviderConfigurationImpl();
		return featureLabelProviderConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectLabelProviderConfiguration createObjectLabelProviderConfiguration() {
		ObjectLabelProviderConfigurationImpl objectLabelProviderConfiguration = new ObjectLabelProviderConfigurationImpl();
		return objectLabelProviderConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattablelabelproviderPackage getNattablelabelproviderPackage() {
		return (NattablelabelproviderPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NattablelabelproviderPackage getPackage() {
		return NattablelabelproviderPackage.eINSTANCE;
	}

} //NattablelabelproviderFactoryImpl
