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
import org.eclipse.papyrus.alf.alf.ConditionalAndExpression;
import org.eclipse.papyrus.alf.alf.ConditionalAndExpressionCompletion;
import org.eclipse.papyrus.alf.alf.ConditionalOrExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Or Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalOrExpressionCompletionImpl#getConditionalAndExpressionCompletion <em>Conditional And Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalOrExpressionCompletionImpl#getConditionalAndExpression <em>Conditional And Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalOrExpressionCompletionImpl extends MinimalEObjectImpl.Container implements ConditionalOrExpressionCompletion
{
  /**
   * The cached value of the '{@link #getConditionalAndExpressionCompletion() <em>Conditional And Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionalAndExpressionCompletion()
   * @generated
   * @ordered
   */
  protected ConditionalAndExpressionCompletion conditionalAndExpressionCompletion;

  /**
   * The cached value of the '{@link #getConditionalAndExpression() <em>Conditional And Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionalAndExpression()
   * @generated
   * @ordered
   */
  protected EList<ConditionalAndExpression> conditionalAndExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalOrExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getConditionalOrExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalAndExpressionCompletion getConditionalAndExpressionCompletion()
  {
    return conditionalAndExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionalAndExpressionCompletion(ConditionalAndExpressionCompletion newConditionalAndExpressionCompletion, NotificationChain msgs)
  {
    ConditionalAndExpressionCompletion oldConditionalAndExpressionCompletion = conditionalAndExpressionCompletion;
    conditionalAndExpressionCompletion = newConditionalAndExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION_COMPLETION, oldConditionalAndExpressionCompletion, newConditionalAndExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionalAndExpressionCompletion(ConditionalAndExpressionCompletion newConditionalAndExpressionCompletion)
  {
    if (newConditionalAndExpressionCompletion != conditionalAndExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (conditionalAndExpressionCompletion != null)
        msgs = ((InternalEObject)conditionalAndExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION_COMPLETION, null, msgs);
      if (newConditionalAndExpressionCompletion != null)
        msgs = ((InternalEObject)newConditionalAndExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetConditionalAndExpressionCompletion(newConditionalAndExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION_COMPLETION, newConditionalAndExpressionCompletion, newConditionalAndExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConditionalAndExpression> getConditionalAndExpression()
  {
    if (conditionalAndExpression == null)
    {
      conditionalAndExpression = new EObjectContainmentEList<ConditionalAndExpression>(ConditionalAndExpression.class, this, AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION);
    }
    return conditionalAndExpression;
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        return basicSetConditionalAndExpressionCompletion(null, msgs);
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION:
        return ((InternalEList<?>)getConditionalAndExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        return getConditionalAndExpressionCompletion();
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION:
        return getConditionalAndExpression();
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        setConditionalAndExpressionCompletion((ConditionalAndExpressionCompletion)newValue);
        return;
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION:
        getConditionalAndExpression().clear();
        getConditionalAndExpression().addAll((Collection<? extends ConditionalAndExpression>)newValue);
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        setConditionalAndExpressionCompletion((ConditionalAndExpressionCompletion)null);
        return;
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION:
        getConditionalAndExpression().clear();
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        return conditionalAndExpressionCompletion != null;
      case AlfPackage.CONDITIONAL_OR_EXPRESSION_COMPLETION__CONDITIONAL_AND_EXPRESSION:
        return conditionalAndExpression != null && !conditionalAndExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConditionalOrExpressionCompletionImpl
