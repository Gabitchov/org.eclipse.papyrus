/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.ui.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.properties.environment.LayoutType;

import org.eclipse.papyrus.properties.ui.Layout;
import org.eclipse.papyrus.properties.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.ui.impl.LayoutImpl#getLayoutType <em>Layout Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayoutImpl extends UIComponentImpl implements Layout {
	/**
	 * The cached value of the '{@link #getLayoutType() <em>Layout Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutType()
	 * @generated
	 * @ordered
	 */
	protected LayoutType layoutType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutType getLayoutType() {
		if (layoutType != null && layoutType.eIsProxy()) {
			InternalEObject oldLayoutType = (InternalEObject)layoutType;
			layoutType = (LayoutType)eResolveProxy(oldLayoutType);
			if (layoutType != oldLayoutType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.LAYOUT__LAYOUT_TYPE, oldLayoutType, layoutType));
			}
		}
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutType basicGetLayoutType() {
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutType(LayoutType newLayoutType) {
		LayoutType oldLayoutType = layoutType;
		layoutType = newLayoutType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.LAYOUT__LAYOUT_TYPE, oldLayoutType, layoutType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiPackage.LAYOUT__LAYOUT_TYPE:
				if (resolve) return getLayoutType();
				return basicGetLayoutType();
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
			case UiPackage.LAYOUT__LAYOUT_TYPE:
				setLayoutType((LayoutType)newValue);
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
			case UiPackage.LAYOUT__LAYOUT_TYPE:
				setLayoutType((LayoutType)null);
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
			case UiPackage.LAYOUT__LAYOUT_TYPE:
				return layoutType != null;
		}
		return super.eIsSet(featureID);
	}

} //LayoutImpl
