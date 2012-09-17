/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;

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
 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationFactory
 * @model kind="package"
 * @generated
 */
public interface CsscustomizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "csscustomization";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/css/customization";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "csscustomization";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CsscustomizationPackage eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CsscustomizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CSSStylesheetImpl <em>CSS Stylesheet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CSSStylesheetImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CsscustomizationPackageImpl#getCSSStylesheet()
	 * @generated
	 */
	int CSS_STYLESHEET = 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_STYLESHEET__FILE = CustomizationPluginPackage.FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE;

	/**
	 * The feature id for the '<em><b>Theme</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_STYLESHEET__THEME = CustomizationPluginPackage.FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_STYLESHEET__ICON = CustomizationPluginPackage.FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_STYLESHEET__LABEL = CustomizationPluginPackage.FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CSS Stylesheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_STYLESHEET_FEATURE_COUNT = CustomizationPluginPackage.FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet <em>CSS Stylesheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSS Stylesheet</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet
	 * @generated
	 */
	EClass getCSSStylesheet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getTheme <em>Theme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Theme</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getTheme()
	 * @see #getCSSStylesheet()
	 * @generated
	 */
	EAttribute getCSSStylesheet_Theme();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getIcon()
	 * @see #getCSSStylesheet()
	 * @generated
	 */
	EAttribute getCSSStylesheet_Icon();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getLabel()
	 * @see #getCSSStylesheet()
	 * @generated
	 */
	EAttribute getCSSStylesheet_Label();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CsscustomizationFactory getCsscustomizationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CSSStylesheetImpl <em>CSS Stylesheet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CSSStylesheetImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CsscustomizationPackageImpl#getCSSStylesheet()
		 * @generated
		 */
		EClass CSS_STYLESHEET = eINSTANCE.getCSSStylesheet();

		/**
		 * The meta object literal for the '<em><b>Theme</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSS_STYLESHEET__THEME = eINSTANCE.getCSSStylesheet_Theme();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSS_STYLESHEET__ICON = eINSTANCE.getCSSStylesheet_Icon();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSS_STYLESHEET__LABEL = eINSTANCE.getCSSStylesheet_Label();

	}

} //CsscustomizationPackage
