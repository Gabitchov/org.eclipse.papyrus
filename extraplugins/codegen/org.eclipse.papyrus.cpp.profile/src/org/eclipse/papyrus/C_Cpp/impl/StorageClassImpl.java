/**
 */
package org.eclipse.papyrus.C_Cpp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.C_Cpp.C_CppPackage;
import org.eclipse.papyrus.C_Cpp.EStorageClass;
import org.eclipse.papyrus.C_Cpp.StorageClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Storage Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.StorageClassImpl#getStorageClass <em>Storage Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StorageClassImpl extends EObjectImpl implements StorageClass {
	/**
	 * The default value of the '{@link #getStorageClass() <em>Storage Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageClass()
	 * @generated
	 * @ordered
	 */
	protected static final EStorageClass STORAGE_CLASS_EDEFAULT = EStorageClass.AUTO;

	/**
	 * The cached value of the '{@link #getStorageClass() <em>Storage Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageClass()
	 * @generated
	 * @ordered
	 */
	protected EStorageClass storageClass = STORAGE_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StorageClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return C_CppPackage.Literals.STORAGE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStorageClass getStorageClass() {
		return storageClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorageClass(EStorageClass newStorageClass) {
		EStorageClass oldStorageClass = storageClass;
		storageClass = newStorageClass == null ? STORAGE_CLASS_EDEFAULT : newStorageClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.STORAGE_CLASS__STORAGE_CLASS, oldStorageClass, storageClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case C_CppPackage.STORAGE_CLASS__STORAGE_CLASS:
				return getStorageClass();
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
			case C_CppPackage.STORAGE_CLASS__STORAGE_CLASS:
				setStorageClass((EStorageClass)newValue);
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
			case C_CppPackage.STORAGE_CLASS__STORAGE_CLASS:
				setStorageClass(STORAGE_CLASS_EDEFAULT);
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
			case C_CppPackage.STORAGE_CLASS__STORAGE_CLASS:
				return storageClass != STORAGE_CLASS_EDEFAULT;
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
		result.append(" (storageClass: ");
		result.append(storageClass);
		result.append(')');
		return result.toString();
	}

} //StorageClassImpl
