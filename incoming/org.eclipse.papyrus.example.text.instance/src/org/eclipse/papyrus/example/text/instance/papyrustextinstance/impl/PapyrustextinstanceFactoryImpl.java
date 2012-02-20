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
 */
package org.eclipse.papyrus.example.text.instance.papyrustextinstance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.example.text.instance.papyrustextinstance.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrustextinstanceFactoryImpl extends EFactoryImpl implements PapyrustextinstanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PapyrustextinstanceFactory init() {
		try {
			PapyrustextinstanceFactory thePapyrustextinstanceFactory = (PapyrustextinstanceFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/Papyrus/Example/0.9.0/papyrustextinstance"); 
			if (thePapyrustextinstanceFactory != null) {
				return thePapyrustextinstanceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PapyrustextinstanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustextinstanceFactoryImpl() {
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
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE: return createPapyrusTextInstance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusTextInstance createPapyrusTextInstance() {
		PapyrusTextInstanceImpl papyrusTextInstance = new PapyrusTextInstanceImpl();
		return papyrusTextInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustextinstancePackage getPapyrustextinstancePackage() {
		return (PapyrustextinstancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PapyrustextinstancePackage getPackage() {
		return PapyrustextinstancePackage.eINSTANCE;
	}

} //PapyrustextinstanceFactoryImpl
