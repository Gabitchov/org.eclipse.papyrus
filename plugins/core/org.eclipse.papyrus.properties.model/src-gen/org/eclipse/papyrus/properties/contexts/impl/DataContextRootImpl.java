/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.properties.contexts.DataContextRoot;

import org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Context Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.DataContextRootImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.DataContextRootImpl#getModelElementFactory <em>Model Element Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataContextRootImpl extends DataContextPackageImpl implements DataContextRoot {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElementFactory() <em>Model Element Factory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementFactory()
	 * @generated
	 * @ordered
	 */
	protected ModelElementFactoryDescriptor modelElementFactory;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataContextRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.DATA_CONTEXT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.DATA_CONTEXT_ROOT__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementFactoryDescriptor getModelElementFactory() {
		if (modelElementFactory != null && modelElementFactory.eIsProxy()) {
			InternalEObject oldModelElementFactory = (InternalEObject)modelElementFactory;
			modelElementFactory = (ModelElementFactoryDescriptor)eResolveProxy(oldModelElementFactory);
			if (modelElementFactory != oldModelElementFactory) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.DATA_CONTEXT_ROOT__MODEL_ELEMENT_FACTORY, oldModelElementFactory, modelElementFactory));
			}
		}
		return modelElementFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementFactoryDescriptor basicGetModelElementFactory() {
		return modelElementFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementFactory(ModelElementFactoryDescriptor newModelElementFactory) {
		ModelElementFactoryDescriptor oldModelElementFactory = modelElementFactory;
		modelElementFactory = newModelElementFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.DATA_CONTEXT_ROOT__MODEL_ELEMENT_FACTORY, oldModelElementFactory, modelElementFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ContextsPackage.DATA_CONTEXT_ROOT__LABEL:
				return getLabel();
			case ContextsPackage.DATA_CONTEXT_ROOT__MODEL_ELEMENT_FACTORY:
				if (resolve) return getModelElementFactory();
				return basicGetModelElementFactory();
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
			case ContextsPackage.DATA_CONTEXT_ROOT__LABEL:
				setLabel((String)newValue);
				return;
			case ContextsPackage.DATA_CONTEXT_ROOT__MODEL_ELEMENT_FACTORY:
				setModelElementFactory((ModelElementFactoryDescriptor)newValue);
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
			case ContextsPackage.DATA_CONTEXT_ROOT__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case ContextsPackage.DATA_CONTEXT_ROOT__MODEL_ELEMENT_FACTORY:
				setModelElementFactory((ModelElementFactoryDescriptor)null);
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
			case ContextsPackage.DATA_CONTEXT_ROOT__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case ContextsPackage.DATA_CONTEXT_ROOT__MODEL_ELEMENT_FACTORY:
				return modelElementFactory != null;
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
		result.append(" (label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //DataContextRootImpl
