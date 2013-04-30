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
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.SignalReceptionDeclaration;
import org.eclipse.papyrus.alf.alf.SpecializationClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal Reception Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SignalReceptionDeclarationImpl#getSignalName <em>Signal Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SignalReceptionDeclarationImpl#getSpecializationClause <em>Specialization Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignalReceptionDeclarationImpl extends MinimalEObjectImpl.Container implements SignalReceptionDeclaration
{
  /**
   * The cached value of the '{@link #getSignalName() <em>Signal Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignalName()
   * @generated
   * @ordered
   */
  protected Name signalName;

  /**
   * The cached value of the '{@link #getSpecializationClause() <em>Specialization Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecializationClause()
   * @generated
   * @ordered
   */
  protected SpecializationClause specializationClause;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SignalReceptionDeclarationImpl()
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
    return AlfPackage.eINSTANCE.getSignalReceptionDeclaration();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name getSignalName()
  {
    return signalName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSignalName(Name newSignalName, NotificationChain msgs)
  {
    Name oldSignalName = signalName;
    signalName = newSignalName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_RECEPTION_DECLARATION__SIGNAL_NAME, oldSignalName, newSignalName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignalName(Name newSignalName)
  {
    if (newSignalName != signalName)
    {
      NotificationChain msgs = null;
      if (signalName != null)
        msgs = ((InternalEObject)signalName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_RECEPTION_DECLARATION__SIGNAL_NAME, null, msgs);
      if (newSignalName != null)
        msgs = ((InternalEObject)newSignalName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_RECEPTION_DECLARATION__SIGNAL_NAME, null, msgs);
      msgs = basicSetSignalName(newSignalName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_RECEPTION_DECLARATION__SIGNAL_NAME, newSignalName, newSignalName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecializationClause getSpecializationClause()
  {
    return specializationClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpecializationClause(SpecializationClause newSpecializationClause, NotificationChain msgs)
  {
    SpecializationClause oldSpecializationClause = specializationClause;
    specializationClause = newSpecializationClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_RECEPTION_DECLARATION__SPECIALIZATION_CLAUSE, oldSpecializationClause, newSpecializationClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecializationClause(SpecializationClause newSpecializationClause)
  {
    if (newSpecializationClause != specializationClause)
    {
      NotificationChain msgs = null;
      if (specializationClause != null)
        msgs = ((InternalEObject)specializationClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_RECEPTION_DECLARATION__SPECIALIZATION_CLAUSE, null, msgs);
      if (newSpecializationClause != null)
        msgs = ((InternalEObject)newSpecializationClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_RECEPTION_DECLARATION__SPECIALIZATION_CLAUSE, null, msgs);
      msgs = basicSetSpecializationClause(newSpecializationClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_RECEPTION_DECLARATION__SPECIALIZATION_CLAUSE, newSpecializationClause, newSpecializationClause));
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
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SIGNAL_NAME:
        return basicSetSignalName(null, msgs);
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SPECIALIZATION_CLAUSE:
        return basicSetSpecializationClause(null, msgs);
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
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SIGNAL_NAME:
        return getSignalName();
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SPECIALIZATION_CLAUSE:
        return getSpecializationClause();
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
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SIGNAL_NAME:
        setSignalName((Name)newValue);
        return;
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SPECIALIZATION_CLAUSE:
        setSpecializationClause((SpecializationClause)newValue);
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
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SIGNAL_NAME:
        setSignalName((Name)null);
        return;
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SPECIALIZATION_CLAUSE:
        setSpecializationClause((SpecializationClause)null);
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
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SIGNAL_NAME:
        return signalName != null;
      case AlfPackage.SIGNAL_RECEPTION_DECLARATION__SPECIALIZATION_CLAUSE:
        return specializationClause != null;
    }
    return super.eIsSet(featureID);
  }

} //SignalReceptionDeclarationImpl
