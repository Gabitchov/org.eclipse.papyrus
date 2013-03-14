/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind;

import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getEffect <em>Effect</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterRuleImpl extends MinimalEObjectImpl.Container implements ParameterRule
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
   * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected static final Direction DIRECTION_EDEFAULT = Direction.IN;

  /**
   * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected Direction direction = DIRECTION_EDEFAULT;

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
   * The cached value of the '{@link #getEffect() <em>Effect</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffect()
   * @generated
   * @ordered
   */
  protected EffectRule effect;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParameterRuleImpl()
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
    return UmlParameterPackage.Literals.PARAMETER_RULE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Direction getDirection()
  {
    return direction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirection(Direction newDirection)
  {
    Direction oldDirection = direction;
    direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__DIRECTION, oldDirection, direction));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__TYPE, oldType, newType);
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
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__TYPE, newType, newType));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY, oldMultiplicity, newMultiplicity);
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
        msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY, null, msgs);
      if (newMultiplicity != null)
        msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY, null, msgs);
      msgs = basicSetMultiplicity(newMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY, newMultiplicity, newMultiplicity));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__MODIFIERS, oldModifiers, newModifiers);
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
        msgs = ((InternalEObject)modifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__MODIFIERS, null, msgs);
      if (newModifiers != null)
        msgs = ((InternalEObject)newModifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__MODIFIERS, null, msgs);
      msgs = basicSetModifiers(newModifiers, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__MODIFIERS, newModifiers, newModifiers));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EffectRule getEffect()
  {
    return effect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEffect(EffectRule newEffect, NotificationChain msgs)
  {
    EffectRule oldEffect = effect;
    effect = newEffect;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__EFFECT, oldEffect, newEffect);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEffect(EffectRule newEffect)
  {
    if (newEffect != effect)
    {
      NotificationChain msgs = null;
      if (effect != null)
        msgs = ((InternalEObject)effect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__EFFECT, null, msgs);
      if (newEffect != null)
        msgs = ((InternalEObject)newEffect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__EFFECT, null, msgs);
      msgs = basicSetEffect(newEffect, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__EFFECT, newEffect, newEffect));
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
      case UmlParameterPackage.PARAMETER_RULE__TYPE:
        return basicSetType(null, msgs);
      case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
        return basicSetMultiplicity(null, msgs);
      case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
        return basicSetModifiers(null, msgs);
      case UmlParameterPackage.PARAMETER_RULE__EFFECT:
        return basicSetEffect(null, msgs);
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
      case UmlParameterPackage.PARAMETER_RULE__VISIBILITY:
        return getVisibility();
      case UmlParameterPackage.PARAMETER_RULE__DIRECTION:
        return getDirection();
      case UmlParameterPackage.PARAMETER_RULE__NAME:
        return getName();
      case UmlParameterPackage.PARAMETER_RULE__TYPE:
        return getType();
      case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
        return getMultiplicity();
      case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
        return getModifiers();
      case UmlParameterPackage.PARAMETER_RULE__EFFECT:
        return getEffect();
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
      case UmlParameterPackage.PARAMETER_RULE__VISIBILITY:
        setVisibility((VisibilityKind)newValue);
        return;
      case UmlParameterPackage.PARAMETER_RULE__DIRECTION:
        setDirection((Direction)newValue);
        return;
      case UmlParameterPackage.PARAMETER_RULE__NAME:
        setName((String)newValue);
        return;
      case UmlParameterPackage.PARAMETER_RULE__TYPE:
        setType((TypeRule)newValue);
        return;
      case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
        setMultiplicity((MultiplicityRule)newValue);
        return;
      case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
        setModifiers((ModifiersRule)newValue);
        return;
      case UmlParameterPackage.PARAMETER_RULE__EFFECT:
        setEffect((EffectRule)newValue);
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
      case UmlParameterPackage.PARAMETER_RULE__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case UmlParameterPackage.PARAMETER_RULE__DIRECTION:
        setDirection(DIRECTION_EDEFAULT);
        return;
      case UmlParameterPackage.PARAMETER_RULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UmlParameterPackage.PARAMETER_RULE__TYPE:
        setType((TypeRule)null);
        return;
      case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
        setMultiplicity((MultiplicityRule)null);
        return;
      case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
        setModifiers((ModifiersRule)null);
        return;
      case UmlParameterPackage.PARAMETER_RULE__EFFECT:
        setEffect((EffectRule)null);
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
      case UmlParameterPackage.PARAMETER_RULE__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case UmlParameterPackage.PARAMETER_RULE__DIRECTION:
        return direction != DIRECTION_EDEFAULT;
      case UmlParameterPackage.PARAMETER_RULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmlParameterPackage.PARAMETER_RULE__TYPE:
        return type != null;
      case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
        return multiplicity != null;
      case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
        return modifiers != null;
      case UmlParameterPackage.PARAMETER_RULE__EFFECT:
        return effect != null;
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
    result.append(", direction: ");
    result.append(direction);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ParameterRuleImpl
