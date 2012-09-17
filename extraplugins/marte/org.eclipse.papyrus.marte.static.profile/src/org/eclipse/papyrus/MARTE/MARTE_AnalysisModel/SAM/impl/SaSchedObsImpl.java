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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaTimedObsImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sa Sched Obs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSchedObsImpl#getSuspentions <em>Suspentions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSchedObsImpl#getBlockT <em>Block T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSchedObsImpl#getOverlaps <em>Overlaps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaSchedObsImpl extends GaTimedObsImpl implements SaSchedObs {
	/**
	 * The cached value of the '{@link #getSuspentions() <em>Suspentions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspentions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> suspentions;

	/**
	 * The cached value of the '{@link #getBlockT() <em>Block T</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockT()
	 * @generated
	 * @ordered
	 */
	protected EList<String> blockT;

	/**
	 * The cached value of the '{@link #getOverlaps() <em>Overlaps</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverlaps()
	 * @generated
	 * @ordered
	 */
	protected EList<String> overlaps;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaSchedObsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SAMPackage.Literals.SA_SCHED_OBS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSuspentions() {
		if (suspentions == null) {
			suspentions = new EDataTypeUniqueEList<String>(String.class, this, SAMPackage.SA_SCHED_OBS__SUSPENTIONS);
		}
		return suspentions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBlockT() {
		if (blockT == null) {
			blockT = new EDataTypeUniqueEList<String>(String.class, this, SAMPackage.SA_SCHED_OBS__BLOCK_T);
		}
		return blockT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOverlaps() {
		if (overlaps == null) {
			overlaps = new EDataTypeUniqueEList<String>(String.class, this, SAMPackage.SA_SCHED_OBS__OVERLAPS);
		}
		return overlaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SAMPackage.SA_SCHED_OBS__SUSPENTIONS:
				return getSuspentions();
			case SAMPackage.SA_SCHED_OBS__BLOCK_T:
				return getBlockT();
			case SAMPackage.SA_SCHED_OBS__OVERLAPS:
				return getOverlaps();
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
			case SAMPackage.SA_SCHED_OBS__SUSPENTIONS:
				getSuspentions().clear();
				getSuspentions().addAll((Collection<? extends String>)newValue);
				return;
			case SAMPackage.SA_SCHED_OBS__BLOCK_T:
				getBlockT().clear();
				getBlockT().addAll((Collection<? extends String>)newValue);
				return;
			case SAMPackage.SA_SCHED_OBS__OVERLAPS:
				getOverlaps().clear();
				getOverlaps().addAll((Collection<? extends String>)newValue);
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
			case SAMPackage.SA_SCHED_OBS__SUSPENTIONS:
				getSuspentions().clear();
				return;
			case SAMPackage.SA_SCHED_OBS__BLOCK_T:
				getBlockT().clear();
				return;
			case SAMPackage.SA_SCHED_OBS__OVERLAPS:
				getOverlaps().clear();
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
			case SAMPackage.SA_SCHED_OBS__SUSPENTIONS:
				return suspentions != null && !suspentions.isEmpty();
			case SAMPackage.SA_SCHED_OBS__BLOCK_T:
				return blockT != null && !blockT.isEmpty();
			case SAMPackage.SA_SCHED_OBS__OVERLAPS:
				return overlaps != null && !overlaps.isEmpty();
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
		result.append(" (suspentions: ");
		result.append(suspentions);
		result.append(", blockT: ");
		result.append(blockT);
		result.append(", overlaps: ");
		result.append(overlaps);
		result.append(')');
		return result.toString();
	}

} //SaSchedObsImpl
