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

import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Concern;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ConcernImpl#getFramedBy <em>Framed By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ConcernImpl#getAddressedBy <em>Addressed By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ConcernImpl#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ConcernImpl#getRaisedBy <em>Raised By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ConcernImpl#getDecisions <em>Decisions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcernImpl extends ADElementImpl implements Concern {
	/**
	 * The cached value of the '{@link #getFramedBy() <em>Framed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFramedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureViewpoint> framedBy;

	/**
	 * The cached value of the '{@link #getAddressedBy() <em>Addressed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureView> addressedBy;

	/**
	 * The cached value of the '{@link #getStakeholders() <em>Stakeholders</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStakeholders()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> stakeholders;

	/**
	 * The cached value of the '{@link #getRaisedBy() <em>Raised By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaisedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureDecision> raisedBy;

	/**
	 * The cached value of the '{@link #getDecisions() <em>Decisions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecisions()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureDecision> decisions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcernImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.CONCERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureViewpoint> getFramedBy() {
		if (framedBy == null) {
			framedBy = new EObjectWithInverseResolvingEList.ManyInverse<ArchitectureViewpoint>(ArchitectureViewpoint.class, this, Iso42010Package.CONCERN__FRAMED_BY, Iso42010Package.ARCHITECTURE_VIEWPOINT__FRAMES);
		}
		return framedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureView> getAddressedBy() {
		if (addressedBy == null) {
			addressedBy = new EObjectWithInverseResolvingEList.ManyInverse<ArchitectureView>(ArchitectureView.class, this, Iso42010Package.CONCERN__ADDRESSED_BY, Iso42010Package.ARCHITECTURE_VIEW__ADDRESSES);
		}
		return addressedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getStakeholders() {
		if (stakeholders == null) {
			stakeholders = new EObjectWithInverseResolvingEList.ManyInverse<Stakeholder>(Stakeholder.class, this, Iso42010Package.CONCERN__STAKEHOLDERS, Iso42010Package.STAKEHOLDER__CONCERNS);
		}
		return stakeholders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureDecision> getRaisedBy() {
		if (raisedBy == null) {
			raisedBy = new EObjectWithInverseResolvingEList.ManyInverse<ArchitectureDecision>(ArchitectureDecision.class, this, Iso42010Package.CONCERN__RAISED_BY, Iso42010Package.ARCHITECTURE_DECISION__RAISES);
		}
		return raisedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureDecision> getDecisions() {
		if (decisions == null) {
			decisions = new EObjectWithInverseResolvingEList.ManyInverse<ArchitectureDecision>(ArchitectureDecision.class, this, Iso42010Package.CONCERN__DECISIONS, Iso42010Package.ARCHITECTURE_DECISION__PERTAINS_TO);
		}
		return decisions;
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
			case Iso42010Package.CONCERN__FRAMED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFramedBy()).basicAdd(otherEnd, msgs);
			case Iso42010Package.CONCERN__ADDRESSED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAddressedBy()).basicAdd(otherEnd, msgs);
			case Iso42010Package.CONCERN__STAKEHOLDERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStakeholders()).basicAdd(otherEnd, msgs);
			case Iso42010Package.CONCERN__RAISED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRaisedBy()).basicAdd(otherEnd, msgs);
			case Iso42010Package.CONCERN__DECISIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDecisions()).basicAdd(otherEnd, msgs);
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
			case Iso42010Package.CONCERN__FRAMED_BY:
				return ((InternalEList<?>)getFramedBy()).basicRemove(otherEnd, msgs);
			case Iso42010Package.CONCERN__ADDRESSED_BY:
				return ((InternalEList<?>)getAddressedBy()).basicRemove(otherEnd, msgs);
			case Iso42010Package.CONCERN__STAKEHOLDERS:
				return ((InternalEList<?>)getStakeholders()).basicRemove(otherEnd, msgs);
			case Iso42010Package.CONCERN__RAISED_BY:
				return ((InternalEList<?>)getRaisedBy()).basicRemove(otherEnd, msgs);
			case Iso42010Package.CONCERN__DECISIONS:
				return ((InternalEList<?>)getDecisions()).basicRemove(otherEnd, msgs);
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
			case Iso42010Package.CONCERN__FRAMED_BY:
				return getFramedBy();
			case Iso42010Package.CONCERN__ADDRESSED_BY:
				return getAddressedBy();
			case Iso42010Package.CONCERN__STAKEHOLDERS:
				return getStakeholders();
			case Iso42010Package.CONCERN__RAISED_BY:
				return getRaisedBy();
			case Iso42010Package.CONCERN__DECISIONS:
				return getDecisions();
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
			case Iso42010Package.CONCERN__FRAMED_BY:
				getFramedBy().clear();
				getFramedBy().addAll((Collection<? extends ArchitectureViewpoint>)newValue);
				return;
			case Iso42010Package.CONCERN__ADDRESSED_BY:
				getAddressedBy().clear();
				getAddressedBy().addAll((Collection<? extends ArchitectureView>)newValue);
				return;
			case Iso42010Package.CONCERN__STAKEHOLDERS:
				getStakeholders().clear();
				getStakeholders().addAll((Collection<? extends Stakeholder>)newValue);
				return;
			case Iso42010Package.CONCERN__RAISED_BY:
				getRaisedBy().clear();
				getRaisedBy().addAll((Collection<? extends ArchitectureDecision>)newValue);
				return;
			case Iso42010Package.CONCERN__DECISIONS:
				getDecisions().clear();
				getDecisions().addAll((Collection<? extends ArchitectureDecision>)newValue);
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
			case Iso42010Package.CONCERN__FRAMED_BY:
				getFramedBy().clear();
				return;
			case Iso42010Package.CONCERN__ADDRESSED_BY:
				getAddressedBy().clear();
				return;
			case Iso42010Package.CONCERN__STAKEHOLDERS:
				getStakeholders().clear();
				return;
			case Iso42010Package.CONCERN__RAISED_BY:
				getRaisedBy().clear();
				return;
			case Iso42010Package.CONCERN__DECISIONS:
				getDecisions().clear();
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
			case Iso42010Package.CONCERN__FRAMED_BY:
				return framedBy != null && !framedBy.isEmpty();
			case Iso42010Package.CONCERN__ADDRESSED_BY:
				return addressedBy != null && !addressedBy.isEmpty();
			case Iso42010Package.CONCERN__STAKEHOLDERS:
				return stakeholders != null && !stakeholders.isEmpty();
			case Iso42010Package.CONCERN__RAISED_BY:
				return raisedBy != null && !raisedBy.isEmpty();
			case Iso42010Package.CONCERN__DECISIONS:
				return decisions != null && !decisions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConcernImpl
