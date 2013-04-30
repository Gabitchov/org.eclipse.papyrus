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
import org.eclipse.papyrus.alf.alf.ImportDeclaration;
import org.eclipse.papyrus.alf.alf.ImportReference;
import org.eclipse.papyrus.alf.alf.ImportVisibilityIndicator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ImportDeclarationImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ImportDeclarationImpl#getImportReference <em>Import Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportDeclarationImpl extends MinimalEObjectImpl.Container implements ImportDeclaration
{
  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final ImportVisibilityIndicator VISIBILITY_EDEFAULT = ImportVisibilityIndicator.PUBLIC;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected ImportVisibilityIndicator visibility = VISIBILITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getImportReference() <em>Import Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportReference()
   * @generated
   * @ordered
   */
  protected ImportReference importReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImportDeclarationImpl()
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
    return AlfPackage.eINSTANCE.getImportDeclaration();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportVisibilityIndicator getVisibility()
  {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibility(ImportVisibilityIndicator newVisibility)
  {
    ImportVisibilityIndicator oldVisibility = visibility;
    visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_DECLARATION__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportReference getImportReference()
  {
    return importReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImportReference(ImportReference newImportReference, NotificationChain msgs)
  {
    ImportReference oldImportReference = importReference;
    importReference = newImportReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_DECLARATION__IMPORT_REFERENCE, oldImportReference, newImportReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImportReference(ImportReference newImportReference)
  {
    if (newImportReference != importReference)
    {
      NotificationChain msgs = null;
      if (importReference != null)
        msgs = ((InternalEObject)importReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IMPORT_DECLARATION__IMPORT_REFERENCE, null, msgs);
      if (newImportReference != null)
        msgs = ((InternalEObject)newImportReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.IMPORT_DECLARATION__IMPORT_REFERENCE, null, msgs);
      msgs = basicSetImportReference(newImportReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.IMPORT_DECLARATION__IMPORT_REFERENCE, newImportReference, newImportReference));
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
      case AlfPackage.IMPORT_DECLARATION__IMPORT_REFERENCE:
        return basicSetImportReference(null, msgs);
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
      case AlfPackage.IMPORT_DECLARATION__VISIBILITY:
        return getVisibility();
      case AlfPackage.IMPORT_DECLARATION__IMPORT_REFERENCE:
        return getImportReference();
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
      case AlfPackage.IMPORT_DECLARATION__VISIBILITY:
        setVisibility((ImportVisibilityIndicator)newValue);
        return;
      case AlfPackage.IMPORT_DECLARATION__IMPORT_REFERENCE:
        setImportReference((ImportReference)newValue);
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
      case AlfPackage.IMPORT_DECLARATION__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case AlfPackage.IMPORT_DECLARATION__IMPORT_REFERENCE:
        setImportReference((ImportReference)null);
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
      case AlfPackage.IMPORT_DECLARATION__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case AlfPackage.IMPORT_DECLARATION__IMPORT_REFERENCE:
        return importReference != null;
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
    result.append(" (visibility: ");
    result.append(visibility);
    result.append(')');
    return result.toString();
  }

} //ImportDeclarationImpl
