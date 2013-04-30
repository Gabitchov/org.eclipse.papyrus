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
import org.eclipse.papyrus.alf.alf.EnumerationBody;
import org.eclipse.papyrus.alf.alf.EnumerationLiteralName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.EnumerationBodyImpl#getEnumerationLiteralName <em>Enumeration Literal Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationBodyImpl extends MinimalEObjectImpl.Container implements EnumerationBody
{
  /**
   * The cached value of the '{@link #getEnumerationLiteralName() <em>Enumeration Literal Name</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumerationLiteralName()
   * @generated
   * @ordered
   */
  protected EList<EnumerationLiteralName> enumerationLiteralName;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumerationBodyImpl()
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
    return AlfPackage.eINSTANCE.getEnumerationBody();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EnumerationLiteralName> getEnumerationLiteralName()
  {
    if (enumerationLiteralName == null)
    {
      enumerationLiteralName = new EObjectContainmentEList<EnumerationLiteralName>(EnumerationLiteralName.class, this, AlfPackage.ENUMERATION_BODY__ENUMERATION_LITERAL_NAME);
    }
    return enumerationLiteralName;
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
      case AlfPackage.ENUMERATION_BODY__ENUMERATION_LITERAL_NAME:
        return ((InternalEList<?>)getEnumerationLiteralName()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.ENUMERATION_BODY__ENUMERATION_LITERAL_NAME:
        return getEnumerationLiteralName();
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
      case AlfPackage.ENUMERATION_BODY__ENUMERATION_LITERAL_NAME:
        getEnumerationLiteralName().clear();
        getEnumerationLiteralName().addAll((Collection<? extends EnumerationLiteralName>)newValue);
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
      case AlfPackage.ENUMERATION_BODY__ENUMERATION_LITERAL_NAME:
        getEnumerationLiteralName().clear();
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
      case AlfPackage.ENUMERATION_BODY__ENUMERATION_LITERAL_NAME:
        return enumerationLiteralName != null && !enumerationLiteralName.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EnumerationBodyImpl
