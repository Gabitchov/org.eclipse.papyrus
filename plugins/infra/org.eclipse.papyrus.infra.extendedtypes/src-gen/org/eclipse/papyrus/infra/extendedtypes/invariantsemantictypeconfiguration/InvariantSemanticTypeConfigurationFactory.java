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
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage
 * @generated
 */
public interface InvariantSemanticTypeConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InvariantSemanticTypeConfigurationFactory eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Invariant Semantic Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invariant Semantic Type Configuration</em>'.
	 * @generated
	 */
	InvariantSemanticTypeConfiguration createInvariantSemanticTypeConfiguration();

	/**
	 * Returns a new object of class '<em>And Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Rule</em>'.
	 * @generated
	 */
	AndRule createAndRule();

	/**
	 * Returns a new object of class '<em>Or Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Rule</em>'.
	 * @generated
	 */
	OrRule createOrRule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InvariantSemanticTypeConfigurationPackage getInvariantSemanticTypeConfigurationPackage();

} //InvariantSemanticTypeConfigurationFactory
