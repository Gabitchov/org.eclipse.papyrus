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
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssFactory
 * @model kind="package"
 * @generated
 */
public interface CssPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "css";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/infra/gmfdiag/CSS";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "css";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CssPackage eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.StylesheetImpl <em>Stylesheet</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.StylesheetImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getStylesheet()
   * @generated
   */
  int STYLESHEET = 0;

  /**
   * The feature id for the '<em><b>Charset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STYLESHEET__CHARSET = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STYLESHEET__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STYLESHEET__CONTENTS = 2;

  /**
   * The number of structural features of the '<em>Stylesheet</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STYLESHEET_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ContentImpl <em>Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ContentImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getContent()
   * @generated
   */
  int CONTENT = 1;

  /**
   * The number of structural features of the '<em>Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ImportImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 2;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__STRING = 0;

  /**
   * The feature id for the '<em><b>Uri</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__URI = 1;

  /**
   * The feature id for the '<em><b>Media</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__MEDIA = 2;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.MediaImpl <em>Media</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.MediaImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getMedia()
   * @generated
   */
  int MEDIA = 3;

  /**
   * The feature id for the '<em><b>Media</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEDIA__MEDIA = CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEDIA__RULES = CONTENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Media</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEDIA_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PageImpl <em>Page</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.PageImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getPage()
   * @generated
   */
  int PAGE = 4;

  /**
   * The feature id for the '<em><b>Pseudo</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAGE__PSEUDO = CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAGE__DECLARATIONS = CONTENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Page</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAGE_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoPageImpl <em>Pseudo Page</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoPageImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getPseudoPage()
   * @generated
   */
  int PSEUDO_PAGE = 5;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PSEUDO_PAGE__ID = 0;

  /**
   * The number of structural features of the '<em>Pseudo Page</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PSEUDO_PAGE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.RulesetImpl <em>Ruleset</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.RulesetImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getRuleset()
   * @generated
   */
  int RULESET = 6;

  /**
   * The feature id for the '<em><b>Selectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULESET__SELECTORS = CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULESET__PROPERTIES = CONTENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Ruleset</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULESET_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SelectorImpl <em>Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.SelectorImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getSelector()
   * @generated
   */
  int SELECTOR = 7;

  /**
   * The number of structural features of the '<em>Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.CompositeSelectorImpl <em>Composite Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CompositeSelectorImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getCompositeSelector()
   * @generated
   */
  int COMPOSITE_SELECTOR = 8;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_SELECTOR__LEFT = SELECTOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Combinator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_SELECTOR__COMBINATOR = SELECTOR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_SELECTOR__RIGHT = SELECTOR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Composite Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_SELECTOR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SimpleSelectorImpl <em>Simple Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.SimpleSelectorImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getSimpleSelector()
   * @generated
   */
  int SIMPLE_SELECTOR = 9;

  /**
   * The feature id for the '<em><b>Element Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SELECTOR__ELEMENT_NAME = SELECTOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SELECTOR__CONDITION = SELECTOR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Simple Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SELECTOR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SelectorConditionImpl <em>Selector Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.SelectorConditionImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getSelectorCondition()
   * @generated
   */
  int SELECTOR_CONDITION = 10;

  /**
   * The number of structural features of the '<em>Selector Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR_CONDITION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.CombinatorImpl <em>Combinator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CombinatorImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getCombinator()
   * @generated
   */
  int COMBINATOR = 11;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMBINATOR__KIND = 0;

  /**
   * The number of structural features of the '<em>Combinator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMBINATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.DeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.DeclarationImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getDeclaration()
   * @generated
   */
  int DECLARATION = 12;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__PROPERTY = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Important</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__IMPORTANT = 2;

  /**
   * The number of structural features of the '<em>Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ExpressionImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 13;

  /**
   * The feature id for the '<em><b>Terms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__TERMS = 0;

  /**
   * The feature id for the '<em><b>Subterms</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__SUBTERMS = 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SubtermImpl <em>Subterm</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.SubtermImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getSubterm()
   * @generated
   */
  int SUBTERM = 14;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTERM__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTERM__TERM = 1;

  /**
   * The number of structural features of the '<em>Subterm</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTERM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.TermImpl <em>Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.TermImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getTerm()
   * @generated
   */
  int TERM = 15;

  /**
   * The number of structural features of the '<em>Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.FunctionImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__NAME = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__ARGS = TERM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.NameImpl <em>Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.NameImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getName_()
   * @generated
   */
  int NAME = 17;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME__VALUE = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.NumberImpl <em>Number</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.NumberImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getNumber()
   * @generated
   */
  int NUMBER = 18;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER__OP = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER__VALUE = TERM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Number</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PercentageImpl <em>Percentage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.PercentageImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getPercentage()
   * @generated
   */
  int PERCENTAGE = 19;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERCENTAGE__OP = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERCENTAGE__VALUE = TERM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERCENTAGE__UNIT = TERM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Percentage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERCENTAGE_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.LengthImpl <em>Length</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.LengthImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getLength()
   * @generated
   */
  int LENGTH = 20;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENGTH__OP = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENGTH__VALUE = TERM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENGTH__UNIT = TERM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Length</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENGTH_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.EmsImpl <em>Ems</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.EmsImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getEms()
   * @generated
   */
  int EMS = 21;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMS__OP = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMS__VALUE = TERM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMS__UNIT = TERM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Ems</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMS_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ExsImpl <em>Exs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ExsImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getExs()
   * @generated
   */
  int EXS = 22;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXS__OP = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXS__VALUE = TERM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXS__UNIT = TERM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Exs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXS_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.AngleImpl <em>Angle</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.AngleImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getAngle()
   * @generated
   */
  int ANGLE = 23;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANGLE__OP = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANGLE__VALUE = TERM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANGLE__UNIT = TERM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Angle</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANGLE_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.TimeImpl <em>Time</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.TimeImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getTime()
   * @generated
   */
  int TIME = 24;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME__OP = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME__VALUE = TERM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME__UNIT = TERM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Time</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.FrequencyImpl <em>Frequency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.FrequencyImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getFrequency()
   * @generated
   */
  int FREQUENCY = 25;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREQUENCY__OP = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREQUENCY__VALUE = TERM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREQUENCY__UNIT = TERM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Frequency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREQUENCY_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.UriImpl <em>Uri</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.UriImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getUri()
   * @generated
   */
  int URI = 26;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI__VALUE = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Uri</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.StringValueImpl <em>String Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.StringValueImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getStringValue()
   * @generated
   */
  int STRING_VALUE = 27;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE__VALUE = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.HexColorImpl <em>Hex Color</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.HexColorImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getHexColor()
   * @generated
   */
  int HEX_COLOR = 28;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEX_COLOR__VALUE = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Hex Color</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEX_COLOR_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ClassImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getClass_()
   * @generated
   */
  int CLASS = 29;

  /**
   * The feature id for the '<em><b>Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__CLASS = SELECTOR_CONDITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_FEATURE_COUNT = SELECTOR_CONDITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.AttributeImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = SELECTOR_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = SELECTOR_CONDITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = SELECTOR_CONDITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.AttributeValueImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getAttributeValue()
   * @generated
   */
  int ATTRIBUTE_VALUE = 31;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Attribute Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoImpl <em>Pseudo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getPseudo()
   * @generated
   */
  int PSEUDO = 32;

  /**
   * The feature id for the '<em><b>Pseudo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PSEUDO__PSEUDO = SELECTOR_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PSEUDO__ARGS = SELECTOR_CONDITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Pseudo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PSEUDO_FEATURE_COUNT = SELECTOR_CONDITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.CSSIdImpl <em>CSS Id</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CSSIdImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getCSSId()
   * @generated
   */
  int CSS_ID = 33;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CSS_ID__VALUE = SELECTOR_CONDITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>CSS Id</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CSS_ID_FEATURE_COUNT = SELECTOR_CONDITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.UnaryOperatorImpl
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 34;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATOR__OPERATOR = 0;

  /**
   * The number of structural features of the '<em>Unary Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.UNARY <em>UNARY</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.UNARY
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getUNARY()
   * @generated
   */
  int UNARY = 35;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.KIND <em>KIND</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.KIND
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getKIND()
   * @generated
   */
  int KIND = 36;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP <em>ATTRIBUTE OP</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP
   * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getATTRIBUTE_OP()
   * @generated
   */
  int ATTRIBUTE_OP = 37;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet <em>Stylesheet</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stylesheet</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet
   * @generated
   */
  EClass getStylesheet();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getCharset <em>Charset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Charset</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getCharset()
   * @see #getStylesheet()
   * @generated
   */
  EAttribute getStylesheet_Charset();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getImports()
   * @see #getStylesheet()
   * @generated
   */
  EReference getStylesheet_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contents</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getContents()
   * @see #getStylesheet()
   * @generated
   */
  EReference getStylesheet_Contents();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Content <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Content</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Content
   * @generated
   */
  EClass getContent();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Import#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Import#getString()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_String();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Import#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Uri</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Import#getUri()
   * @see #getImport()
   * @generated
   */
  EReference getImport_Uri();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.gmfdiag.css.Import#getMedia <em>Media</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Media</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Import#getMedia()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_Media();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Media <em>Media</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Media</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Media
   * @generated
   */
  EClass getMedia();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.gmfdiag.css.Media#getMedia <em>Media</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Media</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Media#getMedia()
   * @see #getMedia()
   * @generated
   */
  EAttribute getMedia_Media();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css.Media#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Media#getRules()
   * @see #getMedia()
   * @generated
   */
  EReference getMedia_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Page <em>Page</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Page</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Page
   * @generated
   */
  EClass getPage();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Page#getPseudo <em>Pseudo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pseudo</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Page#getPseudo()
   * @see #getPage()
   * @generated
   */
  EReference getPage_Pseudo();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css.Page#getDeclarations <em>Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declarations</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Page#getDeclarations()
   * @see #getPage()
   * @generated
   */
  EReference getPage_Declarations();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.PseudoPage <em>Pseudo Page</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pseudo Page</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.PseudoPage
   * @generated
   */
  EClass getPseudoPage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.PseudoPage#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.PseudoPage#getId()
   * @see #getPseudoPage()
   * @generated
   */
  EAttribute getPseudoPage_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Ruleset <em>Ruleset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ruleset</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Ruleset
   * @generated
   */
  EClass getRuleset();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css.Ruleset#getSelectors <em>Selectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Selectors</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Ruleset#getSelectors()
   * @see #getRuleset()
   * @generated
   */
  EReference getRuleset_Selectors();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css.Ruleset#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Ruleset#getProperties()
   * @see #getRuleset()
   * @generated
   */
  EReference getRuleset_Properties();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Selector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selector</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Selector
   * @generated
   */
  EClass getSelector();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector <em>Composite Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composite Selector</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector
   * @generated
   */
  EClass getCompositeSelector();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getLeft()
   * @see #getCompositeSelector()
   * @generated
   */
  EReference getCompositeSelector_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getCombinator <em>Combinator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Combinator</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getCombinator()
   * @see #getCompositeSelector()
   * @generated
   */
  EReference getCompositeSelector_Combinator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getRight()
   * @see #getCompositeSelector()
   * @generated
   */
  EReference getCompositeSelector_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector <em>Simple Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Selector</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector
   * @generated
   */
  EClass getSimpleSelector();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector#getElementName <em>Element Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Element Name</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector#getElementName()
   * @see #getSimpleSelector()
   * @generated
   */
  EAttribute getSimpleSelector_ElementName();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Condition</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector#getCondition()
   * @see #getSimpleSelector()
   * @generated
   */
  EReference getSimpleSelector_Condition();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition <em>Selector Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selector Condition</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition
   * @generated
   */
  EClass getSelectorCondition();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Combinator <em>Combinator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Combinator</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Combinator
   * @generated
   */
  EClass getCombinator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Combinator#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Combinator#getKind()
   * @see #getCombinator()
   * @generated
   */
  EAttribute getCombinator_Kind();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Declaration
   * @generated
   */
  EClass getDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Declaration#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Declaration#getProperty()
   * @see #getDeclaration()
   * @generated
   */
  EAttribute getDeclaration_Property();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Declaration#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Declaration#getExpression()
   * @see #getDeclaration()
   * @generated
   */
  EReference getDeclaration_Expression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Declaration#isImportant <em>Important</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Important</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Declaration#isImportant()
   * @see #getDeclaration()
   * @generated
   */
  EAttribute getDeclaration_Important();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Expression#getTerms <em>Terms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Terms</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Expression#getTerms()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Terms();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css.Expression#getSubterms <em>Subterms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subterms</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Expression#getSubterms()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Subterms();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Subterm <em>Subterm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subterm</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Subterm
   * @generated
   */
  EClass getSubterm();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Subterm#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Subterm#getOperator()
   * @see #getSubterm()
   * @generated
   */
  EAttribute getSubterm_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Subterm#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Subterm#getTerm()
   * @see #getSubterm()
   * @generated
   */
  EReference getSubterm_Term();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Term
   * @generated
   */
  EClass getTerm();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Function#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Function#getName()
   * @see #getFunction()
   * @generated
   */
  EAttribute getFunction_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Function#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Args</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Function#getArgs()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Args();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Name <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Name
   * @generated
   */
  EClass getName_();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Name#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Name#getValue()
   * @see #getName_()
   * @generated
   */
  EAttribute getName_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Number <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Number
   * @generated
   */
  EClass getNumber();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Number#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Number#getOp()
   * @see #getNumber()
   * @generated
   */
  EReference getNumber_Op();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Number#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Number#getValue()
   * @see #getNumber()
   * @generated
   */
  EAttribute getNumber_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Percentage <em>Percentage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Percentage</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Percentage
   * @generated
   */
  EClass getPercentage();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Percentage#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Percentage#getOp()
   * @see #getPercentage()
   * @generated
   */
  EReference getPercentage_Op();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Percentage#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Percentage#getValue()
   * @see #getPercentage()
   * @generated
   */
  EAttribute getPercentage_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Percentage#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Percentage#getUnit()
   * @see #getPercentage()
   * @generated
   */
  EAttribute getPercentage_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Length <em>Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Length</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Length
   * @generated
   */
  EClass getLength();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Length#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Length#getOp()
   * @see #getLength()
   * @generated
   */
  EReference getLength_Op();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Length#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Length#getValue()
   * @see #getLength()
   * @generated
   */
  EAttribute getLength_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Length#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Length#getUnit()
   * @see #getLength()
   * @generated
   */
  EAttribute getLength_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Ems <em>Ems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ems</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Ems
   * @generated
   */
  EClass getEms();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Ems#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Ems#getOp()
   * @see #getEms()
   * @generated
   */
  EReference getEms_Op();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Ems#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Ems#getValue()
   * @see #getEms()
   * @generated
   */
  EAttribute getEms_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Ems#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Ems#getUnit()
   * @see #getEms()
   * @generated
   */
  EAttribute getEms_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Exs <em>Exs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exs</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Exs
   * @generated
   */
  EClass getExs();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Exs#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Exs#getOp()
   * @see #getExs()
   * @generated
   */
  EReference getExs_Op();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Exs#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Exs#getValue()
   * @see #getExs()
   * @generated
   */
  EAttribute getExs_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Exs#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Exs#getUnit()
   * @see #getExs()
   * @generated
   */
  EAttribute getExs_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Angle <em>Angle</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Angle</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Angle
   * @generated
   */
  EClass getAngle();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Angle#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Angle#getOp()
   * @see #getAngle()
   * @generated
   */
  EReference getAngle_Op();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Angle#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Angle#getValue()
   * @see #getAngle()
   * @generated
   */
  EAttribute getAngle_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Angle#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Angle#getUnit()
   * @see #getAngle()
   * @generated
   */
  EAttribute getAngle_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Time <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Time
   * @generated
   */
  EClass getTime();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Time#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Time#getOp()
   * @see #getTime()
   * @generated
   */
  EReference getTime_Op();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Time#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Time#getValue()
   * @see #getTime()
   * @generated
   */
  EAttribute getTime_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Time#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Time#getUnit()
   * @see #getTime()
   * @generated
   */
  EAttribute getTime_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency <em>Frequency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Frequency</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Frequency
   * @generated
   */
  EClass getFrequency();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getOp()
   * @see #getFrequency()
   * @generated
   */
  EReference getFrequency_Op();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getValue()
   * @see #getFrequency()
   * @generated
   */
  EAttribute getFrequency_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getUnit()
   * @see #getFrequency()
   * @generated
   */
  EAttribute getFrequency_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Uri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Uri</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Uri
   * @generated
   */
  EClass getUri();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Uri#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Uri#getValue()
   * @see #getUri()
   * @generated
   */
  EAttribute getUri_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.StringValue
   * @generated
   */
  EClass getStringValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.StringValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.StringValue#getValue()
   * @see #getStringValue()
   * @generated
   */
  EAttribute getStringValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.HexColor <em>Hex Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hex Color</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.HexColor
   * @generated
   */
  EClass getHexColor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.HexColor#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.HexColor#getValue()
   * @see #getHexColor()
   * @generated
   */
  EAttribute getHexColor_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Class
   * @generated
   */
  EClass getClass_();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Class#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Class#getClass_()
   * @see #getClass_()
   * @generated
   */
  EAttribute getClass_Class();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Attribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Attribute#getName()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue <em>Attribute Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue
   * @generated
   */
  EClass getAttributeValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue#getOperator()
   * @see #getAttributeValue()
   * @generated
   */
  EAttribute getAttributeValue_Operator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue#getValue()
   * @see #getAttributeValue()
   * @generated
   */
  EAttribute getAttributeValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Pseudo <em>Pseudo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pseudo</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Pseudo
   * @generated
   */
  EClass getPseudo();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Pseudo#getPseudo <em>Pseudo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pseudo</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Pseudo#getPseudo()
   * @see #getPseudo()
   * @generated
   */
  EAttribute getPseudo_Pseudo();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.Pseudo#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Args</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Pseudo#getArgs()
   * @see #getPseudo()
   * @generated
   */
  EAttribute getPseudo_Args();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.CSSId <em>CSS Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CSS Id</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CSSId
   * @generated
   */
  EClass getCSSId();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.CSSId#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CSSId#getValue()
   * @see #getCSSId()
   * @generated
   */
  EAttribute getCSSId_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Operator</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator
   * @generated
   */
  EClass getUnaryOperator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator#getOperator()
   * @see #getUnaryOperator()
   * @generated
   */
  EAttribute getUnaryOperator_Operator();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.gmfdiag.css.UNARY <em>UNARY</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>UNARY</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.UNARY
   * @generated
   */
  EEnum getUNARY();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.gmfdiag.css.KIND <em>KIND</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>KIND</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.KIND
   * @generated
   */
  EEnum getKIND();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP <em>ATTRIBUTE OP</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>ATTRIBUTE OP</em>'.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP
   * @generated
   */
  EEnum getATTRIBUTE_OP();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CssFactory getCssFactory();

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
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.StylesheetImpl <em>Stylesheet</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.StylesheetImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getStylesheet()
     * @generated
     */
    EClass STYLESHEET = eINSTANCE.getStylesheet();

    /**
     * The meta object literal for the '<em><b>Charset</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STYLESHEET__CHARSET = eINSTANCE.getStylesheet_Charset();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STYLESHEET__IMPORTS = eINSTANCE.getStylesheet_Imports();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STYLESHEET__CONTENTS = eINSTANCE.getStylesheet_Contents();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ContentImpl <em>Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ContentImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getContent()
     * @generated
     */
    EClass CONTENT = eINSTANCE.getContent();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ImportImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__STRING = eINSTANCE.getImport_String();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT__URI = eINSTANCE.getImport_Uri();

    /**
     * The meta object literal for the '<em><b>Media</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__MEDIA = eINSTANCE.getImport_Media();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.MediaImpl <em>Media</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.MediaImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getMedia()
     * @generated
     */
    EClass MEDIA = eINSTANCE.getMedia();

    /**
     * The meta object literal for the '<em><b>Media</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEDIA__MEDIA = eINSTANCE.getMedia_Media();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEDIA__RULES = eINSTANCE.getMedia_Rules();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PageImpl <em>Page</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.PageImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getPage()
     * @generated
     */
    EClass PAGE = eINSTANCE.getPage();

    /**
     * The meta object literal for the '<em><b>Pseudo</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PAGE__PSEUDO = eINSTANCE.getPage_Pseudo();

    /**
     * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PAGE__DECLARATIONS = eINSTANCE.getPage_Declarations();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoPageImpl <em>Pseudo Page</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoPageImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getPseudoPage()
     * @generated
     */
    EClass PSEUDO_PAGE = eINSTANCE.getPseudoPage();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PSEUDO_PAGE__ID = eINSTANCE.getPseudoPage_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.RulesetImpl <em>Ruleset</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.RulesetImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getRuleset()
     * @generated
     */
    EClass RULESET = eINSTANCE.getRuleset();

    /**
     * The meta object literal for the '<em><b>Selectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULESET__SELECTORS = eINSTANCE.getRuleset_Selectors();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULESET__PROPERTIES = eINSTANCE.getRuleset_Properties();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SelectorImpl <em>Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.SelectorImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getSelector()
     * @generated
     */
    EClass SELECTOR = eINSTANCE.getSelector();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.CompositeSelectorImpl <em>Composite Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CompositeSelectorImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getCompositeSelector()
     * @generated
     */
    EClass COMPOSITE_SELECTOR = eINSTANCE.getCompositeSelector();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_SELECTOR__LEFT = eINSTANCE.getCompositeSelector_Left();

    /**
     * The meta object literal for the '<em><b>Combinator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_SELECTOR__COMBINATOR = eINSTANCE.getCompositeSelector_Combinator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_SELECTOR__RIGHT = eINSTANCE.getCompositeSelector_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SimpleSelectorImpl <em>Simple Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.SimpleSelectorImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getSimpleSelector()
     * @generated
     */
    EClass SIMPLE_SELECTOR = eINSTANCE.getSimpleSelector();

    /**
     * The meta object literal for the '<em><b>Element Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_SELECTOR__ELEMENT_NAME = eINSTANCE.getSimpleSelector_ElementName();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_SELECTOR__CONDITION = eINSTANCE.getSimpleSelector_Condition();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SelectorConditionImpl <em>Selector Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.SelectorConditionImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getSelectorCondition()
     * @generated
     */
    EClass SELECTOR_CONDITION = eINSTANCE.getSelectorCondition();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.CombinatorImpl <em>Combinator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CombinatorImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getCombinator()
     * @generated
     */
    EClass COMBINATOR = eINSTANCE.getCombinator();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMBINATOR__KIND = eINSTANCE.getCombinator_Kind();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.DeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.DeclarationImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getDeclaration()
     * @generated
     */
    EClass DECLARATION = eINSTANCE.getDeclaration();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATION__PROPERTY = eINSTANCE.getDeclaration_Property();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATION__EXPRESSION = eINSTANCE.getDeclaration_Expression();

    /**
     * The meta object literal for the '<em><b>Important</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATION__IMPORTANT = eINSTANCE.getDeclaration_Important();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ExpressionImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Terms</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__TERMS = eINSTANCE.getExpression_Terms();

    /**
     * The meta object literal for the '<em><b>Subterms</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__SUBTERMS = eINSTANCE.getExpression_Subterms();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SubtermImpl <em>Subterm</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.SubtermImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getSubterm()
     * @generated
     */
    EClass SUBTERM = eINSTANCE.getSubterm();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBTERM__OPERATOR = eINSTANCE.getSubterm_Operator();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTERM__TERM = eINSTANCE.getSubterm_Term();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.TermImpl <em>Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.TermImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getTerm()
     * @generated
     */
    EClass TERM = eINSTANCE.getTerm();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.FunctionImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__ARGS = eINSTANCE.getFunction_Args();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.NameImpl <em>Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.NameImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getName_()
     * @generated
     */
    EClass NAME = eINSTANCE.getName_();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAME__VALUE = eINSTANCE.getName_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.NumberImpl <em>Number</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.NumberImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getNumber()
     * @generated
     */
    EClass NUMBER = eINSTANCE.getNumber();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMBER__OP = eINSTANCE.getNumber_Op();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBER__VALUE = eINSTANCE.getNumber_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PercentageImpl <em>Percentage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.PercentageImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getPercentage()
     * @generated
     */
    EClass PERCENTAGE = eINSTANCE.getPercentage();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PERCENTAGE__OP = eINSTANCE.getPercentage_Op();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PERCENTAGE__VALUE = eINSTANCE.getPercentage_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PERCENTAGE__UNIT = eINSTANCE.getPercentage_Unit();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.LengthImpl <em>Length</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.LengthImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getLength()
     * @generated
     */
    EClass LENGTH = eINSTANCE.getLength();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENGTH__OP = eINSTANCE.getLength_Op();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENGTH__VALUE = eINSTANCE.getLength_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENGTH__UNIT = eINSTANCE.getLength_Unit();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.EmsImpl <em>Ems</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.EmsImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getEms()
     * @generated
     */
    EClass EMS = eINSTANCE.getEms();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EMS__OP = eINSTANCE.getEms_Op();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EMS__VALUE = eINSTANCE.getEms_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EMS__UNIT = eINSTANCE.getEms_Unit();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ExsImpl <em>Exs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ExsImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getExs()
     * @generated
     */
    EClass EXS = eINSTANCE.getExs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXS__OP = eINSTANCE.getExs_Op();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXS__VALUE = eINSTANCE.getExs_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXS__UNIT = eINSTANCE.getExs_Unit();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.AngleImpl <em>Angle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.AngleImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getAngle()
     * @generated
     */
    EClass ANGLE = eINSTANCE.getAngle();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANGLE__OP = eINSTANCE.getAngle_Op();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANGLE__VALUE = eINSTANCE.getAngle_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANGLE__UNIT = eINSTANCE.getAngle_Unit();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.TimeImpl <em>Time</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.TimeImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getTime()
     * @generated
     */
    EClass TIME = eINSTANCE.getTime();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME__OP = eINSTANCE.getTime_Op();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME__VALUE = eINSTANCE.getTime_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME__UNIT = eINSTANCE.getTime_Unit();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.FrequencyImpl <em>Frequency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.FrequencyImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getFrequency()
     * @generated
     */
    EClass FREQUENCY = eINSTANCE.getFrequency();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FREQUENCY__OP = eINSTANCE.getFrequency_Op();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FREQUENCY__VALUE = eINSTANCE.getFrequency_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FREQUENCY__UNIT = eINSTANCE.getFrequency_Unit();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.UriImpl <em>Uri</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.UriImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getUri()
     * @generated
     */
    EClass URI = eINSTANCE.getUri();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute URI__VALUE = eINSTANCE.getUri_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.StringValueImpl <em>String Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.StringValueImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getStringValue()
     * @generated
     */
    EClass STRING_VALUE = eINSTANCE.getStringValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.HexColorImpl <em>Hex Color</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.HexColorImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getHexColor()
     * @generated
     */
    EClass HEX_COLOR = eINSTANCE.getHexColor();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HEX_COLOR__VALUE = eINSTANCE.getHexColor_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ClassImpl <em>Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.ClassImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getClass_()
     * @generated
     */
    EClass CLASS = eINSTANCE.getClass_();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS__CLASS = eINSTANCE.getClass_Class();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.AttributeImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.AttributeValueImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getAttributeValue()
     * @generated
     */
    EClass ATTRIBUTE_VALUE = eINSTANCE.getAttributeValue();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_VALUE__OPERATOR = eINSTANCE.getAttributeValue_Operator();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_VALUE__VALUE = eINSTANCE.getAttributeValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoImpl <em>Pseudo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getPseudo()
     * @generated
     */
    EClass PSEUDO = eINSTANCE.getPseudo();

    /**
     * The meta object literal for the '<em><b>Pseudo</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PSEUDO__PSEUDO = eINSTANCE.getPseudo_Pseudo();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PSEUDO__ARGS = eINSTANCE.getPseudo_Args();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.CSSIdImpl <em>CSS Id</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CSSIdImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getCSSId()
     * @generated
     */
    EClass CSS_ID = eINSTANCE.getCSSId();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CSS_ID__VALUE = eINSTANCE.getCSSId_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.UnaryOperatorImpl
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getUnaryOperator()
     * @generated
     */
    EClass UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_OPERATOR__OPERATOR = eINSTANCE.getUnaryOperator_Operator();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.UNARY <em>UNARY</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.UNARY
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getUNARY()
     * @generated
     */
    EEnum UNARY = eINSTANCE.getUNARY();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.KIND <em>KIND</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.KIND
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getKIND()
     * @generated
     */
    EEnum KIND = eINSTANCE.getKIND();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP <em>ATTRIBUTE OP</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP
     * @see org.eclipse.papyrus.infra.gmfdiag.css.impl.CssPackageImpl#getATTRIBUTE_OP()
     * @generated
     */
    EEnum ATTRIBUTE_OP = eINSTANCE.getATTRIBUTE_OP();

  }

} //CssPackage
