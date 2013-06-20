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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Angular;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Distance;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Metric;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Milli_Amp;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Op_Set_Point;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Linear;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage
 * @generated
 */
public class Oarp4_datatypesAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static Oarp4_datatypesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Oarp4_datatypesAdapterFactory() {
		if(modelPackage == null) {
			modelPackage = Oarp4_datatypesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if(object == modelPackage) {
			return true;
		}
		if(object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Oarp4_datatypesSwitch<Adapter> modelSwitch = new Oarp4_datatypesSwitch<Adapter>() {

		@Override
		public Adapter caseVelocity_Linear(Velocity_Linear object) {
			return createVelocity_LinearAdapter();
		}

		@Override
		public Adapter caseArt_Set_Point(Art_Set_Point object) {
			return createArt_Set_PointAdapter();
		}

		@Override
		public Adapter caseVelocity_Angular(Velocity_Angular object) {
			return createVelocity_AngularAdapter();
		}

		@Override
		public Adapter caseDistance(Distance object) {
			return createDistanceAdapter();
		}

		@Override
		public Adapter caseMetric(Metric object) {
			return createMetricAdapter();
		}

		@Override
		public Adapter caseAngular(Angular object) {
			return createAngularAdapter();
		}

		@Override
		public Adapter caseOp_Set_Point(Op_Set_Point object) {
			return createOp_Set_PointAdapter();
		}

		@Override
		public Adapter caseSpeed_Tics_Left_Right(Speed_Tics_Left_Right object) {
			return createSpeed_Tics_Left_RightAdapter();
		}

		@Override
		public Adapter caseSpeed_Tics(Speed_Tics object) {
			return createSpeed_TicsAdapter();
		}

		@Override
		public Adapter caseOdometer_Tics(Odometer_Tics object) {
			return createOdometer_TicsAdapter();
		}

		@Override
		public Adapter caseOdometer_Tics_Left_Right(Odometer_Tics_Left_Right object) {
			return createOdometer_Tics_Left_RightAdapter();
		}

		@Override
		public Adapter caseProxi_Left_Right(Proxi_Left_Right object) {
			return createProxi_Left_RightAdapter();
		}

		@Override
		public Adapter caseMilli_Amp(Milli_Amp object) {
			return createMilli_AmpAdapter();
		}

		@Override
		public Adapter caseOdometer_Linear_Left_Right(Odometer_Linear_Left_Right object) {
			return createOdometer_Linear_Left_RightAdapter();
		}

		@Override
		public Adapter caseVelocity_Angular_Left_Right(Velocity_Angular_Left_Right object) {
			return createVelocity_Angular_Left_RightAdapter();
		}

		@Override
		public Adapter caseVelocity(Velocity object) {
			return createVelocityAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *        the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Linear
	 * <em>Velocity Linear</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Linear
	 * @generated
	 */
	public Adapter createVelocity_LinearAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point
	 * <em>Art Set Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point
	 * @generated
	 */
	public Adapter createArt_Set_PointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular
	 * <em>Velocity Angular</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular
	 * @generated
	 */
	public Adapter createVelocity_AngularAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Distance <em>Distance</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Distance
	 * @generated
	 */
	public Adapter createDistanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Metric
	 * @generated
	 */
	public Adapter createMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Angular <em>Angular</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Angular
	 * @generated
	 */
	public Adapter createAngularAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Op_Set_Point
	 * <em>Op Set Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Op_Set_Point
	 * @generated
	 */
	public Adapter createOp_Set_PointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right
	 * <em>Speed Tics Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right
	 * @generated
	 */
	public Adapter createSpeed_Tics_Left_RightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics
	 * <em>Speed Tics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics
	 * @generated
	 */
	public Adapter createSpeed_TicsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics
	 * <em>Odometer Tics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics
	 * @generated
	 */
	public Adapter createOdometer_TicsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right
	 * <em>Odometer Tics Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right
	 * @generated
	 */
	public Adapter createOdometer_Tics_Left_RightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right
	 * <em>Proxi Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right
	 * @generated
	 */
	public Adapter createProxi_Left_RightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Milli_Amp
	 * <em>Milli Amp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Milli_Amp
	 * @generated
	 */
	public Adapter createMilli_AmpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right
	 * <em>Odometer Linear Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right
	 * @generated
	 */
	public Adapter createOdometer_Linear_Left_RightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right
	 * <em>Velocity Angular Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right
	 * @generated
	 */
	public Adapter createVelocity_Angular_Left_RightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity <em>Velocity</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity
	 * @generated
	 */
	public Adapter createVelocityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Oarp4_datatypesAdapterFactory
