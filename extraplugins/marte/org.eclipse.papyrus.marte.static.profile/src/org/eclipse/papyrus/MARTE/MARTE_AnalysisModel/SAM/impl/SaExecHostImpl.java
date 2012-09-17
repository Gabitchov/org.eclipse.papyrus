/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sa Exec Host</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaExecHostImpl#getIsSched <em>Is Sched</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaExecHostImpl#getSchSlack <em>Sch Slack</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaExecHostImpl#getSchedUtiliz <em>Sched Utiliz</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaExecHostImpl#getISRswitchT <em>IS Rswitch T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaExecHostImpl#getISRprioRange <em>IS Rprio Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaExecHostImpl extends GaExecHostImpl implements SaExecHost {
	/**
	 * The default value of the '{@link #getIsSched() <em>Is Sched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSched()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_SCHED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsSched() <em>Is Sched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSched()
	 * @generated
	 * @ordered
	 */
	protected String isSched = IS_SCHED_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchSlack() <em>Sch Slack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchSlack()
	 * @generated
	 * @ordered
	 */
	protected static final String SCH_SLACK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchSlack() <em>Sch Slack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchSlack()
	 * @generated
	 * @ordered
	 */
	protected String schSlack = SCH_SLACK_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedUtiliz() <em>Sched Utiliz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedUtiliz()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHED_UTILIZ_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchedUtiliz() <em>Sched Utiliz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedUtiliz()
	 * @generated
	 * @ordered
	 */
	protected String schedUtiliz = SCHED_UTILIZ_EDEFAULT;

	/**
	 * The default value of the '{@link #getISRswitchT() <em>IS Rswitch T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getISRswitchT()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_RSWITCH_T_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getISRswitchT() <em>IS Rswitch T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getISRswitchT()
	 * @generated
	 * @ordered
	 */
	protected String isRswitchT = IS_RSWITCH_T_EDEFAULT;

	/**
	 * The default value of the '{@link #getISRprioRange() <em>IS Rprio Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getISRprioRange()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_RPRIO_RANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getISRprioRange() <em>IS Rprio Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getISRprioRange()
	 * @generated
	 * @ordered
	 */
	protected String isRprioRange = IS_RPRIO_RANGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaExecHostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SAMPackage.Literals.SA_EXEC_HOST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsSched() {
		return isSched;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSched(String newIsSched) {
		String oldIsSched = isSched;
		isSched = newIsSched;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_EXEC_HOST__IS_SCHED, oldIsSched, isSched));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchSlack() {
		return schSlack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchSlack(String newSchSlack) {
		String oldSchSlack = schSlack;
		schSlack = newSchSlack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_EXEC_HOST__SCH_SLACK, oldSchSlack, schSlack));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchedUtiliz() {
		return schedUtiliz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedUtiliz(String newSchedUtiliz) {
		String oldSchedUtiliz = schedUtiliz;
		schedUtiliz = newSchedUtiliz;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_EXEC_HOST__SCHED_UTILIZ, oldSchedUtiliz, schedUtiliz));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getISRswitchT() {
		return isRswitchT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setISRswitchT(String newISRswitchT) {
		String oldISRswitchT = isRswitchT;
		isRswitchT = newISRswitchT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_EXEC_HOST__IS_RSWITCH_T, oldISRswitchT, isRswitchT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getISRprioRange() {
		return isRprioRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setISRprioRange(String newISRprioRange) {
		String oldISRprioRange = isRprioRange;
		isRprioRange = newISRprioRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_EXEC_HOST__IS_RPRIO_RANGE, oldISRprioRange, isRprioRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SAMPackage.SA_EXEC_HOST__IS_SCHED:
				return getIsSched();
			case SAMPackage.SA_EXEC_HOST__SCH_SLACK:
				return getSchSlack();
			case SAMPackage.SA_EXEC_HOST__SCHED_UTILIZ:
				return getSchedUtiliz();
			case SAMPackage.SA_EXEC_HOST__IS_RSWITCH_T:
				return getISRswitchT();
			case SAMPackage.SA_EXEC_HOST__IS_RPRIO_RANGE:
				return getISRprioRange();
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
			case SAMPackage.SA_EXEC_HOST__IS_SCHED:
				setIsSched((String)newValue);
				return;
			case SAMPackage.SA_EXEC_HOST__SCH_SLACK:
				setSchSlack((String)newValue);
				return;
			case SAMPackage.SA_EXEC_HOST__SCHED_UTILIZ:
				setSchedUtiliz((String)newValue);
				return;
			case SAMPackage.SA_EXEC_HOST__IS_RSWITCH_T:
				setISRswitchT((String)newValue);
				return;
			case SAMPackage.SA_EXEC_HOST__IS_RPRIO_RANGE:
				setISRprioRange((String)newValue);
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
			case SAMPackage.SA_EXEC_HOST__IS_SCHED:
				setIsSched(IS_SCHED_EDEFAULT);
				return;
			case SAMPackage.SA_EXEC_HOST__SCH_SLACK:
				setSchSlack(SCH_SLACK_EDEFAULT);
				return;
			case SAMPackage.SA_EXEC_HOST__SCHED_UTILIZ:
				setSchedUtiliz(SCHED_UTILIZ_EDEFAULT);
				return;
			case SAMPackage.SA_EXEC_HOST__IS_RSWITCH_T:
				setISRswitchT(IS_RSWITCH_T_EDEFAULT);
				return;
			case SAMPackage.SA_EXEC_HOST__IS_RPRIO_RANGE:
				setISRprioRange(IS_RPRIO_RANGE_EDEFAULT);
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
			case SAMPackage.SA_EXEC_HOST__IS_SCHED:
				return IS_SCHED_EDEFAULT == null ? isSched != null : !IS_SCHED_EDEFAULT.equals(isSched);
			case SAMPackage.SA_EXEC_HOST__SCH_SLACK:
				return SCH_SLACK_EDEFAULT == null ? schSlack != null : !SCH_SLACK_EDEFAULT.equals(schSlack);
			case SAMPackage.SA_EXEC_HOST__SCHED_UTILIZ:
				return SCHED_UTILIZ_EDEFAULT == null ? schedUtiliz != null : !SCHED_UTILIZ_EDEFAULT.equals(schedUtiliz);
			case SAMPackage.SA_EXEC_HOST__IS_RSWITCH_T:
				return IS_RSWITCH_T_EDEFAULT == null ? isRswitchT != null : !IS_RSWITCH_T_EDEFAULT.equals(isRswitchT);
			case SAMPackage.SA_EXEC_HOST__IS_RPRIO_RANGE:
				return IS_RPRIO_RANGE_EDEFAULT == null ? isRprioRange != null : !IS_RPRIO_RANGE_EDEFAULT.equals(isRprioRange);
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
		result.append(" (isSched: ");
		result.append(isSched);
		result.append(", schSlack: ");
		result.append(schSlack);
		result.append(", schedUtiliz: ");
		result.append(schedUtiliz);
		result.append(", ISRswitchT: ");
		result.append(isRswitchT);
		result.append(", ISRprioRange: ");
		result.append(isRprioRange);
		result.append(')');
		return result.toString();
	}

} //SaExecHostImpl
