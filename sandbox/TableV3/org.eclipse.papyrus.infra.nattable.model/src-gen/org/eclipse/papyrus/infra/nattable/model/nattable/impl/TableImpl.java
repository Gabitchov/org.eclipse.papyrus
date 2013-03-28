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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.AbstractTableConfigurationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getEditorConfiguration <em>Editor Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#isInvertAxis <em>Invert Axis</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends AbstractTableConfigurationImpl implements Table {
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
	 * The cached value of the '{@link #getEditorConfiguration() <em>Editor Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TableConfiguration editorConfiguration;

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
	public TableConfiguration getEditorConfiguration() {
		if (editorConfiguration != null && editorConfiguration.eIsProxy()) {
			InternalEObject oldEditorConfiguration = (InternalEObject)editorConfiguration;
			editorConfiguration = (TableConfiguration)eResolveProxy(oldEditorConfiguration);
			if (editorConfiguration != oldEditorConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattablePackage.TABLE__EDITOR_CONFIGURATION, oldEditorConfiguration, editorConfiguration));
			}
		}
		return editorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableConfiguration basicGetEditorConfiguration() {
		return editorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditorConfiguration(TableConfiguration newEditorConfiguration) {
		TableConfiguration oldEditorConfiguration = editorConfiguration;
		editorConfiguration = newEditorConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__EDITOR_CONFIGURATION, oldEditorConfiguration, editorConfiguration));
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattablePackage.TABLE__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case NattablePackage.TABLE__EDITOR_CONFIGURATION:
				if (resolve) return getEditorConfiguration();
				return basicGetEditorConfiguration();
			case NattablePackage.TABLE__INVERT_AXIS:
				return isInvertAxis();
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
			case NattablePackage.TABLE__CONTEXT:
				setContext((EObject)newValue);
				return;
			case NattablePackage.TABLE__EDITOR_CONFIGURATION:
				setEditorConfiguration((TableConfiguration)newValue);
				return;
			case NattablePackage.TABLE__INVERT_AXIS:
				setInvertAxis((Boolean)newValue);
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
			case NattablePackage.TABLE__EDITOR_CONFIGURATION:
				setEditorConfiguration((TableConfiguration)null);
				return;
			case NattablePackage.TABLE__INVERT_AXIS:
				setInvertAxis(INVERT_AXIS_EDEFAULT);
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
			case NattablePackage.TABLE__EDITOR_CONFIGURATION:
				return editorConfiguration != null;
			case NattablePackage.TABLE__INVERT_AXIS:
				return invertAxis != INVERT_AXIS_EDEFAULT;
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
