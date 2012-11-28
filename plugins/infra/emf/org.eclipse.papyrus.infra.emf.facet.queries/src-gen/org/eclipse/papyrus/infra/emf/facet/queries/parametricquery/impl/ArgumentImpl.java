/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ArgumentImpl#getArgumentName <em>Argument Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ArgumentImpl extends EObjectImpl implements Argument {

	/**
	 * The default value of the '{@link #getArgumentName() <em>Argument Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getArgumentName()
	 * @generated
	 * @ordered
	 */
	protected static final String ARGUMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArgumentName() <em>Argument Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getArgumentName()
	 * @generated
	 * @ordered
	 */
	protected String argumentName = ARGUMENT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ArgumentImpl() {
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
		return ParametricqueryPackage.Literals.ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getArgumentName() {
		return argumentName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setArgumentName(String newArgumentName) {
		String oldArgumentName = argumentName;
		argumentName = newArgumentName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametricqueryPackage.ARGUMENT__ARGUMENT_NAME, oldArgumentName, argumentName));
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
		case ParametricqueryPackage.ARGUMENT__ARGUMENT_NAME:
			return getArgumentName();
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
		case ParametricqueryPackage.ARGUMENT__ARGUMENT_NAME:
			setArgumentName((String)newValue);
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
		case ParametricqueryPackage.ARGUMENT__ARGUMENT_NAME:
			setArgumentName(ARGUMENT_NAME_EDEFAULT);
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
		case ParametricqueryPackage.ARGUMENT__ARGUMENT_NAME:
			return ARGUMENT_NAME_EDEFAULT == null ? argumentName != null : !ARGUMENT_NAME_EDEFAULT.equals(argumentName);
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
		result.append(" (argumentName: "); //$NON-NLS-1$
		result.append(argumentName);
		result.append(')');
		return result.toString();
	}

} //ArgumentImpl
