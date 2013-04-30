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
import org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletion;
import org.eclipse.papyrus.alf.alf.QualifiedName;
import org.eclipse.papyrus.alf.alf.UnqualifiedName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.QualifiedNameImpl#getUnqualified <em>Unqualified</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.QualifiedNameImpl#getNameCompletion <em>Name Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedNameImpl extends MinimalEObjectImpl.Container implements QualifiedName
{
  /**
   * The cached value of the '{@link #getUnqualified() <em>Unqualified</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnqualified()
   * @generated
   * @ordered
   */
  protected UnqualifiedName unqualified;

  /**
   * The cached value of the '{@link #getNameCompletion() <em>Name Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameCompletion()
   * @generated
   * @ordered
   */
  protected ColonQualifiedNameCompletion nameCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedNameImpl()
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
    return AlfPackage.eINSTANCE.getQualifiedName();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnqualifiedName getUnqualified()
  {
    return unqualified;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnqualified(UnqualifiedName newUnqualified, NotificationChain msgs)
  {
    UnqualifiedName oldUnqualified = unqualified;
    unqualified = newUnqualified;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME__UNQUALIFIED, oldUnqualified, newUnqualified);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnqualified(UnqualifiedName newUnqualified)
  {
    if (newUnqualified != unqualified)
    {
      NotificationChain msgs = null;
      if (unqualified != null)
        msgs = ((InternalEObject)unqualified).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME__UNQUALIFIED, null, msgs);
      if (newUnqualified != null)
        msgs = ((InternalEObject)newUnqualified).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME__UNQUALIFIED, null, msgs);
      msgs = basicSetUnqualified(newUnqualified, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME__UNQUALIFIED, newUnqualified, newUnqualified));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColonQualifiedNameCompletion getNameCompletion()
  {
    return nameCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNameCompletion(ColonQualifiedNameCompletion newNameCompletion, NotificationChain msgs)
  {
    ColonQualifiedNameCompletion oldNameCompletion = nameCompletion;
    nameCompletion = newNameCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME__NAME_COMPLETION, oldNameCompletion, newNameCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameCompletion(ColonQualifiedNameCompletion newNameCompletion)
  {
    if (newNameCompletion != nameCompletion)
    {
      NotificationChain msgs = null;
      if (nameCompletion != null)
        msgs = ((InternalEObject)nameCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME__NAME_COMPLETION, null, msgs);
      if (newNameCompletion != null)
        msgs = ((InternalEObject)newNameCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME__NAME_COMPLETION, null, msgs);
      msgs = basicSetNameCompletion(newNameCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME__NAME_COMPLETION, newNameCompletion, newNameCompletion));
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
      case AlfPackage.QUALIFIED_NAME__UNQUALIFIED:
        return basicSetUnqualified(null, msgs);
      case AlfPackage.QUALIFIED_NAME__NAME_COMPLETION:
        return basicSetNameCompletion(null, msgs);
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
      case AlfPackage.QUALIFIED_NAME__UNQUALIFIED:
        return getUnqualified();
      case AlfPackage.QUALIFIED_NAME__NAME_COMPLETION:
        return getNameCompletion();
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
      case AlfPackage.QUALIFIED_NAME__UNQUALIFIED:
        setUnqualified((UnqualifiedName)newValue);
        return;
      case AlfPackage.QUALIFIED_NAME__NAME_COMPLETION:
        setNameCompletion((ColonQualifiedNameCompletion)newValue);
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
      case AlfPackage.QUALIFIED_NAME__UNQUALIFIED:
        setUnqualified((UnqualifiedName)null);
        return;
      case AlfPackage.QUALIFIED_NAME__NAME_COMPLETION:
        setNameCompletion((ColonQualifiedNameCompletion)null);
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
      case AlfPackage.QUALIFIED_NAME__UNQUALIFIED:
        return unqualified != null;
      case AlfPackage.QUALIFIED_NAME__NAME_COMPLETION:
        return nameCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //QualifiedNameImpl
