/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registry Id Desc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl#isUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl#getSets <em>Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl#getParents <em>Parents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistryIdDescImpl extends EObjectImpl implements RegistryIdDesc {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnique = IS_UNIQUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSets() <em>Sets</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSets()
	 * @generated
	 * @ordered
	 */
	protected EList<String> sets;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<String> extends_;

	/**
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<String> parents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegistryIdDescImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorswithidPackage.Literals.REGISTRY_ID_DESC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.REGISTRY_ID_DESC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.REGISTRY_ID_DESC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnique(boolean newIsUnique) {
		boolean oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.REGISTRY_ID_DESC__IS_UNIQUE, oldIsUnique, isUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSets() {
		if (sets == null) {
			sets = new EDataTypeUniqueEList<String>(String.class, this, ServicedescriptorswithidPackage.REGISTRY_ID_DESC__SETS);
		}
		return sets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExtends() {
		if (extends_ == null) {
			extends_ = new EDataTypeUniqueEList<String>(String.class, this, ServicedescriptorswithidPackage.REGISTRY_ID_DESC__EXTENDS);
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParents() {
		if (parents == null) {
			parents = new EDataTypeUniqueEList<String>(String.class, this, ServicedescriptorswithidPackage.REGISTRY_ID_DESC__PARENTS);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__NAME:
				return getName();
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__DESCRIPTION:
				return getDescription();
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__IS_UNIQUE:
				return isUnique();
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__SETS:
				return getSets();
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__EXTENDS:
				return getExtends();
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__PARENTS:
				return getParents();
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
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__NAME:
				setName((String)newValue);
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__SETS:
				getSets().clear();
				getSets().addAll((Collection<? extends String>)newValue);
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends String>)newValue);
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends String>)newValue);
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
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__SETS:
				getSets().clear();
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__EXTENDS:
				getExtends().clear();
				return;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__PARENTS:
				getParents().clear();
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
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__IS_UNIQUE:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__SETS:
				return sets != null && !sets.isEmpty();
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__PARENTS:
				return parents != null && !parents.isEmpty();
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
		result.append(", description: ");
		result.append(description);
		result.append(", isUnique: ");
		result.append(isUnique);
		result.append(", sets: ");
		result.append(sets);
		result.append(", extends: ");
		result.append(extends_);
		result.append(", parents: ");
		result.append(parents);
		result.append(')');
		return result.toString();
	}

} //RegistryIdDescImpl
