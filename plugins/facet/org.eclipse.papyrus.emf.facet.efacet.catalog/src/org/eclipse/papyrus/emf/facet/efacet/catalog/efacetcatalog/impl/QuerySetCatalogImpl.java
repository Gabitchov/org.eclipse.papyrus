/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 *  
 */
package org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EObjectEList.Unsettable;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.emf.facet.efacet.QuerySet;
import org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.EfacetcatalogPackage;
import org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Query Set Catalog</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.impl.QuerySetCatalogImpl#getInstalledEntries
 * <em>Installed Entries</em>}</li>
 * <li>{@link org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.impl.QuerySetCatalogImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.impl.QuerySetCatalogImpl#getInstalledQuerySets
 * <em>Installed Query Sets</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class QuerySetCatalogImpl extends EObjectImpl implements QuerySetCatalog {
	/**
	 * The cached value of the '{@link #getInstalledEntries() <em>Installed Entries</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstalledEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> installedEntries;
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
	protected QuerySetCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EfacetcatalogPackage.Literals.QUERY_SET_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getInstalledEntries() {
		if (installedEntries == null) {
			installedEntries = new EObjectResolvingEList<EObject>(EObject.class, this, EfacetcatalogPackage.QUERY_SET_CATALOG__INSTALLED_ENTRIES);
		}
		return installedEntries;
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
	public void setName(final String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EfacetcatalogPackage.QUERY_SET_CATALOG__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<QuerySet> getInstalledQuerySets() {
		Unsettable<QuerySet> unsettableList = new EObjectEList.Unsettable<QuerySet>(
				QuerySet.class, this, EfacetcatalogPackage.eINSTANCE
						.getQuerySetCatalog_InstalledQuerySets().getFeatureID());
		for (Object object : this.getInstalledEntries()) {
			if (object instanceof QuerySet) {
				QuerySet querySetImpl = (QuerySet) object;
				unsettableList.add(querySetImpl);
			}
		}
		return unsettableList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
			case EfacetcatalogPackage.QUERY_SET_CATALOG__INSTALLED_ENTRIES:
				return getInstalledEntries();
			case EfacetcatalogPackage.QUERY_SET_CATALOG__NAME:
				return getName();
			case EfacetcatalogPackage.QUERY_SET_CATALOG__INSTALLED_QUERY_SETS:
				return getInstalledQuerySets();
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
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
			case EfacetcatalogPackage.QUERY_SET_CATALOG__INSTALLED_ENTRIES:
				getInstalledEntries().clear();
				getInstalledEntries().addAll((Collection<? extends EObject>)newValue);
				return;
			case EfacetcatalogPackage.QUERY_SET_CATALOG__NAME:
				setName((String)newValue);
				return;
			case EfacetcatalogPackage.QUERY_SET_CATALOG__INSTALLED_QUERY_SETS:
				getInstalledQuerySets().clear();
				getInstalledQuerySets().addAll((Collection<? extends QuerySet>)newValue);
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
	public void eUnset(final int featureID) {
		switch (featureID) {
			case EfacetcatalogPackage.QUERY_SET_CATALOG__INSTALLED_ENTRIES:
				getInstalledEntries().clear();
				return;
			case EfacetcatalogPackage.QUERY_SET_CATALOG__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EfacetcatalogPackage.QUERY_SET_CATALOG__INSTALLED_QUERY_SETS:
				getInstalledQuerySets().clear();
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
	public boolean eIsSet(final int featureID) {
		switch (featureID) {
			case EfacetcatalogPackage.QUERY_SET_CATALOG__INSTALLED_ENTRIES:
				return installedEntries != null && !installedEntries.isEmpty();
			case EfacetcatalogPackage.QUERY_SET_CATALOG__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EfacetcatalogPackage.QUERY_SET_CATALOG__INSTALLED_QUERY_SETS:
				return !getInstalledQuerySets().isEmpty();
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //QuerySetCatalogImpl
