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
import org.eclipse.papyrus.alf.alf.NamedTupleExpressionList;
import org.eclipse.papyrus.alf.alf.PositionalTupleExpressionList;
import org.eclipse.papyrus.alf.alf.Tuple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.TupleImpl#getNamedTupleExpressionList <em>Named Tuple Expression List</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.TupleImpl#getPositionalTupleExpressionList <em>Positional Tuple Expression List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleImpl extends MinimalEObjectImpl.Container implements Tuple
{
  /**
   * The cached value of the '{@link #getNamedTupleExpressionList() <em>Named Tuple Expression List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedTupleExpressionList()
   * @generated
   * @ordered
   */
  protected NamedTupleExpressionList namedTupleExpressionList;

  /**
   * The cached value of the '{@link #getPositionalTupleExpressionList() <em>Positional Tuple Expression List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPositionalTupleExpressionList()
   * @generated
   * @ordered
   */
  protected PositionalTupleExpressionList positionalTupleExpressionList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TupleImpl()
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
    return AlfPackage.eINSTANCE.getTuple();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedTupleExpressionList getNamedTupleExpressionList()
  {
    return namedTupleExpressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNamedTupleExpressionList(NamedTupleExpressionList newNamedTupleExpressionList, NotificationChain msgs)
  {
    NamedTupleExpressionList oldNamedTupleExpressionList = namedTupleExpressionList;
    namedTupleExpressionList = newNamedTupleExpressionList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.TUPLE__NAMED_TUPLE_EXPRESSION_LIST, oldNamedTupleExpressionList, newNamedTupleExpressionList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamedTupleExpressionList(NamedTupleExpressionList newNamedTupleExpressionList)
  {
    if (newNamedTupleExpressionList != namedTupleExpressionList)
    {
      NotificationChain msgs = null;
      if (namedTupleExpressionList != null)
        msgs = ((InternalEObject)namedTupleExpressionList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.TUPLE__NAMED_TUPLE_EXPRESSION_LIST, null, msgs);
      if (newNamedTupleExpressionList != null)
        msgs = ((InternalEObject)newNamedTupleExpressionList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.TUPLE__NAMED_TUPLE_EXPRESSION_LIST, null, msgs);
      msgs = basicSetNamedTupleExpressionList(newNamedTupleExpressionList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.TUPLE__NAMED_TUPLE_EXPRESSION_LIST, newNamedTupleExpressionList, newNamedTupleExpressionList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PositionalTupleExpressionList getPositionalTupleExpressionList()
  {
    return positionalTupleExpressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPositionalTupleExpressionList(PositionalTupleExpressionList newPositionalTupleExpressionList, NotificationChain msgs)
  {
    PositionalTupleExpressionList oldPositionalTupleExpressionList = positionalTupleExpressionList;
    positionalTupleExpressionList = newPositionalTupleExpressionList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST, oldPositionalTupleExpressionList, newPositionalTupleExpressionList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPositionalTupleExpressionList(PositionalTupleExpressionList newPositionalTupleExpressionList)
  {
    if (newPositionalTupleExpressionList != positionalTupleExpressionList)
    {
      NotificationChain msgs = null;
      if (positionalTupleExpressionList != null)
        msgs = ((InternalEObject)positionalTupleExpressionList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST, null, msgs);
      if (newPositionalTupleExpressionList != null)
        msgs = ((InternalEObject)newPositionalTupleExpressionList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST, null, msgs);
      msgs = basicSetPositionalTupleExpressionList(newPositionalTupleExpressionList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST, newPositionalTupleExpressionList, newPositionalTupleExpressionList));
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
      case AlfPackage.TUPLE__NAMED_TUPLE_EXPRESSION_LIST:
        return basicSetNamedTupleExpressionList(null, msgs);
      case AlfPackage.TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        return basicSetPositionalTupleExpressionList(null, msgs);
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
      case AlfPackage.TUPLE__NAMED_TUPLE_EXPRESSION_LIST:
        return getNamedTupleExpressionList();
      case AlfPackage.TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        return getPositionalTupleExpressionList();
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
      case AlfPackage.TUPLE__NAMED_TUPLE_EXPRESSION_LIST:
        setNamedTupleExpressionList((NamedTupleExpressionList)newValue);
        return;
      case AlfPackage.TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        setPositionalTupleExpressionList((PositionalTupleExpressionList)newValue);
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
      case AlfPackage.TUPLE__NAMED_TUPLE_EXPRESSION_LIST:
        setNamedTupleExpressionList((NamedTupleExpressionList)null);
        return;
      case AlfPackage.TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        setPositionalTupleExpressionList((PositionalTupleExpressionList)null);
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
      case AlfPackage.TUPLE__NAMED_TUPLE_EXPRESSION_LIST:
        return namedTupleExpressionList != null;
      case AlfPackage.TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        return positionalTupleExpressionList != null;
    }
    return super.eIsSet(featureID);
  }

} //TupleImpl
