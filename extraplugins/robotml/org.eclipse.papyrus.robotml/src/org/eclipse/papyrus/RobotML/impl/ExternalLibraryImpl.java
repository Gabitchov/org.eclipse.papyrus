/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotML.ExternalLibrary;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

import org.eclipse.uml2.uml.Interface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.ExternalLibraryImpl#getLibPath <em>Lib Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.ExternalLibraryImpl#getLibFileFormat <em>Lib File Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.ExternalLibraryImpl#getBase_Interface <em>Base Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalLibraryImpl extends MinimalEObjectImpl.Container implements ExternalLibrary {
	/**
	 * The default value of the '{@link #getLibPath() <em>Lib Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibPath()
	 * @generated
	 * @ordered
	 */
	protected static final String LIB_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLibPath() <em>Lib Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibPath()
	 * @generated
	 * @ordered
	 */
	protected String libPath = LIB_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLibFileFormat() <em>Lib File Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibFileFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String LIB_FILE_FORMAT_EDEFAULT = "elf";

	/**
	 * The cached value of the '{@link #getLibFileFormat() <em>Lib File Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibFileFormat()
	 * @generated
	 * @ordered
	 */
	protected String libFileFormat = LIB_FILE_FORMAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Interface() <em>Base Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Interface()
	 * @generated
	 * @ordered
	 */
	protected Interface base_Interface;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.EXTERNAL_LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLibPath() {
		return libPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibPath(String newLibPath) {
		String oldLibPath = libPath;
		libPath = newLibPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.EXTERNAL_LIBRARY__LIB_PATH, oldLibPath, libPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLibFileFormat() {
		return libFileFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibFileFormat(String newLibFileFormat) {
		String oldLibFileFormat = libFileFormat;
		libFileFormat = newLibFileFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.EXTERNAL_LIBRARY__LIB_FILE_FORMAT, oldLibFileFormat, libFileFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getBase_Interface() {
		if (base_Interface != null && base_Interface.eIsProxy()) {
			InternalEObject oldBase_Interface = (InternalEObject)base_Interface;
			base_Interface = (Interface)eResolveProxy(oldBase_Interface);
			if (base_Interface != oldBase_Interface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.EXTERNAL_LIBRARY__BASE_INTERFACE, oldBase_Interface, base_Interface));
			}
		}
		return base_Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetBase_Interface() {
		return base_Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Interface(Interface newBase_Interface) {
		Interface oldBase_Interface = base_Interface;
		base_Interface = newBase_Interface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.EXTERNAL_LIBRARY__BASE_INTERFACE, oldBase_Interface, base_Interface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.EXTERNAL_LIBRARY__LIB_PATH:
				return getLibPath();
			case RobotMLPackage.EXTERNAL_LIBRARY__LIB_FILE_FORMAT:
				return getLibFileFormat();
			case RobotMLPackage.EXTERNAL_LIBRARY__BASE_INTERFACE:
				if (resolve) return getBase_Interface();
				return basicGetBase_Interface();
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
			case RobotMLPackage.EXTERNAL_LIBRARY__LIB_PATH:
				setLibPath((String)newValue);
				return;
			case RobotMLPackage.EXTERNAL_LIBRARY__LIB_FILE_FORMAT:
				setLibFileFormat((String)newValue);
				return;
			case RobotMLPackage.EXTERNAL_LIBRARY__BASE_INTERFACE:
				setBase_Interface((Interface)newValue);
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
			case RobotMLPackage.EXTERNAL_LIBRARY__LIB_PATH:
				setLibPath(LIB_PATH_EDEFAULT);
				return;
			case RobotMLPackage.EXTERNAL_LIBRARY__LIB_FILE_FORMAT:
				setLibFileFormat(LIB_FILE_FORMAT_EDEFAULT);
				return;
			case RobotMLPackage.EXTERNAL_LIBRARY__BASE_INTERFACE:
				setBase_Interface((Interface)null);
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
			case RobotMLPackage.EXTERNAL_LIBRARY__LIB_PATH:
				return LIB_PATH_EDEFAULT == null ? libPath != null : !LIB_PATH_EDEFAULT.equals(libPath);
			case RobotMLPackage.EXTERNAL_LIBRARY__LIB_FILE_FORMAT:
				return LIB_FILE_FORMAT_EDEFAULT == null ? libFileFormat != null : !LIB_FILE_FORMAT_EDEFAULT.equals(libFileFormat);
			case RobotMLPackage.EXTERNAL_LIBRARY__BASE_INTERFACE:
				return base_Interface != null;
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
		result.append(" (libPath: ");
		result.append(libPath);
		result.append(", libFileFormat: ");
		result.append(libFileFormat);
		result.append(')');
		return result.toString();
	}

} //ExternalLibraryImpl
