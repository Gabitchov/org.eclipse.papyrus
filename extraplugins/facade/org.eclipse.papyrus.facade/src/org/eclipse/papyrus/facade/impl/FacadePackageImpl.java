/**
 */
package org.eclipse.papyrus.facade.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.FacadeFactory;
import org.eclipse.papyrus.facade.FacadePackage;

import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;

import org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl;

import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

import org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FacadePackageImpl extends EPackageImpl implements FacadePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facadeEClass = null;

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
	 * @see org.eclipse.papyrus.facade.FacadePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FacadePackageImpl() {
		super(eNS_URI, FacadeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FacadePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FacadePackage init() {
		if (isInited) return (FacadePackage)EPackage.Registry.INSTANCE.getEPackage(FacadePackage.eNS_URI);

		// Obtain or create and register package
		FacadePackageImpl theFacadePackage = (FacadePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FacadePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FacadePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		VirtualmetamodelPackageImpl theVirtualmetamodelPackage = (VirtualmetamodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VirtualmetamodelPackage.eNS_URI) instanceof VirtualmetamodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VirtualmetamodelPackage.eNS_URI) : VirtualmetamodelPackage.eINSTANCE);
		ExtensiondefinitionPackageImpl theExtensiondefinitionPackage = (ExtensiondefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensiondefinitionPackage.eNS_URI) instanceof ExtensiondefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensiondefinitionPackage.eNS_URI) : ExtensiondefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theFacadePackage.createPackageContents();
		theVirtualmetamodelPackage.createPackageContents();
		theExtensiondefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theFacadePackage.initializePackageContents();
		theVirtualmetamodelPackage.initializePackageContents();
		theExtensiondefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFacadePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FacadePackage.eNS_URI, theFacadePackage);
		return theFacadePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacade() {
		return facadeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacade_ExtensionDefinitions() {
		return (EReference)facadeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacade_Virtualmetamodel() {
		return (EReference)facadeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacadeFactory getFacadeFactory() {
		return (FacadeFactory)getEFactoryInstance();
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
		facadeEClass = createEClass(FACADE);
		createEReference(facadeEClass, FACADE__EXTENSION_DEFINITIONS);
		createEReference(facadeEClass, FACADE__VIRTUALMETAMODEL);
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
		VirtualmetamodelPackage theVirtualmetamodelPackage = (VirtualmetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(VirtualmetamodelPackage.eNS_URI);
		ExtensiondefinitionPackage theExtensiondefinitionPackage = (ExtensiondefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(ExtensiondefinitionPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theVirtualmetamodelPackage);
		getESubpackages().add(theExtensiondefinitionPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(facadeEClass, Facade.class, "Facade", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFacade_ExtensionDefinitions(), theExtensiondefinitionPackage.getExtensionDefinition(), theExtensiondefinitionPackage.getExtensionDefinition_Facade(), "extensionDefinitions", null, 0, -1, Facade.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacade_Virtualmetamodel(), theVirtualmetamodelPackage.getVirtualMetamodel(), theVirtualmetamodelPackage.getVirtualMetamodel_Facade(), "virtualmetamodel", null, 0, 1, Facade.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //FacadePackageImpl
