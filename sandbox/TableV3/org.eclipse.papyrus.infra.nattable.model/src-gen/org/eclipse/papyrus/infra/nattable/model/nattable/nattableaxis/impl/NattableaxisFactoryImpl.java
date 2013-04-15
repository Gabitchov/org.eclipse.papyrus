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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NattableaxisFactoryImpl extends EFactoryImpl implements NattableaxisFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NattableaxisFactory init() {
		try {
			NattableaxisFactory theNattableaxisFactory = (NattableaxisFactory)EPackage.Registry.INSTANCE.getEFactory(NattableaxisPackage.eNS_URI);
			if (theNattableaxisFactory != null) {
				return theNattableaxisFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NattableaxisFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattableaxisFactoryImpl() {
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
			case NattableaxisPackage.EOBJECT_AXIS: return createEObjectAxis();
			case NattableaxisPackage.FEATURE_ID_AXIS: return createFeatureIdAxis();
			case NattableaxisPackage.ESTRUCTURAL_FEATURE_AXIS: return createEStructuralFeatureAxis();
			case NattableaxisPackage.OBJECT_ID_AXIS: return createObjectIdAxis();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectAxis createEObjectAxis() {
		EObjectAxisImpl eObjectAxis = new EObjectAxisImpl();
		return eObjectAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureIdAxis createFeatureIdAxis() {
		FeatureIdAxisImpl featureIdAxis = new FeatureIdAxisImpl();
		return featureIdAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeatureAxis createEStructuralFeatureAxis() {
		EStructuralFeatureAxisImpl eStructuralFeatureAxis = new EStructuralFeatureAxisImpl();
		return eStructuralFeatureAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectIdAxis createObjectIdAxis() {
		ObjectIdAxisImpl objectIdAxis = new ObjectIdAxisImpl();
		return objectIdAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattableaxisPackage getNattableaxisPackage() {
		return (NattableaxisPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NattableaxisPackage getPackage() {
		return NattableaxisPackage.eINSTANCE;
	}

} //NattableaxisFactoryImpl
