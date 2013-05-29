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
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel;
import org.eclipse.papyrus.eastadl.variability.ConfigurableContainer;
import org.eclipse.papyrus.eastadl.variability.FeatureConfiguration;
import org.eclipse.papyrus.eastadl.variability.Variability;
import org.eclipse.papyrus.eastadl.variability.VariabilityPackage;
import org.eclipse.papyrus.eastadl.variability.VariableElement;
import org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl#getConfigurableContainer <em>Configurable Container</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl#getProductFeatureModel <em>Product Feature Model</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl#getDecisionModel <em>Decision Model</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl#getVariableElement <em>Variable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariabilityImpl extends ContextImpl implements Variability {
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
	 * The cached value of the '{@link #getConfigurableContainer() <em>Configurable Container</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurableContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigurableContainer> configurableContainer;

	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureConfiguration> configuration;

	/**
	 * The cached value of the '{@link #getProductFeatureModel() <em>Product Feature Model</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductFeatureModel()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureModel> productFeatureModel;

	/**
	 * The cached value of the '{@link #getDecisionModel() <em>Decision Model</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecisionModel()
	 * @generated
	 * @ordered
	 */
	protected EList<VehicleLevelBinding> decisionModel;

	/**
	 * The cached value of the '{@link #getVariableElement() <em>Variable Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableElement()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableElement> variableElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VariabilityPackage.VARIABILITY__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case VariabilityPackage.VARIABILITY__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case VariabilityPackage.VARIABILITY__CONFIGURABLE_CONTAINER:
				return getConfigurableContainer();
			case VariabilityPackage.VARIABILITY__CONFIGURATION:
				return getConfiguration();
			case VariabilityPackage.VARIABILITY__PRODUCT_FEATURE_MODEL:
				return getProductFeatureModel();
			case VariabilityPackage.VARIABILITY__DECISION_MODEL:
				return getDecisionModel();
			case VariabilityPackage.VARIABILITY__VARIABLE_ELEMENT:
				return getVariableElement();
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
			case VariabilityPackage.VARIABILITY__BASE_CLASS:
				return base_Class != null;
			case VariabilityPackage.VARIABILITY__BASE_PACKAGE:
				return base_Package != null;
			case VariabilityPackage.VARIABILITY__CONFIGURABLE_CONTAINER:
				return configurableContainer != null && !configurableContainer.isEmpty();
			case VariabilityPackage.VARIABILITY__CONFIGURATION:
				return configuration != null && !configuration.isEmpty();
			case VariabilityPackage.VARIABILITY__PRODUCT_FEATURE_MODEL:
				return productFeatureModel != null && !productFeatureModel.isEmpty();
			case VariabilityPackage.VARIABILITY__DECISION_MODEL:
				return decisionModel != null && !decisionModel.isEmpty();
			case VariabilityPackage.VARIABILITY__VARIABLE_ELEMENT:
				return variableElement != null && !variableElement.isEmpty();
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
			case VariabilityPackage.VARIABILITY__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case VariabilityPackage.VARIABILITY__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case VariabilityPackage.VARIABILITY__CONFIGURABLE_CONTAINER:
				getConfigurableContainer().clear();
				getConfigurableContainer().addAll((Collection<? extends ConfigurableContainer>)newValue);
				return;
			case VariabilityPackage.VARIABILITY__CONFIGURATION:
				getConfiguration().clear();
				getConfiguration().addAll((Collection<? extends FeatureConfiguration>)newValue);
				return;
			case VariabilityPackage.VARIABILITY__PRODUCT_FEATURE_MODEL:
				getProductFeatureModel().clear();
				getProductFeatureModel().addAll((Collection<? extends FeatureModel>)newValue);
				return;
			case VariabilityPackage.VARIABILITY__DECISION_MODEL:
				getDecisionModel().clear();
				getDecisionModel().addAll((Collection<? extends VehicleLevelBinding>)newValue);
				return;
			case VariabilityPackage.VARIABILITY__VARIABLE_ELEMENT:
				getVariableElement().clear();
				getVariableElement().addAll((Collection<? extends VariableElement>)newValue);
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
		return VariabilityPackage.Literals.VARIABILITY;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.VARIABILITY__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.VARIABILITY__BASE_CLASS, oldBase_Class, base_Class));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.VARIABILITY__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.VARIABILITY__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VariabilityPackage.VARIABILITY__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case VariabilityPackage.VARIABILITY__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case VariabilityPackage.VARIABILITY__CONFIGURABLE_CONTAINER:
				getConfigurableContainer().clear();
				return;
			case VariabilityPackage.VARIABILITY__CONFIGURATION:
				getConfiguration().clear();
				return;
			case VariabilityPackage.VARIABILITY__PRODUCT_FEATURE_MODEL:
				getProductFeatureModel().clear();
				return;
			case VariabilityPackage.VARIABILITY__DECISION_MODEL:
				getDecisionModel().clear();
				return;
			case VariabilityPackage.VARIABILITY__VARIABLE_ELEMENT:
				getVariableElement().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigurableContainer> getConfigurableContainer() {
		if (configurableContainer == null) {
			configurableContainer = new EObjectResolvingEList<ConfigurableContainer>(ConfigurableContainer.class, this, VariabilityPackage.VARIABILITY__CONFIGURABLE_CONTAINER);
		}
		return configurableContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureConfiguration> getConfiguration() {
		if (configuration == null) {
			configuration = new EObjectResolvingEList<FeatureConfiguration>(FeatureConfiguration.class, this, VariabilityPackage.VARIABILITY__CONFIGURATION);
		}
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VehicleLevelBinding> getDecisionModel() {
		if (decisionModel == null) {
			decisionModel = new EObjectResolvingEList<VehicleLevelBinding>(VehicleLevelBinding.class, this, VariabilityPackage.VARIABILITY__DECISION_MODEL);
		}
		return decisionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureModel> getProductFeatureModel() {
		if (productFeatureModel == null) {
			productFeatureModel = new EObjectResolvingEList<FeatureModel>(FeatureModel.class, this, VariabilityPackage.VARIABILITY__PRODUCT_FEATURE_MODEL);
		}
		return productFeatureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableElement> getVariableElement() {
		if (variableElement == null) {
			variableElement = new EObjectResolvingEList<VariableElement>(VariableElement.class, this, VariabilityPackage.VARIABILITY__VARIABLE_ELEMENT);
		}
		return variableElement;
	}

} //VariabilityImpl
