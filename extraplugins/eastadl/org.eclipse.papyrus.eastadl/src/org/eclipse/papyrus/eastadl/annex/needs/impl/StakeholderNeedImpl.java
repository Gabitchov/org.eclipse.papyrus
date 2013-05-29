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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.annex.needs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage;
import org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement;
import org.eclipse.papyrus.eastadl.annex.needs.Stakeholder;
import org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder Need</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderNeedImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderNeedImpl#getNeed <em>Need</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderNeedImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderNeedImpl#getStakeHolder <em>Stake Holder</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderNeedImpl#getProblemStatement <em>Problem Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StakeholderNeedImpl extends TraceableSpecificationImpl implements StakeholderNeed {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getNeed() <em>Need</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeed()
	 * @generated
	 * @ordered
	 */
	protected static final String NEED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNeed() <em>Need</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeed()
	 * @generated
	 * @ordered
	 */
	protected String need = NEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStakeHolder() <em>Stake Holder</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStakeHolder()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> stakeHolder;

	/**
	 * The cached value of the '{@link #getProblemStatement() <em>Problem Statement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblemStatement()
	 * @generated
	 * @ordered
	 */
	protected EList<ProblemStatement> problemStatement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StakeholderNeedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NeedsPackage.STAKEHOLDER_NEED__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case NeedsPackage.STAKEHOLDER_NEED__NEED:
				return getNeed();
			case NeedsPackage.STAKEHOLDER_NEED__PRIORITY:
				return getPriority();
			case NeedsPackage.STAKEHOLDER_NEED__STAKE_HOLDER:
				return getStakeHolder();
			case NeedsPackage.STAKEHOLDER_NEED__PROBLEM_STATEMENT:
				return getProblemStatement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NeedsPackage.STAKEHOLDER_NEED__BASE_CLASS:
				return base_Class != null;
			case NeedsPackage.STAKEHOLDER_NEED__NEED:
				return NEED_EDEFAULT == null ? need != null : !NEED_EDEFAULT.equals(need);
			case NeedsPackage.STAKEHOLDER_NEED__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case NeedsPackage.STAKEHOLDER_NEED__STAKE_HOLDER:
				return stakeHolder != null && !stakeHolder.isEmpty();
			case NeedsPackage.STAKEHOLDER_NEED__PROBLEM_STATEMENT:
				return problemStatement != null && !problemStatement.isEmpty();
		}
		return super.eIsSet(featureID);
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
			case NeedsPackage.STAKEHOLDER_NEED__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case NeedsPackage.STAKEHOLDER_NEED__NEED:
				setNeed((String)newValue);
				return;
			case NeedsPackage.STAKEHOLDER_NEED__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case NeedsPackage.STAKEHOLDER_NEED__STAKE_HOLDER:
				getStakeHolder().clear();
				getStakeHolder().addAll((Collection<? extends Stakeholder>)newValue);
				return;
			case NeedsPackage.STAKEHOLDER_NEED__PROBLEM_STATEMENT:
				getProblemStatement().clear();
				getProblemStatement().addAll((Collection<? extends ProblemStatement>)newValue);
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
	protected EClass eStaticClass() {
		return NeedsPackage.Literals.STAKEHOLDER_NEED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NeedsPackage.STAKEHOLDER_NEED__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.STAKEHOLDER_NEED__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NeedsPackage.STAKEHOLDER_NEED__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case NeedsPackage.STAKEHOLDER_NEED__NEED:
				setNeed(NEED_EDEFAULT);
				return;
			case NeedsPackage.STAKEHOLDER_NEED__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case NeedsPackage.STAKEHOLDER_NEED__STAKE_HOLDER:
				getStakeHolder().clear();
				return;
			case NeedsPackage.STAKEHOLDER_NEED__PROBLEM_STATEMENT:
				getProblemStatement().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNeed() {
		return need;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProblemStatement> getProblemStatement() {
		if (problemStatement == null) {
			problemStatement = new EObjectResolvingEList<ProblemStatement>(ProblemStatement.class, this, NeedsPackage.STAKEHOLDER_NEED__PROBLEM_STATEMENT);
		}
		return problemStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getStakeHolder() {
		if (stakeHolder == null) {
			stakeHolder = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, NeedsPackage.STAKEHOLDER_NEED__STAKE_HOLDER);
		}
		return stakeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeed(String newNeed) {
		String oldNeed = need;
		need = newNeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.STAKEHOLDER_NEED__NEED, oldNeed, need));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.STAKEHOLDER_NEED__PRIORITY, oldPriority, priority));
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
		result.append(" (need: ");
		result.append(need);
		result.append(", priority: ");
		result.append(priority);
		result.append(')');
		return result.toString();
	}

} //StakeholderNeedImpl
