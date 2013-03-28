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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.AbstractTableConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Table Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.AbstractTableConfigurationImpl#getRowAxisProvider <em>Row Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.AbstractTableConfigurationImpl#getColumnAxisProvider <em>Column Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.AbstractTableConfigurationImpl#getEditorDeclaration <em>Editor Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.AbstractTableConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.AbstractTableConfigurationImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractTableConfigurationImpl extends EModelElementImpl implements AbstractTableConfiguration {
	/**
	 * The cached value of the '{@link #getRowAxisProvider() <em>Row Axis Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRowAxisProvider()
	 * @generated
	 * @ordered
	 */
	protected AbstractAxisProvider rowAxisProvider;

	/**
	 * The cached value of the '{@link #getColumnAxisProvider() <em>Column Axis Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnAxisProvider()
	 * @generated
	 * @ordered
	 */
	protected AbstractAxisProvider columnAxisProvider;

	/**
	 * The default value of the '{@link #getEditorDeclaration() <em>Editor Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorDeclaration()
	 * @generated
	 * @ordered
	 */
	protected static final CellEditorDeclaration EDITOR_DECLARATION_EDEFAULT = CellEditorDeclaration.COLUMN;

	/**
	 * The cached value of the '{@link #getEditorDeclaration() <em>Editor Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorDeclaration()
	 * @generated
	 * @ordered
	 */
	protected CellEditorDeclaration editorDeclaration = EDITOR_DECLARATION_EDEFAULT;

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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTableConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableconfigurationPackage.Literals.ABSTRACT_TABLE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAxisProvider getRowAxisProvider() {
		return rowAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRowAxisProvider(AbstractAxisProvider newRowAxisProvider, NotificationChain msgs) {
		AbstractAxisProvider oldRowAxisProvider = rowAxisProvider;
		rowAxisProvider = newRowAxisProvider;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__ROW_AXIS_PROVIDER, oldRowAxisProvider, newRowAxisProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRowAxisProvider(AbstractAxisProvider newRowAxisProvider) {
		if (newRowAxisProvider != rowAxisProvider) {
			NotificationChain msgs = null;
			if (rowAxisProvider != null)
				msgs = ((InternalEObject)rowAxisProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__ROW_AXIS_PROVIDER, null, msgs);
			if (newRowAxisProvider != null)
				msgs = ((InternalEObject)newRowAxisProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__ROW_AXIS_PROVIDER, null, msgs);
			msgs = basicSetRowAxisProvider(newRowAxisProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__ROW_AXIS_PROVIDER, newRowAxisProvider, newRowAxisProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAxisProvider getColumnAxisProvider() {
		return columnAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColumnAxisProvider(AbstractAxisProvider newColumnAxisProvider, NotificationChain msgs) {
		AbstractAxisProvider oldColumnAxisProvider = columnAxisProvider;
		columnAxisProvider = newColumnAxisProvider;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDER, oldColumnAxisProvider, newColumnAxisProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnAxisProvider(AbstractAxisProvider newColumnAxisProvider) {
		if (newColumnAxisProvider != columnAxisProvider) {
			NotificationChain msgs = null;
			if (columnAxisProvider != null)
				msgs = ((InternalEObject)columnAxisProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDER, null, msgs);
			if (newColumnAxisProvider != null)
				msgs = ((InternalEObject)newColumnAxisProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDER, null, msgs);
			msgs = basicSetColumnAxisProvider(newColumnAxisProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDER, newColumnAxisProvider, newColumnAxisProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CellEditorDeclaration getEditorDeclaration() {
		return editorDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditorDeclaration(CellEditorDeclaration newEditorDeclaration) {
		CellEditorDeclaration oldEditorDeclaration = editorDeclaration;
		editorDeclaration = newEditorDeclaration == null ? EDITOR_DECLARATION_EDEFAULT : newEditorDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__EDITOR_DECLARATION, oldEditorDeclaration, editorDeclaration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__ROW_AXIS_PROVIDER:
				return basicSetRowAxisProvider(null, msgs);
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDER:
				return basicSetColumnAxisProvider(null, msgs);
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
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__ROW_AXIS_PROVIDER:
				return getRowAxisProvider();
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDER:
				return getColumnAxisProvider();
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__EDITOR_DECLARATION:
				return getEditorDeclaration();
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__NAME:
				return getName();
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__DESCRIPTION:
				return getDescription();
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
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__ROW_AXIS_PROVIDER:
				setRowAxisProvider((AbstractAxisProvider)newValue);
				return;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDER:
				setColumnAxisProvider((AbstractAxisProvider)newValue);
				return;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__EDITOR_DECLARATION:
				setEditorDeclaration((CellEditorDeclaration)newValue);
				return;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__DESCRIPTION:
				setDescription((String)newValue);
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
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__ROW_AXIS_PROVIDER:
				setRowAxisProvider((AbstractAxisProvider)null);
				return;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDER:
				setColumnAxisProvider((AbstractAxisProvider)null);
				return;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__EDITOR_DECLARATION:
				setEditorDeclaration(EDITOR_DECLARATION_EDEFAULT);
				return;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__ROW_AXIS_PROVIDER:
				return rowAxisProvider != null;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDER:
				return columnAxisProvider != null;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__EDITOR_DECLARATION:
				return editorDeclaration != EDITOR_DECLARATION_EDEFAULT;
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NattableconfigurationPackage.ABSTRACT_TABLE_CONFIGURATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(" (editorDeclaration: "); //$NON-NLS-1$
		result.append(editorDeclaration);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", description: "); //$NON-NLS-1$
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //AbstractTableConfigurationImpl
