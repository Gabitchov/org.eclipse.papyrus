/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.stylesheets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Embedded Style Sheet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage#getEmbeddedStyleSheet()
 * @model
 * @generated
 */
public interface EmbeddedStyleSheet extends StyleSheet {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage#getEmbeddedStyleSheet_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage#getEmbeddedStyleSheet_Content()
	 * @model required="true"
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

} // EmbeddedStyleSheet
