/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java;

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
 * @see org.eclipse.papyrus.java.profile.java.JavaFactory
 * @model kind="package"
 * @generated
 */
public interface JavaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "java";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/JAVA/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "java";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavaPackage eINSTANCE = org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaNamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaNamedElementImpl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaNamedElement()
	 * @generated
	 */
	int JAVA_NAMED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAMED_ELEMENT__AUTHOR = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAMED_ELEMENT__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAMED_ELEMENT__COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAMED_ELEMENT__IS_GENERATED = 4;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAMED_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaGenImpl <em>Gen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaGenImpl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaGen()
	 * @generated
	 */
	int JAVA_GEN = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN__NAME = JAVA_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN__AUTHOR = JAVA_NAMED_ELEMENT__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN__VERSION = JAVA_NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN__COMMENT = JAVA_NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN__IS_GENERATED = JAVA_NAMED_ELEMENT__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Src Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN__SRC_NAME = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN__PROJECT_NAME = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN_FEATURE_COUNT = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaClass()
	 * @generated
	 */
	int JAVA_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__NAME = JAVA_GEN__NAME;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__AUTHOR = JAVA_GEN__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__VERSION = JAVA_GEN__VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__COMMENT = JAVA_GEN__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__IS_GENERATED = JAVA_GEN__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Src Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__SRC_NAME = JAVA_GEN__SRC_NAME;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__PROJECT_NAME = JAVA_GEN__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__BASE_CLASSIFIER = JAVA_GEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__IS_FINAL = JAVA_GEN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__IS_ABSTRACT = JAVA_GEN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__IS_STATIC = JAVA_GEN_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS_FEATURE_COUNT = JAVA_GEN_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaPackage_Impl <em>Package </em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackage_Impl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaPackage_()
	 * @generated
	 */
	int JAVA_PACKAGE_ = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE___NAME = JAVA_GEN__NAME;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE___AUTHOR = JAVA_GEN__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE___VERSION = JAVA_GEN__VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE___COMMENT = JAVA_GEN__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE___IS_GENERATED = JAVA_GEN__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Src Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE___SRC_NAME = JAVA_GEN__SRC_NAME;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE___PROJECT_NAME = JAVA_GEN__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE___PACKAGE_NAME = JAVA_GEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE___BASE_PACKAGE = JAVA_GEN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE__FEATURE_COUNT = JAVA_GEN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaMethod()
	 * @generated
	 */
	int JAVA_METHOD = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__NAME = JAVA_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__AUTHOR = JAVA_NAMED_ELEMENT__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__VERSION = JAVA_NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__COMMENT = JAVA_NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__IS_GENERATED = JAVA_NAMED_ELEMENT__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__IS_STATIC = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__IS_FINAL = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__IS_ABSTRACT = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__IS_NATIVE = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__IS_SYNCHRONIZED = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__IS_CONSTRUCTOR = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__BASE_OPERATION = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_FEATURE_COUNT = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaParameterImpl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaParameter()
	 * @generated
	 */
	int JAVA_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PARAMETER__NAME = JAVA_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PARAMETER__AUTHOR = JAVA_NAMED_ELEMENT__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PARAMETER__VERSION = JAVA_NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PARAMETER__COMMENT = JAVA_NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PARAMETER__IS_GENERATED = JAVA_NAMED_ELEMENT__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PARAMETER__IS_FINAL = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PARAMETER__BASE_PARAMETER = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PARAMETER_FEATURE_COUNT = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaProperty()
	 * @generated
	 */
	int JAVA_PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__NAME = JAVA_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__AUTHOR = JAVA_NAMED_ELEMENT__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__VERSION = JAVA_NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__COMMENT = JAVA_NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__IS_GENERATED = JAVA_NAMED_ELEMENT__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__IS_ABSTRACT = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__IS_FINAL = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__BASE_PROPERTY = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__IS_TRANSIENT = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Generate Getter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__GENERATE_GETTER = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Generate Setter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__GENERATE_SETTER = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__IS_STATIC = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY_FEATURE_COUNT = JAVA_NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.PrimitiveTypeImpl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = JAVA_GEN__NAME;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__AUTHOR = JAVA_GEN__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__VERSION = JAVA_GEN__VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__COMMENT = JAVA_GEN__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_GENERATED = JAVA_GEN__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Src Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__SRC_NAME = JAVA_GEN__SRC_NAME;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__PROJECT_NAME = JAVA_GEN__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IMPLEMENTATION_CLASS = JAVA_GEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Primitive Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__BASE_PRIMITIVE_TYPE = JAVA_GEN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Collection Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__COLLECTION_IMPLEMENTATION_CLASS = JAVA_GEN_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = JAVA_GEN_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaProjectImpl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaProject()
	 * @generated
	 */
	int JAVA_PROJECT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROJECT__NAME = JAVA_GEN__NAME;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROJECT__AUTHOR = JAVA_GEN__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROJECT__VERSION = JAVA_GEN__VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROJECT__COMMENT = JAVA_GEN__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROJECT__IS_GENERATED = JAVA_GEN__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Src Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROJECT__SRC_NAME = JAVA_GEN__SRC_NAME;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROJECT__PROJECT_NAME = JAVA_GEN__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROJECT__BASE_PACKAGE = JAVA_GEN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROJECT_FEATURE_COUNT = JAVA_GEN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaSrcFolderImpl <em>Src Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaSrcFolderImpl
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaSrcFolder()
	 * @generated
	 */
	int JAVA_SRC_FOLDER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SRC_FOLDER__NAME = JAVA_GEN__NAME;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SRC_FOLDER__AUTHOR = JAVA_GEN__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SRC_FOLDER__VERSION = JAVA_GEN__VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SRC_FOLDER__COMMENT = JAVA_GEN__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SRC_FOLDER__IS_GENERATED = JAVA_GEN__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Src Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SRC_FOLDER__SRC_NAME = JAVA_GEN__SRC_NAME;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SRC_FOLDER__PROJECT_NAME = JAVA_GEN__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SRC_FOLDER__BASE_PACKAGE = JAVA_GEN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Src Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SRC_FOLDER_FEATURE_COUNT = JAVA_GEN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.profile.java.TrueFalseDefault <em>True False Default</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.profile.java.TrueFalseDefault
	 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getTrueFalseDefault()
	 * @generated
	 */
	int TRUE_FALSE_DEFAULT = 10;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.JavaClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaClass
	 * @generated
	 */
	EClass getJavaClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.profile.java.JavaClass#getBase_Classifier <em>Base Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Classifier</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaClass#getBase_Classifier()
	 * @see #getJavaClass()
	 * @generated
	 */
	EReference getJavaClass_Base_Classifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaClass#isFinal <em>Is Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Final</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaClass#isFinal()
	 * @see #getJavaClass()
	 * @generated
	 */
	EAttribute getJavaClass_IsFinal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaClass#isAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaClass#isAbstract()
	 * @see #getJavaClass()
	 * @generated
	 */
	EAttribute getJavaClass_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaClass#isStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaClass#isStatic()
	 * @see #getJavaClass()
	 * @generated
	 */
	EAttribute getJavaClass_IsStatic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.JavaGen <em>Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaGen
	 * @generated
	 */
	EClass getJavaGen();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaGen#getSrcName <em>Src Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Name</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaGen#getSrcName()
	 * @see #getJavaGen()
	 * @generated
	 */
	EAttribute getJavaGen_SrcName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaGen#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaGen#getProjectName()
	 * @see #getJavaGen()
	 * @generated
	 */
	EAttribute getJavaGen_ProjectName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.JavaNamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaNamedElement
	 * @generated
	 */
	EClass getJavaNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaNamedElement#getName()
	 * @see #getJavaNamedElement()
	 * @generated
	 */
	EAttribute getJavaNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaNamedElement#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaNamedElement#getAuthor()
	 * @see #getJavaNamedElement()
	 * @generated
	 */
	EAttribute getJavaNamedElement_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaNamedElement#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaNamedElement#getVersion()
	 * @see #getJavaNamedElement()
	 * @generated
	 */
	EAttribute getJavaNamedElement_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaNamedElement#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaNamedElement#getComment()
	 * @see #getJavaNamedElement()
	 * @generated
	 */
	EAttribute getJavaNamedElement_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaNamedElement#isGenerated <em>Is Generated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Generated</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaNamedElement#isGenerated()
	 * @see #getJavaNamedElement()
	 * @generated
	 */
	EAttribute getJavaNamedElement_IsGenerated();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.JavaPackage_ <em>Package </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package </em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage_
	 * @generated
	 */
	EClass getJavaPackage_();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaPackage_#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage_#getPackageName()
	 * @see #getJavaPackage_()
	 * @generated
	 */
	EAttribute getJavaPackage__PackageName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.profile.java.JavaPackage_#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage_#getBase_Package()
	 * @see #getJavaPackage_()
	 * @generated
	 */
	EReference getJavaPackage__Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.JavaMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaMethod
	 * @generated
	 */
	EClass getJavaMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaMethod#isStatic()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_IsStatic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isFinal <em>Is Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Final</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaMethod#isFinal()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_IsFinal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaMethod#isAbstract()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isNative <em>Is Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Native</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaMethod#isNative()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_IsNative();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isSynchronized <em>Is Synchronized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Synchronized</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaMethod#isSynchronized()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_IsSynchronized();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isConstructor <em>Is Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Constructor</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaMethod#isConstructor()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_IsConstructor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaMethod#getBase_Operation()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EReference getJavaMethod_Base_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.JavaParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaParameter
	 * @generated
	 */
	EClass getJavaParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaParameter#isFinal <em>Is Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Final</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaParameter#isFinal()
	 * @see #getJavaParameter()
	 * @generated
	 */
	EAttribute getJavaParameter_IsFinal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.profile.java.JavaParameter#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaParameter#getBase_Parameter()
	 * @see #getJavaParameter()
	 * @generated
	 */
	EReference getJavaParameter_Base_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.JavaProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProperty
	 * @generated
	 */
	EClass getJavaProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProperty#isAbstract()
	 * @see #getJavaProperty()
	 * @generated
	 */
	EAttribute getJavaProperty_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isFinal <em>Is Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Final</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProperty#isFinal()
	 * @see #getJavaProperty()
	 * @generated
	 */
	EAttribute getJavaProperty_IsFinal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProperty#getBase_Property()
	 * @see #getJavaProperty()
	 * @generated
	 */
	EReference getJavaProperty_Base_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isTransient <em>Is Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transient</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProperty#isTransient()
	 * @see #getJavaProperty()
	 * @generated
	 */
	EAttribute getJavaProperty_IsTransient();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getGenerateGetter <em>Generate Getter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate Getter</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProperty#getGenerateGetter()
	 * @see #getJavaProperty()
	 * @generated
	 */
	EAttribute getJavaProperty_GenerateGetter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getGenerateSetter <em>Generate Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate Setter</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProperty#getGenerateSetter()
	 * @see #getJavaProperty()
	 * @generated
	 */
	EAttribute getJavaProperty_GenerateSetter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProperty#isStatic()
	 * @see #getJavaProperty()
	 * @generated
	 */
	EAttribute getJavaProperty_IsStatic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.PrimitiveType#getImplementationClass <em>Implementation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Class</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.PrimitiveType#getImplementationClass()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_ImplementationClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.profile.java.PrimitiveType#getBase_PrimitiveType <em>Base Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Primitive Type</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.PrimitiveType#getBase_PrimitiveType()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EReference getPrimitiveType_Base_PrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.profile.java.PrimitiveType#getCollectionImplementationClass <em>Collection Implementation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Implementation Class</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.PrimitiveType#getCollectionImplementationClass()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_CollectionImplementationClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.JavaProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProject
	 * @generated
	 */
	EClass getJavaProject();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.profile.java.JavaProject#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaProject#getBase_Package()
	 * @see #getJavaProject()
	 * @generated
	 */
	EReference getJavaProject_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.profile.java.JavaSrcFolder <em>Src Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Src Folder</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaSrcFolder
	 * @generated
	 */
	EClass getJavaSrcFolder();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.profile.java.JavaSrcFolder#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.JavaSrcFolder#getBase_Package()
	 * @see #getJavaSrcFolder()
	 * @generated
	 */
	EReference getJavaSrcFolder_Base_Package();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.java.profile.java.TrueFalseDefault <em>True False Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>True False Default</em>'.
	 * @see org.eclipse.papyrus.java.profile.java.TrueFalseDefault
	 * @generated
	 */
	EEnum getTrueFalseDefault();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavaFactory getJavaFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaClass()
		 * @generated
		 */
		EClass JAVA_CLASS = eINSTANCE.getJavaClass();

		/**
		 * The meta object literal for the '<em><b>Base Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_CLASS__BASE_CLASSIFIER = eINSTANCE.getJavaClass_Base_Classifier();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_CLASS__IS_FINAL = eINSTANCE.getJavaClass_IsFinal();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_CLASS__IS_ABSTRACT = eINSTANCE.getJavaClass_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_CLASS__IS_STATIC = eINSTANCE.getJavaClass_IsStatic();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaGenImpl <em>Gen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaGenImpl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaGen()
		 * @generated
		 */
		EClass JAVA_GEN = eINSTANCE.getJavaGen();

		/**
		 * The meta object literal for the '<em><b>Src Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_GEN__SRC_NAME = eINSTANCE.getJavaGen_SrcName();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_GEN__PROJECT_NAME = eINSTANCE.getJavaGen_ProjectName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaNamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaNamedElementImpl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaNamedElement()
		 * @generated
		 */
		EClass JAVA_NAMED_ELEMENT = eINSTANCE.getJavaNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_NAMED_ELEMENT__NAME = eINSTANCE.getJavaNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_NAMED_ELEMENT__AUTHOR = eINSTANCE.getJavaNamedElement_Author();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_NAMED_ELEMENT__VERSION = eINSTANCE.getJavaNamedElement_Version();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_NAMED_ELEMENT__COMMENT = eINSTANCE.getJavaNamedElement_Comment();

		/**
		 * The meta object literal for the '<em><b>Is Generated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_NAMED_ELEMENT__IS_GENERATED = eINSTANCE.getJavaNamedElement_IsGenerated();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaPackage_Impl <em>Package </em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackage_Impl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaPackage_()
		 * @generated
		 */
		EClass JAVA_PACKAGE_ = eINSTANCE.getJavaPackage_();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PACKAGE___PACKAGE_NAME = eINSTANCE.getJavaPackage__PackageName();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_PACKAGE___BASE_PACKAGE = eINSTANCE.getJavaPackage__Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaMethod()
		 * @generated
		 */
		EClass JAVA_METHOD = eINSTANCE.getJavaMethod();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__IS_STATIC = eINSTANCE.getJavaMethod_IsStatic();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__IS_FINAL = eINSTANCE.getJavaMethod_IsFinal();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__IS_ABSTRACT = eINSTANCE.getJavaMethod_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__IS_NATIVE = eINSTANCE.getJavaMethod_IsNative();

		/**
		 * The meta object literal for the '<em><b>Is Synchronized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__IS_SYNCHRONIZED = eINSTANCE.getJavaMethod_IsSynchronized();

		/**
		 * The meta object literal for the '<em><b>Is Constructor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__IS_CONSTRUCTOR = eINSTANCE.getJavaMethod_IsConstructor();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_METHOD__BASE_OPERATION = eINSTANCE.getJavaMethod_Base_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaParameterImpl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaParameter()
		 * @generated
		 */
		EClass JAVA_PARAMETER = eINSTANCE.getJavaParameter();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PARAMETER__IS_FINAL = eINSTANCE.getJavaParameter_IsFinal();

		/**
		 * The meta object literal for the '<em><b>Base Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_PARAMETER__BASE_PARAMETER = eINSTANCE.getJavaParameter_Base_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaProperty()
		 * @generated
		 */
		EClass JAVA_PROPERTY = eINSTANCE.getJavaProperty();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PROPERTY__IS_ABSTRACT = eINSTANCE.getJavaProperty_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PROPERTY__IS_FINAL = eINSTANCE.getJavaProperty_IsFinal();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_PROPERTY__BASE_PROPERTY = eINSTANCE.getJavaProperty_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Is Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PROPERTY__IS_TRANSIENT = eINSTANCE.getJavaProperty_IsTransient();

		/**
		 * The meta object literal for the '<em><b>Generate Getter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PROPERTY__GENERATE_GETTER = eINSTANCE.getJavaProperty_GenerateGetter();

		/**
		 * The meta object literal for the '<em><b>Generate Setter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PROPERTY__GENERATE_SETTER = eINSTANCE.getJavaProperty_GenerateSetter();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PROPERTY__IS_STATIC = eINSTANCE.getJavaProperty_IsStatic();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.PrimitiveTypeImpl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Implementation Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__IMPLEMENTATION_CLASS = eINSTANCE.getPrimitiveType_ImplementationClass();

		/**
		 * The meta object literal for the '<em><b>Base Primitive Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE__BASE_PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType_Base_PrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Collection Implementation Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__COLLECTION_IMPLEMENTATION_CLASS = eINSTANCE.getPrimitiveType_CollectionImplementationClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaProjectImpl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaProject()
		 * @generated
		 */
		EClass JAVA_PROJECT = eINSTANCE.getJavaProject();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_PROJECT__BASE_PACKAGE = eINSTANCE.getJavaProject_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.impl.JavaSrcFolderImpl <em>Src Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaSrcFolderImpl
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getJavaSrcFolder()
		 * @generated
		 */
		EClass JAVA_SRC_FOLDER = eINSTANCE.getJavaSrcFolder();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_SRC_FOLDER__BASE_PACKAGE = eINSTANCE.getJavaSrcFolder_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.profile.java.TrueFalseDefault <em>True False Default</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.profile.java.TrueFalseDefault
		 * @see org.eclipse.papyrus.java.profile.java.impl.JavaPackageImpl#getTrueFalseDefault()
		 * @generated
		 */
		EEnum TRUE_FALSE_DEFAULT = eINSTANCE.getTrueFalseDefault();

	}

} //JavaPackage
