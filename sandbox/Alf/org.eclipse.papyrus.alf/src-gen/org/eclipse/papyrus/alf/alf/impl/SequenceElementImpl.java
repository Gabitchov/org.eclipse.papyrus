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
import org.eclipse.papyrus.alf.alf.Expression;
import org.eclipse.papyrus.alf.alf.SequenceElement;
import org.eclipse.papyrus.alf.alf.SequenceInitializationExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceElementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceElementImpl#getSequenceInitializationExpression <em>Sequence Initialization Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceElementImpl extends MinimalEObjectImpl.Container implements SequenceElement
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getSequenceInitializationExpression() <em>Sequence Initialization Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceInitializationExpression()
   * @generated
   * @ordered
   */
  protected SequenceInitializationExpression sequenceInitializationExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequenceElementImpl()
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
    return AlfPackage.eINSTANCE.getSequenceElement();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENT__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENT__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceInitializationExpression getSequenceInitializationExpression()
  {
    return sequenceInitializationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceInitializationExpression(SequenceInitializationExpression newSequenceInitializationExpression, NotificationChain msgs)
  {
    SequenceInitializationExpression oldSequenceInitializationExpression = sequenceInitializationExpression;
    sequenceInitializationExpression = newSequenceInitializationExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENT__SEQUENCE_INITIALIZATION_EXPRESSION, oldSequenceInitializationExpression, newSequenceInitializationExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceInitializationExpression(SequenceInitializationExpression newSequenceInitializationExpression)
  {
    if (newSequenceInitializationExpression != sequenceInitializationExpression)
    {
      NotificationChain msgs = null;
      if (sequenceInitializationExpression != null)
        msgs = ((InternalEObject)sequenceInitializationExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENT__SEQUENCE_INITIALIZATION_EXPRESSION, null, msgs);
      if (newSequenceInitializationExpression != null)
        msgs = ((InternalEObject)newSequenceInitializationExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENT__SEQUENCE_INITIALIZATION_EXPRESSION, null, msgs);
      msgs = basicSetSequenceInitializationExpression(newSequenceInitializationExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENT__SEQUENCE_INITIALIZATION_EXPRESSION, newSequenceInitializationExpression, newSequenceInitializationExpression));
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
      case AlfPackage.SEQUENCE_ELEMENT__EXPRESSION:
        return basicSetExpression(null, msgs);
      case AlfPackage.SEQUENCE_ELEMENT__SEQUENCE_INITIALIZATION_EXPRESSION:
        return basicSetSequenceInitializationExpression(null, msgs);
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
      case AlfPackage.SEQUENCE_ELEMENT__EXPRESSION:
        return getExpression();
      case AlfPackage.SEQUENCE_ELEMENT__SEQUENCE_INITIALIZATION_EXPRESSION:
        return getSequenceInitializationExpression();
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
      case AlfPackage.SEQUENCE_ELEMENT__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case AlfPackage.SEQUENCE_ELEMENT__SEQUENCE_INITIALIZATION_EXPRESSION:
        setSequenceInitializationExpression((SequenceInitializationExpression)newValue);
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
      case AlfPackage.SEQUENCE_ELEMENT__EXPRESSION:
        setExpression((Expression)null);
        return;
      case AlfPackage.SEQUENCE_ELEMENT__SEQUENCE_INITIALIZATION_EXPRESSION:
        setSequenceInitializationExpression((SequenceInitializationExpression)null);
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
      case AlfPackage.SEQUENCE_ELEMENT__EXPRESSION:
        return expression != null;
      case AlfPackage.SEQUENCE_ELEMENT__SEQUENCE_INITIALIZATION_EXPRESSION:
        return sequenceInitializationExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //SequenceElementImpl
