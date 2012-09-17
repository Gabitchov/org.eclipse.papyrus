/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.stylesheets;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Style Sheets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets#getStylesheets <em>Stylesheets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage#getModelStyleSheets()
 * @model
 * @generated
 */
public interface ModelStyleSheets extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Stylesheets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stylesheets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stylesheets</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage#getModelStyleSheets_Stylesheets()
	 * @model containment="true"
	 * @generated
	 */
	EList<StyleSheet> getStylesheets();

} // ModelStyleSheets
