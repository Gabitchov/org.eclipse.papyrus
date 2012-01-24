/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.requirements.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.sysml.requirements.Copy;
import org.eclipse.papyrus.sysml.requirements.DeriveReqt;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementRelated;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.requirements.Satisfy;
import org.eclipse.papyrus.sysml.requirements.TestCase;
import org.eclipse.papyrus.sysml.requirements.Verify;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.profile.l2.Trace;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage
 * @generated
 */
public class RequirementsSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static RequirementsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementsSwitch() {
		if(modelPackage == null) {
			modelPackage = RequirementsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		/**
		 * ePackage == UMLPackage.eINSTANCE in order to accept UML element
		 */
		return ePackage == modelPackage || ePackage == UMLPackage.eINSTANCE;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Copy</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Copy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCopy(Copy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Derive Reqt</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Derive Reqt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeriveReqt(DeriveReqt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirement(Requirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement Related</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement Related</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementRelated(RequirementRelated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Satisfy</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Satisfy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSatisfy(Satisfy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Case</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestCase(TestCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrace(Trace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verify</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verify</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerify(Verify object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

	/**
	 * Tell if the Abstraction is a DeriveReqt implementation
	 * 
	 * @param Abstraction
	 * @return
	 * @generated
	 */
	protected Boolean isDeriveReqtFromAbstraction(Abstraction abstraction_) {
		if(UMLUtil.getStereotypeApplication(abstraction_, DeriveReqt.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DeriveReqt</em>' from Abstraction object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DeriveReqt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractionStereotypedByDeriveReqt(Abstraction abstraction_) {
		return null;
	}

	/**
	 * Tell if the Abstraction is a Verify implementation
	 * 
	 * @param Abstraction
	 * @return
	 * @generated
	 */
	protected Boolean isVerifyFromAbstraction(Abstraction abstraction_) {
		if(UMLUtil.getStereotypeApplication(abstraction_, Verify.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verify</em>' from Abstraction object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verify</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractionStereotypedByVerify(Abstraction abstraction_) {
		return null;
	}

	/**
	 * Tell if the Abstraction is a Copy implementation
	 * 
	 * @param Abstraction
	 * @return
	 * @generated
	 */
	protected Boolean isCopyFromAbstraction(Abstraction abstraction_) {
		if(UMLUtil.getStereotypeApplication(abstraction_, Copy.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Copy</em>' from Abstraction object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Copy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractionStereotypedByCopy(Abstraction abstraction_) {
		return null;
	}

	/**
	 * Tell if the Abstraction is a Satisfy implementation
	 * 
	 * @param Abstraction
	 * @return
	 * @generated
	 */
	protected Boolean isSatisfyFromAbstraction(Abstraction abstraction_) {
		if(UMLUtil.getStereotypeApplication(abstraction_, Satisfy.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Satisfy</em>' from Abstraction object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Satisfy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractionStereotypedBySatisfy(Abstraction abstraction_) {
		return null;
	}

	/**
	 * Tell if the Behavior is a TestCase implementation
	 * 
	 * @param Behavior
	 * @return
	 * @generated
	 */
	protected Boolean isTestCaseFromBehavior(Behavior behavior_) {
		if(UMLUtil.getStereotypeApplication(behavior_, TestCase.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TestCase</em>' from Behavior object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TestCase</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorStereotypedByTestCase(Behavior behavior_) {
		return null;
	}

	/**
	 * Tell if the Operation is a TestCase implementation
	 * 
	 * @param Operation
	 * @return
	 * @generated
	 */
	protected Boolean isTestCaseFromOperation(Operation operation_) {
		if(UMLUtil.getStereotypeApplication(operation_, TestCase.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TestCase</em>' from Operation object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TestCase</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationStereotypedByTestCase(Operation operation_) {
		return null;
	}

	/**
	 * Tell if the Class is a Requirement implementation
	 * 
	 * @param Class
	 * @return
	 * @generated
	 */
	protected Boolean isRequirementFromClass(Class class_) {
		if(UMLUtil.getStereotypeApplication(class_, Requirement.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement</em>' from Class object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassStereotypedByRequirement(Class class_) {
		return null;
	}

	/**
	 * Tell if the NamedElement is a RequirementRelated implementation
	 * 
	 * @param NamedElement
	 * @return
	 * @generated
	 */
	protected Boolean isRequirementRelatedFromNamedElement(NamedElement namedElement_) {
		if(UMLUtil.getStereotypeApplication(namedElement_, RequirementRelated.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RequirementRelated</em>' from NamedElement object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RequirementRelated</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElementStereotypedByRequirementRelated(NamedElement namedElement_) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		if(theEObject.eClass().getEPackage() == UMLPackage.eINSTANCE) {
			switch(classifierID) {





			case UMLPackage.ABSTRACTION:
			{
				Abstraction umlElement = (Abstraction)theEObject;
				T result;

				result = caseAbstractionStereotypedByDeriveReqt(umlElement);
				if(result != null) {
					return result;
				}




				result = caseAbstractionStereotypedByVerify(umlElement);
				if(result != null) {
					return result;
				}




				result = caseAbstractionStereotypedByCopy(umlElement);
				if(result != null) {
					return result;
				}




				result = caseAbstractionStereotypedBySatisfy(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.BEHAVIOR:
			{
				Behavior umlElement = (Behavior)theEObject;
				T result;

				result = caseBehaviorStereotypedByTestCase(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.CLASS:
			{
				Class umlElement = (Class)theEObject;
				T result;

				result = caseClassStereotypedByRequirement(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.NAMED_ELEMENT:
			{
				NamedElement umlElement = (NamedElement)theEObject;
				T result;

				result = caseNamedElementStereotypedByRequirementRelated(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.OPERATION:
			{
				Operation umlElement = (Operation)theEObject;
				T result;

				result = caseOperationStereotypedByTestCase(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}




			default:
				return defaultCase(theEObject);
			}




		} else {
			switch(classifierID) {

			case RequirementsPackage.DERIVE_REQT:
			{
				DeriveReqt deriveReqt = (DeriveReqt)theEObject;
				T result = caseDeriveReqt(deriveReqt);

				if(result == null)
					result = caseTrace(deriveReqt);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case RequirementsPackage.VERIFY:
			{
				Verify verify = (Verify)theEObject;
				T result = caseVerify(verify);

				if(result == null)
					result = caseTrace(verify);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case RequirementsPackage.COPY:
			{
				Copy copy = (Copy)theEObject;
				T result = caseCopy(copy);

				if(result == null)
					result = caseTrace(copy);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case RequirementsPackage.SATISFY:
			{
				Satisfy satisfy = (Satisfy)theEObject;
				T result = caseSatisfy(satisfy);

				if(result == null)
					result = caseTrace(satisfy);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case RequirementsPackage.TEST_CASE:
			{
				TestCase testCase = (TestCase)theEObject;
				T result = caseTestCase(testCase);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case RequirementsPackage.REQUIREMENT:
			{
				Requirement requirement = (Requirement)theEObject;
				T result = caseRequirement(requirement);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case RequirementsPackage.REQUIREMENT_RELATED:
			{
				RequirementRelated requirementRelated = (RequirementRelated)theEObject;
				T result = caseRequirementRelated(requirementRelated);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}

			default:
				return defaultCase(theEObject);
			}
		}
	}

} // RequirementsSwitch
