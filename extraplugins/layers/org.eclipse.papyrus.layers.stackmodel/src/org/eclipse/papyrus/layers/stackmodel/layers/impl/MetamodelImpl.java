/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.Metamodel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metamodel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.MetamodelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.MetamodelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.MetamodelImpl#getNsuri <em>Nsuri</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.MetamodelImpl#getPluginID <em>Plugin ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.MetamodelImpl#getEPackageInstanceName <em>EPackage Instance Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.MetamodelImpl#isTypeValid <em>Is Type Valid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetamodelImpl extends 
FolderElementImpl implements Metamodel {
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
	 * The default value of the '{@link #getNsuri() <em>Nsuri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsuri()
	 * @generated
	 * @ordered
	 */
	protected static final String NSURI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsuri() <em>Nsuri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsuri()
	 * @generated
	 * @ordered
	 */
	protected String nsuri = NSURI_EDEFAULT;

	/**
	 * The default value of the '{@link #getPluginID() <em>Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginID()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPluginID() <em>Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginID()
	 * @generated
	 * @ordered
	 */
	protected String pluginID = PLUGIN_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getEPackageInstanceName() <em>EPackage Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageInstanceName()
	 * @generated
	 * @ordered
	 */
	protected static final String EPACKAGE_INSTANCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEPackageInstanceName() <em>EPackage Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageInstanceName()
	 * @generated
	 * @ordered
	 */
	protected String ePackageInstanceName = EPACKAGE_INSTANCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isTypeValid() <em>Is Type Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypeValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TYPE_VALID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTypeValid() <em>Is Type Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypeValid()
	 * @generated
	 * @ordered
	 */
	protected boolean isTypeValid = IS_TYPE_VALID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetamodelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.METAMODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.METAMODEL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.METAMODEL__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsuri() {
		return nsuri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsuri(String newNsuri) {
		String oldNsuri = nsuri;
		nsuri = newNsuri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.METAMODEL__NSURI, oldNsuri, nsuri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPluginID() {
		return pluginID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginID(String newPluginID) {
		String oldPluginID = pluginID;
		pluginID = newPluginID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.METAMODEL__PLUGIN_ID, oldPluginID, pluginID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEPackageInstanceName() {
		return ePackageInstanceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEPackageInstanceName(String newEPackageInstanceName) {
		String oldEPackageInstanceName = ePackageInstanceName;
		ePackageInstanceName = newEPackageInstanceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.METAMODEL__EPACKAGE_INSTANCE_NAME, oldEPackageInstanceName, ePackageInstanceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypeValid() {
		return isTypeValid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTypeValid(boolean newIsTypeValid) {
		boolean oldIsTypeValid = isTypeValid;
		isTypeValid = newIsTypeValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.METAMODEL__IS_TYPE_VALID, oldIsTypeValid, isTypeValid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getEPackage() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.METAMODEL__NAME:
				return getName();
			case LayersPackage.METAMODEL__DESCRIPTION:
				return getDescription();
			case LayersPackage.METAMODEL__NSURI:
				return getNsuri();
			case LayersPackage.METAMODEL__PLUGIN_ID:
				return getPluginID();
			case LayersPackage.METAMODEL__EPACKAGE_INSTANCE_NAME:
				return getEPackageInstanceName();
			case LayersPackage.METAMODEL__IS_TYPE_VALID:
				return isTypeValid();
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
			case LayersPackage.METAMODEL__NAME:
				setName((String)newValue);
				return;
			case LayersPackage.METAMODEL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LayersPackage.METAMODEL__NSURI:
				setNsuri((String)newValue);
				return;
			case LayersPackage.METAMODEL__PLUGIN_ID:
				setPluginID((String)newValue);
				return;
			case LayersPackage.METAMODEL__EPACKAGE_INSTANCE_NAME:
				setEPackageInstanceName((String)newValue);
				return;
			case LayersPackage.METAMODEL__IS_TYPE_VALID:
				setIsTypeValid((Boolean)newValue);
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
			case LayersPackage.METAMODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LayersPackage.METAMODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LayersPackage.METAMODEL__NSURI:
				setNsuri(NSURI_EDEFAULT);
				return;
			case LayersPackage.METAMODEL__PLUGIN_ID:
				setPluginID(PLUGIN_ID_EDEFAULT);
				return;
			case LayersPackage.METAMODEL__EPACKAGE_INSTANCE_NAME:
				setEPackageInstanceName(EPACKAGE_INSTANCE_NAME_EDEFAULT);
				return;
			case LayersPackage.METAMODEL__IS_TYPE_VALID:
				setIsTypeValid(IS_TYPE_VALID_EDEFAULT);
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
			case LayersPackage.METAMODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LayersPackage.METAMODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LayersPackage.METAMODEL__NSURI:
				return NSURI_EDEFAULT == null ? nsuri != null : !NSURI_EDEFAULT.equals(nsuri);
			case LayersPackage.METAMODEL__PLUGIN_ID:
				return PLUGIN_ID_EDEFAULT == null ? pluginID != null : !PLUGIN_ID_EDEFAULT.equals(pluginID);
			case LayersPackage.METAMODEL__EPACKAGE_INSTANCE_NAME:
				return EPACKAGE_INSTANCE_NAME_EDEFAULT == null ? ePackageInstanceName != null : !EPACKAGE_INSTANCE_NAME_EDEFAULT.equals(ePackageInstanceName);
			case LayersPackage.METAMODEL__IS_TYPE_VALID:
				return isTypeValid != IS_TYPE_VALID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.METAMODEL___GET_EPACKAGE:
				return getEPackage();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", nsuri: ");
		result.append(nsuri);
		result.append(", pluginID: ");
		result.append(pluginID);
		result.append(", ePackageInstanceName: ");
		result.append(ePackageInstanceName);
		result.append(", isTypeValid: ");
		result.append(isTypeValid);
		result.append(')');
		return result.toString();
	}

} //MetamodelImpl
