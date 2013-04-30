/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.ActivityDeclaration;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.FormalParameters;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.TemplateParameters;
import org.eclipse.papyrus.alf.alf.TypePart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActivityDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActivityDeclarationImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActivityDeclarationImpl#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActivityDeclarationImpl#getTypePart <em>Type Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityDeclarationImpl extends MinimalEObjectImpl.Container implements ActivityDeclaration
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Name name;

  /**
   * The cached value of the '{@link #getTemplateParameters() <em>Template Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateParameters()
   * @generated
   * @ordered
   */
  protected TemplateParameters templateParameters;

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
   * The cached value of the '{@link #getTypePart() <em>Type Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypePart()
   * @generated
   * @ordered
   */
  protected TypePart typePart;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActivityDeclarationImpl()
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
    return AlfPackage.eINSTANCE.getActivityDeclaration();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(Name newName, NotificationChain msgs)
  {
    Name oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DECLARATION__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(Name newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DECLARATION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DECLARATION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DECLARATION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateParameters getTemplateParameters()
  {
    return templateParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTemplateParameters(TemplateParameters newTemplateParameters, NotificationChain msgs)
  {
    TemplateParameters oldTemplateParameters = templateParameters;
    templateParameters = newTemplateParameters;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DECLARATION__TEMPLATE_PARAMETERS, oldTemplateParameters, newTemplateParameters);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemplateParameters(TemplateParameters newTemplateParameters)
  {
    if (newTemplateParameters != templateParameters)
    {
      NotificationChain msgs = null;
      if (templateParameters != null)
        msgs = ((InternalEObject)templateParameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DECLARATION__TEMPLATE_PARAMETERS, null, msgs);
      if (newTemplateParameters != null)
        msgs = ((InternalEObject)newTemplateParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DECLARATION__TEMPLATE_PARAMETERS, null, msgs);
      msgs = basicSetTemplateParameters(newTemplateParameters, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DECLARATION__TEMPLATE_PARAMETERS, newTemplateParameters, newTemplateParameters));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DECLARATION__FORMAL_PARAMETERS, oldFormalParameters, newFormalParameters);
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
        msgs = ((InternalEObject)formalParameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DECLARATION__FORMAL_PARAMETERS, null, msgs);
      if (newFormalParameters != null)
        msgs = ((InternalEObject)newFormalParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DECLARATION__FORMAL_PARAMETERS, null, msgs);
      msgs = basicSetFormalParameters(newFormalParameters, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DECLARATION__FORMAL_PARAMETERS, newFormalParameters, newFormalParameters));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePart getTypePart()
  {
    return typePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypePart(TypePart newTypePart, NotificationChain msgs)
  {
    TypePart oldTypePart = typePart;
    typePart = newTypePart;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DECLARATION__TYPE_PART, oldTypePart, newTypePart);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypePart(TypePart newTypePart)
  {
    if (newTypePart != typePart)
    {
      NotificationChain msgs = null;
      if (typePart != null)
        msgs = ((InternalEObject)typePart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DECLARATION__TYPE_PART, null, msgs);
      if (newTypePart != null)
        msgs = ((InternalEObject)newTypePart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DECLARATION__TYPE_PART, null, msgs);
      msgs = basicSetTypePart(newTypePart, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DECLARATION__TYPE_PART, newTypePart, newTypePart));
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
      case AlfPackage.ACTIVITY_DECLARATION__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.ACTIVITY_DECLARATION__TEMPLATE_PARAMETERS:
        return basicSetTemplateParameters(null, msgs);
      case AlfPackage.ACTIVITY_DECLARATION__FORMAL_PARAMETERS:
        return basicSetFormalParameters(null, msgs);
      case AlfPackage.ACTIVITY_DECLARATION__TYPE_PART:
        return basicSetTypePart(null, msgs);
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
      case AlfPackage.ACTIVITY_DECLARATION__NAME:
        return getName();
      case AlfPackage.ACTIVITY_DECLARATION__TEMPLATE_PARAMETERS:
        return getTemplateParameters();
      case AlfPackage.ACTIVITY_DECLARATION__FORMAL_PARAMETERS:
        return getFormalParameters();
      case AlfPackage.ACTIVITY_DECLARATION__TYPE_PART:
        return getTypePart();
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
      case AlfPackage.ACTIVITY_DECLARATION__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.ACTIVITY_DECLARATION__TEMPLATE_PARAMETERS:
        setTemplateParameters((TemplateParameters)newValue);
        return;
      case AlfPackage.ACTIVITY_DECLARATION__FORMAL_PARAMETERS:
        setFormalParameters((FormalParameters)newValue);
        return;
      case AlfPackage.ACTIVITY_DECLARATION__TYPE_PART:
        setTypePart((TypePart)newValue);
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
      case AlfPackage.ACTIVITY_DECLARATION__NAME:
        setName((Name)null);
        return;
      case AlfPackage.ACTIVITY_DECLARATION__TEMPLATE_PARAMETERS:
        setTemplateParameters((TemplateParameters)null);
        return;
      case AlfPackage.ACTIVITY_DECLARATION__FORMAL_PARAMETERS:
        setFormalParameters((FormalParameters)null);
        return;
      case AlfPackage.ACTIVITY_DECLARATION__TYPE_PART:
        setTypePart((TypePart)null);
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
      case AlfPackage.ACTIVITY_DECLARATION__NAME:
        return name != null;
      case AlfPackage.ACTIVITY_DECLARATION__TEMPLATE_PARAMETERS:
        return templateParameters != null;
      case AlfPackage.ACTIVITY_DECLARATION__FORMAL_PARAMETERS:
        return formalParameters != null;
      case AlfPackage.ACTIVITY_DECLARATION__TYPE_PART:
        return typePart != null;
    }
    return super.eIsSet(featureID);
  }

} //ActivityDeclarationImpl
