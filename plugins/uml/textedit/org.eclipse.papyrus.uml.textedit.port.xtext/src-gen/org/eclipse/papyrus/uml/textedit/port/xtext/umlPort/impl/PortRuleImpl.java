/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl#getIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl#getIsConjugated <em>Is Conjugated</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortRuleImpl extends MinimalEObjectImpl.Container implements PortRule
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
   * The default value of the '{@link #getIsConjugated() <em>Is Conjugated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsConjugated()
   * @generated
   * @ordered
   */
  protected static final String IS_CONJUGATED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIsConjugated() <em>Is Conjugated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsConjugated()
   * @generated
   * @ordered
   */
  protected String isConjugated = IS_CONJUGATED_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypeRule type;

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
   * The cached value of the '{@link #getDefault() <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefault()
   * @generated
   * @ordered
   */
  protected DefaultValueRule default_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PortRuleImpl()
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
    return UmlPortPackage.Literals.PORT_RULE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__VISIBILITY, oldVisibility, visibility));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__IS_DERIVED, oldIsDerived, isDerived));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIsConjugated()
  {
    return isConjugated;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsConjugated(String newIsConjugated)
  {
    String oldIsConjugated = isConjugated;
    isConjugated = newIsConjugated;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__IS_CONJUGATED, oldIsConjugated, isConjugated));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeRule getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(TypeRule newType, NotificationChain msgs)
  {
    TypeRule oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypeRule newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.PORT_RULE__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.PORT_RULE__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__TYPE, newType, newType));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__MULTIPLICITY, oldMultiplicity, newMultiplicity);
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
        msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.PORT_RULE__MULTIPLICITY, null, msgs);
      if (newMultiplicity != null)
        msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.PORT_RULE__MULTIPLICITY, null, msgs);
      msgs = basicSetMultiplicity(newMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__MULTIPLICITY, newMultiplicity, newMultiplicity));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__MODIFIERS, oldModifiers, newModifiers);
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
        msgs = ((InternalEObject)modifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.PORT_RULE__MODIFIERS, null, msgs);
      if (newModifiers != null)
        msgs = ((InternalEObject)newModifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.PORT_RULE__MODIFIERS, null, msgs);
      msgs = basicSetModifiers(newModifiers, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__MODIFIERS, newModifiers, newModifiers));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefaultValueRule getDefault()
  {
    return default_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDefault(DefaultValueRule newDefault, NotificationChain msgs)
  {
    DefaultValueRule oldDefault = default_;
    default_ = newDefault;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__DEFAULT, oldDefault, newDefault);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefault(DefaultValueRule newDefault)
  {
    if (newDefault != default_)
    {
      NotificationChain msgs = null;
      if (default_ != null)
        msgs = ((InternalEObject)default_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.PORT_RULE__DEFAULT, null, msgs);
      if (newDefault != null)
        msgs = ((InternalEObject)newDefault).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.PORT_RULE__DEFAULT, null, msgs);
      msgs = basicSetDefault(newDefault, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.PORT_RULE__DEFAULT, newDefault, newDefault));
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
      case UmlPortPackage.PORT_RULE__TYPE:
        return basicSetType(null, msgs);
      case UmlPortPackage.PORT_RULE__MULTIPLICITY:
        return basicSetMultiplicity(null, msgs);
      case UmlPortPackage.PORT_RULE__MODIFIERS:
        return basicSetModifiers(null, msgs);
      case UmlPortPackage.PORT_RULE__DEFAULT:
        return basicSetDefault(null, msgs);
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
      case UmlPortPackage.PORT_RULE__VISIBILITY:
        return getVisibility();
      case UmlPortPackage.PORT_RULE__IS_DERIVED:
        return getIsDerived();
      case UmlPortPackage.PORT_RULE__NAME:
        return getName();
      case UmlPortPackage.PORT_RULE__IS_CONJUGATED:
        return getIsConjugated();
      case UmlPortPackage.PORT_RULE__TYPE:
        return getType();
      case UmlPortPackage.PORT_RULE__MULTIPLICITY:
        return getMultiplicity();
      case UmlPortPackage.PORT_RULE__MODIFIERS:
        return getModifiers();
      case UmlPortPackage.PORT_RULE__DEFAULT:
        return getDefault();
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
      case UmlPortPackage.PORT_RULE__VISIBILITY:
        setVisibility((VisibilityKind)newValue);
        return;
      case UmlPortPackage.PORT_RULE__IS_DERIVED:
        setIsDerived((String)newValue);
        return;
      case UmlPortPackage.PORT_RULE__NAME:
        setName((String)newValue);
        return;
      case UmlPortPackage.PORT_RULE__IS_CONJUGATED:
        setIsConjugated((String)newValue);
        return;
      case UmlPortPackage.PORT_RULE__TYPE:
        setType((TypeRule)newValue);
        return;
      case UmlPortPackage.PORT_RULE__MULTIPLICITY:
        setMultiplicity((MultiplicityRule)newValue);
        return;
      case UmlPortPackage.PORT_RULE__MODIFIERS:
        setModifiers((ModifiersRule)newValue);
        return;
      case UmlPortPackage.PORT_RULE__DEFAULT:
        setDefault((DefaultValueRule)newValue);
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
      case UmlPortPackage.PORT_RULE__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case UmlPortPackage.PORT_RULE__IS_DERIVED:
        setIsDerived(IS_DERIVED_EDEFAULT);
        return;
      case UmlPortPackage.PORT_RULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UmlPortPackage.PORT_RULE__IS_CONJUGATED:
        setIsConjugated(IS_CONJUGATED_EDEFAULT);
        return;
      case UmlPortPackage.PORT_RULE__TYPE:
        setType((TypeRule)null);
        return;
      case UmlPortPackage.PORT_RULE__MULTIPLICITY:
        setMultiplicity((MultiplicityRule)null);
        return;
      case UmlPortPackage.PORT_RULE__MODIFIERS:
        setModifiers((ModifiersRule)null);
        return;
      case UmlPortPackage.PORT_RULE__DEFAULT:
        setDefault((DefaultValueRule)null);
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
      case UmlPortPackage.PORT_RULE__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case UmlPortPackage.PORT_RULE__IS_DERIVED:
        return IS_DERIVED_EDEFAULT == null ? isDerived != null : !IS_DERIVED_EDEFAULT.equals(isDerived);
      case UmlPortPackage.PORT_RULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmlPortPackage.PORT_RULE__IS_CONJUGATED:
        return IS_CONJUGATED_EDEFAULT == null ? isConjugated != null : !IS_CONJUGATED_EDEFAULT.equals(isConjugated);
      case UmlPortPackage.PORT_RULE__TYPE:
        return type != null;
      case UmlPortPackage.PORT_RULE__MULTIPLICITY:
        return multiplicity != null;
      case UmlPortPackage.PORT_RULE__MODIFIERS:
        return modifiers != null;
      case UmlPortPackage.PORT_RULE__DEFAULT:
        return default_ != null;
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
    result.append(", isConjugated: ");
    result.append(isConjugated);
    result.append(')');
    return result.toString();
  }

} //PortRuleImpl
