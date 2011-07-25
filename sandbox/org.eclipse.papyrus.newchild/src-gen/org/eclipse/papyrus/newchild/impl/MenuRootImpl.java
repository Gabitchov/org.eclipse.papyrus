/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.constraints.ConstraintsPackage;
import org.eclipse.papyrus.constraints.DisplayUnit;

import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.MenuRoot;
import org.eclipse.papyrus.newchild.NewchildPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.impl.MenuRootImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.impl.MenuRootImpl#getElementMultiplicity <em>Element Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.impl.MenuRootImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.impl.MenuRootImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuRootImpl extends MenuContainerImpl implements MenuRoot {
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
	 * The default value of the '{@link #getElementMultiplicity() <em>Element Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final int ELEMENT_MULTIPLICITY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getElementMultiplicity() <em>Element Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected int elementMultiplicity = ELEMENT_MULTIPLICITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<MenuGroup> groups;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NewchildPackage.Literals.MENU_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintDescriptor> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentWithInverseEList<ConstraintDescriptor>(ConstraintDescriptor.class, this, NewchildPackage.MENU_ROOT__CONSTRAINTS, ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getElementMultiplicity() {
		return elementMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementMultiplicity(int newElementMultiplicity) {
		int oldElementMultiplicity = elementMultiplicity;
		elementMultiplicity = newElementMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.MENU_ROOT__ELEMENT_MULTIPLICITY, oldElementMultiplicity, elementMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MenuGroup> getGroups() {
		if (groups == null) {
			groups = new EObjectContainmentEList<MenuGroup>(MenuGroup.class, this, NewchildPackage.MENU_ROOT__GROUPS);
		}
		return groups;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.MENU_ROOT__NAME, oldName, name));
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
			case NewchildPackage.MENU_ROOT__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
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
			case NewchildPackage.MENU_ROOT__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case NewchildPackage.MENU_ROOT__GROUPS:
				return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
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
			case NewchildPackage.MENU_ROOT__CONSTRAINTS:
				return getConstraints();
			case NewchildPackage.MENU_ROOT__ELEMENT_MULTIPLICITY:
				return getElementMultiplicity();
			case NewchildPackage.MENU_ROOT__GROUPS:
				return getGroups();
			case NewchildPackage.MENU_ROOT__NAME:
				return getName();
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
			case NewchildPackage.MENU_ROOT__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ConstraintDescriptor>)newValue);
				return;
			case NewchildPackage.MENU_ROOT__ELEMENT_MULTIPLICITY:
				setElementMultiplicity((Integer)newValue);
				return;
			case NewchildPackage.MENU_ROOT__GROUPS:
				getGroups().clear();
				getGroups().addAll((Collection<? extends MenuGroup>)newValue);
				return;
			case NewchildPackage.MENU_ROOT__NAME:
				setName((String)newValue);
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
			case NewchildPackage.MENU_ROOT__CONSTRAINTS:
				getConstraints().clear();
				return;
			case NewchildPackage.MENU_ROOT__ELEMENT_MULTIPLICITY:
				setElementMultiplicity(ELEMENT_MULTIPLICITY_EDEFAULT);
				return;
			case NewchildPackage.MENU_ROOT__GROUPS:
				getGroups().clear();
				return;
			case NewchildPackage.MENU_ROOT__NAME:
				setName(NAME_EDEFAULT);
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
			case NewchildPackage.MENU_ROOT__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case NewchildPackage.MENU_ROOT__ELEMENT_MULTIPLICITY:
				return elementMultiplicity != ELEMENT_MULTIPLICITY_EDEFAULT;
			case NewchildPackage.MENU_ROOT__GROUPS:
				return groups != null && !groups.isEmpty();
			case NewchildPackage.MENU_ROOT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DisplayUnit.class) {
			switch (derivedFeatureID) {
				case NewchildPackage.MENU_ROOT__CONSTRAINTS: return ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS;
				case NewchildPackage.MENU_ROOT__ELEMENT_MULTIPLICITY: return ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DisplayUnit.class) {
			switch (baseFeatureID) {
				case ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS: return NewchildPackage.MENU_ROOT__CONSTRAINTS;
				case ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY: return NewchildPackage.MENU_ROOT__ELEMENT_MULTIPLICITY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (elementMultiplicity: ");
		result.append(elementMultiplicity);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MenuRootImpl
