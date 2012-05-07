/**
 *  Copyright (c) 2012 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusemfcompareinstanceFactoryImpl extends EFactoryImpl implements PapyrusemfcompareinstanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PapyrusemfcompareinstanceFactory init() {
		try {
			PapyrusemfcompareinstanceFactory thePapyrusemfcompareinstanceFactory = (PapyrusemfcompareinstanceFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/Papyrus/EMFCompare/0.9.0/papyrusemfcompareinstance"); 
			if (thePapyrusemfcompareinstanceFactory != null) {
				return thePapyrusemfcompareinstanceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PapyrusemfcompareinstanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusemfcompareinstanceFactoryImpl() {
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
			case PapyrusemfcompareinstancePackage.PAPYRUS_EMF_COMPARE_INSTANCE: return createPapyrusEMFCompareInstance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusEMFCompareInstance createPapyrusEMFCompareInstance() {
		PapyrusEMFCompareInstanceImpl papyrusEMFCompareInstance = new PapyrusEMFCompareInstanceImpl();
		return papyrusEMFCompareInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusemfcompareinstancePackage getPapyrusemfcompareinstancePackage() {
		return (PapyrusemfcompareinstancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PapyrusemfcompareinstancePackage getPackage() {
		return PapyrusemfcompareinstancePackage.eINSTANCE;
	}

} //PapyrusemfcompareinstanceFactoryImpl
