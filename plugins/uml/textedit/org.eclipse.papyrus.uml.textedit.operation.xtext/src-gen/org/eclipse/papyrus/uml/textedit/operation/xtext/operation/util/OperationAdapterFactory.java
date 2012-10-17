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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage
 * @generated
 */
public class OperationAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static OperationPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = OperationPackage.eINSTANCE;
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
  protected OperationSwitch<Adapter> modelSwitch =
    new OperationSwitch<Adapter>()
    {
      @Override
      public Adapter caseOperationDefinitionOrStub(OperationDefinitionOrStub object)
      {
        return createOperationDefinitionOrStubAdapter();
      }
      @Override
      public Adapter caseOperationDeclaration(OperationDeclaration object)
      {
        return createOperationDeclarationAdapter();
      }
      @Override
      public Adapter caseFormalParameters(FormalParameters object)
      {
        return createFormalParametersAdapter();
      }
      @Override
      public Adapter caseFormalParameterList(FormalParameterList object)
      {
        return createFormalParameterListAdapter();
      }
      @Override
      public Adapter caseFormalParameter(FormalParameter object)
      {
        return createFormalParameterAdapter();
      }
      @Override
      public Adapter caseTypePart(TypePart object)
      {
        return createTypePartAdapter();
      }
      @Override
      public Adapter caseMultiplicity(Multiplicity object)
      {
        return createMultiplicityAdapter();
      }
      @Override
      public Adapter caseMultiplicityRange(MultiplicityRange object)
      {
        return createMultiplicityRangeAdapter();
      }
      @Override
      public Adapter caseNUMBER_LITERAL_WITHOUT_SUFFIX(NUMBER_LITERAL_WITHOUT_SUFFIX object)
      {
        return createNUMBER_LITERAL_WITHOUT_SUFFIXAdapter();
      }
      @Override
      public Adapter caseINTEGER_LITERAL_WITHOUT_SUFFIX(INTEGER_LITERAL_WITHOUT_SUFFIX object)
      {
        return createINTEGER_LITERAL_WITHOUT_SUFFIXAdapter();
      }
      @Override
      public Adapter caseUNLIMITED_LITERAL_WITHOUT_SUFFIX(UNLIMITED_LITERAL_WITHOUT_SUFFIX object)
      {
        return createUNLIMITED_LITERAL_WITHOUT_SUFFIXAdapter();
      }
      @Override
      public Adapter caseTypeName(TypeName object)
      {
        return createTypeNameAdapter();
      }
      @Override
      public Adapter caseRedefinitionClause(RedefinitionClause object)
      {
        return createRedefinitionClauseAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub <em>Definition Or Stub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub
   * @generated
   */
  public Adapter createOperationDefinitionOrStubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration
   * @generated
   */
  public Adapter createOperationDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters <em>Formal Parameters</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters
   * @generated
   */
  public Adapter createFormalParametersAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList <em>Formal Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList
   * @generated
   */
  public Adapter createFormalParameterListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter
   * @generated
   */
  public Adapter createFormalParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart <em>Type Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart
   * @generated
   */
  public Adapter createTypePartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity
   * @generated
   */
  public Adapter createMultiplicityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange <em>Multiplicity Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange
   * @generated
   */
  public Adapter createMultiplicityRangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.NUMBER_LITERAL_WITHOUT_SUFFIX <em>NUMBER LITERAL WITHOUT SUFFIX</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.NUMBER_LITERAL_WITHOUT_SUFFIX
   * @generated
   */
  public Adapter createNUMBER_LITERAL_WITHOUT_SUFFIXAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.INTEGER_LITERAL_WITHOUT_SUFFIX <em>INTEGER LITERAL WITHOUT SUFFIX</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.INTEGER_LITERAL_WITHOUT_SUFFIX
   * @generated
   */
  public Adapter createINTEGER_LITERAL_WITHOUT_SUFFIXAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.UNLIMITED_LITERAL_WITHOUT_SUFFIX <em>UNLIMITED LITERAL WITHOUT SUFFIX</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.UNLIMITED_LITERAL_WITHOUT_SUFFIX
   * @generated
   */
  public Adapter createUNLIMITED_LITERAL_WITHOUT_SUFFIXAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypeName
   * @generated
   */
  public Adapter createTypeNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause <em>Redefinition Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause
   * @generated
   */
  public Adapter createRedefinitionClauseAdapter()
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

} //OperationAdapterFactory
