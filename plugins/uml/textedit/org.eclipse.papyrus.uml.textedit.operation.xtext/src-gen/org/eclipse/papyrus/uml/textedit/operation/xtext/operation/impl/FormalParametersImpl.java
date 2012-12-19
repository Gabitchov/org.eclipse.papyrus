/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Parameters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.FormalParametersImpl#getFormalParameterList <em>Formal Parameter List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormalParametersImpl extends MinimalEObjectImpl.Container implements FormalParameters
{
  /**
   * The cached value of the '{@link #getFormalParameterList() <em>Formal Parameter List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParameterList()
   * @generated
   * @ordered
   */
  protected FormalParameterList formalParameterList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FormalParametersImpl()
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
    return OperationPackage.Literals.FORMAL_PARAMETERS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameterList getFormalParameterList()
  {
    return formalParameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFormalParameterList(FormalParameterList newFormalParameterList, NotificationChain msgs)
  {
    FormalParameterList oldFormalParameterList = formalParameterList;
    formalParameterList = newFormalParameterList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST, oldFormalParameterList, newFormalParameterList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormalParameterList(FormalParameterList newFormalParameterList)
  {
    if (newFormalParameterList != formalParameterList)
    {
      NotificationChain msgs = null;
      if (formalParameterList != null)
        msgs = ((InternalEObject)formalParameterList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST, null, msgs);
      if (newFormalParameterList != null)
        msgs = ((InternalEObject)newFormalParameterList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST, null, msgs);
      msgs = basicSetFormalParameterList(newFormalParameterList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST, newFormalParameterList, newFormalParameterList));
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
      case OperationPackage.FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST:
        return basicSetFormalParameterList(null, msgs);
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
      case OperationPackage.FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST:
        return getFormalParameterList();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case OperationPackage.FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST:
        setFormalParameterList((FormalParameterList)newValue);
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
      case OperationPackage.FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST:
        setFormalParameterList((FormalParameterList)null);
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
      case OperationPackage.FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST:
        return formalParameterList != null;
    }
    return super.eIsSet(featureID);
  }

} //FormalParametersImpl
