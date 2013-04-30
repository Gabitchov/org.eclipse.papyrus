/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.AttributeDefinition;
import org.eclipse.papyrus.alf.alf.AttributeInitializer;
import org.eclipse.papyrus.alf.alf.PropertyDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AttributeDefinitionImpl#getPropertyDeclaration <em>Property Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AttributeDefinitionImpl#getAttributeInitializer <em>Attribute Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeDefinitionImpl extends FeatureDefinitionOrStubImpl implements AttributeDefinition
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
   * The cached value of the '{@link #getAttributeInitializer() <em>Attribute Initializer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeInitializer()
   * @generated
   * @ordered
   */
  protected AttributeInitializer attributeInitializer;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeDefinitionImpl()
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
    return AlfPackage.eINSTANCE.getAttributeDefinition();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ATTRIBUTE_DEFINITION__PROPERTY_DECLARATION, oldPropertyDeclaration, newPropertyDeclaration);
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
        msgs = ((InternalEObject)propertyDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ATTRIBUTE_DEFINITION__PROPERTY_DECLARATION, null, msgs);
      if (newPropertyDeclaration != null)
        msgs = ((InternalEObject)newPropertyDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ATTRIBUTE_DEFINITION__PROPERTY_DECLARATION, null, msgs);
      msgs = basicSetPropertyDeclaration(newPropertyDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ATTRIBUTE_DEFINITION__PROPERTY_DECLARATION, newPropertyDeclaration, newPropertyDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeInitializer getAttributeInitializer()
  {
    return attributeInitializer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAttributeInitializer(AttributeInitializer newAttributeInitializer, NotificationChain msgs)
  {
    AttributeInitializer oldAttributeInitializer = attributeInitializer;
    attributeInitializer = newAttributeInitializer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_INITIALIZER, oldAttributeInitializer, newAttributeInitializer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttributeInitializer(AttributeInitializer newAttributeInitializer)
  {
    if (newAttributeInitializer != attributeInitializer)
    {
      NotificationChain msgs = null;
      if (attributeInitializer != null)
        msgs = ((InternalEObject)attributeInitializer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_INITIALIZER, null, msgs);
      if (newAttributeInitializer != null)
        msgs = ((InternalEObject)newAttributeInitializer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_INITIALIZER, null, msgs);
      msgs = basicSetAttributeInitializer(newAttributeInitializer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_INITIALIZER, newAttributeInitializer, newAttributeInitializer));
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
      case AlfPackage.ATTRIBUTE_DEFINITION__PROPERTY_DECLARATION:
        return basicSetPropertyDeclaration(null, msgs);
      case AlfPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_INITIALIZER:
        return basicSetAttributeInitializer(null, msgs);
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
      case AlfPackage.ATTRIBUTE_DEFINITION__PROPERTY_DECLARATION:
        return getPropertyDeclaration();
      case AlfPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_INITIALIZER:
        return getAttributeInitializer();
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
      case AlfPackage.ATTRIBUTE_DEFINITION__PROPERTY_DECLARATION:
        setPropertyDeclaration((PropertyDeclaration)newValue);
        return;
      case AlfPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_INITIALIZER:
        setAttributeInitializer((AttributeInitializer)newValue);
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
      case AlfPackage.ATTRIBUTE_DEFINITION__PROPERTY_DECLARATION:
        setPropertyDeclaration((PropertyDeclaration)null);
        return;
      case AlfPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_INITIALIZER:
        setAttributeInitializer((AttributeInitializer)null);
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
      case AlfPackage.ATTRIBUTE_DEFINITION__PROPERTY_DECLARATION:
        return propertyDeclaration != null;
      case AlfPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_INITIALIZER:
        return attributeInitializer != null;
    }
    return super.eIsSet(featureID);
  }

} //AttributeDefinitionImpl
