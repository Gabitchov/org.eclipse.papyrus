/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.properties.generation.fieldselection.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelection;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionFactory;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition;
import org.eclipse.papyrus.customization.properties.generation.wizard.widget.TernaryButton.State;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FieldSelectionPackageImpl extends EPackageImpl implements FieldSelectionPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType valueEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FieldSelectionPackageImpl() {
		super(eNS_URI, FieldSelectionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FieldSelectionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FieldSelectionPackage init() {
		if (isInited) return (FieldSelectionPackage)EPackage.Registry.INSTANCE.getEPackage(FieldSelectionPackage.eNS_URI);

		// Obtain or create and register package
		FieldSelectionPackageImpl theFieldSelectionPackage = (FieldSelectionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FieldSelectionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FieldSelectionPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFieldSelectionPackage.createPackageContents();

		// Initialize created meta-data
		theFieldSelectionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFieldSelectionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FieldSelectionPackage.eNS_URI, theFieldSelectionPackage);
		return theFieldSelectionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFieldSelection() {
		return fieldSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFieldSelection_Fields() {
		return (EReference)fieldSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFieldSelection_ContextElements() {
		return (EReference)fieldSelectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyDefinition() {
		return propertyDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_Name() {
		return (EAttribute)propertyDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_ValueSingle() {
		return (EAttribute)propertyDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_ValueMultiple() {
		return (EAttribute)propertyDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextElement() {
		return contextElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextElement_Elements() {
		return (EReference)contextElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextElement_Properties() {
		return (EReference)contextElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContextElement_Name() {
		return (EAttribute)contextElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getValue() {
		return valueEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldSelectionFactory getFieldSelectionFactory() {
		return (FieldSelectionFactory)getEFactoryInstance();
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
		fieldSelectionEClass = createEClass(FIELD_SELECTION);
		createEReference(fieldSelectionEClass, FIELD_SELECTION__FIELDS);
		createEReference(fieldSelectionEClass, FIELD_SELECTION__CONTEXT_ELEMENTS);

		propertyDefinitionEClass = createEClass(PROPERTY_DEFINITION);
		createEAttribute(propertyDefinitionEClass, PROPERTY_DEFINITION__NAME);
		createEAttribute(propertyDefinitionEClass, PROPERTY_DEFINITION__VALUE_SINGLE);
		createEAttribute(propertyDefinitionEClass, PROPERTY_DEFINITION__VALUE_MULTIPLE);

		contextElementEClass = createEClass(CONTEXT_ELEMENT);
		createEReference(contextElementEClass, CONTEXT_ELEMENT__ELEMENTS);
		createEReference(contextElementEClass, CONTEXT_ELEMENT__PROPERTIES);
		createEAttribute(contextElementEClass, CONTEXT_ELEMENT__NAME);

		// Create data types
		valueEDataType = createEDataType(VALUE);
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

		// Initialize classes and features; add operations and parameters
		initEClass(fieldSelectionEClass, FieldSelection.class, "FieldSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFieldSelection_Fields(), this.getPropertyDefinition(), null, "fields", null, 0, -1, FieldSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFieldSelection_ContextElements(), this.getContextElement(), null, "contextElements", null, 0, -1, FieldSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyDefinitionEClass, PropertyDefinition.class, "PropertyDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, PropertyDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyDefinition_ValueSingle(), this.getValue(), "valueSingle", "DEFAULT", 1, 1, PropertyDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyDefinition_ValueMultiple(), this.getValue(), "valueMultiple", "DEFAULT", 1, 1, PropertyDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextElementEClass, ContextElement.class, "ContextElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextElement_Elements(), this.getContextElement(), null, "elements", null, 0, -1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextElement_Properties(), this.getPropertyDefinition(), null, "properties", null, 0, -1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContextElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(valueEDataType, State.class, "Value", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //FieldSelectionPackageImpl
