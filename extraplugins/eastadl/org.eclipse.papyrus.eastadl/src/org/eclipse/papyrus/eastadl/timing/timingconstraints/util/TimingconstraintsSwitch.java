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
package org.eclipse.papyrus.eastadl.timing.timingconstraints.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.timing.TimingConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.*;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.AgeTimingConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.OutputSynchronizationConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.ReactionConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage;


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
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage
 * @generated
 */
public class TimingconstraintsSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static TimingconstraintsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimingconstraintsSwitch() {
		if(modelPackage == null) {
			modelPackage = TimingconstraintsPackage.eINSTANCE;
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
	 * Returns the result of interpreting the object as an instance of '<em>Age Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Age Timing Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAgeTimingConstraint(AgeTimingConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arbitrary Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arbitrary Event Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArbitraryEventConstraint(ArbitraryEventConstraint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Delay Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delay Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelayConstraint(DelayConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventConstraint(EventConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Synchronization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Synchronization Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputSynchronizationConstraint(InputSynchronizationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Synchronization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Synchronization Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputSynchronizationConstraint(OutputSynchronizationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Event Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternEventConstraint(PatternEventConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Periodic Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Periodic Event Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePeriodicEventConstraint(PeriodicEventConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reaction Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReactionConstraint(ReactionConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sporadic Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sporadic Event Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSporadicEventConstraint(SporadicEventConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimingConstraint(TimingConstraint object) {
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
		case TimingconstraintsPackage.DELAY_CONSTRAINT:
		{
			DelayConstraint delayConstraint = (DelayConstraint)theEObject;
			T result = caseDelayConstraint(delayConstraint);
			if(result == null)
				result = caseTimingConstraint(delayConstraint);
			if(result == null)
				result = caseEAElement(delayConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TimingconstraintsPackage.AGE_TIMING_CONSTRAINT:
		{
			AgeTimingConstraint ageTimingConstraint = (AgeTimingConstraint)theEObject;
			T result = caseAgeTimingConstraint(ageTimingConstraint);
			if(result == null)
				result = caseDelayConstraint(ageTimingConstraint);
			if(result == null)
				result = caseTimingConstraint(ageTimingConstraint);
			if(result == null)
				result = caseEAElement(ageTimingConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TimingconstraintsPackage.EVENT_CONSTRAINT:
		{
			EventConstraint eventConstraint = (EventConstraint)theEObject;
			T result = caseEventConstraint(eventConstraint);
			if(result == null)
				result = caseTimingConstraint(eventConstraint);
			if(result == null)
				result = caseEAElement(eventConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TimingconstraintsPackage.INPUT_SYNCHRONIZATION_CONSTRAINT:
		{
			InputSynchronizationConstraint inputSynchronizationConstraint = (InputSynchronizationConstraint)theEObject;
			T result = caseInputSynchronizationConstraint(inputSynchronizationConstraint);
			if(result == null)
				result = caseAgeTimingConstraint(inputSynchronizationConstraint);
			if(result == null)
				result = caseDelayConstraint(inputSynchronizationConstraint);
			if(result == null)
				result = caseTimingConstraint(inputSynchronizationConstraint);
			if(result == null)
				result = caseEAElement(inputSynchronizationConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TimingconstraintsPackage.OUTPUT_SYNCHRONIZATION_CONSTRAINT:
		{
			OutputSynchronizationConstraint outputSynchronizationConstraint = (OutputSynchronizationConstraint)theEObject;
			T result = caseOutputSynchronizationConstraint(outputSynchronizationConstraint);
			if(result == null)
				result = caseReactionConstraint(outputSynchronizationConstraint);
			if(result == null)
				result = caseDelayConstraint(outputSynchronizationConstraint);
			if(result == null)
				result = caseTimingConstraint(outputSynchronizationConstraint);
			if(result == null)
				result = caseEAElement(outputSynchronizationConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TimingconstraintsPackage.REACTION_CONSTRAINT:
		{
			ReactionConstraint reactionConstraint = (ReactionConstraint)theEObject;
			T result = caseReactionConstraint(reactionConstraint);
			if(result == null)
				result = caseDelayConstraint(reactionConstraint);
			if(result == null)
				result = caseTimingConstraint(reactionConstraint);
			if(result == null)
				result = caseEAElement(reactionConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT:
		{
			SporadicEventConstraint sporadicEventConstraint = (SporadicEventConstraint)theEObject;
			T result = caseSporadicEventConstraint(sporadicEventConstraint);
			if(result == null)
				result = caseEventConstraint(sporadicEventConstraint);
			if(result == null)
				result = caseTimingConstraint(sporadicEventConstraint);
			if(result == null)
				result = caseEAElement(sporadicEventConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TimingconstraintsPackage.PERIODIC_EVENT_CONSTRAINT:
		{
			PeriodicEventConstraint periodicEventConstraint = (PeriodicEventConstraint)theEObject;
			T result = casePeriodicEventConstraint(periodicEventConstraint);
			if(result == null)
				result = caseEventConstraint(periodicEventConstraint);
			if(result == null)
				result = caseTimingConstraint(periodicEventConstraint);
			if(result == null)
				result = caseEAElement(periodicEventConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT:
		{
			PatternEventConstraint patternEventConstraint = (PatternEventConstraint)theEObject;
			T result = casePatternEventConstraint(patternEventConstraint);
			if(result == null)
				result = caseEventConstraint(patternEventConstraint);
			if(result == null)
				result = caseTimingConstraint(patternEventConstraint);
			if(result == null)
				result = caseEAElement(patternEventConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT:
		{
			ArbitraryEventConstraint arbitraryEventConstraint = (ArbitraryEventConstraint)theEObject;
			T result = caseArbitraryEventConstraint(arbitraryEventConstraint);
			if(result == null)
				result = caseEventConstraint(arbitraryEventConstraint);
			if(result == null)
				result = caseTimingConstraint(arbitraryEventConstraint);
			if(result == null)
				result = caseEAElement(arbitraryEventConstraint);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

} //TimingconstraintsSwitch
