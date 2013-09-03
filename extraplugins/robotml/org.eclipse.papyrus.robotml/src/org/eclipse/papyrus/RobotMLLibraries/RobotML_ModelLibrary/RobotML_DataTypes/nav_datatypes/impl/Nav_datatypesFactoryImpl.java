/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.*;

// TODO: Auto-generated Javadoc
/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Nav_datatypesFactoryImpl extends EFactoryImpl implements Nav_datatypesFactory {
	
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the nav_datatypes factory
	 * @generated
	 */
	public static Nav_datatypesFactory init() {
		try {
			Nav_datatypesFactory theNav_datatypesFactory = (Nav_datatypesFactory)EPackage.Registry.INSTANCE.getEFactory(Nav_datatypesPackage.eNS_URI);
			if (theNav_datatypesFactory != null) {
				return theNav_datatypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Nav_datatypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Nav_datatypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param eClass the e class
	 * @return the e object
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Nav_datatypesPackage.PATH: return createPath();
			case Nav_datatypesPackage.ODOMETRY: return createOdometry();
			case Nav_datatypesPackage.MAP_META_DATA: return createMapMetaData();
			case Nav_datatypesPackage.OCCUPANCY_GRID: return createOccupancyGrid();
			case Nav_datatypesPackage.GRID_CELLS: return createGridCells();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the path
	 * @generated
	 */
	public Path createPath() {
		PathImpl path = new PathImpl();
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the odometry
	 * @generated
	 */
	public Odometry createOdometry() {
		OdometryImpl odometry = new OdometryImpl();
		return odometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the map meta data
	 * @generated
	 */
	public MapMetaData createMapMetaData() {
		MapMetaDataImpl mapMetaData = new MapMetaDataImpl();
		return mapMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the occupancy grid
	 * @generated
	 */
	public OccupancyGrid createOccupancyGrid() {
		OccupancyGridImpl occupancyGrid = new OccupancyGridImpl();
		return occupancyGrid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the grid cells
	 * @generated
	 */
	public GridCells createGridCells() {
		GridCellsImpl gridCells = new GridCellsImpl();
		return gridCells;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the nav_datatypes package
	 * @generated
	 */
	public Nav_datatypesPackage getNav_datatypesPackage() {
		return (Nav_datatypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the package
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Nav_datatypesPackage getPackage() {
		return Nav_datatypesPackage.eINSTANCE;
	}

} //Nav_datatypesFactoryImpl
