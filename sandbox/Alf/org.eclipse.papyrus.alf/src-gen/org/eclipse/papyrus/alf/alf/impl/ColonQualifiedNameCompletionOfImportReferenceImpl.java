/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.AliasDefinition;
import org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionOfImportReference;
import org.eclipse.papyrus.alf.alf.Name;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Colon Qualified Name Completion Of Import Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ColonQualifiedNameCompletionOfImportReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ColonQualifiedNameCompletionOfImportReferenceImpl#isStar <em>Star</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ColonQualifiedNameCompletionOfImportReferenceImpl#getAlias <em>Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColonQualifiedNameCompletionOfImportReferenceImpl extends ImportReferenceQualifiedNameCompletionImpl implements ColonQualifiedNameCompletionOfImportReference
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected EList<Name> name;

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
   * The cached value of the '{@link #getAlias() <em>Alias</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected AliasDefinition alias;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ColonQualifiedNameCompletionOfImportReferenceImpl()
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
    return AlfPackage.eINSTANCE.getColonQualifiedNameCompletionOfImportReference();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Name> getName()
  {
    if (name == null)
    {
      name = new EObjectContainmentEList<Name>(Name.class, this, AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__NAME);
    }
    return name;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__STAR, oldStar, star));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__ALIAS, oldAlias, newAlias);
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
        msgs = ((InternalEObject)alias).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__ALIAS, null, msgs);
      if (newAlias != null)
        msgs = ((InternalEObject)newAlias).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__ALIAS, null, msgs);
      msgs = basicSetAlias(newAlias, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__ALIAS, newAlias, newAlias));
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__NAME:
        return ((InternalEList<?>)getName()).basicRemove(otherEnd, msgs);
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__ALIAS:
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__NAME:
        return getName();
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__STAR:
        return isStar();
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__ALIAS:
        return getAlias();
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__NAME:
        getName().clear();
        getName().addAll((Collection<? extends Name>)newValue);
        return;
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__STAR:
        setStar((Boolean)newValue);
        return;
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__ALIAS:
        setAlias((AliasDefinition)newValue);
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__NAME:
        getName().clear();
        return;
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__STAR:
        setStar(STAR_EDEFAULT);
        return;
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__ALIAS:
        setAlias((AliasDefinition)null);
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
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__NAME:
        return name != null && !name.isEmpty();
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__STAR:
        return star != STAR_EDEFAULT;
      case AlfPackage.COLON_QUALIFIED_NAME_COMPLETION_OF_IMPORT_REFERENCE__ALIAS:
        return alias != null;
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

} //ColonQualifiedNameCompletionOfImportReferenceImpl
