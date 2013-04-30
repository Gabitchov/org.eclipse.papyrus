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
import org.eclipse.papyrus.alf.alf.PositionalTemplateBinding;
import org.eclipse.papyrus.alf.alf.QualifiedName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Positional Template Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PositionalTemplateBindingImpl#getQualifiedName <em>Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PositionalTemplateBindingImpl extends TemplateBindingImpl implements PositionalTemplateBinding
{
  /**
   * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedName()
   * @generated
   * @ordered
   */
  protected EList<QualifiedName> qualifiedName;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PositionalTemplateBindingImpl()
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
    return AlfPackage.eINSTANCE.getPositionalTemplateBinding();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<QualifiedName> getQualifiedName()
  {
    if (qualifiedName == null)
    {
      qualifiedName = new EObjectContainmentEList<QualifiedName>(QualifiedName.class, this, AlfPackage.POSITIONAL_TEMPLATE_BINDING__QUALIFIED_NAME);
    }
    return qualifiedName;
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
      case AlfPackage.POSITIONAL_TEMPLATE_BINDING__QUALIFIED_NAME:
        return ((InternalEList<?>)getQualifiedName()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.POSITIONAL_TEMPLATE_BINDING__QUALIFIED_NAME:
        return getQualifiedName();
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
      case AlfPackage.POSITIONAL_TEMPLATE_BINDING__QUALIFIED_NAME:
        getQualifiedName().clear();
        getQualifiedName().addAll((Collection<? extends QualifiedName>)newValue);
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
      case AlfPackage.POSITIONAL_TEMPLATE_BINDING__QUALIFIED_NAME:
        getQualifiedName().clear();
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
      case AlfPackage.POSITIONAL_TEMPLATE_BINDING__QUALIFIED_NAME:
        return qualifiedName != null && !qualifiedName.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PositionalTemplateBindingImpl
