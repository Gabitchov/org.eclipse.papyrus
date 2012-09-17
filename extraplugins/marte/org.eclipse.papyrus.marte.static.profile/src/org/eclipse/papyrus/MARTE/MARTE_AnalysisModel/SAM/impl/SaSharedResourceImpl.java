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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.MutualExclusionResourceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sa Shared Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSharedResourceImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSharedResourceImpl#getIsPreemp <em>Is Preemp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSharedResourceImpl#getIsConsum <em>Is Consum</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSharedResourceImpl#getAcquisT <em>Acquis T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSharedResourceImpl#getReleaseT <em>Release T</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaSharedResourceImpl extends MutualExclusionResourceImpl implements SaSharedResource {
	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final String CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected String capacity = CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsPreemp() <em>Is Preemp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsPreemp()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_PREEMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsPreemp() <em>Is Preemp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsPreemp()
	 * @generated
	 * @ordered
	 */
	protected String isPreemp = IS_PREEMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsConsum() <em>Is Consum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsConsum()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_CONSUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsConsum() <em>Is Consum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsConsum()
	 * @generated
	 * @ordered
	 */
	protected String isConsum = IS_CONSUM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAcquisT() <em>Acquis T</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcquisT()
	 * @generated
	 * @ordered
	 */
	protected EList<String> acquisT;

	/**
	 * The cached value of the '{@link #getReleaseT() <em>Release T</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseT()
	 * @generated
	 * @ordered
	 */
	protected EList<String> releaseT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaSharedResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SAMPackage.Literals.SA_SHARED_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacity(String newCapacity) {
		String oldCapacity = capacity;
		capacity = newCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_SHARED_RESOURCE__CAPACITY, oldCapacity, capacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsPreemp() {
		return isPreemp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPreemp(String newIsPreemp) {
		String oldIsPreemp = isPreemp;
		isPreemp = newIsPreemp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_SHARED_RESOURCE__IS_PREEMP, oldIsPreemp, isPreemp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsConsum() {
		return isConsum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsConsum(String newIsConsum) {
		String oldIsConsum = isConsum;
		isConsum = newIsConsum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_SHARED_RESOURCE__IS_CONSUM, oldIsConsum, isConsum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAcquisT() {
		if (acquisT == null) {
			acquisT = new EDataTypeUniqueEList<String>(String.class, this, SAMPackage.SA_SHARED_RESOURCE__ACQUIS_T);
		}
		return acquisT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getReleaseT() {
		if (releaseT == null) {
			releaseT = new EDataTypeUniqueEList<String>(String.class, this, SAMPackage.SA_SHARED_RESOURCE__RELEASE_T);
		}
		return releaseT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SAMPackage.SA_SHARED_RESOURCE__CAPACITY:
				return getCapacity();
			case SAMPackage.SA_SHARED_RESOURCE__IS_PREEMP:
				return getIsPreemp();
			case SAMPackage.SA_SHARED_RESOURCE__IS_CONSUM:
				return getIsConsum();
			case SAMPackage.SA_SHARED_RESOURCE__ACQUIS_T:
				return getAcquisT();
			case SAMPackage.SA_SHARED_RESOURCE__RELEASE_T:
				return getReleaseT();
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
			case SAMPackage.SA_SHARED_RESOURCE__CAPACITY:
				setCapacity((String)newValue);
				return;
			case SAMPackage.SA_SHARED_RESOURCE__IS_PREEMP:
				setIsPreemp((String)newValue);
				return;
			case SAMPackage.SA_SHARED_RESOURCE__IS_CONSUM:
				setIsConsum((String)newValue);
				return;
			case SAMPackage.SA_SHARED_RESOURCE__ACQUIS_T:
				getAcquisT().clear();
				getAcquisT().addAll((Collection<? extends String>)newValue);
				return;
			case SAMPackage.SA_SHARED_RESOURCE__RELEASE_T:
				getReleaseT().clear();
				getReleaseT().addAll((Collection<? extends String>)newValue);
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
			case SAMPackage.SA_SHARED_RESOURCE__CAPACITY:
				setCapacity(CAPACITY_EDEFAULT);
				return;
			case SAMPackage.SA_SHARED_RESOURCE__IS_PREEMP:
				setIsPreemp(IS_PREEMP_EDEFAULT);
				return;
			case SAMPackage.SA_SHARED_RESOURCE__IS_CONSUM:
				setIsConsum(IS_CONSUM_EDEFAULT);
				return;
			case SAMPackage.SA_SHARED_RESOURCE__ACQUIS_T:
				getAcquisT().clear();
				return;
			case SAMPackage.SA_SHARED_RESOURCE__RELEASE_T:
				getReleaseT().clear();
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
			case SAMPackage.SA_SHARED_RESOURCE__CAPACITY:
				return CAPACITY_EDEFAULT == null ? capacity != null : !CAPACITY_EDEFAULT.equals(capacity);
			case SAMPackage.SA_SHARED_RESOURCE__IS_PREEMP:
				return IS_PREEMP_EDEFAULT == null ? isPreemp != null : !IS_PREEMP_EDEFAULT.equals(isPreemp);
			case SAMPackage.SA_SHARED_RESOURCE__IS_CONSUM:
				return IS_CONSUM_EDEFAULT == null ? isConsum != null : !IS_CONSUM_EDEFAULT.equals(isConsum);
			case SAMPackage.SA_SHARED_RESOURCE__ACQUIS_T:
				return acquisT != null && !acquisT.isEmpty();
			case SAMPackage.SA_SHARED_RESOURCE__RELEASE_T:
				return releaseT != null && !releaseT.isEmpty();
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
		result.append(" (capacity: ");
		result.append(capacity);
		result.append(", isPreemp: ");
		result.append(isPreemp);
		result.append(", isConsum: ");
		result.append(isConsum);
		result.append(", acquisT: ");
		result.append(acquisT);
		result.append(", releaseT: ");
		result.append(releaseT);
		result.append(')');
		return result.toString();
	}

} //SaSharedResourceImpl
