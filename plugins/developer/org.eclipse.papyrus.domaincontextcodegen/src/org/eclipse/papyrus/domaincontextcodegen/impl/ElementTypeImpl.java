/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getHelper <em>Helper</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getOwner <em>Owner</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ElementTypeImpl extends EObjectImpl implements ElementType {

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getHelper() <em>Helper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHelper()
	 * @generated
	 * @ordered
	 */
	protected static final String HELPER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHelper() <em>Helper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHelper()
	 * @generated
	 * @ordered
	 */
	protected String helper = HELPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomaincontextcodegenPackage.Literals.ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getHelper() {
		return helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHelper(String newHelper) {
		String oldHelper = helper;
		helper = newHelper;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__HELPER, oldHelper, helper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementTypes getOwner() {
		if(eContainerFeatureID() != DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER)
			return null;
		return (ElementTypes)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOwner(ElementTypes newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOwner(ElementTypes newOwner) {
		if(newOwner != eInternalContainer() || (eContainerFeatureID() != DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER && newOwner != null)) {
			if(EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, DomaincontextcodegenPackage.ELEMENT_TYPES__TYPES, ElementTypes.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetOwner((ElementTypes)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER:
			return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER:
			return eInternalContainer().eInverseRemove(this, DomaincontextcodegenPackage.ELEMENT_TYPES__TYPES, ElementTypes.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case DomaincontextcodegenPackage.ELEMENT_TYPE__NAME:
			return getName();
		case DomaincontextcodegenPackage.ELEMENT_TYPE__HELPER:
			return getHelper();
		case DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER:
			return getOwner();
		case DomaincontextcodegenPackage.ELEMENT_TYPE__ICON:
			return getIcon();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case DomaincontextcodegenPackage.ELEMENT_TYPE__NAME:
			setName((String)newValue);
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPE__HELPER:
			setHelper((String)newValue);
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER:
			setOwner((ElementTypes)newValue);
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPE__ICON:
			setIcon((String)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case DomaincontextcodegenPackage.ELEMENT_TYPE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPE__HELPER:
			setHelper(HELPER_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER:
			setOwner((ElementTypes)null);
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPE__ICON:
			setIcon(ICON_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case DomaincontextcodegenPackage.ELEMENT_TYPE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DomaincontextcodegenPackage.ELEMENT_TYPE__HELPER:
			return HELPER_EDEFAULT == null ? helper != null : !HELPER_EDEFAULT.equals(helper);
		case DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER:
			return getOwner() != null;
		case DomaincontextcodegenPackage.ELEMENT_TYPE__ICON:
			return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", helper: ");
		result.append(helper);
		result.append(", icon: ");
		result.append(icon);
		result.append(')');
		return result.toString();
	}

} //ElementTypeImpl
