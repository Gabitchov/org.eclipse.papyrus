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
import org.eclipse.papyrus.alf.alf.NamedTemplateBinding;
import org.eclipse.papyrus.alf.alf.TemplateParameterSubstitution;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Template Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NamedTemplateBindingImpl#getTemplateParameterSubstitution <em>Template Parameter Substitution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedTemplateBindingImpl extends TemplateBindingImpl implements NamedTemplateBinding
{
  /**
   * The cached value of the '{@link #getTemplateParameterSubstitution() <em>Template Parameter Substitution</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateParameterSubstitution()
   * @generated
   * @ordered
   */
  protected EList<TemplateParameterSubstitution> templateParameterSubstitution;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedTemplateBindingImpl()
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
    return AlfPackage.eINSTANCE.getNamedTemplateBinding();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TemplateParameterSubstitution> getTemplateParameterSubstitution()
  {
    if (templateParameterSubstitution == null)
    {
      templateParameterSubstitution = new EObjectContainmentEList<TemplateParameterSubstitution>(TemplateParameterSubstitution.class, this, AlfPackage.NAMED_TEMPLATE_BINDING__TEMPLATE_PARAMETER_SUBSTITUTION);
    }
    return templateParameterSubstitution;
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
      case AlfPackage.NAMED_TEMPLATE_BINDING__TEMPLATE_PARAMETER_SUBSTITUTION:
        return ((InternalEList<?>)getTemplateParameterSubstitution()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.NAMED_TEMPLATE_BINDING__TEMPLATE_PARAMETER_SUBSTITUTION:
        return getTemplateParameterSubstitution();
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
      case AlfPackage.NAMED_TEMPLATE_BINDING__TEMPLATE_PARAMETER_SUBSTITUTION:
        getTemplateParameterSubstitution().clear();
        getTemplateParameterSubstitution().addAll((Collection<? extends TemplateParameterSubstitution>)newValue);
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
      case AlfPackage.NAMED_TEMPLATE_BINDING__TEMPLATE_PARAMETER_SUBSTITUTION:
        getTemplateParameterSubstitution().clear();
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
      case AlfPackage.NAMED_TEMPLATE_BINDING__TEMPLATE_PARAMETER_SUBSTITUTION:
        return templateParameterSubstitution != null && !templateParameterSubstitution.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //NamedTemplateBindingImpl
