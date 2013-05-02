/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.FCM.FCMPackage;
import org.eclipse.papyrus.FCM.InterceptionKind;
import org.eclipse.papyrus.FCM.InterceptionRule;
import org.eclipse.papyrus.FCM.Port;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interception Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.InterceptionRuleImpl#getInterceptionKind <em>Interception Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.InterceptionRuleImpl#getInterceptionSet <em>Interception Set</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.InterceptionRuleImpl#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.InterceptionRuleImpl#getBase_Operation <em>Base Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterceptionRuleImpl extends EObjectImpl implements InterceptionRule {

	/**
	 * The default value of the '{@link #getInterceptionKind() <em>Interception Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterceptionKind()
	 * @generated
	 * @ordered
	 */
	protected static final InterceptionKind INTERCEPTION_KIND_EDEFAULT = InterceptionKind.INTERCEPT_SOME;

	/**
	 * The cached value of the '{@link #getInterceptionKind() <em>Interception Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterceptionKind()
	 * @generated
	 * @ordered
	 */
	protected InterceptionKind interceptionKind = INTERCEPTION_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInterceptionSet() <em>Interception Set</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterceptionSet()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> interceptionSet;

	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * The cached value of the '{@link #getBase_Operation() <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_Operation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterceptionRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.INTERCEPTION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterceptionKind getInterceptionKind() {
		return interceptionKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterceptionKind(InterceptionKind newInterceptionKind) {
		InterceptionKind oldInterceptionKind = interceptionKind;
		interceptionKind = newInterceptionKind == null ? INTERCEPTION_KIND_EDEFAULT : newInterceptionKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.INTERCEPTION_RULE__INTERCEPTION_KIND, oldInterceptionKind, interceptionKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getInterceptionSet() {
		if (interceptionSet == null) {
			interceptionSet = new EObjectResolvingEList<Feature>(Feature.class, this, FCMPackage.INTERCEPTION_RULE__INTERCEPTION_SET);
		}
		return interceptionSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBase_Property() {
		if (base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if (base_Property != oldBase_Property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.INTERCEPTION_RULE__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.INTERCEPTION_RULE__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getBase_Operation() {
		if (base_Operation != null && base_Operation.eIsProxy()) {
			InternalEObject oldBase_Operation = (InternalEObject)base_Operation;
			base_Operation = (Operation)eResolveProxy(oldBase_Operation);
			if (base_Operation != oldBase_Operation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.INTERCEPTION_RULE__BASE_OPERATION, oldBase_Operation, base_Operation));
			}
		}
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetBase_Operation() {
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Operation(Operation newBase_Operation) {
		Operation oldBase_Operation = base_Operation;
		base_Operation = newBase_Operation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.INTERCEPTION_RULE__BASE_OPERATION, oldBase_Operation, base_Operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.INTERCEPTION_RULE__INTERCEPTION_KIND:
				return getInterceptionKind();
			case FCMPackage.INTERCEPTION_RULE__INTERCEPTION_SET:
				return getInterceptionSet();
			case FCMPackage.INTERCEPTION_RULE__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
			case FCMPackage.INTERCEPTION_RULE__BASE_OPERATION:
				if (resolve) return getBase_Operation();
				return basicGetBase_Operation();
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
			case FCMPackage.INTERCEPTION_RULE__INTERCEPTION_KIND:
				setInterceptionKind((InterceptionKind)newValue);
				return;
			case FCMPackage.INTERCEPTION_RULE__INTERCEPTION_SET:
				getInterceptionSet().clear();
				getInterceptionSet().addAll((Collection<? extends Feature>)newValue);
				return;
			case FCMPackage.INTERCEPTION_RULE__BASE_PROPERTY:
				setBase_Property((Property)newValue);
				return;
			case FCMPackage.INTERCEPTION_RULE__BASE_OPERATION:
				setBase_Operation((Operation)newValue);
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
			case FCMPackage.INTERCEPTION_RULE__INTERCEPTION_KIND:
				setInterceptionKind(INTERCEPTION_KIND_EDEFAULT);
				return;
			case FCMPackage.INTERCEPTION_RULE__INTERCEPTION_SET:
				getInterceptionSet().clear();
				return;
			case FCMPackage.INTERCEPTION_RULE__BASE_PROPERTY:
				setBase_Property((Property)null);
				return;
			case FCMPackage.INTERCEPTION_RULE__BASE_OPERATION:
				setBase_Operation((Operation)null);
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
			case FCMPackage.INTERCEPTION_RULE__INTERCEPTION_KIND:
				return interceptionKind != INTERCEPTION_KIND_EDEFAULT;
			case FCMPackage.INTERCEPTION_RULE__INTERCEPTION_SET:
				return interceptionSet != null && !interceptionSet.isEmpty();
			case FCMPackage.INTERCEPTION_RULE__BASE_PROPERTY:
				return base_Property != null;
			case FCMPackage.INTERCEPTION_RULE__BASE_OPERATION:
				return base_Operation != null;
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
		result.append(" (interceptionKind: ");
		result.append(interceptionKind);
		result.append(')');
		return result.toString();
	}

} //InterceptionRuleImpl
