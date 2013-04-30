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
import org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionWithoutBinding;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.QualifiedNameWithoutBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Name Without Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.QualifiedNameWithoutBindingImpl#getUnqualified <em>Unqualified</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.QualifiedNameWithoutBindingImpl#getNameCompletion <em>Name Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedNameWithoutBindingImpl extends MinimalEObjectImpl.Container implements QualifiedNameWithoutBinding
{
  /**
   * The cached value of the '{@link #getUnqualified() <em>Unqualified</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnqualified()
   * @generated
   * @ordered
   */
  protected Name unqualified;

  /**
   * The cached value of the '{@link #getNameCompletion() <em>Name Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameCompletion()
   * @generated
   * @ordered
   */
  protected ColonQualifiedNameCompletionWithoutBinding nameCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedNameWithoutBindingImpl()
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
    return AlfPackage.eINSTANCE.getQualifiedNameWithoutBinding();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name getUnqualified()
  {
    return unqualified;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnqualified(Name newUnqualified, NotificationChain msgs)
  {
    Name oldUnqualified = unqualified;
    unqualified = newUnqualified;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__UNQUALIFIED, oldUnqualified, newUnqualified);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnqualified(Name newUnqualified)
  {
    if (newUnqualified != unqualified)
    {
      NotificationChain msgs = null;
      if (unqualified != null)
        msgs = ((InternalEObject)unqualified).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__UNQUALIFIED, null, msgs);
      if (newUnqualified != null)
        msgs = ((InternalEObject)newUnqualified).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__UNQUALIFIED, null, msgs);
      msgs = basicSetUnqualified(newUnqualified, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__UNQUALIFIED, newUnqualified, newUnqualified));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColonQualifiedNameCompletionWithoutBinding getNameCompletion()
  {
    return nameCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNameCompletion(ColonQualifiedNameCompletionWithoutBinding newNameCompletion, NotificationChain msgs)
  {
    ColonQualifiedNameCompletionWithoutBinding oldNameCompletion = nameCompletion;
    nameCompletion = newNameCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__NAME_COMPLETION, oldNameCompletion, newNameCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameCompletion(ColonQualifiedNameCompletionWithoutBinding newNameCompletion)
  {
    if (newNameCompletion != nameCompletion)
    {
      NotificationChain msgs = null;
      if (nameCompletion != null)
        msgs = ((InternalEObject)nameCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__NAME_COMPLETION, null, msgs);
      if (newNameCompletion != null)
        msgs = ((InternalEObject)newNameCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__NAME_COMPLETION, null, msgs);
      msgs = basicSetNameCompletion(newNameCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__NAME_COMPLETION, newNameCompletion, newNameCompletion));
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
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__UNQUALIFIED:
        return basicSetUnqualified(null, msgs);
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__NAME_COMPLETION:
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
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__UNQUALIFIED:
        return getUnqualified();
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__NAME_COMPLETION:
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
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__UNQUALIFIED:
        setUnqualified((Name)newValue);
        return;
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__NAME_COMPLETION:
        setNameCompletion((ColonQualifiedNameCompletionWithoutBinding)newValue);
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
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__UNQUALIFIED:
        setUnqualified((Name)null);
        return;
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__NAME_COMPLETION:
        setNameCompletion((ColonQualifiedNameCompletionWithoutBinding)null);
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
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__UNQUALIFIED:
        return unqualified != null;
      case AlfPackage.QUALIFIED_NAME_WITHOUT_BINDING__NAME_COMPLETION:
        return nameCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //QualifiedNameWithoutBindingImpl
