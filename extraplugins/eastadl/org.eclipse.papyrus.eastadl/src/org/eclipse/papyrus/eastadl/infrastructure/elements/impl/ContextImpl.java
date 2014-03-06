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
package org.eclipse.papyrus.eastadl.infrastructure.elements.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Relationship;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl#getTraceableSpecification <em>Traceable Specification</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl#getOwnedRelationship <em>Owned Relationship</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ContextImpl extends EAElementImpl implements Context {

	/**
	 * The cached value of the '{@link #getTraceableSpecification() <em>Traceable Specification</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTraceableSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceableSpecification> traceableSpecification;

	/**
	 * The cached value of the '{@link #getOwnedRelationship() <em>Owned Relationship</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOwnedRelationship()
	 * @generated
	 * @ordered
	 */
	protected EList<Relationship> ownedRelationship;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ContextImpl() {
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
		case ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION:
			return getTraceableSpecification();
		case ElementsPackage.CONTEXT__OWNED_RELATIONSHIP:
			return getOwnedRelationship();
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
		case ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION:
			return traceableSpecification != null && !traceableSpecification.isEmpty();
		case ElementsPackage.CONTEXT__OWNED_RELATIONSHIP:
			return ownedRelationship != null && !ownedRelationship.isEmpty();
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
		case ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION:
			getTraceableSpecification().clear();
			getTraceableSpecification().addAll((Collection<? extends TraceableSpecification>)newValue);
			return;
		case ElementsPackage.CONTEXT__OWNED_RELATIONSHIP:
			getOwnedRelationship().clear();
			getOwnedRelationship().addAll((Collection<? extends Relationship>)newValue);
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
		return ElementsPackage.Literals.CONTEXT;
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
		case ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION:
			getTraceableSpecification().clear();
			return;
		case ElementsPackage.CONTEXT__OWNED_RELATIONSHIP:
			getOwnedRelationship().clear();
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
	public EList<Relationship> getOwnedRelationship() {
		if(ownedRelationship == null) {
			ownedRelationship = new EObjectResolvingEList<Relationship>(Relationship.class, this, ElementsPackage.CONTEXT__OWNED_RELATIONSHIP);
		}
		return ownedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<TraceableSpecification> getTraceableSpecification() {
		if(traceableSpecification == null) {
			traceableSpecification = new EObjectResolvingEList<TraceableSpecification>(TraceableSpecification.class, this, ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION);
		}
		return traceableSpecification;
	}

} //ContextImpl
