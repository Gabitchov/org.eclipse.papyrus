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
import org.eclipse.papyrus.alf.alf.AliasDefinition;
import org.eclipse.papyrus.alf.alf.Name;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alias Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AliasDefinitionImpl#getAlias <em>Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AliasDefinitionImpl extends MinimalEObjectImpl.Container implements AliasDefinition
{
  /**
   * The cached value of the '{@link #getAlias() <em>Alias</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected Name alias;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AliasDefinitionImpl()
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
    return AlfPackage.eINSTANCE.getAliasDefinition();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name getAlias()
  {
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAlias(Name newAlias, NotificationChain msgs)
  {
    Name oldAlias = alias;
    alias = newAlias;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ALIAS_DEFINITION__ALIAS, oldAlias, newAlias);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlias(Name newAlias)
  {
    if (newAlias != alias)
    {
      NotificationChain msgs = null;
      if (alias != null)
        msgs = ((InternalEObject)alias).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ALIAS_DEFINITION__ALIAS, null, msgs);
      if (newAlias != null)
        msgs = ((InternalEObject)newAlias).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ALIAS_DEFINITION__ALIAS, null, msgs);
      msgs = basicSetAlias(newAlias, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ALIAS_DEFINITION__ALIAS, newAlias, newAlias));
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
      case AlfPackage.ALIAS_DEFINITION__ALIAS:
        return basicSetAlias(null, msgs);
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
      case AlfPackage.ALIAS_DEFINITION__ALIAS:
        return getAlias();
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
      case AlfPackage.ALIAS_DEFINITION__ALIAS:
        setAlias((Name)newValue);
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
      case AlfPackage.ALIAS_DEFINITION__ALIAS:
        setAlias((Name)null);
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
      case AlfPackage.ALIAS_DEFINITION__ALIAS:
        return alias != null;
    }
    return super.eIsSet(featureID);
  }

} //AliasDefinitionImpl
