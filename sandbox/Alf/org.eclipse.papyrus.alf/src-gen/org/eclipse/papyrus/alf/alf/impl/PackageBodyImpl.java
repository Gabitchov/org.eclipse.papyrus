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
import org.eclipse.papyrus.alf.alf.PackageBody;
import org.eclipse.papyrus.alf.alf.PackagedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PackageBodyImpl#getPackagedElement <em>Packaged Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageBodyImpl extends MinimalEObjectImpl.Container implements PackageBody
{
  /**
   * The cached value of the '{@link #getPackagedElement() <em>Packaged Element</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackagedElement()
   * @generated
   * @ordered
   */
  protected EList<PackagedElement> packagedElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackageBodyImpl()
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
    return AlfPackage.eINSTANCE.getPackageBody();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PackagedElement> getPackagedElement()
  {
    if (packagedElement == null)
    {
      packagedElement = new EObjectContainmentEList<PackagedElement>(PackagedElement.class, this, AlfPackage.PACKAGE_BODY__PACKAGED_ELEMENT);
    }
    return packagedElement;
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
      case AlfPackage.PACKAGE_BODY__PACKAGED_ELEMENT:
        return ((InternalEList<?>)getPackagedElement()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.PACKAGE_BODY__PACKAGED_ELEMENT:
        return getPackagedElement();
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
      case AlfPackage.PACKAGE_BODY__PACKAGED_ELEMENT:
        getPackagedElement().clear();
        getPackagedElement().addAll((Collection<? extends PackagedElement>)newValue);
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
      case AlfPackage.PACKAGE_BODY__PACKAGED_ELEMENT:
        getPackagedElement().clear();
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
      case AlfPackage.PACKAGE_BODY__PACKAGED_ELEMENT:
        return packagedElement != null && !packagedElement.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PackageBodyImpl
