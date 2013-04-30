/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AcceptClause;
import org.eclipse.papyrus.alf.alf.AcceptStatement;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.CompoundAcceptStatementCompletion;
import org.eclipse.papyrus.alf.alf.SimpleAcceptStatementCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accept Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AcceptStatementImpl#getAcceptClause <em>Accept Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AcceptStatementImpl#getSimpleCompletion <em>Simple Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AcceptStatementImpl#getCompoundCompletion <em>Compound Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AcceptStatementImpl extends StatementImpl implements AcceptStatement
{
  /**
   * The cached value of the '{@link #getAcceptClause() <em>Accept Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAcceptClause()
   * @generated
   * @ordered
   */
  protected AcceptClause acceptClause;

  /**
   * The cached value of the '{@link #getSimpleCompletion() <em>Simple Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSimpleCompletion()
   * @generated
   * @ordered
   */
  protected SimpleAcceptStatementCompletion simpleCompletion;

  /**
   * The cached value of the '{@link #getCompoundCompletion() <em>Compound Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompoundCompletion()
   * @generated
   * @ordered
   */
  protected CompoundAcceptStatementCompletion compoundCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AcceptStatementImpl()
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
    return AlfPackage.eINSTANCE.getAcceptStatement();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AcceptClause getAcceptClause()
  {
    return acceptClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAcceptClause(AcceptClause newAcceptClause, NotificationChain msgs)
  {
    AcceptClause oldAcceptClause = acceptClause;
    acceptClause = newAcceptClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_STATEMENT__ACCEPT_CLAUSE, oldAcceptClause, newAcceptClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAcceptClause(AcceptClause newAcceptClause)
  {
    if (newAcceptClause != acceptClause)
    {
      NotificationChain msgs = null;
      if (acceptClause != null)
        msgs = ((InternalEObject)acceptClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_STATEMENT__ACCEPT_CLAUSE, null, msgs);
      if (newAcceptClause != null)
        msgs = ((InternalEObject)newAcceptClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_STATEMENT__ACCEPT_CLAUSE, null, msgs);
      msgs = basicSetAcceptClause(newAcceptClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_STATEMENT__ACCEPT_CLAUSE, newAcceptClause, newAcceptClause));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAcceptStatementCompletion getSimpleCompletion()
  {
    return simpleCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSimpleCompletion(SimpleAcceptStatementCompletion newSimpleCompletion, NotificationChain msgs)
  {
    SimpleAcceptStatementCompletion oldSimpleCompletion = simpleCompletion;
    simpleCompletion = newSimpleCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_STATEMENT__SIMPLE_COMPLETION, oldSimpleCompletion, newSimpleCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSimpleCompletion(SimpleAcceptStatementCompletion newSimpleCompletion)
  {
    if (newSimpleCompletion != simpleCompletion)
    {
      NotificationChain msgs = null;
      if (simpleCompletion != null)
        msgs = ((InternalEObject)simpleCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_STATEMENT__SIMPLE_COMPLETION, null, msgs);
      if (newSimpleCompletion != null)
        msgs = ((InternalEObject)newSimpleCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_STATEMENT__SIMPLE_COMPLETION, null, msgs);
      msgs = basicSetSimpleCompletion(newSimpleCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_STATEMENT__SIMPLE_COMPLETION, newSimpleCompletion, newSimpleCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompoundAcceptStatementCompletion getCompoundCompletion()
  {
    return compoundCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCompoundCompletion(CompoundAcceptStatementCompletion newCompoundCompletion, NotificationChain msgs)
  {
    CompoundAcceptStatementCompletion oldCompoundCompletion = compoundCompletion;
    compoundCompletion = newCompoundCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_STATEMENT__COMPOUND_COMPLETION, oldCompoundCompletion, newCompoundCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompoundCompletion(CompoundAcceptStatementCompletion newCompoundCompletion)
  {
    if (newCompoundCompletion != compoundCompletion)
    {
      NotificationChain msgs = null;
      if (compoundCompletion != null)
        msgs = ((InternalEObject)compoundCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_STATEMENT__COMPOUND_COMPLETION, null, msgs);
      if (newCompoundCompletion != null)
        msgs = ((InternalEObject)newCompoundCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_STATEMENT__COMPOUND_COMPLETION, null, msgs);
      msgs = basicSetCompoundCompletion(newCompoundCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_STATEMENT__COMPOUND_COMPLETION, newCompoundCompletion, newCompoundCompletion));
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
      case AlfPackage.ACCEPT_STATEMENT__ACCEPT_CLAUSE:
        return basicSetAcceptClause(null, msgs);
      case AlfPackage.ACCEPT_STATEMENT__SIMPLE_COMPLETION:
        return basicSetSimpleCompletion(null, msgs);
      case AlfPackage.ACCEPT_STATEMENT__COMPOUND_COMPLETION:
        return basicSetCompoundCompletion(null, msgs);
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
      case AlfPackage.ACCEPT_STATEMENT__ACCEPT_CLAUSE:
        return getAcceptClause();
      case AlfPackage.ACCEPT_STATEMENT__SIMPLE_COMPLETION:
        return getSimpleCompletion();
      case AlfPackage.ACCEPT_STATEMENT__COMPOUND_COMPLETION:
        return getCompoundCompletion();
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
      case AlfPackage.ACCEPT_STATEMENT__ACCEPT_CLAUSE:
        setAcceptClause((AcceptClause)newValue);
        return;
      case AlfPackage.ACCEPT_STATEMENT__SIMPLE_COMPLETION:
        setSimpleCompletion((SimpleAcceptStatementCompletion)newValue);
        return;
      case AlfPackage.ACCEPT_STATEMENT__COMPOUND_COMPLETION:
        setCompoundCompletion((CompoundAcceptStatementCompletion)newValue);
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
      case AlfPackage.ACCEPT_STATEMENT__ACCEPT_CLAUSE:
        setAcceptClause((AcceptClause)null);
        return;
      case AlfPackage.ACCEPT_STATEMENT__SIMPLE_COMPLETION:
        setSimpleCompletion((SimpleAcceptStatementCompletion)null);
        return;
      case AlfPackage.ACCEPT_STATEMENT__COMPOUND_COMPLETION:
        setCompoundCompletion((CompoundAcceptStatementCompletion)null);
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
      case AlfPackage.ACCEPT_STATEMENT__ACCEPT_CLAUSE:
        return acceptClause != null;
      case AlfPackage.ACCEPT_STATEMENT__SIMPLE_COMPLETION:
        return simpleCompletion != null;
      case AlfPackage.ACCEPT_STATEMENT__COMPOUND_COMPLETION:
        return compoundCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //AcceptStatementImpl
