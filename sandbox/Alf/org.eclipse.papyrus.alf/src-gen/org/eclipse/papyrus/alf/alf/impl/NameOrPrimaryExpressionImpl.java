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
import org.eclipse.papyrus.alf.alf.NameOrPrimaryExpression;
import org.eclipse.papyrus.alf.alf.NameToPrimaryExpression;
import org.eclipse.papyrus.alf.alf.QualifiedNameWithoutBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Or Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameOrPrimaryExpressionImpl#getPotentiallyAmbiguousQualifiedName <em>Potentially Ambiguous Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameOrPrimaryExpressionImpl#getNameToPrimaryExpression <em>Name To Primary Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameOrPrimaryExpressionImpl extends MinimalEObjectImpl.Container implements NameOrPrimaryExpression
{
  /**
   * The cached value of the '{@link #getPotentiallyAmbiguousQualifiedName() <em>Potentially Ambiguous Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPotentiallyAmbiguousQualifiedName()
   * @generated
   * @ordered
   */
  protected QualifiedNameWithoutBinding potentiallyAmbiguousQualifiedName;

  /**
   * The cached value of the '{@link #getNameToPrimaryExpression() <em>Name To Primary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameToPrimaryExpression()
   * @generated
   * @ordered
   */
  protected NameToPrimaryExpression nameToPrimaryExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NameOrPrimaryExpressionImpl()
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
    return AlfPackage.eINSTANCE.getNameOrPrimaryExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameWithoutBinding getPotentiallyAmbiguousQualifiedName()
  {
    return potentiallyAmbiguousQualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPotentiallyAmbiguousQualifiedName(QualifiedNameWithoutBinding newPotentiallyAmbiguousQualifiedName, NotificationChain msgs)
  {
    QualifiedNameWithoutBinding oldPotentiallyAmbiguousQualifiedName = potentiallyAmbiguousQualifiedName;
    potentiallyAmbiguousQualifiedName = newPotentiallyAmbiguousQualifiedName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_OR_PRIMARY_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME, oldPotentiallyAmbiguousQualifiedName, newPotentiallyAmbiguousQualifiedName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPotentiallyAmbiguousQualifiedName(QualifiedNameWithoutBinding newPotentiallyAmbiguousQualifiedName)
  {
    if (newPotentiallyAmbiguousQualifiedName != potentiallyAmbiguousQualifiedName)
    {
      NotificationChain msgs = null;
      if (potentiallyAmbiguousQualifiedName != null)
        msgs = ((InternalEObject)potentiallyAmbiguousQualifiedName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_OR_PRIMARY_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME, null, msgs);
      if (newPotentiallyAmbiguousQualifiedName != null)
        msgs = ((InternalEObject)newPotentiallyAmbiguousQualifiedName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_OR_PRIMARY_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME, null, msgs);
      msgs = basicSetPotentiallyAmbiguousQualifiedName(newPotentiallyAmbiguousQualifiedName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_OR_PRIMARY_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME, newPotentiallyAmbiguousQualifiedName, newPotentiallyAmbiguousQualifiedName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameToPrimaryExpression getNameToPrimaryExpression()
  {
    return nameToPrimaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNameToPrimaryExpression(NameToPrimaryExpression newNameToPrimaryExpression, NotificationChain msgs)
  {
    NameToPrimaryExpression oldNameToPrimaryExpression = nameToPrimaryExpression;
    nameToPrimaryExpression = newNameToPrimaryExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_OR_PRIMARY_EXPRESSION__NAME_TO_PRIMARY_EXPRESSION, oldNameToPrimaryExpression, newNameToPrimaryExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameToPrimaryExpression(NameToPrimaryExpression newNameToPrimaryExpression)
  {
    if (newNameToPrimaryExpression != nameToPrimaryExpression)
    {
      NotificationChain msgs = null;
      if (nameToPrimaryExpression != null)
        msgs = ((InternalEObject)nameToPrimaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_OR_PRIMARY_EXPRESSION__NAME_TO_PRIMARY_EXPRESSION, null, msgs);
      if (newNameToPrimaryExpression != null)
        msgs = ((InternalEObject)newNameToPrimaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_OR_PRIMARY_EXPRESSION__NAME_TO_PRIMARY_EXPRESSION, null, msgs);
      msgs = basicSetNameToPrimaryExpression(newNameToPrimaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_OR_PRIMARY_EXPRESSION__NAME_TO_PRIMARY_EXPRESSION, newNameToPrimaryExpression, newNameToPrimaryExpression));
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
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        return basicSetPotentiallyAmbiguousQualifiedName(null, msgs);
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__NAME_TO_PRIMARY_EXPRESSION:
        return basicSetNameToPrimaryExpression(null, msgs);
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
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        return getPotentiallyAmbiguousQualifiedName();
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__NAME_TO_PRIMARY_EXPRESSION:
        return getNameToPrimaryExpression();
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
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        setPotentiallyAmbiguousQualifiedName((QualifiedNameWithoutBinding)newValue);
        return;
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__NAME_TO_PRIMARY_EXPRESSION:
        setNameToPrimaryExpression((NameToPrimaryExpression)newValue);
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
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        setPotentiallyAmbiguousQualifiedName((QualifiedNameWithoutBinding)null);
        return;
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__NAME_TO_PRIMARY_EXPRESSION:
        setNameToPrimaryExpression((NameToPrimaryExpression)null);
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
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        return potentiallyAmbiguousQualifiedName != null;
      case AlfPackage.NAME_OR_PRIMARY_EXPRESSION__NAME_TO_PRIMARY_EXPRESSION:
        return nameToPrimaryExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //NameOrPrimaryExpressionImpl
