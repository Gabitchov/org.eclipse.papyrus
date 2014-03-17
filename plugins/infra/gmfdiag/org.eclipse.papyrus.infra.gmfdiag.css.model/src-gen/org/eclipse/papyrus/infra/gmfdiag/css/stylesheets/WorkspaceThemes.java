/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.stylesheets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace Themes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.WorkspaceThemes#getThemes <em>Themes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage#getWorkspaceThemes()
 * @model
 * @generated
 */
public interface WorkspaceThemes extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Themes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Themes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Themes</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage#getWorkspaceThemes_Themes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Theme> getThemes();

} // WorkspaceThemes
