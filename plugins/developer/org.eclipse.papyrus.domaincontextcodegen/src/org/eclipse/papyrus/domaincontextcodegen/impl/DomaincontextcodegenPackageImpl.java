/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.domaincontextcodegen.AdviceBinding;
import org.eclipse.papyrus.domaincontextcodegen.Binding;
import org.eclipse.papyrus.domaincontextcodegen.DomainContext;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenFactory;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypes;
import org.eclipse.papyrus.domaincontextcodegen.GenHandlers;
import org.eclipse.papyrus.domaincontextcodegen.InheritanceKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DomaincontextcodegenPackageImpl extends EPackageImpl implements DomaincontextcodegenPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass domainContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementTypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass adviceBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass bindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass genHandlersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum inheritanceKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DomaincontextcodegenPackageImpl() {
		super(eNS_URI, DomaincontextcodegenFactory.eINSTANCE);
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
	 * This method is used to initialize {@link DomaincontextcodegenPackage#eINSTANCE} when that field is accessed. Clients should not invoke it
	 * directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DomaincontextcodegenPackage init() {
		if(isInited)
			return (DomaincontextcodegenPackage)EPackage.Registry.INSTANCE.getEPackage(DomaincontextcodegenPackage.eNS_URI);

		// Obtain or create and register package
		DomaincontextcodegenPackageImpl theDomaincontextcodegenPackage = (DomaincontextcodegenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DomaincontextcodegenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DomaincontextcodegenPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDomaincontextcodegenPackage.createPackageContents();

		// Initialize created meta-data
		theDomaincontextcodegenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDomaincontextcodegenPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DomaincontextcodegenPackage.eNS_URI, theDomaincontextcodegenPackage);
		return theDomaincontextcodegenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDomainContext() {
		return domainContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_TypeProjectName() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_HandlerProjectName() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_IClientContextID() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_Metamodel() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_SpecializationOf() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_ElementTypeIDPrefix() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_ElementTypeNamePrefix() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_MatcherPatch() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_ElementTypes() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_DefaultHelperPath() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_Advicebindings() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_Bindings() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_GenHandlers() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_GeneratedSourceFolder() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementTypes() {
		return elementTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementTypes_Types() {
		return (EReference)elementTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementType() {
		return elementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementType_MetaClass() {
		return (EReference)elementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementType_SpecificName() {
		return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementType_Edithelper_EditHelperAdvicePath() {
		return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementType_Kind() {
		return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementType_Specializationof() {
		return (EReference)elementTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementType_SpecializationIDof() {
		return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAdviceBinding() {
		return adviceBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAdviceBinding_AdvicePath() {
		return (EAttribute)adviceBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAdviceBinding_AdviceID() {
		return (EAttribute)adviceBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAdviceBinding_Inheritance() {
		return (EAttribute)adviceBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAdviceBinding_ElementTypeRef() {
		return (EReference)adviceBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAdviceBinding_ElementTypeIDref() {
		return (EAttribute)adviceBindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBinding() {
		return bindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getBinding_Advice() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBinding_ElementTypePattern() {
		return (EAttribute)bindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBinding_AdviceID() {
		return (EAttribute)bindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGenHandlers() {
		return genHandlersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_HandlerPackage() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_SuperClass() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_SuperClassPackage() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_ElementTypeEnumerator() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_ElementTypeEnumeratorPackage() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getInheritanceKind() {
		return inheritanceKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomaincontextcodegenFactory getDomaincontextcodegenFactory() {
		return (DomaincontextcodegenFactory)getEFactoryInstance();
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
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		domainContextEClass = createEClass(DOMAIN_CONTEXT);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__TYPE_PROJECT_NAME);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__HANDLER_PROJECT_NAME);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__METAMODEL);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__SPECIALIZATION_OF);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__MATCHER_PATCH);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__ELEMENT_TYPES);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__DEFAULT_HELPER_PATH);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__ADVICEBINDINGS);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__BINDINGS);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__GEN_HANDLERS);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER);

		elementTypesEClass = createEClass(ELEMENT_TYPES);
		createEReference(elementTypesEClass, ELEMENT_TYPES__TYPES);

		elementTypeEClass = createEClass(ELEMENT_TYPE);
		createEReference(elementTypeEClass, ELEMENT_TYPE__META_CLASS);
		createEAttribute(elementTypeEClass, ELEMENT_TYPE__SPECIFIC_NAME);
		createEAttribute(elementTypeEClass, ELEMENT_TYPE__EDITHELPER_EDIT_HELPER_ADVICE_PATH);
		createEAttribute(elementTypeEClass, ELEMENT_TYPE__KIND);
		createEReference(elementTypeEClass, ELEMENT_TYPE__SPECIALIZATIONOF);
		createEAttribute(elementTypeEClass, ELEMENT_TYPE__SPECIALIZATION_IDOF);

		adviceBindingEClass = createEClass(ADVICE_BINDING);
		createEAttribute(adviceBindingEClass, ADVICE_BINDING__ADVICE_PATH);
		createEAttribute(adviceBindingEClass, ADVICE_BINDING__ADVICE_ID);
		createEAttribute(adviceBindingEClass, ADVICE_BINDING__INHERITANCE);
		createEReference(adviceBindingEClass, ADVICE_BINDING__ELEMENT_TYPE_REF);
		createEAttribute(adviceBindingEClass, ADVICE_BINDING__ELEMENT_TYPE_IDREF);

		bindingEClass = createEClass(BINDING);
		createEReference(bindingEClass, BINDING__ADVICE);
		createEAttribute(bindingEClass, BINDING__ELEMENT_TYPE_PATTERN);
		createEAttribute(bindingEClass, BINDING__ADVICE_ID);

		genHandlersEClass = createEClass(GEN_HANDLERS);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__HANDLER_PACKAGE);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__SUPER_CLASS);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__SUPER_CLASS_PACKAGE);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR_PACKAGE);

		// Create enums
		inheritanceKindEEnum = createEEnum(INHERITANCE_KIND);
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
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(domainContextEClass, DomainContext.class, "DomainContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainContext_TypeProjectName(), ecorePackage.getEString(), "typeProjectName", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_HandlerProjectName(), ecorePackage.getEString(), "handlerProjectName", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_IClientContextID(), ecorePackage.getEString(), "IClientContextID", null, 0, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_Metamodel(), ecorePackage.getEPackage(), null, "metamodel", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_SpecializationOf(), this.getDomainContext(), null, "specializationOf", null, 0, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_ElementTypeIDPrefix(), ecorePackage.getEString(), "elementTypeIDPrefix", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_ElementTypeNamePrefix(), ecorePackage.getEString(), "elementTypeNamePrefix", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_MatcherPatch(), ecorePackage.getEString(), "matcherPatch", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_ElementTypes(), this.getElementTypes(), null, "elementTypes", null, 0, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_DefaultHelperPath(), ecorePackage.getEString(), "defaultHelperPath", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_Advicebindings(), this.getAdviceBinding(), null, "advicebindings", null, 0, -1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_Bindings(), this.getBinding(), null, "bindings", null, 0, -1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_GenHandlers(), this.getGenHandlers(), null, "genHandlers", null, 0, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_GeneratedSourceFolder(), ecorePackage.getEString(), "generatedSourceFolder", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTypesEClass, ElementTypes.class, "ElementTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementTypes_Types(), this.getElementType(), null, "types", null, 0, -1, ElementTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTypeEClass, ElementType.class, "ElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementType_MetaClass(), ecorePackage.getEClass(), null, "metaClass", null, 1, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementType_SpecificName(), ecorePackage.getEString(), "specificName", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementType_Edithelper_EditHelperAdvicePath(), ecorePackage.getEString(), "edithelper_EditHelperAdvicePath", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementType_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementType_Specializationof(), this.getElementType(), null, "specializationof", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementType_SpecializationIDof(), ecorePackage.getEString(), "specializationIDof", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adviceBindingEClass, AdviceBinding.class, "AdviceBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdviceBinding_AdvicePath(), ecorePackage.getEString(), "advicePath", null, 0, 1, AdviceBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdviceBinding_AdviceID(), ecorePackage.getEString(), "adviceID", null, 0, 1, AdviceBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdviceBinding_Inheritance(), this.getInheritanceKind(), "inheritance", null, 0, 1, AdviceBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdviceBinding_ElementTypeRef(), this.getElementType(), null, "elementTypeRef", null, 0, 1, AdviceBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdviceBinding_ElementTypeIDref(), ecorePackage.getEString(), "elementTypeIDref", null, 0, 1, AdviceBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingEClass, Binding.class, "Binding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinding_Advice(), this.getAdviceBinding(), null, "advice", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinding_ElementTypePattern(), ecorePackage.getEString(), "elementTypePattern", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinding_AdviceID(), ecorePackage.getEString(), "adviceID", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genHandlersEClass, GenHandlers.class, "GenHandlers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenHandlers_HandlerPackage(), ecorePackage.getEString(), "handlerPackage", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenHandlers_SuperClass(), ecorePackage.getEString(), "superClass", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenHandlers_SuperClassPackage(), ecorePackage.getEString(), "superClassPackage", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenHandlers_ElementTypeEnumerator(), ecorePackage.getEString(), "elementTypeEnumerator", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenHandlers_ElementTypeEnumeratorPackage(), ecorePackage.getEString(), "elementTypeEnumeratorPackage", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(inheritanceKindEEnum, InheritanceKind.class, "InheritanceKind");
		addEEnumLiteral(inheritanceKindEEnum, InheritanceKind.NONE);
		addEEnumLiteral(inheritanceKindEEnum, InheritanceKind.ALL);

		// Create resource
		createResource(eNS_URI);
	}

} //DomaincontextcodegenPackageImpl
