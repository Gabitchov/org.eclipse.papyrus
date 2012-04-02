/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.stylesheets;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory
 * @model kind="package"
 * @generated
 */
public interface StylesheetsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "stylesheets";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/gmfdiag/css";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "css";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StylesheetsPackage eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.ModelStyleSheetsImpl <em>Model Style Sheets</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.ModelStyleSheetsImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsPackageImpl#getModelStyleSheets()
	 * @generated
	 */
	int MODEL_STYLE_SHEETS = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_STYLE_SHEETS__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Stylesheets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_STYLE_SHEETS__STYLESHEETS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Style Sheets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_STYLE_SHEETS_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet <em>Style Sheet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsPackageImpl#getStyleSheet()
	 * @generated
	 */
	int STYLE_SHEET = 1;

	/**
	 * The number of structural features of the '<em>Style Sheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_SHEET_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StyleSheetReferenceImpl <em>Style Sheet Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StyleSheetReferenceImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsPackageImpl#getStyleSheetReference()
	 * @generated
	 */
	int STYLE_SHEET_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_SHEET_REFERENCE__PATH = STYLE_SHEET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Style Sheet Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_SHEET_REFERENCE_FEATURE_COUNT = STYLE_SHEET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.EmbeddedStyleSheetImpl <em>Embedded Style Sheet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.EmbeddedStyleSheetImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsPackageImpl#getEmbeddedStyleSheet()
	 * @generated
	 */
	int EMBEDDED_STYLE_SHEET = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_STYLE_SHEET__LABEL = STYLE_SHEET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_STYLE_SHEET__CONTENT = STYLE_SHEET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Embedded Style Sheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_STYLE_SHEET_FEATURE_COUNT = STYLE_SHEET_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets <em>Model Style Sheets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Style Sheets</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets
	 * @generated
	 */
	EClass getModelStyleSheets();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets#getStylesheets <em>Stylesheets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stylesheets</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets#getStylesheets()
	 * @see #getModelStyleSheets()
	 * @generated
	 */
	EReference getModelStyleSheets_Stylesheets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet <em>Style Sheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style Sheet</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet
	 * @generated
	 */
	EClass getStyleSheet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference <em>Style Sheet Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style Sheet Reference</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference
	 * @generated
	 */
	EClass getStyleSheetReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference#getPath()
	 * @see #getStyleSheetReference()
	 * @generated
	 */
	EAttribute getStyleSheetReference_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet <em>Embedded Style Sheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Embedded Style Sheet</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet
	 * @generated
	 */
	EClass getEmbeddedStyleSheet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet#getLabel()
	 * @see #getEmbeddedStyleSheet()
	 * @generated
	 */
	EAttribute getEmbeddedStyleSheet_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet#getContent()
	 * @see #getEmbeddedStyleSheet()
	 * @generated
	 */
	EAttribute getEmbeddedStyleSheet_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StylesheetsFactory getStylesheetsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.ModelStyleSheetsImpl <em>Model Style Sheets</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.ModelStyleSheetsImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsPackageImpl#getModelStyleSheets()
		 * @generated
		 */
		EClass MODEL_STYLE_SHEETS = eINSTANCE.getModelStyleSheets();

		/**
		 * The meta object literal for the '<em><b>Stylesheets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_STYLE_SHEETS__STYLESHEETS = eINSTANCE.getModelStyleSheets_Stylesheets();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet <em>Style Sheet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsPackageImpl#getStyleSheet()
		 * @generated
		 */
		EClass STYLE_SHEET = eINSTANCE.getStyleSheet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StyleSheetReferenceImpl <em>Style Sheet Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StyleSheetReferenceImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsPackageImpl#getStyleSheetReference()
		 * @generated
		 */
		EClass STYLE_SHEET_REFERENCE = eINSTANCE.getStyleSheetReference();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_SHEET_REFERENCE__PATH = eINSTANCE.getStyleSheetReference_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.EmbeddedStyleSheetImpl <em>Embedded Style Sheet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.EmbeddedStyleSheetImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsPackageImpl#getEmbeddedStyleSheet()
		 * @generated
		 */
		EClass EMBEDDED_STYLE_SHEET = eINSTANCE.getEmbeddedStyleSheet();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMBEDDED_STYLE_SHEET__LABEL = eINSTANCE.getEmbeddedStyleSheet_Label();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMBEDDED_STYLE_SHEET__CONTENT = eINSTANCE.getEmbeddedStyleSheet_Content();

	}

} //StylesheetsPackage
