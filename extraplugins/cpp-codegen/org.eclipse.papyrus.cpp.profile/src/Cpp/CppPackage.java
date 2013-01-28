/**
 */
package Cpp;

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
 * @see Cpp.CppFactory
 * @model kind="package"
 * @generated
 */
public interface CppPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Cpp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://papyrus/CppProfile/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Cpp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CppPackage eINSTANCE = Cpp.impl.CppPackageImpl.init();

	/**
	 * The meta object id for the '{@link Cpp.impl.CppArrayImpl <em>Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppArrayImpl
	 * @see Cpp.impl.CppPackageImpl#getCppArray()
	 * @generated
	 */
	int CPP_ARRAY = 3;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppConstImpl <em>Const</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppConstImpl
	 * @see Cpp.impl.CppPackageImpl#getCppConst()
	 * @generated
	 */
	int CPP_CONST = 4;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppDefaultImpl <em>Default</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppDefaultImpl
	 * @see Cpp.impl.CppPackageImpl#getCppDefault()
	 * @generated
	 */
	int CPP_DEFAULT = 5;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppPtrImpl <em>Ptr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppPtrImpl
	 * @see Cpp.impl.CppPackageImpl#getCppPtr()
	 * @generated
	 */
	int CPP_PTR = 0;

	/**
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_PTR__BASE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_PTR__BASE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_PTR__DECLARATION = 2;

	/**
	 * The number of structural features of the '<em>Ptr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_PTR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppRefImpl <em>Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppRefImpl
	 * @see Cpp.impl.CppPackageImpl#getCppRef()
	 * @generated
	 */
	int CPP_REF = 6;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppExternClassImpl <em>Extern Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppExternClassImpl
	 * @see Cpp.impl.CppPackageImpl#getCppExternClass()
	 * @generated
	 */
	int CPP_EXTERN_CLASS = 7;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppExternLibraryImpl <em>Extern Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppExternLibraryImpl
	 * @see Cpp.impl.CppPackageImpl#getCppExternLibrary()
	 * @generated
	 */
	int CPP_EXTERN_LIBRARY = 8;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppIncludeImpl <em>Include</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppIncludeImpl
	 * @see Cpp.impl.CppPackageImpl#getCppInclude()
	 * @generated
	 */
	int CPP_INCLUDE = 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INCLUDE__BODY = 0;

	/**
	 * The feature id for the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INCLUDE__HEADER = 1;

	/**
	 * The feature id for the '<em><b>Base package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INCLUDE__BASE_PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Base class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INCLUDE__BASE_CLASS = 3;

	/**
	 * The feature id for the '<em><b>Base Package Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INCLUDE__BASE_PACKAGE_IMPORT = 4;

	/**
	 * The feature id for the '<em><b>Pre Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INCLUDE__PRE_BODY = 5;

	/**
	 * The number of structural features of the '<em>Include</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INCLUDE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link Cpp.impl.ManualGenerationImpl <em>Manual Generation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.ManualGenerationImpl
	 * @see Cpp.impl.CppPackageImpl#getManualGeneration()
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
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_ARRAY__BASE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_ARRAY__DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_ARRAY__BASE_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Base association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_ARRAY__BASE_ASSOCIATION = 3;

	/**
	 * The number of structural features of the '<em>Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_ARRAY_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_CONST__BASE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_CONST__BASE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_CONST__BASE_OPERATION = 2;

	/**
	 * The number of structural features of the '<em>Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_CONST_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_DEFAULT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_DEFAULT__BASE_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_DEFAULT__BASE_PROPERTY = 2;

	/**
	 * The number of structural features of the '<em>Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_DEFAULT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_REF__BASE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_REF__BASE_PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_REF_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_EXTERN_CLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Base class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_EXTERN_CLASS__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Extern Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_EXTERN_CLASS_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_EXTERN_LIBRARY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Base package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_EXTERN_LIBRARY__BASE_PACKAGE = 1;

	/**
	 * The number of structural features of the '<em>Extern Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_EXTERN_LIBRARY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppRootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppRootImpl
	 * @see Cpp.impl.CppPackageImpl#getCppRoot()
	 * @generated
	 */
	int CPP_ROOT = 9;

	/**
	 * The feature id for the '<em><b>Base package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_ROOT__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_ROOT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppNoCodeGenImpl <em>No Code Gen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppNoCodeGenImpl
	 * @see Cpp.impl.CppPackageImpl#getCppNoCodeGen()
	 * @generated
	 */
	int CPP_NO_CODE_GEN = 10;

	/**
	 * The feature id for the '<em><b>Base element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_NO_CODE_GEN__BASE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>No Code Gen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_NO_CODE_GEN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppConstInitImpl <em>Const Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppConstInitImpl
	 * @see Cpp.impl.CppPackageImpl#getCppConstInit()
	 * @generated
	 */
	int CPP_CONST_INIT = 11;

	/**
	 * The feature id for the '<em><b>Initialisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_CONST_INIT__INITIALISATION = 0;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_CONST_INIT__BASE_OPERATION = 1;

	/**
	 * The number of structural features of the '<em>Const Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_CONST_INIT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppFriendImpl <em>Friend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppFriendImpl
	 * @see Cpp.impl.CppPackageImpl#getCppFriend()
	 * @generated
	 */
	int CPP_FRIEND = 12;

	/**
	 * The feature id for the '<em><b>Base dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_FRIEND__BASE_DEPENDENCY = 0;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_FRIEND__BASE_OPERATION = 1;

	/**
	 * The number of structural features of the '<em>Friend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_FRIEND_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppInlineImpl <em>Inline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppInlineImpl
	 * @see Cpp.impl.CppPackageImpl#getCppInline()
	 * @generated
	 */
	int CPP_INLINE = 13;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INLINE__BASE_OPERATION = 0;

	/**
	 * The number of structural features of the '<em>Inline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INLINE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppVirtualImpl <em>Virtual</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppVirtualImpl
	 * @see Cpp.impl.CppPackageImpl#getCppVirtual()
	 * @generated
	 */
	int CPP_VIRTUAL = 14;

	/**
	 * The feature id for the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_VIRTUAL__BASE_OPERATION = 0;

	/**
	 * The number of structural features of the '<em>Virtual</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_VIRTUAL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppTypeImpl
	 * @see Cpp.impl.CppPackageImpl#getCppType()
	 * @generated
	 */
	int CPP_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TYPE__DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Base primitivetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TYPE__BASE_PRIMITIVETYPE = 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppVisibilityImpl <em>Visibility</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppVisibilityImpl
	 * @see Cpp.impl.CppPackageImpl#getCppVisibility()
	 * @generated
	 */
	int CPP_VISIBILITY = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_VISIBILITY__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Base generalization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_VISIBILITY__BASE_GENERALIZATION = 1;

	/**
	 * The number of structural features of the '<em>Visibility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_VISIBILITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppInitImpl <em>Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppInitImpl
	 * @see Cpp.impl.CppPackageImpl#getCppInit()
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
	 * The number of structural features of the '<em>Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_INIT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppTemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppTemplateImpl
	 * @see Cpp.impl.CppPackageImpl#getCppTemplate()
	 * @generated
	 */
	int CPP_TEMPLATE = 18;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TEMPLATE__DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Base class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TEMPLATE__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TEMPLATE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppTemplateBindingImpl <em>Template Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppTemplateBindingImpl
	 * @see Cpp.impl.CppPackageImpl#getCppTemplateBinding()
	 * @generated
	 */
	int CPP_TEMPLATE_BINDING = 19;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TEMPLATE_BINDING__BINDING = 0;

	/**
	 * The feature id for the '<em><b>Base templatebinding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TEMPLATE_BINDING__BASE_TEMPLATEBINDING = 1;

	/**
	 * The number of structural features of the '<em>Template Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TEMPLATE_BINDING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Cpp.impl.CppTemplateParameterImpl <em>Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.CppTemplateParameterImpl
	 * @see Cpp.impl.CppPackageImpl#getCppTemplateParameter()
	 * @generated
	 */
	int CPP_TEMPLATE_PARAMETER = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TEMPLATE_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Base templateparameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER = 1;

	/**
	 * The number of structural features of the '<em>Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_TEMPLATE_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Cpp.impl.UnionImpl <em>Union</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.impl.UnionImpl
	 * @see Cpp.impl.CppPackageImpl#getUnion()
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
	 * The meta object id for the '{@link Cpp.CppVisibilityKind <em>Visibility Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Cpp.CppVisibilityKind
	 * @see Cpp.impl.CppPackageImpl#getCppVisibilityKind()
	 * @generated
	 */
	int CPP_VISIBILITY_KIND = 22;


	/**
	 * Returns the meta object for class '{@link Cpp.CppArray <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array</em>'.
	 * @see Cpp.CppArray
	 * @generated
	 */
	EClass getCppArray();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppArray#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see Cpp.CppArray#getBase_parameter()
	 * @see #getCppArray()
	 * @generated
	 */
	EReference getCppArray_Base_parameter();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppArray#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition</em>'.
	 * @see Cpp.CppArray#getDefinition()
	 * @see #getCppArray()
	 * @generated
	 */
	EAttribute getCppArray_Definition();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppArray#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see Cpp.CppArray#getBase_property()
	 * @see #getCppArray()
	 * @generated
	 */
	EReference getCppArray_Base_property();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppArray#getBase_association <em>Base association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base association</em>'.
	 * @see Cpp.CppArray#getBase_association()
	 * @see #getCppArray()
	 * @generated
	 */
	EReference getCppArray_Base_association();

	/**
	 * Returns the meta object for class '{@link Cpp.CppConst <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const</em>'.
	 * @see Cpp.CppConst
	 * @generated
	 */
	EClass getCppConst();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppConst#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see Cpp.CppConst#getBase_parameter()
	 * @see #getCppConst()
	 * @generated
	 */
	EReference getCppConst_Base_parameter();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppConst#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see Cpp.CppConst#getBase_property()
	 * @see #getCppConst()
	 * @generated
	 */
	EReference getCppConst_Base_property();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppConst#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see Cpp.CppConst#getBase_operation()
	 * @see #getCppConst()
	 * @generated
	 */
	EReference getCppConst_Base_operation();

	/**
	 * Returns the meta object for class '{@link Cpp.CppDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default</em>'.
	 * @see Cpp.CppDefault
	 * @generated
	 */
	EClass getCppDefault();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppDefault#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see Cpp.CppDefault#getValue()
	 * @see #getCppDefault()
	 * @generated
	 */
	EAttribute getCppDefault_Value();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppDefault#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see Cpp.CppDefault#getBase_parameter()
	 * @see #getCppDefault()
	 * @generated
	 */
	EReference getCppDefault_Base_parameter();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppDefault#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see Cpp.CppDefault#getBase_property()
	 * @see #getCppDefault()
	 * @generated
	 */
	EReference getCppDefault_Base_property();

	/**
	 * Returns the meta object for class '{@link Cpp.CppPtr <em>Ptr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ptr</em>'.
	 * @see Cpp.CppPtr
	 * @generated
	 */
	EClass getCppPtr();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppPtr#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see Cpp.CppPtr#getBase_parameter()
	 * @see #getCppPtr()
	 * @generated
	 */
	EReference getCppPtr_Base_parameter();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppPtr#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see Cpp.CppPtr#getBase_property()
	 * @see #getCppPtr()
	 * @generated
	 */
	EReference getCppPtr_Base_property();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppPtr#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declaration</em>'.
	 * @see Cpp.CppPtr#getDeclaration()
	 * @see #getCppPtr()
	 * @generated
	 */
	EAttribute getCppPtr_Declaration();

	/**
	 * Returns the meta object for class '{@link Cpp.CppRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ref</em>'.
	 * @see Cpp.CppRef
	 * @generated
	 */
	EClass getCppRef();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppRef#getBase_parameter <em>Base parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base parameter</em>'.
	 * @see Cpp.CppRef#getBase_parameter()
	 * @see #getCppRef()
	 * @generated
	 */
	EReference getCppRef_Base_parameter();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppRef#getBase_property <em>Base property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base property</em>'.
	 * @see Cpp.CppRef#getBase_property()
	 * @see #getCppRef()
	 * @generated
	 */
	EReference getCppRef_Base_property();

	/**
	 * Returns the meta object for class '{@link Cpp.CppExternClass <em>Extern Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extern Class</em>'.
	 * @see Cpp.CppExternClass
	 * @generated
	 */
	EClass getCppExternClass();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppExternClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Cpp.CppExternClass#getName()
	 * @see #getCppExternClass()
	 * @generated
	 */
	EAttribute getCppExternClass_Name();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppExternClass#getBase_class <em>Base class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base class</em>'.
	 * @see Cpp.CppExternClass#getBase_class()
	 * @see #getCppExternClass()
	 * @generated
	 */
	EReference getCppExternClass_Base_class();

	/**
	 * Returns the meta object for class '{@link Cpp.CppExternLibrary <em>Extern Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extern Library</em>'.
	 * @see Cpp.CppExternLibrary
	 * @generated
	 */
	EClass getCppExternLibrary();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppExternLibrary#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Cpp.CppExternLibrary#getName()
	 * @see #getCppExternLibrary()
	 * @generated
	 */
	EAttribute getCppExternLibrary_Name();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppExternLibrary#getBase_package <em>Base package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base package</em>'.
	 * @see Cpp.CppExternLibrary#getBase_package()
	 * @see #getCppExternLibrary()
	 * @generated
	 */
	EReference getCppExternLibrary_Base_package();

	/**
	 * Returns the meta object for class '{@link Cpp.CppInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Include</em>'.
	 * @see Cpp.CppInclude
	 * @generated
	 */
	EClass getCppInclude();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppInclude#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see Cpp.CppInclude#getBody()
	 * @see #getCppInclude()
	 * @generated
	 */
	EAttribute getCppInclude_Body();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppInclude#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header</em>'.
	 * @see Cpp.CppInclude#getHeader()
	 * @see #getCppInclude()
	 * @generated
	 */
	EAttribute getCppInclude_Header();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppInclude#getBase_package <em>Base package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base package</em>'.
	 * @see Cpp.CppInclude#getBase_package()
	 * @see #getCppInclude()
	 * @generated
	 */
	EReference getCppInclude_Base_package();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppInclude#getBase_class <em>Base class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base class</em>'.
	 * @see Cpp.CppInclude#getBase_class()
	 * @see #getCppInclude()
	 * @generated
	 */
	EReference getCppInclude_Base_class();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppInclude#getBase_PackageImport <em>Base Package Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package Import</em>'.
	 * @see Cpp.CppInclude#getBase_PackageImport()
	 * @see #getCppInclude()
	 * @generated
	 */
	EReference getCppInclude_Base_PackageImport();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppInclude#getPreBody <em>Pre Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pre Body</em>'.
	 * @see Cpp.CppInclude#getPreBody()
	 * @see #getCppInclude()
	 * @generated
	 */
	EAttribute getCppInclude_PreBody();

	/**
	 * Returns the meta object for class '{@link Cpp.ManualGeneration <em>Manual Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manual Generation</em>'.
	 * @see Cpp.ManualGeneration
	 * @generated
	 */
	EClass getManualGeneration();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.ManualGeneration#getExtensionBody <em>Extension Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension Body</em>'.
	 * @see Cpp.ManualGeneration#getExtensionBody()
	 * @see #getManualGeneration()
	 * @generated
	 */
	EAttribute getManualGeneration_ExtensionBody();

	/**
	 * Returns the meta object for the reference '{@link Cpp.ManualGeneration#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see Cpp.ManualGeneration#getBase_Class()
	 * @see #getManualGeneration()
	 * @generated
	 */
	EReference getManualGeneration_Base_Class();

	/**
	 * Returns the meta object for class '{@link Cpp.CppRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see Cpp.CppRoot
	 * @generated
	 */
	EClass getCppRoot();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppRoot#getBase_package <em>Base package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base package</em>'.
	 * @see Cpp.CppRoot#getBase_package()
	 * @see #getCppRoot()
	 * @generated
	 */
	EReference getCppRoot_Base_package();

	/**
	 * Returns the meta object for class '{@link Cpp.CppNoCodeGen <em>No Code Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No Code Gen</em>'.
	 * @see Cpp.CppNoCodeGen
	 * @generated
	 */
	EClass getCppNoCodeGen();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppNoCodeGen#getBase_element <em>Base element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base element</em>'.
	 * @see Cpp.CppNoCodeGen#getBase_element()
	 * @see #getCppNoCodeGen()
	 * @generated
	 */
	EReference getCppNoCodeGen_Base_element();

	/**
	 * Returns the meta object for class '{@link Cpp.CppConstInit <em>Const Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const Init</em>'.
	 * @see Cpp.CppConstInit
	 * @generated
	 */
	EClass getCppConstInit();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppConstInit#getInitialisation <em>Initialisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialisation</em>'.
	 * @see Cpp.CppConstInit#getInitialisation()
	 * @see #getCppConstInit()
	 * @generated
	 */
	EAttribute getCppConstInit_Initialisation();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppConstInit#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see Cpp.CppConstInit#getBase_operation()
	 * @see #getCppConstInit()
	 * @generated
	 */
	EReference getCppConstInit_Base_operation();

	/**
	 * Returns the meta object for class '{@link Cpp.CppFriend <em>Friend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Friend</em>'.
	 * @see Cpp.CppFriend
	 * @generated
	 */
	EClass getCppFriend();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppFriend#getBase_dependency <em>Base dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base dependency</em>'.
	 * @see Cpp.CppFriend#getBase_dependency()
	 * @see #getCppFriend()
	 * @generated
	 */
	EReference getCppFriend_Base_dependency();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppFriend#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see Cpp.CppFriend#getBase_operation()
	 * @see #getCppFriend()
	 * @generated
	 */
	EReference getCppFriend_Base_operation();

	/**
	 * Returns the meta object for class '{@link Cpp.CppInline <em>Inline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inline</em>'.
	 * @see Cpp.CppInline
	 * @generated
	 */
	EClass getCppInline();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppInline#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see Cpp.CppInline#getBase_operation()
	 * @see #getCppInline()
	 * @generated
	 */
	EReference getCppInline_Base_operation();

	/**
	 * Returns the meta object for class '{@link Cpp.CppVirtual <em>Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual</em>'.
	 * @see Cpp.CppVirtual
	 * @generated
	 */
	EClass getCppVirtual();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppVirtual#getBase_operation <em>Base operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base operation</em>'.
	 * @see Cpp.CppVirtual#getBase_operation()
	 * @see #getCppVirtual()
	 * @generated
	 */
	EReference getCppVirtual_Base_operation();

	/**
	 * Returns the meta object for class '{@link Cpp.CppType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see Cpp.CppType
	 * @generated
	 */
	EClass getCppType();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppType#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition</em>'.
	 * @see Cpp.CppType#getDefinition()
	 * @see #getCppType()
	 * @generated
	 */
	EAttribute getCppType_Definition();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppType#getBase_primitivetype <em>Base primitivetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base primitivetype</em>'.
	 * @see Cpp.CppType#getBase_primitivetype()
	 * @see #getCppType()
	 * @generated
	 */
	EReference getCppType_Base_primitivetype();

	/**
	 * Returns the meta object for class '{@link Cpp.CppVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visibility</em>'.
	 * @see Cpp.CppVisibility
	 * @generated
	 */
	EClass getCppVisibility();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppVisibility#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see Cpp.CppVisibility#getValue()
	 * @see #getCppVisibility()
	 * @generated
	 */
	EAttribute getCppVisibility_Value();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppVisibility#getBase_generalization <em>Base generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base generalization</em>'.
	 * @see Cpp.CppVisibility#getBase_generalization()
	 * @see #getCppVisibility()
	 * @generated
	 */
	EReference getCppVisibility_Base_generalization();

	/**
	 * Returns the meta object for class '{@link Cpp.CppInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Init</em>'.
	 * @see Cpp.CppInit
	 * @generated
	 */
	EClass getCppInit();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppInit#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see Cpp.CppInit#getValue()
	 * @see #getCppInit()
	 * @generated
	 */
	EAttribute getCppInit_Value();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppInit#getBase_enumerationliteral <em>Base enumerationliteral</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base enumerationliteral</em>'.
	 * @see Cpp.CppInit#getBase_enumerationliteral()
	 * @see #getCppInit()
	 * @generated
	 */
	EReference getCppInit_Base_enumerationliteral();

	/**
	 * Returns the meta object for class '{@link Cpp.CppTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see Cpp.CppTemplate
	 * @generated
	 */
	EClass getCppTemplate();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppTemplate#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declaration</em>'.
	 * @see Cpp.CppTemplate#getDeclaration()
	 * @see #getCppTemplate()
	 * @generated
	 */
	EAttribute getCppTemplate_Declaration();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppTemplate#getBase_class <em>Base class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base class</em>'.
	 * @see Cpp.CppTemplate#getBase_class()
	 * @see #getCppTemplate()
	 * @generated
	 */
	EReference getCppTemplate_Base_class();

	/**
	 * Returns the meta object for class '{@link Cpp.CppTemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Binding</em>'.
	 * @see Cpp.CppTemplateBinding
	 * @generated
	 */
	EClass getCppTemplateBinding();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppTemplateBinding#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binding</em>'.
	 * @see Cpp.CppTemplateBinding#getBinding()
	 * @see #getCppTemplateBinding()
	 * @generated
	 */
	EAttribute getCppTemplateBinding_Binding();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppTemplateBinding#getBase_templatebinding <em>Base templatebinding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base templatebinding</em>'.
	 * @see Cpp.CppTemplateBinding#getBase_templatebinding()
	 * @see #getCppTemplateBinding()
	 * @generated
	 */
	EReference getCppTemplateBinding_Base_templatebinding();

	/**
	 * Returns the meta object for class '{@link Cpp.CppTemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter</em>'.
	 * @see Cpp.CppTemplateParameter
	 * @generated
	 */
	EClass getCppTemplateParameter();

	/**
	 * Returns the meta object for the attribute '{@link Cpp.CppTemplateParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Cpp.CppTemplateParameter#getName()
	 * @see #getCppTemplateParameter()
	 * @generated
	 */
	EAttribute getCppTemplateParameter_Name();

	/**
	 * Returns the meta object for the reference '{@link Cpp.CppTemplateParameter#getBase_templateparameter <em>Base templateparameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base templateparameter</em>'.
	 * @see Cpp.CppTemplateParameter#getBase_templateparameter()
	 * @see #getCppTemplateParameter()
	 * @generated
	 */
	EReference getCppTemplateParameter_Base_templateparameter();

	/**
	 * Returns the meta object for class '{@link Cpp.Union <em>Union</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union</em>'.
	 * @see Cpp.Union
	 * @generated
	 */
	EClass getUnion();

	/**
	 * Returns the meta object for the reference '{@link Cpp.Union#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see Cpp.Union#getBase_DataType()
	 * @see #getUnion()
	 * @generated
	 */
	EReference getUnion_Base_DataType();

	/**
	 * Returns the meta object for enum '{@link Cpp.CppVisibilityKind <em>Visibility Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility Kind</em>'.
	 * @see Cpp.CppVisibilityKind
	 * @generated
	 */
	EEnum getCppVisibilityKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CppFactory getCppFactory();

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
		 * The meta object literal for the '{@link Cpp.impl.CppArrayImpl <em>Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppArrayImpl
		 * @see Cpp.impl.CppPackageImpl#getCppArray()
		 * @generated
		 */
		EClass CPP_ARRAY = eINSTANCE.getCppArray();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_ARRAY__BASE_PARAMETER = eINSTANCE.getCppArray_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_ARRAY__DEFINITION = eINSTANCE.getCppArray_Definition();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_ARRAY__BASE_PROPERTY = eINSTANCE.getCppArray_Base_property();

		/**
		 * The meta object literal for the '<em><b>Base association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_ARRAY__BASE_ASSOCIATION = eINSTANCE.getCppArray_Base_association();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppConstImpl <em>Const</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppConstImpl
		 * @see Cpp.impl.CppPackageImpl#getCppConst()
		 * @generated
		 */
		EClass CPP_CONST = eINSTANCE.getCppConst();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_CONST__BASE_PARAMETER = eINSTANCE.getCppConst_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_CONST__BASE_PROPERTY = eINSTANCE.getCppConst_Base_property();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_CONST__BASE_OPERATION = eINSTANCE.getCppConst_Base_operation();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppDefaultImpl <em>Default</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppDefaultImpl
		 * @see Cpp.impl.CppPackageImpl#getCppDefault()
		 * @generated
		 */
		EClass CPP_DEFAULT = eINSTANCE.getCppDefault();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_DEFAULT__VALUE = eINSTANCE.getCppDefault_Value();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_DEFAULT__BASE_PARAMETER = eINSTANCE.getCppDefault_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_DEFAULT__BASE_PROPERTY = eINSTANCE.getCppDefault_Base_property();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppPtrImpl <em>Ptr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppPtrImpl
		 * @see Cpp.impl.CppPackageImpl#getCppPtr()
		 * @generated
		 */
		EClass CPP_PTR = eINSTANCE.getCppPtr();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_PTR__BASE_PARAMETER = eINSTANCE.getCppPtr_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_PTR__BASE_PROPERTY = eINSTANCE.getCppPtr_Base_property();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_PTR__DECLARATION = eINSTANCE.getCppPtr_Declaration();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppRefImpl <em>Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppRefImpl
		 * @see Cpp.impl.CppPackageImpl#getCppRef()
		 * @generated
		 */
		EClass CPP_REF = eINSTANCE.getCppRef();

		/**
		 * The meta object literal for the '<em><b>Base parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_REF__BASE_PARAMETER = eINSTANCE.getCppRef_Base_parameter();

		/**
		 * The meta object literal for the '<em><b>Base property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_REF__BASE_PROPERTY = eINSTANCE.getCppRef_Base_property();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppExternClassImpl <em>Extern Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppExternClassImpl
		 * @see Cpp.impl.CppPackageImpl#getCppExternClass()
		 * @generated
		 */
		EClass CPP_EXTERN_CLASS = eINSTANCE.getCppExternClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_EXTERN_CLASS__NAME = eINSTANCE.getCppExternClass_Name();

		/**
		 * The meta object literal for the '<em><b>Base class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_EXTERN_CLASS__BASE_CLASS = eINSTANCE.getCppExternClass_Base_class();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppExternLibraryImpl <em>Extern Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppExternLibraryImpl
		 * @see Cpp.impl.CppPackageImpl#getCppExternLibrary()
		 * @generated
		 */
		EClass CPP_EXTERN_LIBRARY = eINSTANCE.getCppExternLibrary();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_EXTERN_LIBRARY__NAME = eINSTANCE.getCppExternLibrary_Name();

		/**
		 * The meta object literal for the '<em><b>Base package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_EXTERN_LIBRARY__BASE_PACKAGE = eINSTANCE.getCppExternLibrary_Base_package();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppIncludeImpl <em>Include</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppIncludeImpl
		 * @see Cpp.impl.CppPackageImpl#getCppInclude()
		 * @generated
		 */
		EClass CPP_INCLUDE = eINSTANCE.getCppInclude();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_INCLUDE__BODY = eINSTANCE.getCppInclude_Body();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_INCLUDE__HEADER = eINSTANCE.getCppInclude_Header();

		/**
		 * The meta object literal for the '<em><b>Base package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_INCLUDE__BASE_PACKAGE = eINSTANCE.getCppInclude_Base_package();

		/**
		 * The meta object literal for the '<em><b>Base class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_INCLUDE__BASE_CLASS = eINSTANCE.getCppInclude_Base_class();

		/**
		 * The meta object literal for the '<em><b>Base Package Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_INCLUDE__BASE_PACKAGE_IMPORT = eINSTANCE.getCppInclude_Base_PackageImport();

		/**
		 * The meta object literal for the '<em><b>Pre Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_INCLUDE__PRE_BODY = eINSTANCE.getCppInclude_PreBody();

		/**
		 * The meta object literal for the '{@link Cpp.impl.ManualGenerationImpl <em>Manual Generation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.ManualGenerationImpl
		 * @see Cpp.impl.CppPackageImpl#getManualGeneration()
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
		 * The meta object literal for the '{@link Cpp.impl.CppRootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppRootImpl
		 * @see Cpp.impl.CppPackageImpl#getCppRoot()
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
		 * The meta object literal for the '{@link Cpp.impl.CppNoCodeGenImpl <em>No Code Gen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppNoCodeGenImpl
		 * @see Cpp.impl.CppPackageImpl#getCppNoCodeGen()
		 * @generated
		 */
		EClass CPP_NO_CODE_GEN = eINSTANCE.getCppNoCodeGen();

		/**
		 * The meta object literal for the '<em><b>Base element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_NO_CODE_GEN__BASE_ELEMENT = eINSTANCE.getCppNoCodeGen_Base_element();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppConstInitImpl <em>Const Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppConstInitImpl
		 * @see Cpp.impl.CppPackageImpl#getCppConstInit()
		 * @generated
		 */
		EClass CPP_CONST_INIT = eINSTANCE.getCppConstInit();

		/**
		 * The meta object literal for the '<em><b>Initialisation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_CONST_INIT__INITIALISATION = eINSTANCE.getCppConstInit_Initialisation();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_CONST_INIT__BASE_OPERATION = eINSTANCE.getCppConstInit_Base_operation();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppFriendImpl <em>Friend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppFriendImpl
		 * @see Cpp.impl.CppPackageImpl#getCppFriend()
		 * @generated
		 */
		EClass CPP_FRIEND = eINSTANCE.getCppFriend();

		/**
		 * The meta object literal for the '<em><b>Base dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_FRIEND__BASE_DEPENDENCY = eINSTANCE.getCppFriend_Base_dependency();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_FRIEND__BASE_OPERATION = eINSTANCE.getCppFriend_Base_operation();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppInlineImpl <em>Inline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppInlineImpl
		 * @see Cpp.impl.CppPackageImpl#getCppInline()
		 * @generated
		 */
		EClass CPP_INLINE = eINSTANCE.getCppInline();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_INLINE__BASE_OPERATION = eINSTANCE.getCppInline_Base_operation();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppVirtualImpl <em>Virtual</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppVirtualImpl
		 * @see Cpp.impl.CppPackageImpl#getCppVirtual()
		 * @generated
		 */
		EClass CPP_VIRTUAL = eINSTANCE.getCppVirtual();

		/**
		 * The meta object literal for the '<em><b>Base operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_VIRTUAL__BASE_OPERATION = eINSTANCE.getCppVirtual_Base_operation();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppTypeImpl
		 * @see Cpp.impl.CppPackageImpl#getCppType()
		 * @generated
		 */
		EClass CPP_TYPE = eINSTANCE.getCppType();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_TYPE__DEFINITION = eINSTANCE.getCppType_Definition();

		/**
		 * The meta object literal for the '<em><b>Base primitivetype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_TYPE__BASE_PRIMITIVETYPE = eINSTANCE.getCppType_Base_primitivetype();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppVisibilityImpl <em>Visibility</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppVisibilityImpl
		 * @see Cpp.impl.CppPackageImpl#getCppVisibility()
		 * @generated
		 */
		EClass CPP_VISIBILITY = eINSTANCE.getCppVisibility();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_VISIBILITY__VALUE = eINSTANCE.getCppVisibility_Value();

		/**
		 * The meta object literal for the '<em><b>Base generalization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_VISIBILITY__BASE_GENERALIZATION = eINSTANCE.getCppVisibility_Base_generalization();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppInitImpl <em>Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppInitImpl
		 * @see Cpp.impl.CppPackageImpl#getCppInit()
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
		 * The meta object literal for the '{@link Cpp.impl.CppTemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppTemplateImpl
		 * @see Cpp.impl.CppPackageImpl#getCppTemplate()
		 * @generated
		 */
		EClass CPP_TEMPLATE = eINSTANCE.getCppTemplate();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_TEMPLATE__DECLARATION = eINSTANCE.getCppTemplate_Declaration();

		/**
		 * The meta object literal for the '<em><b>Base class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_TEMPLATE__BASE_CLASS = eINSTANCE.getCppTemplate_Base_class();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppTemplateBindingImpl <em>Template Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppTemplateBindingImpl
		 * @see Cpp.impl.CppPackageImpl#getCppTemplateBinding()
		 * @generated
		 */
		EClass CPP_TEMPLATE_BINDING = eINSTANCE.getCppTemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_TEMPLATE_BINDING__BINDING = eINSTANCE.getCppTemplateBinding_Binding();

		/**
		 * The meta object literal for the '<em><b>Base templatebinding</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_TEMPLATE_BINDING__BASE_TEMPLATEBINDING = eINSTANCE.getCppTemplateBinding_Base_templatebinding();

		/**
		 * The meta object literal for the '{@link Cpp.impl.CppTemplateParameterImpl <em>Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.CppTemplateParameterImpl
		 * @see Cpp.impl.CppPackageImpl#getCppTemplateParameter()
		 * @generated
		 */
		EClass CPP_TEMPLATE_PARAMETER = eINSTANCE.getCppTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_TEMPLATE_PARAMETER__NAME = eINSTANCE.getCppTemplateParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Base templateparameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPP_TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER = eINSTANCE.getCppTemplateParameter_Base_templateparameter();

		/**
		 * The meta object literal for the '{@link Cpp.impl.UnionImpl <em>Union</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.impl.UnionImpl
		 * @see Cpp.impl.CppPackageImpl#getUnion()
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
		 * The meta object literal for the '{@link Cpp.CppVisibilityKind <em>Visibility Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Cpp.CppVisibilityKind
		 * @see Cpp.impl.CppPackageImpl#getCppVisibilityKind()
		 * @generated
		 */
		EEnum CPP_VISIBILITY_KIND = eINSTANCE.getCppVisibilityKind();

	}

} //CppPackage
