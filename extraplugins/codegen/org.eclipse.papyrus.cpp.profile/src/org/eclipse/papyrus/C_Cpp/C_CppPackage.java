/**
 */
package org.eclipse.papyrus.C_Cpp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.C_Cpp.C_CppFactory
 * @model kind="package"
 * @generated
 */
public interface C_CppPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "C_Cpp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/C_Cpp/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "C_Cpp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	C_CppPackage eINSTANCE = org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.PtrImpl <em>Ptr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.PtrImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getPtr()
	 * @generated
	 */
	int PTR = 0;

	/**
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTR__BASE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTR__BASE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTR__DECLARATION = 2;

	/**
	 * The number of structural features of the '<em>Ptr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.IncludeImpl <em>Include</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.IncludeImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getInclude()
	 * @generated
	 */
	int INCLUDE = 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__BODY = 0;

	/**
	 * The feature id for the '<em><b>Pre Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__PRE_BODY = 1;

	/**
	 * The feature id for the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__HEADER = 2;

	/**
	 * The feature id for the '<em><b>Base package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__BASE_PACKAGE = 3;

	/**
	 * The feature id for the '<em><b>Base class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__BASE_CLASS = 4;

	/**
	 * The feature id for the '<em><b>Base Package Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__BASE_PACKAGE_IMPORT = 5;

	/**
	 * The number of structural features of the '<em>Include</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.ManualGenerationImpl <em>Manual Generation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.ManualGenerationImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getManualGeneration()
	 * @generated
	 */
	int MANUAL_GENERATION = 2;

	/**
	 * The feature id for the '<em><b>Extension Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_GENERATION__EXTENSION_BODY = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_GENERATION__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Manual Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_GENERATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.ArrayImpl <em>Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.ArrayImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getArray()
	 * @generated
	 */
	int ARRAY = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.ConstImpl <em>Const</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.ConstImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getConst()
	 * @generated
	 */
	int CONST = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.DefaultImpl <em>Default</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.DefaultImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getDefault()
	 * @generated
	 */
	int DEFAULT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.RefImpl <em>Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.RefImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getRef()
	 * @generated
	 */
	int REF = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl <em>Extern Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getExternLibrary()
	 * @generated
	 */
	int EXTERN_LIBRARY = 3;

	/**
	 * The feature id for the '<em><b>Include Paths</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_LIBRARY__INCLUDE_PATHS = 0;

	/**
	 * The feature id for the '<em><b>Base package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_LIBRARY__BASE_PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Lib Paths</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_LIBRARY__LIB_PATHS = 2;

	/**
	 * The feature id for the '<em><b>Macros</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_LIBRARY__MACROS = 3;

	/**
	 * The feature id for the '<em><b>Libs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_LIBRARY__LIBS = 4;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_LIBRARY__INCLUDES = 5;

	/**
	 * The number of structural features of the '<em>Extern Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_LIBRARY_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.CppRootImpl <em>Cpp Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.CppRootImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getCppRoot()
	 * @generated
	 */
	int CPP_ROOT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.NoCodeGenImpl <em>No Code Gen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.NoCodeGenImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getNoCodeGen()
	 * @generated
	 */
	int NO_CODE_GEN = 4;

	/**
	 * The feature id for the '<em><b>Base element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_CODE_GEN__BASE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>No Code Gen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_CODE_GEN_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_ROOT__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Cpp Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_ROOT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY__BASE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY__DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY__BASE_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Base association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY__BASE_ASSOCIATION = 3;

	/**
	 * The number of structural features of the '<em>Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST__BASE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST__BASE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST__BASE_OPERATION = 2;

	/**
	 * The number of structural features of the '<em>Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__BASE_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__BASE_PROPERTY = 2;

	/**
	 * The number of structural features of the '<em>Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF__BASE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF__BASE_PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.ExternalImpl <em>External</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.ExternalImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getExternal()
	 * @generated
	 */
	int EXTERNAL = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL__BASE_CLASSIFIER = 1;

	/**
	 * The number of structural features of the '<em>External</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.ConstInitImpl <em>Const Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.ConstInitImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getConstInit()
	 * @generated
	 */
	int CONST_INIT = 11;

	/**
	 * The feature id for the '<em><b>Initialisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_INIT__INITIALISATION = 0;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_INIT__BASE_OPERATION = 1;

	/**
	 * The number of structural features of the '<em>Const Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_INIT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.FriendImpl <em>Friend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.FriendImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getFriend()
	 * @generated
	 */
	int FRIEND = 12;

	/**
	 * The feature id for the '<em><b>Base dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRIEND__BASE_DEPENDENCY = 0;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRIEND__BASE_OPERATION = 1;

	/**
	 * The number of structural features of the '<em>Friend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRIEND_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.InlineImpl <em>Inline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.InlineImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getInline()
	 * @generated
	 */
	int INLINE = 13;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE__BASE_OPERATION = 0;

	/**
	 * The number of structural features of the '<em>Inline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.VirtualImpl <em>Virtual</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.VirtualImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getVirtual()
	 * @generated
	 */
	int VIRTUAL = 14;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL__BASE_OPERATION = 0;

	/**
	 * The number of structural features of the '<em>Virtual</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.TypedefImpl <em>Typedef</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.TypedefImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getTypedef()
	 * @generated
	 */
	int TYPEDEF = 15;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Base primitivetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__BASE_PRIMITIVETYPE = 1;

	/**
	 * The number of structural features of the '<em>Typedef</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.VisibilityImpl <em>Visibility</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.VisibilityImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Base generalization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY__BASE_GENERALIZATION = 1;

	/**
	 * The number of structural features of the '<em>Visibility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.CppInitImpl <em>Cpp Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.CppInitImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getCppInit()
	 * @generated
	 */
	int CPP_INIT = 17;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INIT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Base enumerationliteral</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INIT__BASE_ENUMERATIONLITERAL = 1;

	/**
	 * The number of structural features of the '<em>Cpp Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INIT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.TemplateImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 18;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Base class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.TemplateBindingImpl <em>Template Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.TemplateBindingImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getTemplateBinding()
	 * @generated
	 */
	int TEMPLATE_BINDING = 19;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__BINDING = 0;

	/**
	 * The feature id for the '<em><b>Base templatebinding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__BASE_TEMPLATEBINDING = 1;

	/**
	 * The number of structural features of the '<em>Template Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.TemplateParameterImpl <em>Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.TemplateParameterImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getTemplateParameter()
	 * @generated
	 */
	int TEMPLATE_PARAMETER = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Base templateparameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER = 1;

	/**
	 * The number of structural features of the '<em>Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.UnionImpl <em>Union</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.UnionImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getUnion()
	 * @generated
	 */
	int UNION = 21;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__BASE_DATA_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.impl.StorageClassImpl <em>Storage Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.impl.StorageClassImpl
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getStorageClass()
	 * @generated
	 */
	int STORAGE_CLASS = 22;

	/**
	 * The feature id for the '<em><b>Storage Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_CLASS__STORAGE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_CLASS__BASE_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_CLASS__BASE_PROPERTY = 2;

	/**
	 * The number of structural features of the '<em>Storage Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_CLASS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.VisibilityKind <em>Visibility Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.VisibilityKind
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getVisibilityKind()
	 * @generated
	 */
	int VISIBILITY_KIND = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.EAccessKind <em>EAccess Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.EAccessKind
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getEAccessKind()
	 * @generated
	 */
	int EACCESS_KIND = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.C_Cpp.EStorageClass <em>EStorage Class</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.C_Cpp.EStorageClass
	 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getEStorageClass()
	 * @generated
	 */
	int ESTORAGE_CLASS = 25;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Ptr <em>Ptr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ptr</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Ptr
	 * @generated
	 */
	EClass getPtr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Ptr#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Ptr#getBase_parameter()
	 * @see #getPtr()
	 * @generated
	 */
	EReference getPtr_Base_parameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Ptr#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Ptr#getBase_property()
	 * @see #getPtr()
	 * @generated
	 */
	EReference getPtr_Base_property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.Ptr#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declaration</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Ptr#getDeclaration()
	 * @see #getPtr()
	 * @generated
	 */
	EAttribute getPtr_Declaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Include <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Include</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Include
	 * @generated
	 */
	EClass getInclude();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.Include#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Include#getBody()
	 * @see #getInclude()
	 * @generated
	 */
	EAttribute getInclude_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.Include#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Include#getHeader()
	 * @see #getInclude()
	 * @generated
	 */
	EAttribute getInclude_Header();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Include#getBase_package <em>Base package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base package</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Include#getBase_package()
	 * @see #getInclude()
	 * @generated
	 */
	EReference getInclude_Base_package();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Include#getBase_class <em>Base class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base class</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Include#getBase_class()
	 * @see #getInclude()
	 * @generated
	 */
	EReference getInclude_Base_class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Include#getBase_PackageImport <em>Base Package Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package Import</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Include#getBase_PackageImport()
	 * @see #getInclude()
	 * @generated
	 */
	EReference getInclude_Base_PackageImport();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.Include#getPreBody <em>Pre Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pre Body</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Include#getPreBody()
	 * @see #getInclude()
	 * @generated
	 */
	EAttribute getInclude_PreBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.ManualGeneration <em>Manual Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manual Generation</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ManualGeneration
	 * @generated
	 */
	EClass getManualGeneration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.ManualGeneration#getExtensionBody <em>Extension Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension Body</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ManualGeneration#getExtensionBody()
	 * @see #getManualGeneration()
	 * @generated
	 */
	EAttribute getManualGeneration_ExtensionBody();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.ManualGeneration#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ManualGeneration#getBase_Class()
	 * @see #getManualGeneration()
	 * @generated
	 */
	EReference getManualGeneration_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Array <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Array
	 * @generated
	 */
	EClass getArray();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Array#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Array#getBase_parameter()
	 * @see #getArray()
	 * @generated
	 */
	EReference getArray_Base_parameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.Array#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Array#getDefinition()
	 * @see #getArray()
	 * @generated
	 */
	EAttribute getArray_Definition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Array#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Array#getBase_property()
	 * @see #getArray()
	 * @generated
	 */
	EReference getArray_Base_property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Array#getBase_association <em>Base association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base association</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Array#getBase_association()
	 * @see #getArray()
	 * @generated
	 */
	EReference getArray_Base_association();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Const <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Const
	 * @generated
	 */
	EClass getConst();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Const#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Const#getBase_parameter()
	 * @see #getConst()
	 * @generated
	 */
	EReference getConst_Base_parameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Const#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Const#getBase_property()
	 * @see #getConst()
	 * @generated
	 */
	EReference getConst_Base_property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Const#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Const#getBase_operation()
	 * @see #getConst()
	 * @generated
	 */
	EReference getConst_Base_operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Default <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Default
	 * @generated
	 */
	EClass getDefault();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.Default#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Default#getValue()
	 * @see #getDefault()
	 * @generated
	 */
	EAttribute getDefault_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Default#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Default#getBase_parameter()
	 * @see #getDefault()
	 * @generated
	 */
	EReference getDefault_Base_parameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Default#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Default#getBase_property()
	 * @see #getDefault()
	 * @generated
	 */
	EReference getDefault_Base_property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Ref <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ref</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Ref
	 * @generated
	 */
	EClass getRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Ref#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Ref#getBase_parameter()
	 * @see #getRef()
	 * @generated
	 */
	EReference getRef_Base_parameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Ref#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Ref#getBase_property()
	 * @see #getRef()
	 * @generated
	 */
	EReference getRef_Base_property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.External <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.External
	 * @generated
	 */
	EClass getExternal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.External#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.External#getName()
	 * @see #getExternal()
	 * @generated
	 */
	EAttribute getExternal_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.External#getBase_Classifier <em>Base Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Classifier</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.External#getBase_Classifier()
	 * @see #getExternal()
	 * @generated
	 */
	EReference getExternal_Base_Classifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.ExternLibrary <em>Extern Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extern Library</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ExternLibrary
	 * @generated
	 */
	EClass getExternLibrary();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getIncludePaths <em>Include Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Include Paths</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ExternLibrary#getIncludePaths()
	 * @see #getExternLibrary()
	 * @generated
	 */
	EAttribute getExternLibrary_IncludePaths();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getBase_package <em>Base package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base package</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ExternLibrary#getBase_package()
	 * @see #getExternLibrary()
	 * @generated
	 */
	EReference getExternLibrary_Base_package();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getLibPaths <em>Lib Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Lib Paths</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ExternLibrary#getLibPaths()
	 * @see #getExternLibrary()
	 * @generated
	 */
	EAttribute getExternLibrary_LibPaths();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getMacros <em>Macros</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Macros</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ExternLibrary#getMacros()
	 * @see #getExternLibrary()
	 * @generated
	 */
	EAttribute getExternLibrary_Macros();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getLibs <em>Libs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Libs</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ExternLibrary#getLibs()
	 * @see #getExternLibrary()
	 * @generated
	 */
	EAttribute getExternLibrary_Libs();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getIncludes <em>Includes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Includes</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ExternLibrary#getIncludes()
	 * @see #getExternLibrary()
	 * @generated
	 */
	EAttribute getExternLibrary_Includes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.CppRoot <em>Cpp Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cpp Root</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.CppRoot
	 * @generated
	 */
	EClass getCppRoot();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.CppRoot#getBase_package <em>Base package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base package</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.CppRoot#getBase_package()
	 * @see #getCppRoot()
	 * @generated
	 */
	EReference getCppRoot_Base_package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.NoCodeGen <em>No Code Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No Code Gen</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.NoCodeGen
	 * @generated
	 */
	EClass getNoCodeGen();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.NoCodeGen#getBase_element <em>Base element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base element</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.NoCodeGen#getBase_element()
	 * @see #getNoCodeGen()
	 * @generated
	 */
	EReference getNoCodeGen_Base_element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.ConstInit <em>Const Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const Init</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ConstInit
	 * @generated
	 */
	EClass getConstInit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.ConstInit#getInitialisation <em>Initialisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialisation</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ConstInit#getInitialisation()
	 * @see #getConstInit()
	 * @generated
	 */
	EAttribute getConstInit_Initialisation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.ConstInit#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.ConstInit#getBase_operation()
	 * @see #getConstInit()
	 * @generated
	 */
	EReference getConstInit_Base_operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Friend <em>Friend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Friend</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Friend
	 * @generated
	 */
	EClass getFriend();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Friend#getBase_dependency <em>Base dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base dependency</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Friend#getBase_dependency()
	 * @see #getFriend()
	 * @generated
	 */
	EReference getFriend_Base_dependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Friend#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Friend#getBase_operation()
	 * @see #getFriend()
	 * @generated
	 */
	EReference getFriend_Base_operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Inline <em>Inline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inline</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Inline
	 * @generated
	 */
	EClass getInline();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Inline#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Inline#getBase_operation()
	 * @see #getInline()
	 * @generated
	 */
	EReference getInline_Base_operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Virtual <em>Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Virtual
	 * @generated
	 */
	EClass getVirtual();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Virtual#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Virtual#getBase_operation()
	 * @see #getVirtual()
	 * @generated
	 */
	EReference getVirtual_Base_operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Typedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typedef</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Typedef
	 * @generated
	 */
	EClass getTypedef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.Typedef#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Typedef#getDefinition()
	 * @see #getTypedef()
	 * @generated
	 */
	EAttribute getTypedef_Definition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Typedef#getBase_primitivetype <em>Base primitivetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base primitivetype</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Typedef#getBase_primitivetype()
	 * @see #getTypedef()
	 * @generated
	 */
	EReference getTypedef_Base_primitivetype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visibility</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Visibility
	 * @generated
	 */
	EClass getVisibility();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.Visibility#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Visibility#getValue()
	 * @see #getVisibility()
	 * @generated
	 */
	EAttribute getVisibility_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Visibility#getBase_generalization <em>Base generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base generalization</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Visibility#getBase_generalization()
	 * @see #getVisibility()
	 * @generated
	 */
	EReference getVisibility_Base_generalization();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.CppInit <em>Cpp Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cpp Init</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.CppInit
	 * @generated
	 */
	EClass getCppInit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.CppInit#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.CppInit#getValue()
	 * @see #getCppInit()
	 * @generated
	 */
	EAttribute getCppInit_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.CppInit#getBase_enumerationliteral <em>Base enumerationliteral</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base enumerationliteral</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.CppInit#getBase_enumerationliteral()
	 * @see #getCppInit()
	 * @generated
	 */
	EReference getCppInit_Base_enumerationliteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.Template#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declaration</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Template#getDeclaration()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_Declaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Template#getBase_class <em>Base class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base class</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Template#getBase_class()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Base_class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.TemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Binding</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.TemplateBinding
	 * @generated
	 */
	EClass getTemplateBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.TemplateBinding#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binding</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.TemplateBinding#getBinding()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EAttribute getTemplateBinding_Binding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.TemplateBinding#getBase_templatebinding <em>Base templatebinding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base templatebinding</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.TemplateBinding#getBase_templatebinding()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_Base_templatebinding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.TemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.TemplateParameter
	 * @generated
	 */
	EClass getTemplateParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.TemplateParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.TemplateParameter#getName()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EAttribute getTemplateParameter_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.TemplateParameter#getBase_templateparameter <em>Base templateparameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base templateparameter</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.TemplateParameter#getBase_templateparameter()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_Base_templateparameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.Union <em>Union</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Union
	 * @generated
	 */
	EClass getUnion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.Union#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.Union#getBase_DataType()
	 * @see #getUnion()
	 * @generated
	 */
	EReference getUnion_Base_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.C_Cpp.StorageClass <em>Storage Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage Class</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.StorageClass
	 * @generated
	 */
	EClass getStorageClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.C_Cpp.StorageClass#getStorageClass <em>Storage Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Storage Class</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.StorageClass#getStorageClass()
	 * @see #getStorageClass()
	 * @generated
	 */
	EAttribute getStorageClass_StorageClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.StorageClass#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.StorageClass#getBase_Parameter()
	 * @see #getStorageClass()
	 * @generated
	 */
	EReference getStorageClass_Base_Parameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.C_Cpp.StorageClass#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.StorageClass#getBase_Property()
	 * @see #getStorageClass()
	 * @generated
	 */
	EReference getStorageClass_Base_Property();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.C_Cpp.VisibilityKind <em>Visibility Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility Kind</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.VisibilityKind
	 * @generated
	 */
	EEnum getVisibilityKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.C_Cpp.EAccessKind <em>EAccess Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EAccess Kind</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.EAccessKind
	 * @generated
	 */
	EEnum getEAccessKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.C_Cpp.EStorageClass <em>EStorage Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EStorage Class</em>'.
	 * @see org.eclipse.papyrus.C_Cpp.EStorageClass
	 * @generated
	 */
	EEnum getEStorageClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	C_CppFactory getC_CppFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.PtrImpl <em>Ptr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.PtrImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getPtr()
		 * @generated
		 */
		EClass PTR = eINSTANCE.getPtr();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PTR__BASE_PARAMETER = eINSTANCE.getPtr_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PTR__BASE_PROPERTY = eINSTANCE.getPtr_Base_property();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PTR__DECLARATION = eINSTANCE.getPtr_Declaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.IncludeImpl <em>Include</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.IncludeImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getInclude()
		 * @generated
		 */
		EClass INCLUDE = eINSTANCE.getInclude();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUDE__BODY = eINSTANCE.getInclude_Body();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUDE__HEADER = eINSTANCE.getInclude_Header();

		/**
		 * The meta object literal for the '<em><b>Base package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE__BASE_PACKAGE = eINSTANCE.getInclude_Base_package();

		/**
		 * The meta object literal for the '<em><b>Base class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE__BASE_CLASS = eINSTANCE.getInclude_Base_class();

		/**
		 * The meta object literal for the '<em><b>Base Package Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE__BASE_PACKAGE_IMPORT = eINSTANCE.getInclude_Base_PackageImport();

		/**
		 * The meta object literal for the '<em><b>Pre Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUDE__PRE_BODY = eINSTANCE.getInclude_PreBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.ManualGenerationImpl <em>Manual Generation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.ManualGenerationImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getManualGeneration()
		 * @generated
		 */
		EClass MANUAL_GENERATION = eINSTANCE.getManualGeneration();

		/**
		 * The meta object literal for the '<em><b>Extension Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANUAL_GENERATION__EXTENSION_BODY = eINSTANCE.getManualGeneration_ExtensionBody();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANUAL_GENERATION__BASE_CLASS = eINSTANCE.getManualGeneration_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.ArrayImpl <em>Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.ArrayImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getArray()
		 * @generated
		 */
		EClass ARRAY = eINSTANCE.getArray();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY__BASE_PARAMETER = eINSTANCE.getArray_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY__DEFINITION = eINSTANCE.getArray_Definition();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY__BASE_PROPERTY = eINSTANCE.getArray_Base_property();

		/**
		 * The meta object literal for the '<em><b>Base association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY__BASE_ASSOCIATION = eINSTANCE.getArray_Base_association();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.ConstImpl <em>Const</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.ConstImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getConst()
		 * @generated
		 */
		EClass CONST = eINSTANCE.getConst();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONST__BASE_PARAMETER = eINSTANCE.getConst_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONST__BASE_PROPERTY = eINSTANCE.getConst_Base_property();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONST__BASE_OPERATION = eINSTANCE.getConst_Base_operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.DefaultImpl <em>Default</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.DefaultImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getDefault()
		 * @generated
		 */
		EClass DEFAULT = eINSTANCE.getDefault();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT__VALUE = eINSTANCE.getDefault_Value();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT__BASE_PARAMETER = eINSTANCE.getDefault_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT__BASE_PROPERTY = eINSTANCE.getDefault_Base_property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.RefImpl <em>Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.RefImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getRef()
		 * @generated
		 */
		EClass REF = eINSTANCE.getRef();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REF__BASE_PARAMETER = eINSTANCE.getRef_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REF__BASE_PROPERTY = eINSTANCE.getRef_Base_property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.ExternalImpl <em>External</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.ExternalImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getExternal()
		 * @generated
		 */
		EClass EXTERNAL = eINSTANCE.getExternal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL__NAME = eINSTANCE.getExternal_Name();

		/**
		 * The meta object literal for the '<em><b>Base Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL__BASE_CLASSIFIER = eINSTANCE.getExternal_Base_Classifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl <em>Extern Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getExternLibrary()
		 * @generated
		 */
		EClass EXTERN_LIBRARY = eINSTANCE.getExternLibrary();

		/**
		 * The meta object literal for the '<em><b>Include Paths</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERN_LIBRARY__INCLUDE_PATHS = eINSTANCE.getExternLibrary_IncludePaths();

		/**
		 * The meta object literal for the '<em><b>Base package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERN_LIBRARY__BASE_PACKAGE = eINSTANCE.getExternLibrary_Base_package();

		/**
		 * The meta object literal for the '<em><b>Lib Paths</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERN_LIBRARY__LIB_PATHS = eINSTANCE.getExternLibrary_LibPaths();

		/**
		 * The meta object literal for the '<em><b>Macros</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERN_LIBRARY__MACROS = eINSTANCE.getExternLibrary_Macros();

		/**
		 * The meta object literal for the '<em><b>Libs</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERN_LIBRARY__LIBS = eINSTANCE.getExternLibrary_Libs();

		/**
		 * The meta object literal for the '<em><b>Includes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERN_LIBRARY__INCLUDES = eINSTANCE.getExternLibrary_Includes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.CppRootImpl <em>Cpp Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.CppRootImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getCppRoot()
		 * @generated
		 */
		EClass CPP_ROOT = eINSTANCE.getCppRoot();

		/**
		 * The meta object literal for the '<em><b>Base package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_ROOT__BASE_PACKAGE = eINSTANCE.getCppRoot_Base_package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.NoCodeGenImpl <em>No Code Gen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.NoCodeGenImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getNoCodeGen()
		 * @generated
		 */
		EClass NO_CODE_GEN = eINSTANCE.getNoCodeGen();

		/**
		 * The meta object literal for the '<em><b>Base element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NO_CODE_GEN__BASE_ELEMENT = eINSTANCE.getNoCodeGen_Base_element();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.ConstInitImpl <em>Const Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.ConstInitImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getConstInit()
		 * @generated
		 */
		EClass CONST_INIT = eINSTANCE.getConstInit();

		/**
		 * The meta object literal for the '<em><b>Initialisation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONST_INIT__INITIALISATION = eINSTANCE.getConstInit_Initialisation();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONST_INIT__BASE_OPERATION = eINSTANCE.getConstInit_Base_operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.FriendImpl <em>Friend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.FriendImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getFriend()
		 * @generated
		 */
		EClass FRIEND = eINSTANCE.getFriend();

		/**
		 * The meta object literal for the '<em><b>Base dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRIEND__BASE_DEPENDENCY = eINSTANCE.getFriend_Base_dependency();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRIEND__BASE_OPERATION = eINSTANCE.getFriend_Base_operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.InlineImpl <em>Inline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.InlineImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getInline()
		 * @generated
		 */
		EClass INLINE = eINSTANCE.getInline();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INLINE__BASE_OPERATION = eINSTANCE.getInline_Base_operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.VirtualImpl <em>Virtual</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.VirtualImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getVirtual()
		 * @generated
		 */
		EClass VIRTUAL = eINSTANCE.getVirtual();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL__BASE_OPERATION = eINSTANCE.getVirtual_Base_operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.TypedefImpl <em>Typedef</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.TypedefImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getTypedef()
		 * @generated
		 */
		EClass TYPEDEF = eINSTANCE.getTypedef();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPEDEF__DEFINITION = eINSTANCE.getTypedef_Definition();

		/**
		 * The meta object literal for the '<em><b>Base primitivetype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPEDEF__BASE_PRIMITIVETYPE = eINSTANCE.getTypedef_Base_primitivetype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.VisibilityImpl <em>Visibility</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.VisibilityImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getVisibility()
		 * @generated
		 */
		EClass VISIBILITY = eINSTANCE.getVisibility();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIBILITY__VALUE = eINSTANCE.getVisibility_Value();

		/**
		 * The meta object literal for the '<em><b>Base generalization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISIBILITY__BASE_GENERALIZATION = eINSTANCE.getVisibility_Base_generalization();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.CppInitImpl <em>Cpp Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.CppInitImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getCppInit()
		 * @generated
		 */
		EClass CPP_INIT = eINSTANCE.getCppInit();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_INIT__VALUE = eINSTANCE.getCppInit_Value();

		/**
		 * The meta object literal for the '<em><b>Base enumerationliteral</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_INIT__BASE_ENUMERATIONLITERAL = eINSTANCE.getCppInit_Base_enumerationliteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.TemplateImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE__DECLARATION = eINSTANCE.getTemplate_Declaration();

		/**
		 * The meta object literal for the '<em><b>Base class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__BASE_CLASS = eINSTANCE.getTemplate_Base_class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.TemplateBindingImpl <em>Template Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.TemplateBindingImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getTemplateBinding()
		 * @generated
		 */
		EClass TEMPLATE_BINDING = eINSTANCE.getTemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_BINDING__BINDING = eINSTANCE.getTemplateBinding_Binding();

		/**
		 * The meta object literal for the '<em><b>Base templatebinding</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__BASE_TEMPLATEBINDING = eINSTANCE.getTemplateBinding_Base_templatebinding();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.TemplateParameterImpl <em>Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.TemplateParameterImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getTemplateParameter()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER = eINSTANCE.getTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_PARAMETER__NAME = eINSTANCE.getTemplateParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Base templateparameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER = eINSTANCE.getTemplateParameter_Base_templateparameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.UnionImpl <em>Union</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.UnionImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getUnion()
		 * @generated
		 */
		EClass UNION = eINSTANCE.getUnion();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNION__BASE_DATA_TYPE = eINSTANCE.getUnion_Base_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.impl.StorageClassImpl <em>Storage Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.impl.StorageClassImpl
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getStorageClass()
		 * @generated
		 */
		EClass STORAGE_CLASS = eINSTANCE.getStorageClass();

		/**
		 * The meta object literal for the '<em><b>Storage Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORAGE_CLASS__STORAGE_CLASS = eINSTANCE.getStorageClass_StorageClass();

		/**
		 * The meta object literal for the '<em><b>Base Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE_CLASS__BASE_PARAMETER = eINSTANCE.getStorageClass_Base_Parameter();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE_CLASS__BASE_PROPERTY = eINSTANCE.getStorageClass_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.VisibilityKind <em>Visibility Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.VisibilityKind
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getVisibilityKind()
		 * @generated
		 */
		EEnum VISIBILITY_KIND = eINSTANCE.getVisibilityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.EAccessKind <em>EAccess Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.EAccessKind
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getEAccessKind()
		 * @generated
		 */
		EEnum EACCESS_KIND = eINSTANCE.getEAccessKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.C_Cpp.EStorageClass <em>EStorage Class</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.C_Cpp.EStorageClass
		 * @see org.eclipse.papyrus.C_Cpp.impl.C_CppPackageImpl#getEStorageClass()
		 * @generated
		 */
		EEnum ESTORAGE_CLASS = eINSTANCE.getEStorageClass();

	}

} //C_CppPackage
