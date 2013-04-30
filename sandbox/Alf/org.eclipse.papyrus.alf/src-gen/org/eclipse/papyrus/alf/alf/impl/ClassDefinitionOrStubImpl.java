/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.ClassBody;
import org.eclipse.papyrus.alf.alf.ClassDeclaration;
import org.eclipse.papyrus.alf.alf.ClassDefinitionOrStub;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassDefinitionOrStubImpl#getClassDeclaration <em>Class Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassDefinitionOrStubImpl#getClassBody <em>Class Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassDefinitionOrStubImpl extends ClassifierDefinitionOrStubImpl implements ClassDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getClassDeclaration() <em>Class Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassDeclaration()
   * @generated
   * @ordered
   */
  protected ClassDeclaration classDeclaration;

  /**
   * The cached value of the '{@link #getClassBody() <em>Class Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassBody()
   * @generated
   * @ordered
   */
  protected ClassBody classBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassDefinitionOrStubImpl()
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
    return AlfPackage.eINSTANCE.getClassDefinitionOrStub();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDeclaration getClassDeclaration()
  {
    return classDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassDeclaration(ClassDeclaration newClassDeclaration, NotificationChain msgs)
  {
    ClassDeclaration oldClassDeclaration = classDeclaration;
    classDeclaration = newClassDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_DECLARATION, oldClassDeclaration, newClassDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassDeclaration(ClassDeclaration newClassDeclaration)
  {
    if (newClassDeclaration != classDeclaration)
    {
      NotificationChain msgs = null;
      if (classDeclaration != null)
        msgs = ((InternalEObject)classDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_DECLARATION, null, msgs);
      if (newClassDeclaration != null)
        msgs = ((InternalEObject)newClassDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_DECLARATION, null, msgs);
      msgs = basicSetClassDeclaration(newClassDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_DECLARATION, newClassDeclaration, newClassDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassBody getClassBody()
  {
    return classBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassBody(ClassBody newClassBody, NotificationChain msgs)
  {
    ClassBody oldClassBody = classBody;
    classBody = newClassBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_BODY, oldClassBody, newClassBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassBody(ClassBody newClassBody)
  {
    if (newClassBody != classBody)
    {
      NotificationChain msgs = null;
      if (classBody != null)
        msgs = ((InternalEObject)classBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_BODY, null, msgs);
      if (newClassBody != null)
        msgs = ((InternalEObject)newClassBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_BODY, null, msgs);
      msgs = basicSetClassBody(newClassBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_BODY, newClassBody, newClassBody));
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
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_DECLARATION:
        return basicSetClassDeclaration(null, msgs);
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_BODY:
        return basicSetClassBody(null, msgs);
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
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_DECLARATION:
        return getClassDeclaration();
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_BODY:
        return getClassBody();
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
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_DECLARATION:
        setClassDeclaration((ClassDeclaration)newValue);
        return;
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_BODY:
        setClassBody((ClassBody)newValue);
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
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_DECLARATION:
        setClassDeclaration((ClassDeclaration)null);
        return;
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_BODY:
        setClassBody((ClassBody)null);
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
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_DECLARATION:
        return classDeclaration != null;
      case AlfPackage.CLASS_DEFINITION_OR_STUB__CLASS_BODY:
        return classBody != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassDefinitionOrStubImpl
