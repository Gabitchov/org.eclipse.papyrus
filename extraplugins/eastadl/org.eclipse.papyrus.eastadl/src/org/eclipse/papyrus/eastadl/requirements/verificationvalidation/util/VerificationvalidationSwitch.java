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
package org.eclipse.papyrus.eastadl.requirements.verificationvalidation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Relationship;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.papyrus.eastadl.requirements.RequirementsRelationship;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVActualOutcome;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVIntendedOutcome;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVStimuli;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify;


/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage
 * @generated
 */
public class VerificationvalidationSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static VerificationvalidationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VerificationvalidationSwitch() {
		if(modelPackage == null) {
			modelPackage = VerificationvalidationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationship(Relationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verify</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verify</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirements_Verify(org.eclipse.papyrus.sysml.requirements.Verify object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementsRelationship(RequirementsRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrace(org.eclipse.uml2.uml.profile.standard.Trace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traceable Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traceable Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceableSpecification(TraceableSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verification Validation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verification Validation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerificationValidation(VerificationValidation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verify</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verify</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerify(Verify object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EA Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EA Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAElement(EAElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EA Packageable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EA Packageable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAPackageableElement(EAPackageableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case VerificationvalidationPackage.VV_STIMULI:
		{
			VVStimuli vvStimuli = (VVStimuli)theEObject;
			T result = caseVVStimuli(vvStimuli);
			if(result == null)
				result = caseTraceableSpecification(vvStimuli);
			if(result == null)
				result = caseEAPackageableElement(vvStimuli);
			if(result == null)
				result = caseEAElement(vvStimuli);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VerificationvalidationPackage.VV_INTENDED_OUTCOME:
		{
			VVIntendedOutcome vvIntendedOutcome = (VVIntendedOutcome)theEObject;
			T result = caseVVIntendedOutcome(vvIntendedOutcome);
			if(result == null)
				result = caseTraceableSpecification(vvIntendedOutcome);
			if(result == null)
				result = caseEAPackageableElement(vvIntendedOutcome);
			if(result == null)
				result = caseEAElement(vvIntendedOutcome);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VerificationvalidationPackage.VV_ACTUAL_OUTCOME:
		{
			VVActualOutcome vvActualOutcome = (VVActualOutcome)theEObject;
			T result = caseVVActualOutcome(vvActualOutcome);
			if(result == null)
				result = caseTraceableSpecification(vvActualOutcome);
			if(result == null)
				result = caseEAPackageableElement(vvActualOutcome);
			if(result == null)
				result = caseEAElement(vvActualOutcome);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VerificationvalidationPackage.VV_CASE:
		{
			VVCase vvCase = (VVCase)theEObject;
			T result = caseVVCase(vvCase);
			if(result == null)
				result = caseTraceableSpecification(vvCase);
			if(result == null)
				result = caseEAPackageableElement(vvCase);
			if(result == null)
				result = caseEAElement(vvCase);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VerificationvalidationPackage.VV_TARGET:
		{
			VVTarget vvTarget = (VVTarget)theEObject;
			T result = caseVVTarget(vvTarget);
			if(result == null)
				result = caseTraceableSpecification(vvTarget);
			if(result == null)
				result = caseEAPackageableElement(vvTarget);
			if(result == null)
				result = caseEAElement(vvTarget);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VerificationvalidationPackage.VV_LOG:
		{
			VVLog vvLog = (VVLog)theEObject;
			T result = caseVVLog(vvLog);
			if(result == null)
				result = caseTraceableSpecification(vvLog);
			if(result == null)
				result = caseEAPackageableElement(vvLog);
			if(result == null)
				result = caseEAElement(vvLog);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VerificationvalidationPackage.VV_PROCEDURE:
		{
			VVProcedure vvProcedure = (VVProcedure)theEObject;
			T result = caseVVProcedure(vvProcedure);
			if(result == null)
				result = caseTraceableSpecification(vvProcedure);
			if(result == null)
				result = caseEAPackageableElement(vvProcedure);
			if(result == null)
				result = caseEAElement(vvProcedure);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VerificationvalidationPackage.VERIFICATION_VALIDATION:
		{
			VerificationValidation verificationValidation = (VerificationValidation)theEObject;
			T result = caseVerificationValidation(verificationValidation);
			if(result == null)
				result = caseContext(verificationValidation);
			if(result == null)
				result = caseEAElement(verificationValidation);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VerificationvalidationPackage.VERIFY:
		{
			Verify verify = (Verify)theEObject;
			T result = caseVerify(verify);
			if(result == null)
				result = caseRequirementsRelationship(verify);
			if(result == null)
				result = caseRequirements_Verify(verify);
			if(result == null)
				result = caseRelationship(verify);
			if(result == null)
				result = caseTrace(verify);
			if(result == null)
				result = caseEAElement(verify);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VV Stimuli</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VV Stimuli</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVVStimuli(VVStimuli object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VV Intended Outcome</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VV Intended Outcome</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVVIntendedOutcome(VVIntendedOutcome object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VV Actual Outcome</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VV Actual Outcome</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVVActualOutcome(VVActualOutcome object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VV Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VV Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVVCase(VVCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VV Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VV Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVVTarget(VVTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VV Log</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VV Log</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVVLog(VVLog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VV Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VV Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVVProcedure(VVProcedure object) {
		return null;
	}

} //VerificationvalidationSwitch
