/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.WorkspaceThemes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StylesheetsPackageImpl extends EPackageImpl implements StylesheetsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelStyleSheetsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass styleSheetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass styleSheetReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass embeddedStyleSheetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceThemesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass themeEClass = null;

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
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StylesheetsPackageImpl() {
		super(eNS_URI, StylesheetsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StylesheetsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StylesheetsPackage init() {
		if (isInited) return (StylesheetsPackage)EPackage.Registry.INSTANCE.getEPackage(StylesheetsPackage.eNS_URI);

		// Obtain or create and register package
		StylesheetsPackageImpl theStylesheetsPackage = (StylesheetsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StylesheetsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StylesheetsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStylesheetsPackage.createPackageContents();

		// Initialize created meta-data
		theStylesheetsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStylesheetsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StylesheetsPackage.eNS_URI, theStylesheetsPackage);
		return theStylesheetsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelStyleSheets() {
		return modelStyleSheetsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelStyleSheets_Stylesheets() {
		return (EReference)modelStyleSheetsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStyleSheet() {
		return styleSheetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStyleSheetReference() {
		return styleSheetReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyleSheetReference_Path() {
		return (EAttribute)styleSheetReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmbeddedStyleSheet() {
		return embeddedStyleSheetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmbeddedStyleSheet_Label() {
		return (EAttribute)embeddedStyleSheetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmbeddedStyleSheet_Content() {
		return (EAttribute)embeddedStyleSheetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspaceThemes() {
		return workspaceThemesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceThemes_Themes() {
		return (EReference)workspaceThemesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTheme() {
		return themeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheme_Id() {
		return (EAttribute)themeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheme_Label() {
		return (EAttribute)themeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheme_Icon() {
		return (EAttribute)themeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTheme_Stylesheets() {
		return (EReference)themeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylesheetsFactory getStylesheetsFactory() {
		return (StylesheetsFactory)getEFactoryInstance();
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
		modelStyleSheetsEClass = createEClass(MODEL_STYLE_SHEETS);
		createEReference(modelStyleSheetsEClass, MODEL_STYLE_SHEETS__STYLESHEETS);

		styleSheetEClass = createEClass(STYLE_SHEET);

		styleSheetReferenceEClass = createEClass(STYLE_SHEET_REFERENCE);
		createEAttribute(styleSheetReferenceEClass, STYLE_SHEET_REFERENCE__PATH);

		embeddedStyleSheetEClass = createEClass(EMBEDDED_STYLE_SHEET);
		createEAttribute(embeddedStyleSheetEClass, EMBEDDED_STYLE_SHEET__LABEL);
		createEAttribute(embeddedStyleSheetEClass, EMBEDDED_STYLE_SHEET__CONTENT);

		workspaceThemesEClass = createEClass(WORKSPACE_THEMES);
		createEReference(workspaceThemesEClass, WORKSPACE_THEMES__THEMES);

		themeEClass = createEClass(THEME);
		createEAttribute(themeEClass, THEME__ID);
		createEAttribute(themeEClass, THEME__LABEL);
		createEAttribute(themeEClass, THEME__ICON);
		createEReference(themeEClass, THEME__STYLESHEETS);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modelStyleSheetsEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		styleSheetReferenceEClass.getESuperTypes().add(this.getStyleSheet());
		embeddedStyleSheetEClass.getESuperTypes().add(this.getStyleSheet());
		workspaceThemesEClass.getESuperTypes().add(theEcorePackage.getEModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(modelStyleSheetsEClass, ModelStyleSheets.class, "ModelStyleSheets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelStyleSheets_Stylesheets(), this.getStyleSheet(), null, "stylesheets", null, 0, -1, ModelStyleSheets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(styleSheetEClass, StyleSheet.class, "StyleSheet", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(styleSheetReferenceEClass, StyleSheetReference.class, "StyleSheetReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStyleSheetReference_Path(), theEcorePackage.getEString(), "path", null, 1, 1, StyleSheetReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(embeddedStyleSheetEClass, EmbeddedStyleSheet.class, "EmbeddedStyleSheet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmbeddedStyleSheet_Label(), ecorePackage.getEString(), "label", null, 0, 1, EmbeddedStyleSheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmbeddedStyleSheet_Content(), theEcorePackage.getEString(), "content", null, 1, 1, EmbeddedStyleSheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workspaceThemesEClass, WorkspaceThemes.class, "WorkspaceThemes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspaceThemes_Themes(), this.getTheme(), null, "themes", null, 0, -1, WorkspaceThemes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(themeEClass, Theme.class, "Theme", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTheme_Id(), theEcorePackage.getEString(), "id", null, 0, 1, Theme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTheme_Label(), theEcorePackage.getEString(), "label", null, 0, 1, Theme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTheme_Icon(), theEcorePackage.getEString(), "icon", null, 0, 1, Theme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTheme_Stylesheets(), this.getStyleSheet(), null, "stylesheets", null, 0, -1, Theme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //StylesheetsPackageImpl
