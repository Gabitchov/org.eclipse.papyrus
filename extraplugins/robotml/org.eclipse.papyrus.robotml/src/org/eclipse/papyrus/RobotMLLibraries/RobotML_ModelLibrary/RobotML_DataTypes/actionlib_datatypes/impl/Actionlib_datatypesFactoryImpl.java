/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Actionlib_datatypesFactoryImpl extends EFactoryImpl implements Actionlib_datatypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Actionlib_datatypesFactory init() {
		try {
			Actionlib_datatypesFactory theActionlib_datatypesFactory = (Actionlib_datatypesFactory)EPackage.Registry.INSTANCE.getEFactory(Actionlib_datatypesPackage.eNS_URI);
			if (theActionlib_datatypesFactory != null) {
				return theActionlib_datatypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Actionlib_datatypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actionlib_datatypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Actionlib_datatypesPackage.GOAL_ID: return createGoalID();
			case Actionlib_datatypesPackage.GOAL_STATUS: return createGoalStatus();
			case Actionlib_datatypesPackage.GOAL_STATUS_ARRAY: return createGoalStatusArray();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalID createGoalID() {
		GoalIDImpl goalID = new GoalIDImpl();
		return goalID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalStatus createGoalStatus() {
		GoalStatusImpl goalStatus = new GoalStatusImpl();
		return goalStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalStatusArray createGoalStatusArray() {
		GoalStatusArrayImpl goalStatusArray = new GoalStatusArrayImpl();
		return goalStatusArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actionlib_datatypesPackage getActionlib_datatypesPackage() {
		return (Actionlib_datatypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Actionlib_datatypesPackage getPackage() {
		return Actionlib_datatypesPackage.eINSTANCE;
	}

} //Actionlib_datatypesFactoryImpl
