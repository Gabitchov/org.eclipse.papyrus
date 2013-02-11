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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.*;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMFactory;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommHost;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SAMFactoryImpl extends EFactoryImpl implements SAMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SAMFactory init() {
		try {
			SAMFactory theSAMFactory = (SAMFactory)EPackage.Registry.INSTANCE.getEFactory(SAMPackage.eNS_URI);
			if (theSAMFactory != null) {
				return theSAMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SAMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAMFactoryImpl() {
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
			case SAMPackage.SA_ANALYSIS_CONTEXT: return createSaAnalysisContext();
			case SAMPackage.SA_ENDTO_END_FLOW: return createSaEndtoEndFlow();
			case SAMPackage.SA_COMM_STEP: return createSaCommStep();
			case SAMPackage.SA_STEP: return createSaStep();
			case SAMPackage.SA_SHARED_RESOURCE: return createSaSharedResource();
			case SAMPackage.SA_SCHED_OBS: return createSaSchedObs();
			case SAMPackage.SA_COMM_HOST: return createSaCommHost();
			case SAMPackage.SA_EXEC_HOST: return createSaExecHost();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SAMPackage.OPTIMALLITY_CRITERION_KIND:
				return createOptimallityCriterionKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SAMPackage.OPTIMALLITY_CRITERION_KIND:
				return convertOptimallityCriterionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaAnalysisContext createSaAnalysisContext() {
		SaAnalysisContextImpl saAnalysisContext = new SaAnalysisContextImpl();
		return saAnalysisContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaEndtoEndFlow createSaEndtoEndFlow() {
		SaEndtoEndFlowImpl saEndtoEndFlow = new SaEndtoEndFlowImpl();
		return saEndtoEndFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaCommStep createSaCommStep() {
		SaCommStepImpl saCommStep = new SaCommStepImpl();
		return saCommStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaStep createSaStep() {
		SaStepImpl saStep = new SaStepImpl();
		return saStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaSharedResource createSaSharedResource() {
		SaSharedResourceImpl saSharedResource = new SaSharedResourceImpl();
		return saSharedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaSchedObs createSaSchedObs() {
		SaSchedObsImpl saSchedObs = new SaSchedObsImpl();
		return saSchedObs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaCommHost createSaCommHost() {
		SaCommHostImpl saCommHost = new SaCommHostImpl();
		return saCommHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaExecHost createSaExecHost() {
		SaExecHostImpl saExecHost = new SaExecHostImpl();
		return saExecHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimallityCriterionKind createOptimallityCriterionKindFromString(EDataType eDataType, String initialValue) {
		OptimallityCriterionKind result = OptimallityCriterionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOptimallityCriterionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAMPackage getSAMPackage() {
		return (SAMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SAMPackage getPackage() {
		return SAMPackage.eINSTANCE;
	}

} //SAMFactoryImpl
