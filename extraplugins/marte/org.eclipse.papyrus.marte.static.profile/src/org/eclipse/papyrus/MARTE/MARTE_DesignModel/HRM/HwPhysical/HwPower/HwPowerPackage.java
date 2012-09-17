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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.HwLayoutPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerFactory
 * @model kind="package"
 * @generated
 */
public interface HwPowerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HwPower";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/HwPower/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "HwPower";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HwPowerPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerSupplyImpl <em>Supply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerSupplyImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerPackageImpl#getHwPowerSupply()
	 * @generated
	 */
	int HW_POWER_SUPPLY = 0;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__RES_MULT = HwLayoutPackage.HW_COMPONENT__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__IS_PROTECTED = HwLayoutPackage.HW_COMPONENT__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__IS_ACTIVE = HwLayoutPackage.HW_COMPONENT__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__BASE_PROPERTY = HwLayoutPackage.HW_COMPONENT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__BASE_INSTANCE_SPECIFICATION = HwLayoutPackage.HW_COMPONENT__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__BASE_CLASSIFIER = HwLayoutPackage.HW_COMPONENT__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__BASE_LIFELINE = HwLayoutPackage.HW_COMPONENT__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__BASE_CONNECTABLE_ELEMENT = HwLayoutPackage.HW_COMPONENT__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__DESCRIPTION = HwLayoutPackage.HW_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>PHW Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__PHW_SERVICES = HwLayoutPackage.HW_COMPONENT__PHW_SERVICES;

	/**
	 * The feature id for the '<em><b>RHW Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__RHW_SERVICES = HwLayoutPackage.HW_COMPONENT__RHW_SERVICES;

	/**
	 * The feature id for the '<em><b>Owned HW</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__OWNED_HW = HwLayoutPackage.HW_COMPONENT__OWNED_HW;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__END_POINTS = HwLayoutPackage.HW_COMPONENT__END_POINTS;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__FREQUENCY = HwLayoutPackage.HW_COMPONENT__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__KIND = HwLayoutPackage.HW_COMPONENT__KIND;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__DIMENSIONS = HwLayoutPackage.HW_COMPONENT__DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__AREA = HwLayoutPackage.HW_COMPONENT__AREA;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__POSITION = HwLayoutPackage.HW_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__GRID = HwLayoutPackage.HW_COMPONENT__GRID;

	/**
	 * The feature id for the '<em><b>Nb Pins</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__NB_PINS = HwLayoutPackage.HW_COMPONENT__NB_PINS;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__WEIGHT = HwLayoutPackage.HW_COMPONENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__PRICE = HwLayoutPackage.HW_COMPONENT__PRICE;

	/**
	 * The feature id for the '<em><b>RConditions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__RCONDITIONS = HwLayoutPackage.HW_COMPONENT__RCONDITIONS;

	/**
	 * The feature id for the '<em><b>Powered Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__POWERED_SERVICES = HwLayoutPackage.HW_COMPONENT__POWERED_SERVICES;

	/**
	 * The feature id for the '<em><b>Static Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__STATIC_CONSUMPTION = HwLayoutPackage.HW_COMPONENT__STATIC_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Static Dissipation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__STATIC_DISSIPATION = HwLayoutPackage.HW_COMPONENT__STATIC_DISSIPATION;

	/**
	 * The feature id for the '<em><b>Sub Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__SUB_COMPONENTS = HwLayoutPackage.HW_COMPONENT__SUB_COMPONENTS;

	/**
	 * The feature id for the '<em><b>Supplied Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__SUPPLIED_POWER = HwLayoutPackage.HW_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY__CAPACITY = HwLayoutPackage.HW_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Supply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_POWER_SUPPLY_FEATURE_COUNT = HwLayoutPackage.HW_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwCoolingSupplyImpl <em>Hw Cooling Supply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwCoolingSupplyImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerPackageImpl#getHwCoolingSupply()
	 * @generated
	 */
	int HW_COOLING_SUPPLY = 1;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__RES_MULT = HwLayoutPackage.HW_COMPONENT__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__IS_PROTECTED = HwLayoutPackage.HW_COMPONENT__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__IS_ACTIVE = HwLayoutPackage.HW_COMPONENT__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__BASE_PROPERTY = HwLayoutPackage.HW_COMPONENT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__BASE_INSTANCE_SPECIFICATION = HwLayoutPackage.HW_COMPONENT__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__BASE_CLASSIFIER = HwLayoutPackage.HW_COMPONENT__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__BASE_LIFELINE = HwLayoutPackage.HW_COMPONENT__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__BASE_CONNECTABLE_ELEMENT = HwLayoutPackage.HW_COMPONENT__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__DESCRIPTION = HwLayoutPackage.HW_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>PHW Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__PHW_SERVICES = HwLayoutPackage.HW_COMPONENT__PHW_SERVICES;

	/**
	 * The feature id for the '<em><b>RHW Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__RHW_SERVICES = HwLayoutPackage.HW_COMPONENT__RHW_SERVICES;

	/**
	 * The feature id for the '<em><b>Owned HW</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__OWNED_HW = HwLayoutPackage.HW_COMPONENT__OWNED_HW;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__END_POINTS = HwLayoutPackage.HW_COMPONENT__END_POINTS;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__FREQUENCY = HwLayoutPackage.HW_COMPONENT__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__KIND = HwLayoutPackage.HW_COMPONENT__KIND;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__DIMENSIONS = HwLayoutPackage.HW_COMPONENT__DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__AREA = HwLayoutPackage.HW_COMPONENT__AREA;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__POSITION = HwLayoutPackage.HW_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__GRID = HwLayoutPackage.HW_COMPONENT__GRID;

	/**
	 * The feature id for the '<em><b>Nb Pins</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__NB_PINS = HwLayoutPackage.HW_COMPONENT__NB_PINS;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__WEIGHT = HwLayoutPackage.HW_COMPONENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__PRICE = HwLayoutPackage.HW_COMPONENT__PRICE;

	/**
	 * The feature id for the '<em><b>RConditions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__RCONDITIONS = HwLayoutPackage.HW_COMPONENT__RCONDITIONS;

	/**
	 * The feature id for the '<em><b>Powered Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__POWERED_SERVICES = HwLayoutPackage.HW_COMPONENT__POWERED_SERVICES;

	/**
	 * The feature id for the '<em><b>Static Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__STATIC_CONSUMPTION = HwLayoutPackage.HW_COMPONENT__STATIC_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Static Dissipation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__STATIC_DISSIPATION = HwLayoutPackage.HW_COMPONENT__STATIC_DISSIPATION;

	/**
	 * The feature id for the '<em><b>Sub Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__SUB_COMPONENTS = HwLayoutPackage.HW_COMPONENT__SUB_COMPONENTS;

	/**
	 * The feature id for the '<em><b>Cooling Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY__COOLING_POWER = HwLayoutPackage.HW_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hw Cooling Supply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COOLING_SUPPLY_FEATURE_COUNT = HwLayoutPackage.HW_COMPONENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerSupply <em>Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supply</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerSupply
	 * @generated
	 */
	EClass getHwPowerSupply();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerSupply#getSuppliedPower <em>Supplied Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Supplied Power</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerSupply#getSuppliedPower()
	 * @see #getHwPowerSupply()
	 * @generated
	 */
	EAttribute getHwPowerSupply_SuppliedPower();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerSupply#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerSupply#getCapacity()
	 * @see #getHwPowerSupply()
	 * @generated
	 */
	EAttribute getHwPowerSupply_Capacity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwCoolingSupply <em>Hw Cooling Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hw Cooling Supply</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwCoolingSupply
	 * @generated
	 */
	EClass getHwCoolingSupply();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwCoolingSupply#getCoolingPower <em>Cooling Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cooling Power</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwCoolingSupply#getCoolingPower()
	 * @see #getHwCoolingSupply()
	 * @generated
	 */
	EAttribute getHwCoolingSupply_CoolingPower();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HwPowerFactory getHwPowerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerSupplyImpl <em>Supply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerSupplyImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerPackageImpl#getHwPowerSupply()
		 * @generated
		 */
		EClass HW_POWER_SUPPLY = eINSTANCE.getHwPowerSupply();

		/**
		 * The meta object literal for the '<em><b>Supplied Power</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HW_POWER_SUPPLY__SUPPLIED_POWER = eINSTANCE.getHwPowerSupply_SuppliedPower();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HW_POWER_SUPPLY__CAPACITY = eINSTANCE.getHwPowerSupply_Capacity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwCoolingSupplyImpl <em>Hw Cooling Supply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwCoolingSupplyImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerPackageImpl#getHwCoolingSupply()
		 * @generated
		 */
		EClass HW_COOLING_SUPPLY = eINSTANCE.getHwCoolingSupply();

		/**
		 * The meta object literal for the '<em><b>Cooling Power</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HW_COOLING_SUPPLY__COOLING_POWER = eINSTANCE.getHwCoolingSupply_CoolingPower();

	}

} //HwPowerPackage
