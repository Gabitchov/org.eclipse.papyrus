/**
 */
package Cpp.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

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
import Cpp.ManualGeneration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class CppPackageImpl extends EPackageImpl implements CppPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppConstEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppDefaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppPtrEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppExternClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppExternLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppIncludeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass manualGenerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppNoCodeGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppConstInitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppFriendEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppInlineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppVirtualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppVisibilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppInitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppTemplateBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cppTemplateParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum cppVisibilityKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see Cpp.CppPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CppPackageImpl() {
		super(eNS_URI, CppFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link CppPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CppPackage init() {
		if(isInited)
			return (CppPackage)EPackage.Registry.INSTANCE.getEPackage(CppPackage.eNS_URI);

		// Obtain or create and register package
		CppPackageImpl theCppPackage = (CppPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CppPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CppPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCppPackage.createPackageContents();

		// Initialize created meta-data
		theCppPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCppPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CppPackage.eNS_URI, theCppPackage);
		return theCppPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppArray() {
		return cppArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppArray_Base_parameter() {
		return (EReference)cppArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppArray_Definition() {
		return (EAttribute)cppArrayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppArray_Base_property() {
		return (EReference)cppArrayEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppArray_Base_association() {
		return (EReference)cppArrayEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppConst() {
		return cppConstEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppConst_Base_parameter() {
		return (EReference)cppConstEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppConst_Base_property() {
		return (EReference)cppConstEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppConst_Base_operation() {
		return (EReference)cppConstEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppDefault() {
		return cppDefaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppDefault_Value() {
		return (EAttribute)cppDefaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppDefault_Base_parameter() {
		return (EReference)cppDefaultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppDefault_Base_property() {
		return (EReference)cppDefaultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppPtr() {
		return cppPtrEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppPtr_Base_parameter() {
		return (EReference)cppPtrEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppPtr_Base_property() {
		return (EReference)cppPtrEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppPtr_Declaration() {
		return (EAttribute)cppPtrEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppRef() {
		return cppRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppRef_Base_parameter() {
		return (EReference)cppRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppRef_Base_property() {
		return (EReference)cppRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppExternClass() {
		return cppExternClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppExternClass_Name() {
		return (EAttribute)cppExternClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppExternClass_Base_class() {
		return (EReference)cppExternClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppExternLibrary() {
		return cppExternLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppExternLibrary_Name() {
		return (EAttribute)cppExternLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppExternLibrary_Base_package() {
		return (EReference)cppExternLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppInclude() {
		return cppIncludeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppInclude_Body() {
		return (EAttribute)cppIncludeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppInclude_Header() {
		return (EAttribute)cppIncludeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppInclude_Base_package() {
		return (EReference)cppIncludeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppInclude_Base_class() {
		return (EReference)cppIncludeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppInclude_Base_PackageImport() {
		return (EReference)cppIncludeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppInclude_PreBody() {
		return (EAttribute)cppIncludeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getManualGeneration() {
		return manualGenerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getManualGeneration_ExtensionBody() {
		return (EAttribute)manualGenerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getManualGeneration_Base_Class() {
		return (EReference)manualGenerationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppRoot() {
		return cppRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppRoot_Base_package() {
		return (EReference)cppRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppNoCodeGen() {
		return cppNoCodeGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppNoCodeGen_Base_element() {
		return (EReference)cppNoCodeGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppConstInit() {
		return cppConstInitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppConstInit_Initialisation() {
		return (EAttribute)cppConstInitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppConstInit_Base_operation() {
		return (EReference)cppConstInitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppFriend() {
		return cppFriendEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppFriend_Base_dependency() {
		return (EReference)cppFriendEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppFriend_Base_operation() {
		return (EReference)cppFriendEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppInline() {
		return cppInlineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppInline_Base_operation() {
		return (EReference)cppInlineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppVirtual() {
		return cppVirtualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppVirtual_Base_operation() {
		return (EReference)cppVirtualEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppType() {
		return cppTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppType_Definition() {
		return (EAttribute)cppTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppType_Base_primitivetype() {
		return (EReference)cppTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppVisibility() {
		return cppVisibilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppVisibility_Value() {
		return (EAttribute)cppVisibilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppVisibility_Base_generalization() {
		return (EReference)cppVisibilityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppInit() {
		return cppInitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppInit_Value() {
		return (EAttribute)cppInitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppInit_Base_enumerationliteral() {
		return (EReference)cppInitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppTemplate() {
		return cppTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppTemplate_Declaration() {
		return (EAttribute)cppTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppTemplate_Base_class() {
		return (EReference)cppTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppTemplateBinding() {
		return cppTemplateBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppTemplateBinding_Binding() {
		return (EAttribute)cppTemplateBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppTemplateBinding_Base_templatebinding() {
		return (EReference)cppTemplateBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCppTemplateParameter() {
		return cppTemplateParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCppTemplateParameter_Name() {
		return (EAttribute)cppTemplateParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCppTemplateParameter_Base_templateparameter() {
		return (EReference)cppTemplateParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getCppVisibilityKind() {
		return cppVisibilityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CppFactory getCppFactory() {
		return (CppFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		cppPtrEClass = createEClass(CPP_PTR);
		createEReference(cppPtrEClass, CPP_PTR__BASE_PARAMETER);
		createEReference(cppPtrEClass, CPP_PTR__BASE_PROPERTY);
		createEAttribute(cppPtrEClass, CPP_PTR__DECLARATION);

		cppIncludeEClass = createEClass(CPP_INCLUDE);
		createEAttribute(cppIncludeEClass, CPP_INCLUDE__BODY);
		createEAttribute(cppIncludeEClass, CPP_INCLUDE__HEADER);
		createEReference(cppIncludeEClass, CPP_INCLUDE__BASE_PACKAGE);
		createEReference(cppIncludeEClass, CPP_INCLUDE__BASE_CLASS);
		createEReference(cppIncludeEClass, CPP_INCLUDE__BASE_PACKAGE_IMPORT);
		createEAttribute(cppIncludeEClass, CPP_INCLUDE__PRE_BODY);

		manualGenerationEClass = createEClass(MANUAL_GENERATION);
		createEAttribute(manualGenerationEClass, MANUAL_GENERATION__EXTENSION_BODY);
		createEReference(manualGenerationEClass, MANUAL_GENERATION__BASE_CLASS);

		cppArrayEClass = createEClass(CPP_ARRAY);
		createEReference(cppArrayEClass, CPP_ARRAY__BASE_PARAMETER);
		createEAttribute(cppArrayEClass, CPP_ARRAY__DEFINITION);
		createEReference(cppArrayEClass, CPP_ARRAY__BASE_PROPERTY);
		createEReference(cppArrayEClass, CPP_ARRAY__BASE_ASSOCIATION);

		cppConstEClass = createEClass(CPP_CONST);
		createEReference(cppConstEClass, CPP_CONST__BASE_PARAMETER);
		createEReference(cppConstEClass, CPP_CONST__BASE_PROPERTY);
		createEReference(cppConstEClass, CPP_CONST__BASE_OPERATION);

		cppDefaultEClass = createEClass(CPP_DEFAULT);
		createEAttribute(cppDefaultEClass, CPP_DEFAULT__VALUE);
		createEReference(cppDefaultEClass, CPP_DEFAULT__BASE_PARAMETER);
		createEReference(cppDefaultEClass, CPP_DEFAULT__BASE_PROPERTY);

		cppRefEClass = createEClass(CPP_REF);
		createEReference(cppRefEClass, CPP_REF__BASE_PARAMETER);
		createEReference(cppRefEClass, CPP_REF__BASE_PROPERTY);

		cppExternClassEClass = createEClass(CPP_EXTERN_CLASS);
		createEAttribute(cppExternClassEClass, CPP_EXTERN_CLASS__NAME);
		createEReference(cppExternClassEClass, CPP_EXTERN_CLASS__BASE_CLASS);

		cppExternLibraryEClass = createEClass(CPP_EXTERN_LIBRARY);
		createEAttribute(cppExternLibraryEClass, CPP_EXTERN_LIBRARY__NAME);
		createEReference(cppExternLibraryEClass, CPP_EXTERN_LIBRARY__BASE_PACKAGE);

		cppRootEClass = createEClass(CPP_ROOT);
		createEReference(cppRootEClass, CPP_ROOT__BASE_PACKAGE);

		cppNoCodeGenEClass = createEClass(CPP_NO_CODE_GEN);
		createEReference(cppNoCodeGenEClass, CPP_NO_CODE_GEN__BASE_ELEMENT);

		cppConstInitEClass = createEClass(CPP_CONST_INIT);
		createEAttribute(cppConstInitEClass, CPP_CONST_INIT__INITIALISATION);
		createEReference(cppConstInitEClass, CPP_CONST_INIT__BASE_OPERATION);

		cppFriendEClass = createEClass(CPP_FRIEND);
		createEReference(cppFriendEClass, CPP_FRIEND__BASE_DEPENDENCY);
		createEReference(cppFriendEClass, CPP_FRIEND__BASE_OPERATION);

		cppInlineEClass = createEClass(CPP_INLINE);
		createEReference(cppInlineEClass, CPP_INLINE__BASE_OPERATION);

		cppVirtualEClass = createEClass(CPP_VIRTUAL);
		createEReference(cppVirtualEClass, CPP_VIRTUAL__BASE_OPERATION);

		cppTypeEClass = createEClass(CPP_TYPE);
		createEAttribute(cppTypeEClass, CPP_TYPE__DEFINITION);
		createEReference(cppTypeEClass, CPP_TYPE__BASE_PRIMITIVETYPE);

		cppVisibilityEClass = createEClass(CPP_VISIBILITY);
		createEAttribute(cppVisibilityEClass, CPP_VISIBILITY__VALUE);
		createEReference(cppVisibilityEClass, CPP_VISIBILITY__BASE_GENERALIZATION);

		cppInitEClass = createEClass(CPP_INIT);
		createEAttribute(cppInitEClass, CPP_INIT__VALUE);
		createEReference(cppInitEClass, CPP_INIT__BASE_ENUMERATIONLITERAL);

		cppTemplateEClass = createEClass(CPP_TEMPLATE);
		createEAttribute(cppTemplateEClass, CPP_TEMPLATE__DECLARATION);
		createEReference(cppTemplateEClass, CPP_TEMPLATE__BASE_CLASS);

		cppTemplateBindingEClass = createEClass(CPP_TEMPLATE_BINDING);
		createEAttribute(cppTemplateBindingEClass, CPP_TEMPLATE_BINDING__BINDING);
		createEReference(cppTemplateBindingEClass, CPP_TEMPLATE_BINDING__BASE_TEMPLATEBINDING);

		cppTemplateParameterEClass = createEClass(CPP_TEMPLATE_PARAMETER);
		createEAttribute(cppTemplateParameterEClass, CPP_TEMPLATE_PARAMETER__NAME);
		createEReference(cppTemplateParameterEClass, CPP_TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER);

		// Create enums
		cppVisibilityKindEEnum = createEEnum(CPP_VISIBILITY_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(cppPtrEClass, CppPtr.class, "CppPtr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCppPtr_Base_parameter(), theUMLPackage.getParameter(), null, "base_parameter", null, 1, 1, CppPtr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppPtr_Base_property(), theUMLPackage.getProperty(), null, "base_property", null, 1, 1, CppPtr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCppPtr_Declaration(), theTypesPackage.getString(), "declaration", null, 1, 1, CppPtr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppIncludeEClass, CppInclude.class, "CppInclude", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppInclude_Body(), theTypesPackage.getString(), "body", "", 1, 1, CppInclude.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCppInclude_Header(), theTypesPackage.getString(), "header", "", 1, 1, CppInclude.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppInclude_Base_package(), theUMLPackage.getPackage(), null, "base_package", null, 1, 1, CppInclude.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppInclude_Base_class(), theUMLPackage.getClass_(), null, "base_class", null, 1, 1, CppInclude.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppInclude_Base_PackageImport(), theUMLPackage.getPackageImport(), null, "base_PackageImport", null, 1, 1, CppInclude.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCppInclude_PreBody(), theTypesPackage.getString(), "preBody", null, 1, 1, CppInclude.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(manualGenerationEClass, ManualGeneration.class, "ManualGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getManualGeneration_ExtensionBody(), theTypesPackage.getString(), "extensionBody", null, 1, 1, ManualGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getManualGeneration_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, ManualGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppArrayEClass, CppArray.class, "CppArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCppArray_Base_parameter(), theUMLPackage.getParameter(), null, "base_parameter", null, 1, 1, CppArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCppArray_Definition(), theTypesPackage.getString(), "definition", null, 1, 1, CppArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppArray_Base_property(), theUMLPackage.getProperty(), null, "base_property", null, 1, 1, CppArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppArray_Base_association(), theUMLPackage.getAssociation(), null, "base_association", null, 1, 1, CppArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppConstEClass, CppConst.class, "CppConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCppConst_Base_parameter(), theUMLPackage.getParameter(), null, "base_parameter", null, 1, 1, CppConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppConst_Base_property(), theUMLPackage.getProperty(), null, "base_property", null, 1, 1, CppConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppConst_Base_operation(), theUMLPackage.getOperation(), null, "base_operation", null, 1, 1, CppConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppDefaultEClass, CppDefault.class, "CppDefault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppDefault_Value(), theTypesPackage.getString(), "value", null, 1, 1, CppDefault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppDefault_Base_parameter(), theUMLPackage.getParameter(), null, "base_parameter", null, 1, 1, CppDefault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppDefault_Base_property(), theUMLPackage.getProperty(), null, "base_property", null, 1, 1, CppDefault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppRefEClass, CppRef.class, "CppRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCppRef_Base_parameter(), theUMLPackage.getParameter(), null, "base_parameter", null, 1, 1, CppRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppRef_Base_property(), theUMLPackage.getProperty(), null, "base_property", null, 1, 1, CppRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppExternClassEClass, CppExternClass.class, "CppExternClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppExternClass_Name(), theTypesPackage.getString(), "name", null, 1, 1, CppExternClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppExternClass_Base_class(), theUMLPackage.getClass_(), null, "base_class", null, 1, 1, CppExternClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppExternLibraryEClass, CppExternLibrary.class, "CppExternLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppExternLibrary_Name(), theTypesPackage.getString(), "name", null, 1, 1, CppExternLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppExternLibrary_Base_package(), theUMLPackage.getPackage(), null, "base_package", null, 1, 1, CppExternLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppRootEClass, CppRoot.class, "CppRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCppRoot_Base_package(), theUMLPackage.getPackage(), null, "base_package", null, 1, 1, CppRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppNoCodeGenEClass, CppNoCodeGen.class, "CppNoCodeGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCppNoCodeGen_Base_element(), theUMLPackage.getElement(), null, "base_element", null, 1, 1, CppNoCodeGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppConstInitEClass, CppConstInit.class, "CppConstInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppConstInit_Initialisation(), theTypesPackage.getString(), "initialisation", null, 1, 1, CppConstInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppConstInit_Base_operation(), theUMLPackage.getOperation(), null, "base_operation", null, 1, 1, CppConstInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppFriendEClass, CppFriend.class, "CppFriend", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCppFriend_Base_dependency(), theUMLPackage.getDependency(), null, "base_dependency", null, 1, 1, CppFriend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppFriend_Base_operation(), theUMLPackage.getOperation(), null, "base_operation", null, 1, 1, CppFriend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppInlineEClass, CppInline.class, "CppInline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCppInline_Base_operation(), theUMLPackage.getOperation(), null, "base_operation", null, 1, 1, CppInline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppVirtualEClass, CppVirtual.class, "CppVirtual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCppVirtual_Base_operation(), theUMLPackage.getOperation(), null, "base_operation", null, 1, 1, CppVirtual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppTypeEClass, CppType.class, "CppType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppType_Definition(), theTypesPackage.getString(), "definition", null, 1, 1, CppType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppType_Base_primitivetype(), theUMLPackage.getPrimitiveType(), null, "base_primitivetype", null, 1, 1, CppType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppVisibilityEClass, CppVisibility.class, "CppVisibility", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppVisibility_Value(), theTypesPackage.getString(), "value", null, 1, 1, CppVisibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppVisibility_Base_generalization(), theUMLPackage.getGeneralization(), null, "base_generalization", null, 1, 1, CppVisibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppInitEClass, CppInit.class, "CppInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppInit_Value(), theTypesPackage.getInteger(), "value", null, 1, 1, CppInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppInit_Base_enumerationliteral(), theUMLPackage.getEnumerationLiteral(), null, "base_enumerationliteral", null, 1, 1, CppInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppTemplateEClass, CppTemplate.class, "CppTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppTemplate_Declaration(), theTypesPackage.getString(), "declaration", null, 1, 1, CppTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppTemplate_Base_class(), theUMLPackage.getClass_(), null, "base_class", null, 1, 1, CppTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppTemplateBindingEClass, CppTemplateBinding.class, "CppTemplateBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppTemplateBinding_Binding(), theTypesPackage.getString(), "binding", null, 1, 1, CppTemplateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppTemplateBinding_Base_templatebinding(), theUMLPackage.getTemplateBinding(), null, "base_templatebinding", null, 1, 1, CppTemplateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cppTemplateParameterEClass, CppTemplateParameter.class, "CppTemplateParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCppTemplateParameter_Name(), theTypesPackage.getString(), "name", null, 1, 1, CppTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCppTemplateParameter_Base_templateparameter(), theUMLPackage.getTemplateParameter(), null, "base_templateparameter", null, 1, 1, CppTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(cppVisibilityKindEEnum, CppVisibilityKind.class, "CppVisibilityKind");
		addEEnumLiteral(cppVisibilityKindEEnum, CppVisibilityKind.PRIVATE);
		addEEnumLiteral(cppVisibilityKindEEnum, CppVisibilityKind.PROTECTED);
		addEEnumLiteral(cppVisibilityKindEEnum, CppVisibilityKind.PUBLIC);

		// Create resource
		createResource(eNS_URI);
	}

} //CppPackageImpl
