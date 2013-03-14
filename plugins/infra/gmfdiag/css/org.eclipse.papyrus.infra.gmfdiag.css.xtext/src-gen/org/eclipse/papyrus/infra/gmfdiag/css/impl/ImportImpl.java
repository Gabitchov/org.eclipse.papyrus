/*****************************************************************************
 * Copyright (c) 2012-2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.Import;
import org.eclipse.papyrus.infra.gmfdiag.css.Uri;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ImportImpl#getString <em>String</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ImportImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ImportImpl#getMedia <em>Media</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportImpl extends MinimalEObjectImpl.Container implements Import
{
  /**
   * The default value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected static final String STRING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected String string = STRING_EDEFAULT;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected Uri uri;

  /**
   * The cached value of the '{@link #getMedia() <em>Media</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMedia()
   * @generated
   * @ordered
   */
  protected EList<String> media;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImportImpl()
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
    return CssPackage.Literals.IMPORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getString()
  {
    return string;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setString(String newString)
  {
    String oldString = string;
    string = newString;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.IMPORT__STRING, oldString, string));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Uri getUri()
  {
    return uri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUri(Uri newUri, NotificationChain msgs)
  {
    Uri oldUri = uri;
    uri = newUri;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CssPackage.IMPORT__URI, oldUri, newUri);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUri(Uri newUri)
  {
    if (newUri != uri)
    {
      NotificationChain msgs = null;
      if (uri != null)
        msgs = ((InternalEObject)uri).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CssPackage.IMPORT__URI, null, msgs);
      if (newUri != null)
        msgs = ((InternalEObject)newUri).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CssPackage.IMPORT__URI, null, msgs);
      msgs = basicSetUri(newUri, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.IMPORT__URI, newUri, newUri));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getMedia()
  {
    if (media == null)
    {
      media = new EDataTypeEList<String>(String.class, this, CssPackage.IMPORT__MEDIA);
    }
    return media;
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
      case CssPackage.IMPORT__URI:
        return basicSetUri(null, msgs);
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
      case CssPackage.IMPORT__STRING:
        return getString();
      case CssPackage.IMPORT__URI:
        return getUri();
      case CssPackage.IMPORT__MEDIA:
        return getMedia();
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
      case CssPackage.IMPORT__STRING:
        setString((String)newValue);
        return;
      case CssPackage.IMPORT__URI:
        setUri((Uri)newValue);
        return;
      case CssPackage.IMPORT__MEDIA:
        getMedia().clear();
        getMedia().addAll((Collection<? extends String>)newValue);
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
      case CssPackage.IMPORT__STRING:
        setString(STRING_EDEFAULT);
        return;
      case CssPackage.IMPORT__URI:
        setUri((Uri)null);
        return;
      case CssPackage.IMPORT__MEDIA:
        getMedia().clear();
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
      case CssPackage.IMPORT__STRING:
        return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT.equals(string);
      case CssPackage.IMPORT__URI:
        return uri != null;
      case CssPackage.IMPORT__MEDIA:
        return media != null && !media.isEmpty();
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
    result.append(" (string: ");
    result.append(string);
    result.append(", media: ");
    result.append(media);
    result.append(')');
    return result.toString();
  }

} //ImportImpl
