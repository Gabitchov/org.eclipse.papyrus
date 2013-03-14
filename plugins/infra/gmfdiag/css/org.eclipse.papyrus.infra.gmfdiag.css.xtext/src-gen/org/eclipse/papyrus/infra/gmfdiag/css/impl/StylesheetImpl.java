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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.gmfdiag.css.Content;
import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.Import;
import org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stylesheet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.StylesheetImpl#getCharset <em>Charset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.StylesheetImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.StylesheetImpl#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StylesheetImpl extends MinimalEObjectImpl.Container implements Stylesheet
{
  /**
   * The default value of the '{@link #getCharset() <em>Charset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharset()
   * @generated
   * @ordered
   */
  protected static final String CHARSET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCharset() <em>Charset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharset()
   * @generated
   * @ordered
   */
  protected String charset = CHARSET_EDEFAULT;

  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContents()
   * @generated
   * @ordered
   */
  protected EList<Content> contents;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StylesheetImpl()
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
    return CssPackage.Literals.STYLESHEET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCharset()
  {
    return charset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCharset(String newCharset)
  {
    String oldCharset = charset;
    charset = newCharset;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.STYLESHEET__CHARSET, oldCharset, charset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, CssPackage.STYLESHEET__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Content> getContents()
  {
    if (contents == null)
    {
      contents = new EObjectContainmentEList<Content>(Content.class, this, CssPackage.STYLESHEET__CONTENTS);
    }
    return contents;
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
      case CssPackage.STYLESHEET__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case CssPackage.STYLESHEET__CONTENTS:
        return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
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
      case CssPackage.STYLESHEET__CHARSET:
        return getCharset();
      case CssPackage.STYLESHEET__IMPORTS:
        return getImports();
      case CssPackage.STYLESHEET__CONTENTS:
        return getContents();
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
      case CssPackage.STYLESHEET__CHARSET:
        setCharset((String)newValue);
        return;
      case CssPackage.STYLESHEET__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case CssPackage.STYLESHEET__CONTENTS:
        getContents().clear();
        getContents().addAll((Collection<? extends Content>)newValue);
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
      case CssPackage.STYLESHEET__CHARSET:
        setCharset(CHARSET_EDEFAULT);
        return;
      case CssPackage.STYLESHEET__IMPORTS:
        getImports().clear();
        return;
      case CssPackage.STYLESHEET__CONTENTS:
        getContents().clear();
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
      case CssPackage.STYLESHEET__CHARSET:
        return CHARSET_EDEFAULT == null ? charset != null : !CHARSET_EDEFAULT.equals(charset);
      case CssPackage.STYLESHEET__IMPORTS:
        return imports != null && !imports.isEmpty();
      case CssPackage.STYLESHEET__CONTENTS:
        return contents != null && !contents.isEmpty();
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
    result.append(" (charset: ");
    result.append(charset);
    result.append(')');
    return result.toString();
  }

} //StylesheetImpl
