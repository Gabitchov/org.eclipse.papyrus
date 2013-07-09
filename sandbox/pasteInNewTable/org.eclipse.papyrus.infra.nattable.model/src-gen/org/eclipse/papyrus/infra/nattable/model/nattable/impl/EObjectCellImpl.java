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
package org.eclipse.papyrus.infra.nattable.model.nattable.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Problem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EObject Cell</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectCellImpl#getProblems <em>Problems</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectCellImpl#getRowElement <em>Row Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectCellImpl#getColumnElement <em>Column Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EObjectCellImpl extends MinimalEObjectImpl.Container implements EObjectCell {
	/**
	 * The cached value of the '{@link #getProblems() <em>Problems</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblems()
	 * @generated
	 * @ordered
	 */
	protected EList<Problem> problems;

	/**
	 * The cached value of the '{@link #getRowElement() <em>Row Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRowElement()
	 * @generated
	 * @ordered
	 */
	protected EObject rowElement;

	/**
	 * The cached value of the '{@link #getColumnElement() <em>Column Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnElement()
	 * @generated
	 * @ordered
	 */
	protected EObject columnElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObjectCellImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattablePackage.Literals.EOBJECT_CELL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Problem> getProblems() {
		if (problems == null) {
			problems = new EObjectResolvingEList<Problem>(Problem.class, this, NattablePackage.EOBJECT_CELL__PROBLEMS);
		}
		return problems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRowElement() {
		if (rowElement != null && rowElement.eIsProxy()) {
			InternalEObject oldRowElement = (InternalEObject)rowElement;
			rowElement = eResolveProxy(oldRowElement);
			if (rowElement != oldRowElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattablePackage.EOBJECT_CELL__ROW_ELEMENT, oldRowElement, rowElement));
			}
		}
		return rowElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRowElement() {
		return rowElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRowElement(EObject newRowElement) {
		EObject oldRowElement = rowElement;
		rowElement = newRowElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.EOBJECT_CELL__ROW_ELEMENT, oldRowElement, rowElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getColumnElement() {
		if (columnElement != null && columnElement.eIsProxy()) {
			InternalEObject oldColumnElement = (InternalEObject)columnElement;
			columnElement = eResolveProxy(oldColumnElement);
			if (columnElement != oldColumnElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattablePackage.EOBJECT_CELL__COLUMN_ELEMENT, oldColumnElement, columnElement));
			}
		}
		return columnElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetColumnElement() {
		return columnElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnElement(EObject newColumnElement) {
		EObject oldColumnElement = columnElement;
		columnElement = newColumnElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.EOBJECT_CELL__COLUMN_ELEMENT, oldColumnElement, columnElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattablePackage.EOBJECT_CELL__PROBLEMS:
				return getProblems();
			case NattablePackage.EOBJECT_CELL__ROW_ELEMENT:
				if (resolve) return getRowElement();
				return basicGetRowElement();
			case NattablePackage.EOBJECT_CELL__COLUMN_ELEMENT:
				if (resolve) return getColumnElement();
				return basicGetColumnElement();
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
			case NattablePackage.EOBJECT_CELL__PROBLEMS:
				getProblems().clear();
				getProblems().addAll((Collection<? extends Problem>)newValue);
				return;
			case NattablePackage.EOBJECT_CELL__ROW_ELEMENT:
				setRowElement((EObject)newValue);
				return;
			case NattablePackage.EOBJECT_CELL__COLUMN_ELEMENT:
				setColumnElement((EObject)newValue);
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
			case NattablePackage.EOBJECT_CELL__PROBLEMS:
				getProblems().clear();
				return;
			case NattablePackage.EOBJECT_CELL__ROW_ELEMENT:
				setRowElement((EObject)null);
				return;
			case NattablePackage.EOBJECT_CELL__COLUMN_ELEMENT:
				setColumnElement((EObject)null);
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
			case NattablePackage.EOBJECT_CELL__PROBLEMS:
				return problems != null && !problems.isEmpty();
			case NattablePackage.EOBJECT_CELL__ROW_ELEMENT:
				return rowElement != null;
			case NattablePackage.EOBJECT_CELL__COLUMN_ELEMENT:
				return columnElement != null;
		}
		return super.eIsSet(featureID);
	}

} //EObjectCellImpl
