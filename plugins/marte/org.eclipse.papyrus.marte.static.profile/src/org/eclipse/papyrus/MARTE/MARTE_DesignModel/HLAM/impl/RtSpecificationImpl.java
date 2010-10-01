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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation;

import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rt Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getUtility <em>Utility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getOccKind <em>Occ Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getTRef <em>TRef</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getRelDl <em>Rel Dl</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getAbsDl <em>Abs Dl</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getBoundDl <em>Bound Dl</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getRdTime <em>Rd Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getMiss <em>Miss</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RtSpecificationImpl extends EObjectImpl implements RtSpecification {
	/**
	 * The default value of the '{@link #getUtility() <em>Utility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtility()
	 * @generated
	 * @ordered
	 */
	protected static final String UTILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUtility() <em>Utility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtility()
	 * @generated
	 * @ordered
	 */
	protected String utility = UTILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOccKind() <em>Occ Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccKind()
	 * @generated
	 * @ordered
	 */
	protected static final String OCC_KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOccKind() <em>Occ Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccKind()
	 * @generated
	 * @ordered
	 */
	protected String occKind = OCC_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTRef() <em>TRef</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTRef()
	 * @generated
	 * @ordered
	 */
	protected TimedInstantObservation tRef;

	/**
	 * The default value of the '{@link #getRelDl() <em>Rel Dl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelDl()
	 * @generated
	 * @ordered
	 */
	protected static final String REL_DL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelDl() <em>Rel Dl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelDl()
	 * @generated
	 * @ordered
	 */
	protected String relDl = REL_DL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAbsDl() <em>Abs Dl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsDl()
	 * @generated
	 * @ordered
	 */
	protected static final String ABS_DL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAbsDl() <em>Abs Dl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsDl()
	 * @generated
	 * @ordered
	 */
	protected String absDl = ABS_DL_EDEFAULT;

	/**
	 * The default value of the '{@link #getBoundDl() <em>Bound Dl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundDl()
	 * @generated
	 * @ordered
	 */
	protected static final String BOUND_DL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBoundDl() <em>Bound Dl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundDl()
	 * @generated
	 * @ordered
	 */
	protected String boundDl = BOUND_DL_EDEFAULT;

	/**
	 * The default value of the '{@link #getRdTime() <em>Rd Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRdTime()
	 * @generated
	 * @ordered
	 */
	protected static final String RD_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRdTime() <em>Rd Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRdTime()
	 * @generated
	 * @ordered
	 */
	protected String rdTime = RD_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMiss() <em>Miss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiss()
	 * @generated
	 * @ordered
	 */
	protected static final String MISS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMiss() <em>Miss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiss()
	 * @generated
	 * @ordered
	 */
	protected String miss = MISS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected String priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Comment() <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Comment()
	 * @generated
	 * @ordered
	 */
	protected Comment base_Comment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RtSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HLAMPackage.Literals.RT_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUtility() {
		return utility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtility(String newUtility) {
		String oldUtility = utility;
		utility = newUtility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__UTILITY, oldUtility, utility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOccKind() {
		return occKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOccKind(String newOccKind) {
		String oldOccKind = occKind;
		occKind = newOccKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__OCC_KIND, oldOccKind, occKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimedInstantObservation getTRef() {
		if (tRef != null && tRef.eIsProxy()) {
			InternalEObject oldTRef = (InternalEObject)tRef;
			tRef = (TimedInstantObservation)eResolveProxy(oldTRef);
			if (tRef != oldTRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_SPECIFICATION__TREF, oldTRef, tRef));
			}
		}
		return tRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimedInstantObservation basicGetTRef() {
		return tRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTRef(TimedInstantObservation newTRef) {
		TimedInstantObservation oldTRef = tRef;
		tRef = newTRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__TREF, oldTRef, tRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelDl() {
		return relDl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelDl(String newRelDl) {
		String oldRelDl = relDl;
		relDl = newRelDl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__REL_DL, oldRelDl, relDl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbsDl() {
		return absDl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsDl(String newAbsDl) {
		String oldAbsDl = absDl;
		absDl = newAbsDl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__ABS_DL, oldAbsDl, absDl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBoundDl() {
		return boundDl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundDl(String newBoundDl) {
		String oldBoundDl = boundDl;
		boundDl = newBoundDl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__BOUND_DL, oldBoundDl, boundDl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRdTime() {
		return rdTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRdTime(String newRdTime) {
		String oldRdTime = rdTime;
		rdTime = newRdTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__RD_TIME, oldRdTime, rdTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMiss() {
		return miss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMiss(String newMiss) {
		String oldMiss = miss;
		miss = newMiss;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__MISS, oldMiss, miss));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(String newPriority) {
		String oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment getBase_Comment() {
		if (base_Comment != null && base_Comment.eIsProxy()) {
			InternalEObject oldBase_Comment = (InternalEObject)base_Comment;
			base_Comment = (Comment)eResolveProxy(oldBase_Comment);
			if (base_Comment != oldBase_Comment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_SPECIFICATION__BASE_COMMENT, oldBase_Comment, base_Comment));
			}
		}
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment basicGetBase_Comment() {
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Comment(Comment newBase_Comment) {
		Comment oldBase_Comment = base_Comment;
		base_Comment = newBase_Comment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SPECIFICATION__BASE_COMMENT, oldBase_Comment, base_Comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature getContext() {
		BehavioralFeature context = basicGetContext();
		return context != null && context.eIsProxy() ? (BehavioralFeature)eResolveProxy((InternalEObject)context) : context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature basicGetContext() {
		// TODO: implement this method to return the 'Context' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		return null;
		// throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(BehavioralFeature newContext) {
		// TODO: implement this method to set the 'Context' reference
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HLAMPackage.RT_SPECIFICATION__UTILITY:
				return getUtility();
			case HLAMPackage.RT_SPECIFICATION__OCC_KIND:
				return getOccKind();
			case HLAMPackage.RT_SPECIFICATION__TREF:
				if (resolve) return getTRef();
				return basicGetTRef();
			case HLAMPackage.RT_SPECIFICATION__REL_DL:
				return getRelDl();
			case HLAMPackage.RT_SPECIFICATION__ABS_DL:
				return getAbsDl();
			case HLAMPackage.RT_SPECIFICATION__BOUND_DL:
				return getBoundDl();
			case HLAMPackage.RT_SPECIFICATION__RD_TIME:
				return getRdTime();
			case HLAMPackage.RT_SPECIFICATION__MISS:
				return getMiss();
			case HLAMPackage.RT_SPECIFICATION__PRIORITY:
				return getPriority();
			case HLAMPackage.RT_SPECIFICATION__BASE_COMMENT:
				if (resolve) return getBase_Comment();
				return basicGetBase_Comment();
			case HLAMPackage.RT_SPECIFICATION__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
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
			case HLAMPackage.RT_SPECIFICATION__UTILITY:
				setUtility((String)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__OCC_KIND:
				setOccKind((String)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__TREF:
				setTRef((TimedInstantObservation)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__REL_DL:
				setRelDl((String)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__ABS_DL:
				setAbsDl((String)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__BOUND_DL:
				setBoundDl((String)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__RD_TIME:
				setRdTime((String)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__MISS:
				setMiss((String)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__PRIORITY:
				setPriority((String)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__BASE_COMMENT:
				setBase_Comment((Comment)newValue);
				return;
			case HLAMPackage.RT_SPECIFICATION__CONTEXT:
				setContext((BehavioralFeature)newValue);
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
			case HLAMPackage.RT_SPECIFICATION__UTILITY:
				setUtility(UTILITY_EDEFAULT);
				return;
			case HLAMPackage.RT_SPECIFICATION__OCC_KIND:
				setOccKind(OCC_KIND_EDEFAULT);
				return;
			case HLAMPackage.RT_SPECIFICATION__TREF:
				setTRef((TimedInstantObservation)null);
				return;
			case HLAMPackage.RT_SPECIFICATION__REL_DL:
				setRelDl(REL_DL_EDEFAULT);
				return;
			case HLAMPackage.RT_SPECIFICATION__ABS_DL:
				setAbsDl(ABS_DL_EDEFAULT);
				return;
			case HLAMPackage.RT_SPECIFICATION__BOUND_DL:
				setBoundDl(BOUND_DL_EDEFAULT);
				return;
			case HLAMPackage.RT_SPECIFICATION__RD_TIME:
				setRdTime(RD_TIME_EDEFAULT);
				return;
			case HLAMPackage.RT_SPECIFICATION__MISS:
				setMiss(MISS_EDEFAULT);
				return;
			case HLAMPackage.RT_SPECIFICATION__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case HLAMPackage.RT_SPECIFICATION__BASE_COMMENT:
				setBase_Comment((Comment)null);
				return;
			case HLAMPackage.RT_SPECIFICATION__CONTEXT:
				setContext((BehavioralFeature)null);
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
			case HLAMPackage.RT_SPECIFICATION__UTILITY:
				return UTILITY_EDEFAULT == null ? utility != null : !UTILITY_EDEFAULT.equals(utility);
			case HLAMPackage.RT_SPECIFICATION__OCC_KIND:
				return OCC_KIND_EDEFAULT == null ? occKind != null : !OCC_KIND_EDEFAULT.equals(occKind);
			case HLAMPackage.RT_SPECIFICATION__TREF:
				return tRef != null;
			case HLAMPackage.RT_SPECIFICATION__REL_DL:
				return REL_DL_EDEFAULT == null ? relDl != null : !REL_DL_EDEFAULT.equals(relDl);
			case HLAMPackage.RT_SPECIFICATION__ABS_DL:
				return ABS_DL_EDEFAULT == null ? absDl != null : !ABS_DL_EDEFAULT.equals(absDl);
			case HLAMPackage.RT_SPECIFICATION__BOUND_DL:
				return BOUND_DL_EDEFAULT == null ? boundDl != null : !BOUND_DL_EDEFAULT.equals(boundDl);
			case HLAMPackage.RT_SPECIFICATION__RD_TIME:
				return RD_TIME_EDEFAULT == null ? rdTime != null : !RD_TIME_EDEFAULT.equals(rdTime);
			case HLAMPackage.RT_SPECIFICATION__MISS:
				return MISS_EDEFAULT == null ? miss != null : !MISS_EDEFAULT.equals(miss);
			case HLAMPackage.RT_SPECIFICATION__PRIORITY:
				return PRIORITY_EDEFAULT == null ? priority != null : !PRIORITY_EDEFAULT.equals(priority);
			case HLAMPackage.RT_SPECIFICATION__BASE_COMMENT:
				return base_Comment != null;
			case HLAMPackage.RT_SPECIFICATION__CONTEXT:
				return basicGetContext() != null;
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
		result.append(" (utility: ");
		result.append(utility);
		result.append(", occKind: ");
		result.append(occKind);
		result.append(", relDl: ");
		result.append(relDl);
		result.append(", absDl: ");
		result.append(absDl);
		result.append(", boundDl: ");
		result.append(boundDl);
		result.append(", rdTime: ");
		result.append(rdTime);
		result.append(", miss: ");
		result.append(miss);
		result.append(", priority: ");
		result.append(priority);
		result.append(')');
		return result.toString();
	}

} //RtSpecificationImpl
