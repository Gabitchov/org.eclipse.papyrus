/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.facet.infra.query.QueryPackage;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.Tableinstance2Package;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstanceFactory;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrustableinstancePackageImpl extends EPackageImpl implements PapyrustableinstancePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusTableInstanceEClass = null;

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
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrustableinstancePackageImpl() {
		super(eNS_URI, PapyrustableinstanceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PapyrustableinstancePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PapyrustableinstancePackage init() {
		if (isInited) return (PapyrustableinstancePackage)EPackage.Registry.INSTANCE.getEPackage(PapyrustableinstancePackage.eNS_URI);

		// Obtain or create and register package
		PapyrustableinstancePackageImpl thePapyrustableinstancePackage = (PapyrustableinstancePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PapyrustableinstancePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PapyrustableinstancePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Tableinstance2Package.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrustableinstancePackage.createPackageContents();

		// Initialize created meta-data
		thePapyrustableinstancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrustableinstancePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PapyrustableinstancePackage.eNS_URI, thePapyrustableinstancePackage);
		return thePapyrustableinstancePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusTableInstance() {
		return papyrusTableInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTableInstance_Name() {
		return (EAttribute)papyrusTableInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTableInstance_Type() {
		return (EAttribute)papyrusTableInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTableInstance_IsSynchronized() {
		return (EAttribute)papyrusTableInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTableInstance_Table() {
		return (EReference)papyrusTableInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTableInstance_FillingQueries() {
		return (EReference)papyrusTableInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustableinstanceFactory getPapyrustableinstanceFactory() {
		return (PapyrustableinstanceFactory)getEFactoryInstance();
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
		papyrusTableInstanceEClass = createEClass(PAPYRUS_TABLE_INSTANCE);
		createEAttribute(papyrusTableInstanceEClass, PAPYRUS_TABLE_INSTANCE__NAME);
		createEAttribute(papyrusTableInstanceEClass, PAPYRUS_TABLE_INSTANCE__TYPE);
		createEAttribute(papyrusTableInstanceEClass, PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED);
		createEReference(papyrusTableInstanceEClass, PAPYRUS_TABLE_INSTANCE__TABLE);
		createEReference(papyrusTableInstanceEClass, PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES);
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
		Tableinstance2Package theTableinstance2Package = (Tableinstance2Package)EPackage.Registry.INSTANCE.getEPackage(Tableinstance2Package.eNS_URI);
		QueryPackage theQueryPackage = (QueryPackage)EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		papyrusTableInstanceEClass.getESuperTypes().add(theEcorePackage.getEModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(papyrusTableInstanceEClass, PapyrusTableInstance.class, "PapyrusTableInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPapyrusTableInstance_Name(), ecorePackage.getEString(), "name", "no name", 0, 1, PapyrusTableInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPapyrusTableInstance_Type(), ecorePackage.getEString(), "type", "PapyrusDefaultTable", 0, 1, PapyrusTableInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPapyrusTableInstance_IsSynchronized(), ecorePackage.getEBoolean(), "isSynchronized", "false", 0, 1, PapyrusTableInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPapyrusTableInstance_Table(), theTableinstance2Package.getTableInstance2(), null, "table", null, 0, 1, PapyrusTableInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPapyrusTableInstance_FillingQueries(), theQueryPackage.getModelQuery(), null, "fillingQueries", null, 0, -1, PapyrusTableInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PapyrustableinstancePackageImpl
