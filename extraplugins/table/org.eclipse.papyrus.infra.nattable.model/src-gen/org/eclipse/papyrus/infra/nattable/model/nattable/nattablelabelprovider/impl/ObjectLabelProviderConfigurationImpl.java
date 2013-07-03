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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Label Provider Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.ObjectLabelProviderConfigurationImpl#isDisplayIcon <em>
 * Display Icon</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.ObjectLabelProviderConfigurationImpl#isDisplayLabel <em>
 * Display Label</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ObjectLabelProviderConfigurationImpl extends EModelElementImpl implements ObjectLabelProviderConfiguration {

	/**
	 * The default value of the '{@link #isDisplayIcon() <em>Display Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDisplayIcon()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_ICON_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisplayIcon() <em>Display Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDisplayIcon()
	 * @generated
	 * @ordered
	 */
	protected boolean displayIcon = DISPLAY_ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisplayLabel() <em>Display Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDisplayLabel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_LABEL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisplayLabel() <em>Display Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDisplayLabel()
	 * @generated
	 * @ordered
	 */
	protected boolean displayLabel = DISPLAY_LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ObjectLabelProviderConfigurationImpl() {
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
		return NattablelabelproviderPackage.Literals.OBJECT_LABEL_PROVIDER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDisplayIcon() {
		return displayIcon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDisplayIcon(boolean newDisplayIcon) {
		boolean oldDisplayIcon = displayIcon;
		displayIcon = newDisplayIcon;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON, oldDisplayIcon, displayIcon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDisplayLabel() {
		return displayLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDisplayLabel(boolean newDisplayLabel) {
		boolean oldDisplayLabel = displayLabel;
		displayLabel = newDisplayLabel;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_LABEL, oldDisplayLabel, displayLabel));
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
		case NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON:
			return isDisplayIcon();
		case NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_LABEL:
			return isDisplayLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON:
			setDisplayIcon((Boolean)newValue);
			return;
		case NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_LABEL:
			setDisplayLabel((Boolean)newValue);
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
		case NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON:
			setDisplayIcon(DISPLAY_ICON_EDEFAULT);
			return;
		case NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_LABEL:
			setDisplayLabel(DISPLAY_LABEL_EDEFAULT);
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
		case NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON:
			return displayIcon != DISPLAY_ICON_EDEFAULT;
		case NattablelabelproviderPackage.OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_LABEL:
			return displayLabel != DISPLAY_LABEL_EDEFAULT;
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
		result.append(" (displayIcon: "); //$NON-NLS-1$
		result.append(displayIcon);
		result.append(", displayLabel: "); //$NON-NLS-1$
		result.append(displayLabel);
		result.append(')');
		return result.toString();
	}

} //ObjectLabelProviderConfigurationImpl
