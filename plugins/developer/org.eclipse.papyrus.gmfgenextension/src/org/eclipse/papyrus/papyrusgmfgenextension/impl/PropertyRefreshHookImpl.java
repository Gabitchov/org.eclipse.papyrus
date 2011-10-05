/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;
import org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Refresh Hook</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl#getTriggeringCondition <em>Triggering Condition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyRefreshHookImpl extends ExternalHookImpl implements PropertyRefreshHook {

	/**
	 * The default value of the '{@link #getTriggeringCondition() <em>Triggering Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggeringCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGERING_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTriggeringCondition() <em>Triggering Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggeringCondition()
	 * @generated
	 * @ordered
	 */
	protected String triggeringCondition = TRIGGERING_CONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected String action = ACTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyRefreshHookImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusgmfgenextensionPackage.Literals.PROPERTY_REFRESH_HOOK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTriggeringCondition() {
		return triggeringCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggeringCondition(String newTriggeringCondition) {
		String oldTriggeringCondition = triggeringCondition;
		triggeringCondition = newTriggeringCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION, oldTriggeringCondition, triggeringCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(String newAction) {
		String oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION:
				return getTriggeringCondition();
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__ACTION:
				return getAction();
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
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION:
				setTriggeringCondition((String)newValue);
				return;
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__ACTION:
				setAction((String)newValue);
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
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION:
				setTriggeringCondition(TRIGGERING_CONDITION_EDEFAULT);
				return;
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__ACTION:
				setAction(ACTION_EDEFAULT);
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
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION:
				return TRIGGERING_CONDITION_EDEFAULT == null ? triggeringCondition != null : !TRIGGERING_CONDITION_EDEFAULT.equals(triggeringCondition);
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK__ACTION:
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
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
		result.append(" (triggeringCondition: ");
		result.append(triggeringCondition);
		result.append(", action: ");
		result.append(action);
		result.append(')');
		return result.toString();
	}

} //PropertyRefreshHookImpl
