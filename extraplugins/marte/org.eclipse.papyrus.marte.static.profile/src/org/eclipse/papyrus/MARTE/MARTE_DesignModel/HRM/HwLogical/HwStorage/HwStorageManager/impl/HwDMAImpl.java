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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwArbiter;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwMedia;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwDMA;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwStorageManagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw DMA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwDMAImpl#getControlledMedias <em>Controlled Medias</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwDMAImpl#getNbChannels <em>Nb Channels</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwDMAImpl#getTransferWidth <em>Transfer Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwDMAImpl#getDrivenBy <em>Driven By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwDMAImpl extends HwStorageManagerImpl implements HwDMA {
	/**
	 * The cached value of the '{@link #getControlledMedias() <em>Controlled Medias</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlledMedias()
	 * @generated
	 * @ordered
	 */
	protected EList<HwMedia> controlledMedias;

	/**
	 * The default value of the '{@link #getNbChannels() <em>Nb Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbChannels()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_CHANNELS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbChannels() <em>Nb Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbChannels()
	 * @generated
	 * @ordered
	 */
	protected String nbChannels = NB_CHANNELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransferWidth() <em>Transfer Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransferWidth()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSFER_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransferWidth() <em>Transfer Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransferWidth()
	 * @generated
	 * @ordered
	 */
	protected String transferWidth = TRANSFER_WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDrivenBy() <em>Driven By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrivenBy()
	 * @generated
	 * @ordered
	 */
	protected EList<HwProcessor> drivenBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwDMAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwStorageManagerPackage.Literals.HW_DMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwMedia> getControlledMedias() {
		if (controlledMedias == null) {
			controlledMedias = new EObjectWithInverseResolvingEList.ManyInverse<HwMedia>(HwMedia.class, this, HwStorageManagerPackage.HW_DMA__CONTROLLED_MEDIAS, HwCommunicationPackage.HW_MEDIA__ARBITERS);
		}
		return controlledMedias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbChannels() {
		return nbChannels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbChannels(String newNbChannels) {
		String oldNbChannels = nbChannels;
		nbChannels = newNbChannels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwStorageManagerPackage.HW_DMA__NB_CHANNELS, oldNbChannels, nbChannels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransferWidth() {
		return transferWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransferWidth(String newTransferWidth) {
		String oldTransferWidth = transferWidth;
		transferWidth = newTransferWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwStorageManagerPackage.HW_DMA__TRANSFER_WIDTH, oldTransferWidth, transferWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwProcessor> getDrivenBy() {
		if (drivenBy == null) {
			drivenBy = new EObjectResolvingEList<HwProcessor>(HwProcessor.class, this, HwStorageManagerPackage.HW_DMA__DRIVEN_BY);
		}
		return drivenBy;
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
			case HwStorageManagerPackage.HW_DMA__CONTROLLED_MEDIAS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getControlledMedias()).basicAdd(otherEnd, msgs);
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
			case HwStorageManagerPackage.HW_DMA__CONTROLLED_MEDIAS:
				return ((InternalEList<?>)getControlledMedias()).basicRemove(otherEnd, msgs);
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
			case HwStorageManagerPackage.HW_DMA__CONTROLLED_MEDIAS:
				return getControlledMedias();
			case HwStorageManagerPackage.HW_DMA__NB_CHANNELS:
				return getNbChannels();
			case HwStorageManagerPackage.HW_DMA__TRANSFER_WIDTH:
				return getTransferWidth();
			case HwStorageManagerPackage.HW_DMA__DRIVEN_BY:
				return getDrivenBy();
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
			case HwStorageManagerPackage.HW_DMA__CONTROLLED_MEDIAS:
				getControlledMedias().clear();
				getControlledMedias().addAll((Collection<? extends HwMedia>)newValue);
				return;
			case HwStorageManagerPackage.HW_DMA__NB_CHANNELS:
				setNbChannels((String)newValue);
				return;
			case HwStorageManagerPackage.HW_DMA__TRANSFER_WIDTH:
				setTransferWidth((String)newValue);
				return;
			case HwStorageManagerPackage.HW_DMA__DRIVEN_BY:
				getDrivenBy().clear();
				getDrivenBy().addAll((Collection<? extends HwProcessor>)newValue);
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
			case HwStorageManagerPackage.HW_DMA__CONTROLLED_MEDIAS:
				getControlledMedias().clear();
				return;
			case HwStorageManagerPackage.HW_DMA__NB_CHANNELS:
				setNbChannels(NB_CHANNELS_EDEFAULT);
				return;
			case HwStorageManagerPackage.HW_DMA__TRANSFER_WIDTH:
				setTransferWidth(TRANSFER_WIDTH_EDEFAULT);
				return;
			case HwStorageManagerPackage.HW_DMA__DRIVEN_BY:
				getDrivenBy().clear();
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
			case HwStorageManagerPackage.HW_DMA__CONTROLLED_MEDIAS:
				return controlledMedias != null && !controlledMedias.isEmpty();
			case HwStorageManagerPackage.HW_DMA__NB_CHANNELS:
				return NB_CHANNELS_EDEFAULT == null ? nbChannels != null : !NB_CHANNELS_EDEFAULT.equals(nbChannels);
			case HwStorageManagerPackage.HW_DMA__TRANSFER_WIDTH:
				return TRANSFER_WIDTH_EDEFAULT == null ? transferWidth != null : !TRANSFER_WIDTH_EDEFAULT.equals(transferWidth);
			case HwStorageManagerPackage.HW_DMA__DRIVEN_BY:
				return drivenBy != null && !drivenBy.isEmpty();
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
		if (baseClass == HwCommunicationResource.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HwArbiter.class) {
			switch (derivedFeatureID) {
				case HwStorageManagerPackage.HW_DMA__CONTROLLED_MEDIAS: return HwCommunicationPackage.HW_ARBITER__CONTROLLED_MEDIAS;
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
		if (baseClass == HwCommunicationResource.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HwArbiter.class) {
			switch (baseFeatureID) {
				case HwCommunicationPackage.HW_ARBITER__CONTROLLED_MEDIAS: return HwStorageManagerPackage.HW_DMA__CONTROLLED_MEDIAS;
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
		result.append(" (nbChannels: ");
		result.append(nbChannels);
		result.append(", transferWidth: ");
		result.append(transferWidth);
		result.append(')');
		return result.toString();
	}

} //HwDMAImpl
