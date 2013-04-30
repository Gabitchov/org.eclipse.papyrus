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
import org.eclipse.papyrus.alf.alf.StructuredBody;
import org.eclipse.papyrus.alf.alf.StructuredMember;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structured Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.StructuredBodyImpl#getStructuredMember <em>Structured Member</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructuredBodyImpl extends MinimalEObjectImpl.Container implements StructuredBody
{
  /**
   * The cached value of the '{@link #getStructuredMember() <em>Structured Member</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructuredMember()
   * @generated
   * @ordered
   */
  protected EList<StructuredMember> structuredMember;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructuredBodyImpl()
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
    return AlfPackage.eINSTANCE.getStructuredBody();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StructuredMember> getStructuredMember()
  {
    if (structuredMember == null)
    {
      structuredMember = new EObjectContainmentEList<StructuredMember>(StructuredMember.class, this, AlfPackage.STRUCTURED_BODY__STRUCTURED_MEMBER);
    }
    return structuredMember;
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
      case AlfPackage.STRUCTURED_BODY__STRUCTURED_MEMBER:
        return ((InternalEList<?>)getStructuredMember()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.STRUCTURED_BODY__STRUCTURED_MEMBER:
        return getStructuredMember();
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
      case AlfPackage.STRUCTURED_BODY__STRUCTURED_MEMBER:
        getStructuredMember().clear();
        getStructuredMember().addAll((Collection<? extends StructuredMember>)newValue);
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
      case AlfPackage.STRUCTURED_BODY__STRUCTURED_MEMBER:
        getStructuredMember().clear();
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
      case AlfPackage.STRUCTURED_BODY__STRUCTURED_MEMBER:
        return structuredMember != null && !structuredMember.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StructuredBodyImpl
