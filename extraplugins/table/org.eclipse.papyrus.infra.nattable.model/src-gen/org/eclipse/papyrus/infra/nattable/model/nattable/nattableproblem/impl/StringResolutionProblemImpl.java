/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Resolution Problem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.StringResolutionProblemImpl#getValueAsString <em>Value As String
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.StringResolutionProblemImpl#getUnresolvedString <em>Unresolved
 * String</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StringResolutionProblemImpl extends ProblemImpl implements StringResolutionProblem {

	/**
	 * The default value of the '{@link #getValueAsString() <em>Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValueAsString()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_AS_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueAsString() <em>Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValueAsString()
	 * @generated
	 * @ordered
	 */
	protected String valueAsString = VALUE_AS_STRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnresolvedString() <em>Unresolved String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUnresolvedString()
	 * @generated
	 * @ordered
	 */
	protected EList<String> unresolvedString;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StringResolutionProblemImpl() {
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
		return NattableproblemPackage.Literals.STRING_RESOLUTION_PROBLEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getValueAsString() {
		return valueAsString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValueAsString(String newValueAsString) {
		String oldValueAsString = valueAsString;
		valueAsString = newValueAsString;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableproblemPackage.STRING_RESOLUTION_PROBLEM__VALUE_AS_STRING, oldValueAsString, valueAsString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getUnresolvedString() {
		if(unresolvedString == null) {
			unresolvedString = new EDataTypeUniqueEList<String>(String.class, this, NattableproblemPackage.STRING_RESOLUTION_PROBLEM__UNRESOLVED_STRING);
		}
		return unresolvedString;
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
		case NattableproblemPackage.STRING_RESOLUTION_PROBLEM__VALUE_AS_STRING:
			return getValueAsString();
		case NattableproblemPackage.STRING_RESOLUTION_PROBLEM__UNRESOLVED_STRING:
			return getUnresolvedString();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case NattableproblemPackage.STRING_RESOLUTION_PROBLEM__VALUE_AS_STRING:
			setValueAsString((String)newValue);
			return;
		case NattableproblemPackage.STRING_RESOLUTION_PROBLEM__UNRESOLVED_STRING:
			getUnresolvedString().clear();
			getUnresolvedString().addAll((Collection<? extends String>)newValue);
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
		case NattableproblemPackage.STRING_RESOLUTION_PROBLEM__VALUE_AS_STRING:
			setValueAsString(VALUE_AS_STRING_EDEFAULT);
			return;
		case NattableproblemPackage.STRING_RESOLUTION_PROBLEM__UNRESOLVED_STRING:
			getUnresolvedString().clear();
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
		case NattableproblemPackage.STRING_RESOLUTION_PROBLEM__VALUE_AS_STRING:
			return VALUE_AS_STRING_EDEFAULT == null ? valueAsString != null : !VALUE_AS_STRING_EDEFAULT.equals(valueAsString);
		case NattableproblemPackage.STRING_RESOLUTION_PROBLEM__UNRESOLVED_STRING:
			return unresolvedString != null && !unresolvedString.isEmpty();
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
		result.append(" (valueAsString: "); //$NON-NLS-1$
		result.append(valueAsString);
		result.append(", unresolvedString: "); //$NON-NLS-1$
		result.append(unresolvedString);
		result.append(')');
		return result.toString();
	}

} //StringResolutionProblemImpl
