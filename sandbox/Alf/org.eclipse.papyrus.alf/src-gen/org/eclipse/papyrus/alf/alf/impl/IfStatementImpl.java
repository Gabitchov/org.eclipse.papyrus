/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.FinalClause;
import org.eclipse.papyrus.alf.alf.IfStatement;
import org.eclipse.papyrus.alf.alf.SequentialClauses;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.IfStatementImpl#getSequentialClauses <em>Sequential Clauses</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.IfStatementImpl#getFinalClause <em>Final Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfStatementImpl extends StatementImpl implements IfStatement
{
  /**
   * The cached value of the '{@link #getSequentialClauses() <em>Sequential Clauses</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequentialClauses()
   * @generated
   * @ordered
   */
  protected SequentialClauses sequentialClauses;

  /**
   * The cached value of the '{@link #getFinalClause() <em>Final Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFinalClause()
   * @generated
   * @ordered
   */
  protected FinalClause finalClause;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementImpl()
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
    return AlfPackage.eINSTANCE.getIfStatement();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequentialClauses getSequentialClauses()
  {
    return sequentialClauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequentialClauses(SequentialClauses newSequentialClauses, NotificationChain msgs)
  {
    SequentialClauses oldSequentialClauses = sequentialClauses;
    sequentialClauses = newSequentialClauses;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.IF_STATEMENT__SEQUENTIAL_CLAUSES, oldSequentialClauses, newSequentialClauses);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequentialClauses(SequentialClauses newSequentialClauses)
  {
    if (newSequentialClauses != sequentialClauses)
    {
      NotificationChain msgs = null;
      if (sequentialClauses != null)
        msgs = ((InternalEObject)sequentialClauses).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IF_STATEMENT__SEQUENTIAL_CLAUSES, null, msgs);
      if (newSequentialClauses != null)
        msgs = ((InternalEObject)newSequentialClauses).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IF_STATEMENT__SEQUENTIAL_CLAUSES, null, msgs);
      msgs = basicSetSequentialClauses(newSequentialClauses, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.IF_STATEMENT__SEQUENTIAL_CLAUSES, newSequentialClauses, newSequentialClauses));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FinalClause getFinalClause()
  {
    return finalClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFinalClause(FinalClause newFinalClause, NotificationChain msgs)
  {
    FinalClause oldFinalClause = finalClause;
    finalClause = newFinalClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.IF_STATEMENT__FINAL_CLAUSE, oldFinalClause, newFinalClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinalClause(FinalClause newFinalClause)
  {
    if (newFinalClause != finalClause)
    {
      NotificationChain msgs = null;
      if (finalClause != null)
        msgs = ((InternalEObject)finalClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IF_STATEMENT__FINAL_CLAUSE, null, msgs);
      if (newFinalClause != null)
        msgs = ((InternalEObject)newFinalClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IF_STATEMENT__FINAL_CLAUSE, null, msgs);
      msgs = basicSetFinalClause(newFinalClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.IF_STATEMENT__FINAL_CLAUSE, newFinalClause, newFinalClause));
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
      case AlfPackage.IF_STATEMENT__SEQUENTIAL_CLAUSES:
        return basicSetSequentialClauses(null, msgs);
      case AlfPackage.IF_STATEMENT__FINAL_CLAUSE:
        return basicSetFinalClause(null, msgs);
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
      case AlfPackage.IF_STATEMENT__SEQUENTIAL_CLAUSES:
        return getSequentialClauses();
      case AlfPackage.IF_STATEMENT__FINAL_CLAUSE:
        return getFinalClause();
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
      case AlfPackage.IF_STATEMENT__SEQUENTIAL_CLAUSES:
        setSequentialClauses((SequentialClauses)newValue);
        return;
      case AlfPackage.IF_STATEMENT__FINAL_CLAUSE:
        setFinalClause((FinalClause)newValue);
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
      case AlfPackage.IF_STATEMENT__SEQUENTIAL_CLAUSES:
        setSequentialClauses((SequentialClauses)null);
        return;
      case AlfPackage.IF_STATEMENT__FINAL_CLAUSE:
        setFinalClause((FinalClause)null);
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
      case AlfPackage.IF_STATEMENT__SEQUENTIAL_CLAUSES:
        return sequentialClauses != null;
      case AlfPackage.IF_STATEMENT__FINAL_CLAUSE:
        return finalClause != null;
    }
    return super.eIsSet(featureID);
  }

} //IfStatementImpl
