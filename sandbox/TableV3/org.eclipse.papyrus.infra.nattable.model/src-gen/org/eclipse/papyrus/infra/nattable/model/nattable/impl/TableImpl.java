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

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;

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
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getVerticalContentProvider <em>Vertical Content Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl#getHorizontalContentProvider <em>Horizontal Content Provider</em>}</li>
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
	 * The cached value of the '{@link #getEditorConfiguration() <em>Editor Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorConfiguration()
	 * @generated
	 * @ordered
	 */
	protected LocalTableEditorConfiguration editorConfiguration;

	/**
	 * The cached value of the '{@link #getVerticalContentProvider() <em>Vertical Content Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalContentProvider()
	 * @generated
	 * @ordered
	 */
	protected IAxisContentsProvider verticalContentProvider;

	/**
	 * The cached value of the '{@link #getHorizontalContentProvider() <em>Horizontal Content Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHorizontalContentProvider()
	 * @generated
	 * @ordered
	 */
	protected IAxisContentsProvider horizontalContentProvider;

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
	public LocalTableEditorConfiguration getEditorConfiguration() {
		return editorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEditorConfiguration(LocalTableEditorConfiguration newEditorConfiguration, NotificationChain msgs) {
		LocalTableEditorConfiguration oldEditorConfiguration = editorConfiguration;
		editorConfiguration = newEditorConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__EDITOR_CONFIGURATION, oldEditorConfiguration, newEditorConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditorConfiguration(LocalTableEditorConfiguration newEditorConfiguration) {
		if (newEditorConfiguration != editorConfiguration) {
			NotificationChain msgs = null;
			if (editorConfiguration != null)
				msgs = ((InternalEObject)editorConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__EDITOR_CONFIGURATION, null, msgs);
			if (newEditorConfiguration != null)
				msgs = ((InternalEObject)newEditorConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__EDITOR_CONFIGURATION, null, msgs);
			msgs = basicSetEditorConfiguration(newEditorConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__EDITOR_CONFIGURATION, newEditorConfiguration, newEditorConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAxisContentsProvider getVerticalContentProvider() {
		return verticalContentProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVerticalContentProvider(IAxisContentsProvider newVerticalContentProvider, NotificationChain msgs) {
		IAxisContentsProvider oldVerticalContentProvider = verticalContentProvider;
		verticalContentProvider = newVerticalContentProvider;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__VERTICAL_CONTENT_PROVIDER, oldVerticalContentProvider, newVerticalContentProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerticalContentProvider(IAxisContentsProvider newVerticalContentProvider) {
		if (newVerticalContentProvider != verticalContentProvider) {
			NotificationChain msgs = null;
			if (verticalContentProvider != null)
				msgs = ((InternalEObject)verticalContentProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__VERTICAL_CONTENT_PROVIDER, null, msgs);
			if (newVerticalContentProvider != null)
				msgs = ((InternalEObject)newVerticalContentProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__VERTICAL_CONTENT_PROVIDER, null, msgs);
			msgs = basicSetVerticalContentProvider(newVerticalContentProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__VERTICAL_CONTENT_PROVIDER, newVerticalContentProvider, newVerticalContentProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAxisContentsProvider getHorizontalContentProvider() {
		return horizontalContentProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHorizontalContentProvider(IAxisContentsProvider newHorizontalContentProvider, NotificationChain msgs) {
		IAxisContentsProvider oldHorizontalContentProvider = horizontalContentProvider;
		horizontalContentProvider = newHorizontalContentProvider;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__HORIZONTAL_CONTENT_PROVIDER, oldHorizontalContentProvider, newHorizontalContentProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHorizontalContentProvider(IAxisContentsProvider newHorizontalContentProvider) {
		if (newHorizontalContentProvider != horizontalContentProvider) {
			NotificationChain msgs = null;
			if (horizontalContentProvider != null)
				msgs = ((InternalEObject)horizontalContentProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__HORIZONTAL_CONTENT_PROVIDER, null, msgs);
			if (newHorizontalContentProvider != null)
				msgs = ((InternalEObject)newHorizontalContentProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablePackage.TABLE__HORIZONTAL_CONTENT_PROVIDER, null, msgs);
			msgs = basicSetHorizontalContentProvider(newHorizontalContentProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.TABLE__HORIZONTAL_CONTENT_PROVIDER, newHorizontalContentProvider, newHorizontalContentProvider));
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
			case NattablePackage.TABLE__EDITOR_CONFIGURATION:
				return basicSetEditorConfiguration(null, msgs);
			case NattablePackage.TABLE__VERTICAL_CONTENT_PROVIDER:
				return basicSetVerticalContentProvider(null, msgs);
			case NattablePackage.TABLE__HORIZONTAL_CONTENT_PROVIDER:
				return basicSetHorizontalContentProvider(null, msgs);
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
				return getEditorConfiguration();
			case NattablePackage.TABLE__VERTICAL_CONTENT_PROVIDER:
				return getVerticalContentProvider();
			case NattablePackage.TABLE__HORIZONTAL_CONTENT_PROVIDER:
				return getHorizontalContentProvider();
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
				setEditorConfiguration((LocalTableEditorConfiguration)newValue);
				return;
			case NattablePackage.TABLE__VERTICAL_CONTENT_PROVIDER:
				setVerticalContentProvider((IAxisContentsProvider)newValue);
				return;
			case NattablePackage.TABLE__HORIZONTAL_CONTENT_PROVIDER:
				setHorizontalContentProvider((IAxisContentsProvider)newValue);
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
				setEditorConfiguration((LocalTableEditorConfiguration)null);
				return;
			case NattablePackage.TABLE__VERTICAL_CONTENT_PROVIDER:
				setVerticalContentProvider((IAxisContentsProvider)null);
				return;
			case NattablePackage.TABLE__HORIZONTAL_CONTENT_PROVIDER:
				setHorizontalContentProvider((IAxisContentsProvider)null);
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
			case NattablePackage.TABLE__VERTICAL_CONTENT_PROVIDER:
				return verticalContentProvider != null;
			case NattablePackage.TABLE__HORIZONTAL_CONTENT_PROVIDER:
				return horizontalContentProvider != null;
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
