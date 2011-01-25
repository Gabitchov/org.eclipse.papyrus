/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.properties.contexts.ConfigProperty;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.properties.contexts.DisplayUnit;

import org.eclipse.papyrus.properties.environment.ConstraintType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl#getDisplay <em>Display</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl#getConstraintType <em>Constraint Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.ConstraintDescriptorImpl#getOverriddenConstraints <em>Overridden Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintDescriptorImpl extends EObjectImpl implements ConstraintDescriptor {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstraintType() <em>Constraint Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintType()
	 * @generated
	 * @ordered
	 */
	protected ConstraintType constraintType;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintDescriptor> constraints;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigProperty> properties;

	/**
	 * The cached value of the '{@link #getOverriddenConstraints() <em>Overridden Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverriddenConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintDescriptor> overriddenConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.CONSTRAINT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisplayUnit getDisplay() {
		if (eContainerFeatureID() != ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY) return null;
		return (DisplayUnit)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDisplay(DisplayUnit newDisplay, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDisplay, ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplay(DisplayUnit newDisplay) {
		if (newDisplay != eInternalContainer() || (eContainerFeatureID() != ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY && newDisplay != null)) {
			if (EcoreUtil.isAncestor(this, newDisplay))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDisplay != null)
				msgs = ((InternalEObject)newDisplay).eInverseAdd(this, ContextsPackage.DISPLAY_UNIT__CONSTRAINTS, DisplayUnit.class, msgs);
			msgs = basicSetDisplay(newDisplay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY, newDisplay, newDisplay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintType getConstraintType() {
		if (constraintType != null && constraintType.eIsProxy()) {
			InternalEObject oldConstraintType = (InternalEObject)constraintType;
			constraintType = (ConstraintType)eResolveProxy(oldConstraintType);
			if (constraintType != oldConstraintType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINT_TYPE, oldConstraintType, constraintType));
			}
		}
		return constraintType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintType basicGetConstraintType() {
		return constraintType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintType(ConstraintType newConstraintType) {
		ConstraintType oldConstraintType = constraintType;
		constraintType = newConstraintType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINT_TYPE, oldConstraintType, constraintType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintDescriptor> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<ConstraintDescriptor>(ConstraintDescriptor.class, this, ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<ConfigProperty>(ConfigProperty.class, this, ContextsPackage.CONSTRAINT_DESCRIPTOR__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintDescriptor> getOverriddenConstraints() {
		if (overriddenConstraints == null) {
			overriddenConstraints = new EObjectResolvingEList<ConstraintDescriptor>(ConstraintDescriptor.class, this, ContextsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS);
		}
		return overriddenConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDisplay((DisplayUnit)otherEnd, msgs);
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
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				return basicSetDisplay(null, msgs);
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__PROPERTIES:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				return eInternalContainer().eInverseRemove(this, ContextsPackage.DISPLAY_UNIT__CONSTRAINTS, DisplayUnit.class, msgs);
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
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__NAME:
				return getName();
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				return getDisplay();
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINT_TYPE:
				if (resolve) return getConstraintType();
				return basicGetConstraintType();
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINTS:
				return getConstraints();
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__PROPERTIES:
				return getProperties();
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS:
				return getOverriddenConstraints();
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
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				setDisplay((DisplayUnit)newValue);
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINT_TYPE:
				setConstraintType((ConstraintType)newValue);
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ConstraintDescriptor>)newValue);
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends ConfigProperty>)newValue);
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS:
				getOverriddenConstraints().clear();
				getOverriddenConstraints().addAll((Collection<? extends ConstraintDescriptor>)newValue);
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
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				setDisplay((DisplayUnit)null);
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINT_TYPE:
				setConstraintType((ConstraintType)null);
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINTS:
				getConstraints().clear();
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__PROPERTIES:
				getProperties().clear();
				return;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS:
				getOverriddenConstraints().clear();
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
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				return getDisplay() != null;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINT_TYPE:
				return constraintType != null;
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case ContextsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS:
				return overriddenConstraints != null && !overriddenConstraints.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ConstraintDescriptorImpl
