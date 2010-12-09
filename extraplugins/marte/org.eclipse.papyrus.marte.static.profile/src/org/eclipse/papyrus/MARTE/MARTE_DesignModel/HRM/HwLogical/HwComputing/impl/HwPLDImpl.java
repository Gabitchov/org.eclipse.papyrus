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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.PLD_Technology;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwRAM;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw PLD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwPLDImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwPLDImpl#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwPLDImpl#getNbLUTs <em>Nb LU Ts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwPLDImpl#getNdLUT_Inputs <em>Nd LUT Inputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwPLDImpl#getNbFlipFlops <em>Nb Flip Flops</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwPLDImpl#getBlocksRAM <em>Blocks RAM</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwPLDImpl#getBlocksComputing <em>Blocks Computing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwPLDImpl extends HwComputingResourceImpl implements HwPLD {
	/**
	 * The default value of the '{@link #getTechnology() <em>Technology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnology()
	 * @generated
	 * @ordered
	 */
	protected static final PLD_Technology TECHNOLOGY_EDEFAULT = PLD_Technology.SRAM;

	/**
	 * The cached value of the '{@link #getTechnology() <em>Technology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnology()
	 * @generated
	 * @ordered
	 */
	protected PLD_Technology technology = TECHNOLOGY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrganization() <em>Organization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganization()
	 * @generated
	 * @ordered
	 */
	protected static final String ORGANIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrganization() <em>Organization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganization()
	 * @generated
	 * @ordered
	 */
	protected String organization = ORGANIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbLUTs() <em>Nb LU Ts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbLUTs()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_LU_TS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbLUTs() <em>Nb LU Ts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbLUTs()
	 * @generated
	 * @ordered
	 */
	protected String nbLUTs = NB_LU_TS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNdLUT_Inputs() <em>Nd LUT Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNdLUT_Inputs()
	 * @generated
	 * @ordered
	 */
	protected static final String ND_LUT_INPUTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNdLUT_Inputs() <em>Nd LUT Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNdLUT_Inputs()
	 * @generated
	 * @ordered
	 */
	protected String ndLUT_Inputs = ND_LUT_INPUTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbFlipFlops() <em>Nb Flip Flops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbFlipFlops()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_FLIP_FLOPS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbFlipFlops() <em>Nb Flip Flops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbFlipFlops()
	 * @generated
	 * @ordered
	 */
	protected String nbFlipFlops = NB_FLIP_FLOPS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBlocksRAM() <em>Blocks RAM</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocksRAM()
	 * @generated
	 * @ordered
	 */
	protected EList<HwRAM> blocksRAM;

	/**
	 * The cached value of the '{@link #getBlocksComputing() <em>Blocks Computing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocksComputing()
	 * @generated
	 * @ordered
	 */
	protected EList<HwComputingResource> blocksComputing;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwPLDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwComputingPackage.Literals.HW_PLD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PLD_Technology getTechnology() {
		return technology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTechnology(PLD_Technology newTechnology) {
		PLD_Technology oldTechnology = technology;
		technology = newTechnology == null ? TECHNOLOGY_EDEFAULT : newTechnology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PLD__TECHNOLOGY, oldTechnology, technology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrganization(String newOrganization) {
		String oldOrganization = organization;
		organization = newOrganization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PLD__ORGANIZATION, oldOrganization, organization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbLUTs() {
		return nbLUTs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbLUTs(String newNbLUTs) {
		String oldNbLUTs = nbLUTs;
		nbLUTs = newNbLUTs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PLD__NB_LU_TS, oldNbLUTs, nbLUTs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNdLUT_Inputs() {
		return ndLUT_Inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNdLUT_Inputs(String newNdLUT_Inputs) {
		String oldNdLUT_Inputs = ndLUT_Inputs;
		ndLUT_Inputs = newNdLUT_Inputs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PLD__ND_LUT_INPUTS, oldNdLUT_Inputs, ndLUT_Inputs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbFlipFlops() {
		return nbFlipFlops;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbFlipFlops(String newNbFlipFlops) {
		String oldNbFlipFlops = nbFlipFlops;
		nbFlipFlops = newNbFlipFlops;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PLD__NB_FLIP_FLOPS, oldNbFlipFlops, nbFlipFlops));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwRAM> getBlocksRAM() {
		if (blocksRAM == null) {
			blocksRAM = new EObjectResolvingEList<HwRAM>(HwRAM.class, this, HwComputingPackage.HW_PLD__BLOCKS_RAM);
		}
		return blocksRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwComputingResource> getBlocksComputing() {
		if (blocksComputing == null) {
			blocksComputing = new EObjectResolvingEList<HwComputingResource>(HwComputingResource.class, this, HwComputingPackage.HW_PLD__BLOCKS_COMPUTING);
		}
		return blocksComputing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwComputingPackage.HW_PLD__TECHNOLOGY:
				return getTechnology();
			case HwComputingPackage.HW_PLD__ORGANIZATION:
				return getOrganization();
			case HwComputingPackage.HW_PLD__NB_LU_TS:
				return getNbLUTs();
			case HwComputingPackage.HW_PLD__ND_LUT_INPUTS:
				return getNdLUT_Inputs();
			case HwComputingPackage.HW_PLD__NB_FLIP_FLOPS:
				return getNbFlipFlops();
			case HwComputingPackage.HW_PLD__BLOCKS_RAM:
				return getBlocksRAM();
			case HwComputingPackage.HW_PLD__BLOCKS_COMPUTING:
				return getBlocksComputing();
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
			case HwComputingPackage.HW_PLD__TECHNOLOGY:
				setTechnology((PLD_Technology)newValue);
				return;
			case HwComputingPackage.HW_PLD__ORGANIZATION:
				setOrganization((String)newValue);
				return;
			case HwComputingPackage.HW_PLD__NB_LU_TS:
				setNbLUTs((String)newValue);
				return;
			case HwComputingPackage.HW_PLD__ND_LUT_INPUTS:
				setNdLUT_Inputs((String)newValue);
				return;
			case HwComputingPackage.HW_PLD__NB_FLIP_FLOPS:
				setNbFlipFlops((String)newValue);
				return;
			case HwComputingPackage.HW_PLD__BLOCKS_RAM:
				getBlocksRAM().clear();
				getBlocksRAM().addAll((Collection<? extends HwRAM>)newValue);
				return;
			case HwComputingPackage.HW_PLD__BLOCKS_COMPUTING:
				getBlocksComputing().clear();
				getBlocksComputing().addAll((Collection<? extends HwComputingResource>)newValue);
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
			case HwComputingPackage.HW_PLD__TECHNOLOGY:
				setTechnology(TECHNOLOGY_EDEFAULT);
				return;
			case HwComputingPackage.HW_PLD__ORGANIZATION:
				setOrganization(ORGANIZATION_EDEFAULT);
				return;
			case HwComputingPackage.HW_PLD__NB_LU_TS:
				setNbLUTs(NB_LU_TS_EDEFAULT);
				return;
			case HwComputingPackage.HW_PLD__ND_LUT_INPUTS:
				setNdLUT_Inputs(ND_LUT_INPUTS_EDEFAULT);
				return;
			case HwComputingPackage.HW_PLD__NB_FLIP_FLOPS:
				setNbFlipFlops(NB_FLIP_FLOPS_EDEFAULT);
				return;
			case HwComputingPackage.HW_PLD__BLOCKS_RAM:
				getBlocksRAM().clear();
				return;
			case HwComputingPackage.HW_PLD__BLOCKS_COMPUTING:
				getBlocksComputing().clear();
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
			case HwComputingPackage.HW_PLD__TECHNOLOGY:
				return technology != TECHNOLOGY_EDEFAULT;
			case HwComputingPackage.HW_PLD__ORGANIZATION:
				return ORGANIZATION_EDEFAULT == null ? organization != null : !ORGANIZATION_EDEFAULT.equals(organization);
			case HwComputingPackage.HW_PLD__NB_LU_TS:
				return NB_LU_TS_EDEFAULT == null ? nbLUTs != null : !NB_LU_TS_EDEFAULT.equals(nbLUTs);
			case HwComputingPackage.HW_PLD__ND_LUT_INPUTS:
				return ND_LUT_INPUTS_EDEFAULT == null ? ndLUT_Inputs != null : !ND_LUT_INPUTS_EDEFAULT.equals(ndLUT_Inputs);
			case HwComputingPackage.HW_PLD__NB_FLIP_FLOPS:
				return NB_FLIP_FLOPS_EDEFAULT == null ? nbFlipFlops != null : !NB_FLIP_FLOPS_EDEFAULT.equals(nbFlipFlops);
			case HwComputingPackage.HW_PLD__BLOCKS_RAM:
				return blocksRAM != null && !blocksRAM.isEmpty();
			case HwComputingPackage.HW_PLD__BLOCKS_COMPUTING:
				return blocksComputing != null && !blocksComputing.isEmpty();
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
		result.append(" (technology: ");
		result.append(technology);
		result.append(", organization: ");
		result.append(organization);
		result.append(", nbLUTs: ");
		result.append(nbLUTs);
		result.append(", ndLUT_Inputs: ");
		result.append(ndLUT_Inputs);
		result.append(", nbFlipFlops: ");
		result.append(nbFlipFlops);
		result.append(')');
		return result.toString();
	}

} //HwPLDImpl
