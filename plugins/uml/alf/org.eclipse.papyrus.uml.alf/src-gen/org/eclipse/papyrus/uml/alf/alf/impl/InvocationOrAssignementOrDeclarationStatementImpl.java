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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.AssignmentCompletion;
import org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation Or Assignement Or Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.InvocationOrAssignementOrDeclarationStatementImpl#getTypePart_OR_assignedPart_OR_invocationPart <em>Type Part OR assigned Part OR invocation Part</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.InvocationOrAssignementOrDeclarationStatementImpl#getVariableDeclarationCompletion <em>Variable Declaration Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.InvocationOrAssignementOrDeclarationStatementImpl#getAssignmentCompletion <em>Assignment Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocationOrAssignementOrDeclarationStatementImpl extends StatementImpl implements InvocationOrAssignementOrDeclarationStatement
{
  /**
   * The cached value of the '{@link #getTypePart_OR_assignedPart_OR_invocationPart() <em>Type Part OR assigned Part OR invocation Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypePart_OR_assignedPart_OR_invocationPart()
   * @generated
   * @ordered
   */
  protected NameExpression typePart_OR_assignedPart_OR_invocationPart;

  /**
   * The cached value of the '{@link #getVariableDeclarationCompletion() <em>Variable Declaration Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableDeclarationCompletion()
   * @generated
   * @ordered
   */
  protected VariableDeclarationCompletion variableDeclarationCompletion;

  /**
   * The cached value of the '{@link #getAssignmentCompletion() <em>Assignment Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignmentCompletion()
   * @generated
   * @ordered
   */
  protected AssignmentCompletion assignmentCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvocationOrAssignementOrDeclarationStatementImpl()
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
    return AlfPackage.Literals.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameExpression getTypePart_OR_assignedPart_OR_invocationPart()
  {
    return typePart_OR_assignedPart_OR_invocationPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypePart_OR_assignedPart_OR_invocationPart(NameExpression newTypePart_OR_assignedPart_OR_invocationPart, NotificationChain msgs)
  {
    NameExpression oldTypePart_OR_assignedPart_OR_invocationPart = typePart_OR_assignedPart_OR_invocationPart;
    typePart_OR_assignedPart_OR_invocationPart = newTypePart_OR_assignedPart_OR_invocationPart;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART, oldTypePart_OR_assignedPart_OR_invocationPart, newTypePart_OR_assignedPart_OR_invocationPart);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypePart_OR_assignedPart_OR_invocationPart(NameExpression newTypePart_OR_assignedPart_OR_invocationPart)
  {
    if (newTypePart_OR_assignedPart_OR_invocationPart != typePart_OR_assignedPart_OR_invocationPart)
    {
      NotificationChain msgs = null;
      if (typePart_OR_assignedPart_OR_invocationPart != null)
        msgs = ((InternalEObject)typePart_OR_assignedPart_OR_invocationPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART, null, msgs);
      if (newTypePart_OR_assignedPart_OR_invocationPart != null)
        msgs = ((InternalEObject)newTypePart_OR_assignedPart_OR_invocationPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART, null, msgs);
      msgs = basicSetTypePart_OR_assignedPart_OR_invocationPart(newTypePart_OR_assignedPart_OR_invocationPart, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART, newTypePart_OR_assignedPart_OR_invocationPart, newTypePart_OR_assignedPart_OR_invocationPart));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclarationCompletion getVariableDeclarationCompletion()
  {
    return variableDeclarationCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariableDeclarationCompletion(VariableDeclarationCompletion newVariableDeclarationCompletion, NotificationChain msgs)
  {
    VariableDeclarationCompletion oldVariableDeclarationCompletion = variableDeclarationCompletion;
    variableDeclarationCompletion = newVariableDeclarationCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION, oldVariableDeclarationCompletion, newVariableDeclarationCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableDeclarationCompletion(VariableDeclarationCompletion newVariableDeclarationCompletion)
  {
    if (newVariableDeclarationCompletion != variableDeclarationCompletion)
    {
      NotificationChain msgs = null;
      if (variableDeclarationCompletion != null)
        msgs = ((InternalEObject)variableDeclarationCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION, null, msgs);
      if (newVariableDeclarationCompletion != null)
        msgs = ((InternalEObject)newVariableDeclarationCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION, null, msgs);
      msgs = basicSetVariableDeclarationCompletion(newVariableDeclarationCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION, newVariableDeclarationCompletion, newVariableDeclarationCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentCompletion getAssignmentCompletion()
  {
    return assignmentCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssignmentCompletion(AssignmentCompletion newAssignmentCompletion, NotificationChain msgs)
  {
    AssignmentCompletion oldAssignmentCompletion = assignmentCompletion;
    assignmentCompletion = newAssignmentCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION, oldAssignmentCompletion, newAssignmentCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignmentCompletion(AssignmentCompletion newAssignmentCompletion)
  {
    if (newAssignmentCompletion != assignmentCompletion)
    {
      NotificationChain msgs = null;
      if (assignmentCompletion != null)
        msgs = ((InternalEObject)assignmentCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION, null, msgs);
      if (newAssignmentCompletion != null)
        msgs = ((InternalEObject)newAssignmentCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION, null, msgs);
      msgs = basicSetAssignmentCompletion(newAssignmentCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION, newAssignmentCompletion, newAssignmentCompletion));
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
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART:
        return basicSetTypePart_OR_assignedPart_OR_invocationPart(null, msgs);
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION:
        return basicSetVariableDeclarationCompletion(null, msgs);
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION:
        return basicSetAssignmentCompletion(null, msgs);
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
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART:
        return getTypePart_OR_assignedPart_OR_invocationPart();
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION:
        return getVariableDeclarationCompletion();
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION:
        return getAssignmentCompletion();
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
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART:
        setTypePart_OR_assignedPart_OR_invocationPart((NameExpression)newValue);
        return;
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION:
        setVariableDeclarationCompletion((VariableDeclarationCompletion)newValue);
        return;
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION:
        setAssignmentCompletion((AssignmentCompletion)newValue);
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
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART:
        setTypePart_OR_assignedPart_OR_invocationPart((NameExpression)null);
        return;
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION:
        setVariableDeclarationCompletion((VariableDeclarationCompletion)null);
        return;
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION:
        setAssignmentCompletion((AssignmentCompletion)null);
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
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART:
        return typePart_OR_assignedPart_OR_invocationPart != null;
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION:
        return variableDeclarationCompletion != null;
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION:
        return assignmentCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //InvocationOrAssignementOrDeclarationStatementImpl
