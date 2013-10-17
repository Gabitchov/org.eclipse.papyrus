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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.AbstractTableTester;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getIconPath <em>Icon Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getCreationTester <em>Creation
 * Tester</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getCellEditorDeclaration <em>Cell
 * Editor Declaration</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getRowHeaderAxisConfiguration <em>
 * Row Header Axis Configuration</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getColumnHeaderAxisConfiguration
 * <em>Column Header Axis Configuration</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getColumnAxisProviders <em>Column
 * Axis Providers</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getRowAxisProviders <em>Row Axis
 * Providers</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getDefaultRowAxisProvider <em>
 * Default Row Axis Provider</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl#getDefaultColumnAxisProvider <em>
 * Default Column Axis Provider</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TableConfigurationImpl extends TableNamedElementImpl implements TableConfiguration {

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconPath() <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIconPath()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconPath() <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIconPath()
	 * @generated
	 * @ordered
	 */
	protected String iconPath = ICON_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCreationTester() <em>Creation Tester</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCreationTester()
	 * @generated
	 * @ordered
	 */
	protected AbstractTableTester creationTester;

	/**
	 * The default value of the '{@link #getCellEditorDeclaration() <em>Cell Editor Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCellEditorDeclaration()
	 * @generated
	 * @ordered
	 */
	protected static final CellEditorDeclaration CELL_EDITOR_DECLARATION_EDEFAULT = CellEditorDeclaration.COLUMN;

	/**
	 * The cached value of the '{@link #getCellEditorDeclaration() <em>Cell Editor Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCellEditorDeclaration()
	 * @generated
	 * @ordered
	 */
	protected CellEditorDeclaration cellEditorDeclaration = CELL_EDITOR_DECLARATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRowHeaderAxisConfiguration() <em>Row Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRowHeaderAxisConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TableHeaderAxisConfiguration rowHeaderAxisConfiguration;

	/**
	 * The cached value of the '{@link #getColumnHeaderAxisConfiguration() <em>Column Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getColumnHeaderAxisConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TableHeaderAxisConfiguration columnHeaderAxisConfiguration;

	/**
	 * The cached value of the '{@link #getColumnAxisProviders() <em>Column Axis Providers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getColumnAxisProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAxisProvider> columnAxisProviders;

	/**
	 * The cached value of the '{@link #getRowAxisProviders() <em>Row Axis Providers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRowAxisProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAxisProvider> rowAxisProviders;

	/**
	 * The cached value of the '{@link #getDefaultRowAxisProvider() <em>Default Row Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDefaultRowAxisProvider()
	 * @generated
	 * @ordered
	 */
	protected AbstractAxisProvider defaultRowAxisProvider;

	/**
	 * The cached value of the '{@link #getDefaultColumnAxisProvider() <em>Default Column Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDefaultColumnAxisProvider()
	 * @generated
	 * @ordered
	 */
	protected AbstractAxisProvider defaultColumnAxisProvider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TableConfigurationImpl() {
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
		return NattableconfigurationPackage.Literals.TABLE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getIconPath() {
		return iconPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIconPath(String newIconPath) {
		String oldIconPath = iconPath;
		iconPath = newIconPath;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__ICON_PATH, oldIconPath, iconPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractTableTester getCreationTester() {
		return creationTester;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetCreationTester(AbstractTableTester newCreationTester, NotificationChain msgs) {
		AbstractTableTester oldCreationTester = creationTester;
		creationTester = newCreationTester;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__CREATION_TESTER, oldCreationTester, newCreationTester);
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
	public void setCreationTester(AbstractTableTester newCreationTester) {
		if(newCreationTester != creationTester) {
			NotificationChain msgs = null;
			if(creationTester != null)
				msgs = ((InternalEObject)creationTester).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_CONFIGURATION__CREATION_TESTER, null, msgs);
			if(newCreationTester != null)
				msgs = ((InternalEObject)newCreationTester).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_CONFIGURATION__CREATION_TESTER, null, msgs);
			msgs = basicSetCreationTester(newCreationTester, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__CREATION_TESTER, newCreationTester, newCreationTester));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CellEditorDeclaration getCellEditorDeclaration() {
		return cellEditorDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCellEditorDeclaration(CellEditorDeclaration newCellEditorDeclaration) {
		CellEditorDeclaration oldCellEditorDeclaration = cellEditorDeclaration;
		cellEditorDeclaration = newCellEditorDeclaration == null ? CELL_EDITOR_DECLARATION_EDEFAULT : newCellEditorDeclaration;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__CELL_EDITOR_DECLARATION, oldCellEditorDeclaration, cellEditorDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TableHeaderAxisConfiguration getRowHeaderAxisConfiguration() {
		return rowHeaderAxisConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRowHeaderAxisConfiguration(TableHeaderAxisConfiguration newRowHeaderAxisConfiguration, NotificationChain msgs) {
		TableHeaderAxisConfiguration oldRowHeaderAxisConfiguration = rowHeaderAxisConfiguration;
		rowHeaderAxisConfiguration = newRowHeaderAxisConfiguration;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION, oldRowHeaderAxisConfiguration, newRowHeaderAxisConfiguration);
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
	public void setRowHeaderAxisConfiguration(TableHeaderAxisConfiguration newRowHeaderAxisConfiguration) {
		if(newRowHeaderAxisConfiguration != rowHeaderAxisConfiguration) {
			NotificationChain msgs = null;
			if(rowHeaderAxisConfiguration != null)
				msgs = ((InternalEObject)rowHeaderAxisConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION, null, msgs);
			if(newRowHeaderAxisConfiguration != null)
				msgs = ((InternalEObject)newRowHeaderAxisConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION, null, msgs);
			msgs = basicSetRowHeaderAxisConfiguration(newRowHeaderAxisConfiguration, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION, newRowHeaderAxisConfiguration, newRowHeaderAxisConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TableHeaderAxisConfiguration getColumnHeaderAxisConfiguration() {
		return columnHeaderAxisConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetColumnHeaderAxisConfiguration(TableHeaderAxisConfiguration newColumnHeaderAxisConfiguration, NotificationChain msgs) {
		TableHeaderAxisConfiguration oldColumnHeaderAxisConfiguration = columnHeaderAxisConfiguration;
		columnHeaderAxisConfiguration = newColumnHeaderAxisConfiguration;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION, oldColumnHeaderAxisConfiguration, newColumnHeaderAxisConfiguration);
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
	public void setColumnHeaderAxisConfiguration(TableHeaderAxisConfiguration newColumnHeaderAxisConfiguration) {
		if(newColumnHeaderAxisConfiguration != columnHeaderAxisConfiguration) {
			NotificationChain msgs = null;
			if(columnHeaderAxisConfiguration != null)
				msgs = ((InternalEObject)columnHeaderAxisConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION, null, msgs);
			if(newColumnHeaderAxisConfiguration != null)
				msgs = ((InternalEObject)newColumnHeaderAxisConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION, null, msgs);
			msgs = basicSetColumnHeaderAxisConfiguration(newColumnHeaderAxisConfiguration, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION, newColumnHeaderAxisConfiguration, newColumnHeaderAxisConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractAxisProvider> getColumnAxisProviders() {
		if(columnAxisProviders == null) {
			columnAxisProviders = new EObjectContainmentEList<AbstractAxisProvider>(AbstractAxisProvider.class, this, NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDERS);
		}
		return columnAxisProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractAxisProvider> getRowAxisProviders() {
		if(rowAxisProviders == null) {
			rowAxisProviders = new EObjectContainmentEList<AbstractAxisProvider>(AbstractAxisProvider.class, this, NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_AXIS_PROVIDERS);
		}
		return rowAxisProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractAxisProvider getDefaultRowAxisProvider() {
		if(defaultRowAxisProvider != null && defaultRowAxisProvider.eIsProxy()) {
			InternalEObject oldDefaultRowAxisProvider = (InternalEObject)defaultRowAxisProvider;
			defaultRowAxisProvider = (AbstractAxisProvider)eResolveProxy(oldDefaultRowAxisProvider);
			if(defaultRowAxisProvider != oldDefaultRowAxisProvider) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER, oldDefaultRowAxisProvider, defaultRowAxisProvider));
			}
		}
		return defaultRowAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractAxisProvider basicGetDefaultRowAxisProvider() {
		return defaultRowAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefaultRowAxisProvider(AbstractAxisProvider newDefaultRowAxisProvider) {
		AbstractAxisProvider oldDefaultRowAxisProvider = defaultRowAxisProvider;
		defaultRowAxisProvider = newDefaultRowAxisProvider;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER, oldDefaultRowAxisProvider, defaultRowAxisProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractAxisProvider getDefaultColumnAxisProvider() {
		if(defaultColumnAxisProvider != null && defaultColumnAxisProvider.eIsProxy()) {
			InternalEObject oldDefaultColumnAxisProvider = (InternalEObject)defaultColumnAxisProvider;
			defaultColumnAxisProvider = (AbstractAxisProvider)eResolveProxy(oldDefaultColumnAxisProvider);
			if(defaultColumnAxisProvider != oldDefaultColumnAxisProvider) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER, oldDefaultColumnAxisProvider, defaultColumnAxisProvider));
			}
		}
		return defaultColumnAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractAxisProvider basicGetDefaultColumnAxisProvider() {
		return defaultColumnAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefaultColumnAxisProvider(AbstractAxisProvider newDefaultColumnAxisProvider) {
		AbstractAxisProvider oldDefaultColumnAxisProvider = defaultColumnAxisProvider;
		defaultColumnAxisProvider = newDefaultColumnAxisProvider;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER, oldDefaultColumnAxisProvider, defaultColumnAxisProvider));
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
		case NattableconfigurationPackage.TABLE_CONFIGURATION__CREATION_TESTER:
			return basicSetCreationTester(null, msgs);
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION:
			return basicSetRowHeaderAxisConfiguration(null, msgs);
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION:
			return basicSetColumnHeaderAxisConfiguration(null, msgs);
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDERS:
			return ((InternalEList<?>)getColumnAxisProviders()).basicRemove(otherEnd, msgs);
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_AXIS_PROVIDERS:
			return ((InternalEList<?>)getRowAxisProviders()).basicRemove(otherEnd, msgs);
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
		case NattableconfigurationPackage.TABLE_CONFIGURATION__TYPE:
			return getType();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ICON_PATH:
			return getIconPath();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__CREATION_TESTER:
			return getCreationTester();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__CELL_EDITOR_DECLARATION:
			return getCellEditorDeclaration();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION:
			return getRowHeaderAxisConfiguration();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION:
			return getColumnHeaderAxisConfiguration();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDERS:
			return getColumnAxisProviders();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_AXIS_PROVIDERS:
			return getRowAxisProviders();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER:
			if(resolve)
				return getDefaultRowAxisProvider();
			return basicGetDefaultRowAxisProvider();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER:
			if(resolve)
				return getDefaultColumnAxisProvider();
			return basicGetDefaultColumnAxisProvider();
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
		case NattableconfigurationPackage.TABLE_CONFIGURATION__TYPE:
			setType((String)newValue);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ICON_PATH:
			setIconPath((String)newValue);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__CREATION_TESTER:
			setCreationTester((AbstractTableTester)newValue);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__CELL_EDITOR_DECLARATION:
			setCellEditorDeclaration((CellEditorDeclaration)newValue);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION:
			setRowHeaderAxisConfiguration((TableHeaderAxisConfiguration)newValue);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION:
			setColumnHeaderAxisConfiguration((TableHeaderAxisConfiguration)newValue);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDERS:
			getColumnAxisProviders().clear();
			getColumnAxisProviders().addAll((Collection<? extends AbstractAxisProvider>)newValue);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_AXIS_PROVIDERS:
			getRowAxisProviders().clear();
			getRowAxisProviders().addAll((Collection<? extends AbstractAxisProvider>)newValue);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER:
			setDefaultRowAxisProvider((AbstractAxisProvider)newValue);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER:
			setDefaultColumnAxisProvider((AbstractAxisProvider)newValue);
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
		case NattableconfigurationPackage.TABLE_CONFIGURATION__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ICON_PATH:
			setIconPath(ICON_PATH_EDEFAULT);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__CREATION_TESTER:
			setCreationTester((AbstractTableTester)null);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__CELL_EDITOR_DECLARATION:
			setCellEditorDeclaration(CELL_EDITOR_DECLARATION_EDEFAULT);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION:
			setRowHeaderAxisConfiguration((TableHeaderAxisConfiguration)null);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION:
			setColumnHeaderAxisConfiguration((TableHeaderAxisConfiguration)null);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDERS:
			getColumnAxisProviders().clear();
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_AXIS_PROVIDERS:
			getRowAxisProviders().clear();
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER:
			setDefaultRowAxisProvider((AbstractAxisProvider)null);
			return;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER:
			setDefaultColumnAxisProvider((AbstractAxisProvider)null);
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
		case NattableconfigurationPackage.TABLE_CONFIGURATION__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ICON_PATH:
			return ICON_PATH_EDEFAULT == null ? iconPath != null : !ICON_PATH_EDEFAULT.equals(iconPath);
		case NattableconfigurationPackage.TABLE_CONFIGURATION__CREATION_TESTER:
			return creationTester != null;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__CELL_EDITOR_DECLARATION:
			return cellEditorDeclaration != CELL_EDITOR_DECLARATION_EDEFAULT;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION:
			return rowHeaderAxisConfiguration != null;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION:
			return columnHeaderAxisConfiguration != null;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDERS:
			return columnAxisProviders != null && !columnAxisProviders.isEmpty();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__ROW_AXIS_PROVIDERS:
			return rowAxisProviders != null && !rowAxisProviders.isEmpty();
		case NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER:
			return defaultRowAxisProvider != null;
		case NattableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER:
			return defaultColumnAxisProvider != null;
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
		result.append(" (type: "); //$NON-NLS-1$
		result.append(type);
		result.append(", iconPath: "); //$NON-NLS-1$
		result.append(iconPath);
		result.append(", cellEditorDeclaration: "); //$NON-NLS-1$
		result.append(cellEditorDeclaration);
		result.append(')');
		return result.toString();
	}

} //TableConfigurationImpl
