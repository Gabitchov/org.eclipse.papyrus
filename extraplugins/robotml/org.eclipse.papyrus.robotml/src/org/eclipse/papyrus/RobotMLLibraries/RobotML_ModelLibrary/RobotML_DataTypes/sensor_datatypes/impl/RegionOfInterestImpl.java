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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.RegionOfInterest;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Region Of Interest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#getX_offset <em>
 * Xoffset</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#getY_offset <em>
 * Yoffset</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#getHeight <em>
 * Height</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#isDo_rectify <em>
 * Do rectify</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#getWidth <em>
 * Width</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RegionOfInterestImpl extends EObjectImpl implements RegionOfInterest {

	/**
	 * The default value of the '{@link #getX_offset() <em>Xoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getX_offset()
	 * @generated
	 * @ordered
	 */
	protected static final long XOFFSET_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getX_offset() <em>Xoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getX_offset()
	 * @generated
	 * @ordered
	 */
	protected long x_offset = XOFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getY_offset() <em>Yoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getY_offset()
	 * @generated
	 * @ordered
	 */
	protected static final long YOFFSET_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getY_offset() <em>Yoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getY_offset()
	 * @generated
	 * @ordered
	 */
	protected long y_offset = YOFFSET_EDEFAULT;

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
	 * The default value of the '{@link #isDo_rectify() <em>Do rectify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDo_rectify()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DO_RECTIFY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDo_rectify() <em>Do rectify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDo_rectify()
	 * @generated
	 * @ordered
	 */
	protected boolean do_rectify = DO_RECTIFY_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RegionOfInterestImpl() {
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
		return Sensor_datatypesPackage.Literals.REGION_OF_INTEREST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getX_offset() {
		return x_offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setX_offset(long newX_offset) {
		long oldX_offset = x_offset;
		x_offset = newX_offset;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET, oldX_offset, x_offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getY_offset() {
		return y_offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setY_offset(long newY_offset) {
		long oldY_offset = y_offset;
		y_offset = newY_offset;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET, oldY_offset, y_offset));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDo_rectify() {
		return do_rectify;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDo_rectify(boolean newDo_rectify) {
		boolean oldDo_rectify = do_rectify;
		do_rectify = newDo_rectify;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY, oldDo_rectify, do_rectify));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH, oldWidth, width));
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
		case Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET:
			return getX_offset();
		case Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET:
			return getY_offset();
		case Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT:
			return getHeight();
		case Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY:
			return isDo_rectify();
		case Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH:
			return getWidth();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET:
			setX_offset((Long)newValue);
			return;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET:
			setY_offset((Long)newValue);
			return;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT:
			setHeight((Long)newValue);
			return;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY:
			setDo_rectify((Boolean)newValue);
			return;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH:
			setWidth((Long)newValue);
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
		case Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET:
			setX_offset(XOFFSET_EDEFAULT);
			return;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET:
			setY_offset(YOFFSET_EDEFAULT);
			return;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT:
			setHeight(HEIGHT_EDEFAULT);
			return;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY:
			setDo_rectify(DO_RECTIFY_EDEFAULT);
			return;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH:
			setWidth(WIDTH_EDEFAULT);
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
		case Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET:
			return x_offset != XOFFSET_EDEFAULT;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET:
			return y_offset != YOFFSET_EDEFAULT;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT:
			return height != HEIGHT_EDEFAULT;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY:
			return do_rectify != DO_RECTIFY_EDEFAULT;
		case Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH:
			return width != WIDTH_EDEFAULT;
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
		result.append(" (x_offset: ");
		result.append(x_offset);
		result.append(", y_offset: ");
		result.append(y_offset);
		result.append(", height: ");
		result.append(height);
		result.append(", do_rectify: ");
		result.append(do_rectify);
		result.append(", width: ");
		result.append(width);
		result.append(')');
		return result.toString();
	}

} //RegionOfInterestImpl
