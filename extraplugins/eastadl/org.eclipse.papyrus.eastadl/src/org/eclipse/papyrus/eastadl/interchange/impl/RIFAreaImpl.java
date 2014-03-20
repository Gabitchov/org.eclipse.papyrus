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
package org.eclipse.papyrus.eastadl.interchange.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.interchange.InterchangePackage;
import org.eclipse.papyrus.eastadl.interchange.RIFArea;
import org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject;
import org.eclipse.papyrus.eastadl.requirements.RequirementsContainer;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>RIF Area</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.interchange.impl.RIFAreaImpl#getRootRequirementContainer <em>Root Requirement Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.interchange.impl.RIFAreaImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.interchange.impl.RIFAreaImpl#getInterchangeReqSpecObject <em>Interchange Req Spec Object</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class RIFAreaImpl extends ContextImpl implements RIFArea {

	/**
	 * The cached value of the '{@link #getRootRequirementContainer() <em>Root Requirement Container</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRootRequirementContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementsContainer> rootRequirementContainer;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getInterchangeReqSpecObject() <em>Interchange Req Spec Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getInterchangeReqSpecObject()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementSpecificationObject> interchangeReqSpecObject;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RIFAreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case InterchangePackage.RIF_AREA__ROOT_REQUIREMENT_CONTAINER:
			return getRootRequirementContainer();
		case InterchangePackage.RIF_AREA__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case InterchangePackage.RIF_AREA__INTERCHANGE_REQ_SPEC_OBJECT:
			return getInterchangeReqSpecObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case InterchangePackage.RIF_AREA__ROOT_REQUIREMENT_CONTAINER:
			return rootRequirementContainer != null && !rootRequirementContainer.isEmpty();
		case InterchangePackage.RIF_AREA__BASE_CLASS:
			return base_Class != null;
		case InterchangePackage.RIF_AREA__INTERCHANGE_REQ_SPEC_OBJECT:
			return interchangeReqSpecObject != null && !interchangeReqSpecObject.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case InterchangePackage.RIF_AREA__ROOT_REQUIREMENT_CONTAINER:
			getRootRequirementContainer().clear();
			getRootRequirementContainer().addAll((Collection<? extends RequirementsContainer>)newValue);
			return;
		case InterchangePackage.RIF_AREA__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case InterchangePackage.RIF_AREA__INTERCHANGE_REQ_SPEC_OBJECT:
			getInterchangeReqSpecObject().clear();
			getInterchangeReqSpecObject().addAll((Collection<? extends RequirementSpecificationObject>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InterchangePackage.Literals.RIF_AREA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case InterchangePackage.RIF_AREA__ROOT_REQUIREMENT_CONTAINER:
			getRootRequirementContainer().clear();
			return;
		case InterchangePackage.RIF_AREA__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case InterchangePackage.RIF_AREA__INTERCHANGE_REQ_SPEC_OBJECT:
			getInterchangeReqSpecObject().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if(base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if(base_Class != oldBase_Class) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InterchangePackage.RIF_AREA__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RequirementSpecificationObject> getInterchangeReqSpecObject() {
		if(interchangeReqSpecObject == null) {
			interchangeReqSpecObject = new EObjectResolvingEList<RequirementSpecificationObject>(RequirementSpecificationObject.class, this, InterchangePackage.RIF_AREA__INTERCHANGE_REQ_SPEC_OBJECT);
		}
		return interchangeReqSpecObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RequirementsContainer> getRootRequirementContainer() {
		if(rootRequirementContainer == null) {
			rootRequirementContainer = new EObjectResolvingEList<RequirementsContainer>(RequirementsContainer.class, this, InterchangePackage.RIF_AREA__ROOT_REQUIREMENT_CONTAINER);
		}
		return rootRequirementContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InterchangePackage.RIF_AREA__BASE_CLASS, oldBase_Class, base_Class));
	}

} // RIFAreaImpl
