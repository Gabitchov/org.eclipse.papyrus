/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Of Value Name Pairs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ListOfValueNamePairsImpl#getValueNamePairs <em>Value Name Pairs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListOfValueNamePairsImpl extends MinimalEObjectImpl.Container implements ListOfValueNamePairs
{
  /**
   * The cached value of the '{@link #getValueNamePairs() <em>Value Name Pairs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueNamePairs()
   * @generated
   * @ordered
   */
  protected EList<ValueNamePair> valueNamePairs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ListOfValueNamePairsImpl()
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
    return VSLPackage.Literals.LIST_OF_VALUE_NAME_PAIRS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValueNamePair> getValueNamePairs()
  {
    if (valueNamePairs == null)
    {
      valueNamePairs = new EObjectContainmentEList<ValueNamePair>(ValueNamePair.class, this, VSLPackage.LIST_OF_VALUE_NAME_PAIRS__VALUE_NAME_PAIRS);
    }
    return valueNamePairs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getFilteredParentRule(final EClass filter)
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getFilteredParentRule(this, filter) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getExpectedType()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getExpectedType(this) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getContextElement()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getContextElement(this) ;
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
      case VSLPackage.LIST_OF_VALUE_NAME_PAIRS__VALUE_NAME_PAIRS:
        return ((InternalEList<?>)getValueNamePairs()).basicRemove(otherEnd, msgs);
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
      case VSLPackage.LIST_OF_VALUE_NAME_PAIRS__VALUE_NAME_PAIRS:
        return getValueNamePairs();
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
      case VSLPackage.LIST_OF_VALUE_NAME_PAIRS__VALUE_NAME_PAIRS:
        getValueNamePairs().clear();
        getValueNamePairs().addAll((Collection<? extends ValueNamePair>)newValue);
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
      case VSLPackage.LIST_OF_VALUE_NAME_PAIRS__VALUE_NAME_PAIRS:
        getValueNamePairs().clear();
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
      case VSLPackage.LIST_OF_VALUE_NAME_PAIRS__VALUE_NAME_PAIRS:
        return valueNamePairs != null && !valueNamePairs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ListOfValueNamePairsImpl
