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
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommHostImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommHost;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sa Comm Host</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommHostImpl#getIsSched <em>Is Sched</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommHostImpl#getSchSlack <em>Sch Slack</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaCommHostImpl extends GaCommHostImpl implements SaCommHost {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaCommHostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SAMPackage.Literals.SA_COMM_HOST;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_COMM_HOST__IS_SCHED, oldIsSched, isSched));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_COMM_HOST__SCH_SLACK, oldSchSlack, schSlack));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SAMPackage.SA_COMM_HOST__IS_SCHED:
				return getIsSched();
			case SAMPackage.SA_COMM_HOST__SCH_SLACK:
				return getSchSlack();
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
			case SAMPackage.SA_COMM_HOST__IS_SCHED:
				setIsSched((String)newValue);
				return;
			case SAMPackage.SA_COMM_HOST__SCH_SLACK:
				setSchSlack((String)newValue);
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
			case SAMPackage.SA_COMM_HOST__IS_SCHED:
				setIsSched(IS_SCHED_EDEFAULT);
				return;
			case SAMPackage.SA_COMM_HOST__SCH_SLACK:
				setSchSlack(SCH_SLACK_EDEFAULT);
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
			case SAMPackage.SA_COMM_HOST__IS_SCHED:
				return IS_SCHED_EDEFAULT == null ? isSched != null : !IS_SCHED_EDEFAULT.equals(isSched);
			case SAMPackage.SA_COMM_HOST__SCH_SLACK:
				return SCH_SLACK_EDEFAULT == null ? schSlack != null : !SCH_SLACK_EDEFAULT.equals(schSlack);
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
		result.append(')');
		return result.toString();
	}

} //SaCommHostImpl
