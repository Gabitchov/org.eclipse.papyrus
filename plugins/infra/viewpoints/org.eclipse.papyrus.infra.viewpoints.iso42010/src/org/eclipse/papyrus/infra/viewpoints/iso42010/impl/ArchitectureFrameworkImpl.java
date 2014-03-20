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

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Concern;
import org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture Framework</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureFrameworkImpl#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureFrameworkImpl#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureFrameworkImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureFrameworkImpl#getConcerns <em>Concerns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureFrameworkImpl extends MinimalEObjectImpl.Container implements ArchitectureFramework {
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
	 * The cached value of the '{@link #getViewpoints() <em>Viewpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureViewpoint> viewpoints;

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
	 * The cached value of the '{@link #getConcerns() <em>Concerns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcerns()
	 * @generated
	 * @ordered
	 */
	protected EList<Concern> concerns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureFrameworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.ARCHITECTURE_FRAMEWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getStakeholders() {
		if (stakeholders == null) {
			stakeholders = new EObjectContainmentEList<Stakeholder>(Stakeholder.class, this, Iso42010Package.ARCHITECTURE_FRAMEWORK__STAKEHOLDERS);
		}
		return stakeholders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureViewpoint> getViewpoints() {
		if (viewpoints == null) {
			viewpoints = new EObjectContainmentEList<ArchitectureViewpoint>(ArchitectureViewpoint.class, this, Iso42010Package.ARCHITECTURE_FRAMEWORK__VIEWPOINTS);
		}
		return viewpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CorrespondenceRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<CorrespondenceRule>(CorrespondenceRule.class, this, Iso42010Package.ARCHITECTURE_FRAMEWORK__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Concern> getConcerns() {
		if (concerns == null) {
			concerns = new EObjectContainmentEList<Concern>(Concern.class, this, Iso42010Package.ARCHITECTURE_FRAMEWORK__CONCERNS);
		}
		return concerns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__STAKEHOLDERS:
				return ((InternalEList<?>)getStakeholders()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__VIEWPOINTS:
				return ((InternalEList<?>)getViewpoints()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__CONCERNS:
				return ((InternalEList<?>)getConcerns()).basicRemove(otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__STAKEHOLDERS:
				return getStakeholders();
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__VIEWPOINTS:
				return getViewpoints();
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__RULES:
				return getRules();
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__CONCERNS:
				return getConcerns();
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
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__STAKEHOLDERS:
				getStakeholders().clear();
				getStakeholders().addAll((Collection<? extends Stakeholder>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__VIEWPOINTS:
				getViewpoints().clear();
				getViewpoints().addAll((Collection<? extends ArchitectureViewpoint>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends CorrespondenceRule>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__CONCERNS:
				getConcerns().clear();
				getConcerns().addAll((Collection<? extends Concern>)newValue);
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
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__STAKEHOLDERS:
				getStakeholders().clear();
				return;
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__VIEWPOINTS:
				getViewpoints().clear();
				return;
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__RULES:
				getRules().clear();
				return;
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__CONCERNS:
				getConcerns().clear();
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
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__STAKEHOLDERS:
				return stakeholders != null && !stakeholders.isEmpty();
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__VIEWPOINTS:
				return viewpoints != null && !viewpoints.isEmpty();
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__RULES:
				return rules != null && !rules.isEmpty();
			case Iso42010Package.ARCHITECTURE_FRAMEWORK__CONCERNS:
				return concerns != null && !concerns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureFrameworkImpl
