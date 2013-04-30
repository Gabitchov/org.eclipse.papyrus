/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.SequenceElement;
import org.eclipse.papyrus.alf.alf.SequenceElementListCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Element List Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceElementListCompletionImpl#getSequenceElement <em>Sequence Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceElementListCompletionImpl extends MinimalEObjectImpl.Container implements SequenceElementListCompletion
{
  /**
   * The cached value of the '{@link #getSequenceElement() <em>Sequence Element</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceElement()
   * @generated
   * @ordered
   */
  protected EList<SequenceElement> sequenceElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequenceElementListCompletionImpl()
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
    return AlfPackage.eINSTANCE.getSequenceElementListCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SequenceElement> getSequenceElement()
  {
    if (sequenceElement == null)
    {
      sequenceElement = new EObjectContainmentEList<SequenceElement>(SequenceElement.class, this, AlfPackage.SEQUENCE_ELEMENT_LIST_COMPLETION__SEQUENCE_ELEMENT);
    }
    return sequenceElement;
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
      case AlfPackage.SEQUENCE_ELEMENT_LIST_COMPLETION__SEQUENCE_ELEMENT:
        return ((InternalEList<?>)getSequenceElement()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.SEQUENCE_ELEMENT_LIST_COMPLETION__SEQUENCE_ELEMENT:
        return getSequenceElement();
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
      case AlfPackage.SEQUENCE_ELEMENT_LIST_COMPLETION__SEQUENCE_ELEMENT:
        getSequenceElement().clear();
        getSequenceElement().addAll((Collection<? extends SequenceElement>)newValue);
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
      case AlfPackage.SEQUENCE_ELEMENT_LIST_COMPLETION__SEQUENCE_ELEMENT:
        getSequenceElement().clear();
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
      case AlfPackage.SEQUENCE_ELEMENT_LIST_COMPLETION__SEQUENCE_ELEMENT:
        return sequenceElement != null && !sequenceElement.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SequenceElementListCompletionImpl
