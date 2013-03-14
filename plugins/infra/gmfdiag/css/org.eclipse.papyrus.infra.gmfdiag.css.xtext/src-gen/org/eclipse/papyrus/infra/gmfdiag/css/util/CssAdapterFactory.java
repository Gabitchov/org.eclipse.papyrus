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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage
 * @generated
 */
public class CssAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CssPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CssAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = CssPackage.eINSTANCE;
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
  protected CssSwitch<Adapter> modelSwitch =
    new CssSwitch<Adapter>()
    {
      @Override
      public Adapter caseStylesheet(Stylesheet object)
      {
        return createStylesheetAdapter();
      }
      @Override
      public Adapter caseContent(Content object)
      {
        return createContentAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseMedia(Media object)
      {
        return createMediaAdapter();
      }
      @Override
      public Adapter casePage(Page object)
      {
        return createPageAdapter();
      }
      @Override
      public Adapter casePseudoPage(PseudoPage object)
      {
        return createPseudoPageAdapter();
      }
      @Override
      public Adapter caseRuleset(Ruleset object)
      {
        return createRulesetAdapter();
      }
      @Override
      public Adapter caseSelector(Selector object)
      {
        return createSelectorAdapter();
      }
      @Override
      public Adapter caseCompositeSelector(CompositeSelector object)
      {
        return createCompositeSelectorAdapter();
      }
      @Override
      public Adapter caseSimpleSelector(SimpleSelector object)
      {
        return createSimpleSelectorAdapter();
      }
      @Override
      public Adapter caseSelectorCondition(SelectorCondition object)
      {
        return createSelectorConditionAdapter();
      }
      @Override
      public Adapter caseCombinator(Combinator object)
      {
        return createCombinatorAdapter();
      }
      @Override
      public Adapter caseDeclaration(Declaration object)
      {
        return createDeclarationAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseSubterm(Subterm object)
      {
        return createSubtermAdapter();
      }
      @Override
      public Adapter caseTerm(Term object)
      {
        return createTermAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter caseName(Name object)
      {
        return createNameAdapter();
      }
      @Override
      public Adapter caseNumber(org.eclipse.papyrus.infra.gmfdiag.css.Number object)
      {
        return createNumberAdapter();
      }
      @Override
      public Adapter casePercentage(Percentage object)
      {
        return createPercentageAdapter();
      }
      @Override
      public Adapter caseLength(Length object)
      {
        return createLengthAdapter();
      }
      @Override
      public Adapter caseEms(Ems object)
      {
        return createEmsAdapter();
      }
      @Override
      public Adapter caseExs(Exs object)
      {
        return createExsAdapter();
      }
      @Override
      public Adapter caseAngle(Angle object)
      {
        return createAngleAdapter();
      }
      @Override
      public Adapter caseTime(Time object)
      {
        return createTimeAdapter();
      }
      @Override
      public Adapter caseFrequency(Frequency object)
      {
        return createFrequencyAdapter();
      }
      @Override
      public Adapter caseUri(Uri object)
      {
        return createUriAdapter();
      }
      @Override
      public Adapter caseStringValue(StringValue object)
      {
        return createStringValueAdapter();
      }
      @Override
      public Adapter caseHexColor(HexColor object)
      {
        return createHexColorAdapter();
      }
      @Override
      public Adapter caseClass(org.eclipse.papyrus.infra.gmfdiag.css.Class object)
      {
        return createClassAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseAttributeValue(AttributeValue object)
      {
        return createAttributeValueAdapter();
      }
      @Override
      public Adapter casePseudo(Pseudo object)
      {
        return createPseudoAdapter();
      }
      @Override
      public Adapter caseCSSId(CSSId object)
      {
        return createCSSIdAdapter();
      }
      @Override
      public Adapter caseUnaryOperator(UnaryOperator object)
      {
        return createUnaryOperatorAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet <em>Stylesheet</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet
   * @generated
   */
  public Adapter createStylesheetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Content <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Content
   * @generated
   */
  public Adapter createContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Media <em>Media</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Media
   * @generated
   */
  public Adapter createMediaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Page <em>Page</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Page
   * @generated
   */
  public Adapter createPageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.PseudoPage <em>Pseudo Page</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.PseudoPage
   * @generated
   */
  public Adapter createPseudoPageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Ruleset <em>Ruleset</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Ruleset
   * @generated
   */
  public Adapter createRulesetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Selector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Selector
   * @generated
   */
  public Adapter createSelectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector <em>Composite Selector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector
   * @generated
   */
  public Adapter createCompositeSelectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector <em>Simple Selector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector
   * @generated
   */
  public Adapter createSimpleSelectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition <em>Selector Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition
   * @generated
   */
  public Adapter createSelectorConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Combinator <em>Combinator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Combinator
   * @generated
   */
  public Adapter createCombinatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Declaration
   * @generated
   */
  public Adapter createDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Subterm <em>Subterm</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Subterm
   * @generated
   */
  public Adapter createSubtermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Term
   * @generated
   */
  public Adapter createTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Name <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Name
   * @generated
   */
  public Adapter createNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Number <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Number
   * @generated
   */
  public Adapter createNumberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Percentage <em>Percentage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Percentage
   * @generated
   */
  public Adapter createPercentageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Length <em>Length</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Length
   * @generated
   */
  public Adapter createLengthAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Ems <em>Ems</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Ems
   * @generated
   */
  public Adapter createEmsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Exs <em>Exs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Exs
   * @generated
   */
  public Adapter createExsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Angle <em>Angle</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Angle
   * @generated
   */
  public Adapter createAngleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Time <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Time
   * @generated
   */
  public Adapter createTimeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency <em>Frequency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Frequency
   * @generated
   */
  public Adapter createFrequencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Uri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Uri
   * @generated
   */
  public Adapter createUriAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.StringValue
   * @generated
   */
  public Adapter createStringValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.HexColor <em>Hex Color</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.HexColor
   * @generated
   */
  public Adapter createHexColorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Class
   * @generated
   */
  public Adapter createClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue <em>Attribute Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue
   * @generated
   */
  public Adapter createAttributeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.Pseudo <em>Pseudo</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.Pseudo
   * @generated
   */
  public Adapter createPseudoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.CSSId <em>CSS Id</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CSSId
   * @generated
   */
  public Adapter createCSSIdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator
   * @generated
   */
  public Adapter createUnaryOperatorAdapter()
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

} //CssAdapterFactory
