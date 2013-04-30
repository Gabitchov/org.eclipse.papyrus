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
import org.eclipse.papyrus.alf.alf.AndExpression;
import org.eclipse.papyrus.alf.alf.AndExpressionCompletion;
import org.eclipse.papyrus.alf.alf.ExclusiveOrExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exclusive Or Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ExclusiveOrExpressionCompletionImpl#getAndExpressionCompletion <em>And Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ExclusiveOrExpressionCompletionImpl#getAndExpression <em>And Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExclusiveOrExpressionCompletionImpl extends MinimalEObjectImpl.Container implements ExclusiveOrExpressionCompletion
{
  /**
   * The cached value of the '{@link #getAndExpressionCompletion() <em>And Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndExpressionCompletion()
   * @generated
   * @ordered
   */
  protected AndExpressionCompletion andExpressionCompletion;

  /**
   * The cached value of the '{@link #getAndExpression() <em>And Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndExpression()
   * @generated
   * @ordered
   */
  protected EList<AndExpression> andExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExclusiveOrExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getExclusiveOrExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpressionCompletion getAndExpressionCompletion()
  {
    return andExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAndExpressionCompletion(AndExpressionCompletion newAndExpressionCompletion, NotificationChain msgs)
  {
    AndExpressionCompletion oldAndExpressionCompletion = andExpressionCompletion;
    andExpressionCompletion = newAndExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION_COMPLETION, oldAndExpressionCompletion, newAndExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAndExpressionCompletion(AndExpressionCompletion newAndExpressionCompletion)
  {
    if (newAndExpressionCompletion != andExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (andExpressionCompletion != null)
        msgs = ((InternalEObject)andExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION_COMPLETION, null, msgs);
      if (newAndExpressionCompletion != null)
        msgs = ((InternalEObject)newAndExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetAndExpressionCompletion(newAndExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION_COMPLETION, newAndExpressionCompletion, newAndExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AndExpression> getAndExpression()
  {
    if (andExpression == null)
    {
      andExpression = new EObjectContainmentEList<AndExpression>(AndExpression.class, this, AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION);
    }
    return andExpression;
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION_COMPLETION:
        return basicSetAndExpressionCompletion(null, msgs);
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION:
        return ((InternalEList<?>)getAndExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION_COMPLETION:
        return getAndExpressionCompletion();
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION:
        return getAndExpression();
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION_COMPLETION:
        setAndExpressionCompletion((AndExpressionCompletion)newValue);
        return;
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION:
        getAndExpression().clear();
        getAndExpression().addAll((Collection<? extends AndExpression>)newValue);
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION_COMPLETION:
        setAndExpressionCompletion((AndExpressionCompletion)null);
        return;
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION:
        getAndExpression().clear();
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION_COMPLETION:
        return andExpressionCompletion != null;
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION_COMPLETION__AND_EXPRESSION:
        return andExpression != null && !andExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExclusiveOrExpressionCompletionImpl
