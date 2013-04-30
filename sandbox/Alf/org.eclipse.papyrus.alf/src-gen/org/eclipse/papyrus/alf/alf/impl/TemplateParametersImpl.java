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
import org.eclipse.papyrus.alf.alf.ClassifierTemplateParameter;
import org.eclipse.papyrus.alf.alf.TemplateParameters;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.TemplateParametersImpl#getClassifierTemplateParameter <em>Classifier Template Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateParametersImpl extends MinimalEObjectImpl.Container implements TemplateParameters
{
  /**
   * The cached value of the '{@link #getClassifierTemplateParameter() <em>Classifier Template Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifierTemplateParameter()
   * @generated
   * @ordered
   */
  protected EList<ClassifierTemplateParameter> classifierTemplateParameter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TemplateParametersImpl()
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
    return AlfPackage.eINSTANCE.getTemplateParameters();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClassifierTemplateParameter> getClassifierTemplateParameter()
  {
    if (classifierTemplateParameter == null)
    {
      classifierTemplateParameter = new EObjectContainmentEList<ClassifierTemplateParameter>(ClassifierTemplateParameter.class, this, AlfPackage.TEMPLATE_PARAMETERS__CLASSIFIER_TEMPLATE_PARAMETER);
    }
    return classifierTemplateParameter;
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
      case AlfPackage.TEMPLATE_PARAMETERS__CLASSIFIER_TEMPLATE_PARAMETER:
        return ((InternalEList<?>)getClassifierTemplateParameter()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.TEMPLATE_PARAMETERS__CLASSIFIER_TEMPLATE_PARAMETER:
        return getClassifierTemplateParameter();
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
      case AlfPackage.TEMPLATE_PARAMETERS__CLASSIFIER_TEMPLATE_PARAMETER:
        getClassifierTemplateParameter().clear();
        getClassifierTemplateParameter().addAll((Collection<? extends ClassifierTemplateParameter>)newValue);
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
      case AlfPackage.TEMPLATE_PARAMETERS__CLASSIFIER_TEMPLATE_PARAMETER:
        getClassifierTemplateParameter().clear();
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
      case AlfPackage.TEMPLATE_PARAMETERS__CLASSIFIER_TEMPLATE_PARAMETER:
        return classifierTemplateParameter != null && !classifierTemplateParameter.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TemplateParametersImpl
