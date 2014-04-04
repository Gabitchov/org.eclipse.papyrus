/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.C_Cpp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.C_Cpp.C_CppPackage;
import org.eclipse.papyrus.C_Cpp.Friend;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Friend</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.FriendImpl#getBase_dependency <em>Base dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.FriendImpl#getBase_operation <em>Base operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FriendImpl extends MinimalEObjectImpl.Container implements Friend {
	/**
	 * The cached value of the '{@link #getBase_dependency() <em>Base dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_dependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency base_dependency;

	/**
	 * The cached value of the '{@link #getBase_operation() <em>Base operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_operation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FriendImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return C_CppPackage.Literals.FRIEND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency getBase_dependency() {
		if (base_dependency != null && base_dependency.eIsProxy()) {
			InternalEObject oldBase_dependency = (InternalEObject)base_dependency;
			base_dependency = (Dependency)eResolveProxy(oldBase_dependency);
			if (base_dependency != oldBase_dependency) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.FRIEND__BASE_DEPENDENCY, oldBase_dependency, base_dependency));
			}
		}
		return base_dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency basicGetBase_dependency() {
		return base_dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_dependency(Dependency newBase_dependency) {
		Dependency oldBase_dependency = base_dependency;
		base_dependency = newBase_dependency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.FRIEND__BASE_DEPENDENCY, oldBase_dependency, base_dependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getBase_operation() {
		if (base_operation != null && base_operation.eIsProxy()) {
			InternalEObject oldBase_operation = (InternalEObject)base_operation;
			base_operation = (Operation)eResolveProxy(oldBase_operation);
			if (base_operation != oldBase_operation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.FRIEND__BASE_OPERATION, oldBase_operation, base_operation));
			}
		}
		return base_operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetBase_operation() {
		return base_operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_operation(Operation newBase_operation) {
		Operation oldBase_operation = base_operation;
		base_operation = newBase_operation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.FRIEND__BASE_OPERATION, oldBase_operation, base_operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case C_CppPackage.FRIEND__BASE_DEPENDENCY:
				if (resolve) return getBase_dependency();
				return basicGetBase_dependency();
			case C_CppPackage.FRIEND__BASE_OPERATION:
				if (resolve) return getBase_operation();
				return basicGetBase_operation();
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
			case C_CppPackage.FRIEND__BASE_DEPENDENCY:
				setBase_dependency((Dependency)newValue);
				return;
			case C_CppPackage.FRIEND__BASE_OPERATION:
				setBase_operation((Operation)newValue);
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
			case C_CppPackage.FRIEND__BASE_DEPENDENCY:
				setBase_dependency((Dependency)null);
				return;
			case C_CppPackage.FRIEND__BASE_OPERATION:
				setBase_operation((Operation)null);
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
			case C_CppPackage.FRIEND__BASE_DEPENDENCY:
				return base_dependency != null;
			case C_CppPackage.FRIEND__BASE_OPERATION:
				return base_operation != null;
		}
		return super.eIsSet(featureID);
	}

} //FriendImpl
