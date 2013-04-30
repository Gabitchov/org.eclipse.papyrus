/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.QualifiedName;
import org.eclipse.papyrus.alf.alf.SuperInvocationExpression;
import org.eclipse.papyrus.alf.alf.Tuple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Super Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SuperInvocationExpressionImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SuperInvocationExpressionImpl#getTuple <em>Tuple</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuperInvocationExpressionImpl extends BaseExpressionImpl implements SuperInvocationExpression
{
  /**
   * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedName()
   * @generated
   * @ordered
   */
  protected QualifiedName qualifiedName;

  /**
   * The cached value of the '{@link #getTuple() <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTuple()
   * @generated
   * @ordered
   */
  protected Tuple tuple;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SuperInvocationExpressionImpl()
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
    return AlfPackage.eINSTANCE.getSuperInvocationExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getQualifiedName()
  {
    return qualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifiedName(QualifiedName newQualifiedName, NotificationChain msgs)
  {
    QualifiedName oldQualifiedName = qualifiedName;
    qualifiedName = newQualifiedName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SUPER_INVOCATION_EXPRESSION__QUALIFIED_NAME, oldQualifiedName, newQualifiedName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualifiedName(QualifiedName newQualifiedName)
  {
    if (newQualifiedName != qualifiedName)
    {
      NotificationChain msgs = null;
      if (qualifiedName != null)
        msgs = ((InternalEObject)qualifiedName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SUPER_INVOCATION_EXPRESSION__QUALIFIED_NAME, null, msgs);
      if (newQualifiedName != null)
        msgs = ((InternalEObject)newQualifiedName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SUPER_INVOCATION_EXPRESSION__QUALIFIED_NAME, null, msgs);
      msgs = basicSetQualifiedName(newQualifiedName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SUPER_INVOCATION_EXPRESSION__QUALIFIED_NAME, newQualifiedName, newQualifiedName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tuple getTuple()
  {
    return tuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTuple(Tuple newTuple, NotificationChain msgs)
  {
    Tuple oldTuple = tuple;
    tuple = newTuple;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SUPER_INVOCATION_EXPRESSION__TUPLE, oldTuple, newTuple);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTuple(Tuple newTuple)
  {
    if (newTuple != tuple)
    {
      NotificationChain msgs = null;
      if (tuple != null)
        msgs = ((InternalEObject)tuple).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SUPER_INVOCATION_EXPRESSION__TUPLE, null, msgs);
      if (newTuple != null)
        msgs = ((InternalEObject)newTuple).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SUPER_INVOCATION_EXPRESSION__TUPLE, null, msgs);
      msgs = basicSetTuple(newTuple, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SUPER_INVOCATION_EXPRESSION__TUPLE, newTuple, newTuple));
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__QUALIFIED_NAME:
        return basicSetQualifiedName(null, msgs);
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__TUPLE:
        return basicSetTuple(null, msgs);
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__QUALIFIED_NAME:
        return getQualifiedName();
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__TUPLE:
        return getTuple();
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__QUALIFIED_NAME:
        setQualifiedName((QualifiedName)newValue);
        return;
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__TUPLE:
        setTuple((Tuple)newValue);
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__QUALIFIED_NAME:
        setQualifiedName((QualifiedName)null);
        return;
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__TUPLE:
        setTuple((Tuple)null);
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__QUALIFIED_NAME:
        return qualifiedName != null;
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__TUPLE:
        return tuple != null;
    }
    return super.eIsSet(featureID);
  }

} //SuperInvocationExpressionImpl
