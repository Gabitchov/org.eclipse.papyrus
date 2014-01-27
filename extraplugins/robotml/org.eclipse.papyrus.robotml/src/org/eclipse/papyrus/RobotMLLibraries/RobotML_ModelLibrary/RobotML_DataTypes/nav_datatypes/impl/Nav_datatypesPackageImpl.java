/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl;

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

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesFactory;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Path;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesPackageImpl;

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
 * @generated
 */
public class Nav_datatypesPackageImpl extends EPackageImpl implements Nav_datatypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass odometryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass occupancyGridEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gridCellsEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Nav_datatypesPackageImpl() {
		super(eNS_URI, Nav_datatypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Nav_datatypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Nav_datatypesPackage init() {
		if (isInited) return (Nav_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Nav_datatypesPackage.eNS_URI);

		// Obtain or create and register package
		Nav_datatypesPackageImpl theNav_datatypesPackage = (Nav_datatypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Nav_datatypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Nav_datatypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		RobotMLPackageImpl theRobotMLPackage = (RobotMLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RobotMLPackage.eNS_URI) instanceof RobotMLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RobotMLPackage.eNS_URI) : RobotMLPackage.eINSTANCE);
		Diagnostic_datatypesPackageImpl theDiagnostic_datatypesPackage = (Diagnostic_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) instanceof Diagnostic_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) : Diagnostic_datatypesPackage.eINSTANCE);
		Geometry_datatypesPackageImpl theGeometry_datatypesPackage = (Geometry_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI) instanceof Geometry_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI) : Geometry_datatypesPackage.eINSTANCE);
		Sensor_datatypesPackageImpl theSensor_datatypesPackage = (Sensor_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI) instanceof Sensor_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI) : Sensor_datatypesPackage.eINSTANCE);
		Actionlib_datatypesPackageImpl theActionlib_datatypesPackage = (Actionlib_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) instanceof Actionlib_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) : Actionlib_datatypesPackage.eINSTANCE);
		Oarp1_datatypesPackageImpl theOarp1_datatypesPackage = (Oarp1_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Oarp1_datatypesPackage.eNS_URI) instanceof Oarp1_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Oarp1_datatypesPackage.eNS_URI) : Oarp1_datatypesPackage.eINSTANCE);
		Oarp4_datatypesPackageImpl theOarp4_datatypesPackage = (Oarp4_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) instanceof Oarp4_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) : Oarp4_datatypesPackage.eINSTANCE);
		Std_datatypesPackageImpl theStd_datatypesPackage = (Std_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) instanceof Std_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) : Std_datatypesPackage.eINSTANCE);

		// Create package meta-data objects
		theNav_datatypesPackage.createPackageContents();
		theRobotMLPackage.createPackageContents();
		theDiagnostic_datatypesPackage.createPackageContents();
		theGeometry_datatypesPackage.createPackageContents();
		theSensor_datatypesPackage.createPackageContents();
		theActionlib_datatypesPackage.createPackageContents();
		theOarp1_datatypesPackage.createPackageContents();
		theOarp4_datatypesPackage.createPackageContents();
		theStd_datatypesPackage.createPackageContents();

		// Initialize created meta-data
		theNav_datatypesPackage.initializePackageContents();
		theRobotMLPackage.initializePackageContents();
		theDiagnostic_datatypesPackage.initializePackageContents();
		theGeometry_datatypesPackage.initializePackageContents();
		theSensor_datatypesPackage.initializePackageContents();
		theActionlib_datatypesPackage.initializePackageContents();
		theOarp1_datatypesPackage.initializePackageContents();
		theOarp4_datatypesPackage.initializePackageContents();
		theStd_datatypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNav_datatypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Nav_datatypesPackage.eNS_URI, theNav_datatypesPackage);
		return theNav_datatypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPath() {
		return pathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPath_Header() {
		return (EReference)pathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPath_Poses() {
		return (EReference)pathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOdometry() {
		return odometryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOdometry_Header() {
		return (EReference)odometryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOdometry_Child_frame_id() {
		return (EAttribute)odometryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOdometry_Pose() {
		return (EReference)odometryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOdometry_Twist() {
		return (EReference)odometryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapMetaData() {
		return mapMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapMetaData_Map_load_time() {
		return (EAttribute)mapMetaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapMetaData_Resolution() {
		return (EAttribute)mapMetaDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapMetaData_Width() {
		return (EAttribute)mapMetaDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapMetaData_Origin() {
		return (EReference)mapMetaDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOccupancyGrid() {
		return occupancyGridEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOccupancyGrid_Header() {
		return (EReference)occupancyGridEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOccupancyGrid_Info() {
		return (EReference)occupancyGridEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOccupancyGrid_Data() {
		return (EAttribute)occupancyGridEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGridCells() {
		return gridCellsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGridCells_Header() {
		return (EReference)gridCellsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridCells_Cell_width() {
		return (EAttribute)gridCellsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridCells_Cell_height() {
		return (EAttribute)gridCellsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGridCells_Cells() {
		return (EReference)gridCellsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Nav_datatypesFactory getNav_datatypesFactory() {
		return (Nav_datatypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		pathEClass = createEClass(PATH);
		createEReference(pathEClass, PATH__HEADER);
		createEReference(pathEClass, PATH__POSES);

		odometryEClass = createEClass(ODOMETRY);
		createEReference(odometryEClass, ODOMETRY__HEADER);
		createEAttribute(odometryEClass, ODOMETRY__CHILD_FRAME_ID);
		createEReference(odometryEClass, ODOMETRY__POSE);
		createEReference(odometryEClass, ODOMETRY__TWIST);

		mapMetaDataEClass = createEClass(MAP_META_DATA);
		createEAttribute(mapMetaDataEClass, MAP_META_DATA__MAP_LOAD_TIME);
		createEAttribute(mapMetaDataEClass, MAP_META_DATA__RESOLUTION);
		createEAttribute(mapMetaDataEClass, MAP_META_DATA__WIDTH);
		createEReference(mapMetaDataEClass, MAP_META_DATA__ORIGIN);

		occupancyGridEClass = createEClass(OCCUPANCY_GRID);
		createEReference(occupancyGridEClass, OCCUPANCY_GRID__HEADER);
		createEReference(occupancyGridEClass, OCCUPANCY_GRID__INFO);
		createEAttribute(occupancyGridEClass, OCCUPANCY_GRID__DATA);

		gridCellsEClass = createEClass(GRID_CELLS);
		createEReference(gridCellsEClass, GRID_CELLS__HEADER);
		createEAttribute(gridCellsEClass, GRID_CELLS__CELL_WIDTH);
		createEAttribute(gridCellsEClass, GRID_CELLS__CELL_HEIGHT);
		createEReference(gridCellsEClass, GRID_CELLS__CELLS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Std_datatypesPackage theStd_datatypesPackage = (Std_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI);
		Geometry_datatypesPackage theGeometry_datatypesPackage = (Geometry_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(pathEClass, Path.class, "Path", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPath_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPath_Poses(), theGeometry_datatypesPackage.getPoseStamped(), null, "poses", null, 0, -1, Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(odometryEClass, Odometry.class, "Odometry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOdometry_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, Odometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOdometry_Child_frame_id(), theStd_datatypesPackage.getString(), "child_frame_id", null, 1, 1, Odometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOdometry_Pose(), theGeometry_datatypesPackage.getPoseWithCovariance(), null, "pose", null, 1, 1, Odometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOdometry_Twist(), theGeometry_datatypesPackage.getTwistWithCovariance(), null, "twist", null, 1, 1, Odometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mapMetaDataEClass, MapMetaData.class, "MapMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapMetaData_Map_load_time(), theStd_datatypesPackage.getTime(), "map_load_time", null, 1, 1, MapMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMapMetaData_Resolution(), theStd_datatypesPackage.getFloat32(), "resolution", null, 1, 1, MapMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMapMetaData_Width(), theStd_datatypesPackage.getUInt32(), "width", null, 1, 1, MapMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMapMetaData_Origin(), theGeometry_datatypesPackage.getPose(), null, "origin", null, 1, 1, MapMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(occupancyGridEClass, OccupancyGrid.class, "OccupancyGrid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOccupancyGrid_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, OccupancyGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOccupancyGrid_Info(), this.getMapMetaData(), null, "info", null, 1, 1, OccupancyGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOccupancyGrid_Data(), theStd_datatypesPackage.getInt8(), "data", null, 0, -1, OccupancyGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(gridCellsEClass, GridCells.class, "GridCells", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGridCells_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, GridCells.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGridCells_Cell_width(), theStd_datatypesPackage.getFloat32(), "cell_width", null, 1, 1, GridCells.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGridCells_Cell_height(), theStd_datatypesPackage.getFloat32(), "cell_height", null, 1, 1, GridCells.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGridCells_Cells(), theGeometry_datatypesPackage.getPoint(), null, "cells", null, 0, -1, GridCells.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Nav_datatypesPackageImpl
