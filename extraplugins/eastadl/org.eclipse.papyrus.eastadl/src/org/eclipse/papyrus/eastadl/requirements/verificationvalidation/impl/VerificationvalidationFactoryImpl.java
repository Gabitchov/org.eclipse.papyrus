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
package org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVActualOutcome;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVIntendedOutcome;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVStimuli;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationFactory;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VerificationvalidationFactoryImpl extends EFactoryImpl implements VerificationvalidationFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VerificationvalidationPackage getPackage() {
		return VerificationvalidationPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VerificationvalidationFactory init() {
		try {
			VerificationvalidationFactory theVerificationvalidationFactory = (VerificationvalidationFactory)EPackage.Registry.INSTANCE.getEFactory(VerificationvalidationPackage.eNS_URI);
			if (theVerificationvalidationFactory != null) {
				return theVerificationvalidationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VerificationvalidationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerificationvalidationFactoryImpl() {
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
			case VerificationvalidationPackage.VV_STIMULI: return createVVStimuli();
			case VerificationvalidationPackage.VV_INTENDED_OUTCOME: return createVVIntendedOutcome();
			case VerificationvalidationPackage.VV_ACTUAL_OUTCOME: return createVVActualOutcome();
			case VerificationvalidationPackage.VV_CASE: return createVVCase();
			case VerificationvalidationPackage.VV_TARGET: return createVVTarget();
			case VerificationvalidationPackage.VV_LOG: return createVVLog();
			case VerificationvalidationPackage.VV_PROCEDURE: return createVVProcedure();
			case VerificationvalidationPackage.VERIFICATION_VALIDATION: return createVerificationValidation();
			case VerificationvalidationPackage.VERIFY: return createVerify();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VVStimuli createVVStimuli() {
		VVStimuliImpl vvStimuli = new VVStimuliImpl();
		return vvStimuli;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VVIntendedOutcome createVVIntendedOutcome() {
		VVIntendedOutcomeImpl vvIntendedOutcome = new VVIntendedOutcomeImpl();
		return vvIntendedOutcome;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VVActualOutcome createVVActualOutcome() {
		VVActualOutcomeImpl vvActualOutcome = new VVActualOutcomeImpl();
		return vvActualOutcome;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VVCase createVVCase() {
		VVCaseImpl vvCase = new VVCaseImpl();
		return vvCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VVTarget createVVTarget() {
		VVTargetImpl vvTarget = new VVTargetImpl();
		return vvTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VVLog createVVLog() {
		VVLogImpl vvLog = new VVLogImpl();
		return vvLog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VVProcedure createVVProcedure() {
		VVProcedureImpl vvProcedure = new VVProcedureImpl();
		return vvProcedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerificationValidation createVerificationValidation() {
		VerificationValidationImpl verificationValidation = new VerificationValidationImpl();
		return verificationValidation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Verify createVerify() {
		VerifyImpl verify = new VerifyImpl();
		return verify;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerificationvalidationPackage getVerificationvalidationPackage() {
		return (VerificationvalidationPackage)getEPackage();
	}

} //VerificationvalidationFactoryImpl
