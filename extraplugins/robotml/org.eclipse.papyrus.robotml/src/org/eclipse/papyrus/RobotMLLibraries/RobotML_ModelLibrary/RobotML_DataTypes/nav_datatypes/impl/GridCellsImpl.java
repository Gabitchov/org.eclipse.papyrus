/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grid Cells</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.GridCellsImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.GridCellsImpl#getCell_width <em>Cell width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.GridCellsImpl#getCell_height <em>Cell height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.GridCellsImpl#getCells <em>Cells</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GridCellsImpl extends MinimalEObjectImpl.Container implements GridCells {
	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Header header;

	/**
	 * The default value of the '{@link #getCell_width() <em>Cell width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCell_width()
	 * @generated
	 * @ordered
	 */
	protected static final float CELL_WIDTH_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getCell_width() <em>Cell width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCell_width()
	 * @generated
	 * @ordered
	 */
	protected float cell_width = CELL_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getCell_height() <em>Cell height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCell_height()
	 * @generated
	 * @ordered
	 */
	protected static final float CELL_HEIGHT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getCell_height() <em>Cell height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCell_height()
	 * @generated
	 * @ordered
	 */
	protected float cell_height = CELL_HEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCells() <em>Cells</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCells()
	 * @generated
	 * @ordered
	 */
	protected EList<Point> cells;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GridCellsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Nav_datatypesPackage.Literals.GRID_CELLS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeader(Header newHeader, NotificationChain msgs) {
		Header oldHeader = header;
		header = newHeader;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.GRID_CELLS__HEADER, oldHeader, newHeader);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(Header newHeader) {
		if (newHeader != header) {
			NotificationChain msgs = null;
			if (header != null)
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.GRID_CELLS__HEADER, null, msgs);
			if (newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.GRID_CELLS__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.GRID_CELLS__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCell_width() {
		return cell_width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCell_width(float newCell_width) {
		float oldCell_width = cell_width;
		cell_width = newCell_width;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.GRID_CELLS__CELL_WIDTH, oldCell_width, cell_width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCell_height() {
		return cell_height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCell_height(float newCell_height) {
		float oldCell_height = cell_height;
		cell_height = newCell_height;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.GRID_CELLS__CELL_HEIGHT, oldCell_height, cell_height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Point> getCells() {
		if (cells == null) {
			cells = new EObjectContainmentEList<Point>(Point.class, this, Nav_datatypesPackage.GRID_CELLS__CELLS);
		}
		return cells;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Nav_datatypesPackage.GRID_CELLS__HEADER:
				return basicSetHeader(null, msgs);
			case Nav_datatypesPackage.GRID_CELLS__CELLS:
				return ((InternalEList<?>)getCells()).basicRemove(otherEnd, msgs);
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
			case Nav_datatypesPackage.GRID_CELLS__HEADER:
				return getHeader();
			case Nav_datatypesPackage.GRID_CELLS__CELL_WIDTH:
				return getCell_width();
			case Nav_datatypesPackage.GRID_CELLS__CELL_HEIGHT:
				return getCell_height();
			case Nav_datatypesPackage.GRID_CELLS__CELLS:
				return getCells();
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
			case Nav_datatypesPackage.GRID_CELLS__HEADER:
				setHeader((Header)newValue);
				return;
			case Nav_datatypesPackage.GRID_CELLS__CELL_WIDTH:
				setCell_width((Float)newValue);
				return;
			case Nav_datatypesPackage.GRID_CELLS__CELL_HEIGHT:
				setCell_height((Float)newValue);
				return;
			case Nav_datatypesPackage.GRID_CELLS__CELLS:
				getCells().clear();
				getCells().addAll((Collection<? extends Point>)newValue);
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
			case Nav_datatypesPackage.GRID_CELLS__HEADER:
				setHeader((Header)null);
				return;
			case Nav_datatypesPackage.GRID_CELLS__CELL_WIDTH:
				setCell_width(CELL_WIDTH_EDEFAULT);
				return;
			case Nav_datatypesPackage.GRID_CELLS__CELL_HEIGHT:
				setCell_height(CELL_HEIGHT_EDEFAULT);
				return;
			case Nav_datatypesPackage.GRID_CELLS__CELLS:
				getCells().clear();
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
			case Nav_datatypesPackage.GRID_CELLS__HEADER:
				return header != null;
			case Nav_datatypesPackage.GRID_CELLS__CELL_WIDTH:
				return cell_width != CELL_WIDTH_EDEFAULT;
			case Nav_datatypesPackage.GRID_CELLS__CELL_HEIGHT:
				return cell_height != CELL_HEIGHT_EDEFAULT;
			case Nav_datatypesPackage.GRID_CELLS__CELLS:
				return cells != null && !cells.isEmpty();
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
		result.append(" (cell_width: ");
		result.append(cell_width);
		result.append(", cell_height: ");
		result.append(cell_height);
		result.append(')');
		return result.toString();
	}

} //GridCellsImpl
