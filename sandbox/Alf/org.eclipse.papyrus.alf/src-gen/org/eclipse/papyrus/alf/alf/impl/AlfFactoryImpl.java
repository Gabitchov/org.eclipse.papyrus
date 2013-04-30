/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.alf.alf.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlfFactoryImpl extends EFactoryImpl implements AlfFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AlfFactory init()
  {
    try
    {
      AlfFactory theAlfFactory = (AlfFactory)EPackage.Registry.INSTANCE.getEFactory(AlfPackage.eNS_URI);
      if (theAlfFactory != null)
      {
        return theAlfFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AlfFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AlfPackage.UNIT_DEFINITION: return createUnitDefinition();
      case AlfPackage.BOOLEAN_LITERAL: return createBOOLEAN_LITERAL();
      case AlfPackage.NUMBER_LITERAL: return createNUMBER_LITERAL();
      case AlfPackage.INTEGER_LITERAL: return createINTEGER_LITERAL();
      case AlfPackage.UNLIMITED_NATURAL: return createUNLIMITED_NATURAL();
      case AlfPackage.STRING_LITERAL: return createSTRING_LITERAL();
      case AlfPackage.STEREOTYPE_ANNOTATIONS: return createStereotypeAnnotations();
      case AlfPackage.STEREOTYPE_ANNOTATION: return createStereotypeAnnotation();
      case AlfPackage.TAGGED_VALUES: return createTaggedValues();
      case AlfPackage.TAGGED_VALUE_LIST: return createTaggedValueList();
      case AlfPackage.PRIMITIVE_LITERAL: return createPRIMITIVE_LITERAL();
      case AlfPackage.TAGGED_VALUE: return createTaggedValue();
      case AlfPackage.NAMESPACE_DECLARATION: return createNamespaceDeclaration();
      case AlfPackage.IMPORT_DECLARATION: return createImportDeclaration();
      case AlfPackage.IMPORT_REFERENCE: return createImportReference();
      case AlfPackage.IMPORT_REFERENCE_QUALIFIED_NAME_COMPLETION: return createImportReferenceQualifiedNameCompletion();
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE: return createColonQualifiedNameCompletionOfImportReference();
      case AlfPackage.ALIAS_DEFINITION: return createAliasDefinition();
      case AlfPackage.NAMESPACE_DEFINITION: return createNamespaceDefinition();
      case AlfPackage.VISIBILITY_INDICATOR: return createVisibilityIndicator();
      case AlfPackage.PACKAGE_DECLARATION: return createPackageDeclaration();
      case AlfPackage.PACKAGE_DEFINITION: return createPackageDefinition();
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB: return createPackageDefinitionOrStub();
      case AlfPackage.PACKAGE_BODY: return createPackageBody();
      case AlfPackage.PACKAGED_ELEMENT: return createPackagedElement();
      case AlfPackage.PACKAGED_ELEMENT_DEFINITION: return createPackagedElementDefinition();
      case AlfPackage.CLASSIFIER_DEFINITION: return createClassifierDefinition();
      case AlfPackage.CLASSIFIER_DEFINITION_OR_STUB: return createClassifierDefinitionOrStub();
      case AlfPackage.CLASSIFIER_SIGNATURE: return createClassifierSignature();
      case AlfPackage.TEMPLATE_PARAMETERS: return createTemplateParameters();
      case AlfPackage.CLASSIFIER_TEMPLATE_PARAMETER: return createClassifierTemplateParameter();
      case AlfPackage.SPECIALIZATION_CLAUSE: return createSpecializationClause();
      case AlfPackage.CLASS_DECLARATION: return createClassDeclaration();
      case AlfPackage.CLASS_DEFINITION: return createClassDefinition();
      case AlfPackage.CLASS_DEFINITION_OR_STUB: return createClassDefinitionOrStub();
      case AlfPackage.CLASS_BODY: return createClassBody();
      case AlfPackage.CLASS_MEMBER: return createClassMember();
      case AlfPackage.CLASS_MEMBER_DEFINITION: return createClassMemberDefinition();
      case AlfPackage.ACTIVE_CLASS_DECLARATION: return createActiveClassDeclaration();
      case AlfPackage.ACTIVE_CLASS_DEFINITION: return createActiveClassDefinition();
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB: return createActiveClassDefinitionOrStub();
      case AlfPackage.ACTIVE_CLASS_BODY: return createActiveClassBody();
      case AlfPackage.BEHAVIOR_CLAUSE: return createBehaviorClause();
      case AlfPackage.ACTIVE_CLASS_MEMBER: return createActiveClassMember();
      case AlfPackage.ACTIVE_CLASS_MEMBER_DEFINITION: return createActiveClassMemberDefinition();
      case AlfPackage.DATA_TYPE_DECLARATION: return createDataTypeDeclaration();
      case AlfPackage.DATA_TYPE_DEFINITION: return createDataTypeDefinition();
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB: return createDataTypeDefinitionOrStub();
      case AlfPackage.STRUCTURED_BODY: return createStructuredBody();
      case AlfPackage.STRUCTURED_MEMBER: return createStructuredMember();
      case AlfPackage.ASSOCIATION_DECLARATION: return createAssociationDeclaration();
      case AlfPackage.ASSOCIATION_DEFINITION: return createAssociationDefinition();
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB: return createAssociationDefinitionOrStub();
      case AlfPackage.ENUMERATION_DECLARATION: return createEnumerationDeclaration();
      case AlfPackage.ENUMERATION_DEFINITION: return createEnumerationDefinition();
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB: return createEnumerationDefinitionOrStub();
      case AlfPackage.ENUMERATION_BODY: return createEnumerationBody();
      case AlfPackage.ENUMERATION_LITERAL_NAME: return createEnumerationLiteralName();
      case AlfPackage.SIGNAL_DECLARATION: return createSignalDeclaration();
      case AlfPackage.SIGNAL_DEFINITION: return createSignalDefinition();
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB: return createSignalDefinitionOrStub();
      case AlfPackage.ACTIVITY_DECLARATION: return createActivityDeclaration();
      case AlfPackage.ACTIVITY_DEFINITION: return createActivityDefinition();
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB: return createActivityDefinitionOrStub();
      case AlfPackage.FORMAL_PARAMETERS: return createFormalParameters();
      case AlfPackage.FORMAL_PARAMETER_LIST: return createFormalParameterList();
      case AlfPackage.FORMAL_PARAMETER: return createFormalParameter();
      case AlfPackage.FEATURE_DEFINITION_OR_STUB: return createFeatureDefinitionOrStub();
      case AlfPackage.ACTIVE_FEATURE_DEFINITION_OR_STUB: return createActiveFeatureDefinitionOrStub();
      case AlfPackage.PROPERTY_DEFINITION: return createPropertyDefinition();
      case AlfPackage.ATTRIBUTE_DEFINITION: return createAttributeDefinition();
      case AlfPackage.ATTRIBUTE_INITIALIZER: return createAttributeInitializer();
      case AlfPackage.PROPERTY_DECLARATION: return createPropertyDeclaration();
      case AlfPackage.TYPE_PART: return createTypePart();
      case AlfPackage.TYPE_NAME: return createTypeName();
      case AlfPackage.MULTIPLICITY: return createMultiplicity();
      case AlfPackage.MULTIPLICITY_RANGE: return createMultiplicityRange();
      case AlfPackage.UNLIMITED_NATURAL_LITERAL: return createUnlimitedNaturalLiteral();
      case AlfPackage.OPERATION_DECLARATION: return createOperationDeclaration();
      case AlfPackage.OPERATION_DEFINITION_OR_STUB: return createOperationDefinitionOrStub();
      case AlfPackage.REDEFINITION_CLAUSE: return createRedefinitionClause();
      case AlfPackage.RECEPTION_DEFINITION: return createReceptionDefinition();
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION: return createSignalReceptionDeclaration();
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB: return createSignalReceptionDefinitionOrStub();
      case AlfPackage.NAME: return createName();
      case AlfPackage.QUALIFIED_NAME: return createQualifiedName();
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION: return createColonQualifiedNameCompletion();
      case AlfPackage.UNQUALIFIED_NAME: return createUnqualifiedName();
      case AlfPackage.NAME_BINDING: return createNameBinding();
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING: return createQualifiedNameWithoutBinding();
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_WITHOUT_BINDING: return createColonQualifiedNameCompletionWithoutBinding();
      case AlfPackage.TEMPLATE_BINDING: return createTemplateBinding();
      case AlfPackage.POSITIONAL_TEMPLATE_BINDING: return createPositionalTemplateBinding();
      case AlfPackage.NAMED_TEMPLATE_BINDING: return createNamedTemplateBinding();
      case AlfPackage.TEMPLATE_PARAMETER_SUBSTITUTION: return createTemplateParameterSubstitution();
      case AlfPackage.EXPRESSION: return createExpression();
      case AlfPackage.NON_NAME_EXPRESSION: return createNonNameExpression();
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION: return createNameToExpressionCompletion();
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION: return createPrimaryToExpressionCompletion();
      case AlfPackage.EXPRESSION_COMPLETION: return createExpressionCompletion();
      case AlfPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
      case AlfPackage.BASE_EXPRESSION: return createBaseExpression();
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION: return createNameToPrimaryExpression();
      case AlfPackage.PRIMARY_EXPRESSION_COMPLETION: return createPrimaryExpressionCompletion();
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX: return createFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index();
      case AlfPackage.LITERAL_EXPRESSION: return createLiteralExpression();
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION: return createNameOrPrimaryExpression();
      case AlfPackage.THIS_EXPRESSION: return createThisExpression();
      case AlfPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
      case AlfPackage.FEATURE: return createFeature();
      case AlfPackage.TUPLE: return createTuple();
      case AlfPackage.POSITIONAL_TUPLE_EXPRESSION_LIST: return createPositionalTupleExpressionList();
      case AlfPackage.POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION: return createPositionalTupleExpressionListCompletion();
      case AlfPackage.NAMED_TUPLE_EXPRESSION_LIST: return createNamedTupleExpressionList();
      case AlfPackage.NAMED_EXPRESSION: return createNamedExpression();
      case AlfPackage.BEHAVIOR_INVOCATION: return createBehaviorInvocation();
      case AlfPackage.FEATURE_INVOCATION: return createFeatureInvocation();
      case AlfPackage.SUPER_INVOCATION_EXPRESSION: return createSuperInvocationExpression();
      case AlfPackage.INSTANCE_CREATION_OR_SEQUENCE_CONSTRUCTION_EXPRESSION: return createInstanceCreationOrSequenceConstructionExpression();
      case AlfPackage.LINK_OPERATION_COMPLETION: return createLinkOperationCompletion();
      case AlfPackage.LINK_OPERATION_TUPLE: return createLinkOperationTuple();
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION: return createIndexedNamedExpressionListCompletion();
      case AlfPackage.INDEXED_NAMED_EXPRESSION: return createIndexedNamedExpression();
      case AlfPackage.CLASS_EXTENT_EXPRESSION_COMPLETION: return createClassExtentExpressionCompletion();
      case AlfPackage.SEQUENCE_ANY_EXPRESSION: return createSequenceAnyExpression();
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION: return createSequenceConstructionExpressionCompletion();
      case AlfPackage.MULTIPLICITY_INDICATOR: return createMultiplicityIndicator();
      case AlfPackage.SEQUENCE_ELEMENTS: return createSequenceElements();
      case AlfPackage.SEQUENCE_ELEMENT_LIST_COMPLETION: return createSequenceElementListCompletion();
      case AlfPackage.SEQUENCE_ELEMENT: return createSequenceElement();
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION: return createSequenceInitializationExpression();
      case AlfPackage.INDEX: return createIndex();
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION: return createSequenceOperationOrReductionOrExpansion();
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION: return createPostfixExpressionCompletion();
      case AlfPackage.POSTFIX_OPERATION: return createPostfixOperation();
      case AlfPackage.PREFIX_EXPRESSION: return createPrefixExpression();
      case AlfPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION: return createPostfixOrCastExpression();
      case AlfPackage.NON_NAME_UNARY_EXPRESSION: return createNonNameUnaryExpression();
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION: return createNonNamePostfixOrCastExpression();
      case AlfPackage.NON_POSTFIX_NON_CAST_UNARY_EXPRESSION: return createNonPostfixNonCastUnaryExpression();
      case AlfPackage.BOOLEAN_NEGATION_EXPRESSION: return createBooleanNegationExpression();
      case AlfPackage.BIT_STRING_COMPLEMENT_EXPRESSION: return createBitStringComplementExpression();
      case AlfPackage.NUMERIC_UNARY_EXPRESSION: return createNumericUnaryExpression();
      case AlfPackage.ISOLATION_EXPRESSION: return createIsolationExpression();
      case AlfPackage.CAST_COMPLETION: return createCastCompletion();
      case AlfPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION: return createMultiplicativeExpressionCompletion();
      case AlfPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION: return createAdditiveExpressionCompletion();
      case AlfPackage.SHIFT_EXPRESSION: return createShiftExpression();
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION: return createShiftExpressionCompletion();
      case AlfPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION: return createRelationalExpressionCompletion();
      case AlfPackage.CLASSIFICATION_EXPRESSION: return createClassificationExpression();
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION: return createClassificationExpressionCompletion();
      case AlfPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION: return createEqualityExpressionCompletion();
      case AlfPackage.AND_EXPRESSION: return createAndExpression();
      case AlfPackage.AND_EXPRESSION_COMPLETION: return createAndExpressionCompletion();
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION: return createExclusiveOrExpression();
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION: return createExclusiveOrExpressionCompletion();
      case AlfPackage.INCLUSIVE_OR_EXPRESSION: return createInclusiveOrExpression();
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION: return createInclusiveOrExpressionCompletion();
      case AlfPackage.CONDITIONAL_AND_EXPRESSION: return createConditionalAndExpression();
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION: return createConditionalAndExpressionCompletion();
      case AlfPackage.CONDITIONAL_OR_EXPRESSION: return createConditionalOrExpression();
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION: return createConditionalOrExpressionCompletion();
      case AlfPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION: return createConditionalExpressionCompletion();
      case AlfPackage.ASSIGNMENT_EXPRESSION_COMPLETION: return createAssignmentExpressionCompletion();
      case AlfPackage.STATEMENT_SEQUENCE: return createStatementSequence();
      case AlfPackage.DOCUMENTED_STATEMENT: return createDocumentedStatement();
      case AlfPackage.STATEMENT: return createStatement();
      case AlfPackage.BLOCK: return createBlock();
      case AlfPackage.ANNOTATED_STATEMENT: return createAnnotatedStatement();
      case AlfPackage.ANNOTATIONS: return createAnnotations();
      case AlfPackage.ANNOTATION: return createAnnotation();
      case AlfPackage.NAME_LIST: return createNameList();
      case AlfPackage.IN_LINE_STATEMENT: return createInLineStatement();
      case AlfPackage.BLOCK_STATEMENT: return createBlockStatement();
      case AlfPackage.EMPTY_STATEMENT: return createEmptyStatement();
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT: return createLocalNameDeclarationOrExpressionStatement();
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT: return createLocalNameDeclarationStatement();
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT_COMPLETION: return createLocalNameDeclarationStatementCompletion();
      case AlfPackage.INITIALIZATION_EXPRESSION: return createInitializationExpression();
      case AlfPackage.INSTANCE_INITIALIZATION_EXPRESSION: return createInstanceInitializationExpression();
      case AlfPackage.IF_STATEMENT: return createIfStatement();
      case AlfPackage.SEQUENTIAL_CLAUSES: return createSequentialClauses();
      case AlfPackage.CONCURRENT_CLAUSES: return createConcurrentClauses();
      case AlfPackage.NON_FINAL_CLAUSE: return createNonFinalClause();
      case AlfPackage.FINAL_CLAUSE: return createFinalClause();
      case AlfPackage.SWITCH_STATEMENT: return createSwitchStatement();
      case AlfPackage.SWITCH_CLAUSE: return createSwitchClause();
      case AlfPackage.SWITCH_CASE: return createSwitchCase();
      case AlfPackage.SWITCH_DEFAULT_CLAUSE: return createSwitchDefaultClause();
      case AlfPackage.NON_EMPTY_STATEMENT_SEQUENCE: return createNonEmptyStatementSequence();
      case AlfPackage.WHILE_STATEMENT: return createWhileStatement();
      case AlfPackage.DO_STATEMENT: return createDoStatement();
      case AlfPackage.FOR_STATEMENT: return createForStatement();
      case AlfPackage.FOR_CONTROL: return createForControl();
      case AlfPackage.LOOP_VARIABLE_DEFINITION: return createLoopVariableDefinition();
      case AlfPackage.BREAK_STATEMENT: return createBreakStatement();
      case AlfPackage.RETURN_STATEMENT: return createReturnStatement();
      case AlfPackage.ACCEPT_STATEMENT: return createAcceptStatement();
      case AlfPackage.SIMPLE_ACCEPT_STATEMENT_COMPLETION: return createSimpleAcceptStatementCompletion();
      case AlfPackage.COMPOUND_ACCEPT_STATEMENT_COMPLETION: return createCompoundAcceptStatementCompletion();
      case AlfPackage.ACCEPT_BLOCK: return createAcceptBlock();
      case AlfPackage.ACCEPT_CLAUSE: return createAcceptClause();
      case AlfPackage.CLASSIFY_STATEMENT: return createClassifyStatement();
      case AlfPackage.CLASSIFICATION_CLAUSE: return createClassificationClause();
      case AlfPackage.CLASSIFICATION_FROM_CLAUSE: return createClassificationFromClause();
      case AlfPackage.CLASSIFICATION_TO_CLAUSE: return createClassificationToClause();
      case AlfPackage.RECLASSIFY_ALL_CLAUSE: return createReclassifyAllClause();
      case AlfPackage.QUALIFIED_NAME_LIST: return createQualifiedNameList();
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
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AlfPackage.IMPORT_VISIBILITY_INDICATOR:
        return createImportVisibilityIndicatorFromString(eDataType, initialValue);
      case AlfPackage.PARAMETER_DIRECTION:
        return createParameterDirectionFromString(eDataType, initialValue);
      case AlfPackage.LINK_OPERATION:
        return createLinkOperationFromString(eDataType, initialValue);
      case AlfPackage.AFFIX_OPERATOR:
        return createAffixOperatorFromString(eDataType, initialValue);
      case AlfPackage.NUMERIC_UNARY_OPERATOR:
        return createNumericUnaryOperatorFromString(eDataType, initialValue);
      case AlfPackage.MULTIPLICATIVE_OPERATOR:
        return createMultiplicativeOperatorFromString(eDataType, initialValue);
      case AlfPackage.ADDITIVE_OPERATOR:
        return createAdditiveOperatorFromString(eDataType, initialValue);
      case AlfPackage.SHIFT_OPERATOR:
        return createShiftOperatorFromString(eDataType, initialValue);
      case AlfPackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      case AlfPackage.CLASSIFICATION_OPERATOR:
        return createClassificationOperatorFromString(eDataType, initialValue);
      case AlfPackage.EQUALITY_OPERATOR:
        return createEqualityOperatorFromString(eDataType, initialValue);
      case AlfPackage.ASSIGNMENT_OPERATOR:
        return createAssignmentOperatorFromString(eDataType, initialValue);
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
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AlfPackage.IMPORT_VISIBILITY_INDICATOR:
        return convertImportVisibilityIndicatorToString(eDataType, instanceValue);
      case AlfPackage.PARAMETER_DIRECTION:
        return convertParameterDirectionToString(eDataType, instanceValue);
      case AlfPackage.LINK_OPERATION:
        return convertLinkOperationToString(eDataType, instanceValue);
      case AlfPackage.AFFIX_OPERATOR:
        return convertAffixOperatorToString(eDataType, instanceValue);
      case AlfPackage.NUMERIC_UNARY_OPERATOR:
        return convertNumericUnaryOperatorToString(eDataType, instanceValue);
      case AlfPackage.MULTIPLICATIVE_OPERATOR:
        return convertMultiplicativeOperatorToString(eDataType, instanceValue);
      case AlfPackage.ADDITIVE_OPERATOR:
        return convertAdditiveOperatorToString(eDataType, instanceValue);
      case AlfPackage.SHIFT_OPERATOR:
        return convertShiftOperatorToString(eDataType, instanceValue);
      case AlfPackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      case AlfPackage.CLASSIFICATION_OPERATOR:
        return convertClassificationOperatorToString(eDataType, instanceValue);
      case AlfPackage.EQUALITY_OPERATOR:
        return convertEqualityOperatorToString(eDataType, instanceValue);
      case AlfPackage.ASSIGNMENT_OPERATOR:
        return convertAssignmentOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitDefinition createUnitDefinition()
  {
    UnitDefinitionImpl unitDefinition = new UnitDefinitionImpl();
    return unitDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BOOLEAN_LITERAL createBOOLEAN_LITERAL()
  {
    BOOLEAN_LITERALImpl booleaN_LITERAL = new BOOLEAN_LITERALImpl();
    return booleaN_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NUMBER_LITERAL createNUMBER_LITERAL()
  {
    NUMBER_LITERALImpl numbeR_LITERAL = new NUMBER_LITERALImpl();
    return numbeR_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public INTEGER_LITERAL createINTEGER_LITERAL()
  {
    INTEGER_LITERALImpl integeR_LITERAL = new INTEGER_LITERALImpl();
    return integeR_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UNLIMITED_NATURAL createUNLIMITED_NATURAL()
  {
    UNLIMITED_NATURALImpl unlimiteD_NATURAL = new UNLIMITED_NATURALImpl();
    return unlimiteD_NATURAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public STRING_LITERAL createSTRING_LITERAL()
  {
    STRING_LITERALImpl strinG_LITERAL = new STRING_LITERALImpl();
    return strinG_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StereotypeAnnotations createStereotypeAnnotations()
  {
    StereotypeAnnotationsImpl stereotypeAnnotations = new StereotypeAnnotationsImpl();
    return stereotypeAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StereotypeAnnotation createStereotypeAnnotation()
  {
    StereotypeAnnotationImpl stereotypeAnnotation = new StereotypeAnnotationImpl();
    return stereotypeAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaggedValues createTaggedValues()
  {
    TaggedValuesImpl taggedValues = new TaggedValuesImpl();
    return taggedValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaggedValueList createTaggedValueList()
  {
    TaggedValueListImpl taggedValueList = new TaggedValueListImpl();
    return taggedValueList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PRIMITIVE_LITERAL createPRIMITIVE_LITERAL()
  {
    PRIMITIVE_LITERALImpl primitivE_LITERAL = new PRIMITIVE_LITERALImpl();
    return primitivE_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaggedValue createTaggedValue()
  {
    TaggedValueImpl taggedValue = new TaggedValueImpl();
    return taggedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamespaceDeclaration createNamespaceDeclaration()
  {
    NamespaceDeclarationImpl namespaceDeclaration = new NamespaceDeclarationImpl();
    return namespaceDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportDeclaration createImportDeclaration()
  {
    ImportDeclarationImpl importDeclaration = new ImportDeclarationImpl();
    return importDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportReference createImportReference()
  {
    ImportReferenceImpl importReference = new ImportReferenceImpl();
    return importReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportReferenceQualifiedNameCompletion createImportReferenceQualifiedNameCompletion()
  {
    ImportReferenceQualifiedNameCompletionImpl importReferenceQualifiedNameCompletion = new ImportReferenceQualifiedNameCompletionImpl();
    return importReferenceQualifiedNameCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColonQualifiedNameCompletionOfImportReference createColonQualifiedNameCompletionOfImportReference()
  {
    ColonQualifiedNameCompletionOfImportReferenceImpl colonQualifiedNameCompletionOfImportReference = new ColonQualifiedNameCompletionOfImportReferenceImpl();
    return colonQualifiedNameCompletionOfImportReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AliasDefinition createAliasDefinition()
  {
    AliasDefinitionImpl aliasDefinition = new AliasDefinitionImpl();
    return aliasDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamespaceDefinition createNamespaceDefinition()
  {
    NamespaceDefinitionImpl namespaceDefinition = new NamespaceDefinitionImpl();
    return namespaceDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VisibilityIndicator createVisibilityIndicator()
  {
    VisibilityIndicatorImpl visibilityIndicator = new VisibilityIndicatorImpl();
    return visibilityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration createPackageDeclaration()
  {
    PackageDeclarationImpl packageDeclaration = new PackageDeclarationImpl();
    return packageDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDefinition createPackageDefinition()
  {
    PackageDefinitionImpl packageDefinition = new PackageDefinitionImpl();
    return packageDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDefinitionOrStub createPackageDefinitionOrStub()
  {
    PackageDefinitionOrStubImpl packageDefinitionOrStub = new PackageDefinitionOrStubImpl();
    return packageDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageBody createPackageBody()
  {
    PackageBodyImpl packageBody = new PackageBodyImpl();
    return packageBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackagedElement createPackagedElement()
  {
    PackagedElementImpl packagedElement = new PackagedElementImpl();
    return packagedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackagedElementDefinition createPackagedElementDefinition()
  {
    PackagedElementDefinitionImpl packagedElementDefinition = new PackagedElementDefinitionImpl();
    return packagedElementDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierDefinition createClassifierDefinition()
  {
    ClassifierDefinitionImpl classifierDefinition = new ClassifierDefinitionImpl();
    return classifierDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierDefinitionOrStub createClassifierDefinitionOrStub()
  {
    ClassifierDefinitionOrStubImpl classifierDefinitionOrStub = new ClassifierDefinitionOrStubImpl();
    return classifierDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierSignature createClassifierSignature()
  {
    ClassifierSignatureImpl classifierSignature = new ClassifierSignatureImpl();
    return classifierSignature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateParameters createTemplateParameters()
  {
    TemplateParametersImpl templateParameters = new TemplateParametersImpl();
    return templateParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierTemplateParameter createClassifierTemplateParameter()
  {
    ClassifierTemplateParameterImpl classifierTemplateParameter = new ClassifierTemplateParameterImpl();
    return classifierTemplateParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecializationClause createSpecializationClause()
  {
    SpecializationClauseImpl specializationClause = new SpecializationClauseImpl();
    return specializationClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDeclaration createClassDeclaration()
  {
    ClassDeclarationImpl classDeclaration = new ClassDeclarationImpl();
    return classDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDefinition createClassDefinition()
  {
    ClassDefinitionImpl classDefinition = new ClassDefinitionImpl();
    return classDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDefinitionOrStub createClassDefinitionOrStub()
  {
    ClassDefinitionOrStubImpl classDefinitionOrStub = new ClassDefinitionOrStubImpl();
    return classDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassBody createClassBody()
  {
    ClassBodyImpl classBody = new ClassBodyImpl();
    return classBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassMember createClassMember()
  {
    ClassMemberImpl classMember = new ClassMemberImpl();
    return classMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassMemberDefinition createClassMemberDefinition()
  {
    ClassMemberDefinitionImpl classMemberDefinition = new ClassMemberDefinitionImpl();
    return classMemberDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveClassDeclaration createActiveClassDeclaration()
  {
    ActiveClassDeclarationImpl activeClassDeclaration = new ActiveClassDeclarationImpl();
    return activeClassDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveClassDefinition createActiveClassDefinition()
  {
    ActiveClassDefinitionImpl activeClassDefinition = new ActiveClassDefinitionImpl();
    return activeClassDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveClassDefinitionOrStub createActiveClassDefinitionOrStub()
  {
    ActiveClassDefinitionOrStubImpl activeClassDefinitionOrStub = new ActiveClassDefinitionOrStubImpl();
    return activeClassDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveClassBody createActiveClassBody()
  {
    ActiveClassBodyImpl activeClassBody = new ActiveClassBodyImpl();
    return activeClassBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorClause createBehaviorClause()
  {
    BehaviorClauseImpl behaviorClause = new BehaviorClauseImpl();
    return behaviorClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveClassMember createActiveClassMember()
  {
    ActiveClassMemberImpl activeClassMember = new ActiveClassMemberImpl();
    return activeClassMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveClassMemberDefinition createActiveClassMemberDefinition()
  {
    ActiveClassMemberDefinitionImpl activeClassMemberDefinition = new ActiveClassMemberDefinitionImpl();
    return activeClassMemberDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeDeclaration createDataTypeDeclaration()
  {
    DataTypeDeclarationImpl dataTypeDeclaration = new DataTypeDeclarationImpl();
    return dataTypeDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeDefinition createDataTypeDefinition()
  {
    DataTypeDefinitionImpl dataTypeDefinition = new DataTypeDefinitionImpl();
    return dataTypeDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeDefinitionOrStub createDataTypeDefinitionOrStub()
  {
    DataTypeDefinitionOrStubImpl dataTypeDefinitionOrStub = new DataTypeDefinitionOrStubImpl();
    return dataTypeDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructuredBody createStructuredBody()
  {
    StructuredBodyImpl structuredBody = new StructuredBodyImpl();
    return structuredBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructuredMember createStructuredMember()
  {
    StructuredMemberImpl structuredMember = new StructuredMemberImpl();
    return structuredMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationDeclaration createAssociationDeclaration()
  {
    AssociationDeclarationImpl associationDeclaration = new AssociationDeclarationImpl();
    return associationDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationDefinition createAssociationDefinition()
  {
    AssociationDefinitionImpl associationDefinition = new AssociationDefinitionImpl();
    return associationDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationDefinitionOrStub createAssociationDefinitionOrStub()
  {
    AssociationDefinitionOrStubImpl associationDefinitionOrStub = new AssociationDefinitionOrStubImpl();
    return associationDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationDeclaration createEnumerationDeclaration()
  {
    EnumerationDeclarationImpl enumerationDeclaration = new EnumerationDeclarationImpl();
    return enumerationDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationDefinition createEnumerationDefinition()
  {
    EnumerationDefinitionImpl enumerationDefinition = new EnumerationDefinitionImpl();
    return enumerationDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationDefinitionOrStub createEnumerationDefinitionOrStub()
  {
    EnumerationDefinitionOrStubImpl enumerationDefinitionOrStub = new EnumerationDefinitionOrStubImpl();
    return enumerationDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationBody createEnumerationBody()
  {
    EnumerationBodyImpl enumerationBody = new EnumerationBodyImpl();
    return enumerationBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationLiteralName createEnumerationLiteralName()
  {
    EnumerationLiteralNameImpl enumerationLiteralName = new EnumerationLiteralNameImpl();
    return enumerationLiteralName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalDeclaration createSignalDeclaration()
  {
    SignalDeclarationImpl signalDeclaration = new SignalDeclarationImpl();
    return signalDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalDefinition createSignalDefinition()
  {
    SignalDefinitionImpl signalDefinition = new SignalDefinitionImpl();
    return signalDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalDefinitionOrStub createSignalDefinitionOrStub()
  {
    SignalDefinitionOrStubImpl signalDefinitionOrStub = new SignalDefinitionOrStubImpl();
    return signalDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityDeclaration createActivityDeclaration()
  {
    ActivityDeclarationImpl activityDeclaration = new ActivityDeclarationImpl();
    return activityDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityDefinition createActivityDefinition()
  {
    ActivityDefinitionImpl activityDefinition = new ActivityDefinitionImpl();
    return activityDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityDefinitionOrStub createActivityDefinitionOrStub()
  {
    ActivityDefinitionOrStubImpl activityDefinitionOrStub = new ActivityDefinitionOrStubImpl();
    return activityDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameters createFormalParameters()
  {
    FormalParametersImpl formalParameters = new FormalParametersImpl();
    return formalParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameterList createFormalParameterList()
  {
    FormalParameterListImpl formalParameterList = new FormalParameterListImpl();
    return formalParameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameter createFormalParameter()
  {
    FormalParameterImpl formalParameter = new FormalParameterImpl();
    return formalParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureDefinitionOrStub createFeatureDefinitionOrStub()
  {
    FeatureDefinitionOrStubImpl featureDefinitionOrStub = new FeatureDefinitionOrStubImpl();
    return featureDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveFeatureDefinitionOrStub createActiveFeatureDefinitionOrStub()
  {
    ActiveFeatureDefinitionOrStubImpl activeFeatureDefinitionOrStub = new ActiveFeatureDefinitionOrStubImpl();
    return activeFeatureDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyDefinition createPropertyDefinition()
  {
    PropertyDefinitionImpl propertyDefinition = new PropertyDefinitionImpl();
    return propertyDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeDefinition createAttributeDefinition()
  {
    AttributeDefinitionImpl attributeDefinition = new AttributeDefinitionImpl();
    return attributeDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeInitializer createAttributeInitializer()
  {
    AttributeInitializerImpl attributeInitializer = new AttributeInitializerImpl();
    return attributeInitializer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyDeclaration createPropertyDeclaration()
  {
    PropertyDeclarationImpl propertyDeclaration = new PropertyDeclarationImpl();
    return propertyDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePart createTypePart()
  {
    TypePartImpl typePart = new TypePartImpl();
    return typePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeName createTypeName()
  {
    TypeNameImpl typeName = new TypeNameImpl();
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multiplicity createMultiplicity()
  {
    MultiplicityImpl multiplicity = new MultiplicityImpl();
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityRange createMultiplicityRange()
  {
    MultiplicityRangeImpl multiplicityRange = new MultiplicityRangeImpl();
    return multiplicityRange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnlimitedNaturalLiteral createUnlimitedNaturalLiteral()
  {
    UnlimitedNaturalLiteralImpl unlimitedNaturalLiteral = new UnlimitedNaturalLiteralImpl();
    return unlimitedNaturalLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationDeclaration createOperationDeclaration()
  {
    OperationDeclarationImpl operationDeclaration = new OperationDeclarationImpl();
    return operationDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationDefinitionOrStub createOperationDefinitionOrStub()
  {
    OperationDefinitionOrStubImpl operationDefinitionOrStub = new OperationDefinitionOrStubImpl();
    return operationDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinitionClause createRedefinitionClause()
  {
    RedefinitionClauseImpl redefinitionClause = new RedefinitionClauseImpl();
    return redefinitionClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReceptionDefinition createReceptionDefinition()
  {
    ReceptionDefinitionImpl receptionDefinition = new ReceptionDefinitionImpl();
    return receptionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalReceptionDeclaration createSignalReceptionDeclaration()
  {
    SignalReceptionDeclarationImpl signalReceptionDeclaration = new SignalReceptionDeclarationImpl();
    return signalReceptionDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalReceptionDefinitionOrStub createSignalReceptionDefinitionOrStub()
  {
    SignalReceptionDefinitionOrStubImpl signalReceptionDefinitionOrStub = new SignalReceptionDefinitionOrStubImpl();
    return signalReceptionDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name createName()
  {
    NameImpl name = new NameImpl();
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName createQualifiedName()
  {
    QualifiedNameImpl qualifiedName = new QualifiedNameImpl();
    return qualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColonQualifiedNameCompletion createColonQualifiedNameCompletion()
  {
    ColonQualifiedNameCompletionImpl colonQualifiedNameCompletion = new ColonQualifiedNameCompletionImpl();
    return colonQualifiedNameCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnqualifiedName createUnqualifiedName()
  {
    UnqualifiedNameImpl unqualifiedName = new UnqualifiedNameImpl();
    return unqualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameBinding createNameBinding()
  {
    NameBindingImpl nameBinding = new NameBindingImpl();
    return nameBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameWithoutBinding createQualifiedNameWithoutBinding()
  {
    QualifiedNameWithoutBindingImpl qualifiedNameWithoutBinding = new QualifiedNameWithoutBindingImpl();
    return qualifiedNameWithoutBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColonQualifiedNameCompletionWithoutBinding createColonQualifiedNameCompletionWithoutBinding()
  {
    ColonQualifiedNameCompletionWithoutBindingImpl colonQualifiedNameCompletionWithoutBinding = new ColonQualifiedNameCompletionWithoutBindingImpl();
    return colonQualifiedNameCompletionWithoutBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateBinding createTemplateBinding()
  {
    TemplateBindingImpl templateBinding = new TemplateBindingImpl();
    return templateBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PositionalTemplateBinding createPositionalTemplateBinding()
  {
    PositionalTemplateBindingImpl positionalTemplateBinding = new PositionalTemplateBindingImpl();
    return positionalTemplateBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedTemplateBinding createNamedTemplateBinding()
  {
    NamedTemplateBindingImpl namedTemplateBinding = new NamedTemplateBindingImpl();
    return namedTemplateBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateParameterSubstitution createTemplateParameterSubstitution()
  {
    TemplateParameterSubstitutionImpl templateParameterSubstitution = new TemplateParameterSubstitutionImpl();
    return templateParameterSubstitution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonNameExpression createNonNameExpression()
  {
    NonNameExpressionImpl nonNameExpression = new NonNameExpressionImpl();
    return nonNameExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameToExpressionCompletion createNameToExpressionCompletion()
  {
    NameToExpressionCompletionImpl nameToExpressionCompletion = new NameToExpressionCompletionImpl();
    return nameToExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryToExpressionCompletion createPrimaryToExpressionCompletion()
  {
    PrimaryToExpressionCompletionImpl primaryToExpressionCompletion = new PrimaryToExpressionCompletionImpl();
    return primaryToExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionCompletion createExpressionCompletion()
  {
    ExpressionCompletionImpl expressionCompletion = new ExpressionCompletionImpl();
    return expressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpression createPrimaryExpression()
  {
    PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
    return primaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BaseExpression createBaseExpression()
  {
    BaseExpressionImpl baseExpression = new BaseExpressionImpl();
    return baseExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameToPrimaryExpression createNameToPrimaryExpression()
  {
    NameToPrimaryExpressionImpl nameToPrimaryExpression = new NameToPrimaryExpressionImpl();
    return nameToPrimaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpressionCompletion createPrimaryExpressionCompletion()
  {
    PrimaryExpressionCompletionImpl primaryExpressionCompletion = new PrimaryExpressionCompletionImpl();
    return primaryExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index createFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index()
  {
    Feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexImpl feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index = new Feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexImpl();
    return feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralExpression createLiteralExpression()
  {
    LiteralExpressionImpl literalExpression = new LiteralExpressionImpl();
    return literalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameOrPrimaryExpression createNameOrPrimaryExpression()
  {
    NameOrPrimaryExpressionImpl nameOrPrimaryExpression = new NameOrPrimaryExpressionImpl();
    return nameOrPrimaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThisExpression createThisExpression()
  {
    ThisExpressionImpl thisExpression = new ThisExpressionImpl();
    return thisExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParenthesizedExpression createParenthesizedExpression()
  {
    ParenthesizedExpressionImpl parenthesizedExpression = new ParenthesizedExpressionImpl();
    return parenthesizedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature createFeature()
  {
    FeatureImpl feature = new FeatureImpl();
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tuple createTuple()
  {
    TupleImpl tuple = new TupleImpl();
    return tuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PositionalTupleExpressionList createPositionalTupleExpressionList()
  {
    PositionalTupleExpressionListImpl positionalTupleExpressionList = new PositionalTupleExpressionListImpl();
    return positionalTupleExpressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PositionalTupleExpressionListCompletion createPositionalTupleExpressionListCompletion()
  {
    PositionalTupleExpressionListCompletionImpl positionalTupleExpressionListCompletion = new PositionalTupleExpressionListCompletionImpl();
    return positionalTupleExpressionListCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedTupleExpressionList createNamedTupleExpressionList()
  {
    NamedTupleExpressionListImpl namedTupleExpressionList = new NamedTupleExpressionListImpl();
    return namedTupleExpressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedExpression createNamedExpression()
  {
    NamedExpressionImpl namedExpression = new NamedExpressionImpl();
    return namedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorInvocation createBehaviorInvocation()
  {
    BehaviorInvocationImpl behaviorInvocation = new BehaviorInvocationImpl();
    return behaviorInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureInvocation createFeatureInvocation()
  {
    FeatureInvocationImpl featureInvocation = new FeatureInvocationImpl();
    return featureInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperInvocationExpression createSuperInvocationExpression()
  {
    SuperInvocationExpressionImpl superInvocationExpression = new SuperInvocationExpressionImpl();
    return superInvocationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceCreationOrSequenceConstructionExpression createInstanceCreationOrSequenceConstructionExpression()
  {
    InstanceCreationOrSequenceConstructionExpressionImpl instanceCreationOrSequenceConstructionExpression = new InstanceCreationOrSequenceConstructionExpressionImpl();
    return instanceCreationOrSequenceConstructionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperationCompletion createLinkOperationCompletion()
  {
    LinkOperationCompletionImpl linkOperationCompletion = new LinkOperationCompletionImpl();
    return linkOperationCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperationTuple createLinkOperationTuple()
  {
    LinkOperationTupleImpl linkOperationTuple = new LinkOperationTupleImpl();
    return linkOperationTuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndexedNamedExpressionListCompletion createIndexedNamedExpressionListCompletion()
  {
    IndexedNamedExpressionListCompletionImpl indexedNamedExpressionListCompletion = new IndexedNamedExpressionListCompletionImpl();
    return indexedNamedExpressionListCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndexedNamedExpression createIndexedNamedExpression()
  {
    IndexedNamedExpressionImpl indexedNamedExpression = new IndexedNamedExpressionImpl();
    return indexedNamedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassExtentExpressionCompletion createClassExtentExpressionCompletion()
  {
    ClassExtentExpressionCompletionImpl classExtentExpressionCompletion = new ClassExtentExpressionCompletionImpl();
    return classExtentExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceAnyExpression createSequenceAnyExpression()
  {
    SequenceAnyExpressionImpl sequenceAnyExpression = new SequenceAnyExpressionImpl();
    return sequenceAnyExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceConstructionExpressionCompletion createSequenceConstructionExpressionCompletion()
  {
    SequenceConstructionExpressionCompletionImpl sequenceConstructionExpressionCompletion = new SequenceConstructionExpressionCompletionImpl();
    return sequenceConstructionExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityIndicator createMultiplicityIndicator()
  {
    MultiplicityIndicatorImpl multiplicityIndicator = new MultiplicityIndicatorImpl();
    return multiplicityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceElements createSequenceElements()
  {
    SequenceElementsImpl sequenceElements = new SequenceElementsImpl();
    return sequenceElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceElementListCompletion createSequenceElementListCompletion()
  {
    SequenceElementListCompletionImpl sequenceElementListCompletion = new SequenceElementListCompletionImpl();
    return sequenceElementListCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceElement createSequenceElement()
  {
    SequenceElementImpl sequenceElement = new SequenceElementImpl();
    return sequenceElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceInitializationExpression createSequenceInitializationExpression()
  {
    SequenceInitializationExpressionImpl sequenceInitializationExpression = new SequenceInitializationExpressionImpl();
    return sequenceInitializationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Index createIndex()
  {
    IndexImpl index = new IndexImpl();
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceOperationOrReductionOrExpansion createSequenceOperationOrReductionOrExpansion()
  {
    SequenceOperationOrReductionOrExpansionImpl sequenceOperationOrReductionOrExpansion = new SequenceOperationOrReductionOrExpansionImpl();
    return sequenceOperationOrReductionOrExpansion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixExpressionCompletion createPostfixExpressionCompletion()
  {
    PostfixExpressionCompletionImpl postfixExpressionCompletion = new PostfixExpressionCompletionImpl();
    return postfixExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixOperation createPostfixOperation()
  {
    PostfixOperationImpl postfixOperation = new PostfixOperationImpl();
    return postfixOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrefixExpression createPrefixExpression()
  {
    PrefixExpressionImpl prefixExpression = new PrefixExpressionImpl();
    return prefixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixOrCastExpression createPostfixOrCastExpression()
  {
    PostfixOrCastExpressionImpl postfixOrCastExpression = new PostfixOrCastExpressionImpl();
    return postfixOrCastExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonNameUnaryExpression createNonNameUnaryExpression()
  {
    NonNameUnaryExpressionImpl nonNameUnaryExpression = new NonNameUnaryExpressionImpl();
    return nonNameUnaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonNamePostfixOrCastExpression createNonNamePostfixOrCastExpression()
  {
    NonNamePostfixOrCastExpressionImpl nonNamePostfixOrCastExpression = new NonNamePostfixOrCastExpressionImpl();
    return nonNamePostfixOrCastExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonPostfixNonCastUnaryExpression createNonPostfixNonCastUnaryExpression()
  {
    NonPostfixNonCastUnaryExpressionImpl nonPostfixNonCastUnaryExpression = new NonPostfixNonCastUnaryExpressionImpl();
    return nonPostfixNonCastUnaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanNegationExpression createBooleanNegationExpression()
  {
    BooleanNegationExpressionImpl booleanNegationExpression = new BooleanNegationExpressionImpl();
    return booleanNegationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitStringComplementExpression createBitStringComplementExpression()
  {
    BitStringComplementExpressionImpl bitStringComplementExpression = new BitStringComplementExpressionImpl();
    return bitStringComplementExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericUnaryExpression createNumericUnaryExpression()
  {
    NumericUnaryExpressionImpl numericUnaryExpression = new NumericUnaryExpressionImpl();
    return numericUnaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IsolationExpression createIsolationExpression()
  {
    IsolationExpressionImpl isolationExpression = new IsolationExpressionImpl();
    return isolationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CastCompletion createCastCompletion()
  {
    CastCompletionImpl castCompletion = new CastCompletionImpl();
    return castCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpression createMultiplicativeExpression()
  {
    MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
    return multiplicativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpressionCompletion createMultiplicativeExpressionCompletion()
  {
    MultiplicativeExpressionCompletionImpl multiplicativeExpressionCompletion = new MultiplicativeExpressionCompletionImpl();
    return multiplicativeExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpression createAdditiveExpression()
  {
    AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
    return additiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpressionCompletion createAdditiveExpressionCompletion()
  {
    AdditiveExpressionCompletionImpl additiveExpressionCompletion = new AdditiveExpressionCompletionImpl();
    return additiveExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression createShiftExpression()
  {
    ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
    return shiftExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpressionCompletion createShiftExpressionCompletion()
  {
    ShiftExpressionCompletionImpl shiftExpressionCompletion = new ShiftExpressionCompletionImpl();
    return shiftExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpressionCompletion createRelationalExpressionCompletion()
  {
    RelationalExpressionCompletionImpl relationalExpressionCompletion = new RelationalExpressionCompletionImpl();
    return relationalExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationExpression createClassificationExpression()
  {
    ClassificationExpressionImpl classificationExpression = new ClassificationExpressionImpl();
    return classificationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationExpressionCompletion createClassificationExpressionCompletion()
  {
    ClassificationExpressionCompletionImpl classificationExpressionCompletion = new ClassificationExpressionCompletionImpl();
    return classificationExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpressionCompletion createEqualityExpressionCompletion()
  {
    EqualityExpressionCompletionImpl equalityExpressionCompletion = new EqualityExpressionCompletionImpl();
    return equalityExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpression createAndExpression()
  {
    AndExpressionImpl andExpression = new AndExpressionImpl();
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpressionCompletion createAndExpressionCompletion()
  {
    AndExpressionCompletionImpl andExpressionCompletion = new AndExpressionCompletionImpl();
    return andExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExclusiveOrExpression createExclusiveOrExpression()
  {
    ExclusiveOrExpressionImpl exclusiveOrExpression = new ExclusiveOrExpressionImpl();
    return exclusiveOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExclusiveOrExpressionCompletion createExclusiveOrExpressionCompletion()
  {
    ExclusiveOrExpressionCompletionImpl exclusiveOrExpressionCompletion = new ExclusiveOrExpressionCompletionImpl();
    return exclusiveOrExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InclusiveOrExpression createInclusiveOrExpression()
  {
    InclusiveOrExpressionImpl inclusiveOrExpression = new InclusiveOrExpressionImpl();
    return inclusiveOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InclusiveOrExpressionCompletion createInclusiveOrExpressionCompletion()
  {
    InclusiveOrExpressionCompletionImpl inclusiveOrExpressionCompletion = new InclusiveOrExpressionCompletionImpl();
    return inclusiveOrExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalAndExpression createConditionalAndExpression()
  {
    ConditionalAndExpressionImpl conditionalAndExpression = new ConditionalAndExpressionImpl();
    return conditionalAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalAndExpressionCompletion createConditionalAndExpressionCompletion()
  {
    ConditionalAndExpressionCompletionImpl conditionalAndExpressionCompletion = new ConditionalAndExpressionCompletionImpl();
    return conditionalAndExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalOrExpression createConditionalOrExpression()
  {
    ConditionalOrExpressionImpl conditionalOrExpression = new ConditionalOrExpressionImpl();
    return conditionalOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalOrExpressionCompletion createConditionalOrExpressionCompletion()
  {
    ConditionalOrExpressionCompletionImpl conditionalOrExpressionCompletion = new ConditionalOrExpressionCompletionImpl();
    return conditionalOrExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpression createConditionalExpression()
  {
    ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
    return conditionalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpressionCompletion createConditionalExpressionCompletion()
  {
    ConditionalExpressionCompletionImpl conditionalExpressionCompletion = new ConditionalExpressionCompletionImpl();
    return conditionalExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentExpressionCompletion createAssignmentExpressionCompletion()
  {
    AssignmentExpressionCompletionImpl assignmentExpressionCompletion = new AssignmentExpressionCompletionImpl();
    return assignmentExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatementSequence createStatementSequence()
  {
    StatementSequenceImpl statementSequence = new StatementSequenceImpl();
    return statementSequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DocumentedStatement createDocumentedStatement()
  {
    DocumentedStatementImpl documentedStatement = new DocumentedStatementImpl();
    return documentedStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotatedStatement createAnnotatedStatement()
  {
    AnnotatedStatementImpl annotatedStatement = new AnnotatedStatementImpl();
    return annotatedStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotations createAnnotations()
  {
    AnnotationsImpl annotations = new AnnotationsImpl();
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation createAnnotation()
  {
    AnnotationImpl annotation = new AnnotationImpl();
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameList createNameList()
  {
    NameListImpl nameList = new NameListImpl();
    return nameList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InLineStatement createInLineStatement()
  {
    InLineStatementImpl inLineStatement = new InLineStatementImpl();
    return inLineStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockStatement createBlockStatement()
  {
    BlockStatementImpl blockStatement = new BlockStatementImpl();
    return blockStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmptyStatement createEmptyStatement()
  {
    EmptyStatementImpl emptyStatement = new EmptyStatementImpl();
    return emptyStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalNameDeclarationOrExpressionStatement createLocalNameDeclarationOrExpressionStatement()
  {
    LocalNameDeclarationOrExpressionStatementImpl localNameDeclarationOrExpressionStatement = new LocalNameDeclarationOrExpressionStatementImpl();
    return localNameDeclarationOrExpressionStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalNameDeclarationStatement createLocalNameDeclarationStatement()
  {
    LocalNameDeclarationStatementImpl localNameDeclarationStatement = new LocalNameDeclarationStatementImpl();
    return localNameDeclarationStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalNameDeclarationStatementCompletion createLocalNameDeclarationStatementCompletion()
  {
    LocalNameDeclarationStatementCompletionImpl localNameDeclarationStatementCompletion = new LocalNameDeclarationStatementCompletionImpl();
    return localNameDeclarationStatementCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitializationExpression createInitializationExpression()
  {
    InitializationExpressionImpl initializationExpression = new InitializationExpressionImpl();
    return initializationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceInitializationExpression createInstanceInitializationExpression()
  {
    InstanceInitializationExpressionImpl instanceInitializationExpression = new InstanceInitializationExpressionImpl();
    return instanceInitializationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatement createIfStatement()
  {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequentialClauses createSequentialClauses()
  {
    SequentialClausesImpl sequentialClauses = new SequentialClausesImpl();
    return sequentialClauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcurrentClauses createConcurrentClauses()
  {
    ConcurrentClausesImpl concurrentClauses = new ConcurrentClausesImpl();
    return concurrentClauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonFinalClause createNonFinalClause()
  {
    NonFinalClauseImpl nonFinalClause = new NonFinalClauseImpl();
    return nonFinalClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FinalClause createFinalClause()
  {
    FinalClauseImpl finalClause = new FinalClauseImpl();
    return finalClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchStatement createSwitchStatement()
  {
    SwitchStatementImpl switchStatement = new SwitchStatementImpl();
    return switchStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchClause createSwitchClause()
  {
    SwitchClauseImpl switchClause = new SwitchClauseImpl();
    return switchClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchCase createSwitchCase()
  {
    SwitchCaseImpl switchCase = new SwitchCaseImpl();
    return switchCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchDefaultClause createSwitchDefaultClause()
  {
    SwitchDefaultClauseImpl switchDefaultClause = new SwitchDefaultClauseImpl();
    return switchDefaultClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonEmptyStatementSequence createNonEmptyStatementSequence()
  {
    NonEmptyStatementSequenceImpl nonEmptyStatementSequence = new NonEmptyStatementSequenceImpl();
    return nonEmptyStatementSequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileStatement createWhileStatement()
  {
    WhileStatementImpl whileStatement = new WhileStatementImpl();
    return whileStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoStatement createDoStatement()
  {
    DoStatementImpl doStatement = new DoStatementImpl();
    return doStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForStatement createForStatement()
  {
    ForStatementImpl forStatement = new ForStatementImpl();
    return forStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForControl createForControl()
  {
    ForControlImpl forControl = new ForControlImpl();
    return forControl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopVariableDefinition createLoopVariableDefinition()
  {
    LoopVariableDefinitionImpl loopVariableDefinition = new LoopVariableDefinitionImpl();
    return loopVariableDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BreakStatement createBreakStatement()
  {
    BreakStatementImpl breakStatement = new BreakStatementImpl();
    return breakStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnStatement createReturnStatement()
  {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    return returnStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AcceptStatement createAcceptStatement()
  {
    AcceptStatementImpl acceptStatement = new AcceptStatementImpl();
    return acceptStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAcceptStatementCompletion createSimpleAcceptStatementCompletion()
  {
    SimpleAcceptStatementCompletionImpl simpleAcceptStatementCompletion = new SimpleAcceptStatementCompletionImpl();
    return simpleAcceptStatementCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompoundAcceptStatementCompletion createCompoundAcceptStatementCompletion()
  {
    CompoundAcceptStatementCompletionImpl compoundAcceptStatementCompletion = new CompoundAcceptStatementCompletionImpl();
    return compoundAcceptStatementCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AcceptBlock createAcceptBlock()
  {
    AcceptBlockImpl acceptBlock = new AcceptBlockImpl();
    return acceptBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AcceptClause createAcceptClause()
  {
    AcceptClauseImpl acceptClause = new AcceptClauseImpl();
    return acceptClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifyStatement createClassifyStatement()
  {
    ClassifyStatementImpl classifyStatement = new ClassifyStatementImpl();
    return classifyStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationClause createClassificationClause()
  {
    ClassificationClauseImpl classificationClause = new ClassificationClauseImpl();
    return classificationClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationFromClause createClassificationFromClause()
  {
    ClassificationFromClauseImpl classificationFromClause = new ClassificationFromClauseImpl();
    return classificationFromClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationToClause createClassificationToClause()
  {
    ClassificationToClauseImpl classificationToClause = new ClassificationToClauseImpl();
    return classificationToClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReclassifyAllClause createReclassifyAllClause()
  {
    ReclassifyAllClauseImpl reclassifyAllClause = new ReclassifyAllClauseImpl();
    return reclassifyAllClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameList createQualifiedNameList()
  {
    QualifiedNameListImpl qualifiedNameList = new QualifiedNameListImpl();
    return qualifiedNameList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportVisibilityIndicator createImportVisibilityIndicatorFromString(EDataType eDataType, String initialValue)
  {
    ImportVisibilityIndicator result = ImportVisibilityIndicator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImportVisibilityIndicatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterDirection createParameterDirectionFromString(EDataType eDataType, String initialValue)
  {
    ParameterDirection result = ParameterDirection.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertParameterDirectionToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperation createLinkOperationFromString(EDataType eDataType, String initialValue)
  {
    LinkOperation result = LinkOperation.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLinkOperationToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AffixOperator createAffixOperatorFromString(EDataType eDataType, String initialValue)
  {
    AffixOperator result = AffixOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAffixOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericUnaryOperator createNumericUnaryOperatorFromString(EDataType eDataType, String initialValue)
  {
    NumericUnaryOperator result = NumericUnaryOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertNumericUnaryOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue)
  {
    MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue)
  {
    AdditiveOperator result = AdditiveOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftOperator createShiftOperatorFromString(EDataType eDataType, String initialValue)
  {
    ShiftOperator result = ShiftOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShiftOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue)
  {
    RelationalOperator result = RelationalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationOperator createClassificationOperatorFromString(EDataType eDataType, String initialValue)
  {
    ClassificationOperator result = ClassificationOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertClassificationOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue)
  {
    EqualityOperator result = EqualityOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue)
  {
    AssignmentOperator result = AssignmentOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfPackage getAlfPackage()
  {
    return (AlfPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AlfPackage getPackage()
  {
    return AlfPackage.eINSTANCE;
  }

} //AlfFactoryImpl
