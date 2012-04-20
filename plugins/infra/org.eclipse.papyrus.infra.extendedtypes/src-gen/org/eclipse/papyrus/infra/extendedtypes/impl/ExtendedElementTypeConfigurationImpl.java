/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.IconEntry;
import org.eclipse.papyrus.infra.extendedtypes.PostActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.PreActionConfiguration;
import org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended Element Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getIconEntry <em>Icon Entry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getHint <em>Hint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getKindName <em>Kind Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getSpecializedTypesID <em>Specialized Types ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getPreValidation <em>Pre Validation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getPreAction <em>Pre Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getPostAction <em>Post Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl#getSpecializedDiagramTypeID <em>Specialized Diagram Type ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendedElementTypeConfigurationImpl extends EObjectImpl implements ExtendedElementTypeConfiguration {
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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIconEntry() <em>Icon Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconEntry()
	 * @generated
	 * @ordered
	 */
	protected IconEntry iconEntry;

	/**
	 * The default value of the '{@link #getHint() <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHint()
	 * @generated
	 * @ordered
	 */
	protected static final String HINT_EDEFAULT = "ExtendedElements";

	/**
	 * The cached value of the '{@link #getHint() <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHint()
	 * @generated
	 * @ordered
	 */
	protected String hint = HINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getKindName() <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindName()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_NAME_EDEFAULT = "org.eclipse.gmf.runtime.emf.type.core.IHintedType";

	/**
	 * The cached value of the '{@link #getKindName() <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindName()
	 * @generated
	 * @ordered
	 */
	protected String kindName = KIND_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSpecializedTypesID() <em>Specialized Types ID</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializedTypesID()
	 * @generated
	 * @ordered
	 */
	protected EList<String> specializedTypesID;

	/**
	 * The cached value of the '{@link #getPreValidation() <em>Pre Validation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreValidation()
	 * @generated
	 * @ordered
	 */
	protected EList<QueryConfiguration> preValidation;

	/**
	 * The cached value of the '{@link #getPreAction() <em>Pre Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreAction()
	 * @generated
	 * @ordered
	 */
	protected EList<PreActionConfiguration> preAction;

	/**
	 * The cached value of the '{@link #getPostAction() <em>Post Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostAction()
	 * @generated
	 * @ordered
	 */
	protected EList<PostActionConfiguration> postAction;

	/**
	 * The default value of the '{@link #getSpecializedDiagramTypeID() <em>Specialized Diagram Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializedDiagramTypeID()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecializedDiagramTypeID() <em>Specialized Diagram Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializedDiagramTypeID()
	 * @generated
	 * @ordered
	 */
	protected String specializedDiagramTypeID = SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendedElementTypeConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedtypesPackage.Literals.EXTENDED_ELEMENT_TYPE_CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IconEntry getIconEntry() {
		return iconEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIconEntry(IconEntry newIconEntry, NotificationChain msgs) {
		IconEntry oldIconEntry = iconEntry;
		iconEntry = newIconEntry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY, oldIconEntry, newIconEntry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconEntry(IconEntry newIconEntry) {
		if (newIconEntry != iconEntry) {
			NotificationChain msgs = null;
			if (iconEntry != null)
				msgs = ((InternalEObject)iconEntry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY, null, msgs);
			if (newIconEntry != null)
				msgs = ((InternalEObject)newIconEntry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY, null, msgs);
			msgs = basicSetIconEntry(newIconEntry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY, newIconEntry, newIconEntry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHint() {
		return hint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHint(String newHint) {
		String oldHint = hint;
		hint = newHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__HINT, oldHint, hint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKindName() {
		return kindName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKindName(String newKindName) {
		String oldKindName = kindName;
		kindName = newKindName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__KIND_NAME, oldKindName, kindName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSpecializedTypesID() {
		if (specializedTypesID == null) {
			specializedTypesID = new EDataTypeUniqueEList<String>(String.class, this, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID);
		}
		return specializedTypesID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QueryConfiguration> getPreValidation() {
		if (preValidation == null) {
			preValidation = new EObjectResolvingEList<QueryConfiguration>(QueryConfiguration.class, this, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_VALIDATION);
		}
		return preValidation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PreActionConfiguration> getPreAction() {
		if (preAction == null) {
			preAction = new EObjectContainmentEList<PreActionConfiguration>(PreActionConfiguration.class, this, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_ACTION);
		}
		return preAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PostActionConfiguration> getPostAction() {
		if (postAction == null) {
			postAction = new EObjectContainmentEList<PostActionConfiguration>(PostActionConfiguration.class, this, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__POST_ACTION);
		}
		return postAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecializedDiagramTypeID() {
		return specializedDiagramTypeID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecializedDiagramTypeID(String newSpecializedDiagramTypeID) {
		String oldSpecializedDiagramTypeID = specializedDiagramTypeID;
		specializedDiagramTypeID = newSpecializedDiagramTypeID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID, oldSpecializedDiagramTypeID, specializedDiagramTypeID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				return basicSetIconEntry(null, msgs);
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_ACTION:
				return ((InternalEList<?>)getPreAction()).basicRemove(otherEnd, msgs);
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__POST_ACTION:
				return ((InternalEList<?>)getPostAction()).basicRemove(otherEnd, msgs);
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
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__NAME:
				return getName();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ID:
				return getId();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				return getIconEntry();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__HINT:
				return getHint();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__KIND_NAME:
				return getKindName();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
				return getSpecializedTypesID();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_VALIDATION:
				return getPreValidation();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_ACTION:
				return getPreAction();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__POST_ACTION:
				return getPostAction();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID:
				return getSpecializedDiagramTypeID();
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
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ID:
				setId((String)newValue);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				setIconEntry((IconEntry)newValue);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__HINT:
				setHint((String)newValue);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__KIND_NAME:
				setKindName((String)newValue);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
				getSpecializedTypesID().clear();
				getSpecializedTypesID().addAll((Collection<? extends String>)newValue);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_VALIDATION:
				getPreValidation().clear();
				getPreValidation().addAll((Collection<? extends QueryConfiguration>)newValue);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_ACTION:
				getPreAction().clear();
				getPreAction().addAll((Collection<? extends PreActionConfiguration>)newValue);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__POST_ACTION:
				getPostAction().clear();
				getPostAction().addAll((Collection<? extends PostActionConfiguration>)newValue);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID:
				setSpecializedDiagramTypeID((String)newValue);
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
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ID:
				setId(ID_EDEFAULT);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				setIconEntry((IconEntry)null);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__HINT:
				setHint(HINT_EDEFAULT);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__KIND_NAME:
				setKindName(KIND_NAME_EDEFAULT);
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
				getSpecializedTypesID().clear();
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_VALIDATION:
				getPreValidation().clear();
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_ACTION:
				getPreAction().clear();
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__POST_ACTION:
				getPostAction().clear();
				return;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID:
				setSpecializedDiagramTypeID(SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT);
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
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				return iconEntry != null;
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__HINT:
				return HINT_EDEFAULT == null ? hint != null : !HINT_EDEFAULT.equals(hint);
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__KIND_NAME:
				return KIND_NAME_EDEFAULT == null ? kindName != null : !KIND_NAME_EDEFAULT.equals(kindName);
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
				return specializedTypesID != null && !specializedTypesID.isEmpty();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_VALIDATION:
				return preValidation != null && !preValidation.isEmpty();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_ACTION:
				return preAction != null && !preAction.isEmpty();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__POST_ACTION:
				return postAction != null && !postAction.isEmpty();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID:
				return SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT == null ? specializedDiagramTypeID != null : !SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT.equals(specializedDiagramTypeID);
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
		result.append(", id: ");
		result.append(id);
		result.append(", hint: ");
		result.append(hint);
		result.append(", kindName: ");
		result.append(kindName);
		result.append(", specializedTypesID: ");
		result.append(specializedTypesID);
		result.append(", specializedDiagramTypeID: ");
		result.append(specializedDiagramTypeID);
		result.append(')');
		return result.toString();
	}

} //ExtendedElementTypeConfigurationImpl
