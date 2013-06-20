/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.Actionlib_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.Diagnostic_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.Diagnostic_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.Geometry_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.CarLikeCommand;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesFactory;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.Sensor_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class Oarp1_datatypesPackageImpl extends EPackageImpl implements Oarp1_datatypesPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass carLikeCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass multiLayerLidarScanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass extentedLidarScanEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Oarp1_datatypesPackageImpl() {
		super(eNS_URI, Oarp1_datatypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link Oarp1_datatypesPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Oarp1_datatypesPackage init() {
		if(isInited)
			return (Oarp1_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Oarp1_datatypesPackage.eNS_URI);

		// Obtain or create and register package
		Oarp1_datatypesPackageImpl theOarp1_datatypesPackage = (Oarp1_datatypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Oarp1_datatypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Oarp1_datatypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		RobotMLPackageImpl theRobotMLPackage = (RobotMLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RobotMLPackage.eNS_URI) instanceof RobotMLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RobotMLPackage.eNS_URI) : RobotMLPackage.eINSTANCE);
		Diagnostic_datatypesPackageImpl theDiagnostic_datatypesPackage = (Diagnostic_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) instanceof Diagnostic_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) : Diagnostic_datatypesPackage.eINSTANCE);
		Geometry_datatypesPackageImpl theGeometry_datatypesPackage = (Geometry_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI) instanceof Geometry_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI) : Geometry_datatypesPackage.eINSTANCE);
		Nav_datatypesPackageImpl theNav_datatypesPackage = (Nav_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Nav_datatypesPackage.eNS_URI) instanceof Nav_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Nav_datatypesPackage.eNS_URI) : Nav_datatypesPackage.eINSTANCE);
		Sensor_datatypesPackageImpl theSensor_datatypesPackage = (Sensor_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI) instanceof Sensor_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI) : Sensor_datatypesPackage.eINSTANCE);
		Actionlib_datatypesPackageImpl theActionlib_datatypesPackage = (Actionlib_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) instanceof Actionlib_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) : Actionlib_datatypesPackage.eINSTANCE);
		Oarp4_datatypesPackageImpl theOarp4_datatypesPackage = (Oarp4_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) instanceof Oarp4_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) : Oarp4_datatypesPackage.eINSTANCE);
		Std_datatypesPackageImpl theStd_datatypesPackage = (Std_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) instanceof Std_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) : Std_datatypesPackage.eINSTANCE);

		// Create package meta-data objects
		theOarp1_datatypesPackage.createPackageContents();
		theRobotMLPackage.createPackageContents();
		theDiagnostic_datatypesPackage.createPackageContents();
		theGeometry_datatypesPackage.createPackageContents();
		theNav_datatypesPackage.createPackageContents();
		theSensor_datatypesPackage.createPackageContents();
		theActionlib_datatypesPackage.createPackageContents();
		theOarp4_datatypesPackage.createPackageContents();
		theStd_datatypesPackage.createPackageContents();

		// Initialize created meta-data
		theOarp1_datatypesPackage.initializePackageContents();
		theRobotMLPackage.initializePackageContents();
		theDiagnostic_datatypesPackage.initializePackageContents();
		theGeometry_datatypesPackage.initializePackageContents();
		theNav_datatypesPackage.initializePackageContents();
		theSensor_datatypesPackage.initializePackageContents();
		theActionlib_datatypesPackage.initializePackageContents();
		theOarp4_datatypesPackage.initializePackageContents();
		theStd_datatypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOarp1_datatypesPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Oarp1_datatypesPackage.eNS_URI, theOarp1_datatypesPackage);
		return theOarp1_datatypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCarLikeCommand() {
		return carLikeCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCarLikeCommand_Velocity() {
		return (EAttribute)carLikeCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCarLikeCommand_SteeringAngle() {
		return (EAttribute)carLikeCommandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMultiLayerLidarScan() {
		return multiLayerLidarScanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMultiLayerLidarScan_Layers() {
		return (EReference)multiLayerLidarScanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMultiLayerLidarScan_NbLayer() {
		return (EAttribute)multiLayerLidarScanEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExtentedLidarScan() {
		return extentedLidarScanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getExtentedLidarScan_Scan() {
		return (EReference)extentedLidarScanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getExtentedLidarScan_LayerId() {
		return (EAttribute)extentedLidarScanEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getExtentedLidarScan_LayerAngle() {
		return (EAttribute)extentedLidarScanEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Oarp1_datatypesFactory getOarp1_datatypesFactory() {
		return (Oarp1_datatypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		carLikeCommandEClass = createEClass(CAR_LIKE_COMMAND);
		createEAttribute(carLikeCommandEClass, CAR_LIKE_COMMAND__VELOCITY);
		createEAttribute(carLikeCommandEClass, CAR_LIKE_COMMAND__STEERING_ANGLE);

		multiLayerLidarScanEClass = createEClass(MULTI_LAYER_LIDAR_SCAN);
		createEReference(multiLayerLidarScanEClass, MULTI_LAYER_LIDAR_SCAN__LAYERS);
		createEAttribute(multiLayerLidarScanEClass, MULTI_LAYER_LIDAR_SCAN__NB_LAYER);

		extentedLidarScanEClass = createEClass(EXTENTED_LIDAR_SCAN);
		createEReference(extentedLidarScanEClass, EXTENTED_LIDAR_SCAN__SCAN);
		createEAttribute(extentedLidarScanEClass, EXTENTED_LIDAR_SCAN__LAYER_ID);
		createEAttribute(extentedLidarScanEClass, EXTENTED_LIDAR_SCAN__LAYER_ANGLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Std_datatypesPackage theStd_datatypesPackage = (Std_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI);
		Sensor_datatypesPackage theSensor_datatypesPackage = (Sensor_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(carLikeCommandEClass, CarLikeCommand.class, "CarLikeCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCarLikeCommand_Velocity(), theStd_datatypesPackage.getFloat64(), "velocity", "0", 1, 1, CarLikeCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCarLikeCommand_SteeringAngle(), theStd_datatypesPackage.getFloat64(), "steeringAngle", "0", 1, 1, CarLikeCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(multiLayerLidarScanEClass, MultiLayerLidarScan.class, "MultiLayerLidarScan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiLayerLidarScan_Layers(), this.getExtentedLidarScan(), null, "layers", null, 1, 1, MultiLayerLidarScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMultiLayerLidarScan_NbLayer(), theStd_datatypesPackage.getUInt8(), "nbLayer", null, 1, 1, MultiLayerLidarScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(extentedLidarScanEClass, ExtentedLidarScan.class, "ExtentedLidarScan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtentedLidarScan_Scan(), theSensor_datatypesPackage.getLaserScan(), null, "scan", null, 1, 1, ExtentedLidarScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtentedLidarScan_LayerId(), theStd_datatypesPackage.getUInt8(), "layerId", null, 1, 1, ExtentedLidarScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtentedLidarScan_LayerAngle(), theStd_datatypesPackage.getFloat32(), "layerAngle", null, 1, 1, ExtentedLidarScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Oarp1_datatypesPackageImpl
