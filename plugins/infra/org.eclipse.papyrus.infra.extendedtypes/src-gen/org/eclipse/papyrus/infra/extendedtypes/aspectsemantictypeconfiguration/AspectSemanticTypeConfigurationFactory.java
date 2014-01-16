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
package org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfigurationPackage
 * @generated
 */
public interface AspectSemanticTypeConfigurationFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	AspectSemanticTypeConfigurationFactory eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl.AspectSemanticTypeConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Aspect Semantic Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Aspect Semantic Type Configuration</em>'.
	 * @generated
	 */
	AspectSemanticTypeConfiguration createAspectSemanticTypeConfiguration();

	/**
	 * Returns a new object of class '<em>Aspect Semantic Type Advice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Aspect Semantic Type Advice Configuration</em>'.
	 * @generated
	 */
	AspectSemanticTypeAdviceConfiguration createAspectSemanticTypeAdviceConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	AspectSemanticTypeConfigurationPackage getAspectSemanticTypeConfigurationPackage();
} //AspectSemanticTypeConfigurationFactory
