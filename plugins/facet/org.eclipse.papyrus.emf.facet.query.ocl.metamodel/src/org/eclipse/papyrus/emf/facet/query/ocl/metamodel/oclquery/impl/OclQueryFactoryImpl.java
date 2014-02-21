/**
 *  Copyright (c) 2012 Mia-Software.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * 	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 * 
 * 
 */
package org.eclipse.emf.facet.query.ocl.metamodel.oclquery.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.facet.query.ocl.metamodel.oclquery.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclQueryFactoryImpl extends EFactoryImpl implements OclQueryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OclQueryFactory init() {
		try {
			OclQueryFactory theOclQueryFactory = (OclQueryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/facet/query/ocl/0.3.incubation/oclquery"); 
			if (theOclQueryFactory != null) {
				return theOclQueryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OclQueryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclQueryFactoryImpl() {
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
			case OclQueryPackage.OCL_QUERY: return createOclQuery();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclQuery createOclQuery() {
		OclQueryImpl oclQuery = new OclQueryImpl();
		return oclQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclQueryPackage getOclQueryPackage() {
		return (OclQueryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OclQueryPackage getPackage() {
		return OclQueryPackage.eINSTANCE;
	}

} //OclQueryFactoryImpl
