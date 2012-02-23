/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.gmfdiag.css.modelstylesheets;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.css.modelstylesheets.ModelStyleSheetsPackage
 * @generated
 */
public interface ModelStyleSheetsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelStyleSheetsFactory eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.css.modelstylesheets.impl.ModelStyleSheetsFactoryImpl.init();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelStyleSheetsPackage getModelStyleSheetsPackage();

} //ModelStyleSheetsFactory
