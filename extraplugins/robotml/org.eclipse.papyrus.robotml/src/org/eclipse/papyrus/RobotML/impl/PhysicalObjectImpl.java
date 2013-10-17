/**
 */
package org.eclipse.papyrus.RobotML.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.RobotML.Environment;
import org.eclipse.papyrus.RobotML.PhysicalObject;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.Surface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl#getEvelovesIn <em>Eveloves In</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl#getHasSurface <em>Has Surface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PhysicalObjectImpl extends SystemImpl implements PhysicalObject {
	/**
	 * The cached value of the '{@link #getEvelovesIn() <em>Eveloves In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvelovesIn()
	 * @generated
	 * @ordered
	 */
	protected EList<Environment> evelovesIn;

	/**
	 * The cached value of the '{@link #getHasSurface() <em>Has Surface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasSurface()
	 * @generated
	 * @ordered
	 */
	protected Surface hasSurface;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicalObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.PHYSICAL_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Environment> getEvelovesIn() {
		if (evelovesIn == null) {
			evelovesIn = new EObjectResolvingEList<Environment>(Environment.class, this, RobotMLPackage.PHYSICAL_OBJECT__EVELOVES_IN);
		}
		return evelovesIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Surface getHasSurface() {
		if (hasSurface != null && hasSurface.eIsProxy()) {
			InternalEObject oldHasSurface = (InternalEObject)hasSurface;
			hasSurface = (Surface)eResolveProxy(oldHasSurface);
			if (hasSurface != oldHasSurface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.PHYSICAL_OBJECT__HAS_SURFACE, oldHasSurface, hasSurface));
			}
		}
		return hasSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Surface basicGetHasSurface() {
		return hasSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasSurface(Surface newHasSurface) {
		Surface oldHasSurface = hasSurface;
		hasSurface = newHasSurface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.PHYSICAL_OBJECT__HAS_SURFACE, oldHasSurface, hasSurface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.PHYSICAL_OBJECT__EVELOVES_IN:
				return getEvelovesIn();
			case RobotMLPackage.PHYSICAL_OBJECT__HAS_SURFACE:
				if (resolve) return getHasSurface();
				return basicGetHasSurface();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RobotMLPackage.PHYSICAL_OBJECT__EVELOVES_IN:
				getEvelovesIn().clear();
				getEvelovesIn().addAll((Collection<? extends Environment>)newValue);
				return;
			case RobotMLPackage.PHYSICAL_OBJECT__HAS_SURFACE:
				setHasSurface((Surface)newValue);
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
			case RobotMLPackage.PHYSICAL_OBJECT__EVELOVES_IN:
				getEvelovesIn().clear();
				return;
			case RobotMLPackage.PHYSICAL_OBJECT__HAS_SURFACE:
				setHasSurface((Surface)null);
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
			case RobotMLPackage.PHYSICAL_OBJECT__EVELOVES_IN:
				return evelovesIn != null && !evelovesIn.isEmpty();
			case RobotMLPackage.PHYSICAL_OBJECT__HAS_SURFACE:
				return hasSurface != null;
		}
		return super.eIsSet(featureID);
	}

} //PhysicalObjectImpl
