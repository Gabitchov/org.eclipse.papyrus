/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.properties.generation.fieldselection.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelection;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.impl.FieldSelectionImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.impl.FieldSelectionImpl#getContextElements <em>Context Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldSelectionImpl extends EObjectImpl implements FieldSelection {

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyDefinition> fields;

	/**
	 * The cached value of the '{@link #getContextElements() <em>Context Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ContextElement> contextElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FieldSelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FieldSelectionPackage.Literals.FIELD_SELECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyDefinition> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentEList<PropertyDefinition>(PropertyDefinition.class, this, FieldSelectionPackage.FIELD_SELECTION__FIELDS);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContextElement> getContextElements() {
		if (contextElements == null) {
			contextElements = new EObjectContainmentEList<ContextElement>(ContextElement.class, this, FieldSelectionPackage.FIELD_SELECTION__CONTEXT_ELEMENTS);
		}
		return contextElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FieldSelectionPackage.FIELD_SELECTION__FIELDS:
				return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
			case FieldSelectionPackage.FIELD_SELECTION__CONTEXT_ELEMENTS:
				return ((InternalEList<?>)getContextElements()).basicRemove(otherEnd, msgs);
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
			case FieldSelectionPackage.FIELD_SELECTION__FIELDS:
				return getFields();
			case FieldSelectionPackage.FIELD_SELECTION__CONTEXT_ELEMENTS:
				return getContextElements();
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
			case FieldSelectionPackage.FIELD_SELECTION__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends PropertyDefinition>)newValue);
				return;
			case FieldSelectionPackage.FIELD_SELECTION__CONTEXT_ELEMENTS:
				getContextElements().clear();
				getContextElements().addAll((Collection<? extends ContextElement>)newValue);
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
			case FieldSelectionPackage.FIELD_SELECTION__FIELDS:
				getFields().clear();
				return;
			case FieldSelectionPackage.FIELD_SELECTION__CONTEXT_ELEMENTS:
				getContextElements().clear();
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
			case FieldSelectionPackage.FIELD_SELECTION__FIELDS:
				return fields != null && !fields.isEmpty();
			case FieldSelectionPackage.FIELD_SELECTION__CONTEXT_ELEMENTS:
				return contextElements != null && !contextElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FieldSelectionImpl
