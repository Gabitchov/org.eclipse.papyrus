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
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl#getVerticalAxisProvider <em>Vertical Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl#getHorizontalAxisProvider <em>Horizontal Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl#getEditorDeclaration <em>Editor Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableEditorConfigurationImpl extends EModelElementImpl implements TableEditorConfiguration {
	/**
	 * The cached value of the '{@link #getVerticalAxisProvider() <em>Vertical Axis Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalAxisProvider()
	 * @generated
	 * @ordered
	 */
	protected AbstractAxisProvider verticalAxisProvider;

	/**
	 * The cached value of the '{@link #getHorizontalAxisProvider() <em>Horizontal Axis Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHorizontalAxisProvider()
	 * @generated
	 * @ordered
	 */
	protected AbstractAxisProvider horizontalAxisProvider;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableEditorConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableconfigurationPackage.Literals.TABLE_EDITOR_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAxisProvider getVerticalAxisProvider() {
		return verticalAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVerticalAxisProvider(AbstractAxisProvider newVerticalAxisProvider, NotificationChain msgs) {
		AbstractAxisProvider oldVerticalAxisProvider = verticalAxisProvider;
		verticalAxisProvider = newVerticalAxisProvider;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER, oldVerticalAxisProvider, newVerticalAxisProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerticalAxisProvider(AbstractAxisProvider newVerticalAxisProvider) {
		if (newVerticalAxisProvider != verticalAxisProvider) {
			NotificationChain msgs = null;
			if (verticalAxisProvider != null)
				msgs = ((InternalEObject)verticalAxisProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER, null, msgs);
			if (newVerticalAxisProvider != null)
				msgs = ((InternalEObject)newVerticalAxisProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER, null, msgs);
			msgs = basicSetVerticalAxisProvider(newVerticalAxisProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER, newVerticalAxisProvider, newVerticalAxisProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAxisProvider getHorizontalAxisProvider() {
		return horizontalAxisProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHorizontalAxisProvider(AbstractAxisProvider newHorizontalAxisProvider, NotificationChain msgs) {
		AbstractAxisProvider oldHorizontalAxisProvider = horizontalAxisProvider;
		horizontalAxisProvider = newHorizontalAxisProvider;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER, oldHorizontalAxisProvider, newHorizontalAxisProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHorizontalAxisProvider(AbstractAxisProvider newHorizontalAxisProvider) {
		if (newHorizontalAxisProvider != horizontalAxisProvider) {
			NotificationChain msgs = null;
			if (horizontalAxisProvider != null)
				msgs = ((InternalEObject)horizontalAxisProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER, null, msgs);
			if (newHorizontalAxisProvider != null)
				msgs = ((InternalEObject)newHorizontalAxisProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER, null, msgs);
			msgs = basicSetHorizontalAxisProvider(newHorizontalAxisProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER, newHorizontalAxisProvider, newHorizontalAxisProvider));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__EDITOR_DECLARATION, oldEditorDeclaration, editorDeclaration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER:
				return basicSetVerticalAxisProvider(null, msgs);
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER:
				return basicSetHorizontalAxisProvider(null, msgs);
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
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER:
				return getVerticalAxisProvider();
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER:
				return getHorizontalAxisProvider();
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__EDITOR_DECLARATION:
				return getEditorDeclaration();
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__TYPE:
				return getType();
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
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER:
				setVerticalAxisProvider((AbstractAxisProvider)newValue);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER:
				setHorizontalAxisProvider((AbstractAxisProvider)newValue);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__EDITOR_DECLARATION:
				setEditorDeclaration((CellEditorDeclaration)newValue);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__TYPE:
				setType((String)newValue);
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
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER:
				setVerticalAxisProvider((AbstractAxisProvider)null);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER:
				setHorizontalAxisProvider((AbstractAxisProvider)null);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__EDITOR_DECLARATION:
				setEditorDeclaration(EDITOR_DECLARATION_EDEFAULT);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__TYPE:
				setType(TYPE_EDEFAULT);
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
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER:
				return verticalAxisProvider != null;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER:
				return horizontalAxisProvider != null;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__EDITOR_DECLARATION:
				return editorDeclaration != EDITOR_DECLARATION_EDEFAULT;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(", type: "); //$NON-NLS-1$
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //TableEditorConfigurationImpl
