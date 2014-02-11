/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage
 * @generated
 */
public class Oarp4_datatypesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Oarp4_datatypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Oarp4_datatypesSwitch() {
		if (modelPackage == null) {
			modelPackage = Oarp4_datatypesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Oarp4_datatypesPackage.VELOCITY_LINEAR: {
				Velocity_Linear velocity_Linear = (Velocity_Linear)theEObject;
				T result = caseVelocity_Linear(velocity_Linear);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.ART_SET_POINT: {
				Art_Set_Point art_Set_Point = (Art_Set_Point)theEObject;
				T result = caseArt_Set_Point(art_Set_Point);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR: {
				Velocity_Angular velocity_Angular = (Velocity_Angular)theEObject;
				T result = caseVelocity_Angular(velocity_Angular);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.DISTANCE: {
				Distance distance = (Distance)theEObject;
				T result = caseDistance(distance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.METRIC: {
				Metric metric = (Metric)theEObject;
				T result = caseMetric(metric);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.ANGULAR: {
				Angular angular = (Angular)theEObject;
				T result = caseAngular(angular);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.OP_SET_POINT: {
				Op_Set_Point op_Set_Point = (Op_Set_Point)theEObject;
				T result = caseOp_Set_Point(op_Set_Point);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT: {
				Speed_Tics_Left_Right speed_Tics_Left_Right = (Speed_Tics_Left_Right)theEObject;
				T result = caseSpeed_Tics_Left_Right(speed_Tics_Left_Right);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.SPEED_TICS: {
				Speed_Tics speed_Tics = (Speed_Tics)theEObject;
				T result = caseSpeed_Tics(speed_Tics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.ODOMETER_TICS: {
				Odometer_Tics odometer_Tics = (Odometer_Tics)theEObject;
				T result = caseOdometer_Tics(odometer_Tics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT: {
				Odometer_Tics_Left_Right odometer_Tics_Left_Right = (Odometer_Tics_Left_Right)theEObject;
				T result = caseOdometer_Tics_Left_Right(odometer_Tics_Left_Right);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT: {
				Proxi_Left_Right proxi_Left_Right = (Proxi_Left_Right)theEObject;
				T result = caseProxi_Left_Right(proxi_Left_Right);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.MILLI_AMP: {
				Milli_Amp milli_Amp = (Milli_Amp)theEObject;
				T result = caseMilli_Amp(milli_Amp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT: {
				Odometer_Linear_Left_Right odometer_Linear_Left_Right = (Odometer_Linear_Left_Right)theEObject;
				T result = caseOdometer_Linear_Left_Right(odometer_Linear_Left_Right);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT: {
				Velocity_Angular_Left_Right velocity_Angular_Left_Right = (Velocity_Angular_Left_Right)theEObject;
				T result = caseVelocity_Angular_Left_Right(velocity_Angular_Left_Right);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Oarp4_datatypesPackage.VELOCITY: {
				Velocity velocity = (Velocity)theEObject;
				T result = caseVelocity(velocity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Velocity Linear</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Velocity Linear</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVelocity_Linear(Velocity_Linear object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Art Set Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Art Set Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArt_Set_Point(Art_Set_Point object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Velocity Angular</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Velocity Angular</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVelocity_Angular(Velocity_Angular object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Distance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Distance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDistance(Distance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metric</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metric</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetric(Metric object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Angular</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Angular</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAngular(Angular object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Op Set Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Op Set Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOp_Set_Point(Op_Set_Point object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Speed Tics Left Right</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Speed Tics Left Right</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpeed_Tics_Left_Right(Speed_Tics_Left_Right object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Speed Tics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Speed Tics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpeed_Tics(Speed_Tics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Odometer Tics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Odometer Tics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOdometer_Tics(Odometer_Tics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Odometer Tics Left Right</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Odometer Tics Left Right</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOdometer_Tics_Left_Right(Odometer_Tics_Left_Right object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxi Left Right</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxi Left Right</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxi_Left_Right(Proxi_Left_Right object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Milli Amp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Milli Amp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMilli_Amp(Milli_Amp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Odometer Linear Left Right</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Odometer Linear Left Right</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOdometer_Linear_Left_Right(Odometer_Linear_Left_Right object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Velocity Angular Left Right</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Velocity Angular Left Right</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVelocity_Angular_Left_Right(Velocity_Angular_Left_Right object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Velocity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Velocity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVelocity(Velocity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Oarp4_datatypesSwitch
