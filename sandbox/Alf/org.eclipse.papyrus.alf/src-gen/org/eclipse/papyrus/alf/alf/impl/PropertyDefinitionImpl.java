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
import org.eclipse.papyrus.alf.alf.PropertyDeclaration;
import org.eclipse.papyrus.alf.alf.PropertyDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PropertyDefinitionImpl#getPropertyDeclaration <em>Property Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyDefinitionImpl extends MinimalEObjectImpl.Container implements PropertyDefinition
{
  /**
   * The cached value of the '{@link #getPropertyDeclaration() <em>Property Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyDeclaration()
   * @generated
   * @ordered
   */
  protected PropertyDeclaration propertyDeclaration;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyDefinitionImpl()
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
    return AlfPackage.eINSTANCE.getPropertyDefinition();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyDeclaration getPropertyDeclaration()
  {
    return propertyDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPropertyDeclaration(PropertyDeclaration newPropertyDeclaration, NotificationChain msgs)
  {
    PropertyDeclaration oldPropertyDeclaration = propertyDeclaration;
    propertyDeclaration = newPropertyDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PROPERTY_DEFINITION__PROPERTY_DECLARATION, oldPropertyDeclaration, newPropertyDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPropertyDeclaration(PropertyDeclaration newPropertyDeclaration)
  {
    if (newPropertyDeclaration != propertyDeclaration)
    {
      NotificationChain msgs = null;
      if (propertyDeclaration != null)
        msgs = ((InternalEObject)propertyDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PROPERTY_DEFINITION__PROPERTY_DECLARATION, null, msgs);
      if (newPropertyDeclaration != null)
        msgs = ((InternalEObject)newPropertyDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PROPERTY_DEFINITION__PROPERTY_DECLARATION, null, msgs);
      msgs = basicSetPropertyDeclaration(newPropertyDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PROPERTY_DEFINITION__PROPERTY_DECLARATION, newPropertyDeclaration, newPropertyDeclaration));
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
      case AlfPackage.PROPERTY_DEFINITION__PROPERTY_DECLARATION:
        return basicSetPropertyDeclaration(null, msgs);
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
      case AlfPackage.PROPERTY_DEFINITION__PROPERTY_DECLARATION:
        return getPropertyDeclaration();
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
      case AlfPackage.PROPERTY_DEFINITION__PROPERTY_DECLARATION:
        setPropertyDeclaration((PropertyDeclaration)newValue);
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
      case AlfPackage.PROPERTY_DEFINITION__PROPERTY_DECLARATION:
        setPropertyDeclaration((PropertyDeclaration)null);
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
      case AlfPackage.PROPERTY_DEFINITION__PROPERTY_DECLARATION:
        return propertyDeclaration != null;
    }
    return super.eIsSet(featureID);
  }

} //PropertyDefinitionImpl
