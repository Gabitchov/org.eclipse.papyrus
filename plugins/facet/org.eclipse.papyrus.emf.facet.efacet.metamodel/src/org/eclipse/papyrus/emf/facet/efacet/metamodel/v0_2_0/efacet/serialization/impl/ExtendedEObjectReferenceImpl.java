/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended EObject Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.ExtendedEObjectReferenceImpl#getExtendedEObject <em>Extended EObject</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.ExtendedEObjectReferenceImpl#getAttributeInstances <em>Attribute Instances</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.ExtendedEObjectReferenceImpl#getReferenceInstances <em>Reference Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendedEObjectReferenceImpl extends EObjectImpl implements ExtendedEObjectReference {
	/**
	 * The cached value of the '{@link #getExtendedEObject() <em>Extended EObject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedEObject()
	 * @generated
	 * @ordered
	 */
	protected EObject extendedEObject;

	/**
	 * The cached value of the '{@link #getAttributeInstances() <em>Attribute Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAttributeInstance> attributeInstances;

	/**
	 * The cached value of the '{@link #getReferenceInstances() <em>Reference Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractReferenceInstance> referenceInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendedEObjectReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getExtendedEObject() {
		if (extendedEObject != null && extendedEObject.eIsProxy()) {
			InternalEObject oldExtendedEObject = (InternalEObject)extendedEObject;
			extendedEObject = eResolveProxy(oldExtendedEObject);
			if (extendedEObject != oldExtendedEObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SerializationPackage.EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT, oldExtendedEObject, extendedEObject));
			}
		}
		return extendedEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetExtendedEObject() {
		return extendedEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedEObject(EObject newExtendedEObject) {
		EObject oldExtendedEObject = extendedEObject;
		extendedEObject = newExtendedEObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializationPackage.EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT, oldExtendedEObject, extendedEObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAttributeInstance> getAttributeInstances() {
		if (attributeInstances == null) {
			attributeInstances = new EObjectContainmentEList<AbstractAttributeInstance>(AbstractAttributeInstance.class, this, SerializationPackage.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES);
		}
		return attributeInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractReferenceInstance> getReferenceInstances() {
		if (referenceInstances == null) {
			referenceInstances = new EObjectContainmentEList<AbstractReferenceInstance>(AbstractReferenceInstance.class, this, SerializationPackage.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES);
		}
		return referenceInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES:
				return ((InternalEList<?>)getAttributeInstances()).basicRemove(otherEnd, msgs);
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES:
				return ((InternalEList<?>)getReferenceInstances()).basicRemove(otherEnd, msgs);
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
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT:
				if (resolve) return getExtendedEObject();
				return basicGetExtendedEObject();
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES:
				return getAttributeInstances();
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES:
				return getReferenceInstances();
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
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT:
				setExtendedEObject((EObject)newValue);
				return;
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES:
				getAttributeInstances().clear();
				getAttributeInstances().addAll((Collection<? extends AbstractAttributeInstance>)newValue);
				return;
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES:
				getReferenceInstances().clear();
				getReferenceInstances().addAll((Collection<? extends AbstractReferenceInstance>)newValue);
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
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT:
				setExtendedEObject((EObject)null);
				return;
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES:
				getAttributeInstances().clear();
				return;
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES:
				getReferenceInstances().clear();
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
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT:
				return extendedEObject != null;
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES:
				return attributeInstances != null && !attributeInstances.isEmpty();
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES:
				return referenceInstances != null && !referenceInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExtendedEObjectReferenceImpl
