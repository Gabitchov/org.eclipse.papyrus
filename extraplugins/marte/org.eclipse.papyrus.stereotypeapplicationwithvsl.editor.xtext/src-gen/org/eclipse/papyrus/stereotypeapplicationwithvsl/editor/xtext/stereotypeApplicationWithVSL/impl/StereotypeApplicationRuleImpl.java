/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl;

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

import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Application Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationRuleImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationRuleImpl#getTagSpecification <em>Tag Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypeApplicationRuleImpl extends MinimalEObjectImpl.Container implements StereotypeApplicationRule
{
  /**
   * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotype()
   * @generated
   * @ordered
   */
  protected Stereotype stereotype;

  /**
   * The cached value of the '{@link #getTagSpecification() <em>Tag Specification</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTagSpecification()
   * @generated
   * @ordered
   */
  protected EList<TagSpecificationRule> tagSpecification;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StereotypeApplicationRuleImpl()
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
    return StereotypeApplicationWithVSLPackage.Literals.STEREOTYPE_APPLICATION_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stereotype getStereotype()
  {
    if (stereotype != null && stereotype.eIsProxy())
    {
      InternalEObject oldStereotype = (InternalEObject)stereotype;
      stereotype = (Stereotype)eResolveProxy(oldStereotype);
      if (stereotype != oldStereotype)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__STEREOTYPE, oldStereotype, stereotype));
      }
    }
    return stereotype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stereotype basicGetStereotype()
  {
    return stereotype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStereotype(Stereotype newStereotype)
  {
    Stereotype oldStereotype = stereotype;
    stereotype = newStereotype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__STEREOTYPE, oldStereotype, stereotype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TagSpecificationRule> getTagSpecification()
  {
    if (tagSpecification == null)
    {
      tagSpecification = new EObjectContainmentEList<TagSpecificationRule>(TagSpecificationRule.class, this, StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__TAG_SPECIFICATION);
    }
    return tagSpecification;
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
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__TAG_SPECIFICATION:
        return ((InternalEList<?>)getTagSpecification()).basicRemove(otherEnd, msgs);
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
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__STEREOTYPE:
        if (resolve) return getStereotype();
        return basicGetStereotype();
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__TAG_SPECIFICATION:
        return getTagSpecification();
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
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__STEREOTYPE:
        setStereotype((Stereotype)newValue);
        return;
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__TAG_SPECIFICATION:
        getTagSpecification().clear();
        getTagSpecification().addAll((Collection<? extends TagSpecificationRule>)newValue);
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
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__STEREOTYPE:
        setStereotype((Stereotype)null);
        return;
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__TAG_SPECIFICATION:
        getTagSpecification().clear();
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
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__STEREOTYPE:
        return stereotype != null;
      case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE__TAG_SPECIFICATION:
        return tagSpecification != null && !tagSpecification.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StereotypeApplicationRuleImpl
