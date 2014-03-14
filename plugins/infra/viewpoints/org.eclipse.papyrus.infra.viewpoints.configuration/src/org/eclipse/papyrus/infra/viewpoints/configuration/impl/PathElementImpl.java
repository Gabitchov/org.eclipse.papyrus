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
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.configuration.PathElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PathElementImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PathElementImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PathElementImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathElementImpl extends MinimalEObjectImpl.Container implements PathElement {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EReference feature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PATH_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (EReference)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.PATH_ELEMENT__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(EReference newFeature) {
		EReference oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PATH_ELEMENT__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrigin() {
		EClass origin = basicGetOrigin();
		return origin != null && origin.eIsProxy() ? (EClass)eResolveProxy((InternalEObject)origin) : origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EClass basicGetOrigin() {
		if (this.eContainer() instanceof ChildRule)
			return basicGetOriginChildRule();
		return basicGetOriginModelRule();
	}

	private EClass basicGetOriginChildRule() {
		ChildRule rule = (ChildRule) this.eContainer();
		return basicGetOriginFrom(rule.getInsertionPath(), rule.getOrigin());
	}

	private EClass basicGetOriginModelRule() {
		ModelRule rule = (ModelRule)this.eContainer();
		PapyrusView view = (PapyrusView) rule.eContainer();
		OwningRule or = (view.getOwningRules().size() >= 1) ? view.getOwningRules().get(0) : null;
		if (or != null)
			return basicGetOriginFrom(rule.getAutoSelectPath(), or.getElement());
		return null;
	}

	private EClass basicGetOriginFrom(EList<PathElement> list, EClass from) {
		EClass current = from;
		int index = 0;
		while ((current != null) && list.get(index) != this) {
			EReference feature = list.get(index).getFeature();
			if (!current.getEAllReferences().contains(feature))
				return null;
			current = feature.getEReferenceType();
			index++;
		}
		return current;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarget() {
		EClass target = basicGetTarget();
		return target != null && target.eIsProxy() ? (EClass)eResolveProxy((InternalEObject)target) : target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EClass basicGetTarget() {
		EReference feature = this.getFeature();
		if (feature == null)
			return null;
		EClass origin = basicGetOrigin();
		if (origin == null)
			return null;
		if (!origin.getEAllReferences().contains(feature))
			return null;
		return feature.getEReferenceType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.PATH_ELEMENT__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case ConfigurationPackage.PATH_ELEMENT__ORIGIN:
				if (resolve) return getOrigin();
				return basicGetOrigin();
			case ConfigurationPackage.PATH_ELEMENT__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case ConfigurationPackage.PATH_ELEMENT__FEATURE:
				setFeature((EReference)newValue);
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
			case ConfigurationPackage.PATH_ELEMENT__FEATURE:
				setFeature((EReference)null);
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
			case ConfigurationPackage.PATH_ELEMENT__FEATURE:
				return feature != null;
			case ConfigurationPackage.PATH_ELEMENT__ORIGIN:
				return basicGetOrigin() != null;
			case ConfigurationPackage.PATH_ELEMENT__TARGET:
				return basicGetTarget() != null;
		}
		return super.eIsSet(featureID);
	}

} //PathElementImpl
