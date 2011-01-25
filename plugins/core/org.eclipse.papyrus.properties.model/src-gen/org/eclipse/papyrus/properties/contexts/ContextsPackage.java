/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.properties.contexts.ContextsFactory
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
	String eNS_URI = "http://www.eclipse.org/papyrus/properties/contexts";

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
	ContextsPackage eINSTANCE = org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__VIEWS = 1;

	/**
	 * The feature id for the '<em><b>Tabs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__TABS = 2;

	/**
	 * The feature id for the '<em><b>Data Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__DATA_CONTEXTS = 3;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.DisplayUnitImpl <em>Display Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.DisplayUnitImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getDisplayUnit()
	 * @generated
	 */
	int DISPLAY_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT__CONSTRAINTS = 0;

	/**
	 * The number of structural features of the '<em>Display Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.ViewImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getView()
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
	int VIEW__CONSTRAINTS = DISPLAY_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NAME = DISPLAY_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__SECTIONS = DISPLAY_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Datacontexts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__DATACONTEXTS = DISPLAY_UNIT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Element Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ELEMENT_MULTIPLICITY = DISPLAY_UNIT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CONTEXT = DISPLAY_UNIT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Automatic Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__AUTOMATIC_CONTEXT = DISPLAY_UNIT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = DISPLAY_UNIT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.TabImpl <em>Tab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.TabImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getTab()
	 * @generated
	 */
	int TAB = 3;

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
	 * The number of structural features of the '<em>Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.SectionImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 4;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__CONSTRAINTS = DISPLAY_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__NAME = DISPLAY_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tab</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__TAB = DISPLAY_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Section File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__SECTION_FILE = DISPLAY_UNIT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__WIDGET = DISPLAY_UNIT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = DISPLAY_UNIT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.DataContextElementImpl <em>Data Context Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.DataContextElementImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getDataContextElement()
	 * @generated
	 */
	int DATA_CONTEXT_ELEMENT = 5;

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
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.PropertyImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 6;

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
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.UnknownPropertyImpl <em>Unknown Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.UnknownPropertyImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getUnknownProperty()
	 * @generated
	 */
	int UNKNOWN_PROPERTY = 7;

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
	 * The number of structural features of the '<em>Unknown Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.DataContextPackageImpl <em>Data Context Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.DataContextPackageImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getDataContextPackage()
	 * @generated
	 */
	int DATA_CONTEXT_PACKAGE = 8;

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
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.DataContextRootImpl <em>Data Context Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.DataContextRootImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getDataContextRoot()
	 * @generated
	 */
	int DATA_CONTEXT_ROOT = 9;

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
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl <em>Constraint Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getConstraintDescriptor()
	 * @generated
	 */
	int CONSTRAINT_DESCRIPTOR = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Display</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__DISPLAY = 1;

	/**
	 * The feature id for the '<em><b>Constraint Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__CONSTRAINT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__CONSTRAINTS = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__PROPERTIES = 4;

	/**
	 * The feature id for the '<em><b>Overridden Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS = 5;

	/**
	 * The number of structural features of the '<em>Constraint Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.ConfigPropertyImpl <em>Config Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.ConfigPropertyImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getConfigProperty()
	 * @generated
	 */
	int CONFIG_PROPERTY = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Config Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.ValuePropertyImpl <em>Value Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.ValuePropertyImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getValueProperty()
	 * @generated
	 */
	int VALUE_PROPERTY = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY__NAME = CONFIG_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY__VALUE = CONFIG_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY_FEATURE_COUNT = CONFIG_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.contexts.impl.ReferencePropertyImpl <em>Reference Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.contexts.impl.ReferencePropertyImpl
	 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getReferenceProperty()
	 * @generated
	 */
	int REFERENCE_PROPERTY = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__NAME = CONFIG_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__VALUE = CONFIG_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY_FEATURE_COUNT = CONFIG_PROPERTY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Context#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Context#getName()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.contexts.Context#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Context#getViews()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Views();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.contexts.Context#getTabs <em>Tabs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tabs</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Context#getTabs()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Tabs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.contexts.Context#getDataContexts <em>Data Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Contexts</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Context#getDataContexts()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_DataContexts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.DisplayUnit <em>Display Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Unit</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DisplayUnit
	 * @generated
	 */
	EClass getDisplayUnit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.contexts.DisplayUnit#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DisplayUnit#getConstraints()
	 * @see #getDisplayUnit()
	 * @generated
	 */
	EReference getDisplayUnit_Constraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.View#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.View#getName()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.properties.contexts.View#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sections</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.View#getSections()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Sections();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.properties.contexts.View#getDatacontexts <em>Datacontexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Datacontexts</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.View#getDatacontexts()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Datacontexts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.View#getElementMultiplicity <em>Element Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Multiplicity</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.View#getElementMultiplicity()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_ElementMultiplicity();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.properties.contexts.View#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.View#getContext()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.View#isAutomaticContext <em>Automatic Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Automatic Context</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.View#isAutomaticContext()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_AutomaticContext();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.Tab <em>Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tab</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Tab
	 * @generated
	 */
	EClass getTab();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Tab#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Tab#getLabel()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Tab#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Tab#getId()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Tab#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Tab#getCategory()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Category();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Tab#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Tab#getImage()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Image();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.contexts.Tab#getAfterTab <em>After Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>After Tab</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Tab#getAfterTab()
	 * @see #getTab()
	 * @generated
	 */
	EReference getTab_AfterTab();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.contexts.Tab#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Tab#getSections()
	 * @see #getTab()
	 * @generated
	 */
	EReference getTab_Sections();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Section
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Section#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Section#getName()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.properties.contexts.Section#getTab <em>Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tab</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Section#getTab()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Tab();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Section#getSectionFile <em>Section File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Section File</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Section#getSectionFile()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_SectionFile();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.contexts.Section#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Widget</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Section#getWidget()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Widget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.DataContextElement <em>Data Context Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Context Element</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextElement
	 * @generated
	 */
	EClass getDataContextElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.DataContextElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextElement#getName()
	 * @see #getDataContextElement()
	 * @generated
	 */
	EAttribute getDataContextElement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.contexts.DataContextElement#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextElement#getProperties()
	 * @see #getDataContextElement()
	 * @generated
	 */
	EReference getDataContextElement_Properties();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.properties.contexts.DataContextElement#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextElement#getPackage()
	 * @see #getDataContextElement()
	 * @generated
	 */
	EReference getDataContextElement_Package();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.properties.contexts.DataContextElement#getSupertypes <em>Supertypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supertypes</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextElement#getSupertypes()
	 * @see #getDataContextElement()
	 * @generated
	 */
	EReference getDataContextElement_Supertypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Property#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Property#getLabel()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Type();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.properties.contexts.Property#getContextElement <em>Context Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context Element</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Property#getContextElement()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_ContextElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.Property#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.Property#getMultiplicity()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Multiplicity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.UnknownProperty <em>Unknown Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Property</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.UnknownProperty
	 * @generated
	 */
	EClass getUnknownProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.DataContextPackage <em>Data Context Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Context Package</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextPackage
	 * @generated
	 */
	EClass getDataContextPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.contexts.DataContextPackage#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextPackage#getElements()
	 * @see #getDataContextPackage()
	 * @generated
	 */
	EReference getDataContextPackage_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.DataContextRoot <em>Data Context Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Context Root</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextRoot
	 * @generated
	 */
	EClass getDataContextRoot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.DataContextRoot#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextRoot#getLabel()
	 * @see #getDataContextRoot()
	 * @generated
	 */
	EAttribute getDataContextRoot_Label();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.contexts.DataContextRoot#getModelElementFactory <em>Model Element Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element Factory</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.DataContextRoot#getModelElementFactory()
	 * @see #getDataContextRoot()
	 * @generated
	 */
	EReference getDataContextRoot_ModelElementFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor <em>Constraint Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Descriptor</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ConstraintDescriptor
	 * @generated
	 */
	EClass getConstraintDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getName()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EAttribute getConstraintDescriptor_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getDisplay <em>Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Display</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getDisplay()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EReference getConstraintDescriptor_Display();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getConstraintType <em>Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint Type</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getConstraintType()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EReference getConstraintDescriptor_ConstraintType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getConstraints()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EReference getConstraintDescriptor_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getProperties()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EReference getConstraintDescriptor_Properties();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getOverriddenConstraints <em>Overridden Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Overridden Constraints</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getOverriddenConstraints()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EReference getConstraintDescriptor_OverriddenConstraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.ConfigProperty <em>Config Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Property</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ConfigProperty
	 * @generated
	 */
	EClass getConfigProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.ConfigProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ConfigProperty#getName()
	 * @see #getConfigProperty()
	 * @generated
	 */
	EAttribute getConfigProperty_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.ValueProperty <em>Value Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Property</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ValueProperty
	 * @generated
	 */
	EClass getValueProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.contexts.ValueProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ValueProperty#getValue()
	 * @see #getValueProperty()
	 * @generated
	 */
	EAttribute getValueProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.contexts.ReferenceProperty <em>Reference Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Property</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ReferenceProperty
	 * @generated
	 */
	EClass getReferenceProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.contexts.ReferenceProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.properties.contexts.ReferenceProperty#getValue()
	 * @see #getReferenceProperty()
	 * @generated
	 */
	EReference getReferenceProperty_Value();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getContext()
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
		 * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__VIEWS = eINSTANCE.getContext_Views();

		/**
		 * The meta object literal for the '<em><b>Tabs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__TABS = eINSTANCE.getContext_Tabs();

		/**
		 * The meta object literal for the '<em><b>Data Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__DATA_CONTEXTS = eINSTANCE.getContext_DataContexts();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.DisplayUnitImpl <em>Display Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.DisplayUnitImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getDisplayUnit()
		 * @generated
		 */
		EClass DISPLAY_UNIT = eINSTANCE.getDisplayUnit();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPLAY_UNIT__CONSTRAINTS = eINSTANCE.getDisplayUnit_Constraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.ViewImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getView()
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
		 * The meta object literal for the '<em><b>Datacontexts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__DATACONTEXTS = eINSTANCE.getView_Datacontexts();

		/**
		 * The meta object literal for the '<em><b>Element Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__ELEMENT_MULTIPLICITY = eINSTANCE.getView_ElementMultiplicity();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.TabImpl <em>Tab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.TabImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getTab()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.SectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.SectionImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getSection()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.DataContextElementImpl <em>Data Context Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.DataContextElementImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getDataContextElement()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.PropertyImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getProperty()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.UnknownPropertyImpl <em>Unknown Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.UnknownPropertyImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getUnknownProperty()
		 * @generated
		 */
		EClass UNKNOWN_PROPERTY = eINSTANCE.getUnknownProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.DataContextPackageImpl <em>Data Context Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.DataContextPackageImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getDataContextPackage()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.DataContextRootImpl <em>Data Context Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.DataContextRootImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getDataContextRoot()
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

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl <em>Constraint Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getConstraintDescriptor()
		 * @generated
		 */
		EClass CONSTRAINT_DESCRIPTOR = eINSTANCE.getConstraintDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_DESCRIPTOR__NAME = eINSTANCE.getConstraintDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Display</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_DESCRIPTOR__DISPLAY = eINSTANCE.getConstraintDescriptor_Display();

		/**
		 * The meta object literal for the '<em><b>Constraint Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_DESCRIPTOR__CONSTRAINT_TYPE = eINSTANCE.getConstraintDescriptor_ConstraintType();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_DESCRIPTOR__CONSTRAINTS = eINSTANCE.getConstraintDescriptor_Constraints();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_DESCRIPTOR__PROPERTIES = eINSTANCE.getConstraintDescriptor_Properties();

		/**
		 * The meta object literal for the '<em><b>Overridden Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS = eINSTANCE.getConstraintDescriptor_OverriddenConstraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.ConfigPropertyImpl <em>Config Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.ConfigPropertyImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getConfigProperty()
		 * @generated
		 */
		EClass CONFIG_PROPERTY = eINSTANCE.getConfigProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG_PROPERTY__NAME = eINSTANCE.getConfigProperty_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.ValuePropertyImpl <em>Value Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.ValuePropertyImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getValueProperty()
		 * @generated
		 */
		EClass VALUE_PROPERTY = eINSTANCE.getValueProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_PROPERTY__VALUE = eINSTANCE.getValueProperty_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.contexts.impl.ReferencePropertyImpl <em>Reference Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.contexts.impl.ReferencePropertyImpl
		 * @see org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl#getReferenceProperty()
		 * @generated
		 */
		EClass REFERENCE_PROPERTY = eINSTANCE.getReferenceProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_PROPERTY__VALUE = eINSTANCE.getReferenceProperty_Value();

	}

} //ContextsPackage
