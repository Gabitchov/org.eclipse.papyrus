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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject;
import org.eclipse.papyrus.eastadl.requirements.RequirementsContainer;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl#getChildContainer <em>Child Container</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl#getParentContainer <em>Parent Container</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl#getContainedReqSpecObject <em>Contained Req Spec Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementsContainerImpl extends TraceableSpecificationImpl implements RequirementsContainer {
	/**
	 * The cached value of the '{@link #getChildContainer() <em>Child Container</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementsContainer> childContainer;

	/**
	 * The cached value of the '{@link #getParentContainer() <em>Parent Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentContainer()
	 * @generated
	 * @ordered
	 */
	protected RequirementsContainer parentContainer;

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
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * The cached value of the '{@link #getContainedReqSpecObject() <em>Contained Req Spec Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedReqSpecObject()
	 * @generated
	 * @ordered
	 */
	protected RequirementSpecificationObject containedReqSpecObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementsContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpecificationObject basicGetContainedReqSpecObject() {
		return containedReqSpecObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsContainer basicGetParentContainer() {
		return parentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentContainer(RequirementsContainer newParentContainer, NotificationChain msgs) {
		RequirementsContainer oldParentContainer = parentContainer;
		parentContainer = newParentContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER, oldParentContainer, newParentContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER:
				return getChildContainer();
			case RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER:
				if (resolve) return getParentContainer();
				return basicGetParentContainer();
			case RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT:
				if (resolve) return getContainedReqSpecObject();
				return basicGetContainedReqSpecObject();
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildContainer()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER:
				if (parentContainer != null)
					msgs = ((InternalEObject)parentContainer).eInverseRemove(this, RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER, RequirementsContainer.class, msgs);
				return basicSetParentContainer((RequirementsContainer)otherEnd, msgs);
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
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER:
				return ((InternalEList<?>)getChildContainer()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER:
				return basicSetParentContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER:
				return childContainer != null && !childContainer.isEmpty();
			case RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER:
				return parentContainer != null;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_CLASS:
				return base_Class != null;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGE:
				return base_Package != null;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT:
				return containedReqSpecObject != null;
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
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER:
				getChildContainer().clear();
				getChildContainer().addAll((Collection<? extends RequirementsContainer>)newValue);
				return;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER:
				setParentContainer((RequirementsContainer)newValue);
				return;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT:
				setContainedReqSpecObject((RequirementSpecificationObject)newValue);
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
		return RequirementsPackage.Literals.REQUIREMENTS_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER:
				getChildContainer().clear();
				return;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER:
				setParentContainer((RequirementsContainer)null);
				return;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case RequirementsPackage.REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT:
				setContainedReqSpecObject((RequirementSpecificationObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequirementsContainer> getChildContainer() {
		if (childContainer == null) {
			childContainer = new EObjectWithInverseResolvingEList<RequirementsContainer>(RequirementsContainer.class, this, RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER, RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER);
		}
		return childContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpecificationObject getContainedReqSpecObject() {
		if (containedReqSpecObject != null && containedReqSpecObject.eIsProxy()) {
			InternalEObject oldContainedReqSpecObject = (InternalEObject)containedReqSpecObject;
			containedReqSpecObject = (RequirementSpecificationObject)eResolveProxy(oldContainedReqSpecObject);
			if (containedReqSpecObject != oldContainedReqSpecObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT, oldContainedReqSpecObject, containedReqSpecObject));
			}
		}
		return containedReqSpecObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsContainer getParentContainer() {
		if (parentContainer != null && parentContainer.eIsProxy()) {
			InternalEObject oldParentContainer = (InternalEObject)parentContainer;
			parentContainer = (RequirementsContainer)eResolveProxy(oldParentContainer);
			if (parentContainer != oldParentContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER, oldParentContainer, parentContainer));
			}
		}
		return parentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedReqSpecObject(RequirementSpecificationObject newContainedReqSpecObject) {
		RequirementSpecificationObject oldContainedReqSpecObject = containedReqSpecObject;
		containedReqSpecObject = newContainedReqSpecObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT, oldContainedReqSpecObject, containedReqSpecObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentContainer(RequirementsContainer newParentContainer) {
		if (newParentContainer != parentContainer) {
			NotificationChain msgs = null;
			if (parentContainer != null)
				msgs = ((InternalEObject)parentContainer).eInverseRemove(this, RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER, RequirementsContainer.class, msgs);
			if (newParentContainer != null)
				msgs = ((InternalEObject)newParentContainer).eInverseAdd(this, RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER, RequirementsContainer.class, msgs);
			msgs = basicSetParentContainer(newParentContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER, newParentContainer, newParentContainer));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGE, oldBase_Package, base_Package));
	}

} //RequirementsContainerImpl
