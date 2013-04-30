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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.ConditionalAndExpressionCompletion;
import org.eclipse.papyrus.alf.alf.InclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.InclusiveOrExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional And Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalAndExpressionCompletionImpl#getInclusiveOrExpressionCompletion <em>Inclusive Or Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalAndExpressionCompletionImpl#getInclusiveOrExpression <em>Inclusive Or Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalAndExpressionCompletionImpl extends MinimalEObjectImpl.Container implements ConditionalAndExpressionCompletion
{
  /**
   * The cached value of the '{@link #getInclusiveOrExpressionCompletion() <em>Inclusive Or Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInclusiveOrExpressionCompletion()
   * @generated
   * @ordered
   */
  protected InclusiveOrExpressionCompletion inclusiveOrExpressionCompletion;

  /**
   * The cached value of the '{@link #getInclusiveOrExpression() <em>Inclusive Or Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInclusiveOrExpression()
   * @generated
   * @ordered
   */
  protected EList<InclusiveOrExpression> inclusiveOrExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalAndExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getConditionalAndExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InclusiveOrExpressionCompletion getInclusiveOrExpressionCompletion()
  {
    return inclusiveOrExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion newInclusiveOrExpressionCompletion, NotificationChain msgs)
  {
    InclusiveOrExpressionCompletion oldInclusiveOrExpressionCompletion = inclusiveOrExpressionCompletion;
    inclusiveOrExpressionCompletion = newInclusiveOrExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION_COMPLETION, oldInclusiveOrExpressionCompletion, newInclusiveOrExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion newInclusiveOrExpressionCompletion)
  {
    if (newInclusiveOrExpressionCompletion != inclusiveOrExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (inclusiveOrExpressionCompletion != null)
        msgs = ((InternalEObject)inclusiveOrExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION_COMPLETION, null, msgs);
      if (newInclusiveOrExpressionCompletion != null)
        msgs = ((InternalEObject)newInclusiveOrExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetInclusiveOrExpressionCompletion(newInclusiveOrExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION_COMPLETION, newInclusiveOrExpressionCompletion, newInclusiveOrExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InclusiveOrExpression> getInclusiveOrExpression()
  {
    if (inclusiveOrExpression == null)
    {
      inclusiveOrExpression = new EObjectContainmentEList<InclusiveOrExpression>(InclusiveOrExpression.class, this, AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION);
    }
    return inclusiveOrExpression;
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        return basicSetInclusiveOrExpressionCompletion(null, msgs);
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION:
        return ((InternalEList<?>)getInclusiveOrExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        return getInclusiveOrExpressionCompletion();
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION:
        return getInclusiveOrExpression();
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        setInclusiveOrExpressionCompletion((InclusiveOrExpressionCompletion)newValue);
        return;
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION:
        getInclusiveOrExpression().clear();
        getInclusiveOrExpression().addAll((Collection<? extends InclusiveOrExpression>)newValue);
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        setInclusiveOrExpressionCompletion((InclusiveOrExpressionCompletion)null);
        return;
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION:
        getInclusiveOrExpression().clear();
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        return inclusiveOrExpressionCompletion != null;
      case AlfPackage.CONDITIONAL_AND_EXPRESSION_COMPLETION__INCLUSIVE_OR_EXPRESSION:
        return inclusiveOrExpression != null && !inclusiveOrExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConditionalAndExpressionCompletionImpl
