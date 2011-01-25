/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.environment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.papyrus.properties.environment.EnvironmentFactory
 * @model kind="package"
 * @generated
 */
public interface EnvironmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "environment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/properties/environment";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "environment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvironmentPackage eINSTANCE = org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Model Element Factories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__MODEL_ELEMENT_FACTORIES = 0;

	/**
	 * The feature id for the '<em><b>Constraint Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__CONSTRAINT_TYPES = 1;

	/**
	 * The feature id for the '<em><b>Widget Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__WIDGET_TYPES = 2;

	/**
	 * The feature id for the '<em><b>Property Editor Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__PROPERTY_EDITOR_TYPES = 3;

	/**
	 * The feature id for the '<em><b>Composite Widget Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__COMPOSITE_WIDGET_TYPES = 4;

	/**
	 * The feature id for the '<em><b>Layout Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__LAYOUT_TYPES = 5;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.environment.impl.WidgetTypeImpl <em>Widget Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.environment.impl.WidgetTypeImpl
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getWidgetType()
	 * @generated
	 */
	int WIDGET_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Widget Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__WIDGET_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Widget Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.environment.impl.PropertyEditorTypeImpl <em>Property Editor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.environment.impl.PropertyEditorTypeImpl
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getPropertyEditorType()
	 * @generated
	 */
	int PROPERTY_EDITOR_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR_TYPE__LABEL = WIDGET_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Widget Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR_TYPE__WIDGET_CLASS = WIDGET_TYPE__WIDGET_CLASS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR_TYPE__TYPE = WIDGET_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR_TYPE__MULTIPLICITY = WIDGET_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Editor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR_TYPE_FEATURE_COUNT = WIDGET_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.environment.impl.CompositeWidgetTypeImpl <em>Composite Widget Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.environment.impl.CompositeWidgetTypeImpl
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getCompositeWidgetType()
	 * @generated
	 */
	int COMPOSITE_WIDGET_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_WIDGET_TYPE__LABEL = WIDGET_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Widget Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_WIDGET_TYPE__WIDGET_CLASS = WIDGET_TYPE__WIDGET_CLASS;

	/**
	 * The number of structural features of the '<em>Composite Widget Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_WIDGET_TYPE_FEATURE_COUNT = WIDGET_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.environment.impl.LayoutTypeImpl <em>Layout Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.environment.impl.LayoutTypeImpl
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getLayoutType()
	 * @generated
	 */
	int LAYOUT_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__LABEL = WIDGET_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Widget Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__WIDGET_CLASS = WIDGET_TYPE__WIDGET_CLASS;

	/**
	 * The number of structural features of the '<em>Layout Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE_FEATURE_COUNT = WIDGET_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.environment.impl.ConstraintTypeImpl <em>Constraint Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.environment.impl.ConstraintTypeImpl
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getConstraintType()
	 * @generated
	 */
	int CONSTRAINT_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TYPE__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Constraint Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TYPE__CONSTRAINT_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Constraint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.environment.impl.ModelElementFactoryDescriptorImpl <em>Model Element Factory Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.environment.impl.ModelElementFactoryDescriptorImpl
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getModelElementFactoryDescriptor()
	 * @generated
	 */
	int MODEL_ELEMENT_FACTORY_DESCRIPTOR = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FACTORY_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Factory Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FACTORY_DESCRIPTOR__FACTORY_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Model Element Factory Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FACTORY_DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.environment.impl.StandardWidgetTypeImpl <em>Standard Widget Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.environment.impl.StandardWidgetTypeImpl
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getStandardWidgetType()
	 * @generated
	 */
	int STANDARD_WIDGET_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_WIDGET_TYPE__LABEL = WIDGET_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Widget Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_WIDGET_TYPE__WIDGET_CLASS = WIDGET_TYPE__WIDGET_CLASS;

	/**
	 * The number of structural features of the '<em>Standard Widget Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_WIDGET_TYPE_FEATURE_COUNT = WIDGET_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.environment.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.environment.Type
	 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.environment.Environment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see org.eclipse.papyrus.properties.environment.Environment
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.environment.Environment#getModelElementFactories <em>Model Element Factories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Element Factories</em>'.
	 * @see org.eclipse.papyrus.properties.environment.Environment#getModelElementFactories()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_ModelElementFactories();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.environment.Environment#getConstraintTypes <em>Constraint Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint Types</em>'.
	 * @see org.eclipse.papyrus.properties.environment.Environment#getConstraintTypes()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_ConstraintTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.environment.Environment#getWidgetTypes <em>Widget Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widget Types</em>'.
	 * @see org.eclipse.papyrus.properties.environment.Environment#getWidgetTypes()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_WidgetTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.environment.Environment#getPropertyEditorTypes <em>Property Editor Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Editor Types</em>'.
	 * @see org.eclipse.papyrus.properties.environment.Environment#getPropertyEditorTypes()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_PropertyEditorTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.environment.Environment#getCompositeWidgetTypes <em>Composite Widget Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composite Widget Types</em>'.
	 * @see org.eclipse.papyrus.properties.environment.Environment#getCompositeWidgetTypes()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_CompositeWidgetTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.environment.Environment#getLayoutTypes <em>Layout Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layout Types</em>'.
	 * @see org.eclipse.papyrus.properties.environment.Environment#getLayoutTypes()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_LayoutTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.environment.PropertyEditorType <em>Property Editor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Editor Type</em>'.
	 * @see org.eclipse.papyrus.properties.environment.PropertyEditorType
	 * @generated
	 */
	EClass getPropertyEditorType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.environment.PropertyEditorType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.properties.environment.PropertyEditorType#getType()
	 * @see #getPropertyEditorType()
	 * @generated
	 */
	EAttribute getPropertyEditorType_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.environment.PropertyEditorType#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.eclipse.papyrus.properties.environment.PropertyEditorType#getMultiplicity()
	 * @see #getPropertyEditorType()
	 * @generated
	 */
	EAttribute getPropertyEditorType_Multiplicity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.environment.WidgetType <em>Widget Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget Type</em>'.
	 * @see org.eclipse.papyrus.properties.environment.WidgetType
	 * @generated
	 */
	EClass getWidgetType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.environment.WidgetType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.properties.environment.WidgetType#getLabel()
	 * @see #getWidgetType()
	 * @generated
	 */
	EAttribute getWidgetType_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.environment.WidgetType#getWidgetClass <em>Widget Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Widget Class</em>'.
	 * @see org.eclipse.papyrus.properties.environment.WidgetType#getWidgetClass()
	 * @see #getWidgetType()
	 * @generated
	 */
	EAttribute getWidgetType_WidgetClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.environment.CompositeWidgetType <em>Composite Widget Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Widget Type</em>'.
	 * @see org.eclipse.papyrus.properties.environment.CompositeWidgetType
	 * @generated
	 */
	EClass getCompositeWidgetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.environment.LayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout Type</em>'.
	 * @see org.eclipse.papyrus.properties.environment.LayoutType
	 * @generated
	 */
	EClass getLayoutType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.environment.ConstraintType <em>Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Type</em>'.
	 * @see org.eclipse.papyrus.properties.environment.ConstraintType
	 * @generated
	 */
	EClass getConstraintType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.environment.ConstraintType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.properties.environment.ConstraintType#getLabel()
	 * @see #getConstraintType()
	 * @generated
	 */
	EAttribute getConstraintType_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.environment.ConstraintType#getConstraintClass <em>Constraint Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Class</em>'.
	 * @see org.eclipse.papyrus.properties.environment.ConstraintType#getConstraintClass()
	 * @see #getConstraintType()
	 * @generated
	 */
	EAttribute getConstraintType_ConstraintClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor <em>Model Element Factory Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Factory Descriptor</em>'.
	 * @see org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor
	 * @generated
	 */
	EClass getModelElementFactoryDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor#getName()
	 * @see #getModelElementFactoryDescriptor()
	 * @generated
	 */
	EAttribute getModelElementFactoryDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor#getFactoryClass <em>Factory Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory Class</em>'.
	 * @see org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor#getFactoryClass()
	 * @see #getModelElementFactoryDescriptor()
	 * @generated
	 */
	EAttribute getModelElementFactoryDescriptor_FactoryClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.environment.StandardWidgetType <em>Standard Widget Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Standard Widget Type</em>'.
	 * @see org.eclipse.papyrus.properties.environment.StandardWidgetType
	 * @generated
	 */
	EClass getStandardWidgetType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.properties.environment.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see org.eclipse.papyrus.properties.environment.Type
	 * @generated
	 */
	EEnum getType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnvironmentFactory getEnvironmentFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '<em><b>Model Element Factories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__MODEL_ELEMENT_FACTORIES = eINSTANCE.getEnvironment_ModelElementFactories();

		/**
		 * The meta object literal for the '<em><b>Constraint Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__CONSTRAINT_TYPES = eINSTANCE.getEnvironment_ConstraintTypes();

		/**
		 * The meta object literal for the '<em><b>Widget Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__WIDGET_TYPES = eINSTANCE.getEnvironment_WidgetTypes();

		/**
		 * The meta object literal for the '<em><b>Property Editor Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__PROPERTY_EDITOR_TYPES = eINSTANCE.getEnvironment_PropertyEditorTypes();

		/**
		 * The meta object literal for the '<em><b>Composite Widget Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__COMPOSITE_WIDGET_TYPES = eINSTANCE.getEnvironment_CompositeWidgetTypes();

		/**
		 * The meta object literal for the '<em><b>Layout Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__LAYOUT_TYPES = eINSTANCE.getEnvironment_LayoutTypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.environment.impl.PropertyEditorTypeImpl <em>Property Editor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.environment.impl.PropertyEditorTypeImpl
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getPropertyEditorType()
		 * @generated
		 */
		EClass PROPERTY_EDITOR_TYPE = eINSTANCE.getPropertyEditorType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_EDITOR_TYPE__TYPE = eINSTANCE.getPropertyEditorType_Type();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_EDITOR_TYPE__MULTIPLICITY = eINSTANCE.getPropertyEditorType_Multiplicity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.environment.impl.WidgetTypeImpl <em>Widget Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.environment.impl.WidgetTypeImpl
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getWidgetType()
		 * @generated
		 */
		EClass WIDGET_TYPE = eINSTANCE.getWidgetType();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET_TYPE__LABEL = eINSTANCE.getWidgetType_Label();

		/**
		 * The meta object literal for the '<em><b>Widget Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET_TYPE__WIDGET_CLASS = eINSTANCE.getWidgetType_WidgetClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.environment.impl.CompositeWidgetTypeImpl <em>Composite Widget Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.environment.impl.CompositeWidgetTypeImpl
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getCompositeWidgetType()
		 * @generated
		 */
		EClass COMPOSITE_WIDGET_TYPE = eINSTANCE.getCompositeWidgetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.environment.impl.LayoutTypeImpl <em>Layout Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.environment.impl.LayoutTypeImpl
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getLayoutType()
		 * @generated
		 */
		EClass LAYOUT_TYPE = eINSTANCE.getLayoutType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.environment.impl.ConstraintTypeImpl <em>Constraint Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.environment.impl.ConstraintTypeImpl
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getConstraintType()
		 * @generated
		 */
		EClass CONSTRAINT_TYPE = eINSTANCE.getConstraintType();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_TYPE__LABEL = eINSTANCE.getConstraintType_Label();

		/**
		 * The meta object literal for the '<em><b>Constraint Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_TYPE__CONSTRAINT_CLASS = eINSTANCE.getConstraintType_ConstraintClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.environment.impl.ModelElementFactoryDescriptorImpl <em>Model Element Factory Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.environment.impl.ModelElementFactoryDescriptorImpl
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getModelElementFactoryDescriptor()
		 * @generated
		 */
		EClass MODEL_ELEMENT_FACTORY_DESCRIPTOR = eINSTANCE.getModelElementFactoryDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_FACTORY_DESCRIPTOR__NAME = eINSTANCE.getModelElementFactoryDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Factory Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_FACTORY_DESCRIPTOR__FACTORY_CLASS = eINSTANCE.getModelElementFactoryDescriptor_FactoryClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.environment.impl.StandardWidgetTypeImpl <em>Standard Widget Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.environment.impl.StandardWidgetTypeImpl
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getStandardWidgetType()
		 * @generated
		 */
		EClass STANDARD_WIDGET_TYPE = eINSTANCE.getStandardWidgetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.environment.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.environment.Type
		 * @see org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

	}

} //EnvironmentPackage
