/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.newchild.ElementPosition;
import org.eclipse.papyrus.newchild.NewChildKind;
import org.eclipse.papyrus.newchild.NewChildMenu;
import org.eclipse.papyrus.newchild.NewchildPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Child Menu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.impl.NewChildMenuImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.impl.NewChildMenuImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewChildMenuImpl extends MenuImpl implements NewChildMenu {
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
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final NewChildKind KIND_EDEFAULT = NewChildKind.HIERARCHICAL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected NewChildKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewChildMenuImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NewchildPackage.Literals.NEW_CHILD_MENU;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.NEW_CHILD_MENU__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewChildKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(NewChildKind newKind) {
		NewChildKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.NEW_CHILD_MENU__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NewchildPackage.NEW_CHILD_MENU__POSITION:
				return getPosition();
			case NewchildPackage.NEW_CHILD_MENU__KIND:
				return getKind();
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
			case NewchildPackage.NEW_CHILD_MENU__POSITION:
				setPosition((ElementPosition)newValue);
				return;
			case NewchildPackage.NEW_CHILD_MENU__KIND:
				setKind((NewChildKind)newValue);
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
			case NewchildPackage.NEW_CHILD_MENU__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case NewchildPackage.NEW_CHILD_MENU__KIND:
				setKind(KIND_EDEFAULT);
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
			case NewchildPackage.NEW_CHILD_MENU__POSITION:
				return position != POSITION_EDEFAULT;
			case NewchildPackage.NEW_CHILD_MENU__KIND:
				return kind != KIND_EDEFAULT;
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
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //NewChildMenuImpl
