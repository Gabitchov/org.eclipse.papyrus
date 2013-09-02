/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.RobotML.CameraSystem;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point32;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Camera System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl#getAlpha_u <em>Alpha u</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl#getAlpha_v <em>Alpha v</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl#getU0 <em>U0</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl#getV0 <em>V0</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl#getColor_format <em>Color format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl#getTranslate <em>Translate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl#getRotate <em>Rotate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CameraSystemImpl extends ImageSensorSystemImpl implements CameraSystem {
	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final long WIDTH_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected long width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final long HEIGHT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected long height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlpha_u() <em>Alpha u</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha_u()
	 * @generated
	 * @ordered
	 */
	protected static final float ALPHA_U_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAlpha_u() <em>Alpha u</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha_u()
	 * @generated
	 * @ordered
	 */
	protected float alpha_u = ALPHA_U_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlpha_v() <em>Alpha v</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha_v()
	 * @generated
	 * @ordered
	 */
	protected static final float ALPHA_V_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAlpha_v() <em>Alpha v</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha_v()
	 * @generated
	 * @ordered
	 */
	protected float alpha_v = ALPHA_V_EDEFAULT;

	/**
	 * The default value of the '{@link #getU0() <em>U0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getU0()
	 * @generated
	 * @ordered
	 */
	protected static final float U0_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getU0() <em>U0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getU0()
	 * @generated
	 * @ordered
	 */
	protected float u0 = U0_EDEFAULT;

	/**
	 * The default value of the '{@link #getV0() <em>V0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getV0()
	 * @generated
	 * @ordered
	 */
	protected static final float V0_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getV0() <em>V0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getV0()
	 * @generated
	 * @ordered
	 */
	protected float v0 = V0_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor_format() <em>Color format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor_format()
	 * @generated
	 * @ordered
	 */
	protected static final String COLOR_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor_format() <em>Color format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor_format()
	 * @generated
	 * @ordered
	 */
	protected String color_format = COLOR_FORMAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTranslate() <em>Translate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslate()
	 * @generated
	 * @ordered
	 */
	protected Point32 translate;

	/**
	 * The cached value of the '{@link #getRotate() <em>Rotate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotate()
	 * @generated
	 * @ordered
	 */
	protected Point32 rotate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CameraSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.CAMERA_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(long newWidth) {
		long oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(long newHeight) {
		long oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAlpha_u() {
		return alpha_u;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlpha_u(float newAlpha_u) {
		float oldAlpha_u = alpha_u;
		alpha_u = newAlpha_u;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__ALPHA_U, oldAlpha_u, alpha_u));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAlpha_v() {
		return alpha_v;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlpha_v(float newAlpha_v) {
		float oldAlpha_v = alpha_v;
		alpha_v = newAlpha_v;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__ALPHA_V, oldAlpha_v, alpha_v));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getU0() {
		return u0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU0(float newU0) {
		float oldU0 = u0;
		u0 = newU0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__U0, oldU0, u0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getV0() {
		return v0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV0(float newV0) {
		float oldV0 = v0;
		v0 = newV0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__V0, oldV0, v0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColor_format() {
		return color_format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor_format(String newColor_format) {
		String oldColor_format = color_format;
		color_format = newColor_format;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__COLOR_FORMAT, oldColor_format, color_format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point32 getTranslate() {
		return translate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTranslate(Point32 newTranslate, NotificationChain msgs) {
		Point32 oldTranslate = translate;
		translate = newTranslate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__TRANSLATE, oldTranslate, newTranslate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslate(Point32 newTranslate) {
		if (newTranslate != translate) {
			NotificationChain msgs = null;
			if (translate != null)
				msgs = ((InternalEObject)translate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.CAMERA_SYSTEM__TRANSLATE, null, msgs);
			if (newTranslate != null)
				msgs = ((InternalEObject)newTranslate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.CAMERA_SYSTEM__TRANSLATE, null, msgs);
			msgs = basicSetTranslate(newTranslate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__TRANSLATE, newTranslate, newTranslate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point32 getRotate() {
		return rotate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRotate(Point32 newRotate, NotificationChain msgs) {
		Point32 oldRotate = rotate;
		rotate = newRotate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__ROTATE, oldRotate, newRotate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotate(Point32 newRotate) {
		if (newRotate != rotate) {
			NotificationChain msgs = null;
			if (rotate != null)
				msgs = ((InternalEObject)rotate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.CAMERA_SYSTEM__ROTATE, null, msgs);
			if (newRotate != null)
				msgs = ((InternalEObject)newRotate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.CAMERA_SYSTEM__ROTATE, null, msgs);
			msgs = basicSetRotate(newRotate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.CAMERA_SYSTEM__ROTATE, newRotate, newRotate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RobotMLPackage.CAMERA_SYSTEM__TRANSLATE:
				return basicSetTranslate(null, msgs);
			case RobotMLPackage.CAMERA_SYSTEM__ROTATE:
				return basicSetRotate(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.CAMERA_SYSTEM__WIDTH:
				return getWidth();
			case RobotMLPackage.CAMERA_SYSTEM__HEIGHT:
				return getHeight();
			case RobotMLPackage.CAMERA_SYSTEM__ALPHA_U:
				return getAlpha_u();
			case RobotMLPackage.CAMERA_SYSTEM__ALPHA_V:
				return getAlpha_v();
			case RobotMLPackage.CAMERA_SYSTEM__U0:
				return getU0();
			case RobotMLPackage.CAMERA_SYSTEM__V0:
				return getV0();
			case RobotMLPackage.CAMERA_SYSTEM__COLOR_FORMAT:
				return getColor_format();
			case RobotMLPackage.CAMERA_SYSTEM__TRANSLATE:
				return getTranslate();
			case RobotMLPackage.CAMERA_SYSTEM__ROTATE:
				return getRotate();
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
			case RobotMLPackage.CAMERA_SYSTEM__WIDTH:
				setWidth((Long)newValue);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__HEIGHT:
				setHeight((Long)newValue);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__ALPHA_U:
				setAlpha_u((Float)newValue);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__ALPHA_V:
				setAlpha_v((Float)newValue);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__U0:
				setU0((Float)newValue);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__V0:
				setV0((Float)newValue);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__COLOR_FORMAT:
				setColor_format((String)newValue);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__TRANSLATE:
				setTranslate((Point32)newValue);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__ROTATE:
				setRotate((Point32)newValue);
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
			case RobotMLPackage.CAMERA_SYSTEM__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__ALPHA_U:
				setAlpha_u(ALPHA_U_EDEFAULT);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__ALPHA_V:
				setAlpha_v(ALPHA_V_EDEFAULT);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__U0:
				setU0(U0_EDEFAULT);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__V0:
				setV0(V0_EDEFAULT);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__COLOR_FORMAT:
				setColor_format(COLOR_FORMAT_EDEFAULT);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__TRANSLATE:
				setTranslate((Point32)null);
				return;
			case RobotMLPackage.CAMERA_SYSTEM__ROTATE:
				setRotate((Point32)null);
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
			case RobotMLPackage.CAMERA_SYSTEM__WIDTH:
				return width != WIDTH_EDEFAULT;
			case RobotMLPackage.CAMERA_SYSTEM__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case RobotMLPackage.CAMERA_SYSTEM__ALPHA_U:
				return alpha_u != ALPHA_U_EDEFAULT;
			case RobotMLPackage.CAMERA_SYSTEM__ALPHA_V:
				return alpha_v != ALPHA_V_EDEFAULT;
			case RobotMLPackage.CAMERA_SYSTEM__U0:
				return u0 != U0_EDEFAULT;
			case RobotMLPackage.CAMERA_SYSTEM__V0:
				return v0 != V0_EDEFAULT;
			case RobotMLPackage.CAMERA_SYSTEM__COLOR_FORMAT:
				return COLOR_FORMAT_EDEFAULT == null ? color_format != null : !COLOR_FORMAT_EDEFAULT.equals(color_format);
			case RobotMLPackage.CAMERA_SYSTEM__TRANSLATE:
				return translate != null;
			case RobotMLPackage.CAMERA_SYSTEM__ROTATE:
				return rotate != null;
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
		result.append(" (width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", alpha_u: ");
		result.append(alpha_u);
		result.append(", alpha_v: ");
		result.append(alpha_v);
		result.append(", u0: ");
		result.append(u0);
		result.append(", v0: ");
		result.append(v0);
		result.append(", color_format: ");
		result.append(color_format);
		result.append(')');
		return result.toString();
	}

} //CameraSystemImpl
