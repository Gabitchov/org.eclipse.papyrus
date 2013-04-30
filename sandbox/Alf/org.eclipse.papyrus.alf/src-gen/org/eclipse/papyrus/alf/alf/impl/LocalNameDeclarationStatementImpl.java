/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatementCompletion;
import org.eclipse.papyrus.alf.alf.MultiplicityIndicator;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.TypeName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Name Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationStatementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationStatementImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationStatementImpl#getMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationStatementImpl#getLocalNameDeclarationCompletion <em>Local Name Declaration Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalNameDeclarationStatementImpl extends StatementImpl implements LocalNameDeclarationStatement
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
   * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected TypeName typeName;

  /**
   * The cached value of the '{@link #getMultiplicityIndicator() <em>Multiplicity Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicityIndicator()
   * @generated
   * @ordered
   */
  protected MultiplicityIndicator multiplicityIndicator;

  /**
   * The cached value of the '{@link #getLocalNameDeclarationCompletion() <em>Local Name Declaration Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalNameDeclarationCompletion()
   * @generated
   * @ordered
   */
  protected LocalNameDeclarationStatementCompletion localNameDeclarationCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LocalNameDeclarationStatementImpl()
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
    return AlfPackage.eINSTANCE.getLocalNameDeclarationStatement();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__NAME, oldName, newName);
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
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeName getTypeName()
  {
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeName(TypeName newTypeName, NotificationChain msgs)
  {
    TypeName oldTypeName = typeName;
    typeName = newTypeName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__TYPE_NAME, oldTypeName, newTypeName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeName(TypeName newTypeName)
  {
    if (newTypeName != typeName)
    {
      NotificationChain msgs = null;
      if (typeName != null)
        msgs = ((InternalEObject)typeName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__TYPE_NAME, null, msgs);
      if (newTypeName != null)
        msgs = ((InternalEObject)newTypeName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__TYPE_NAME, null, msgs);
      msgs = basicSetTypeName(newTypeName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__TYPE_NAME, newTypeName, newTypeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityIndicator getMultiplicityIndicator()
  {
    return multiplicityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicityIndicator(MultiplicityIndicator newMultiplicityIndicator, NotificationChain msgs)
  {
    MultiplicityIndicator oldMultiplicityIndicator = multiplicityIndicator;
    multiplicityIndicator = newMultiplicityIndicator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR, oldMultiplicityIndicator, newMultiplicityIndicator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicityIndicator(MultiplicityIndicator newMultiplicityIndicator)
  {
    if (newMultiplicityIndicator != multiplicityIndicator)
    {
      NotificationChain msgs = null;
      if (multiplicityIndicator != null)
        msgs = ((InternalEObject)multiplicityIndicator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR, null, msgs);
      if (newMultiplicityIndicator != null)
        msgs = ((InternalEObject)newMultiplicityIndicator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR, null, msgs);
      msgs = basicSetMultiplicityIndicator(newMultiplicityIndicator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR, newMultiplicityIndicator, newMultiplicityIndicator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalNameDeclarationStatementCompletion getLocalNameDeclarationCompletion()
  {
    return localNameDeclarationCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLocalNameDeclarationCompletion(LocalNameDeclarationStatementCompletion newLocalNameDeclarationCompletion, NotificationChain msgs)
  {
    LocalNameDeclarationStatementCompletion oldLocalNameDeclarationCompletion = localNameDeclarationCompletion;
    localNameDeclarationCompletion = newLocalNameDeclarationCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION, oldLocalNameDeclarationCompletion, newLocalNameDeclarationCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocalNameDeclarationCompletion(LocalNameDeclarationStatementCompletion newLocalNameDeclarationCompletion)
  {
    if (newLocalNameDeclarationCompletion != localNameDeclarationCompletion)
    {
      NotificationChain msgs = null;
      if (localNameDeclarationCompletion != null)
        msgs = ((InternalEObject)localNameDeclarationCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION, null, msgs);
      if (newLocalNameDeclarationCompletion != null)
        msgs = ((InternalEObject)newLocalNameDeclarationCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION, null, msgs);
      msgs = basicSetLocalNameDeclarationCompletion(newLocalNameDeclarationCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION, newLocalNameDeclarationCompletion, newLocalNameDeclarationCompletion));
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
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__TYPE_NAME:
        return basicSetTypeName(null, msgs);
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR:
        return basicSetMultiplicityIndicator(null, msgs);
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        return basicSetLocalNameDeclarationCompletion(null, msgs);
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
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__NAME:
        return getName();
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__TYPE_NAME:
        return getTypeName();
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR:
        return getMultiplicityIndicator();
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        return getLocalNameDeclarationCompletion();
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
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__TYPE_NAME:
        setTypeName((TypeName)newValue);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR:
        setMultiplicityIndicator((MultiplicityIndicator)newValue);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        setLocalNameDeclarationCompletion((LocalNameDeclarationStatementCompletion)newValue);
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
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__NAME:
        setName((Name)null);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__TYPE_NAME:
        setTypeName((TypeName)null);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR:
        setMultiplicityIndicator((MultiplicityIndicator)null);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        setLocalNameDeclarationCompletion((LocalNameDeclarationStatementCompletion)null);
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
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__NAME:
        return name != null;
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__TYPE_NAME:
        return typeName != null;
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR:
        return multiplicityIndicator != null;
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        return localNameDeclarationCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //LocalNameDeclarationStatementImpl
