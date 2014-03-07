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
package org.eclipse.papyrus.eastadl.annex.needs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.eastadl.annex.needs.*;
import org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription;
import org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalModel;
import org.eclipse.papyrus.eastadl.annex.needs.Architecture;
import org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity;
import org.eclipse.papyrus.eastadl.annex.needs.Concept;
import org.eclipse.papyrus.eastadl.annex.needs.Mission;
import org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage;
import org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement;
import org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning;
import org.eclipse.papyrus.eastadl.annex.needs.Stakeholder;
import org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed;
import org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;


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
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage
 * @generated
 */
public class NeedsSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static NeedsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NeedsSwitch() {
		if(modelPackage == null) {
			modelPackage = NeedsPackage.eINSTANCE;
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
	 * Returns the result of interpreting the object as an instance of '<em>Architectural Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Architectural Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchitecturalDescription(ArchitecturalDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Architectural Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Architectural Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchitecturalModel(ArchitecturalModel object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Architecture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchitecture(Architecture object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Opportunity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Opportunity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessOpportunity(BusinessOpportunity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcept(Concept object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mission</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mission</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMission(Mission object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Problem Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Problem Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProblemStatement(ProblemStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product Positioning</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Positioning</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProductPositioning(ProductPositioning object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stakeholder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stakeholder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStakeholder(Stakeholder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stakeholder Need</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stakeholder Need</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStakeholderNeed(StakeholderNeed object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Vehicle System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vehicle System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVehicleSystem(VehicleSystem object) {
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
		case NeedsPackage.STAKEHOLDER:
		{
			Stakeholder stakeholder = (Stakeholder)theEObject;
			T result = caseStakeholder(stakeholder);
			if(result == null)
				result = caseTraceableSpecification(stakeholder);
			if(result == null)
				result = caseEAPackageableElement(stakeholder);
			if(result == null)
				result = caseEAElement(stakeholder);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.STAKEHOLDER_NEED:
		{
			StakeholderNeed stakeholderNeed = (StakeholderNeed)theEObject;
			T result = caseStakeholderNeed(stakeholderNeed);
			if(result == null)
				result = caseTraceableSpecification(stakeholderNeed);
			if(result == null)
				result = caseEAPackageableElement(stakeholderNeed);
			if(result == null)
				result = caseEAElement(stakeholderNeed);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.PROBLEM_STATEMENT:
		{
			ProblemStatement problemStatement = (ProblemStatement)theEObject;
			T result = caseProblemStatement(problemStatement);
			if(result == null)
				result = caseTraceableSpecification(problemStatement);
			if(result == null)
				result = caseEAPackageableElement(problemStatement);
			if(result == null)
				result = caseEAElement(problemStatement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.PRODUCT_POSITIONING:
		{
			ProductPositioning productPositioning = (ProductPositioning)theEObject;
			T result = caseProductPositioning(productPositioning);
			if(result == null)
				result = caseTraceableSpecification(productPositioning);
			if(result == null)
				result = caseEAPackageableElement(productPositioning);
			if(result == null)
				result = caseEAElement(productPositioning);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.BUSINESS_OPPORTUNITY:
		{
			BusinessOpportunity businessOpportunity = (BusinessOpportunity)theEObject;
			T result = caseBusinessOpportunity(businessOpportunity);
			if(result == null)
				result = caseTraceableSpecification(businessOpportunity);
			if(result == null)
				result = caseEAPackageableElement(businessOpportunity);
			if(result == null)
				result = caseEAElement(businessOpportunity);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.CONCEPT:
		{
			Concept concept = (Concept)theEObject;
			T result = caseConcept(concept);
			if(result == null)
				result = caseEAElement(concept);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.MISSION:
		{
			Mission mission = (Mission)theEObject;
			T result = caseMission(mission);
			if(result == null)
				result = caseConcept(mission);
			if(result == null)
				result = caseEAElement(mission);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.VEHICLE_SYSTEM:
		{
			VehicleSystem vehicleSystem = (VehicleSystem)theEObject;
			T result = caseVehicleSystem(vehicleSystem);
			if(result == null)
				result = caseConcept(vehicleSystem);
			if(result == null)
				result = caseEAElement(vehicleSystem);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.ARCHITECTURE:
		{
			Architecture architecture = (Architecture)theEObject;
			T result = caseArchitecture(architecture);
			if(result == null)
				result = caseConcept(architecture);
			if(result == null)
				result = caseEAElement(architecture);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.ARCHITECTURAL_DESCRIPTION:
		{
			ArchitecturalDescription architecturalDescription = (ArchitecturalDescription)theEObject;
			T result = caseArchitecturalDescription(architecturalDescription);
			if(result == null)
				result = caseConcept(architecturalDescription);
			if(result == null)
				result = caseEAElement(architecturalDescription);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NeedsPackage.ARCHITECTURAL_MODEL:
		{
			ArchitecturalModel architecturalModel = (ArchitecturalModel)theEObject;
			T result = caseArchitecturalModel(architecturalModel);
			if(result == null)
				result = caseConcept(architecturalModel);
			if(result == null)
				result = caseEAElement(architecturalModel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

} //NeedsSwitch
