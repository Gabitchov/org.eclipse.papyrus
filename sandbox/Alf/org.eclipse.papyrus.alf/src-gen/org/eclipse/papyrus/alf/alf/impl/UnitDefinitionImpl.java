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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.ImportDeclaration;
import org.eclipse.papyrus.alf.alf.NamespaceDeclaration;
import org.eclipse.papyrus.alf.alf.NamespaceDefinition;
import org.eclipse.papyrus.alf.alf.StereotypeAnnotations;
import org.eclipse.papyrus.alf.alf.UnitDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.UnitDefinitionImpl#getNamespaceDeclaration <em>Namespace Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.UnitDefinitionImpl#getImportDeclarations <em>Import Declarations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.UnitDefinitionImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.UnitDefinitionImpl#getStereotypeAnnotations <em>Stereotype Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.UnitDefinitionImpl#getNamesapceDefinition <em>Namesapce Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitDefinitionImpl extends MinimalEObjectImpl.Container implements UnitDefinition
{
  /**
   * The cached value of the '{@link #getNamespaceDeclaration() <em>Namespace Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespaceDeclaration()
   * @generated
   * @ordered
   */
  protected NamespaceDeclaration namespaceDeclaration;

  /**
   * The cached value of the '{@link #getImportDeclarations() <em>Import Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportDeclarations()
   * @generated
   * @ordered
   */
  protected EList<ImportDeclaration> importDeclarations;

  /**
   * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComment()
   * @generated
   * @ordered
   */
  protected static final String COMMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComment()
   * @generated
   * @ordered
   */
  protected String comment = COMMENT_EDEFAULT;

  /**
   * The cached value of the '{@link #getStereotypeAnnotations() <em>Stereotype Annotations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotypeAnnotations()
   * @generated
   * @ordered
   */
  protected StereotypeAnnotations stereotypeAnnotations;

  /**
   * The cached value of the '{@link #getNamesapceDefinition() <em>Namesapce Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamesapceDefinition()
   * @generated
   * @ordered
   */
  protected NamespaceDefinition namesapceDefinition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnitDefinitionImpl()
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
    return AlfPackage.eINSTANCE.getUnitDefinition();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamespaceDeclaration getNamespaceDeclaration()
  {
    return namespaceDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNamespaceDeclaration(NamespaceDeclaration newNamespaceDeclaration, NotificationChain msgs)
  {
    NamespaceDeclaration oldNamespaceDeclaration = namespaceDeclaration;
    namespaceDeclaration = newNamespaceDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.UNIT_DEFINITION__NAMESPACE_DECLARATION, oldNamespaceDeclaration, newNamespaceDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamespaceDeclaration(NamespaceDeclaration newNamespaceDeclaration)
  {
    if (newNamespaceDeclaration != namespaceDeclaration)
    {
      NotificationChain msgs = null;
      if (namespaceDeclaration != null)
        msgs = ((InternalEObject)namespaceDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.UNIT_DEFINITION__NAMESPACE_DECLARATION, null, msgs);
      if (newNamespaceDeclaration != null)
        msgs = ((InternalEObject)newNamespaceDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.UNIT_DEFINITION__NAMESPACE_DECLARATION, null, msgs);
      msgs = basicSetNamespaceDeclaration(newNamespaceDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.UNIT_DEFINITION__NAMESPACE_DECLARATION, newNamespaceDeclaration, newNamespaceDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ImportDeclaration> getImportDeclarations()
  {
    if (importDeclarations == null)
    {
      importDeclarations = new EObjectContainmentEList<ImportDeclaration>(ImportDeclaration.class, this, AlfPackage.UNIT_DEFINITION__IMPORT_DECLARATIONS);
    }
    return importDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComment()
  {
    return comment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComment(String newComment)
  {
    String oldComment = comment;
    comment = newComment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.UNIT_DEFINITION__COMMENT, oldComment, comment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StereotypeAnnotations getStereotypeAnnotations()
  {
    return stereotypeAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStereotypeAnnotations(StereotypeAnnotations newStereotypeAnnotations, NotificationChain msgs)
  {
    StereotypeAnnotations oldStereotypeAnnotations = stereotypeAnnotations;
    stereotypeAnnotations = newStereotypeAnnotations;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.UNIT_DEFINITION__STEREOTYPE_ANNOTATIONS, oldStereotypeAnnotations, newStereotypeAnnotations);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStereotypeAnnotations(StereotypeAnnotations newStereotypeAnnotations)
  {
    if (newStereotypeAnnotations != stereotypeAnnotations)
    {
      NotificationChain msgs = null;
      if (stereotypeAnnotations != null)
        msgs = ((InternalEObject)stereotypeAnnotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.UNIT_DEFINITION__STEREOTYPE_ANNOTATIONS, null, msgs);
      if (newStereotypeAnnotations != null)
        msgs = ((InternalEObject)newStereotypeAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.UNIT_DEFINITION__STEREOTYPE_ANNOTATIONS, null, msgs);
      msgs = basicSetStereotypeAnnotations(newStereotypeAnnotations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.UNIT_DEFINITION__STEREOTYPE_ANNOTATIONS, newStereotypeAnnotations, newStereotypeAnnotations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamespaceDefinition getNamesapceDefinition()
  {
    return namesapceDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNamesapceDefinition(NamespaceDefinition newNamesapceDefinition, NotificationChain msgs)
  {
    NamespaceDefinition oldNamesapceDefinition = namesapceDefinition;
    namesapceDefinition = newNamesapceDefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.UNIT_DEFINITION__NAMESAPCE_DEFINITION, oldNamesapceDefinition, newNamesapceDefinition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamesapceDefinition(NamespaceDefinition newNamesapceDefinition)
  {
    if (newNamesapceDefinition != namesapceDefinition)
    {
      NotificationChain msgs = null;
      if (namesapceDefinition != null)
        msgs = ((InternalEObject)namesapceDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.UNIT_DEFINITION__NAMESAPCE_DEFINITION, null, msgs);
      if (newNamesapceDefinition != null)
        msgs = ((InternalEObject)newNamesapceDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.UNIT_DEFINITION__NAMESAPCE_DEFINITION, null, msgs);
      msgs = basicSetNamesapceDefinition(newNamesapceDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.UNIT_DEFINITION__NAMESAPCE_DEFINITION, newNamesapceDefinition, newNamesapceDefinition));
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
      case AlfPackage.UNIT_DEFINITION__NAMESPACE_DECLARATION:
        return basicSetNamespaceDeclaration(null, msgs);
      case AlfPackage.UNIT_DEFINITION__IMPORT_DECLARATIONS:
        return ((InternalEList<?>)getImportDeclarations()).basicRemove(otherEnd, msgs);
      case AlfPackage.UNIT_DEFINITION__STEREOTYPE_ANNOTATIONS:
        return basicSetStereotypeAnnotations(null, msgs);
      case AlfPackage.UNIT_DEFINITION__NAMESAPCE_DEFINITION:
        return basicSetNamesapceDefinition(null, msgs);
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
      case AlfPackage.UNIT_DEFINITION__NAMESPACE_DECLARATION:
        return getNamespaceDeclaration();
      case AlfPackage.UNIT_DEFINITION__IMPORT_DECLARATIONS:
        return getImportDeclarations();
      case AlfPackage.UNIT_DEFINITION__COMMENT:
        return getComment();
      case AlfPackage.UNIT_DEFINITION__STEREOTYPE_ANNOTATIONS:
        return getStereotypeAnnotations();
      case AlfPackage.UNIT_DEFINITION__NAMESAPCE_DEFINITION:
        return getNamesapceDefinition();
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
      case AlfPackage.UNIT_DEFINITION__NAMESPACE_DECLARATION:
        setNamespaceDeclaration((NamespaceDeclaration)newValue);
        return;
      case AlfPackage.UNIT_DEFINITION__IMPORT_DECLARATIONS:
        getImportDeclarations().clear();
        getImportDeclarations().addAll((Collection<? extends ImportDeclaration>)newValue);
        return;
      case AlfPackage.UNIT_DEFINITION__COMMENT:
        setComment((String)newValue);
        return;
      case AlfPackage.UNIT_DEFINITION__STEREOTYPE_ANNOTATIONS:
        setStereotypeAnnotations((StereotypeAnnotations)newValue);
        return;
      case AlfPackage.UNIT_DEFINITION__NAMESAPCE_DEFINITION:
        setNamesapceDefinition((NamespaceDefinition)newValue);
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
      case AlfPackage.UNIT_DEFINITION__NAMESPACE_DECLARATION:
        setNamespaceDeclaration((NamespaceDeclaration)null);
        return;
      case AlfPackage.UNIT_DEFINITION__IMPORT_DECLARATIONS:
        getImportDeclarations().clear();
        return;
      case AlfPackage.UNIT_DEFINITION__COMMENT:
        setComment(COMMENT_EDEFAULT);
        return;
      case AlfPackage.UNIT_DEFINITION__STEREOTYPE_ANNOTATIONS:
        setStereotypeAnnotations((StereotypeAnnotations)null);
        return;
      case AlfPackage.UNIT_DEFINITION__NAMESAPCE_DEFINITION:
        setNamesapceDefinition((NamespaceDefinition)null);
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
      case AlfPackage.UNIT_DEFINITION__NAMESPACE_DECLARATION:
        return namespaceDeclaration != null;
      case AlfPackage.UNIT_DEFINITION__IMPORT_DECLARATIONS:
        return importDeclarations != null && !importDeclarations.isEmpty();
      case AlfPackage.UNIT_DEFINITION__COMMENT:
        return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
      case AlfPackage.UNIT_DEFINITION__STEREOTYPE_ANNOTATIONS:
        return stereotypeAnnotations != null;
      case AlfPackage.UNIT_DEFINITION__NAMESAPCE_DEFINITION:
        return namesapceDefinition != null;
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
    result.append(" (comment: ");
    result.append(comment);
    result.append(')');
    return result.toString();
  }

} //UnitDefinitionImpl
