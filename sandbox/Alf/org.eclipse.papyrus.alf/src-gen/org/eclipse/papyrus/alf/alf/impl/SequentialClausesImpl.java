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
import org.eclipse.papyrus.alf.alf.ConcurrentClauses;
import org.eclipse.papyrus.alf.alf.SequentialClauses;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequential Clauses</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequentialClausesImpl#getConcurrentClauses <em>Concurrent Clauses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequentialClausesImpl extends MinimalEObjectImpl.Container implements SequentialClauses
{
  /**
   * The cached value of the '{@link #getConcurrentClauses() <em>Concurrent Clauses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConcurrentClauses()
   * @generated
   * @ordered
   */
  protected EList<ConcurrentClauses> concurrentClauses;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequentialClausesImpl()
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
    return AlfPackage.eINSTANCE.getSequentialClauses();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConcurrentClauses> getConcurrentClauses()
  {
    if (concurrentClauses == null)
    {
      concurrentClauses = new EObjectContainmentEList<ConcurrentClauses>(ConcurrentClauses.class, this, AlfPackage.SEQUENTIAL_CLAUSES__CONCURRENT_CLAUSES);
    }
    return concurrentClauses;
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCURRENT_CLAUSES:
        return ((InternalEList<?>)getConcurrentClauses()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCURRENT_CLAUSES:
        return getConcurrentClauses();
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCURRENT_CLAUSES:
        getConcurrentClauses().clear();
        getConcurrentClauses().addAll((Collection<? extends ConcurrentClauses>)newValue);
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCURRENT_CLAUSES:
        getConcurrentClauses().clear();
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCURRENT_CLAUSES:
        return concurrentClauses != null && !concurrentClauses.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SequentialClausesImpl
