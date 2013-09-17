/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerApplicationFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerStackDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModel;
import org.eclipse.papyrus.layers.stackmodel.layers.loaders.RegistriesLoader;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getLayersStacks <em>Layers Stacks</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getLayerStackRegistry <em>Layer Stack Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getPropertyRegistry <em>Property Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getLayerDescriptorRegistry <em>Layer Descriptor Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getFactory <em>Factory</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getPropertySetterRegistry <em>Property Setter Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getLayerOperatorDescriptorRegistry <em>Layer Operator Descriptor Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayersStackApplicationImpl extends 
FolderElementImpl implements LayersStackApplication {
	/**
	 * The cached value of the '{@link #getLayersStacks() <em>Layers Stacks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayersStacks()
	 * @generated
	 * @ordered
	 */
	protected EList<LayersStack> layersStacks;

	/**
	 * The cached value of the '{@link #getLayerStackRegistry() <em>Layer Stack Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerStackRegistry()
	 * @generated
	 * @ordered
	 */
	protected LayerStackDescriptorRegistry layerStackRegistry;
	/**
	 * The cached value of the '{@link #getPropertyRegistry() <em>Property Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyRegistry()
	 * @generated
	 * @ordered
	 */
	protected PropertyRegistry propertyRegistry;

	/**
	 * The cached value of the '{@link #getLayerDescriptorRegistry() <em>Layer Descriptor Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerDescriptorRegistry()
	 * @generated
	 * @ordered
	 */
	protected LayerDescriptorRegistry layerDescriptorRegistry;

	/**
	 * The cached value of the '{@link #getFactory() <em>Factory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected LayerApplicationFactory factory;

	/**
	 * The cached value of the '{@link #getPropertySetterRegistry() <em>Property Setter Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertySetterRegistry()
	 * @generated
	 * @ordered
	 */
	protected PropertySetterRegistry propertySetterRegistry;

	/**
	 * The cached value of the '{@link #getLayerOperatorDescriptorRegistry() <em>Layer Operator Descriptor Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerOperatorDescriptorRegistry()
	 * @generated
	 * @ordered
	 */
	protected LayerOperatorDescriptorRegistry layerOperatorDescriptorRegistry;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LayersStackApplicationImpl() {
		super();
		init();
	}

	/**
	 * Init the class
	 * Create the internal objects : {@link PropertyRegistry}, {@link LayerStackDescriptorRegistry}.
	 */
	protected void init() {
		// Create the PropertyRegistry
		PropertyRegistry propertyRegistry = LayersFactory.eINSTANCE.createPropertyRegistry();
		setPropertyRegistry(propertyRegistry);
		
		// Create the LayerStackDescriptorRegistry
		LayerStackDescriptorRegistry layerStackDescriptorRegistry = LayersFactory.eINSTANCE.createLayerStackDescriptorRegistry();
		setLayerStackRegistry(layerStackDescriptorRegistry);

		// Create the LayerDescriptorRegistry
		LayerDescriptorRegistry layerDescriptorRegistry = LayersFactory.eINSTANCE.createLayerDescriptorRegistry();
		setLayerDescriptorRegistry(layerDescriptorRegistry);

		// Create the config model and the registries loader
		LayersConfigModel configModel = LayersConfigModel.getInstance();
		RegistriesLoader registriesLoader = new RegistriesLoader(configModel);
		
		// Create the LayerOperatorDescriptorRegistry
		LayerOperatorDescriptorRegistry layerOperatorDescriptorRegistry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		layerOperatorDescriptorRegistry.setPropertyCollectionSize(propertyRegistry.getPropertiesCount());

		registriesLoader.loadLayerOperatorDescriptorRegistry(layerOperatorDescriptorRegistry, propertyRegistry);
		setLayerOperatorDescriptorRegistry(layerOperatorDescriptorRegistry);

		// Create the LayerApplicationFactory
		LayerApplicationFactory layerApplicationFactory = LayersFactory.eINSTANCE.createLayerApplicationFactory();
		setFactory(layerApplicationFactory);
		
		// Create the PropertySetterRegistry
		PropertySetterRegistry propertySetterRegistry = LayersFactory.eINSTANCE.createPropertySetterRegistry();
		propertySetterRegistry.setApplication(this);
		setPropertySetterRegistry(propertySetterRegistry);
		
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYERS_STACK_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LayersStack> getLayersStacks() {
		if (layersStacks == null) {
			layersStacks = new EObjectContainmentEList<LayersStack>(LayersStack.class, this, LayersPackage.LAYERS_STACK_APPLICATION__LAYERS_STACKS);
		}
		return layersStacks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerStackDescriptorRegistry getLayerStackRegistry() {
		return layerStackRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayerStackRegistry(LayerStackDescriptorRegistry newLayerStackRegistry, NotificationChain msgs) {
		LayerStackDescriptorRegistry oldLayerStackRegistry = layerStackRegistry;
		layerStackRegistry = newLayerStackRegistry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY, oldLayerStackRegistry, newLayerStackRegistry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerStackRegistry(LayerStackDescriptorRegistry newLayerStackRegistry) {
		if (newLayerStackRegistry != layerStackRegistry) {
			NotificationChain msgs = null;
			if (layerStackRegistry != null)
				msgs = ((InternalEObject)layerStackRegistry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY, null, msgs);
			if (newLayerStackRegistry != null)
				msgs = ((InternalEObject)newLayerStackRegistry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY, null, msgs);
			msgs = basicSetLayerStackRegistry(newLayerStackRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY, newLayerStackRegistry, newLayerStackRegistry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyRegistry getPropertyRegistry() {
		return propertyRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropertyRegistry(PropertyRegistry newPropertyRegistry, NotificationChain msgs) {
		PropertyRegistry oldPropertyRegistry = propertyRegistry;
		propertyRegistry = newPropertyRegistry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY, oldPropertyRegistry, newPropertyRegistry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyRegistry(PropertyRegistry newPropertyRegistry) {
		if (newPropertyRegistry != propertyRegistry) {
			NotificationChain msgs = null;
			if (propertyRegistry != null)
				msgs = ((InternalEObject)propertyRegistry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY, null, msgs);
			if (newPropertyRegistry != null)
				msgs = ((InternalEObject)newPropertyRegistry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY, null, msgs);
			msgs = basicSetPropertyRegistry(newPropertyRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY, newPropertyRegistry, newPropertyRegistry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerDescriptorRegistry getLayerDescriptorRegistry() {
		return layerDescriptorRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayerDescriptorRegistry(LayerDescriptorRegistry newLayerDescriptorRegistry, NotificationChain msgs) {
		LayerDescriptorRegistry oldLayerDescriptorRegistry = layerDescriptorRegistry;
		layerDescriptorRegistry = newLayerDescriptorRegistry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY, oldLayerDescriptorRegistry, newLayerDescriptorRegistry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerDescriptorRegistry(LayerDescriptorRegistry newLayerDescriptorRegistry) {
		if (newLayerDescriptorRegistry != layerDescriptorRegistry) {
			NotificationChain msgs = null;
			if (layerDescriptorRegistry != null)
				msgs = ((InternalEObject)layerDescriptorRegistry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY, null, msgs);
			if (newLayerDescriptorRegistry != null)
				msgs = ((InternalEObject)newLayerDescriptorRegistry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY, null, msgs);
			msgs = basicSetLayerDescriptorRegistry(newLayerDescriptorRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY, newLayerDescriptorRegistry, newLayerDescriptorRegistry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerApplicationFactory getFactory() {
		return factory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFactory(LayerApplicationFactory newFactory, NotificationChain msgs) {
		LayerApplicationFactory oldFactory = factory;
		factory = newFactory;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__FACTORY, oldFactory, newFactory);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactory(LayerApplicationFactory newFactory) {
		if (newFactory != factory) {
			NotificationChain msgs = null;
			if (factory != null)
				msgs = ((InternalEObject)factory).eInverseRemove(this, LayersPackage.LAYER_APPLICATION_FACTORY__APPLICATION, LayerApplicationFactory.class, msgs);
			if (newFactory != null)
				msgs = ((InternalEObject)newFactory).eInverseAdd(this, LayersPackage.LAYER_APPLICATION_FACTORY__APPLICATION, LayerApplicationFactory.class, msgs);
			msgs = basicSetFactory(newFactory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__FACTORY, newFactory, newFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySetterRegistry getPropertySetterRegistry() {
		return propertySetterRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropertySetterRegistry(PropertySetterRegistry newPropertySetterRegistry, NotificationChain msgs) {
		PropertySetterRegistry oldPropertySetterRegistry = propertySetterRegistry;
		propertySetterRegistry = newPropertySetterRegistry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY, oldPropertySetterRegistry, newPropertySetterRegistry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertySetterRegistry(PropertySetterRegistry newPropertySetterRegistry) {
		if (newPropertySetterRegistry != propertySetterRegistry) {
			NotificationChain msgs = null;
			if (propertySetterRegistry != null)
				msgs = ((InternalEObject)propertySetterRegistry).eInverseRemove(this, LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION, PropertySetterRegistry.class, msgs);
			if (newPropertySetterRegistry != null)
				msgs = ((InternalEObject)newPropertySetterRegistry).eInverseAdd(this, LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION, PropertySetterRegistry.class, msgs);
			msgs = basicSetPropertySetterRegistry(newPropertySetterRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY, newPropertySetterRegistry, newPropertySetterRegistry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorDescriptorRegistry getLayerOperatorDescriptorRegistry() {
		return layerOperatorDescriptorRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayerOperatorDescriptorRegistry(LayerOperatorDescriptorRegistry newLayerOperatorDescriptorRegistry, NotificationChain msgs) {
		LayerOperatorDescriptorRegistry oldLayerOperatorDescriptorRegistry = layerOperatorDescriptorRegistry;
		layerOperatorDescriptorRegistry = newLayerOperatorDescriptorRegistry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY, oldLayerOperatorDescriptorRegistry, newLayerOperatorDescriptorRegistry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerOperatorDescriptorRegistry(LayerOperatorDescriptorRegistry newLayerOperatorDescriptorRegistry) {
		if (newLayerOperatorDescriptorRegistry != layerOperatorDescriptorRegistry) {
			NotificationChain msgs = null;
			if (layerOperatorDescriptorRegistry != null)
				msgs = ((InternalEObject)layerOperatorDescriptorRegistry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY, null, msgs);
			if (newLayerOperatorDescriptorRegistry != null)
				msgs = ((InternalEObject)newLayerOperatorDescriptorRegistry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY, null, msgs);
			msgs = basicSetLayerOperatorDescriptorRegistry(newLayerOperatorDescriptorRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY, newLayerOperatorDescriptorRegistry, newLayerOperatorDescriptorRegistry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeLayersStackFor(Diagram diagram) {
		
		try {
			LayersStack stack = lookupLayersStackFor(diagram);
			getLayersStacks().remove(stack);
		} catch (NotFoundException e) {
			// silently fails
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLayersStackAttachedFor(Diagram diagram) {
		try {
			lookupLayersStackFor(diagram);
			return true;
		} catch (NotFoundException e) {
			// not found
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LayersStack lookupLayersStackFor(Diagram diagram) throws NotFoundException {
		for( LayersStack stack : getLayersStacks()) {
			if( stack.getDiagram() == diagram ) {
				return stack;
			}
		}

		// Not found
		throw new NotFoundException("No LayersStack attached for diagram: " + diagram);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Get the {@link LayersStack} for the specified diagram. Create it if 
	 * necessary.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LayersStack getLayersStackFor(Diagram diagram) {
		try {
			return  lookupLayersStackFor(diagram);
		} catch (NotFoundException e) {
			// Create a new one
			return createLayersStackFor(diagram);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Create a new LayersStack for the specified diagram.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LayersStack createLayersStackFor(Diagram diagram) {
		
		// Create a new LayerStack and add it to application (this)
		LayersStack layer = LayersFactory.eINSTANCE.createLayersStack();
		layer.setDiagram(diagram);
		
		// Create first layer in stack
		TopLayerOperator rootLayer = LayersFactory.eINSTANCE.createTopLayerOperator();
		rootLayer.setName("Top Layer");
		rootLayer.setApplication(this);
		layer.setLayers(rootLayer);

		// attach stack to application
		getLayersStacks().add(layer);


		return layer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.LAYERS_STACK_APPLICATION__FACTORY:
				if (factory != null)
					msgs = ((InternalEObject)factory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__FACTORY, null, msgs);
				return basicSetFactory((LayerApplicationFactory)otherEnd, msgs);
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY:
				if (propertySetterRegistry != null)
					msgs = ((InternalEObject)propertySetterRegistry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY, null, msgs);
				return basicSetPropertySetterRegistry((PropertySetterRegistry)otherEnd, msgs);
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
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYERS_STACKS:
				return ((InternalEList<?>)getLayersStacks()).basicRemove(otherEnd, msgs);
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY:
				return basicSetLayerStackRegistry(null, msgs);
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY:
				return basicSetPropertyRegistry(null, msgs);
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY:
				return basicSetLayerDescriptorRegistry(null, msgs);
			case LayersPackage.LAYERS_STACK_APPLICATION__FACTORY:
				return basicSetFactory(null, msgs);
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY:
				return basicSetPropertySetterRegistry(null, msgs);
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY:
				return basicSetLayerOperatorDescriptorRegistry(null, msgs);
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
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYERS_STACKS:
				return getLayersStacks();
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY:
				return getLayerStackRegistry();
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY:
				return getPropertyRegistry();
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY:
				return getLayerDescriptorRegistry();
			case LayersPackage.LAYERS_STACK_APPLICATION__FACTORY:
				return getFactory();
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY:
				return getPropertySetterRegistry();
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY:
				return getLayerOperatorDescriptorRegistry();
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
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYERS_STACKS:
				getLayersStacks().clear();
				getLayersStacks().addAll((Collection<? extends LayersStack>)newValue);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY:
				setLayerStackRegistry((LayerStackDescriptorRegistry)newValue);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY:
				setPropertyRegistry((PropertyRegistry)newValue);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY:
				setLayerDescriptorRegistry((LayerDescriptorRegistry)newValue);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__FACTORY:
				setFactory((LayerApplicationFactory)newValue);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY:
				setPropertySetterRegistry((PropertySetterRegistry)newValue);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY:
				setLayerOperatorDescriptorRegistry((LayerOperatorDescriptorRegistry)newValue);
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
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYERS_STACKS:
				getLayersStacks().clear();
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY:
				setLayerStackRegistry((LayerStackDescriptorRegistry)null);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY:
				setPropertyRegistry((PropertyRegistry)null);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY:
				setLayerDescriptorRegistry((LayerDescriptorRegistry)null);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__FACTORY:
				setFactory((LayerApplicationFactory)null);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY:
				setPropertySetterRegistry((PropertySetterRegistry)null);
				return;
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY:
				setLayerOperatorDescriptorRegistry((LayerOperatorDescriptorRegistry)null);
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
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYERS_STACKS:
				return layersStacks != null && !layersStacks.isEmpty();
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY:
				return layerStackRegistry != null;
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY:
				return propertyRegistry != null;
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY:
				return layerDescriptorRegistry != null;
			case LayersPackage.LAYERS_STACK_APPLICATION__FACTORY:
				return factory != null;
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY:
				return propertySetterRegistry != null;
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY:
				return layerOperatorDescriptorRegistry != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.LAYERS_STACK_APPLICATION___GET_LAYERS_STACK_FOR__DIAGRAM:
				return getLayersStackFor((Diagram)arguments.get(0));
			case LayersPackage.LAYERS_STACK_APPLICATION___REMOVE_LAYERS_STACK_FOR__DIAGRAM:
				removeLayersStackFor((Diagram)arguments.get(0));
				return null;
			case LayersPackage.LAYERS_STACK_APPLICATION___IS_LAYERS_STACK_ATTACHED_FOR__DIAGRAM:
				return isLayersStackAttachedFor((Diagram)arguments.get(0));
			case LayersPackage.LAYERS_STACK_APPLICATION___CREATE_LAYERS_STACK_FOR__DIAGRAM:
				return createLayersStackFor((Diagram)arguments.get(0));
			case LayersPackage.LAYERS_STACK_APPLICATION___LOOKUP_LAYERS_STACK_FOR__DIAGRAM:
				try {
					return lookupLayersStackFor((Diagram)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

} //LayersStackApplicationImpl
