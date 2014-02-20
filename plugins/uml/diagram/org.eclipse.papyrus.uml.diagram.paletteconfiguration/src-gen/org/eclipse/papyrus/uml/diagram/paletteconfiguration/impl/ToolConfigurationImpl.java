/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tool Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ToolConfigurationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ToolConfigurationImpl#getElementDescriptors <em>Element Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToolConfigurationImpl extends LeafConfigurationImpl implements ToolConfiguration {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ToolKind KIND_EDEFAULT = ToolKind.CREATION_TOOL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ToolKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElementDescriptors() <em>Element Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementDescriptor> elementDescriptors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PaletteconfigurationPackage.Literals.TOOL_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ToolKind newKind) {
		ToolKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PaletteconfigurationPackage.TOOL_CONFIGURATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementDescriptor> getElementDescriptors() {
		if (elementDescriptors == null) {
			elementDescriptors = new EObjectContainmentEList<ElementDescriptor>(ElementDescriptor.class, this, PaletteconfigurationPackage.TOOL_CONFIGURATION__ELEMENT_DESCRIPTORS);
		}
		return elementDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PaletteconfigurationPackage.TOOL_CONFIGURATION__ELEMENT_DESCRIPTORS:
				return ((InternalEList<?>)getElementDescriptors()).basicRemove(otherEnd, msgs);
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
			case PaletteconfigurationPackage.TOOL_CONFIGURATION__KIND:
				return getKind();
			case PaletteconfigurationPackage.TOOL_CONFIGURATION__ELEMENT_DESCRIPTORS:
				return getElementDescriptors();
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
			case PaletteconfigurationPackage.TOOL_CONFIGURATION__KIND:
				setKind((ToolKind)newValue);
				return;
			case PaletteconfigurationPackage.TOOL_CONFIGURATION__ELEMENT_DESCRIPTORS:
				getElementDescriptors().clear();
				getElementDescriptors().addAll((Collection<? extends ElementDescriptor>)newValue);
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
			case PaletteconfigurationPackage.TOOL_CONFIGURATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case PaletteconfigurationPackage.TOOL_CONFIGURATION__ELEMENT_DESCRIPTORS:
				getElementDescriptors().clear();
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
			case PaletteconfigurationPackage.TOOL_CONFIGURATION__KIND:
				return kind != KIND_EDEFAULT;
			case PaletteconfigurationPackage.TOOL_CONFIGURATION__ELEMENT_DESCRIPTORS:
				return elementDescriptors != null && !elementDescriptors.isEmpty();
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

} //ToolConfigurationImpl
