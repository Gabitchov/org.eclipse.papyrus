/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Applications Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationsRuleImpl#getStereotypeApplications <em>Stereotype Applications</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypeApplicationsRuleImpl extends MinimalEObjectImpl.Container implements StereotypeApplicationsRule
{
  /**
   * The cached value of the '{@link #getStereotypeApplications() <em>Stereotype Applications</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotypeApplications()
   * @generated
   * @ordered
   */
  protected EList<StereotypeApplicationRule> stereotypeApplications;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StereotypeApplicationsRuleImpl()
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
    return StereotypeApplicationWithVSLPackage.Literals.STEREOTYPE_APPLICATIONS_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StereotypeApplicationRule> getStereotypeApplications()
  {
    if (stereotypeApplications == null)
    {
      stereotypeApplications = new EObjectContainmentEList<StereotypeApplicationRule>(StereotypeApplicationRule.class, this, StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATIONS_RULE__STEREOTYPE_APPLICATIONS);
    }
    return stereotypeApplications;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getExpectedType()
  {
    return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation.ContextUtil.getExpectedType(this) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getContextElement()
  {
    return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation.ContextUtil.getContextElement(this) ;
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
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATIONS_RULE__STEREOTYPE_APPLICATIONS:
        return ((InternalEList<?>)getStereotypeApplications()).basicRemove(otherEnd, msgs);
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
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATIONS_RULE__STEREOTYPE_APPLICATIONS:
        return getStereotypeApplications();
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
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATIONS_RULE__STEREOTYPE_APPLICATIONS:
        getStereotypeApplications().clear();
        getStereotypeApplications().addAll((Collection<? extends StereotypeApplicationRule>)newValue);
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
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATIONS_RULE__STEREOTYPE_APPLICATIONS:
        getStereotypeApplications().clear();
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
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATIONS_RULE__STEREOTYPE_APPLICATIONS:
        return stereotypeApplications != null && !stereotypeApplications.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StereotypeApplicationsRuleImpl
