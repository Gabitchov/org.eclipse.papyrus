/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.AliasDefinition;
import org.eclipse.papyrus.alf.alf.ImportReference;
import org.eclipse.papyrus.alf.alf.ImportReferenceQualifiedNameCompletion;
import org.eclipse.papyrus.alf.alf.Name;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ImportReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ImportReferenceImpl#getCompletion <em>Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ImportReferenceImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ImportReferenceImpl#isStar <em>Star</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportReferenceImpl extends MinimalEObjectImpl.Container implements ImportReference
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
   * The cached value of the '{@link #getCompletion() <em>Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompletion()
   * @generated
   * @ordered
   */
  protected ImportReferenceQualifiedNameCompletion completion;

  /**
   * The cached value of the '{@link #getAlias() <em>Alias</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected AliasDefinition alias;

  /**
   * The default value of the '{@link #isStar() <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStar()
   * @generated
   * @ordered
   */
  protected static final boolean STAR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStar() <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStar()
   * @generated
   * @ordered
   */
  protected boolean star = STAR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImportReferenceImpl()
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
    return AlfPackage.eINSTANCE.getImportReference();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_REFERENCE__NAME, oldName, newName);
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
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IMPORT_REFERENCE__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IMPORT_REFERENCE__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_REFERENCE__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportReferenceQualifiedNameCompletion getCompletion()
  {
    return completion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCompletion(ImportReferenceQualifiedNameCompletion newCompletion, NotificationChain msgs)
  {
    ImportReferenceQualifiedNameCompletion oldCompletion = completion;
    completion = newCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_REFERENCE__COMPLETION, oldCompletion, newCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompletion(ImportReferenceQualifiedNameCompletion newCompletion)
  {
    if (newCompletion != completion)
    {
      NotificationChain msgs = null;
      if (completion != null)
        msgs = ((InternalEObject)completion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IMPORT_REFERENCE__COMPLETION, null, msgs);
      if (newCompletion != null)
        msgs = ((InternalEObject)newCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IMPORT_REFERENCE__COMPLETION, null, msgs);
      msgs = basicSetCompletion(newCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_REFERENCE__COMPLETION, newCompletion, newCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AliasDefinition getAlias()
  {
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAlias(AliasDefinition newAlias, NotificationChain msgs)
  {
    AliasDefinition oldAlias = alias;
    alias = newAlias;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_REFERENCE__ALIAS, oldAlias, newAlias);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlias(AliasDefinition newAlias)
  {
    if (newAlias != alias)
    {
      NotificationChain msgs = null;
      if (alias != null)
        msgs = ((InternalEObject)alias).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IMPORT_REFERENCE__ALIAS, null, msgs);
      if (newAlias != null)
        msgs = ((InternalEObject)newAlias).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IMPORT_REFERENCE__ALIAS, null, msgs);
      msgs = basicSetAlias(newAlias, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_REFERENCE__ALIAS, newAlias, newAlias));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStar()
  {
    return star;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStar(boolean newStar)
  {
    boolean oldStar = star;
    star = newStar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_REFERENCE__STAR, oldStar, star));
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
      case AlfPackage.IMPORT_REFERENCE__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.IMPORT_REFERENCE__COMPLETION:
        return basicSetCompletion(null, msgs);
      case AlfPackage.IMPORT_REFERENCE__ALIAS:
        return basicSetAlias(null, msgs);
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
      case AlfPackage.IMPORT_REFERENCE__NAME:
        return getName();
      case AlfPackage.IMPORT_REFERENCE__COMPLETION:
        return getCompletion();
      case AlfPackage.IMPORT_REFERENCE__ALIAS:
        return getAlias();
      case AlfPackage.IMPORT_REFERENCE__STAR:
        return isStar();
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
      case AlfPackage.IMPORT_REFERENCE__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.IMPORT_REFERENCE__COMPLETION:
        setCompletion((ImportReferenceQualifiedNameCompletion)newValue);
        return;
      case AlfPackage.IMPORT_REFERENCE__ALIAS:
        setAlias((AliasDefinition)newValue);
        return;
      case AlfPackage.IMPORT_REFERENCE__STAR:
        setStar((Boolean)newValue);
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
      case AlfPackage.IMPORT_REFERENCE__NAME:
        setName((Name)null);
        return;
      case AlfPackage.IMPORT_REFERENCE__COMPLETION:
        setCompletion((ImportReferenceQualifiedNameCompletion)null);
        return;
      case AlfPackage.IMPORT_REFERENCE__ALIAS:
        setAlias((AliasDefinition)null);
        return;
      case AlfPackage.IMPORT_REFERENCE__STAR:
        setStar(STAR_EDEFAULT);
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
      case AlfPackage.IMPORT_REFERENCE__NAME:
        return name != null;
      case AlfPackage.IMPORT_REFERENCE__COMPLETION:
        return completion != null;
      case AlfPackage.IMPORT_REFERENCE__ALIAS:
        return alias != null;
      case AlfPackage.IMPORT_REFERENCE__STAR:
        return star != STAR_EDEFAULT;
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
    result.append(" (star: ");
    result.append(star);
    result.append(')');
    return result.toString();
  }

} //ImportReferenceImpl
