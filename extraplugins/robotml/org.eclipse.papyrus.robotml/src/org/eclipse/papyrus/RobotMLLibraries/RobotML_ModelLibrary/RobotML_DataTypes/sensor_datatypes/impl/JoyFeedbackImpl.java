/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.JoyFeedback;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Joy Feedback</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JoyFeedbackImpl#getTYPE_LED <em>TYPE LED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JoyFeedbackImpl#getTYPE_RUMBLE <em>TYPE RUMBLE</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JoyFeedbackImpl#getTYPE_BUZZER <em>TYPE BUZZER</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JoyFeedbackImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JoyFeedbackImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JoyFeedbackImpl#getIntensity <em>Intensity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JoyFeedbackImpl extends MinimalEObjectImpl.Container implements JoyFeedback {
	/**
	 * The default value of the '{@link #getTYPE_LED() <em>TYPE LED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTYPE_LED()
	 * @generated
	 * @ordered
	 */
	protected static final char TYPE_LED_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getTYPE_LED() <em>TYPE LED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTYPE_LED()
	 * @generated
	 * @ordered
	 */
	protected char typE_LED = TYPE_LED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTYPE_RUMBLE() <em>TYPE RUMBLE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTYPE_RUMBLE()
	 * @generated
	 * @ordered
	 */
	protected static final char TYPE_RUMBLE_EDEFAULT = '\u0001';

	/**
	 * The cached value of the '{@link #getTYPE_RUMBLE() <em>TYPE RUMBLE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTYPE_RUMBLE()
	 * @generated
	 * @ordered
	 */
	protected char typE_RUMBLE = TYPE_RUMBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTYPE_BUZZER() <em>TYPE BUZZER</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTYPE_BUZZER()
	 * @generated
	 * @ordered
	 */
	protected static final char TYPE_BUZZER_EDEFAULT = '\u0002';

	/**
	 * The cached value of the '{@link #getTYPE_BUZZER() <em>TYPE BUZZER</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTYPE_BUZZER()
	 * @generated
	 * @ordered
	 */
	protected char typE_BUZZER = TYPE_BUZZER_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final char TYPE_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected char type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final char ID_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected char id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntensity() <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntensity()
	 * @generated
	 * @ordered
	 */
	protected static final float INTENSITY_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getIntensity() <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntensity()
	 * @generated
	 * @ordered
	 */
	protected float intensity = INTENSITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoyFeedbackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.JOY_FEEDBACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getTYPE_LED() {
		return typE_LED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTYPE_LED(char newTYPE_LED) {
		char oldTYPE_LED = typE_LED;
		typE_LED = newTYPE_LED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_LED, oldTYPE_LED, typE_LED));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getTYPE_RUMBLE() {
		return typE_RUMBLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTYPE_RUMBLE(char newTYPE_RUMBLE) {
		char oldTYPE_RUMBLE = typE_RUMBLE;
		typE_RUMBLE = newTYPE_RUMBLE;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_RUMBLE, oldTYPE_RUMBLE, typE_RUMBLE));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getTYPE_BUZZER() {
		return typE_BUZZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTYPE_BUZZER(char newTYPE_BUZZER) {
		char oldTYPE_BUZZER = typE_BUZZER;
		typE_BUZZER = newTYPE_BUZZER;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_BUZZER, oldTYPE_BUZZER, typE_BUZZER));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(char newType) {
		char oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.JOY_FEEDBACK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(char newId) {
		char oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.JOY_FEEDBACK__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getIntensity() {
		return intensity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntensity(float newIntensity) {
		float oldIntensity = intensity;
		intensity = newIntensity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.JOY_FEEDBACK__INTENSITY, oldIntensity, intensity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_LED:
				return getTYPE_LED();
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_RUMBLE:
				return getTYPE_RUMBLE();
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_BUZZER:
				return getTYPE_BUZZER();
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE:
				return getType();
			case Sensor_datatypesPackage.JOY_FEEDBACK__ID:
				return getId();
			case Sensor_datatypesPackage.JOY_FEEDBACK__INTENSITY:
				return getIntensity();
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
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_LED:
				setTYPE_LED((Character)newValue);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_RUMBLE:
				setTYPE_RUMBLE((Character)newValue);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_BUZZER:
				setTYPE_BUZZER((Character)newValue);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE:
				setType((Character)newValue);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__ID:
				setId((Character)newValue);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__INTENSITY:
				setIntensity((Float)newValue);
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
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_LED:
				setTYPE_LED(TYPE_LED_EDEFAULT);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_RUMBLE:
				setTYPE_RUMBLE(TYPE_RUMBLE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_BUZZER:
				setTYPE_BUZZER(TYPE_BUZZER_EDEFAULT);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__ID:
				setId(ID_EDEFAULT);
				return;
			case Sensor_datatypesPackage.JOY_FEEDBACK__INTENSITY:
				setIntensity(INTENSITY_EDEFAULT);
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
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_LED:
				return typE_LED != TYPE_LED_EDEFAULT;
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_RUMBLE:
				return typE_RUMBLE != TYPE_RUMBLE_EDEFAULT;
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE_BUZZER:
				return typE_BUZZER != TYPE_BUZZER_EDEFAULT;
			case Sensor_datatypesPackage.JOY_FEEDBACK__TYPE:
				return type != TYPE_EDEFAULT;
			case Sensor_datatypesPackage.JOY_FEEDBACK__ID:
				return id != ID_EDEFAULT;
			case Sensor_datatypesPackage.JOY_FEEDBACK__INTENSITY:
				return intensity != INTENSITY_EDEFAULT;
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
		result.append(" (TYPE_LED: ");
		result.append(typE_LED);
		result.append(", TYPE_RUMBLE: ");
		result.append(typE_RUMBLE);
		result.append(", TYPE_BUZZER: ");
		result.append(typE_BUZZER);
		result.append(", type: ");
		result.append(type);
		result.append(", id: ");
		result.append(id);
		result.append(", intensity: ");
		result.append(intensity);
		result.append(')');
		return result.toString();
	}

} //JoyFeedbackImpl
