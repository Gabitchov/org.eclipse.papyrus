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
import org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionWithoutBinding;
import org.eclipse.papyrus.alf.alf.Name;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Colon Qualified Name Completion Without Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ColonQualifiedNameCompletionWithoutBindingImpl#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColonQualifiedNameCompletionWithoutBindingImpl extends MinimalEObjectImpl.Container implements ColonQualifiedNameCompletionWithoutBinding
{
  /**
   * The cached value of the '{@link #getNames() <em>Names</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNames()
   * @generated
   * @ordered
   */
  protected EList<Name> names;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ColonQualifiedNameCompletionWithoutBindingImpl()
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
    return AlfPackage.eINSTANCE.getColonQualifiedNameCompletionWithoutBinding();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Name> getNames()
  {
    if (names == null)
    {
      names = new EObjectContainmentEList<Name>(Name.class, this, AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_WITHOUT_BINDING__NAMES);
    }
    return names;
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_WITHOUT_BINDING__NAMES:
        return ((InternalEList<?>)getNames()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_WITHOUT_BINDING__NAMES:
        return getNames();
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_WITHOUT_BINDING__NAMES:
        getNames().clear();
        getNames().addAll((Collection<? extends Name>)newValue);
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_WITHOUT_BINDING__NAMES:
        getNames().clear();
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_WITHOUT_BINDING__NAMES:
        return names != null && !names.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ColonQualifiedNameCompletionWithoutBindingImpl
