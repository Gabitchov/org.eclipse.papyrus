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
package org.eclipse.papyrus.eastadl.requirements.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject;
import org.eclipse.papyrus.eastadl.requirements.RequirementsContainer;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Specification Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementSpecificationObjectImpl#getReferencingContainer <em>Referencing Container</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class RequirementSpecificationObjectImpl extends TraceableSpecificationImpl implements RequirementSpecificationObject {

	/**
	 * The cached value of the '{@link #getReferencingContainer() <em>Referencing Container</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getReferencingContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementsContainer> referencingContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RequirementSpecificationObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.REQUIREMENT_SPECIFICATION_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RequirementsContainer> getReferencingContainer() {
		if(referencingContainer == null) {
			referencingContainer = new EObjectResolvingEList<RequirementsContainer>(RequirementsContainer.class, this, RequirementsPackage.REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER);
		}
		return referencingContainer;
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
		case RequirementsPackage.REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER:
			return getReferencingContainer();
		}
		return super.eGet(featureID, resolve, coreType);
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
		case RequirementsPackage.REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER:
			getReferencingContainer().clear();
			getReferencingContainer().addAll((Collection<? extends RequirementsContainer>)newValue);
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
	public void eUnset(int featureID) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER:
			getReferencingContainer().clear();
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
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER:
			return referencingContainer != null && !referencingContainer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RequirementSpecificationObjectImpl
