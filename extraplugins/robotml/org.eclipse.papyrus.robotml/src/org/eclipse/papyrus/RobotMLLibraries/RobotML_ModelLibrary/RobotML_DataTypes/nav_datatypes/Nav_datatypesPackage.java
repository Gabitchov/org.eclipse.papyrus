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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesFactory
 * @model kind="package"
 * @generated
 */
public interface Nav_datatypesPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "nav_datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http:///RobotMLLibraries/RobotML_ModelLibrary/RobotML_DataTypes/nav_datatypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	Nav_datatypesPackage eINSTANCE = org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.PathImpl
	 * <em>Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.PathImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getPath()
	 * @generated
	 */
	int PATH = 0;

	/**
	 * The feature id for the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATH__HEADER = 0;

	/**
	 * The feature id for the '<em><b>Poses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATH__POSES = 1;

	/**
	 * The number of structural features of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATH_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OdometryImpl
	 * <em>Odometry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OdometryImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getOdometry()
	 * @generated
	 */
	int ODOMETRY = 1;

	/**
	 * The feature id for the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY__HEADER = 0;

	/**
	 * The feature id for the '<em><b>Child frame id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY__CHILD_FRAME_ID = 1;

	/**
	 * The feature id for the '<em><b>Pose</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY__POSE = 2;

	/**
	 * The feature id for the '<em><b>Twist</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY__TWIST = 3;

	/**
	 * The number of structural features of the '<em>Odometry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.MapMetaDataImpl <em>Map Meta Data</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.MapMetaDataImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getMapMetaData()
	 * @generated
	 */
	int MAP_META_DATA = 2;

	/**
	 * The feature id for the '<em><b>Map load time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAP_META_DATA__MAP_LOAD_TIME = 0;

	/**
	 * The feature id for the '<em><b>Resolution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAP_META_DATA__RESOLUTION = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAP_META_DATA__WIDTH = 2;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAP_META_DATA__ORIGIN = 3;

	/**
	 * The number of structural features of the '<em>Map Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAP_META_DATA_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OccupancyGridImpl
	 * <em>Occupancy Grid</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OccupancyGridImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getOccupancyGrid()
	 * @generated
	 */
	int OCCUPANCY_GRID = 3;

	/**
	 * The feature id for the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCCUPANCY_GRID__HEADER = 0;

	/**
	 * The feature id for the '<em><b>Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCCUPANCY_GRID__INFO = 1;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCCUPANCY_GRID__DATA = 2;

	/**
	 * The number of structural features of the '<em>Occupancy Grid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCCUPANCY_GRID_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.GridCellsImpl <em>Grid Cells</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.GridCellsImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getGridCells()
	 * @generated
	 */
	int GRID_CELLS = 4;

	/**
	 * The feature id for the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_CELLS__HEADER = 0;

	/**
	 * The feature id for the '<em><b>Cell width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_CELLS__CELL_WIDTH = 1;

	/**
	 * The feature id for the '<em><b>Cell height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_CELLS__CELL_HEIGHT = 2;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_CELLS__CELLS = 3;

	/**
	 * The number of structural features of the '<em>Grid Cells</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_CELLS_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Path
	 * <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Path</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Path
	 * @generated
	 */
	EClass getPath();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Path#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Header</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Path#getHeader()
	 * @see #getPath()
	 * @generated
	 */
	EReference getPath_Header();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Path#getPoses <em>Poses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Poses</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Path#getPoses()
	 * @see #getPath()
	 * @generated
	 */
	EReference getPath_Poses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry
	 * <em>Odometry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Odometry</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry
	 * @generated
	 */
	EClass getOdometry();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Header</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry#getHeader()
	 * @see #getOdometry()
	 * @generated
	 */
	EReference getOdometry_Header();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry#getChild_frame_id
	 * <em>Child frame id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Child frame id</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry#getChild_frame_id()
	 * @see #getOdometry()
	 * @generated
	 */
	EAttribute getOdometry_Child_frame_id();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry#getPose <em>Pose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Pose</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry#getPose()
	 * @see #getOdometry()
	 * @generated
	 */
	EReference getOdometry_Pose();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry#getTwist <em>Twist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Twist</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry#getTwist()
	 * @see #getOdometry()
	 * @generated
	 */
	EReference getOdometry_Twist();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData <em>Map Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Map Meta Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData
	 * @generated
	 */
	EClass getMapMetaData();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData#getMap_load_time
	 * <em>Map load time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Map load time</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData#getMap_load_time()
	 * @see #getMapMetaData()
	 * @generated
	 */
	EAttribute getMapMetaData_Map_load_time();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData#getResolution <em>Resolution</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Resolution</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData#getResolution()
	 * @see #getMapMetaData()
	 * @generated
	 */
	EAttribute getMapMetaData_Resolution();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData#getWidth()
	 * @see #getMapMetaData()
	 * @generated
	 */
	EAttribute getMapMetaData_Width();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Origin</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData#getOrigin()
	 * @see #getMapMetaData()
	 * @generated
	 */
	EReference getMapMetaData_Origin();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid <em>Occupancy Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Occupancy Grid</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid
	 * @generated
	 */
	EClass getOccupancyGrid();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Header</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid#getHeader()
	 * @see #getOccupancyGrid()
	 * @generated
	 */
	EReference getOccupancyGrid_Header();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid#getInfo <em>Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Info</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid#getInfo()
	 * @see #getOccupancyGrid()
	 * @generated
	 */
	EReference getOccupancyGrid_Info();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid#getData()
	 * @see #getOccupancyGrid()
	 * @generated
	 */
	EAttribute getOccupancyGrid_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells
	 * <em>Grid Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Grid Cells</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells
	 * @generated
	 */
	EClass getGridCells();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Header</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getHeader()
	 * @see #getGridCells()
	 * @generated
	 */
	EReference getGridCells_Header();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCell_width <em>Cell width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Cell width</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCell_width()
	 * @see #getGridCells()
	 * @generated
	 */
	EAttribute getGridCells_Cell_width();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCell_height <em>Cell height</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Cell height</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCell_height()
	 * @see #getGridCells()
	 * @generated
	 */
	EAttribute getGridCells_Cell_height();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCells <em>Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Cells</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCells()
	 * @see #getGridCells()
	 * @generated
	 */
	EReference getGridCells_Cells();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Nav_datatypesFactory getNav_datatypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.PathImpl <em>Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.PathImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getPath()
		 * @generated
		 */
		EClass PATH = eINSTANCE.getPath();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PATH__HEADER = eINSTANCE.getPath_Header();

		/**
		 * The meta object literal for the '<em><b>Poses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PATH__POSES = eINSTANCE.getPath_Poses();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OdometryImpl <em>Odometry</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OdometryImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getOdometry()
		 * @generated
		 */
		EClass ODOMETRY = eINSTANCE.getOdometry();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ODOMETRY__HEADER = eINSTANCE.getOdometry_Header();

		/**
		 * The meta object literal for the '<em><b>Child frame id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ODOMETRY__CHILD_FRAME_ID = eINSTANCE.getOdometry_Child_frame_id();

		/**
		 * The meta object literal for the '<em><b>Pose</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ODOMETRY__POSE = eINSTANCE.getOdometry_Pose();

		/**
		 * The meta object literal for the '<em><b>Twist</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ODOMETRY__TWIST = eINSTANCE.getOdometry_Twist();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.MapMetaDataImpl
		 * <em>Map Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.MapMetaDataImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getMapMetaData()
		 * @generated
		 */
		EClass MAP_META_DATA = eINSTANCE.getMapMetaData();

		/**
		 * The meta object literal for the '<em><b>Map load time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MAP_META_DATA__MAP_LOAD_TIME = eINSTANCE.getMapMetaData_Map_load_time();

		/**
		 * The meta object literal for the '<em><b>Resolution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MAP_META_DATA__RESOLUTION = eINSTANCE.getMapMetaData_Resolution();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MAP_META_DATA__WIDTH = eINSTANCE.getMapMetaData_Width();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MAP_META_DATA__ORIGIN = eINSTANCE.getMapMetaData_Origin();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OccupancyGridImpl
		 * <em>Occupancy Grid</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OccupancyGridImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getOccupancyGrid()
		 * @generated
		 */
		EClass OCCUPANCY_GRID = eINSTANCE.getOccupancyGrid();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCCUPANCY_GRID__HEADER = eINSTANCE.getOccupancyGrid_Header();

		/**
		 * The meta object literal for the '<em><b>Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCCUPANCY_GRID__INFO = eINSTANCE.getOccupancyGrid_Info();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OCCUPANCY_GRID__DATA = eINSTANCE.getOccupancyGrid_Data();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.GridCellsImpl <em>Grid Cells</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.GridCellsImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl#getGridCells()
		 * @generated
		 */
		EClass GRID_CELLS = eINSTANCE.getGridCells();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_CELLS__HEADER = eINSTANCE.getGridCells_Header();

		/**
		 * The meta object literal for the '<em><b>Cell width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_CELLS__CELL_WIDTH = eINSTANCE.getGridCells_Cell_width();

		/**
		 * The meta object literal for the '<em><b>Cell height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_CELLS__CELL_HEIGHT = eINSTANCE.getGridCells_Cell_height();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_CELLS__CELLS = eINSTANCE.getGridCells_Cells();

	}

} //Nav_datatypesPackage
