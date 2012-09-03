/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl#getFillingMode <em>Filling Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl#getContextFeature <em>Context Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl#isUsingUser <em>Using User</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl#isUsingContextFeature <em>Using Context Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl#isUsingQueries <em>Using Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PapyrusTableImpl extends EModelElementImpl implements PapyrusTable {

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected Table table;

	/**
	 * The default value of the '{@link #getFillingMode() <em>Filling Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillingMode()
	 * @generated
	 * @ordered
	 */
	protected static final FillingMode FILLING_MODE_EDEFAULT = FillingMode.USER;

	/**
	 * The cached value of the '{@link #getFillingMode() <em>Filling Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillingMode()
	 * @generated
	 * @ordered
	 */
	protected FillingMode fillingMode = FILLING_MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContextFeature() <em>Context Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextFeature()
	 * @generated
	 * @ordered
	 */
	protected EReference contextFeature;

	/**
	 * The cached value of the '{@link #getQueries() <em>Queries</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<Query> queries;

	/**
	 * The default value of the '{@link #isUsingUser() <em>Using User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsingUser()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USING_USER_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isUsingContextFeature() <em>Using Context Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsingContextFeature()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USING_CONTEXT_FEATURE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isUsingQueries() <em>Using Queries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsingQueries()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USING_QUERIES_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusTableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrustablePackage.Literals.PAPYRUS_TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustablePackage.PAPYRUS_TABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustablePackage.PAPYRUS_TABLE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTable(Table newTable, NotificationChain msgs) {
		Table oldTable = table;
		table = newTable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PapyrustablePackage.PAPYRUS_TABLE__TABLE, oldTable, newTable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTable(Table newTable) {
		if (newTable != table) {
			NotificationChain msgs = null;
			if (table != null)
				msgs = ((InternalEObject)table).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PapyrustablePackage.PAPYRUS_TABLE__TABLE, null, msgs);
			if (newTable != null)
				msgs = ((InternalEObject)newTable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PapyrustablePackage.PAPYRUS_TABLE__TABLE, null, msgs);
			msgs = basicSetTable(newTable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustablePackage.PAPYRUS_TABLE__TABLE, newTable, newTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FillingMode getFillingMode() {
		return fillingMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFillingMode(FillingMode newFillingMode) {
		FillingMode oldFillingMode = fillingMode;
		fillingMode = newFillingMode == null ? FILLING_MODE_EDEFAULT : newFillingMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustablePackage.PAPYRUS_TABLE__FILLING_MODE, oldFillingMode, fillingMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextFeature() {
		if (contextFeature != null && contextFeature.eIsProxy()) {
			InternalEObject oldContextFeature = (InternalEObject)contextFeature;
			contextFeature = (EReference)eResolveProxy(oldContextFeature);
			if (contextFeature != oldContextFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrustablePackage.PAPYRUS_TABLE__CONTEXT_FEATURE, oldContextFeature, contextFeature));
			}
		}
		return contextFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetContextFeature() {
		return contextFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextFeature(EReference newContextFeature) {
		EReference oldContextFeature = contextFeature;
		contextFeature = newContextFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustablePackage.PAPYRUS_TABLE__CONTEXT_FEATURE, oldContextFeature, contextFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Query> getQueries() {
		if (queries == null) {
			queries = new EObjectResolvingEList<Query>(Query.class, this, PapyrustablePackage.PAPYRUS_TABLE__QUERIES);
		}
		return queries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isUsingUser() {
		return this.fillingMode.getValue() == FillingMode.USER_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isUsingContextFeature() {
		return this.fillingMode.getValue() == FillingMode.CONTEXT_FEATURE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isUsingQueries() {
		return this.fillingMode.getValue() == FillingMode.QUERIES_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PapyrustablePackage.PAPYRUS_TABLE__TABLE:
				return basicSetTable(null, msgs);
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
			case PapyrustablePackage.PAPYRUS_TABLE__NAME:
				return getName();
			case PapyrustablePackage.PAPYRUS_TABLE__TYPE:
				return getType();
			case PapyrustablePackage.PAPYRUS_TABLE__TABLE:
				return getTable();
			case PapyrustablePackage.PAPYRUS_TABLE__FILLING_MODE:
				return getFillingMode();
			case PapyrustablePackage.PAPYRUS_TABLE__CONTEXT_FEATURE:
				if (resolve) return getContextFeature();
				return basicGetContextFeature();
			case PapyrustablePackage.PAPYRUS_TABLE__QUERIES:
				return getQueries();
			case PapyrustablePackage.PAPYRUS_TABLE__USING_USER:
				return isUsingUser();
			case PapyrustablePackage.PAPYRUS_TABLE__USING_CONTEXT_FEATURE:
				return isUsingContextFeature();
			case PapyrustablePackage.PAPYRUS_TABLE__USING_QUERIES:
				return isUsingQueries();
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
			case PapyrustablePackage.PAPYRUS_TABLE__NAME:
				setName((String)newValue);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__TYPE:
				setType((String)newValue);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__TABLE:
				setTable((Table)newValue);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__FILLING_MODE:
				setFillingMode((FillingMode)newValue);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__CONTEXT_FEATURE:
				setContextFeature((EReference)newValue);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__QUERIES:
				getQueries().clear();
				getQueries().addAll((Collection<? extends Query>)newValue);
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
			case PapyrustablePackage.PAPYRUS_TABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__TABLE:
				setTable((Table)null);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__FILLING_MODE:
				setFillingMode(FILLING_MODE_EDEFAULT);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__CONTEXT_FEATURE:
				setContextFeature((EReference)null);
				return;
			case PapyrustablePackage.PAPYRUS_TABLE__QUERIES:
				getQueries().clear();
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
			case PapyrustablePackage.PAPYRUS_TABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PapyrustablePackage.PAPYRUS_TABLE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case PapyrustablePackage.PAPYRUS_TABLE__TABLE:
				return table != null;
			case PapyrustablePackage.PAPYRUS_TABLE__FILLING_MODE:
				return fillingMode != FILLING_MODE_EDEFAULT;
			case PapyrustablePackage.PAPYRUS_TABLE__CONTEXT_FEATURE:
				return contextFeature != null;
			case PapyrustablePackage.PAPYRUS_TABLE__QUERIES:
				return queries != null && !queries.isEmpty();
			case PapyrustablePackage.PAPYRUS_TABLE__USING_USER:
				return isUsingUser() != USING_USER_EDEFAULT;
			case PapyrustablePackage.PAPYRUS_TABLE__USING_CONTEXT_FEATURE:
				return isUsingContextFeature() != USING_CONTEXT_FEATURE_EDEFAULT;
			case PapyrustablePackage.PAPYRUS_TABLE__USING_QUERIES:
				return isUsingQueries() != USING_QUERIES_EDEFAULT;
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", type: "); //$NON-NLS-1$
		result.append(type);
		result.append(", fillingMode: "); //$NON-NLS-1$
		result.append(fillingMode);
		result.append(')');
		return result.toString();
	}

} //PapyrusTableImpl
