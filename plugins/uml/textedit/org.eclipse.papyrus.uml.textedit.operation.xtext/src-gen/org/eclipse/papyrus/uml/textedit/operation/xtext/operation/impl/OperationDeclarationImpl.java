/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl#isIsConstructor <em>Is Constructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl#isIsDestructor <em>Is Destructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl#getVisibilityIndicator <em>Visibility Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDeclarationImpl#getRedefinition <em>Redefinition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationDeclarationImpl extends MinimalEObjectImpl.Container implements OperationDeclaration
{
  /**
   * The default value of the '{@link #isIsConstructor() <em>Is Constructor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsConstructor()
   * @generated
   * @ordered
   */
  protected static final boolean IS_CONSTRUCTOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsConstructor() <em>Is Constructor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsConstructor()
   * @generated
   * @ordered
   */
  protected boolean isConstructor = IS_CONSTRUCTOR_EDEFAULT;

  /**
   * The default value of the '{@link #isIsDestructor() <em>Is Destructor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsDestructor()
   * @generated
   * @ordered
   */
  protected static final boolean IS_DESTRUCTOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsDestructor() <em>Is Destructor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsDestructor()
   * @generated
   * @ordered
   */
  protected boolean isDestructor = IS_DESTRUCTOR_EDEFAULT;

  /**
   * The default value of the '{@link #getVisibilityIndicator() <em>Visibility Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibilityIndicator()
   * @generated
   * @ordered
   */
  protected static final VisibilityIndicator VISIBILITY_INDICATOR_EDEFAULT = VisibilityIndicator.PUBLIC;

  /**
   * The cached value of the '{@link #getVisibilityIndicator() <em>Visibility Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibilityIndicator()
   * @generated
   * @ordered
   */
  protected VisibilityIndicator visibilityIndicator = VISIBILITY_INDICATOR_EDEFAULT;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getFormalParameters() <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParameters()
   * @generated
   * @ordered
   */
  protected FormalParameters formalParameters;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected TypePart returnType;

  /**
   * The cached value of the '{@link #getRedefinition() <em>Redefinition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedefinition()
   * @generated
   * @ordered
   */
  protected RedefinitionClause redefinition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationDeclarationImpl()
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
    return OperationPackage.Literals.OPERATION_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsConstructor()
  {
    return isConstructor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsConstructor(boolean newIsConstructor)
  {
    boolean oldIsConstructor = isConstructor;
    isConstructor = newIsConstructor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__IS_CONSTRUCTOR, oldIsConstructor, isConstructor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsDestructor()
  {
    return isDestructor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsDestructor(boolean newIsDestructor)
  {
    boolean oldIsDestructor = isDestructor;
    isDestructor = newIsDestructor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__IS_DESTRUCTOR, oldIsDestructor, isDestructor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VisibilityIndicator getVisibilityIndicator()
  {
    return visibilityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibilityIndicator(VisibilityIndicator newVisibilityIndicator)
  {
    VisibilityIndicator oldVisibilityIndicator = visibilityIndicator;
    visibilityIndicator = newVisibilityIndicator == null ? VISIBILITY_INDICATOR_EDEFAULT : newVisibilityIndicator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__VISIBILITY_INDICATOR, oldVisibilityIndicator, visibilityIndicator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameters getFormalParameters()
  {
    return formalParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFormalParameters(FormalParameters newFormalParameters, NotificationChain msgs)
  {
    FormalParameters oldFormalParameters = formalParameters;
    formalParameters = newFormalParameters;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS, oldFormalParameters, newFormalParameters);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormalParameters(FormalParameters newFormalParameters)
  {
    if (newFormalParameters != formalParameters)
    {
      NotificationChain msgs = null;
      if (formalParameters != null)
        msgs = ((InternalEObject)formalParameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS, null, msgs);
      if (newFormalParameters != null)
        msgs = ((InternalEObject)newFormalParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS, null, msgs);
      msgs = basicSetFormalParameters(newFormalParameters, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS, newFormalParameters, newFormalParameters));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePart getReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturnType(TypePart newReturnType, NotificationChain msgs)
  {
    TypePart oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__RETURN_TYPE, oldReturnType, newReturnType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(TypePart newReturnType)
  {
    if (newReturnType != returnType)
    {
      NotificationChain msgs = null;
      if (returnType != null)
        msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DECLARATION__RETURN_TYPE, null, msgs);
      if (newReturnType != null)
        msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DECLARATION__RETURN_TYPE, null, msgs);
      msgs = basicSetReturnType(newReturnType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__RETURN_TYPE, newReturnType, newReturnType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinitionClause getRedefinition()
  {
    return redefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRedefinition(RedefinitionClause newRedefinition, NotificationChain msgs)
  {
    RedefinitionClause oldRedefinition = redefinition;
    redefinition = newRedefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__REDEFINITION, oldRedefinition, newRedefinition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedefinition(RedefinitionClause newRedefinition)
  {
    if (newRedefinition != redefinition)
    {
      NotificationChain msgs = null;
      if (redefinition != null)
        msgs = ((InternalEObject)redefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DECLARATION__REDEFINITION, null, msgs);
      if (newRedefinition != null)
        msgs = ((InternalEObject)newRedefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DECLARATION__REDEFINITION, null, msgs);
      msgs = basicSetRedefinition(newRedefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DECLARATION__REDEFINITION, newRedefinition, newRedefinition));
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
      case OperationPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        return basicSetFormalParameters(null, msgs);
      case OperationPackage.OPERATION_DECLARATION__RETURN_TYPE:
        return basicSetReturnType(null, msgs);
      case OperationPackage.OPERATION_DECLARATION__REDEFINITION:
        return basicSetRedefinition(null, msgs);
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
      case OperationPackage.OPERATION_DECLARATION__IS_CONSTRUCTOR:
        return isIsConstructor();
      case OperationPackage.OPERATION_DECLARATION__IS_DESTRUCTOR:
        return isIsDestructor();
      case OperationPackage.OPERATION_DECLARATION__VISIBILITY_INDICATOR:
        return getVisibilityIndicator();
      case OperationPackage.OPERATION_DECLARATION__ABSTRACT:
        return isAbstract();
      case OperationPackage.OPERATION_DECLARATION__NAME:
        return getName();
      case OperationPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        return getFormalParameters();
      case OperationPackage.OPERATION_DECLARATION__RETURN_TYPE:
        return getReturnType();
      case OperationPackage.OPERATION_DECLARATION__REDEFINITION:
        return getRedefinition();
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
      case OperationPackage.OPERATION_DECLARATION__IS_CONSTRUCTOR:
        setIsConstructor((Boolean)newValue);
        return;
      case OperationPackage.OPERATION_DECLARATION__IS_DESTRUCTOR:
        setIsDestructor((Boolean)newValue);
        return;
      case OperationPackage.OPERATION_DECLARATION__VISIBILITY_INDICATOR:
        setVisibilityIndicator((VisibilityIndicator)newValue);
        return;
      case OperationPackage.OPERATION_DECLARATION__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case OperationPackage.OPERATION_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case OperationPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        setFormalParameters((FormalParameters)newValue);
        return;
      case OperationPackage.OPERATION_DECLARATION__RETURN_TYPE:
        setReturnType((TypePart)newValue);
        return;
      case OperationPackage.OPERATION_DECLARATION__REDEFINITION:
        setRedefinition((RedefinitionClause)newValue);
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
      case OperationPackage.OPERATION_DECLARATION__IS_CONSTRUCTOR:
        setIsConstructor(IS_CONSTRUCTOR_EDEFAULT);
        return;
      case OperationPackage.OPERATION_DECLARATION__IS_DESTRUCTOR:
        setIsDestructor(IS_DESTRUCTOR_EDEFAULT);
        return;
      case OperationPackage.OPERATION_DECLARATION__VISIBILITY_INDICATOR:
        setVisibilityIndicator(VISIBILITY_INDICATOR_EDEFAULT);
        return;
      case OperationPackage.OPERATION_DECLARATION__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case OperationPackage.OPERATION_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case OperationPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        setFormalParameters((FormalParameters)null);
        return;
      case OperationPackage.OPERATION_DECLARATION__RETURN_TYPE:
        setReturnType((TypePart)null);
        return;
      case OperationPackage.OPERATION_DECLARATION__REDEFINITION:
        setRedefinition((RedefinitionClause)null);
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
      case OperationPackage.OPERATION_DECLARATION__IS_CONSTRUCTOR:
        return isConstructor != IS_CONSTRUCTOR_EDEFAULT;
      case OperationPackage.OPERATION_DECLARATION__IS_DESTRUCTOR:
        return isDestructor != IS_DESTRUCTOR_EDEFAULT;
      case OperationPackage.OPERATION_DECLARATION__VISIBILITY_INDICATOR:
        return visibilityIndicator != VISIBILITY_INDICATOR_EDEFAULT;
      case OperationPackage.OPERATION_DECLARATION__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case OperationPackage.OPERATION_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case OperationPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        return formalParameters != null;
      case OperationPackage.OPERATION_DECLARATION__RETURN_TYPE:
        return returnType != null;
      case OperationPackage.OPERATION_DECLARATION__REDEFINITION:
        return redefinition != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (isConstructor: ");
    result.append(isConstructor);
    result.append(", isDestructor: ");
    result.append(isDestructor);
    result.append(", visibilityIndicator: ");
    result.append(visibilityIndicator);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //OperationDeclarationImpl
