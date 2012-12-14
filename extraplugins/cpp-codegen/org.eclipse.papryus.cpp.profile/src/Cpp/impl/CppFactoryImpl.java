/**
 */
package Cpp.impl;

import Cpp.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import Cpp.CppArray;
import Cpp.CppConst;
import Cpp.CppConstInit;
import Cpp.CppDefault;
import Cpp.CppExternClass;
import Cpp.CppExternLibrary;
import Cpp.CppFactory;
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
import Cpp.CppVisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CppFactoryImpl extends EFactoryImpl implements CppFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CppFactory init() {
		try {
			CppFactory theCppFactory = (CppFactory)EPackage.Registry.INSTANCE.getEFactory("http://papyrus/CppProfile/1"); 
			if (theCppFactory != null) {
				return theCppFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CppFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppFactoryImpl() {
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
			case CppPackage.CPP_PTR: return createCppPtr();
			case CppPackage.CPP_INCLUDE: return createCppInclude();
			case CppPackage.MANUAL_GENERATION: return createManualGeneration();
			case CppPackage.CPP_ARRAY: return createCppArray();
			case CppPackage.CPP_CONST: return createCppConst();
			case CppPackage.CPP_DEFAULT: return createCppDefault();
			case CppPackage.CPP_REF: return createCppRef();
			case CppPackage.CPP_EXTERN_CLASS: return createCppExternClass();
			case CppPackage.CPP_EXTERN_LIBRARY: return createCppExternLibrary();
			case CppPackage.CPP_ROOT: return createCppRoot();
			case CppPackage.CPP_NO_CODE_GEN: return createCppNoCodeGen();
			case CppPackage.CPP_CONST_INIT: return createCppConstInit();
			case CppPackage.CPP_FRIEND: return createCppFriend();
			case CppPackage.CPP_INLINE: return createCppInline();
			case CppPackage.CPP_VIRTUAL: return createCppVirtual();
			case CppPackage.CPP_TYPE: return createCppType();
			case CppPackage.CPP_VISIBILITY: return createCppVisibility();
			case CppPackage.CPP_INIT: return createCppInit();
			case CppPackage.CPP_TEMPLATE: return createCppTemplate();
			case CppPackage.CPP_TEMPLATE_BINDING: return createCppTemplateBinding();
			case CppPackage.CPP_TEMPLATE_PARAMETER: return createCppTemplateParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CppPackage.CPP_VISIBILITY_KIND:
				return createCppVisibilityKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CppPackage.CPP_VISIBILITY_KIND:
				return convertCppVisibilityKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppArray createCppArray() {
		CppArrayImpl cppArray = new CppArrayImpl();
		return cppArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppConst createCppConst() {
		CppConstImpl cppConst = new CppConstImpl();
		return cppConst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppDefault createCppDefault() {
		CppDefaultImpl cppDefault = new CppDefaultImpl();
		return cppDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppPtr createCppPtr() {
		CppPtrImpl cppPtr = new CppPtrImpl();
		return cppPtr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppRef createCppRef() {
		CppRefImpl cppRef = new CppRefImpl();
		return cppRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppExternClass createCppExternClass() {
		CppExternClassImpl cppExternClass = new CppExternClassImpl();
		return cppExternClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppExternLibrary createCppExternLibrary() {
		CppExternLibraryImpl cppExternLibrary = new CppExternLibraryImpl();
		return cppExternLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppInclude createCppInclude() {
		CppIncludeImpl cppInclude = new CppIncludeImpl();
		return cppInclude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManualGeneration createManualGeneration() {
		ManualGenerationImpl manualGeneration = new ManualGenerationImpl();
		return manualGeneration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppRoot createCppRoot() {
		CppRootImpl cppRoot = new CppRootImpl();
		return cppRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppNoCodeGen createCppNoCodeGen() {
		CppNoCodeGenImpl cppNoCodeGen = new CppNoCodeGenImpl();
		return cppNoCodeGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppConstInit createCppConstInit() {
		CppConstInitImpl cppConstInit = new CppConstInitImpl();
		return cppConstInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppFriend createCppFriend() {
		CppFriendImpl cppFriend = new CppFriendImpl();
		return cppFriend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppInline createCppInline() {
		CppInlineImpl cppInline = new CppInlineImpl();
		return cppInline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppVirtual createCppVirtual() {
		CppVirtualImpl cppVirtual = new CppVirtualImpl();
		return cppVirtual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppType createCppType() {
		CppTypeImpl cppType = new CppTypeImpl();
		return cppType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppVisibility createCppVisibility() {
		CppVisibilityImpl cppVisibility = new CppVisibilityImpl();
		return cppVisibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppInit createCppInit() {
		CppInitImpl cppInit = new CppInitImpl();
		return cppInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppTemplate createCppTemplate() {
		CppTemplateImpl cppTemplate = new CppTemplateImpl();
		return cppTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppTemplateBinding createCppTemplateBinding() {
		CppTemplateBindingImpl cppTemplateBinding = new CppTemplateBindingImpl();
		return cppTemplateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppTemplateParameter createCppTemplateParameter() {
		CppTemplateParameterImpl cppTemplateParameter = new CppTemplateParameterImpl();
		return cppTemplateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppVisibilityKind createCppVisibilityKindFromString(EDataType eDataType, String initialValue) {
		CppVisibilityKind result = CppVisibilityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCppVisibilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppPackage getCppPackage() {
		return (CppPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CppPackage getPackage() {
		return CppPackage.eINSTANCE;
	}

} //CppFactoryImpl
