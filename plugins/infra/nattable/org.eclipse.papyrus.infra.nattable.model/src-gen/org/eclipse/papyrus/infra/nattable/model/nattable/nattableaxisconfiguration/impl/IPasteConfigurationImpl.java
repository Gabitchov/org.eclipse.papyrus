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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IPaste Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.IPasteConfigurationImpl#getPostActions <em>Post Actions
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.IPasteConfigurationImpl#isDetachedMode <em>Detached
 * Mode</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IPasteConfigurationImpl extends MinimalEObjectImpl.Container implements IPasteConfiguration {

	/**
	 * The cached value of the '{@link #getPostActions() <em>Post Actions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPostActions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> postActions;

	/**
	 * The default value of the '{@link #isDetachedMode() <em>Detached Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDetachedMode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DETACHED_MODE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDetachedMode() <em>Detached Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDetachedMode()
	 * @generated
	 * @ordered
	 */
	protected boolean detachedMode = DETACHED_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IPasteConfigurationImpl() {
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
		return NattableaxisconfigurationPackage.Literals.IPASTE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getPostActions() {
		if(postActions == null) {
			postActions = new EDataTypeUniqueEList<String>(String.class, this, NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__POST_ACTIONS);
		}
		return postActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDetachedMode() {
		return detachedMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDetachedMode(boolean newDetachedMode) {
		boolean oldDetachedMode = detachedMode;
		detachedMode = newDetachedMode;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__DETACHED_MODE, oldDetachedMode, detachedMode));
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
		case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__POST_ACTIONS:
			return getPostActions();
		case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__DETACHED_MODE:
			return isDetachedMode();
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
		case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__POST_ACTIONS:
			getPostActions().clear();
			getPostActions().addAll((Collection<? extends String>)newValue);
			return;
		case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__DETACHED_MODE:
			setDetachedMode((Boolean)newValue);
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
		case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__POST_ACTIONS:
			getPostActions().clear();
			return;
		case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__DETACHED_MODE:
			setDetachedMode(DETACHED_MODE_EDEFAULT);
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
		case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__POST_ACTIONS:
			return postActions != null && !postActions.isEmpty();
		case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION__DETACHED_MODE:
			return detachedMode != DETACHED_MODE_EDEFAULT;
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
		result.append(" (postActions: "); //$NON-NLS-1$
		result.append(postActions);
		result.append(", detachedMode: "); //$NON-NLS-1$
		result.append(detachedMode);
		result.append(')');
		return result.toString();
	}

} //IPasteConfigurationImpl
