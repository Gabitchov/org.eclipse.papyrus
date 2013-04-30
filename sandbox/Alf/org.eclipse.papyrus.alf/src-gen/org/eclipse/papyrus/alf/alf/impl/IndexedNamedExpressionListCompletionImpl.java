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
import org.eclipse.papyrus.alf.alf.Expression;
import org.eclipse.papyrus.alf.alf.IndexedNamedExpression;
import org.eclipse.papyrus.alf.alf.IndexedNamedExpressionListCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indexed Named Expression List Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.IndexedNamedExpressionListCompletionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.IndexedNamedExpressionListCompletionImpl#getIndexedNamedExpression <em>Indexed Named Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexedNamedExpressionListCompletionImpl extends MinimalEObjectImpl.Container implements IndexedNamedExpressionListCompletion
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
   * The cached value of the '{@link #getIndexedNamedExpression() <em>Indexed Named Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndexedNamedExpression()
   * @generated
   * @ordered
   */
  protected EList<IndexedNamedExpression> indexedNamedExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IndexedNamedExpressionListCompletionImpl()
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
    return AlfPackage.eINSTANCE.getIndexedNamedExpressionListCompletion();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__EXPRESSION, oldExpression, newExpression);
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
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IndexedNamedExpression> getIndexedNamedExpression()
  {
    if (indexedNamedExpression == null)
    {
      indexedNamedExpression = new EObjectContainmentEList<IndexedNamedExpression>(IndexedNamedExpression.class, this, AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__INDEXED_NAMED_EXPRESSION);
    }
    return indexedNamedExpression;
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
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__EXPRESSION:
        return basicSetExpression(null, msgs);
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__INDEXED_NAMED_EXPRESSION:
        return ((InternalEList<?>)getIndexedNamedExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__EXPRESSION:
        return getExpression();
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__INDEXED_NAMED_EXPRESSION:
        return getIndexedNamedExpression();
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
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__INDEXED_NAMED_EXPRESSION:
        getIndexedNamedExpression().clear();
        getIndexedNamedExpression().addAll((Collection<? extends IndexedNamedExpression>)newValue);
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
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__EXPRESSION:
        setExpression((Expression)null);
        return;
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__INDEXED_NAMED_EXPRESSION:
        getIndexedNamedExpression().clear();
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
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__EXPRESSION:
        return expression != null;
      case AlfPackage.INDEXED_NAMED_EXPRESSION_LIST_COMPLETION__INDEXED_NAMED_EXPRESSION:
        return indexedNamedExpression != null && !indexedNamedExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IndexedNamedExpressionListCompletionImpl
