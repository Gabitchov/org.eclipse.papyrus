/**
 */
package Cpp.util;

import Cpp.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import Cpp.CppArray;
import Cpp.CppConst;
import Cpp.CppConstInit;
import Cpp.CppDefault;
import Cpp.CppExternClass;
import Cpp.CppExternLibrary;
import Cpp.CppFriend;
import Cpp.CppInclude;
import Cpp.CppInit;
import Cpp.CppInline;
import Cpp.CppNoCodeGen;
import Cpp.CppPackage;
import Cpp.CppPtr;
import Cpp.CppRef;
import Cpp.CppRoot;
import Cpp.CppTemplate;
import Cpp.CppTemplateBinding;
import Cpp.CppTemplateParameter;
import Cpp.CppType;
import Cpp.CppVirtual;
import Cpp.CppVisibility;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see Cpp.CppPackage
 * @generated
 */
public class CppSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CppPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppSwitch() {
		if (modelPackage == null) {
			modelPackage = CppPackage.eINSTANCE;
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
			case CppPackage.CPP_PTR: {
				CppPtr cppPtr = (CppPtr)theEObject;
				T result = caseCppPtr(cppPtr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_INCLUDE: {
				CppInclude cppInclude = (CppInclude)theEObject;
				T result = caseCppInclude(cppInclude);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.MANUAL_GENERATION: {
				ManualGeneration manualGeneration = (ManualGeneration)theEObject;
				T result = caseManualGeneration(manualGeneration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_ARRAY: {
				CppArray cppArray = (CppArray)theEObject;
				T result = caseCppArray(cppArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_CONST: {
				CppConst cppConst = (CppConst)theEObject;
				T result = caseCppConst(cppConst);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_DEFAULT: {
				CppDefault cppDefault = (CppDefault)theEObject;
				T result = caseCppDefault(cppDefault);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_REF: {
				CppRef cppRef = (CppRef)theEObject;
				T result = caseCppRef(cppRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_EXTERN_CLASS: {
				CppExternClass cppExternClass = (CppExternClass)theEObject;
				T result = caseCppExternClass(cppExternClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_EXTERN_LIBRARY: {
				CppExternLibrary cppExternLibrary = (CppExternLibrary)theEObject;
				T result = caseCppExternLibrary(cppExternLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_ROOT: {
				CppRoot cppRoot = (CppRoot)theEObject;
				T result = caseCppRoot(cppRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_NO_CODE_GEN: {
				CppNoCodeGen cppNoCodeGen = (CppNoCodeGen)theEObject;
				T result = caseCppNoCodeGen(cppNoCodeGen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_CONST_INIT: {
				CppConstInit cppConstInit = (CppConstInit)theEObject;
				T result = caseCppConstInit(cppConstInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_FRIEND: {
				CppFriend cppFriend = (CppFriend)theEObject;
				T result = caseCppFriend(cppFriend);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_INLINE: {
				CppInline cppInline = (CppInline)theEObject;
				T result = caseCppInline(cppInline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_VIRTUAL: {
				CppVirtual cppVirtual = (CppVirtual)theEObject;
				T result = caseCppVirtual(cppVirtual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_TYPE: {
				CppType cppType = (CppType)theEObject;
				T result = caseCppType(cppType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_VISIBILITY: {
				CppVisibility cppVisibility = (CppVisibility)theEObject;
				T result = caseCppVisibility(cppVisibility);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_INIT: {
				CppInit cppInit = (CppInit)theEObject;
				T result = caseCppInit(cppInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_TEMPLATE: {
				CppTemplate cppTemplate = (CppTemplate)theEObject;
				T result = caseCppTemplate(cppTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_TEMPLATE_BINDING: {
				CppTemplateBinding cppTemplateBinding = (CppTemplateBinding)theEObject;
				T result = caseCppTemplateBinding(cppTemplateBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CppPackage.CPP_TEMPLATE_PARAMETER: {
				CppTemplateParameter cppTemplateParameter = (CppTemplateParameter)theEObject;
				T result = caseCppTemplateParameter(cppTemplateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppArray(CppArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppConst(CppConst object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppDefault(CppDefault object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ptr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ptr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppPtr(CppPtr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppRef(CppRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extern Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extern Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppExternClass(CppExternClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extern Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extern Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppExternLibrary(CppExternLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Include</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Include</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppInclude(CppInclude object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manual Generation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manual Generation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManualGeneration(ManualGeneration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppRoot(CppRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>No Code Gen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>No Code Gen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppNoCodeGen(CppNoCodeGen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Init</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppConstInit(CppConstInit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Friend</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Friend</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppFriend(CppFriend object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppInline(CppInline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppVirtual(CppVirtual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppType(CppType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visibility</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visibility</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppVisibility(CppVisibility object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Init</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppInit(CppInit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppTemplate(CppTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppTemplateBinding(CppTemplateBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCppTemplateParameter(CppTemplateParameter object) {
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

} //CppSwitch
