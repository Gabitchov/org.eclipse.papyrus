/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage
 * @generated
 */
public class JdtmmSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static JdtmmPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JdtmmSwitch() {
		if(modelPackage == null) {
			modelPackage = JdtmmPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
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
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case JdtmmPackage.JDT_JAVA_ELEMENT:
		{
			JDTJavaElement jdtJavaElement = (JDTJavaElement)theEObject;
			T result = caseJDTJavaElement(jdtJavaElement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_PARENT:
		{
			JDTParent jdtParent = (JDTParent)theEObject;
			T result = caseJDTParent(jdtParent);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_MEMBER:
		{
			JDTMember jdtMember = (JDTMember)theEObject;
			T result = caseJDTMember(jdtMember);
			if(result == null)
				result = caseJDTParentJavaElement(jdtMember);
			if(result == null)
				result = caseJDTJavaElement(jdtMember);
			if(result == null)
				result = caseJDTParent(jdtMember);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_PARENT_JAVA_ELEMENT:
		{
			JDTParentJavaElement jdtParentJavaElement = (JDTParentJavaElement)theEObject;
			T result = caseJDTParentJavaElement(jdtParentJavaElement);
			if(result == null)
				result = caseJDTJavaElement(jdtParentJavaElement);
			if(result == null)
				result = caseJDTParent(jdtParentJavaElement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_TYPE_PARAMETER:
		{
			JDTTypeParameter jdtTypeParameter = (JDTTypeParameter)theEObject;
			T result = caseJDTTypeParameter(jdtTypeParameter);
			if(result == null)
				result = caseJDTJavaElement(jdtTypeParameter);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_FIELD:
		{
			JDTField jdtField = (JDTField)theEObject;
			T result = caseJDTField(jdtField);
			if(result == null)
				result = caseJDTMember(jdtField);
			if(result == null)
				result = caseJDTParentJavaElement(jdtField);
			if(result == null)
				result = caseJDTJavaElement(jdtField);
			if(result == null)
				result = caseJDTParent(jdtField);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_TYPE:
		{
			JDTType jdtType = (JDTType)theEObject;
			T result = caseJDTType(jdtType);
			if(result == null)
				result = caseJDTMember(jdtType);
			if(result == null)
				result = caseJDTParentJavaElement(jdtType);
			if(result == null)
				result = caseJDTJavaElement(jdtType);
			if(result == null)
				result = caseJDTParent(jdtType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_METHOD:
		{
			JDTMethod jdtMethod = (JDTMethod)theEObject;
			T result = caseJDTMethod(jdtMethod);
			if(result == null)
				result = caseJDTMember(jdtMethod);
			if(result == null)
				result = caseJDTParentJavaElement(jdtMethod);
			if(result == null)
				result = caseJDTJavaElement(jdtMethod);
			if(result == null)
				result = caseJDTParent(jdtMethod);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_PARAMETER:
		{
			JDTParameter jdtParameter = (JDTParameter)theEObject;
			T result = caseJDTParameter(jdtParameter);
			if(result == null)
				result = caseJDTMember(jdtParameter);
			if(result == null)
				result = caseJDTParentJavaElement(jdtParameter);
			if(result == null)
				result = caseJDTJavaElement(jdtParameter);
			if(result == null)
				result = caseJDTParent(jdtParameter);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_COMPILATION_UNIT:
		{
			JDTCompilationUnit jdtCompilationUnit = (JDTCompilationUnit)theEObject;
			T result = caseJDTCompilationUnit(jdtCompilationUnit);
			if(result == null)
				result = caseJDTTypeRoot(jdtCompilationUnit);
			if(result == null)
				result = caseJDTParentJavaElement(jdtCompilationUnit);
			if(result == null)
				result = caseJDTJavaElement(jdtCompilationUnit);
			if(result == null)
				result = caseJDTParent(jdtCompilationUnit);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_TYPE_ROOT:
		{
			JDTTypeRoot jdtTypeRoot = (JDTTypeRoot)theEObject;
			T result = caseJDTTypeRoot(jdtTypeRoot);
			if(result == null)
				result = caseJDTParentJavaElement(jdtTypeRoot);
			if(result == null)
				result = caseJDTJavaElement(jdtTypeRoot);
			if(result == null)
				result = caseJDTParent(jdtTypeRoot);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_PACKAGE_FRAGMENT:
		{
			JDTPackageFragment jdtPackageFragment = (JDTPackageFragment)theEObject;
			T result = caseJDTPackageFragment(jdtPackageFragment);
			if(result == null)
				result = caseJDTParentJavaElement(jdtPackageFragment);
			if(result == null)
				result = caseJDTJavaElement(jdtPackageFragment);
			if(result == null)
				result = caseJDTParent(jdtPackageFragment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT:
		{
			JDTPackageFragmentRoot jdtPackageFragmentRoot = (JDTPackageFragmentRoot)theEObject;
			T result = caseJDTPackageFragmentRoot(jdtPackageFragmentRoot);
			if(result == null)
				result = caseJDTParentJavaElement(jdtPackageFragmentRoot);
			if(result == null)
				result = caseJDTJavaElement(jdtPackageFragmentRoot);
			if(result == null)
				result = caseJDTParent(jdtPackageFragmentRoot);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_JAVA_PROJECT:
		{
			JDTJavaProject jdtJavaProject = (JDTJavaProject)theEObject;
			T result = caseJDTJavaProject(jdtJavaProject);
			if(result == null)
				result = caseJDTParentJavaElement(jdtJavaProject);
			if(result == null)
				result = caseJDTJavaElement(jdtJavaProject);
			if(result == null)
				result = caseJDTParent(jdtJavaProject);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_JAVA_MODEL:
		{
			JDTJavaModel jdtJavaModel = (JDTJavaModel)theEObject;
			T result = caseJDTJavaModel(jdtJavaModel);
			if(result == null)
				result = caseJDTParentJavaElement(jdtJavaModel);
			if(result == null)
				result = caseJDTJavaElement(jdtJavaModel);
			if(result == null)
				result = caseJDTParent(jdtJavaModel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_CLASS:
		{
			JDTClass jdtClass = (JDTClass)theEObject;
			T result = caseJDTClass(jdtClass);
			if(result == null)
				result = caseJDTType(jdtClass);
			if(result == null)
				result = caseJDTMember(jdtClass);
			if(result == null)
				result = caseJDTParentJavaElement(jdtClass);
			if(result == null)
				result = caseJDTJavaElement(jdtClass);
			if(result == null)
				result = caseJDTParent(jdtClass);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_INTERFACE:
		{
			JDTInterface jdtInterface = (JDTInterface)theEObject;
			T result = caseJDTInterface(jdtInterface);
			if(result == null)
				result = caseJDTType(jdtInterface);
			if(result == null)
				result = caseJDTMember(jdtInterface);
			if(result == null)
				result = caseJDTParentJavaElement(jdtInterface);
			if(result == null)
				result = caseJDTJavaElement(jdtInterface);
			if(result == null)
				result = caseJDTParent(jdtInterface);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_ENUM:
		{
			JDTEnum jdtEnum = (JDTEnum)theEObject;
			T result = caseJDTEnum(jdtEnum);
			if(result == null)
				result = caseJDTType(jdtEnum);
			if(result == null)
				result = caseJDTMember(jdtEnum);
			if(result == null)
				result = caseJDTParentJavaElement(jdtEnum);
			if(result == null)
				result = caseJDTJavaElement(jdtEnum);
			if(result == null)
				result = caseJDTParent(jdtEnum);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_IMPORT_DECLARATION:
		{
			JDTImportDeclaration jdtImportDeclaration = (JDTImportDeclaration)theEObject;
			T result = caseJDTImportDeclaration(jdtImportDeclaration);
			if(result == null)
				result = caseJDTJavaElement(jdtImportDeclaration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_IMPORT_CONTAINER:
		{
			JDTImportContainer jdtImportContainer = (JDTImportContainer)theEObject;
			T result = caseJDTImportContainer(jdtImportContainer);
			if(result == null)
				result = caseJDTParentJavaElement(jdtImportContainer);
			if(result == null)
				result = caseJDTJavaElement(jdtImportContainer);
			if(result == null)
				result = caseJDTParent(jdtImportContainer);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case JdtmmPackage.JDT_EXCEPTION:
		{
			JDTException jdtException = (JDTException)theEObject;
			T result = caseJDTException(jdtException);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Java Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Java Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTJavaElement(JDTJavaElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Parent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Parent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTParent(JDTParent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTMember(JDTMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Parent Java Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Parent Java Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTParentJavaElement(JDTParentJavaElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Type Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTTypeParameter(JDTTypeParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTField(JDTField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTType(JDTType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTMethod(JDTMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTParameter(JDTParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Compilation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTCompilationUnit(JDTCompilationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Type Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Type Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTTypeRoot(JDTTypeRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Package Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Package Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTPackageFragment(JDTPackageFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Package Fragment Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Package Fragment Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTPackageFragmentRoot(JDTPackageFragmentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Java Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Java Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTJavaProject(JDTJavaProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Java Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Java Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTJavaModel(JDTJavaModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTClass(JDTClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTInterface(JDTInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTEnum(JDTEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Import Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Import Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTImportDeclaration(JDTImportDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Import Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Import Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTImportContainer(JDTImportContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JDT Exception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JDT Exception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJDTException(JDTException object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
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

} //JdtmmSwitch
