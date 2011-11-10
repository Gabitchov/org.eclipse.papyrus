/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ElementDescriptorImpl#getElementTypeId <em>Element Type Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ElementDescriptorImpl#getGraphicalHints <em>Graphical Hints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementDescriptorImpl extends EObjectImpl implements ElementDescriptor {
	/**
	 * The default value of the '{@link #getElementTypeId() <em>Element Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeId()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeId() <em>Element Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeId()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeId = ELEMENT_TYPE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGraphicalHints() <em>Graphical Hints</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicalHints()
	 * @generated
	 * @ordered
	 */
	protected EList<String> graphicalHints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PaletteconfigurationPackage.Literals.ELEMENT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementTypeId() {
		return elementTypeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeId(String newElementTypeId) {
		String oldElementTypeId = elementTypeId;
		elementTypeId = newElementTypeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__ELEMENT_TYPE_ID, oldElementTypeId, elementTypeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getGraphicalHints() {
		if (graphicalHints == null) {
			graphicalHints = new EDataTypeUniqueEList<String>(String.class, this, PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__GRAPHICAL_HINTS);
		}
		return graphicalHints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__ELEMENT_TYPE_ID:
				return getElementTypeId();
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__GRAPHICAL_HINTS:
				return getGraphicalHints();
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
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__ELEMENT_TYPE_ID:
				setElementTypeId((String)newValue);
				return;
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__GRAPHICAL_HINTS:
				getGraphicalHints().clear();
				getGraphicalHints().addAll((Collection<? extends String>)newValue);
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
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__ELEMENT_TYPE_ID:
				setElementTypeId(ELEMENT_TYPE_ID_EDEFAULT);
				return;
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__GRAPHICAL_HINTS:
				getGraphicalHints().clear();
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
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__ELEMENT_TYPE_ID:
				return ELEMENT_TYPE_ID_EDEFAULT == null ? elementTypeId != null : !ELEMENT_TYPE_ID_EDEFAULT.equals(elementTypeId);
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR__GRAPHICAL_HINTS:
				return graphicalHints != null && !graphicalHints.isEmpty();
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
		result.append(" (elementTypeId: ");
		result.append(elementTypeId);
		result.append(", graphicalHints: ");
		result.append(graphicalHints);
		result.append(')');
		return result.toString();
	}

} //ElementDescriptorImpl
