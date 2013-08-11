/**
 */
package org.eclipse.papyrus.facade.virtualmetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;

import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Metaclass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl#getAppliedStereotypes <em>Applied Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetaclassImpl#isStereotypeInterface <em>Stereotype Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualMetaclassImpl extends VirtualClassifierImpl implements VirtualMetaclass {
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAppliedStereotypes() <em>Applied Stereotypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<BaseMetaclass> appliedStereotypes;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualOperation> operations;

	/**
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualMetaclass> parents;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualProperty> properties;

	/**
	 * The default value of the '{@link #isStereotypeInterface() <em>Stereotype Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStereotypeInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STEREOTYPE_INTERFACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStereotypeInterface() <em>Stereotype Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStereotypeInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean stereotypeInterface = STEREOTYPE_INTERFACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualMetaclassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VirtualmetamodelPackage.Literals.VIRTUAL_METACLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_METACLASS__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BaseMetaclass> getAppliedStereotypes() {
		if (appliedStereotypes == null) {
			appliedStereotypes = new EObjectResolvingEList<BaseMetaclass>(BaseMetaclass.class, this, VirtualmetamodelPackage.VIRTUAL_METACLASS__APPLIED_STEREOTYPES);
		}
		return appliedStereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<VirtualOperation>(VirtualOperation.class, this, VirtualmetamodelPackage.VIRTUAL_METACLASS__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualMetaclass> getParents() {
		if (parents == null) {
			parents = new EObjectResolvingEList<VirtualMetaclass>(VirtualMetaclass.class, this, VirtualmetamodelPackage.VIRTUAL_METACLASS__PARENTS);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentWithInverseEList<VirtualProperty>(VirtualProperty.class, this, VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES, VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStereotypeInterface() {
		return stereotypeInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypeInterface(boolean newStereotypeInterface) {
		boolean oldStereotypeInterface = stereotypeInterface;
		stereotypeInterface = newStereotypeInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_METACLASS__STEREOTYPE_INTERFACE, oldStereotypeInterface, stereotypeInterface));
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
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProperties()).basicAdd(otherEnd, msgs);
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
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__ABSTRACT:
				return isAbstract();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__APPLIED_STEREOTYPES:
				return getAppliedStereotypes();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__OPERATIONS:
				return getOperations();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PARENTS:
				return getParents();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES:
				return getProperties();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__STEREOTYPE_INTERFACE:
				return isStereotypeInterface();
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
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__APPLIED_STEREOTYPES:
				getAppliedStereotypes().clear();
				getAppliedStereotypes().addAll((Collection<? extends BaseMetaclass>)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends VirtualOperation>)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends VirtualMetaclass>)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends VirtualProperty>)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__STEREOTYPE_INTERFACE:
				setStereotypeInterface((Boolean)newValue);
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
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__APPLIED_STEREOTYPES:
				getAppliedStereotypes().clear();
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__OPERATIONS:
				getOperations().clear();
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PARENTS:
				getParents().clear();
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES:
				getProperties().clear();
				return;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__STEREOTYPE_INTERFACE:
				setStereotypeInterface(STEREOTYPE_INTERFACE_EDEFAULT);
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
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__APPLIED_STEREOTYPES:
				return appliedStereotypes != null && !appliedStereotypes.isEmpty();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PARENTS:
				return parents != null && !parents.isEmpty();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS__STEREOTYPE_INTERFACE:
				return stereotypeInterface != STEREOTYPE_INTERFACE_EDEFAULT;
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
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(", stereotypeInterface: ");
		result.append(stereotypeInterface);
		result.append(')');
		return result.toString();
	}

} //VirtualMetaclassImpl
