/**
 */
package org.eclipse.papyrus.facade.virtualmetamodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.facade.virtualmetamodel.*;

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
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage
 * @generated
 */
public class VirtualmetamodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VirtualmetamodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualmetamodelSwitch() {
		if (modelPackage == null) {
			modelPackage = VirtualmetamodelPackage.eINSTANCE;
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
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL: {
				VirtualMetamodel virtualMetamodel = (VirtualMetamodel)theEObject;
				T result = caseVirtualMetamodel(virtualMetamodel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT: {
				VirtualElement virtualElement = (VirtualElement)theEObject;
				T result = caseVirtualElement(virtualElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualmetamodelPackage.VIRTUAL_CLASSIFIER: {
				VirtualClassifier virtualClassifier = (VirtualClassifier)theEObject;
				T result = caseVirtualClassifier(virtualClassifier);
				if (result == null) result = caseVirtualElement(virtualClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualmetamodelPackage.VIRTUAL_METACLASS: {
				VirtualMetaclass virtualMetaclass = (VirtualMetaclass)theEObject;
				T result = caseVirtualMetaclass(virtualMetaclass);
				if (result == null) result = caseVirtualClassifier(virtualMetaclass);
				if (result == null) result = caseVirtualElement(virtualMetaclass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY: {
				VirtualProperty virtualProperty = (VirtualProperty)theEObject;
				T result = caseVirtualProperty(virtualProperty);
				if (result == null) result = caseVirtualElement(virtualProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualmetamodelPackage.VIRTUAL_OPERATION: {
				VirtualOperation virtualOperation = (VirtualOperation)theEObject;
				T result = caseVirtualOperation(virtualOperation);
				if (result == null) result = caseVirtualElement(virtualOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualmetamodelPackage.VIRTUAL_PARAMETER: {
				VirtualParameter virtualParameter = (VirtualParameter)theEObject;
				T result = caseVirtualParameter(virtualParameter);
				if (result == null) result = caseVirtualElement(virtualParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualmetamodelPackage.VIRTUAL_DATATYPE: {
				VirtualDatatype virtualDatatype = (VirtualDatatype)theEObject;
				T result = caseVirtualDatatype(virtualDatatype);
				if (result == null) result = caseVirtualClassifier(virtualDatatype);
				if (result == null) result = caseVirtualElement(virtualDatatype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualmetamodelPackage.VIRTUAL_ENUM: {
				VirtualEnum virtualEnum = (VirtualEnum)theEObject;
				T result = caseVirtualEnum(virtualEnum);
				if (result == null) result = caseVirtualClassifier(virtualEnum);
				if (result == null) result = caseVirtualElement(virtualEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualmetamodelPackage.VIRTUAL_LITERAL: {
				VirtualLiteral virtualLiteral = (VirtualLiteral)theEObject;
				T result = caseVirtualLiteral(virtualLiteral);
				if (result == null) result = caseVirtualElement(virtualLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Metamodel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualMetamodel(VirtualMetamodel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualElement(VirtualElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualClassifier(VirtualClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Metaclass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Metaclass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualMetaclass(VirtualMetaclass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualProperty(VirtualProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualOperation(VirtualOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualParameter(VirtualParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Datatype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Datatype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualDatatype(VirtualDatatype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualEnum(VirtualEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualLiteral(VirtualLiteral object) {
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

} //VirtualmetamodelSwitch
