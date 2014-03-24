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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerState;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#isLayerEnabledInternal <em>Is Layer Enabled Internal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#isLayerEnabled <em>Is Layer Enabled</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#isBranchEnabled <em>Is Branch Enabled</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getOwningLayersStack <em>Owning Layers Stack</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LayerExpressionImpl extends 
ApplicationDependantElementImpl implements LayerExpression {
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
	 * The default value of the '{@link #isLayerEnabledInternal() <em>Is Layer Enabled Internal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLayerEnabledInternal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LAYER_ENABLED_INTERNAL_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isLayerEnabled() <em>Is Layer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLayerEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LAYER_ENABLED_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isLayerEnabled() <em>Is Layer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLayerEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean isLayerEnabled = IS_LAYER_ENABLED_EDEFAULT;
	/**
	 * The default value of the '{@link #isBranchEnabled() <em>Is Branch Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBranchEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BRANCH_ENABLED_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isBranchEnabled() <em>Is Branch Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBranchEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean isBranchEnabled = IS_BRANCH_ENABLED_EDEFAULT;
	/**
	 * The cached value of the '{@link #getOwningLayersStack() <em>Owning Layers Stack</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwningLayersStack()
	 * @generated
	 * @ordered
	 */
	protected LayersStack owningLayersStack;
	
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final LayerState STATE_EDEFAULT = LayerState.DETACHED;
	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected LayerState state = STATE_EDEFAULT;
	/**
	 * Listener on this object container (i.e owner) attached/detached events
	 */
	protected Adapter containerListener = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			
			switch(msg.getFeatureID(LayerExpression.class)) {
			  case EcorePackage.EOBJECT___ECONTAINER :
				  switch(msg.getEventType()) {
					case Notification.SET:
						// 
						owningLayerChanged((LayerOperator)msg.getNewValue(), (LayerOperator)msg.getOldValue());
						break;

					case Notification.UNSET:
						owningLayerChanged((LayerOperator)msg.getNewValue(), (LayerOperator)msg.getOldValue());
						break;

					default:
						break;
				  }
				  break;
			};
		}

	};


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LayerExpressionImpl() {
		super();
		
		// Listen on this object attachment / detachment from its container.
		// When this node is atttached to a parent, the owningLayerStack property is set.
		// This is done in owningLayerChanged.
		eAdapters().add(containerListener);

	}

	/**
	 * Start the behaviors associated to this layer.
	 * This method is called by one of the methods: {@link #startAfterReloading()} or {@link #attachToLayersStack(LayersStack)}.
	 */
	protected void startBehaviors() {
		
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYER_EXPRESSION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_EXPRESSION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_EXPRESSION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLayerEnabledInternal() {
		return isLayerEnabled();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLayerEnabled() {
		return isLayerEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setIsLayerEnabled(boolean newIsLayerEnabled) {
		boolean oldIsLayerEnabled = isLayerEnabled;
		isLayerEnabled = newIsLayerEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED, oldIsLayerEnabled, isLayerEnabled));

		// Disable the branch
		setIsBranchEnabled(isLayerEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBranchEnabled() {
		return isBranchEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setIsBranchEnabled(boolean newIsBranchEnabled) {
		boolean oldIsBranchEnabled = isBranchEnabled;
		isBranchEnabled = newIsBranchEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_EXPRESSION__IS_BRANCH_ENABLED, oldIsBranchEnabled, isBranchEnabled));

		// Propagate to children.
		// This is done in LayerOperation.
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStack getOwningLayersStack() {
		if (owningLayersStack != null && owningLayersStack.eIsProxy()) {
			InternalEObject oldOwningLayersStack = (InternalEObject)owningLayersStack;
			owningLayersStack = (LayersStack)eResolveProxy(oldOwningLayersStack);
			if (owningLayersStack != oldOwningLayersStack) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersPackage.LAYER_EXPRESSION__OWNING_LAYERS_STACK, oldOwningLayersStack, owningLayersStack));
			}
		}
		return owningLayersStack;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStack basicGetOwningLayersStack() {
		return owningLayersStack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningLayersStack(LayersStack newOwningLayersStack) {
		LayersStack oldOwningLayersStack = owningLayersStack;
		owningLayersStack = newOwningLayersStack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_EXPRESSION__OWNING_LAYERS_STACK, oldOwningLayersStack, owningLayersStack));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(LayerState newState) {
		LayerState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_EXPRESSION__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LayersStack getLayersStack() throws NotFoundException {
		
		LayersStack res = getOwningLayersStack();
		if( res != null) {
			return res;
		}
			
		throw new NotFoundException("LayersStack is not set in the Layer '" + getName() +"'");		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void enterAttachedState() throws LayersException {
		// do nothing
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void attach() throws LayersException {
		
		// Stop if already in ATTACHED state.
		if(getState() == LayerState.ATTACHED) {
			return;
		}
		
		// Check required attributes
		if( getApplication()==null || getOwningLayersStack() == null || eContainer() == null) {
			throw new BadStateException("A required attribute is not set. The Layer can't be attached."
					+ "[layerName=" + getName() 
					+ ", application=" + (getApplication()==null?"null":"ok")
					+ ", owningLayersStack=" + (getOwningLayersStack()==null?"null":"ok")
					+ ", container=" + (eContainer()==null?"null":"ok")
					+ "]"
					);
		}
		
		// Can go in attached mode
		setState(LayerState.ATTACHED);
		enterAttachedState();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Subclass can overload in order to stop some behaviors.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void detach() throws LayersException {
		

		// Change the state
		exitAttachedState();
		setState(LayerState.DETACHED);		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void exitAttachedState() {
		// do nothing.
	}

	/**
	 * <!-- begin-user-doc -->
	 * Start this element after its reloading by EMF
	 * This method is called recursively by the parent of this element.
	 * <br>
	 * This default implementation start the associated behaviors.
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void startAfterReloading() {
		startBehaviors();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputePropertyValueCommand getComputePropertyValueCommand(View view, Property property) throws LayersException  {
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
	 * @generated
	 */
	public EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, EList<Property> property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * This default implementation set the layerStack, and start behaviors.
	 * This method can be overriden by subclasses. In this case, subclass must ensure that
	 * the {@link #owningLayersStack} is set and the behaviors are started.
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void attachToLayersStack(LayersStack owningLayersStack) {
		
		// the owning stack
		setOwningLayersStack(owningLayersStack);

		// Start associated behavior
		startBehaviors();
	}

	/**
	 * Init this Layer.
	 * Called by the LayerStack as soon as the layer is added in the tree of layers.
	 * This method can be subclassed to init a particular layer.
	 * 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initLayer(LayersStack owningLayersStack) {
		
		// the owning stack
		setOwningLayersStack(owningLayersStack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(List<View> view, Property property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, List<Property> property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.LAYER_EXPRESSION__NAME:
				return getName();
			case LayersPackage.LAYER_EXPRESSION__DESCRIPTION:
				return getDescription();
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED_INTERNAL:
				return isLayerEnabledInternal();
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED:
				return isLayerEnabled();
			case LayersPackage.LAYER_EXPRESSION__IS_BRANCH_ENABLED:
				return isBranchEnabled();
			case LayersPackage.LAYER_EXPRESSION__OWNING_LAYERS_STACK:
				if (resolve) return getOwningLayersStack();
				return basicGetOwningLayersStack();
			case LayersPackage.LAYER_EXPRESSION__STATE:
				return getState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LayersPackage.LAYER_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case LayersPackage.LAYER_EXPRESSION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED:
				setIsLayerEnabled((Boolean)newValue);
				return;
			case LayersPackage.LAYER_EXPRESSION__IS_BRANCH_ENABLED:
				setIsBranchEnabled((Boolean)newValue);
				return;
			case LayersPackage.LAYER_EXPRESSION__OWNING_LAYERS_STACK:
				setOwningLayersStack((LayersStack)newValue);
				return;
			case LayersPackage.LAYER_EXPRESSION__STATE:
				setState((LayerState)newValue);
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
			case LayersPackage.LAYER_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LayersPackage.LAYER_EXPRESSION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED:
				setIsLayerEnabled(IS_LAYER_ENABLED_EDEFAULT);
				return;
			case LayersPackage.LAYER_EXPRESSION__IS_BRANCH_ENABLED:
				setIsBranchEnabled(IS_BRANCH_ENABLED_EDEFAULT);
				return;
			case LayersPackage.LAYER_EXPRESSION__OWNING_LAYERS_STACK:
				setOwningLayersStack((LayersStack)null);
				return;
			case LayersPackage.LAYER_EXPRESSION__STATE:
				setState(STATE_EDEFAULT);
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
			case LayersPackage.LAYER_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LayersPackage.LAYER_EXPRESSION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED_INTERNAL:
				return isLayerEnabledInternal() != IS_LAYER_ENABLED_INTERNAL_EDEFAULT;
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED:
				return isLayerEnabled != IS_LAYER_ENABLED_EDEFAULT;
			case LayersPackage.LAYER_EXPRESSION__IS_BRANCH_ENABLED:
				return isBranchEnabled != IS_BRANCH_ENABLED_EDEFAULT;
			case LayersPackage.LAYER_EXPRESSION__OWNING_LAYERS_STACK:
				return owningLayersStack != null;
			case LayersPackage.LAYER_EXPRESSION__STATE:
				return state != STATE_EDEFAULT;
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
			case LayersPackage.LAYER_EXPRESSION___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY:
				try {
					return getComputePropertyValueCommand((View)arguments.get(0), (Property)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY:
				try {
					return getViewsComputePropertyValueCommand((EList<View>)arguments.get(0), (Property)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST:
				try {
					return getPropertiesComputePropertyValueCommand((View)arguments.get(0), (EList<Property>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___ATTACH_TO_LAYERS_STACK__LAYERSSTACK:
				attachToLayersStack((LayersStack)arguments.get(0));
				return null;
			case LayersPackage.LAYER_EXPRESSION___GET_LAYERS_STACK:
				try {
					return getLayersStack();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___ENTER_ATTACHED_STATE:
				try {
					enterAttachedState();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___ATTACH:
				try {
					attach();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___DETACH:
				try {
					detach();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___EXIT_ATTACHED_STATE:
				exitAttachedState();
				return null;
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
		result.append(", isLayerEnabled: ");
		result.append(isLayerEnabled);
		result.append(", isBranchEnabled: ");
		result.append(isBranchEnabled);
		result.append(", state: ");
		result.append(state);
		result.append(')');
		return result.toString();
	}

	/**
	 * This method is called when the container of this parent has changed.
	 * Set the #owningLayerStack property and the {@link #isBranchEnabled()} property
	 * @param newValue
	 * @param oldValue
	 */
	private void owningLayerChanged(LayerOperator newParent, LayerOperator oldParent) {
		// propagate values
		if (newParent != null ) {
			setOwningLayersStack(newParent.getOwningLayersStack());
			setIsBranchEnabled(newParent.isBranchEnabled());
		}
	};

} //LayerExpressionImpl
