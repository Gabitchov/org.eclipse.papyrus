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

import org.eclipse.papyrus.alf.alf.AdditiveExpression;
import org.eclipse.papyrus.alf.alf.AdditiveExpressionCompletion;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.ShiftExpressionCompletion;
import org.eclipse.papyrus.alf.alf.ShiftOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shift Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ShiftExpressionCompletionImpl#getAdditiveExpressionCompletion <em>Additive Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ShiftExpressionCompletionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ShiftExpressionCompletionImpl#getAdditiveExpression <em>Additive Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ShiftExpressionCompletionImpl extends MinimalEObjectImpl.Container implements ShiftExpressionCompletion
{
  /**
   * The cached value of the '{@link #getAdditiveExpressionCompletion() <em>Additive Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditiveExpressionCompletion()
   * @generated
   * @ordered
   */
  protected AdditiveExpressionCompletion additiveExpressionCompletion;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected EList<ShiftOperator> operator;

  /**
   * The cached value of the '{@link #getAdditiveExpression() <em>Additive Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditiveExpression()
   * @generated
   * @ordered
   */
  protected EList<AdditiveExpression> additiveExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ShiftExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getShiftExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpressionCompletion getAdditiveExpressionCompletion()
  {
    return additiveExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAdditiveExpressionCompletion(AdditiveExpressionCompletion newAdditiveExpressionCompletion, NotificationChain msgs)
  {
    AdditiveExpressionCompletion oldAdditiveExpressionCompletion = additiveExpressionCompletion;
    additiveExpressionCompletion = newAdditiveExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION_COMPLETION, oldAdditiveExpressionCompletion, newAdditiveExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdditiveExpressionCompletion(AdditiveExpressionCompletion newAdditiveExpressionCompletion)
  {
    if (newAdditiveExpressionCompletion != additiveExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (additiveExpressionCompletion != null)
        msgs = ((InternalEObject)additiveExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION_COMPLETION, null, msgs);
      if (newAdditiveExpressionCompletion != null)
        msgs = ((InternalEObject)newAdditiveExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetAdditiveExpressionCompletion(newAdditiveExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION_COMPLETION, newAdditiveExpressionCompletion, newAdditiveExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ShiftOperator> getOperator()
  {
    if (operator == null)
    {
      operator = new EDataTypeEList<ShiftOperator>(ShiftOperator.class, this, AlfPackage.SHIFT_EXPRESSION_COMPLETION__OPERATOR);
    }
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AdditiveExpression> getAdditiveExpression()
  {
    if (additiveExpression == null)
    {
      additiveExpression = new EObjectContainmentEList<AdditiveExpression>(AdditiveExpression.class, this, AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION);
    }
    return additiveExpression;
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
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION_COMPLETION:
        return basicSetAdditiveExpressionCompletion(null, msgs);
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION:
        return ((InternalEList<?>)getAdditiveExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION_COMPLETION:
        return getAdditiveExpressionCompletion();
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__OPERATOR:
        return getOperator();
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION:
        return getAdditiveExpression();
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
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION_COMPLETION:
        setAdditiveExpressionCompletion((AdditiveExpressionCompletion)newValue);
        return;
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__OPERATOR:
        getOperator().clear();
        getOperator().addAll((Collection<? extends ShiftOperator>)newValue);
        return;
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION:
        getAdditiveExpression().clear();
        getAdditiveExpression().addAll((Collection<? extends AdditiveExpression>)newValue);
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
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION_COMPLETION:
        setAdditiveExpressionCompletion((AdditiveExpressionCompletion)null);
        return;
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__OPERATOR:
        getOperator().clear();
        return;
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION:
        getAdditiveExpression().clear();
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
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION_COMPLETION:
        return additiveExpressionCompletion != null;
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__OPERATOR:
        return operator != null && !operator.isEmpty();
      case AlfPackage.SHIFT_EXPRESSION_COMPLETION__ADDITIVE_EXPRESSION:
        return additiveExpression != null && !additiveExpression.isEmpty();
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

} //ShiftExpressionCompletionImpl
