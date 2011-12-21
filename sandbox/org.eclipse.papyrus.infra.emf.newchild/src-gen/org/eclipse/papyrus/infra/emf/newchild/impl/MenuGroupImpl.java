/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.infra.emf.newchild.MenuGroup;
import org.eclipse.papyrus.infra.emf.newchild.MenuPosition;
import org.eclipse.papyrus.infra.emf.newchild.NewchildPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.impl.MenuGroupImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.impl.MenuGroupImpl#getAfter <em>After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.impl.MenuGroupImpl#getAbsolutePosition <em>Absolute Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuGroupImpl extends MenuContainerImpl implements MenuGroup {
	/**
	 * The default value of the '{@link #getBefore() <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBefore()
	 * @generated
	 * @ordered
	 */
	protected static final String BEFORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBefore() <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBefore()
	 * @generated
	 * @ordered
	 */
	protected String before = BEFORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAfter() <em>After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfter()
	 * @generated
	 * @ordered
	 */
	protected static final String AFTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAfter() <em>After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfter()
	 * @generated
	 * @ordered
	 */
	protected String after = AFTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getAbsolutePosition() <em>Absolute Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsolutePosition()
	 * @generated
	 * @ordered
	 */
	protected static final MenuPosition ABSOLUTE_POSITION_EDEFAULT = MenuPosition.TOP;

	/**
	 * The cached value of the '{@link #getAbsolutePosition() <em>Absolute Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsolutePosition()
	 * @generated
	 * @ordered
	 */
	protected MenuPosition absolutePosition = ABSOLUTE_POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NewchildPackage.Literals.MENU_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBefore() {
		return before;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBefore(String newBefore) {
		String oldBefore = before;
		before = newBefore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.MENU_GROUP__BEFORE, oldBefore, before));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAfter() {
		return after;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAfter(String newAfter) {
		String oldAfter = after;
		after = newAfter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.MENU_GROUP__AFTER, oldAfter, after));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuPosition getAbsolutePosition() {
		return absolutePosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsolutePosition(MenuPosition newAbsolutePosition) {
		MenuPosition oldAbsolutePosition = absolutePosition;
		absolutePosition = newAbsolutePosition == null ? ABSOLUTE_POSITION_EDEFAULT : newAbsolutePosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.MENU_GROUP__ABSOLUTE_POSITION, oldAbsolutePosition, absolutePosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NewchildPackage.MENU_GROUP__BEFORE:
				return getBefore();
			case NewchildPackage.MENU_GROUP__AFTER:
				return getAfter();
			case NewchildPackage.MENU_GROUP__ABSOLUTE_POSITION:
				return getAbsolutePosition();
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
			case NewchildPackage.MENU_GROUP__BEFORE:
				setBefore((String)newValue);
				return;
			case NewchildPackage.MENU_GROUP__AFTER:
				setAfter((String)newValue);
				return;
			case NewchildPackage.MENU_GROUP__ABSOLUTE_POSITION:
				setAbsolutePosition((MenuPosition)newValue);
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
			case NewchildPackage.MENU_GROUP__BEFORE:
				setBefore(BEFORE_EDEFAULT);
				return;
			case NewchildPackage.MENU_GROUP__AFTER:
				setAfter(AFTER_EDEFAULT);
				return;
			case NewchildPackage.MENU_GROUP__ABSOLUTE_POSITION:
				setAbsolutePosition(ABSOLUTE_POSITION_EDEFAULT);
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
			case NewchildPackage.MENU_GROUP__BEFORE:
				return BEFORE_EDEFAULT == null ? before != null : !BEFORE_EDEFAULT.equals(before);
			case NewchildPackage.MENU_GROUP__AFTER:
				return AFTER_EDEFAULT == null ? after != null : !AFTER_EDEFAULT.equals(after);
			case NewchildPackage.MENU_GROUP__ABSOLUTE_POSITION:
				return absolutePosition != ABSOLUTE_POSITION_EDEFAULT;
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
		result.append(" (before: ");
		result.append(before);
		result.append(", after: ");
		result.append(after);
		result.append(", absolutePosition: ");
		result.append(absolutePosition);
		result.append(')');
		return result.toString();
	}

} //MenuGroupImpl
