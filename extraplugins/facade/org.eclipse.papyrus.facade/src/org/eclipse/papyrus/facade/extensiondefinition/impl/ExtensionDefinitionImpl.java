/**
 */
package org.eclipse.papyrus.facade.extensiondefinition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.FacadePackage;

import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;

import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensionDefinitionImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensionDefinitionImpl#getBaseMetaclasses <em>Base Metaclasses</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensionDefinitionImpl#getFacade <em>Facade</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensionDefinitionImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensionDefinitionImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionDefinitionImpl extends MinimalEObjectImpl.Container implements ExtensionDefinition {
	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected Extension extension;

	/**
	 * The cached value of the '{@link #getBaseMetaclasses() <em>Base Metaclasses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseMetaclasses()
	 * @generated
	 * @ordered
	 */
	protected EList<BaseMetaclass> baseMetaclasses;

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
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ExtensionDefinitionKind KIND_EDEFAULT = ExtensionDefinitionKind.ASSOCIATION;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ExtensionDefinitionKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtensiondefinitionPackage.Literals.EXTENSION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension getExtension() {
		if (extension != null && extension.eIsProxy()) {
			InternalEObject oldExtension = (InternalEObject)extension;
			extension = (Extension)eResolveProxy(oldExtension);
			if (extension != oldExtension) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtensiondefinitionPackage.EXTENSION_DEFINITION__EXTENSION, oldExtension, extension));
			}
		}
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension basicGetExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(Extension newExtension) {
		Extension oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensiondefinitionPackage.EXTENSION_DEFINITION__EXTENSION, oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BaseMetaclass> getBaseMetaclasses() {
		if (baseMetaclasses == null) {
			baseMetaclasses = new EObjectContainmentWithInverseEList<BaseMetaclass>(BaseMetaclass.class, this, ExtensiondefinitionPackage.EXTENSION_DEFINITION__BASE_METACLASSES, ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION);
		}
		return baseMetaclasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Facade getFacade() {
		if (eContainerFeatureID() != ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE) return null;
		return (Facade)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFacade(Facade newFacade, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFacade, ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacade(Facade newFacade) {
		if (newFacade != eInternalContainer() || (eContainerFeatureID() != ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE && newFacade != null)) {
			if (EcoreUtil.isAncestor(this, newFacade))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFacade != null)
				msgs = ((InternalEObject)newFacade).eInverseAdd(this, FacadePackage.FACADE__EXTENSION_DEFINITIONS, Facade.class, msgs);
			msgs = basicSetFacade(newFacade, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE, newFacade, newFacade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype getStereotype() {
		if (stereotype != null && stereotype.eIsProxy()) {
			InternalEObject oldStereotype = (InternalEObject)stereotype;
			stereotype = (Stereotype)eResolveProxy(oldStereotype);
			if (stereotype != oldStereotype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtensiondefinitionPackage.EXTENSION_DEFINITION__STEREOTYPE, oldStereotype, stereotype));
			}
		}
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype basicGetStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(Stereotype newStereotype) {
		Stereotype oldStereotype = stereotype;
		stereotype = newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensiondefinitionPackage.EXTENSION_DEFINITION__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionDefinitionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ExtensionDefinitionKind newKind) {
		ExtensionDefinitionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensiondefinitionPackage.EXTENSION_DEFINITION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__BASE_METACLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBaseMetaclasses()).basicAdd(otherEnd, msgs);
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFacade((Facade)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__BASE_METACLASSES:
				return ((InternalEList<?>)getBaseMetaclasses()).basicRemove(otherEnd, msgs);
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE:
				return basicSetFacade(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE:
				return eInternalContainer().eInverseRemove(this, FacadePackage.FACADE__EXTENSION_DEFINITIONS, Facade.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__EXTENSION:
				if (resolve) return getExtension();
				return basicGetExtension();
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__BASE_METACLASSES:
				return getBaseMetaclasses();
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE:
				return getFacade();
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__STEREOTYPE:
				if (resolve) return getStereotype();
				return basicGetStereotype();
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__KIND:
				return getKind();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__EXTENSION:
				setExtension((Extension)newValue);
				return;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__BASE_METACLASSES:
				getBaseMetaclasses().clear();
				getBaseMetaclasses().addAll((Collection<? extends BaseMetaclass>)newValue);
				return;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE:
				setFacade((Facade)newValue);
				return;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__STEREOTYPE:
				setStereotype((Stereotype)newValue);
				return;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__KIND:
				setKind((ExtensionDefinitionKind)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__EXTENSION:
				setExtension((Extension)null);
				return;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__BASE_METACLASSES:
				getBaseMetaclasses().clear();
				return;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE:
				setFacade((Facade)null);
				return;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__STEREOTYPE:
				setStereotype((Stereotype)null);
				return;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__KIND:
				setKind(KIND_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__EXTENSION:
				return extension != null;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__BASE_METACLASSES:
				return baseMetaclasses != null && !baseMetaclasses.isEmpty();
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE:
				return getFacade() != null;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__STEREOTYPE:
				return stereotype != null;
			case ExtensiondefinitionPackage.EXTENSION_DEFINITION__KIND:
				return kind != KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //ExtensionDefinitionImpl
