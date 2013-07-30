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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cell</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.CellImpl#getColumnWrapper <em>Column Wrapper</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.CellImpl#getRowWrapper <em>Row Wrapper</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.CellImpl#getProblems <em>Problems</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CellImpl extends EModelElementImpl implements Cell {

	/**
	 * The cached value of the '{@link #getColumnWrapper() <em>Column Wrapper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getColumnWrapper()
	 * @generated
	 * @ordered
	 */
	protected ICellAxisWrapper columnWrapper;

	/**
	 * The cached value of the '{@link #getRowWrapper() <em>Row Wrapper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRowWrapper()
	 * @generated
	 * @ordered
	 */
	protected ICellAxisWrapper rowWrapper;

	/**
	 * The cached value of the '{@link #getProblems() <em>Problems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProblems()
	 * @generated
	 * @ordered
	 */
	protected EList<Problem> problems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CellImpl() {
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
		return NattablecellPackage.Literals.CELL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ICellAxisWrapper getColumnWrapper() {
		return columnWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetColumnWrapper(ICellAxisWrapper newColumnWrapper, NotificationChain msgs) {
		ICellAxisWrapper oldColumnWrapper = columnWrapper;
		columnWrapper = newColumnWrapper;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablecellPackage.CELL__COLUMN_WRAPPER, oldColumnWrapper, newColumnWrapper);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setColumnWrapper(ICellAxisWrapper newColumnWrapper) {
		if(newColumnWrapper != columnWrapper) {
			NotificationChain msgs = null;
			if(columnWrapper != null)
				msgs = ((InternalEObject)columnWrapper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablecellPackage.CELL__COLUMN_WRAPPER, null, msgs);
			if(newColumnWrapper != null)
				msgs = ((InternalEObject)newColumnWrapper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablecellPackage.CELL__COLUMN_WRAPPER, null, msgs);
			msgs = basicSetColumnWrapper(newColumnWrapper, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablecellPackage.CELL__COLUMN_WRAPPER, newColumnWrapper, newColumnWrapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ICellAxisWrapper getRowWrapper() {
		return rowWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRowWrapper(ICellAxisWrapper newRowWrapper, NotificationChain msgs) {
		ICellAxisWrapper oldRowWrapper = rowWrapper;
		rowWrapper = newRowWrapper;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablecellPackage.CELL__ROW_WRAPPER, oldRowWrapper, newRowWrapper);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRowWrapper(ICellAxisWrapper newRowWrapper) {
		if(newRowWrapper != rowWrapper) {
			NotificationChain msgs = null;
			if(rowWrapper != null)
				msgs = ((InternalEObject)rowWrapper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablecellPackage.CELL__ROW_WRAPPER, null, msgs);
			if(newRowWrapper != null)
				msgs = ((InternalEObject)newRowWrapper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablecellPackage.CELL__ROW_WRAPPER, null, msgs);
			msgs = basicSetRowWrapper(newRowWrapper, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablecellPackage.CELL__ROW_WRAPPER, newRowWrapper, newRowWrapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Problem> getProblems() {
		if(problems == null) {
			problems = new EObjectContainmentEList<Problem>(Problem.class, this, NattablecellPackage.CELL__PROBLEMS);
		}
		return problems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case NattablecellPackage.CELL__COLUMN_WRAPPER:
			return basicSetColumnWrapper(null, msgs);
		case NattablecellPackage.CELL__ROW_WRAPPER:
			return basicSetRowWrapper(null, msgs);
		case NattablecellPackage.CELL__PROBLEMS:
			return ((InternalEList<?>)getProblems()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
		case NattablecellPackage.CELL__COLUMN_WRAPPER:
			return getColumnWrapper();
		case NattablecellPackage.CELL__ROW_WRAPPER:
			return getRowWrapper();
		case NattablecellPackage.CELL__PROBLEMS:
			return getProblems();
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
		case NattablecellPackage.CELL__COLUMN_WRAPPER:
			setColumnWrapper((ICellAxisWrapper)newValue);
			return;
		case NattablecellPackage.CELL__ROW_WRAPPER:
			setRowWrapper((ICellAxisWrapper)newValue);
			return;
		case NattablecellPackage.CELL__PROBLEMS:
			getProblems().clear();
			getProblems().addAll((Collection<? extends Problem>)newValue);
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
		case NattablecellPackage.CELL__COLUMN_WRAPPER:
			setColumnWrapper((ICellAxisWrapper)null);
			return;
		case NattablecellPackage.CELL__ROW_WRAPPER:
			setRowWrapper((ICellAxisWrapper)null);
			return;
		case NattablecellPackage.CELL__PROBLEMS:
			getProblems().clear();
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
		case NattablecellPackage.CELL__COLUMN_WRAPPER:
			return columnWrapper != null;
		case NattablecellPackage.CELL__ROW_WRAPPER:
			return rowWrapper != null;
		case NattablecellPackage.CELL__PROBLEMS:
			return problems != null && !problems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CellImpl
