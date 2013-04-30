/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AdditiveExpressionCompletion;
import org.eclipse.papyrus.alf.alf.AdditiveOperator;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.MultiplicativeExpression;
import org.eclipse.papyrus.alf.alf.MultiplicativeExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Additive Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AdditiveExpressionCompletionImpl#getMultiplicativeExpressionCompletion <em>Multiplicative Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AdditiveExpressionCompletionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AdditiveExpressionCompletionImpl#getMultiplicativeExpression <em>Multiplicative Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdditiveExpressionCompletionImpl extends MinimalEObjectImpl.Container implements AdditiveExpressionCompletion
{
  /**
   * The cached value of the '{@link #getMultiplicativeExpressionCompletion() <em>Multiplicative Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicativeExpressionCompletion()
   * @generated
   * @ordered
   */
  protected MultiplicativeExpressionCompletion multiplicativeExpressionCompletion;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected EList<AdditiveOperator> operator;

  /**
   * The cached value of the '{@link #getMultiplicativeExpression() <em>Multiplicative Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicativeExpression()
   * @generated
   * @ordered
   */
  protected EList<MultiplicativeExpression> multiplicativeExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AdditiveExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getAdditiveExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpressionCompletion getMultiplicativeExpressionCompletion()
  {
    return multiplicativeExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicativeExpressionCompletion(MultiplicativeExpressionCompletion newMultiplicativeExpressionCompletion, NotificationChain msgs)
  {
    MultiplicativeExpressionCompletion oldMultiplicativeExpressionCompletion = multiplicativeExpressionCompletion;
    multiplicativeExpressionCompletion = newMultiplicativeExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION_COMPLETION, oldMultiplicativeExpressionCompletion, newMultiplicativeExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicativeExpressionCompletion(MultiplicativeExpressionCompletion newMultiplicativeExpressionCompletion)
  {
    if (newMultiplicativeExpressionCompletion != multiplicativeExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (multiplicativeExpressionCompletion != null)
        msgs = ((InternalEObject)multiplicativeExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION_COMPLETION, null, msgs);
      if (newMultiplicativeExpressionCompletion != null)
        msgs = ((InternalEObject)newMultiplicativeExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetMultiplicativeExpressionCompletion(newMultiplicativeExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION_COMPLETION, newMultiplicativeExpressionCompletion, newMultiplicativeExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AdditiveOperator> getOperator()
  {
    if (operator == null)
    {
      operator = new EDataTypeEList<AdditiveOperator>(AdditiveOperator.class, this, AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__OPERATOR);
    }
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MultiplicativeExpression> getMultiplicativeExpression()
  {
    if (multiplicativeExpression == null)
    {
      multiplicativeExpression = new EObjectContainmentEList<MultiplicativeExpression>(MultiplicativeExpression.class, this, AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION);
    }
    return multiplicativeExpression;
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
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        return basicSetMultiplicativeExpressionCompletion(null, msgs);
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION:
        return ((InternalEList<?>)getMultiplicativeExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        return getMultiplicativeExpressionCompletion();
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__OPERATOR:
        return getOperator();
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION:
        return getMultiplicativeExpression();
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
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        setMultiplicativeExpressionCompletion((MultiplicativeExpressionCompletion)newValue);
        return;
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__OPERATOR:
        getOperator().clear();
        getOperator().addAll((Collection<? extends AdditiveOperator>)newValue);
        return;
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION:
        getMultiplicativeExpression().clear();
        getMultiplicativeExpression().addAll((Collection<? extends MultiplicativeExpression>)newValue);
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
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        setMultiplicativeExpressionCompletion((MultiplicativeExpressionCompletion)null);
        return;
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__OPERATOR:
        getOperator().clear();
        return;
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION:
        getMultiplicativeExpression().clear();
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
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        return multiplicativeExpressionCompletion != null;
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__OPERATOR:
        return operator != null && !operator.isEmpty();
      case AlfPackage.ADDITIVE_EXPRESSION_COMPLETION__MULTIPLICATIVE_EXPRESSION:
        return multiplicativeExpression != null && !multiplicativeExpression.isEmpty();
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

} //AdditiveExpressionCompletionImpl
