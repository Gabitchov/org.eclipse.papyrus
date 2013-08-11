/**
 */
package org.eclipse.papyrus.facade.virtualmetamodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.facade.FacadePackage;

import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;

import org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl;

import org.eclipse.papyrus.facade.impl.FacadePackageImpl;

import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelFactory;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualmetamodelPackageImpl extends EPackageImpl implements VirtualmetamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualMetamodelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualMetaclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualDatatypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualEnumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualLiteralEClass = null;

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
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VirtualmetamodelPackageImpl() {
		super(eNS_URI, VirtualmetamodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link VirtualmetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VirtualmetamodelPackage init() {
		if (isInited) return (VirtualmetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(VirtualmetamodelPackage.eNS_URI);

		// Obtain or create and register package
		VirtualmetamodelPackageImpl theVirtualmetamodelPackage = (VirtualmetamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VirtualmetamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VirtualmetamodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		FacadePackageImpl theFacadePackage = (FacadePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FacadePackage.eNS_URI) instanceof FacadePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FacadePackage.eNS_URI) : FacadePackage.eINSTANCE);
		ExtensiondefinitionPackageImpl theExtensiondefinitionPackage = (ExtensiondefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensiondefinitionPackage.eNS_URI) instanceof ExtensiondefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensiondefinitionPackage.eNS_URI) : ExtensiondefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theVirtualmetamodelPackage.createPackageContents();
		theFacadePackage.createPackageContents();
		theExtensiondefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theVirtualmetamodelPackage.initializePackageContents();
		theFacadePackage.initializePackageContents();
		theExtensiondefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVirtualmetamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VirtualmetamodelPackage.eNS_URI, theVirtualmetamodelPackage);
		return theVirtualmetamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualMetamodel() {
		return virtualMetamodelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualMetamodel_Name() {
		return (EAttribute)virtualMetamodelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualMetamodel_NsPrefix() {
		return (EAttribute)virtualMetamodelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualMetamodel_NsURI() {
		return (EAttribute)virtualMetamodelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualMetamodel_VirtualClassifiers() {
		return (EReference)virtualMetamodelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualMetamodel_Facade() {
		return (EReference)virtualMetamodelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualElement() {
		return virtualElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualElement_AliasName() {
		return (EAttribute)virtualElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualElement_Kept() {
		return (EAttribute)virtualElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualElement_RepresentedElement() {
		return (EReference)virtualElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualClassifier() {
		return virtualClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualClassifier_Metamodel() {
		return (EReference)virtualClassifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualMetaclass() {
		return virtualMetaclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualMetaclass_Abstract() {
		return (EAttribute)virtualMetaclassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualMetaclass_AppliedStereotypes() {
		return (EReference)virtualMetaclassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualMetaclass_Operations() {
		return (EReference)virtualMetaclassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualMetaclass_Parents() {
		return (EReference)virtualMetaclassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualMetaclass_Properties() {
		return (EReference)virtualMetaclassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualMetaclass_StereotypeInterface() {
		return (EAttribute)virtualMetaclassEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualProperty() {
		return virtualPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualProperty_Lower() {
		return (EAttribute)virtualPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualProperty_Upper() {
		return (EAttribute)virtualPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualProperty_VirtualMetaclass() {
		return (EReference)virtualPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualOperation() {
		return virtualOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualOperation_Parameters() {
		return (EReference)virtualOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualParameter() {
		return virtualParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualDatatype() {
		return virtualDatatypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualEnum() {
		return virtualEnumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualEnum_Literals() {
		return (EReference)virtualEnumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualLiteral() {
		return virtualLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualmetamodelFactory getVirtualmetamodelFactory() {
		return (VirtualmetamodelFactory)getEFactoryInstance();
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
		virtualMetamodelEClass = createEClass(VIRTUAL_METAMODEL);
		createEAttribute(virtualMetamodelEClass, VIRTUAL_METAMODEL__NAME);
		createEAttribute(virtualMetamodelEClass, VIRTUAL_METAMODEL__NS_PREFIX);
		createEAttribute(virtualMetamodelEClass, VIRTUAL_METAMODEL__NS_URI);
		createEReference(virtualMetamodelEClass, VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS);
		createEReference(virtualMetamodelEClass, VIRTUAL_METAMODEL__FACADE);

		virtualElementEClass = createEClass(VIRTUAL_ELEMENT);
		createEAttribute(virtualElementEClass, VIRTUAL_ELEMENT__ALIAS_NAME);
		createEAttribute(virtualElementEClass, VIRTUAL_ELEMENT__KEPT);
		createEReference(virtualElementEClass, VIRTUAL_ELEMENT__REPRESENTED_ELEMENT);

		virtualClassifierEClass = createEClass(VIRTUAL_CLASSIFIER);
		createEReference(virtualClassifierEClass, VIRTUAL_CLASSIFIER__METAMODEL);

		virtualMetaclassEClass = createEClass(VIRTUAL_METACLASS);
		createEAttribute(virtualMetaclassEClass, VIRTUAL_METACLASS__ABSTRACT);
		createEReference(virtualMetaclassEClass, VIRTUAL_METACLASS__APPLIED_STEREOTYPES);
		createEReference(virtualMetaclassEClass, VIRTUAL_METACLASS__OPERATIONS);
		createEReference(virtualMetaclassEClass, VIRTUAL_METACLASS__PARENTS);
		createEReference(virtualMetaclassEClass, VIRTUAL_METACLASS__PROPERTIES);
		createEAttribute(virtualMetaclassEClass, VIRTUAL_METACLASS__STEREOTYPE_INTERFACE);

		virtualPropertyEClass = createEClass(VIRTUAL_PROPERTY);
		createEAttribute(virtualPropertyEClass, VIRTUAL_PROPERTY__LOWER);
		createEAttribute(virtualPropertyEClass, VIRTUAL_PROPERTY__UPPER);
		createEReference(virtualPropertyEClass, VIRTUAL_PROPERTY__VIRTUAL_METACLASS);

		virtualOperationEClass = createEClass(VIRTUAL_OPERATION);
		createEReference(virtualOperationEClass, VIRTUAL_OPERATION__PARAMETERS);

		virtualParameterEClass = createEClass(VIRTUAL_PARAMETER);

		virtualDatatypeEClass = createEClass(VIRTUAL_DATATYPE);

		virtualEnumEClass = createEClass(VIRTUAL_ENUM);
		createEReference(virtualEnumEClass, VIRTUAL_ENUM__LITERALS);

		virtualLiteralEClass = createEClass(VIRTUAL_LITERAL);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		FacadePackage theFacadePackage = (FacadePackage)EPackage.Registry.INSTANCE.getEPackage(FacadePackage.eNS_URI);
		ExtensiondefinitionPackage theExtensiondefinitionPackage = (ExtensiondefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(ExtensiondefinitionPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		virtualClassifierEClass.getESuperTypes().add(this.getVirtualElement());
		virtualMetaclassEClass.getESuperTypes().add(this.getVirtualClassifier());
		virtualPropertyEClass.getESuperTypes().add(this.getVirtualElement());
		virtualOperationEClass.getESuperTypes().add(this.getVirtualElement());
		virtualParameterEClass.getESuperTypes().add(this.getVirtualElement());
		virtualDatatypeEClass.getESuperTypes().add(this.getVirtualClassifier());
		virtualEnumEClass.getESuperTypes().add(this.getVirtualClassifier());
		virtualLiteralEClass.getESuperTypes().add(this.getVirtualElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(virtualMetamodelEClass, VirtualMetamodel.class, "VirtualMetamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVirtualMetamodel_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VirtualMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVirtualMetamodel_NsPrefix(), theEcorePackage.getEString(), "nsPrefix", null, 0, 1, VirtualMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVirtualMetamodel_NsURI(), theEcorePackage.getEString(), "nsURI", null, 0, 1, VirtualMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVirtualMetamodel_VirtualClassifiers(), this.getVirtualClassifier(), this.getVirtualClassifier_Metamodel(), "virtualClassifiers", null, 0, -1, VirtualMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVirtualMetamodel_Facade(), theFacadePackage.getFacade(), theFacadePackage.getFacade_Virtualmetamodel(), "facade", null, 1, 1, VirtualMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualElementEClass, VirtualElement.class, "VirtualElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVirtualElement_AliasName(), ecorePackage.getEString(), "aliasName", null, 0, 1, VirtualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVirtualElement_Kept(), ecorePackage.getEBoolean(), "kept", null, 1, 1, VirtualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVirtualElement_RepresentedElement(), theEcorePackage.getEObject(), null, "representedElement", null, 1, 1, VirtualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualClassifierEClass, VirtualClassifier.class, "VirtualClassifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVirtualClassifier_Metamodel(), this.getVirtualMetamodel(), this.getVirtualMetamodel_VirtualClassifiers(), "metamodel", null, 1, 1, VirtualClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualMetaclassEClass, VirtualMetaclass.class, "VirtualMetaclass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVirtualMetaclass_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, VirtualMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVirtualMetaclass_AppliedStereotypes(), theExtensiondefinitionPackage.getBaseMetaclass(), null, "appliedStereotypes", null, 0, -1, VirtualMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVirtualMetaclass_Operations(), this.getVirtualOperation(), null, "operations", null, 0, -1, VirtualMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVirtualMetaclass_Parents(), this.getVirtualMetaclass(), null, "parents", null, 0, -1, VirtualMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVirtualMetaclass_Properties(), this.getVirtualProperty(), this.getVirtualProperty_VirtualMetaclass(), "properties", null, 0, -1, VirtualMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVirtualMetaclass_StereotypeInterface(), theTypesPackage.getBoolean(), "stereotypeInterface", null, 1, 1, VirtualMetaclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualPropertyEClass, VirtualProperty.class, "VirtualProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVirtualProperty_Lower(), ecorePackage.getEInt(), "lower", null, 1, 1, VirtualProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVirtualProperty_Upper(), ecorePackage.getEInt(), "upper", null, 1, 1, VirtualProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVirtualProperty_VirtualMetaclass(), this.getVirtualMetaclass(), this.getVirtualMetaclass_Properties(), "virtualMetaclass", null, 1, 1, VirtualProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualOperationEClass, VirtualOperation.class, "VirtualOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVirtualOperation_Parameters(), this.getVirtualParameter(), null, "parameters", null, 0, -1, VirtualOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualParameterEClass, VirtualParameter.class, "VirtualParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(virtualDatatypeEClass, VirtualDatatype.class, "VirtualDatatype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(virtualEnumEClass, VirtualEnum.class, "VirtualEnum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVirtualEnum_Literals(), this.getVirtualLiteral(), null, "literals", null, 0, -1, VirtualEnum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualLiteralEClass, VirtualLiteral.class, "VirtualLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //VirtualmetamodelPackageImpl
