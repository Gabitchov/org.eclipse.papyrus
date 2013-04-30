/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.QualifiedName;
import org.eclipse.papyrus.alf.alf.ReceptionDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reception Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ReceptionDefinitionImpl#getReceptionName <em>Reception Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReceptionDefinitionImpl extends ActiveFeatureDefinitionOrStubImpl implements ReceptionDefinition
{
  /**
   * The cached value of the '{@link #getReceptionName() <em>Reception Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReceptionName()
   * @generated
   * @ordered
   */
  protected QualifiedName receptionName;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReceptionDefinitionImpl()
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
    return AlfPackage.eINSTANCE.getReceptionDefinition();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getReceptionName()
  {
    return receptionName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReceptionName(QualifiedName newReceptionName, NotificationChain msgs)
  {
    QualifiedName oldReceptionName = receptionName;
    receptionName = newReceptionName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.RECEPTION_DEFINITION__RECEPTION_NAME, oldReceptionName, newReceptionName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReceptionName(QualifiedName newReceptionName)
  {
    if (newReceptionName != receptionName)
    {
      NotificationChain msgs = null;
      if (receptionName != null)
        msgs = ((InternalEObject)receptionName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.RECEPTION_DEFINITION__RECEPTION_NAME, null, msgs);
      if (newReceptionName != null)
        msgs = ((InternalEObject)newReceptionName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.RECEPTION_DEFINITION__RECEPTION_NAME, null, msgs);
      msgs = basicSetReceptionName(newReceptionName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.RECEPTION_DEFINITION__RECEPTION_NAME, newReceptionName, newReceptionName));
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
      case AlfPackage.RECEPTION_DEFINITION__RECEPTION_NAME:
        return basicSetReceptionName(null, msgs);
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
      case AlfPackage.RECEPTION_DEFINITION__RECEPTION_NAME:
        return getReceptionName();
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
      case AlfPackage.RECEPTION_DEFINITION__RECEPTION_NAME:
        setReceptionName((QualifiedName)newValue);
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
      case AlfPackage.RECEPTION_DEFINITION__RECEPTION_NAME:
        setReceptionName((QualifiedName)null);
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
      case AlfPackage.RECEPTION_DEFINITION__RECEPTION_NAME:
        return receptionName != null;
    }
    return super.eIsSet(featureID);
  }

} //ReceptionDefinitionImpl
