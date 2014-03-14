/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.stylesheets;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage
 * @generated
 */
public interface StylesheetsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StylesheetsFactory eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Style Sheets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Style Sheets</em>'.
	 * @generated
	 */
	ModelStyleSheets createModelStyleSheets();

	/**
	 * Returns a new object of class '<em>Style Sheet Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Style Sheet Reference</em>'.
	 * @generated
	 */
	StyleSheetReference createStyleSheetReference();

	/**
	 * Returns a new object of class '<em>Embedded Style Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Embedded Style Sheet</em>'.
	 * @generated
	 */
	EmbeddedStyleSheet createEmbeddedStyleSheet();

	/**
	 * Returns a new object of class '<em>Workspace Themes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workspace Themes</em>'.
	 * @generated
	 */
	WorkspaceThemes createWorkspaceThemes();

	/**
	 * Returns a new object of class '<em>Theme</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Theme</em>'.
	 * @generated
	 */
	Theme createTheme();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StylesheetsPackage getStylesheetsPackage();

} //StylesheetsFactory
