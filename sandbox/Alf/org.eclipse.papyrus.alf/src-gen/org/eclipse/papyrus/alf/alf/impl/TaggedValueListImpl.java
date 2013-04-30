/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.TaggedValue;
import org.eclipse.papyrus.alf.alf.TaggedValueList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Value List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.TaggedValueListImpl#getTaggedValue <em>Tagged Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaggedValueListImpl extends TaggedValuesImpl implements TaggedValueList
{
  /**
   * The cached value of the '{@link #getTaggedValue() <em>Tagged Value</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaggedValue()
   * @generated
   * @ordered
   */
  protected EList<TaggedValue> taggedValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TaggedValueListImpl()
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
    return AlfPackage.eINSTANCE.getTaggedValueList();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TaggedValue> getTaggedValue()
  {
    if (taggedValue == null)
    {
      taggedValue = new EObjectContainmentEList<TaggedValue>(TaggedValue.class, this, AlfPackage.TAGGED_VALUE_LIST__TAGGED_VALUE);
    }
    return taggedValue;
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
      case AlfPackage.TAGGED_VALUE_LIST__TAGGED_VALUE:
        return ((InternalEList<?>)getTaggedValue()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.TAGGED_VALUE_LIST__TAGGED_VALUE:
        return getTaggedValue();
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
      case AlfPackage.TAGGED_VALUE_LIST__TAGGED_VALUE:
        getTaggedValue().clear();
        getTaggedValue().addAll((Collection<? extends TaggedValue>)newValue);
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
      case AlfPackage.TAGGED_VALUE_LIST__TAGGED_VALUE:
        getTaggedValue().clear();
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
      case AlfPackage.TAGGED_VALUE_LIST__TAGGED_VALUE:
        return taggedValue != null && !taggedValue.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TaggedValueListImpl
