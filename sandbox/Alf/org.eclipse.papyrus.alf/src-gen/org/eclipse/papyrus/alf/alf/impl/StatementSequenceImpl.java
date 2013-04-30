/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.DocumentedStatement;
import org.eclipse.papyrus.alf.alf.StatementSequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.StatementSequenceImpl#getDocumentStatement <em>Document Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatementSequenceImpl extends MinimalEObjectImpl.Container implements StatementSequence
{
  /**
   * The cached value of the '{@link #getDocumentStatement() <em>Document Statement</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentStatement()
   * @generated
   * @ordered
   */
  protected EList<DocumentedStatement> documentStatement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StatementSequenceImpl()
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
    return AlfPackage.eINSTANCE.getStatementSequence();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DocumentedStatement> getDocumentStatement()
  {
    if (documentStatement == null)
    {
      documentStatement = new EObjectContainmentEList<DocumentedStatement>(DocumentedStatement.class, this, AlfPackage.STATEMENT_SEQUENCE__DOCUMENT_STATEMENT);
    }
    return documentStatement;
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
      case AlfPackage.STATEMENT_SEQUENCE__DOCUMENT_STATEMENT:
        return ((InternalEList<?>)getDocumentStatement()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.STATEMENT_SEQUENCE__DOCUMENT_STATEMENT:
        return getDocumentStatement();
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
      case AlfPackage.STATEMENT_SEQUENCE__DOCUMENT_STATEMENT:
        getDocumentStatement().clear();
        getDocumentStatement().addAll((Collection<? extends DocumentedStatement>)newValue);
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
      case AlfPackage.STATEMENT_SEQUENCE__DOCUMENT_STATEMENT:
        getDocumentStatement().clear();
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
      case AlfPackage.STATEMENT_SEQUENCE__DOCUMENT_STATEMENT:
        return documentStatement != null && !documentStatement.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StatementSequenceImpl
