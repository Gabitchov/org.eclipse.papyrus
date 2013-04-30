/**
 */
package org.eclipse.papyrus.alf.alf.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.alf.alf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.alf.alf.AlfPackage
 * @generated
 */
public class AlfSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AlfPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = AlfPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case AlfPackage.UNIT_DEFINITION:
      {
        UnitDefinition unitDefinition = (UnitDefinition)theEObject;
        T result = caseUnitDefinition(unitDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BOOLEAN_LITERAL:
      {
        BOOLEAN_LITERAL booleaN_LITERAL = (BOOLEAN_LITERAL)theEObject;
        T result = caseBOOLEAN_LITERAL(booleaN_LITERAL);
        if (result == null) result = casePRIMITIVE_LITERAL(booleaN_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NUMBER_LITERAL:
      {
        NUMBER_LITERAL numbeR_LITERAL = (NUMBER_LITERAL)theEObject;
        T result = caseNUMBER_LITERAL(numbeR_LITERAL);
        if (result == null) result = casePRIMITIVE_LITERAL(numbeR_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INTEGER_LITERAL:
      {
        INTEGER_LITERAL integeR_LITERAL = (INTEGER_LITERAL)theEObject;
        T result = caseINTEGER_LITERAL(integeR_LITERAL);
        if (result == null) result = caseNUMBER_LITERAL(integeR_LITERAL);
        if (result == null) result = casePRIMITIVE_LITERAL(integeR_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.UNLIMITED_NATURAL:
      {
        UNLIMITED_NATURAL unlimiteD_NATURAL = (UNLIMITED_NATURAL)theEObject;
        T result = caseUNLIMITED_NATURAL(unlimiteD_NATURAL);
        if (result == null) result = caseNUMBER_LITERAL(unlimiteD_NATURAL);
        if (result == null) result = casePRIMITIVE_LITERAL(unlimiteD_NATURAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STRING_LITERAL:
      {
        STRING_LITERAL strinG_LITERAL = (STRING_LITERAL)theEObject;
        T result = caseSTRING_LITERAL(strinG_LITERAL);
        if (result == null) result = casePRIMITIVE_LITERAL(strinG_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STEREOTYPE_ANNOTATIONS:
      {
        StereotypeAnnotations stereotypeAnnotations = (StereotypeAnnotations)theEObject;
        T result = caseStereotypeAnnotations(stereotypeAnnotations);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STEREOTYPE_ANNOTATION:
      {
        StereotypeAnnotation stereotypeAnnotation = (StereotypeAnnotation)theEObject;
        T result = caseStereotypeAnnotation(stereotypeAnnotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TAGGED_VALUES:
      {
        TaggedValues taggedValues = (TaggedValues)theEObject;
        T result = caseTaggedValues(taggedValues);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TAGGED_VALUE_LIST:
      {
        TaggedValueList taggedValueList = (TaggedValueList)theEObject;
        T result = caseTaggedValueList(taggedValueList);
        if (result == null) result = caseTaggedValues(taggedValueList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PRIMITIVE_LITERAL:
      {
        PRIMITIVE_LITERAL primitivE_LITERAL = (PRIMITIVE_LITERAL)theEObject;
        T result = casePRIMITIVE_LITERAL(primitivE_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TAGGED_VALUE:
      {
        TaggedValue taggedValue = (TaggedValue)theEObject;
        T result = caseTaggedValue(taggedValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAMESPACE_DECLARATION:
      {
        NamespaceDeclaration namespaceDeclaration = (NamespaceDeclaration)theEObject;
        T result = caseNamespaceDeclaration(namespaceDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.IMPORT_DECLARATION:
      {
        ImportDeclaration importDeclaration = (ImportDeclaration)theEObject;
        T result = caseImportDeclaration(importDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.IMPORT_REFERENCE:
      {
        ImportReference importReference = (ImportReference)theEObject;
        T result = caseImportReference(importReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.IMPORT_REFERENCE_QUALIFIED_NAME_COMPLETION:
      {
        ImportReferenceQualifiedNameCompletion importReferenceQualifiedNameCompletion = (ImportReferenceQualifiedNameCompletion)theEObject;
        T result = caseImportReferenceQualifiedNameCompletion(importReferenceQualifiedNameCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE:
      {
        ColonQualifiedNameCompletionOfImportReference colonQualifiedNameCompletionOfImportReference = (ColonQualifiedNameCompletionOfImportReference)theEObject;
        T result = caseColonQualifiedNameCompletionOfImportReference(colonQualifiedNameCompletionOfImportReference);
        if (result == null) result = caseImportReferenceQualifiedNameCompletion(colonQualifiedNameCompletionOfImportReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ALIAS_DEFINITION:
      {
        AliasDefinition aliasDefinition = (AliasDefinition)theEObject;
        T result = caseAliasDefinition(aliasDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAMESPACE_DEFINITION:
      {
        NamespaceDefinition namespaceDefinition = (NamespaceDefinition)theEObject;
        T result = caseNamespaceDefinition(namespaceDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.VISIBILITY_INDICATOR:
      {
        VisibilityIndicator visibilityIndicator = (VisibilityIndicator)theEObject;
        T result = caseVisibilityIndicator(visibilityIndicator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PACKAGE_DECLARATION:
      {
        PackageDeclaration packageDeclaration = (PackageDeclaration)theEObject;
        T result = casePackageDeclaration(packageDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PACKAGE_DEFINITION:
      {
        PackageDefinition packageDefinition = (PackageDefinition)theEObject;
        T result = casePackageDefinition(packageDefinition);
        if (result == null) result = caseNamespaceDefinition(packageDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB:
      {
        PackageDefinitionOrStub packageDefinitionOrStub = (PackageDefinitionOrStub)theEObject;
        T result = casePackageDefinitionOrStub(packageDefinitionOrStub);
        if (result == null) result = casePackagedElementDefinition(packageDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PACKAGE_BODY:
      {
        PackageBody packageBody = (PackageBody)theEObject;
        T result = casePackageBody(packageBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PACKAGED_ELEMENT:
      {
        PackagedElement packagedElement = (PackagedElement)theEObject;
        T result = casePackagedElement(packagedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PACKAGED_ELEMENT_DEFINITION:
      {
        PackagedElementDefinition packagedElementDefinition = (PackagedElementDefinition)theEObject;
        T result = casePackagedElementDefinition(packagedElementDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFIER_DEFINITION:
      {
        ClassifierDefinition classifierDefinition = (ClassifierDefinition)theEObject;
        T result = caseClassifierDefinition(classifierDefinition);
        if (result == null) result = caseNamespaceDefinition(classifierDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFIER_DEFINITION_OR_STUB:
      {
        ClassifierDefinitionOrStub classifierDefinitionOrStub = (ClassifierDefinitionOrStub)theEObject;
        T result = caseClassifierDefinitionOrStub(classifierDefinitionOrStub);
        if (result == null) result = casePackagedElementDefinition(classifierDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(classifierDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(classifierDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFIER_SIGNATURE:
      {
        ClassifierSignature classifierSignature = (ClassifierSignature)theEObject;
        T result = caseClassifierSignature(classifierSignature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TEMPLATE_PARAMETERS:
      {
        TemplateParameters templateParameters = (TemplateParameters)theEObject;
        T result = caseTemplateParameters(templateParameters);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFIER_TEMPLATE_PARAMETER:
      {
        ClassifierTemplateParameter classifierTemplateParameter = (ClassifierTemplateParameter)theEObject;
        T result = caseClassifierTemplateParameter(classifierTemplateParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SPECIALIZATION_CLAUSE:
      {
        SpecializationClause specializationClause = (SpecializationClause)theEObject;
        T result = caseSpecializationClause(specializationClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASS_DECLARATION:
      {
        ClassDeclaration classDeclaration = (ClassDeclaration)theEObject;
        T result = caseClassDeclaration(classDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASS_DEFINITION:
      {
        ClassDefinition classDefinition = (ClassDefinition)theEObject;
        T result = caseClassDefinition(classDefinition);
        if (result == null) result = caseClassifierDefinition(classDefinition);
        if (result == null) result = caseNamespaceDefinition(classDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASS_DEFINITION_OR_STUB:
      {
        ClassDefinitionOrStub classDefinitionOrStub = (ClassDefinitionOrStub)theEObject;
        T result = caseClassDefinitionOrStub(classDefinitionOrStub);
        if (result == null) result = caseClassifierDefinitionOrStub(classDefinitionOrStub);
        if (result == null) result = casePackagedElementDefinition(classDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(classDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(classDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASS_BODY:
      {
        ClassBody classBody = (ClassBody)theEObject;
        T result = caseClassBody(classBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASS_MEMBER:
      {
        ClassMember classMember = (ClassMember)theEObject;
        T result = caseClassMember(classMember);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASS_MEMBER_DEFINITION:
      {
        ClassMemberDefinition classMemberDefinition = (ClassMemberDefinition)theEObject;
        T result = caseClassMemberDefinition(classMemberDefinition);
        if (result == null) result = caseActiveClassMemberDefinition(classMemberDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVE_CLASS_DECLARATION:
      {
        ActiveClassDeclaration activeClassDeclaration = (ActiveClassDeclaration)theEObject;
        T result = caseActiveClassDeclaration(activeClassDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVE_CLASS_DEFINITION:
      {
        ActiveClassDefinition activeClassDefinition = (ActiveClassDefinition)theEObject;
        T result = caseActiveClassDefinition(activeClassDefinition);
        if (result == null) result = caseClassifierDefinition(activeClassDefinition);
        if (result == null) result = caseNamespaceDefinition(activeClassDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB:
      {
        ActiveClassDefinitionOrStub activeClassDefinitionOrStub = (ActiveClassDefinitionOrStub)theEObject;
        T result = caseActiveClassDefinitionOrStub(activeClassDefinitionOrStub);
        if (result == null) result = caseClassifierDefinitionOrStub(activeClassDefinitionOrStub);
        if (result == null) result = casePackagedElementDefinition(activeClassDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(activeClassDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(activeClassDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVE_CLASS_BODY:
      {
        ActiveClassBody activeClassBody = (ActiveClassBody)theEObject;
        T result = caseActiveClassBody(activeClassBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BEHAVIOR_CLAUSE:
      {
        BehaviorClause behaviorClause = (BehaviorClause)theEObject;
        T result = caseBehaviorClause(behaviorClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVE_CLASS_MEMBER:
      {
        ActiveClassMember activeClassMember = (ActiveClassMember)theEObject;
        T result = caseActiveClassMember(activeClassMember);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVE_CLASS_MEMBER_DEFINITION:
      {
        ActiveClassMemberDefinition activeClassMemberDefinition = (ActiveClassMemberDefinition)theEObject;
        T result = caseActiveClassMemberDefinition(activeClassMemberDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.DATA_TYPE_DECLARATION:
      {
        DataTypeDeclaration dataTypeDeclaration = (DataTypeDeclaration)theEObject;
        T result = caseDataTypeDeclaration(dataTypeDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.DATA_TYPE_DEFINITION:
      {
        DataTypeDefinition dataTypeDefinition = (DataTypeDefinition)theEObject;
        T result = caseDataTypeDefinition(dataTypeDefinition);
        if (result == null) result = caseClassifierDefinition(dataTypeDefinition);
        if (result == null) result = caseNamespaceDefinition(dataTypeDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB:
      {
        DataTypeDefinitionOrStub dataTypeDefinitionOrStub = (DataTypeDefinitionOrStub)theEObject;
        T result = caseDataTypeDefinitionOrStub(dataTypeDefinitionOrStub);
        if (result == null) result = caseClassifierDefinitionOrStub(dataTypeDefinitionOrStub);
        if (result == null) result = casePackagedElementDefinition(dataTypeDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(dataTypeDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(dataTypeDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STRUCTURED_BODY:
      {
        StructuredBody structuredBody = (StructuredBody)theEObject;
        T result = caseStructuredBody(structuredBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STRUCTURED_MEMBER:
      {
        StructuredMember structuredMember = (StructuredMember)theEObject;
        T result = caseStructuredMember(structuredMember);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ASSOCIATION_DECLARATION:
      {
        AssociationDeclaration associationDeclaration = (AssociationDeclaration)theEObject;
        T result = caseAssociationDeclaration(associationDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ASSOCIATION_DEFINITION:
      {
        AssociationDefinition associationDefinition = (AssociationDefinition)theEObject;
        T result = caseAssociationDefinition(associationDefinition);
        if (result == null) result = caseClassifierDefinition(associationDefinition);
        if (result == null) result = caseNamespaceDefinition(associationDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB:
      {
        AssociationDefinitionOrStub associationDefinitionOrStub = (AssociationDefinitionOrStub)theEObject;
        T result = caseAssociationDefinitionOrStub(associationDefinitionOrStub);
        if (result == null) result = caseClassifierDefinitionOrStub(associationDefinitionOrStub);
        if (result == null) result = casePackagedElementDefinition(associationDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(associationDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(associationDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ENUMERATION_DECLARATION:
      {
        EnumerationDeclaration enumerationDeclaration = (EnumerationDeclaration)theEObject;
        T result = caseEnumerationDeclaration(enumerationDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ENUMERATION_DEFINITION:
      {
        EnumerationDefinition enumerationDefinition = (EnumerationDefinition)theEObject;
        T result = caseEnumerationDefinition(enumerationDefinition);
        if (result == null) result = caseClassifierDefinition(enumerationDefinition);
        if (result == null) result = caseNamespaceDefinition(enumerationDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB:
      {
        EnumerationDefinitionOrStub enumerationDefinitionOrStub = (EnumerationDefinitionOrStub)theEObject;
        T result = caseEnumerationDefinitionOrStub(enumerationDefinitionOrStub);
        if (result == null) result = caseClassifierDefinitionOrStub(enumerationDefinitionOrStub);
        if (result == null) result = casePackagedElementDefinition(enumerationDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(enumerationDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(enumerationDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ENUMERATION_BODY:
      {
        EnumerationBody enumerationBody = (EnumerationBody)theEObject;
        T result = caseEnumerationBody(enumerationBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ENUMERATION_LITERAL_NAME:
      {
        EnumerationLiteralName enumerationLiteralName = (EnumerationLiteralName)theEObject;
        T result = caseEnumerationLiteralName(enumerationLiteralName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SIGNAL_DECLARATION:
      {
        SignalDeclaration signalDeclaration = (SignalDeclaration)theEObject;
        T result = caseSignalDeclaration(signalDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SIGNAL_DEFINITION:
      {
        SignalDefinition signalDefinition = (SignalDefinition)theEObject;
        T result = caseSignalDefinition(signalDefinition);
        if (result == null) result = caseClassifierDefinition(signalDefinition);
        if (result == null) result = caseNamespaceDefinition(signalDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB:
      {
        SignalDefinitionOrStub signalDefinitionOrStub = (SignalDefinitionOrStub)theEObject;
        T result = caseSignalDefinitionOrStub(signalDefinitionOrStub);
        if (result == null) result = caseClassifierDefinitionOrStub(signalDefinitionOrStub);
        if (result == null) result = casePackagedElementDefinition(signalDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(signalDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(signalDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVITY_DECLARATION:
      {
        ActivityDeclaration activityDeclaration = (ActivityDeclaration)theEObject;
        T result = caseActivityDeclaration(activityDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVITY_DEFINITION:
      {
        ActivityDefinition activityDefinition = (ActivityDefinition)theEObject;
        T result = caseActivityDefinition(activityDefinition);
        if (result == null) result = caseClassifierDefinition(activityDefinition);
        if (result == null) result = caseNamespaceDefinition(activityDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB:
      {
        ActivityDefinitionOrStub activityDefinitionOrStub = (ActivityDefinitionOrStub)theEObject;
        T result = caseActivityDefinitionOrStub(activityDefinitionOrStub);
        if (result == null) result = caseClassifierDefinitionOrStub(activityDefinitionOrStub);
        if (result == null) result = casePackagedElementDefinition(activityDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(activityDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(activityDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FORMAL_PARAMETERS:
      {
        FormalParameters formalParameters = (FormalParameters)theEObject;
        T result = caseFormalParameters(formalParameters);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FORMAL_PARAMETER_LIST:
      {
        FormalParameterList formalParameterList = (FormalParameterList)theEObject;
        T result = caseFormalParameterList(formalParameterList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FORMAL_PARAMETER:
      {
        FormalParameter formalParameter = (FormalParameter)theEObject;
        T result = caseFormalParameter(formalParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FEATURE_DEFINITION_OR_STUB:
      {
        FeatureDefinitionOrStub featureDefinitionOrStub = (FeatureDefinitionOrStub)theEObject;
        T result = caseFeatureDefinitionOrStub(featureDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(featureDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(featureDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACTIVE_FEATURE_DEFINITION_OR_STUB:
      {
        ActiveFeatureDefinitionOrStub activeFeatureDefinitionOrStub = (ActiveFeatureDefinitionOrStub)theEObject;
        T result = caseActiveFeatureDefinitionOrStub(activeFeatureDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(activeFeatureDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PROPERTY_DEFINITION:
      {
        PropertyDefinition propertyDefinition = (PropertyDefinition)theEObject;
        T result = casePropertyDefinition(propertyDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ATTRIBUTE_DEFINITION:
      {
        AttributeDefinition attributeDefinition = (AttributeDefinition)theEObject;
        T result = caseAttributeDefinition(attributeDefinition);
        if (result == null) result = caseFeatureDefinitionOrStub(attributeDefinition);
        if (result == null) result = caseClassMemberDefinition(attributeDefinition);
        if (result == null) result = caseActiveClassMemberDefinition(attributeDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ATTRIBUTE_INITIALIZER:
      {
        AttributeInitializer attributeInitializer = (AttributeInitializer)theEObject;
        T result = caseAttributeInitializer(attributeInitializer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PROPERTY_DECLARATION:
      {
        PropertyDeclaration propertyDeclaration = (PropertyDeclaration)theEObject;
        T result = casePropertyDeclaration(propertyDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TYPE_PART:
      {
        TypePart typePart = (TypePart)theEObject;
        T result = caseTypePart(typePart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TYPE_NAME:
      {
        TypeName typeName = (TypeName)theEObject;
        T result = caseTypeName(typeName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.MULTIPLICITY:
      {
        Multiplicity multiplicity = (Multiplicity)theEObject;
        T result = caseMultiplicity(multiplicity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.MULTIPLICITY_RANGE:
      {
        MultiplicityRange multiplicityRange = (MultiplicityRange)theEObject;
        T result = caseMultiplicityRange(multiplicityRange);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.UNLIMITED_NATURAL_LITERAL:
      {
        UnlimitedNaturalLiteral unlimitedNaturalLiteral = (UnlimitedNaturalLiteral)theEObject;
        T result = caseUnlimitedNaturalLiteral(unlimitedNaturalLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.OPERATION_DECLARATION:
      {
        OperationDeclaration operationDeclaration = (OperationDeclaration)theEObject;
        T result = caseOperationDeclaration(operationDeclaration);
        if (result == null) result = caseOperationDefinitionOrStub(operationDeclaration);
        if (result == null) result = caseFeatureDefinitionOrStub(operationDeclaration);
        if (result == null) result = caseClassMemberDefinition(operationDeclaration);
        if (result == null) result = caseActiveClassMemberDefinition(operationDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.OPERATION_DEFINITION_OR_STUB:
      {
        OperationDefinitionOrStub operationDefinitionOrStub = (OperationDefinitionOrStub)theEObject;
        T result = caseOperationDefinitionOrStub(operationDefinitionOrStub);
        if (result == null) result = caseFeatureDefinitionOrStub(operationDefinitionOrStub);
        if (result == null) result = caseClassMemberDefinition(operationDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(operationDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.REDEFINITION_CLAUSE:
      {
        RedefinitionClause redefinitionClause = (RedefinitionClause)theEObject;
        T result = caseRedefinitionClause(redefinitionClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.RECEPTION_DEFINITION:
      {
        ReceptionDefinition receptionDefinition = (ReceptionDefinition)theEObject;
        T result = caseReceptionDefinition(receptionDefinition);
        if (result == null) result = caseActiveFeatureDefinitionOrStub(receptionDefinition);
        if (result == null) result = caseActiveClassMemberDefinition(receptionDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION:
      {
        SignalReceptionDeclaration signalReceptionDeclaration = (SignalReceptionDeclaration)theEObject;
        T result = caseSignalReceptionDeclaration(signalReceptionDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB:
      {
        SignalReceptionDefinitionOrStub signalReceptionDefinitionOrStub = (SignalReceptionDefinitionOrStub)theEObject;
        T result = caseSignalReceptionDefinitionOrStub(signalReceptionDefinitionOrStub);
        if (result == null) result = caseActiveFeatureDefinitionOrStub(signalReceptionDefinitionOrStub);
        if (result == null) result = caseActiveClassMemberDefinition(signalReceptionDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAME:
      {
        Name name = (Name)theEObject;
        T result = caseName(name);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.QUALIFIED_NAME:
      {
        QualifiedName qualifiedName = (QualifiedName)theEObject;
        T result = caseQualifiedName(qualifiedName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION:
      {
        ColonQualifiedNameCompletion colonQualifiedNameCompletion = (ColonQualifiedNameCompletion)theEObject;
        T result = caseColonQualifiedNameCompletion(colonQualifiedNameCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.UNQUALIFIED_NAME:
      {
        UnqualifiedName unqualifiedName = (UnqualifiedName)theEObject;
        T result = caseUnqualifiedName(unqualifiedName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAME_BINDING:
      {
        NameBinding nameBinding = (NameBinding)theEObject;
        T result = caseNameBinding(nameBinding);
        if (result == null) result = caseUnqualifiedName(nameBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING:
      {
        QualifiedNameWithoutBinding qualifiedNameWithoutBinding = (QualifiedNameWithoutBinding)theEObject;
        T result = caseQualifiedNameWithoutBinding(qualifiedNameWithoutBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_WITHOUT_BINDING:
      {
        ColonQualifiedNameCompletionWithoutBinding colonQualifiedNameCompletionWithoutBinding = (ColonQualifiedNameCompletionWithoutBinding)theEObject;
        T result = caseColonQualifiedNameCompletionWithoutBinding(colonQualifiedNameCompletionWithoutBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TEMPLATE_BINDING:
      {
        TemplateBinding templateBinding = (TemplateBinding)theEObject;
        T result = caseTemplateBinding(templateBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.POSITIONAL_TEMPLATE_BINDING:
      {
        PositionalTemplateBinding positionalTemplateBinding = (PositionalTemplateBinding)theEObject;
        T result = casePositionalTemplateBinding(positionalTemplateBinding);
        if (result == null) result = caseTemplateBinding(positionalTemplateBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAMED_TEMPLATE_BINDING:
      {
        NamedTemplateBinding namedTemplateBinding = (NamedTemplateBinding)theEObject;
        T result = caseNamedTemplateBinding(namedTemplateBinding);
        if (result == null) result = caseTemplateBinding(namedTemplateBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TEMPLATE_PARAMETER_SUBSTITUTION:
      {
        TemplateParameterSubstitution templateParameterSubstitution = (TemplateParameterSubstitution)theEObject;
        T result = caseTemplateParameterSubstitution(templateParameterSubstitution);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseInitializationExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NON_NAME_EXPRESSION:
      {
        NonNameExpression nonNameExpression = (NonNameExpression)theEObject;
        T result = caseNonNameExpression(nonNameExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION:
      {
        NameToExpressionCompletion nameToExpressionCompletion = (NameToExpressionCompletion)theEObject;
        T result = caseNameToExpressionCompletion(nameToExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION:
      {
        PrimaryToExpressionCompletion primaryToExpressionCompletion = (PrimaryToExpressionCompletion)theEObject;
        T result = casePrimaryToExpressionCompletion(primaryToExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EXPRESSION_COMPLETION:
      {
        ExpressionCompletion expressionCompletion = (ExpressionCompletion)theEObject;
        T result = caseExpressionCompletion(expressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PRIMARY_EXPRESSION:
      {
        PrimaryExpression primaryExpression = (PrimaryExpression)theEObject;
        T result = casePrimaryExpression(primaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BASE_EXPRESSION:
      {
        BaseExpression baseExpression = (BaseExpression)theEObject;
        T result = caseBaseExpression(baseExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION:
      {
        NameToPrimaryExpression nameToPrimaryExpression = (NameToPrimaryExpression)theEObject;
        T result = caseNameToPrimaryExpression(nameToPrimaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PRIMARY_EXPRESSION_COMPLETION:
      {
        PrimaryExpressionCompletion primaryExpressionCompletion = (PrimaryExpressionCompletion)theEObject;
        T result = casePrimaryExpressionCompletion(primaryExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX:
      {
        Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index = (Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index)theEObject;
        T result = caseFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index(feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LITERAL_EXPRESSION:
      {
        LiteralExpression literalExpression = (LiteralExpression)theEObject;
        T result = caseLiteralExpression(literalExpression);
        if (result == null) result = caseBaseExpression(literalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION:
      {
        NameOrPrimaryExpression nameOrPrimaryExpression = (NameOrPrimaryExpression)theEObject;
        T result = caseNameOrPrimaryExpression(nameOrPrimaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.THIS_EXPRESSION:
      {
        ThisExpression thisExpression = (ThisExpression)theEObject;
        T result = caseThisExpression(thisExpression);
        if (result == null) result = caseBaseExpression(thisExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PARENTHESIZED_EXPRESSION:
      {
        ParenthesizedExpression parenthesizedExpression = (ParenthesizedExpression)theEObject;
        T result = caseParenthesizedExpression(parenthesizedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FEATURE:
      {
        Feature feature = (Feature)theEObject;
        T result = caseFeature(feature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TUPLE:
      {
        Tuple tuple = (Tuple)theEObject;
        T result = caseTuple(tuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.POSITIONAL_TUPLE_EXPRESSION_LIST:
      {
        PositionalTupleExpressionList positionalTupleExpressionList = (PositionalTupleExpressionList)theEObject;
        T result = casePositionalTupleExpressionList(positionalTupleExpressionList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION:
      {
        PositionalTupleExpressionListCompletion positionalTupleExpressionListCompletion = (PositionalTupleExpressionListCompletion)theEObject;
        T result = casePositionalTupleExpressionListCompletion(positionalTupleExpressionListCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAMED_TUPLE_EXPRESSION_LIST:
      {
        NamedTupleExpressionList namedTupleExpressionList = (NamedTupleExpressionList)theEObject;
        T result = caseNamedTupleExpressionList(namedTupleExpressionList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAMED_EXPRESSION:
      {
        NamedExpression namedExpression = (NamedExpression)theEObject;
        T result = caseNamedExpression(namedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BEHAVIOR_INVOCATION:
      {
        BehaviorInvocation behaviorInvocation = (BehaviorInvocation)theEObject;
        T result = caseBehaviorInvocation(behaviorInvocation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FEATURE_INVOCATION:
      {
        FeatureInvocation featureInvocation = (FeatureInvocation)theEObject;
        T result = caseFeatureInvocation(featureInvocation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SUPER_INVOCATION_EXPRESSION:
      {
        SuperInvocationExpression superInvocationExpression = (SuperInvocationExpression)theEObject;
        T result = caseSuperInvocationExpression(superInvocationExpression);
        if (result == null) result = caseBaseExpression(superInvocationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INSTANCE_CREATION_OR_SEQUENCE_CONSTRUCTION_EXPRESSION:
      {
        InstanceCreationOrSequenceConstructionExpression instanceCreationOrSequenceConstructionExpression = (InstanceCreationOrSequenceConstructionExpression)theEObject;
        T result = caseInstanceCreationOrSequenceConstructionExpression(instanceCreationOrSequenceConstructionExpression);
        if (result == null) result = caseBaseExpression(instanceCreationOrSequenceConstructionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LINK_OPERATION_COMPLETION:
      {
        LinkOperationCompletion linkOperationCompletion = (LinkOperationCompletion)theEObject;
        T result = caseLinkOperationCompletion(linkOperationCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LINK_OPERATION_TUPLE:
      {
        LinkOperationTuple linkOperationTuple = (LinkOperationTuple)theEObject;
        T result = caseLinkOperationTuple(linkOperationTuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION:
      {
        IndexedNamedExpressionListCompletion indexedNamedExpressionListCompletion = (IndexedNamedExpressionListCompletion)theEObject;
        T result = caseIndexedNamedExpressionListCompletion(indexedNamedExpressionListCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INDEXED_NAMED_EXPRESSION:
      {
        IndexedNamedExpression indexedNamedExpression = (IndexedNamedExpression)theEObject;
        T result = caseIndexedNamedExpression(indexedNamedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASS_EXTENT_EXPRESSION_COMPLETION:
      {
        ClassExtentExpressionCompletion classExtentExpressionCompletion = (ClassExtentExpressionCompletion)theEObject;
        T result = caseClassExtentExpressionCompletion(classExtentExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_ANY_EXPRESSION:
      {
        SequenceAnyExpression sequenceAnyExpression = (SequenceAnyExpression)theEObject;
        T result = caseSequenceAnyExpression(sequenceAnyExpression);
        if (result == null) result = caseBaseExpression(sequenceAnyExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION:
      {
        SequenceConstructionExpressionCompletion sequenceConstructionExpressionCompletion = (SequenceConstructionExpressionCompletion)theEObject;
        T result = caseSequenceConstructionExpressionCompletion(sequenceConstructionExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.MULTIPLICITY_INDICATOR:
      {
        MultiplicityIndicator multiplicityIndicator = (MultiplicityIndicator)theEObject;
        T result = caseMultiplicityIndicator(multiplicityIndicator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_ELEMENTS:
      {
        SequenceElements sequenceElements = (SequenceElements)theEObject;
        T result = caseSequenceElements(sequenceElements);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_ELEMENT_LIST_COMPLETION:
      {
        SequenceElementListCompletion sequenceElementListCompletion = (SequenceElementListCompletion)theEObject;
        T result = caseSequenceElementListCompletion(sequenceElementListCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_ELEMENT:
      {
        SequenceElement sequenceElement = (SequenceElement)theEObject;
        T result = caseSequenceElement(sequenceElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION:
      {
        SequenceInitializationExpression sequenceInitializationExpression = (SequenceInitializationExpression)theEObject;
        T result = caseSequenceInitializationExpression(sequenceInitializationExpression);
        if (result == null) result = caseInitializationExpression(sequenceInitializationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INDEX:
      {
        Index index = (Index)theEObject;
        T result = caseIndex(index);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION:
      {
        SequenceOperationOrReductionOrExpansion sequenceOperationOrReductionOrExpansion = (SequenceOperationOrReductionOrExpansion)theEObject;
        T result = caseSequenceOperationOrReductionOrExpansion(sequenceOperationOrReductionOrExpansion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION:
      {
        PostfixExpressionCompletion postfixExpressionCompletion = (PostfixExpressionCompletion)theEObject;
        T result = casePostfixExpressionCompletion(postfixExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.POSTFIX_OPERATION:
      {
        PostfixOperation postfixOperation = (PostfixOperation)theEObject;
        T result = casePostfixOperation(postfixOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PREFIX_EXPRESSION:
      {
        PrefixExpression prefixExpression = (PrefixExpression)theEObject;
        T result = casePrefixExpression(prefixExpression);
        if (result == null) result = caseNonPostfixNonCastUnaryExpression(prefixExpression);
        if (result == null) result = caseUnaryExpression(prefixExpression);
        if (result == null) result = caseNonNameUnaryExpression(prefixExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.UNARY_EXPRESSION:
      {
        UnaryExpression unaryExpression = (UnaryExpression)theEObject;
        T result = caseUnaryExpression(unaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION:
      {
        PostfixOrCastExpression postfixOrCastExpression = (PostfixOrCastExpression)theEObject;
        T result = casePostfixOrCastExpression(postfixOrCastExpression);
        if (result == null) result = caseUnaryExpression(postfixOrCastExpression);
        if (result == null) result = caseCastCompletion(postfixOrCastExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NON_NAME_UNARY_EXPRESSION:
      {
        NonNameUnaryExpression nonNameUnaryExpression = (NonNameUnaryExpression)theEObject;
        T result = caseNonNameUnaryExpression(nonNameUnaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION:
      {
        NonNamePostfixOrCastExpression nonNamePostfixOrCastExpression = (NonNamePostfixOrCastExpression)theEObject;
        T result = caseNonNamePostfixOrCastExpression(nonNamePostfixOrCastExpression);
        if (result == null) result = caseNonNameUnaryExpression(nonNamePostfixOrCastExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NON_POSTFIX_NON_CAST_UNARY_EXPRESSION:
      {
        NonPostfixNonCastUnaryExpression nonPostfixNonCastUnaryExpression = (NonPostfixNonCastUnaryExpression)theEObject;
        T result = caseNonPostfixNonCastUnaryExpression(nonPostfixNonCastUnaryExpression);
        if (result == null) result = caseUnaryExpression(nonPostfixNonCastUnaryExpression);
        if (result == null) result = caseNonNameUnaryExpression(nonPostfixNonCastUnaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BOOLEAN_NEGATION_EXPRESSION:
      {
        BooleanNegationExpression booleanNegationExpression = (BooleanNegationExpression)theEObject;
        T result = caseBooleanNegationExpression(booleanNegationExpression);
        if (result == null) result = caseNonPostfixNonCastUnaryExpression(booleanNegationExpression);
        if (result == null) result = caseCastCompletion(booleanNegationExpression);
        if (result == null) result = caseUnaryExpression(booleanNegationExpression);
        if (result == null) result = caseNonNameUnaryExpression(booleanNegationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BIT_STRING_COMPLEMENT_EXPRESSION:
      {
        BitStringComplementExpression bitStringComplementExpression = (BitStringComplementExpression)theEObject;
        T result = caseBitStringComplementExpression(bitStringComplementExpression);
        if (result == null) result = caseNonPostfixNonCastUnaryExpression(bitStringComplementExpression);
        if (result == null) result = caseCastCompletion(bitStringComplementExpression);
        if (result == null) result = caseUnaryExpression(bitStringComplementExpression);
        if (result == null) result = caseNonNameUnaryExpression(bitStringComplementExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NUMERIC_UNARY_EXPRESSION:
      {
        NumericUnaryExpression numericUnaryExpression = (NumericUnaryExpression)theEObject;
        T result = caseNumericUnaryExpression(numericUnaryExpression);
        if (result == null) result = caseNonPostfixNonCastUnaryExpression(numericUnaryExpression);
        if (result == null) result = caseUnaryExpression(numericUnaryExpression);
        if (result == null) result = caseNonNameUnaryExpression(numericUnaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ISOLATION_EXPRESSION:
      {
        IsolationExpression isolationExpression = (IsolationExpression)theEObject;
        T result = caseIsolationExpression(isolationExpression);
        if (result == null) result = caseNonPostfixNonCastUnaryExpression(isolationExpression);
        if (result == null) result = caseCastCompletion(isolationExpression);
        if (result == null) result = caseUnaryExpression(isolationExpression);
        if (result == null) result = caseNonNameUnaryExpression(isolationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CAST_COMPLETION:
      {
        CastCompletion castCompletion = (CastCompletion)theEObject;
        T result = caseCastCompletion(castCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.MULTIPLICATIVE_EXPRESSION:
      {
        MultiplicativeExpression multiplicativeExpression = (MultiplicativeExpression)theEObject;
        T result = caseMultiplicativeExpression(multiplicativeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION:
      {
        MultiplicativeExpressionCompletion multiplicativeExpressionCompletion = (MultiplicativeExpressionCompletion)theEObject;
        T result = caseMultiplicativeExpressionCompletion(multiplicativeExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ADDITIVE_EXPRESSION:
      {
        AdditiveExpression additiveExpression = (AdditiveExpression)theEObject;
        T result = caseAdditiveExpression(additiveExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION:
      {
        AdditiveExpressionCompletion additiveExpressionCompletion = (AdditiveExpressionCompletion)theEObject;
        T result = caseAdditiveExpressionCompletion(additiveExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SHIFT_EXPRESSION:
      {
        ShiftExpression shiftExpression = (ShiftExpression)theEObject;
        T result = caseShiftExpression(shiftExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION:
      {
        ShiftExpressionCompletion shiftExpressionCompletion = (ShiftExpressionCompletion)theEObject;
        T result = caseShiftExpressionCompletion(shiftExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.RELATIONAL_EXPRESSION:
      {
        RelationalExpression relationalExpression = (RelationalExpression)theEObject;
        T result = caseRelationalExpression(relationalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION:
      {
        RelationalExpressionCompletion relationalExpressionCompletion = (RelationalExpressionCompletion)theEObject;
        T result = caseRelationalExpressionCompletion(relationalExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFICATION_EXPRESSION:
      {
        ClassificationExpression classificationExpression = (ClassificationExpression)theEObject;
        T result = caseClassificationExpression(classificationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION:
      {
        ClassificationExpressionCompletion classificationExpressionCompletion = (ClassificationExpressionCompletion)theEObject;
        T result = caseClassificationExpressionCompletion(classificationExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EQUALITY_EXPRESSION:
      {
        EqualityExpression equalityExpression = (EqualityExpression)theEObject;
        T result = caseEqualityExpression(equalityExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION:
      {
        EqualityExpressionCompletion equalityExpressionCompletion = (EqualityExpressionCompletion)theEObject;
        T result = caseEqualityExpressionCompletion(equalityExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.AND_EXPRESSION_COMPLETION:
      {
        AndExpressionCompletion andExpressionCompletion = (AndExpressionCompletion)theEObject;
        T result = caseAndExpressionCompletion(andExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION:
      {
        ExclusiveOrExpression exclusiveOrExpression = (ExclusiveOrExpression)theEObject;
        T result = caseExclusiveOrExpression(exclusiveOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION:
      {
        ExclusiveOrExpressionCompletion exclusiveOrExpressionCompletion = (ExclusiveOrExpressionCompletion)theEObject;
        T result = caseExclusiveOrExpressionCompletion(exclusiveOrExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INCLUSIVE_OR_EXPRESSION:
      {
        InclusiveOrExpression inclusiveOrExpression = (InclusiveOrExpression)theEObject;
        T result = caseInclusiveOrExpression(inclusiveOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION:
      {
        InclusiveOrExpressionCompletion inclusiveOrExpressionCompletion = (InclusiveOrExpressionCompletion)theEObject;
        T result = caseInclusiveOrExpressionCompletion(inclusiveOrExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONDITIONAL_AND_EXPRESSION:
      {
        ConditionalAndExpression conditionalAndExpression = (ConditionalAndExpression)theEObject;
        T result = caseConditionalAndExpression(conditionalAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION:
      {
        ConditionalAndExpressionCompletion conditionalAndExpressionCompletion = (ConditionalAndExpressionCompletion)theEObject;
        T result = caseConditionalAndExpressionCompletion(conditionalAndExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONDITIONAL_OR_EXPRESSION:
      {
        ConditionalOrExpression conditionalOrExpression = (ConditionalOrExpression)theEObject;
        T result = caseConditionalOrExpression(conditionalOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION:
      {
        ConditionalOrExpressionCompletion conditionalOrExpressionCompletion = (ConditionalOrExpressionCompletion)theEObject;
        T result = caseConditionalOrExpressionCompletion(conditionalOrExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONDITIONAL_EXPRESSION:
      {
        ConditionalExpression conditionalExpression = (ConditionalExpression)theEObject;
        T result = caseConditionalExpression(conditionalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION:
      {
        ConditionalExpressionCompletion conditionalExpressionCompletion = (ConditionalExpressionCompletion)theEObject;
        T result = caseConditionalExpressionCompletion(conditionalExpressionCompletion);
        if (result == null) result = caseExpressionCompletion(conditionalExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ASSIGNMENT_EXPRESSION_COMPLETION:
      {
        AssignmentExpressionCompletion assignmentExpressionCompletion = (AssignmentExpressionCompletion)theEObject;
        T result = caseAssignmentExpressionCompletion(assignmentExpressionCompletion);
        if (result == null) result = caseExpressionCompletion(assignmentExpressionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STATEMENT_SEQUENCE:
      {
        StatementSequence statementSequence = (StatementSequence)theEObject;
        T result = caseStatementSequence(statementSequence);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.DOCUMENTED_STATEMENT:
      {
        DocumentedStatement documentedStatement = (DocumentedStatement)theEObject;
        T result = caseDocumentedStatement(documentedStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BLOCK:
      {
        Block block = (Block)theEObject;
        T result = caseBlock(block);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ANNOTATED_STATEMENT:
      {
        AnnotatedStatement annotatedStatement = (AnnotatedStatement)theEObject;
        T result = caseAnnotatedStatement(annotatedStatement);
        if (result == null) result = caseStatement(annotatedStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ANNOTATIONS:
      {
        Annotations annotations = (Annotations)theEObject;
        T result = caseAnnotations(annotations);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ANNOTATION:
      {
        Annotation annotation = (Annotation)theEObject;
        T result = caseAnnotation(annotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAME_LIST:
      {
        NameList nameList = (NameList)theEObject;
        T result = caseNameList(nameList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.IN_LINE_STATEMENT:
      {
        InLineStatement inLineStatement = (InLineStatement)theEObject;
        T result = caseInLineStatement(inLineStatement);
        if (result == null) result = caseStatement(inLineStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BLOCK_STATEMENT:
      {
        BlockStatement blockStatement = (BlockStatement)theEObject;
        T result = caseBlockStatement(blockStatement);
        if (result == null) result = caseStatement(blockStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EMPTY_STATEMENT:
      {
        EmptyStatement emptyStatement = (EmptyStatement)theEObject;
        T result = caseEmptyStatement(emptyStatement);
        if (result == null) result = caseStatement(emptyStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT:
      {
        LocalNameDeclarationOrExpressionStatement localNameDeclarationOrExpressionStatement = (LocalNameDeclarationOrExpressionStatement)theEObject;
        T result = caseLocalNameDeclarationOrExpressionStatement(localNameDeclarationOrExpressionStatement);
        if (result == null) result = caseStatement(localNameDeclarationOrExpressionStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT:
      {
        LocalNameDeclarationStatement localNameDeclarationStatement = (LocalNameDeclarationStatement)theEObject;
        T result = caseLocalNameDeclarationStatement(localNameDeclarationStatement);
        if (result == null) result = caseStatement(localNameDeclarationStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT_COMPLETION:
      {
        LocalNameDeclarationStatementCompletion localNameDeclarationStatementCompletion = (LocalNameDeclarationStatementCompletion)theEObject;
        T result = caseLocalNameDeclarationStatementCompletion(localNameDeclarationStatementCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INITIALIZATION_EXPRESSION:
      {
        InitializationExpression initializationExpression = (InitializationExpression)theEObject;
        T result = caseInitializationExpression(initializationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INSTANCE_INITIALIZATION_EXPRESSION:
      {
        InstanceInitializationExpression instanceInitializationExpression = (InstanceInitializationExpression)theEObject;
        T result = caseInstanceInitializationExpression(instanceInitializationExpression);
        if (result == null) result = caseInitializationExpression(instanceInitializationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.IF_STATEMENT:
      {
        IfStatement ifStatement = (IfStatement)theEObject;
        T result = caseIfStatement(ifStatement);
        if (result == null) result = caseStatement(ifStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENTIAL_CLAUSES:
      {
        SequentialClauses sequentialClauses = (SequentialClauses)theEObject;
        T result = caseSequentialClauses(sequentialClauses);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONCURRENT_CLAUSES:
      {
        ConcurrentClauses concurrentClauses = (ConcurrentClauses)theEObject;
        T result = caseConcurrentClauses(concurrentClauses);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NON_FINAL_CLAUSE:
      {
        NonFinalClause nonFinalClause = (NonFinalClause)theEObject;
        T result = caseNonFinalClause(nonFinalClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FINAL_CLAUSE:
      {
        FinalClause finalClause = (FinalClause)theEObject;
        T result = caseFinalClause(finalClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SWITCH_STATEMENT:
      {
        SwitchStatement switchStatement = (SwitchStatement)theEObject;
        T result = caseSwitchStatement(switchStatement);
        if (result == null) result = caseStatement(switchStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SWITCH_CLAUSE:
      {
        SwitchClause switchClause = (SwitchClause)theEObject;
        T result = caseSwitchClause(switchClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SWITCH_CASE:
      {
        SwitchCase switchCase = (SwitchCase)theEObject;
        T result = caseSwitchCase(switchCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SWITCH_DEFAULT_CLAUSE:
      {
        SwitchDefaultClause switchDefaultClause = (SwitchDefaultClause)theEObject;
        T result = caseSwitchDefaultClause(switchDefaultClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NON_EMPTY_STATEMENT_SEQUENCE:
      {
        NonEmptyStatementSequence nonEmptyStatementSequence = (NonEmptyStatementSequence)theEObject;
        T result = caseNonEmptyStatementSequence(nonEmptyStatementSequence);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.WHILE_STATEMENT:
      {
        WhileStatement whileStatement = (WhileStatement)theEObject;
        T result = caseWhileStatement(whileStatement);
        if (result == null) result = caseStatement(whileStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.DO_STATEMENT:
      {
        DoStatement doStatement = (DoStatement)theEObject;
        T result = caseDoStatement(doStatement);
        if (result == null) result = caseStatement(doStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FOR_STATEMENT:
      {
        ForStatement forStatement = (ForStatement)theEObject;
        T result = caseForStatement(forStatement);
        if (result == null) result = caseStatement(forStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FOR_CONTROL:
      {
        ForControl forControl = (ForControl)theEObject;
        T result = caseForControl(forControl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LOOP_VARIABLE_DEFINITION:
      {
        LoopVariableDefinition loopVariableDefinition = (LoopVariableDefinition)theEObject;
        T result = caseLoopVariableDefinition(loopVariableDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BREAK_STATEMENT:
      {
        BreakStatement breakStatement = (BreakStatement)theEObject;
        T result = caseBreakStatement(breakStatement);
        if (result == null) result = caseStatement(breakStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.RETURN_STATEMENT:
      {
        ReturnStatement returnStatement = (ReturnStatement)theEObject;
        T result = caseReturnStatement(returnStatement);
        if (result == null) result = caseStatement(returnStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACCEPT_STATEMENT:
      {
        AcceptStatement acceptStatement = (AcceptStatement)theEObject;
        T result = caseAcceptStatement(acceptStatement);
        if (result == null) result = caseStatement(acceptStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SIMPLE_ACCEPT_STATEMENT_COMPLETION:
      {
        SimpleAcceptStatementCompletion simpleAcceptStatementCompletion = (SimpleAcceptStatementCompletion)theEObject;
        T result = caseSimpleAcceptStatementCompletion(simpleAcceptStatementCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.COMPOUND_ACCEPT_STATEMENT_COMPLETION:
      {
        CompoundAcceptStatementCompletion compoundAcceptStatementCompletion = (CompoundAcceptStatementCompletion)theEObject;
        T result = caseCompoundAcceptStatementCompletion(compoundAcceptStatementCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACCEPT_BLOCK:
      {
        AcceptBlock acceptBlock = (AcceptBlock)theEObject;
        T result = caseAcceptBlock(acceptBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACCEPT_CLAUSE:
      {
        AcceptClause acceptClause = (AcceptClause)theEObject;
        T result = caseAcceptClause(acceptClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFY_STATEMENT:
      {
        ClassifyStatement classifyStatement = (ClassifyStatement)theEObject;
        T result = caseClassifyStatement(classifyStatement);
        if (result == null) result = caseStatement(classifyStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFICATION_CLAUSE:
      {
        ClassificationClause classificationClause = (ClassificationClause)theEObject;
        T result = caseClassificationClause(classificationClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFICATION_FROM_CLAUSE:
      {
        ClassificationFromClause classificationFromClause = (ClassificationFromClause)theEObject;
        T result = caseClassificationFromClause(classificationFromClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFICATION_TO_CLAUSE:
      {
        ClassificationToClause classificationToClause = (ClassificationToClause)theEObject;
        T result = caseClassificationToClause(classificationToClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.RECLASSIFY_ALL_CLAUSE:
      {
        ReclassifyAllClause reclassifyAllClause = (ReclassifyAllClause)theEObject;
        T result = caseReclassifyAllClause(reclassifyAllClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.QUALIFIED_NAME_LIST:
      {
        QualifiedNameList qualifiedNameList = (QualifiedNameList)theEObject;
        T result = caseQualifiedNameList(qualifiedNameList);
        if (result == null) result = caseTaggedValues(qualifiedNameList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnitDefinition(UnitDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>BOOLEAN LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>BOOLEAN LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBOOLEAN_LITERAL(BOOLEAN_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>NUMBER LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>NUMBER LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNUMBER_LITERAL(NUMBER_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>INTEGER LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>INTEGER LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseINTEGER_LITERAL(INTEGER_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UNLIMITED NATURAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UNLIMITED NATURAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUNLIMITED_NATURAL(UNLIMITED_NATURAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>STRING LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>STRING LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTRING_LITERAL(STRING_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stereotype Annotations</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stereotype Annotations</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStereotypeAnnotations(StereotypeAnnotations object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stereotype Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stereotype Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStereotypeAnnotation(StereotypeAnnotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Values</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Values</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedValues(TaggedValues object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Value List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Value List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedValueList(TaggedValueList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>PRIMITIVE LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PRIMITIVE LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePRIMITIVE_LITERAL(PRIMITIVE_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedValue(TaggedValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Namespace Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Namespace Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamespaceDeclaration(NamespaceDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImportDeclaration(ImportDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImportReference(ImportReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import Reference Qualified Name Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import Reference Qualified Name Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImportReferenceQualifiedNameCompletion(ImportReferenceQualifiedNameCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Colon Qualified Name Completion Of Import Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Colon Qualified Name Completion Of Import Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColonQualifiedNameCompletionOfImportReference(ColonQualifiedNameCompletionOfImportReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alias Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alias Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAliasDefinition(AliasDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Namespace Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Namespace Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamespaceDefinition(NamespaceDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Visibility Indicator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Visibility Indicator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVisibilityIndicator(VisibilityIndicator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDeclaration(PackageDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDefinition(PackageDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDefinitionOrStub(PackageDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageBody(PackageBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Packaged Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Packaged Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackagedElement(PackagedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Packaged Element Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Packaged Element Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackagedElementDefinition(PackagedElementDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierDefinition(ClassifierDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierDefinitionOrStub(ClassifierDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Signature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Signature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierSignature(ClassifierSignature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Template Parameters</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Template Parameters</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTemplateParameters(TemplateParameters object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Template Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Template Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierTemplateParameter(ClassifierTemplateParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Specialization Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Specialization Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecializationClause(SpecializationClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassDeclaration(ClassDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassDefinition(ClassDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassDefinitionOrStub(ClassDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassBody(ClassBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Member</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Member</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassMember(ClassMember object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Member Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Member Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassMemberDefinition(ClassMemberDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Active Class Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Active Class Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActiveClassDeclaration(ActiveClassDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Active Class Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Active Class Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActiveClassDefinition(ActiveClassDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Active Class Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Active Class Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActiveClassDefinitionOrStub(ActiveClassDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Active Class Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Active Class Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActiveClassBody(ActiveClassBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorClause(BehaviorClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Active Class Member</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Active Class Member</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActiveClassMember(ActiveClassMember object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Active Class Member Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Active Class Member Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActiveClassMemberDefinition(ActiveClassMemberDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Type Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Type Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataTypeDeclaration(DataTypeDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataTypeDefinition(DataTypeDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Type Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Type Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataTypeDefinitionOrStub(DataTypeDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Structured Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structured Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructuredBody(StructuredBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Structured Member</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structured Member</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructuredMember(StructuredMember object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationDeclaration(AssociationDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationDefinition(AssociationDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationDefinitionOrStub(AssociationDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationDeclaration(EnumerationDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationDefinition(EnumerationDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationDefinitionOrStub(EnumerationDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationBody(EnumerationBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Literal Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationLiteralName(EnumerationLiteralName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signal Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signal Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignalDeclaration(SignalDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signal Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signal Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignalDefinition(SignalDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signal Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signal Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignalDefinitionOrStub(SignalDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActivityDeclaration(ActivityDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActivityDefinition(ActivityDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActivityDefinitionOrStub(ActivityDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formal Parameters</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formal Parameters</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormalParameters(FormalParameters object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formal Parameter List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formal Parameter List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormalParameterList(FormalParameterList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormalParameter(FormalParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureDefinitionOrStub(FeatureDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Active Feature Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Active Feature Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActiveFeatureDefinitionOrStub(ActiveFeatureDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyDefinition(PropertyDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeDefinition(AttributeDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Initializer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Initializer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeInitializer(AttributeInitializer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyDeclaration(PropertyDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypePart(TypePart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeName(TypeName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicity(Multiplicity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicityRange(MultiplicityRange object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnlimitedNaturalLiteral(UnlimitedNaturalLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationDeclaration(OperationDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationDefinitionOrStub(OperationDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Redefinition Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Redefinition Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRedefinitionClause(RedefinitionClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reception Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reception Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReceptionDefinition(ReceptionDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signal Reception Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signal Reception Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignalReceptionDeclaration(SignalReceptionDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signal Reception Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signal Reception Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignalReceptionDefinitionOrStub(SignalReceptionDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseName(Name object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedName(QualifiedName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Colon Qualified Name Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Colon Qualified Name Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColonQualifiedNameCompletion(ColonQualifiedNameCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unqualified Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unqualified Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnqualifiedName(UnqualifiedName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameBinding(NameBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Name Without Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Name Without Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedNameWithoutBinding(QualifiedNameWithoutBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Colon Qualified Name Completion Without Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Colon Qualified Name Completion Without Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColonQualifiedNameCompletionWithoutBinding(ColonQualifiedNameCompletionWithoutBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Template Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Template Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTemplateBinding(TemplateBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Positional Template Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Positional Template Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePositionalTemplateBinding(PositionalTemplateBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Template Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Template Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedTemplateBinding(NamedTemplateBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Template Parameter Substitution</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Template Parameter Substitution</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTemplateParameterSubstitution(TemplateParameterSubstitution object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Name Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Name Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonNameExpression(NonNameExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name To Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name To Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameToExpressionCompletion(NameToExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary To Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary To Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryToExpressionCompletion(PrimaryToExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionCompletion(ExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryExpression(PrimaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Base Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Base Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBaseExpression(BaseExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name To Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name To Primary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameToPrimaryExpression(NameToPrimaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryExpressionCompletion(PrimaryExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Or Sequence Operation Or Reduction Or Expansion Or Index</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Or Sequence Operation Or Reduction Or Expansion Or Index</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index(Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteralExpression(LiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Or Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Or Primary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameOrPrimaryExpression(NameOrPrimaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>This Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>This Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThisExpression(ThisExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParenthesizedExpression(ParenthesizedExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeature(Feature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTuple(Tuple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Positional Tuple Expression List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Positional Tuple Expression List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePositionalTupleExpressionList(PositionalTupleExpressionList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Positional Tuple Expression List Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Positional Tuple Expression List Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePositionalTupleExpressionListCompletion(PositionalTupleExpressionListCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Tuple Expression List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Tuple Expression List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedTupleExpressionList(NamedTupleExpressionList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedExpression(NamedExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorInvocation(BehaviorInvocation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureInvocation(FeatureInvocation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Super Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Super Invocation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuperInvocationExpression(SuperInvocationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Creation Or Sequence Construction Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Creation Or Sequence Construction Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceCreationOrSequenceConstructionExpression(InstanceCreationOrSequenceConstructionExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Link Operation Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Link Operation Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinkOperationCompletion(LinkOperationCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Link Operation Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Link Operation Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinkOperationTuple(LinkOperationTuple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Indexed Named Expression List Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Indexed Named Expression List Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndexedNamedExpressionListCompletion(IndexedNamedExpressionListCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Indexed Named Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Indexed Named Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndexedNamedExpression(IndexedNamedExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Extent Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Extent Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassExtentExpressionCompletion(ClassExtentExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Any Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Any Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceAnyExpression(SequenceAnyExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Construction Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Construction Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceConstructionExpressionCompletion(SequenceConstructionExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity Indicator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity Indicator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicityIndicator(MultiplicityIndicator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Elements</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Elements</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceElements(SequenceElements object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Element List Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Element List Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceElementListCompletion(SequenceElementListCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceElement(SequenceElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Initialization Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Initialization Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceInitializationExpression(SequenceInitializationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Index</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Index</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndex(Index object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Operation Or Reduction Or Expansion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Operation Or Reduction Or Expansion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceOperationOrReductionOrExpansion(SequenceOperationOrReductionOrExpansion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpressionCompletion(PostfixExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixOperation(PostfixOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prefix Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prefix Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrefixExpression(PrefixExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryExpression(UnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Or Cast Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Or Cast Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixOrCastExpression(PostfixOrCastExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Name Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Name Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonNameUnaryExpression(NonNameUnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Name Postfix Or Cast Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Name Postfix Or Cast Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonNamePostfixOrCastExpression(NonNamePostfixOrCastExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Postfix Non Cast Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Postfix Non Cast Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonPostfixNonCastUnaryExpression(NonPostfixNonCastUnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Negation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Negation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanNegationExpression(BooleanNegationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bit String Complement Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bit String Complement Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBitStringComplementExpression(BitStringComplementExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numeric Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numeric Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericUnaryExpression(NumericUnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Isolation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Isolation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIsolationExpression(IsolationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cast Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cast Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCastCompletion(CastCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicativeExpression(MultiplicativeExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicative Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicativeExpressionCompletion(MultiplicativeExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdditiveExpression(AdditiveExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Additive Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Additive Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdditiveExpressionCompletion(AdditiveExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShiftExpression(ShiftExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shift Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shift Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShiftExpressionCompletion(ShiftExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationalExpression(RelationalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationalExpressionCompletion(RelationalExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationExpression(ClassificationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationExpressionCompletion(ClassificationExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualityExpression(EqualityExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equality Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equality Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualityExpressionCompletion(EqualityExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpression(AndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpressionCompletion(AndExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exclusive Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExclusiveOrExpression(ExclusiveOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exclusive Or Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exclusive Or Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExclusiveOrExpressionCompletion(ExclusiveOrExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inclusive Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInclusiveOrExpression(InclusiveOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inclusive Or Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inclusive Or Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalAndExpression(ConditionalAndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional And Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional And Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalAndExpressionCompletion(ConditionalAndExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalOrExpression(ConditionalOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Or Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Or Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalOrExpressionCompletion(ConditionalOrExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalExpression(ConditionalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalExpressionCompletion(ConditionalExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Expression Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignmentExpressionCompletion(AssignmentExpressionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement Sequence</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement Sequence</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatementSequence(StatementSequence object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Documented Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Documented Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDocumentedStatement(DocumentedStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlock(Block object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotated Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotated Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotatedStatement(AnnotatedStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotations</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotations</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotations(Annotations object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotation(Annotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameList(NameList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>In Line Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>In Line Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInLineStatement(InLineStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlockStatement(BlockStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmptyStatement(EmptyStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Local Name Declaration Or Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Name Declaration Or Expression Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalNameDeclarationOrExpressionStatement(LocalNameDeclarationOrExpressionStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Local Name Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Name Declaration Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalNameDeclarationStatement(LocalNameDeclarationStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Local Name Declaration Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Name Declaration Statement Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalNameDeclarationStatementCompletion(LocalNameDeclarationStatementCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Initialization Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Initialization Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitializationExpression(InitializationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Initialization Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Initialization Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceInitializationExpression(InstanceInitializationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfStatement(IfStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequential Clauses</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequential Clauses</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequentialClauses(SequentialClauses object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concurrent Clauses</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concurrent Clauses</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcurrentClauses(ConcurrentClauses object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Final Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Final Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonFinalClause(NonFinalClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Final Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Final Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFinalClause(FinalClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchStatement(SwitchStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchClause(SwitchClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchCase(SwitchCase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Default Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Default Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchDefaultClause(SwitchDefaultClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Empty Statement Sequence</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Empty Statement Sequence</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonEmptyStatementSequence(NonEmptyStatementSequence object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhileStatement(WhileStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Do Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Do Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDoStatement(DoStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForStatement(ForStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For Control</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Control</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForControl(ForControl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop Variable Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoopVariableDefinition(LoopVariableDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBreakStatement(BreakStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReturnStatement(ReturnStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Accept Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Accept Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAcceptStatement(AcceptStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Accept Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Accept Statement Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleAcceptStatementCompletion(SimpleAcceptStatementCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compound Accept Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compound Accept Statement Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompoundAcceptStatementCompletion(CompoundAcceptStatementCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Accept Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Accept Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAcceptBlock(AcceptBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Accept Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Accept Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAcceptClause(AcceptClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classify Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classify Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifyStatement(ClassifyStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationClause(ClassificationClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification From Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification From Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationFromClause(ClassificationFromClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification To Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification To Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationToClause(ClassificationToClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reclassify All Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reclassify All Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReclassifyAllClause(ReclassifyAllClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Name List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Name List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedNameList(QualifiedNameList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //AlfSwitch
