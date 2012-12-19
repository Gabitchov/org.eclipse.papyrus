/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.alf.alf.QualifiedNameList;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Redefinition Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.RedefinitionClauseImpl#getRedefinedOperations <em>Redefined Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RedefinitionClauseImpl extends MinimalEObjectImpl.Container implements RedefinitionClause
{
  /**
   * The cached value of the '{@link #getRedefinedOperations() <em>Redefined Operations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedefinedOperations()
   * @generated
   * @ordered
   */
  protected QualifiedNameList redefinedOperations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RedefinitionClauseImpl()
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
    return OperationPackage.Literals.REDEFINITION_CLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameList getRedefinedOperations()
  {
    return redefinedOperations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRedefinedOperations(QualifiedNameList newRedefinedOperations, NotificationChain msgs)
  {
    QualifiedNameList oldRedefinedOperations = redefinedOperations;
    redefinedOperations = newRedefinedOperations;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.REDEFINITION_CLAUSE__REDEFINED_OPERATIONS, oldRedefinedOperations, newRedefinedOperations);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedefinedOperations(QualifiedNameList newRedefinedOperations)
  {
    if (newRedefinedOperations != redefinedOperations)
    {
      NotificationChain msgs = null;
      if (redefinedOperations != null)
        msgs = ((InternalEObject)redefinedOperations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.REDEFINITION_CLAUSE__REDEFINED_OPERATIONS, null, msgs);
      if (newRedefinedOperations != null)
        msgs = ((InternalEObject)newRedefinedOperations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.REDEFINITION_CLAUSE__REDEFINED_OPERATIONS, null, msgs);
      msgs = basicSetRedefinedOperations(newRedefinedOperations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.REDEFINITION_CLAUSE__REDEFINED_OPERATIONS, newRedefinedOperations, newRedefinedOperations));
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
      case OperationPackage.REDEFINITION_CLAUSE__REDEFINED_OPERATIONS:
        return basicSetRedefinedOperations(null, msgs);
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
      case OperationPackage.REDEFINITION_CLAUSE__REDEFINED_OPERATIONS:
        return getRedefinedOperations();
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
      case OperationPackage.REDEFINITION_CLAUSE__REDEFINED_OPERATIONS:
        setRedefinedOperations((QualifiedNameList)newValue);
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
      case OperationPackage.REDEFINITION_CLAUSE__REDEFINED_OPERATIONS:
        setRedefinedOperations((QualifiedNameList)null);
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
      case OperationPackage.REDEFINITION_CLAUSE__REDEFINED_OPERATIONS:
        return redefinedOperations != null;
    }
    return super.eIsSet(featureID);
  }

} //RedefinitionClauseImpl
