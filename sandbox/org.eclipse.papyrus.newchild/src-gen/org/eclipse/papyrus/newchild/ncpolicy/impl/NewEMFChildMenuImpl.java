/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.ncpolicy.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.newchild.MenuGroup;

import org.eclipse.papyrus.newchild.impl.MenuImpl;

import org.eclipse.papyrus.newchild.ncpolicy.CreateIn;
import org.eclipse.papyrus.newchild.ncpolicy.Layout;
import org.eclipse.papyrus.newchild.ncpolicy.NcpolicyPackage;
import org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New EMF Child Menu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewEMFChildMenuImpl#getCreateIn <em>Create In</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewEMFChildMenuImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewEMFChildMenuImpl#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewEMFChildMenuImpl extends MenuImpl implements NewEMFChildMenu {
	/**
	 * The default value of the '{@link #getCreateIn() <em>Create In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateIn()
	 * @generated
	 * @ordered
	 */
	protected static final CreateIn CREATE_IN_EDEFAULT = CreateIn.SELF;

	/**
	 * The cached value of the '{@link #getCreateIn() <em>Create In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateIn()
	 * @generated
	 * @ordered
	 */
	protected CreateIn createIn = CREATE_IN_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected static final Layout LAYOUT_EDEFAULT = Layout.HIERARCHICAL;

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected Layout layout = LAYOUT_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewEMFChildMenuImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NcpolicyPackage.Literals.NEW_EMF_CHILD_MENU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateIn getCreateIn() {
		return createIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateIn(CreateIn newCreateIn) {
		CreateIn oldCreateIn = createIn;
		createIn = newCreateIn == null ? CREATE_IN_EDEFAULT : newCreateIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NcpolicyPackage.NEW_EMF_CHILD_MENU__CREATE_IN, oldCreateIn, createIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout getLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayout(Layout newLayout) {
		Layout oldLayout = layout;
		layout = newLayout == null ? LAYOUT_EDEFAULT : newLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NcpolicyPackage.NEW_EMF_CHILD_MENU__LAYOUT, oldLayout, layout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MenuGroup> getGroups() {
		if (groups == null) {
			groups = new EObjectContainmentEList<MenuGroup>(MenuGroup.class, this, NcpolicyPackage.NEW_EMF_CHILD_MENU__GROUPS);
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__GROUPS:
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
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__CREATE_IN:
				return getCreateIn();
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__LAYOUT:
				return getLayout();
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__GROUPS:
				return getGroups();
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
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__CREATE_IN:
				setCreateIn((CreateIn)newValue);
				return;
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__LAYOUT:
				setLayout((Layout)newValue);
				return;
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__GROUPS:
				getGroups().clear();
				getGroups().addAll((Collection<? extends MenuGroup>)newValue);
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
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__CREATE_IN:
				setCreateIn(CREATE_IN_EDEFAULT);
				return;
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__LAYOUT:
				setLayout(LAYOUT_EDEFAULT);
				return;
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__GROUPS:
				getGroups().clear();
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
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__CREATE_IN:
				return createIn != CREATE_IN_EDEFAULT;
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__LAYOUT:
				return layout != LAYOUT_EDEFAULT;
			case NcpolicyPackage.NEW_EMF_CHILD_MENU__GROUPS:
				return groups != null && !groups.isEmpty();
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
		result.append(" (createIn: ");
		result.append(createIn);
		result.append(", layout: ");
		result.append(layout);
		result.append(')');
		return result.toString();
	}

} //NewEMFChildMenuImpl
