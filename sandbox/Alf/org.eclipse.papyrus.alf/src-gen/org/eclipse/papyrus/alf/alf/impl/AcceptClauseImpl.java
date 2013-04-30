/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AcceptClause;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.QualifiedNameList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accept Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AcceptClauseImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AcceptClauseImpl#getQualifiedNameList <em>Qualified Name List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AcceptClauseImpl extends MinimalEObjectImpl.Container implements AcceptClause
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Name name;

  /**
   * The cached value of the '{@link #getQualifiedNameList() <em>Qualified Name List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedNameList()
   * @generated
   * @ordered
   */
  protected QualifiedNameList qualifiedNameList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AcceptClauseImpl()
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
    return AlfPackage.eINSTANCE.getAcceptClause();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(Name newName, NotificationChain msgs)
  {
    Name oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_CLAUSE__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(Name newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_CLAUSE__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_CLAUSE__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_CLAUSE__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameList getQualifiedNameList()
  {
    return qualifiedNameList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifiedNameList(QualifiedNameList newQualifiedNameList, NotificationChain msgs)
  {
    QualifiedNameList oldQualifiedNameList = qualifiedNameList;
    qualifiedNameList = newQualifiedNameList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_CLAUSE__QUALIFIED_NAME_LIST, oldQualifiedNameList, newQualifiedNameList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualifiedNameList(QualifiedNameList newQualifiedNameList)
  {
    if (newQualifiedNameList != qualifiedNameList)
    {
      NotificationChain msgs = null;
      if (qualifiedNameList != null)
        msgs = ((InternalEObject)qualifiedNameList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_CLAUSE__QUALIFIED_NAME_LIST, null, msgs);
      if (newQualifiedNameList != null)
        msgs = ((InternalEObject)newQualifiedNameList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_CLAUSE__QUALIFIED_NAME_LIST, null, msgs);
      msgs = basicSetQualifiedNameList(newQualifiedNameList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_CLAUSE__QUALIFIED_NAME_LIST, newQualifiedNameList, newQualifiedNameList));
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
      case AlfPackage.ACCEPT_CLAUSE__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.ACCEPT_CLAUSE__QUALIFIED_NAME_LIST:
        return basicSetQualifiedNameList(null, msgs);
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
      case AlfPackage.ACCEPT_CLAUSE__NAME:
        return getName();
      case AlfPackage.ACCEPT_CLAUSE__QUALIFIED_NAME_LIST:
        return getQualifiedNameList();
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
      case AlfPackage.ACCEPT_CLAUSE__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.ACCEPT_CLAUSE__QUALIFIED_NAME_LIST:
        setQualifiedNameList((QualifiedNameList)newValue);
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
      case AlfPackage.ACCEPT_CLAUSE__NAME:
        setName((Name)null);
        return;
      case AlfPackage.ACCEPT_CLAUSE__QUALIFIED_NAME_LIST:
        setQualifiedNameList((QualifiedNameList)null);
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
      case AlfPackage.ACCEPT_CLAUSE__NAME:
        return name != null;
      case AlfPackage.ACCEPT_CLAUSE__QUALIFIED_NAME_LIST:
        return qualifiedNameList != null;
    }
    return super.eIsSet(featureID);
  }

} //AcceptClauseImpl
