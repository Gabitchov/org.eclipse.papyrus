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
package org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.*;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.FunctionalSafetyConcept;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementFactory;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class SafetyrequirementFactoryImpl extends EFactoryImpl implements SafetyrequirementFactory {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SafetyrequirementPackage getPackage() {
		return SafetyrequirementPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SafetyrequirementFactory init() {
		try {
			SafetyrequirementFactory theSafetyrequirementFactory = (SafetyrequirementFactory)EPackage.Registry.INSTANCE.getEFactory(SafetyrequirementPackage.eNS_URI);
			if(theSafetyrequirementFactory != null) {
				return theSafetyrequirementFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SafetyrequirementFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SafetyrequirementFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case SafetyrequirementPackage.FUNCTIONAL_SAFETY_CONCEPT:
			return createFunctionalSafetyConcept();
		case SafetyrequirementPackage.SAFETY_GOAL:
			return createSafetyGoal();
		case SafetyrequirementPackage.TECHNICAL_SAFETY_CONCEPT:
			return createTechnicalSafetyConcept();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionalSafetyConcept createFunctionalSafetyConcept() {
		FunctionalSafetyConceptImpl functionalSafetyConcept = new FunctionalSafetyConceptImpl();
		return functionalSafetyConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SafetyGoal createSafetyGoal() {
		SafetyGoalImpl safetyGoal = new SafetyGoalImpl();
		return safetyGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TechnicalSafetyConcept createTechnicalSafetyConcept() {
		TechnicalSafetyConceptImpl technicalSafetyConcept = new TechnicalSafetyConceptImpl();
		return technicalSafetyConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SafetyrequirementPackage getSafetyrequirementPackage() {
		return (SafetyrequirementPackage)getEPackage();
	}

} //SafetyrequirementFactoryImpl
