/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - add prototype reference to Context (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.contexts;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.infra.constraints.ConstraintsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.views.properties.contexts.ContextsFactory
 * @model kind="package"
 * @generated
 */
public interface ContextsPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "contexts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/properties/contexts/0.9";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "contexts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ContextsPackage eINSTANCE = org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextImpl
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__DEPENDENCIES = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tabs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__TABS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__VIEWS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Data Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__DATA_CONTEXTS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__PROTOTYPE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.TabImpl <em>Tab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.TabImpl
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getTab()
	 * @generated
	 */
	int TAB = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__ID = 1;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__CATEGORY = 2;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__IMAGE = 3;

	/**
	 * The feature id for the '<em><b>After Tab</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__AFTER_TAB = 4;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__SECTIONS = 5;

	/**
	 * The feature id for the '<em><b>Indented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__INDENTED = 6;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__PRIORITY = 7;

	/**
	 * The number of structural features of the '<em>Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ViewImpl
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CONSTRAINTS = ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Element Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ELEMENT_MULTIPLICITY = ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NAME = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__SECTIONS = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CONTEXT = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Automatic Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__AUTOMATIC_CONTEXT = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Datacontexts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__DATACONTEXTS = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.SectionImpl
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__CONSTRAINTS = ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Element Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ELEMENT_MULTIPLICITY = ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__NAME = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tab</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__TAB = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Section File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__SECTION_FILE = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__WIDGET = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.DataContextElementImpl <em>Data Context Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.DataContextElementImpl
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getDataContextElement()
	 * @generated
	 */
	int DATA_CONTEXT_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ELEMENT__PROPERTIES = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ELEMENT__PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ELEMENT__SUPERTYPES = 3;

	/**
	 * The number of structural features of the '<em>Data Context Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.PropertyImpl
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LABEL = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Context Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__CONTEXT_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__MULTIPLICITY = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESCRIPTION = 5;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.UnknownPropertyImpl <em>Unknown Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.UnknownPropertyImpl
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getUnknownProperty()
	 * @generated
	 */
	int UNKNOWN_PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_PROPERTY__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_PROPERTY__LABEL = PROPERTY__LABEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_PROPERTY__TYPE = PROPERTY__TYPE;

	/**
	 * The feature id for the '<em><b>Context Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_PROPERTY__CONTEXT_ELEMENT = PROPERTY__CONTEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_PROPERTY__MULTIPLICITY = PROPERTY__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_PROPERTY__DESCRIPTION = PROPERTY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Unknown Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.DataContextPackageImpl <em>Data Context Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.DataContextPackageImpl
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getDataContextPackage()
	 * @generated
	 */
	int DATA_CONTEXT_PACKAGE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_PACKAGE__NAME = DATA_CONTEXT_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_PACKAGE__PROPERTIES = DATA_CONTEXT_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_PACKAGE__PACKAGE = DATA_CONTEXT_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_PACKAGE__SUPERTYPES = DATA_CONTEXT_ELEMENT__SUPERTYPES;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_PACKAGE__ELEMENTS = DATA_CONTEXT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Context Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_PACKAGE_FEATURE_COUNT = DATA_CONTEXT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.DataContextRootImpl <em>Data Context Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.DataContextRootImpl
	 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getDataContextRoot()
	 * @generated
	 */
	int DATA_CONTEXT_ROOT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ROOT__NAME = DATA_CONTEXT_PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ROOT__PROPERTIES = DATA_CONTEXT_PACKAGE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ROOT__PACKAGE = DATA_CONTEXT_PACKAGE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ROOT__SUPERTYPES = DATA_CONTEXT_PACKAGE__SUPERTYPES;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ROOT__ELEMENTS = DATA_CONTEXT_PACKAGE__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ROOT__LABEL = DATA_CONTEXT_PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Element Factory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ROOT__MODEL_ELEMENT_FACTORY = DATA_CONTEXT_PACKAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Context Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_ROOT_FEATURE_COUNT = DATA_CONTEXT_PACKAGE_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.contexts.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Context#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Context#getName()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.views.properties.contexts.Context#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Context#getDependencies()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Dependencies();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.views.properties.contexts.Context#getTabs <em>Tabs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tabs</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Context#getTabs()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Tabs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.views.properties.contexts.Context#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Context#getViews()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Views();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.views.properties.contexts.Context#getDataContexts <em>Data Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Contexts</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Context#getDataContexts()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_DataContexts();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.views.properties.contexts.Context#getPrototype <em>Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prototype</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Context#getPrototype()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Prototype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.contexts.Tab <em>Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tab</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Tab
	 * @generated
	 */
	EClass getTab();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Tab#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Tab#getLabel()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Tab#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Tab#getId()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Tab#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Tab#getCategory()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Category();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Tab#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Tab#getImage()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Image();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.views.properties.contexts.Tab#getAfterTab <em>After Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>After Tab</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Tab#getAfterTab()
	 * @see #getTab()
	 * @generated
	 */
	EReference getTab_AfterTab();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.views.properties.contexts.Tab#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Tab#getSections()
	 * @see #getTab()
	 * @generated
	 */
	EReference getTab_Sections();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Tab#isIndented <em>Indented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indented</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Tab#isIndented()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Indented();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Tab#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Tab#getPriority()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Priority();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.contexts.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.View#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.View#getName()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.views.properties.contexts.View#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sections</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.View#getSections()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Sections();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.views.properties.contexts.View#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.View#getContext()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.View#isAutomaticContext <em>Automatic Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Automatic Context</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.View#isAutomaticContext()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_AutomaticContext();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.views.properties.contexts.View#getDatacontexts <em>Datacontexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Datacontexts</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.View#getDatacontexts()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Datacontexts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.contexts.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Section
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Section#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Section#getName()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.views.properties.contexts.Section#getTab <em>Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tab</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Section#getTab()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Tab();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Section#getSectionFile <em>Section File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Section File</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Section#getSectionFile()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_SectionFile();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.views.properties.contexts.Section#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Widget</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Section#getWidget()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Widget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.contexts.DataContextElement <em>Data Context Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Context Element</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextElement
	 * @generated
	 */
	EClass getDataContextElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.DataContextElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextElement#getName()
	 * @see #getDataContextElement()
	 * @generated
	 */
	EAttribute getDataContextElement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.views.properties.contexts.DataContextElement#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextElement#getProperties()
	 * @see #getDataContextElement()
	 * @generated
	 */
	EReference getDataContextElement_Properties();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.views.properties.contexts.DataContextElement#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextElement#getPackage()
	 * @see #getDataContextElement()
	 * @generated
	 */
	EReference getDataContextElement_Package();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.views.properties.contexts.DataContextElement#getSupertypes <em>Supertypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supertypes</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextElement#getSupertypes()
	 * @see #getDataContextElement()
	 * @generated
	 */
	EReference getDataContextElement_Supertypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.contexts.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Property#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Property#getLabel()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Type();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.views.properties.contexts.Property#getContextElement <em>Context Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context Element</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Property#getContextElement()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_ContextElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Property#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Property#getMultiplicity()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Multiplicity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.Property#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.Property#getDescription()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.contexts.UnknownProperty <em>Unknown Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Property</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.UnknownProperty
	 * @generated
	 */
	EClass getUnknownProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.contexts.DataContextPackage <em>Data Context Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Context Package</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextPackage
	 * @generated
	 */
	EClass getDataContextPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.views.properties.contexts.DataContextPackage#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextPackage#getElements()
	 * @see #getDataContextPackage()
	 * @generated
	 */
	EReference getDataContextPackage_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.contexts.DataContextRoot <em>Data Context Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Context Root</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextRoot
	 * @generated
	 */
	EClass getDataContextRoot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.views.properties.contexts.DataContextRoot#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextRoot#getLabel()
	 * @see #getDataContextRoot()
	 * @generated
	 */
	EAttribute getDataContextRoot_Label();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.views.properties.contexts.DataContextRoot#getModelElementFactory <em>Model Element Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element Factory</em>'.
	 * @see org.eclipse.papyrus.views.properties.contexts.DataContextRoot#getModelElementFactory()
	 * @see #getDataContextRoot()
	 * @generated
	 */
	EReference getDataContextRoot_ModelElementFactory();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ContextsFactory getContextsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextImpl
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT__NAME = eINSTANCE.getContext_Name();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__DEPENDENCIES = eINSTANCE.getContext_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Tabs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__TABS = eINSTANCE.getContext_Tabs();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__VIEWS = eINSTANCE.getContext_Views();

		/**
		 * The meta object literal for the '<em><b>Data Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__DATA_CONTEXTS = eINSTANCE.getContext_DataContexts();

		/**
		 * The meta object literal for the '<em><b>Prototype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__PROTOTYPE = eINSTANCE.getContext_Prototype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.TabImpl <em>Tab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.TabImpl
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getTab()
		 * @generated
		 */
		EClass TAB = eINSTANCE.getTab();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB__LABEL = eINSTANCE.getTab_Label();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB__ID = eINSTANCE.getTab_Id();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB__CATEGORY = eINSTANCE.getTab_Category();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB__IMAGE = eINSTANCE.getTab_Image();

		/**
		 * The meta object literal for the '<em><b>After Tab</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAB__AFTER_TAB = eINSTANCE.getTab_AfterTab();

		/**
		 * The meta object literal for the '<em><b>Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAB__SECTIONS = eINSTANCE.getTab_Sections();

		/**
		 * The meta object literal for the '<em><b>Indented</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB__INDENTED = eINSTANCE.getTab_Indented();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB__PRIORITY = eINSTANCE.getTab_Priority();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ViewImpl
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__NAME = eINSTANCE.getView_Name();

		/**
		 * The meta object literal for the '<em><b>Sections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__SECTIONS = eINSTANCE.getView_Sections();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__CONTEXT = eINSTANCE.getView_Context();

		/**
		 * The meta object literal for the '<em><b>Automatic Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__AUTOMATIC_CONTEXT = eINSTANCE.getView_AutomaticContext();

		/**
		 * The meta object literal for the '<em><b>Datacontexts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__DATACONTEXTS = eINSTANCE.getView_Datacontexts();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.SectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.SectionImpl
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getSection()
		 * @generated
		 */
		EClass SECTION = eINSTANCE.getSection();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECTION__NAME = eINSTANCE.getSection_Name();

		/**
		 * The meta object literal for the '<em><b>Tab</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__TAB = eINSTANCE.getSection_Tab();

		/**
		 * The meta object literal for the '<em><b>Section File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECTION__SECTION_FILE = eINSTANCE.getSection_SectionFile();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__WIDGET = eINSTANCE.getSection_Widget();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.DataContextElementImpl <em>Data Context Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.DataContextElementImpl
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getDataContextElement()
		 * @generated
		 */
		EClass DATA_CONTEXT_ELEMENT = eINSTANCE.getDataContextElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_CONTEXT_ELEMENT__NAME = eINSTANCE.getDataContextElement_Name();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONTEXT_ELEMENT__PROPERTIES = eINSTANCE.getDataContextElement_Properties();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONTEXT_ELEMENT__PACKAGE = eINSTANCE.getDataContextElement_Package();

		/**
		 * The meta object literal for the '<em><b>Supertypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONTEXT_ELEMENT__SUPERTYPES = eINSTANCE.getDataContextElement_Supertypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.PropertyImpl
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__LABEL = eINSTANCE.getProperty_Label();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Context Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__CONTEXT_ELEMENT = eINSTANCE.getProperty_ContextElement();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__MULTIPLICITY = eINSTANCE.getProperty_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__DESCRIPTION = eINSTANCE.getProperty_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.UnknownPropertyImpl <em>Unknown Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.UnknownPropertyImpl
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getUnknownProperty()
		 * @generated
		 */
		EClass UNKNOWN_PROPERTY = eINSTANCE.getUnknownProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.DataContextPackageImpl <em>Data Context Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.DataContextPackageImpl
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getDataContextPackage()
		 * @generated
		 */
		EClass DATA_CONTEXT_PACKAGE = eINSTANCE.getDataContextPackage();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONTEXT_PACKAGE__ELEMENTS = eINSTANCE.getDataContextPackage_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.contexts.impl.DataContextRootImpl <em>Data Context Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.DataContextRootImpl
		 * @see org.eclipse.papyrus.views.properties.contexts.impl.ContextsPackageImpl#getDataContextRoot()
		 * @generated
		 */
		EClass DATA_CONTEXT_ROOT = eINSTANCE.getDataContextRoot();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_CONTEXT_ROOT__LABEL = eINSTANCE.getDataContextRoot_Label();

		/**
		 * The meta object literal for the '<em><b>Model Element Factory</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONTEXT_ROOT__MODEL_ELEMENT_FACTORY = eINSTANCE.getDataContextRoot_ModelElementFactory();

	}

} //ContextsPackage
