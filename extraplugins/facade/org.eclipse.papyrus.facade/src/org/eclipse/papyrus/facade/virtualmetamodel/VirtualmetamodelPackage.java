/**
 */
package org.eclipse.papyrus.facade.virtualmetamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface VirtualmetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "virtualmetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/virtualmetamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "virtualmetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VirtualmetamodelPackage eINSTANCE = org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetamodelImpl <em>Virtual Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetamodelImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualMetamodel()
	 * @generated
	 */
	int VIRTUAL_METAMODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METAMODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METAMODEL__NS_PREFIX = 1;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METAMODEL__NS_URI = 2;

	/**
	 * The feature id for the '<em><b>Virtual Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS = 3;

	/**
	 * The feature id for the '<em><b>Facade</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METAMODEL__FACADE = 4;

	/**
	 * The number of structural features of the '<em>Virtual Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METAMODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Virtual Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METAMODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualElementImpl <em>Virtual Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualElementImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualElement()
	 * @generated
	 */
	int VIRTUAL_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ELEMENT__ALIAS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ELEMENT__KEPT = 1;

	/**
	 * The feature id for the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ELEMENT__REPRESENTED_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Virtual Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Virtual Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualClassifierImpl <em>Virtual Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualClassifierImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualClassifier()
	 * @generated
	 */
	int VIRTUAL_CLASSIFIER = 2;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_CLASSIFIER__ALIAS_NAME = VIRTUAL_ELEMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_CLASSIFIER__KEPT = VIRTUAL_ELEMENT__KEPT;

	/**
	 * The feature id for the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_CLASSIFIER__REPRESENTED_ELEMENT = VIRTUAL_ELEMENT__REPRESENTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_CLASSIFIER__METAMODEL = VIRTUAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Virtual Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_CLASSIFIER_FEATURE_COUNT = VIRTUAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Virtual Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_CLASSIFIER_OPERATION_COUNT = VIRTUAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl <em>Virtual Metaclass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualMetaclass()
	 * @generated
	 */
	int VIRTUAL_METACLASS = 3;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__ALIAS_NAME = VIRTUAL_CLASSIFIER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__KEPT = VIRTUAL_CLASSIFIER__KEPT;

	/**
	 * The feature id for the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__REPRESENTED_ELEMENT = VIRTUAL_CLASSIFIER__REPRESENTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__METAMODEL = VIRTUAL_CLASSIFIER__METAMODEL;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__ABSTRACT = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Applied Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__APPLIED_STEREOTYPES = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__OPERATIONS = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__PARENTS = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__PROPERTIES = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Stereotype Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS__STEREOTYPE_INTERFACE = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Virtual Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS_FEATURE_COUNT = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Virtual Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_METACLASS_OPERATION_COUNT = VIRTUAL_CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualPropertyImpl <em>Virtual Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualPropertyImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualProperty()
	 * @generated
	 */
	int VIRTUAL_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PROPERTY__ALIAS_NAME = VIRTUAL_ELEMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PROPERTY__KEPT = VIRTUAL_ELEMENT__KEPT;

	/**
	 * The feature id for the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PROPERTY__REPRESENTED_ELEMENT = VIRTUAL_ELEMENT__REPRESENTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PROPERTY__LOWER = VIRTUAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PROPERTY__UPPER = VIRTUAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Virtual Metaclass</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PROPERTY__VIRTUAL_METACLASS = VIRTUAL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Virtual Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PROPERTY_FEATURE_COUNT = VIRTUAL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Virtual Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PROPERTY_OPERATION_COUNT = VIRTUAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualOperationImpl <em>Virtual Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualOperationImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualOperation()
	 * @generated
	 */
	int VIRTUAL_OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_OPERATION__ALIAS_NAME = VIRTUAL_ELEMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_OPERATION__KEPT = VIRTUAL_ELEMENT__KEPT;

	/**
	 * The feature id for the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_OPERATION__REPRESENTED_ELEMENT = VIRTUAL_ELEMENT__REPRESENTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_OPERATION__PARAMETERS = VIRTUAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Virtual Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_OPERATION_FEATURE_COUNT = VIRTUAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Virtual Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_OPERATION_OPERATION_COUNT = VIRTUAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualParameterImpl <em>Virtual Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualParameterImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualParameter()
	 * @generated
	 */
	int VIRTUAL_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PARAMETER__ALIAS_NAME = VIRTUAL_ELEMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PARAMETER__KEPT = VIRTUAL_ELEMENT__KEPT;

	/**
	 * The feature id for the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PARAMETER__REPRESENTED_ELEMENT = VIRTUAL_ELEMENT__REPRESENTED_ELEMENT;

	/**
	 * The number of structural features of the '<em>Virtual Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PARAMETER_FEATURE_COUNT = VIRTUAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Virtual Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_PARAMETER_OPERATION_COUNT = VIRTUAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualDatatypeImpl <em>Virtual Datatype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualDatatypeImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualDatatype()
	 * @generated
	 */
	int VIRTUAL_DATATYPE = 7;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DATATYPE__ALIAS_NAME = VIRTUAL_CLASSIFIER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DATATYPE__KEPT = VIRTUAL_CLASSIFIER__KEPT;

	/**
	 * The feature id for the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DATATYPE__REPRESENTED_ELEMENT = VIRTUAL_CLASSIFIER__REPRESENTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DATATYPE__METAMODEL = VIRTUAL_CLASSIFIER__METAMODEL;

	/**
	 * The number of structural features of the '<em>Virtual Datatype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DATATYPE_FEATURE_COUNT = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Virtual Datatype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DATATYPE_OPERATION_COUNT = VIRTUAL_CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualEnumImpl <em>Virtual Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualEnumImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualEnum()
	 * @generated
	 */
	int VIRTUAL_ENUM = 8;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ENUM__ALIAS_NAME = VIRTUAL_CLASSIFIER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ENUM__KEPT = VIRTUAL_CLASSIFIER__KEPT;

	/**
	 * The feature id for the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ENUM__REPRESENTED_ELEMENT = VIRTUAL_CLASSIFIER__REPRESENTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ENUM__METAMODEL = VIRTUAL_CLASSIFIER__METAMODEL;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ENUM__LITERALS = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Virtual Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ENUM_FEATURE_COUNT = VIRTUAL_CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Virtual Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ENUM_OPERATION_COUNT = VIRTUAL_CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualLiteralImpl <em>Virtual Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualLiteralImpl
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualLiteral()
	 * @generated
	 */
	int VIRTUAL_LITERAL = 9;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_LITERAL__ALIAS_NAME = VIRTUAL_ELEMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_LITERAL__KEPT = VIRTUAL_ELEMENT__KEPT;

	/**
	 * The feature id for the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_LITERAL__REPRESENTED_ELEMENT = VIRTUAL_ELEMENT__REPRESENTED_ELEMENT;

	/**
	 * The number of structural features of the '<em>Virtual Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_LITERAL_FEATURE_COUNT = VIRTUAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Virtual Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_LITERAL_OPERATION_COUNT = VIRTUAL_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel <em>Virtual Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Metamodel</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel
	 * @generated
	 */
	EClass getVirtualMetamodel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getName()
	 * @see #getVirtualMetamodel()
	 * @generated
	 */
	EAttribute getVirtualMetamodel_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getNsPrefix()
	 * @see #getVirtualMetamodel()
	 * @generated
	 */
	EAttribute getVirtualMetamodel_NsPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getNsURI()
	 * @see #getVirtualMetamodel()
	 * @generated
	 */
	EAttribute getVirtualMetamodel_NsURI();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getVirtualClassifiers <em>Virtual Classifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Virtual Classifiers</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getVirtualClassifiers()
	 * @see #getVirtualMetamodel()
	 * @generated
	 */
	EReference getVirtualMetamodel_VirtualClassifiers();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getFacade <em>Facade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Facade</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getFacade()
	 * @see #getVirtualMetamodel()
	 * @generated
	 */
	EReference getVirtualMetamodel_Facade();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement <em>Virtual Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Element</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement
	 * @generated
	 */
	EClass getVirtualElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#getAliasName <em>Alias Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias Name</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#getAliasName()
	 * @see #getVirtualElement()
	 * @generated
	 */
	EAttribute getVirtualElement_AliasName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#isKept <em>Kept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kept</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#isKept()
	 * @see #getVirtualElement()
	 * @generated
	 */
	EAttribute getVirtualElement_Kept();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#getRepresentedElement <em>Represented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Represented Element</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#getRepresentedElement()
	 * @see #getVirtualElement()
	 * @generated
	 */
	EReference getVirtualElement_RepresentedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier <em>Virtual Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Classifier</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier
	 * @generated
	 */
	EClass getVirtualClassifier();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Metamodel</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier#getMetamodel()
	 * @see #getVirtualClassifier()
	 * @generated
	 */
	EReference getVirtualClassifier_Metamodel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass <em>Virtual Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Metaclass</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass
	 * @generated
	 */
	EClass getVirtualMetaclass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#isAbstract()
	 * @see #getVirtualMetaclass()
	 * @generated
	 */
	EAttribute getVirtualMetaclass_Abstract();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getAppliedStereotypes <em>Applied Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Applied Stereotypes</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getAppliedStereotypes()
	 * @see #getVirtualMetaclass()
	 * @generated
	 */
	EReference getVirtualMetaclass_AppliedStereotypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getOperations()
	 * @see #getVirtualMetaclass()
	 * @generated
	 */
	EReference getVirtualMetaclass_Operations();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parents</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getParents()
	 * @see #getVirtualMetaclass()
	 * @generated
	 */
	EReference getVirtualMetaclass_Parents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getProperties()
	 * @see #getVirtualMetaclass()
	 * @generated
	 */
	EReference getVirtualMetaclass_Properties();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#isStereotypeInterface <em>Stereotype Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype Interface</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#isStereotypeInterface()
	 * @see #getVirtualMetaclass()
	 * @generated
	 */
	EAttribute getVirtualMetaclass_StereotypeInterface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty <em>Virtual Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Property</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty
	 * @generated
	 */
	EClass getVirtualProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getLower()
	 * @see #getVirtualProperty()
	 * @generated
	 */
	EAttribute getVirtualProperty_Lower();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getUpper()
	 * @see #getVirtualProperty()
	 * @generated
	 */
	EAttribute getVirtualProperty_Upper();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getVirtualMetaclass <em>Virtual Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Virtual Metaclass</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getVirtualMetaclass()
	 * @see #getVirtualProperty()
	 * @generated
	 */
	EReference getVirtualProperty_VirtualMetaclass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation <em>Virtual Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Operation</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation
	 * @generated
	 */
	EClass getVirtualOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation#getParameters()
	 * @see #getVirtualOperation()
	 * @generated
	 */
	EReference getVirtualOperation_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter <em>Virtual Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Parameter</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter
	 * @generated
	 */
	EClass getVirtualParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype <em>Virtual Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Datatype</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype
	 * @generated
	 */
	EClass getVirtualDatatype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum <em>Virtual Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Enum</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum
	 * @generated
	 */
	EClass getVirtualEnum();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum#getLiterals()
	 * @see #getVirtualEnum()
	 * @generated
	 */
	EReference getVirtualEnum_Literals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral <em>Virtual Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Literal</em>'.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral
	 * @generated
	 */
	EClass getVirtualLiteral();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VirtualmetamodelFactory getVirtualmetamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetamodelImpl <em>Virtual Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetamodelImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualMetamodel()
		 * @generated
		 */
		EClass VIRTUAL_METAMODEL = eINSTANCE.getVirtualMetamodel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_METAMODEL__NAME = eINSTANCE.getVirtualMetamodel_Name();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_METAMODEL__NS_PREFIX = eINSTANCE.getVirtualMetamodel_NsPrefix();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_METAMODEL__NS_URI = eINSTANCE.getVirtualMetamodel_NsURI();

		/**
		 * The meta object literal for the '<em><b>Virtual Classifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS = eINSTANCE.getVirtualMetamodel_VirtualClassifiers();

		/**
		 * The meta object literal for the '<em><b>Facade</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_METAMODEL__FACADE = eINSTANCE.getVirtualMetamodel_Facade();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualElementImpl <em>Virtual Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualElementImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualElement()
		 * @generated
		 */
		EClass VIRTUAL_ELEMENT = eINSTANCE.getVirtualElement();

		/**
		 * The meta object literal for the '<em><b>Alias Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_ELEMENT__ALIAS_NAME = eINSTANCE.getVirtualElement_AliasName();

		/**
		 * The meta object literal for the '<em><b>Kept</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_ELEMENT__KEPT = eINSTANCE.getVirtualElement_Kept();

		/**
		 * The meta object literal for the '<em><b>Represented Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_ELEMENT__REPRESENTED_ELEMENT = eINSTANCE.getVirtualElement_RepresentedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualClassifierImpl <em>Virtual Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualClassifierImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualClassifier()
		 * @generated
		 */
		EClass VIRTUAL_CLASSIFIER = eINSTANCE.getVirtualClassifier();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_CLASSIFIER__METAMODEL = eINSTANCE.getVirtualClassifier_Metamodel();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl <em>Virtual Metaclass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualMetaclass()
		 * @generated
		 */
		EClass VIRTUAL_METACLASS = eINSTANCE.getVirtualMetaclass();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_METACLASS__ABSTRACT = eINSTANCE.getVirtualMetaclass_Abstract();

		/**
		 * The meta object literal for the '<em><b>Applied Stereotypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_METACLASS__APPLIED_STEREOTYPES = eINSTANCE.getVirtualMetaclass_AppliedStereotypes();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_METACLASS__OPERATIONS = eINSTANCE.getVirtualMetaclass_Operations();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_METACLASS__PARENTS = eINSTANCE.getVirtualMetaclass_Parents();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_METACLASS__PROPERTIES = eINSTANCE.getVirtualMetaclass_Properties();

		/**
		 * The meta object literal for the '<em><b>Stereotype Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_METACLASS__STEREOTYPE_INTERFACE = eINSTANCE.getVirtualMetaclass_StereotypeInterface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualPropertyImpl <em>Virtual Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualPropertyImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualProperty()
		 * @generated
		 */
		EClass VIRTUAL_PROPERTY = eINSTANCE.getVirtualProperty();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_PROPERTY__LOWER = eINSTANCE.getVirtualProperty_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_PROPERTY__UPPER = eINSTANCE.getVirtualProperty_Upper();

		/**
		 * The meta object literal for the '<em><b>Virtual Metaclass</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_PROPERTY__VIRTUAL_METACLASS = eINSTANCE.getVirtualProperty_VirtualMetaclass();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualOperationImpl <em>Virtual Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualOperationImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualOperation()
		 * @generated
		 */
		EClass VIRTUAL_OPERATION = eINSTANCE.getVirtualOperation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_OPERATION__PARAMETERS = eINSTANCE.getVirtualOperation_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualParameterImpl <em>Virtual Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualParameterImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualParameter()
		 * @generated
		 */
		EClass VIRTUAL_PARAMETER = eINSTANCE.getVirtualParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualDatatypeImpl <em>Virtual Datatype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualDatatypeImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualDatatype()
		 * @generated
		 */
		EClass VIRTUAL_DATATYPE = eINSTANCE.getVirtualDatatype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualEnumImpl <em>Virtual Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualEnumImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualEnum()
		 * @generated
		 */
		EClass VIRTUAL_ENUM = eINSTANCE.getVirtualEnum();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_ENUM__LITERALS = eINSTANCE.getVirtualEnum_Literals();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualLiteralImpl <em>Virtual Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualLiteralImpl
		 * @see org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelPackageImpl#getVirtualLiteral()
		 * @generated
		 */
		EClass VIRTUAL_LITERAL = eINSTANCE.getVirtualLiteral();

	}

} //VirtualmetamodelPackage
