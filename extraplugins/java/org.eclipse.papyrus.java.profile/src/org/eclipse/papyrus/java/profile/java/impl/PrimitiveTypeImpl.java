/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.java.profile.java.JavaPackage;
import org.eclipse.papyrus.java.profile.java.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.PrimitiveTypeImpl#getImplementationClass <em>Implementation Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.PrimitiveTypeImpl#getBase_PrimitiveType <em>Base Primitive Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimitiveTypeImpl extends JavaGenImpl implements PrimitiveType {
	/**
	 * The default value of the '{@link #getImplementationClass() <em>Implementation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClass()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementationClass() <em>Implementation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClass()
	 * @generated
	 * @ordered
	 */
	protected String implementationClass = IMPLEMENTATION_CLASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_PrimitiveType() <em>Base Primitive Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_PrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.PrimitiveType base_PrimitiveType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.PRIMITIVE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementationClass() {
		return implementationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClass(String newImplementationClass) {
		String oldImplementationClass = implementationClass;
		implementationClass = newImplementationClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.PRIMITIVE_TYPE__IMPLEMENTATION_CLASS, oldImplementationClass, implementationClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.PrimitiveType getBase_PrimitiveType() {
		if (base_PrimitiveType != null && base_PrimitiveType.eIsProxy()) {
			InternalEObject oldBase_PrimitiveType = (InternalEObject)base_PrimitiveType;
			base_PrimitiveType = (org.eclipse.uml2.uml.PrimitiveType)eResolveProxy(oldBase_PrimitiveType);
			if (base_PrimitiveType != oldBase_PrimitiveType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JavaPackage.PRIMITIVE_TYPE__BASE_PRIMITIVE_TYPE, oldBase_PrimitiveType, base_PrimitiveType));
			}
		}
		return base_PrimitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.PrimitiveType basicGetBase_PrimitiveType() {
		return base_PrimitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_PrimitiveType(org.eclipse.uml2.uml.PrimitiveType newBase_PrimitiveType) {
		org.eclipse.uml2.uml.PrimitiveType oldBase_PrimitiveType = base_PrimitiveType;
		base_PrimitiveType = newBase_PrimitiveType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.PRIMITIVE_TYPE__BASE_PRIMITIVE_TYPE, oldBase_PrimitiveType, base_PrimitiveType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.PRIMITIVE_TYPE__IMPLEMENTATION_CLASS:
				return getImplementationClass();
			case JavaPackage.PRIMITIVE_TYPE__BASE_PRIMITIVE_TYPE:
				if (resolve) return getBase_PrimitiveType();
				return basicGetBase_PrimitiveType();
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
			case JavaPackage.PRIMITIVE_TYPE__IMPLEMENTATION_CLASS:
				setImplementationClass((String)newValue);
				return;
			case JavaPackage.PRIMITIVE_TYPE__BASE_PRIMITIVE_TYPE:
				setBase_PrimitiveType((org.eclipse.uml2.uml.PrimitiveType)newValue);
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
			case JavaPackage.PRIMITIVE_TYPE__IMPLEMENTATION_CLASS:
				setImplementationClass(IMPLEMENTATION_CLASS_EDEFAULT);
				return;
			case JavaPackage.PRIMITIVE_TYPE__BASE_PRIMITIVE_TYPE:
				setBase_PrimitiveType((org.eclipse.uml2.uml.PrimitiveType)null);
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
			case JavaPackage.PRIMITIVE_TYPE__IMPLEMENTATION_CLASS:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case JavaPackage.PRIMITIVE_TYPE__BASE_PRIMITIVE_TYPE:
				return base_PrimitiveType != null;
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
		result.append(" (implementationClass: ");
		result.append(implementationClass);
		result.append(')');
		return result.toString();
	}

} //PrimitiveTypeImpl
