/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StylesheetsFactoryImpl extends EFactoryImpl implements StylesheetsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StylesheetsFactory init() {
		try {
			StylesheetsFactory theStylesheetsFactory = (StylesheetsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/infra/gmfdiag/css"); 
			if (theStylesheetsFactory != null) {
				return theStylesheetsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StylesheetsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylesheetsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StylesheetsPackage.MODEL_STYLE_SHEETS: return createModelStyleSheets();
			case StylesheetsPackage.STYLE_SHEET_REFERENCE: return createStyleSheetReference();
			case StylesheetsPackage.EMBEDDED_STYLE_SHEET: return createEmbeddedStyleSheet();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelStyleSheets createModelStyleSheets() {
		ModelStyleSheetsImpl modelStyleSheets = new ModelStyleSheetsImpl();
		return modelStyleSheets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyleSheetReference createStyleSheetReference() {
		StyleSheetReferenceImpl styleSheetReference = new StyleSheetReferenceImpl();
		return styleSheetReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbeddedStyleSheet createEmbeddedStyleSheet() {
		EmbeddedStyleSheetImpl embeddedStyleSheet = new EmbeddedStyleSheetImpl();
		return embeddedStyleSheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylesheetsPackage getStylesheetsPackage() {
		return (StylesheetsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StylesheetsPackage getPackage() {
		return StylesheetsPackage.eINSTANCE;
	}

} //StylesheetsFactoryImpl
