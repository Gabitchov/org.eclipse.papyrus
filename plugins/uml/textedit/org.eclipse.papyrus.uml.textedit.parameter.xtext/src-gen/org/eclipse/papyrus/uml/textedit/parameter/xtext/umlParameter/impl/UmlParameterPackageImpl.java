/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterFactory;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlParameterPackageImpl extends EPackageImpl implements UmlParameterPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass parameterRuleEClass = null;

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
	private EClass effectRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum modifierKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum effectKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlParameterPackageImpl() {
		super(eNS_URI, UmlParameterFactory.eINSTANCE);
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
	 * This method is used to initialize {@link UmlParameterPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlParameterPackage init() {
		if(isInited) {
			return (UmlParameterPackage)EPackage.Registry.INSTANCE.getEPackage(UmlParameterPackage.eNS_URI);
		}

		// Obtain or create and register package
		UmlParameterPackageImpl theUmlParameterPackage = (UmlParameterPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UmlParameterPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UmlParameterPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UmlCommonPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlParameterPackage.createPackageContents();

		// Initialize created meta-data
		theUmlParameterPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlParameterPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlParameterPackage.eNS_URI, theUmlParameterPackage);
		return theUmlParameterPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getParameterRule() {
		return parameterRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getParameterRule_Visibility() {
		return (EAttribute)parameterRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getParameterRule_Direction() {
		return (EAttribute)parameterRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getParameterRule_Name() {
		return (EAttribute)parameterRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getParameterRule_Type() {
		return (EReference)parameterRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getParameterRule_Multiplicity() {
		return (EReference)parameterRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getParameterRule_Modifiers() {
		return (EReference)parameterRuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getParameterRule_Effect() {
		return (EReference)parameterRuleEClass.getEStructuralFeatures().get(6);
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
	public EClass getEffectRule() {
		return effectRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEffectRule_EffectKind() {
		return (EAttribute)effectRuleEClass.getEStructuralFeatures().get(0);
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
	public EEnum getEffectKind() {
		return effectKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlParameterFactory getUmlParameterFactory() {
		return (UmlParameterFactory)getEFactoryInstance();
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
		parameterRuleEClass = createEClass(PARAMETER_RULE);
		createEAttribute(parameterRuleEClass, PARAMETER_RULE__VISIBILITY);
		createEAttribute(parameterRuleEClass, PARAMETER_RULE__DIRECTION);
		createEAttribute(parameterRuleEClass, PARAMETER_RULE__NAME);
		createEReference(parameterRuleEClass, PARAMETER_RULE__TYPE);
		createEReference(parameterRuleEClass, PARAMETER_RULE__MULTIPLICITY);
		createEReference(parameterRuleEClass, PARAMETER_RULE__MODIFIERS);
		createEReference(parameterRuleEClass, PARAMETER_RULE__EFFECT);

		modifiersRuleEClass = createEClass(MODIFIERS_RULE);
		createEReference(modifiersRuleEClass, MODIFIERS_RULE__VALUES);

		modifierSpecificationEClass = createEClass(MODIFIER_SPECIFICATION);
		createEAttribute(modifierSpecificationEClass, MODIFIER_SPECIFICATION__VALUE);

		effectRuleEClass = createEClass(EFFECT_RULE);
		createEAttribute(effectRuleEClass, EFFECT_RULE__EFFECT_KIND);

		// Create enums
		modifierKindEEnum = createEEnum(MODIFIER_KIND);
		effectKindEEnum = createEEnum(EFFECT_KIND);
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
		UmlCommonPackage theUmlCommonPackage = (UmlCommonPackage)EPackage.Registry.INSTANCE.getEPackage(UmlCommonPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(parameterRuleEClass, ParameterRule.class, "ParameterRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterRule_Visibility(), theUmlCommonPackage.getVisibilityKind(), "visibility", null, 0, 1, ParameterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterRule_Direction(), theUmlCommonPackage.getDirection(), "direction", null, 0, 1, ParameterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterRule_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ParameterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterRule_Type(), theUmlCommonPackage.getTypeRule(), null, "type", null, 0, 1, ParameterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterRule_Multiplicity(), theUmlCommonPackage.getMultiplicityRule(), null, "multiplicity", null, 0, 1, ParameterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterRule_Modifiers(), this.getModifiersRule(), null, "modifiers", null, 0, 1, ParameterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterRule_Effect(), this.getEffectRule(), null, "effect", null, 0, 1, ParameterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifiersRuleEClass, ModifiersRule.class, "ModifiersRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifiersRule_Values(), this.getModifierSpecification(), null, "values", null, 0, -1, ModifiersRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifierSpecificationEClass, ModifierSpecification.class, "ModifierSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModifierSpecification_Value(), this.getModifierKind(), "value", null, 0, 1, ModifierSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(effectRuleEClass, EffectRule.class, "EffectRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEffectRule_EffectKind(), this.getEffectKind(), "effectKind", null, 0, 1, EffectRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(modifierKindEEnum, ModifierKind.class, "ModifierKind");
		addEEnumLiteral(modifierKindEEnum, ModifierKind.EXCEPTION);
		addEEnumLiteral(modifierKindEEnum, ModifierKind.STREAM);
		addEEnumLiteral(modifierKindEEnum, ModifierKind.ORDERED);
		addEEnumLiteral(modifierKindEEnum, ModifierKind.UNIQUE);

		initEEnum(effectKindEEnum, EffectKind.class, "EffectKind");
		addEEnumLiteral(effectKindEEnum, EffectKind.CREATE);
		addEEnumLiteral(effectKindEEnum, EffectKind.READ);
		addEEnumLiteral(effectKindEEnum, EffectKind.UPDATE);
		addEEnumLiteral(effectKindEEnum, EffectKind.DELETE);

		// Create resource
		createResource(eNS_URI);
	}

} //UmlParameterPackageImpl
