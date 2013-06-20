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
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.RobotML.LidarSystem;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lidar System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getNbLayers <em>Nb Layers</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getLayerAngleMin <em>Layer Angle Min</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getLayerAngleStep <em>Layer Angle Step</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#isNoise <em>Noise</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getSigmaNoise <em>Sigma Noise</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getAngle_min <em>Angle min</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getAngle_max <em>Angle max</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getTime_increment <em>Time increment</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getScan_time <em>Scan time</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getRange_min <em>Range min</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getRange_max <em>Range max</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getNbRays <em>Nb Rays</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class LidarSystemImpl extends ObjectDetectionSensorSystemImpl implements LidarSystem {

	/**
	 * The default value of the '{@link #getNbLayers() <em>Nb Layers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNbLayers()
	 * @generated
	 * @ordered
	 */
	protected static final long NB_LAYERS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getNbLayers() <em>Nb Layers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNbLayers()
	 * @generated
	 * @ordered
	 */
	protected long nbLayers = NB_LAYERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayerAngleMin() <em>Layer Angle Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerAngleMin()
	 * @generated
	 * @ordered
	 */
	protected static final float LAYER_ANGLE_MIN_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getLayerAngleMin() <em>Layer Angle Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerAngleMin()
	 * @generated
	 * @ordered
	 */
	protected float layerAngleMin = LAYER_ANGLE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayerAngleStep() <em>Layer Angle Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerAngleStep()
	 * @generated
	 * @ordered
	 */
	protected static final float LAYER_ANGLE_STEP_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getLayerAngleStep() <em>Layer Angle Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerAngleStep()
	 * @generated
	 * @ordered
	 */
	protected float layerAngleStep = LAYER_ANGLE_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoise() <em>Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isNoise()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NOISE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoise() <em>Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isNoise()
	 * @generated
	 * @ordered
	 */
	protected boolean noise = NOISE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSigmaNoise() <em>Sigma Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSigmaNoise()
	 * @generated
	 * @ordered
	 */
	protected static final float SIGMA_NOISE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSigmaNoise() <em>Sigma Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSigmaNoise()
	 * @generated
	 * @ordered
	 */
	protected float sigmaNoise = SIGMA_NOISE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAngle_min() <em>Angle min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAngle_min()
	 * @generated
	 * @ordered
	 */
	protected static final float ANGLE_MIN_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAngle_min() <em>Angle min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAngle_min()
	 * @generated
	 * @ordered
	 */
	protected float angle_min = ANGLE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAngle_max() <em>Angle max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAngle_max()
	 * @generated
	 * @ordered
	 */
	protected static final float ANGLE_MAX_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAngle_max() <em>Angle max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAngle_max()
	 * @generated
	 * @ordered
	 */
	protected float angle_max = ANGLE_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime_increment() <em>Time increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTime_increment()
	 * @generated
	 * @ordered
	 */
	protected static final float TIME_INCREMENT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getTime_increment() <em>Time increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTime_increment()
	 * @generated
	 * @ordered
	 */
	protected float time_increment = TIME_INCREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getScan_time() <em>Scan time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getScan_time()
	 * @generated
	 * @ordered
	 */
	protected static final float SCAN_TIME_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getScan_time() <em>Scan time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getScan_time()
	 * @generated
	 * @ordered
	 */
	protected float scan_time = SCAN_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRange_min() <em>Range min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRange_min()
	 * @generated
	 * @ordered
	 */
	protected static final float RANGE_MIN_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getRange_min() <em>Range min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRange_min()
	 * @generated
	 * @ordered
	 */
	protected float range_min = RANGE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getRange_max() <em>Range max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRange_max()
	 * @generated
	 * @ordered
	 */
	protected static final float RANGE_MAX_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getRange_max() <em>Range max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRange_max()
	 * @generated
	 * @ordered
	 */
	protected float range_max = RANGE_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbRays() <em>Nb Rays</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNbRays()
	 * @generated
	 * @ordered
	 */
	protected static final long NB_RAYS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getNbRays() <em>Nb Rays</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNbRays()
	 * @generated
	 * @ordered
	 */
	protected long nbRays = NB_RAYS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LidarSystemImpl() {
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
		return RobotMLPackage.Literals.LIDAR_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getNbLayers() {
		return nbLayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNbLayers(long newNbLayers) {
		long oldNbLayers = nbLayers;
		nbLayers = newNbLayers;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS, oldNbLayers, nbLayers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getLayerAngleMin() {
		return layerAngleMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLayerAngleMin(float newLayerAngleMin) {
		float oldLayerAngleMin = layerAngleMin;
		layerAngleMin = newLayerAngleMin;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN, oldLayerAngleMin, layerAngleMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getLayerAngleStep() {
		return layerAngleStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLayerAngleStep(float newLayerAngleStep) {
		float oldLayerAngleStep = layerAngleStep;
		layerAngleStep = newLayerAngleStep;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP, oldLayerAngleStep, layerAngleStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isNoise() {
		return noise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNoise(boolean newNoise) {
		boolean oldNoise = noise;
		noise = newNoise;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__NOISE, oldNoise, noise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getSigmaNoise() {
		return sigmaNoise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSigmaNoise(float newSigmaNoise) {
		float oldSigmaNoise = sigmaNoise;
		sigmaNoise = newSigmaNoise;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE, oldSigmaNoise, sigmaNoise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getAngle_min() {
		return angle_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAngle_min(float newAngle_min) {
		float oldAngle_min = angle_min;
		angle_min = newAngle_min;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN, oldAngle_min, angle_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getAngle_max() {
		return angle_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAngle_max(float newAngle_max) {
		float oldAngle_max = angle_max;
		angle_max = newAngle_max;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX, oldAngle_max, angle_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getTime_increment() {
		return time_increment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTime_increment(float newTime_increment) {
		float oldTime_increment = time_increment;
		time_increment = newTime_increment;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT, oldTime_increment, time_increment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getScan_time() {
		return scan_time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setScan_time(float newScan_time) {
		float oldScan_time = scan_time;
		scan_time = newScan_time;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME, oldScan_time, scan_time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getRange_min() {
		return range_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRange_min(float newRange_min) {
		float oldRange_min = range_min;
		range_min = newRange_min;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN, oldRange_min, range_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getRange_max() {
		return range_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRange_max(float newRange_max) {
		float oldRange_max = range_max;
		range_max = newRange_max;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX, oldRange_max, range_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getNbRays() {
		return nbRays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNbRays(long newNbRays) {
		long oldNbRays = nbRays;
		nbRays = newNbRays;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__NB_RAYS, oldNbRays, nbRays));
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
		case RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS:
			return getNbLayers();
		case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN:
			return getLayerAngleMin();
		case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP:
			return getLayerAngleStep();
		case RobotMLPackage.LIDAR_SYSTEM__NOISE:
			return isNoise();
		case RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE:
			return getSigmaNoise();
		case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN:
			return getAngle_min();
		case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX:
			return getAngle_max();
		case RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT:
			return getTime_increment();
		case RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME:
			return getScan_time();
		case RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN:
			return getRange_min();
		case RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX:
			return getRange_max();
		case RobotMLPackage.LIDAR_SYSTEM__NB_RAYS:
			return getNbRays();
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
		case RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS:
			setNbLayers((Long)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN:
			setLayerAngleMin((Float)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP:
			setLayerAngleStep((Float)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__NOISE:
			setNoise((Boolean)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE:
			setSigmaNoise((Float)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN:
			setAngle_min((Float)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX:
			setAngle_max((Float)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT:
			setTime_increment((Float)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME:
			setScan_time((Float)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN:
			setRange_min((Float)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX:
			setRange_max((Float)newValue);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__NB_RAYS:
			setNbRays((Long)newValue);
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
		case RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS:
			setNbLayers(NB_LAYERS_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN:
			setLayerAngleMin(LAYER_ANGLE_MIN_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP:
			setLayerAngleStep(LAYER_ANGLE_STEP_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__NOISE:
			setNoise(NOISE_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE:
			setSigmaNoise(SIGMA_NOISE_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN:
			setAngle_min(ANGLE_MIN_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX:
			setAngle_max(ANGLE_MAX_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT:
			setTime_increment(TIME_INCREMENT_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME:
			setScan_time(SCAN_TIME_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN:
			setRange_min(RANGE_MIN_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX:
			setRange_max(RANGE_MAX_EDEFAULT);
			return;
		case RobotMLPackage.LIDAR_SYSTEM__NB_RAYS:
			setNbRays(NB_RAYS_EDEFAULT);
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
		case RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS:
			return nbLayers != NB_LAYERS_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN:
			return layerAngleMin != LAYER_ANGLE_MIN_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP:
			return layerAngleStep != LAYER_ANGLE_STEP_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__NOISE:
			return noise != NOISE_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE:
			return sigmaNoise != SIGMA_NOISE_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN:
			return angle_min != ANGLE_MIN_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX:
			return angle_max != ANGLE_MAX_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT:
			return time_increment != TIME_INCREMENT_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME:
			return scan_time != SCAN_TIME_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN:
			return range_min != RANGE_MIN_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX:
			return range_max != RANGE_MAX_EDEFAULT;
		case RobotMLPackage.LIDAR_SYSTEM__NB_RAYS:
			return nbRays != NB_RAYS_EDEFAULT;
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
		result.append(" (nbLayers: ");
		result.append(nbLayers);
		result.append(", layerAngleMin: ");
		result.append(layerAngleMin);
		result.append(", layerAngleStep: ");
		result.append(layerAngleStep);
		result.append(", noise: ");
		result.append(noise);
		result.append(", sigmaNoise: ");
		result.append(sigmaNoise);
		result.append(", angle_min: ");
		result.append(angle_min);
		result.append(", angle_max: ");
		result.append(angle_max);
		result.append(", time_increment: ");
		result.append(time_increment);
		result.append(", scan_time: ");
		result.append(scan_time);
		result.append(", range_min: ");
		result.append(range_min);
		result.append(", range_max: ");
		result.append(range_max);
		result.append(", nbRays: ");
		result.append(nbRays);
		result.append(')');
		return result.toString();
	}

} //LidarSystemImpl
