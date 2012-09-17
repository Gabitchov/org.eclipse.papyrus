/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.InlineStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inline Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.InlineStatementImpl#getLangageName <em>Langage Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.InlineStatementImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InlineStatementImpl extends StatementImpl implements InlineStatement
{
  /**
   * The default value of the '{@link #getLangageName() <em>Langage Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLangageName()
   * @generated
   * @ordered
   */
  protected static final String LANGAGE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLangageName() <em>Langage Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLangageName()
   * @generated
   * @ordered
   */
  protected String langageName = LANGAGE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getBody() <em>Body</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected static final String BODY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected String body = BODY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InlineStatementImpl()
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
    return AlfPackage.Literals.INLINE_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLangageName()
  {
    return langageName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLangageName(String newLangageName)
  {
    String oldLangageName = langageName;
    langageName = newLangageName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INLINE_STATEMENT__LANGAGE_NAME, oldLangageName, langageName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(String newBody)
  {
    String oldBody = body;
    body = newBody;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INLINE_STATEMENT__BODY, oldBody, body));
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
      case AlfPackage.INLINE_STATEMENT__LANGAGE_NAME:
        return getLangageName();
      case AlfPackage.INLINE_STATEMENT__BODY:
        return getBody();
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
      case AlfPackage.INLINE_STATEMENT__LANGAGE_NAME:
        setLangageName((String)newValue);
        return;
      case AlfPackage.INLINE_STATEMENT__BODY:
        setBody((String)newValue);
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
      case AlfPackage.INLINE_STATEMENT__LANGAGE_NAME:
        setLangageName(LANGAGE_NAME_EDEFAULT);
        return;
      case AlfPackage.INLINE_STATEMENT__BODY:
        setBody(BODY_EDEFAULT);
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
      case AlfPackage.INLINE_STATEMENT__LANGAGE_NAME:
        return LANGAGE_NAME_EDEFAULT == null ? langageName != null : !LANGAGE_NAME_EDEFAULT.equals(langageName);
      case AlfPackage.INLINE_STATEMENT__BODY:
        return BODY_EDEFAULT == null ? body != null : !BODY_EDEFAULT.equals(body);
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
    result.append(" (langageName: ");
    result.append(langageName);
    result.append(", body: ");
    result.append(body);
    result.append(')');
    return result.toString();
  }

} //InlineStatementImpl
