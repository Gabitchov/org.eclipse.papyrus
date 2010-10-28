/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ReferenceValueRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Value Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.ReferenceValueRuleImpl#getReferencedElement <em>Referenced Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceValueRuleImpl extends ValueRuleImpl implements ReferenceValueRule
{
  /**
   * The cached value of the '{@link #getReferencedElement() <em>Referenced Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencedElement()
   * @generated
   * @ordered
   */
  protected NamedElement referencedElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceValueRuleImpl()
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
    return StereotypeApplicationWithVSLPackage.Literals.REFERENCE_VALUE_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement getReferencedElement()
  {
    if (referencedElement != null && referencedElement.eIsProxy())
    {
      InternalEObject oldReferencedElement = (InternalEObject)referencedElement;
      referencedElement = (NamedElement)eResolveProxy(oldReferencedElement);
      if (referencedElement != oldReferencedElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StereotypeApplicationWithVSLPackage.REFERENCE_VALUE_RULE__REFERENCED_ELEMENT, oldReferencedElement, referencedElement));
      }
    }
    return referencedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetReferencedElement()
  {
    return referencedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferencedElement(NamedElement newReferencedElement)
  {
    NamedElement oldReferencedElement = referencedElement;
    referencedElement = newReferencedElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StereotypeApplicationWithVSLPackage.REFERENCE_VALUE_RULE__REFERENCED_ELEMENT, oldReferencedElement, referencedElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getExpectedType()
  {
    return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation.ContextUtil.getExpectedType(this) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getContextElement()
  {
    return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation.ContextUtil.getContextElement(this) ;
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
      case StereotypeApplicationWithVSLPackage.REFERENCE_VALUE_RULE__REFERENCED_ELEMENT:
        if (resolve) return getReferencedElement();
        return basicGetReferencedElement();
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
      case StereotypeApplicationWithVSLPackage.REFERENCE_VALUE_RULE__REFERENCED_ELEMENT:
        setReferencedElement((NamedElement)newValue);
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
      case StereotypeApplicationWithVSLPackage.REFERENCE_VALUE_RULE__REFERENCED_ELEMENT:
        setReferencedElement((NamedElement)null);
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
      case StereotypeApplicationWithVSLPackage.REFERENCE_VALUE_RULE__REFERENCED_ELEMENT:
        return referencedElement != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceValueRuleImpl
