/**
 */
package org.eclipse.papyrus.C_Cpp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.C_Cpp.C_CppPackage;
import org.eclipse.papyrus.C_Cpp.CppRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cpp Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.CppRootImpl#getBase_package <em>Base package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CppRootImpl extends EObjectImpl implements CppRoot {
	/**
	 * The cached value of the '{@link #getBase_package() <em>Base package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_package;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CppRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return C_CppPackage.Literals.CPP_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_package() {
		if (base_package != null && base_package.eIsProxy()) {
			InternalEObject oldBase_package = (InternalEObject)base_package;
			base_package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_package);
			if (base_package != oldBase_package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.CPP_ROOT__BASE_PACKAGE, oldBase_package, base_package));
			}
		}
		return base_package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_package() {
		return base_package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_package(org.eclipse.uml2.uml.Package newBase_package) {
		org.eclipse.uml2.uml.Package oldBase_package = base_package;
		base_package = newBase_package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.CPP_ROOT__BASE_PACKAGE, oldBase_package, base_package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case C_CppPackage.CPP_ROOT__BASE_PACKAGE:
				if (resolve) return getBase_package();
				return basicGetBase_package();
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
			case C_CppPackage.CPP_ROOT__BASE_PACKAGE:
				setBase_package((org.eclipse.uml2.uml.Package)newValue);
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
			case C_CppPackage.CPP_ROOT__BASE_PACKAGE:
				setBase_package((org.eclipse.uml2.uml.Package)null);
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
			case C_CppPackage.CPP_ROOT__BASE_PACKAGE:
				return base_package != null;
		}
		return super.eIsSet(featureID);
	}

} //CppRootImpl
