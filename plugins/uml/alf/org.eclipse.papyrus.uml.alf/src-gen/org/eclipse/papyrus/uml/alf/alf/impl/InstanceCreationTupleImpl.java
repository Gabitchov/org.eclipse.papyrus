/**
 */
package org.eclipse.papyrus.uml.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationTuple;
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationTupleElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Creation Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.InstanceCreationTupleImpl#getInstanceCreationTupleElement <em>Instance Creation Tuple Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceCreationTupleImpl extends MinimalEObjectImpl.Container implements InstanceCreationTuple
{
  /**
   * The cached value of the '{@link #getInstanceCreationTupleElement() <em>Instance Creation Tuple Element</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstanceCreationTupleElement()
   * @generated
   * @ordered
   */
  protected EList<InstanceCreationTupleElement> instanceCreationTupleElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InstanceCreationTupleImpl()
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
    return AlfPackage.Literals.INSTANCE_CREATION_TUPLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InstanceCreationTupleElement> getInstanceCreationTupleElement()
  {
    if (instanceCreationTupleElement == null)
    {
      instanceCreationTupleElement = new EObjectContainmentEList<InstanceCreationTupleElement>(InstanceCreationTupleElement.class, this, AlfPackage.INSTANCE_CREATION_TUPLE__INSTANCE_CREATION_TUPLE_ELEMENT);
    }
    return instanceCreationTupleElement;
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
      case AlfPackage.INSTANCE_CREATION_TUPLE__INSTANCE_CREATION_TUPLE_ELEMENT:
        return ((InternalEList<?>)getInstanceCreationTupleElement()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.INSTANCE_CREATION_TUPLE__INSTANCE_CREATION_TUPLE_ELEMENT:
        return getInstanceCreationTupleElement();
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
      case AlfPackage.INSTANCE_CREATION_TUPLE__INSTANCE_CREATION_TUPLE_ELEMENT:
        getInstanceCreationTupleElement().clear();
        getInstanceCreationTupleElement().addAll((Collection<? extends InstanceCreationTupleElement>)newValue);
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
      case AlfPackage.INSTANCE_CREATION_TUPLE__INSTANCE_CREATION_TUPLE_ELEMENT:
        getInstanceCreationTupleElement().clear();
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
      case AlfPackage.INSTANCE_CREATION_TUPLE__INSTANCE_CREATION_TUPLE_ELEMENT:
        return instanceCreationTupleElement != null && !instanceCreationTupleElement.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InstanceCreationTupleImpl
