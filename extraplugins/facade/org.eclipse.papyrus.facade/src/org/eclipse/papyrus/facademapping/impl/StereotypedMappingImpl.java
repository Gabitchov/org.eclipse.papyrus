/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facademapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.facademapping.ExtensionDefinitionKind;
import org.eclipse.papyrus.facademapping.FacademappingPackage;
import org.eclipse.papyrus.facademapping.StereotypedMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotyped Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facademapping.impl.StereotypedMappingImpl#getAppliedStereotypes <em>Applied Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facademapping.impl.StereotypedMappingImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypedMappingImpl extends MappingImpl implements StereotypedMapping {
	/**
	 * The cached value of the '{@link #getAppliedStereotypes() <em>Applied Stereotypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> appliedStereotypes;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ExtensionDefinitionKind KIND_EDEFAULT = ExtensionDefinitionKind.ASSOCIATION;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ExtensionDefinitionKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StereotypedMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FacademappingPackage.Literals.STEREOTYPED_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getAppliedStereotypes() {
		if (appliedStereotypes == null) {
			appliedStereotypes = new EObjectResolvingEList<EObject>(EObject.class, this, FacademappingPackage.STEREOTYPED_MAPPING__APPLIED_STEREOTYPES);
		}
		return appliedStereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionDefinitionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ExtensionDefinitionKind newKind) {
		ExtensionDefinitionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FacademappingPackage.STEREOTYPED_MAPPING__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FacademappingPackage.STEREOTYPED_MAPPING__APPLIED_STEREOTYPES:
				return getAppliedStereotypes();
			case FacademappingPackage.STEREOTYPED_MAPPING__KIND:
				return getKind();
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
			case FacademappingPackage.STEREOTYPED_MAPPING__APPLIED_STEREOTYPES:
				getAppliedStereotypes().clear();
				getAppliedStereotypes().addAll((Collection<? extends EObject>)newValue);
				return;
			case FacademappingPackage.STEREOTYPED_MAPPING__KIND:
				setKind((ExtensionDefinitionKind)newValue);
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
			case FacademappingPackage.STEREOTYPED_MAPPING__APPLIED_STEREOTYPES:
				getAppliedStereotypes().clear();
				return;
			case FacademappingPackage.STEREOTYPED_MAPPING__KIND:
				setKind(KIND_EDEFAULT);
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
			case FacademappingPackage.STEREOTYPED_MAPPING__APPLIED_STEREOTYPES:
				return appliedStereotypes != null && !appliedStereotypes.isEmpty();
			case FacademappingPackage.STEREOTYPED_MAPPING__KIND:
				return kind != KIND_EDEFAULT;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //StereotypedMappingImpl
