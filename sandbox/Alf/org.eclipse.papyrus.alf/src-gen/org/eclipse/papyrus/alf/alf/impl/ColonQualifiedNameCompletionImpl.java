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
import org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletion;
import org.eclipse.papyrus.alf.alf.NameBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Colon Qualified Name Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ColonQualifiedNameCompletionImpl#getNamedBindings <em>Named Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColonQualifiedNameCompletionImpl extends MinimalEObjectImpl.Container implements ColonQualifiedNameCompletion
{
  /**
   * The cached value of the '{@link #getNamedBindings() <em>Named Bindings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedBindings()
   * @generated
   * @ordered
   */
  protected EList<NameBinding> namedBindings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ColonQualifiedNameCompletionImpl()
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
    return AlfPackage.eINSTANCE.getColonQualifiedNameCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NameBinding> getNamedBindings()
  {
    if (namedBindings == null)
    {
      namedBindings = new EObjectContainmentEList<NameBinding>(NameBinding.class, this, AlfPackage.COLON_QUALIFIED_NAME_COMPLETION__NAMED_BINDINGS);
    }
    return namedBindings;
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION__NAMED_BINDINGS:
        return ((InternalEList<?>)getNamedBindings()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION__NAMED_BINDINGS:
        return getNamedBindings();
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION__NAMED_BINDINGS:
        getNamedBindings().clear();
        getNamedBindings().addAll((Collection<? extends NameBinding>)newValue);
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION__NAMED_BINDINGS:
        getNamedBindings().clear();
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION__NAMED_BINDINGS:
        return namedBindings != null && !namedBindings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ColonQualifiedNameCompletionImpl
