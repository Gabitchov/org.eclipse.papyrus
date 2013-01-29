/**
 */
package org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.ExpressionValueRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag Specification Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.impl.TagSpecificationRuleImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.impl.TagSpecificationRuleImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TagSpecificationRuleImpl extends MinimalEObjectImpl.Container implements TagSpecificationRule
{
  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected Property property;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected ExpressionValueRule value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TagSpecificationRuleImpl()
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
    return StereotypeApplicationWithVSLPackage.Literals.TAG_SPECIFICATION_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property getProperty()
  {
    if (property != null && property.eIsProxy())
    {
      InternalEObject oldProperty = (InternalEObject)property;
      property = (Property)eResolveProxy(oldProperty);
      if (property != oldProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__PROPERTY, oldProperty, property));
      }
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property basicGetProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProperty(Property newProperty)
  {
    Property oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__PROPERTY, oldProperty, property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionValueRule getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(ExpressionValueRule newValue, NotificationChain msgs)
  {
    ExpressionValueRule oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(ExpressionValueRule newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getExpectedType()
  {
    return org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.validation.ContextUtil.getExpectedType(this) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getContextElement()
  {
    return org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.validation.ContextUtil.getContextElement(this) ;
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
      case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__VALUE:
        return basicSetValue(null, msgs);
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
      case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__PROPERTY:
        if (resolve) return getProperty();
        return basicGetProperty();
      case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__VALUE:
        return getValue();
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
      case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__PROPERTY:
        setProperty((Property)newValue);
        return;
      case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__VALUE:
        setValue((ExpressionValueRule)newValue);
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
      case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__PROPERTY:
        setProperty((Property)null);
        return;
      case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__VALUE:
        setValue((ExpressionValueRule)null);
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
      case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__PROPERTY:
        return property != null;
      case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

} //TagSpecificationRuleImpl
