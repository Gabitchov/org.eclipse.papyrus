/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.property.editor.xtext.umlProperty.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifiersRule;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.MultiplicityRule;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.UmlPropertyPackage;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.VisibilityKind;

import org.eclipse.uml2.uml.Classifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl#getIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyRuleImpl extends MinimalEObjectImpl.Container implements PropertyRule
{
  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final VisibilityKind VISIBILITY_EDEFAULT = VisibilityKind.PUBLIC;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected VisibilityKind visibility = VISIBILITY_EDEFAULT;

  /**
   * The default value of the '{@link #getIsDerived() <em>Is Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsDerived()
   * @generated
   * @ordered
   */
  protected static final String IS_DERIVED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIsDerived() <em>Is Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsDerived()
   * @generated
   * @ordered
   */
  protected String isDerived = IS_DERIVED_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Classifier type;

  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected MultiplicityRule multiplicity;

  /**
   * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifiers()
   * @generated
   * @ordered
   */
  protected ModifiersRule modifiers;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyRuleImpl()
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
    return UmlPropertyPackage.Literals.PROPERTY_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VisibilityKind getVisibility()
  {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibility(VisibilityKind newVisibility)
  {
    VisibilityKind oldVisibility = visibility;
    visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIsDerived()
  {
    return isDerived;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsDerived(String newIsDerived)
  {
    String oldIsDerived = isDerived;
    isDerived = newIsDerived;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__IS_DERIVED, oldIsDerived, isDerived));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (Classifier)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlPropertyPackage.PROPERTY_RULE__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Classifier newType)
  {
    Classifier oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityRule getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicity(MultiplicityRule newMultiplicity, NotificationChain msgs)
  {
    MultiplicityRule oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY, oldMultiplicity, newMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicity(MultiplicityRule newMultiplicity)
  {
    if (newMultiplicity != multiplicity)
    {
      NotificationChain msgs = null;
      if (multiplicity != null)
        msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY, null, msgs);
      if (newMultiplicity != null)
        msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY, null, msgs);
      msgs = basicSetMultiplicity(newMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY, newMultiplicity, newMultiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModifiersRule getModifiers()
  {
    return modifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModifiers(ModifiersRule newModifiers, NotificationChain msgs)
  {
    ModifiersRule oldModifiers = modifiers;
    modifiers = newModifiers;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__MODIFIERS, oldModifiers, newModifiers);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModifiers(ModifiersRule newModifiers)
  {
    if (newModifiers != modifiers)
    {
      NotificationChain msgs = null;
      if (modifiers != null)
        msgs = ((InternalEObject)modifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__MODIFIERS, null, msgs);
      if (newModifiers != null)
        msgs = ((InternalEObject)newModifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__MODIFIERS, null, msgs);
      msgs = basicSetModifiers(newModifiers, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__MODIFIERS, newModifiers, newModifiers));
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
      case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
        return basicSetMultiplicity(null, msgs);
      case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
        return basicSetModifiers(null, msgs);
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
      case UmlPropertyPackage.PROPERTY_RULE__VISIBILITY:
        return getVisibility();
      case UmlPropertyPackage.PROPERTY_RULE__IS_DERIVED:
        return getIsDerived();
      case UmlPropertyPackage.PROPERTY_RULE__NAME:
        return getName();
      case UmlPropertyPackage.PROPERTY_RULE__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
        return getMultiplicity();
      case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
        return getModifiers();
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
      case UmlPropertyPackage.PROPERTY_RULE__VISIBILITY:
        setVisibility((VisibilityKind)newValue);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__IS_DERIVED:
        setIsDerived((String)newValue);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__NAME:
        setName((String)newValue);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__TYPE:
        setType((Classifier)newValue);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
        setMultiplicity((MultiplicityRule)newValue);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
        setModifiers((ModifiersRule)newValue);
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
      case UmlPropertyPackage.PROPERTY_RULE__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__IS_DERIVED:
        setIsDerived(IS_DERIVED_EDEFAULT);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__TYPE:
        setType((Classifier)null);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
        setMultiplicity((MultiplicityRule)null);
        return;
      case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
        setModifiers((ModifiersRule)null);
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
      case UmlPropertyPackage.PROPERTY_RULE__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case UmlPropertyPackage.PROPERTY_RULE__IS_DERIVED:
        return IS_DERIVED_EDEFAULT == null ? isDerived != null : !IS_DERIVED_EDEFAULT.equals(isDerived);
      case UmlPropertyPackage.PROPERTY_RULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmlPropertyPackage.PROPERTY_RULE__TYPE:
        return type != null;
      case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
        return multiplicity != null;
      case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
        return modifiers != null;
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
    result.append(" (visibility: ");
    result.append(visibility);
    result.append(", isDerived: ");
    result.append(isDerived);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PropertyRuleImpl
