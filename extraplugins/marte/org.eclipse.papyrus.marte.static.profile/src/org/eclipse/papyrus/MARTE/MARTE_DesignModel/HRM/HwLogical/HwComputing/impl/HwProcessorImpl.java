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
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwBranchPredictor;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwISA;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwCache;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwMMU;
import org.eclipse.papyrus.MARTE.utils.MarteUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getMips <em>Mips</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getIpc <em>Ipc</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getNbCores <em>Nb Cores</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getNbPipelines <em>Nb Pipelines</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getNbStages <em>Nb Stages</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getNbALUs <em>Nb AL Us</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getNbFPUs <em>Nb FP Us</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getOwnedISAs <em>Owned IS As</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getPredictors <em>Predictors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getCaches <em>Caches</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwProcessorImpl#getOwnedMMUs <em>Owned MM Us</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwProcessorImpl extends HwComputingResourceImpl implements HwProcessor {
	/**
	 * The default value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final String ARCHITECTURE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getMips() <em>Mips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMips()
	 * @generated
	 * @ordered
	 */
	protected static final String MIPS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMips() <em>Mips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMips()
	 * @generated
	 * @ordered
	 */
	protected String mips = MIPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIpc() <em>Ipc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpc()
	 * @generated
	 * @ordered
	 */
	protected static final String IPC_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getNbCores() <em>Nb Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbCores()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_CORES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbCores() <em>Nb Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbCores()
	 * @generated
	 * @ordered
	 */
	protected String nbCores = NB_CORES_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbPipelines() <em>Nb Pipelines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbPipelines()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_PIPELINES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbPipelines() <em>Nb Pipelines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbPipelines()
	 * @generated
	 * @ordered
	 */
	protected String nbPipelines = NB_PIPELINES_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbStages() <em>Nb Stages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbStages()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_STAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbStages() <em>Nb Stages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbStages()
	 * @generated
	 * @ordered
	 */
	protected String nbStages = NB_STAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbALUs() <em>Nb AL Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbALUs()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_AL_US_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbALUs() <em>Nb AL Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbALUs()
	 * @generated
	 * @ordered
	 */
	protected String nbALUs = NB_AL_US_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbFPUs() <em>Nb FP Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbFPUs()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_FP_US_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbFPUs() <em>Nb FP Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbFPUs()
	 * @generated
	 * @ordered
	 */
	protected String nbFPUs = NB_FP_US_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedISAs() <em>Owned IS As</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedISAs()
	 * @generated
	 * @ordered
	 */
	protected EList<HwISA> ownedISAs;

	/**
	 * The cached value of the '{@link #getPredictors() <em>Predictors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredictors()
	 * @generated
	 * @ordered
	 */
	protected EList<HwBranchPredictor> predictors;

	/**
	 * The cached value of the '{@link #getCaches() <em>Caches</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaches()
	 * @generated
	 * @ordered
	 */
	protected EList<HwCache> caches;

	/**
	 * The cached value of the '{@link #getOwnedMMUs() <em>Owned MM Us</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMMUs()
	 * @generated
	 * @ordered
	 */
	protected EList<HwMMU> ownedMMUs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwProcessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwComputingPackage.Literals.HW_PROCESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getArchitecture() {
		// TODO: implement this method to return the 'Architecture' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		
		Object base = null;
		if(getBase_Classifier()!=null)
			base = getBase_Classifier();
		else if(getBase_ConnectableElement()!=null)
			base = getBase_ConnectableElement();
		else if(getBase_InstanceSpecification()!=null)
			base = getBase_InstanceSpecification();
		else if(getBase_Lifeline()!=null)
			base = getBase_Lifeline();
		else if(getBase_Property()!=null)
			base = getBase_Property();
		
		String archi=null;
		
		if(base!=null) {
			//Object ownedISAs = eGet(HwComputingPackage.HW_PROCESSOR__OWNED_IS_AS, false, false);
			
			int instWidth = 0;
			Iterator<HwISA> isaIter = getOwnedISAs().iterator();
			while(isaIter.hasNext()) {
				HwISA currentISA = isaIter.next();
				String widthTuple = currentISA.getInst_Width();
				if(widthTuple!=null) {
					Integer intWidth = Integer.valueOf(MarteUtils.getValueFromTuple(widthTuple, "value"));
					if(instWidth < intWidth) {
						instWidth = intWidth;
						String stringUnit = MarteUtils.getValueFromTuple(widthTuple, "unit"); 
						archi = "{unit="+stringUnit+",value=" + String.valueOf(instWidth) + "}";
					}
				}
			}
		}
		
		return archi;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArchitecture(String newArchitecture) {
		// TODO: implement this method to set the 'Architecture' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMips() {
		return mips;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMips(String newMips) {
		String oldMips = mips;
		mips = newMips;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PROCESSOR__MIPS, oldMips, mips));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getIpc() {
		// TODO: implement this method to return the 'Ipc' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		
		String ipc = null;
		
		String mipsTuple = getMips();
		String frequencyTuple = getFrequency();
		
		if(mipsTuple != null && frequencyTuple!=null) {
			int mipsValue = Integer.valueOf(MarteUtils.getValueFromTuple(mipsTuple, "value"));
			float frequencyValue = Float.valueOf(MarteUtils.getValueFromTuple(frequencyTuple, "value"));
			String frequencyUnit = MarteUtils.getValueFromTuple(frequencyTuple, "unit");
			long convFactor = 1;
			if(frequencyUnit.equals("Gz"))
				convFactor = 1000000000;
			else if(frequencyUnit.equals("Mz"))
				convFactor = 1000000;
			else if(frequencyUnit.equals("KHz"))
				convFactor = 1000;
			
			ipc = String.valueOf((mipsValue*1000000)/(convFactor*frequencyValue));
		}
		
		return ipc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIpc(String newIpc) {
		// TODO: implement this method to set the 'Ipc' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbCores() {
		return nbCores;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbCores(String newNbCores) {
		String oldNbCores = nbCores;
		nbCores = newNbCores;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PROCESSOR__NB_CORES, oldNbCores, nbCores));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbPipelines() {
		return nbPipelines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbPipelines(String newNbPipelines) {
		String oldNbPipelines = nbPipelines;
		nbPipelines = newNbPipelines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PROCESSOR__NB_PIPELINES, oldNbPipelines, nbPipelines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbStages() {
		return nbStages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbStages(String newNbStages) {
		String oldNbStages = nbStages;
		nbStages = newNbStages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PROCESSOR__NB_STAGES, oldNbStages, nbStages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbALUs() {
		return nbALUs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbALUs(String newNbALUs) {
		String oldNbALUs = nbALUs;
		nbALUs = newNbALUs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PROCESSOR__NB_AL_US, oldNbALUs, nbALUs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbFPUs() {
		return nbFPUs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbFPUs(String newNbFPUs) {
		String oldNbFPUs = nbFPUs;
		nbFPUs = newNbFPUs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwComputingPackage.HW_PROCESSOR__NB_FP_US, oldNbFPUs, nbFPUs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwISA> getOwnedISAs() {
		if (ownedISAs == null) {
			ownedISAs = new EObjectResolvingEList<HwISA>(HwISA.class, this, HwComputingPackage.HW_PROCESSOR__OWNED_IS_AS);
		}
		return ownedISAs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwBranchPredictor> getPredictors() {
		if (predictors == null) {
			predictors = new EObjectResolvingEList<HwBranchPredictor>(HwBranchPredictor.class, this, HwComputingPackage.HW_PROCESSOR__PREDICTORS);
		}
		return predictors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwCache> getCaches() {
		if (caches == null) {
			caches = new EObjectResolvingEList<HwCache>(HwCache.class, this, HwComputingPackage.HW_PROCESSOR__CACHES);
		}
		return caches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwMMU> getOwnedMMUs() {
		if (ownedMMUs == null) {
			ownedMMUs = new EObjectResolvingEList<HwMMU>(HwMMU.class, this, HwComputingPackage.HW_PROCESSOR__OWNED_MM_US);
		}
		return ownedMMUs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwComputingPackage.HW_PROCESSOR__ARCHITECTURE:
				return getArchitecture();
			case HwComputingPackage.HW_PROCESSOR__MIPS:
				return getMips();
			case HwComputingPackage.HW_PROCESSOR__IPC:
				return getIpc();
			case HwComputingPackage.HW_PROCESSOR__NB_CORES:
				return getNbCores();
			case HwComputingPackage.HW_PROCESSOR__NB_PIPELINES:
				return getNbPipelines();
			case HwComputingPackage.HW_PROCESSOR__NB_STAGES:
				return getNbStages();
			case HwComputingPackage.HW_PROCESSOR__NB_AL_US:
				return getNbALUs();
			case HwComputingPackage.HW_PROCESSOR__NB_FP_US:
				return getNbFPUs();
			case HwComputingPackage.HW_PROCESSOR__OWNED_IS_AS:
				return getOwnedISAs();
			case HwComputingPackage.HW_PROCESSOR__PREDICTORS:
				return getPredictors();
			case HwComputingPackage.HW_PROCESSOR__CACHES:
				return getCaches();
			case HwComputingPackage.HW_PROCESSOR__OWNED_MM_US:
				return getOwnedMMUs();
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
			case HwComputingPackage.HW_PROCESSOR__ARCHITECTURE:
				setArchitecture((String)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__MIPS:
				setMips((String)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__IPC:
				setIpc((String)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_CORES:
				setNbCores((String)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_PIPELINES:
				setNbPipelines((String)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_STAGES:
				setNbStages((String)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_AL_US:
				setNbALUs((String)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_FP_US:
				setNbFPUs((String)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__OWNED_IS_AS:
				getOwnedISAs().clear();
				getOwnedISAs().addAll((Collection<? extends HwISA>)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__PREDICTORS:
				getPredictors().clear();
				getPredictors().addAll((Collection<? extends HwBranchPredictor>)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__CACHES:
				getCaches().clear();
				getCaches().addAll((Collection<? extends HwCache>)newValue);
				return;
			case HwComputingPackage.HW_PROCESSOR__OWNED_MM_US:
				getOwnedMMUs().clear();
				getOwnedMMUs().addAll((Collection<? extends HwMMU>)newValue);
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
			case HwComputingPackage.HW_PROCESSOR__ARCHITECTURE:
				setArchitecture(ARCHITECTURE_EDEFAULT);
				return;
			case HwComputingPackage.HW_PROCESSOR__MIPS:
				setMips(MIPS_EDEFAULT);
				return;
			case HwComputingPackage.HW_PROCESSOR__IPC:
				setIpc(IPC_EDEFAULT);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_CORES:
				setNbCores(NB_CORES_EDEFAULT);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_PIPELINES:
				setNbPipelines(NB_PIPELINES_EDEFAULT);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_STAGES:
				setNbStages(NB_STAGES_EDEFAULT);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_AL_US:
				setNbALUs(NB_AL_US_EDEFAULT);
				return;
			case HwComputingPackage.HW_PROCESSOR__NB_FP_US:
				setNbFPUs(NB_FP_US_EDEFAULT);
				return;
			case HwComputingPackage.HW_PROCESSOR__OWNED_IS_AS:
				getOwnedISAs().clear();
				return;
			case HwComputingPackage.HW_PROCESSOR__PREDICTORS:
				getPredictors().clear();
				return;
			case HwComputingPackage.HW_PROCESSOR__CACHES:
				getCaches().clear();
				return;
			case HwComputingPackage.HW_PROCESSOR__OWNED_MM_US:
				getOwnedMMUs().clear();
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
			case HwComputingPackage.HW_PROCESSOR__ARCHITECTURE:
				return ARCHITECTURE_EDEFAULT == null ? getArchitecture() != null : !ARCHITECTURE_EDEFAULT.equals(getArchitecture());
			case HwComputingPackage.HW_PROCESSOR__MIPS:
				return MIPS_EDEFAULT == null ? mips != null : !MIPS_EDEFAULT.equals(mips);
			case HwComputingPackage.HW_PROCESSOR__IPC:
				return IPC_EDEFAULT == null ? getIpc() != null : !IPC_EDEFAULT.equals(getIpc());
			case HwComputingPackage.HW_PROCESSOR__NB_CORES:
				return NB_CORES_EDEFAULT == null ? nbCores != null : !NB_CORES_EDEFAULT.equals(nbCores);
			case HwComputingPackage.HW_PROCESSOR__NB_PIPELINES:
				return NB_PIPELINES_EDEFAULT == null ? nbPipelines != null : !NB_PIPELINES_EDEFAULT.equals(nbPipelines);
			case HwComputingPackage.HW_PROCESSOR__NB_STAGES:
				return NB_STAGES_EDEFAULT == null ? nbStages != null : !NB_STAGES_EDEFAULT.equals(nbStages);
			case HwComputingPackage.HW_PROCESSOR__NB_AL_US:
				return NB_AL_US_EDEFAULT == null ? nbALUs != null : !NB_AL_US_EDEFAULT.equals(nbALUs);
			case HwComputingPackage.HW_PROCESSOR__NB_FP_US:
				return NB_FP_US_EDEFAULT == null ? nbFPUs != null : !NB_FP_US_EDEFAULT.equals(nbFPUs);
			case HwComputingPackage.HW_PROCESSOR__OWNED_IS_AS:
				return ownedISAs != null && !ownedISAs.isEmpty();
			case HwComputingPackage.HW_PROCESSOR__PREDICTORS:
				return predictors != null && !predictors.isEmpty();
			case HwComputingPackage.HW_PROCESSOR__CACHES:
				return caches != null && !caches.isEmpty();
			case HwComputingPackage.HW_PROCESSOR__OWNED_MM_US:
				return ownedMMUs != null && !ownedMMUs.isEmpty();
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
		result.append(" (mips: ");
		result.append(mips);
		result.append(", nbCores: ");
		result.append(nbCores);
		result.append(", nbPipelines: ");
		result.append(nbPipelines);
		result.append(", nbStages: ");
		result.append(nbStages);
		result.append(", nbALUs: ");
		result.append(nbALUs);
		result.append(", nbFPUs: ");
		result.append(nbFPUs);
		result.append(')');
		return result.toString();
	}

} //HwProcessorImpl
