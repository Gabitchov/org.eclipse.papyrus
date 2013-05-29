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
package org.eclipse.papyrus.eastadl.infrastructure.elements;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This section contains the UML-profile specification, specifying stereotypes in the UML-profile, defined from the metaclasses in the Infrastructure::Elements subprofile. It includes specification details for each stereotype. If the stereotype has properties, which may be referred to as tag definitions, or if the stereotype has constraints, this section also includes specification details for these properties and constraints.
 * 
 * Overview:
 * The Infrastructure::Elements subprofile of EAST-ADL2 defines general-purpose relationship constructs that may be used to model dependencies between structural constructs.
 * The purpose of the stereotypes in this subprofile is to specify rigorously ("formally") the various relationships that may exist between basic constructs.
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsFactory
 * @model kind="package"
 * @generated
 */
public interface ElementsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RelationshipImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getRelationship()
		 * @generated
		 */
		EClass RELATIONSHIP = eINSTANCE.getRelationship();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl <em>Traceable Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getTraceableSpecification()
		 * @generated
		 */
		EClass TRACEABLE_SPECIFICATION = eINSTANCE.getTraceableSpecification();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACEABLE_SPECIFICATION__NOTE = eINSTANCE.getTraceableSpecification_Note();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAPackageableElementImpl <em>EA Packageable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAPackageableElementImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getEAPackageableElement()
		 * @generated
		 */
		EClass EA_PACKAGEABLE_ELEMENT = eINSTANCE.getEAPackageableElement();

		/**
		 * The meta object literal for the '<em><b>Base Packageable Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT = eINSTANCE.getEAPackageableElement_Base_PackageableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em><b>Traceable Specification</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__TRACEABLE_SPECIFICATION = eINSTANCE.getContext_TraceableSpecification();

		/**
		 * The meta object literal for the '<em><b>Owned Relationship</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__OWNED_RELATIONSHIP = eINSTANCE.getContext_OwnedRelationship();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RealizationImpl <em>Realization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RealizationImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getRealization()
		 * @generated
		 */
		EClass REALIZATION = eINSTANCE.getRealization();

		/**
		 * The meta object literal for the '<em><b>Realized</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZATION__REALIZED = eINSTANCE.getRealization_Realized();

		/**
		 * The meta object literal for the '<em><b>Realized By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZATION__REALIZED_BY = eINSTANCE.getRealization_RealizedBy();

		/**
		 * The meta object literal for the '<em><b>Base Realization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZATION__BASE_REALIZATION = eINSTANCE.getRealization_Base_Realization();

		/**
		 * The meta object literal for the '<em><b>Realized By path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZATION__REALIZED_BY_PATH = eINSTANCE.getRealization_RealizedBy_path();

		/**
		 * The meta object literal for the '<em><b>Realized path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZATION__REALIZED_PATH = eINSTANCE.getRealization_Realized_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.MultiLevelReferenceImpl <em>Multi Level Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.MultiLevelReferenceImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getMultiLevelReference()
		 * @generated
		 */
		EClass MULTI_LEVEL_REFERENCE = eINSTANCE.getMultiLevelReference();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_LEVEL_REFERENCE__BASE_DEPENDENCY = eINSTANCE.getMultiLevelReference_Base_Dependency();

		/**
		 * The meta object literal for the '<em><b>Referring</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_LEVEL_REFERENCE__REFERRING = eINSTANCE.getMultiLevelReference_Referring();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_LEVEL_REFERENCE__REFERENCE = eINSTANCE.getMultiLevelReference_Reference();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RationaleImpl <em>Rationale</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RationaleImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getRationale()
		 * @generated
		 */
		EClass RATIONALE = eINSTANCE.getRationale();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAPackageImpl <em>EA Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAPackageImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getEAPackage()
		 * @generated
		 */
		EClass EA_PACKAGE = eINSTANCE.getEAPackage();

		/**
		 * The meta object literal for the '<em><b>Sub Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EA_PACKAGE__SUB_PACKAGES = eINSTANCE.getEAPackage_SubPackages();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EA_PACKAGE__ELEMENT = eINSTANCE.getEAPackage_Element();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EA_PACKAGE__BASE_PACKAGE = eINSTANCE.getEAPackage_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.CommentImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__BODY = eINSTANCE.getComment_Body();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT__BASE_COMMENT = eINSTANCE.getComment_Base_Comment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl <em>EA Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getEAElement()
		 * @generated
		 */
		EClass EA_ELEMENT = eINSTANCE.getEAElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EA_ELEMENT__NAME = eINSTANCE.getEAElement_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Comment</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EA_ELEMENT__OWNED_COMMENT = eINSTANCE.getEAElement_OwnedComment();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EA_ELEMENT__BASE_NAMED_ELEMENT = eINSTANCE.getEAElement_Base_NamedElement();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "elements";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Infrastructure/Elements/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Elements";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ElementsPackage eINSTANCE = org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl <em>EA Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getEAElement()
	 * @generated
	 */
	int EA_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_ELEMENT__BASE_NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_ELEMENT__OWNED_COMMENT = 2;

	/**
	 * The number of structural features of the '<em>EA Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAPackageableElementImpl <em>EA Packageable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAPackageableElementImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getEAPackageableElement()
	 * @generated
	 */
	int EA_PACKAGEABLE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGEABLE_ELEMENT__NAME = EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGEABLE_ELEMENT__BASE_NAMED_ELEMENT = EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGEABLE_ELEMENT__OWNED_COMMENT = EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT = EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EA Packageable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGEABLE_ELEMENT_FEATURE_COUNT = EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RelationshipImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getRelationship()
	 * @generated
	 */
	int RELATIONSHIP = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl <em>Traceable Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getTraceableSpecification()
	 * @generated
	 */
	int TRACEABLE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABLE_SPECIFICATION__NAME = EA_PACKAGEABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT = EA_PACKAGEABLE_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABLE_SPECIFICATION__OWNED_COMMENT = EA_PACKAGEABLE_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT = EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABLE_SPECIFICATION__NOTE = EA_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Traceable Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABLE_SPECIFICATION_FEATURE_COUNT = EA_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__NAME = EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__BASE_NAMED_ELEMENT = EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__OWNED_COMMENT = EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_FEATURE_COUNT = EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RealizationImpl <em>Realization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RealizationImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getRealization()
	 * @generated
	 */
	int REALIZATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION__NAME = RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION__BASE_NAMED_ELEMENT = RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION__OWNED_COMMENT = RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Realized</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION__REALIZED = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION__REALIZED_BY = RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Realization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION__BASE_REALIZATION = RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Realized By path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION__REALIZED_BY_PATH = RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Realized path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION__REALIZED_PATH = RELATIONSHIP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Realization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__BASE_NAMED_ELEMENT = EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__OWNED_COMMENT = EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__TRACEABLE_SPECIFICATION = EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__OWNED_RELATIONSHIP = EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.MultiLevelReferenceImpl <em>Multi Level Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.MultiLevelReferenceImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getMultiLevelReference()
	 * @generated
	 */
	int MULTI_LEVEL_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LEVEL_REFERENCE__NAME = RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LEVEL_REFERENCE__BASE_NAMED_ELEMENT = RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LEVEL_REFERENCE__OWNED_COMMENT = RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LEVEL_REFERENCE__BASE_DEPENDENCY = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LEVEL_REFERENCE__REFERRING = RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LEVEL_REFERENCE__REFERENCE = RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Level Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LEVEL_REFERENCE_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RationaleImpl <em>Rationale</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RationaleImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getRationale()
	 * @generated
	 */
	int RATIONALE = 6;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIONALE__BASE_COMMENT = ModelelementsPackage.RATIONALE__BASE_COMMENT;

	/**
	 * The number of structural features of the '<em>Rationale</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIONALE_FEATURE_COUNT = ModelelementsPackage.RATIONALE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAPackageImpl <em>EA Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAPackageImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getEAPackage()
	 * @generated
	 */
	int EA_PACKAGE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGE__NAME = EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGE__BASE_NAMED_ELEMENT = EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGE__OWNED_COMMENT = EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Sub Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGE__SUB_PACKAGES = EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGE__ELEMENT = EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGE__BASE_PACKAGE = EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EA Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EA_PACKAGE_FEATURE_COUNT = EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.CommentImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 8;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__BODY = 0;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__BASE_COMMENT = 1;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Context#getOwnedRelationship <em>Owned Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Owned Relationship</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Context#getOwnedRelationship()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_OwnedRelationship();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Context#getTraceableSpecification <em>Traceable Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Traceable Specification</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Context#getTraceableSpecification()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_TraceableSpecification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ElementsFactory getElementsFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.MultiLevelReference <em>Multi Level Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Level Reference</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.MultiLevelReference
	 * @generated
	 */
	EClass getMultiLevelReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.MultiLevelReference#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.MultiLevelReference#getBase_Dependency()
	 * @see #getMultiLevelReference()
	 * @generated
	 */
	EReference getMultiLevelReference_Base_Dependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.MultiLevelReference#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.MultiLevelReference#getReference()
	 * @see #getMultiLevelReference()
	 * @generated
	 */
	EReference getMultiLevelReference_Reference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Rationale <em>Rationale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rationale</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Rationale
	 * @generated
	 */
	EClass getRationale();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackage <em>EA Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EA Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackage
	 * @generated
	 */
	EClass getEAPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackage#getSubPackages <em>Sub Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Packages</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackage#getSubPackages()
	 * @see #getEAPackage()
	 * @generated
	 */
	EReference getEAPackage_SubPackages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackage#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackage#getElement()
	 * @see #getEAPackage()
	 * @generated
	 */
	EReference getEAPackage_Element();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackage#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackage#getBase_Package()
	 * @see #getEAPackage()
	 * @generated
	 */
	EReference getEAPackage_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Comment#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Comment#getBody()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Body();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Comment#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Comment#getBase_Comment()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_Base_Comment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement <em>EA Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EA Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement
	 * @generated
	 */
	EClass getEAElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement#getName()
	 * @see #getEAElement()
	 * @generated
	 */
	EAttribute getEAElement_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement#getBase_NamedElement()
	 * @see #getEAElement()
	 * @generated
	 */
	EReference getEAElement_Base_NamedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement#getOwnedComment <em>Owned Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Owned Comment</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement#getOwnedComment()
	 * @see #getEAElement()
	 * @generated
	 */
	EReference getEAElement_OwnedComment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.MultiLevelReference#getReferring <em>Referring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referring</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.MultiLevelReference#getReferring()
	 * @see #getMultiLevelReference()
	 * @generated
	 */
	EReference getMultiLevelReference_Referring();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization <em>Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realization</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Realization
	 * @generated
	 */
	EClass getRealization();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealized <em>Realized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealized()
	 * @see #getRealization()
	 * @generated
	 */
	EReference getRealization_Realized();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealizedBy <em>Realized By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized By</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealizedBy()
	 * @see #getRealization()
	 * @generated
	 */
	EReference getRealization_RealizedBy();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getBase_Realization <em>Base Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Realization</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getBase_Realization()
	 * @see #getRealization()
	 * @generated
	 */
	EReference getRealization_Base_Realization();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealizedBy_path <em>Realized By path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized By path</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealizedBy_path()
	 * @see #getRealization()
	 * @generated
	 */
	EReference getRealization_RealizedBy_path();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealized_path <em>Realized path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized path</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealized_path()
	 * @see #getRealization()
	 * @generated
	 */
	EReference getRealization_Realized_path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification <em>Traceable Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traceable Specification</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification
	 * @generated
	 */
	EClass getTraceableSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification#getNote()
	 * @see #getTraceableSpecification()
	 * @generated
	 */
	EAttribute getTraceableSpecification_Note();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement <em>EA Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EA Packageable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement
	 * @generated
	 */
	EClass getEAPackageableElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement#getBase_PackageableElement <em>Base Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Packageable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement#getBase_PackageableElement()
	 * @see #getEAPackageableElement()
	 * @generated
	 */
	EReference getEAPackageableElement_Base_PackageableElement();

} //ElementsPackage
