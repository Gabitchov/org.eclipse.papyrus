/**
 */
package org.eclipse.papyrus.facademapping.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.facademapping.ExtensionDefinitionKind;
import org.eclipse.papyrus.facademapping.FacadeMappping;
import org.eclipse.papyrus.facademapping.FacademappingFactory;
import org.eclipse.papyrus.facademapping.FacademappingPackage;
import org.eclipse.papyrus.facademapping.Mapping;
import org.eclipse.papyrus.facademapping.StereotypedMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FacademappingPackageImpl extends EPackageImpl implements FacademappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypedMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facadeMapppingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum extensionDefinitionKindEEnum = null;

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
	 * @see org.eclipse.papyrus.facademapping.FacademappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FacademappingPackageImpl() {
		super(eNS_URI, FacademappingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FacademappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FacademappingPackage init() {
		if (isInited) return (FacademappingPackage)EPackage.Registry.INSTANCE.getEPackage(FacademappingPackage.eNS_URI);

		// Obtain or create and register package
		FacademappingPackageImpl theFacademappingPackage = (FacademappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FacademappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FacademappingPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFacademappingPackage.createPackageContents();

		// Initialize created meta-data
		theFacademappingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFacademappingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FacademappingPackage.eNS_URI, theFacademappingPackage);
		return theFacademappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_UmlElement() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_SpecificDomainElement() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypedMapping() {
		return stereotypedMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypedMapping_AppliedStereotypes() {
		return (EReference)stereotypedMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypedMapping_Kind() {
		return (EAttribute)stereotypedMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacadeMappping() {
		return facadeMapppingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacadeMappping_Mappings() {
		return (EReference)facadeMapppingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExtensionDefinitionKind() {
		return extensionDefinitionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacademappingFactory getFacademappingFactory() {
		return (FacademappingFactory)getEFactoryInstance();
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
		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__UML_ELEMENT);
		createEReference(mappingEClass, MAPPING__SPECIFIC_DOMAIN_ELEMENT);

		stereotypedMappingEClass = createEClass(STEREOTYPED_MAPPING);
		createEReference(stereotypedMappingEClass, STEREOTYPED_MAPPING__APPLIED_STEREOTYPES);
		createEAttribute(stereotypedMappingEClass, STEREOTYPED_MAPPING__KIND);

		facadeMapppingEClass = createEClass(FACADE_MAPPPING);
		createEReference(facadeMapppingEClass, FACADE_MAPPPING__MAPPINGS);

		// Create enums
		extensionDefinitionKindEEnum = createEEnum(EXTENSION_DEFINITION_KIND);
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
		stereotypedMappingEClass.getESuperTypes().add(this.getMapping());

		// Initialize classes, features, and operations; add parameters
		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_UmlElement(), ecorePackage.getEObject(), null, "umlElement", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_SpecificDomainElement(), ecorePackage.getEObject(), null, "specificDomainElement", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stereotypedMappingEClass, StereotypedMapping.class, "StereotypedMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStereotypedMapping_AppliedStereotypes(), ecorePackage.getEObject(), null, "appliedStereotypes", null, 1, -1, StereotypedMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStereotypedMapping_Kind(), this.getExtensionDefinitionKind(), "kind", null, 0, 1, StereotypedMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facadeMapppingEClass, FacadeMappping.class, "FacadeMappping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFacadeMappping_Mappings(), this.getMapping(), null, "mappings", null, 0, -1, FacadeMappping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(extensionDefinitionKindEEnum, ExtensionDefinitionKind.class, "ExtensionDefinitionKind");
		addEEnumLiteral(extensionDefinitionKindEEnum, ExtensionDefinitionKind.ASSOCIATION);
		addEEnumLiteral(extensionDefinitionKindEEnum, ExtensionDefinitionKind.GENERALIZATION);
		addEEnumLiteral(extensionDefinitionKindEEnum, ExtensionDefinitionKind.MULTI_GENERALIZATION);
		addEEnumLiteral(extensionDefinitionKindEEnum, ExtensionDefinitionKind.FUSION);

		// Create resource
		createResource(eNS_URI);
	}

} //FacademappingPackageImpl
