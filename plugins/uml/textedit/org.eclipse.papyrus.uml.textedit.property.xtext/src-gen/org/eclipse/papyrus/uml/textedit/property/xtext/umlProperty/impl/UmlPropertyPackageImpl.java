/**
 */
package org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierKind;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.QualifiedName;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.RedefinesRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.SubsetsRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyFactory;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.VisibilityKind;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlPropertyPackageImpl extends EPackageImpl implements UmlPropertyPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass propertyRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass typeRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass qualifiedNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass multiplicityRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass boundSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modifiersRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modifierSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass redefinesRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass subsetsRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass defaultValueRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum visibilityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum modifierKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlPropertyPackageImpl() {
		super(eNS_URI, UmlPropertyFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link UmlPropertyPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlPropertyPackage init() {
		if(isInited) {
			return (UmlPropertyPackage)EPackage.Registry.INSTANCE.getEPackage(UmlPropertyPackage.eNS_URI);
		}

		// Obtain or create and register package
		UmlPropertyPackageImpl theUmlPropertyPackage = (UmlPropertyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UmlPropertyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UmlPropertyPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlPropertyPackage.createPackageContents();

		// Initialize created meta-data
		theUmlPropertyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlPropertyPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlPropertyPackage.eNS_URI, theUmlPropertyPackage);
		return theUmlPropertyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPropertyRule() {
		return propertyRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPropertyRule_Visibility() {
		return (EAttribute)propertyRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPropertyRule_IsDerived() {
		return (EAttribute)propertyRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPropertyRule_Name() {
		return (EAttribute)propertyRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyRule_Type() {
		return (EReference)propertyRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyRule_Multiplicity() {
		return (EReference)propertyRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyRule_Modifiers() {
		return (EReference)propertyRuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyRule_Default() {
		return (EReference)propertyRuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTypeRule() {
		return typeRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTypeRule_Path() {
		return (EReference)typeRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTypeRule_Type() {
		return (EReference)typeRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getQualifiedName() {
		return qualifiedNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getQualifiedName_Path() {
		return (EReference)qualifiedNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getQualifiedName_Remaining() {
		return (EReference)qualifiedNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMultiplicityRule() {
		return multiplicityRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMultiplicityRule_Bounds() {
		return (EReference)multiplicityRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBoundSpecification() {
		return boundSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBoundSpecification_Value() {
		return (EAttribute)boundSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getModifiersRule() {
		return modifiersRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getModifiersRule_Values() {
		return (EReference)modifiersRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getModifierSpecification() {
		return modifierSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getModifierSpecification_Value() {
		return (EAttribute)modifierSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getModifierSpecification_Redefines() {
		return (EReference)modifierSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getModifierSpecification_Subsets() {
		return (EReference)modifierSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRedefinesRule() {
		return redefinesRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRedefinesRule_Property() {
		return (EReference)redefinesRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSubsetsRule() {
		return subsetsRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSubsetsRule_Property() {
		return (EReference)subsetsRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefaultValueRule() {
		return defaultValueRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDefaultValueRule_Default() {
		return (EAttribute)defaultValueRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getVisibilityKind() {
		return visibilityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getModifierKind() {
		return modifierKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlPropertyFactory getUmlPropertyFactory() {
		return (UmlPropertyFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		propertyRuleEClass = createEClass(PROPERTY_RULE);
		createEAttribute(propertyRuleEClass, PROPERTY_RULE__VISIBILITY);
		createEAttribute(propertyRuleEClass, PROPERTY_RULE__IS_DERIVED);
		createEAttribute(propertyRuleEClass, PROPERTY_RULE__NAME);
		createEReference(propertyRuleEClass, PROPERTY_RULE__TYPE);
		createEReference(propertyRuleEClass, PROPERTY_RULE__MULTIPLICITY);
		createEReference(propertyRuleEClass, PROPERTY_RULE__MODIFIERS);
		createEReference(propertyRuleEClass, PROPERTY_RULE__DEFAULT);

		typeRuleEClass = createEClass(TYPE_RULE);
		createEReference(typeRuleEClass, TYPE_RULE__PATH);
		createEReference(typeRuleEClass, TYPE_RULE__TYPE);

		qualifiedNameEClass = createEClass(QUALIFIED_NAME);
		createEReference(qualifiedNameEClass, QUALIFIED_NAME__PATH);
		createEReference(qualifiedNameEClass, QUALIFIED_NAME__REMAINING);

		multiplicityRuleEClass = createEClass(MULTIPLICITY_RULE);
		createEReference(multiplicityRuleEClass, MULTIPLICITY_RULE__BOUNDS);

		boundSpecificationEClass = createEClass(BOUND_SPECIFICATION);
		createEAttribute(boundSpecificationEClass, BOUND_SPECIFICATION__VALUE);

		modifiersRuleEClass = createEClass(MODIFIERS_RULE);
		createEReference(modifiersRuleEClass, MODIFIERS_RULE__VALUES);

		modifierSpecificationEClass = createEClass(MODIFIER_SPECIFICATION);
		createEAttribute(modifierSpecificationEClass, MODIFIER_SPECIFICATION__VALUE);
		createEReference(modifierSpecificationEClass, MODIFIER_SPECIFICATION__REDEFINES);
		createEReference(modifierSpecificationEClass, MODIFIER_SPECIFICATION__SUBSETS);

		redefinesRuleEClass = createEClass(REDEFINES_RULE);
		createEReference(redefinesRuleEClass, REDEFINES_RULE__PROPERTY);

		subsetsRuleEClass = createEClass(SUBSETS_RULE);
		createEReference(subsetsRuleEClass, SUBSETS_RULE__PROPERTY);

		defaultValueRuleEClass = createEClass(DEFAULT_VALUE_RULE);
		createEAttribute(defaultValueRuleEClass, DEFAULT_VALUE_RULE__DEFAULT);

		// Create enums
		visibilityKindEEnum = createEEnum(VISIBILITY_KIND);
		modifierKindEEnum = createEEnum(MODIFIER_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(propertyRuleEClass, PropertyRule.class, "PropertyRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyRule_Visibility(), this.getVisibilityKind(), "visibility", null, 0, 1, PropertyRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyRule_IsDerived(), theEcorePackage.getEString(), "isDerived", null, 0, 1, PropertyRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyRule_Name(), theEcorePackage.getEString(), "name", null, 0, 1, PropertyRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyRule_Type(), this.getTypeRule(), null, "type", null, 0, 1, PropertyRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyRule_Multiplicity(), this.getMultiplicityRule(), null, "multiplicity", null, 0, 1, PropertyRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyRule_Modifiers(), this.getModifiersRule(), null, "modifiers", null, 0, 1, PropertyRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyRule_Default(), this.getDefaultValueRule(), null, "default", null, 0, 1, PropertyRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeRuleEClass, TypeRule.class, "TypeRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeRule_Path(), this.getQualifiedName(), null, "path", null, 0, 1, TypeRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeRule_Type(), theUMLPackage.getClassifier(), null, "type", null, 0, 1, TypeRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualifiedNameEClass, QualifiedName.class, "QualifiedName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualifiedName_Path(), theUMLPackage.getNamespace(), null, "path", null, 0, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualifiedName_Remaining(), this.getQualifiedName(), null, "remaining", null, 0, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicityRuleEClass, MultiplicityRule.class, "MultiplicityRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplicityRule_Bounds(), this.getBoundSpecification(), null, "bounds", null, 0, -1, MultiplicityRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boundSpecificationEClass, BoundSpecification.class, "BoundSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoundSpecification_Value(), theEcorePackage.getEString(), "value", null, 0, 1, BoundSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifiersRuleEClass, ModifiersRule.class, "ModifiersRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifiersRule_Values(), this.getModifierSpecification(), null, "values", null, 0, -1, ModifiersRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifierSpecificationEClass, ModifierSpecification.class, "ModifierSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModifierSpecification_Value(), this.getModifierKind(), "value", null, 0, 1, ModifierSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifierSpecification_Redefines(), this.getRedefinesRule(), null, "redefines", null, 0, 1, ModifierSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifierSpecification_Subsets(), this.getSubsetsRule(), null, "subsets", null, 0, 1, ModifierSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(redefinesRuleEClass, RedefinesRule.class, "RedefinesRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRedefinesRule_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, RedefinesRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subsetsRuleEClass, SubsetsRule.class, "SubsetsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsetsRule_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, SubsetsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultValueRuleEClass, DefaultValueRule.class, "DefaultValueRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefaultValueRule_Default(), theEcorePackage.getEString(), "default", null, 0, 1, DefaultValueRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(visibilityKindEEnum, VisibilityKind.class, "VisibilityKind");
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PUBLIC);
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PRIVATE);
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PROTECTED);
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PACKAGE);

		initEEnum(modifierKindEEnum, ModifierKind.class, "ModifierKind");
		addEEnumLiteral(modifierKindEEnum, ModifierKind.READ_ONLY);
		addEEnumLiteral(modifierKindEEnum, ModifierKind.UNION);
		addEEnumLiteral(modifierKindEEnum, ModifierKind.ORDERED);
		addEEnumLiteral(modifierKindEEnum, ModifierKind.UNIQUE);

		// Create resource
		createResource(eNS_URI);
	}

} //UmlPropertyPackageImpl
