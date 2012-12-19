/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Parameter List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParameterListImpl#getFormalParameter <em>Formal Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormalParameterListImpl extends MinimalEObjectImpl.Container implements FormalParameterList
{
  /**
   * The cached value of the '{@link #getFormalParameter() <em>Formal Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParameter()
   * @generated
   * @ordered
   */
  protected EList<FormalParameter> formalParameter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FormalParameterListImpl()
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
    return OperationPackage.Literals.FORMAL_PARAMETER_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FormalParameter> getFormalParameter()
  {
    if (formalParameter == null)
    {
      formalParameter = new EObjectContainmentEList<FormalParameter>(FormalParameter.class, this, OperationPackage.FORMAL_PARAMETER_LIST__FORMAL_PARAMETER);
    }
    return formalParameter;
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
      case OperationPackage.FORMAL_PARAMETER_LIST__FORMAL_PARAMETER:
        return ((InternalEList<?>)getFormalParameter()).basicRemove(otherEnd, msgs);
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
      case OperationPackage.FORMAL_PARAMETER_LIST__FORMAL_PARAMETER:
        return getFormalParameter();
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
      case OperationPackage.FORMAL_PARAMETER_LIST__FORMAL_PARAMETER:
        getFormalParameter().clear();
        getFormalParameter().addAll((Collection<? extends FormalParameter>)newValue);
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
      case OperationPackage.FORMAL_PARAMETER_LIST__FORMAL_PARAMETER:
        getFormalParameter().clear();
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
      case OperationPackage.FORMAL_PARAMETER_LIST__FORMAL_PARAMETER:
        return formalParameter != null && !formalParameter.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FormalParameterListImpl
