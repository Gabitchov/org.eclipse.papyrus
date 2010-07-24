/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.property.editor.xtext.umlProperty.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.property.editor.xtext.umlProperty.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlPropertyFactoryImpl extends EFactoryImpl implements UmlPropertyFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UmlPropertyFactory init()
  {
    try
    {
      UmlPropertyFactory theUmlPropertyFactory = (UmlPropertyFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/property/editor/xtext/UmlProperty"); 
      if (theUmlPropertyFactory != null)
      {
        return theUmlPropertyFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UmlPropertyFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlPropertyFactoryImpl()
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
      case UmlPropertyPackage.PROPERTY_RULE: return createPropertyRule();
      case UmlPropertyPackage.MULTIPLICITY_RULE: return createMultiplicityRule();
      case UmlPropertyPackage.BOUND_SPECIFICATION: return createBoundSpecification();
      case UmlPropertyPackage.MODIFIERS_RULE: return createModifiersRule();
      case UmlPropertyPackage.MODIFIER_SPECIFICATION: return createModifierSpecification();
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
      case UmlPropertyPackage.VISIBILITY_KIND:
        return createVisibilityKindFromString(eDataType, initialValue);
      case UmlPropertyPackage.MODIFIER_KIND:
        return createModifierKindFromString(eDataType, initialValue);
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
      case UmlPropertyPackage.VISIBILITY_KIND:
        return convertVisibilityKindToString(eDataType, instanceValue);
      case UmlPropertyPackage.MODIFIER_KIND:
        return convertModifierKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyRule createPropertyRule()
  {
    PropertyRuleImpl propertyRule = new PropertyRuleImpl();
    return propertyRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityRule createMultiplicityRule()
  {
    MultiplicityRuleImpl multiplicityRule = new MultiplicityRuleImpl();
    return multiplicityRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoundSpecification createBoundSpecification()
  {
    BoundSpecificationImpl boundSpecification = new BoundSpecificationImpl();
    return boundSpecification;
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
  public VisibilityKind createVisibilityKindFromString(EDataType eDataType, String initialValue)
  {
    VisibilityKind result = VisibilityKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVisibilityKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
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
  public UmlPropertyPackage getUmlPropertyPackage()
  {
    return (UmlPropertyPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UmlPropertyPackage getPackage()
  {
    return UmlPropertyPackage.eINSTANCE;
  }

} //UmlPropertyFactoryImpl
