/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.*;

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
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage
 * @generated
 */
public class OperationSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static OperationPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = OperationPackage.eINSTANCE;
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
      case OperationPackage.OPERATION_DEFINITION_OR_STUB:
      {
        OperationDefinitionOrStub operationDefinitionOrStub = (OperationDefinitionOrStub)theEObject;
        T result = caseOperationDefinitionOrStub(operationDefinitionOrStub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.OPERATION_DECLARATION:
      {
        OperationDeclaration operationDeclaration = (OperationDeclaration)theEObject;
        T result = caseOperationDeclaration(operationDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.FORMAL_PARAMETERS:
      {
        FormalParameters formalParameters = (FormalParameters)theEObject;
        T result = caseFormalParameters(formalParameters);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.FORMAL_PARAMETER_LIST:
      {
        FormalParameterList formalParameterList = (FormalParameterList)theEObject;
        T result = caseFormalParameterList(formalParameterList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.FORMAL_PARAMETER:
      {
        FormalParameter formalParameter = (FormalParameter)theEObject;
        T result = caseFormalParameter(formalParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.TYPE_PART:
      {
        TypePart typePart = (TypePart)theEObject;
        T result = caseTypePart(typePart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.MULTIPLICITY:
      {
        Multiplicity multiplicity = (Multiplicity)theEObject;
        T result = caseMultiplicity(multiplicity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.MULTIPLICITY_RANGE:
      {
        MultiplicityRange multiplicityRange = (MultiplicityRange)theEObject;
        T result = caseMultiplicityRange(multiplicityRange);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.NUMBER_LITERAL_WITHOUT_SUFFIX:
      {
        NUMBER_LITERAL_WITHOUT_SUFFIX numbeR_LITERAL_WITHOUT_SUFFIX = (NUMBER_LITERAL_WITHOUT_SUFFIX)theEObject;
        T result = caseNUMBER_LITERAL_WITHOUT_SUFFIX(numbeR_LITERAL_WITHOUT_SUFFIX);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.INTEGER_LITERAL_WITHOUT_SUFFIX:
      {
        INTEGER_LITERAL_WITHOUT_SUFFIX integeR_LITERAL_WITHOUT_SUFFIX = (INTEGER_LITERAL_WITHOUT_SUFFIX)theEObject;
        T result = caseINTEGER_LITERAL_WITHOUT_SUFFIX(integeR_LITERAL_WITHOUT_SUFFIX);
        if (result == null) result = caseNUMBER_LITERAL_WITHOUT_SUFFIX(integeR_LITERAL_WITHOUT_SUFFIX);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.UNLIMITED_LITERAL_WITHOUT_SUFFIX:
      {
        UNLIMITED_LITERAL_WITHOUT_SUFFIX unlimiteD_LITERAL_WITHOUT_SUFFIX = (UNLIMITED_LITERAL_WITHOUT_SUFFIX)theEObject;
        T result = caseUNLIMITED_LITERAL_WITHOUT_SUFFIX(unlimiteD_LITERAL_WITHOUT_SUFFIX);
        if (result == null) result = caseNUMBER_LITERAL_WITHOUT_SUFFIX(unlimiteD_LITERAL_WITHOUT_SUFFIX);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.TYPE_NAME:
      {
        TypeName typeName = (TypeName)theEObject;
        T result = caseTypeName(typeName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperationPackage.REDEFINITION_CLAUSE:
      {
        RedefinitionClause redefinitionClause = (RedefinitionClause)theEObject;
        T result = caseRedefinitionClause(redefinitionClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Definition Or Stub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationDefinitionOrStub(OperationDefinitionOrStub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationDeclaration(OperationDeclaration object)
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
   * Returns the result of interpreting the object as an instance of '<em>NUMBER LITERAL WITHOUT SUFFIX</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>NUMBER LITERAL WITHOUT SUFFIX</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNUMBER_LITERAL_WITHOUT_SUFFIX(NUMBER_LITERAL_WITHOUT_SUFFIX object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>INTEGER LITERAL WITHOUT SUFFIX</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>INTEGER LITERAL WITHOUT SUFFIX</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseINTEGER_LITERAL_WITHOUT_SUFFIX(INTEGER_LITERAL_WITHOUT_SUFFIX object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UNLIMITED LITERAL WITHOUT SUFFIX</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UNLIMITED LITERAL WITHOUT SUFFIX</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUNLIMITED_LITERAL_WITHOUT_SUFFIX(UNLIMITED_LITERAL_WITHOUT_SUFFIX object)
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

} //OperationSwitch
