/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Image;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImageImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImageImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImageImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImageImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImageImpl#getIs_bigendian <em>Is bigendian</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImageImpl#getStep <em>Step</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImageImpl#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImageImpl extends MinimalEObjectImpl.Container implements Image {
	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Header header;

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
	 * The default value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCODING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected String encoding = ENCODING_EDEFAULT;

	/**
	 * The default value of the '{@link #getIs_bigendian() <em>Is bigendian</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIs_bigendian()
	 * @generated
	 * @ordered
	 */
	protected static final char IS_BIGENDIAN_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getIs_bigendian() <em>Is bigendian</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIs_bigendian()
	 * @generated
	 * @ordered
	 */
	protected char is_bigendian = IS_BIGENDIAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected static final long STEP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected long step = STEP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<Character> data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeader(Header newHeader, NotificationChain msgs) {
		Header oldHeader = header;
		header = newHeader;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMAGE__HEADER, oldHeader, newHeader);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(Header newHeader) {
		if (newHeader != header) {
			NotificationChain msgs = null;
			if (header != null)
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMAGE__HEADER, null, msgs);
			if (newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMAGE__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMAGE__HEADER, newHeader, newHeader));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMAGE__HEIGHT, oldHeight, height));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMAGE__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncoding(String newEncoding) {
		String oldEncoding = encoding;
		encoding = newEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMAGE__ENCODING, oldEncoding, encoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getIs_bigendian() {
		return is_bigendian;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIs_bigendian(char newIs_bigendian) {
		char oldIs_bigendian = is_bigendian;
		is_bigendian = newIs_bigendian;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMAGE__IS_BIGENDIAN, oldIs_bigendian, is_bigendian));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStep() {
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStep(long newStep) {
		long oldStep = step;
		step = newStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMAGE__STEP, oldStep, step));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Character> getData() {
		if (data == null) {
			data = new EDataTypeUniqueEList<Character>(Character.class, this, Sensor_datatypesPackage.IMAGE__DATA);
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Sensor_datatypesPackage.IMAGE__HEADER:
				return basicSetHeader(null, msgs);
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
			case Sensor_datatypesPackage.IMAGE__HEADER:
				return getHeader();
			case Sensor_datatypesPackage.IMAGE__HEIGHT:
				return getHeight();
			case Sensor_datatypesPackage.IMAGE__WIDTH:
				return getWidth();
			case Sensor_datatypesPackage.IMAGE__ENCODING:
				return getEncoding();
			case Sensor_datatypesPackage.IMAGE__IS_BIGENDIAN:
				return getIs_bigendian();
			case Sensor_datatypesPackage.IMAGE__STEP:
				return getStep();
			case Sensor_datatypesPackage.IMAGE__DATA:
				return getData();
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
			case Sensor_datatypesPackage.IMAGE__HEADER:
				setHeader((Header)newValue);
				return;
			case Sensor_datatypesPackage.IMAGE__HEIGHT:
				setHeight((Long)newValue);
				return;
			case Sensor_datatypesPackage.IMAGE__WIDTH:
				setWidth((Long)newValue);
				return;
			case Sensor_datatypesPackage.IMAGE__ENCODING:
				setEncoding((String)newValue);
				return;
			case Sensor_datatypesPackage.IMAGE__IS_BIGENDIAN:
				setIs_bigendian((Character)newValue);
				return;
			case Sensor_datatypesPackage.IMAGE__STEP:
				setStep((Long)newValue);
				return;
			case Sensor_datatypesPackage.IMAGE__DATA:
				getData().clear();
				getData().addAll((Collection<? extends Character>)newValue);
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
			case Sensor_datatypesPackage.IMAGE__HEADER:
				setHeader((Header)null);
				return;
			case Sensor_datatypesPackage.IMAGE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case Sensor_datatypesPackage.IMAGE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case Sensor_datatypesPackage.IMAGE__ENCODING:
				setEncoding(ENCODING_EDEFAULT);
				return;
			case Sensor_datatypesPackage.IMAGE__IS_BIGENDIAN:
				setIs_bigendian(IS_BIGENDIAN_EDEFAULT);
				return;
			case Sensor_datatypesPackage.IMAGE__STEP:
				setStep(STEP_EDEFAULT);
				return;
			case Sensor_datatypesPackage.IMAGE__DATA:
				getData().clear();
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
			case Sensor_datatypesPackage.IMAGE__HEADER:
				return header != null;
			case Sensor_datatypesPackage.IMAGE__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case Sensor_datatypesPackage.IMAGE__WIDTH:
				return width != WIDTH_EDEFAULT;
			case Sensor_datatypesPackage.IMAGE__ENCODING:
				return ENCODING_EDEFAULT == null ? encoding != null : !ENCODING_EDEFAULT.equals(encoding);
			case Sensor_datatypesPackage.IMAGE__IS_BIGENDIAN:
				return is_bigendian != IS_BIGENDIAN_EDEFAULT;
			case Sensor_datatypesPackage.IMAGE__STEP:
				return step != STEP_EDEFAULT;
			case Sensor_datatypesPackage.IMAGE__DATA:
				return data != null && !data.isEmpty();
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
		result.append(" (height: ");
		result.append(height);
		result.append(", width: ");
		result.append(width);
		result.append(", encoding: ");
		result.append(encoding);
		result.append(", is_bigendian: ");
		result.append(is_bigendian);
		result.append(", step: ");
		result.append(step);
		result.append(", data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} //ImageImpl
