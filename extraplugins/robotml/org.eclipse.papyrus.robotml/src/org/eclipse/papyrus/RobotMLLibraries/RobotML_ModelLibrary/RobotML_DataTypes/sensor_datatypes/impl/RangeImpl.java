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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Range;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getULTRASOUND <em>ULTRASOUND
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getINFRARED <em>INFRARED
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getHeader <em>Header</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getRadiation_type <em>
 * Radiation type</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getField_of_view <em>Field
 * of view</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getMin_range <em>Min range
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getMax_range <em>Max range
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RangeImpl extends EObjectImpl implements Range {

	/**
	 * The default value of the '{@link #getULTRASOUND() <em>ULTRASOUND</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getULTRASOUND()
	 * @generated
	 * @ordered
	 */
	protected static final char ULTRASOUND_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getULTRASOUND() <em>ULTRASOUND</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getULTRASOUND()
	 * @generated
	 * @ordered
	 */
	protected char ultrasound = ULTRASOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getINFRARED() <em>INFRARED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getINFRARED()
	 * @generated
	 * @ordered
	 */
	protected static final char INFRARED_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getINFRARED() <em>INFRARED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getINFRARED()
	 * @generated
	 * @ordered
	 */
	protected char infrared = INFRARED_EDEFAULT;

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
	 * The default value of the '{@link #getRadiation_type() <em>Radiation type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRadiation_type()
	 * @generated
	 * @ordered
	 */
	protected static final char RADIATION_TYPE_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getRadiation_type() <em>Radiation type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRadiation_type()
	 * @generated
	 * @ordered
	 */
	protected char radiation_type = RADIATION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getField_of_view() <em>Field of view</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getField_of_view()
	 * @generated
	 * @ordered
	 */
	protected static final float FIELD_OF_VIEW_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getField_of_view() <em>Field of view</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getField_of_view()
	 * @generated
	 * @ordered
	 */
	protected float field_of_view = FIELD_OF_VIEW_EDEFAULT;

	/**
	 * The default value of the '{@link #getMin_range() <em>Min range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMin_range()
	 * @generated
	 * @ordered
	 */
	protected static final float MIN_RANGE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMin_range() <em>Min range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMin_range()
	 * @generated
	 * @ordered
	 */
	protected float min_range = MIN_RANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax_range() <em>Max range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMax_range()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX_RANGE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMax_range() <em>Max range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMax_range()
	 * @generated
	 * @ordered
	 */
	protected float max_range = MAX_RANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected static final float RANGE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected float range = RANGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RangeImpl() {
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
		return Sensor_datatypesPackage.Literals.RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public char getULTRASOUND() {
		return ultrasound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setULTRASOUND(char newULTRASOUND) {
		char oldULTRASOUND = ultrasound;
		ultrasound = newULTRASOUND;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__ULTRASOUND, oldULTRASOUND, ultrasound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public char getINFRARED() {
		return infrared;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setINFRARED(char newINFRARED) {
		char oldINFRARED = infrared;
		infrared = newINFRARED;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__INFRARED, oldINFRARED, infrared));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__HEADER, oldHeader, newHeader);
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
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.RANGE__HEADER, null, msgs);
			if(newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.RANGE__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public char getRadiation_type() {
		return radiation_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRadiation_type(char newRadiation_type) {
		char oldRadiation_type = radiation_type;
		radiation_type = newRadiation_type;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__RADIATION_TYPE, oldRadiation_type, radiation_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getField_of_view() {
		return field_of_view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setField_of_view(float newField_of_view) {
		float oldField_of_view = field_of_view;
		field_of_view = newField_of_view;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW, oldField_of_view, field_of_view));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getMin_range() {
		return min_range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMin_range(float newMin_range) {
		float oldMin_range = min_range;
		min_range = newMin_range;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__MIN_RANGE, oldMin_range, min_range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getMax_range() {
		return max_range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMax_range(float newMax_range) {
		float oldMax_range = max_range;
		max_range = newMax_range;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__MAX_RANGE, oldMax_range, max_range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRange(float newRange) {
		float oldRange = range;
		range = newRange;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__RANGE, oldRange, range));
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
		case Sensor_datatypesPackage.RANGE__HEADER:
			return basicSetHeader(null, msgs);
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
		case Sensor_datatypesPackage.RANGE__ULTRASOUND:
			return getULTRASOUND();
		case Sensor_datatypesPackage.RANGE__INFRARED:
			return getINFRARED();
		case Sensor_datatypesPackage.RANGE__HEADER:
			return getHeader();
		case Sensor_datatypesPackage.RANGE__RADIATION_TYPE:
			return getRadiation_type();
		case Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW:
			return getField_of_view();
		case Sensor_datatypesPackage.RANGE__MIN_RANGE:
			return getMin_range();
		case Sensor_datatypesPackage.RANGE__MAX_RANGE:
			return getMax_range();
		case Sensor_datatypesPackage.RANGE__RANGE:
			return getRange();
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
		case Sensor_datatypesPackage.RANGE__ULTRASOUND:
			setULTRASOUND((Character)newValue);
			return;
		case Sensor_datatypesPackage.RANGE__INFRARED:
			setINFRARED((Character)newValue);
			return;
		case Sensor_datatypesPackage.RANGE__HEADER:
			setHeader((Header)newValue);
			return;
		case Sensor_datatypesPackage.RANGE__RADIATION_TYPE:
			setRadiation_type((Character)newValue);
			return;
		case Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW:
			setField_of_view((Float)newValue);
			return;
		case Sensor_datatypesPackage.RANGE__MIN_RANGE:
			setMin_range((Float)newValue);
			return;
		case Sensor_datatypesPackage.RANGE__MAX_RANGE:
			setMax_range((Float)newValue);
			return;
		case Sensor_datatypesPackage.RANGE__RANGE:
			setRange((Float)newValue);
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
		case Sensor_datatypesPackage.RANGE__ULTRASOUND:
			setULTRASOUND(ULTRASOUND_EDEFAULT);
			return;
		case Sensor_datatypesPackage.RANGE__INFRARED:
			setINFRARED(INFRARED_EDEFAULT);
			return;
		case Sensor_datatypesPackage.RANGE__HEADER:
			setHeader((Header)null);
			return;
		case Sensor_datatypesPackage.RANGE__RADIATION_TYPE:
			setRadiation_type(RADIATION_TYPE_EDEFAULT);
			return;
		case Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW:
			setField_of_view(FIELD_OF_VIEW_EDEFAULT);
			return;
		case Sensor_datatypesPackage.RANGE__MIN_RANGE:
			setMin_range(MIN_RANGE_EDEFAULT);
			return;
		case Sensor_datatypesPackage.RANGE__MAX_RANGE:
			setMax_range(MAX_RANGE_EDEFAULT);
			return;
		case Sensor_datatypesPackage.RANGE__RANGE:
			setRange(RANGE_EDEFAULT);
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
		case Sensor_datatypesPackage.RANGE__ULTRASOUND:
			return ultrasound != ULTRASOUND_EDEFAULT;
		case Sensor_datatypesPackage.RANGE__INFRARED:
			return infrared != INFRARED_EDEFAULT;
		case Sensor_datatypesPackage.RANGE__HEADER:
			return header != null;
		case Sensor_datatypesPackage.RANGE__RADIATION_TYPE:
			return radiation_type != RADIATION_TYPE_EDEFAULT;
		case Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW:
			return field_of_view != FIELD_OF_VIEW_EDEFAULT;
		case Sensor_datatypesPackage.RANGE__MIN_RANGE:
			return min_range != MIN_RANGE_EDEFAULT;
		case Sensor_datatypesPackage.RANGE__MAX_RANGE:
			return max_range != MAX_RANGE_EDEFAULT;
		case Sensor_datatypesPackage.RANGE__RANGE:
			return range != RANGE_EDEFAULT;
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
		result.append(" (ULTRASOUND: ");
		result.append(ultrasound);
		result.append(", INFRARED: ");
		result.append(infrared);
		result.append(", radiation_type: ");
		result.append(radiation_type);
		result.append(", field_of_view: ");
		result.append(field_of_view);
		result.append(", min_range: ");
		result.append(min_range);
		result.append(", max_range: ");
		result.append(max_range);
		result.append(", range: ");
		result.append(range);
		result.append(')');
		return result.toString();
	}

} //RangeImpl
