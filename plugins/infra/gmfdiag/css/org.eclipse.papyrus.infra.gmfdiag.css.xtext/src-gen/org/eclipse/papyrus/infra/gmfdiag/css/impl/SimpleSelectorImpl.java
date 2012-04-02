/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition;
import org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SimpleSelectorImpl#getElementName <em>Element Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.SimpleSelectorImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleSelectorImpl extends SelectorImpl implements SimpleSelector
{
  /**
   * The default value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementName()
   * @generated
   * @ordered
   */
  protected static final String ELEMENT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementName()
   * @generated
   * @ordered
   */
  protected String elementName = ELEMENT_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected EList<SelectorCondition> condition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleSelectorImpl()
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
    return CssPackage.Literals.SIMPLE_SELECTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElementName()
  {
    return elementName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElementName(String newElementName)
  {
    String oldElementName = elementName;
    elementName = newElementName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.SIMPLE_SELECTOR__ELEMENT_NAME, oldElementName, elementName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SelectorCondition> getCondition()
  {
    if (condition == null)
    {
      condition = new EObjectContainmentEList<SelectorCondition>(SelectorCondition.class, this, CssPackage.SIMPLE_SELECTOR__CONDITION);
    }
    return condition;
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
      case CssPackage.SIMPLE_SELECTOR__CONDITION:
        return ((InternalEList<?>)getCondition()).basicRemove(otherEnd, msgs);
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
      case CssPackage.SIMPLE_SELECTOR__ELEMENT_NAME:
        return getElementName();
      case CssPackage.SIMPLE_SELECTOR__CONDITION:
        return getCondition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CssPackage.SIMPLE_SELECTOR__ELEMENT_NAME:
        setElementName((String)newValue);
        return;
      case CssPackage.SIMPLE_SELECTOR__CONDITION:
        getCondition().clear();
        getCondition().addAll((Collection<? extends SelectorCondition>)newValue);
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
      case CssPackage.SIMPLE_SELECTOR__ELEMENT_NAME:
        setElementName(ELEMENT_NAME_EDEFAULT);
        return;
      case CssPackage.SIMPLE_SELECTOR__CONDITION:
        getCondition().clear();
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
      case CssPackage.SIMPLE_SELECTOR__ELEMENT_NAME:
        return ELEMENT_NAME_EDEFAULT == null ? elementName != null : !ELEMENT_NAME_EDEFAULT.equals(elementName);
      case CssPackage.SIMPLE_SELECTOR__CONDITION:
        return condition != null && !condition.isEmpty();
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
    result.append(" (elementName: ");
    result.append(elementName);
    result.append(')');
    return result.toString();
  }

} //SimpleSelectorImpl
