/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.extensiondefinition.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.facade.FacadePackage;

import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionFactory;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;

import org.eclipse.papyrus.facade.impl.FacadePackageImpl;

import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

import org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtensiondefinitionPackageImpl extends EPackageImpl implements ExtensiondefinitionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseMetaclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass combinationEClass = null;

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
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExtensiondefinitionPackageImpl() {
		super(eNS_URI, ExtensiondefinitionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExtensiondefinitionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExtensiondefinitionPackage init() {
		if (isInited) return (ExtensiondefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(ExtensiondefinitionPackage.eNS_URI);

		// Obtain or create and register package
		ExtensiondefinitionPackageImpl theExtensiondefinitionPackage = (ExtensiondefinitionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExtensiondefinitionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExtensiondefinitionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		FacadePackageImpl theFacadePackage = (FacadePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FacadePackage.eNS_URI) instanceof FacadePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FacadePackage.eNS_URI) : FacadePackage.eINSTANCE);
		VirtualmetamodelPackageImpl theVirtualmetamodelPackage = (VirtualmetamodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VirtualmetamodelPackage.eNS_URI) instanceof VirtualmetamodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VirtualmetamodelPackage.eNS_URI) : VirtualmetamodelPackage.eINSTANCE);

		// Create package meta-data objects
		theExtensiondefinitionPackage.createPackageContents();
		theFacadePackage.createPackageContents();
		theVirtualmetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theExtensiondefinitionPackage.initializePackageContents();
		theFacadePackage.initializePackageContents();
		theVirtualmetamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExtensiondefinitionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExtensiondefinitionPackage.eNS_URI, theExtensiondefinitionPackage);
		return theExtensiondefinitionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionDefinition() {
		return extensionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionDefinition_Extension() {
		return (EReference)extensionDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionDefinition_BaseMetaclasses() {
		return (EReference)extensionDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionDefinition_Facade() {
		return (EReference)extensionDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionDefinition_Stereotype() {
		return (EReference)extensionDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionDefinition_Kind() {
		return (EAttribute)extensionDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseMetaclass() {
		return baseMetaclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseMetaclass_IncompatibleStereotypes() {
		return (EReference)baseMetaclassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseMetaclass_Base() {
		return (EReference)baseMetaclassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseMetaclass_ExtensionDefinition() {
		return (EReference)baseMetaclassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseMetaclass_CompatibleStereotypes() {
		return (EReference)baseMetaclassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseMetaclass_Possible() {
		return (EAttribute)baseMetaclassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCombination() {
		return combinationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombination_Members() {
		return (EReference)combinationEClass.getEStructuralFeatures().get(0);
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
	public ExtensiondefinitionFactory getExtensiondefinitionFactory() {
		return (ExtensiondefinitionFactory)getEFactoryInstance();
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
		extensionDefinitionEClass = createEClass(EXTENSION_DEFINITION);
		createEReference(extensionDefinitionEClass, EXTENSION_DEFINITION__EXTENSION);
		createEReference(extensionDefinitionEClass, EXTENSION_DEFINITION__BASE_METACLASSES);
		createEReference(extensionDefinitionEClass, EXTENSION_DEFINITION__FACADE);
		createEReference(extensionDefinitionEClass, EXTENSION_DEFINITION__STEREOTYPE);
		createEAttribute(extensionDefinitionEClass, EXTENSION_DEFINITION__KIND);

		baseMetaclassEClass = createEClass(BASE_METACLASS);
		createEReference(baseMetaclassEClass, BASE_METACLASS__INCOMPATIBLE_STEREOTYPES);
		createEReference(baseMetaclassEClass, BASE_METACLASS__BASE);
		createEReference(baseMetaclassEClass, BASE_METACLASS__EXTENSION_DEFINITION);
		createEReference(baseMetaclassEClass, BASE_METACLASS__COMPATIBLE_STEREOTYPES);
		createEAttribute(baseMetaclassEClass, BASE_METACLASS__POSSIBLE);

		combinationEClass = createEClass(COMBINATION);
		createEReference(combinationEClass, COMBINATION__MEMBERS);

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

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		FacadePackage theFacadePackage = (FacadePackage)EPackage.Registry.INSTANCE.getEPackage(FacadePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(extensionDefinitionEClass, ExtensionDefinition.class, "ExtensionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionDefinition_Extension(), theUMLPackage.getExtension(), null, "extension", null, 1, 1, ExtensionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionDefinition_BaseMetaclasses(), this.getBaseMetaclass(), this.getBaseMetaclass_ExtensionDefinition(), "baseMetaclasses", null, 0, -1, ExtensionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionDefinition_Facade(), theFacadePackage.getFacade(), theFacadePackage.getFacade_ExtensionDefinitions(), "facade", null, 1, 1, ExtensionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionDefinition_Stereotype(), theUMLPackage.getStereotype(), null, "stereotype", null, 1, 1, ExtensionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtensionDefinition_Kind(), this.getExtensionDefinitionKind(), "kind", null, 1, 1, ExtensionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(baseMetaclassEClass, BaseMetaclass.class, "BaseMetaclass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBaseMetaclass_IncompatibleStereotypes(), this.getCombination(), null, "incompatibleStereotypes", null, 0, -1, BaseMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBaseMetaclass_Base(), ecorePackage.getEObject(), null, "base", null, 1, 1, BaseMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBaseMetaclass_ExtensionDefinition(), this.getExtensionDefinition(), this.getExtensionDefinition_BaseMetaclasses(), "extensionDefinition", null, 1, 1, BaseMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBaseMetaclass_CompatibleStereotypes(), this.getCombination(), null, "compatibleStereotypes", null, 0, -1, BaseMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseMetaclass_Possible(), ecorePackage.getEBoolean(), "possible", null, 1, 1, BaseMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(combinationEClass, Combination.class, "Combination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCombination_Members(), this.getBaseMetaclass(), null, "members", null, 0, -1, Combination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(extensionDefinitionKindEEnum, ExtensionDefinitionKind.class, "ExtensionDefinitionKind");
		addEEnumLiteral(extensionDefinitionKindEEnum, ExtensionDefinitionKind.ASSOCIATION);
		addEEnumLiteral(extensionDefinitionKindEEnum, ExtensionDefinitionKind.GENERALIZATION);
		addEEnumLiteral(extensionDefinitionKindEEnum, ExtensionDefinitionKind.MULTI_GENERALIZATION);
		addEEnumLiteral(extensionDefinitionKindEEnum, ExtensionDefinitionKind.FUSION);
	}

} //ExtensiondefinitionPackageImpl
