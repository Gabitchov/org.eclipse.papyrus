/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage
 * @generated
 */
public interface CsscustomizationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CsscustomizationFactory eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CsscustomizationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CSS Stylesheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CSS Stylesheet</em>'.
	 * @generated
	 */
	CSSStylesheet createCSSStylesheet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CsscustomizationPackage getCsscustomizationPackage();

} //CsscustomizationFactory
