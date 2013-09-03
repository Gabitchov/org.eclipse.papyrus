/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.RobotML.CycabTK;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cycab TK</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CycabTKImpl#isUseRealTime <em>Use Real Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CycabTKImpl#getTimeStep <em>Time Step</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CycabTKImpl#getTimeFactor <em>Time Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CycabTKImpl extends RoboticSimulatorImpl implements CycabTK {
	/**
	 * The default value of the '{@link #isUseRealTime() <em>Use Real Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseRealTime()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_REAL_TIME_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseRealTime() <em>Use Real Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseRealTime()
	 * @generated
	 * @ordered
	 */
	protected boolean useRealTime = USE_REAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeStep() <em>Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeStep()
	 * @generated
	 * @ordered
	 */
	protected static final float TIME_STEP_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getTimeStep() <em>Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeStep()
	 * @generated
	 * @ordered
	 */
	protected float timeStep = TIME_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeFactor() <em>Time Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeFactor()
	 * @generated
	 * @ordered
	 */
	protected static final float TIME_FACTOR_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getTimeFactor() <em>Time Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeFactor()
	 * @generated
	 * @ordered
	 */
	protected float timeFactor = TIME_FACTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CycabTKImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.CYCAB_TK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseRealTime() {
		return useRealTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseRealTime(boolean newUseRealTime) {
		boolean oldUseRealTime = useRealTime;
		useRealTime = newUseRealTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CYCAB_TK__USE_REAL_TIME, oldUseRealTime, useRealTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTimeStep() {
		return timeStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeStep(float newTimeStep) {
		float oldTimeStep = timeStep;
		timeStep = newTimeStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CYCAB_TK__TIME_STEP, oldTimeStep, timeStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTimeFactor() {
		return timeFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeFactor(float newTimeFactor) {
		float oldTimeFactor = timeFactor;
		timeFactor = newTimeFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CYCAB_TK__TIME_FACTOR, oldTimeFactor, timeFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.CYCAB_TK__USE_REAL_TIME:
				return isUseRealTime();
			case RobotMLPackage.CYCAB_TK__TIME_STEP:
				return getTimeStep();
			case RobotMLPackage.CYCAB_TK__TIME_FACTOR:
				return getTimeFactor();
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
			case RobotMLPackage.CYCAB_TK__USE_REAL_TIME:
				setUseRealTime((Boolean)newValue);
				return;
			case RobotMLPackage.CYCAB_TK__TIME_STEP:
				setTimeStep((Float)newValue);
				return;
			case RobotMLPackage.CYCAB_TK__TIME_FACTOR:
				setTimeFactor((Float)newValue);
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
			case RobotMLPackage.CYCAB_TK__USE_REAL_TIME:
				setUseRealTime(USE_REAL_TIME_EDEFAULT);
				return;
			case RobotMLPackage.CYCAB_TK__TIME_STEP:
				setTimeStep(TIME_STEP_EDEFAULT);
				return;
			case RobotMLPackage.CYCAB_TK__TIME_FACTOR:
				setTimeFactor(TIME_FACTOR_EDEFAULT);
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
			case RobotMLPackage.CYCAB_TK__USE_REAL_TIME:
				return useRealTime != USE_REAL_TIME_EDEFAULT;
			case RobotMLPackage.CYCAB_TK__TIME_STEP:
				return timeStep != TIME_STEP_EDEFAULT;
			case RobotMLPackage.CYCAB_TK__TIME_FACTOR:
				return timeFactor != TIME_FACTOR_EDEFAULT;
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
		result.append(" (useRealTime: ");
		result.append(useRealTime);
		result.append(", timeStep: ");
		result.append(timeStep);
		result.append(", timeFactor: ");
		result.append(timeFactor);
		result.append(')');
		return result.toString();
	}

} //CycabTKImpl
