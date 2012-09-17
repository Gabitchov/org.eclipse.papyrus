/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.customization.model.customizationplugin.impl.FileBasedCustomizableElementImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CSS Stylesheet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CSSStylesheetImpl#getTheme <em>Theme</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CSSStylesheetImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl.CSSStylesheetImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CSSStylesheetImpl extends FileBasedCustomizableElementImpl implements CSSStylesheet {
	/**
	 * The default value of the '{@link #getTheme() <em>Theme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheme()
	 * @generated
	 * @ordered
	 */
	protected static final String THEME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTheme() <em>Theme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheme()
	 * @generated
	 * @ordered
	 */
	protected String theme = THEME_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CSSStylesheetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CsscustomizationPackage.Literals.CSS_STYLESHEET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheme(String newTheme) {
		String oldTheme = theme;
		theme = newTheme;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CsscustomizationPackage.CSS_STYLESHEET__THEME, oldTheme, theme));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CsscustomizationPackage.CSS_STYLESHEET__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CsscustomizationPackage.CSS_STYLESHEET__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CsscustomizationPackage.CSS_STYLESHEET__THEME:
				return getTheme();
			case CsscustomizationPackage.CSS_STYLESHEET__ICON:
				return getIcon();
			case CsscustomizationPackage.CSS_STYLESHEET__LABEL:
				return getLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CsscustomizationPackage.CSS_STYLESHEET__THEME:
				setTheme((String)newValue);
				return;
			case CsscustomizationPackage.CSS_STYLESHEET__ICON:
				setIcon((String)newValue);
				return;
			case CsscustomizationPackage.CSS_STYLESHEET__LABEL:
				setLabel((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CsscustomizationPackage.CSS_STYLESHEET__THEME:
				setTheme(THEME_EDEFAULT);
				return;
			case CsscustomizationPackage.CSS_STYLESHEET__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case CsscustomizationPackage.CSS_STYLESHEET__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CsscustomizationPackage.CSS_STYLESHEET__THEME:
				return THEME_EDEFAULT == null ? theme != null : !THEME_EDEFAULT.equals(theme);
			case CsscustomizationPackage.CSS_STYLESHEET__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case CsscustomizationPackage.CSS_STYLESHEET__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (theme: ");
		result.append(theme);
		result.append(", icon: ");
		result.append(icon);
		result.append(", label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //CSSStylesheetImpl
