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
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage
 * @generated
 */
public interface OperationFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  OperationFactory eINSTANCE = org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Definition Or Stub</em>'.
   * @generated
   */
  OperationDefinitionOrStub createOperationDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declaration</em>'.
   * @generated
   */
  OperationDeclaration createOperationDeclaration();

  /**
   * Returns a new object of class '<em>Formal Parameters</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Parameters</em>'.
   * @generated
   */
  FormalParameters createFormalParameters();

  /**
   * Returns a new object of class '<em>Formal Parameter List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Parameter List</em>'.
   * @generated
   */
  FormalParameterList createFormalParameterList();

  /**
   * Returns a new object of class '<em>Formal Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Parameter</em>'.
   * @generated
   */
  FormalParameter createFormalParameter();

  /**
   * Returns a new object of class '<em>Type Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Part</em>'.
   * @generated
   */
  TypePart createTypePart();

  /**
   * Returns a new object of class '<em>Multiplicity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity</em>'.
   * @generated
   */
  Multiplicity createMultiplicity();

  /**
   * Returns a new object of class '<em>Multiplicity Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity Range</em>'.
   * @generated
   */
  MultiplicityRange createMultiplicityRange();

  /**
   * Returns a new object of class '<em>NUMBER LITERAL WITHOUT SUFFIX</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>NUMBER LITERAL WITHOUT SUFFIX</em>'.
   * @generated
   */
  NUMBER_LITERAL_WITHOUT_SUFFIX createNUMBER_LITERAL_WITHOUT_SUFFIX();

  /**
   * Returns a new object of class '<em>INTEGER LITERAL WITHOUT SUFFIX</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>INTEGER LITERAL WITHOUT SUFFIX</em>'.
   * @generated
   */
  INTEGER_LITERAL_WITHOUT_SUFFIX createINTEGER_LITERAL_WITHOUT_SUFFIX();

  /**
   * Returns a new object of class '<em>UNLIMITED LITERAL WITHOUT SUFFIX</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UNLIMITED LITERAL WITHOUT SUFFIX</em>'.
   * @generated
   */
  UNLIMITED_LITERAL_WITHOUT_SUFFIX createUNLIMITED_LITERAL_WITHOUT_SUFFIX();

  /**
   * Returns a new object of class '<em>Type Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Name</em>'.
   * @generated
   */
  TypeName createTypeName();

  /**
   * Returns a new object of class '<em>Redefinition Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Redefinition Clause</em>'.
   * @generated
   */
  RedefinitionClause createRedefinitionClause();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  OperationPackage getOperationPackage();

} //OperationFactory
