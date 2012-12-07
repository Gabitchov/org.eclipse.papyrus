/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP;
import org.eclipse.papyrus.infra.gmfdiag.css.Angle;
import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSId;
import org.eclipse.papyrus.infra.gmfdiag.css.Combinator;
import org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector;
import org.eclipse.papyrus.infra.gmfdiag.css.Content;
import org.eclipse.papyrus.infra.gmfdiag.css.CssFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.Ems;
import org.eclipse.papyrus.infra.gmfdiag.css.Expression;
import org.eclipse.papyrus.infra.gmfdiag.css.Exs;
import org.eclipse.papyrus.infra.gmfdiag.css.Frequency;
import org.eclipse.papyrus.infra.gmfdiag.css.Function;
import org.eclipse.papyrus.infra.gmfdiag.css.HexColor;
import org.eclipse.papyrus.infra.gmfdiag.css.Import;
import org.eclipse.papyrus.infra.gmfdiag.css.KIND;
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
import org.eclipse.papyrus.infra.gmfdiag.css.UNARY;
import org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator;
import org.eclipse.papyrus.infra.gmfdiag.css.Uri;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CssFactoryImpl extends EFactoryImpl implements CssFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CssFactory init()
  {
    try
    {
      CssFactory theCssFactory = (CssFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/infra/gmfdiag/CSS"); 
      if (theCssFactory != null)
      {
        return theCssFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CssFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CssFactoryImpl()
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
      case CssPackage.STYLESHEET: return createStylesheet();
      case CssPackage.CONTENT: return createContent();
      case CssPackage.IMPORT: return createImport();
      case CssPackage.MEDIA: return createMedia();
      case CssPackage.PAGE: return createPage();
      case CssPackage.PSEUDO_PAGE: return createPseudoPage();
      case CssPackage.RULESET: return createRuleset();
      case CssPackage.SELECTOR: return createSelector();
      case CssPackage.COMPOSITE_SELECTOR: return createCompositeSelector();
      case CssPackage.SIMPLE_SELECTOR: return createSimpleSelector();
      case CssPackage.SELECTOR_CONDITION: return createSelectorCondition();
      case CssPackage.COMBINATOR: return createCombinator();
      case CssPackage.DECLARATION: return createDeclaration();
      case CssPackage.EXPRESSION: return createExpression();
      case CssPackage.SUBTERM: return createSubterm();
      case CssPackage.TERM: return createTerm();
      case CssPackage.FUNCTION: return createFunction();
      case CssPackage.NAME: return createName();
      case CssPackage.NUMBER: return createNumber();
      case CssPackage.PERCENTAGE: return createPercentage();
      case CssPackage.LENGTH: return createLength();
      case CssPackage.EMS: return createEms();
      case CssPackage.EXS: return createExs();
      case CssPackage.ANGLE: return createAngle();
      case CssPackage.TIME: return createTime();
      case CssPackage.FREQUENCY: return createFrequency();
      case CssPackage.URI: return createUri();
      case CssPackage.STRING_VALUE: return createStringValue();
      case CssPackage.HEX_COLOR: return createHexColor();
      case CssPackage.CLASS: return createClass();
      case CssPackage.ATTRIBUTE: return createAttribute();
      case CssPackage.ATTRIBUTE_VALUE: return createAttributeValue();
      case CssPackage.PSEUDO: return createPseudo();
      case CssPackage.CSS_ID: return createCSSId();
      case CssPackage.UNARY_OPERATOR: return createUnaryOperator();
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
      case CssPackage.UNARY:
        return createUNARYFromString(eDataType, initialValue);
      case CssPackage.KIND:
        return createKINDFromString(eDataType, initialValue);
      case CssPackage.ATTRIBUTE_OP:
        return createATTRIBUTE_OPFromString(eDataType, initialValue);
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
      case CssPackage.UNARY:
        return convertUNARYToString(eDataType, instanceValue);
      case CssPackage.KIND:
        return convertKINDToString(eDataType, instanceValue);
      case CssPackage.ATTRIBUTE_OP:
        return convertATTRIBUTE_OPToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stylesheet createStylesheet()
  {
    StylesheetImpl stylesheet = new StylesheetImpl();
    return stylesheet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Content createContent()
  {
    ContentImpl content = new ContentImpl();
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Media createMedia()
  {
    MediaImpl media = new MediaImpl();
    return media;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Page createPage()
  {
    PageImpl page = new PageImpl();
    return page;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PseudoPage createPseudoPage()
  {
    PseudoPageImpl pseudoPage = new PseudoPageImpl();
    return pseudoPage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ruleset createRuleset()
  {
    RulesetImpl ruleset = new RulesetImpl();
    return ruleset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Selector createSelector()
  {
    SelectorImpl selector = new SelectorImpl();
    return selector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompositeSelector createCompositeSelector()
  {
    CompositeSelectorImpl compositeSelector = new CompositeSelectorImpl();
    return compositeSelector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleSelector createSimpleSelector()
  {
    SimpleSelectorImpl simpleSelector = new SimpleSelectorImpl();
    return simpleSelector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelectorCondition createSelectorCondition()
  {
    SelectorConditionImpl selectorCondition = new SelectorConditionImpl();
    return selectorCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combinator createCombinator()
  {
    CombinatorImpl combinator = new CombinatorImpl();
    return combinator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declaration createDeclaration()
  {
    DeclarationImpl declaration = new DeclarationImpl();
    return declaration;
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
  public Subterm createSubterm()
  {
    SubtermImpl subterm = new SubtermImpl();
    return subterm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Term createTerm()
  {
    TermImpl term = new TermImpl();
    return term;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
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
  public org.eclipse.papyrus.infra.gmfdiag.css.Number createNumber()
  {
    NumberImpl number = new NumberImpl();
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Percentage createPercentage()
  {
    PercentageImpl percentage = new PercentageImpl();
    return percentage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Length createLength()
  {
    LengthImpl length = new LengthImpl();
    return length;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ems createEms()
  {
    EmsImpl ems = new EmsImpl();
    return ems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exs createExs()
  {
    ExsImpl exs = new ExsImpl();
    return exs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Angle createAngle()
  {
    AngleImpl angle = new AngleImpl();
    return angle;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Time createTime()
  {
    TimeImpl time = new TimeImpl();
    return time;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Frequency createFrequency()
  {
    FrequencyImpl frequency = new FrequencyImpl();
    return frequency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Uri createUri()
  {
    UriImpl uri = new UriImpl();
    return uri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringValue createStringValue()
  {
    StringValueImpl stringValue = new StringValueImpl();
    return stringValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HexColor createHexColor()
  {
    HexColorImpl hexColor = new HexColorImpl();
    return hexColor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.papyrus.infra.gmfdiag.css.Class createClass()
  {
    ClassImpl class_ = new ClassImpl();
    return class_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeValue createAttributeValue()
  {
    AttributeValueImpl attributeValue = new AttributeValueImpl();
    return attributeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pseudo createPseudo()
  {
    PseudoImpl pseudo = new PseudoImpl();
    return pseudo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CSSId createCSSId()
  {
    CSSIdImpl cssId = new CSSIdImpl();
    return cssId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOperator createUnaryOperator()
  {
    UnaryOperatorImpl unaryOperator = new UnaryOperatorImpl();
    return unaryOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UNARY createUNARYFromString(EDataType eDataType, String initialValue)
  {
    UNARY result = UNARY.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUNARYToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KIND createKINDFromString(EDataType eDataType, String initialValue)
  {
    KIND result = KIND.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertKINDToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ATTRIBUTE_OP createATTRIBUTE_OPFromString(EDataType eDataType, String initialValue)
  {
    ATTRIBUTE_OP result = ATTRIBUTE_OP.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertATTRIBUTE_OPToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CssPackage getCssPackage()
  {
    return (CssPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CssPackage getPackage()
  {
    return CssPackage.eINSTANCE;
  }

} //CssFactoryImpl
