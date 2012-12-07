/**
 */
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

import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.Expression;
import org.eclipse.papyrus.infra.gmfdiag.css.Subterm;
import org.eclipse.papyrus.infra.gmfdiag.css.Term;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ExpressionImpl#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.ExpressionImpl#getSubterms <em>Subterms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends MinimalEObjectImpl.Container implements Expression
{
  /**
   * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTerms()
   * @generated
   * @ordered
   */
  protected Term terms;

  /**
   * The cached value of the '{@link #getSubterms() <em>Subterms</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubterms()
   * @generated
   * @ordered
   */
  protected EList<Subterm> subterms;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionImpl()
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
    return CssPackage.Literals.EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Term getTerms()
  {
    return terms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTerms(Term newTerms, NotificationChain msgs)
  {
    Term oldTerms = terms;
    terms = newTerms;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CssPackage.EXPRESSION__TERMS, oldTerms, newTerms);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTerms(Term newTerms)
  {
    if (newTerms != terms)
    {
      NotificationChain msgs = null;
      if (terms != null)
        msgs = ((InternalEObject)terms).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CssPackage.EXPRESSION__TERMS, null, msgs);
      if (newTerms != null)
        msgs = ((InternalEObject)newTerms).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CssPackage.EXPRESSION__TERMS, null, msgs);
      msgs = basicSetTerms(newTerms, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.EXPRESSION__TERMS, newTerms, newTerms));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Subterm> getSubterms()
  {
    if (subterms == null)
    {
      subterms = new EObjectContainmentEList<Subterm>(Subterm.class, this, CssPackage.EXPRESSION__SUBTERMS);
    }
    return subterms;
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
      case CssPackage.EXPRESSION__TERMS:
        return basicSetTerms(null, msgs);
      case CssPackage.EXPRESSION__SUBTERMS:
        return ((InternalEList<?>)getSubterms()).basicRemove(otherEnd, msgs);
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
      case CssPackage.EXPRESSION__TERMS:
        return getTerms();
      case CssPackage.EXPRESSION__SUBTERMS:
        return getSubterms();
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
      case CssPackage.EXPRESSION__TERMS:
        setTerms((Term)newValue);
        return;
      case CssPackage.EXPRESSION__SUBTERMS:
        getSubterms().clear();
        getSubterms().addAll((Collection<? extends Subterm>)newValue);
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
      case CssPackage.EXPRESSION__TERMS:
        setTerms((Term)null);
        return;
      case CssPackage.EXPRESSION__SUBTERMS:
        getSubterms().clear();
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
      case CssPackage.EXPRESSION__TERMS:
        return terms != null;
      case CssPackage.EXPRESSION__SUBTERMS:
        return subterms != null && !subterms.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExpressionImpl
