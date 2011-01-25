/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.environment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.properties.contexts.Context;

import org.eclipse.papyrus.properties.environment.CompositeWidgetType;
import org.eclipse.papyrus.properties.environment.ConstraintType;
import org.eclipse.papyrus.properties.environment.Environment;
import org.eclipse.papyrus.properties.environment.EnvironmentPackage;
import org.eclipse.papyrus.properties.environment.LayoutType;
import org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor;
import org.eclipse.papyrus.properties.environment.PropertyEditorType;
import org.eclipse.papyrus.properties.environment.StandardWidgetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl#getModelElementFactories <em>Model Element Factories</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl#getConstraintTypes <em>Constraint Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl#getWidgetTypes <em>Widget Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl#getPropertyEditorTypes <em>Property Editor Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl#getCompositeWidgetTypes <em>Composite Widget Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.impl.EnvironmentImpl#getLayoutTypes <em>Layout Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentImpl extends EObjectImpl implements Environment {
	/**
	 * The cached value of the '{@link #getModelElementFactories() <em>Model Element Factories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementFactories()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementFactoryDescriptor> modelElementFactories;

	/**
	 * The cached value of the '{@link #getConstraintTypes() <em>Constraint Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintType> constraintTypes;

	/**
	 * The cached value of the '{@link #getWidgetTypes() <em>Widget Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidgetTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<StandardWidgetType> widgetTypes;

	/**
	 * The cached value of the '{@link #getPropertyEditorTypes() <em>Property Editor Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyEditorTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyEditorType> propertyEditorTypes;

	/**
	 * The cached value of the '{@link #getCompositeWidgetTypes() <em>Composite Widget Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeWidgetTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeWidgetType> compositeWidgetTypes;

	/**
	 * The cached value of the '{@link #getLayoutTypes() <em>Layout Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<LayoutType> layoutTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementFactoryDescriptor> getModelElementFactories() {
		if (modelElementFactories == null) {
			modelElementFactories = new EObjectContainmentEList<ModelElementFactoryDescriptor>(ModelElementFactoryDescriptor.class, this, EnvironmentPackage.ENVIRONMENT__MODEL_ELEMENT_FACTORIES);
		}
		return modelElementFactories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintType> getConstraintTypes() {
		if (constraintTypes == null) {
			constraintTypes = new EObjectContainmentEList<ConstraintType>(ConstraintType.class, this, EnvironmentPackage.ENVIRONMENT__CONSTRAINT_TYPES);
		}
		return constraintTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StandardWidgetType> getWidgetTypes() {
		if (widgetTypes == null) {
			widgetTypes = new EObjectContainmentEList<StandardWidgetType>(StandardWidgetType.class, this, EnvironmentPackage.ENVIRONMENT__WIDGET_TYPES);
		}
		return widgetTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyEditorType> getPropertyEditorTypes() {
		if (propertyEditorTypes == null) {
			propertyEditorTypes = new EObjectContainmentEList<PropertyEditorType>(PropertyEditorType.class, this, EnvironmentPackage.ENVIRONMENT__PROPERTY_EDITOR_TYPES);
		}
		return propertyEditorTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompositeWidgetType> getCompositeWidgetTypes() {
		if (compositeWidgetTypes == null) {
			compositeWidgetTypes = new EObjectContainmentEList<CompositeWidgetType>(CompositeWidgetType.class, this, EnvironmentPackage.ENVIRONMENT__COMPOSITE_WIDGET_TYPES);
		}
		return compositeWidgetTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LayoutType> getLayoutTypes() {
		if (layoutTypes == null) {
			layoutTypes = new EObjectContainmentEList<LayoutType>(LayoutType.class, this, EnvironmentPackage.ENVIRONMENT__LAYOUT_TYPES);
		}
		return layoutTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EnvironmentPackage.ENVIRONMENT__MODEL_ELEMENT_FACTORIES:
				return ((InternalEList<?>)getModelElementFactories()).basicRemove(otherEnd, msgs);
			case EnvironmentPackage.ENVIRONMENT__CONSTRAINT_TYPES:
				return ((InternalEList<?>)getConstraintTypes()).basicRemove(otherEnd, msgs);
			case EnvironmentPackage.ENVIRONMENT__WIDGET_TYPES:
				return ((InternalEList<?>)getWidgetTypes()).basicRemove(otherEnd, msgs);
			case EnvironmentPackage.ENVIRONMENT__PROPERTY_EDITOR_TYPES:
				return ((InternalEList<?>)getPropertyEditorTypes()).basicRemove(otherEnd, msgs);
			case EnvironmentPackage.ENVIRONMENT__COMPOSITE_WIDGET_TYPES:
				return ((InternalEList<?>)getCompositeWidgetTypes()).basicRemove(otherEnd, msgs);
			case EnvironmentPackage.ENVIRONMENT__LAYOUT_TYPES:
				return ((InternalEList<?>)getLayoutTypes()).basicRemove(otherEnd, msgs);
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
			case EnvironmentPackage.ENVIRONMENT__MODEL_ELEMENT_FACTORIES:
				return getModelElementFactories();
			case EnvironmentPackage.ENVIRONMENT__CONSTRAINT_TYPES:
				return getConstraintTypes();
			case EnvironmentPackage.ENVIRONMENT__WIDGET_TYPES:
				return getWidgetTypes();
			case EnvironmentPackage.ENVIRONMENT__PROPERTY_EDITOR_TYPES:
				return getPropertyEditorTypes();
			case EnvironmentPackage.ENVIRONMENT__COMPOSITE_WIDGET_TYPES:
				return getCompositeWidgetTypes();
			case EnvironmentPackage.ENVIRONMENT__LAYOUT_TYPES:
				return getLayoutTypes();
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
			case EnvironmentPackage.ENVIRONMENT__MODEL_ELEMENT_FACTORIES:
				getModelElementFactories().clear();
				getModelElementFactories().addAll((Collection<? extends ModelElementFactoryDescriptor>)newValue);
				return;
			case EnvironmentPackage.ENVIRONMENT__CONSTRAINT_TYPES:
				getConstraintTypes().clear();
				getConstraintTypes().addAll((Collection<? extends ConstraintType>)newValue);
				return;
			case EnvironmentPackage.ENVIRONMENT__WIDGET_TYPES:
				getWidgetTypes().clear();
				getWidgetTypes().addAll((Collection<? extends StandardWidgetType>)newValue);
				return;
			case EnvironmentPackage.ENVIRONMENT__PROPERTY_EDITOR_TYPES:
				getPropertyEditorTypes().clear();
				getPropertyEditorTypes().addAll((Collection<? extends PropertyEditorType>)newValue);
				return;
			case EnvironmentPackage.ENVIRONMENT__COMPOSITE_WIDGET_TYPES:
				getCompositeWidgetTypes().clear();
				getCompositeWidgetTypes().addAll((Collection<? extends CompositeWidgetType>)newValue);
				return;
			case EnvironmentPackage.ENVIRONMENT__LAYOUT_TYPES:
				getLayoutTypes().clear();
				getLayoutTypes().addAll((Collection<? extends LayoutType>)newValue);
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
			case EnvironmentPackage.ENVIRONMENT__MODEL_ELEMENT_FACTORIES:
				getModelElementFactories().clear();
				return;
			case EnvironmentPackage.ENVIRONMENT__CONSTRAINT_TYPES:
				getConstraintTypes().clear();
				return;
			case EnvironmentPackage.ENVIRONMENT__WIDGET_TYPES:
				getWidgetTypes().clear();
				return;
			case EnvironmentPackage.ENVIRONMENT__PROPERTY_EDITOR_TYPES:
				getPropertyEditorTypes().clear();
				return;
			case EnvironmentPackage.ENVIRONMENT__COMPOSITE_WIDGET_TYPES:
				getCompositeWidgetTypes().clear();
				return;
			case EnvironmentPackage.ENVIRONMENT__LAYOUT_TYPES:
				getLayoutTypes().clear();
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
			case EnvironmentPackage.ENVIRONMENT__MODEL_ELEMENT_FACTORIES:
				return modelElementFactories != null && !modelElementFactories.isEmpty();
			case EnvironmentPackage.ENVIRONMENT__CONSTRAINT_TYPES:
				return constraintTypes != null && !constraintTypes.isEmpty();
			case EnvironmentPackage.ENVIRONMENT__WIDGET_TYPES:
				return widgetTypes != null && !widgetTypes.isEmpty();
			case EnvironmentPackage.ENVIRONMENT__PROPERTY_EDITOR_TYPES:
				return propertyEditorTypes != null && !propertyEditorTypes.isEmpty();
			case EnvironmentPackage.ENVIRONMENT__COMPOSITE_WIDGET_TYPES:
				return compositeWidgetTypes != null && !compositeWidgetTypes.isEmpty();
			case EnvironmentPackage.ENVIRONMENT__LAYOUT_TYPES:
				return layoutTypes != null && !layoutTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnvironmentImpl
