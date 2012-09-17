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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Exec Host</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getSpeedFactor <em>Speed Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getMainScheduler <em>Main Scheduler</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getCommTxOvh <em>Comm Tx Ovh</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getCommRcvOvh <em>Comm Rcv Ovh</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getCntxtSwT <em>Cntxt Sw T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getClockOvh <em>Clock Ovh</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getSchedPriRange <em>Sched Pri Range</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getMemSize <em>Mem Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getUtilization <em>Utilization</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl#getThroughput <em>Throughput</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaExecHostImpl extends SchedulerImpl implements GaExecHost {
	/**
	 * The default value of the '{@link #getSpeedFactor() <em>Speed Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedFactor()
	 * @generated
	 * @ordered
	 */
	protected static final String SPEED_FACTOR_EDEFAULT = "1.0";

	/**
	 * The cached value of the '{@link #getSpeedFactor() <em>Speed Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedFactor()
	 * @generated
	 * @ordered
	 */
	protected String speedFactor = SPEED_FACTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMainScheduler() <em>Main Scheduler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainScheduler()
	 * @generated
	 * @ordered
	 */
	protected Scheduler mainScheduler;

	/**
	 * The default value of the '{@link #getCommTxOvh() <em>Comm Tx Ovh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommTxOvh()
	 * @generated
	 * @ordered
	 */
	protected static final String COMM_TX_OVH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommTxOvh() <em>Comm Tx Ovh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommTxOvh()
	 * @generated
	 * @ordered
	 */
	protected String commTxOvh = COMM_TX_OVH_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommRcvOvh() <em>Comm Rcv Ovh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommRcvOvh()
	 * @generated
	 * @ordered
	 */
	protected static final String COMM_RCV_OVH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommRcvOvh() <em>Comm Rcv Ovh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommRcvOvh()
	 * @generated
	 * @ordered
	 */
	protected String commRcvOvh = COMM_RCV_OVH_EDEFAULT;

	/**
	 * The default value of the '{@link #getCntxtSwT() <em>Cntxt Sw T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCntxtSwT()
	 * @generated
	 * @ordered
	 */
	protected static final String CNTXT_SW_T_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCntxtSwT() <em>Cntxt Sw T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCntxtSwT()
	 * @generated
	 * @ordered
	 */
	protected String cntxtSwT = CNTXT_SW_T_EDEFAULT;

	/**
	 * The default value of the '{@link #getClockOvh() <em>Clock Ovh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClockOvh()
	 * @generated
	 * @ordered
	 */
	protected static final String CLOCK_OVH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClockOvh() <em>Clock Ovh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClockOvh()
	 * @generated
	 * @ordered
	 */
	protected String clockOvh = CLOCK_OVH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedPriRange() <em>Sched Pri Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedPriRange()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHED_PRI_RANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchedPriRange() <em>Sched Pri Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedPriRange()
	 * @generated
	 * @ordered
	 */
	protected String schedPriRange = SCHED_PRI_RANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemSize() <em>Mem Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemSize()
	 * @generated
	 * @ordered
	 */
	protected static final String MEM_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemSize() <em>Mem Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemSize()
	 * @generated
	 * @ordered
	 */
	protected String memSize = MEM_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUtilization() <em>Utilization</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilization()
	 * @generated
	 * @ordered
	 */
	protected EList<String> utilization;

	/**
	 * The cached value of the '{@link #getThroughput() <em>Throughput</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThroughput()
	 * @generated
	 * @ordered
	 */
	protected EList<String> throughput;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GaExecHostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_EXEC_HOST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpeedFactor() {
		return speedFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeedFactor(String newSpeedFactor) {
		String oldSpeedFactor = speedFactor;
		speedFactor = newSpeedFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_EXEC_HOST__SPEED_FACTOR, oldSpeedFactor, speedFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler getMainScheduler() {
		if (mainScheduler != null && mainScheduler.eIsProxy()) {
			InternalEObject oldMainScheduler = (InternalEObject)mainScheduler;
			mainScheduler = (Scheduler)eResolveProxy(oldMainScheduler);
			if (mainScheduler != oldMainScheduler) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_EXEC_HOST__MAIN_SCHEDULER, oldMainScheduler, mainScheduler));
			}
		}
		return mainScheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler basicGetMainScheduler() {
		return mainScheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainScheduler(Scheduler newMainScheduler) {
		Scheduler oldMainScheduler = mainScheduler;
		mainScheduler = newMainScheduler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_EXEC_HOST__MAIN_SCHEDULER, oldMainScheduler, mainScheduler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommTxOvh() {
		return commTxOvh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommTxOvh(String newCommTxOvh) {
		String oldCommTxOvh = commTxOvh;
		commTxOvh = newCommTxOvh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_EXEC_HOST__COMM_TX_OVH, oldCommTxOvh, commTxOvh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommRcvOvh() {
		return commRcvOvh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommRcvOvh(String newCommRcvOvh) {
		String oldCommRcvOvh = commRcvOvh;
		commRcvOvh = newCommRcvOvh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_EXEC_HOST__COMM_RCV_OVH, oldCommRcvOvh, commRcvOvh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCntxtSwT() {
		return cntxtSwT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCntxtSwT(String newCntxtSwT) {
		String oldCntxtSwT = cntxtSwT;
		cntxtSwT = newCntxtSwT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_EXEC_HOST__CNTXT_SW_T, oldCntxtSwT, cntxtSwT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClockOvh() {
		return clockOvh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClockOvh(String newClockOvh) {
		String oldClockOvh = clockOvh;
		clockOvh = newClockOvh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_EXEC_HOST__CLOCK_OVH, oldClockOvh, clockOvh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchedPriRange() {
		return schedPriRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedPriRange(String newSchedPriRange) {
		String oldSchedPriRange = schedPriRange;
		schedPriRange = newSchedPriRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_EXEC_HOST__SCHED_PRI_RANGE, oldSchedPriRange, schedPriRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMemSize() {
		return memSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemSize(String newMemSize) {
		String oldMemSize = memSize;
		memSize = newMemSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_EXEC_HOST__MEM_SIZE, oldMemSize, memSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUtilization() {
		if (utilization == null) {
			utilization = new EDataTypeUniqueEList<String>(String.class, this, GQAMPackage.GA_EXEC_HOST__UTILIZATION);
		}
		return utilization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getThroughput() {
		if (throughput == null) {
			throughput = new EDataTypeUniqueEList<String>(String.class, this, GQAMPackage.GA_EXEC_HOST__THROUGHPUT);
		}
		return throughput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_EXEC_HOST__SPEED_FACTOR:
				return getSpeedFactor();
			case GQAMPackage.GA_EXEC_HOST__MAIN_SCHEDULER:
				if (resolve) return getMainScheduler();
				return basicGetMainScheduler();
			case GQAMPackage.GA_EXEC_HOST__COMM_TX_OVH:
				return getCommTxOvh();
			case GQAMPackage.GA_EXEC_HOST__COMM_RCV_OVH:
				return getCommRcvOvh();
			case GQAMPackage.GA_EXEC_HOST__CNTXT_SW_T:
				return getCntxtSwT();
			case GQAMPackage.GA_EXEC_HOST__CLOCK_OVH:
				return getClockOvh();
			case GQAMPackage.GA_EXEC_HOST__SCHED_PRI_RANGE:
				return getSchedPriRange();
			case GQAMPackage.GA_EXEC_HOST__MEM_SIZE:
				return getMemSize();
			case GQAMPackage.GA_EXEC_HOST__UTILIZATION:
				return getUtilization();
			case GQAMPackage.GA_EXEC_HOST__THROUGHPUT:
				return getThroughput();
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
			case GQAMPackage.GA_EXEC_HOST__SPEED_FACTOR:
				setSpeedFactor((String)newValue);
				return;
			case GQAMPackage.GA_EXEC_HOST__MAIN_SCHEDULER:
				setMainScheduler((Scheduler)newValue);
				return;
			case GQAMPackage.GA_EXEC_HOST__COMM_TX_OVH:
				setCommTxOvh((String)newValue);
				return;
			case GQAMPackage.GA_EXEC_HOST__COMM_RCV_OVH:
				setCommRcvOvh((String)newValue);
				return;
			case GQAMPackage.GA_EXEC_HOST__CNTXT_SW_T:
				setCntxtSwT((String)newValue);
				return;
			case GQAMPackage.GA_EXEC_HOST__CLOCK_OVH:
				setClockOvh((String)newValue);
				return;
			case GQAMPackage.GA_EXEC_HOST__SCHED_PRI_RANGE:
				setSchedPriRange((String)newValue);
				return;
			case GQAMPackage.GA_EXEC_HOST__MEM_SIZE:
				setMemSize((String)newValue);
				return;
			case GQAMPackage.GA_EXEC_HOST__UTILIZATION:
				getUtilization().clear();
				getUtilization().addAll((Collection<? extends String>)newValue);
				return;
			case GQAMPackage.GA_EXEC_HOST__THROUGHPUT:
				getThroughput().clear();
				getThroughput().addAll((Collection<? extends String>)newValue);
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
			case GQAMPackage.GA_EXEC_HOST__SPEED_FACTOR:
				setSpeedFactor(SPEED_FACTOR_EDEFAULT);
				return;
			case GQAMPackage.GA_EXEC_HOST__MAIN_SCHEDULER:
				setMainScheduler((Scheduler)null);
				return;
			case GQAMPackage.GA_EXEC_HOST__COMM_TX_OVH:
				setCommTxOvh(COMM_TX_OVH_EDEFAULT);
				return;
			case GQAMPackage.GA_EXEC_HOST__COMM_RCV_OVH:
				setCommRcvOvh(COMM_RCV_OVH_EDEFAULT);
				return;
			case GQAMPackage.GA_EXEC_HOST__CNTXT_SW_T:
				setCntxtSwT(CNTXT_SW_T_EDEFAULT);
				return;
			case GQAMPackage.GA_EXEC_HOST__CLOCK_OVH:
				setClockOvh(CLOCK_OVH_EDEFAULT);
				return;
			case GQAMPackage.GA_EXEC_HOST__SCHED_PRI_RANGE:
				setSchedPriRange(SCHED_PRI_RANGE_EDEFAULT);
				return;
			case GQAMPackage.GA_EXEC_HOST__MEM_SIZE:
				setMemSize(MEM_SIZE_EDEFAULT);
				return;
			case GQAMPackage.GA_EXEC_HOST__UTILIZATION:
				getUtilization().clear();
				return;
			case GQAMPackage.GA_EXEC_HOST__THROUGHPUT:
				getThroughput().clear();
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
			case GQAMPackage.GA_EXEC_HOST__SPEED_FACTOR:
				return SPEED_FACTOR_EDEFAULT == null ? speedFactor != null : !SPEED_FACTOR_EDEFAULT.equals(speedFactor);
			case GQAMPackage.GA_EXEC_HOST__MAIN_SCHEDULER:
				return mainScheduler != null;
			case GQAMPackage.GA_EXEC_HOST__COMM_TX_OVH:
				return COMM_TX_OVH_EDEFAULT == null ? commTxOvh != null : !COMM_TX_OVH_EDEFAULT.equals(commTxOvh);
			case GQAMPackage.GA_EXEC_HOST__COMM_RCV_OVH:
				return COMM_RCV_OVH_EDEFAULT == null ? commRcvOvh != null : !COMM_RCV_OVH_EDEFAULT.equals(commRcvOvh);
			case GQAMPackage.GA_EXEC_HOST__CNTXT_SW_T:
				return CNTXT_SW_T_EDEFAULT == null ? cntxtSwT != null : !CNTXT_SW_T_EDEFAULT.equals(cntxtSwT);
			case GQAMPackage.GA_EXEC_HOST__CLOCK_OVH:
				return CLOCK_OVH_EDEFAULT == null ? clockOvh != null : !CLOCK_OVH_EDEFAULT.equals(clockOvh);
			case GQAMPackage.GA_EXEC_HOST__SCHED_PRI_RANGE:
				return SCHED_PRI_RANGE_EDEFAULT == null ? schedPriRange != null : !SCHED_PRI_RANGE_EDEFAULT.equals(schedPriRange);
			case GQAMPackage.GA_EXEC_HOST__MEM_SIZE:
				return MEM_SIZE_EDEFAULT == null ? memSize != null : !MEM_SIZE_EDEFAULT.equals(memSize);
			case GQAMPackage.GA_EXEC_HOST__UTILIZATION:
				return utilization != null && !utilization.isEmpty();
			case GQAMPackage.GA_EXEC_HOST__THROUGHPUT:
				return throughput != null && !throughput.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ProcessingResource.class) {
			switch (derivedFeatureID) {
				case GQAMPackage.GA_EXEC_HOST__SPEED_FACTOR: return GRMPackage.PROCESSING_RESOURCE__SPEED_FACTOR;
				case GQAMPackage.GA_EXEC_HOST__MAIN_SCHEDULER: return GRMPackage.PROCESSING_RESOURCE__MAIN_SCHEDULER;
				default: return -1;
			}
		}
		if (baseClass == ComputingResource.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ProcessingResource.class) {
			switch (baseFeatureID) {
				case GRMPackage.PROCESSING_RESOURCE__SPEED_FACTOR: return GQAMPackage.GA_EXEC_HOST__SPEED_FACTOR;
				case GRMPackage.PROCESSING_RESOURCE__MAIN_SCHEDULER: return GQAMPackage.GA_EXEC_HOST__MAIN_SCHEDULER;
				default: return -1;
			}
		}
		if (baseClass == ComputingResource.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (speedFactor: ");
		result.append(speedFactor);
		result.append(", commTxOvh: ");
		result.append(commTxOvh);
		result.append(", commRcvOvh: ");
		result.append(commRcvOvh);
		result.append(", cntxtSwT: ");
		result.append(cntxtSwT);
		result.append(", clockOvh: ");
		result.append(clockOvh);
		result.append(", schedPriRange: ");
		result.append(schedPriRange);
		result.append(", memSize: ");
		result.append(memSize);
		result.append(", utilization: ");
		result.append(utilization);
		result.append(", throughput: ");
		result.append(throughput);
		result.append(')');
		return result.toString();
	}

} //GaExecHostImpl
