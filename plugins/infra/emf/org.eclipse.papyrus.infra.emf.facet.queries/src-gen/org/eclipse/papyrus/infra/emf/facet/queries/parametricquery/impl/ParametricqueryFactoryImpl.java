/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParametricqueryFactoryImpl extends EFactoryImpl implements ParametricqueryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParametricqueryFactory init() {
		try {
			ParametricqueryFactory theParametricqueryFactory = (ParametricqueryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/infra/emf/facet/parametric/query/0.9.1"); //$NON-NLS-1$ 
			if (theParametricqueryFactory != null) {
				return theParametricqueryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ParametricqueryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricqueryFactoryImpl() {
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
			case ParametricqueryPackage.PARAMETRIC_QUERY: return createParametricQuery();
			case ParametricqueryPackage.STRING_ARGUMENT: return createStringArgument();
			case ParametricqueryPackage.ESTRUCTURAL_FEATURE_ARGUMENT: return createEStructuralFeatureArgument();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricQuery createParametricQuery() {
		ParametricQueryImpl parametricQuery = new ParametricQueryImpl();
		return parametricQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringArgument createStringArgument() {
		StringArgumentImpl stringArgument = new StringArgumentImpl();
		return stringArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeatureArgument createEStructuralFeatureArgument() {
		EStructuralFeatureArgumentImpl eStructuralFeatureArgument = new EStructuralFeatureArgumentImpl();
		return eStructuralFeatureArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricqueryPackage getParametricqueryPackage() {
		return (ParametricqueryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ParametricqueryPackage getPackage() {
		return ParametricqueryPackage.eINSTANCE;
	}

} //ParametricqueryFactoryImpl
