/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.RobotML.Robot;
import org.eclipse.papyrus.RobotML.RobotKind;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.UGVKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Robot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.RobotImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.RobotImpl#getMass <em>Mass</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.RobotImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.RobotImpl#getUgvKind <em>Ugv Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RobotImpl extends AgentImpl implements Robot {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final RobotKind KIND_EDEFAULT = RobotKind.UG_VCAR;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected RobotKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getMass() <em>Mass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMass()
	 * @generated
	 * @ordered
	 */
	protected static final float MASS_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMass() <em>Mass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMass()
	 * @generated
	 * @ordered
	 */
	protected float mass = MASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final float WIDTH_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected float width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getUgvKind() <em>Ugv Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUgvKind()
	 * @generated
	 * @ordered
	 */
	protected static final UGVKind UGV_KIND_EDEFAULT = UGVKind.DIFFERENTIAL;

	/**
	 * The cached value of the '{@link #getUgvKind() <em>Ugv Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUgvKind()
	 * @generated
	 * @ordered
	 */
	protected UGVKind ugvKind = UGV_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RobotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.ROBOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(RobotKind newKind) {
		RobotKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ROBOT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMass() {
		return mass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMass(float newMass) {
		float oldMass = mass;
		mass = newMass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ROBOT__MASS, oldMass, mass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(float newWidth) {
		float oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ROBOT__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UGVKind getUgvKind() {
		return ugvKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUgvKind(UGVKind newUgvKind) {
		UGVKind oldUgvKind = ugvKind;
		ugvKind = newUgvKind == null ? UGV_KIND_EDEFAULT : newUgvKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ROBOT__UGV_KIND, oldUgvKind, ugvKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.ROBOT__KIND:
				return getKind();
			case RobotMLPackage.ROBOT__MASS:
				return getMass();
			case RobotMLPackage.ROBOT__WIDTH:
				return getWidth();
			case RobotMLPackage.ROBOT__UGV_KIND:
				return getUgvKind();
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
			case RobotMLPackage.ROBOT__KIND:
				setKind((RobotKind)newValue);
				return;
			case RobotMLPackage.ROBOT__MASS:
				setMass((Float)newValue);
				return;
			case RobotMLPackage.ROBOT__WIDTH:
				setWidth((Float)newValue);
				return;
			case RobotMLPackage.ROBOT__UGV_KIND:
				setUgvKind((UGVKind)newValue);
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
			case RobotMLPackage.ROBOT__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case RobotMLPackage.ROBOT__MASS:
				setMass(MASS_EDEFAULT);
				return;
			case RobotMLPackage.ROBOT__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case RobotMLPackage.ROBOT__UGV_KIND:
				setUgvKind(UGV_KIND_EDEFAULT);
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
			case RobotMLPackage.ROBOT__KIND:
				return kind != KIND_EDEFAULT;
			case RobotMLPackage.ROBOT__MASS:
				return mass != MASS_EDEFAULT;
			case RobotMLPackage.ROBOT__WIDTH:
				return width != WIDTH_EDEFAULT;
			case RobotMLPackage.ROBOT__UGV_KIND:
				return ugvKind != UGV_KIND_EDEFAULT;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", mass: ");
		result.append(mass);
		result.append(", width: ");
		result.append(width);
		result.append(", ugvKind: ");
		result.append(ugvKind);
		result.append(')');
		return result.toString();
	}

} //RobotImpl
