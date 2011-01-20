/**
 * 
 *  Copyright (c) 2010 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Tatiana Fesenko(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util;

import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.*;

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
 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage
 * @generated
 */
public class UMLDiffSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMLDiffPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLDiffSwitch() {
		if (modelPackage == null) {
			modelPackage = UMLDiffPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UMLDiffPackage.UML_DIFF_EXTENSION: {
				UMLDiffExtension umlDiffExtension = (UMLDiffExtension)theEObject;
				T result = caseUMLDiffExtension(umlDiffExtension);
				if (result == null) result = caseAbstractDiffExtension(umlDiffExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLDiffPackage.STEREOTYPE_CHANGE: {
				StereotypeChange stereotypeChange = (StereotypeChange)theEObject;
				T result = caseStereotypeChange(stereotypeChange);
				if (result == null) result = caseUMLDiffExtension(stereotypeChange);
				if (result == null) result = caseAbstractDiffExtension(stereotypeChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLDiffPackage.TAGGED_VALUE_CHANGE: {
				TaggedValueChange taggedValueChange = (TaggedValueChange)theEObject;
				T result = caseTaggedValueChange(taggedValueChange);
				if (result == null) result = caseAttributeChange(taggedValueChange);
				if (result == null) result = caseAbstractDiffExtension(taggedValueChange);
				if (result == null) result = caseDiffElement(taggedValueChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLDiffPackage.TAGGED_VALUE_CHANGE_LEFT_TARGET: {
				TaggedValueChangeLeftTarget taggedValueChangeLeftTarget = (TaggedValueChangeLeftTarget)theEObject;
				T result = caseTaggedValueChangeLeftTarget(taggedValueChangeLeftTarget);
				if (result == null) result = caseAttributeChangeLeftTarget(taggedValueChangeLeftTarget);
				if (result == null) result = caseAttributeChange(taggedValueChangeLeftTarget);
				if (result == null) result = caseDiffElement(taggedValueChangeLeftTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLDiffPackage.TAGGED_VALUE_CHANGE_RIGHT_TARGET: {
				TaggedValueChangeRightTarget taggedValueChangeRightTarget = (TaggedValueChangeRightTarget)theEObject;
				T result = caseTaggedValueChangeRightTarget(taggedValueChangeRightTarget);
				if (result == null) result = caseAttributeChangeRightTarget(taggedValueChangeRightTarget);
				if (result == null) result = caseAttributeChange(taggedValueChangeRightTarget);
				if (result == null) result = caseDiffElement(taggedValueChangeRightTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLDiffPackage.UPDATE_TAGGED_VALUE: {
				UpdateTaggedValue updateTaggedValue = (UpdateTaggedValue)theEObject;
				T result = caseUpdateTaggedValue(updateTaggedValue);
				if (result == null) result = caseUpdateAttribute(updateTaggedValue);
				if (result == null) result = caseAttributeChange(updateTaggedValue);
				if (result == null) result = caseDiffElement(updateTaggedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION: {
				AddStereotypeApplication addStereotypeApplication = (AddStereotypeApplication)theEObject;
				T result = caseAddStereotypeApplication(addStereotypeApplication);
				if (result == null) result = caseStereotypeChange(addStereotypeApplication);
				if (result == null) result = caseUMLDiffExtension(addStereotypeApplication);
				if (result == null) result = caseAbstractDiffExtension(addStereotypeApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLDiffPackage.REMOVE_STEREOTYPE_APPLICATION: {
				RemoveStereotypeApplication removeStereotypeApplication = (RemoveStereotypeApplication)theEObject;
				T result = caseRemoveStereotypeApplication(removeStereotypeApplication);
				if (result == null) result = caseStereotypeChange(removeStereotypeApplication);
				if (result == null) result = caseUMLDiffExtension(removeStereotypeApplication);
				if (result == null) result = caseAbstractDiffExtension(removeStereotypeApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLDiffExtension(UMLDiffExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeChange(StereotypeChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tagged Value Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tagged Value Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaggedValueChange(TaggedValueChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tagged Value Change Left Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tagged Value Change Left Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaggedValueChangeLeftTarget(TaggedValueChangeLeftTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tagged Value Change Right Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tagged Value Change Right Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaggedValueChangeRightTarget(TaggedValueChangeRightTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Tagged Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Tagged Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateTaggedValue(UpdateTaggedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Stereotype Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Stereotype Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddStereotypeApplication(AddStereotypeApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Stereotype Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Stereotype Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveStereotypeApplication(RemoveStereotypeApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Diff Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Diff Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractDiffExtension(AbstractDiffExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiffElement(DiffElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeChange(AttributeChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Change Left Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Change Left Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeChangeLeftTarget(AttributeChangeLeftTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Change Right Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Change Right Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeChangeRightTarget(AttributeChangeRightTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateAttribute(UpdateAttribute object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //UMLDiffSwitch
