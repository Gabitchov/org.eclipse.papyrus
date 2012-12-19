/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation;

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
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationFactory
 * @model kind="package"
 * @generated
 */
public interface OperationPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "operation";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/operation/xtext/Operation";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "operation";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  OperationPackage eINSTANCE = org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDefinitionOrStubImpl <em>Definition Or Stub</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDefinitionOrStubImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getOperationDefinitionOrStub()
   * @generated
   */
  int OPERATION_DEFINITION_OR_STUB = 0;

  /**
   * The feature id for the '<em><b>Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION_OR_STUB__DECLARATION = 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION_OR_STUB__BODY = 1;

  /**
   * The number of structural features of the '<em>Definition Or Stub</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION_OR_STUB_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getOperationDeclaration()
   * @generated
   */
  int OPERATION_DECLARATION = 1;

  /**
   * The feature id for the '<em><b>Is Constructor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DECLARATION__IS_CONSTRUCTOR = 0;

  /**
   * The feature id for the '<em><b>Is Destructor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DECLARATION__IS_DESTRUCTOR = 1;

  /**
   * The feature id for the '<em><b>Visibility Indicator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DECLARATION__VISIBILITY_INDICATOR = 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DECLARATION__ABSTRACT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DECLARATION__NAME = 4;

  /**
   * The feature id for the '<em><b>Formal Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DECLARATION__FORMAL_PARAMETERS = 5;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DECLARATION__RETURN_TYPE = 6;

  /**
   * The feature id for the '<em><b>Redefinition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DECLARATION__REDEFINITION = 7;

  /**
   * The number of structural features of the '<em>Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DECLARATION_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParametersImpl <em>Formal Parameters</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParametersImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getFormalParameters()
   * @generated
   */
  int FORMAL_PARAMETERS = 2;

  /**
   * The feature id for the '<em><b>Formal Parameter List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST = 0;

  /**
   * The number of structural features of the '<em>Formal Parameters</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETERS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParameterListImpl <em>Formal Parameter List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParameterListImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getFormalParameterList()
   * @generated
   */
  int FORMAL_PARAMETER_LIST = 3;

  /**
   * The feature id for the '<em><b>Formal Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER_LIST__FORMAL_PARAMETER = 0;

  /**
   * The number of structural features of the '<em>Formal Parameter List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParameterImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getFormalParameter()
   * @generated
   */
  int FORMAL_PARAMETER = 4;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER__DIRECTION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER__NAME = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER__TYPE = 2;

  /**
   * The number of structural features of the '<em>Formal Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.TypePartImpl <em>Type Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.TypePartImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getTypePart()
   * @generated
   */
  int TYPE_PART = 5;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_PART__TYPE_NAME = 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_PART__MULTIPLICITY = 1;

  /**
   * The number of structural features of the '<em>Type Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getMultiplicity()
   * @generated
   */
  int MULTIPLICITY = 6;

  /**
   * The feature id for the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__RANGE = 0;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__ORDERED = 1;

  /**
   * The feature id for the '<em><b>Non Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__NON_UNIQUE = 2;

  /**
   * The feature id for the '<em><b>Sequence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__SEQUENCE = 3;

  /**
   * The number of structural features of the '<em>Multiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityRangeImpl <em>Multiplicity Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityRangeImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getMultiplicityRange()
   * @generated
   */
  int MULTIPLICITY_RANGE = 7;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_RANGE__LOWER = 0;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_RANGE__UPPER = 1;

  /**
   * The number of structural features of the '<em>Multiplicity Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_RANGE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.NUMBER_LITERAL_WITHOUT_SUFFIXImpl <em>NUMBER LITERAL WITHOUT SUFFIX</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.NUMBER_LITERAL_WITHOUT_SUFFIXImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getNUMBER_LITERAL_WITHOUT_SUFFIX()
   * @generated
   */
  int NUMBER_LITERAL_WITHOUT_SUFFIX = 8;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_WITHOUT_SUFFIX__VALUE = 0;

  /**
   * The number of structural features of the '<em>NUMBER LITERAL WITHOUT SUFFIX</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_WITHOUT_SUFFIX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.INTEGER_LITERAL_WITHOUT_SUFFIXImpl <em>INTEGER LITERAL WITHOUT SUFFIX</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.INTEGER_LITERAL_WITHOUT_SUFFIXImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getINTEGER_LITERAL_WITHOUT_SUFFIX()
   * @generated
   */
  int INTEGER_LITERAL_WITHOUT_SUFFIX = 9;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL_WITHOUT_SUFFIX__VALUE = NUMBER_LITERAL_WITHOUT_SUFFIX__VALUE;

  /**
   * The number of structural features of the '<em>INTEGER LITERAL WITHOUT SUFFIX</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL_WITHOUT_SUFFIX_FEATURE_COUNT = NUMBER_LITERAL_WITHOUT_SUFFIX_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.UNLIMITED_LITERAL_WITHOUT_SUFFIXImpl <em>UNLIMITED LITERAL WITHOUT SUFFIX</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.UNLIMITED_LITERAL_WITHOUT_SUFFIXImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getUNLIMITED_LITERAL_WITHOUT_SUFFIX()
   * @generated
   */
  int UNLIMITED_LITERAL_WITHOUT_SUFFIX = 10;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNLIMITED_LITERAL_WITHOUT_SUFFIX__VALUE = NUMBER_LITERAL_WITHOUT_SUFFIX__VALUE;

  /**
   * The number of structural features of the '<em>UNLIMITED LITERAL WITHOUT SUFFIX</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNLIMITED_LITERAL_WITHOUT_SUFFIX_FEATURE_COUNT = NUMBER_LITERAL_WITHOUT_SUFFIX_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.TypeNameImpl <em>Type Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.TypeNameImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getTypeName()
   * @generated
   */
  int TYPE_NAME = 11;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME__QUALIFIED_NAME = 0;

  /**
   * The number of structural features of the '<em>Type Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.RedefinitionClauseImpl <em>Redefinition Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.RedefinitionClauseImpl
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getRedefinitionClause()
   * @generated
   */
  int REDEFINITION_CLAUSE = 12;

  /**
   * The feature id for the '<em><b>Redefined Operations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REDEFINITION_CLAUSE__REDEFINED_OPERATIONS = 0;

  /**
   * The number of structural features of the '<em>Redefinition Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REDEFINITION_CLAUSE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator <em>Visibility Indicator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getVisibilityIndicator()
   * @generated
   */
  int VISIBILITY_INDICATOR = 13;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection <em>Parameter Direction</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getParameterDirection()
   * @generated
   */
  int PARAMETER_DIRECTION = 14;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub <em>Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition Or Stub</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub
   * @generated
   */
  EClass getOperationDefinitionOrStub();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub#getDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declaration</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub#getDeclaration()
   * @see #getOperationDefinitionOrStub()
   * @generated
   */
  EReference getOperationDefinitionOrStub_Declaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub#getBody()
   * @see #getOperationDefinitionOrStub()
   * @generated
   */
  EReference getOperationDefinitionOrStub_Body();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration
   * @generated
   */
  EClass getOperationDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isIsConstructor <em>Is Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Constructor</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isIsConstructor()
   * @see #getOperationDeclaration()
   * @generated
   */
  EAttribute getOperationDeclaration_IsConstructor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isIsDestructor <em>Is Destructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Destructor</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isIsDestructor()
   * @see #getOperationDeclaration()
   * @generated
   */
  EAttribute getOperationDeclaration_IsDestructor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getVisibilityIndicator <em>Visibility Indicator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility Indicator</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getVisibilityIndicator()
   * @see #getOperationDeclaration()
   * @generated
   */
  EAttribute getOperationDeclaration_VisibilityIndicator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isAbstract()
   * @see #getOperationDeclaration()
   * @generated
   */
  EAttribute getOperationDeclaration_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getName()
   * @see #getOperationDeclaration()
   * @generated
   */
  EAttribute getOperationDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getFormalParameters <em>Formal Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formal Parameters</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getFormalParameters()
   * @see #getOperationDeclaration()
   * @generated
   */
  EReference getOperationDeclaration_FormalParameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Type</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getReturnType()
   * @see #getOperationDeclaration()
   * @generated
   */
  EReference getOperationDeclaration_ReturnType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getRedefinition <em>Redefinition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Redefinition</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getRedefinition()
   * @see #getOperationDeclaration()
   * @generated
   */
  EReference getOperationDeclaration_Redefinition();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters <em>Formal Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Parameters</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters
   * @generated
   */
  EClass getFormalParameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters#getFormalParameterList <em>Formal Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formal Parameter List</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters#getFormalParameterList()
   * @see #getFormalParameters()
   * @generated
   */
  EReference getFormalParameters_FormalParameterList();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList <em>Formal Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Parameter List</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList
   * @generated
   */
  EClass getFormalParameterList();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList#getFormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Formal Parameter</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList#getFormalParameter()
   * @see #getFormalParameterList()
   * @generated
   */
  EReference getFormalParameterList_FormalParameter();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Parameter</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter
   * @generated
   */
  EClass getFormalParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getDirection()
   * @see #getFormalParameter()
   * @generated
   */
  EAttribute getFormalParameter_Direction();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getName()
   * @see #getFormalParameter()
   * @generated
   */
  EAttribute getFormalParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getType()
   * @see #getFormalParameter()
   * @generated
   */
  EReference getFormalParameter_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart <em>Type Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Part</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart
   * @generated
   */
  EClass getTypePart();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Name</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart#getTypeName()
   * @see #getTypePart()
   * @generated
   */
  EReference getTypePart_TypeName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart#getMultiplicity()
   * @see #getTypePart()
   * @generated
   */
  EReference getTypePart_Multiplicity();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity
   * @generated
   */
  EClass getMultiplicity();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity#getRange <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity#getRange()
   * @see #getMultiplicity()
   * @generated
   */
  EReference getMultiplicity_Range();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity#isOrdered <em>Ordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ordered</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity#isOrdered()
   * @see #getMultiplicity()
   * @generated
   */
  EAttribute getMultiplicity_Ordered();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity#isNonUnique <em>Non Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Non Unique</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity#isNonUnique()
   * @see #getMultiplicity()
   * @generated
   */
  EAttribute getMultiplicity_NonUnique();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity#isSequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sequence</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity#isSequence()
   * @see #getMultiplicity()
   * @generated
   */
  EAttribute getMultiplicity_Sequence();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange <em>Multiplicity Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity Range</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange
   * @generated
   */
  EClass getMultiplicityRange();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange#getLower()
   * @see #getMultiplicityRange()
   * @generated
   */
  EReference getMultiplicityRange_Lower();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Upper</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange#getUpper()
   * @see #getMultiplicityRange()
   * @generated
   */
  EReference getMultiplicityRange_Upper();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.NUMBER_LITERAL_WITHOUT_SUFFIX <em>NUMBER LITERAL WITHOUT SUFFIX</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>NUMBER LITERAL WITHOUT SUFFIX</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.NUMBER_LITERAL_WITHOUT_SUFFIX
   * @generated
   */
  EClass getNUMBER_LITERAL_WITHOUT_SUFFIX();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.NUMBER_LITERAL_WITHOUT_SUFFIX#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.NUMBER_LITERAL_WITHOUT_SUFFIX#getValue()
   * @see #getNUMBER_LITERAL_WITHOUT_SUFFIX()
   * @generated
   */
  EAttribute getNUMBER_LITERAL_WITHOUT_SUFFIX_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.INTEGER_LITERAL_WITHOUT_SUFFIX <em>INTEGER LITERAL WITHOUT SUFFIX</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>INTEGER LITERAL WITHOUT SUFFIX</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.INTEGER_LITERAL_WITHOUT_SUFFIX
   * @generated
   */
  EClass getINTEGER_LITERAL_WITHOUT_SUFFIX();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.UNLIMITED_LITERAL_WITHOUT_SUFFIX <em>UNLIMITED LITERAL WITHOUT SUFFIX</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UNLIMITED LITERAL WITHOUT SUFFIX</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.UNLIMITED_LITERAL_WITHOUT_SUFFIX
   * @generated
   */
  EClass getUNLIMITED_LITERAL_WITHOUT_SUFFIX();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Name</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypeName
   * @generated
   */
  EClass getTypeName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypeName#getQualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qualified Name</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypeName#getQualifiedName()
   * @see #getTypeName()
   * @generated
   */
  EReference getTypeName_QualifiedName();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause <em>Redefinition Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Redefinition Clause</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause
   * @generated
   */
  EClass getRedefinitionClause();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause#getRedefinedOperations <em>Redefined Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Redefined Operations</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause#getRedefinedOperations()
   * @see #getRedefinitionClause()
   * @generated
   */
  EReference getRedefinitionClause_RedefinedOperations();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator <em>Visibility Indicator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Visibility Indicator</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator
   * @generated
   */
  EEnum getVisibilityIndicator();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection <em>Parameter Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Parameter Direction</em>'.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection
   * @generated
   */
  EEnum getParameterDirection();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  OperationFactory getOperationFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDefinitionOrStubImpl <em>Definition Or Stub</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDefinitionOrStubImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getOperationDefinitionOrStub()
     * @generated
     */
    EClass OPERATION_DEFINITION_OR_STUB = eINSTANCE.getOperationDefinitionOrStub();

    /**
     * The meta object literal for the '<em><b>Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_DEFINITION_OR_STUB__DECLARATION = eINSTANCE.getOperationDefinitionOrStub_Declaration();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_DEFINITION_OR_STUB__BODY = eINSTANCE.getOperationDefinitionOrStub_Body();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getOperationDeclaration()
     * @generated
     */
    EClass OPERATION_DECLARATION = eINSTANCE.getOperationDeclaration();

    /**
     * The meta object literal for the '<em><b>Is Constructor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION_DECLARATION__IS_CONSTRUCTOR = eINSTANCE.getOperationDeclaration_IsConstructor();

    /**
     * The meta object literal for the '<em><b>Is Destructor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION_DECLARATION__IS_DESTRUCTOR = eINSTANCE.getOperationDeclaration_IsDestructor();

    /**
     * The meta object literal for the '<em><b>Visibility Indicator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION_DECLARATION__VISIBILITY_INDICATOR = eINSTANCE.getOperationDeclaration_VisibilityIndicator();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION_DECLARATION__ABSTRACT = eINSTANCE.getOperationDeclaration_Abstract();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION_DECLARATION__NAME = eINSTANCE.getOperationDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Formal Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_DECLARATION__FORMAL_PARAMETERS = eINSTANCE.getOperationDeclaration_FormalParameters();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_DECLARATION__RETURN_TYPE = eINSTANCE.getOperationDeclaration_ReturnType();

    /**
     * The meta object literal for the '<em><b>Redefinition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_DECLARATION__REDEFINITION = eINSTANCE.getOperationDeclaration_Redefinition();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParametersImpl <em>Formal Parameters</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParametersImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getFormalParameters()
     * @generated
     */
    EClass FORMAL_PARAMETERS = eINSTANCE.getFormalParameters();

    /**
     * The meta object literal for the '<em><b>Formal Parameter List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST = eINSTANCE.getFormalParameters_FormalParameterList();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParameterListImpl <em>Formal Parameter List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParameterListImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getFormalParameterList()
     * @generated
     */
    EClass FORMAL_PARAMETER_LIST = eINSTANCE.getFormalParameterList();

    /**
     * The meta object literal for the '<em><b>Formal Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAL_PARAMETER_LIST__FORMAL_PARAMETER = eINSTANCE.getFormalParameterList_FormalParameter();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParameterImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getFormalParameter()
     * @generated
     */
    EClass FORMAL_PARAMETER = eINSTANCE.getFormalParameter();

    /**
     * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORMAL_PARAMETER__DIRECTION = eINSTANCE.getFormalParameter_Direction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORMAL_PARAMETER__NAME = eINSTANCE.getFormalParameter_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAL_PARAMETER__TYPE = eINSTANCE.getFormalParameter_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.TypePartImpl <em>Type Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.TypePartImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getTypePart()
     * @generated
     */
    EClass TYPE_PART = eINSTANCE.getTypePart();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_PART__TYPE_NAME = eINSTANCE.getTypePart_TypeName();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_PART__MULTIPLICITY = eINSTANCE.getTypePart_Multiplicity();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getMultiplicity()
     * @generated
     */
    EClass MULTIPLICITY = eINSTANCE.getMultiplicity();

    /**
     * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICITY__RANGE = eINSTANCE.getMultiplicity_Range();

    /**
     * The meta object literal for the '<em><b>Ordered</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY__ORDERED = eINSTANCE.getMultiplicity_Ordered();

    /**
     * The meta object literal for the '<em><b>Non Unique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY__NON_UNIQUE = eINSTANCE.getMultiplicity_NonUnique();

    /**
     * The meta object literal for the '<em><b>Sequence</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY__SEQUENCE = eINSTANCE.getMultiplicity_Sequence();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityRangeImpl <em>Multiplicity Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityRangeImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getMultiplicityRange()
     * @generated
     */
    EClass MULTIPLICITY_RANGE = eINSTANCE.getMultiplicityRange();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICITY_RANGE__LOWER = eINSTANCE.getMultiplicityRange_Lower();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICITY_RANGE__UPPER = eINSTANCE.getMultiplicityRange_Upper();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.NUMBER_LITERAL_WITHOUT_SUFFIXImpl <em>NUMBER LITERAL WITHOUT SUFFIX</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.NUMBER_LITERAL_WITHOUT_SUFFIXImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getNUMBER_LITERAL_WITHOUT_SUFFIX()
     * @generated
     */
    EClass NUMBER_LITERAL_WITHOUT_SUFFIX = eINSTANCE.getNUMBER_LITERAL_WITHOUT_SUFFIX();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBER_LITERAL_WITHOUT_SUFFIX__VALUE = eINSTANCE.getNUMBER_LITERAL_WITHOUT_SUFFIX_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.INTEGER_LITERAL_WITHOUT_SUFFIXImpl <em>INTEGER LITERAL WITHOUT SUFFIX</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.INTEGER_LITERAL_WITHOUT_SUFFIXImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getINTEGER_LITERAL_WITHOUT_SUFFIX()
     * @generated
     */
    EClass INTEGER_LITERAL_WITHOUT_SUFFIX = eINSTANCE.getINTEGER_LITERAL_WITHOUT_SUFFIX();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.UNLIMITED_LITERAL_WITHOUT_SUFFIXImpl <em>UNLIMITED LITERAL WITHOUT SUFFIX</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.UNLIMITED_LITERAL_WITHOUT_SUFFIXImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getUNLIMITED_LITERAL_WITHOUT_SUFFIX()
     * @generated
     */
    EClass UNLIMITED_LITERAL_WITHOUT_SUFFIX = eINSTANCE.getUNLIMITED_LITERAL_WITHOUT_SUFFIX();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.TypeNameImpl <em>Type Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.TypeNameImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getTypeName()
     * @generated
     */
    EClass TYPE_NAME = eINSTANCE.getTypeName();

    /**
     * The meta object literal for the '<em><b>Qualified Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_NAME__QUALIFIED_NAME = eINSTANCE.getTypeName_QualifiedName();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.RedefinitionClauseImpl <em>Redefinition Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.RedefinitionClauseImpl
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getRedefinitionClause()
     * @generated
     */
    EClass REDEFINITION_CLAUSE = eINSTANCE.getRedefinitionClause();

    /**
     * The meta object literal for the '<em><b>Redefined Operations</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REDEFINITION_CLAUSE__REDEFINED_OPERATIONS = eINSTANCE.getRedefinitionClause_RedefinedOperations();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator <em>Visibility Indicator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getVisibilityIndicator()
     * @generated
     */
    EEnum VISIBILITY_INDICATOR = eINSTANCE.getVisibilityIndicator();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection <em>Parameter Direction</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection
     * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationPackageImpl#getParameterDirection()
     * @generated
     */
    EEnum PARAMETER_DIRECTION = eINSTANCE.getParameterDirection();

  }

} //OperationPackage
