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
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.util.PropertyIndexedList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Setter Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#getPropertySetters <em>Property Setters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#getSetterMap <em>Setter Map</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertySetterRegistryImpl extends MinimalEObjectImpl.Container implements PropertySetterRegistry {
	/**
	 * The cached value of the '{@link #getPropertySetters() <em>Property Setters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertySetters()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertySetter> propertySetters;

	/**
	 * The cached value of the '{@link #getSetterMap() <em>Setter Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetterMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, PropertySetter> setterMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected PropertySetterRegistryImpl() {
		super();
		init();
	}

	/**
	 * Initialize the registry with some setters
	 */
	protected void init() {
		
		addPropertySetter(LayersFactory.eINSTANCE.createFillPropertySetter());
		addPropertySetter(LayersFactory.eINSTANCE.createIsValidPropertySetter());
		addPropertySetter(LayersFactory.eINSTANCE.createLinePropertySetter());
		addPropertySetter(LayersFactory.eINSTANCE.createFontPropertySetter());
		addPropertySetter(LayersFactory.eINSTANCE.createIsVisiblePropertySetter());
		addPropertySetter(LayersFactory.eINSTANCE.createIsAbstractUmlSetter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.PROPERTY_SETTER_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<PropertySetter> getPropertySetters() {
//		if (propertySetters == null) {
//			propertySetters = new EObjectResolvingEList<PropertySetter>(PropertySetter.class, this, LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS);
//		}
		if (propertySetters == null) {
			propertySetters = new PropertyIndexedList<PropertySetter>(getSetterMap(), PropertySetter.class, this, LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS, LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP, PropertySetter.NULL_PROPERTY_SETTER);
		}
		return propertySetters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, PropertySetter> getSetterMap() {
		if (setterMap == null) {
			setterMap = new EcoreEMap<String,PropertySetter>(LayersPackage.Literals.STRING_TO_PROPERTY_SETTER, StringToPropertySetterImpl.class, this, LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP);
		}
		return setterMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStackApplication getApplication() {
		if (eContainerFeatureID() != LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION) return null;
		return (LayersStackApplication)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplication(LayersStackApplication newApplication, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newApplication, LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setApplication(LayersStackApplication newApplication) {
		if (newApplication != eInternalContainer() || (eContainerFeatureID() != LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION && newApplication != null)) {
			if (EcoreUtil.isAncestor(this, newApplication))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newApplication != null)
				msgs = ((InternalEObject)newApplication).eInverseAdd(this, LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY, LayersStackApplication.class, msgs);
			msgs = basicSetApplication(newApplication, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION, newApplication, newApplication));


		// update the list of PropertySetters
		if( newApplication != null) {
			List<Property> list = newApplication.getPropertyRegistry().getProperties();
			((PropertyIndexedList<PropertySetter>)getPropertySetters()).setPropertyList(list);
		};

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertySetter getPropertySetter(Property property) throws NotFoundException {

		try {
			return getPropertySetters().get(property.getIndex());
		}
		catch( IndexOutOfBoundsException e) {
			// Try by name
			PropertySetter setter = getPropertySetter(property.getName());
			if(setter != null) {
				return setter;
			}
			throw new NotFoundException("No setter found for property '" + property.getName() + "'");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertySetter getPropertySetter(String property) throws NotFoundException {
		return getSetterMap().get(property);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addPropertySetter(PropertySetter setter) {
		
		String key = setter.getPropertyName();
		if( key == null || key.length() == 0) {
			throw new UnsupportedOperationException("Setter must have a valid name.");
		}
		
		getSetterMap().put(key, setter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetApplication((LayersStackApplication)otherEnd, msgs);
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
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				return ((InternalEList<?>)getSetterMap()).basicRemove(otherEnd, msgs);
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				return basicSetApplication(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				return eInternalContainer().eInverseRemove(this, LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY, LayersStackApplication.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS:
				return getPropertySetters();
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				if (coreType) return getSetterMap();
				else return getSetterMap().map();
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				return getApplication();
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
			case LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS:
				getPropertySetters().clear();
				getPropertySetters().addAll((Collection<? extends PropertySetter>)newValue);
				return;
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				((EStructuralFeature.Setting)getSetterMap()).set(newValue);
				return;
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				setApplication((LayersStackApplication)newValue);
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
			case LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS:
				getPropertySetters().clear();
				return;
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				getSetterMap().clear();
				return;
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				setApplication((LayersStackApplication)null);
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
			case LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS:
				return propertySetters != null && !propertySetters.isEmpty();
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				return setterMap != null && !setterMap.isEmpty();
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				return getApplication() != null;
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
			case LayersPackage.PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__PROPERTY:
				try {
					return getPropertySetter((Property)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__STRING:
				try {
					return getPropertySetter((String)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.PROPERTY_SETTER_REGISTRY___ADD_PROPERTY_SETTER__PROPERTYSETTER:
				addPropertySetter((PropertySetter)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertySetterRegistryImpl
