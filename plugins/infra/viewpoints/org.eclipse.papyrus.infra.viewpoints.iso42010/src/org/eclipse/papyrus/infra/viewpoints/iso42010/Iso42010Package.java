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
package org.eclipse.papyrus.infra.viewpoints.iso42010;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Factory
 * @model kind="package"
 * @generated
 */
public interface Iso42010Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "iso42010";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/viewpoints/iso42010";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "iso42010";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Iso42010Package eINSTANCE = org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ADElementImpl <em>AD Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ADElementImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getADElement()
	 * @generated
	 */
	int AD_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT__AFFECTED_BY = 1;

	/**
	 * The number of structural features of the '<em>AD Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>AD Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl <em>Architecture Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureDescription()
	 * @generated
	 */
	int ARCHITECTURE_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__STAKEHOLDERS = 0;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__CONCERNS = 1;

	/**
	 * The feature id for the '<em><b>Viewpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__VIEWPOINTS = 2;

	/**
	 * The feature id for the '<em><b>Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__VIEWS = 3;

	/**
	 * The feature id for the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__SYSTEM = 4;

	/**
	 * The feature id for the '<em><b>Expresses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__EXPRESSES = 5;

	/**
	 * The feature id for the '<em><b>Rationales</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__RATIONALES = 6;

	/**
	 * The feature id for the '<em><b>Correspondences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__CORRESPONDENCES = 7;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__RULES = 8;

	/**
	 * The feature id for the '<em><b>Decisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__DECISIONS = 9;

	/**
	 * The number of structural features of the '<em>Architecture Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Architecture Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.StakeholderImpl <em>Stakeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.StakeholderImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getStakeholder()
	 * @generated
	 */
	int STAKEHOLDER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__AFFECTED_BY = AD_ELEMENT__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__CONCERNS = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Viewpoints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__VIEWPOINTS = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Interest In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__HAS_INTEREST_IN = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stakeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Stakeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewpointImpl <em>Architecture Viewpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewpointImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureViewpoint()
	 * @generated
	 */
	int ARCHITECTURE_VIEWPOINT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__AFFECTED_BY = AD_ELEMENT__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Model Kinds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__MODEL_KINDS = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Governs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__GOVERNS = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Frames</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__FRAMES = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Architecture Viewpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Architecture Viewpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ModelKindImpl <em>Model Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ModelKindImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getModelKind()
	 * @generated
	 */
	int MODEL_KIND = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_KIND__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_KIND__AFFECTED_BY = AD_ELEMENT__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Governs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_KIND__GOVERNS = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Viewpoint</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_KIND__VIEWPOINT = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_KIND_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Model Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_KIND_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureModelImpl <em>Architecture Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureModelImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureModel()
	 * @generated
	 */
	int ARCHITECTURE_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_MODEL__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_MODEL__AFFECTED_BY = AD_ELEMENT__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Governed By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_MODEL__GOVERNED_BY = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>View</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_MODEL__VIEW = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Architecture Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_MODEL_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Architecture Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_MODEL_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewImpl <em>Architecture View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureView()
	 * @generated
	 */
	int ARCHITECTURE_VIEW = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEW__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEW__AFFECTED_BY = AD_ELEMENT__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Governed By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEW__GOVERNED_BY = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEW__MODELS = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Addresses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEW__ADDRESSES = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Architecture View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEW_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Architecture View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEW_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ConcernImpl <em>Concern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ConcernImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getConcern()
	 * @generated
	 */
	int CONCERN = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__AFFECTED_BY = AD_ELEMENT__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Framed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__FRAMED_BY = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Addressed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__ADDRESSED_BY = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__STAKEHOLDERS = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Raised By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__RAISED_BY = AD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Decisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__DECISIONS = AD_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.SystemImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__STAKEHOLDERS = 1;

	/**
	 * The feature id for the '<em><b>Exhibits</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__EXHIBITS = 2;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureImpl <em>Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitecture()
	 * @generated
	 */
	int ARCHITECTURE = 9;

	/**
	 * The feature id for the '<em><b>Exhibited In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__EXHIBITED_IN = 0;

	/**
	 * The number of structural features of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureRationaleImpl <em>Architecture Rationale</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureRationaleImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureRationale()
	 * @generated
	 */
	int ARCHITECTURE_RATIONALE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RATIONALE__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RATIONALE__AFFECTED_BY = AD_ELEMENT__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Justifies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RATIONALE__JUSTIFIES = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Architecture Rationale</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RATIONALE_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Architecture Rationale</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RATIONALE_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceImpl <em>Correspondence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getCorrespondence()
	 * @generated
	 */
	int CORRESPONDENCE = 11;

	/**
	 * The feature id for the '<em><b>Governed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__GOVERNED_BY = 0;

	/**
	 * The feature id for the '<em><b>Relates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__RELATES = 1;

	/**
	 * The number of structural features of the '<em>Correspondence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Correspondence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceRuleImpl <em>Correspondence Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceRuleImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getCorrespondenceRule()
	 * @generated
	 */
	int CORRESPONDENCE_RULE = 12;

	/**
	 * The feature id for the '<em><b>Governs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE_RULE__GOVERNS = 0;

	/**
	 * The number of structural features of the '<em>Correspondence Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE_RULE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Correspondence Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl <em>Architecture Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureDecision()
	 * @generated
	 */
	int ARCHITECTURE_DECISION = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION__AFFECTED_BY = AD_ELEMENT__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Justified By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION__JUSTIFIED_BY = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Depends Upon</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION__DEPENDS_UPON = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION__DEPENDENTS = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Raises</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION__RAISES = AD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Pertains To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION__PERTAINS_TO = AD_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION__AFFECTS = AD_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Architecture Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Architecture Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DECISION_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureFrameworkImpl <em>Architecture Framework</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureFrameworkImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureFramework()
	 * @generated
	 */
	int ARCHITECTURE_FRAMEWORK = 14;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__STAKEHOLDERS = 0;

	/**
	 * The feature id for the '<em><b>Viewpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__VIEWPOINTS = 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__RULES = 2;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__CONCERNS = 3;

	/**
	 * The number of structural features of the '<em>Architecture Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Architecture Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement <em>AD Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AD Element</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement
	 * @generated
	 */
	EClass getADElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement#getName()
	 * @see #getADElement()
	 * @generated
	 */
	EAttribute getADElement_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement#getAffectedBy <em>Affected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Affected By</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement#getAffectedBy()
	 * @see #getADElement()
	 * @generated
	 */
	EReference getADElement_AffectedBy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription <em>Architecture Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Description</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription
	 * @generated
	 */
	EClass getArchitectureDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stakeholders</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getStakeholders()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_Stakeholders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concerns</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getConcerns()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_Concerns();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getViewpoints <em>Viewpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Viewpoints</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getViewpoints()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_Viewpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getViews()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_Views();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getSystem()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_System();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getExpresses <em>Expresses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expresses</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getExpresses()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_Expresses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getRationales <em>Rationales</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rationales</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getRationales()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_Rationales();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getCorrespondences <em>Correspondences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Correspondences</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getCorrespondences()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_Correspondences();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getRules()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_Rules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getDecisions <em>Decisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decisions</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getDecisions()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EReference getArchitectureDescription_Decisions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder <em>Stakeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stakeholder</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder
	 * @generated
	 */
	EClass getStakeholder();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Concerns</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getConcerns()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_Concerns();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getViewpoints <em>Viewpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Viewpoints</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getViewpoints()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_Viewpoints();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getHasInterestIn <em>Has Interest In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Has Interest In</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getHasInterestIn()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_HasInterestIn();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint <em>Architecture Viewpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Viewpoint</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint
	 * @generated
	 */
	EClass getArchitectureViewpoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getModelKinds <em>Model Kinds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Kinds</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getModelKinds()
	 * @see #getArchitectureViewpoint()
	 * @generated
	 */
	EReference getArchitectureViewpoint_ModelKinds();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getGoverns <em>Governs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Governs</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getGoverns()
	 * @see #getArchitectureViewpoint()
	 * @generated
	 */
	EReference getArchitectureViewpoint_Governs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getFrames <em>Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Frames</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getFrames()
	 * @see #getArchitectureViewpoint()
	 * @generated
	 */
	EReference getArchitectureViewpoint_Frames();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind <em>Model Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Kind</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind
	 * @generated
	 */
	EClass getModelKind();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getGoverns <em>Governs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Governs</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getGoverns()
	 * @see #getModelKind()
	 * @generated
	 */
	EReference getModelKind_Governs();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getViewpoint <em>Viewpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Viewpoint</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getViewpoint()
	 * @see #getModelKind()
	 * @generated
	 */
	EReference getModelKind_Viewpoint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel <em>Architecture Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Model</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel
	 * @generated
	 */
	EClass getArchitectureModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getGovernedBy <em>Governed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Governed By</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getGovernedBy()
	 * @see #getArchitectureModel()
	 * @generated
	 */
	EReference getArchitectureModel_GovernedBy();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>View</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getView()
	 * @see #getArchitectureModel()
	 * @generated
	 */
	EReference getArchitectureModel_View();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView <em>Architecture View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture View</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView
	 * @generated
	 */
	EClass getArchitectureView();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getGovernedBy <em>Governed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Governed By</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getGovernedBy()
	 * @see #getArchitectureView()
	 * @generated
	 */
	EReference getArchitectureView_GovernedBy();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getModels()
	 * @see #getArchitectureView()
	 * @generated
	 */
	EReference getArchitectureView_Models();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getAddresses <em>Addresses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Addresses</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getAddresses()
	 * @see #getArchitectureView()
	 * @generated
	 */
	EReference getArchitectureView_Addresses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern <em>Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concern</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern
	 * @generated
	 */
	EClass getConcern();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getFramedBy <em>Framed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Framed By</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getFramedBy()
	 * @see #getConcern()
	 * @generated
	 */
	EReference getConcern_FramedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getAddressedBy <em>Addressed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Addressed By</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getAddressedBy()
	 * @see #getConcern()
	 * @generated
	 */
	EReference getConcern_AddressedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stakeholders</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getStakeholders()
	 * @see #getConcern()
	 * @generated
	 */
	EReference getConcern_Stakeholders();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getRaisedBy <em>Raised By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Raised By</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getRaisedBy()
	 * @see #getConcern()
	 * @generated
	 */
	EReference getConcern_RaisedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getDecisions <em>Decisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Decisions</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getDecisions()
	 * @see #getConcern()
	 * @generated
	 */
	EReference getConcern_Decisions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.System#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.System#getName()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.System#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stakeholders</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.System#getStakeholders()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Stakeholders();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.System#getExhibits <em>Exhibits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exhibits</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.System#getExhibits()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Exhibits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Architecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Architecture
	 * @generated
	 */
	EClass getArchitecture();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Architecture#getExhibitedIn <em>Exhibited In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exhibited In</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Architecture#getExhibitedIn()
	 * @see #getArchitecture()
	 * @generated
	 */
	EReference getArchitecture_ExhibitedIn();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale <em>Architecture Rationale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Rationale</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale
	 * @generated
	 */
	EClass getArchitectureRationale();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale#getJustifies <em>Justifies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Justifies</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale#getJustifies()
	 * @see #getArchitectureRationale()
	 * @generated
	 */
	EReference getArchitectureRationale_Justifies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence <em>Correspondence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Correspondence</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence
	 * @generated
	 */
	EClass getCorrespondence();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence#getGovernedBy <em>Governed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Governed By</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence#getGovernedBy()
	 * @see #getCorrespondence()
	 * @generated
	 */
	EReference getCorrespondence_GovernedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence#getRelates <em>Relates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relates</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence#getRelates()
	 * @see #getCorrespondence()
	 * @generated
	 */
	EReference getCorrespondence_Relates();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule <em>Correspondence Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Correspondence Rule</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule
	 * @generated
	 */
	EClass getCorrespondenceRule();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule#getGoverns <em>Governs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Governs</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule#getGoverns()
	 * @see #getCorrespondenceRule()
	 * @generated
	 */
	EReference getCorrespondenceRule_Governs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision <em>Architecture Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Decision</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision
	 * @generated
	 */
	EClass getArchitectureDecision();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getJustifiedBy <em>Justified By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Justified By</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getJustifiedBy()
	 * @see #getArchitectureDecision()
	 * @generated
	 */
	EReference getArchitectureDecision_JustifiedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependsUpon <em>Depends Upon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends Upon</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependsUpon()
	 * @see #getArchitectureDecision()
	 * @generated
	 */
	EReference getArchitectureDecision_DependsUpon();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependents <em>Dependents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependents</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependents()
	 * @see #getArchitectureDecision()
	 * @generated
	 */
	EReference getArchitectureDecision_Dependents();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getRaises <em>Raises</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Raises</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getRaises()
	 * @see #getArchitectureDecision()
	 * @generated
	 */
	EReference getArchitectureDecision_Raises();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getPertainsTo <em>Pertains To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Pertains To</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getPertainsTo()
	 * @see #getArchitectureDecision()
	 * @generated
	 */
	EReference getArchitectureDecision_PertainsTo();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getAffects <em>Affects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Affects</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getAffects()
	 * @see #getArchitectureDecision()
	 * @generated
	 */
	EReference getArchitectureDecision_Affects();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework <em>Architecture Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Framework</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework
	 * @generated
	 */
	EClass getArchitectureFramework();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stakeholders</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework#getStakeholders()
	 * @see #getArchitectureFramework()
	 * @generated
	 */
	EReference getArchitectureFramework_Stakeholders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework#getViewpoints <em>Viewpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Viewpoints</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework#getViewpoints()
	 * @see #getArchitectureFramework()
	 * @generated
	 */
	EReference getArchitectureFramework_Viewpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework#getRules()
	 * @see #getArchitectureFramework()
	 * @generated
	 */
	EReference getArchitectureFramework_Rules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concerns</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework#getConcerns()
	 * @see #getArchitectureFramework()
	 * @generated
	 */
	EReference getArchitectureFramework_Concerns();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Iso42010Factory getIso42010Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ADElementImpl <em>AD Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ADElementImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getADElement()
		 * @generated
		 */
		EClass AD_ELEMENT = eINSTANCE.getADElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AD_ELEMENT__NAME = eINSTANCE.getADElement_Name();

		/**
		 * The meta object literal for the '<em><b>Affected By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AD_ELEMENT__AFFECTED_BY = eINSTANCE.getADElement_AffectedBy();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl <em>Architecture Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureDescription()
		 * @generated
		 */
		EClass ARCHITECTURE_DESCRIPTION = eINSTANCE.getArchitectureDescription();

		/**
		 * The meta object literal for the '<em><b>Stakeholders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__STAKEHOLDERS = eINSTANCE.getArchitectureDescription_Stakeholders();

		/**
		 * The meta object literal for the '<em><b>Concerns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__CONCERNS = eINSTANCE.getArchitectureDescription_Concerns();

		/**
		 * The meta object literal for the '<em><b>Viewpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__VIEWPOINTS = eINSTANCE.getArchitectureDescription_Viewpoints();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__VIEWS = eINSTANCE.getArchitectureDescription_Views();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__SYSTEM = eINSTANCE.getArchitectureDescription_System();

		/**
		 * The meta object literal for the '<em><b>Expresses</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__EXPRESSES = eINSTANCE.getArchitectureDescription_Expresses();

		/**
		 * The meta object literal for the '<em><b>Rationales</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__RATIONALES = eINSTANCE.getArchitectureDescription_Rationales();

		/**
		 * The meta object literal for the '<em><b>Correspondences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__CORRESPONDENCES = eINSTANCE.getArchitectureDescription_Correspondences();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__RULES = eINSTANCE.getArchitectureDescription_Rules();

		/**
		 * The meta object literal for the '<em><b>Decisions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION__DECISIONS = eINSTANCE.getArchitectureDescription_Decisions();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.StakeholderImpl <em>Stakeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.StakeholderImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getStakeholder()
		 * @generated
		 */
		EClass STAKEHOLDER = eINSTANCE.getStakeholder();

		/**
		 * The meta object literal for the '<em><b>Concerns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__CONCERNS = eINSTANCE.getStakeholder_Concerns();

		/**
		 * The meta object literal for the '<em><b>Viewpoints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__VIEWPOINTS = eINSTANCE.getStakeholder_Viewpoints();

		/**
		 * The meta object literal for the '<em><b>Has Interest In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__HAS_INTEREST_IN = eINSTANCE.getStakeholder_HasInterestIn();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewpointImpl <em>Architecture Viewpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewpointImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureViewpoint()
		 * @generated
		 */
		EClass ARCHITECTURE_VIEWPOINT = eINSTANCE.getArchitectureViewpoint();

		/**
		 * The meta object literal for the '<em><b>Model Kinds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_VIEWPOINT__MODEL_KINDS = eINSTANCE.getArchitectureViewpoint_ModelKinds();

		/**
		 * The meta object literal for the '<em><b>Governs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_VIEWPOINT__GOVERNS = eINSTANCE.getArchitectureViewpoint_Governs();

		/**
		 * The meta object literal for the '<em><b>Frames</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_VIEWPOINT__FRAMES = eINSTANCE.getArchitectureViewpoint_Frames();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ModelKindImpl <em>Model Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ModelKindImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getModelKind()
		 * @generated
		 */
		EClass MODEL_KIND = eINSTANCE.getModelKind();

		/**
		 * The meta object literal for the '<em><b>Governs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_KIND__GOVERNS = eINSTANCE.getModelKind_Governs();

		/**
		 * The meta object literal for the '<em><b>Viewpoint</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_KIND__VIEWPOINT = eINSTANCE.getModelKind_Viewpoint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureModelImpl <em>Architecture Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureModelImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureModel()
		 * @generated
		 */
		EClass ARCHITECTURE_MODEL = eINSTANCE.getArchitectureModel();

		/**
		 * The meta object literal for the '<em><b>Governed By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_MODEL__GOVERNED_BY = eINSTANCE.getArchitectureModel_GovernedBy();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_MODEL__VIEW = eINSTANCE.getArchitectureModel_View();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewImpl <em>Architecture View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureView()
		 * @generated
		 */
		EClass ARCHITECTURE_VIEW = eINSTANCE.getArchitectureView();

		/**
		 * The meta object literal for the '<em><b>Governed By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_VIEW__GOVERNED_BY = eINSTANCE.getArchitectureView_GovernedBy();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_VIEW__MODELS = eINSTANCE.getArchitectureView_Models();

		/**
		 * The meta object literal for the '<em><b>Addresses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_VIEW__ADDRESSES = eINSTANCE.getArchitectureView_Addresses();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ConcernImpl <em>Concern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ConcernImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getConcern()
		 * @generated
		 */
		EClass CONCERN = eINSTANCE.getConcern();

		/**
		 * The meta object literal for the '<em><b>Framed By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCERN__FRAMED_BY = eINSTANCE.getConcern_FramedBy();

		/**
		 * The meta object literal for the '<em><b>Addressed By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCERN__ADDRESSED_BY = eINSTANCE.getConcern_AddressedBy();

		/**
		 * The meta object literal for the '<em><b>Stakeholders</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCERN__STAKEHOLDERS = eINSTANCE.getConcern_Stakeholders();

		/**
		 * The meta object literal for the '<em><b>Raised By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCERN__RAISED_BY = eINSTANCE.getConcern_RaisedBy();

		/**
		 * The meta object literal for the '<em><b>Decisions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCERN__DECISIONS = eINSTANCE.getConcern_Decisions();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.SystemImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__NAME = eINSTANCE.getSystem_Name();

		/**
		 * The meta object literal for the '<em><b>Stakeholders</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__STAKEHOLDERS = eINSTANCE.getSystem_Stakeholders();

		/**
		 * The meta object literal for the '<em><b>Exhibits</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__EXHIBITS = eINSTANCE.getSystem_Exhibits();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureImpl <em>Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitecture()
		 * @generated
		 */
		EClass ARCHITECTURE = eINSTANCE.getArchitecture();

		/**
		 * The meta object literal for the '<em><b>Exhibited In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE__EXHIBITED_IN = eINSTANCE.getArchitecture_ExhibitedIn();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureRationaleImpl <em>Architecture Rationale</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureRationaleImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureRationale()
		 * @generated
		 */
		EClass ARCHITECTURE_RATIONALE = eINSTANCE.getArchitectureRationale();

		/**
		 * The meta object literal for the '<em><b>Justifies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_RATIONALE__JUSTIFIES = eINSTANCE.getArchitectureRationale_Justifies();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceImpl <em>Correspondence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getCorrespondence()
		 * @generated
		 */
		EClass CORRESPONDENCE = eINSTANCE.getCorrespondence();

		/**
		 * The meta object literal for the '<em><b>Governed By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORRESPONDENCE__GOVERNED_BY = eINSTANCE.getCorrespondence_GovernedBy();

		/**
		 * The meta object literal for the '<em><b>Relates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORRESPONDENCE__RELATES = eINSTANCE.getCorrespondence_Relates();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceRuleImpl <em>Correspondence Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceRuleImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getCorrespondenceRule()
		 * @generated
		 */
		EClass CORRESPONDENCE_RULE = eINSTANCE.getCorrespondenceRule();

		/**
		 * The meta object literal for the '<em><b>Governs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORRESPONDENCE_RULE__GOVERNS = eINSTANCE.getCorrespondenceRule_Governs();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl <em>Architecture Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureDecision()
		 * @generated
		 */
		EClass ARCHITECTURE_DECISION = eINSTANCE.getArchitectureDecision();

		/**
		 * The meta object literal for the '<em><b>Justified By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DECISION__JUSTIFIED_BY = eINSTANCE.getArchitectureDecision_JustifiedBy();

		/**
		 * The meta object literal for the '<em><b>Depends Upon</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DECISION__DEPENDS_UPON = eINSTANCE.getArchitectureDecision_DependsUpon();

		/**
		 * The meta object literal for the '<em><b>Dependents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DECISION__DEPENDENTS = eINSTANCE.getArchitectureDecision_Dependents();

		/**
		 * The meta object literal for the '<em><b>Raises</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DECISION__RAISES = eINSTANCE.getArchitectureDecision_Raises();

		/**
		 * The meta object literal for the '<em><b>Pertains To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DECISION__PERTAINS_TO = eINSTANCE.getArchitectureDecision_PertainsTo();

		/**
		 * The meta object literal for the '<em><b>Affects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DECISION__AFFECTS = eINSTANCE.getArchitectureDecision_Affects();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureFrameworkImpl <em>Architecture Framework</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureFrameworkImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010PackageImpl#getArchitectureFramework()
		 * @generated
		 */
		EClass ARCHITECTURE_FRAMEWORK = eINSTANCE.getArchitectureFramework();

		/**
		 * The meta object literal for the '<em><b>Stakeholders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_FRAMEWORK__STAKEHOLDERS = eINSTANCE.getArchitectureFramework_Stakeholders();

		/**
		 * The meta object literal for the '<em><b>Viewpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_FRAMEWORK__VIEWPOINTS = eINSTANCE.getArchitectureFramework_Viewpoints();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_FRAMEWORK__RULES = eINSTANCE.getArchitectureFramework_Rules();

		/**
		 * The meta object literal for the '<em><b>Concerns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_FRAMEWORK__CONCERNS = eINSTANCE.getArchitectureFramework_Concerns();

	}

} //Iso42010Package
