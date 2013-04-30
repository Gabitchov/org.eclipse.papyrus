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
import org.eclipse.papyrus.alf.alf.NameToExpressionCompletion;
import org.eclipse.papyrus.alf.alf.NameToPrimaryExpression;
import org.eclipse.papyrus.alf.alf.PrimaryToExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name To Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameToExpressionCompletionImpl#getNameToPrimary <em>Name To Primary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameToExpressionCompletionImpl#getPrimaryToExpressionCompletion <em>Primary To Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameToExpressionCompletionImpl extends MinimalEObjectImpl.Container implements NameToExpressionCompletion
{
  /**
   * The cached value of the '{@link #getNameToPrimary() <em>Name To Primary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameToPrimary()
   * @generated
   * @ordered
   */
  protected NameToPrimaryExpression nameToPrimary;

  /**
   * The cached value of the '{@link #getPrimaryToExpressionCompletion() <em>Primary To Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimaryToExpressionCompletion()
   * @generated
   * @ordered
   */
  protected PrimaryToExpressionCompletion primaryToExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NameToExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getNameToExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameToPrimaryExpression getNameToPrimary()
  {
    return nameToPrimary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNameToPrimary(NameToPrimaryExpression newNameToPrimary, NotificationChain msgs)
  {
    NameToPrimaryExpression oldNameToPrimary = nameToPrimary;
    nameToPrimary = newNameToPrimary;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_EXPRESSION_COMPLETION__NAME_TO_PRIMARY, oldNameToPrimary, newNameToPrimary);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameToPrimary(NameToPrimaryExpression newNameToPrimary)
  {
    if (newNameToPrimary != nameToPrimary)
    {
      NotificationChain msgs = null;
      if (nameToPrimary != null)
        msgs = ((InternalEObject)nameToPrimary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_EXPRESSION_COMPLETION__NAME_TO_PRIMARY, null, msgs);
      if (newNameToPrimary != null)
        msgs = ((InternalEObject)newNameToPrimary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_EXPRESSION_COMPLETION__NAME_TO_PRIMARY, null, msgs);
      msgs = basicSetNameToPrimary(newNameToPrimary, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_EXPRESSION_COMPLETION__NAME_TO_PRIMARY, newNameToPrimary, newNameToPrimary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryToExpressionCompletion getPrimaryToExpressionCompletion()
  {
    return primaryToExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimaryToExpressionCompletion(PrimaryToExpressionCompletion newPrimaryToExpressionCompletion, NotificationChain msgs)
  {
    PrimaryToExpressionCompletion oldPrimaryToExpressionCompletion = primaryToExpressionCompletion;
    primaryToExpressionCompletion = newPrimaryToExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_EXPRESSION_COMPLETION__PRIMARY_TO_EXPRESSION_COMPLETION, oldPrimaryToExpressionCompletion, newPrimaryToExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimaryToExpressionCompletion(PrimaryToExpressionCompletion newPrimaryToExpressionCompletion)
  {
    if (newPrimaryToExpressionCompletion != primaryToExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (primaryToExpressionCompletion != null)
        msgs = ((InternalEObject)primaryToExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_EXPRESSION_COMPLETION__PRIMARY_TO_EXPRESSION_COMPLETION, null, msgs);
      if (newPrimaryToExpressionCompletion != null)
        msgs = ((InternalEObject)newPrimaryToExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_EXPRESSION_COMPLETION__PRIMARY_TO_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetPrimaryToExpressionCompletion(newPrimaryToExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_EXPRESSION_COMPLETION__PRIMARY_TO_EXPRESSION_COMPLETION, newPrimaryToExpressionCompletion, newPrimaryToExpressionCompletion));
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
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__NAME_TO_PRIMARY:
        return basicSetNameToPrimary(null, msgs);
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__PRIMARY_TO_EXPRESSION_COMPLETION:
        return basicSetPrimaryToExpressionCompletion(null, msgs);
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
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__NAME_TO_PRIMARY:
        return getNameToPrimary();
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__PRIMARY_TO_EXPRESSION_COMPLETION:
        return getPrimaryToExpressionCompletion();
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
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__NAME_TO_PRIMARY:
        setNameToPrimary((NameToPrimaryExpression)newValue);
        return;
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__PRIMARY_TO_EXPRESSION_COMPLETION:
        setPrimaryToExpressionCompletion((PrimaryToExpressionCompletion)newValue);
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
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__NAME_TO_PRIMARY:
        setNameToPrimary((NameToPrimaryExpression)null);
        return;
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__PRIMARY_TO_EXPRESSION_COMPLETION:
        setPrimaryToExpressionCompletion((PrimaryToExpressionCompletion)null);
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
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__NAME_TO_PRIMARY:
        return nameToPrimary != null;
      case AlfPackage.NAME_TO_EXPRESSION_COMPLETION__PRIMARY_TO_EXPRESSION_COMPLETION:
        return primaryToExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //NameToExpressionCompletionImpl
