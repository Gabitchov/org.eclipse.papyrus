/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sash Windows Mngr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashWindowsMngrImpl#getPageList <em>Page List</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashWindowsMngrImpl#getSashModel <em>Sash Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SashWindowsMngrImpl extends EObjectImpl implements SashWindowsMngr {

	/**
	 * The cached value of the '{@link #getPageList() <em>Page List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageList()
	 * @generated
	 * @ordered
	 */
	protected PageList pageList;

	/**
	 * The cached value of the '{@link #getSashModel() <em>Sash Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSashModel()
	 * @generated
	 * @ordered
	 */
	protected SashModel sashModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SashWindowsMngrImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.SASH_WINDOWS_MNGR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageList getPageList() {
		return pageList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPageList(PageList newPageList, NotificationChain msgs) {
		PageList oldPageList = pageList;
		pageList = newPageList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiPackage.SASH_WINDOWS_MNGR__PAGE_LIST, oldPageList, newPageList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageList(PageList newPageList) {
		if (newPageList != pageList) {
			NotificationChain msgs = null;
			if (pageList != null)
				msgs = ((InternalEObject)pageList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiPackage.SASH_WINDOWS_MNGR__PAGE_LIST, null, msgs);
			if (newPageList != null)
				msgs = ((InternalEObject)newPageList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiPackage.SASH_WINDOWS_MNGR__PAGE_LIST, null, msgs);
			msgs = basicSetPageList(newPageList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.SASH_WINDOWS_MNGR__PAGE_LIST, newPageList, newPageList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SashModel getSashModel() {
		return sashModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSashModel(SashModel newSashModel, NotificationChain msgs) {
		SashModel oldSashModel = sashModel;
		sashModel = newSashModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiPackage.SASH_WINDOWS_MNGR__SASH_MODEL, oldSashModel, newSashModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSashModel(SashModel newSashModel) {
		if (newSashModel != sashModel) {
			NotificationChain msgs = null;
			if (sashModel != null)
				msgs = ((InternalEObject)sashModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiPackage.SASH_WINDOWS_MNGR__SASH_MODEL, null, msgs);
			if (newSashModel != null)
				msgs = ((InternalEObject)newSashModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiPackage.SASH_WINDOWS_MNGR__SASH_MODEL, null, msgs);
			msgs = basicSetSashModel(newSashModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.SASH_WINDOWS_MNGR__SASH_MODEL, newSashModel, newSashModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiPackage.SASH_WINDOWS_MNGR__PAGE_LIST:
				return basicSetPageList(null, msgs);
			case DiPackage.SASH_WINDOWS_MNGR__SASH_MODEL:
				return basicSetSashModel(null, msgs);
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
			case DiPackage.SASH_WINDOWS_MNGR__PAGE_LIST:
				return getPageList();
			case DiPackage.SASH_WINDOWS_MNGR__SASH_MODEL:
				return getSashModel();
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
			case DiPackage.SASH_WINDOWS_MNGR__PAGE_LIST:
				setPageList((PageList)newValue);
				return;
			case DiPackage.SASH_WINDOWS_MNGR__SASH_MODEL:
				setSashModel((SashModel)newValue);
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
			case DiPackage.SASH_WINDOWS_MNGR__PAGE_LIST:
				setPageList((PageList)null);
				return;
			case DiPackage.SASH_WINDOWS_MNGR__SASH_MODEL:
				setSashModel((SashModel)null);
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
			case DiPackage.SASH_WINDOWS_MNGR__PAGE_LIST:
				return pageList != null;
			case DiPackage.SASH_WINDOWS_MNGR__SASH_MODEL:
				return sashModel != null;
		}
		return super.eIsSet(featureID);
	}

} //SashWindowsMngrImpl
