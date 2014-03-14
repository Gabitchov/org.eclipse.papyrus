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
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture Rationale</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureRationaleImpl#getJustifies <em>Justifies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureRationaleImpl extends ADElementImpl implements ArchitectureRationale {
	/**
	 * The cached value of the '{@link #getJustifies() <em>Justifies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJustifies()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureDecision> justifies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureRationaleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.ARCHITECTURE_RATIONALE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureDecision> getJustifies() {
		if (justifies == null) {
			justifies = new EObjectWithInverseResolvingEList.ManyInverse<ArchitectureDecision>(ArchitectureDecision.class, this, Iso42010Package.ARCHITECTURE_RATIONALE__JUSTIFIES, Iso42010Package.ARCHITECTURE_DECISION__JUSTIFIED_BY);
		}
		return justifies;
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
			case Iso42010Package.ARCHITECTURE_RATIONALE__JUSTIFIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getJustifies()).basicAdd(otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_RATIONALE__JUSTIFIES:
				return ((InternalEList<?>)getJustifies()).basicRemove(otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_RATIONALE__JUSTIFIES:
				return getJustifies();
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
			case Iso42010Package.ARCHITECTURE_RATIONALE__JUSTIFIES:
				getJustifies().clear();
				getJustifies().addAll((Collection<? extends ArchitectureDecision>)newValue);
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
			case Iso42010Package.ARCHITECTURE_RATIONALE__JUSTIFIES:
				getJustifies().clear();
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
			case Iso42010Package.ARCHITECTURE_RATIONALE__JUSTIFIES:
				return justifies != null && !justifies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureRationaleImpl
