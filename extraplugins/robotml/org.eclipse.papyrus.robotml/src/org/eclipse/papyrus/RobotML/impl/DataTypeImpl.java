/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotML.DataType;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.DataTypeImpl#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.DataTypeImpl#isNative <em>Native</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.DataTypeImpl#getLibraryPath <em>Library Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeImpl extends MinimalEObjectImpl.Container implements DataType {
	/**
	 * The cached value of the '{@link #getBase_DataType() <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_DataType()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.DataType base_DataType;

	/**
	 * The default value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected boolean native_ = NATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLibraryPath() <em>Library Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryPath()
	 * @generated
	 * @ordered
	 */
	protected static final String LIBRARY_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLibraryPath() <em>Library Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryPath()
	 * @generated
	 * @ordered
	 */
	protected String libraryPath = LIBRARY_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.DataType getBase_DataType() {
		if (base_DataType != null && base_DataType.eIsProxy()) {
			InternalEObject oldBase_DataType = (InternalEObject)base_DataType;
			base_DataType = (org.eclipse.uml2.uml.DataType)eResolveProxy(oldBase_DataType);
			if (base_DataType != oldBase_DataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.DATA_TYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
			}
		}
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.DataType basicGetBase_DataType() {
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_DataType(org.eclipse.uml2.uml.DataType newBase_DataType) {
		org.eclipse.uml2.uml.DataType oldBase_DataType = base_DataType;
		base_DataType = newBase_DataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.DATA_TYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNative() {
		return native_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNative(boolean newNative) {
		boolean oldNative = native_;
		native_ = newNative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.DATA_TYPE__NATIVE, oldNative, native_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLibraryPath() {
		return libraryPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibraryPath(String newLibraryPath) {
		String oldLibraryPath = libraryPath;
		libraryPath = newLibraryPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.DATA_TYPE__LIBRARY_PATH, oldLibraryPath, libraryPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.DATA_TYPE__BASE_DATA_TYPE:
				if (resolve) return getBase_DataType();
				return basicGetBase_DataType();
			case RobotMLPackage.DATA_TYPE__NATIVE:
				return isNative();
			case RobotMLPackage.DATA_TYPE__LIBRARY_PATH:
				return getLibraryPath();
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
			case RobotMLPackage.DATA_TYPE__BASE_DATA_TYPE:
				setBase_DataType((org.eclipse.uml2.uml.DataType)newValue);
				return;
			case RobotMLPackage.DATA_TYPE__NATIVE:
				setNative((Boolean)newValue);
				return;
			case RobotMLPackage.DATA_TYPE__LIBRARY_PATH:
				setLibraryPath((String)newValue);
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
			case RobotMLPackage.DATA_TYPE__BASE_DATA_TYPE:
				setBase_DataType((org.eclipse.uml2.uml.DataType)null);
				return;
			case RobotMLPackage.DATA_TYPE__NATIVE:
				setNative(NATIVE_EDEFAULT);
				return;
			case RobotMLPackage.DATA_TYPE__LIBRARY_PATH:
				setLibraryPath(LIBRARY_PATH_EDEFAULT);
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
			case RobotMLPackage.DATA_TYPE__BASE_DATA_TYPE:
				return base_DataType != null;
			case RobotMLPackage.DATA_TYPE__NATIVE:
				return native_ != NATIVE_EDEFAULT;
			case RobotMLPackage.DATA_TYPE__LIBRARY_PATH:
				return LIBRARY_PATH_EDEFAULT == null ? libraryPath != null : !LIBRARY_PATH_EDEFAULT.equals(libraryPath);
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
		result.append(" (native: ");
		result.append(native_);
		result.append(", libraryPath: ");
		result.append(libraryPath);
		result.append(')');
		return result.toString();
	}

} //DataTypeImpl
