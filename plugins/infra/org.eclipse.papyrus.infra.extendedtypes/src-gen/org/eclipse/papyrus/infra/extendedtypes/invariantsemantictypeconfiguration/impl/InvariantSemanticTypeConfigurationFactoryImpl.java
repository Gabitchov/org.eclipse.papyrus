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
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantSemanticTypeConfigurationFactoryImpl extends EFactoryImpl implements InvariantSemanticTypeConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InvariantSemanticTypeConfigurationFactory init() {
		try {
			InvariantSemanticTypeConfigurationFactory theInvariantSemanticTypeConfigurationFactory = (InvariantSemanticTypeConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(InvariantSemanticTypeConfigurationPackage.eNS_URI);
			if (theInvariantSemanticTypeConfigurationFactory != null) {
				return theInvariantSemanticTypeConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InvariantSemanticTypeConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantSemanticTypeConfigurationFactoryImpl() {
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
			case InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION: return createInvariantSemanticTypeConfiguration();
			case InvariantSemanticTypeConfigurationPackage.AND_RULE: return createAndRule();
			case InvariantSemanticTypeConfigurationPackage.OR_RULE: return createOrRule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantSemanticTypeConfiguration createInvariantSemanticTypeConfiguration() {
		InvariantSemanticTypeConfigurationImpl invariantSemanticTypeConfiguration = new InvariantSemanticTypeConfigurationImpl();
		return invariantSemanticTypeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndRule createAndRule() {
		AndRuleImpl andRule = new AndRuleImpl();
		return andRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrRule createOrRule() {
		OrRuleImpl orRule = new OrRuleImpl();
		return orRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantSemanticTypeConfigurationPackage getInvariantSemanticTypeConfigurationPackage() {
		return (InvariantSemanticTypeConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InvariantSemanticTypeConfigurationPackage getPackage() {
		return InvariantSemanticTypeConfigurationPackage.eINSTANCE;
	}

} //InvariantSemanticTypeConfigurationFactoryImpl
