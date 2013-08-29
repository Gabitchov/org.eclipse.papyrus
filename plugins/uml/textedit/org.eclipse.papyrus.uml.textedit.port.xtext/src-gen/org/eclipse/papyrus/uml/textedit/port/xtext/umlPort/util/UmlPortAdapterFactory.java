/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage
 * @generated
 */
public class UmlPortAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UmlPortPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlPortAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = UmlPortPackage.eINSTANCE;
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
  protected UmlPortSwitch<Adapter> modelSwitch =
    new UmlPortSwitch<Adapter>()
    {
      @Override
      public Adapter casePortRule(PortRule object)
      {
        return createPortRuleAdapter();
      }
      @Override
      public Adapter caseTypeRule(TypeRule object)
      {
        return createTypeRuleAdapter();
      }
      @Override
      public Adapter caseQualifiedName(QualifiedName object)
      {
        return createQualifiedNameAdapter();
      }
      @Override
      public Adapter caseMultiplicityRule(MultiplicityRule object)
      {
        return createMultiplicityRuleAdapter();
      }
      @Override
      public Adapter caseBoundSpecification(BoundSpecification object)
      {
        return createBoundSpecificationAdapter();
      }
      @Override
      public Adapter caseModifiersRule(ModifiersRule object)
      {
        return createModifiersRuleAdapter();
      }
      @Override
      public Adapter caseModifierSpecification(ModifierSpecification object)
      {
        return createModifierSpecificationAdapter();
      }
      @Override
      public Adapter caseRedefinesRule(RedefinesRule object)
      {
        return createRedefinesRuleAdapter();
      }
      @Override
      public Adapter caseSubsetsRule(SubsetsRule object)
      {
        return createSubsetsRuleAdapter();
      }
      @Override
      public Adapter caseDefaultValueRule(DefaultValueRule object)
      {
        return createDefaultValueRuleAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule <em>Port Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule
   * @generated
   */
  public Adapter createPortRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule <em>Type Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule
   * @generated
   */
  public Adapter createTypeRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName
   * @generated
   */
  public Adapter createQualifiedNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule <em>Multiplicity Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule
   * @generated
   */
  public Adapter createMultiplicityRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification <em>Bound Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification
   * @generated
   */
  public Adapter createBoundSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule <em>Modifiers Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule
   * @generated
   */
  public Adapter createModifiersRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification <em>Modifier Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification
   * @generated
   */
  public Adapter createModifierSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule <em>Redefines Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule
   * @generated
   */
  public Adapter createRedefinesRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule <em>Subsets Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule
   * @generated
   */
  public Adapter createSubsetsRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule <em>Default Value Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule
   * @generated
   */
  public Adapter createDefaultValueRuleAdapter()
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

} //UmlPortAdapterFactory
