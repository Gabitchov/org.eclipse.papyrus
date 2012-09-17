/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Style Sheets</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.ModelStyleSheetsImpl#getStylesheets <em>Stylesheets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelStyleSheetsImpl extends EModelElementImpl implements ModelStyleSheets {
	/**
	 * The cached value of the '{@link #getStylesheets() <em>Stylesheets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStylesheets()
	 * @generated
	 * @ordered
	 */
	protected EList<StyleSheet> stylesheets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelStyleSheetsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StylesheetsPackage.Literals.MODEL_STYLE_SHEETS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StyleSheet> getStylesheets() {
		if (stylesheets == null) {
			stylesheets = new EObjectContainmentEList<StyleSheet>(StyleSheet.class, this, StylesheetsPackage.MODEL_STYLE_SHEETS__STYLESHEETS);
		}
		return stylesheets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StylesheetsPackage.MODEL_STYLE_SHEETS__STYLESHEETS:
				return ((InternalEList<?>)getStylesheets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StylesheetsPackage.MODEL_STYLE_SHEETS__STYLESHEETS:
				return getStylesheets();
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
			case StylesheetsPackage.MODEL_STYLE_SHEETS__STYLESHEETS:
				getStylesheets().clear();
				getStylesheets().addAll((Collection<? extends StyleSheet>)newValue);
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
			case StylesheetsPackage.MODEL_STYLE_SHEETS__STYLESHEETS:
				getStylesheets().clear();
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
			case StylesheetsPackage.MODEL_STYLE_SHEETS__STYLESHEETS:
				return stylesheets != null && !stylesheets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelStyleSheetsImpl
