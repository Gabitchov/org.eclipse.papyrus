/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.MultiplicativeExpressionCompletion;
import org.eclipse.papyrus.alf.alf.MultiplicativeOperator;
import org.eclipse.papyrus.alf.alf.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicative Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.MultiplicativeExpressionCompletionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.MultiplicativeExpressionCompletionImpl#getUnaryExpression <em>Unary Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicativeExpressionCompletionImpl extends MinimalEObjectImpl.Container implements MultiplicativeExpressionCompletion
{
  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected EList<MultiplicativeOperator> operator;

  /**
   * The cached value of the '{@link #getUnaryExpression() <em>Unary Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnaryExpression()
   * @generated
   * @ordered
   */
  protected EList<UnaryExpression> unaryExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultiplicativeExpressionCompletionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AlfPackage.eINSTANCE.getMultiplicativeExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MultiplicativeOperator> getOperator()
  {
    if (operator == null)
    {
      operator = new EDataTypeEList<MultiplicativeOperator>(MultiplicativeOperator.class, this, AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__OPERATOR);
    }
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UnaryExpression> getUnaryExpression()
  {
    if (unaryExpression == null)
    {
      unaryExpression = new EObjectContainmentEList<UnaryExpression>(UnaryExpression.class, this, AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__UNARY_EXPRESSION);
    }
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__UNARY_EXPRESSION:
        return ((InternalEList<?>)getUnaryExpression()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__OPERATOR:
        return getOperator();
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__UNARY_EXPRESSION:
        return getUnaryExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__OPERATOR:
        getOperator().clear();
        getOperator().addAll((Collection<? extends MultiplicativeOperator>)newValue);
        return;
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__UNARY_EXPRESSION:
        getUnaryExpression().clear();
        getUnaryExpression().addAll((Collection<? extends UnaryExpression>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__OPERATOR:
        getOperator().clear();
        return;
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__UNARY_EXPRESSION:
        getUnaryExpression().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__OPERATOR:
        return operator != null && !operator.isEmpty();
      case AlfPackage.MULTIPLICATIVE_EXPRESSION_COMPLETION__UNARY_EXPRESSION:
        return unaryExpression != null && !unaryExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //MultiplicativeExpressionCompletionImpl
