/**
 */
package org.eclipse.papyrus.facade.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.FacadePackage;

import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;

import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facade</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.impl.FacadeImpl#getExtensionDefinitions <em>Extension Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.impl.FacadeImpl#getVirtualmetamodel <em>Virtualmetamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacadeImpl extends MinimalEObjectImpl.Container implements Facade {
	/**
	 * The cached value of the '{@link #getExtensionDefinitions() <em>Extension Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionDefinition> extensionDefinitions;

	/**
	 * The cached value of the '{@link #getVirtualmetamodel() <em>Virtualmetamodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualmetamodel()
	 * @generated
	 * @ordered
	 */
	protected VirtualMetamodel virtualmetamodel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacadeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FacadePackage.Literals.FACADE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionDefinition> getExtensionDefinitions() {
		if (extensionDefinitions == null) {
			extensionDefinitions = new EObjectContainmentWithInverseEList<ExtensionDefinition>(ExtensionDefinition.class, this, FacadePackage.FACADE__EXTENSION_DEFINITIONS, ExtensiondefinitionPackage.EXTENSION_DEFINITION__FACADE);
		}
		return extensionDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualMetamodel getVirtualmetamodel() {
		return virtualmetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVirtualmetamodel(VirtualMetamodel newVirtualmetamodel, NotificationChain msgs) {
		VirtualMetamodel oldVirtualmetamodel = virtualmetamodel;
		virtualmetamodel = newVirtualmetamodel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FacadePackage.FACADE__VIRTUALMETAMODEL, oldVirtualmetamodel, newVirtualmetamodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtualmetamodel(VirtualMetamodel newVirtualmetamodel) {
		if (newVirtualmetamodel != virtualmetamodel) {
			NotificationChain msgs = null;
			if (virtualmetamodel != null)
				msgs = ((InternalEObject)virtualmetamodel).eInverseRemove(this, VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE, VirtualMetamodel.class, msgs);
			if (newVirtualmetamodel != null)
				msgs = ((InternalEObject)newVirtualmetamodel).eInverseAdd(this, VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE, VirtualMetamodel.class, msgs);
			msgs = basicSetVirtualmetamodel(newVirtualmetamodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FacadePackage.FACADE__VIRTUALMETAMODEL, newVirtualmetamodel, newVirtualmetamodel));
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
			case FacadePackage.FACADE__EXTENSION_DEFINITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtensionDefinitions()).basicAdd(otherEnd, msgs);
			case FacadePackage.FACADE__VIRTUALMETAMODEL:
				if (virtualmetamodel != null)
					msgs = ((InternalEObject)virtualmetamodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FacadePackage.FACADE__VIRTUALMETAMODEL, null, msgs);
				return basicSetVirtualmetamodel((VirtualMetamodel)otherEnd, msgs);
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
			case FacadePackage.FACADE__EXTENSION_DEFINITIONS:
				return ((InternalEList<?>)getExtensionDefinitions()).basicRemove(otherEnd, msgs);
			case FacadePackage.FACADE__VIRTUALMETAMODEL:
				return basicSetVirtualmetamodel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FacadePackage.FACADE__EXTENSION_DEFINITIONS:
				return getExtensionDefinitions();
			case FacadePackage.FACADE__VIRTUALMETAMODEL:
				return getVirtualmetamodel();
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
			case FacadePackage.FACADE__EXTENSION_DEFINITIONS:
				getExtensionDefinitions().clear();
				getExtensionDefinitions().addAll((Collection<? extends ExtensionDefinition>)newValue);
				return;
			case FacadePackage.FACADE__VIRTUALMETAMODEL:
				setVirtualmetamodel((VirtualMetamodel)newValue);
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
			case FacadePackage.FACADE__EXTENSION_DEFINITIONS:
				getExtensionDefinitions().clear();
				return;
			case FacadePackage.FACADE__VIRTUALMETAMODEL:
				setVirtualmetamodel((VirtualMetamodel)null);
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
			case FacadePackage.FACADE__EXTENSION_DEFINITIONS:
				return extensionDefinitions != null && !extensionDefinitions.isEmpty();
			case FacadePackage.FACADE__VIRTUALMETAMODEL:
				return virtualmetamodel != null;
		}
		return super.eIsSet(featureID);
	}

} //FacadeImpl
