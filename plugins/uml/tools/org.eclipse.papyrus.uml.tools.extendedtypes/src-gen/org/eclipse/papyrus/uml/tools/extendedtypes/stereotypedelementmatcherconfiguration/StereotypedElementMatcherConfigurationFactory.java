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
package org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationPackage
 * @generated
 */
public interface StereotypedElementMatcherConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StereotypedElementMatcherConfigurationFactory eINSTANCE = org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl.StereotypedElementMatcherConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Stereotyped Element Matcher Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotyped Element Matcher Configuration</em>'.
	 * @generated
	 */
	StereotypedElementMatcherConfiguration createStereotypedElementMatcherConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StereotypedElementMatcherConfigurationPackage getStereotypedElementMatcherConfigurationPackage();

} //StereotypedElementMatcherConfigurationFactory
