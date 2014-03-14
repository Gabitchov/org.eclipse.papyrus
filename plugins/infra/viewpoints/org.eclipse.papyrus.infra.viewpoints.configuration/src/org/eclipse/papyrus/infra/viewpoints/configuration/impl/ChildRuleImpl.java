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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.PathElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ChildRuleImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ChildRuleImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ChildRuleImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ChildRuleImpl#getInsertionPath <em>Insertion Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildRuleImpl extends RuleImpl implements ChildRule {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EClass element;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> stereotypes;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected EClass origin;

	/**
	 * The cached value of the '{@link #getInsertionPath() <em>Insertion Path</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsertionPath()
	 * @generated
	 * @ordered
	 */
	protected EList<PathElement> insertionPath;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.CHILD_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (EClass)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.CHILD_RULE__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(EClass newElement) {
		EClass oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.CHILD_RULE__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getStereotypes() {
		if (stereotypes == null) {
			stereotypes = new EObjectResolvingEList<EClass>(EClass.class, this, ConfigurationPackage.CHILD_RULE__STEREOTYPES);
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrigin() {
		if (origin != null && origin.eIsProxy()) {
			InternalEObject oldOrigin = (InternalEObject)origin;
			origin = (EClass)eResolveProxy(oldOrigin);
			if (origin != oldOrigin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.CHILD_RULE__ORIGIN, oldOrigin, origin));
			}
		}
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(EClass newOrigin) {
		EClass oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.CHILD_RULE__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PathElement> getInsertionPath() {
		if (insertionPath == null) {
			insertionPath = new EObjectContainmentEList<PathElement>(PathElement.class, this, ConfigurationPackage.CHILD_RULE__INSERTION_PATH);
		}
		return insertionPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.CHILD_RULE__INSERTION_PATH:
				return ((InternalEList<?>)getInsertionPath()).basicRemove(otherEnd, msgs);
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
			case ConfigurationPackage.CHILD_RULE__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case ConfigurationPackage.CHILD_RULE__STEREOTYPES:
				return getStereotypes();
			case ConfigurationPackage.CHILD_RULE__ORIGIN:
				if (resolve) return getOrigin();
				return basicGetOrigin();
			case ConfigurationPackage.CHILD_RULE__INSERTION_PATH:
				return getInsertionPath();
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
			case ConfigurationPackage.CHILD_RULE__ELEMENT:
				setElement((EClass)newValue);
				return;
			case ConfigurationPackage.CHILD_RULE__STEREOTYPES:
				getStereotypes().clear();
				getStereotypes().addAll((Collection<? extends EClass>)newValue);
				return;
			case ConfigurationPackage.CHILD_RULE__ORIGIN:
				setOrigin((EClass)newValue);
				return;
			case ConfigurationPackage.CHILD_RULE__INSERTION_PATH:
				getInsertionPath().clear();
				getInsertionPath().addAll((Collection<? extends PathElement>)newValue);
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
			case ConfigurationPackage.CHILD_RULE__ELEMENT:
				setElement((EClass)null);
				return;
			case ConfigurationPackage.CHILD_RULE__STEREOTYPES:
				getStereotypes().clear();
				return;
			case ConfigurationPackage.CHILD_RULE__ORIGIN:
				setOrigin((EClass)null);
				return;
			case ConfigurationPackage.CHILD_RULE__INSERTION_PATH:
				getInsertionPath().clear();
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
			case ConfigurationPackage.CHILD_RULE__ELEMENT:
				return element != null;
			case ConfigurationPackage.CHILD_RULE__STEREOTYPES:
				return stereotypes != null && !stereotypes.isEmpty();
			case ConfigurationPackage.CHILD_RULE__ORIGIN:
				return origin != null;
			case ConfigurationPackage.CHILD_RULE__INSERTION_PATH:
				return insertionPath != null && !insertionPath.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ChildRuleImpl
