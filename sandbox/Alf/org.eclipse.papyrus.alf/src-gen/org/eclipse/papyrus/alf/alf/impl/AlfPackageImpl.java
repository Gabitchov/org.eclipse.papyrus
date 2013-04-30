/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.eclipse.papyrus.alf.alf.AlfFactory;
import org.eclipse.papyrus.alf.alf.AlfPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlfPackageImpl extends EPackageImpl implements AlfPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected String packageFilename = "alf.ecore";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unitDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleaN_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numbeR_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integeR_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unlimiteD_NATURALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass strinG_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stereotypeAnnotationsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stereotypeAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass taggedValuesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass taggedValueListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitivE_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass taggedValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namespaceDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importReferenceQualifiedNameCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass colonQualifiedNameCompletionOfImportReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aliasDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namespaceDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass visibilityIndicatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packagedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packagedElementDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierSignatureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateParametersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierTemplateParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specializationClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classMemberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classMemberDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activeClassDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activeClassDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activeClassDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activeClassBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activeClassMemberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activeClassMemberDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataTypeDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataTypeDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataTypeDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structuredBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structuredMemberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerationDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerationDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerationDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerationBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerationLiteralNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signalDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signalDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signalDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activityDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activityDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activityDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParametersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParameterListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activeFeatureDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeInitializerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typePartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityRangeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unlimitedNaturalLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass redefinitionClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass receptionDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signalReceptionDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signalReceptionDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass colonQualifiedNameCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unqualifiedNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedNameWithoutBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass colonQualifiedNameCompletionWithoutBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass positionalTemplateBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedTemplateBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateParameterSubstitutionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonNameExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameToExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryToExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass baseExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameToPrimaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameOrPrimaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thisExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parenthesizedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass positionalTupleExpressionListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass positionalTupleExpressionListCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedTupleExpressionListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorInvocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureInvocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass superInvocationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceCreationOrSequenceConstructionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkOperationCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkOperationTupleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass indexedNamedExpressionListCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass indexedNamedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classExtentExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceAnyExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceConstructionExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityIndicatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceElementsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceElementListCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceInitializationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass indexEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceOperationOrReductionOrExpansionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prefixExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixOrCastExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonNameUnaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonNamePostfixOrCastExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonPostfixNonCastUnaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanNegationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitStringComplementExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericUnaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass isolationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass castCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicativeExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicativeExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass additiveExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass additiveExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shiftExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shiftExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationalExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exclusiveOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exclusiveOrExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inclusiveOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inclusiveOrExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalAndExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalAndExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalOrExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentExpressionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementSequenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentedStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotatedStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotationsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inLineStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emptyStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localNameDeclarationOrExpressionStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localNameDeclarationStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localNameDeclarationStatementCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initializationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceInitializationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequentialClausesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass concurrentClausesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonFinalClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass finalClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchCaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchDefaultClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonEmptyStatementSequenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whileStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forControlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loopVariableDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass breakStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass returnStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass acceptStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleAcceptStatementCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compoundAcceptStatementCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass acceptBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass acceptClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifyStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationFromClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationToClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reclassifyAllClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedNameListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum importVisibilityIndicatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum parameterDirectionEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum linkOperationEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum affixOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum numericUnaryOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum multiplicativeOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum additiveOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum shiftOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum relationalOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum classificationOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum equalityOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum assignmentOperatorEEnum = null;

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AlfPackageImpl()
  {
    super(eNS_URI, AlfFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link AlfPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @generated
   */
  public static AlfPackage init()
  {
    if (isInited) return (AlfPackage)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI);

    // Obtain or create and register package
    AlfPackageImpl theAlfPackage = (AlfPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AlfPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AlfPackageImpl());

    isInited = true;

    // Load packages
    theAlfPackage.loadPackage();

    // Fix loaded packages
    theAlfPackage.fixPackageContents();

    // Mark meta-data to indicate it can't be changed
    theAlfPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AlfPackage.eNS_URI, theAlfPackage);
    return theAlfPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnitDefinition()
  {
    if (unitDefinitionEClass == null)
    {
      unitDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(0);
    }
    return unitDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitDefinition_NamespaceDeclaration()
  {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitDefinition_ImportDeclarations()
  {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnitDefinition_Comment()
  {
        return (EAttribute)getUnitDefinition().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitDefinition_StereotypeAnnotations()
  {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitDefinition_NamesapceDefinition()
  {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBOOLEAN_LITERAL()
  {
    if (booleaN_LITERALEClass == null)
    {
      booleaN_LITERALEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(1);
    }
    return booleaN_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNUMBER_LITERAL()
  {
    if (numbeR_LITERALEClass == null)
    {
      numbeR_LITERALEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(2);
    }
    return numbeR_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getINTEGER_LITERAL()
  {
    if (integeR_LITERALEClass == null)
    {
      integeR_LITERALEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(3);
    }
    return integeR_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUNLIMITED_NATURAL()
  {
    if (unlimiteD_NATURALEClass == null)
    {
      unlimiteD_NATURALEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(4);
    }
    return unlimiteD_NATURALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSTRING_LITERAL()
  {
    if (strinG_LITERALEClass == null)
    {
      strinG_LITERALEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(5);
    }
    return strinG_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStereotypeAnnotations()
  {
    if (stereotypeAnnotationsEClass == null)
    {
      stereotypeAnnotationsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(6);
    }
    return stereotypeAnnotationsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStereotypeAnnotations_Annotation()
  {
        return (EReference)getStereotypeAnnotations().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStereotypeAnnotation()
  {
    if (stereotypeAnnotationEClass == null)
    {
      stereotypeAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(7);
    }
    return stereotypeAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStereotypeAnnotation_StereotypeName()
  {
        return (EReference)getStereotypeAnnotation().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStereotypeAnnotation_TaggedValues()
  {
        return (EReference)getStereotypeAnnotation().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTaggedValues()
  {
    if (taggedValuesEClass == null)
    {
      taggedValuesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(8);
    }
    return taggedValuesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTaggedValueList()
  {
    if (taggedValueListEClass == null)
    {
      taggedValueListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(9);
    }
    return taggedValueListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTaggedValueList_TaggedValue()
  {
        return (EReference)getTaggedValueList().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPRIMITIVE_LITERAL()
  {
    if (primitivE_LITERALEClass == null)
    {
      primitivE_LITERALEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(10);
    }
    return primitivE_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPRIMITIVE_LITERAL_Value()
  {
        return (EAttribute)getPRIMITIVE_LITERAL().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTaggedValue()
  {
    if (taggedValueEClass == null)
    {
      taggedValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(11);
    }
    return taggedValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTaggedValue_Name()
  {
        return (EReference)getTaggedValue().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTaggedValue_Value()
  {
        return (EReference)getTaggedValue().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamespaceDeclaration()
  {
    if (namespaceDeclarationEClass == null)
    {
      namespaceDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(12);
    }
    return namespaceDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamespaceDeclaration_QualifiedName()
  {
        return (EReference)getNamespaceDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImportDeclaration()
  {
    if (importDeclarationEClass == null)
    {
      importDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(13);
    }
    return importDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImportDeclaration_Visibility()
  {
        return (EAttribute)getImportDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImportDeclaration_ImportReference()
  {
        return (EReference)getImportDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImportReference()
  {
    if (importReferenceEClass == null)
    {
      importReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(15);
    }
    return importReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImportReference_Name()
  {
        return (EReference)getImportReference().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImportReference_Completion()
  {
        return (EReference)getImportReference().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImportReference_Alias()
  {
        return (EReference)getImportReference().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImportReference_Star()
  {
        return (EAttribute)getImportReference().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImportReferenceQualifiedNameCompletion()
  {
    if (importReferenceQualifiedNameCompletionEClass == null)
    {
      importReferenceQualifiedNameCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(16);
    }
    return importReferenceQualifiedNameCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColonQualifiedNameCompletionOfImportReference()
  {
    if (colonQualifiedNameCompletionOfImportReferenceEClass == null)
    {
      colonQualifiedNameCompletionOfImportReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(17);
    }
    return colonQualifiedNameCompletionOfImportReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColonQualifiedNameCompletionOfImportReference_Name()
  {
        return (EReference)getColonQualifiedNameCompletionOfImportReference().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColonQualifiedNameCompletionOfImportReference_Star()
  {
        return (EAttribute)getColonQualifiedNameCompletionOfImportReference().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColonQualifiedNameCompletionOfImportReference_Alias()
  {
        return (EReference)getColonQualifiedNameCompletionOfImportReference().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAliasDefinition()
  {
    if (aliasDefinitionEClass == null)
    {
      aliasDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(18);
    }
    return aliasDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAliasDefinition_Alias()
  {
        return (EReference)getAliasDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamespaceDefinition()
  {
    if (namespaceDefinitionEClass == null)
    {
      namespaceDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(19);
    }
    return namespaceDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVisibilityIndicator()
  {
    if (visibilityIndicatorEClass == null)
    {
      visibilityIndicatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(20);
    }
    return visibilityIndicatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVisibilityIndicator_PUBLIC()
  {
        return (EAttribute)getVisibilityIndicator().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVisibilityIndicator_PRIVATE()
  {
        return (EAttribute)getVisibilityIndicator().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVisibilityIndicator_PROTECTED()
  {
        return (EAttribute)getVisibilityIndicator().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDeclaration()
  {
    if (packageDeclarationEClass == null)
    {
      packageDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(21);
    }
    return packageDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_Name()
  {
        return (EReference)getPackageDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDefinition()
  {
    if (packageDefinitionEClass == null)
    {
      packageDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(22);
    }
    return packageDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDefinition_Declaration()
  {
        return (EReference)getPackageDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDefinition_Body()
  {
        return (EReference)getPackageDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDefinitionOrStub()
  {
    if (packageDefinitionOrStubEClass == null)
    {
      packageDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(23);
    }
    return packageDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDefinitionOrStub_Declaration()
  {
        return (EReference)getPackageDefinitionOrStub().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDefinitionOrStub_Body()
  {
        return (EReference)getPackageDefinitionOrStub().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageBody()
  {
    if (packageBodyEClass == null)
    {
      packageBodyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(24);
    }
    return packageBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageBody_PackagedElement()
  {
        return (EReference)getPackageBody().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackagedElement()
  {
    if (packagedElementEClass == null)
    {
      packagedElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(25);
    }
    return packagedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPackagedElement_Comment()
  {
        return (EAttribute)getPackagedElement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackagedElement_StereotypeAnnotations()
  {
        return (EReference)getPackagedElement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPackagedElement_ImportVisibilityIndicator()
  {
        return (EAttribute)getPackagedElement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackagedElement_PackagedElementDefinition()
  {
        return (EReference)getPackagedElement().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackagedElementDefinition()
  {
    if (packagedElementDefinitionEClass == null)
    {
      packagedElementDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(26);
    }
    return packagedElementDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifierDefinition()
  {
    if (classifierDefinitionEClass == null)
    {
      classifierDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(27);
    }
    return classifierDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifierDefinitionOrStub()
  {
    if (classifierDefinitionOrStubEClass == null)
    {
      classifierDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(28);
    }
    return classifierDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifierSignature()
  {
    if (classifierSignatureEClass == null)
    {
      classifierSignatureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(29);
    }
    return classifierSignatureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierSignature_Name()
  {
        return (EReference)getClassifierSignature().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierSignature_TemplateParameters()
  {
        return (EReference)getClassifierSignature().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierSignature_SpecializationClause()
  {
        return (EReference)getClassifierSignature().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTemplateParameters()
  {
    if (templateParametersEClass == null)
    {
      templateParametersEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(30);
    }
    return templateParametersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateParameters_ClassifierTemplateParameter()
  {
        return (EReference)getTemplateParameters().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifierTemplateParameter()
  {
    if (classifierTemplateParameterEClass == null)
    {
      classifierTemplateParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(31);
    }
    return classifierTemplateParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassifierTemplateParameter_Comment()
  {
        return (EAttribute)getClassifierTemplateParameter().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierTemplateParameter_Name()
  {
        return (EReference)getClassifierTemplateParameter().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierTemplateParameter_QualifiedName()
  {
        return (EReference)getClassifierTemplateParameter().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecializationClause()
  {
    if (specializationClauseEClass == null)
    {
      specializationClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(32);
    }
    return specializationClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecializationClause_QualifiedNameList()
  {
        return (EReference)getSpecializationClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassDeclaration()
  {
    if (classDeclarationEClass == null)
    {
      classDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(33);
    }
    return classDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassDeclaration_IsAbstract()
  {
        return (EAttribute)getClassDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassDeclaration_ClassifierSignature()
  {
        return (EReference)getClassDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassDefinition()
  {
    if (classDefinitionEClass == null)
    {
      classDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(34);
    }
    return classDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassDefinition_ClassDeclaration()
  {
        return (EReference)getClassDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassDefinition_ClassBody()
  {
        return (EReference)getClassDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassDefinitionOrStub()
  {
    if (classDefinitionOrStubEClass == null)
    {
      classDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(35);
    }
    return classDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassDefinitionOrStub_ClassDeclaration()
  {
        return (EReference)getClassDefinitionOrStub().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassDefinitionOrStub_ClassBody()
  {
        return (EReference)getClassDefinitionOrStub().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassBody()
  {
    if (classBodyEClass == null)
    {
      classBodyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(36);
    }
    return classBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassBody_ClassMember()
  {
        return (EReference)getClassBody().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassMember()
  {
    if (classMemberEClass == null)
    {
      classMemberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(37);
    }
    return classMemberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassMember_Comment()
  {
        return (EAttribute)getClassMember().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassMember_StereotypeAnnotations()
  {
        return (EReference)getClassMember().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassMember_VisibilityIndicator()
  {
        return (EReference)getClassMember().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassMember_ClassMemberDefinition()
  {
        return (EReference)getClassMember().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassMemberDefinition()
  {
    if (classMemberDefinitionEClass == null)
    {
      classMemberDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(38);
    }
    return classMemberDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActiveClassDeclaration()
  {
    if (activeClassDeclarationEClass == null)
    {
      activeClassDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(39);
    }
    return activeClassDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActiveClassDeclaration_IsAbstract()
  {
        return (EAttribute)getActiveClassDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassDeclaration_ClassifierSignature()
  {
        return (EReference)getActiveClassDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActiveClassDefinition()
  {
    if (activeClassDefinitionEClass == null)
    {
      activeClassDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(40);
    }
    return activeClassDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassDefinition_ActiveClassDeclaration()
  {
        return (EReference)getActiveClassDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassDefinition_ActiveClassBody()
  {
        return (EReference)getActiveClassDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActiveClassDefinitionOrStub()
  {
    if (activeClassDefinitionOrStubEClass == null)
    {
      activeClassDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(41);
    }
    return activeClassDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassDefinitionOrStub_ActiveClassDeclaration()
  {
        return (EReference)getActiveClassDefinitionOrStub().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassDefinitionOrStub_ActiveClassBody()
  {
        return (EReference)getActiveClassDefinitionOrStub().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActiveClassBody()
  {
    if (activeClassBodyEClass == null)
    {
      activeClassBodyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(42);
    }
    return activeClassBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassBody_ActiveClassMember()
  {
        return (EReference)getActiveClassBody().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassBody_BehaviorClasue()
  {
        return (EReference)getActiveClassBody().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBehaviorClause()
  {
    if (behaviorClauseEClass == null)
    {
      behaviorClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(43);
    }
    return behaviorClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehaviorClause_Block()
  {
        return (EReference)getBehaviorClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehaviorClause_Name()
  {
        return (EReference)getBehaviorClause().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActiveClassMember()
  {
    if (activeClassMemberEClass == null)
    {
      activeClassMemberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(44);
    }
    return activeClassMemberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActiveClassMember_Comment()
  {
        return (EAttribute)getActiveClassMember().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassMember_StereotypeAnnotations()
  {
        return (EReference)getActiveClassMember().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassMember_VisibilityIndicator()
  {
        return (EReference)getActiveClassMember().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveClassMember_ActiveClassMemberDefinition()
  {
        return (EReference)getActiveClassMember().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActiveClassMemberDefinition()
  {
    if (activeClassMemberDefinitionEClass == null)
    {
      activeClassMemberDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(45);
    }
    return activeClassMemberDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataTypeDeclaration()
  {
    if (dataTypeDeclarationEClass == null)
    {
      dataTypeDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(46);
    }
    return dataTypeDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDataTypeDeclaration_IsAbstract()
  {
        return (EAttribute)getDataTypeDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataTypeDeclaration_ClassifierSignature()
  {
        return (EReference)getDataTypeDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataTypeDefinition()
  {
    if (dataTypeDefinitionEClass == null)
    {
      dataTypeDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(47);
    }
    return dataTypeDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataTypeDefinition_DataTypeDeclaration()
  {
        return (EReference)getDataTypeDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataTypeDefinition_StructureBody()
  {
        return (EReference)getDataTypeDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataTypeDefinitionOrStub()
  {
    if (dataTypeDefinitionOrStubEClass == null)
    {
      dataTypeDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(48);
    }
    return dataTypeDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataTypeDefinitionOrStub_DataTypeDeclaration()
  {
        return (EReference)getDataTypeDefinitionOrStub().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataTypeDefinitionOrStub_StructureBody()
  {
        return (EReference)getDataTypeDefinitionOrStub().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructuredBody()
  {
    if (structuredBodyEClass == null)
    {
      structuredBodyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(49);
    }
    return structuredBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructuredBody_StructuredMember()
  {
        return (EReference)getStructuredBody().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructuredMember()
  {
    if (structuredMemberEClass == null)
    {
      structuredMemberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(50);
    }
    return structuredMemberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructuredMember_Comment()
  {
        return (EAttribute)getStructuredMember().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructuredMember_StreotypeAnnotations()
  {
        return (EReference)getStructuredMember().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructuredMember_IsPublic()
  {
        return (EAttribute)getStructuredMember().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructuredMember_PropertyDefinition()
  {
        return (EReference)getStructuredMember().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationDeclaration()
  {
    if (associationDeclarationEClass == null)
    {
      associationDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(51);
    }
    return associationDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssociationDeclaration_IsAbstract()
  {
        return (EAttribute)getAssociationDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationDeclaration_ClassifierSignature()
  {
        return (EReference)getAssociationDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationDefinition()
  {
    if (associationDefinitionEClass == null)
    {
      associationDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(52);
    }
    return associationDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationDefinition_AssociationDeclaration()
  {
        return (EReference)getAssociationDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationDefinition_StructuredBody()
  {
        return (EReference)getAssociationDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationDefinitionOrStub()
  {
    if (associationDefinitionOrStubEClass == null)
    {
      associationDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(53);
    }
    return associationDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationDefinitionOrStub_AssociationDeclaration()
  {
        return (EReference)getAssociationDefinitionOrStub().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationDefinitionOrStub_StructuredBody()
  {
        return (EReference)getAssociationDefinitionOrStub().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerationDeclaration()
  {
    if (enumerationDeclarationEClass == null)
    {
      enumerationDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(54);
    }
    return enumerationDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationDeclaration_Name()
  {
        return (EReference)getEnumerationDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationDeclaration_SpecializationClause()
  {
        return (EReference)getEnumerationDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerationDefinition()
  {
    if (enumerationDefinitionEClass == null)
    {
      enumerationDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(55);
    }
    return enumerationDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationDefinition_EnumerationClause()
  {
        return (EReference)getEnumerationDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationDefinition_EnumerationBody()
  {
        return (EReference)getEnumerationDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerationDefinitionOrStub()
  {
    if (enumerationDefinitionOrStubEClass == null)
    {
      enumerationDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(56);
    }
    return enumerationDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationDefinitionOrStub_EnumerationDeclaration()
  {
        return (EReference)getEnumerationDefinitionOrStub().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationDefinitionOrStub_EnumerationBody()
  {
        return (EReference)getEnumerationDefinitionOrStub().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerationBody()
  {
    if (enumerationBodyEClass == null)
    {
      enumerationBodyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(57);
    }
    return enumerationBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationBody_EnumerationLiteralName()
  {
        return (EReference)getEnumerationBody().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerationLiteralName()
  {
    if (enumerationLiteralNameEClass == null)
    {
      enumerationLiteralNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(58);
    }
    return enumerationLiteralNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumerationLiteralName_Comment()
  {
        return (EAttribute)getEnumerationLiteralName().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationLiteralName_Name()
  {
        return (EReference)getEnumerationLiteralName().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignalDeclaration()
  {
    if (signalDeclarationEClass == null)
    {
      signalDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(59);
    }
    return signalDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSignalDeclaration_IsAbstract()
  {
        return (EAttribute)getSignalDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignalDeclaration_ClassifierSignature()
  {
        return (EReference)getSignalDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignalDefinition()
  {
    if (signalDefinitionEClass == null)
    {
      signalDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(60);
    }
    return signalDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignalDefinition_SignalDeclaration()
  {
        return (EReference)getSignalDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignalDefinition_StructuredBody()
  {
        return (EReference)getSignalDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignalDefinitionOrStub()
  {
    if (signalDefinitionOrStubEClass == null)
    {
      signalDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(61);
    }
    return signalDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignalDefinitionOrStub_SignalDeclaration()
  {
        return (EReference)getSignalDefinitionOrStub().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignalDefinitionOrStub_StructuredBody()
  {
        return (EReference)getSignalDefinitionOrStub().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActivityDeclaration()
  {
    if (activityDeclarationEClass == null)
    {
      activityDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(62);
    }
    return activityDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityDeclaration_Name()
  {
        return (EReference)getActivityDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityDeclaration_TemplateParameters()
  {
        return (EReference)getActivityDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityDeclaration_FormalParameters()
  {
        return (EReference)getActivityDeclaration().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityDeclaration_TypePart()
  {
        return (EReference)getActivityDeclaration().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActivityDefinition()
  {
    if (activityDefinitionEClass == null)
    {
      activityDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(63);
    }
    return activityDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityDefinition_ActivityDeclaration()
  {
        return (EReference)getActivityDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityDefinition_Block()
  {
        return (EReference)getActivityDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActivityDefinitionOrStub()
  {
    if (activityDefinitionOrStubEClass == null)
    {
      activityDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(64);
    }
    return activityDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityDefinitionOrStub_ActivityDeclaration()
  {
        return (EReference)getActivityDefinitionOrStub().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityDefinitionOrStub_Block()
  {
        return (EReference)getActivityDefinitionOrStub().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameters()
  {
    if (formalParametersEClass == null)
    {
      formalParametersEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(65);
    }
    return formalParametersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameters_FormalParameterList()
  {
        return (EReference)getFormalParameters().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameterList()
  {
    if (formalParameterListEClass == null)
    {
      formalParameterListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(66);
    }
    return formalParameterListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameterList_FormalParameter()
  {
        return (EReference)getFormalParameterList().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameter()
  {
    if (formalParameterEClass == null)
    {
      formalParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(67);
    }
    return formalParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFormalParameter_Comment()
  {
        return (EAttribute)getFormalParameter().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameter_StereotypeAnnotations()
  {
        return (EReference)getFormalParameter().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFormalParameter_ParameterDirection()
  {
        return (EAttribute)getFormalParameter().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameter_Name()
  {
        return (EReference)getFormalParameter().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameter_TypePart()
  {
        return (EReference)getFormalParameter().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeatureDefinitionOrStub()
  {
    if (featureDefinitionOrStubEClass == null)
    {
      featureDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(69);
    }
    return featureDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActiveFeatureDefinitionOrStub()
  {
    if (activeFeatureDefinitionOrStubEClass == null)
    {
      activeFeatureDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(70);
    }
    return activeFeatureDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyDefinition()
  {
    if (propertyDefinitionEClass == null)
    {
      propertyDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(71);
    }
    return propertyDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyDefinition_PropertyDeclaration()
  {
        return (EReference)getPropertyDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeDefinition()
  {
    if (attributeDefinitionEClass == null)
    {
      attributeDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(72);
    }
    return attributeDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeDefinition_PropertyDeclaration()
  {
        return (EReference)getAttributeDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeDefinition_AttributeInitializer()
  {
        return (EReference)getAttributeDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeInitializer()
  {
    if (attributeInitializerEClass == null)
    {
      attributeInitializerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(73);
    }
    return attributeInitializerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeInitializer_InitializationExpression()
  {
        return (EReference)getAttributeInitializer().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyDeclaration()
  {
    if (propertyDeclarationEClass == null)
    {
      propertyDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(74);
    }
    return propertyDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyDeclaration_Name()
  {
        return (EReference)getPropertyDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPropertyDeclaration_IsComposite()
  {
        return (EAttribute)getPropertyDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyDeclaration_TypePart()
  {
        return (EReference)getPropertyDeclaration().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypePart()
  {
    if (typePartEClass == null)
    {
      typePartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(75);
    }
    return typePartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypePart_TypeName()
  {
        return (EReference)getTypePart().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypePart_Multiplicity()
  {
        return (EReference)getTypePart().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeName()
  {
    if (typeNameEClass == null)
    {
      typeNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(76);
    }
    return typeNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeName_QualifiedName()
  {
        return (EReference)getTypeName().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeName_Any()
  {
        return (EAttribute)getTypeName().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicity()
  {
    if (multiplicityEClass == null)
    {
      multiplicityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(77);
    }
    return multiplicityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicity_MultiplicityRange()
  {
        return (EReference)getMultiplicity().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity_IsOrdered()
  {
        return (EAttribute)getMultiplicity().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity_IsNonUnique()
  {
        return (EAttribute)getMultiplicity().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity_IsSequence()
  {
        return (EAttribute)getMultiplicity().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicityRange()
  {
    if (multiplicityRangeEClass == null)
    {
      multiplicityRangeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(78);
    }
    return multiplicityRangeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicityRange_Lower()
  {
        return (EReference)getMultiplicityRange().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicityRange_Upper()
  {
        return (EReference)getMultiplicityRange().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnlimitedNaturalLiteral()
  {
    if (unlimitedNaturalLiteralEClass == null)
    {
      unlimitedNaturalLiteralEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(79);
    }
    return unlimitedNaturalLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnlimitedNaturalLiteral_Integer()
  {
        return (EReference)getUnlimitedNaturalLiteral().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnlimitedNaturalLiteral_Star()
  {
        return (EAttribute)getUnlimitedNaturalLiteral().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationDeclaration()
  {
    if (operationDeclarationEClass == null)
    {
      operationDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(80);
    }
    return operationDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationDeclaration_IsAbstract()
  {
        return (EAttribute)getOperationDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDeclaration_Name()
  {
        return (EReference)getOperationDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDeclaration_FormalParameters()
  {
        return (EReference)getOperationDeclaration().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDeclaration_TypePart()
  {
        return (EReference)getOperationDeclaration().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDeclaration_RedefinitionClause()
  {
        return (EReference)getOperationDeclaration().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDeclaration_Block()
  {
        return (EReference)getOperationDeclaration().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationDefinitionOrStub()
  {
    if (operationDefinitionOrStubEClass == null)
    {
      operationDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(81);
    }
    return operationDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRedefinitionClause()
  {
    if (redefinitionClauseEClass == null)
    {
      redefinitionClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(82);
    }
    return redefinitionClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRedefinitionClause_QualifiedNameList()
  {
        return (EReference)getRedefinitionClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReceptionDefinition()
  {
    if (receptionDefinitionEClass == null)
    {
      receptionDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(83);
    }
    return receptionDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReceptionDefinition_ReceptionName()
  {
        return (EReference)getReceptionDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignalReceptionDeclaration()
  {
    if (signalReceptionDeclarationEClass == null)
    {
      signalReceptionDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(84);
    }
    return signalReceptionDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignalReceptionDeclaration_SignalName()
  {
        return (EReference)getSignalReceptionDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignalReceptionDeclaration_SpecializationClause()
  {
        return (EReference)getSignalReceptionDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignalReceptionDefinitionOrStub()
  {
    if (signalReceptionDefinitionOrStubEClass == null)
    {
      signalReceptionDefinitionOrStubEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(85);
    }
    return signalReceptionDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignalReceptionDefinitionOrStub_SignalReceptionOrDeclaration()
  {
        return (EReference)getSignalReceptionDefinitionOrStub().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignalReceptionDefinitionOrStub_StructuredBody()
  {
        return (EReference)getSignalReceptionDefinitionOrStub().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getName_()
  {
    if (nameEClass == null)
    {
      nameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(86);
    }
    return nameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getName_Id()
  {
        return (EAttribute)getName_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedName()
  {
    if (qualifiedNameEClass == null)
    {
      qualifiedNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(87);
    }
    return qualifiedNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedName_Unqualified()
  {
        return (EReference)getQualifiedName().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedName_NameCompletion()
  {
        return (EReference)getQualifiedName().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColonQualifiedNameCompletion()
  {
    if (colonQualifiedNameCompletionEClass == null)
    {
      colonQualifiedNameCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(88);
    }
    return colonQualifiedNameCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColonQualifiedNameCompletion_NamedBindings()
  {
        return (EReference)getColonQualifiedNameCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnqualifiedName()
  {
    if (unqualifiedNameEClass == null)
    {
      unqualifiedNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(89);
    }
    return unqualifiedNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameBinding()
  {
    if (nameBindingEClass == null)
    {
      nameBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(90);
    }
    return nameBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameBinding_Name()
  {
        return (EReference)getNameBinding().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameBinding_TemplateBinding()
  {
        return (EReference)getNameBinding().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedNameWithoutBinding()
  {
    if (qualifiedNameWithoutBindingEClass == null)
    {
      qualifiedNameWithoutBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(91);
    }
    return qualifiedNameWithoutBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedNameWithoutBinding_Unqualified()
  {
        return (EReference)getQualifiedNameWithoutBinding().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedNameWithoutBinding_NameCompletion()
  {
        return (EReference)getQualifiedNameWithoutBinding().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColonQualifiedNameCompletionWithoutBinding()
  {
    if (colonQualifiedNameCompletionWithoutBindingEClass == null)
    {
      colonQualifiedNameCompletionWithoutBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(92);
    }
    return colonQualifiedNameCompletionWithoutBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColonQualifiedNameCompletionWithoutBinding_Names()
  {
        return (EReference)getColonQualifiedNameCompletionWithoutBinding().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTemplateBinding()
  {
    if (templateBindingEClass == null)
    {
      templateBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(93);
    }
    return templateBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPositionalTemplateBinding()
  {
    if (positionalTemplateBindingEClass == null)
    {
      positionalTemplateBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(94);
    }
    return positionalTemplateBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPositionalTemplateBinding_QualifiedName()
  {
        return (EReference)getPositionalTemplateBinding().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedTemplateBinding()
  {
    if (namedTemplateBindingEClass == null)
    {
      namedTemplateBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(95);
    }
    return namedTemplateBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedTemplateBinding_TemplateParameterSubstitution()
  {
        return (EReference)getNamedTemplateBinding().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTemplateParameterSubstitution()
  {
    if (templateParameterSubstitutionEClass == null)
    {
      templateParameterSubstitutionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(96);
    }
    return templateParameterSubstitutionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateParameterSubstitution_Name()
  {
        return (EReference)getTemplateParameterSubstitution().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateParameterSubstitution_QualifiedName()
  {
        return (EReference)getTemplateParameterSubstitution().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    if (expressionEClass == null)
    {
      expressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(97);
    }
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_UnaryExpression()
  {
        return (EReference)getExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_ExpressionCompletion()
  {
        return (EReference)getExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonNameExpression()
  {
    if (nonNameExpressionEClass == null)
    {
      nonNameExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(98);
    }
    return nonNameExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonNameExpression_NonNameUnaryExpression()
  {
        return (EReference)getNonNameExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonNameExpression_ExpressionCompletion()
  {
        return (EReference)getNonNameExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameToExpressionCompletion()
  {
    if (nameToExpressionCompletionEClass == null)
    {
      nameToExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(99);
    }
    return nameToExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameToExpressionCompletion_NameToPrimary()
  {
        return (EReference)getNameToExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameToExpressionCompletion_PrimaryToExpressionCompletion()
  {
        return (EReference)getNameToExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryToExpressionCompletion()
  {
    if (primaryToExpressionCompletionEClass == null)
    {
      primaryToExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(100);
    }
    return primaryToExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryToExpressionCompletion_PostFixExpressionCompletion()
  {
        return (EReference)getPrimaryToExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryToExpressionCompletion_ExpressionCompletion()
  {
        return (EReference)getPrimaryToExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionCompletion()
  {
    if (expressionCompletionEClass == null)
    {
      expressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(101);
    }
    return expressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionCompletion_Expression()
  {
        return (EReference)getExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryExpression()
  {
    if (primaryExpressionEClass == null)
    {
      primaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(102);
    }
    return primaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_NameOrPrimaryExpression()
  {
        return (EReference)getPrimaryExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_BaseExpression()
  {
        return (EReference)getPrimaryExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_ParenthesizedExpression()
  {
        return (EReference)getPrimaryExpression().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_PrimaryExpressionCompletion()
  {
        return (EReference)getPrimaryExpression().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBaseExpression()
  {
    if (baseExpressionEClass == null)
    {
      baseExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(103);
    }
    return baseExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameToPrimaryExpression()
  {
    if (nameToPrimaryExpressionEClass == null)
    {
      nameToPrimaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(104);
    }
    return nameToPrimaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameToPrimaryExpression_LinkOperationCompletion()
  {
        return (EReference)getNameToPrimaryExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameToPrimaryExpression_ClassExtentExpressionCompletion()
  {
        return (EReference)getNameToPrimaryExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameToPrimaryExpression_SequenceConstructionCompletion()
  {
        return (EReference)getNameToPrimaryExpression().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameToPrimaryExpression_BehaviorInvocation()
  {
        return (EReference)getNameToPrimaryExpression().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryExpressionCompletion()
  {
    if (primaryExpressionCompletionEClass == null)
    {
      primaryExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(105);
    }
    return primaryExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpressionCompletion_Content()
  {
        return (EReference)getPrimaryExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index()
  {
    if (feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexEClass == null)
    {
      feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(106);
    }
    return feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index_Feature()
  {
        return (EReference)getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index_FeatureInvocation()
  {
        return (EReference)getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index_SequenceOperationOrReductionOrExpansion()
  {
        return (EReference)getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index_Index()
  {
        return (EReference)getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteralExpression()
  {
    if (literalExpressionEClass == null)
    {
      literalExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(107);
    }
    return literalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLiteralExpression_Expression()
  {
        return (EReference)getLiteralExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameOrPrimaryExpression()
  {
    if (nameOrPrimaryExpressionEClass == null)
    {
      nameOrPrimaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(108);
    }
    return nameOrPrimaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameOrPrimaryExpression_PotentiallyAmbiguousQualifiedName()
  {
        return (EReference)getNameOrPrimaryExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameOrPrimaryExpression_NameToPrimaryExpression()
  {
        return (EReference)getNameOrPrimaryExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThisExpression()
  {
    if (thisExpressionEClass == null)
    {
      thisExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(109);
    }
    return thisExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThisExpression_Tuple()
  {
        return (EReference)getThisExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParenthesizedExpression()
  {
    if (parenthesizedExpressionEClass == null)
    {
      parenthesizedExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(110);
    }
    return parenthesizedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParenthesizedExpression_Expression()
  {
        return (EReference)getParenthesizedExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeature()
  {
    if (featureEClass == null)
    {
      featureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(111);
    }
    return featureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Name()
  {
        return (EReference)getFeature().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTuple()
  {
    if (tupleEClass == null)
    {
      tupleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(112);
    }
    return tupleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTuple_NamedTupleExpressionList()
  {
        return (EReference)getTuple().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTuple_PositionalTupleExpressionList()
  {
        return (EReference)getTuple().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPositionalTupleExpressionList()
  {
    if (positionalTupleExpressionListEClass == null)
    {
      positionalTupleExpressionListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(113);
    }
    return positionalTupleExpressionListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPositionalTupleExpressionList_Expression()
  {
        return (EReference)getPositionalTupleExpressionList().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPositionalTupleExpressionListCompletion()
  {
    if (positionalTupleExpressionListCompletionEClass == null)
    {
      positionalTupleExpressionListCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(114);
    }
    return positionalTupleExpressionListCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPositionalTupleExpressionListCompletion_Expression()
  {
        return (EReference)getPositionalTupleExpressionListCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedTupleExpressionList()
  {
    if (namedTupleExpressionListEClass == null)
    {
      namedTupleExpressionListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(115);
    }
    return namedTupleExpressionListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedTupleExpressionList_NamedExpression()
  {
        return (EReference)getNamedTupleExpressionList().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedExpression()
  {
    if (namedExpressionEClass == null)
    {
      namedExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(116);
    }
    return namedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedExpression_Name()
  {
        return (EReference)getNamedExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedExpression_Expression()
  {
        return (EReference)getNamedExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBehaviorInvocation()
  {
    if (behaviorInvocationEClass == null)
    {
      behaviorInvocationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(117);
    }
    return behaviorInvocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehaviorInvocation_Tuple()
  {
        return (EReference)getBehaviorInvocation().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeatureInvocation()
  {
    if (featureInvocationEClass == null)
    {
      featureInvocationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(118);
    }
    return featureInvocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureInvocation_Tuple()
  {
        return (EReference)getFeatureInvocation().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuperInvocationExpression()
  {
    if (superInvocationExpressionEClass == null)
    {
      superInvocationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(119);
    }
    return superInvocationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuperInvocationExpression_QualifiedName()
  {
        return (EReference)getSuperInvocationExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuperInvocationExpression_Tuple()
  {
        return (EReference)getSuperInvocationExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstanceCreationOrSequenceConstructionExpression()
  {
    if (instanceCreationOrSequenceConstructionExpressionEClass == null)
    {
      instanceCreationOrSequenceConstructionExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(120);
    }
    return instanceCreationOrSequenceConstructionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationOrSequenceConstructionExpression_QualifiedName()
  {
        return (EReference)getInstanceCreationOrSequenceConstructionExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationOrSequenceConstructionExpression_SequenceConstructionExpressionCompletion()
  {
        return (EReference)getInstanceCreationOrSequenceConstructionExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationOrSequenceConstructionExpression_Tuple()
  {
        return (EReference)getInstanceCreationOrSequenceConstructionExpression().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLinkOperationCompletion()
  {
    if (linkOperationCompletionEClass == null)
    {
      linkOperationCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(121);
    }
    return linkOperationCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLinkOperationCompletion_LinkOperation()
  {
        return (EAttribute)getLinkOperationCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationCompletion_LinkOperationTuple()
  {
        return (EReference)getLinkOperationCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLinkOperationTuple()
  {
    if (linkOperationTupleEClass == null)
    {
      linkOperationTupleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(123);
    }
    return linkOperationTupleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTuple_Name()
  {
        return (EReference)getLinkOperationTuple().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTuple_Index()
  {
        return (EReference)getLinkOperationTuple().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTuple_IndexNamedExpressionListCompletion()
  {
        return (EReference)getLinkOperationTuple().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTuple_PrimaryToExpressionCompletion()
  {
        return (EReference)getLinkOperationTuple().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTuple_PositionalTupleExpressionListCompletion()
  {
        return (EReference)getLinkOperationTuple().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTuple_IndexedNamedExpressionListCompletion()
  {
        return (EReference)getLinkOperationTuple().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTuple_NameToExpressionCompletion()
  {
        return (EReference)getLinkOperationTuple().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTuple_PositionalTupleExpressionList()
  {
        return (EReference)getLinkOperationTuple().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIndexedNamedExpressionListCompletion()
  {
    if (indexedNamedExpressionListCompletionEClass == null)
    {
      indexedNamedExpressionListCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(124);
    }
    return indexedNamedExpressionListCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexedNamedExpressionListCompletion_Expression()
  {
        return (EReference)getIndexedNamedExpressionListCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexedNamedExpressionListCompletion_IndexedNamedExpression()
  {
        return (EReference)getIndexedNamedExpressionListCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIndexedNamedExpression()
  {
    if (indexedNamedExpressionEClass == null)
    {
      indexedNamedExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(125);
    }
    return indexedNamedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexedNamedExpression_Name()
  {
        return (EReference)getIndexedNamedExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexedNamedExpression_Index()
  {
        return (EReference)getIndexedNamedExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexedNamedExpression_Expression()
  {
        return (EReference)getIndexedNamedExpression().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassExtentExpressionCompletion()
  {
    if (classExtentExpressionCompletionEClass == null)
    {
      classExtentExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(126);
    }
    return classExtentExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceAnyExpression()
  {
    if (sequenceAnyExpressionEClass == null)
    {
      sequenceAnyExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(127);
    }
    return sequenceAnyExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceAnyExpression_SequenceConstructionExpressionCompletion()
  {
        return (EReference)getSequenceAnyExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceConstructionExpressionCompletion()
  {
    if (sequenceConstructionExpressionCompletionEClass == null)
    {
      sequenceConstructionExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(128);
    }
    return sequenceConstructionExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceConstructionExpressionCompletion_MultiplicityIndicator()
  {
        return (EReference)getSequenceConstructionExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceConstructionExpressionCompletion_SequenceElements()
  {
        return (EReference)getSequenceConstructionExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicityIndicator()
  {
    if (multiplicityIndicatorEClass == null)
    {
      multiplicityIndicatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(129);
    }
    return multiplicityIndicatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceElements()
  {
    if (sequenceElementsEClass == null)
    {
      sequenceElementsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(130);
    }
    return sequenceElementsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceElements_Expression1()
  {
        return (EReference)getSequenceElements().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceElements_Expression2()
  {
        return (EReference)getSequenceElements().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceElements_SequenceElementListCompletion()
  {
        return (EReference)getSequenceElements().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceElements_SequenceInitializationExpression()
  {
        return (EReference)getSequenceElements().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceElementListCompletion()
  {
    if (sequenceElementListCompletionEClass == null)
    {
      sequenceElementListCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(131);
    }
    return sequenceElementListCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceElementListCompletion_SequenceElement()
  {
        return (EReference)getSequenceElementListCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceElement()
  {
    if (sequenceElementEClass == null)
    {
      sequenceElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(132);
    }
    return sequenceElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceElement_Expression()
  {
        return (EReference)getSequenceElement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceElement_SequenceInitializationExpression()
  {
        return (EReference)getSequenceElement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceInitializationExpression()
  {
    if (sequenceInitializationExpressionEClass == null)
    {
      sequenceInitializationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(133);
    }
    return sequenceInitializationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceInitializationExpression_IsNew()
  {
        return (EAttribute)getSequenceInitializationExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceInitializationExpression_SequenceElements()
  {
        return (EReference)getSequenceInitializationExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIndex()
  {
    if (indexEClass == null)
    {
      indexEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(134);
    }
    return indexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndex_Expression()
  {
        return (EReference)getIndex().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceOperationOrReductionOrExpansion()
  {
    if (sequenceOperationOrReductionOrExpansionEClass == null)
    {
      sequenceOperationOrReductionOrExpansionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(135);
    }
    return sequenceOperationOrReductionOrExpansionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceOperationOrReductionOrExpansion_QualifiedName()
  {
        return (EReference)getSequenceOperationOrReductionOrExpansion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceOperationOrReductionOrExpansion_Tuple()
  {
        return (EReference)getSequenceOperationOrReductionOrExpansion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceOperationOrReductionOrExpansion_IsReduce()
  {
        return (EAttribute)getSequenceOperationOrReductionOrExpansion().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceOperationOrReductionOrExpansion_IsOrdered()
  {
        return (EAttribute)getSequenceOperationOrReductionOrExpansion().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceOperationOrReductionOrExpansion_TemplateBinding()
  {
        return (EReference)getSequenceOperationOrReductionOrExpansion().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceOperationOrReductionOrExpansion_Id()
  {
        return (EAttribute)getSequenceOperationOrReductionOrExpansion().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceOperationOrReductionOrExpansion_Name()
  {
        return (EReference)getSequenceOperationOrReductionOrExpansion().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceOperationOrReductionOrExpansion_Expression()
  {
        return (EReference)getSequenceOperationOrReductionOrExpansion().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpressionCompletion()
  {
    if (postfixExpressionCompletionEClass == null)
    {
      postfixExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(136);
    }
    return postfixExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixExpressionCompletion_PrimaryExpressionCompletion()
  {
        return (EReference)getPostfixExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixExpressionCompletion_PostfixOperation()
  {
        return (EReference)getPostfixExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixOperation()
  {
    if (postfixOperationEClass == null)
    {
      postfixOperationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(137);
    }
    return postfixOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPostfixOperation_Operator()
  {
        return (EAttribute)getPostfixOperation().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrefixExpression()
  {
    if (prefixExpressionEClass == null)
    {
      prefixExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(138);
    }
    return prefixExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrefixExpression_Operator()
  {
        return (EAttribute)getPrefixExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrefixExpression_PrimaryExpression()
  {
        return (EReference)getPrefixExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryExpression()
  {
    if (unaryExpressionEClass == null)
    {
      unaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(140);
    }
    return unaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixOrCastExpression()
  {
    if (postfixOrCastExpressionEClass == null)
    {
      postfixOrCastExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(141);
    }
    return postfixOrCastExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixOrCastExpression_NonNamePostfixOrCastExpression()
  {
        return (EReference)getPostfixOrCastExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixOrCastExpression_NameOrPrimaryExpression()
  {
        return (EReference)getPostfixOrCastExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixOrCastExpression_PostFixExpressionCompletion()
  {
        return (EReference)getPostfixOrCastExpression().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonNameUnaryExpression()
  {
    if (nonNameUnaryExpressionEClass == null)
    {
      nonNameUnaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(142);
    }
    return nonNameUnaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonNamePostfixOrCastExpression()
  {
    if (nonNamePostfixOrCastExpressionEClass == null)
    {
      nonNamePostfixOrCastExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(143);
    }
    return nonNamePostfixOrCastExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNonNamePostfixOrCastExpression_Any()
  {
        return (EAttribute)getNonNamePostfixOrCastExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonNamePostfixOrCastExpression_CastCompletion()
  {
        return (EReference)getNonNamePostfixOrCastExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonNamePostfixOrCastExpression_PotentiallyAmbiguousQualifiedName()
  {
        return (EReference)getNonNamePostfixOrCastExpression().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonNamePostfixOrCastExpression_PostifixExpressionCompletion()
  {
        return (EReference)getNonNamePostfixOrCastExpression().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonNamePostfixOrCastExpression_NameToExpressionCompletion()
  {
        return (EReference)getNonNamePostfixOrCastExpression().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonNamePostfixOrCastExpression_PostfixExpressionCompletion()
  {
        return (EReference)getNonNamePostfixOrCastExpression().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonNamePostfixOrCastExpression_NonNameExpression()
  {
        return (EReference)getNonNamePostfixOrCastExpression().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonNamePostfixOrCastExpression_BaseExpression()
  {
        return (EReference)getNonNamePostfixOrCastExpression().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonPostfixNonCastUnaryExpression()
  {
    if (nonPostfixNonCastUnaryExpressionEClass == null)
    {
      nonPostfixNonCastUnaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(144);
    }
    return nonPostfixNonCastUnaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanNegationExpression()
  {
    if (booleanNegationExpressionEClass == null)
    {
      booleanNegationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(145);
    }
    return booleanNegationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBooleanNegationExpression_UnaryExpression()
  {
        return (EReference)getBooleanNegationExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitStringComplementExpression()
  {
    if (bitStringComplementExpressionEClass == null)
    {
      bitStringComplementExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(146);
    }
    return bitStringComplementExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitStringComplementExpression_UnaryExpression()
  {
        return (EReference)getBitStringComplementExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericUnaryExpression()
  {
    if (numericUnaryExpressionEClass == null)
    {
      numericUnaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(147);
    }
    return numericUnaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumericUnaryExpression_Operator()
  {
        return (EAttribute)getNumericUnaryExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericUnaryExpression_UnaryExpression()
  {
        return (EReference)getNumericUnaryExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIsolationExpression()
  {
    if (isolationExpressionEClass == null)
    {
      isolationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(149);
    }
    return isolationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIsolationExpression_UnaryExpression()
  {
        return (EReference)getIsolationExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCastCompletion()
  {
    if (castCompletionEClass == null)
    {
      castCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(150);
    }
    return castCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicativeExpression()
  {
    if (multiplicativeExpressionEClass == null)
    {
      multiplicativeExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(151);
    }
    return multiplicativeExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicativeExpression_UnaryExpression()
  {
        return (EReference)getMultiplicativeExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicativeExpression_MultiplicativeExpressionCompletion()
  {
        return (EReference)getMultiplicativeExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicativeExpressionCompletion()
  {
    if (multiplicativeExpressionCompletionEClass == null)
    {
      multiplicativeExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(152);
    }
    return multiplicativeExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicativeExpressionCompletion_Operator()
  {
        return (EAttribute)getMultiplicativeExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicativeExpressionCompletion_UnaryExpression()
  {
        return (EReference)getMultiplicativeExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdditiveExpression()
  {
    if (additiveExpressionEClass == null)
    {
      additiveExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(154);
    }
    return additiveExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpression_UnaryExpression()
  {
        return (EReference)getAdditiveExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpression_AdditiveExpressionCompletion()
  {
        return (EReference)getAdditiveExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdditiveExpressionCompletion()
  {
    if (additiveExpressionCompletionEClass == null)
    {
      additiveExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(155);
    }
    return additiveExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpressionCompletion_MultiplicativeExpressionCompletion()
  {
        return (EReference)getAdditiveExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAdditiveExpressionCompletion_Operator()
  {
        return (EAttribute)getAdditiveExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpressionCompletion_MultiplicativeExpression()
  {
        return (EReference)getAdditiveExpressionCompletion().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShiftExpression()
  {
    if (shiftExpressionEClass == null)
    {
      shiftExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(157);
    }
    return shiftExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_UnaryExpression()
  {
        return (EReference)getShiftExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_ShiftExpressionCompletion()
  {
        return (EReference)getShiftExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShiftExpressionCompletion()
  {
    if (shiftExpressionCompletionEClass == null)
    {
      shiftExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(158);
    }
    return shiftExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpressionCompletion_AdditiveExpressionCompletion()
  {
        return (EReference)getShiftExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShiftExpressionCompletion_Operator()
  {
        return (EAttribute)getShiftExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpressionCompletion_AdditiveExpression()
  {
        return (EReference)getShiftExpressionCompletion().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationalExpression()
  {
    if (relationalExpressionEClass == null)
    {
      relationalExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(160);
    }
    return relationalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_UnaryExpression()
  {
        return (EReference)getRelationalExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_RelationalExpressionCompletion()
  {
        return (EReference)getRelationalExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationalExpressionCompletion()
  {
    if (relationalExpressionCompletionEClass == null)
    {
      relationalExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(161);
    }
    return relationalExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpressionCompletion_ShiftExpressionCompletion()
  {
        return (EReference)getRelationalExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationalExpressionCompletion_RelationalOperator()
  {
        return (EAttribute)getRelationalExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpressionCompletion_ShiftExpression()
  {
        return (EReference)getRelationalExpressionCompletion().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationExpression()
  {
    if (classificationExpressionEClass == null)
    {
      classificationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(163);
    }
    return classificationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationExpression_UnaryExpression()
  {
        return (EReference)getClassificationExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationExpression_ClassificationExpressionCompletion()
  {
        return (EReference)getClassificationExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationExpressionCompletion()
  {
    if (classificationExpressionCompletionEClass == null)
    {
      classificationExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(164);
    }
    return classificationExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationExpressionCompletion_RelationalExpressionCompletion()
  {
        return (EReference)getClassificationExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassificationExpressionCompletion_Operator()
  {
        return (EAttribute)getClassificationExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationExpressionCompletion_Name()
  {
        return (EReference)getClassificationExpressionCompletion().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityExpression()
  {
    if (equalityExpressionEClass == null)
    {
      equalityExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(166);
    }
    return equalityExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpression_UnaryExpression()
  {
        return (EReference)getEqualityExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpression_ClassificationExpressionCompletion()
  {
        return (EReference)getEqualityExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityExpressionCompletion()
  {
    if (equalityExpressionCompletionEClass == null)
    {
      equalityExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(167);
    }
    return equalityExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpressionCompletion_ClassificationExpressionCompletion()
  {
        return (EReference)getEqualityExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEqualityExpressionCompletion_Operator()
  {
        return (EAttribute)getEqualityExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpressionCompletion_ClassificationExpression()
  {
        return (EReference)getEqualityExpressionCompletion().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpression()
  {
    if (andExpressionEClass == null)
    {
      andExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(169);
    }
    return andExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_UnaryExpression()
  {
        return (EReference)getAndExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_AndExpressionCompletion()
  {
        return (EReference)getAndExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpressionCompletion()
  {
    if (andExpressionCompletionEClass == null)
    {
      andExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(170);
    }
    return andExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpressionCompletion_EqualityExpressionCompletion()
  {
        return (EReference)getAndExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpressionCompletion_EqualityExpression()
  {
        return (EReference)getAndExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExclusiveOrExpression()
  {
    if (exclusiveOrExpressionEClass == null)
    {
      exclusiveOrExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(171);
    }
    return exclusiveOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExclusiveOrExpression_UnaryExpression()
  {
        return (EReference)getExclusiveOrExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExclusiveOrExpression_ExclusiveOrExpressionCompletion()
  {
        return (EReference)getExclusiveOrExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExclusiveOrExpressionCompletion()
  {
    if (exclusiveOrExpressionCompletionEClass == null)
    {
      exclusiveOrExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(172);
    }
    return exclusiveOrExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExclusiveOrExpressionCompletion_AndExpressionCompletion()
  {
        return (EReference)getExclusiveOrExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExclusiveOrExpressionCompletion_AndExpression()
  {
        return (EReference)getExclusiveOrExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInclusiveOrExpression()
  {
    if (inclusiveOrExpressionEClass == null)
    {
      inclusiveOrExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(173);
    }
    return inclusiveOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInclusiveOrExpression_UnaryExpression()
  {
        return (EReference)getInclusiveOrExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInclusiveOrExpression_InclusiveOrExpressionCompletion()
  {
        return (EReference)getInclusiveOrExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInclusiveOrExpressionCompletion()
  {
    if (inclusiveOrExpressionCompletionEClass == null)
    {
      inclusiveOrExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(174);
    }
    return inclusiveOrExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInclusiveOrExpressionCompletion_ExclusiveOrExpressionCompletion()
  {
        return (EReference)getInclusiveOrExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInclusiveOrExpressionCompletion_ExclusiveOrExpression()
  {
        return (EReference)getInclusiveOrExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalAndExpression()
  {
    if (conditionalAndExpressionEClass == null)
    {
      conditionalAndExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(175);
    }
    return conditionalAndExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalAndExpression_UnaryExpression()
  {
        return (EReference)getConditionalAndExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalAndExpression_ConditionalAndExpressionCompletion()
  {
        return (EReference)getConditionalAndExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalAndExpressionCompletion()
  {
    if (conditionalAndExpressionCompletionEClass == null)
    {
      conditionalAndExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(176);
    }
    return conditionalAndExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalAndExpressionCompletion_InclusiveOrExpressionCompletion()
  {
        return (EReference)getConditionalAndExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalAndExpressionCompletion_InclusiveOrExpression()
  {
        return (EReference)getConditionalAndExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalOrExpression()
  {
    if (conditionalOrExpressionEClass == null)
    {
      conditionalOrExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(177);
    }
    return conditionalOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalOrExpression_UnaryExpression()
  {
        return (EReference)getConditionalOrExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalOrExpression_ConditionalOrExpressionCompletion()
  {
        return (EReference)getConditionalOrExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalOrExpressionCompletion()
  {
    if (conditionalOrExpressionCompletionEClass == null)
    {
      conditionalOrExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(178);
    }
    return conditionalOrExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalOrExpressionCompletion_ConditionalAndExpressionCompletion()
  {
        return (EReference)getConditionalOrExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalOrExpressionCompletion_ConditionalAndExpression()
  {
        return (EReference)getConditionalOrExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalExpression()
  {
    if (conditionalExpressionEClass == null)
    {
      conditionalExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(179);
    }
    return conditionalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_UnaryExpression()
  {
        return (EReference)getConditionalExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_ConditionalExpressionCompletion()
  {
        return (EReference)getConditionalExpression().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalExpressionCompletion()
  {
    if (conditionalExpressionCompletionEClass == null)
    {
      conditionalExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(180);
    }
    return conditionalExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpressionCompletion_ConditionalOrExpressionCompletion()
  {
        return (EReference)getConditionalExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpressionCompletion_ConditionalExpression()
  {
        return (EReference)getConditionalExpressionCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignmentExpressionCompletion()
  {
    if (assignmentExpressionCompletionEClass == null)
    {
      assignmentExpressionCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(181);
    }
    return assignmentExpressionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentExpressionCompletion_Operator()
  {
        return (EAttribute)getAssignmentExpressionCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatementSequence()
  {
    if (statementSequenceEClass == null)
    {
      statementSequenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(183);
    }
    return statementSequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatementSequence_DocumentStatement()
  {
        return (EReference)getStatementSequence().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocumentedStatement()
  {
    if (documentedStatementEClass == null)
    {
      documentedStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(184);
    }
    return documentedStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDocumentedStatement_Comment()
  {
        return (EAttribute)getDocumentedStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentedStatement_Statement()
  {
        return (EReference)getDocumentedStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    if (statementEClass == null)
    {
      statementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(185);
    }
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlock()
  {
    if (blockEClass == null)
    {
      blockEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(186);
    }
    return blockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlock_StatementSequence()
  {
        return (EReference)getBlock().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotatedStatement()
  {
    if (annotatedStatementEClass == null)
    {
      annotatedStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(187);
    }
    return annotatedStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotatedStatement_Annotations()
  {
        return (EReference)getAnnotatedStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotatedStatement_Statement()
  {
        return (EReference)getAnnotatedStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotations()
  {
    if (annotationsEClass == null)
    {
      annotationsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(188);
    }
    return annotationsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotations_Annotation()
  {
        return (EReference)getAnnotations().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotation()
  {
    if (annotationEClass == null)
    {
      annotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(189);
    }
    return annotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnnotation_Id()
  {
        return (EAttribute)getAnnotation().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotation_NameList()
  {
        return (EReference)getAnnotation().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameList()
  {
    if (nameListEClass == null)
    {
      nameListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(190);
    }
    return nameListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameList_Name()
  {
        return (EReference)getNameList().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInLineStatement()
  {
    if (inLineStatementEClass == null)
    {
      inLineStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(191);
    }
    return inLineStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInLineStatement_Id()
  {
        return (EAttribute)getInLineStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInLineStatement_Name()
  {
        return (EReference)getInLineStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlockStatement()
  {
    if (blockStatementEClass == null)
    {
      blockStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(192);
    }
    return blockStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlockStatement_Block()
  {
        return (EReference)getBlockStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmptyStatement()
  {
    if (emptyStatementEClass == null)
    {
      emptyStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(193);
    }
    return emptyStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalNameDeclarationOrExpressionStatement()
  {
    if (localNameDeclarationOrExpressionStatementEClass == null)
    {
      localNameDeclarationOrExpressionStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(194);
    }
    return localNameDeclarationOrExpressionStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationOrExpressionStatement_PotentiallyAmbiguousName()
  {
        return (EReference)getLocalNameDeclarationOrExpressionStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationOrExpressionStatement_MultiplicaityIndicator()
  {
        return (EReference)getLocalNameDeclarationOrExpressionStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationOrExpressionStatement_Name()
  {
        return (EReference)getLocalNameDeclarationOrExpressionStatement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationOrExpressionStatement_LocalNameDeclarationCompletion()
  {
        return (EReference)getLocalNameDeclarationOrExpressionStatement().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationOrExpressionStatement_NameToExpressionCompletion()
  {
        return (EReference)getLocalNameDeclarationOrExpressionStatement().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationOrExpressionStatement_NonNameExpression()
  {
        return (EReference)getLocalNameDeclarationOrExpressionStatement().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalNameDeclarationStatement()
  {
    if (localNameDeclarationStatementEClass == null)
    {
      localNameDeclarationStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(195);
    }
    return localNameDeclarationStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationStatement_Name()
  {
        return (EReference)getLocalNameDeclarationStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationStatement_TypeName()
  {
        return (EReference)getLocalNameDeclarationStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationStatement_MultiplicityIndicator()
  {
        return (EReference)getLocalNameDeclarationStatement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationStatement_LocalNameDeclarationCompletion()
  {
        return (EReference)getLocalNameDeclarationStatement().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalNameDeclarationStatementCompletion()
  {
    if (localNameDeclarationStatementCompletionEClass == null)
    {
      localNameDeclarationStatementCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(196);
    }
    return localNameDeclarationStatementCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationStatementCompletion_InitializationExpression()
  {
        return (EReference)getLocalNameDeclarationStatementCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitializationExpression()
  {
    if (initializationExpressionEClass == null)
    {
      initializationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(197);
    }
    return initializationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstanceInitializationExpression()
  {
    if (instanceInitializationExpressionEClass == null)
    {
      instanceInitializationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(198);
    }
    return instanceInitializationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceInitializationExpression_Tuple()
  {
        return (EReference)getInstanceInitializationExpression().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfStatement()
  {
    if (ifStatementEClass == null)
    {
      ifStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(199);
    }
    return ifStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfStatement_SequentialClauses()
  {
        return (EReference)getIfStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfStatement_FinalClause()
  {
        return (EReference)getIfStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequentialClauses()
  {
    if (sequentialClausesEClass == null)
    {
      sequentialClausesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(200);
    }
    return sequentialClausesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequentialClauses_ConcurrentClauses()
  {
        return (EReference)getSequentialClauses().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConcurrentClauses()
  {
    if (concurrentClausesEClass == null)
    {
      concurrentClausesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(201);
    }
    return concurrentClausesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcurrentClauses_NonFinalClause()
  {
        return (EReference)getConcurrentClauses().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonFinalClause()
  {
    if (nonFinalClauseEClass == null)
    {
      nonFinalClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(202);
    }
    return nonFinalClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonFinalClause_Expression()
  {
        return (EReference)getNonFinalClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonFinalClause_Block()
  {
        return (EReference)getNonFinalClause().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFinalClause()
  {
    if (finalClauseEClass == null)
    {
      finalClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(203);
    }
    return finalClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFinalClause_Block()
  {
        return (EReference)getFinalClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchStatement()
  {
    if (switchStatementEClass == null)
    {
      switchStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(204);
    }
    return switchStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchStatement_Expression()
  {
        return (EReference)getSwitchStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchStatement_SwitchClause()
  {
        return (EReference)getSwitchStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchStatement_DefaultClause()
  {
        return (EReference)getSwitchStatement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchClause()
  {
    if (switchClauseEClass == null)
    {
      switchClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(205);
    }
    return switchClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchClause_SwitchCase()
  {
        return (EReference)getSwitchClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchClause_StatementSequence()
  {
        return (EReference)getSwitchClause().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchCase()
  {
    if (switchCaseEClass == null)
    {
      switchCaseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(206);
    }
    return switchCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchCase_Expression()
  {
        return (EReference)getSwitchCase().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchDefaultClause()
  {
    if (switchDefaultClauseEClass == null)
    {
      switchDefaultClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(207);
    }
    return switchDefaultClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchDefaultClause_StatementSequence()
  {
        return (EReference)getSwitchDefaultClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonEmptyStatementSequence()
  {
    if (nonEmptyStatementSequenceEClass == null)
    {
      nonEmptyStatementSequenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(208);
    }
    return nonEmptyStatementSequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonEmptyStatementSequence_Statement()
  {
        return (EReference)getNonEmptyStatementSequence().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWhileStatement()
  {
    if (whileStatementEClass == null)
    {
      whileStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(209);
    }
    return whileStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Expression()
  {
        return (EReference)getWhileStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Block()
  {
        return (EReference)getWhileStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoStatement()
  {
    if (doStatementEClass == null)
    {
      doStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(210);
    }
    return doStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDoStatement_Block()
  {
        return (EReference)getDoStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDoStatement_Expression()
  {
        return (EReference)getDoStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForStatement()
  {
    if (forStatementEClass == null)
    {
      forStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(211);
    }
    return forStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_ForControl()
  {
        return (EReference)getForStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_Block()
  {
        return (EReference)getForStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForControl()
  {
    if (forControlEClass == null)
    {
      forControlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(212);
    }
    return forControlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForControl_LoopVariableDefinition()
  {
        return (EReference)getForControl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoopVariableDefinition()
  {
    if (loopVariableDefinitionEClass == null)
    {
      loopVariableDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(213);
    }
    return loopVariableDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariableDefinition_Name()
  {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariableDefinition_Expression1()
  {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariableDefinition_Expression2()
  {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariableDefinition_TypeName()
  {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariableDefinition_Expression3()
  {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBreakStatement()
  {
    if (breakStatementEClass == null)
    {
      breakStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(214);
    }
    return breakStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReturnStatement()
  {
    if (returnStatementEClass == null)
    {
      returnStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(215);
    }
    return returnStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReturnStatement_Expression()
  {
        return (EReference)getReturnStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAcceptStatement()
  {
    if (acceptStatementEClass == null)
    {
      acceptStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(216);
    }
    return acceptStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptStatement_AcceptClause()
  {
        return (EReference)getAcceptStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptStatement_SimpleCompletion()
  {
        return (EReference)getAcceptStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptStatement_CompoundCompletion()
  {
        return (EReference)getAcceptStatement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleAcceptStatementCompletion()
  {
    if (simpleAcceptStatementCompletionEClass == null)
    {
      simpleAcceptStatementCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(217);
    }
    return simpleAcceptStatementCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompoundAcceptStatementCompletion()
  {
    if (compoundAcceptStatementCompletionEClass == null)
    {
      compoundAcceptStatementCompletionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(218);
    }
    return compoundAcceptStatementCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundAcceptStatementCompletion_Block()
  {
        return (EReference)getCompoundAcceptStatementCompletion().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundAcceptStatementCompletion_AcceptBlock()
  {
        return (EReference)getCompoundAcceptStatementCompletion().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAcceptBlock()
  {
    if (acceptBlockEClass == null)
    {
      acceptBlockEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(219);
    }
    return acceptBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptBlock_AcceptClause()
  {
        return (EReference)getAcceptBlock().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptBlock_Block()
  {
        return (EReference)getAcceptBlock().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAcceptClause()
  {
    if (acceptClauseEClass == null)
    {
      acceptClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(220);
    }
    return acceptClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptClause_Name()
  {
        return (EReference)getAcceptClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptClause_QualifiedNameList()
  {
        return (EReference)getAcceptClause().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifyStatement()
  {
    if (classifyStatementEClass == null)
    {
      classifyStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(221);
    }
    return classifyStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifyStatement_Expression()
  {
        return (EReference)getClassifyStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifyStatement_ClassificationClause()
  {
        return (EReference)getClassifyStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationClause()
  {
    if (classificationClauseEClass == null)
    {
      classificationClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(222);
    }
    return classificationClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationClause_ClassificationFromClause()
  {
        return (EReference)getClassificationClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationClause_ClassificationToClause()
  {
        return (EReference)getClassificationClause().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationClause_ReclassifyAllClause()
  {
        return (EReference)getClassificationClause().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationFromClause()
  {
    if (classificationFromClauseEClass == null)
    {
      classificationFromClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(223);
    }
    return classificationFromClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationFromClause_QualifiedNameList()
  {
        return (EReference)getClassificationFromClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationToClause()
  {
    if (classificationToClauseEClass == null)
    {
      classificationToClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(224);
    }
    return classificationToClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationToClause_QualifiedNameList()
  {
        return (EReference)getClassificationToClause().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReclassifyAllClause()
  {
    if (reclassifyAllClauseEClass == null)
    {
      reclassifyAllClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(225);
    }
    return reclassifyAllClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedNameList()
  {
    if (qualifiedNameListEClass == null)
    {
      qualifiedNameListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(226);
    }
    return qualifiedNameListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedNameList_QualifiedName()
  {
        return (EReference)getQualifiedNameList().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getImportVisibilityIndicator()
  {
    if (importVisibilityIndicatorEEnum == null)
    {
      importVisibilityIndicatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(14);
    }
    return importVisibilityIndicatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getParameterDirection()
  {
    if (parameterDirectionEEnum == null)
    {
      parameterDirectionEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(68);
    }
    return parameterDirectionEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getLinkOperation()
  {
    if (linkOperationEEnum == null)
    {
      linkOperationEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(122);
    }
    return linkOperationEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAffixOperator()
  {
    if (affixOperatorEEnum == null)
    {
      affixOperatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(139);
    }
    return affixOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getNumericUnaryOperator()
  {
    if (numericUnaryOperatorEEnum == null)
    {
      numericUnaryOperatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(148);
    }
    return numericUnaryOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMultiplicativeOperator()
  {
    if (multiplicativeOperatorEEnum == null)
    {
      multiplicativeOperatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(153);
    }
    return multiplicativeOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAdditiveOperator()
  {
    if (additiveOperatorEEnum == null)
    {
      additiveOperatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(156);
    }
    return additiveOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getShiftOperator()
  {
    if (shiftOperatorEEnum == null)
    {
      shiftOperatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(159);
    }
    return shiftOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getRelationalOperator()
  {
    if (relationalOperatorEEnum == null)
    {
      relationalOperatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(162);
    }
    return relationalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getClassificationOperator()
  {
    if (classificationOperatorEEnum == null)
    {
      classificationOperatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(165);
    }
    return classificationOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEqualityOperator()
  {
    if (equalityOperatorEEnum == null)
    {
      equalityOperatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(168);
    }
    return equalityOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAssignmentOperator()
  {
    if (assignmentOperatorEEnum == null)
    {
      assignmentOperatorEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(182);
    }
    return assignmentOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfFactory getAlfFactory()
  {
    return (AlfFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isLoaded = false;

  /**
   * Laods the package and any sub-packages from their serialized form.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void loadPackage()
  {
    if (isLoaded) return;
    isLoaded = true;

    URL url = getClass().getResource(packageFilename);
    if (url == null)
    {
      throw new RuntimeException("Missing serialized package: " + packageFilename);
    }
    URI uri = URI.createURI(url.toString());
    Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
    try
    {
      resource.load(null);
    }
    catch (IOException exception)
    {
      throw new WrappedException(exception);
    }
    initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
    createResource(eNS_URI);
  }


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isFixed = false;

  /**
   * Fixes up the loaded package, to make it appear as if it had been programmatically built.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void fixPackageContents()
  {
    if (isFixed) return;
    isFixed = true;
    fixEClassifiers();
  }

  /**
   * Sets the instance class on the given classifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void fixInstanceClass(EClassifier eClassifier)
  {
    if (eClassifier.getInstanceClassName() == null)
    {
      eClassifier.setInstanceClassName("org.eclipse.papyrus.alf.alf." + eClassifier.getName());
      setGeneratedClassName(eClassifier);
    }
  }

} //AlfPackageImpl
