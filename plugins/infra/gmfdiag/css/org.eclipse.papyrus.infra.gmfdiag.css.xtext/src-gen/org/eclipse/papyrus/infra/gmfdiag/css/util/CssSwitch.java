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
package org.eclipse.papyrus.infra.gmfdiag.css.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.gmfdiag.css.Angle;
import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSId;
import org.eclipse.papyrus.infra.gmfdiag.css.Combinator;
import org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector;
import org.eclipse.papyrus.infra.gmfdiag.css.Content;
import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.Ems;
import org.eclipse.papyrus.infra.gmfdiag.css.Expression;
import org.eclipse.papyrus.infra.gmfdiag.css.Exs;
import org.eclipse.papyrus.infra.gmfdiag.css.Frequency;
import org.eclipse.papyrus.infra.gmfdiag.css.Function;
import org.eclipse.papyrus.infra.gmfdiag.css.HexColor;
import org.eclipse.papyrus.infra.gmfdiag.css.Import;
import org.eclipse.papyrus.infra.gmfdiag.css.Length;
import org.eclipse.papyrus.infra.gmfdiag.css.Media;
import org.eclipse.papyrus.infra.gmfdiag.css.Name;
import org.eclipse.papyrus.infra.gmfdiag.css.Page;
import org.eclipse.papyrus.infra.gmfdiag.css.Percentage;
import org.eclipse.papyrus.infra.gmfdiag.css.Pseudo;
import org.eclipse.papyrus.infra.gmfdiag.css.PseudoPage;
import org.eclipse.papyrus.infra.gmfdiag.css.Ruleset;
import org.eclipse.papyrus.infra.gmfdiag.css.Selector;
import org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition;
import org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector;
import org.eclipse.papyrus.infra.gmfdiag.css.StringValue;
import org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.Subterm;
import org.eclipse.papyrus.infra.gmfdiag.css.Term;
import org.eclipse.papyrus.infra.gmfdiag.css.Time;
import org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator;
import org.eclipse.papyrus.infra.gmfdiag.css.Uri;

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
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage
 * @generated
 */
