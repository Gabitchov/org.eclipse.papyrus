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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription;
import org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalModel;
import org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage;
import org.eclipse.papyrus.eastadl.annex.needs.Stakeholder;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architectural Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalDescriptionImpl#getAggregates <em>Aggregates</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalDescriptionImpl#getIdentifies <em>Identifies</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ArchitecturalDescriptionImpl extends ConceptImpl implements ArchitecturalDescription {

	/**
	 * The cached value of the '{@link #getAggregates() <em>Aggregates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAggregates()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitecturalModel> aggregates;

	/**
	 * The cached value of the '{@link #getIdentifies() <em>Identifies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIdentifies()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> identifies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ArchitecturalDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case NeedsPackage.ARCHITECTURAL_DESCRIPTION__AGGREGATES:
			return getAggregates();
		case NeedsPackage.ARCHITECTURAL_DESCRIPTION__IDENTIFIES:
			return getIdentifies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case NeedsPackage.ARCHITECTURAL_DESCRIPTION__AGGREGATES:
			return aggregates != null && !aggregates.isEmpty();
		case NeedsPackage.ARCHITECTURAL_DESCRIPTION__IDENTIFIES:
			return identifies != null && !identifies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case NeedsPackage.ARCHITECTURAL_DESCRIPTION__AGGREGATES:
			getAggregates().clear();
			getAggregates().addAll((Collection<? extends ArchitecturalModel>)newValue);
			return;
		case NeedsPackage.ARCHITECTURAL_DESCRIPTION__IDENTIFIES:
			getIdentifies().clear();
			getIdentifies().addAll((Collection<? extends Stakeholder>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NeedsPackage.Literals.ARCHITECTURAL_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case NeedsPackage.ARCHITECTURAL_DESCRIPTION__AGGREGATES:
			getAggregates().clear();
			return;
		case NeedsPackage.ARCHITECTURAL_DESCRIPTION__IDENTIFIES:
			getIdentifies().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ArchitecturalModel> getAggregates() {
		if(aggregates == null) {
			aggregates = new EObjectResolvingEList<ArchitecturalModel>(ArchitecturalModel.class, this, NeedsPackage.ARCHITECTURAL_DESCRIPTION__AGGREGATES);
		}
		return aggregates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Stakeholder> getIdentifies() {
		if(identifies == null) {
			identifies = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, NeedsPackage.ARCHITECTURAL_DESCRIPTION__IDENTIFIES);
		}
		return identifies;
	}

} //ArchitecturalDescriptionImpl
