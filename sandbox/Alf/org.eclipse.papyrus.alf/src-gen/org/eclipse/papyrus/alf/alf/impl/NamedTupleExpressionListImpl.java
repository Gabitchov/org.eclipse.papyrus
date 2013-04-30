/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.NamedExpression;
import org.eclipse.papyrus.alf.alf.NamedTupleExpressionList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Tuple Expression List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NamedTupleExpressionListImpl#getNamedExpression <em>Named Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedTupleExpressionListImpl extends MinimalEObjectImpl.Container implements NamedTupleExpressionList
{
  /**
   * The cached value of the '{@link #getNamedExpression() <em>Named Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedExpression()
   * @generated
   * @ordered
   */
  protected EList<NamedExpression> namedExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedTupleExpressionListImpl()
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
    return AlfPackage.eINSTANCE.getNamedTupleExpressionList();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NamedExpression> getNamedExpression()
  {
    if (namedExpression == null)
    {
      namedExpression = new EObjectContainmentEList<NamedExpression>(NamedExpression.class, this, AlfPackage.NAMED_TUPLE_EXPRESSION_LIST__NAMED_EXPRESSION);
    }
    return namedExpression;
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
      case AlfPackage.NAMED_TUPLE_EXPRESSION_LIST__NAMED_EXPRESSION:
        return ((InternalEList<?>)getNamedExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.NAMED_TUPLE_EXPRESSION_LIST__NAMED_EXPRESSION:
        return getNamedExpression();
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
      case AlfPackage.NAMED_TUPLE_EXPRESSION_LIST__NAMED_EXPRESSION:
        getNamedExpression().clear();
        getNamedExpression().addAll((Collection<? extends NamedExpression>)newValue);
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
      case AlfPackage.NAMED_TUPLE_EXPRESSION_LIST__NAMED_EXPRESSION:
        getNamedExpression().clear();
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
      case AlfPackage.NAMED_TUPLE_EXPRESSION_LIST__NAMED_EXPRESSION:
        return namedExpression != null && !namedExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //NamedTupleExpressionListImpl
