/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.NameBinding;
import org.eclipse.papyrus.alf.alf.TemplateBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameBindingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameBindingImpl#getTemplateBinding <em>Template Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameBindingImpl extends UnqualifiedNameImpl implements NameBinding
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
   * The cached value of the '{@link #getTemplateBinding() <em>Template Binding</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateBinding()
   * @generated
   * @ordered
   */
  protected TemplateBinding templateBinding;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NameBindingImpl()
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
    return AlfPackage.eINSTANCE.getNameBinding();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_BINDING__NAME, oldName, newName);
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
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_BINDING__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_BINDING__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_BINDING__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateBinding getTemplateBinding()
  {
    return templateBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTemplateBinding(TemplateBinding newTemplateBinding, NotificationChain msgs)
  {
    TemplateBinding oldTemplateBinding = templateBinding;
    templateBinding = newTemplateBinding;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_BINDING__TEMPLATE_BINDING, oldTemplateBinding, newTemplateBinding);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemplateBinding(TemplateBinding newTemplateBinding)
  {
    if (newTemplateBinding != templateBinding)
    {
      NotificationChain msgs = null;
      if (templateBinding != null)
        msgs = ((InternalEObject)templateBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_BINDING__TEMPLATE_BINDING, null, msgs);
      if (newTemplateBinding != null)
        msgs = ((InternalEObject)newTemplateBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_BINDING__TEMPLATE_BINDING, null, msgs);
      msgs = basicSetTemplateBinding(newTemplateBinding, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_BINDING__TEMPLATE_BINDING, newTemplateBinding, newTemplateBinding));
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
      case AlfPackage.NAME_BINDING__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.NAME_BINDING__TEMPLATE_BINDING:
        return basicSetTemplateBinding(null, msgs);
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
      case AlfPackage.NAME_BINDING__NAME:
        return getName();
      case AlfPackage.NAME_BINDING__TEMPLATE_BINDING:
        return getTemplateBinding();
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
      case AlfPackage.NAME_BINDING__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.NAME_BINDING__TEMPLATE_BINDING:
        setTemplateBinding((TemplateBinding)newValue);
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
      case AlfPackage.NAME_BINDING__NAME:
        setName((Name)null);
        return;
      case AlfPackage.NAME_BINDING__TEMPLATE_BINDING:
        setTemplateBinding((TemplateBinding)null);
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
      case AlfPackage.NAME_BINDING__NAME:
        return name != null;
      case AlfPackage.NAME_BINDING__TEMPLATE_BINDING:
        return templateBinding != null;
    }
    return super.eIsSet(featureID);
  }

} //NameBindingImpl
