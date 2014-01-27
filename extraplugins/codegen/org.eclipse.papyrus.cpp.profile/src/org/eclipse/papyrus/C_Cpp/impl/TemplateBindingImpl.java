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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.C_Cpp.C_CppPackage;
import org.eclipse.papyrus.C_Cpp.TemplateBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.TemplateBindingImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.TemplateBindingImpl#getBase_templatebinding <em>Base templatebinding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateBindingImpl extends EObjectImpl implements TemplateBinding {
	/**
	 * The default value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected static final String BINDING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected String binding = BINDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_templatebinding() <em>Base templatebinding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_templatebinding()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.TemplateBinding base_templatebinding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return C_CppPackage.Literals.TEMPLATE_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinding(String newBinding) {
		String oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.TEMPLATE_BINDING__BINDING, oldBinding, binding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.TemplateBinding getBase_templatebinding() {
		if (base_templatebinding != null && base_templatebinding.eIsProxy()) {
			InternalEObject oldBase_templatebinding = (InternalEObject)base_templatebinding;
			base_templatebinding = (org.eclipse.uml2.uml.TemplateBinding)eResolveProxy(oldBase_templatebinding);
			if (base_templatebinding != oldBase_templatebinding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.TEMPLATE_BINDING__BASE_TEMPLATEBINDING, oldBase_templatebinding, base_templatebinding));
			}
		}
		return base_templatebinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.TemplateBinding basicGetBase_templatebinding() {
		return base_templatebinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_templatebinding(org.eclipse.uml2.uml.TemplateBinding newBase_templatebinding) {
		org.eclipse.uml2.uml.TemplateBinding oldBase_templatebinding = base_templatebinding;
		base_templatebinding = newBase_templatebinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.TEMPLATE_BINDING__BASE_TEMPLATEBINDING, oldBase_templatebinding, base_templatebinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case C_CppPackage.TEMPLATE_BINDING__BINDING:
				return getBinding();
			case C_CppPackage.TEMPLATE_BINDING__BASE_TEMPLATEBINDING:
				if (resolve) return getBase_templatebinding();
				return basicGetBase_templatebinding();
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
			case C_CppPackage.TEMPLATE_BINDING__BINDING:
				setBinding((String)newValue);
				return;
			case C_CppPackage.TEMPLATE_BINDING__BASE_TEMPLATEBINDING:
				setBase_templatebinding((org.eclipse.uml2.uml.TemplateBinding)newValue);
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
			case C_CppPackage.TEMPLATE_BINDING__BINDING:
				setBinding(BINDING_EDEFAULT);
				return;
			case C_CppPackage.TEMPLATE_BINDING__BASE_TEMPLATEBINDING:
				setBase_templatebinding((org.eclipse.uml2.uml.TemplateBinding)null);
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
			case C_CppPackage.TEMPLATE_BINDING__BINDING:
				return BINDING_EDEFAULT == null ? binding != null : !BINDING_EDEFAULT.equals(binding);
			case C_CppPackage.TEMPLATE_BINDING__BASE_TEMPLATEBINDING:
				return base_templatebinding != null;
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
		result.append(" (binding: "); //$NON-NLS-1$
		result.append(binding);
		result.append(')');
		return result.toString();
	}

} //TemplateBindingImpl