public class CssSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CssPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CssSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = CssPackage.eINSTANCE;
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
      case CssPackage.STYLESHEET:
      {
        Stylesheet stylesheet = (Stylesheet)theEObject;
        T result = caseStylesheet(stylesheet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.CONTENT:
      {
        Content content = (Content)theEObject;
        T result = caseContent(content);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.MEDIA:
      {
        Media media = (Media)theEObject;
        T result = caseMedia(media);
        if (result == null) result = caseContent(media);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.PAGE:
      {
        Page page = (Page)theEObject;
        T result = casePage(page);
        if (result == null) result = caseContent(page);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.PSEUDO_PAGE:
      {
        PseudoPage pseudoPage = (PseudoPage)theEObject;
        T result = casePseudoPage(pseudoPage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.RULESET:
      {
        Ruleset ruleset = (Ruleset)theEObject;
        T result = caseRuleset(ruleset);
        if (result == null) result = caseContent(ruleset);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.SELECTOR:
      {
        Selector selector = (Selector)theEObject;
        T result = caseSelector(selector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.COMPOSITE_SELECTOR:
      {
        CompositeSelector compositeSelector = (CompositeSelector)theEObject;
        T result = caseCompositeSelector(compositeSelector);
        if (result == null) result = caseSelector(compositeSelector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.SIMPLE_SELECTOR:
      {
        SimpleSelector simpleSelector = (SimpleSelector)theEObject;
        T result = caseSimpleSelector(simpleSelector);
        if (result == null) result = caseSelector(simpleSelector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.SELECTOR_CONDITION:
      {
        SelectorCondition selectorCondition = (SelectorCondition)theEObject;
        T result = caseSelectorCondition(selectorCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.COMBINATOR:
      {
        Combinator combinator = (Combinator)theEObject;
        T result = caseCombinator(combinator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.DECLARATION:
      {
        Declaration declaration = (Declaration)theEObject;
        T result = caseDeclaration(declaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.SUBTERM:
      {
        Subterm subterm = (Subterm)theEObject;
        T result = caseSubterm(subterm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.TERM:
      {
        Term term = (Term)theEObject;
        T result = caseTerm(term);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.FUNCTION:
      {
        Function function = (Function)theEObject;
        T result = caseFunction(function);
        if (result == null) result = caseTerm(function);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.NAME:
      {
        Name name = (Name)theEObject;
        T result = caseName(name);
        if (result == null) result = caseTerm(name);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.NUMBER:
      {
        org.eclipse.papyrus.infra.gmfdiag.css.Number number = (org.eclipse.papyrus.infra.gmfdiag.css.Number)theEObject;
        T result = caseNumber(number);
        if (result == null) result = caseTerm(number);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.PERCENTAGE:
      {
        Percentage percentage = (Percentage)theEObject;
        T result = casePercentage(percentage);
        if (result == null) result = caseTerm(percentage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.LENGTH:
      {
        Length length = (Length)theEObject;
        T result = caseLength(length);
        if (result == null) result = caseTerm(length);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.EMS:
      {
        Ems ems = (Ems)theEObject;
        T result = caseEms(ems);
        if (result == null) result = caseTerm(ems);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.EXS:
      {
        Exs exs = (Exs)theEObject;
        T result = caseExs(exs);
        if (result == null) result = caseTerm(exs);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.ANGLE:
      {
        Angle angle = (Angle)theEObject;
        T result = caseAngle(angle);
        if (result == null) result = caseTerm(angle);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.TIME:
      {
        Time time = (Time)theEObject;
        T result = caseTime(time);
        if (result == null) result = caseTerm(time);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.FREQUENCY:
      {
        Frequency frequency = (Frequency)theEObject;
        T result = caseFrequency(frequency);
        if (result == null) result = caseTerm(frequency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.URI:
      {
        Uri uri = (Uri)theEObject;
        T result = caseUri(uri);
        if (result == null) result = caseTerm(uri);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.STRING_VALUE:
      {
        StringValue stringValue = (StringValue)theEObject;
        T result = caseStringValue(stringValue);
        if (result == null) result = caseTerm(stringValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.HEX_COLOR:
      {
        HexColor hexColor = (HexColor)theEObject;
        T result = caseHexColor(hexColor);
        if (result == null) result = caseTerm(hexColor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.CLASS:
      {
        org.eclipse.papyrus.infra.gmfdiag.css.Class class_ = (org.eclipse.papyrus.infra.gmfdiag.css.Class)theEObject;
        T result = caseClass(class_);
        if (result == null) result = caseSelectorCondition(class_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = caseSelectorCondition(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.ATTRIBUTE_VALUE:
      {
        AttributeValue attributeValue = (AttributeValue)theEObject;
        T result = caseAttributeValue(attributeValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.PSEUDO:
      {
        Pseudo pseudo = (Pseudo)theEObject;
        T result = casePseudo(pseudo);
        if (result == null) result = caseSelectorCondition(pseudo);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.CSS_ID:
      {
        CSSId cssId = (CSSId)theEObject;
        T result = caseCSSId(cssId);
        if (result == null) result = caseSelectorCondition(cssId);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CssPackage.UNARY_OPERATOR:
      {
        UnaryOperator unaryOperator = (UnaryOperator)theEObject;
        T result = caseUnaryOperator(unaryOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stylesheet</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stylesheet</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStylesheet(Stylesheet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Content</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Content</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContent(Content object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Media</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Media</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMedia(Media object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Page</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Page</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePage(Page object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pseudo Page</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pseudo Page</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePseudoPage(PseudoPage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ruleset</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ruleset</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleset(Ruleset object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Selector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Selector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelector(Selector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Composite Selector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Composite Selector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompositeSelector(CompositeSelector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Selector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Selector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleSelector(SimpleSelector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Selector Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Selector Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectorCondition(SelectorCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Combinator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Combinator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCombinator(Combinator object)
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
  public T caseDeclaration(Declaration object)
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
   * Returns the result of interpreting the object as an instance of '<em>Subterm</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subterm</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubterm(Subterm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTerm(Term object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunction(Function object)
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
   * Returns the result of interpreting the object as an instance of '<em>Number</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumber(org.eclipse.papyrus.infra.gmfdiag.css.Number object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Percentage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Percentage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePercentage(Percentage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Length</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Length</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLength(Length object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ems</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ems</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEms(Ems object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExs(Exs object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Angle</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Angle</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAngle(Angle object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Time</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Time</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTime(Time object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Frequency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Frequency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFrequency(Frequency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Uri</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Uri</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUri(Uri object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringValue(StringValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hex Color</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hex Color</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHexColor(HexColor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClass(org.eclipse.papyrus.infra.gmfdiag.css.Class object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeValue(AttributeValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pseudo</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pseudo</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePseudo(Pseudo object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CSS Id</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CSS Id</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCSSId(CSSId object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryOperator(UnaryOperator object)
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

} //CssSwitch
