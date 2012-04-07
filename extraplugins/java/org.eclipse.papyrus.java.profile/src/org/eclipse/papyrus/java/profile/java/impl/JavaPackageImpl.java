/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.java.profile.java.JavaClass;
import org.eclipse.papyrus.java.profile.java.JavaFactory;
import org.eclipse.papyrus.java.profile.java.JavaGen;
import org.eclipse.papyrus.java.profile.java.JavaMethod;
import org.eclipse.papyrus.java.profile.java.JavaNamedElement;
import org.eclipse.papyrus.java.profile.java.JavaPackage;
import org.eclipse.papyrus.java.profile.java.JavaPackage_;
import org.eclipse.papyrus.java.profile.java.JavaParameter;
import org.eclipse.papyrus.java.profile.java.JavaProject;
import org.eclipse.papyrus.java.profile.java.JavaProperty;
import org.eclipse.papyrus.java.profile.java.JavaSrcFolder;
import org.eclipse.papyrus.java.profile.java.PrimitiveType;
import org.eclipse.papyrus.java.profile.java.TrueFalseDefault;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaPackageImpl extends EPackageImpl implements JavaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaPackage_EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaSrcFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum trueFalseDefaultEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavaPackageImpl() {
		super(eNS_URI, JavaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JavaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JavaPackage init() {
		if (isInited) return (JavaPackage)EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI);

		// Obtain or create and register package
		JavaPackageImpl theJavaPackage = (JavaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JavaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JavaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theJavaPackage.createPackageContents();

		// Initialize created meta-data
		theJavaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JavaPackage.eNS_URI, theJavaPackage);
		return theJavaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaClass() {
		return javaClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaClass_Base_Classifier() {
		return (EReference)javaClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaClass_IsFinal() {
		return (EAttribute)javaClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaClass_IsAbstract() {
		return (EAttribute)javaClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaClass_IsStatic() {
		return (EAttribute)javaClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaClass_ExplicitPlainTextRequiredImports() {
		return (EAttribute)javaClassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaClass_ExplicitRequiredImports() {
		return (EReference)javaClassEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaGen() {
		return javaGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaGen_SrcName() {
		return (EAttribute)javaGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaGen_ProjectName() {
		return (EAttribute)javaGenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaNamedElement() {
		return javaNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaNamedElement_Name() {
		return (EAttribute)javaNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaNamedElement_Author() {
		return (EAttribute)javaNamedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaNamedElement_Version() {
		return (EAttribute)javaNamedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaNamedElement_Comment() {
		return (EAttribute)javaNamedElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaNamedElement_IsGenerated() {
		return (EAttribute)javaNamedElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaPackage_() {
		return javaPackage_EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaPackage__PackageName() {
		return (EAttribute)javaPackage_EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaPackage__Base_Package() {
		return (EReference)javaPackage_EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaMethod() {
		return javaMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_IsStatic() {
		return (EAttribute)javaMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_IsFinal() {
		return (EAttribute)javaMethodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_IsAbstract() {
		return (EAttribute)javaMethodEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_IsNative() {
		return (EAttribute)javaMethodEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_IsSynchronized() {
		return (EAttribute)javaMethodEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_IsConstructor() {
		return (EAttribute)javaMethodEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaMethod_Base_Operation() {
		return (EReference)javaMethodEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_ExplicitPlainTextRequiredImports() {
		return (EAttribute)javaMethodEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaMethod_ExplicitRequiredImports() {
		return (EReference)javaMethodEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaParameter() {
		return javaParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaParameter_IsFinal() {
		return (EAttribute)javaParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaParameter_Base_Parameter() {
		return (EReference)javaParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaProperty() {
		return javaPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaProperty_IsAbstract() {
		return (EAttribute)javaPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaProperty_IsFinal() {
		return (EAttribute)javaPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaProperty_Base_Property() {
		return (EReference)javaPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaProperty_IsTransient() {
		return (EAttribute)javaPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaProperty_GenerateGetter() {
		return (EAttribute)javaPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaProperty_GenerateSetter() {
		return (EAttribute)javaPropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaProperty_IsStatic() {
		return (EAttribute)javaPropertyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaProperty_ExplicitPlainTextRequiredImports() {
		return (EAttribute)javaPropertyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaProperty_ExplicitRequiredImports() {
		return (EReference)javaPropertyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_ImplementationClass() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveType_Base_PrimitiveType() {
		return (EReference)primitiveTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_CollectionImplementationClass() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaProject() {
		return javaProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaProject_Base_Package() {
		return (EReference)javaProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaSrcFolder() {
		return javaSrcFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaSrcFolder_Base_Package() {
		return (EReference)javaSrcFolderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTrueFalseDefault() {
		return trueFalseDefaultEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaFactory getJavaFactory() {
		return (JavaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		javaClassEClass = createEClass(JAVA_CLASS);
		createEReference(javaClassEClass, JAVA_CLASS__BASE_CLASSIFIER);
		createEAttribute(javaClassEClass, JAVA_CLASS__IS_FINAL);
		createEAttribute(javaClassEClass, JAVA_CLASS__IS_ABSTRACT);
		createEAttribute(javaClassEClass, JAVA_CLASS__IS_STATIC);
		createEAttribute(javaClassEClass, JAVA_CLASS__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS);
		createEReference(javaClassEClass, JAVA_CLASS__EXPLICIT_REQUIRED_IMPORTS);

		javaGenEClass = createEClass(JAVA_GEN);
		createEAttribute(javaGenEClass, JAVA_GEN__SRC_NAME);
		createEAttribute(javaGenEClass, JAVA_GEN__PROJECT_NAME);

		javaNamedElementEClass = createEClass(JAVA_NAMED_ELEMENT);
		createEAttribute(javaNamedElementEClass, JAVA_NAMED_ELEMENT__NAME);
		createEAttribute(javaNamedElementEClass, JAVA_NAMED_ELEMENT__AUTHOR);
		createEAttribute(javaNamedElementEClass, JAVA_NAMED_ELEMENT__VERSION);
		createEAttribute(javaNamedElementEClass, JAVA_NAMED_ELEMENT__COMMENT);
		createEAttribute(javaNamedElementEClass, JAVA_NAMED_ELEMENT__IS_GENERATED);

		javaPackage_EClass = createEClass(JAVA_PACKAGE_);
		createEAttribute(javaPackage_EClass, JAVA_PACKAGE___PACKAGE_NAME);
		createEReference(javaPackage_EClass, JAVA_PACKAGE___BASE_PACKAGE);

		javaMethodEClass = createEClass(JAVA_METHOD);
		createEAttribute(javaMethodEClass, JAVA_METHOD__IS_STATIC);
		createEAttribute(javaMethodEClass, JAVA_METHOD__IS_FINAL);
		createEAttribute(javaMethodEClass, JAVA_METHOD__IS_ABSTRACT);
		createEAttribute(javaMethodEClass, JAVA_METHOD__IS_NATIVE);
		createEAttribute(javaMethodEClass, JAVA_METHOD__IS_SYNCHRONIZED);
		createEAttribute(javaMethodEClass, JAVA_METHOD__IS_CONSTRUCTOR);
		createEReference(javaMethodEClass, JAVA_METHOD__BASE_OPERATION);
		createEAttribute(javaMethodEClass, JAVA_METHOD__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS);
		createEReference(javaMethodEClass, JAVA_METHOD__EXPLICIT_REQUIRED_IMPORTS);

		javaParameterEClass = createEClass(JAVA_PARAMETER);
		createEAttribute(javaParameterEClass, JAVA_PARAMETER__IS_FINAL);
		createEReference(javaParameterEClass, JAVA_PARAMETER__BASE_PARAMETER);

		javaPropertyEClass = createEClass(JAVA_PROPERTY);
		createEAttribute(javaPropertyEClass, JAVA_PROPERTY__IS_ABSTRACT);
		createEAttribute(javaPropertyEClass, JAVA_PROPERTY__IS_FINAL);
		createEReference(javaPropertyEClass, JAVA_PROPERTY__BASE_PROPERTY);
		createEAttribute(javaPropertyEClass, JAVA_PROPERTY__IS_TRANSIENT);
		createEAttribute(javaPropertyEClass, JAVA_PROPERTY__GENERATE_GETTER);
		createEAttribute(javaPropertyEClass, JAVA_PROPERTY__GENERATE_SETTER);
		createEAttribute(javaPropertyEClass, JAVA_PROPERTY__IS_STATIC);
		createEAttribute(javaPropertyEClass, JAVA_PROPERTY__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS);
		createEReference(javaPropertyEClass, JAVA_PROPERTY__EXPLICIT_REQUIRED_IMPORTS);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__IMPLEMENTATION_CLASS);
		createEReference(primitiveTypeEClass, PRIMITIVE_TYPE__BASE_PRIMITIVE_TYPE);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__COLLECTION_IMPLEMENTATION_CLASS);

		javaProjectEClass = createEClass(JAVA_PROJECT);
		createEReference(javaProjectEClass, JAVA_PROJECT__BASE_PACKAGE);

		javaSrcFolderEClass = createEClass(JAVA_SRC_FOLDER);
		createEReference(javaSrcFolderEClass, JAVA_SRC_FOLDER__BASE_PACKAGE);

		// Create enums
		trueFalseDefaultEEnum = createEEnum(TRUE_FALSE_DEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		javaClassEClass.getESuperTypes().add(this.getJavaGen());
		javaGenEClass.getESuperTypes().add(this.getJavaNamedElement());
		javaPackage_EClass.getESuperTypes().add(this.getJavaGen());
		javaMethodEClass.getESuperTypes().add(this.getJavaNamedElement());
		javaParameterEClass.getESuperTypes().add(this.getJavaNamedElement());
		javaPropertyEClass.getESuperTypes().add(this.getJavaNamedElement());
		primitiveTypeEClass.getESuperTypes().add(this.getJavaGen());
		javaProjectEClass.getESuperTypes().add(this.getJavaGen());
		javaSrcFolderEClass.getESuperTypes().add(this.getJavaGen());

		// Initialize classes and features; add operations and parameters
		initEClass(javaClassEClass, JavaClass.class, "JavaClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaClass_Base_Classifier(), theUMLPackage.getClassifier(), null, "base_Classifier", null, 1, 1, JavaClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaClass_IsFinal(), ecorePackage.getEBoolean(), "isFinal", null, 1, 1, JavaClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaClass_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, JavaClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaClass_IsStatic(), ecorePackage.getEBoolean(), "isStatic", null, 1, 1, JavaClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaClass_ExplicitPlainTextRequiredImports(), ecorePackage.getEString(), "explicitPlainTextRequiredImports", null, 0, -1, JavaClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJavaClass_ExplicitRequiredImports(), theUMLPackage.getClassifier(), null, "explicitRequiredImports", null, 0, -1, JavaClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaGenEClass, JavaGen.class, "JavaGen", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaGen_SrcName(), ecorePackage.getEString(), "srcName", null, 1, 1, JavaGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaGen_ProjectName(), ecorePackage.getEString(), "projectName", null, 1, 1, JavaGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaNamedElementEClass, JavaNamedElement.class, "JavaNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, JavaNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaNamedElement_Author(), ecorePackage.getEString(), "author", null, 1, 1, JavaNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaNamedElement_Version(), ecorePackage.getEString(), "version", null, 1, 1, JavaNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaNamedElement_Comment(), ecorePackage.getEString(), "comment", null, 1, 1, JavaNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaNamedElement_IsGenerated(), ecorePackage.getEBoolean(), "isGenerated", "true", 1, 1, JavaNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaPackage_EClass, JavaPackage_.class, "JavaPackage_", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaPackage__PackageName(), ecorePackage.getEString(), "packageName", null, 1, 1, JavaPackage_.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJavaPackage__Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, JavaPackage_.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaMethodEClass, JavaMethod.class, "JavaMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaMethod_IsStatic(), ecorePackage.getEBoolean(), "isStatic", null, 1, 1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaMethod_IsFinal(), ecorePackage.getEBoolean(), "isFinal", null, 1, 1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaMethod_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaMethod_IsNative(), ecorePackage.getEBoolean(), "isNative", null, 1, 1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaMethod_IsSynchronized(), ecorePackage.getEBoolean(), "isSynchronized", null, 1, 1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaMethod_IsConstructor(), ecorePackage.getEBoolean(), "isConstructor", null, 1, 1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJavaMethod_Base_Operation(), theUMLPackage.getOperation(), null, "base_Operation", null, 1, 1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaMethod_ExplicitPlainTextRequiredImports(), ecorePackage.getEString(), "explicitPlainTextRequiredImports", null, 0, -1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJavaMethod_ExplicitRequiredImports(), theUMLPackage.getClassifier(), null, "explicitRequiredImports", null, 0, -1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaParameterEClass, JavaParameter.class, "JavaParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaParameter_IsFinal(), ecorePackage.getEBoolean(), "isFinal", null, 1, 1, JavaParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJavaParameter_Base_Parameter(), theUMLPackage.getParameter(), null, "base_Parameter", null, 1, 1, JavaParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaPropertyEClass, JavaProperty.class, "JavaProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaProperty_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaProperty_IsFinal(), ecorePackage.getEBoolean(), "isFinal", null, 1, 1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJavaProperty_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaProperty_IsTransient(), ecorePackage.getEBoolean(), "isTransient", null, 1, 1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaProperty_GenerateGetter(), this.getTrueFalseDefault(), "generateGetter", "default", 1, 1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaProperty_GenerateSetter(), this.getTrueFalseDefault(), "generateSetter", "default", 1, 1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaProperty_IsStatic(), ecorePackage.getEBoolean(), "isStatic", null, 1, 1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaProperty_ExplicitPlainTextRequiredImports(), ecorePackage.getEString(), "explicitPlainTextRequiredImports", null, 0, -1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJavaProperty_ExplicitRequiredImports(), theUMLPackage.getClassifier(), null, "explicitRequiredImports", null, 0, -1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveType_ImplementationClass(), ecorePackage.getEString(), "implementationClass", null, 1, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPrimitiveType_Base_PrimitiveType(), theUMLPackage.getPrimitiveType(), null, "base_PrimitiveType", null, 1, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPrimitiveType_CollectionImplementationClass(), ecorePackage.getEString(), "collectionImplementationClass", null, 1, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaProjectEClass, JavaProject.class, "JavaProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaProject_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, JavaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaSrcFolderEClass, JavaSrcFolder.class, "JavaSrcFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaSrcFolder_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, JavaSrcFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(trueFalseDefaultEEnum, TrueFalseDefault.class, "TrueFalseDefault");
		addEEnumLiteral(trueFalseDefaultEEnum, TrueFalseDefault.TRUE);
		addEEnumLiteral(trueFalseDefaultEEnum, TrueFalseDefault.FALSE);
		addEEnumLiteral(trueFalseDefaultEEnum, TrueFalseDefault.DEFAULT);

		// Create resource
		createResource(eNS_URI);
	}

} //JavaPackageImpl
