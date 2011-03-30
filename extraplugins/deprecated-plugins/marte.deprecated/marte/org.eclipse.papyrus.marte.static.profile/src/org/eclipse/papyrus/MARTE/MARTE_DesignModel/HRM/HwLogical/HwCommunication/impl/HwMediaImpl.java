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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwGeneralPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResourceService;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwArbiter;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwEndPoint;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwMedia;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationMediaImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Media</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwMediaImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwMediaImpl#getP_HW_Services <em>PHW Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwMediaImpl#getR_HW_Services <em>RHW Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwMediaImpl#getOwnedHW <em>Owned HW</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwMediaImpl#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwMediaImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwMediaImpl#getBandWidth <em>Band Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwMediaImpl#getArbiters <em>Arbiters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwMediaImpl extends CommunicationMediaImpl implements HwMedia {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getP_HW_Services() <em>PHW Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getP_HW_Services()
	 * @generated
	 * @ordered
	 */
	protected EList<HwResourceService> p_HW_Services;

	/**
	 * The cached value of the '{@link #getR_HW_Services() <em>RHW Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR_HW_Services()
	 * @generated
	 * @ordered
	 */
	protected EList<HwResourceService> r_HW_Services;

	/**
	 * The cached value of the '{@link #getOwnedHW() <em>Owned HW</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedHW()
	 * @generated
	 * @ordered
	 */
	protected EList<HwResource> ownedHW;

	/**
	 * The cached value of the '{@link #getEndPoints() <em>End Points</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<HwEndPoint> endPoints;

	/**
	 * The default value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final String FREQUENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected String frequency = FREQUENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBandWidth() <em>Band Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBandWidth()
	 * @generated
	 * @ordered
	 */
	protected static final String BAND_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBandWidth() <em>Band Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBandWidth()
	 * @generated
	 * @ordered
	 */
	protected String bandWidth = BAND_WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArbiters() <em>Arbiters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArbiters()
	 * @generated
	 * @ordered
	 */
	protected EList<HwArbiter> arbiters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwMediaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwCommunicationPackage.Literals.HW_MEDIA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwCommunicationPackage.HW_MEDIA__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwResourceService> getP_HW_Services() {
		if (p_HW_Services == null) {
			p_HW_Services = new EObjectContainmentEList<HwResourceService>(HwResourceService.class, this, HwCommunicationPackage.HW_MEDIA__PHW_SERVICES);
		}
		return p_HW_Services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwResourceService> getR_HW_Services() {
		if (r_HW_Services == null) {
			r_HW_Services = new EObjectResolvingEList<HwResourceService>(HwResourceService.class, this, HwCommunicationPackage.HW_MEDIA__RHW_SERVICES);
		}
		return r_HW_Services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwResource> getOwnedHW() {
		if (ownedHW == null) {
			ownedHW = new EObjectContainmentEList<HwResource>(HwResource.class, this, HwCommunicationPackage.HW_MEDIA__OWNED_HW);
		}
		return ownedHW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwEndPoint> getEndPoints() {
		if (endPoints == null) {
			endPoints = new EObjectResolvingEList<HwEndPoint>(HwEndPoint.class, this, HwCommunicationPackage.HW_MEDIA__END_POINTS);
		}
		return endPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrequency(String newFrequency) {
		String oldFrequency = frequency;
		frequency = newFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwCommunicationPackage.HW_MEDIA__FREQUENCY, oldFrequency, frequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBandWidth() {
		return bandWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBandWidth(String newBandWidth) {
		String oldBandWidth = bandWidth;
		bandWidth = newBandWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwCommunicationPackage.HW_MEDIA__BAND_WIDTH, oldBandWidth, bandWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwArbiter> getArbiters() {
		if (arbiters == null) {
			arbiters = new EObjectWithInverseResolvingEList.ManyInverse<HwArbiter>(HwArbiter.class, this, HwCommunicationPackage.HW_MEDIA__ARBITERS, HwCommunicationPackage.HW_ARBITER__CONTROLLED_MEDIAS);
		}
		return arbiters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HwCommunicationPackage.HW_MEDIA__ARBITERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArbiters()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HwCommunicationPackage.HW_MEDIA__PHW_SERVICES:
				return ((InternalEList<?>)getP_HW_Services()).basicRemove(otherEnd, msgs);
			case HwCommunicationPackage.HW_MEDIA__OWNED_HW:
				return ((InternalEList<?>)getOwnedHW()).basicRemove(otherEnd, msgs);
			case HwCommunicationPackage.HW_MEDIA__ARBITERS:
				return ((InternalEList<?>)getArbiters()).basicRemove(otherEnd, msgs);
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
			case HwCommunicationPackage.HW_MEDIA__DESCRIPTION:
				return getDescription();
			case HwCommunicationPackage.HW_MEDIA__PHW_SERVICES:
				return getP_HW_Services();
			case HwCommunicationPackage.HW_MEDIA__RHW_SERVICES:
				return getR_HW_Services();
			case HwCommunicationPackage.HW_MEDIA__OWNED_HW:
				return getOwnedHW();
			case HwCommunicationPackage.HW_MEDIA__END_POINTS:
				return getEndPoints();
			case HwCommunicationPackage.HW_MEDIA__FREQUENCY:
				return getFrequency();
			case HwCommunicationPackage.HW_MEDIA__BAND_WIDTH:
				return getBandWidth();
			case HwCommunicationPackage.HW_MEDIA__ARBITERS:
				return getArbiters();
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
			case HwCommunicationPackage.HW_MEDIA__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case HwCommunicationPackage.HW_MEDIA__PHW_SERVICES:
				getP_HW_Services().clear();
				getP_HW_Services().addAll((Collection<? extends HwResourceService>)newValue);
				return;
			case HwCommunicationPackage.HW_MEDIA__RHW_SERVICES:
				getR_HW_Services().clear();
				getR_HW_Services().addAll((Collection<? extends HwResourceService>)newValue);
				return;
			case HwCommunicationPackage.HW_MEDIA__OWNED_HW:
				getOwnedHW().clear();
				getOwnedHW().addAll((Collection<? extends HwResource>)newValue);
				return;
			case HwCommunicationPackage.HW_MEDIA__END_POINTS:
				getEndPoints().clear();
				getEndPoints().addAll((Collection<? extends HwEndPoint>)newValue);
				return;
			case HwCommunicationPackage.HW_MEDIA__FREQUENCY:
				setFrequency((String)newValue);
				return;
			case HwCommunicationPackage.HW_MEDIA__BAND_WIDTH:
				setBandWidth((String)newValue);
				return;
			case HwCommunicationPackage.HW_MEDIA__ARBITERS:
				getArbiters().clear();
				getArbiters().addAll((Collection<? extends HwArbiter>)newValue);
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
			case HwCommunicationPackage.HW_MEDIA__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case HwCommunicationPackage.HW_MEDIA__PHW_SERVICES:
				getP_HW_Services().clear();
				return;
			case HwCommunicationPackage.HW_MEDIA__RHW_SERVICES:
				getR_HW_Services().clear();
				return;
			case HwCommunicationPackage.HW_MEDIA__OWNED_HW:
				getOwnedHW().clear();
				return;
			case HwCommunicationPackage.HW_MEDIA__END_POINTS:
				getEndPoints().clear();
				return;
			case HwCommunicationPackage.HW_MEDIA__FREQUENCY:
				setFrequency(FREQUENCY_EDEFAULT);
				return;
			case HwCommunicationPackage.HW_MEDIA__BAND_WIDTH:
				setBandWidth(BAND_WIDTH_EDEFAULT);
				return;
			case HwCommunicationPackage.HW_MEDIA__ARBITERS:
				getArbiters().clear();
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
			case HwCommunicationPackage.HW_MEDIA__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case HwCommunicationPackage.HW_MEDIA__PHW_SERVICES:
				return p_HW_Services != null && !p_HW_Services.isEmpty();
			case HwCommunicationPackage.HW_MEDIA__RHW_SERVICES:
				return r_HW_Services != null && !r_HW_Services.isEmpty();
			case HwCommunicationPackage.HW_MEDIA__OWNED_HW:
				return ownedHW != null && !ownedHW.isEmpty();
			case HwCommunicationPackage.HW_MEDIA__END_POINTS:
				return endPoints != null && !endPoints.isEmpty();
			case HwCommunicationPackage.HW_MEDIA__FREQUENCY:
				return FREQUENCY_EDEFAULT == null ? frequency != null : !FREQUENCY_EDEFAULT.equals(frequency);
			case HwCommunicationPackage.HW_MEDIA__BAND_WIDTH:
				return BAND_WIDTH_EDEFAULT == null ? bandWidth != null : !BAND_WIDTH_EDEFAULT.equals(bandWidth);
			case HwCommunicationPackage.HW_MEDIA__ARBITERS:
				return arbiters != null && !arbiters.isEmpty();
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
		if (baseClass == HwResource.class) {
			switch (derivedFeatureID) {
				case HwCommunicationPackage.HW_MEDIA__DESCRIPTION: return HwGeneralPackage.HW_RESOURCE__DESCRIPTION;
				case HwCommunicationPackage.HW_MEDIA__PHW_SERVICES: return HwGeneralPackage.HW_RESOURCE__PHW_SERVICES;
				case HwCommunicationPackage.HW_MEDIA__RHW_SERVICES: return HwGeneralPackage.HW_RESOURCE__RHW_SERVICES;
				case HwCommunicationPackage.HW_MEDIA__OWNED_HW: return HwGeneralPackage.HW_RESOURCE__OWNED_HW;
				case HwCommunicationPackage.HW_MEDIA__END_POINTS: return HwGeneralPackage.HW_RESOURCE__END_POINTS;
				case HwCommunicationPackage.HW_MEDIA__FREQUENCY: return HwGeneralPackage.HW_RESOURCE__FREQUENCY;
				default: return -1;
			}
		}
		if (baseClass == HwCommunicationResource.class) {
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
		if (baseClass == HwResource.class) {
			switch (baseFeatureID) {
				case HwGeneralPackage.HW_RESOURCE__DESCRIPTION: return HwCommunicationPackage.HW_MEDIA__DESCRIPTION;
				case HwGeneralPackage.HW_RESOURCE__PHW_SERVICES: return HwCommunicationPackage.HW_MEDIA__PHW_SERVICES;
				case HwGeneralPackage.HW_RESOURCE__RHW_SERVICES: return HwCommunicationPackage.HW_MEDIA__RHW_SERVICES;
				case HwGeneralPackage.HW_RESOURCE__OWNED_HW: return HwCommunicationPackage.HW_MEDIA__OWNED_HW;
				case HwGeneralPackage.HW_RESOURCE__END_POINTS: return HwCommunicationPackage.HW_MEDIA__END_POINTS;
				case HwGeneralPackage.HW_RESOURCE__FREQUENCY: return HwCommunicationPackage.HW_MEDIA__FREQUENCY;
				default: return -1;
			}
		}
		if (baseClass == HwCommunicationResource.class) {
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
		result.append(" (description: ");
		result.append(description);
		result.append(", frequency: ");
		result.append(frequency);
		result.append(", bandWidth: ");
		result.append(bandWidth);
		result.append(')');
		return result.toString();
	}

} //HwMediaImpl
