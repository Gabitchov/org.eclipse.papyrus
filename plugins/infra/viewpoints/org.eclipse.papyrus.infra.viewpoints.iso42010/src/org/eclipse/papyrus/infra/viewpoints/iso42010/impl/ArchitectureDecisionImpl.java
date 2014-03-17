/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.viewpoints.iso42010.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Concern;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl#getJustifiedBy <em>Justified By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl#getDependsUpon <em>Depends Upon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl#getDependents <em>Dependents</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl#getRaises <em>Raises</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl#getPertainsTo <em>Pertains To</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDecisionImpl#getAffects <em>Affects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureDecisionImpl extends ADElementImpl implements ArchitectureDecision {
	/**
	 * The cached value of the '{@link #getJustifiedBy() <em>Justified By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJustifiedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureRationale> justifiedBy;

	/**
	 * The cached value of the '{@link #getDependsUpon() <em>Depends Upon</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsUpon()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureDecision> dependsUpon;

	/**
	 * The cached value of the '{@link #getDependents() <em>Dependents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependents()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureDecision> dependents;

	/**
	 * The cached value of the '{@link #getRaises() <em>Raises</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaises()
	 * @generated
	 * @ordered
	 */
	protected EList<Concern> raises;

	/**
	 * The cached value of the '{@link #getPertainsTo() <em>Pertains To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPertainsTo()
	 * @generated
	 * @ordered
	 */
	protected EList<Concern> pertainsTo;

	/**
	 * The cached value of the '{@link #getAffects() <em>Affects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffects()
	 * @generated
	 * @ordered
	 */
	protected EList<ADElement> affects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureDecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.ARCHITECTURE_DECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureRationale> getJustifiedBy() {
		if (justifiedBy == null) {
			justifiedBy = new EObjectWithInverseResolvingEList.ManyInverse<ArchitectureRationale>(ArchitectureRationale.class, this, Iso42010Package.ARCHITECTURE_DECISION__JUSTIFIED_BY, Iso42010Package.ARCHITECTURE_RATIONALE__JUSTIFIES);
		}
		return justifiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureDecision> getDependsUpon() {
		if (dependsUpon == null) {
			dependsUpon = new EObjectWithInverseResolvingEList.ManyInverse<ArchitectureDecision>(ArchitectureDecision.class, this, Iso42010Package.ARCHITECTURE_DECISION__DEPENDS_UPON, Iso42010Package.ARCHITECTURE_DECISION__DEPENDENTS);
		}
		return dependsUpon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureDecision> getDependents() {
		if (dependents == null) {
			dependents = new EObjectWithInverseResolvingEList.ManyInverse<ArchitectureDecision>(ArchitectureDecision.class, this, Iso42010Package.ARCHITECTURE_DECISION__DEPENDENTS, Iso42010Package.ARCHITECTURE_DECISION__DEPENDS_UPON);
		}
		return dependents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Concern> getRaises() {
		if (raises == null) {
			raises = new EObjectWithInverseResolvingEList.ManyInverse<Concern>(Concern.class, this, Iso42010Package.ARCHITECTURE_DECISION__RAISES, Iso42010Package.CONCERN__RAISED_BY);
		}
		return raises;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Concern> getPertainsTo() {
		if (pertainsTo == null) {
			pertainsTo = new EObjectWithInverseResolvingEList.ManyInverse<Concern>(Concern.class, this, Iso42010Package.ARCHITECTURE_DECISION__PERTAINS_TO, Iso42010Package.CONCERN__DECISIONS);
		}
		return pertainsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ADElement> getAffects() {
		if (affects == null) {
			affects = new EObjectWithInverseResolvingEList.ManyInverse<ADElement>(ADElement.class, this, Iso42010Package.ARCHITECTURE_DECISION__AFFECTS, Iso42010Package.AD_ELEMENT__AFFECTED_BY);
		}
		return affects;
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
			case Iso42010Package.ARCHITECTURE_DECISION__JUSTIFIED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getJustifiedBy()).basicAdd(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDS_UPON:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependsUpon()).basicAdd(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependents()).basicAdd(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__RAISES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRaises()).basicAdd(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__PERTAINS_TO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPertainsTo()).basicAdd(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__AFFECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAffects()).basicAdd(otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_DECISION__JUSTIFIED_BY:
				return ((InternalEList<?>)getJustifiedBy()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDS_UPON:
				return ((InternalEList<?>)getDependsUpon()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDENTS:
				return ((InternalEList<?>)getDependents()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__RAISES:
				return ((InternalEList<?>)getRaises()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__PERTAINS_TO:
				return ((InternalEList<?>)getPertainsTo()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DECISION__AFFECTS:
				return ((InternalEList<?>)getAffects()).basicRemove(otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_DECISION__JUSTIFIED_BY:
				return getJustifiedBy();
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDS_UPON:
				return getDependsUpon();
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDENTS:
				return getDependents();
			case Iso42010Package.ARCHITECTURE_DECISION__RAISES:
				return getRaises();
			case Iso42010Package.ARCHITECTURE_DECISION__PERTAINS_TO:
				return getPertainsTo();
			case Iso42010Package.ARCHITECTURE_DECISION__AFFECTS:
				return getAffects();
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
			case Iso42010Package.ARCHITECTURE_DECISION__JUSTIFIED_BY:
				getJustifiedBy().clear();
				getJustifiedBy().addAll((Collection<? extends ArchitectureRationale>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDS_UPON:
				getDependsUpon().clear();
				getDependsUpon().addAll((Collection<? extends ArchitectureDecision>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDENTS:
				getDependents().clear();
				getDependents().addAll((Collection<? extends ArchitectureDecision>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__RAISES:
				getRaises().clear();
				getRaises().addAll((Collection<? extends Concern>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__PERTAINS_TO:
				getPertainsTo().clear();
				getPertainsTo().addAll((Collection<? extends Concern>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__AFFECTS:
				getAffects().clear();
				getAffects().addAll((Collection<? extends ADElement>)newValue);
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
			case Iso42010Package.ARCHITECTURE_DECISION__JUSTIFIED_BY:
				getJustifiedBy().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDS_UPON:
				getDependsUpon().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDENTS:
				getDependents().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__RAISES:
				getRaises().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__PERTAINS_TO:
				getPertainsTo().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DECISION__AFFECTS:
				getAffects().clear();
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
			case Iso42010Package.ARCHITECTURE_DECISION__JUSTIFIED_BY:
				return justifiedBy != null && !justifiedBy.isEmpty();
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDS_UPON:
				return dependsUpon != null && !dependsUpon.isEmpty();
			case Iso42010Package.ARCHITECTURE_DECISION__DEPENDENTS:
				return dependents != null && !dependents.isEmpty();
			case Iso42010Package.ARCHITECTURE_DECISION__RAISES:
				return raises != null && !raises.isEmpty();
			case Iso42010Package.ARCHITECTURE_DECISION__PERTAINS_TO:
				return pertainsTo != null && !pertainsTo.isEmpty();
			case Iso42010Package.ARCHITECTURE_DECISION__AFFECTS:
				return affects != null && !affects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureDecisionImpl
