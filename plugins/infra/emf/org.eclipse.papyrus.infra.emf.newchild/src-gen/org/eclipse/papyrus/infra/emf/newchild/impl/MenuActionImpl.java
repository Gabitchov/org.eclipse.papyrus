/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.infra.emf.newchild.MenuAction;
import org.eclipse.papyrus.infra.emf.newchild.NewchildPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.impl.MenuActionImpl#getElementType <em>Element Type</em>}</li>
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
	protected EObject elementType;

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
	public EObject getElementType() {
		if (elementType != null && elementType.eIsProxy()) {
			InternalEObject oldElementType = (InternalEObject)elementType;
			elementType = (EObject)eResolveProxy(oldElementType);
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
	public EObject basicGetElementType() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementType(EObject newElementType) {
		EObject oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.MENU_ACTION__ELEMENT_TYPE, oldElementType, elementType));
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
				setElementType((EObject)newValue);
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
				setElementType((EObject)null);
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
		}
		return super.eIsSet(featureID);
	}

} //MenuActionImpl
