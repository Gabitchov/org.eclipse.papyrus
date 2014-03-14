/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EModelElementImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.WorkspaceThemes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace Themes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.WorkspaceThemesImpl#getThemes <em>Themes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkspaceThemesImpl extends EModelElementImpl implements WorkspaceThemes {
	/**
	 * The cached value of the '{@link #getThemes() <em>Themes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThemes()
	 * @generated
	 * @ordered
	 */
	protected EList<Theme> themes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceThemesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StylesheetsPackage.Literals.WORKSPACE_THEMES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Theme> getThemes() {
		if (themes == null) {
			themes = new EObjectResolvingEList<Theme>(Theme.class, this, StylesheetsPackage.WORKSPACE_THEMES__THEMES);
		}
		return themes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StylesheetsPackage.WORKSPACE_THEMES__THEMES:
				return getThemes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StylesheetsPackage.WORKSPACE_THEMES__THEMES:
				getThemes().clear();
				getThemes().addAll((Collection<? extends Theme>)newValue);
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
			case StylesheetsPackage.WORKSPACE_THEMES__THEMES:
				getThemes().clear();
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
			case StylesheetsPackage.WORKSPACE_THEMES__THEMES:
				return themes != null && !themes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WorkspaceThemesImpl
