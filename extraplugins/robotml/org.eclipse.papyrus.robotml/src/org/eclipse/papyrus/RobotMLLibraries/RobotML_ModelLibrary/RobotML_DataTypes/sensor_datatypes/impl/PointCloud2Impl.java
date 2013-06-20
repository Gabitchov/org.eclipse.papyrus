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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.PointCloud2;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.PointField;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Point Cloud2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.PointCloud2Impl#getHeader <em>Header
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.PointCloud2Impl#getHeight <em>Height
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.PointCloud2Impl#getWidth <em>Width
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.PointCloud2Impl#getFields <em>Fields
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.PointCloud2Impl#isIs_bigendian <em>Is
 * bigendian</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.PointCloud2Impl#getPoint_step <em>
 * Point step</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.PointCloud2Impl#getRow_step <em>Row
 * step</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.PointCloud2Impl#getData <em>Data</em>}
 * </li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.PointCloud2Impl#isIs_dense <em>Is
 * dense</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PointCloud2Impl extends EObjectImpl implements PointCloud2 {

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Header header;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final long HEIGHT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected long height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final long WIDTH_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected long width = WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<PointField> fields;

	/**
	 * The default value of the '{@link #isIs_bigendian() <em>Is bigendian</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIs_bigendian()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BIGENDIAN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIs_bigendian() <em>Is bigendian</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIs_bigendian()
	 * @generated
	 * @ordered
	 */
	protected boolean is_bigendian = IS_BIGENDIAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getPoint_step() <em>Point step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPoint_step()
	 * @generated
	 * @ordered
	 */
	protected static final long POINT_STEP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getPoint_step() <em>Point step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPoint_step()
	 * @generated
	 * @ordered
	 */
	protected long point_step = POINT_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getRow_step() <em>Row step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRow_step()
	 * @generated
	 * @ordered
	 */
	protected static final long ROW_STEP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getRow_step() <em>Row step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRow_step()
	 * @generated
	 * @ordered
	 */
	protected long row_step = ROW_STEP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<Character> data;

	/**
	 * The default value of the '{@link #isIs_dense() <em>Is dense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIs_dense()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DENSE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIs_dense() <em>Is dense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIs_dense()
	 * @generated
	 * @ordered
	 */
	protected boolean is_dense = IS_DENSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PointCloud2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.POINT_CLOUD2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetHeader(Header newHeader, NotificationChain msgs) {
		Header oldHeader = header;
		header = newHeader;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.POINT_CLOUD2__HEADER, oldHeader, newHeader);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHeader(Header newHeader) {
		if(newHeader != header) {
			NotificationChain msgs = null;
			if(header != null)
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.POINT_CLOUD2__HEADER, null, msgs);
			if(newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.POINT_CLOUD2__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.POINT_CLOUD2__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHeight(long newHeight) {
		long oldHeight = height;
		height = newHeight;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.POINT_CLOUD2__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setWidth(long newWidth) {
		long oldWidth = width;
		width = newWidth;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.POINT_CLOUD2__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<PointField> getFields() {
		if(fields == null) {
			fields = new EObjectContainmentEList<PointField>(PointField.class, this, Sensor_datatypesPackage.POINT_CLOUD2__FIELDS);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIs_bigendian() {
		return is_bigendian;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIs_bigendian(boolean newIs_bigendian) {
		boolean oldIs_bigendian = is_bigendian;
		is_bigendian = newIs_bigendian;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.POINT_CLOUD2__IS_BIGENDIAN, oldIs_bigendian, is_bigendian));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getPoint_step() {
		return point_step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPoint_step(long newPoint_step) {
		long oldPoint_step = point_step;
		point_step = newPoint_step;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.POINT_CLOUD2__POINT_STEP, oldPoint_step, point_step));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getRow_step() {
		return row_step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRow_step(long newRow_step) {
		long oldRow_step = row_step;
		row_step = newRow_step;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.POINT_CLOUD2__ROW_STEP, oldRow_step, row_step));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Character> getData() {
		if(data == null) {
			data = new EDataTypeUniqueEList<Character>(Character.class, this, Sensor_datatypesPackage.POINT_CLOUD2__DATA);
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIs_dense() {
		return is_dense;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIs_dense(boolean newIs_dense) {
		boolean oldIs_dense = is_dense;
		is_dense = newIs_dense;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.POINT_CLOUD2__IS_DENSE, oldIs_dense, is_dense));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case Sensor_datatypesPackage.POINT_CLOUD2__HEADER:
			return basicSetHeader(null, msgs);
		case Sensor_datatypesPackage.POINT_CLOUD2__FIELDS:
			return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case Sensor_datatypesPackage.POINT_CLOUD2__HEADER:
			return getHeader();
		case Sensor_datatypesPackage.POINT_CLOUD2__HEIGHT:
			return getHeight();
		case Sensor_datatypesPackage.POINT_CLOUD2__WIDTH:
			return getWidth();
		case Sensor_datatypesPackage.POINT_CLOUD2__FIELDS:
			return getFields();
		case Sensor_datatypesPackage.POINT_CLOUD2__IS_BIGENDIAN:
			return isIs_bigendian();
		case Sensor_datatypesPackage.POINT_CLOUD2__POINT_STEP:
			return getPoint_step();
		case Sensor_datatypesPackage.POINT_CLOUD2__ROW_STEP:
			return getRow_step();
		case Sensor_datatypesPackage.POINT_CLOUD2__DATA:
			return getData();
		case Sensor_datatypesPackage.POINT_CLOUD2__IS_DENSE:
			return isIs_dense();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case Sensor_datatypesPackage.POINT_CLOUD2__HEADER:
			setHeader((Header)newValue);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__HEIGHT:
			setHeight((Long)newValue);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__WIDTH:
			setWidth((Long)newValue);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__FIELDS:
			getFields().clear();
			getFields().addAll((Collection<? extends PointField>)newValue);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__IS_BIGENDIAN:
			setIs_bigendian((Boolean)newValue);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__POINT_STEP:
			setPoint_step((Long)newValue);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__ROW_STEP:
			setRow_step((Long)newValue);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__DATA:
			getData().clear();
			getData().addAll((Collection<? extends Character>)newValue);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__IS_DENSE:
			setIs_dense((Boolean)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case Sensor_datatypesPackage.POINT_CLOUD2__HEADER:
			setHeader((Header)null);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__HEIGHT:
			setHeight(HEIGHT_EDEFAULT);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__WIDTH:
			setWidth(WIDTH_EDEFAULT);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__FIELDS:
			getFields().clear();
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__IS_BIGENDIAN:
			setIs_bigendian(IS_BIGENDIAN_EDEFAULT);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__POINT_STEP:
			setPoint_step(POINT_STEP_EDEFAULT);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__ROW_STEP:
			setRow_step(ROW_STEP_EDEFAULT);
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__DATA:
			getData().clear();
			return;
		case Sensor_datatypesPackage.POINT_CLOUD2__IS_DENSE:
			setIs_dense(IS_DENSE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case Sensor_datatypesPackage.POINT_CLOUD2__HEADER:
			return header != null;
		case Sensor_datatypesPackage.POINT_CLOUD2__HEIGHT:
			return height != HEIGHT_EDEFAULT;
		case Sensor_datatypesPackage.POINT_CLOUD2__WIDTH:
			return width != WIDTH_EDEFAULT;
		case Sensor_datatypesPackage.POINT_CLOUD2__FIELDS:
			return fields != null && !fields.isEmpty();
		case Sensor_datatypesPackage.POINT_CLOUD2__IS_BIGENDIAN:
			return is_bigendian != IS_BIGENDIAN_EDEFAULT;
		case Sensor_datatypesPackage.POINT_CLOUD2__POINT_STEP:
			return point_step != POINT_STEP_EDEFAULT;
		case Sensor_datatypesPackage.POINT_CLOUD2__ROW_STEP:
			return row_step != ROW_STEP_EDEFAULT;
		case Sensor_datatypesPackage.POINT_CLOUD2__DATA:
			return data != null && !data.isEmpty();
		case Sensor_datatypesPackage.POINT_CLOUD2__IS_DENSE:
			return is_dense != IS_DENSE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (height: ");
		result.append(height);
		result.append(", width: ");
		result.append(width);
		result.append(", is_bigendian: ");
		result.append(is_bigendian);
		result.append(", point_step: ");
		result.append(point_step);
		result.append(", row_step: ");
		result.append(row_step);
		result.append(", data: ");
		result.append(data);
		result.append(", is_dense: ");
		result.append(is_dense);
		result.append(')');
		return result.toString();
	}

} //PointCloud2Impl
