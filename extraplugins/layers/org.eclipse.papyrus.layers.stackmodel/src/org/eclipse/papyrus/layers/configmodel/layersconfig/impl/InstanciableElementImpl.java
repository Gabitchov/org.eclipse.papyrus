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
package org.eclipse.papyrus.layers.configmodel.layersconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind;
import org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instanciable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl#getBundleID <em>Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl#getIconPath <em>Icon Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl#getClassnameKind <em>Classname Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InstanciableElementImpl extends FolderElementImpl implements InstanciableElement {
	/**
	 * The default value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected String classname = CLASSNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundleID() <em>Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleID()
	 * @generated
	 * @ordered
	 */
	protected static final String BUNDLE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundleID() <em>Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleID()
	 * @generated
	 * @ordered
	 */
	protected String bundleID = BUNDLE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconPath() <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconPath()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconPath() <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconPath()
	 * @generated
	 * @ordered
	 */
	protected String iconPath = ICON_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassnameKind() <em>Classname Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassnameKind()
	 * @generated
	 * @ordered
	 */
	protected static final ClassnameKind CLASSNAME_KIND_EDEFAULT = ClassnameKind.UNDEFINED;

	/**
	 * The cached value of the '{@link #getClassnameKind() <em>Classname Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassnameKind()
	 * @generated
	 * @ordered
	 */
	protected ClassnameKind classnameKind = CLASSNAME_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanciableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersconfigPackage.Literals.INSTANCIABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassname(String newClassname) {
		String oldClassname = classname;
		classname = newClassname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME, oldClassname, classname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBundleID() {
		return bundleID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleID(String newBundleID) {
		String oldBundleID = bundleID;
		bundleID = newBundleID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersconfigPackage.INSTANCIABLE_ELEMENT__BUNDLE_ID, oldBundleID, bundleID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersconfigPackage.INSTANCIABLE_ELEMENT__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconPath() {
		return iconPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconPath(String newIconPath) {
		String oldIconPath = iconPath;
		iconPath = newIconPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersconfigPackage.INSTANCIABLE_ELEMENT__ICON_PATH, oldIconPath, iconPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassnameKind getClassnameKind() {
		return classnameKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassnameKind(ClassnameKind newClassnameKind) {
		ClassnameKind oldClassnameKind = classnameKind;
		classnameKind = newClassnameKind == null ? CLASSNAME_KIND_EDEFAULT : newClassnameKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME_KIND, oldClassnameKind, classnameKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME:
				return getClassname();
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__BUNDLE_ID:
				return getBundleID();
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__DISPLAY_NAME:
				return getDisplayName();
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__ICON_PATH:
				return getIconPath();
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME_KIND:
				return getClassnameKind();
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
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME:
				setClassname((String)newValue);
				return;
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__BUNDLE_ID:
				setBundleID((String)newValue);
				return;
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__ICON_PATH:
				setIconPath((String)newValue);
				return;
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME_KIND:
				setClassnameKind((ClassnameKind)newValue);
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
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME:
				setClassname(CLASSNAME_EDEFAULT);
				return;
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__BUNDLE_ID:
				setBundleID(BUNDLE_ID_EDEFAULT);
				return;
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__ICON_PATH:
				setIconPath(ICON_PATH_EDEFAULT);
				return;
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME_KIND:
				setClassnameKind(CLASSNAME_KIND_EDEFAULT);
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
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME:
				return CLASSNAME_EDEFAULT == null ? classname != null : !CLASSNAME_EDEFAULT.equals(classname);
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__BUNDLE_ID:
				return BUNDLE_ID_EDEFAULT == null ? bundleID != null : !BUNDLE_ID_EDEFAULT.equals(bundleID);
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__ICON_PATH:
				return ICON_PATH_EDEFAULT == null ? iconPath != null : !ICON_PATH_EDEFAULT.equals(iconPath);
			case LayersconfigPackage.INSTANCIABLE_ELEMENT__CLASSNAME_KIND:
				return classnameKind != CLASSNAME_KIND_EDEFAULT;
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
		result.append(" (classname: ");
		result.append(classname);
		result.append(", bundleID: ");
		result.append(bundleID);
		result.append(", displayName: ");
		result.append(displayName);
		result.append(", iconPath: ");
		result.append(iconPath);
		result.append(", classnameKind: ");
		result.append(classnameKind);
		result.append(')');
		return result.toString();
	}

} //InstanciableElementImpl
