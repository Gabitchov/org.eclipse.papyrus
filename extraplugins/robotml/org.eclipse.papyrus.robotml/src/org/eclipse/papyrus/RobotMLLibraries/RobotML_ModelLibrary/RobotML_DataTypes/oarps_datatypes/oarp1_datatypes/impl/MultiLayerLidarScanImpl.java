/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Layer Lidar Scan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.MultiLayerLidarScanImpl#getLayers <em>Layers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.MultiLayerLidarScanImpl#getNbLayer <em>Nb Layer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiLayerLidarScanImpl extends MinimalEObjectImpl.Container implements MultiLayerLidarScan {
	/**
	 * The cached value of the '{@link #getLayers() <em>Layers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayers()
	 * @generated
	 * @ordered
	 */
	protected ExtentedLidarScan layers;

	/**
	 * The default value of the '{@link #getNbLayer() <em>Nb Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbLayer()
	 * @generated
	 * @ordered
	 */
	protected static final char NB_LAYER_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getNbLayer() <em>Nb Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbLayer()
	 * @generated
	 * @ordered
	 */
	protected char nbLayer = NB_LAYER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiLayerLidarScanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Oarp1_datatypesPackage.Literals.MULTI_LAYER_LIDAR_SCAN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtentedLidarScan getLayers() {
		return layers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayers(ExtentedLidarScan newLayers, NotificationChain msgs) {
		ExtentedLidarScan oldLayers = layers;
		layers = newLayers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__LAYERS, oldLayers, newLayers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayers(ExtentedLidarScan newLayers) {
		if (newLayers != layers) {
			NotificationChain msgs = null;
			if (layers != null)
				msgs = ((InternalEObject)layers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__LAYERS, null, msgs);
			if (newLayers != null)
				msgs = ((InternalEObject)newLayers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__LAYERS, null, msgs);
			msgs = basicSetLayers(newLayers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__LAYERS, newLayers, newLayers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getNbLayer() {
		return nbLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbLayer(char newNbLayer) {
		char oldNbLayer = nbLayer;
		nbLayer = newNbLayer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__NB_LAYER, oldNbLayer, nbLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__LAYERS:
				return basicSetLayers(null, msgs);
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
			case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__LAYERS:
				return getLayers();
			case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__NB_LAYER:
				return getNbLayer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__LAYERS:
				setLayers((ExtentedLidarScan)newValue);
				return;
			case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__NB_LAYER:
				setNbLayer((Character)newValue);
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
			case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__LAYERS:
				setLayers((ExtentedLidarScan)null);
				return;
			case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__NB_LAYER:
				setNbLayer(NB_LAYER_EDEFAULT);
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
			case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__LAYERS:
				return layers != null;
			case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN__NB_LAYER:
				return nbLayer != NB_LAYER_EDEFAULT;
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
		result.append(" (nbLayer: ");
		result.append(nbLayer);
		result.append(')');
		return result.toString();
	}

} //MultiLayerLidarScanImpl
