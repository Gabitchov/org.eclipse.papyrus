/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiFactory;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageListImpl#getAvailablePage <em>Available Page</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageListImpl extends EObjectImpl implements PageList {

	/**
	 * The cached value of the '{@link #getAvailablePage() <em>Available Page</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailablePage()
	 * @generated
	 * @ordered
	 */
	protected EList<PageRef> availablePage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PageListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.PAGE_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageRef> getAvailablePage() {
		if (availablePage == null) {
			availablePage = new EObjectContainmentEList<PageRef>(PageRef.class, this, DiPackage.PAGE_LIST__AVAILABLE_PAGE);
		}
		return availablePage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void addPage(Object pageIdentifier) {

		PageRef pageRef = DiFactory.eINSTANCE.createPageRef();
		pageRef.setPageIdentifier(pageIdentifier);
		getAvailablePage().add(pageRef);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void removePage(Object pageIdentifier) {
		for(PageRef pageRef : getAvailablePage()) {

			if(pageRef.isForIdentifier(pageIdentifier)) {
				getAvailablePage().remove(pageRef);
				return;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiPackage.PAGE_LIST__AVAILABLE_PAGE:
				return ((InternalEList<?>)getAvailablePage()).basicRemove(otherEnd, msgs);
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
			case DiPackage.PAGE_LIST__AVAILABLE_PAGE:
				return getAvailablePage();
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
			case DiPackage.PAGE_LIST__AVAILABLE_PAGE:
				getAvailablePage().clear();
				getAvailablePage().addAll((Collection<? extends PageRef>)newValue);
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
			case DiPackage.PAGE_LIST__AVAILABLE_PAGE:
				getAvailablePage().clear();
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
			case DiPackage.PAGE_LIST__AVAILABLE_PAGE:
				return availablePage != null && !availablePage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PageListImpl
