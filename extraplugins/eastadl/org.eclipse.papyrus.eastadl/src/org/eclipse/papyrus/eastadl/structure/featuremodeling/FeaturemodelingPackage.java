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
package org.eclipse.papyrus.eastadl.structure.featuremodeling;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;


/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc --> This subprofile describes the orthogonal feature
 * modeling that is needed for the VFM and the artifacts.
 * 
 * Overview: This subprofile describes the orthogonal feature modeling that is needed for the VFM
 * and the artifacts. <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingFactory
 * @model kind="package"
 * @generated
 */
public interface FeaturemodelingPackage extends EPackage {

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureModelImpl <em>Feature Model</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureModelImpl
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureModel()
		 * @generated
		 */
		EClass FEATURE_MODEL = eINSTANCE.getFeatureModel();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_MODEL__BASE_PACKAGE = eINSTANCE.getFeatureModel_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_MODEL__BASE_CLASS = eINSTANCE.getFeatureModel_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Root Feature</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_MODEL__ROOT_FEATURE = eINSTANCE.getFeatureModel_RootFeature();

		/**
		 * The meta object literal for the '<em><b>Feature Link</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_MODEL__FEATURE_LINK = eINSTANCE.getFeatureModel_FeatureLink();

		/**
		 * The meta object literal for the '<em><b>Feature Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_MODEL__FEATURE_CONSTRAINT = eINSTANCE.getFeatureModel_FeatureConstraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl <em>Feature Link</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureLink()
		 * @generated
		 */
		EClass FEATURE_LINK = eINSTANCE.getFeatureLink();

		/**
		 * The meta object literal for the '<em><b>Is Bidirectional</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_LINK__IS_BIDIRECTIONAL = eINSTANCE.getFeatureLink_IsBidirectional();

		/**
		 * The meta object literal for the '<em><b>Custom Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_LINK__CUSTOM_TYPE = eINSTANCE.getFeatureLink_CustomType();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_LINK__BASE_DEPENDENCY = eINSTANCE.getFeatureLink_Base_Dependency();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_LINK__START = eINSTANCE.getFeatureLink_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_LINK__END = eINSTANCE.getFeatureLink_End();

		/**
		 * The meta object literal for the '<em><b>Base Association Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_LINK__BASE_ASSOCIATION_CLASS = eINSTANCE.getFeatureLink_Base_AssociationClass();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_LINK__KIND = eINSTANCE.getFeatureLink_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE__BASE_CLASS = eINSTANCE.getFeature_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE__CARDINALITY = eINSTANCE.getFeature_Cardinality();

		/**
		 * The meta object literal for the '<em><b>Required Binding Time</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__REQUIRED_BINDING_TIME = eINSTANCE.getFeature_RequiredBindingTime();

		/**
		 * The meta object literal for the '<em><b>Actual Binding Time</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__ACTUAL_BINDING_TIME = eINSTANCE.getFeature_ActualBindingTime();

		/**
		 * The meta object literal for the '<em><b>Feature Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__FEATURE_PARAMETER = eINSTANCE.getFeature_FeatureParameter();

		/**
		 * The meta object literal for the '<em><b>Child Node</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CHILD_NODE = eINSTANCE.getFeature_ChildNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureTreeNodeImpl <em>Feature Tree Node</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureTreeNodeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureTreeNode()
		 * @generated
		 */
		EClass FEATURE_TREE_NODE = eINSTANCE.getFeatureTreeNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.BindingTimeImpl <em>Binding Time</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.BindingTimeImpl
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getBindingTime()
		 * @generated
		 */
		EClass BINDING_TIME = eINSTANCE.getBindingTime();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_TIME__KIND = eINSTANCE.getBindingTime_Kind();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_TIME__BASE_CLASS = eINSTANCE.getBindingTime_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureGroupImpl
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureGroup()
		 * @generated
		 */
		EClass FEATURE_GROUP = eINSTANCE.getFeatureGroup();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_GROUP__BASE_CLASS = eINSTANCE.getFeatureGroup_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE_GROUP__CARDINALITY = eINSTANCE.getFeatureGroup_Cardinality();

		/**
		 * The meta object literal for the '<em><b>Child Feature</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_GROUP__CHILD_FEATURE = eINSTANCE.getFeatureGroup_ChildFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureConstraintImpl <em>Feature Constraint</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureConstraint()
		 * @generated
		 */
		EClass FEATURE_CONSTRAINT = eINSTANCE.getFeatureConstraint();

