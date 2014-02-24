/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *       Gregoire Dupe (Mia-Software) - Bug 376576 - [EFacet] Change the multiplicity of Facet::extendedFacet 
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomFactory
 * @model kind="package"
 * @generated
 */
public interface CustomPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "custom";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/emf/facet/custom/0.2.incubation/custom";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "custom";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CustomPackage eINSTANCE = org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomizationImpl <em>Customization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomizationImpl
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getCustomization()
	 * @generated
	 */
	int CUSTOMIZATION = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__EANNOTATIONS = EFacetPackage.FACET_SET__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__NAME = EFacetPackage.FACET_SET__NAME;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__NS_URI = EFacetPackage.FACET_SET__NS_URI;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__NS_PREFIX = EFacetPackage.FACET_SET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EFactory Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__EFACTORY_INSTANCE = EFacetPackage.FACET_SET__EFACTORY_INSTANCE;

	/**
	 * The feature id for the '<em><b>EClassifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__ECLASSIFIERS = EFacetPackage.FACET_SET__ECLASSIFIERS;

	/**
	 * The feature id for the '<em><b>ESubpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__ESUBPACKAGES = EFacetPackage.FACET_SET__ESUBPACKAGES;

	/**
	 * The feature id for the '<em><b>ESuper Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__ESUPER_PACKAGE = EFacetPackage.FACET_SET__ESUPER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__DOCUMENTATION = EFacetPackage.FACET_SET__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__CATEGORIES = EFacetPackage.FACET_SET__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Must Be Loaded By Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION__MUST_BE_LOADED_BY_DEFAULT = EFacetPackage.FACET_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Customization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_FEATURE_COUNT = EFacetPackage.FACET_SET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.EClassCustomizationImpl <em>EClass Customization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.EClassCustomizationImpl
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getEClassCustomization()
	 * @generated
	 */
	int ECLASS_CUSTOMIZATION = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__EANNOTATIONS = EFacetPackage.FACET__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__NAME = EFacetPackage.FACET__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__INSTANCE_CLASS_NAME = EFacetPackage.FACET__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__INSTANCE_CLASS = EFacetPackage.FACET__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__DEFAULT_VALUE = EFacetPackage.FACET__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__INSTANCE_TYPE_NAME = EFacetPackage.FACET__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__EPACKAGE = EFacetPackage.FACET__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__ETYPE_PARAMETERS = EFacetPackage.FACET__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__DOCUMENTATION = EFacetPackage.FACET__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extended Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__EXTENDED_METACLASS = EFacetPackage.FACET__EXTENDED_METACLASS;

	/**
	 * The feature id for the '<em><b>Facet Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__FACET_ELEMENTS = EFacetPackage.FACET__FACET_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Facet Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__FACET_OPERATIONS = EFacetPackage.FACET__FACET_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Conformance Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION__CONFORMANCE_TYPED_ELEMENT = EFacetPackage.FACET__CONFORMANCE_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Extended Facets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int ECLASS_CUSTOMIZATION__EXTENDED_FACETS = EFacetPackage.FACET__EXTENDED_FACETS;

	/**
	 * The number of structural features of the '<em>EClass Customization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CUSTOMIZATION_FEATURE_COUNT = EFacetPackage.FACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.FacetCustomizationImpl <em>Facet Customization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.FacetCustomizationImpl
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getFacetCustomization()
	 * @generated
	 */
	int FACET_CUSTOMIZATION = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__EANNOTATIONS = EFacetPackage.FACET__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__NAME = EFacetPackage.FACET__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__INSTANCE_CLASS_NAME = EFacetPackage.FACET__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__INSTANCE_CLASS = EFacetPackage.FACET__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__DEFAULT_VALUE = EFacetPackage.FACET__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__INSTANCE_TYPE_NAME = EFacetPackage.FACET__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__EPACKAGE = EFacetPackage.FACET__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__ETYPE_PARAMETERS = EFacetPackage.FACET__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__DOCUMENTATION = EFacetPackage.FACET__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extended Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__EXTENDED_METACLASS = EFacetPackage.FACET__EXTENDED_METACLASS;

	/**
	 * The feature id for the '<em><b>Facet Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__FACET_ELEMENTS = EFacetPackage.FACET__FACET_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Facet Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__FACET_OPERATIONS = EFacetPackage.FACET__FACET_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Conformance Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__CONFORMANCE_TYPED_ELEMENT = EFacetPackage.FACET__CONFORMANCE_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Extended Facets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int FACET_CUSTOMIZATION__EXTENDED_FACETS = EFacetPackage.FACET__EXTENDED_FACETS;

	/**
	 * The feature id for the '<em><b>Customized Facet</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION__CUSTOMIZED_FACET = EFacetPackage.FACET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Facet Customization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CUSTOMIZATION_FEATURE_COUNT = EFacetPackage.FACET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.ETypedElementSwitchQueryImpl <em>ETyped Element Switch Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.ETypedElementSwitchQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getETypedElementSwitchQuery()
	 * @generated
	 */
	int ETYPED_ELEMENT_SWITCH_QUERY = 3;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_SWITCH_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_SWITCH_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_SWITCH_QUERY__CASES = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ETyped Element Switch Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_SWITCH_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.ETypedElementCaseImpl <em>ETyped Element Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.ETypedElementCaseImpl
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getETypedElementCase()
	 * @generated
	 */
	int ETYPED_ELEMENT_CASE = 4;

	/**
	 * The feature id for the '<em><b>Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_CASE__CASE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_CASE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>ETyped Element Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_CASE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization <em>Customization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customization</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization
	 * @generated
	 */
	EClass getCustomization();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization#isMustBeLoadedByDefault <em>Must Be Loaded By Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Must Be Loaded By Default</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization#isMustBeLoadedByDefault()
	 * @see #getCustomization()
	 * @generated
	 */
	EAttribute getCustomization_MustBeLoadedByDefault();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization <em>EClass Customization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClass Customization</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization
	 * @generated
	 */
	EClass getEClassCustomization();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization <em>Facet Customization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Customization</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization
	 * @generated
	 */
	EClass getFacetCustomization();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization#getCustomizedFacet <em>Customized Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Customized Facet</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization#getCustomizedFacet()
	 * @see #getFacetCustomization()
	 * @generated
	 */
	EReference getFacetCustomization_CustomizedFacet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery <em>ETyped Element Switch Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETyped Element Switch Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery
	 * @generated
	 */
	EClass getETypedElementSwitchQuery();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery#getCases()
	 * @see #getETypedElementSwitchQuery()
	 * @generated
	 */
	EReference getETypedElementSwitchQuery_Cases();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase <em>ETyped Element Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETyped Element Case</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase
	 * @generated
	 */
	EClass getETypedElementCase();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase#getCase <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Case</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase#getCase()
	 * @see #getETypedElementCase()
	 * @generated
	 */
	EReference getETypedElementCase_Case();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase#getValue()
	 * @see #getETypedElementCase()
	 * @generated
	 */
	EReference getETypedElementCase_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CustomFactory getCustomFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomizationImpl <em>Customization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomizationImpl
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getCustomization()
		 * @generated
		 */
		EClass CUSTOMIZATION = eINSTANCE.getCustomization();

		/**
		 * The meta object literal for the '<em><b>Must Be Loaded By Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMIZATION__MUST_BE_LOADED_BY_DEFAULT = eINSTANCE.getCustomization_MustBeLoadedByDefault();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.EClassCustomizationImpl <em>EClass Customization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.EClassCustomizationImpl
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getEClassCustomization()
		 * @generated
		 */
		EClass ECLASS_CUSTOMIZATION = eINSTANCE.getEClassCustomization();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.FacetCustomizationImpl <em>Facet Customization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.FacetCustomizationImpl
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getFacetCustomization()
		 * @generated
		 */
		EClass FACET_CUSTOMIZATION = eINSTANCE.getFacetCustomization();

		/**
		 * The meta object literal for the '<em><b>Customized Facet</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_CUSTOMIZATION__CUSTOMIZED_FACET = eINSTANCE.getFacetCustomization_CustomizedFacet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.ETypedElementSwitchQueryImpl <em>ETyped Element Switch Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.ETypedElementSwitchQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getETypedElementSwitchQuery()
		 * @generated
		 */
		EClass ETYPED_ELEMENT_SWITCH_QUERY = eINSTANCE.getETypedElementSwitchQuery();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETYPED_ELEMENT_SWITCH_QUERY__CASES = eINSTANCE.getETypedElementSwitchQuery_Cases();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.ETypedElementCaseImpl <em>ETyped Element Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.ETypedElementCaseImpl
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomPackageImpl#getETypedElementCase()
		 * @generated
		 */
		EClass ETYPED_ELEMENT_CASE = eINSTANCE.getETypedElementCase();

		/**
		 * The meta object literal for the '<em><b>Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETYPED_ELEMENT_CASE__CASE = eINSTANCE.getETypedElementCase_Case();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETYPED_ELEMENT_CASE__VALUE = eINSTANCE.getETypedElementCase_Value();

	}

} //CustomPackage
