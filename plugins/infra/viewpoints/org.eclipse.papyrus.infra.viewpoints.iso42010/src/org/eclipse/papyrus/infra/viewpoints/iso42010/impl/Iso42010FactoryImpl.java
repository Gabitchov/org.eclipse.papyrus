/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.viewpoints.iso42010.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.viewpoints.iso42010.Architecture;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Concern;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence;
import org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Factory;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Iso42010FactoryImpl extends EFactoryImpl implements Iso42010Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Iso42010Factory init() {
		try {
			Iso42010Factory theIso42010Factory = (Iso42010Factory)EPackage.Registry.INSTANCE.getEFactory(Iso42010Package.eNS_URI);
			if (theIso42010Factory != null) {
				return theIso42010Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Iso42010FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iso42010FactoryImpl() {
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
			case Iso42010Package.ARCHITECTURE_DESCRIPTION: return createArchitectureDescription();
			case Iso42010Package.STAKEHOLDER: return createStakeholder();
			case Iso42010Package.ARCHITECTURE_VIEWPOINT: return createArchitectureViewpoint();
			case Iso42010Package.MODEL_KIND: return createModelKind();
			case Iso42010Package.ARCHITECTURE_MODEL: return createArchitectureModel();
			case Iso42010Package.ARCHITECTURE_VIEW: return createArchitectureView();
			case Iso42010Package.CONCERN: return createConcern();
			case Iso42010Package.SYSTEM: return createSystem();
			case Iso42010Package.ARCHITECTURE: return createArchitecture();
			case Iso42010Package.ARCHITECTURE_RATIONALE: return createArchitectureRationale();
			case Iso42010Package.CORRESPONDENCE: return createCorrespondence();
			case Iso42010Package.CORRESPONDENCE_RULE: return createCorrespondenceRule();
			case Iso42010Package.ARCHITECTURE_DECISION: return createArchitectureDecision();
			case Iso42010Package.ARCHITECTURE_FRAMEWORK: return createArchitectureFramework();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureDescription createArchitectureDescription() {
		ArchitectureDescriptionImpl architectureDescription = new ArchitectureDescriptionImpl();
		return architectureDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stakeholder createStakeholder() {
		StakeholderImpl stakeholder = new StakeholderImpl();
		return stakeholder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureViewpoint createArchitectureViewpoint() {
		ArchitectureViewpointImpl architectureViewpoint = new ArchitectureViewpointImpl();
		return architectureViewpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelKind createModelKind() {
		ModelKindImpl modelKind = new ModelKindImpl();
		return modelKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureModel createArchitectureModel() {
		ArchitectureModelImpl architectureModel = new ArchitectureModelImpl();
		return architectureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureView createArchitectureView() {
		ArchitectureViewImpl architectureView = new ArchitectureViewImpl();
		return architectureView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concern createConcern() {
		ConcernImpl concern = new ConcernImpl();
		return concern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.infra.viewpoints.iso42010.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Architecture createArchitecture() {
		ArchitectureImpl architecture = new ArchitectureImpl();
		return architecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureRationale createArchitectureRationale() {
		ArchitectureRationaleImpl architectureRationale = new ArchitectureRationaleImpl();
		return architectureRationale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Correspondence createCorrespondence() {
		CorrespondenceImpl correspondence = new CorrespondenceImpl();
		return correspondence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrespondenceRule createCorrespondenceRule() {
		CorrespondenceRuleImpl correspondenceRule = new CorrespondenceRuleImpl();
		return correspondenceRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureDecision createArchitectureDecision() {
		ArchitectureDecisionImpl architectureDecision = new ArchitectureDecisionImpl();
		return architectureDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureFramework createArchitectureFramework() {
		ArchitectureFrameworkImpl architectureFramework = new ArchitectureFrameworkImpl();
		return architectureFramework;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iso42010Package getIso42010Package() {
		return (Iso42010Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Iso42010Package getPackage() {
		return Iso42010Package.eINSTANCE;
	}

} //Iso42010FactoryImpl
