/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.RobotML.DataFlowDirectionKind;
import org.eclipse.papyrus.RobotML.DataFlowPort;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl#getBufferSize <em>Buffer Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataFlowPortImpl extends PortImpl implements DataFlowPort {
	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final DataFlowDirectionKind DIRECTION_EDEFAULT = DataFlowDirectionKind.IN;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected DataFlowDirectionKind direction = DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBufferSize() <em>Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferSize()
	 * @generated
	 * @ordered
	 */
	protected static final int BUFFER_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBufferSize() <em>Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferSize()
	 * @generated
	 * @ordered
	 */
	protected int bufferSize = BUFFER_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.DATA_FLOW_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowDirectionKind getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(DataFlowDirectionKind newDirection) {
		DataFlowDirectionKind oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.DATA_FLOW_PORT__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBufferSize() {
		return bufferSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBufferSize(int newBufferSize) {
		int oldBufferSize = bufferSize;
		bufferSize = newBufferSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.DATA_FLOW_PORT__BUFFER_SIZE, oldBufferSize, bufferSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.DATA_FLOW_PORT__DIRECTION:
				return getDirection();
			case RobotMLPackage.DATA_FLOW_PORT__BUFFER_SIZE:
				return getBufferSize();
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
			case RobotMLPackage.DATA_FLOW_PORT__DIRECTION:
				setDirection((DataFlowDirectionKind)newValue);
				return;
			case RobotMLPackage.DATA_FLOW_PORT__BUFFER_SIZE:
				setBufferSize((Integer)newValue);
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
			case RobotMLPackage.DATA_FLOW_PORT__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case RobotMLPackage.DATA_FLOW_PORT__BUFFER_SIZE:
				setBufferSize(BUFFER_SIZE_EDEFAULT);
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
			case RobotMLPackage.DATA_FLOW_PORT__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case RobotMLPackage.DATA_FLOW_PORT__BUFFER_SIZE:
				return bufferSize != BUFFER_SIZE_EDEFAULT;
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
		result.append(" (direction: ");
		result.append(direction);
		result.append(", bufferSize: ");
		result.append(bufferSize);
		result.append(')');
		return result.toString();
	}

} //DataFlowPortImpl
