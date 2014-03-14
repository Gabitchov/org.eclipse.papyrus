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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.viewpoints.iso42010.Architecture;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Concern;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence;
import org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getSystem <em>System</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getExpresses <em>Expresses</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getRationales <em>Rationales</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getCorrespondences <em>Correspondences</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureDescriptionImpl#getDecisions <em>Decisions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureDescriptionImpl extends MinimalEObjectImpl.Container implements ArchitectureDescription {
	/**
	 * The cached value of the '{@link #getStakeholders() <em>Stakeholders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStakeholders()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> stakeholders;

	/**
	 * The cached value of the '{@link #getConcerns() <em>Concerns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcerns()
	 * @generated
	 * @ordered
	 */
	protected EList<Concern> concerns;

	/**
	 * The cached value of the '{@link #getViewpoints() <em>Viewpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureViewpoint> viewpoints;

	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureView> views;

	/**
	 * The cached value of the '{@link #getSystem() <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystem()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.papyrus.infra.viewpoints.iso42010.System system;

	/**
	 * The cached value of the '{@link #getExpresses() <em>Expresses</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpresses()
	 * @generated
	 * @ordered
	 */
	protected Architecture expresses;

	/**
	 * The cached value of the '{@link #getRationales() <em>Rationales</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRationales()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureRationale> rationales;

	/**
	 * The cached value of the '{@link #getCorrespondences() <em>Correspondences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrespondences()
	 * @generated
	 * @ordered
	 */
	protected EList<Correspondence> correspondences;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<CorrespondenceRule> rules;

	/**
	 * The cached value of the '{@link #getDecisions() <em>Decisions</em>}' containment reference list.
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
	protected ArchitectureDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getStakeholders() {
		if (stakeholders == null) {
			stakeholders = new EObjectContainmentEList<Stakeholder>(Stakeholder.class, this, Iso42010Package.ARCHITECTURE_DESCRIPTION__STAKEHOLDERS);
		}
		return stakeholders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Concern> getConcerns() {
		if (concerns == null) {
			concerns = new EObjectContainmentEList<Concern>(Concern.class, this, Iso42010Package.ARCHITECTURE_DESCRIPTION__CONCERNS);
		}
		return concerns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureViewpoint> getViewpoints() {
		if (viewpoints == null) {
			viewpoints = new EObjectContainmentEList<ArchitectureViewpoint>(ArchitectureViewpoint.class, this, Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWPOINTS);
		}
		return viewpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureView> getViews() {
		if (views == null) {
			views = new EObjectContainmentEList<ArchitectureView>(ArchitectureView.class, this, Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWS);
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.infra.viewpoints.iso42010.System getSystem() {
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(org.eclipse.papyrus.infra.viewpoints.iso42010.System newSystem, NotificationChain msgs) {
		org.eclipse.papyrus.infra.viewpoints.iso42010.System oldSystem = system;
		system = newSystem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM, oldSystem, newSystem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(org.eclipse.papyrus.infra.viewpoints.iso42010.System newSystem) {
		if (newSystem != system) {
			NotificationChain msgs = null;
			if (system != null)
				msgs = ((InternalEObject)system).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM, null, msgs);
			if (newSystem != null)
				msgs = ((InternalEObject)newSystem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM, null, msgs);
			msgs = basicSetSystem(newSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Architecture getExpresses() {
		return expresses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpresses(Architecture newExpresses, NotificationChain msgs) {
		Architecture oldExpresses = expresses;
		expresses = newExpresses;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES, oldExpresses, newExpresses);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpresses(Architecture newExpresses) {
		if (newExpresses != expresses) {
			NotificationChain msgs = null;
			if (expresses != null)
				msgs = ((InternalEObject)expresses).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES, null, msgs);
			if (newExpresses != null)
				msgs = ((InternalEObject)newExpresses).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES, null, msgs);
			msgs = basicSetExpresses(newExpresses, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES, newExpresses, newExpresses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureRationale> getRationales() {
		if (rationales == null) {
			rationales = new EObjectContainmentEList<ArchitectureRationale>(ArchitectureRationale.class, this, Iso42010Package.ARCHITECTURE_DESCRIPTION__RATIONALES);
		}
		return rationales;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Correspondence> getCorrespondences() {
		if (correspondences == null) {
			correspondences = new EObjectContainmentEList<Correspondence>(Correspondence.class, this, Iso42010Package.ARCHITECTURE_DESCRIPTION__CORRESPONDENCES);
		}
		return correspondences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CorrespondenceRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<CorrespondenceRule>(CorrespondenceRule.class, this, Iso42010Package.ARCHITECTURE_DESCRIPTION__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureDecision> getDecisions() {
		if (decisions == null) {
			decisions = new EObjectContainmentEList<ArchitectureDecision>(ArchitectureDecision.class, this, Iso42010Package.ARCHITECTURE_DESCRIPTION__DECISIONS);
		}
		return decisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__STAKEHOLDERS:
				return ((InternalEList<?>)getStakeholders()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CONCERNS:
				return ((InternalEList<?>)getConcerns()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWPOINTS:
				return ((InternalEList<?>)getViewpoints()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWS:
				return ((InternalEList<?>)getViews()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM:
				return basicSetSystem(null, msgs);
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES:
				return basicSetExpresses(null, msgs);
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RATIONALES:
				return ((InternalEList<?>)getRationales()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CORRESPONDENCES:
				return ((InternalEList<?>)getCorrespondences()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__DECISIONS:
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
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__STAKEHOLDERS:
				return getStakeholders();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CONCERNS:
				return getConcerns();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWPOINTS:
				return getViewpoints();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWS:
				return getViews();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM:
				return getSystem();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES:
				return getExpresses();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RATIONALES:
				return getRationales();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CORRESPONDENCES:
				return getCorrespondences();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RULES:
				return getRules();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__DECISIONS:
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
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__STAKEHOLDERS:
				getStakeholders().clear();
				getStakeholders().addAll((Collection<? extends Stakeholder>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CONCERNS:
				getConcerns().clear();
				getConcerns().addAll((Collection<? extends Concern>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWPOINTS:
				getViewpoints().clear();
				getViewpoints().addAll((Collection<? extends ArchitectureViewpoint>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWS:
				getViews().clear();
				getViews().addAll((Collection<? extends ArchitectureView>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM:
				setSystem((org.eclipse.papyrus.infra.viewpoints.iso42010.System)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES:
				setExpresses((Architecture)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RATIONALES:
				getRationales().clear();
				getRationales().addAll((Collection<? extends ArchitectureRationale>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CORRESPONDENCES:
				getCorrespondences().clear();
				getCorrespondences().addAll((Collection<? extends Correspondence>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends CorrespondenceRule>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__DECISIONS:
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
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__STAKEHOLDERS:
				getStakeholders().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CONCERNS:
				getConcerns().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWPOINTS:
				getViewpoints().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWS:
				getViews().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM:
				setSystem((org.eclipse.papyrus.infra.viewpoints.iso42010.System)null);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES:
				setExpresses((Architecture)null);
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RATIONALES:
				getRationales().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CORRESPONDENCES:
				getCorrespondences().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RULES:
				getRules().clear();
				return;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__DECISIONS:
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
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__STAKEHOLDERS:
				return stakeholders != null && !stakeholders.isEmpty();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CONCERNS:
				return concerns != null && !concerns.isEmpty();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWPOINTS:
				return viewpoints != null && !viewpoints.isEmpty();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWS:
				return views != null && !views.isEmpty();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM:
				return system != null;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES:
				return expresses != null;
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RATIONALES:
				return rationales != null && !rationales.isEmpty();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CORRESPONDENCES:
				return correspondences != null && !correspondences.isEmpty();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RULES:
				return rules != null && !rules.isEmpty();
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__DECISIONS:
				return decisions != null && !decisions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureDescriptionImpl
