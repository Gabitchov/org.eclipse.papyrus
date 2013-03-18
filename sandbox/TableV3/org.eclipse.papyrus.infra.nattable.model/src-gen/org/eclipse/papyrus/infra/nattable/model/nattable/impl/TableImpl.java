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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getEditorConfiguration <em>Editor Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getVerticalAxisProvider <em>Vertical Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getHorizontalAxisProvider <em>Horizontal Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#isInvertAxis <em>Invert Axis</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends EModelElementImpl implements Table {
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
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EObject context;

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
	 * The cached value of the '{@link #getEditorConfiguration() <em>Editor Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TableEditorConfiguration editorConfiguration;

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
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableEditorConfiguration getEditorConfiguration() {
		if (editorConfiguration != null && editorConfiguration.eIsProxy()) {
			InternalEObject oldEditorConfiguration = (InternalEObject)editorConfiguration;
			editorConfiguration = (TableEditorConfiguration)eResolveProxy(oldEditorConfiguration);
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
	public TableEditorConfiguration basicGetEditorConfiguration() {
		return editorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditorConfiguration(TableEditorConfiguration newEditorConfiguration) {
		TableEditorConfiguration oldEditorConfiguration = editorConfiguration;
		editorConfiguration = newEditorConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__EDITOR_CONFIGURATION, oldEditorConfiguration, editorConfiguration));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__VERTICAL_AXIS_PROVIDER, oldVerticalAxisProvider, newVerticalAxisProvider);
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
				msgs = ((InternalEObject)verticalAxisProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__VERTICAL_AXIS_PROVIDER, null, msgs);
			if (newVerticalAxisProvider != null)
				msgs = ((InternalEObject)newVerticalAxisProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__VERTICAL_AXIS_PROVIDER, null, msgs);
			msgs = basicSetVerticalAxisProvider(newVerticalAxisProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__VERTICAL_AXIS_PROVIDER, newVerticalAxisProvider, newVerticalAxisProvider));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__HORIZONTAL_AXIS_PROVIDER, oldHorizontalAxisProvider, newHorizontalAxisProvider);
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
				msgs = ((InternalEObject)horizontalAxisProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__HORIZONTAL_AXIS_PROVIDER, null, msgs);
			if (newHorizontalAxisProvider != null)
				msgs = ((InternalEObject)newHorizontalAxisProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__HORIZONTAL_AXIS_PROVIDER, null, msgs);
			msgs = basicSetHorizontalAxisProvider(newHorizontalAxisProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__HORIZONTAL_AXIS_PROVIDER, newHorizontalAxisProvider, newHorizontalAxisProvider));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattablePackage.TABLE__VERTICAL_AXIS_PROVIDER:
				return basicSetVerticalAxisProvider(null, msgs);
			case NattablePackage.TABLE__HORIZONTAL_AXIS_PROVIDER:
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
			case NattablePackage.TABLE__NAME:
				return getName();
			case NattablePackage.TABLE__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case NattablePackage.TABLE__DESCRIPTION:
				return getDescription();
			case NattablePackage.TABLE__EDITOR_CONFIGURATION:
				if (resolve) return getEditorConfiguration();
				return basicGetEditorConfiguration();
			case NattablePackage.TABLE__VERTICAL_AXIS_PROVIDER:
				return getVerticalAxisProvider();
			case NattablePackage.TABLE__HORIZONTAL_AXIS_PROVIDER:
				return getHorizontalAxisProvider();
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
			case NattablePackage.TABLE__NAME:
				setName((String)newValue);
				return;
			case NattablePackage.TABLE__CONTEXT:
				setContext((EObject)newValue);
				return;
			case NattablePackage.TABLE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case NattablePackage.TABLE__EDITOR_CONFIGURATION:
				setEditorConfiguration((TableEditorConfiguration)newValue);
				return;
			case NattablePackage.TABLE__VERTICAL_AXIS_PROVIDER:
				setVerticalAxisProvider((AbstractAxisProvider)newValue);
				return;
			case NattablePackage.TABLE__HORIZONTAL_AXIS_PROVIDER:
				setHorizontalAxisProvider((AbstractAxisProvider)newValue);
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
			case NattablePackage.TABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NattablePackage.TABLE__CONTEXT:
				setContext((EObject)null);
				return;
			case NattablePackage.TABLE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case NattablePackage.TABLE__EDITOR_CONFIGURATION:
				setEditorConfiguration((TableEditorConfiguration)null);
				return;
			case NattablePackage.TABLE__VERTICAL_AXIS_PROVIDER:
				setVerticalAxisProvider((AbstractAxisProvider)null);
				return;
			case NattablePackage.TABLE__HORIZONTAL_AXIS_PROVIDER:
				setHorizontalAxisProvider((AbstractAxisProvider)null);
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
			case NattablePackage.TABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NattablePackage.TABLE__CONTEXT:
				return context != null;
			case NattablePackage.TABLE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case NattablePackage.TABLE__EDITOR_CONFIGURATION:
				return editorConfiguration != null;
			case NattablePackage.TABLE__VERTICAL_AXIS_PROVIDER:
				return verticalAxisProvider != null;
			case NattablePackage.TABLE__HORIZONTAL_AXIS_PROVIDER:
				return horizontalAxisProvider != null;
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", invertAxis: "); //$NON-NLS-1$
		result.append(invertAxis);
		result.append(')');
		return result.toString();
	}

} //TableImpl
