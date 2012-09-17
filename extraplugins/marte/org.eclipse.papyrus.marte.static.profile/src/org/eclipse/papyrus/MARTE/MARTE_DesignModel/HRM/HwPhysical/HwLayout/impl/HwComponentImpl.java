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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResourceService;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.impl.HwResourceImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.ComponentKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.HwComponent;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.HwLayoutPackage;
import org.eclipse.papyrus.MARTE.utils.MarteUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getGrid <em>Grid</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getNbPins <em>Nb Pins</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getPrice <em>Price</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getR_Conditions <em>RConditions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getPoweredServices <em>Powered Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getStaticConsumption <em>Static Consumption</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getStaticDissipation <em>Static Dissipation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl#getSubComponents <em>Sub Components</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwComponentImpl extends HwResourceImpl implements HwComponent {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ComponentKind KIND_EDEFAULT = ComponentKind.CARD;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ComponentKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> dimensions;

	/**
	 * The default value of the '{@link #getArea() <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArea()
	 * @generated
	 * @ordered
	 */
	protected static final String AREA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected EList<String> position;

	/**
	 * The cached value of the '{@link #getGrid() <em>Grid</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrid()
	 * @generated
	 * @ordered
	 */
	protected EList<String> grid;

	/**
	 * The default value of the '{@link #getNbPins() <em>Nb Pins</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbPins()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_PINS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbPins() <em>Nb Pins</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbPins()
	 * @generated
	 * @ordered
	 */
	protected String nbPins = NB_PINS_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final String WEIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected String weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected static final String PRICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected String price = PRICE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getR_Conditions() <em>RConditions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR_Conditions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> r_Conditions;

	/**
	 * The cached value of the '{@link #getPoweredServices() <em>Powered Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoweredServices()
	 * @generated
	 * @ordered
	 */
	protected EList<HwResourceService> poweredServices;

	/**
	 * The default value of the '{@link #getStaticConsumption() <em>Static Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticConsumption()
	 * @generated
	 * @ordered
	 */
	protected static final String STATIC_CONSUMPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStaticConsumption() <em>Static Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticConsumption()
	 * @generated
	 * @ordered
	 */
	protected String staticConsumption = STATIC_CONSUMPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStaticDissipation() <em>Static Dissipation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticDissipation()
	 * @generated
	 * @ordered
	 */
	protected static final String STATIC_DISSIPATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStaticDissipation() <em>Static Dissipation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticDissipation()
	 * @generated
	 * @ordered
	 */
	protected String staticDissipation = STATIC_DISSIPATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubComponents() <em>Sub Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<HwComponent> subComponents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwLayoutPackage.Literals.HW_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ComponentKind newKind) {
		ComponentKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwLayoutPackage.HW_COMPONENT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getDimensions() {
		if (dimensions == null) {
			dimensions = new EDataTypeUniqueEList<String>(String.class, this, HwLayoutPackage.HW_COMPONENT__DIMENSIONS);
		}
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getArea() {
		// TODO: implement this method to return the 'Area' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		
		float area = 0;
		int dimSize = getDimensions().size();
		if(dimSize >= 2) {
			float dim1Value = Float.valueOf(MarteUtils.getValueFromTuple(getDimensions().get(0), "value"));
			String dim1Unit = MarteUtils.getValueFromTuple(getDimensions().get(0), "unit");
			float dim2Value = Float.valueOf(MarteUtils.getValueFromTuple(getDimensions().get(1), "value"));
			String dim2Unit = MarteUtils.getValueFromTuple(getDimensions().get(1), "unit");
			
			if(dimSize == 2) {
				if(dim1Unit.equals(dim2Unit)) {
					return "{unit="+dim1Unit+"2,value="+String.valueOf(dim1Value*dim2Value)+"}";
				}
				
				else {
					return "{unit="+dim1Unit+"2,value="+String.valueOf(dim1Value*dim2Value*10)+"}";
				}
			}
			
			else {
				float dim3Value = Float.valueOf(MarteUtils.getValueFromTuple(getDimensions().get(2), "value"));
				String dim3Unit = MarteUtils.getValueFromTuple(getDimensions().get(2), "unit");
				
				if(dim1Unit.equals(dim2Unit) && dim1Unit.equals(dim3Unit)) {
					return "{unit="+dim1Unit+"2,value="+String.valueOf(2*dim1Value*dim2Value+2*dim1Value*dim3Value+2*dim2Value*dim3Value)+"}";
				}
				
				else if(dim1Unit.equals(dim2Unit) && !dim1Unit.equals(dim3Unit) && dim1Unit.equals("mm")) {
					return "{unit="+dim1Unit+"2,value="+String.valueOf(2*dim1Value*dim2Value+2*dim1Value*dim3Value*10+2*dim2Value*dim3Value*10)+"}";
				}
				
				else if(dim1Unit.equals(dim2Unit) && !dim1Unit.equals(dim3Unit) && dim1Unit.equals("cm")){
					return "{unit="+dim3Unit+"2,value="+String.valueOf(2*dim1Value*dim2Value*100+2*dim1Value*dim3Value*10+2*dim2Value*dim3Value*10)+"}";
				}
				
				else if(dim1Unit.equals(dim3Unit) && !dim1Unit.equals(dim2Unit) && dim1Unit.equals("mm")) {
					return "{unit="+dim1Unit+"2,value="+String.valueOf(2*dim1Value*dim2Value*10+2*dim1Value*dim3Value+2*dim2Value*dim3Value*10)+"}";
				}

				else if(dim1Unit.equals(dim3Unit) && !dim1Unit.equals(dim2Unit) && dim1Unit.equals("cm")) {
					return "{unit="+dim3Unit+"2,value="+String.valueOf(2*dim1Value*dim2Value*10+2*dim1Value*dim3Value*100+2*dim2Value*dim3Value*10)+"}";
				}
			}
		}
		return String.valueOf(area);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(String newArea) {
		// TODO: implement this method to set the 'Area' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPosition() {
		if (position == null) {
			position = new EDataTypeUniqueEList<String>(String.class, this, HwLayoutPackage.HW_COMPONENT__POSITION);
		}
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getGrid() {
		if (grid == null) {
			grid = new EDataTypeUniqueEList<String>(String.class, this, HwLayoutPackage.HW_COMPONENT__GRID);
		}
		return grid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbPins() {
		return nbPins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbPins(String newNbPins) {
		String oldNbPins = nbPins;
		nbPins = newNbPins;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwLayoutPackage.HW_COMPONENT__NB_PINS, oldNbPins, nbPins));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(String newWeight) {
		String oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwLayoutPackage.HW_COMPONENT__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrice(String newPrice) {
		String oldPrice = price;
		price = newPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwLayoutPackage.HW_COMPONENT__PRICE, oldPrice, price));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getR_Conditions() {
		if (r_Conditions == null) {
			r_Conditions = new EDataTypeUniqueEList<String>(String.class, this, HwLayoutPackage.HW_COMPONENT__RCONDITIONS);
		}
		return r_Conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwResourceService> getPoweredServices() {
		if (poweredServices == null) {
			poweredServices = new EObjectContainmentEList<HwResourceService>(HwResourceService.class, this, HwLayoutPackage.HW_COMPONENT__POWERED_SERVICES);
		}
		return poweredServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStaticConsumption() {
		return staticConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticConsumption(String newStaticConsumption) {
		String oldStaticConsumption = staticConsumption;
		staticConsumption = newStaticConsumption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwLayoutPackage.HW_COMPONENT__STATIC_CONSUMPTION, oldStaticConsumption, staticConsumption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStaticDissipation() {
		return staticDissipation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticDissipation(String newStaticDissipation) {
		String oldStaticDissipation = staticDissipation;
		staticDissipation = newStaticDissipation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwLayoutPackage.HW_COMPONENT__STATIC_DISSIPATION, oldStaticDissipation, staticDissipation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwComponent> getSubComponents() {
		if (subComponents == null) {
			subComponents = new EObjectResolvingEList<HwComponent>(HwComponent.class, this, HwLayoutPackage.HW_COMPONENT__SUB_COMPONENTS);
		}
		return subComponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HwLayoutPackage.HW_COMPONENT__POWERED_SERVICES:
				return ((InternalEList<?>)getPoweredServices()).basicRemove(otherEnd, msgs);
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
			case HwLayoutPackage.HW_COMPONENT__KIND:
				return getKind();
			case HwLayoutPackage.HW_COMPONENT__DIMENSIONS:
				return getDimensions();
			case HwLayoutPackage.HW_COMPONENT__AREA:
				return getArea();
			case HwLayoutPackage.HW_COMPONENT__POSITION:
				return getPosition();
			case HwLayoutPackage.HW_COMPONENT__GRID:
				return getGrid();
			case HwLayoutPackage.HW_COMPONENT__NB_PINS:
				return getNbPins();
			case HwLayoutPackage.HW_COMPONENT__WEIGHT:
				return getWeight();
			case HwLayoutPackage.HW_COMPONENT__PRICE:
				return getPrice();
			case HwLayoutPackage.HW_COMPONENT__RCONDITIONS:
				return getR_Conditions();
			case HwLayoutPackage.HW_COMPONENT__POWERED_SERVICES:
				return getPoweredServices();
			case HwLayoutPackage.HW_COMPONENT__STATIC_CONSUMPTION:
				return getStaticConsumption();
			case HwLayoutPackage.HW_COMPONENT__STATIC_DISSIPATION:
				return getStaticDissipation();
			case HwLayoutPackage.HW_COMPONENT__SUB_COMPONENTS:
				return getSubComponents();
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
			case HwLayoutPackage.HW_COMPONENT__KIND:
				setKind((ComponentKind)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__DIMENSIONS:
				getDimensions().clear();
				getDimensions().addAll((Collection<? extends String>)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__AREA:
				setArea((String)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__POSITION:
				getPosition().clear();
				getPosition().addAll((Collection<? extends String>)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__GRID:
				getGrid().clear();
				getGrid().addAll((Collection<? extends String>)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__NB_PINS:
				setNbPins((String)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__WEIGHT:
				setWeight((String)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__PRICE:
				setPrice((String)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__RCONDITIONS:
				getR_Conditions().clear();
				getR_Conditions().addAll((Collection<? extends String>)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__POWERED_SERVICES:
				getPoweredServices().clear();
				getPoweredServices().addAll((Collection<? extends HwResourceService>)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__STATIC_CONSUMPTION:
				setStaticConsumption((String)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__STATIC_DISSIPATION:
				setStaticDissipation((String)newValue);
				return;
			case HwLayoutPackage.HW_COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
				getSubComponents().addAll((Collection<? extends HwComponent>)newValue);
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
			case HwLayoutPackage.HW_COMPONENT__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case HwLayoutPackage.HW_COMPONENT__DIMENSIONS:
				getDimensions().clear();
				return;
			case HwLayoutPackage.HW_COMPONENT__AREA:
				setArea(AREA_EDEFAULT);
				return;
			case HwLayoutPackage.HW_COMPONENT__POSITION:
				getPosition().clear();
				return;
			case HwLayoutPackage.HW_COMPONENT__GRID:
				getGrid().clear();
				return;
			case HwLayoutPackage.HW_COMPONENT__NB_PINS:
				setNbPins(NB_PINS_EDEFAULT);
				return;
			case HwLayoutPackage.HW_COMPONENT__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case HwLayoutPackage.HW_COMPONENT__PRICE:
				setPrice(PRICE_EDEFAULT);
				return;
			case HwLayoutPackage.HW_COMPONENT__RCONDITIONS:
				getR_Conditions().clear();
				return;
			case HwLayoutPackage.HW_COMPONENT__POWERED_SERVICES:
				getPoweredServices().clear();
				return;
			case HwLayoutPackage.HW_COMPONENT__STATIC_CONSUMPTION:
				setStaticConsumption(STATIC_CONSUMPTION_EDEFAULT);
				return;
			case HwLayoutPackage.HW_COMPONENT__STATIC_DISSIPATION:
				setStaticDissipation(STATIC_DISSIPATION_EDEFAULT);
				return;
			case HwLayoutPackage.HW_COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
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
			case HwLayoutPackage.HW_COMPONENT__KIND:
				return kind != KIND_EDEFAULT;
			case HwLayoutPackage.HW_COMPONENT__DIMENSIONS:
				return dimensions != null && !dimensions.isEmpty();
			case HwLayoutPackage.HW_COMPONENT__AREA:
				return AREA_EDEFAULT == null ? getArea() != null : !AREA_EDEFAULT.equals(getArea());
			case HwLayoutPackage.HW_COMPONENT__POSITION:
				return position != null && !position.isEmpty();
			case HwLayoutPackage.HW_COMPONENT__GRID:
				return grid != null && !grid.isEmpty();
			case HwLayoutPackage.HW_COMPONENT__NB_PINS:
				return NB_PINS_EDEFAULT == null ? nbPins != null : !NB_PINS_EDEFAULT.equals(nbPins);
			case HwLayoutPackage.HW_COMPONENT__WEIGHT:
				return WEIGHT_EDEFAULT == null ? weight != null : !WEIGHT_EDEFAULT.equals(weight);
			case HwLayoutPackage.HW_COMPONENT__PRICE:
				return PRICE_EDEFAULT == null ? price != null : !PRICE_EDEFAULT.equals(price);
			case HwLayoutPackage.HW_COMPONENT__RCONDITIONS:
				return r_Conditions != null && !r_Conditions.isEmpty();
			case HwLayoutPackage.HW_COMPONENT__POWERED_SERVICES:
				return poweredServices != null && !poweredServices.isEmpty();
			case HwLayoutPackage.HW_COMPONENT__STATIC_CONSUMPTION:
				return STATIC_CONSUMPTION_EDEFAULT == null ? staticConsumption != null : !STATIC_CONSUMPTION_EDEFAULT.equals(staticConsumption);
			case HwLayoutPackage.HW_COMPONENT__STATIC_DISSIPATION:
				return STATIC_DISSIPATION_EDEFAULT == null ? staticDissipation != null : !STATIC_DISSIPATION_EDEFAULT.equals(staticDissipation);
			case HwLayoutPackage.HW_COMPONENT__SUB_COMPONENTS:
				return subComponents != null && !subComponents.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", dimensions: ");
		result.append(dimensions);
		result.append(", position: ");
		result.append(position);
		result.append(", grid: ");
		result.append(grid);
		result.append(", nbPins: ");
		result.append(nbPins);
		result.append(", weight: ");
		result.append(weight);
		result.append(", price: ");
		result.append(price);
		result.append(", r_Conditions: ");
		result.append(r_Conditions);
		result.append(", staticConsumption: ");
		result.append(staticConsumption);
		result.append(", staticDissipation: ");
		result.append(staticDissipation);
		result.append(')');
		return result.toString();
	}

} //HwComponentImpl