		/**
		 * The meta object literal for the '<em><b>Criterion</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE_CONSTRAINT__CRITERION = eINSTANCE.getFeatureConstraint_Criterion();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_CONSTRAINT__BASE_CLASS = eINSTANCE.getFeatureConstraint_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONSTRAINT__BASE_CONSTRAINT = eINSTANCE.getFeatureConstraint_Base_Constraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind <em>Binding Time Kind</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getBindingTimeKind()
		 * @generated
		 */
		EEnum BINDING_TIME_KIND = eINSTANCE.getBindingTimeKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind <em>Variability Dependency Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind
		 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getVariabilityDependencyKind()
		 * @generated
		 */
		EEnum VARIABILITY_DEPENDENCY_KIND = eINSTANCE.getVariabilityDependencyKind();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "featuremodeling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Structure/FeatureModeling/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "FeatureModeling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	FeaturemodelingPackage eINSTANCE = org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureModelImpl <em>Feature Model</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureModelImpl
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureModel()
	 * @generated
	 */
	int FEATURE_MODEL = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl <em>Feature Link</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureLink()
	 * @generated
	 */
	int FEATURE_LINK = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureTreeNodeImpl <em>Feature Tree Node</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureTreeNodeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureTreeNode()
	 * @generated
	 */
	int FEATURE_TREE_NODE = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.BindingTimeImpl <em>Binding Time</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.BindingTimeImpl
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getBindingTime()
	 * @generated
	 */
	int BINDING_TIME = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureGroupImpl
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureGroup()
	 * @generated
	 */
	int FEATURE_GROUP = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureConstraintImpl <em>Feature Constraint</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getFeatureConstraint()
	 * @generated
	 */
	int FEATURE_CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Root Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__ROOT_FEATURE = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Feature Link</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__FEATURE_LINK = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Feature Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__FEATURE_CONSTRAINT = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Feature Model</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TREE_NODE__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TREE_NODE__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_TREE_NODE__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_TREE_NODE__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_TREE_NODE__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The number of structural features of the '<em>Feature Tree Node</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_TREE_NODE_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = FEATURE_TREE_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__BASE_NAMED_ELEMENT = FEATURE_TREE_NODE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__OWNED_COMMENT = FEATURE_TREE_NODE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__TRACEABLE_SPECIFICATION = FEATURE_TREE_NODE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__OWNED_RELATIONSHIP = FEATURE_TREE_NODE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__BASE_CLASS = FEATURE_TREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CARDINALITY = FEATURE_TREE_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required Binding Time</b></em>' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIRED_BINDING_TIME = FEATURE_TREE_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Actual Binding Time</b></em>' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ACTUAL_BINDING_TIME = FEATURE_TREE_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Feature Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__FEATURE_PARAMETER = FEATURE_TREE_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Child Node</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CHILD_NODE = FEATURE_TREE_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = FEATURE_TREE_NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_TIME__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_TIME__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_TIME__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_TIME__KIND = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_TIME__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binding Time</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_TIME_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__NAME = ElementsPackage.RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__BASE_NAMED_ELEMENT = ElementsPackage.RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__OWNED_COMMENT = ElementsPackage.RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__IS_BIDIRECTIONAL = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Custom Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__CUSTOM_TYPE = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__BASE_DEPENDENCY = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__START = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__END = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Base Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__BASE_ASSOCIATION_CLASS = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK__KIND = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Feature Link</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LINK_FEATURE_COUNT = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTRAINT__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTRAINT__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTRAINT__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Criterion</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTRAINT__CRITERION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTRAINT__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTRAINT__BASE_CONSTRAINT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Feature Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTRAINT_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__NAME = FEATURE_TREE_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__BASE_NAMED_ELEMENT = FEATURE_TREE_NODE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__OWNED_COMMENT = FEATURE_TREE_NODE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__TRACEABLE_SPECIFICATION = FEATURE_TREE_NODE__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__OWNED_RELATIONSHIP = FEATURE_TREE_NODE__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__BASE_CLASS = FEATURE_TREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__CARDINALITY = FEATURE_TREE_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Child Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__CHILD_FEATURE = FEATURE_TREE_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Feature Group</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP_FEATURE_COUNT = FEATURE_TREE_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind <em>Binding Time Kind</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getBindingTimeKind()
	 * @generated
	 */
	int BINDING_TIME_KIND = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind <em>Variability Dependency Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl#getVariabilityDependencyKind()
	 * @generated
	 */
	int VARIABILITY_DEPENDENCY_KIND = 8;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime <em>Binding Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime
	 * @generated
	 */
	EClass getBindingTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime#getKind()
	 * @see #getBindingTime()
	 * @generated
	 */
	EAttribute getBindingTime_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime#getBase_Class()
	 * @see #getBindingTime()
	 * @generated
	 */
	EReference getBindingTime_Base_Class();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind <em>Binding Time Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binding Time Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind
	 * @generated
	 */
	EEnum getBindingTimeKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getBase_Class()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getActualBindingTime <em>Actual Binding Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actual Binding Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getActualBindingTime()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ActualBindingTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getCardinality()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Cardinality();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getChildNode <em>Child Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Child Node</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getChildNode()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ChildNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getFeatureParameter <em>Feature Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Parameter</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getFeatureParameter()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_FeatureParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getRequiredBindingTime <em>Required Binding Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Binding Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getRequiredBindingTime()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_RequiredBindingTime();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint <em>Feature Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint
	 * @generated
	 */
	EClass getFeatureConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getCriterion <em>Criterion</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Criterion</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getCriterion()
	 * @see #getFeatureConstraint()
	 * @generated
	 */
	EAttribute getFeatureConstraint_Criterion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getBase_Class()
	 * @see #getFeatureConstraint()
	 * @generated
	 */
	EReference getFeatureConstraint_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getBase_Constraint()
	 * @see #getFeatureConstraint()
	 * @generated
	 */
	EReference getFeatureConstraint_Base_Constraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup <em>Feature Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup
	 * @generated
	 */
	EClass getFeatureGroup();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getBase_Class()
	 * @see #getFeatureGroup()
	 * @generated
	 */
	EReference getFeatureGroup_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getCardinality()
	 * @see #getFeatureGroup()
	 * @generated
	 */
	EAttribute getFeatureGroup_Cardinality();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getChildFeature <em>Child Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Child Feature</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getChildFeature()
	 * @see #getFeatureGroup()
	 * @generated
	 */
	EReference getFeatureGroup_ChildFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink <em>Feature Link</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Link</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink
	 * @generated
	 */
	EClass getFeatureLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getCustomType <em>Custom Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getCustomType()
	 * @see #getFeatureLink()
	 * @generated
	 */
	EAttribute getFeatureLink_CustomType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getBase_Dependency()
	 * @see #getFeatureLink()
	 * @generated
	 */
	EReference getFeatureLink_Base_Dependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getEnd()
	 * @see #getFeatureLink()
	 * @generated
	 */
	EReference getFeatureLink_End();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getBase_AssociationClass <em>Base Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Association Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getBase_AssociationClass()
	 * @see #getFeatureLink()
	 * @generated
	 */
	EReference getFeatureLink_Base_AssociationClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#isIsBidirectional <em>Is Bidirectional</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Bidirectional</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#isIsBidirectional()
	 * @see #getFeatureLink()
	 * @generated
	 */
	EAttribute getFeatureLink_IsBidirectional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getKind()
	 * @see #getFeatureLink()
	 * @generated
	 */
	EAttribute getFeatureLink_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getStart()
	 * @see #getFeatureLink()
	 * @generated
	 */
	EReference getFeatureLink_Start();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel
	 * @generated
	 */
	EClass getFeatureModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getBase_Package()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Base_Package();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getBase_Class()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getFeatureConstraint <em>Feature Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Feature Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getFeatureConstraint()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_FeatureConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getFeatureLink <em>Feature Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Feature Link</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getFeatureLink()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_FeatureLink();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getRootFeature <em>Root Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Feature</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getRootFeature()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_RootFeature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FeaturemodelingFactory getFeaturemodelingFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureTreeNode <em>Feature Tree Node</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Tree Node</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureTreeNode
	 * @generated
	 */
	EClass getFeatureTreeNode();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind <em>Variability Dependency Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variability Dependency Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind
	 * @generated
	 */
	EEnum getVariabilityDependencyKind();

} // FeaturemodelingPackage
