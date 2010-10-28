/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.marte.vsl.vSL.Context;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.Import;
import org.eclipse.papyrus.marte.vsl.vSL.Model;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ModelImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ModelImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected Import imports;

  /**
   * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContext()
   * @generated
   * @ordered
   */
  protected Context context;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Expression value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return VSLPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import getImports()
  {
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImports(Import newImports, NotificationChain msgs)
  {
    Import oldImports = imports;
    imports = newImports;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.MODEL__IMPORTS, oldImports, newImports);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImports(Import newImports)
  {
    if (newImports != imports)
    {
      NotificationChain msgs = null;
      if (imports != null)
        msgs = ((InternalEObject)imports).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.MODEL__IMPORTS, null, msgs);
      if (newImports != null)
        msgs = ((InternalEObject)newImports).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.MODEL__IMPORTS, null, msgs);
      msgs = basicSetImports(newImports, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.MODEL__IMPORTS, newImports, newImports));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Context getContext()
  {
    return context;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContext(Context newContext, NotificationChain msgs)
  {
    Context oldContext = context;
    context = newContext;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.MODEL__CONTEXT, oldContext, newContext);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContext(Context newContext)
  {
    if (newContext != context)
    {
      NotificationChain msgs = null;
      if (context != null)
        msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.MODEL__CONTEXT, null, msgs);
      if (newContext != null)
        msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.MODEL__CONTEXT, null, msgs);
      msgs = basicSetContext(newContext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.MODEL__CONTEXT, newContext, newContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(Expression newValue, NotificationChain msgs)
  {
    Expression oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.MODEL__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Expression newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.MODEL__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.MODEL__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.MODEL__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getFilteredParentRule(EClass filter)
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getFilteredParentRule(this, filter) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getExpectedType()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getExpectedType(this) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getContextElement()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getContextElement(this) ;
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
      case VSLPackage.MODEL__IMPORTS:
        return basicSetImports(null, msgs);
      case VSLPackage.MODEL__CONTEXT:
        return basicSetContext(null, msgs);
      case VSLPackage.MODEL__VALUE:
        return basicSetValue(null, msgs);
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
      case VSLPackage.MODEL__IMPORTS:
        return getImports();
      case VSLPackage.MODEL__CONTEXT:
        return getContext();
      case VSLPackage.MODEL__VALUE:
        return getValue();
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
      case VSLPackage.MODEL__IMPORTS:
        setImports((Import)newValue);
        return;
      case VSLPackage.MODEL__CONTEXT:
        setContext((Context)newValue);
        return;
      case VSLPackage.MODEL__VALUE:
        setValue((Expression)newValue);
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
      case VSLPackage.MODEL__IMPORTS:
        setImports((Import)null);
        return;
      case VSLPackage.MODEL__CONTEXT:
        setContext((Context)null);
        return;
      case VSLPackage.MODEL__VALUE:
        setValue((Expression)null);
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
      case VSLPackage.MODEL__IMPORTS:
        return imports != null;
      case VSLPackage.MODEL__CONTEXT:
        return context != null;
      case VSLPackage.MODEL__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
