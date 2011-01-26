/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.properties.contexts.ConfigProperty;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.ContextsFactory;
import org.eclipse.papyrus.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.contexts.DataContextPackage;
import org.eclipse.papyrus.properties.contexts.DataContextRoot;
import org.eclipse.papyrus.properties.contexts.DisplayUnit;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.contexts.ReferenceProperty;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.Tab;
import org.eclipse.papyrus.properties.contexts.UnknownProperty;
import org.eclipse.papyrus.properties.contexts.ValueProperty;
import org.eclipse.papyrus.properties.contexts.View;

import org.eclipse.papyrus.properties.environment.EnvironmentPackage;

import org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl;

import org.eclipse.papyrus.properties.ui.UiPackage;

import org.eclipse.papyrus.properties.ui.impl.UiPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContextsPackageImpl extends EPackageImpl implements ContextsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass displayUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataContextElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataContextPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataContextRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valuePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referencePropertyEClass = null;

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
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ContextsPackageImpl() {
		super(eNS_URI, ContextsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ContextsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ContextsPackage init() {
		if (isInited) return (ContextsPackage)EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI);

		// Obtain or create and register package
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ContextsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ContextsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EnvironmentPackageImpl theEnvironmentPackage = (EnvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI) instanceof EnvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI) : EnvironmentPackage.eINSTANCE);
		UiPackageImpl theUiPackage = (UiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI) instanceof UiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI) : UiPackage.eINSTANCE);

		// Create package meta-data objects
		theContextsPackage.createPackageContents();
		theEnvironmentPackage.createPackageContents();
		theUiPackage.createPackageContents();

		// Initialize created meta-data
		theContextsPackage.initializePackageContents();
		theEnvironmentPackage.initializePackageContents();
		theUiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theContextsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ContextsPackage.eNS_URI, theContextsPackage);
		return theContextsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContext_Name() {
		return (EAttribute)contextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_Views() {
		return (EReference)contextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_Tabs() {
		return (EReference)contextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_DataContexts() {
		return (EReference)contextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisplayUnit() {
		return displayUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisplayUnit_Constraints() {
		return (EReference)displayUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getView() {
		return viewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getView_Name() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Sections() {
		return (EReference)viewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Datacontexts() {
		return (EReference)viewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getView_ElementMultiplicity() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Context() {
		return (EReference)viewEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getView_AutomaticContext() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTab() {
		return tabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTab_Label() {
		return (EAttribute)tabEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTab_Id() {
		return (EAttribute)tabEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTab_Category() {
		return (EAttribute)tabEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTab_Image() {
		return (EAttribute)tabEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTab_AfterTab() {
		return (EReference)tabEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTab_Sections() {
		return (EReference)tabEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTab_Indented() {
		return (EAttribute)tabEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSection() {
		return sectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSection_Name() {
		return (EAttribute)sectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSection_Tab() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSection_SectionFile() {
		return (EAttribute)sectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSection_Widget() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataContextElement() {
		return dataContextElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataContextElement_Name() {
		return (EAttribute)dataContextElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataContextElement_Properties() {
		return (EReference)dataContextElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataContextElement_Package() {
		return (EReference)dataContextElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataContextElement_Supertypes() {
		return (EReference)dataContextElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Label() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Type() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_ContextElement() {
		return (EReference)propertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Multiplicity() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnknownProperty() {
		return unknownPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataContextPackage() {
		return dataContextPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataContextPackage_Elements() {
		return (EReference)dataContextPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataContextRoot() {
		return dataContextRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataContextRoot_Label() {
		return (EAttribute)dataContextRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataContextRoot_ModelElementFactory() {
		return (EReference)dataContextRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintDescriptor() {
		return constraintDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintDescriptor_Name() {
		return (EAttribute)constraintDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintDescriptor_Display() {
		return (EReference)constraintDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintDescriptor_ConstraintType() {
		return (EReference)constraintDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintDescriptor_Constraints() {
		return (EReference)constraintDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintDescriptor_Properties() {
		return (EReference)constraintDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintDescriptor_OverriddenConstraints() {
		return (EReference)constraintDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigProperty() {
		return configPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigProperty_Name() {
		return (EAttribute)configPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueProperty() {
		return valuePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueProperty_Value() {
		return (EAttribute)valuePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceProperty() {
		return referencePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceProperty_Value() {
		return (EReference)referencePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextsFactory getContextsFactory() {
		return (ContextsFactory)getEFactoryInstance();
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
		contextEClass = createEClass(CONTEXT);
		createEAttribute(contextEClass, CONTEXT__NAME);
		createEReference(contextEClass, CONTEXT__VIEWS);
		createEReference(contextEClass, CONTEXT__TABS);
		createEReference(contextEClass, CONTEXT__DATA_CONTEXTS);

		displayUnitEClass = createEClass(DISPLAY_UNIT);
		createEReference(displayUnitEClass, DISPLAY_UNIT__CONSTRAINTS);

		viewEClass = createEClass(VIEW);
		createEAttribute(viewEClass, VIEW__NAME);
		createEReference(viewEClass, VIEW__SECTIONS);
		createEReference(viewEClass, VIEW__DATACONTEXTS);
		createEAttribute(viewEClass, VIEW__ELEMENT_MULTIPLICITY);
		createEReference(viewEClass, VIEW__CONTEXT);
		createEAttribute(viewEClass, VIEW__AUTOMATIC_CONTEXT);

		tabEClass = createEClass(TAB);
		createEAttribute(tabEClass, TAB__LABEL);
		createEAttribute(tabEClass, TAB__ID);
		createEAttribute(tabEClass, TAB__CATEGORY);
		createEAttribute(tabEClass, TAB__IMAGE);
		createEReference(tabEClass, TAB__AFTER_TAB);
		createEReference(tabEClass, TAB__SECTIONS);
		createEAttribute(tabEClass, TAB__INDENTED);

		sectionEClass = createEClass(SECTION);
		createEAttribute(sectionEClass, SECTION__NAME);
		createEReference(sectionEClass, SECTION__TAB);
		createEAttribute(sectionEClass, SECTION__SECTION_FILE);
		createEReference(sectionEClass, SECTION__WIDGET);

		dataContextElementEClass = createEClass(DATA_CONTEXT_ELEMENT);
		createEAttribute(dataContextElementEClass, DATA_CONTEXT_ELEMENT__NAME);
		createEReference(dataContextElementEClass, DATA_CONTEXT_ELEMENT__PROPERTIES);
		createEReference(dataContextElementEClass, DATA_CONTEXT_ELEMENT__PACKAGE);
		createEReference(dataContextElementEClass, DATA_CONTEXT_ELEMENT__SUPERTYPES);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__LABEL);
		createEAttribute(propertyEClass, PROPERTY__TYPE);
		createEReference(propertyEClass, PROPERTY__CONTEXT_ELEMENT);
		createEAttribute(propertyEClass, PROPERTY__MULTIPLICITY);

		unknownPropertyEClass = createEClass(UNKNOWN_PROPERTY);

		dataContextPackageEClass = createEClass(DATA_CONTEXT_PACKAGE);
		createEReference(dataContextPackageEClass, DATA_CONTEXT_PACKAGE__ELEMENTS);

		dataContextRootEClass = createEClass(DATA_CONTEXT_ROOT);
		createEAttribute(dataContextRootEClass, DATA_CONTEXT_ROOT__LABEL);
		createEReference(dataContextRootEClass, DATA_CONTEXT_ROOT__MODEL_ELEMENT_FACTORY);

		constraintDescriptorEClass = createEClass(CONSTRAINT_DESCRIPTOR);
		createEAttribute(constraintDescriptorEClass, CONSTRAINT_DESCRIPTOR__NAME);
		createEReference(constraintDescriptorEClass, CONSTRAINT_DESCRIPTOR__DISPLAY);
		createEReference(constraintDescriptorEClass, CONSTRAINT_DESCRIPTOR__CONSTRAINT_TYPE);
		createEReference(constraintDescriptorEClass, CONSTRAINT_DESCRIPTOR__CONSTRAINTS);
		createEReference(constraintDescriptorEClass, CONSTRAINT_DESCRIPTOR__PROPERTIES);
		createEReference(constraintDescriptorEClass, CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS);

		configPropertyEClass = createEClass(CONFIG_PROPERTY);
		createEAttribute(configPropertyEClass, CONFIG_PROPERTY__NAME);

		valuePropertyEClass = createEClass(VALUE_PROPERTY);
		createEAttribute(valuePropertyEClass, VALUE_PROPERTY__VALUE);

		referencePropertyEClass = createEClass(REFERENCE_PROPERTY);
		createEReference(referencePropertyEClass, REFERENCE_PROPERTY__VALUE);
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

		// Obtain other dependent packages
		UiPackage theUiPackage = (UiPackage)EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		viewEClass.getESuperTypes().add(this.getDisplayUnit());
		sectionEClass.getESuperTypes().add(this.getDisplayUnit());
		unknownPropertyEClass.getESuperTypes().add(this.getProperty());
		dataContextPackageEClass.getESuperTypes().add(this.getDataContextElement());
		dataContextRootEClass.getESuperTypes().add(this.getDataContextPackage());
		valuePropertyEClass.getESuperTypes().add(this.getConfigProperty());
		referencePropertyEClass.getESuperTypes().add(this.getConfigProperty());

		// Initialize classes and features; add operations and parameters
		initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContext_Name(), ecorePackage.getEString(), "name", null, 1, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_Views(), this.getView(), this.getView_Context(), "views", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_Tabs(), this.getTab(), null, "tabs", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_DataContexts(), this.getDataContextRoot(), null, "dataContexts", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(displayUnitEClass, DisplayUnit.class, "DisplayUnit", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDisplayUnit_Constraints(), this.getConstraintDescriptor(), this.getConstraintDescriptor_Display(), "constraints", null, 0, -1, DisplayUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getView_Name(), ecorePackage.getEString(), "name", null, 1, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Sections(), this.getSection(), null, "sections", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Datacontexts(), this.getDataContextElement(), null, "datacontexts", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getView_ElementMultiplicity(), ecorePackage.getEInt(), "elementMultiplicity", "1", 1, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Context(), this.getContext(), this.getContext_Views(), "context", null, 1, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getView_AutomaticContext(), ecorePackage.getEBoolean(), "automaticContext", null, 1, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tabEClass, Tab.class, "Tab", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTab_Label(), ecorePackage.getEString(), "label", null, 1, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTab_Id(), ecorePackage.getEString(), "id", null, 1, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTab_Category(), ecorePackage.getEString(), "category", null, 1, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTab_Image(), ecorePackage.getEString(), "image", null, 0, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTab_AfterTab(), this.getTab(), null, "afterTab", null, 0, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTab_Sections(), this.getSection(), this.getSection_Tab(), "sections", null, 0, -1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTab_Indented(), ecorePackage.getEBoolean(), "indented", "false", 1, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sectionEClass, Section.class, "Section", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSection_Name(), ecorePackage.getEString(), "name", null, 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSection_Tab(), this.getTab(), this.getTab_Sections(), "tab", null, 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSection_SectionFile(), ecorePackage.getEString(), "sectionFile", null, 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSection_Widget(), theUiPackage.getCompositeWidget(), null, "widget", null, 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataContextElementEClass, DataContextElement.class, "DataContextElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataContextElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, DataContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataContextElement_Properties(), this.getProperty(), this.getProperty_ContextElement(), "properties", null, 0, -1, DataContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataContextElement_Package(), this.getDataContextPackage(), this.getDataContextPackage_Elements(), "package", null, 0, 1, DataContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataContextElement_Supertypes(), this.getDataContextElement(), null, "supertypes", null, 0, -1, DataContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Label(), ecorePackage.getEString(), "label", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Type(), theEnvironmentPackage.getType(), "type", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProperty_ContextElement(), this.getDataContextElement(), this.getDataContextElement_Properties(), "contextElement", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Multiplicity(), ecorePackage.getEInt(), "multiplicity", "1", 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unknownPropertyEClass, UnknownProperty.class, "UnknownProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataContextPackageEClass, DataContextPackage.class, "DataContextPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataContextPackage_Elements(), this.getDataContextElement(), this.getDataContextElement_Package(), "elements", null, 0, -1, DataContextPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataContextRootEClass, DataContextRoot.class, "DataContextRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataContextRoot_Label(), ecorePackage.getEString(), "label", null, 1, 1, DataContextRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataContextRoot_ModelElementFactory(), theEnvironmentPackage.getModelElementFactoryDescriptor(), null, "modelElementFactory", null, 1, 1, DataContextRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintDescriptorEClass, ConstraintDescriptor.class, "ConstraintDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraintDescriptor_Name(), ecorePackage.getEString(), "name", null, 1, 1, ConstraintDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintDescriptor_Display(), this.getDisplayUnit(), this.getDisplayUnit_Constraints(), "display", null, 0, 1, ConstraintDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintDescriptor_ConstraintType(), theEnvironmentPackage.getConstraintType(), null, "constraintType", null, 1, 1, ConstraintDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintDescriptor_Constraints(), this.getConstraintDescriptor(), null, "constraints", null, 0, -1, ConstraintDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintDescriptor_Properties(), this.getConfigProperty(), null, "properties", null, 0, -1, ConstraintDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintDescriptor_OverriddenConstraints(), this.getConstraintDescriptor(), null, "overriddenConstraints", null, 0, -1, ConstraintDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configPropertyEClass, ConfigProperty.class, "ConfigProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, ConfigProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valuePropertyEClass, ValueProperty.class, "ValueProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueProperty_Value(), ecorePackage.getEString(), "value", null, 1, 1, ValueProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referencePropertyEClass, ReferenceProperty.class, "ReferenceProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceProperty_Value(), ecorePackage.getEObject(), null, "value", null, 1, 1, ReferenceProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ContextsPackageImpl
