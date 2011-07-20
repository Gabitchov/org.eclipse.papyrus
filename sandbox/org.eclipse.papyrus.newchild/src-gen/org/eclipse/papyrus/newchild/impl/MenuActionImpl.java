/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.extendedtypes.ExtendedElementTypeConfiguration;

import org.eclipse.papyrus.newchild.ElementPosition;
import org.eclipse.papyrus.newchild.MenuAction;
import org.eclipse.papyrus.newchild.NewchildPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.impl.MenuActionImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.impl.MenuActionImpl#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuActionImpl extends MenuItemImpl implements MenuAction {
	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected ExtendedElementTypeConfiguration elementType;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final ElementPosition POSITION_EDEFAULT = ElementPosition.CHILD;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected ElementPosition position = POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NewchildPackage.Literals.MENU_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedElementTypeConfiguration getElementType() {
		if (elementType != null && elementType.eIsProxy()) {
			InternalEObject oldElementType = (InternalEObject)elementType;
			elementType = (ExtendedElementTypeConfiguration)eResolveProxy(oldElementType);
			if (elementType != oldElementType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NewchildPackage.MENU_ACTION__ELEMENT_TYPE, oldElementType, elementType));
			}
		}
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedElementTypeConfiguration basicGetElementType() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementType(ExtendedElementTypeConfiguration newElementType) {
		ExtendedElementTypeConfiguration oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.MENU_ACTION__ELEMENT_TYPE, oldElementType, elementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementPosition getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(ElementPosition newPosition) {
		ElementPosition oldPosition = position;
		position = newPosition == null ? POSITION_EDEFAULT : newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.MENU_ACTION__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NewchildPackage.MENU_ACTION__ELEMENT_TYPE:
				if (resolve) return getElementType();
				return basicGetElementType();
			case NewchildPackage.MENU_ACTION__POSITION:
				return getPosition();
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
			case NewchildPackage.MENU_ACTION__ELEMENT_TYPE:
				setElementType((ExtendedElementTypeConfiguration)newValue);
				return;
			case NewchildPackage.MENU_ACTION__POSITION:
				setPosition((ElementPosition)newValue);
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
			case NewchildPackage.MENU_ACTION__ELEMENT_TYPE:
				setElementType((ExtendedElementTypeConfiguration)null);
				return;
			case NewchildPackage.MENU_ACTION__POSITION:
				setPosition(POSITION_EDEFAULT);
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
			case NewchildPackage.MENU_ACTION__ELEMENT_TYPE:
				return elementType != null;
			case NewchildPackage.MENU_ACTION__POSITION:
				return position != POSITION_EDEFAULT;
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
		result.append(" (position: ");
		result.append(position);
		result.append(')');
		return result.toString();
	}

} //MenuActionImpl
