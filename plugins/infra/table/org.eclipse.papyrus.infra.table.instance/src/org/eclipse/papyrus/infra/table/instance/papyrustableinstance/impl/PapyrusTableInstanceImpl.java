/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.facet.infra.query.ModelQuery;

import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;

import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Table Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#isIsSynchronized <em>Is Synchronized</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getFillingQueries <em>Filling Queries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getPastedElementId <em>Pasted Element Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getPasteElementContainementFeature <em>Paste Element Containement Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PapyrusTableInstanceImpl extends 
EModelElementImpl implements PapyrusTableInstance {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "no name";

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = "PapyrusDefaultTable";

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsSynchronized() <em>Is Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSynchronized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SYNCHRONIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSynchronized() <em>Is Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSynchronized()
	 * @generated
	 * @ordered
	 */
	protected boolean isSynchronized = IS_SYNCHRONIZED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected TableInstance2 table;

	/**
	 * The cached value of the '{@link #getFillingQueries() <em>Filling Queries</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillingQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelQuery> fillingQueries;

	/**
	 * The default value of the '{@link #getPastedElementId() <em>Pasted Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastedElementId()
	 * @generated
	 * @ordered
	 */
	protected static final String PASTED_ELEMENT_ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPastedElementId() <em>Pasted Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastedElementId()
	 * @generated
	 * @ordered
	 */
	protected String pastedElementId = PASTED_ELEMENT_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPasteElementContainementFeature() <em>Paste Element Containement Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasteElementContainementFeature()
	 * @generated
	 * @ordered
	 */
	protected EReference pasteElementContainementFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusTableInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrustableinstancePackage.Literals.PAPYRUS_TABLE_INSTANCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSynchronized() {
		return isSynchronized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSynchronized(boolean newIsSynchronized) {
		boolean oldIsSynchronized = isSynchronized;
		isSynchronized = newIsSynchronized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED, oldIsSynchronized, isSynchronized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableInstance2 getTable() {
		if (table != null && table.eIsProxy()) {
			InternalEObject oldTable = (InternalEObject)table;
			table = (TableInstance2)eResolveProxy(oldTable);
			if (table != oldTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE, oldTable, table));
			}
		}
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableInstance2 basicGetTable() {
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTable(TableInstance2 newTable) {
		TableInstance2 oldTable = table;
		table = newTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE, oldTable, table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelQuery> getFillingQueries() {
		if (fillingQueries == null) {
			fillingQueries = new EObjectResolvingEList<ModelQuery>(ModelQuery.class, this, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES);
		}
		return fillingQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPastedElementId() {
		return pastedElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPastedElementId(String newPastedElementId) {
		String oldPastedElementId = pastedElementId;
		pastedElementId = newPastedElementId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTED_ELEMENT_ID, oldPastedElementId, pastedElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPasteElementContainementFeature() {
		if (pasteElementContainementFeature != null && pasteElementContainementFeature.eIsProxy()) {
			InternalEObject oldPasteElementContainementFeature = (InternalEObject)pasteElementContainementFeature;
			pasteElementContainementFeature = (EReference)eResolveProxy(oldPasteElementContainementFeature);
			if (pasteElementContainementFeature != oldPasteElementContainementFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTE_ELEMENT_CONTAINEMENT_FEATURE, oldPasteElementContainementFeature, pasteElementContainementFeature));
			}
		}
		return pasteElementContainementFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetPasteElementContainementFeature() {
		return pasteElementContainementFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasteElementContainementFeature(EReference newPasteElementContainementFeature) {
		EReference oldPasteElementContainementFeature = pasteElementContainementFeature;
		pasteElementContainementFeature = newPasteElementContainementFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTE_ELEMENT_CONTAINEMENT_FEATURE, oldPasteElementContainementFeature, pasteElementContainementFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME:
				return getName();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE:
				return getType();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED:
				return isIsSynchronized();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE:
				if (resolve) return getTable();
				return basicGetTable();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES:
				return getFillingQueries();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTED_ELEMENT_ID:
				return getPastedElementId();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTE_ELEMENT_CONTAINEMENT_FEATURE:
				if (resolve) return getPasteElementContainementFeature();
				return basicGetPasteElementContainementFeature();
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
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME:
				setName((String)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE:
				setType((String)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED:
				setIsSynchronized((Boolean)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE:
				setTable((TableInstance2)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES:
				getFillingQueries().clear();
				getFillingQueries().addAll((Collection<? extends ModelQuery>)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTED_ELEMENT_ID:
				setPastedElementId((String)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTE_ELEMENT_CONTAINEMENT_FEATURE:
				setPasteElementContainementFeature((EReference)newValue);
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
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED:
				setIsSynchronized(IS_SYNCHRONIZED_EDEFAULT);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE:
				setTable((TableInstance2)null);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES:
				getFillingQueries().clear();
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTED_ELEMENT_ID:
				setPastedElementId(PASTED_ELEMENT_ID_EDEFAULT);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTE_ELEMENT_CONTAINEMENT_FEATURE:
				setPasteElementContainementFeature((EReference)null);
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
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED:
				return isSynchronized != IS_SYNCHRONIZED_EDEFAULT;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE:
				return table != null;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES:
				return fillingQueries != null && !fillingQueries.isEmpty();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTED_ELEMENT_ID:
				return PASTED_ELEMENT_ID_EDEFAULT == null ? pastedElementId != null : !PASTED_ELEMENT_ID_EDEFAULT.equals(pastedElementId);
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__PASTE_ELEMENT_CONTAINEMENT_FEATURE:
				return pasteElementContainementFeature != null;
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
		result.append(", type: ");
		result.append(type);
		result.append(", isSynchronized: ");
		result.append(isSynchronized);
		result.append(", pastedElementId: ");
		result.append(pastedElementId);
		result.append(')');
		return result.toString();
	}

} //PapyrusTableInstanceImpl
