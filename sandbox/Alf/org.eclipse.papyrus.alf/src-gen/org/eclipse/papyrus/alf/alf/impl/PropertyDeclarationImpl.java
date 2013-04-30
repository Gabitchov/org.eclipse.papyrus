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
import org.eclipse.papyrus.alf.alf.PropertyDeclaration;
import org.eclipse.papyrus.alf.alf.TypePart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PropertyDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PropertyDeclarationImpl#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PropertyDeclarationImpl#getTypePart <em>Type Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyDeclarationImpl extends MinimalEObjectImpl.Container implements PropertyDeclaration
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
   * The default value of the '{@link #isIsComposite() <em>Is Composite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsComposite()
   * @generated
   * @ordered
   */
  protected static final boolean IS_COMPOSITE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsComposite() <em>Is Composite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsComposite()
   * @generated
   * @ordered
   */
  protected boolean isComposite = IS_COMPOSITE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypePart() <em>Type Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypePart()
   * @generated
   * @ordered
   */
  protected TypePart typePart;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyDeclarationImpl()
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
    return AlfPackage.eINSTANCE.getPropertyDeclaration();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PROPERTY_DECLARATION__NAME, oldName, newName);
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
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PROPERTY_DECLARATION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PROPERTY_DECLARATION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PROPERTY_DECLARATION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsComposite()
  {
    return isComposite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsComposite(boolean newIsComposite)
  {
    boolean oldIsComposite = isComposite;
    isComposite = newIsComposite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PROPERTY_DECLARATION__IS_COMPOSITE, oldIsComposite, isComposite));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePart getTypePart()
  {
    return typePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypePart(TypePart newTypePart, NotificationChain msgs)
  {
    TypePart oldTypePart = typePart;
    typePart = newTypePart;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PROPERTY_DECLARATION__TYPE_PART, oldTypePart, newTypePart);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypePart(TypePart newTypePart)
  {
    if (newTypePart != typePart)
    {
      NotificationChain msgs = null;
      if (typePart != null)
        msgs = ((InternalEObject)typePart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PROPERTY_DECLARATION__TYPE_PART, null, msgs);
      if (newTypePart != null)
        msgs = ((InternalEObject)newTypePart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PROPERTY_DECLARATION__TYPE_PART, null, msgs);
      msgs = basicSetTypePart(newTypePart, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PROPERTY_DECLARATION__TYPE_PART, newTypePart, newTypePart));
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
      case AlfPackage.PROPERTY_DECLARATION__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.PROPERTY_DECLARATION__TYPE_PART:
        return basicSetTypePart(null, msgs);
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
      case AlfPackage.PROPERTY_DECLARATION__NAME:
        return getName();
      case AlfPackage.PROPERTY_DECLARATION__IS_COMPOSITE:
        return isIsComposite();
      case AlfPackage.PROPERTY_DECLARATION__TYPE_PART:
        return getTypePart();
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
      case AlfPackage.PROPERTY_DECLARATION__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.PROPERTY_DECLARATION__IS_COMPOSITE:
        setIsComposite((Boolean)newValue);
        return;
      case AlfPackage.PROPERTY_DECLARATION__TYPE_PART:
        setTypePart((TypePart)newValue);
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
      case AlfPackage.PROPERTY_DECLARATION__NAME:
        setName((Name)null);
        return;
      case AlfPackage.PROPERTY_DECLARATION__IS_COMPOSITE:
        setIsComposite(IS_COMPOSITE_EDEFAULT);
        return;
      case AlfPackage.PROPERTY_DECLARATION__TYPE_PART:
        setTypePart((TypePart)null);
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
      case AlfPackage.PROPERTY_DECLARATION__NAME:
        return name != null;
      case AlfPackage.PROPERTY_DECLARATION__IS_COMPOSITE:
        return isComposite != IS_COMPOSITE_EDEFAULT;
      case AlfPackage.PROPERTY_DECLARATION__TYPE_PART:
        return typePart != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (isComposite: ");
    result.append(isComposite);
    result.append(')');
    return result.toString();
  }

} //PropertyDeclarationImpl
