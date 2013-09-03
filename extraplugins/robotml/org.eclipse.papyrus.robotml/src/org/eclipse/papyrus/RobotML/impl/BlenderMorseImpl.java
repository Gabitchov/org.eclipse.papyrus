/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.RobotML.BlenderMorse;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.Shade;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Blender Morse</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl#isDebugMode <em>Debug Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl#isDebugDisplay <em>Debug Display</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl#getGravity <em>Gravity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl#get_viewport_shade <em>viewport shade</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlenderMorseImpl extends RoboticSimulatorImpl implements BlenderMorse {
	/**
	 * The default value of the '{@link #isDebugMode() <em>Debug Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebugMode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEBUG_MODE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDebugMode() <em>Debug Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebugMode()
	 * @generated
	 * @ordered
	 */
	protected boolean debugMode = DEBUG_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDebugDisplay() <em>Debug Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebugDisplay()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEBUG_DISPLAY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDebugDisplay() <em>Debug Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebugDisplay()
	 * @generated
	 * @ordered
	 */
	protected boolean debugDisplay = DEBUG_DISPLAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGravity() <em>Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGravity()
	 * @generated
	 * @ordered
	 */
	protected static final float GRAVITY_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getGravity() <em>Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGravity()
	 * @generated
	 * @ordered
	 */
	protected float gravity = GRAVITY_EDEFAULT;

	/**
	 * The default value of the '{@link #get_viewport_shade() <em>viewport shade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_viewport_shade()
	 * @generated
	 * @ordered
	 */
	protected static final Shade _VIEWPORT_SHADE_EDEFAULT = Shade.WIREFRAME;

	/**
	 * The cached value of the '{@link #get_viewport_shade() <em>viewport shade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_viewport_shade()
	 * @generated
	 * @ordered
	 */
	protected Shade _viewport_shade = _VIEWPORT_SHADE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlenderMorseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.BLENDER_MORSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDebugMode() {
		return debugMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugMode(boolean newDebugMode) {
		boolean oldDebugMode = debugMode;
		debugMode = newDebugMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.BLENDER_MORSE__DEBUG_MODE, oldDebugMode, debugMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDebugDisplay() {
		return debugDisplay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugDisplay(boolean newDebugDisplay) {
		boolean oldDebugDisplay = debugDisplay;
		debugDisplay = newDebugDisplay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.BLENDER_MORSE__DEBUG_DISPLAY, oldDebugDisplay, debugDisplay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getGravity() {
		return gravity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGravity(float newGravity) {
		float oldGravity = gravity;
		gravity = newGravity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.BLENDER_MORSE__GRAVITY, oldGravity, gravity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shade get_viewport_shade() {
		return _viewport_shade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set_viewport_shade(Shade new_viewport_shade) {
		Shade old_viewport_shade = _viewport_shade;
		_viewport_shade = new_viewport_shade == null ? _VIEWPORT_SHADE_EDEFAULT : new_viewport_shade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.BLENDER_MORSE__VIEWPORT_SHADE, old_viewport_shade, _viewport_shade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.BLENDER_MORSE__DEBUG_MODE:
				return isDebugMode();
			case RobotMLPackage.BLENDER_MORSE__DEBUG_DISPLAY:
				return isDebugDisplay();
			case RobotMLPackage.BLENDER_MORSE__GRAVITY:
				return getGravity();
			case RobotMLPackage.BLENDER_MORSE__VIEWPORT_SHADE:
				return get_viewport_shade();
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
			case RobotMLPackage.BLENDER_MORSE__DEBUG_MODE:
				setDebugMode((Boolean)newValue);
				return;
			case RobotMLPackage.BLENDER_MORSE__DEBUG_DISPLAY:
				setDebugDisplay((Boolean)newValue);
				return;
			case RobotMLPackage.BLENDER_MORSE__GRAVITY:
				setGravity((Float)newValue);
				return;
			case RobotMLPackage.BLENDER_MORSE__VIEWPORT_SHADE:
				set_viewport_shade((Shade)newValue);
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
			case RobotMLPackage.BLENDER_MORSE__DEBUG_MODE:
				setDebugMode(DEBUG_MODE_EDEFAULT);
				return;
			case RobotMLPackage.BLENDER_MORSE__DEBUG_DISPLAY:
				setDebugDisplay(DEBUG_DISPLAY_EDEFAULT);
				return;
			case RobotMLPackage.BLENDER_MORSE__GRAVITY:
				setGravity(GRAVITY_EDEFAULT);
				return;
			case RobotMLPackage.BLENDER_MORSE__VIEWPORT_SHADE:
				set_viewport_shade(_VIEWPORT_SHADE_EDEFAULT);
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
			case RobotMLPackage.BLENDER_MORSE__DEBUG_MODE:
				return debugMode != DEBUG_MODE_EDEFAULT;
			case RobotMLPackage.BLENDER_MORSE__DEBUG_DISPLAY:
				return debugDisplay != DEBUG_DISPLAY_EDEFAULT;
			case RobotMLPackage.BLENDER_MORSE__GRAVITY:
				return gravity != GRAVITY_EDEFAULT;
			case RobotMLPackage.BLENDER_MORSE__VIEWPORT_SHADE:
				return _viewport_shade != _VIEWPORT_SHADE_EDEFAULT;
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
		result.append(" (debugMode: ");
		result.append(debugMode);
		result.append(", debugDisplay: ");
		result.append(debugDisplay);
		result.append(", gravity: ");
		result.append(gravity);
		result.append(", _viewport_shade: ");
		result.append(_viewport_shade);
		result.append(')');
		return result.toString();
	}

} //BlenderMorseImpl
