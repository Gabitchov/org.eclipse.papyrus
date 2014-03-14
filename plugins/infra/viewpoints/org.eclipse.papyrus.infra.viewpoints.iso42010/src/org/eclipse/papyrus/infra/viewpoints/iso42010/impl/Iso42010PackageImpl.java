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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Iso42010PackageImpl extends EPackageImpl implements Iso42010Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stakeholderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureViewpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concernEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureRationaleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correspondenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correspondenceRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureFrameworkEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Iso42010PackageImpl() {
		super(eNS_URI, Iso42010Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Iso42010Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Iso42010Package init() {
		if (isInited) return (Iso42010Package)EPackage.Registry.INSTANCE.getEPackage(Iso42010Package.eNS_URI);

		// Obtain or create and register package
		Iso42010PackageImpl theIso42010Package = (Iso42010PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Iso42010PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Iso42010PackageImpl());

		isInited = true;

		// Create package meta-data objects
		theIso42010Package.createPackageContents();

		// Initialize created meta-data
		theIso42010Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIso42010Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Iso42010Package.eNS_URI, theIso42010Package);
		return theIso42010Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getADElement() {
		return adElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getADElement_Name() {
		return (EAttribute)adElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getADElement_AffectedBy() {
		return (EReference)adElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureDescription() {
		return architectureDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_Stakeholders() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_Concerns() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_Viewpoints() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_Views() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_System() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_Expresses() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_Rationales() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_Correspondences() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_Rules() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDescription_Decisions() {
		return (EReference)architectureDescriptionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStakeholder() {
		return stakeholderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholder_Concerns() {
		return (EReference)stakeholderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholder_Viewpoints() {
		return (EReference)stakeholderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholder_HasInterestIn() {
		return (EReference)stakeholderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureViewpoint() {
		return architectureViewpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureViewpoint_ModelKinds() {
		return (EReference)architectureViewpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureViewpoint_Governs() {
		return (EReference)architectureViewpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureViewpoint_Frames() {
		return (EReference)architectureViewpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelKind() {
		return modelKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelKind_Governs() {
		return (EReference)modelKindEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelKind_Viewpoint() {
		return (EReference)modelKindEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureModel() {
		return architectureModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureModel_GovernedBy() {
		return (EReference)architectureModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureModel_View() {
		return (EReference)architectureModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureView() {
		return architectureViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureView_GovernedBy() {
		return (EReference)architectureViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureView_Models() {
		return (EReference)architectureViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureView_Addresses() {
		return (EReference)architectureViewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcern() {
		return concernEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcern_FramedBy() {
		return (EReference)concernEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcern_AddressedBy() {
		return (EReference)concernEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcern_Stakeholders() {
		return (EReference)concernEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcern_RaisedBy() {
		return (EReference)concernEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcern_Decisions() {
		return (EReference)concernEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystem_Name() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Stakeholders() {
		return (EReference)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Exhibits() {
		return (EReference)systemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitecture() {
		return architectureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitecture_ExhibitedIn() {
		return (EReference)architectureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureRationale() {
		return architectureRationaleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureRationale_Justifies() {
		return (EReference)architectureRationaleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrespondence() {
		return correspondenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrespondence_GovernedBy() {
		return (EReference)correspondenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrespondence_Relates() {
		return (EReference)correspondenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrespondenceRule() {
		return correspondenceRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrespondenceRule_Governs() {
		return (EReference)correspondenceRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureDecision() {
		return architectureDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDecision_JustifiedBy() {
		return (EReference)architectureDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDecision_DependsUpon() {
		return (EReference)architectureDecisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDecision_Dependents() {
		return (EReference)architectureDecisionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDecision_Raises() {
		return (EReference)architectureDecisionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDecision_PertainsTo() {
		return (EReference)architectureDecisionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureDecision_Affects() {
		return (EReference)architectureDecisionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureFramework() {
		return architectureFrameworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureFramework_Stakeholders() {
		return (EReference)architectureFrameworkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureFramework_Viewpoints() {
		return (EReference)architectureFrameworkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureFramework_Rules() {
		return (EReference)architectureFrameworkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureFramework_Concerns() {
		return (EReference)architectureFrameworkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iso42010Factory getIso42010Factory() {
		return (Iso42010Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		adElementEClass = createEClass(AD_ELEMENT);
		createEAttribute(adElementEClass, AD_ELEMENT__NAME);
		createEReference(adElementEClass, AD_ELEMENT__AFFECTED_BY);

		architectureDescriptionEClass = createEClass(ARCHITECTURE_DESCRIPTION);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__STAKEHOLDERS);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__CONCERNS);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__VIEWPOINTS);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__VIEWS);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__SYSTEM);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__EXPRESSES);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__RATIONALES);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__CORRESPONDENCES);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__RULES);
		createEReference(architectureDescriptionEClass, ARCHITECTURE_DESCRIPTION__DECISIONS);

		stakeholderEClass = createEClass(STAKEHOLDER);
		createEReference(stakeholderEClass, STAKEHOLDER__CONCERNS);
		createEReference(stakeholderEClass, STAKEHOLDER__VIEWPOINTS);
		createEReference(stakeholderEClass, STAKEHOLDER__HAS_INTEREST_IN);

		architectureViewpointEClass = createEClass(ARCHITECTURE_VIEWPOINT);
		createEReference(architectureViewpointEClass, ARCHITECTURE_VIEWPOINT__MODEL_KINDS);
		createEReference(architectureViewpointEClass, ARCHITECTURE_VIEWPOINT__GOVERNS);
		createEReference(architectureViewpointEClass, ARCHITECTURE_VIEWPOINT__FRAMES);

		modelKindEClass = createEClass(MODEL_KIND);
		createEReference(modelKindEClass, MODEL_KIND__GOVERNS);
		createEReference(modelKindEClass, MODEL_KIND__VIEWPOINT);

		architectureModelEClass = createEClass(ARCHITECTURE_MODEL);
		createEReference(architectureModelEClass, ARCHITECTURE_MODEL__GOVERNED_BY);
		createEReference(architectureModelEClass, ARCHITECTURE_MODEL__VIEW);

		architectureViewEClass = createEClass(ARCHITECTURE_VIEW);
		createEReference(architectureViewEClass, ARCHITECTURE_VIEW__GOVERNED_BY);
		createEReference(architectureViewEClass, ARCHITECTURE_VIEW__MODELS);
		createEReference(architectureViewEClass, ARCHITECTURE_VIEW__ADDRESSES);

		concernEClass = createEClass(CONCERN);
		createEReference(concernEClass, CONCERN__FRAMED_BY);
		createEReference(concernEClass, CONCERN__ADDRESSED_BY);
		createEReference(concernEClass, CONCERN__STAKEHOLDERS);
		createEReference(concernEClass, CONCERN__RAISED_BY);
		createEReference(concernEClass, CONCERN__DECISIONS);

		systemEClass = createEClass(SYSTEM);
		createEAttribute(systemEClass, SYSTEM__NAME);
		createEReference(systemEClass, SYSTEM__STAKEHOLDERS);
		createEReference(systemEClass, SYSTEM__EXHIBITS);

		architectureEClass = createEClass(ARCHITECTURE);
		createEReference(architectureEClass, ARCHITECTURE__EXHIBITED_IN);

		architectureRationaleEClass = createEClass(ARCHITECTURE_RATIONALE);
		createEReference(architectureRationaleEClass, ARCHITECTURE_RATIONALE__JUSTIFIES);

		correspondenceEClass = createEClass(CORRESPONDENCE);
		createEReference(correspondenceEClass, CORRESPONDENCE__GOVERNED_BY);
		createEReference(correspondenceEClass, CORRESPONDENCE__RELATES);

		correspondenceRuleEClass = createEClass(CORRESPONDENCE_RULE);
		createEReference(correspondenceRuleEClass, CORRESPONDENCE_RULE__GOVERNS);

		architectureDecisionEClass = createEClass(ARCHITECTURE_DECISION);
		createEReference(architectureDecisionEClass, ARCHITECTURE_DECISION__JUSTIFIED_BY);
		createEReference(architectureDecisionEClass, ARCHITECTURE_DECISION__DEPENDS_UPON);
		createEReference(architectureDecisionEClass, ARCHITECTURE_DECISION__DEPENDENTS);
		createEReference(architectureDecisionEClass, ARCHITECTURE_DECISION__RAISES);
		createEReference(architectureDecisionEClass, ARCHITECTURE_DECISION__PERTAINS_TO);
		createEReference(architectureDecisionEClass, ARCHITECTURE_DECISION__AFFECTS);

		architectureFrameworkEClass = createEClass(ARCHITECTURE_FRAMEWORK);
		createEReference(architectureFrameworkEClass, ARCHITECTURE_FRAMEWORK__STAKEHOLDERS);
		createEReference(architectureFrameworkEClass, ARCHITECTURE_FRAMEWORK__VIEWPOINTS);
		createEReference(architectureFrameworkEClass, ARCHITECTURE_FRAMEWORK__RULES);
		createEReference(architectureFrameworkEClass, ARCHITECTURE_FRAMEWORK__CONCERNS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stakeholderEClass.getESuperTypes().add(this.getADElement());
		architectureViewpointEClass.getESuperTypes().add(this.getADElement());
		modelKindEClass.getESuperTypes().add(this.getADElement());
		architectureModelEClass.getESuperTypes().add(this.getADElement());
		architectureViewEClass.getESuperTypes().add(this.getADElement());
		concernEClass.getESuperTypes().add(this.getADElement());
		architectureRationaleEClass.getESuperTypes().add(this.getADElement());
		architectureDecisionEClass.getESuperTypes().add(this.getADElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(adElementEClass, ADElement.class, "ADElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getADElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ADElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getADElement_AffectedBy(), this.getArchitectureDecision(), this.getArchitectureDecision_Affects(), "affectedBy", null, 0, -1, ADElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureDescriptionEClass, ArchitectureDescription.class, "ArchitectureDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureDescription_Stakeholders(), this.getStakeholder(), null, "stakeholders", null, 1, -1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDescription_Concerns(), this.getConcern(), null, "concerns", null, 1, -1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDescription_Viewpoints(), this.getArchitectureViewpoint(), null, "viewpoints", null, 1, -1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDescription_Views(), this.getArchitectureView(), null, "views", null, 1, -1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDescription_System(), this.getSystem(), null, "system", null, 1, 1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDescription_Expresses(), this.getArchitecture(), null, "expresses", null, 1, 1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDescription_Rationales(), this.getArchitectureRationale(), null, "rationales", null, 1, -1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDescription_Correspondences(), this.getCorrespondence(), null, "correspondences", null, 0, -1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDescription_Rules(), this.getCorrespondenceRule(), null, "rules", null, 0, -1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDescription_Decisions(), this.getArchitectureDecision(), null, "decisions", null, 0, -1, ArchitectureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stakeholderEClass, Stakeholder.class, "Stakeholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStakeholder_Concerns(), this.getConcern(), this.getConcern_Stakeholders(), "concerns", null, 1, -1, Stakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStakeholder_Viewpoints(), this.getArchitectureViewpoint(), null, "viewpoints", null, 1, -1, Stakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStakeholder_HasInterestIn(), this.getSystem(), this.getSystem_Stakeholders(), "hasInterestIn", null, 1, 1, Stakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureViewpointEClass, ArchitectureViewpoint.class, "ArchitectureViewpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureViewpoint_ModelKinds(), this.getModelKind(), this.getModelKind_Viewpoint(), "modelKinds", null, 1, -1, ArchitectureViewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureViewpoint_Governs(), this.getArchitectureView(), this.getArchitectureView_GovernedBy(), "governs", null, 1, 1, ArchitectureViewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureViewpoint_Frames(), this.getConcern(), this.getConcern_FramedBy(), "frames", null, 1, -1, ArchitectureViewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelKindEClass, ModelKind.class, "ModelKind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelKind_Governs(), this.getArchitectureModel(), this.getArchitectureModel_GovernedBy(), "governs", null, 1, -1, ModelKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelKind_Viewpoint(), this.getArchitectureViewpoint(), this.getArchitectureViewpoint_ModelKinds(), "viewpoint", null, 1, 1, ModelKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureModelEClass, ArchitectureModel.class, "ArchitectureModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureModel_GovernedBy(), this.getModelKind(), this.getModelKind_Governs(), "governedBy", null, 1, 1, ArchitectureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureModel_View(), this.getArchitectureView(), this.getArchitectureView_Models(), "view", null, 1, 1, ArchitectureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureViewEClass, ArchitectureView.class, "ArchitectureView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureView_GovernedBy(), this.getArchitectureViewpoint(), this.getArchitectureViewpoint_Governs(), "governedBy", null, 1, 1, ArchitectureView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureView_Models(), this.getArchitectureModel(), this.getArchitectureModel_View(), "models", null, 1, -1, ArchitectureView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureView_Addresses(), this.getConcern(), this.getConcern_AddressedBy(), "addresses", null, 1, -1, ArchitectureView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concernEClass, Concern.class, "Concern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConcern_FramedBy(), this.getArchitectureViewpoint(), this.getArchitectureViewpoint_Frames(), "framedBy", null, 1, -1, Concern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcern_AddressedBy(), this.getArchitectureView(), this.getArchitectureView_Addresses(), "addressedBy", null, 1, -1, Concern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcern_Stakeholders(), this.getStakeholder(), this.getStakeholder_Concerns(), "stakeholders", null, 1, -1, Concern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcern_RaisedBy(), this.getArchitectureDecision(), this.getArchitectureDecision_Raises(), "raisedBy", null, 0, -1, Concern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcern_Decisions(), this.getArchitectureDecision(), this.getArchitectureDecision_PertainsTo(), "decisions", null, 0, -1, Concern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemEClass, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystem_Name(), ecorePackage.getEString(), "name", null, 1, 1, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Stakeholders(), this.getStakeholder(), this.getStakeholder_HasInterestIn(), "stakeholders", null, 1, -1, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Exhibits(), this.getArchitecture(), this.getArchitecture_ExhibitedIn(), "exhibits", null, 1, 1, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureEClass, Architecture.class, "Architecture", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitecture_ExhibitedIn(), this.getSystem(), this.getSystem_Exhibits(), "exhibitedIn", null, 1, 1, Architecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureRationaleEClass, ArchitectureRationale.class, "ArchitectureRationale", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureRationale_Justifies(), this.getArchitectureDecision(), this.getArchitectureDecision_JustifiedBy(), "justifies", null, 1, -1, ArchitectureRationale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(correspondenceEClass, Correspondence.class, "Correspondence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorrespondence_GovernedBy(), this.getCorrespondenceRule(), this.getCorrespondenceRule_Governs(), "governedBy", null, 0, -1, Correspondence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCorrespondence_Relates(), this.getADElement(), null, "relates", null, 2, -1, Correspondence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(correspondenceRuleEClass, CorrespondenceRule.class, "CorrespondenceRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorrespondenceRule_Governs(), this.getCorrespondence(), this.getCorrespondence_GovernedBy(), "governs", null, 1, -1, CorrespondenceRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureDecisionEClass, ArchitectureDecision.class, "ArchitectureDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureDecision_JustifiedBy(), this.getArchitectureRationale(), this.getArchitectureRationale_Justifies(), "justifiedBy", null, 0, -1, ArchitectureDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDecision_DependsUpon(), this.getArchitectureDecision(), this.getArchitectureDecision_Dependents(), "dependsUpon", null, 0, -1, ArchitectureDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDecision_Dependents(), this.getArchitectureDecision(), this.getArchitectureDecision_DependsUpon(), "dependents", null, 0, -1, ArchitectureDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDecision_Raises(), this.getConcern(), this.getConcern_RaisedBy(), "raises", null, 0, -1, ArchitectureDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDecision_PertainsTo(), this.getConcern(), this.getConcern_Decisions(), "pertainsTo", null, 1, -1, ArchitectureDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureDecision_Affects(), this.getADElement(), this.getADElement_AffectedBy(), "affects", null, 1, -1, ArchitectureDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureFrameworkEClass, ArchitectureFramework.class, "ArchitectureFramework", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureFramework_Stakeholders(), this.getStakeholder(), null, "stakeholders", null, 1, -1, ArchitectureFramework.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureFramework_Viewpoints(), this.getArchitectureViewpoint(), null, "viewpoints", null, 1, -1, ArchitectureFramework.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureFramework_Rules(), this.getCorrespondenceRule(), null, "rules", null, 0, -1, ArchitectureFramework.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureFramework_Concerns(), this.getConcern(), null, "concerns", null, 1, -1, ArchitectureFramework.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Iso42010PackageImpl
