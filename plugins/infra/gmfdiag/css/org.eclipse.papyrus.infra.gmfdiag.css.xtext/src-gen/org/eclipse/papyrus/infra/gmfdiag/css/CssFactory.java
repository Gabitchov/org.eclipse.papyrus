/*****************************************************************************
 * Copyright (c) 2012-2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage
 * @generated
 */
public interface CssFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CssFactory eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.css.impl.CssFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Stylesheet</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stylesheet</em>'.
   * @generated
   */
  Stylesheet createStylesheet();

  /**
   * Returns a new object of class '<em>Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Content</em>'.
   * @generated
   */
  Content createContent();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Media</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Media</em>'.
   * @generated
   */
  Media createMedia();

  /**
   * Returns a new object of class '<em>Page</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Page</em>'.
   * @generated
   */
  Page createPage();

  /**
   * Returns a new object of class '<em>Pseudo Page</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pseudo Page</em>'.
   * @generated
   */
  PseudoPage createPseudoPage();

  /**
   * Returns a new object of class '<em>Ruleset</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ruleset</em>'.
   * @generated
   */
  Ruleset createRuleset();

  /**
   * Returns a new object of class '<em>Selector</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Selector</em>'.
   * @generated
   */
  Selector createSelector();

  /**
   * Returns a new object of class '<em>Composite Selector</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Composite Selector</em>'.
   * @generated
   */
  CompositeSelector createCompositeSelector();

  /**
   * Returns a new object of class '<em>Simple Selector</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Selector</em>'.
   * @generated
   */
  SimpleSelector createSimpleSelector();

  /**
   * Returns a new object of class '<em>Selector Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Selector Condition</em>'.
   * @generated
   */
  SelectorCondition createSelectorCondition();

  /**
   * Returns a new object of class '<em>Combinator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Combinator</em>'.
   * @generated
   */
  Combinator createCombinator();

  /**
   * Returns a new object of class '<em>Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declaration</em>'.
   * @generated
   */
  Declaration createDeclaration();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Subterm</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subterm</em>'.
   * @generated
   */
  Subterm createSubterm();

  /**
   * Returns a new object of class '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term</em>'.
   * @generated
   */
  Term createTerm();

  /**
   * Returns a new object of class '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function</em>'.
   * @generated
   */
  Function createFunction();

  /**
   * Returns a new object of class '<em>Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name</em>'.
   * @generated
   */
  Name createName();

  /**
   * Returns a new object of class '<em>Number</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number</em>'.
   * @generated
   */
  Number createNumber();

  /**
   * Returns a new object of class '<em>Percentage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Percentage</em>'.
   * @generated
   */
  Percentage createPercentage();

  /**
   * Returns a new object of class '<em>Length</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Length</em>'.
   * @generated
   */
  Length createLength();

  /**
   * Returns a new object of class '<em>Ems</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ems</em>'.
   * @generated
   */
  Ems createEms();

  /**
   * Returns a new object of class '<em>Exs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exs</em>'.
   * @generated
   */
  Exs createExs();

  /**
   * Returns a new object of class '<em>Angle</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Angle</em>'.
   * @generated
   */
  Angle createAngle();

  /**
   * Returns a new object of class '<em>Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time</em>'.
   * @generated
   */
  Time createTime();

  /**
   * Returns a new object of class '<em>Frequency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Frequency</em>'.
   * @generated
   */
  Frequency createFrequency();

  /**
   * Returns a new object of class '<em>Uri</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Uri</em>'.
   * @generated
   */
  Uri createUri();

  /**
   * Returns a new object of class '<em>String Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Value</em>'.
   * @generated
   */
  StringValue createStringValue();

  /**
   * Returns a new object of class '<em>Hex Color</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hex Color</em>'.
   * @generated
   */
  HexColor createHexColor();

  /**
   * Returns a new object of class '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class</em>'.
   * @generated
   */
  Class createClass();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Attribute Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Value</em>'.
   * @generated
   */
  AttributeValue createAttributeValue();

  /**
   * Returns a new object of class '<em>Pseudo</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pseudo</em>'.
   * @generated
   */
  Pseudo createPseudo();

  /**
   * Returns a new object of class '<em>CSS Id</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CSS Id</em>'.
   * @generated
   */
  CSSId createCSSId();

  /**
   * Returns a new object of class '<em>Unary Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Operator</em>'.
   * @generated
   */
  UnaryOperator createUnaryOperator();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CssPackage getCssPackage();

} //CssFactory
