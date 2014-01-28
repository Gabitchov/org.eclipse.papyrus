/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getPENDING <em>PENDING</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getACTIVE <em>ACTIVE</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getPREEMPTED <em>PREEMPTED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getSUCCEEDED <em>SUCCEEDED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getABORTED <em>ABORTED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getREJECTED <em>REJECTED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getPREEMPTING <em>PREEMPTING</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getRECALLING <em>RECALLING</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getRECALLED <em>RECALLED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getLOST <em>LOST</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GoalStatusImpl extends MinimalEObjectImpl.Container implements GoalStatus {
	/**
	 * The default value of the '{@link #getPENDING() <em>PENDING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPENDING()
	 * @generated
	 * @ordered
	 */
	protected static final char PENDING_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getPENDING() <em>PENDING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPENDING()
	 * @generated
	 * @ordered
	 */
	protected char pending = PENDING_EDEFAULT;

	/**
	 * The default value of the '{@link #getACTIVE() <em>ACTIVE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getACTIVE()
	 * @generated
	 * @ordered
	 */
	protected static final char ACTIVE_EDEFAULT = '\u0001';

	/**
	 * The cached value of the '{@link #getACTIVE() <em>ACTIVE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getACTIVE()
	 * @generated
	 * @ordered
	 */
	protected char active = ACTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPREEMPTED() <em>PREEMPTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPREEMPTED()
	 * @generated
	 * @ordered
	 */
	protected static final char PREEMPTED_EDEFAULT = '\u0002';

	/**
	 * The cached value of the '{@link #getPREEMPTED() <em>PREEMPTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPREEMPTED()
	 * @generated
	 * @ordered
	 */
	protected char preempted = PREEMPTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getSUCCEEDED() <em>SUCCEEDED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSUCCEEDED()
	 * @generated
	 * @ordered
	 */
	protected static final char SUCCEEDED_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getSUCCEEDED() <em>SUCCEEDED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSUCCEEDED()
	 * @generated
	 * @ordered
	 */
	protected char succeeded = SUCCEEDED_EDEFAULT;

	/**
	 * The default value of the '{@link #getABORTED() <em>ABORTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getABORTED()
	 * @generated
	 * @ordered
	 */
	protected static final char ABORTED_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getABORTED() <em>ABORTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getABORTED()
	 * @generated
	 * @ordered
	 */
	protected char aborted = ABORTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getREJECTED() <em>REJECTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getREJECTED()
	 * @generated
	 * @ordered
	 */
	protected static final char REJECTED_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getREJECTED() <em>REJECTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getREJECTED()
	 * @generated
	 * @ordered
	 */
	protected char rejected = REJECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPREEMPTING() <em>PREEMPTING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPREEMPTING()
	 * @generated
	 * @ordered
	 */
	protected static final char PREEMPTING_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getPREEMPTING() <em>PREEMPTING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPREEMPTING()
	 * @generated
	 * @ordered
	 */
	protected char preempting = PREEMPTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getRECALLING() <em>RECALLING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRECALLING()
	 * @generated
	 * @ordered
	 */
	protected static final char RECALLING_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getRECALLING() <em>RECALLING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRECALLING()
	 * @generated
	 * @ordered
	 */
	protected char recalling = RECALLING_EDEFAULT;

	/**
	 * The default value of the '{@link #getRECALLED() <em>RECALLED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRECALLED()
	 * @generated
	 * @ordered
	 */
	protected static final char RECALLED_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getRECALLED() <em>RECALLED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRECALLED()
	 * @generated
	 * @ordered
	 */
	protected char recalled = RECALLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getLOST() <em>LOST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLOST()
	 * @generated
	 * @ordered
	 */
	protected static final char LOST_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getLOST() <em>LOST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLOST()
	 * @generated
	 * @ordered
	 */
	protected char lost = LOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final char STATUS_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected char status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Actionlib_datatypesPackage.Literals.GOAL_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getPENDING() {
		return pending;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPENDING(char newPENDING) {
		char oldPENDING = pending;
		pending = newPENDING;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__PENDING, oldPENDING, pending));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getACTIVE() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setACTIVE(char newACTIVE) {
		char oldACTIVE = active;
		active = newACTIVE;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE, oldACTIVE, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getPREEMPTED() {
		return preempted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPREEMPTED(char newPREEMPTED) {
		char oldPREEMPTED = preempted;
		preempted = newPREEMPTED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED, oldPREEMPTED, preempted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getSUCCEEDED() {
		return succeeded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSUCCEEDED(char newSUCCEEDED) {
		char oldSUCCEEDED = succeeded;
		succeeded = newSUCCEEDED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED, oldSUCCEEDED, succeeded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getABORTED() {
		return aborted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setABORTED(char newABORTED) {
		char oldABORTED = aborted;
		aborted = newABORTED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__ABORTED, oldABORTED, aborted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getREJECTED() {
		return rejected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setREJECTED(char newREJECTED) {
		char oldREJECTED = rejected;
		rejected = newREJECTED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__REJECTED, oldREJECTED, rejected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getPREEMPTING() {
		return preempting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPREEMPTING(char newPREEMPTING) {
		char oldPREEMPTING = preempting;
		preempting = newPREEMPTING;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING, oldPREEMPTING, preempting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getRECALLING() {
		return recalling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRECALLING(char newRECALLING) {
		char oldRECALLING = recalling;
		recalling = newRECALLING;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__RECALLING, oldRECALLING, recalling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getRECALLED() {
		return recalled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRECALLED(char newRECALLED) {
		char oldRECALLED = recalled;
		recalled = newRECALLED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__RECALLED, oldRECALLED, recalled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getLOST() {
		return lost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLOST(char newLOST) {
		char oldLOST = lost;
		lost = newLOST;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__LOST, oldLOST, lost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(char newStatus) {
		char oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Actionlib_datatypesPackage.GOAL_STATUS__PENDING:
				return getPENDING();
			case Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE:
				return getACTIVE();
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED:
				return getPREEMPTED();
			case Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED:
				return getSUCCEEDED();
			case Actionlib_datatypesPackage.GOAL_STATUS__ABORTED:
				return getABORTED();
			case Actionlib_datatypesPackage.GOAL_STATUS__REJECTED:
				return getREJECTED();
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING:
				return getPREEMPTING();
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLING:
				return getRECALLING();
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLED:
				return getRECALLED();
			case Actionlib_datatypesPackage.GOAL_STATUS__LOST:
				return getLOST();
			case Actionlib_datatypesPackage.GOAL_STATUS__TEXT:
				return getText();
			case Actionlib_datatypesPackage.GOAL_STATUS__STATUS:
				return getStatus();
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
			case Actionlib_datatypesPackage.GOAL_STATUS__PENDING:
				setPENDING((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE:
				setACTIVE((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED:
				setPREEMPTED((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED:
				setSUCCEEDED((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__ABORTED:
				setABORTED((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__REJECTED:
				setREJECTED((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING:
				setPREEMPTING((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLING:
				setRECALLING((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLED:
				setRECALLED((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__LOST:
				setLOST((Character)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__TEXT:
				setText((String)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__STATUS:
				setStatus((Character)newValue);
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
			case Actionlib_datatypesPackage.GOAL_STATUS__PENDING:
				setPENDING(PENDING_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE:
				setACTIVE(ACTIVE_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED:
				setPREEMPTED(PREEMPTED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED:
				setSUCCEEDED(SUCCEEDED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__ABORTED:
				setABORTED(ABORTED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__REJECTED:
				setREJECTED(REJECTED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING:
				setPREEMPTING(PREEMPTING_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLING:
				setRECALLING(RECALLING_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLED:
				setRECALLED(RECALLED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__LOST:
				setLOST(LOST_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case Actionlib_datatypesPackage.GOAL_STATUS__PENDING:
				return pending != PENDING_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED:
				return preempted != PREEMPTED_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED:
				return succeeded != SUCCEEDED_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__ABORTED:
				return aborted != ABORTED_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__REJECTED:
				return rejected != REJECTED_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING:
				return preempting != PREEMPTING_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLING:
				return recalling != RECALLING_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLED:
				return recalled != RECALLED_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__LOST:
				return lost != LOST_EDEFAULT;
			case Actionlib_datatypesPackage.GOAL_STATUS__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case Actionlib_datatypesPackage.GOAL_STATUS__STATUS:
				return status != STATUS_EDEFAULT;
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
		result.append(" (PENDING: ");
		result.append(pending);
		result.append(", ACTIVE: ");
		result.append(active);
		result.append(", PREEMPTED: ");
		result.append(preempted);
		result.append(", SUCCEEDED: ");
		result.append(succeeded);
		result.append(", ABORTED: ");
		result.append(aborted);
		result.append(", REJECTED: ");
		result.append(rejected);
		result.append(", PREEMPTING: ");
		result.append(preempting);
		result.append(", RECALLING: ");
		result.append(recalling);
		result.append(", RECALLED: ");
		result.append(recalled);
		result.append(", LOST: ");
		result.append(lost);
		result.append(", text: ");
		result.append(text);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //GoalStatusImpl
