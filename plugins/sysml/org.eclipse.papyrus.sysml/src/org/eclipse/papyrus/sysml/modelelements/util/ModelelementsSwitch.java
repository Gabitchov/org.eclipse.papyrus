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
package org.eclipse.papyrus.sysml.modelelements.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.sysml.modelelements.Conform;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml.modelelements.Problem;
import org.eclipse.papyrus.sysml.modelelements.Rationale;
import org.eclipse.papyrus.sysml.modelelements.View;
import org.eclipse.papyrus.sysml.modelelements.ViewPoint;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage
 * @generated
 */
public class ModelelementsSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ModelelementsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelelementsSwitch() {
		if(modelPackage == null) {
			modelPackage = ModelelementsPackage.eINSTANCE;
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
	 * Returns the result of interpreting the object as an instance of '<em>Conform</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConform(Conform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Problem</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Problem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProblem(Problem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rationale</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rationale</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRationale(Rationale object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>View</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseView(View object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Point</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewPoint(ViewPoint object) {
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
	 * Tell if the Dependency is a Conform implementation
	 * 
	 * @param Dependency
	 * @return
	 * @generated
	 */
	protected Boolean isConformFromDependency(Dependency dependency_) {
		if(UMLUtil.getStereotypeApplication(dependency_, Conform.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conform</em>' from Dependency object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyStereotypedByConform(Dependency dependency_) {
		return null;
	}

	/**
	 * Tell if the Package is a View implementation
	 * 
	 * @param Package
	 * @return
	 * @generated
	 */
	protected Boolean isViewFromPackage(Package package_) {
		if(UMLUtil.getStereotypeApplication(package_, View.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>' from Package object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageStereotypedByView(Package package_) {
		return null;
	}

	/**
	 * Tell if the Class is a ViewPoint implementation
	 * 
	 * @param Class
	 * @return
	 * @generated
	 */
	protected Boolean isViewPointFromClass(Class class_) {
		if(UMLUtil.getStereotypeApplication(class_, ViewPoint.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ViewPoint</em>' from Class object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ViewPoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassStereotypedByViewPoint(Class class_) {
		return null;
	}

	/**
	 * Tell if the Comment is a Rationale implementation
	 * 
	 * @param Comment
	 * @return
	 * @generated
	 */
	protected Boolean isRationaleFromComment(Comment comment_) {
		if(UMLUtil.getStereotypeApplication(comment_, Rationale.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rationale</em>' from Comment object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rationale</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommentStereotypedByRationale(Comment comment_) {
		return null;
	}

	/**
	 * Tell if the Comment is a Problem implementation
	 * 
	 * @param Comment
	 * @return
	 * @generated
	 */
	protected Boolean isProblemFromComment(Comment comment_) {
		if(UMLUtil.getStereotypeApplication(comment_, Problem.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Problem</em>' from Comment object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Problem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommentStereotypedByProblem(Comment comment_) {
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





			case UMLPackage.CLASS:
			{
				Class umlElement = (Class)theEObject;
				T result;

				result = caseClassStereotypedByViewPoint(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.COMMENT:
			{
				Comment umlElement = (Comment)theEObject;
				T result;

				result = caseCommentStereotypedByRationale(umlElement);
				if(result != null) {
					return result;
				}




				result = caseCommentStereotypedByProblem(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.DEPENDENCY:
			{
				Dependency umlElement = (Dependency)theEObject;
				T result;

				result = caseDependencyStereotypedByConform(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.PACKAGE:
			{
				Package umlElement = (Package)theEObject;
				T result;

				result = casePackageStereotypedByView(umlElement);
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

			case ModelelementsPackage.CONFORM:
			{
				Conform conform = (Conform)theEObject;
				T result = caseConform(conform);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case ModelelementsPackage.VIEW:
			{
				View view = (View)theEObject;
				T result = caseView(view);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case ModelelementsPackage.VIEW_POINT:
			{
				ViewPoint viewPoint = (ViewPoint)theEObject;
				T result = caseViewPoint(viewPoint);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case ModelelementsPackage.RATIONALE:
			{
				Rationale rationale = (Rationale)theEObject;
				T result = caseRationale(rationale);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case ModelelementsPackage.PROBLEM:
			{
				Problem problem = (Problem)theEObject;
				T result = caseProblem(problem);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}

			default:
				return defaultCase(theEObject);
			}
		}
	}

} // ModelelementsSwitch
