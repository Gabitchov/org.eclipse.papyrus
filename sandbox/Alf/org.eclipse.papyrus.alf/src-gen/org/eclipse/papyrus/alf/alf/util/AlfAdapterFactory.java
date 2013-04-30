/**
 */
package org.eclipse.papyrus.alf.alf.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.alf.alf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.alf.alf.AlfPackage
 * @generated
 */
public class AlfAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AlfPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AlfPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlfSwitch<Adapter> modelSwitch =
    new AlfSwitch<Adapter>()
    {
      @Override
      public Adapter caseUnitDefinition(UnitDefinition object)
      {
        return createUnitDefinitionAdapter();
      }
      @Override
      public Adapter caseBOOLEAN_LITERAL(BOOLEAN_LITERAL object)
      {
        return createBOOLEAN_LITERALAdapter();
      }
      @Override
      public Adapter caseNUMBER_LITERAL(NUMBER_LITERAL object)
      {
        return createNUMBER_LITERALAdapter();
      }
      @Override
      public Adapter caseINTEGER_LITERAL(INTEGER_LITERAL object)
      {
        return createINTEGER_LITERALAdapter();
      }
      @Override
      public Adapter caseUNLIMITED_NATURAL(UNLIMITED_NATURAL object)
      {
        return createUNLIMITED_NATURALAdapter();
      }
      @Override
      public Adapter caseSTRING_LITERAL(STRING_LITERAL object)
      {
        return createSTRING_LITERALAdapter();
      }
      @Override
      public Adapter caseStereotypeAnnotations(StereotypeAnnotations object)
      {
        return createStereotypeAnnotationsAdapter();
      }
      @Override
      public Adapter caseStereotypeAnnotation(StereotypeAnnotation object)
      {
        return createStereotypeAnnotationAdapter();
      }
      @Override
      public Adapter caseTaggedValues(TaggedValues object)
      {
        return createTaggedValuesAdapter();
      }
      @Override
      public Adapter caseTaggedValueList(TaggedValueList object)
      {
        return createTaggedValueListAdapter();
      }
      @Override
      public Adapter casePRIMITIVE_LITERAL(PRIMITIVE_LITERAL object)
      {
        return createPRIMITIVE_LITERALAdapter();
      }
      @Override
      public Adapter caseTaggedValue(TaggedValue object)
      {
        return createTaggedValueAdapter();
      }
      @Override
      public Adapter caseNamespaceDeclaration(NamespaceDeclaration object)
      {
        return createNamespaceDeclarationAdapter();
      }
      @Override
      public Adapter caseImportDeclaration(ImportDeclaration object)
      {
        return createImportDeclarationAdapter();
      }
      @Override
      public Adapter caseImportReference(ImportReference object)
      {
        return createImportReferenceAdapter();
      }
      @Override
      public Adapter caseImportReferenceQualifiedNameCompletion(ImportReferenceQualifiedNameCompletion object)
      {
        return createImportReferenceQualifiedNameCompletionAdapter();
      }
      @Override
      public Adapter caseColonQualifiedNameCompletionOfImportReference(ColonQualifiedNameCompletionOfImportReference object)
      {
        return createColonQualifiedNameCompletionOfImportReferenceAdapter();
      }
      @Override
      public Adapter caseAliasDefinition(AliasDefinition object)
      {
        return createAliasDefinitionAdapter();
      }
      @Override
      public Adapter caseNamespaceDefinition(NamespaceDefinition object)
      {
        return createNamespaceDefinitionAdapter();
      }
      @Override
      public Adapter caseVisibilityIndicator(VisibilityIndicator object)
      {
        return createVisibilityIndicatorAdapter();
      }
      @Override
      public Adapter casePackageDeclaration(PackageDeclaration object)
      {
        return createPackageDeclarationAdapter();
      }
      @Override
      public Adapter casePackageDefinition(PackageDefinition object)
      {
        return createPackageDefinitionAdapter();
      }
      @Override
      public Adapter casePackageDefinitionOrStub(PackageDefinitionOrStub object)
      {
        return createPackageDefinitionOrStubAdapter();
      }
      @Override
      public Adapter casePackageBody(PackageBody object)
      {
        return createPackageBodyAdapter();
      }
      @Override
      public Adapter casePackagedElement(PackagedElement object)
      {
        return createPackagedElementAdapter();
      }
      @Override
      public Adapter casePackagedElementDefinition(PackagedElementDefinition object)
      {
        return createPackagedElementDefinitionAdapter();
      }
      @Override
      public Adapter caseClassifierDefinition(ClassifierDefinition object)
      {
        return createClassifierDefinitionAdapter();
      }
      @Override
      public Adapter caseClassifierDefinitionOrStub(ClassifierDefinitionOrStub object)
      {
        return createClassifierDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseClassifierSignature(ClassifierSignature object)
      {
        return createClassifierSignatureAdapter();
      }
      @Override
      public Adapter caseTemplateParameters(TemplateParameters object)
      {
        return createTemplateParametersAdapter();
      }
      @Override
      public Adapter caseClassifierTemplateParameter(ClassifierTemplateParameter object)
      {
        return createClassifierTemplateParameterAdapter();
      }
      @Override
      public Adapter caseSpecializationClause(SpecializationClause object)
      {
        return createSpecializationClauseAdapter();
      }
      @Override
      public Adapter caseClassDeclaration(ClassDeclaration object)
      {
        return createClassDeclarationAdapter();
      }
      @Override
      public Adapter caseClassDefinition(ClassDefinition object)
      {
        return createClassDefinitionAdapter();
      }
      @Override
      public Adapter caseClassDefinitionOrStub(ClassDefinitionOrStub object)
      {
        return createClassDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseClassBody(ClassBody object)
      {
        return createClassBodyAdapter();
      }
      @Override
      public Adapter caseClassMember(ClassMember object)
      {
        return createClassMemberAdapter();
      }
      @Override
      public Adapter caseClassMemberDefinition(ClassMemberDefinition object)
      {
        return createClassMemberDefinitionAdapter();
      }
      @Override
      public Adapter caseActiveClassDeclaration(ActiveClassDeclaration object)
      {
        return createActiveClassDeclarationAdapter();
      }
      @Override
      public Adapter caseActiveClassDefinition(ActiveClassDefinition object)
      {
        return createActiveClassDefinitionAdapter();
      }
      @Override
      public Adapter caseActiveClassDefinitionOrStub(ActiveClassDefinitionOrStub object)
      {
        return createActiveClassDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseActiveClassBody(ActiveClassBody object)
      {
        return createActiveClassBodyAdapter();
      }
      @Override
      public Adapter caseBehaviorClause(BehaviorClause object)
      {
        return createBehaviorClauseAdapter();
      }
      @Override
      public Adapter caseActiveClassMember(ActiveClassMember object)
      {
        return createActiveClassMemberAdapter();
      }
      @Override
      public Adapter caseActiveClassMemberDefinition(ActiveClassMemberDefinition object)
      {
        return createActiveClassMemberDefinitionAdapter();
      }
      @Override
      public Adapter caseDataTypeDeclaration(DataTypeDeclaration object)
      {
        return createDataTypeDeclarationAdapter();
      }
      @Override
      public Adapter caseDataTypeDefinition(DataTypeDefinition object)
      {
        return createDataTypeDefinitionAdapter();
      }
      @Override
      public Adapter caseDataTypeDefinitionOrStub(DataTypeDefinitionOrStub object)
      {
        return createDataTypeDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseStructuredBody(StructuredBody object)
      {
        return createStructuredBodyAdapter();
      }
      @Override
      public Adapter caseStructuredMember(StructuredMember object)
      {
        return createStructuredMemberAdapter();
      }
      @Override
      public Adapter caseAssociationDeclaration(AssociationDeclaration object)
      {
        return createAssociationDeclarationAdapter();
      }
      @Override
      public Adapter caseAssociationDefinition(AssociationDefinition object)
      {
        return createAssociationDefinitionAdapter();
      }
      @Override
      public Adapter caseAssociationDefinitionOrStub(AssociationDefinitionOrStub object)
      {
        return createAssociationDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseEnumerationDeclaration(EnumerationDeclaration object)
      {
        return createEnumerationDeclarationAdapter();
      }
      @Override
      public Adapter caseEnumerationDefinition(EnumerationDefinition object)
      {
        return createEnumerationDefinitionAdapter();
      }
      @Override
      public Adapter caseEnumerationDefinitionOrStub(EnumerationDefinitionOrStub object)
      {
        return createEnumerationDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseEnumerationBody(EnumerationBody object)
      {
        return createEnumerationBodyAdapter();
      }
      @Override
      public Adapter caseEnumerationLiteralName(EnumerationLiteralName object)
      {
        return createEnumerationLiteralNameAdapter();
      }
      @Override
      public Adapter caseSignalDeclaration(SignalDeclaration object)
      {
        return createSignalDeclarationAdapter();
      }
      @Override
      public Adapter caseSignalDefinition(SignalDefinition object)
      {
        return createSignalDefinitionAdapter();
      }
      @Override
      public Adapter caseSignalDefinitionOrStub(SignalDefinitionOrStub object)
      {
        return createSignalDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseActivityDeclaration(ActivityDeclaration object)
      {
        return createActivityDeclarationAdapter();
      }
      @Override
      public Adapter caseActivityDefinition(ActivityDefinition object)
      {
        return createActivityDefinitionAdapter();
      }
      @Override
      public Adapter caseActivityDefinitionOrStub(ActivityDefinitionOrStub object)
      {
        return createActivityDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseFormalParameters(FormalParameters object)
      {
        return createFormalParametersAdapter();
      }
      @Override
      public Adapter caseFormalParameterList(FormalParameterList object)
      {
        return createFormalParameterListAdapter();
      }
      @Override
      public Adapter caseFormalParameter(FormalParameter object)
      {
        return createFormalParameterAdapter();
      }
      @Override
      public Adapter caseFeatureDefinitionOrStub(FeatureDefinitionOrStub object)
      {
        return createFeatureDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseActiveFeatureDefinitionOrStub(ActiveFeatureDefinitionOrStub object)
      {
        return createActiveFeatureDefinitionOrStubAdapter();
      }
      @Override
      public Adapter casePropertyDefinition(PropertyDefinition object)
      {
        return createPropertyDefinitionAdapter();
      }
      @Override
      public Adapter caseAttributeDefinition(AttributeDefinition object)
      {
        return createAttributeDefinitionAdapter();
      }
      @Override
      public Adapter caseAttributeInitializer(AttributeInitializer object)
      {
        return createAttributeInitializerAdapter();
      }
      @Override
      public Adapter casePropertyDeclaration(PropertyDeclaration object)
      {
        return createPropertyDeclarationAdapter();
      }
      @Override
      public Adapter caseTypePart(TypePart object)
      {
        return createTypePartAdapter();
      }
      @Override
      public Adapter caseTypeName(TypeName object)
      {
        return createTypeNameAdapter();
      }
      @Override
      public Adapter caseMultiplicity(Multiplicity object)
      {
        return createMultiplicityAdapter();
      }
      @Override
      public Adapter caseMultiplicityRange(MultiplicityRange object)
      {
        return createMultiplicityRangeAdapter();
      }
      @Override
      public Adapter caseUnlimitedNaturalLiteral(UnlimitedNaturalLiteral object)
      {
        return createUnlimitedNaturalLiteralAdapter();
      }
      @Override
      public Adapter caseOperationDeclaration(OperationDeclaration object)
      {
        return createOperationDeclarationAdapter();
      }
      @Override
      public Adapter caseOperationDefinitionOrStub(OperationDefinitionOrStub object)
      {
        return createOperationDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseRedefinitionClause(RedefinitionClause object)
      {
        return createRedefinitionClauseAdapter();
      }
      @Override
      public Adapter caseReceptionDefinition(ReceptionDefinition object)
      {
        return createReceptionDefinitionAdapter();
      }
      @Override
      public Adapter caseSignalReceptionDeclaration(SignalReceptionDeclaration object)
      {
        return createSignalReceptionDeclarationAdapter();
      }
      @Override
      public Adapter caseSignalReceptionDefinitionOrStub(SignalReceptionDefinitionOrStub object)
      {
        return createSignalReceptionDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseName(Name object)
      {
        return createNameAdapter();
      }
      @Override
      public Adapter caseQualifiedName(QualifiedName object)
      {
        return createQualifiedNameAdapter();
      }
      @Override
      public Adapter caseColonQualifiedNameCompletion(ColonQualifiedNameCompletion object)
      {
        return createColonQualifiedNameCompletionAdapter();
      }
      @Override
      public Adapter caseUnqualifiedName(UnqualifiedName object)
      {
        return createUnqualifiedNameAdapter();
      }
      @Override
      public Adapter caseNameBinding(NameBinding object)
      {
        return createNameBindingAdapter();
      }
      @Override
      public Adapter caseQualifiedNameWithoutBinding(QualifiedNameWithoutBinding object)
      {
        return createQualifiedNameWithoutBindingAdapter();
      }
      @Override
      public Adapter caseColonQualifiedNameCompletionWithoutBinding(ColonQualifiedNameCompletionWithoutBinding object)
      {
        return createColonQualifiedNameCompletionWithoutBindingAdapter();
      }
      @Override
      public Adapter caseTemplateBinding(TemplateBinding object)
      {
        return createTemplateBindingAdapter();
      }
      @Override
      public Adapter casePositionalTemplateBinding(PositionalTemplateBinding object)
      {
        return createPositionalTemplateBindingAdapter();
      }
      @Override
      public Adapter caseNamedTemplateBinding(NamedTemplateBinding object)
      {
        return createNamedTemplateBindingAdapter();
      }
      @Override
      public Adapter caseTemplateParameterSubstitution(TemplateParameterSubstitution object)
      {
        return createTemplateParameterSubstitutionAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseNonNameExpression(NonNameExpression object)
      {
        return createNonNameExpressionAdapter();
      }
      @Override
      public Adapter caseNameToExpressionCompletion(NameToExpressionCompletion object)
      {
        return createNameToExpressionCompletionAdapter();
      }
      @Override
      public Adapter casePrimaryToExpressionCompletion(PrimaryToExpressionCompletion object)
      {
        return createPrimaryToExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseExpressionCompletion(ExpressionCompletion object)
      {
        return createExpressionCompletionAdapter();
      }
      @Override
      public Adapter casePrimaryExpression(PrimaryExpression object)
      {
        return createPrimaryExpressionAdapter();
      }
      @Override
      public Adapter caseBaseExpression(BaseExpression object)
      {
        return createBaseExpressionAdapter();
      }
      @Override
      public Adapter caseNameToPrimaryExpression(NameToPrimaryExpression object)
      {
        return createNameToPrimaryExpressionAdapter();
      }
      @Override
      public Adapter casePrimaryExpressionCompletion(PrimaryExpressionCompletion object)
      {
        return createPrimaryExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index(Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index object)
      {
        return createFeature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexAdapter();
      }
      @Override
      public Adapter caseLiteralExpression(LiteralExpression object)
      {
        return createLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseNameOrPrimaryExpression(NameOrPrimaryExpression object)
      {
        return createNameOrPrimaryExpressionAdapter();
      }
      @Override
      public Adapter caseThisExpression(ThisExpression object)
      {
        return createThisExpressionAdapter();
      }
      @Override
      public Adapter caseParenthesizedExpression(ParenthesizedExpression object)
      {
        return createParenthesizedExpressionAdapter();
      }
      @Override
      public Adapter caseFeature(Feature object)
      {
        return createFeatureAdapter();
      }
      @Override
      public Adapter caseTuple(Tuple object)
      {
        return createTupleAdapter();
      }
      @Override
      public Adapter casePositionalTupleExpressionList(PositionalTupleExpressionList object)
      {
        return createPositionalTupleExpressionListAdapter();
      }
      @Override
      public Adapter casePositionalTupleExpressionListCompletion(PositionalTupleExpressionListCompletion object)
      {
        return createPositionalTupleExpressionListCompletionAdapter();
      }
      @Override
      public Adapter caseNamedTupleExpressionList(NamedTupleExpressionList object)
      {
        return createNamedTupleExpressionListAdapter();
      }
      @Override
      public Adapter caseNamedExpression(NamedExpression object)
      {
        return createNamedExpressionAdapter();
      }
      @Override
      public Adapter caseBehaviorInvocation(BehaviorInvocation object)
      {
        return createBehaviorInvocationAdapter();
      }
      @Override
      public Adapter caseFeatureInvocation(FeatureInvocation object)
      {
        return createFeatureInvocationAdapter();
      }
      @Override
      public Adapter caseSuperInvocationExpression(SuperInvocationExpression object)
      {
        return createSuperInvocationExpressionAdapter();
      }
      @Override
      public Adapter caseInstanceCreationOrSequenceConstructionExpression(InstanceCreationOrSequenceConstructionExpression object)
      {
        return createInstanceCreationOrSequenceConstructionExpressionAdapter();
      }
      @Override
      public Adapter caseLinkOperationCompletion(LinkOperationCompletion object)
      {
        return createLinkOperationCompletionAdapter();
      }
      @Override
      public Adapter caseLinkOperationTuple(LinkOperationTuple object)
      {
        return createLinkOperationTupleAdapter();
      }
      @Override
      public Adapter caseIndexedNamedExpressionListCompletion(IndexedNamedExpressionListCompletion object)
      {
        return createIndexedNamedExpressionListCompletionAdapter();
      }
      @Override
      public Adapter caseIndexedNamedExpression(IndexedNamedExpression object)
      {
        return createIndexedNamedExpressionAdapter();
      }
      @Override
      public Adapter caseClassExtentExpressionCompletion(ClassExtentExpressionCompletion object)
      {
        return createClassExtentExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseSequenceAnyExpression(SequenceAnyExpression object)
      {
        return createSequenceAnyExpressionAdapter();
      }
      @Override
      public Adapter caseSequenceConstructionExpressionCompletion(SequenceConstructionExpressionCompletion object)
      {
        return createSequenceConstructionExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseMultiplicityIndicator(MultiplicityIndicator object)
      {
        return createMultiplicityIndicatorAdapter();
      }
      @Override
      public Adapter caseSequenceElements(SequenceElements object)
      {
        return createSequenceElementsAdapter();
      }
      @Override
      public Adapter caseSequenceElementListCompletion(SequenceElementListCompletion object)
      {
        return createSequenceElementListCompletionAdapter();
      }
      @Override
      public Adapter caseSequenceElement(SequenceElement object)
      {
        return createSequenceElementAdapter();
      }
      @Override
      public Adapter caseSequenceInitializationExpression(SequenceInitializationExpression object)
      {
        return createSequenceInitializationExpressionAdapter();
      }
      @Override
      public Adapter caseIndex(Index object)
      {
        return createIndexAdapter();
      }
      @Override
      public Adapter caseSequenceOperationOrReductionOrExpansion(SequenceOperationOrReductionOrExpansion object)
      {
        return createSequenceOperationOrReductionOrExpansionAdapter();
      }
      @Override
      public Adapter casePostfixExpressionCompletion(PostfixExpressionCompletion object)
      {
        return createPostfixExpressionCompletionAdapter();
      }
      @Override
      public Adapter casePostfixOperation(PostfixOperation object)
      {
        return createPostfixOperationAdapter();
      }
      @Override
      public Adapter casePrefixExpression(PrefixExpression object)
      {
        return createPrefixExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryExpression(UnaryExpression object)
      {
        return createUnaryExpressionAdapter();
      }
      @Override
      public Adapter casePostfixOrCastExpression(PostfixOrCastExpression object)
      {
        return createPostfixOrCastExpressionAdapter();
      }
      @Override
      public Adapter caseNonNameUnaryExpression(NonNameUnaryExpression object)
      {
        return createNonNameUnaryExpressionAdapter();
      }
      @Override
      public Adapter caseNonNamePostfixOrCastExpression(NonNamePostfixOrCastExpression object)
      {
        return createNonNamePostfixOrCastExpressionAdapter();
      }
      @Override
      public Adapter caseNonPostfixNonCastUnaryExpression(NonPostfixNonCastUnaryExpression object)
      {
        return createNonPostfixNonCastUnaryExpressionAdapter();
      }
      @Override
      public Adapter caseBooleanNegationExpression(BooleanNegationExpression object)
      {
        return createBooleanNegationExpressionAdapter();
      }
      @Override
      public Adapter caseBitStringComplementExpression(BitStringComplementExpression object)
      {
        return createBitStringComplementExpressionAdapter();
      }
      @Override
      public Adapter caseNumericUnaryExpression(NumericUnaryExpression object)
      {
        return createNumericUnaryExpressionAdapter();
      }
      @Override
      public Adapter caseIsolationExpression(IsolationExpression object)
      {
        return createIsolationExpressionAdapter();
      }
      @Override
      public Adapter caseCastCompletion(CastCompletion object)
      {
        return createCastCompletionAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpression(MultiplicativeExpression object)
      {
        return createMultiplicativeExpressionAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpressionCompletion(MultiplicativeExpressionCompletion object)
      {
        return createMultiplicativeExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseAdditiveExpression(AdditiveExpression object)
      {
        return createAdditiveExpressionAdapter();
      }
      @Override
      public Adapter caseAdditiveExpressionCompletion(AdditiveExpressionCompletion object)
      {
        return createAdditiveExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseShiftExpression(ShiftExpression object)
      {
        return createShiftExpressionAdapter();
      }
      @Override
      public Adapter caseShiftExpressionCompletion(ShiftExpressionCompletion object)
      {
        return createShiftExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseRelationalExpressionCompletion(RelationalExpressionCompletion object)
      {
        return createRelationalExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseClassificationExpression(ClassificationExpression object)
      {
        return createClassificationExpressionAdapter();
      }
      @Override
      public Adapter caseClassificationExpressionCompletion(ClassificationExpressionCompletion object)
      {
        return createClassificationExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseEqualityExpression(EqualityExpression object)
      {
        return createEqualityExpressionAdapter();
      }
      @Override
      public Adapter caseEqualityExpressionCompletion(EqualityExpressionCompletion object)
      {
        return createEqualityExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseAndExpressionCompletion(AndExpressionCompletion object)
      {
        return createAndExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseExclusiveOrExpression(ExclusiveOrExpression object)
      {
        return createExclusiveOrExpressionAdapter();
      }
      @Override
      public Adapter caseExclusiveOrExpressionCompletion(ExclusiveOrExpressionCompletion object)
      {
        return createExclusiveOrExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseInclusiveOrExpression(InclusiveOrExpression object)
      {
        return createInclusiveOrExpressionAdapter();
      }
      @Override
      public Adapter caseInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion object)
      {
        return createInclusiveOrExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseConditionalAndExpression(ConditionalAndExpression object)
      {
        return createConditionalAndExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalAndExpressionCompletion(ConditionalAndExpressionCompletion object)
      {
        return createConditionalAndExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseConditionalOrExpression(ConditionalOrExpression object)
      {
        return createConditionalOrExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalOrExpressionCompletion(ConditionalOrExpressionCompletion object)
      {
        return createConditionalOrExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseConditionalExpression(ConditionalExpression object)
      {
        return createConditionalExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalExpressionCompletion(ConditionalExpressionCompletion object)
      {
        return createConditionalExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseAssignmentExpressionCompletion(AssignmentExpressionCompletion object)
      {
        return createAssignmentExpressionCompletionAdapter();
      }
      @Override
      public Adapter caseStatementSequence(StatementSequence object)
      {
        return createStatementSequenceAdapter();
      }
      @Override
      public Adapter caseDocumentedStatement(DocumentedStatement object)
      {
        return createDocumentedStatementAdapter();
      }
      @Override
      public Adapter caseStatement(Statement object)
      {
        return createStatementAdapter();
      }
      @Override
      public Adapter caseBlock(Block object)
      {
        return createBlockAdapter();
      }
      @Override
      public Adapter caseAnnotatedStatement(AnnotatedStatement object)
      {
        return createAnnotatedStatementAdapter();
      }
      @Override
      public Adapter caseAnnotations(Annotations object)
      {
        return createAnnotationsAdapter();
      }
      @Override
      public Adapter caseAnnotation(Annotation object)
      {
        return createAnnotationAdapter();
      }
      @Override
      public Adapter caseNameList(NameList object)
      {
        return createNameListAdapter();
      }
      @Override
      public Adapter caseInLineStatement(InLineStatement object)
      {
        return createInLineStatementAdapter();
      }
      @Override
      public Adapter caseBlockStatement(BlockStatement object)
      {
        return createBlockStatementAdapter();
      }
      @Override
      public Adapter caseEmptyStatement(EmptyStatement object)
      {
        return createEmptyStatementAdapter();
      }
      @Override
      public Adapter caseLocalNameDeclarationOrExpressionStatement(LocalNameDeclarationOrExpressionStatement object)
      {
        return createLocalNameDeclarationOrExpressionStatementAdapter();
      }
      @Override
      public Adapter caseLocalNameDeclarationStatement(LocalNameDeclarationStatement object)
      {
        return createLocalNameDeclarationStatementAdapter();
      }
      @Override
      public Adapter caseLocalNameDeclarationStatementCompletion(LocalNameDeclarationStatementCompletion object)
      {
        return createLocalNameDeclarationStatementCompletionAdapter();
      }
      @Override
      public Adapter caseInitializationExpression(InitializationExpression object)
      {
        return createInitializationExpressionAdapter();
      }
      @Override
      public Adapter caseInstanceInitializationExpression(InstanceInitializationExpression object)
      {
        return createInstanceInitializationExpressionAdapter();
      }
      @Override
      public Adapter caseIfStatement(IfStatement object)
      {
        return createIfStatementAdapter();
      }
      @Override
      public Adapter caseSequentialClauses(SequentialClauses object)
      {
        return createSequentialClausesAdapter();
      }
      @Override
      public Adapter caseConcurrentClauses(ConcurrentClauses object)
      {
        return createConcurrentClausesAdapter();
      }
      @Override
      public Adapter caseNonFinalClause(NonFinalClause object)
      {
        return createNonFinalClauseAdapter();
      }
      @Override
      public Adapter caseFinalClause(FinalClause object)
      {
        return createFinalClauseAdapter();
      }
      @Override
      public Adapter caseSwitchStatement(SwitchStatement object)
      {
        return createSwitchStatementAdapter();
      }
      @Override
      public Adapter caseSwitchClause(SwitchClause object)
      {
        return createSwitchClauseAdapter();
      }
      @Override
      public Adapter caseSwitchCase(SwitchCase object)
      {
        return createSwitchCaseAdapter();
      }
      @Override
      public Adapter caseSwitchDefaultClause(SwitchDefaultClause object)
      {
        return createSwitchDefaultClauseAdapter();
      }
      @Override
      public Adapter caseNonEmptyStatementSequence(NonEmptyStatementSequence object)
      {
        return createNonEmptyStatementSequenceAdapter();
      }
      @Override
      public Adapter caseWhileStatement(WhileStatement object)
      {
        return createWhileStatementAdapter();
      }
      @Override
      public Adapter caseDoStatement(DoStatement object)
      {
        return createDoStatementAdapter();
      }
      @Override
      public Adapter caseForStatement(ForStatement object)
      {
        return createForStatementAdapter();
      }
      @Override
      public Adapter caseForControl(ForControl object)
      {
        return createForControlAdapter();
      }
      @Override
      public Adapter caseLoopVariableDefinition(LoopVariableDefinition object)
      {
        return createLoopVariableDefinitionAdapter();
      }
      @Override
      public Adapter caseBreakStatement(BreakStatement object)
      {
        return createBreakStatementAdapter();
      }
      @Override
      public Adapter caseReturnStatement(ReturnStatement object)
      {
        return createReturnStatementAdapter();
      }
      @Override
      public Adapter caseAcceptStatement(AcceptStatement object)
      {
        return createAcceptStatementAdapter();
      }
      @Override
      public Adapter caseSimpleAcceptStatementCompletion(SimpleAcceptStatementCompletion object)
      {
        return createSimpleAcceptStatementCompletionAdapter();
      }
      @Override
      public Adapter caseCompoundAcceptStatementCompletion(CompoundAcceptStatementCompletion object)
      {
        return createCompoundAcceptStatementCompletionAdapter();
      }
      @Override
      public Adapter caseAcceptBlock(AcceptBlock object)
      {
        return createAcceptBlockAdapter();
      }
      @Override
      public Adapter caseAcceptClause(AcceptClause object)
      {
        return createAcceptClauseAdapter();
      }
      @Override
      public Adapter caseClassifyStatement(ClassifyStatement object)
      {
        return createClassifyStatementAdapter();
      }
      @Override
      public Adapter caseClassificationClause(ClassificationClause object)
      {
        return createClassificationClauseAdapter();
      }
      @Override
      public Adapter caseClassificationFromClause(ClassificationFromClause object)
      {
        return createClassificationFromClauseAdapter();
      }
      @Override
      public Adapter caseClassificationToClause(ClassificationToClause object)
      {
        return createClassificationToClauseAdapter();
      }
      @Override
      public Adapter caseReclassifyAllClause(ReclassifyAllClause object)
      {
        return createReclassifyAllClauseAdapter();
      }
      @Override
      public Adapter caseQualifiedNameList(QualifiedNameList object)
      {
        return createQualifiedNameListAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.UnitDefinition <em>Unit Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.UnitDefinition
   * @generated
   */
  public Adapter createUnitDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.BOOLEAN_LITERAL <em>BOOLEAN LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.BOOLEAN_LITERAL
   * @generated
   */
  public Adapter createBOOLEAN_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NUMBER_LITERAL <em>NUMBER LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NUMBER_LITERAL
   * @generated
   */
  public Adapter createNUMBER_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.INTEGER_LITERAL <em>INTEGER LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.INTEGER_LITERAL
   * @generated
   */
  public Adapter createINTEGER_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.UNLIMITED_NATURAL <em>UNLIMITED NATURAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.UNLIMITED_NATURAL
   * @generated
   */
  public Adapter createUNLIMITED_NATURALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.STRING_LITERAL <em>STRING LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.STRING_LITERAL
   * @generated
   */
  public Adapter createSTRING_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.StereotypeAnnotations <em>Stereotype Annotations</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.StereotypeAnnotations
   * @generated
   */
  public Adapter createStereotypeAnnotationsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.StereotypeAnnotation <em>Stereotype Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.StereotypeAnnotation
   * @generated
   */
  public Adapter createStereotypeAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.TaggedValues <em>Tagged Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.TaggedValues
   * @generated
   */
  public Adapter createTaggedValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.TaggedValueList <em>Tagged Value List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.TaggedValueList
   * @generated
   */
  public Adapter createTaggedValueListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PRIMITIVE_LITERAL <em>PRIMITIVE LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PRIMITIVE_LITERAL
   * @generated
   */
  public Adapter createPRIMITIVE_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.TaggedValue <em>Tagged Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.TaggedValue
   * @generated
   */
  public Adapter createTaggedValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NamespaceDeclaration <em>Namespace Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NamespaceDeclaration
   * @generated
   */
  public Adapter createNamespaceDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ImportDeclaration <em>Import Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ImportDeclaration
   * @generated
   */
  public Adapter createImportDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ImportReference <em>Import Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ImportReference
   * @generated
   */
  public Adapter createImportReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ImportReferenceQualifiedNameCompletion <em>Import Reference Qualified Name Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ImportReferenceQualifiedNameCompletion
   * @generated
   */
  public Adapter createImportReferenceQualifiedNameCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionOfImportReference <em>Colon Qualified Name Completion Of Import Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionOfImportReference
   * @generated
   */
  public Adapter createColonQualifiedNameCompletionOfImportReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AliasDefinition <em>Alias Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AliasDefinition
   * @generated
   */
  public Adapter createAliasDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NamespaceDefinition <em>Namespace Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NamespaceDefinition
   * @generated
   */
  public Adapter createNamespaceDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.VisibilityIndicator <em>Visibility Indicator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.VisibilityIndicator
   * @generated
   */
  public Adapter createVisibilityIndicatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PackageDeclaration
   * @generated
   */
  public Adapter createPackageDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PackageDefinition <em>Package Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PackageDefinition
   * @generated
   */
  public Adapter createPackageDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PackageDefinitionOrStub <em>Package Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PackageDefinitionOrStub
   * @generated
   */
  public Adapter createPackageDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PackageBody <em>Package Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PackageBody
   * @generated
   */
  public Adapter createPackageBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PackagedElement <em>Packaged Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PackagedElement
   * @generated
   */
  public Adapter createPackagedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PackagedElementDefinition <em>Packaged Element Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PackagedElementDefinition
   * @generated
   */
  public Adapter createPackagedElementDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassifierDefinition <em>Classifier Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassifierDefinition
   * @generated
   */
  public Adapter createClassifierDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassifierDefinitionOrStub <em>Classifier Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassifierDefinitionOrStub
   * @generated
   */
  public Adapter createClassifierDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassifierSignature <em>Classifier Signature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassifierSignature
   * @generated
   */
  public Adapter createClassifierSignatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.TemplateParameters <em>Template Parameters</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.TemplateParameters
   * @generated
   */
  public Adapter createTemplateParametersAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassifierTemplateParameter <em>Classifier Template Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassifierTemplateParameter
   * @generated
   */
  public Adapter createClassifierTemplateParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SpecializationClause <em>Specialization Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SpecializationClause
   * @generated
   */
  public Adapter createSpecializationClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassDeclaration <em>Class Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassDeclaration
   * @generated
   */
  public Adapter createClassDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassDefinition <em>Class Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassDefinition
   * @generated
   */
  public Adapter createClassDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassDefinitionOrStub <em>Class Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassDefinitionOrStub
   * @generated
   */
  public Adapter createClassDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassBody <em>Class Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassBody
   * @generated
   */
  public Adapter createClassBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassMember <em>Class Member</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassMember
   * @generated
   */
  public Adapter createClassMemberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassMemberDefinition <em>Class Member Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassMemberDefinition
   * @generated
   */
  public Adapter createClassMemberDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActiveClassDeclaration <em>Active Class Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActiveClassDeclaration
   * @generated
   */
  public Adapter createActiveClassDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActiveClassDefinition <em>Active Class Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActiveClassDefinition
   * @generated
   */
  public Adapter createActiveClassDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActiveClassDefinitionOrStub <em>Active Class Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActiveClassDefinitionOrStub
   * @generated
   */
  public Adapter createActiveClassDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActiveClassBody <em>Active Class Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActiveClassBody
   * @generated
   */
  public Adapter createActiveClassBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.BehaviorClause <em>Behavior Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.BehaviorClause
   * @generated
   */
  public Adapter createBehaviorClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActiveClassMember <em>Active Class Member</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActiveClassMember
   * @generated
   */
  public Adapter createActiveClassMemberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActiveClassMemberDefinition <em>Active Class Member Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActiveClassMemberDefinition
   * @generated
   */
  public Adapter createActiveClassMemberDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.DataTypeDeclaration <em>Data Type Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.DataTypeDeclaration
   * @generated
   */
  public Adapter createDataTypeDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.DataTypeDefinition <em>Data Type Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.DataTypeDefinition
   * @generated
   */
  public Adapter createDataTypeDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.DataTypeDefinitionOrStub <em>Data Type Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.DataTypeDefinitionOrStub
   * @generated
   */
  public Adapter createDataTypeDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.StructuredBody <em>Structured Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.StructuredBody
   * @generated
   */
  public Adapter createStructuredBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.StructuredMember <em>Structured Member</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.StructuredMember
   * @generated
   */
  public Adapter createStructuredMemberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AssociationDeclaration <em>Association Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AssociationDeclaration
   * @generated
   */
  public Adapter createAssociationDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AssociationDefinition <em>Association Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AssociationDefinition
   * @generated
   */
  public Adapter createAssociationDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AssociationDefinitionOrStub <em>Association Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AssociationDefinitionOrStub
   * @generated
   */
  public Adapter createAssociationDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.EnumerationDeclaration <em>Enumeration Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.EnumerationDeclaration
   * @generated
   */
  public Adapter createEnumerationDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.EnumerationDefinition <em>Enumeration Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.EnumerationDefinition
   * @generated
   */
  public Adapter createEnumerationDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.EnumerationDefinitionOrStub <em>Enumeration Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.EnumerationDefinitionOrStub
   * @generated
   */
  public Adapter createEnumerationDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.EnumerationBody <em>Enumeration Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.EnumerationBody
   * @generated
   */
  public Adapter createEnumerationBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.EnumerationLiteralName <em>Enumeration Literal Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.EnumerationLiteralName
   * @generated
   */
  public Adapter createEnumerationLiteralNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SignalDeclaration <em>Signal Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SignalDeclaration
   * @generated
   */
  public Adapter createSignalDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SignalDefinition <em>Signal Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SignalDefinition
   * @generated
   */
  public Adapter createSignalDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SignalDefinitionOrStub <em>Signal Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SignalDefinitionOrStub
   * @generated
   */
  public Adapter createSignalDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActivityDeclaration <em>Activity Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActivityDeclaration
   * @generated
   */
  public Adapter createActivityDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActivityDefinition <em>Activity Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActivityDefinition
   * @generated
   */
  public Adapter createActivityDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActivityDefinitionOrStub <em>Activity Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActivityDefinitionOrStub
   * @generated
   */
  public Adapter createActivityDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.FormalParameters <em>Formal Parameters</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.FormalParameters
   * @generated
   */
  public Adapter createFormalParametersAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.FormalParameterList <em>Formal Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.FormalParameterList
   * @generated
   */
  public Adapter createFormalParameterListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.FormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.FormalParameter
   * @generated
   */
  public Adapter createFormalParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.FeatureDefinitionOrStub <em>Feature Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.FeatureDefinitionOrStub
   * @generated
   */
  public Adapter createFeatureDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ActiveFeatureDefinitionOrStub <em>Active Feature Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ActiveFeatureDefinitionOrStub
   * @generated
   */
  public Adapter createActiveFeatureDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PropertyDefinition <em>Property Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PropertyDefinition
   * @generated
   */
  public Adapter createPropertyDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AttributeDefinition <em>Attribute Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AttributeDefinition
   * @generated
   */
  public Adapter createAttributeDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AttributeInitializer <em>Attribute Initializer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AttributeInitializer
   * @generated
   */
  public Adapter createAttributeInitializerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PropertyDeclaration <em>Property Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PropertyDeclaration
   * @generated
   */
  public Adapter createPropertyDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.TypePart <em>Type Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.TypePart
   * @generated
   */
  public Adapter createTypePartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.TypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.TypeName
   * @generated
   */
  public Adapter createTypeNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Multiplicity
   * @generated
   */
  public Adapter createMultiplicityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.MultiplicityRange <em>Multiplicity Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.MultiplicityRange
   * @generated
   */
  public Adapter createMultiplicityRangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.UnlimitedNaturalLiteral <em>Unlimited Natural Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.UnlimitedNaturalLiteral
   * @generated
   */
  public Adapter createUnlimitedNaturalLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.OperationDeclaration <em>Operation Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.OperationDeclaration
   * @generated
   */
  public Adapter createOperationDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.OperationDefinitionOrStub <em>Operation Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.OperationDefinitionOrStub
   * @generated
   */
  public Adapter createOperationDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.RedefinitionClause <em>Redefinition Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.RedefinitionClause
   * @generated
   */
  public Adapter createRedefinitionClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ReceptionDefinition <em>Reception Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ReceptionDefinition
   * @generated
   */
  public Adapter createReceptionDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SignalReceptionDeclaration <em>Signal Reception Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SignalReceptionDeclaration
   * @generated
   */
  public Adapter createSignalReceptionDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SignalReceptionDefinitionOrStub <em>Signal Reception Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SignalReceptionDefinitionOrStub
   * @generated
   */
  public Adapter createSignalReceptionDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Name <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Name
   * @generated
   */
  public Adapter createNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.QualifiedName
   * @generated
   */
  public Adapter createQualifiedNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletion <em>Colon Qualified Name Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletion
   * @generated
   */
  public Adapter createColonQualifiedNameCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.UnqualifiedName <em>Unqualified Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.UnqualifiedName
   * @generated
   */
  public Adapter createUnqualifiedNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NameBinding <em>Name Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NameBinding
   * @generated
   */
  public Adapter createNameBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.QualifiedNameWithoutBinding <em>Qualified Name Without Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.QualifiedNameWithoutBinding
   * @generated
   */
  public Adapter createQualifiedNameWithoutBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionWithoutBinding <em>Colon Qualified Name Completion Without Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionWithoutBinding
   * @generated
   */
  public Adapter createColonQualifiedNameCompletionWithoutBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.TemplateBinding <em>Template Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.TemplateBinding
   * @generated
   */
  public Adapter createTemplateBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PositionalTemplateBinding <em>Positional Template Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PositionalTemplateBinding
   * @generated
   */
  public Adapter createPositionalTemplateBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NamedTemplateBinding <em>Named Template Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NamedTemplateBinding
   * @generated
   */
  public Adapter createNamedTemplateBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.TemplateParameterSubstitution <em>Template Parameter Substitution</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.TemplateParameterSubstitution
   * @generated
   */
  public Adapter createTemplateParameterSubstitutionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NonNameExpression <em>Non Name Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NonNameExpression
   * @generated
   */
  public Adapter createNonNameExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NameToExpressionCompletion <em>Name To Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NameToExpressionCompletion
   * @generated
   */
  public Adapter createNameToExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PrimaryToExpressionCompletion <em>Primary To Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PrimaryToExpressionCompletion
   * @generated
   */
  public Adapter createPrimaryToExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ExpressionCompletion <em>Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ExpressionCompletion
   * @generated
   */
  public Adapter createExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PrimaryExpression
   * @generated
   */
  public Adapter createPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.BaseExpression <em>Base Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.BaseExpression
   * @generated
   */
  public Adapter createBaseExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NameToPrimaryExpression <em>Name To Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NameToPrimaryExpression
   * @generated
   */
  public Adapter createNameToPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PrimaryExpressionCompletion <em>Primary Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PrimaryExpressionCompletion
   * @generated
   */
  public Adapter createPrimaryExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index <em>Feature Or Sequence Operation Or Reduction Or Expansion Or Index</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index
   * @generated
   */
  public Adapter createFeature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.LiteralExpression <em>Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.LiteralExpression
   * @generated
   */
  public Adapter createLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NameOrPrimaryExpression <em>Name Or Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NameOrPrimaryExpression
   * @generated
   */
  public Adapter createNameOrPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ThisExpression <em>This Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ThisExpression
   * @generated
   */
  public Adapter createThisExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ParenthesizedExpression
   * @generated
   */
  public Adapter createParenthesizedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Feature
   * @generated
   */
  public Adapter createFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Tuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Tuple
   * @generated
   */
  public Adapter createTupleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PositionalTupleExpressionList <em>Positional Tuple Expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PositionalTupleExpressionList
   * @generated
   */
  public Adapter createPositionalTupleExpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PositionalTupleExpressionListCompletion <em>Positional Tuple Expression List Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PositionalTupleExpressionListCompletion
   * @generated
   */
  public Adapter createPositionalTupleExpressionListCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NamedTupleExpressionList <em>Named Tuple Expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NamedTupleExpressionList
   * @generated
   */
  public Adapter createNamedTupleExpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NamedExpression <em>Named Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NamedExpression
   * @generated
   */
  public Adapter createNamedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.BehaviorInvocation <em>Behavior Invocation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.BehaviorInvocation
   * @generated
   */
  public Adapter createBehaviorInvocationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.FeatureInvocation <em>Feature Invocation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.FeatureInvocation
   * @generated
   */
  public Adapter createFeatureInvocationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SuperInvocationExpression <em>Super Invocation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SuperInvocationExpression
   * @generated
   */
  public Adapter createSuperInvocationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.InstanceCreationOrSequenceConstructionExpression <em>Instance Creation Or Sequence Construction Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.InstanceCreationOrSequenceConstructionExpression
   * @generated
   */
  public Adapter createInstanceCreationOrSequenceConstructionExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.LinkOperationCompletion <em>Link Operation Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.LinkOperationCompletion
   * @generated
   */
  public Adapter createLinkOperationCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple <em>Link Operation Tuple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.LinkOperationTuple
   * @generated
   */
  public Adapter createLinkOperationTupleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.IndexedNamedExpressionListCompletion <em>Indexed Named Expression List Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.IndexedNamedExpressionListCompletion
   * @generated
   */
  public Adapter createIndexedNamedExpressionListCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.IndexedNamedExpression <em>Indexed Named Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.IndexedNamedExpression
   * @generated
   */
  public Adapter createIndexedNamedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassExtentExpressionCompletion <em>Class Extent Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassExtentExpressionCompletion
   * @generated
   */
  public Adapter createClassExtentExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SequenceAnyExpression <em>Sequence Any Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SequenceAnyExpression
   * @generated
   */
  public Adapter createSequenceAnyExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SequenceConstructionExpressionCompletion <em>Sequence Construction Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SequenceConstructionExpressionCompletion
   * @generated
   */
  public Adapter createSequenceConstructionExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.MultiplicityIndicator <em>Multiplicity Indicator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.MultiplicityIndicator
   * @generated
   */
  public Adapter createMultiplicityIndicatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SequenceElements <em>Sequence Elements</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SequenceElements
   * @generated
   */
  public Adapter createSequenceElementsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SequenceElementListCompletion <em>Sequence Element List Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SequenceElementListCompletion
   * @generated
   */
  public Adapter createSequenceElementListCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SequenceElement <em>Sequence Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SequenceElement
   * @generated
   */
  public Adapter createSequenceElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SequenceInitializationExpression <em>Sequence Initialization Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SequenceInitializationExpression
   * @generated
   */
  public Adapter createSequenceInitializationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Index <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Index
   * @generated
   */
  public Adapter createIndexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion <em>Sequence Operation Or Reduction Or Expansion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion
   * @generated
   */
  public Adapter createSequenceOperationOrReductionOrExpansionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion <em>Postfix Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion
   * @generated
   */
  public Adapter createPostfixExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PostfixOperation <em>Postfix Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PostfixOperation
   * @generated
   */
  public Adapter createPostfixOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PrefixExpression <em>Prefix Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PrefixExpression
   * @generated
   */
  public Adapter createPrefixExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.PostfixOrCastExpression <em>Postfix Or Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.PostfixOrCastExpression
   * @generated
   */
  public Adapter createPostfixOrCastExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NonNameUnaryExpression <em>Non Name Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NonNameUnaryExpression
   * @generated
   */
  public Adapter createNonNameUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression <em>Non Name Postfix Or Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression
   * @generated
   */
  public Adapter createNonNamePostfixOrCastExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NonPostfixNonCastUnaryExpression <em>Non Postfix Non Cast Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NonPostfixNonCastUnaryExpression
   * @generated
   */
  public Adapter createNonPostfixNonCastUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.BooleanNegationExpression <em>Boolean Negation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.BooleanNegationExpression
   * @generated
   */
  public Adapter createBooleanNegationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.BitStringComplementExpression <em>Bit String Complement Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.BitStringComplementExpression
   * @generated
   */
  public Adapter createBitStringComplementExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NumericUnaryExpression <em>Numeric Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NumericUnaryExpression
   * @generated
   */
  public Adapter createNumericUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.IsolationExpression <em>Isolation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.IsolationExpression
   * @generated
   */
  public Adapter createIsolationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.CastCompletion <em>Cast Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.CastCompletion
   * @generated
   */
  public Adapter createCastCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.MultiplicativeExpression
   * @generated
   */
  public Adapter createMultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.MultiplicativeExpressionCompletion <em>Multiplicative Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.MultiplicativeExpressionCompletion
   * @generated
   */
  public Adapter createMultiplicativeExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AdditiveExpression
   * @generated
   */
  public Adapter createAdditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AdditiveExpressionCompletion <em>Additive Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AdditiveExpressionCompletion
   * @generated
   */
  public Adapter createAdditiveExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ShiftExpression
   * @generated
   */
  public Adapter createShiftExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ShiftExpressionCompletion <em>Shift Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ShiftExpressionCompletion
   * @generated
   */
  public Adapter createShiftExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.RelationalExpressionCompletion <em>Relational Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.RelationalExpressionCompletion
   * @generated
   */
  public Adapter createRelationalExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassificationExpression <em>Classification Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassificationExpression
   * @generated
   */
  public Adapter createClassificationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion <em>Classification Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion
   * @generated
   */
  public Adapter createClassificationExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.EqualityExpression
   * @generated
   */
  public Adapter createEqualityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.EqualityExpressionCompletion <em>Equality Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.EqualityExpressionCompletion
   * @generated
   */
  public Adapter createEqualityExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AndExpressionCompletion <em>And Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AndExpressionCompletion
   * @generated
   */
  public Adapter createAndExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ExclusiveOrExpression <em>Exclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ExclusiveOrExpression
   * @generated
   */
  public Adapter createExclusiveOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ExclusiveOrExpressionCompletion <em>Exclusive Or Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ExclusiveOrExpressionCompletion
   * @generated
   */
  public Adapter createExclusiveOrExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.InclusiveOrExpression <em>Inclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.InclusiveOrExpression
   * @generated
   */
  public Adapter createInclusiveOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.InclusiveOrExpressionCompletion <em>Inclusive Or Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.InclusiveOrExpressionCompletion
   * @generated
   */
  public Adapter createInclusiveOrExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ConditionalAndExpression <em>Conditional And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ConditionalAndExpression
   * @generated
   */
  public Adapter createConditionalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ConditionalAndExpressionCompletion <em>Conditional And Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ConditionalAndExpressionCompletion
   * @generated
   */
  public Adapter createConditionalAndExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ConditionalOrExpression <em>Conditional Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ConditionalOrExpression
   * @generated
   */
  public Adapter createConditionalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ConditionalOrExpressionCompletion <em>Conditional Or Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ConditionalOrExpressionCompletion
   * @generated
   */
  public Adapter createConditionalOrExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ConditionalExpression
   * @generated
   */
  public Adapter createConditionalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ConditionalExpressionCompletion <em>Conditional Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ConditionalExpressionCompletion
   * @generated
   */
  public Adapter createConditionalExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AssignmentExpressionCompletion <em>Assignment Expression Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AssignmentExpressionCompletion
   * @generated
   */
  public Adapter createAssignmentExpressionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.StatementSequence <em>Statement Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.StatementSequence
   * @generated
   */
  public Adapter createStatementSequenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.DocumentedStatement <em>Documented Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.DocumentedStatement
   * @generated
   */
  public Adapter createDocumentedStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Statement
   * @generated
   */
  public Adapter createStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Block
   * @generated
   */
  public Adapter createBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AnnotatedStatement <em>Annotated Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AnnotatedStatement
   * @generated
   */
  public Adapter createAnnotatedStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Annotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Annotations
   * @generated
   */
  public Adapter createAnnotationsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.Annotation
   * @generated
   */
  public Adapter createAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NameList <em>Name List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NameList
   * @generated
   */
  public Adapter createNameListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.InLineStatement <em>In Line Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.InLineStatement
   * @generated
   */
  public Adapter createInLineStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.BlockStatement <em>Block Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.BlockStatement
   * @generated
   */
  public Adapter createBlockStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.EmptyStatement <em>Empty Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.EmptyStatement
   * @generated
   */
  public Adapter createEmptyStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement <em>Local Name Declaration Or Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement
   * @generated
   */
  public Adapter createLocalNameDeclarationOrExpressionStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement <em>Local Name Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement
   * @generated
   */
  public Adapter createLocalNameDeclarationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatementCompletion <em>Local Name Declaration Statement Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatementCompletion
   * @generated
   */
  public Adapter createLocalNameDeclarationStatementCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.InitializationExpression <em>Initialization Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.InitializationExpression
   * @generated
   */
  public Adapter createInitializationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.InstanceInitializationExpression <em>Instance Initialization Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.InstanceInitializationExpression
   * @generated
   */
  public Adapter createInstanceInitializationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.IfStatement
   * @generated
   */
  public Adapter createIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SequentialClauses <em>Sequential Clauses</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SequentialClauses
   * @generated
   */
  public Adapter createSequentialClausesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ConcurrentClauses <em>Concurrent Clauses</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ConcurrentClauses
   * @generated
   */
  public Adapter createConcurrentClausesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NonFinalClause <em>Non Final Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NonFinalClause
   * @generated
   */
  public Adapter createNonFinalClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.FinalClause <em>Final Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.FinalClause
   * @generated
   */
  public Adapter createFinalClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SwitchStatement <em>Switch Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SwitchStatement
   * @generated
   */
  public Adapter createSwitchStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SwitchClause <em>Switch Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SwitchClause
   * @generated
   */
  public Adapter createSwitchClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SwitchCase <em>Switch Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SwitchCase
   * @generated
   */
  public Adapter createSwitchCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SwitchDefaultClause <em>Switch Default Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SwitchDefaultClause
   * @generated
   */
  public Adapter createSwitchDefaultClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.NonEmptyStatementSequence <em>Non Empty Statement Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.NonEmptyStatementSequence
   * @generated
   */
  public Adapter createNonEmptyStatementSequenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.WhileStatement
   * @generated
   */
  public Adapter createWhileStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.DoStatement <em>Do Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.DoStatement
   * @generated
   */
  public Adapter createDoStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ForStatement
   * @generated
   */
  public Adapter createForStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ForControl <em>For Control</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ForControl
   * @generated
   */
  public Adapter createForControlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition <em>Loop Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.LoopVariableDefinition
   * @generated
   */
  public Adapter createLoopVariableDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.BreakStatement <em>Break Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.BreakStatement
   * @generated
   */
  public Adapter createBreakStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ReturnStatement
   * @generated
   */
  public Adapter createReturnStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AcceptStatement <em>Accept Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AcceptStatement
   * @generated
   */
  public Adapter createAcceptStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.SimpleAcceptStatementCompletion <em>Simple Accept Statement Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.SimpleAcceptStatementCompletion
   * @generated
   */
  public Adapter createSimpleAcceptStatementCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.CompoundAcceptStatementCompletion <em>Compound Accept Statement Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.CompoundAcceptStatementCompletion
   * @generated
   */
  public Adapter createCompoundAcceptStatementCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AcceptBlock <em>Accept Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AcceptBlock
   * @generated
   */
  public Adapter createAcceptBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.AcceptClause <em>Accept Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.AcceptClause
   * @generated
   */
  public Adapter createAcceptClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassifyStatement <em>Classify Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassifyStatement
   * @generated
   */
  public Adapter createClassifyStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassificationClause <em>Classification Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassificationClause
   * @generated
   */
  public Adapter createClassificationClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassificationFromClause <em>Classification From Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassificationFromClause
   * @generated
   */
  public Adapter createClassificationFromClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ClassificationToClause <em>Classification To Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ClassificationToClause
   * @generated
   */
  public Adapter createClassificationToClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.ReclassifyAllClause <em>Reclassify All Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.ReclassifyAllClause
   * @generated
   */
  public Adapter createReclassifyAllClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.alf.alf.QualifiedNameList <em>Qualified Name List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.alf.alf.QualifiedNameList
   * @generated
   */
  public Adapter createQualifiedNameListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AlfAdapterFactory
