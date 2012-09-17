/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterFactory;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlParameterFactoryImpl extends EFactoryImpl implements UmlParameterFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UmlParameterFactory init()
  {
    try
    {
      UmlParameterFactory theUmlParameterFactory = (UmlParameterFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/uml/textedit/parameter/xtext/UmlParameter"); 
      if (theUmlParameterFactory != null)
      {
        return theUmlParameterFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UmlParameterFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlParameterFactoryImpl()
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
      case UmlParameterPackage.PARAMETER_RULE: return createParameterRule();
      case UmlParameterPackage.MODIFIERS_RULE: return createModifiersRule();
      case UmlParameterPackage.MODIFIER_SPECIFICATION: return createModifierSpecification();
      case UmlParameterPackage.EFFECT_RULE: return createEffectRule();
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
      case UmlParameterPackage.MODIFIER_KIND:
        return createModifierKindFromString(eDataType, initialValue);
      case UmlParameterPackage.EFFECT_KIND:
        return createEffectKindFromString(eDataType, initialValue);
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
      case UmlParameterPackage.MODIFIER_KIND:
        return convertModifierKindToString(eDataType, instanceValue);
      case UmlParameterPackage.EFFECT_KIND:
        return convertEffectKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterRule createParameterRule()
  {
    ParameterRuleImpl parameterRule = new ParameterRuleImpl();
    return parameterRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModifiersRule createModifiersRule()
  {
    ModifiersRuleImpl modifiersRule = new ModifiersRuleImpl();
    return modifiersRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModifierSpecification createModifierSpecification()
  {
    ModifierSpecificationImpl modifierSpecification = new ModifierSpecificationImpl();
    return modifierSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EffectRule createEffectRule()
  {
    EffectRuleImpl effectRule = new EffectRuleImpl();
    return effectRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModifierKind createModifierKindFromString(EDataType eDataType, String initialValue)
  {
    ModifierKind result = ModifierKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertModifierKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EffectKind createEffectKindFromString(EDataType eDataType, String initialValue)
  {
    EffectKind result = EffectKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEffectKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlParameterPackage getUmlParameterPackage()
  {
    return (UmlParameterPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UmlParameterPackage getPackage()
  {
    return UmlParameterPackage.eINSTANCE;
  }

} //UmlParameterFactoryImpl
