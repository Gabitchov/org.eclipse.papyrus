/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion;
import org.eclipse.papyrus.alf.alf.PostfixOperation;
import org.eclipse.papyrus.alf.alf.PrimaryExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postfix Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PostfixExpressionCompletionImpl#getPrimaryExpressionCompletion <em>Primary Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PostfixExpressionCompletionImpl#getPostfixOperation <em>Postfix Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostfixExpressionCompletionImpl extends MinimalEObjectImpl.Container implements PostfixExpressionCompletion
{
  /**
   * The cached value of the '{@link #getPrimaryExpressionCompletion() <em>Primary Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimaryExpressionCompletion()
   * @generated
   * @ordered
   */
  protected PrimaryExpressionCompletion primaryExpressionCompletion;

  /**
   * The cached value of the '{@link #getPostfixOperation() <em>Postfix Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostfixOperation()
   * @generated
   * @ordered
   */
  protected PostfixOperation postfixOperation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PostfixExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getPostfixExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpressionCompletion getPrimaryExpressionCompletion()
  {
    return primaryExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimaryExpressionCompletion(PrimaryExpressionCompletion newPrimaryExpressionCompletion, NotificationChain msgs)
  {
    PrimaryExpressionCompletion oldPrimaryExpressionCompletion = primaryExpressionCompletion;
    primaryExpressionCompletion = newPrimaryExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_EXPRESSION_COMPLETION__PRIMARY_EXPRESSION_COMPLETION, oldPrimaryExpressionCompletion, newPrimaryExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimaryExpressionCompletion(PrimaryExpressionCompletion newPrimaryExpressionCompletion)
  {
    if (newPrimaryExpressionCompletion != primaryExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (primaryExpressionCompletion != null)
        msgs = ((InternalEObject)primaryExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_EXPRESSION_COMPLETION__PRIMARY_EXPRESSION_COMPLETION, null, msgs);
      if (newPrimaryExpressionCompletion != null)
        msgs = ((InternalEObject)newPrimaryExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_EXPRESSION_COMPLETION__PRIMARY_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetPrimaryExpressionCompletion(newPrimaryExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_EXPRESSION_COMPLETION__PRIMARY_EXPRESSION_COMPLETION, newPrimaryExpressionCompletion, newPrimaryExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixOperation getPostfixOperation()
  {
    return postfixOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPostfixOperation(PostfixOperation newPostfixOperation, NotificationChain msgs)
  {
    PostfixOperation oldPostfixOperation = postfixOperation;
    postfixOperation = newPostfixOperation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_EXPRESSION_COMPLETION__POSTFIX_OPERATION, oldPostfixOperation, newPostfixOperation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostfixOperation(PostfixOperation newPostfixOperation)
  {
    if (newPostfixOperation != postfixOperation)
    {
      NotificationChain msgs = null;
      if (postfixOperation != null)
        msgs = ((InternalEObject)postfixOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_EXPRESSION_COMPLETION__POSTFIX_OPERATION, null, msgs);
      if (newPostfixOperation != null)
        msgs = ((InternalEObject)newPostfixOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_EXPRESSION_COMPLETION__POSTFIX_OPERATION, null, msgs);
      msgs = basicSetPostfixOperation(newPostfixOperation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_EXPRESSION_COMPLETION__POSTFIX_OPERATION, newPostfixOperation, newPostfixOperation));
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
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__PRIMARY_EXPRESSION_COMPLETION:
        return basicSetPrimaryExpressionCompletion(null, msgs);
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__POSTFIX_OPERATION:
        return basicSetPostfixOperation(null, msgs);
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
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__PRIMARY_EXPRESSION_COMPLETION:
        return getPrimaryExpressionCompletion();
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__POSTFIX_OPERATION:
        return getPostfixOperation();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__PRIMARY_EXPRESSION_COMPLETION:
        setPrimaryExpressionCompletion((PrimaryExpressionCompletion)newValue);
        return;
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__POSTFIX_OPERATION:
        setPostfixOperation((PostfixOperation)newValue);
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
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__PRIMARY_EXPRESSION_COMPLETION:
        setPrimaryExpressionCompletion((PrimaryExpressionCompletion)null);
        return;
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__POSTFIX_OPERATION:
        setPostfixOperation((PostfixOperation)null);
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
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__PRIMARY_EXPRESSION_COMPLETION:
        return primaryExpressionCompletion != null;
      case AlfPackage.POSTFIX_EXPRESSION_COMPLETION__POSTFIX_OPERATION:
        return postfixOperation != null;
    }
    return super.eIsSet(featureID);
  }

} //PostfixExpressionCompletionImpl
