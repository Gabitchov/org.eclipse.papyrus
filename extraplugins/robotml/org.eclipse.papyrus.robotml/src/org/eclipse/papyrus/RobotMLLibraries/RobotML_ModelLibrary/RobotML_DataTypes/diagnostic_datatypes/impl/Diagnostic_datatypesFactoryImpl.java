/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Diagnostic_datatypesFactoryImpl extends EFactoryImpl implements Diagnostic_datatypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Diagnostic_datatypesFactory init() {
		try {
			Diagnostic_datatypesFactory theDiagnostic_datatypesFactory = (Diagnostic_datatypesFactory)EPackage.Registry.INSTANCE.getEFactory(Diagnostic_datatypesPackage.eNS_URI);
			if (theDiagnostic_datatypesFactory != null) {
				return theDiagnostic_datatypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Diagnostic_datatypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic_datatypesFactoryImpl() {
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
			case Diagnostic_datatypesPackage.DIAGNOSTIC_ARRAY: return createDiagnosticArray();
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS: return createDiagnosticStatus();
			case Diagnostic_datatypesPackage.KEY_VALUE: return createKeyValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagnosticArray createDiagnosticArray() {
		DiagnosticArrayImpl diagnosticArray = new DiagnosticArrayImpl();
		return diagnosticArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagnosticStatus createDiagnosticStatus() {
		DiagnosticStatusImpl diagnosticStatus = new DiagnosticStatusImpl();
		return diagnosticStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyValue createKeyValue() {
		KeyValueImpl keyValue = new KeyValueImpl();
		return keyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic_datatypesPackage getDiagnostic_datatypesPackage() {
		return (Diagnostic_datatypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Diagnostic_datatypesPackage getPackage() {
		return Diagnostic_datatypesPackage.eINSTANCE;
	}

} //Diagnostic_datatypesFactoryImpl
