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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableNamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getTableConfiguration <em>Table Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#isInvertAxis <em>Invert Axis</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getColumnAxisProvidersHistory <em>Column Axis Providers History</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getRowAxisProvidersHistory <em>Row Axis Providers History</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getLocalRowHeaderAxisConfiguration <em>Local Row Header Axis Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getLocalColumnHeaderAxisConfiguration <em>Local Column Header Axis Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getCurrentRowAxisProvider <em>Current Row Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getCurrentColumnAxisProvider <em>Current Column Axis Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends TableNamedElementImpl implements Table {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EObject context;

	/**
	 * The cached value of the '{@link #getTableConfiguration() <em>Table Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TableConfiguration tableConfiguration;

	/**
	 * The default value of the '{@link #isInvertAxis() <em>Invert Axis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInvertAxis()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INVERT_AXIS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInvertAxis() <em>Invert Axis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInvertAxis()
	 * @generated
	 * @ordered
	 */
	protected boolean invertAxis = INVERT_AXIS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getColumnAxisProvidersHistory() <em>Column Axis Providers History</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnAxisProvidersHistory()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAxisProvider> columnAxisProvidersHistory;

	/**
	 * The cached value of the '{@link #getRowAxisProvidersHistory() <em>Row Axis Providers History</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRowAxisProvidersHistory()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAxisProvider> rowAxisProvidersHistory;

	/**
	 * The cached value of the '{@link #getLocalRowHeaderAxisConfiguration() <em>Local Row Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalRowHeaderAxisConfiguration()
	 * @generated
	 * @ordered
	 */
	protected LocalTableHeaderAxisConfiguration localRowHeaderAxisConfiguration;

	/**
	 * The cached value of the '{@link #getLocalColumnHeaderAxisConfiguration() <em>Local Column Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalColumnHeaderAxisConfiguration()
	 * @generated
	 * @ordered
	 */
	protected LocalTableHeaderAxisConfiguration localColumnHeaderAxisConfiguration;

	/**
	 * The cached value of the '{@link #getCurrentRowAxisProvider() <em>Current Row Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentRowAxisProvider()
	 * @generated
	 * @ordered
	 */
	protected AbstractAxisProvider currentRowAxisProvider;

	/**
	 * The cached value of the '{@link #getCurrentColumnAxisProvider() <em>Current Column Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentColumnAxisProvider()
	 * @generated
	 * @ordered
	 */
	protected AbstractAxisProvider currentColumnAxisProvider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattablePackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattablePackage.TABLE__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(EObject newContext) {
		EObject oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableConfiguration getTableConfiguration() {
		if (tableConfiguration != null && tableConfiguration.eIsProxy()) {
			InternalEObject oldTableConfiguration = (InternalEObject)tableConfiguration;
			tableConfiguration = (TableConfiguration)eResolveProxy(oldTableConfiguration);
			if (tableConfiguration != oldTableConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattablePackage.TABLE__TABLE_CONFIGURATION, oldTableConfiguration, tableConfiguration));
			}
		}
		return tableConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableConfiguration basicGetTableConfiguration() {
		return tableConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableConfiguration(TableConfiguration newTableConfiguration) {
		TableConfiguration oldTableConfiguration = tableConfiguration;
		tableConfiguration = newTableConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__TABLE_CONFIGURATION, oldTableConfiguration, tableConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInvertAxis() {
		return invertAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvertAxis(boolean newInvertAxis) {
		boolean oldInvertAxis = invertAxis;
		invertAxis = newInvertAxis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__INVERT_AXIS, oldInvertAxis, invertAxis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAxisProvider> getColumnAxisProvidersHistory() {
		if (columnAxisProvidersHistory == null) {
			columnAxisProvidersHistory = new EObjectContainmentEList<AbstractAxisProvider>(AbstractAxisProvider.class, this, NattablePackage.TABLE__COLUMN_AXIS_PROVIDERS_HISTORY);
		}
		return columnAxisProvidersHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAxisProvider> getRowAxisProvidersHistory() {
		if (rowAxisProvidersHistory == null) {
			rowAxisProvidersHistory = new EObjectContainmentEList<AbstractAxisProvider>(AbstractAxisProvider.class, this, NattablePackage.TABLE__ROW_AXIS_PROVIDERS_HISTORY);
		}
		return rowAxisProvidersHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalTableHeaderAxisConfiguration getLocalRowHeaderAxisConfiguration() {
		return localRowHeaderAxisConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalRowHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration newLocalRowHeaderAxisConfiguration, NotificationChain msgs) {
		LocalTableHeaderAxisConfiguration oldLocalRowHeaderAxisConfiguration = localRowHeaderAxisConfiguration;
		localRowHeaderAxisConfiguration = newLocalRowHeaderAxisConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION, oldLocalRowHeaderAxisConfiguration, newLocalRowHeaderAxisConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalRowHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration newLocalRowHeaderAxisConfiguration) {
		if (newLocalRowHeaderAxisConfiguration != localRowHeaderAxisConfiguration) {
			NotificationChain msgs = null;
			if (localRowHeaderAxisConfiguration != null)
				msgs = ((InternalEObject)localRowHeaderAxisConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION, null, msgs);
			if (newLocalRowHeaderAxisConfiguration != null)
				msgs = ((InternalEObject)newLocalRowHeaderAxisConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION, null, msgs);
			msgs = basicSetLocalRowHeaderAxisConfiguration(newLocalRowHeaderAxisConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION, newLocalRowHeaderAxisConfiguration, newLocalRowHeaderAxisConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalTableHeaderAxisConfiguration getLocalColumnHeaderAxisConfiguration() {
		return localColumnHeaderAxisConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalColumnHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration newLocalColumnHeaderAxisConfiguration, NotificationChain msgs) {
		LocalTableHeaderAxisConfiguration oldLocalColumnHeaderAxisConfiguration = localColumnHeaderAxisConfiguration;
		localColumnHeaderAxisConfiguration = newLocalColumnHeaderAxisConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION, oldLocalColumnHeaderAxisConfiguration, newLocalColumnHeaderAxisConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalColumnHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration newLocalColumnHeaderAxisConfiguration) {
		if (newLocalColumnHeaderAxisConfiguration != localColumnHeaderAxisConfiguration) {
			NotificationChain msgs = null;
			if (localColumnHeaderAxisConfiguration != null)
				msgs = ((InternalEObject)localColumnHeaderAxisConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION, null, msgs);
			if (newLocalColumnHeaderAxisConfiguration != null)
				msgs = ((InternalEObject)newLocalColumnHeaderAxisConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION, null, msgs);
			msgs = basicSetLocalColumnHeaderAxisConfiguration(newLocalColumnHeaderAxisConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION, newLocalColumnHeaderAxisConfiguration, newLocalColumnHeaderAxisConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAxisProvider getCurrentRowAxisProvider() {
		if (currentRowAxisProvider != null && currentRowAxisProvider.eIsProxy()) {
			InternalEObject oldCurrentRowAxisProvider = (InternalEObject)currentRowAxisProvider;
			currentRowAxisProvider = (AbstractAxisProvider)eResolveProxy(oldCurrentRowAxisProvider);
			if (currentRowAxisProvider != oldCurrentRowAxisProvider) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattablePackage.TABLE__CURRENT_ROW_AXIS_PROVIDER, oldCurrentRowAxisProvider, currentRowAxisProvider));
			}
		}
		return currentRowAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAxisProvider basicGetCurrentRowAxisProvider() {
		return currentRowAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentRowAxisProvider(AbstractAxisProvider newCurrentRowAxisProvider) {
		AbstractAxisProvider oldCurrentRowAxisProvider = currentRowAxisProvider;
		currentRowAxisProvider = newCurrentRowAxisProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__CURRENT_ROW_AXIS_PROVIDER, oldCurrentRowAxisProvider, currentRowAxisProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAxisProvider getCurrentColumnAxisProvider() {
		if (currentColumnAxisProvider != null && currentColumnAxisProvider.eIsProxy()) {
			InternalEObject oldCurrentColumnAxisProvider = (InternalEObject)currentColumnAxisProvider;
			currentColumnAxisProvider = (AbstractAxisProvider)eResolveProxy(oldCurrentColumnAxisProvider);
			if (currentColumnAxisProvider != oldCurrentColumnAxisProvider) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattablePackage.TABLE__CURRENT_COLUMN_AXIS_PROVIDER, oldCurrentColumnAxisProvider, currentColumnAxisProvider));
			}
		}
		return currentColumnAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAxisProvider basicGetCurrentColumnAxisProvider() {
		return currentColumnAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentColumnAxisProvider(AbstractAxisProvider newCurrentColumnAxisProvider) {
		AbstractAxisProvider oldCurrentColumnAxisProvider = currentColumnAxisProvider;
		currentColumnAxisProvider = newCurrentColumnAxisProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__CURRENT_COLUMN_AXIS_PROVIDER, oldCurrentColumnAxisProvider, currentColumnAxisProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattablePackage.TABLE__COLUMN_AXIS_PROVIDERS_HISTORY:
				return ((InternalEList<?>)getColumnAxisProvidersHistory()).basicRemove(otherEnd, msgs);
			case NattablePackage.TABLE__ROW_AXIS_PROVIDERS_HISTORY:
				return ((InternalEList<?>)getRowAxisProvidersHistory()).basicRemove(otherEnd, msgs);
			case NattablePackage.TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION:
				return basicSetLocalRowHeaderAxisConfiguration(null, msgs);
			case NattablePackage.TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION:
				return basicSetLocalColumnHeaderAxisConfiguration(null, msgs);
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
			case NattablePackage.TABLE__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case NattablePackage.TABLE__TABLE_CONFIGURATION:
				if (resolve) return getTableConfiguration();
				return basicGetTableConfiguration();
			case NattablePackage.TABLE__INVERT_AXIS:
				return isInvertAxis();
			case NattablePackage.TABLE__COLUMN_AXIS_PROVIDERS_HISTORY:
				return getColumnAxisProvidersHistory();
			case NattablePackage.TABLE__ROW_AXIS_PROVIDERS_HISTORY:
				return getRowAxisProvidersHistory();
			case NattablePackage.TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION:
				return getLocalRowHeaderAxisConfiguration();
			case NattablePackage.TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION:
				return getLocalColumnHeaderAxisConfiguration();
			case NattablePackage.TABLE__CURRENT_ROW_AXIS_PROVIDER:
				if (resolve) return getCurrentRowAxisProvider();
				return basicGetCurrentRowAxisProvider();
			case NattablePackage.TABLE__CURRENT_COLUMN_AXIS_PROVIDER:
				if (resolve) return getCurrentColumnAxisProvider();
				return basicGetCurrentColumnAxisProvider();
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
			case NattablePackage.TABLE__CONTEXT:
				setContext((EObject)newValue);
				return;
			case NattablePackage.TABLE__TABLE_CONFIGURATION:
				setTableConfiguration((TableConfiguration)newValue);
				return;
			case NattablePackage.TABLE__INVERT_AXIS:
				setInvertAxis((Boolean)newValue);
				return;
			case NattablePackage.TABLE__COLUMN_AXIS_PROVIDERS_HISTORY:
				getColumnAxisProvidersHistory().clear();
				getColumnAxisProvidersHistory().addAll((Collection<? extends AbstractAxisProvider>)newValue);
				return;
			case NattablePackage.TABLE__ROW_AXIS_PROVIDERS_HISTORY:
				getRowAxisProvidersHistory().clear();
				getRowAxisProvidersHistory().addAll((Collection<? extends AbstractAxisProvider>)newValue);
				return;
			case NattablePackage.TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION:
				setLocalRowHeaderAxisConfiguration((LocalTableHeaderAxisConfiguration)newValue);
				return;
			case NattablePackage.TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION:
				setLocalColumnHeaderAxisConfiguration((LocalTableHeaderAxisConfiguration)newValue);
				return;
			case NattablePackage.TABLE__CURRENT_ROW_AXIS_PROVIDER:
				setCurrentRowAxisProvider((AbstractAxisProvider)newValue);
				return;
			case NattablePackage.TABLE__CURRENT_COLUMN_AXIS_PROVIDER:
				setCurrentColumnAxisProvider((AbstractAxisProvider)newValue);
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
			case NattablePackage.TABLE__CONTEXT:
				setContext((EObject)null);
				return;
			case NattablePackage.TABLE__TABLE_CONFIGURATION:
				setTableConfiguration((TableConfiguration)null);
				return;
			case NattablePackage.TABLE__INVERT_AXIS:
				setInvertAxis(INVERT_AXIS_EDEFAULT);
				return;
			case NattablePackage.TABLE__COLUMN_AXIS_PROVIDERS_HISTORY:
				getColumnAxisProvidersHistory().clear();
				return;
			case NattablePackage.TABLE__ROW_AXIS_PROVIDERS_HISTORY:
				getRowAxisProvidersHistory().clear();
				return;
			case NattablePackage.TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION:
				setLocalRowHeaderAxisConfiguration((LocalTableHeaderAxisConfiguration)null);
				return;
			case NattablePackage.TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION:
				setLocalColumnHeaderAxisConfiguration((LocalTableHeaderAxisConfiguration)null);
				return;
			case NattablePackage.TABLE__CURRENT_ROW_AXIS_PROVIDER:
				setCurrentRowAxisProvider((AbstractAxisProvider)null);
				return;
			case NattablePackage.TABLE__CURRENT_COLUMN_AXIS_PROVIDER:
				setCurrentColumnAxisProvider((AbstractAxisProvider)null);
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
			case NattablePackage.TABLE__CONTEXT:
				return context != null;
			case NattablePackage.TABLE__TABLE_CONFIGURATION:
				return tableConfiguration != null;
			case NattablePackage.TABLE__INVERT_AXIS:
				return invertAxis != INVERT_AXIS_EDEFAULT;
			case NattablePackage.TABLE__COLUMN_AXIS_PROVIDERS_HISTORY:
				return columnAxisProvidersHistory != null && !columnAxisProvidersHistory.isEmpty();
			case NattablePackage.TABLE__ROW_AXIS_PROVIDERS_HISTORY:
				return rowAxisProvidersHistory != null && !rowAxisProvidersHistory.isEmpty();
			case NattablePackage.TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION:
				return localRowHeaderAxisConfiguration != null;
			case NattablePackage.TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION:
				return localColumnHeaderAxisConfiguration != null;
			case NattablePackage.TABLE__CURRENT_ROW_AXIS_PROVIDER:
				return currentRowAxisProvider != null;
			case NattablePackage.TABLE__CURRENT_COLUMN_AXIS_PROVIDER:
				return currentColumnAxisProvider != null;
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
		result.append(" (invertAxis: "); //$NON-NLS-1$
		result.append(invertAxis);
		result.append(')');
		return result.toString();
	}

} //TableImpl
