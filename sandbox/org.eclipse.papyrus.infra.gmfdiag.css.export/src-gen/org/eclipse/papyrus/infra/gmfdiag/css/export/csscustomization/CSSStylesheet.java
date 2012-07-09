/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization;

import org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CSS Stylesheet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getTheme <em>Theme</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage#getCSSStylesheet()
 * @model
 * @generated
 */
public interface CSSStylesheet extends FileBasedCustomizableElement {
	/**
	 * Returns the value of the '<em><b>Theme</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Theme</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Theme</em>' attribute.
	 * @see #setTheme(String)
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage#getCSSStylesheet_Theme()
	 * @model required="true"
	 * @generated
	 */
	String getTheme();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getTheme <em>Theme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Theme</em>' attribute.
	 * @see #getTheme()
	 * @generated
	 */
	void setTheme(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage#getCSSStylesheet_Icon()
	 * @model
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

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
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage#getCSSStylesheet_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

} // CSSStylesheet
