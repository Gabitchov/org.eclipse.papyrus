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

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.CameraInfo;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.RegionOfInterest;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Camera Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getDistorsion_model <em>Distorsion model</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getD <em>D</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getK <em>K</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getR <em>R</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getP <em>P</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getBinning_x <em>Binning x</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getBinning_y <em>Binning y</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CameraInfoImpl#getRoi <em>Roi</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CameraInfoImpl extends MinimalEObjectImpl.Container implements CameraInfo {
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
	 * The default value of the '{@link #getDistorsion_model() <em>Distorsion model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistorsion_model()
	 * @generated
	 * @ordered
	 */
	protected static final String DISTORSION_MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDistorsion_model() <em>Distorsion model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistorsion_model()
	 * @generated
	 * @ordered
	 */
	protected String distorsion_model = DISTORSION_MODEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getD() <em>D</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> d;

	/**
	 * The cached value of the '{@link #getK() <em>K</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getK()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> k;

	/**
	 * The cached value of the '{@link #getR() <em>R</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> r;

	/**
	 * The cached value of the '{@link #getP() <em>P</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getP()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> p;

	/**
	 * The default value of the '{@link #getBinning_x() <em>Binning x</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinning_x()
	 * @generated
	 * @ordered
	 */
	protected static final long BINNING_X_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getBinning_x() <em>Binning x</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinning_x()
	 * @generated
	 * @ordered
	 */
	protected long binning_x = BINNING_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getBinning_y() <em>Binning y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinning_y()
	 * @generated
	 * @ordered
	 */
	protected static final long BINNING_Y_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getBinning_y() <em>Binning y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinning_y()
	 * @generated
	 * @ordered
	 */
	protected long binning_y = BINNING_Y_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoi() <em>Roi</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoi()
	 * @generated
	 * @ordered
	 */
	protected RegionOfInterest roi;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CameraInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.CAMERA_INFO;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAMERA_INFO__HEADER, oldHeader, newHeader);
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
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.CAMERA_INFO__HEADER, null, msgs);
			if (newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.CAMERA_INFO__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAMERA_INFO__HEADER, newHeader, newHeader));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAMERA_INFO__HEIGHT, oldHeight, height));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAMERA_INFO__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistorsion_model() {
		return distorsion_model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistorsion_model(String newDistorsion_model) {
		String oldDistorsion_model = distorsion_model;
		distorsion_model = newDistorsion_model;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAMERA_INFO__DISTORSION_MODEL, oldDistorsion_model, distorsion_model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getD() {
		if (d == null) {
			d = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.CAMERA_INFO__D);
		}
		return d;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getK() {
		if (k == null) {
			k = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.CAMERA_INFO__K);
		}
		return k;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getR() {
		if (r == null) {
			r = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.CAMERA_INFO__R);
		}
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getP() {
		if (p == null) {
			p = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.CAMERA_INFO__P);
		}
		return p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getBinning_x() {
		return binning_x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinning_x(long newBinning_x) {
		long oldBinning_x = binning_x;
		binning_x = newBinning_x;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAMERA_INFO__BINNING_X, oldBinning_x, binning_x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getBinning_y() {
		return binning_y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinning_y(long newBinning_y) {
		long oldBinning_y = binning_y;
		binning_y = newBinning_y;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAMERA_INFO__BINNING_Y, oldBinning_y, binning_y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionOfInterest getRoi() {
		return roi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoi(RegionOfInterest newRoi, NotificationChain msgs) {
		RegionOfInterest oldRoi = roi;
		roi = newRoi;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAMERA_INFO__ROI, oldRoi, newRoi);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoi(RegionOfInterest newRoi) {
		if (newRoi != roi) {
			NotificationChain msgs = null;
			if (roi != null)
				msgs = ((InternalEObject)roi).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.CAMERA_INFO__ROI, null, msgs);
			if (newRoi != null)
				msgs = ((InternalEObject)newRoi).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.CAMERA_INFO__ROI, null, msgs);
			msgs = basicSetRoi(newRoi, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAMERA_INFO__ROI, newRoi, newRoi));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Sensor_datatypesPackage.CAMERA_INFO__HEADER:
				return basicSetHeader(null, msgs);
			case Sensor_datatypesPackage.CAMERA_INFO__ROI:
				return basicSetRoi(null, msgs);
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
			case Sensor_datatypesPackage.CAMERA_INFO__HEADER:
				return getHeader();
			case Sensor_datatypesPackage.CAMERA_INFO__HEIGHT:
				return getHeight();
			case Sensor_datatypesPackage.CAMERA_INFO__WIDTH:
				return getWidth();
			case Sensor_datatypesPackage.CAMERA_INFO__DISTORSION_MODEL:
				return getDistorsion_model();
			case Sensor_datatypesPackage.CAMERA_INFO__D:
				return getD();
			case Sensor_datatypesPackage.CAMERA_INFO__K:
				return getK();
			case Sensor_datatypesPackage.CAMERA_INFO__R:
				return getR();
			case Sensor_datatypesPackage.CAMERA_INFO__P:
				return getP();
			case Sensor_datatypesPackage.CAMERA_INFO__BINNING_X:
				return getBinning_x();
			case Sensor_datatypesPackage.CAMERA_INFO__BINNING_Y:
				return getBinning_y();
			case Sensor_datatypesPackage.CAMERA_INFO__ROI:
				return getRoi();
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
			case Sensor_datatypesPackage.CAMERA_INFO__HEADER:
				setHeader((Header)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__HEIGHT:
				setHeight((Long)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__WIDTH:
				setWidth((Long)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__DISTORSION_MODEL:
				setDistorsion_model((String)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__D:
				getD().clear();
				getD().addAll((Collection<? extends Double>)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__K:
				getK().clear();
				getK().addAll((Collection<? extends Double>)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__R:
				getR().clear();
				getR().addAll((Collection<? extends Double>)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__P:
				getP().clear();
				getP().addAll((Collection<? extends Double>)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__BINNING_X:
				setBinning_x((Long)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__BINNING_Y:
				setBinning_y((Long)newValue);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__ROI:
				setRoi((RegionOfInterest)newValue);
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
			case Sensor_datatypesPackage.CAMERA_INFO__HEADER:
				setHeader((Header)null);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__DISTORSION_MODEL:
				setDistorsion_model(DISTORSION_MODEL_EDEFAULT);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__D:
				getD().clear();
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__K:
				getK().clear();
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__R:
				getR().clear();
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__P:
				getP().clear();
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__BINNING_X:
				setBinning_x(BINNING_X_EDEFAULT);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__BINNING_Y:
				setBinning_y(BINNING_Y_EDEFAULT);
				return;
			case Sensor_datatypesPackage.CAMERA_INFO__ROI:
				setRoi((RegionOfInterest)null);
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
			case Sensor_datatypesPackage.CAMERA_INFO__HEADER:
				return header != null;
			case Sensor_datatypesPackage.CAMERA_INFO__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case Sensor_datatypesPackage.CAMERA_INFO__WIDTH:
				return width != WIDTH_EDEFAULT;
			case Sensor_datatypesPackage.CAMERA_INFO__DISTORSION_MODEL:
				return DISTORSION_MODEL_EDEFAULT == null ? distorsion_model != null : !DISTORSION_MODEL_EDEFAULT.equals(distorsion_model);
			case Sensor_datatypesPackage.CAMERA_INFO__D:
				return d != null && !d.isEmpty();
			case Sensor_datatypesPackage.CAMERA_INFO__K:
				return k != null && !k.isEmpty();
			case Sensor_datatypesPackage.CAMERA_INFO__R:
				return r != null && !r.isEmpty();
			case Sensor_datatypesPackage.CAMERA_INFO__P:
				return p != null && !p.isEmpty();
			case Sensor_datatypesPackage.CAMERA_INFO__BINNING_X:
				return binning_x != BINNING_X_EDEFAULT;
			case Sensor_datatypesPackage.CAMERA_INFO__BINNING_Y:
				return binning_y != BINNING_Y_EDEFAULT;
			case Sensor_datatypesPackage.CAMERA_INFO__ROI:
				return roi != null;
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
		result.append(", distorsion_model: ");
		result.append(distorsion_model);
		result.append(", D: ");
		result.append(d);
		result.append(", K: ");
		result.append(k);
		result.append(", R: ");
		result.append(r);
		result.append(", P: ");
		result.append(p);
		result.append(", binning_x: ");
		result.append(binning_x);
		result.append(", binning_y: ");
		result.append(binning_y);
		result.append(')');
		return result.toString();
	}

} //CameraInfoImpl
