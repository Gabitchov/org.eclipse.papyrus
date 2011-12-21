/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.ncpolicy.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Child Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.impl.NewChildPolicyImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.impl.NewChildPolicyImpl#getEClasses <em>EClasses</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.impl.NewChildPolicyImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NewChildPolicyImpl extends EObjectImpl implements NewChildPolicy {
	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> roles;

	/**
	 * The cached value of the '{@link #getEClasses() <em>EClasses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> eClasses;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewChildPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NcpolicyPackage.Literals.NEW_CHILD_POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRoles() {
		if (roles == null) {
			roles = new EDataTypeUniqueEList<String>(String.class, this, NcpolicyPackage.NEW_CHILD_POLICY__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getEClasses() {
		if (eClasses == null) {
			eClasses = new EObjectResolvingEList<EClass>(EClass.class, this, NcpolicyPackage.NEW_CHILD_POLICY__ECLASSES);
		}
		return eClasses;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NcpolicyPackage.NEW_CHILD_POLICY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NcpolicyPackage.NEW_CHILD_POLICY__ROLES:
				return getRoles();
			case NcpolicyPackage.NEW_CHILD_POLICY__ECLASSES:
				return getEClasses();
			case NcpolicyPackage.NEW_CHILD_POLICY__NAME:
				return getName();
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
			case NcpolicyPackage.NEW_CHILD_POLICY__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends String>)newValue);
				return;
			case NcpolicyPackage.NEW_CHILD_POLICY__ECLASSES:
				getEClasses().clear();
				getEClasses().addAll((Collection<? extends EClass>)newValue);
				return;
			case NcpolicyPackage.NEW_CHILD_POLICY__NAME:
				setName((String)newValue);
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
			case NcpolicyPackage.NEW_CHILD_POLICY__ROLES:
				getRoles().clear();
				return;
			case NcpolicyPackage.NEW_CHILD_POLICY__ECLASSES:
				getEClasses().clear();
				return;
			case NcpolicyPackage.NEW_CHILD_POLICY__NAME:
				setName(NAME_EDEFAULT);
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
			case NcpolicyPackage.NEW_CHILD_POLICY__ROLES:
				return roles != null && !roles.isEmpty();
			case NcpolicyPackage.NEW_CHILD_POLICY__ECLASSES:
				return eClasses != null && !eClasses.isEmpty();
			case NcpolicyPackage.NEW_CHILD_POLICY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (roles: ");
		result.append(roles);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NewChildPolicyImpl
