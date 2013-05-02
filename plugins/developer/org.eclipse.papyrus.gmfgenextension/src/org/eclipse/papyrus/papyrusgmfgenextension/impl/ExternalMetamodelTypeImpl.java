/**
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.codegen.gmfgen.impl.MetamodelTypeImpl;

import org.eclipse.papyrus.domaincontextcodegen.ElementType;

import org.eclipse.papyrus.papyrusgmfgenextension.ExternalMetamodelType;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Metamodel Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalMetamodelTypeImpl#getElementTypeRef <em>Element Type Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalMetamodelTypeImpl extends MetamodelTypeImpl implements ExternalMetamodelType {
	/**
	 * The cached value of the '{@link #getElementTypeRef() <em>Element Type Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeRef()
	 * @generated
	 * @ordered
	 */
	protected ElementType elementTypeRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalMetamodelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusgmfgenextensionPackage.Literals.EXTERNAL_METAMODEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementType getElementTypeRef() {
		if (elementTypeRef != null && elementTypeRef.eIsProxy()) {
			InternalEObject oldElementTypeRef = (InternalEObject)elementTypeRef;
			elementTypeRef = (ElementType)eResolveProxy(oldElementTypeRef);
			if (elementTypeRef != oldElementTypeRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusgmfgenextensionPackage.EXTERNAL_METAMODEL_TYPE__ELEMENT_TYPE_REF, oldElementTypeRef, elementTypeRef));
			}
		}
		return elementTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementType basicGetElementTypeRef() {
		return elementTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeRef(ElementType newElementTypeRef) {
		ElementType oldElementTypeRef = elementTypeRef;
		elementTypeRef = newElementTypeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.EXTERNAL_METAMODEL_TYPE__ELEMENT_TYPE_REF, oldElementTypeRef, elementTypeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrusgmfgenextensionPackage.EXTERNAL_METAMODEL_TYPE__ELEMENT_TYPE_REF:
				if (resolve) return getElementTypeRef();
				return basicGetElementTypeRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PapyrusgmfgenextensionPackage.EXTERNAL_METAMODEL_TYPE__ELEMENT_TYPE_REF:
				setElementTypeRef((ElementType)newValue);
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
			case PapyrusgmfgenextensionPackage.EXTERNAL_METAMODEL_TYPE__ELEMENT_TYPE_REF:
				setElementTypeRef((ElementType)null);
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
			case PapyrusgmfgenextensionPackage.EXTERNAL_METAMODEL_TYPE__ELEMENT_TYPE_REF:
				return elementTypeRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ExternalMetamodelTypeImpl
