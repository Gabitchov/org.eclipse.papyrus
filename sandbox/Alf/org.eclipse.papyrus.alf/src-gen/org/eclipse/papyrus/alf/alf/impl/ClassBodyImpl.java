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
import org.eclipse.papyrus.alf.alf.ClassBody;
import org.eclipse.papyrus.alf.alf.ClassMember;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassBodyImpl#getClassMember <em>Class Member</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassBodyImpl extends MinimalEObjectImpl.Container implements ClassBody
{
  /**
   * The cached value of the '{@link #getClassMember() <em>Class Member</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassMember()
   * @generated
   * @ordered
   */
  protected EList<ClassMember> classMember;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassBodyImpl()
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
    return AlfPackage.eINSTANCE.getClassBody();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClassMember> getClassMember()
  {
    if (classMember == null)
    {
      classMember = new EObjectContainmentEList<ClassMember>(ClassMember.class, this, AlfPackage.CLASS_BODY__CLASS_MEMBER);
    }
    return classMember;
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
      case AlfPackage.CLASS_BODY__CLASS_MEMBER:
        return ((InternalEList<?>)getClassMember()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.CLASS_BODY__CLASS_MEMBER:
        return getClassMember();
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
      case AlfPackage.CLASS_BODY__CLASS_MEMBER:
        getClassMember().clear();
        getClassMember().addAll((Collection<? extends ClassMember>)newValue);
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
      case AlfPackage.CLASS_BODY__CLASS_MEMBER:
        getClassMember().clear();
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
      case AlfPackage.CLASS_BODY__CLASS_MEMBER:
        return classMember != null && !classMember.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ClassBodyImpl
