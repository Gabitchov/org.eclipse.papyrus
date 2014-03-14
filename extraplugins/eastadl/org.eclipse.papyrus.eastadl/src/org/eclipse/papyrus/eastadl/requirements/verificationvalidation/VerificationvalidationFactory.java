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
package org.eclipse.papyrus.eastadl.requirements.verificationvalidation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage
 * @generated
 */
public interface VerificationvalidationFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	VerificationvalidationFactory eINSTANCE = org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>VV Stimuli</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>VV Stimuli</em>'.
	 * @generated
	 */
	VVStimuli createVVStimuli();

	/**
	 * Returns a new object of class '<em>VV Intended Outcome</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>VV Intended Outcome</em>'.
	 * @generated
	 */
	VVIntendedOutcome createVVIntendedOutcome();

	/**
	 * Returns a new object of class '<em>VV Actual Outcome</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>VV Actual Outcome</em>'.
	 * @generated
	 */
	VVActualOutcome createVVActualOutcome();

	/**
	 * Returns a new object of class '<em>VV Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>VV Case</em>'.
	 * @generated
	 */
	VVCase createVVCase();

	/**
	 * Returns a new object of class '<em>VV Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>VV Target</em>'.
	 * @generated
	 */
	VVTarget createVVTarget();

	/**
	 * Returns a new object of class '<em>VV Log</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>VV Log</em>'.
	 * @generated
	 */
	VVLog createVVLog();

	/**
	 * Returns a new object of class '<em>VV Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>VV Procedure</em>'.
	 * @generated
	 */
	VVProcedure createVVProcedure();

	/**
	 * Returns a new object of class '<em>Verification Validation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Verification Validation</em>'.
	 * @generated
	 */
	VerificationValidation createVerificationValidation();

	/**
	 * Returns a new object of class '<em>Verify</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Verify</em>'.
	 * @generated
	 */
	Verify createVerify();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	VerificationvalidationPackage getVerificationvalidationPackage();

} //VerificationvalidationFactory
