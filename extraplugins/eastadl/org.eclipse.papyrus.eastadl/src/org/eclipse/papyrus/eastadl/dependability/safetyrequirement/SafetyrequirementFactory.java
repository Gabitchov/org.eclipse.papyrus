/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.dependability.safetyrequirement;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage
 * @generated
 */
public interface SafetyrequirementFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SafetyrequirementFactory eINSTANCE = org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyrequirementFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Functional Safety Concept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Functional Safety Concept</em>'.
	 * @generated
	 */
	FunctionalSafetyConcept createFunctionalSafetyConcept();

	/**
	 * Returns a new object of class '<em>Safety Goal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Safety Goal</em>'.
	 * @generated
	 */
	SafetyGoal createSafetyGoal();

	/**
	 * Returns a new object of class '<em>Technical Safety Concept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Technical Safety Concept</em>'.
	 * @generated
	 */
	TechnicalSafetyConcept createTechnicalSafetyConcept();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SafetyrequirementPackage getSafetyrequirementPackage();

} //SafetyrequirementFactory
