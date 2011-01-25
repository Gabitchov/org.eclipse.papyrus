/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.runtime.preferences.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor;
import org.eclipse.papyrus.properties.runtime.preferences.PreferencesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.properties.runtime.preferences.impl.ContextDescriptorImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.properties.runtime.preferences.impl.ContextDescriptorImpl#isApplied <em>Applied</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ContextDescriptorImpl extends EObjectImpl implements ContextDescriptor {

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isApplied() <em>Applied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isApplied()
	 * @generated
	 * @ordered
	 */
	protected static final boolean APPLIED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isApplied() <em>Applied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isApplied()
	 * @generated
	 * @ordered
	 */
	protected boolean applied = APPLIED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ContextDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PreferencesPackage.Literals.CONTEXT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.CONTEXT_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isApplied() {
		return applied;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setApplied(boolean newApplied) {
		boolean oldApplied = applied;
		applied = newApplied;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.CONTEXT_DESCRIPTOR__APPLIED, oldApplied, applied));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case PreferencesPackage.CONTEXT_DESCRIPTOR__NAME:
			return getName();
		case PreferencesPackage.CONTEXT_DESCRIPTOR__APPLIED:
			return isApplied();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case PreferencesPackage.CONTEXT_DESCRIPTOR__NAME:
			setName((String)newValue);
			return;
		case PreferencesPackage.CONTEXT_DESCRIPTOR__APPLIED:
			setApplied((Boolean)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case PreferencesPackage.CONTEXT_DESCRIPTOR__NAME:
			setName(NAME_EDEFAULT);
			return;
		case PreferencesPackage.CONTEXT_DESCRIPTOR__APPLIED:
			setApplied(APPLIED_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case PreferencesPackage.CONTEXT_DESCRIPTOR__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case PreferencesPackage.CONTEXT_DESCRIPTOR__APPLIED:
			return applied != APPLIED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", applied: ");
		result.append(applied);
		result.append(')');
		return result.toString();
	}

} //ContextDescriptorImpl
