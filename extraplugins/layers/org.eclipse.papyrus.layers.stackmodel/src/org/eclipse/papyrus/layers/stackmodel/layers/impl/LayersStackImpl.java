/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.notifier.ILayersTreeEventListener;
import org.eclipse.papyrus.layers.stackmodel.notifier.LayersTreeEventNotifier;
import org.eclipse.papyrus.layers.stackmodel.notifier.LayersTreeEventNotifierFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackImpl#getLayers <em>Layers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackImpl#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayersStackImpl extends 

MinimalEObjectImpl.Container implements LayersStack {
	/**
	 * The cached value of the '{@link #getLayers() <em>Layers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayers()
	 * @generated
	 * @ordered
	 */
	protected LayerExpression layers;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram diagram;

	/**
	 * Listener on layers tree events.
	 * This listener take in charge the initialization of added layers.
	 */
	private ILayersTreeEventListener layersTreeEventListener = new ILayersTreeEventListener() {
		
		@Override
		public void layerSet(Notification notification) {
			LayersStackImpl.this.layerAdded( (LayerExpression)notification.getNewValue() );
		}
		
		@Override
		public void layerRemoved(Notification notification) {
			// nothing to do
			
		}
		
		@Override
		public void layerMoved(Notification notification) {
			// nothing to do
			
		}
		
		@Override
		public void layerAdded(Notification notification) {
			LayersStackImpl.this.layerAdded( (LayerExpression)notification.getNewValue() );
		}

	};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayersStackImpl() {
		super();
		init();
	}

	/**
	 * Init this object.
	 * Create a listener on tree events.
	 */
	private void init() {
		
		LayersTreeEventNotifier layersTreeEventnotifier = LayersTreeEventNotifierFactory.instance.adapt(this);
		
		layersTreeEventnotifier.addLayersModelEventListener(layersTreeEventListener);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYERS_STACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerExpression getLayers() {
		return layers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayers(LayerExpression newLayers, NotificationChain msgs) {
		LayerExpression oldLayers = layers;
		layers = newLayers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK__LAYERS, oldLayers, newLayers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayers(LayerExpression newLayers) {
		if (newLayers != layers) {
			NotificationChain msgs = null;
			if (layers != null)
				msgs = ((InternalEObject)layers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK__LAYERS, null, msgs);
			if (newLayers != null)
				msgs = ((InternalEObject)newLayers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayersPackage.LAYERS_STACK__LAYERS, null, msgs);
			msgs = basicSetLayers(newLayers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK__LAYERS, newLayers, newLayers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getDiagram() {
		if (diagram != null && diagram.eIsProxy()) {
			InternalEObject oldDiagram = (InternalEObject)diagram;
			diagram = (Diagram)eResolveProxy(oldDiagram);
			if (diagram != oldDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersPackage.LAYERS_STACK__DIAGRAM, oldDiagram, diagram));
			}
		}
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram basicGetDiagram() {
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagram(Diagram newDiagram) {
		Diagram oldDiagram = diagram;
		diagram = newDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYERS_STACK__DIAGRAM, oldDiagram, diagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws LayersException 
	 * @generated NOT
	 */
	public ComputePropertyValueCommand getComputePropertyValueCommand(View view, Property property) throws LayersException {
		LayerExpression layers = getLayers();
		if(layers==null) {
			throw new BadStateException("Layers should be set first.");
		}
		
		return layers.getComputePropertyValueCommand(view, property);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, EList<Property> property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(EList<View> view, Property property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws LayersException 
	 * @generated NOT
	 */
	public EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, List<Property> property) throws LayersException {
		LayerExpression layers = getLayers();
		if(layers==null) {
			throw new BadStateException("Layers should be set first.");
		}
		
		return layers.getPropertiesComputePropertyValueCommand(view, property);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws BadStateException 
	 * @generated NOT
	 */
	public EList<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(List<View> view, Property property) throws LayersException {
		
		LayerExpression layers = getLayers();
		if(layers==null) {
			throw new BadStateException("Layers should be set first.");
		}
		
		return layers.getViewsComputePropertyValueCommand(view, property);
	}		

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.LAYERS_STACK__LAYERS:
				return basicSetLayers(null, msgs);
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
			case LayersPackage.LAYERS_STACK__LAYERS:
				return getLayers();
			case LayersPackage.LAYERS_STACK__NAME:
				return getName();
			case LayersPackage.LAYERS_STACK__DESCRIPTION:
				return getDescription();
			case LayersPackage.LAYERS_STACK__DIAGRAM:
				if (resolve) return getDiagram();
				return basicGetDiagram();
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
			case LayersPackage.LAYERS_STACK__LAYERS:
				setLayers((LayerExpression)newValue);
				return;
			case LayersPackage.LAYERS_STACK__NAME:
				setName((String)newValue);
				return;
			case LayersPackage.LAYERS_STACK__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LayersPackage.LAYERS_STACK__DIAGRAM:
				setDiagram((Diagram)newValue);
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
			case LayersPackage.LAYERS_STACK__LAYERS:
				setLayers((LayerExpression)null);
				return;
			case LayersPackage.LAYERS_STACK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LayersPackage.LAYERS_STACK__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LayersPackage.LAYERS_STACK__DIAGRAM:
				setDiagram((Diagram)null);
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
			case LayersPackage.LAYERS_STACK__LAYERS:
				return layers != null;
			case LayersPackage.LAYERS_STACK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LayersPackage.LAYERS_STACK__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LayersPackage.LAYERS_STACK__DIAGRAM:
				return diagram != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.LAYERS_STACK___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY:
				try {
					return getComputePropertyValueCommand((View)arguments.get(0), (Property)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYERS_STACK___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST:
				try {
					return getPropertiesComputePropertyValueCommand((View)arguments.get(0), (EList<Property>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYERS_STACK___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY:
				try {
					return getViewsComputePropertyValueCommand((EList<View>)arguments.get(0), (Property)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

	/**
	 * A layer has been added to the layerTree.
	 * Init this layer.
	 * This method is called by the listener on layerTree events.
	 * 
	 * @param addedLayer The added layer.
	 */
	protected void layerAdded(LayerExpression addedLayer) {
		// Stop if there is no layer
		if( addedLayer == null) {
			return;
		}
		// init the layer
		addedLayer.initLayer(this);
		
	}

} //LayersStackImpl
