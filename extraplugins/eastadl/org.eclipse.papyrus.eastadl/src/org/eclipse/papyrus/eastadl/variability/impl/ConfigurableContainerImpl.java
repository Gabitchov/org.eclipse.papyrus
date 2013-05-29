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
package org.eclipse.papyrus.eastadl.variability.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel;
import org.eclipse.papyrus.eastadl.variability.ConfigurableContainer;
import org.eclipse.papyrus.eastadl.variability.InternalBinding;
import org.eclipse.papyrus.eastadl.variability.VariabilityPackage;
import org.eclipse.papyrus.eastadl.variability.VariationGroup;
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configurable Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl#getInternalBinding <em>Internal Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl#getVariationGroup <em>Variation Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl#getConfigurableElement <em>Configurable Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl#getPublicFeatureModel <em>Public Feature Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurableContainerImpl extends EAElementImpl implements ConfigurableContainer {
	/**
	 * The cached value of the '{@link #getInternalBinding() <em>Internal Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalBinding()
	 * @generated
	 * @ordered
	 */
	protected InternalBinding internalBinding;

	/**
	 * The cached value of the '{@link #getVariationGroup() <em>Variation Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariationGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationGroup> variationGroup;

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
	 * The cached value of the '{@link #getConfigurableElement() <em>Configurable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurableElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement configurableElement;

	/**
	 * The cached value of the '{@link #getPublicFeatureModel() <em>Public Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicFeatureModel()
	 * @generated
	 * @ordered
	 */
	protected FeatureModel publicFeatureModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurableContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetConfigurableElement() {
		return configurableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalBinding basicGetInternalBinding() {
		return internalBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureModel basicGetPublicFeatureModel() {
		return publicFeatureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VariabilityPackage.CONFIGURABLE_CONTAINER__INTERNAL_BINDING:
				if (resolve) return getInternalBinding();
				return basicGetInternalBinding();
			case VariabilityPackage.CONFIGURABLE_CONTAINER__VARIATION_GROUP:
				return getVariationGroup();
			case VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case VariabilityPackage.CONFIGURABLE_CONTAINER__CONFIGURABLE_ELEMENT:
				if (resolve) return getConfigurableElement();
				return basicGetConfigurableElement();
			case VariabilityPackage.CONFIGURABLE_CONTAINER__PUBLIC_FEATURE_MODEL:
				if (resolve) return getPublicFeatureModel();
				return basicGetPublicFeatureModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VariabilityPackage.CONFIGURABLE_CONTAINER__INTERNAL_BINDING:
				return internalBinding != null;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__VARIATION_GROUP:
				return variationGroup != null && !variationGroup.isEmpty();
			case VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_CLASS:
				return base_Class != null;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_PACKAGE:
				return base_Package != null;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__CONFIGURABLE_ELEMENT:
				return configurableElement != null;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__PUBLIC_FEATURE_MODEL:
				return publicFeatureModel != null;
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
			case VariabilityPackage.CONFIGURABLE_CONTAINER__INTERNAL_BINDING:
				setInternalBinding((InternalBinding)newValue);
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__VARIATION_GROUP:
				getVariationGroup().clear();
				getVariationGroup().addAll((Collection<? extends VariationGroup>)newValue);
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__CONFIGURABLE_ELEMENT:
				setConfigurableElement((NamedElement)newValue);
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__PUBLIC_FEATURE_MODEL:
				setPublicFeatureModel((FeatureModel)newValue);
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
		return VariabilityPackage.Literals.CONFIGURABLE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VariabilityPackage.CONFIGURABLE_CONTAINER__INTERNAL_BINDING:
				setInternalBinding((InternalBinding)null);
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__VARIATION_GROUP:
				getVariationGroup().clear();
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__CONFIGURABLE_ELEMENT:
				setConfigurableElement((NamedElement)null);
				return;
			case VariabilityPackage.CONFIGURABLE_CONTAINER__PUBLIC_FEATURE_MODEL:
				setPublicFeatureModel((FeatureModel)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getConfigurableElement() {
		if (configurableElement != null && configurableElement.eIsProxy()) {
			InternalEObject oldConfigurableElement = (InternalEObject)configurableElement;
			configurableElement = (NamedElement)eResolveProxy(oldConfigurableElement);
			if (configurableElement != oldConfigurableElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.CONFIGURABLE_CONTAINER__CONFIGURABLE_ELEMENT, oldConfigurableElement, configurableElement));
			}
		}
		return configurableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalBinding getInternalBinding() {
		if (internalBinding != null && internalBinding.eIsProxy()) {
			InternalEObject oldInternalBinding = (InternalEObject)internalBinding;
			internalBinding = (InternalBinding)eResolveProxy(oldInternalBinding);
			if (internalBinding != oldInternalBinding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.CONFIGURABLE_CONTAINER__INTERNAL_BINDING, oldInternalBinding, internalBinding));
			}
		}
		return internalBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureModel getPublicFeatureModel() {
		if (publicFeatureModel != null && publicFeatureModel.eIsProxy()) {
			InternalEObject oldPublicFeatureModel = (InternalEObject)publicFeatureModel;
			publicFeatureModel = (FeatureModel)eResolveProxy(oldPublicFeatureModel);
			if (publicFeatureModel != oldPublicFeatureModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.CONFIGURABLE_CONTAINER__PUBLIC_FEATURE_MODEL, oldPublicFeatureModel, publicFeatureModel));
			}
		}
		return publicFeatureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariationGroup> getVariationGroup() {
		if (variationGroup == null) {
			variationGroup = new EObjectResolvingEList<VariationGroup>(VariationGroup.class, this, VariabilityPackage.CONFIGURABLE_CONTAINER__VARIATION_GROUP);
		}
		return variationGroup;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_CLASS, oldBase_Class, base_Class));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.CONFIGURABLE_CONTAINER__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurableElement(NamedElement newConfigurableElement) {
		NamedElement oldConfigurableElement = configurableElement;
		configurableElement = newConfigurableElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.CONFIGURABLE_CONTAINER__CONFIGURABLE_ELEMENT, oldConfigurableElement, configurableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalBinding(InternalBinding newInternalBinding) {
		InternalBinding oldInternalBinding = internalBinding;
		internalBinding = newInternalBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.CONFIGURABLE_CONTAINER__INTERNAL_BINDING, oldInternalBinding, internalBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicFeatureModel(FeatureModel newPublicFeatureModel) {
		FeatureModel oldPublicFeatureModel = publicFeatureModel;
		publicFeatureModel = newPublicFeatureModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.CONFIGURABLE_CONTAINER__PUBLIC_FEATURE_MODEL, oldPublicFeatureModel, publicFeatureModel));
	}

} //ConfigurableContainerImpl
