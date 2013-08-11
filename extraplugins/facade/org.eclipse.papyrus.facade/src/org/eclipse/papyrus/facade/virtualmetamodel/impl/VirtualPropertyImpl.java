/**
 */
package org.eclipse.papyrus.facade.virtualmetamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualPropertyImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualPropertyImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualPropertyImpl#getVirtualMetaclass <em>Virtual Metaclass</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualPropertyImpl extends VirtualElementImpl implements VirtualProperty {
	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected int lower = LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected int upper = UPPER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VirtualmetamodelPackage.Literals.VIRTUAL_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(int newLower) {
		int oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_PROPERTY__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(int newUpper) {
		int oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_PROPERTY__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualMetaclass getVirtualMetaclass() {
		if (eContainerFeatureID() != VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS) return null;
		return (VirtualMetaclass)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVirtualMetaclass(VirtualMetaclass newVirtualMetaclass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newVirtualMetaclass, VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtualMetaclass(VirtualMetaclass newVirtualMetaclass) {
		if (newVirtualMetaclass != eInternalContainer() || (eContainerFeatureID() != VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS && newVirtualMetaclass != null)) {
			if (EcoreUtil.isAncestor(this, newVirtualMetaclass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newVirtualMetaclass != null)
				msgs = ((InternalEObject)newVirtualMetaclass).eInverseAdd(this, VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES, VirtualMetaclass.class, msgs);
			msgs = basicSetVirtualMetaclass(newVirtualMetaclass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS, newVirtualMetaclass, newVirtualMetaclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetVirtualMetaclass((VirtualMetaclass)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				return basicSetVirtualMetaclass(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				return eInternalContainer().eInverseRemove(this, VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES, VirtualMetaclass.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__LOWER:
				return getLower();
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__UPPER:
				return getUpper();
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				return getVirtualMetaclass();
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
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__LOWER:
				setLower((Integer)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__UPPER:
				setUpper((Integer)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				setVirtualMetaclass((VirtualMetaclass)newValue);
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
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				setVirtualMetaclass((VirtualMetaclass)null);
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
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__LOWER:
				return lower != LOWER_EDEFAULT;
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__UPPER:
				return upper != UPPER_EDEFAULT;
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				return getVirtualMetaclass() != null;
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
		result.append(" (lower: ");
		result.append(lower);
		result.append(", upper: ");
		result.append(upper);
		result.append(')');
		return result.toString();
	}

} //VirtualPropertyImpl
