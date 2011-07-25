/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.ncpolicy.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.constraints.impl.DisplayUnitImpl;

import org.eclipse.papyrus.newchild.ncpolicy.NcpolicyPackage;
import org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy;
import org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Child Policy Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicySetImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicySetImpl#getPolicies <em>Policies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewChildPolicySetImpl extends DisplayUnitImpl implements NewChildPolicySet {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPolicies() <em>Policies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicies()
	 * @generated
	 * @ordered
	 */
	protected EList<NewChildPolicy> policies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewChildPolicySetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NcpolicyPackage.Literals.NEW_CHILD_POLICY_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NcpolicyPackage.NEW_CHILD_POLICY_SET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NewChildPolicy> getPolicies() {
		if (policies == null) {
			policies = new EObjectContainmentEList<NewChildPolicy>(NewChildPolicy.class, this, NcpolicyPackage.NEW_CHILD_POLICY_SET__POLICIES);
		}
		return policies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NcpolicyPackage.NEW_CHILD_POLICY_SET__POLICIES:
				return ((InternalEList<?>)getPolicies()).basicRemove(otherEnd, msgs);
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
			case NcpolicyPackage.NEW_CHILD_POLICY_SET__NAME:
				return getName();
			case NcpolicyPackage.NEW_CHILD_POLICY_SET__POLICIES:
				return getPolicies();
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
			case NcpolicyPackage.NEW_CHILD_POLICY_SET__NAME:
				setName((String)newValue);
				return;
			case NcpolicyPackage.NEW_CHILD_POLICY_SET__POLICIES:
				getPolicies().clear();
				getPolicies().addAll((Collection<? extends NewChildPolicy>)newValue);
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
			case NcpolicyPackage.NEW_CHILD_POLICY_SET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NcpolicyPackage.NEW_CHILD_POLICY_SET__POLICIES:
				getPolicies().clear();
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
			case NcpolicyPackage.NEW_CHILD_POLICY_SET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NcpolicyPackage.NEW_CHILD_POLICY_SET__POLICIES:
				return policies != null && !policies.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NewChildPolicySetImpl
