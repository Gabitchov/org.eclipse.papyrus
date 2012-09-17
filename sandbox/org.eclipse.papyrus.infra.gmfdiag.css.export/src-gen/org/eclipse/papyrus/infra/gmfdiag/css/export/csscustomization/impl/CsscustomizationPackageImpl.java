/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CsscustomizationPackageImpl extends EPackageImpl implements CsscustomizationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cssStylesheetEClass = null;

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
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CsscustomizationPackageImpl() {
		super(eNS_URI, CsscustomizationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CsscustomizationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CsscustomizationPackage init() {
		if (isInited) return (CsscustomizationPackage)EPackage.Registry.INSTANCE.getEPackage(CsscustomizationPackage.eNS_URI);

		// Obtain or create and register package
		CsscustomizationPackageImpl theCsscustomizationPackage = (CsscustomizationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CsscustomizationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CsscustomizationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CustomizationPluginPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCsscustomizationPackage.createPackageContents();

		// Initialize created meta-data
		theCsscustomizationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCsscustomizationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CsscustomizationPackage.eNS_URI, theCsscustomizationPackage);
		return theCsscustomizationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCSSStylesheet() {
		return cssStylesheetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCSSStylesheet_Theme() {
		return (EAttribute)cssStylesheetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCSSStylesheet_Icon() {
		return (EAttribute)cssStylesheetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCSSStylesheet_Label() {
		return (EAttribute)cssStylesheetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CsscustomizationFactory getCsscustomizationFactory() {
		return (CsscustomizationFactory)getEFactoryInstance();
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
		cssStylesheetEClass = createEClass(CSS_STYLESHEET);
		createEAttribute(cssStylesheetEClass, CSS_STYLESHEET__THEME);
		createEAttribute(cssStylesheetEClass, CSS_STYLESHEET__ICON);
		createEAttribute(cssStylesheetEClass, CSS_STYLESHEET__LABEL);
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
		CustomizationPluginPackage theCustomizationPluginPackage = (CustomizationPluginPackage)EPackage.Registry.INSTANCE.getEPackage(CustomizationPluginPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cssStylesheetEClass.getESuperTypes().add(theCustomizationPluginPackage.getFileBasedCustomizableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(cssStylesheetEClass, CSSStylesheet.class, "CSSStylesheet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCSSStylesheet_Theme(), ecorePackage.getEString(), "theme", null, 1, 1, CSSStylesheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCSSStylesheet_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, CSSStylesheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCSSStylesheet_Label(), ecorePackage.getEString(), "label", null, 0, 1, CSSStylesheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CsscustomizationPackageImpl
