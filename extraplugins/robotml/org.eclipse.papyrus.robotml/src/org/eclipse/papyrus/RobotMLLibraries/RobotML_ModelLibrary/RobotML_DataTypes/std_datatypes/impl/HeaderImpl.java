/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.HeaderImpl#getSeq <em>Seq</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.HeaderImpl#getStamp <em>Stamp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.HeaderImpl#getFrame_id <em>Frame id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HeaderImpl extends MinimalEObjectImpl.Container implements Header {
	/**
	 * The default value of the '{@link #getSeq() <em>Seq</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeq()
	 * @generated
	 * @ordered
	 */
	protected static final long SEQ_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSeq() <em>Seq</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeq()
	 * @generated
	 * @ordered
	 */
	protected long seq = SEQ_EDEFAULT;

	/**
	 * The default value of the '{@link #getStamp() <em>Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStamp()
	 * @generated
	 * @ordered
	 */
	protected static final Date STAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStamp() <em>Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStamp()
	 * @generated
	 * @ordered
	 */
	protected Date stamp = STAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrame_id() <em>Frame id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrame_id()
	 * @generated
	 * @ordered
	 */
	protected static final String FRAME_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrame_id() <em>Frame id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrame_id()
	 * @generated
	 * @ordered
	 */
	protected String frame_id = FRAME_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HeaderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Std_datatypesPackage.Literals.HEADER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSeq() {
		return seq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeq(long newSeq) {
		long oldSeq = seq;
		seq = newSeq;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.HEADER__SEQ, oldSeq, seq));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStamp() {
		return stamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStamp(Date newStamp) {
		Date oldStamp = stamp;
		stamp = newStamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.HEADER__STAMP, oldStamp, stamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrame_id() {
		return frame_id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrame_id(String newFrame_id) {
		String oldFrame_id = frame_id;
		frame_id = newFrame_id;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.HEADER__FRAME_ID, oldFrame_id, frame_id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Std_datatypesPackage.HEADER__SEQ:
				return getSeq();
			case Std_datatypesPackage.HEADER__STAMP:
				return getStamp();
			case Std_datatypesPackage.HEADER__FRAME_ID:
				return getFrame_id();
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
			case Std_datatypesPackage.HEADER__SEQ:
				setSeq((Long)newValue);
				return;
			case Std_datatypesPackage.HEADER__STAMP:
				setStamp((Date)newValue);
				return;
			case Std_datatypesPackage.HEADER__FRAME_ID:
				setFrame_id((String)newValue);
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
			case Std_datatypesPackage.HEADER__SEQ:
				setSeq(SEQ_EDEFAULT);
				return;
			case Std_datatypesPackage.HEADER__STAMP:
				setStamp(STAMP_EDEFAULT);
				return;
			case Std_datatypesPackage.HEADER__FRAME_ID:
				setFrame_id(FRAME_ID_EDEFAULT);
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
			case Std_datatypesPackage.HEADER__SEQ:
				return seq != SEQ_EDEFAULT;
			case Std_datatypesPackage.HEADER__STAMP:
				return STAMP_EDEFAULT == null ? stamp != null : !STAMP_EDEFAULT.equals(stamp);
			case Std_datatypesPackage.HEADER__FRAME_ID:
				return FRAME_ID_EDEFAULT == null ? frame_id != null : !FRAME_ID_EDEFAULT.equals(frame_id);
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
		result.append(" (seq: ");
		result.append(seq);
		result.append(", stamp: ");
		result.append(stamp);
		result.append(", frame_id: ");
		result.append(frame_id);
		result.append(')');
		return result.toString();
	}

} //HeaderImpl
