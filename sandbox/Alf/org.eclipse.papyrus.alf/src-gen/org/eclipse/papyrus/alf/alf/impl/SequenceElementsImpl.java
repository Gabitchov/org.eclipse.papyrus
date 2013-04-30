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
import org.eclipse.papyrus.alf.alf.SequenceElementListCompletion;
import org.eclipse.papyrus.alf.alf.SequenceElements;
import org.eclipse.papyrus.alf.alf.SequenceInitializationExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceElementsImpl#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceElementsImpl#getExpression2 <em>Expression2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceElementsImpl#getSequenceElementListCompletion <em>Sequence Element List Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceElementsImpl#getSequenceInitializationExpression <em>Sequence Initialization Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceElementsImpl extends MinimalEObjectImpl.Container implements SequenceElements
{
  /**
   * The cached value of the '{@link #getExpression1() <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression1()
   * @generated
   * @ordered
   */
  protected Expression expression1;

  /**
   * The cached value of the '{@link #getExpression2() <em>Expression2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression2()
   * @generated
   * @ordered
   */
  protected Expression expression2;

  /**
   * The cached value of the '{@link #getSequenceElementListCompletion() <em>Sequence Element List Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceElementListCompletion()
   * @generated
   * @ordered
   */
  protected SequenceElementListCompletion sequenceElementListCompletion;

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
  protected SequenceElementsImpl()
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
    return AlfPackage.eINSTANCE.getSequenceElements();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression1()
  {
    return expression1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression1(Expression newExpression1, NotificationChain msgs)
  {
    Expression oldExpression1 = expression1;
    expression1 = newExpression1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION1, oldExpression1, newExpression1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression1(Expression newExpression1)
  {
    if (newExpression1 != expression1)
    {
      NotificationChain msgs = null;
      if (expression1 != null)
        msgs = ((InternalEObject)expression1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION1, null, msgs);
      if (newExpression1 != null)
        msgs = ((InternalEObject)newExpression1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION1, null, msgs);
      msgs = basicSetExpression1(newExpression1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION1, newExpression1, newExpression1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression2()
  {
    return expression2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression2(Expression newExpression2, NotificationChain msgs)
  {
    Expression oldExpression2 = expression2;
    expression2 = newExpression2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION2, oldExpression2, newExpression2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression2(Expression newExpression2)
  {
    if (newExpression2 != expression2)
    {
      NotificationChain msgs = null;
      if (expression2 != null)
        msgs = ((InternalEObject)expression2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION2, null, msgs);
      if (newExpression2 != null)
        msgs = ((InternalEObject)newExpression2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION2, null, msgs);
      msgs = basicSetExpression2(newExpression2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION2, newExpression2, newExpression2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceElementListCompletion getSequenceElementListCompletion()
  {
    return sequenceElementListCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceElementListCompletion(SequenceElementListCompletion newSequenceElementListCompletion, NotificationChain msgs)
  {
    SequenceElementListCompletion oldSequenceElementListCompletion = sequenceElementListCompletion;
    sequenceElementListCompletion = newSequenceElementListCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_ELEMENT_LIST_COMPLETION, oldSequenceElementListCompletion, newSequenceElementListCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceElementListCompletion(SequenceElementListCompletion newSequenceElementListCompletion)
  {
    if (newSequenceElementListCompletion != sequenceElementListCompletion)
    {
      NotificationChain msgs = null;
      if (sequenceElementListCompletion != null)
        msgs = ((InternalEObject)sequenceElementListCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_ELEMENT_LIST_COMPLETION, null, msgs);
      if (newSequenceElementListCompletion != null)
        msgs = ((InternalEObject)newSequenceElementListCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_ELEMENT_LIST_COMPLETION, null, msgs);
      msgs = basicSetSequenceElementListCompletion(newSequenceElementListCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_ELEMENT_LIST_COMPLETION, newSequenceElementListCompletion, newSequenceElementListCompletion));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_INITIALIZATION_EXPRESSION, oldSequenceInitializationExpression, newSequenceInitializationExpression);
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
        msgs = ((InternalEObject)sequenceInitializationExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_INITIALIZATION_EXPRESSION, null, msgs);
      if (newSequenceInitializationExpression != null)
        msgs = ((InternalEObject)newSequenceInitializationExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_INITIALIZATION_EXPRESSION, null, msgs);
      msgs = basicSetSequenceInitializationExpression(newSequenceInitializationExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_INITIALIZATION_EXPRESSION, newSequenceInitializationExpression, newSequenceInitializationExpression));
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
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION1:
        return basicSetExpression1(null, msgs);
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION2:
        return basicSetExpression2(null, msgs);
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_ELEMENT_LIST_COMPLETION:
        return basicSetSequenceElementListCompletion(null, msgs);
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_INITIALIZATION_EXPRESSION:
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
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION1:
        return getExpression1();
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION2:
        return getExpression2();
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_ELEMENT_LIST_COMPLETION:
        return getSequenceElementListCompletion();
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_INITIALIZATION_EXPRESSION:
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
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION1:
        setExpression1((Expression)newValue);
        return;
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION2:
        setExpression2((Expression)newValue);
        return;
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_ELEMENT_LIST_COMPLETION:
        setSequenceElementListCompletion((SequenceElementListCompletion)newValue);
        return;
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_INITIALIZATION_EXPRESSION:
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
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION1:
        setExpression1((Expression)null);
        return;
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION2:
        setExpression2((Expression)null);
        return;
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_ELEMENT_LIST_COMPLETION:
        setSequenceElementListCompletion((SequenceElementListCompletion)null);
        return;
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_INITIALIZATION_EXPRESSION:
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
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION1:
        return expression1 != null;
      case AlfPackage.SEQUENCE_ELEMENTS__EXPRESSION2:
        return expression2 != null;
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_ELEMENT_LIST_COMPLETION:
        return sequenceElementListCompletion != null;
      case AlfPackage.SEQUENCE_ELEMENTS__SEQUENCE_INITIALIZATION_EXPRESSION:
        return sequenceInitializationExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //SequenceElementsImpl
