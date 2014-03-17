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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageRefImpl#getEmfPageIdentifier <em>Emf Page Identifier</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageRefImpl#getPageIdentifier <em>Page Identifier</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageRefImpl#getObjectPageIdentifier <em>Object Page Identifier</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageRefImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageRefImpl extends EObjectImpl implements PageRef {

	/**
	 * The cached value of the '{@link #getEmfPageIdentifier() <em>Emf Page Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEmfPageIdentifier()
	 * @generated
	 * @ordered
	 */
	protected EObject emfPageIdentifier;

	/**
	 * The default value of the '{@link #getPageIdentifier() <em>Page Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPageIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final Object PAGE_IDENTIFIER_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getObjectPageIdentifier() <em>Object Page Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getObjectPageIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final Object OBJECT_PAGE_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectPageIdentifier() <em>Object Page Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getObjectPageIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Object objectPageIdentifier = OBJECT_PAGE_IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PageRefImpl() {
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
		return DiPackage.Literals.PAGE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject getEmfPageIdentifier() {
		if(emfPageIdentifier != null && emfPageIdentifier.eIsProxy()) {
			InternalEObject oldEmfPageIdentifier = (InternalEObject)emfPageIdentifier;
			emfPageIdentifier = eResolveProxy(oldEmfPageIdentifier);
			if(emfPageIdentifier != oldEmfPageIdentifier) {
				if(eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiPackage.PAGE_REF__EMF_PAGE_IDENTIFIER, oldEmfPageIdentifier, emfPageIdentifier));
				}
			}
		}
		return emfPageIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EObject basicGetEmfPageIdentifier() {
		return emfPageIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEmfPageIdentifier(EObject newEmfPageIdentifier) {
		EObject oldEmfPageIdentifier = emfPageIdentifier;
		emfPageIdentifier = newEmfPageIdentifier;
		if(eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.PAGE_REF__EMF_PAGE_IDENTIFIER, oldEmfPageIdentifier, emfPageIdentifier));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getPageIdentifier() {
		Object res = getEmfPageIdentifier();

		if(res != null) {
			return res;
		} else {
			return getObjectPageIdentifier();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isForIdentifier(Object pageIdentifier) {
		//Avoid npe when there is an invalid "availablePage". See Bug 398712: Multiple issues with the PageManager
		if(getPageIdentifier() == null) {
			return false;
		}
		return getPageIdentifier().equals(pageIdentifier);
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
		case DiPackage.PAGE_REF__PARENT:
			if(eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetParent((TabFolder)otherEnd, msgs);
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
		case DiPackage.PAGE_REF__PARENT:
			return basicSetParent(null, msgs);
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
		case DiPackage.PAGE_REF__PARENT:
			return eInternalContainer().eInverseRemove(this, DiPackage.TAB_FOLDER__CHILDREN, TabFolder.class, msgs);
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
		case DiPackage.PAGE_REF__EMF_PAGE_IDENTIFIER:
			if(resolve) {
				return getEmfPageIdentifier();
			}
			return basicGetEmfPageIdentifier();
		case DiPackage.PAGE_REF__PAGE_IDENTIFIER:
			return getPageIdentifier();
		case DiPackage.PAGE_REF__OBJECT_PAGE_IDENTIFIER:
			return getObjectPageIdentifier();
		case DiPackage.PAGE_REF__PARENT:
			return getParent();
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
		case DiPackage.PAGE_REF__EMF_PAGE_IDENTIFIER:
			setEmfPageIdentifier((EObject)newValue);
			return;
		case DiPackage.PAGE_REF__PAGE_IDENTIFIER:
			setPageIdentifier(newValue);
			return;
		case DiPackage.PAGE_REF__OBJECT_PAGE_IDENTIFIER:
			setObjectPageIdentifier(newValue);
			return;
		case DiPackage.PAGE_REF__PARENT:
			setParent((TabFolder)newValue);
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
		case DiPackage.PAGE_REF__EMF_PAGE_IDENTIFIER:
			setEmfPageIdentifier((EObject)null);
			return;
		case DiPackage.PAGE_REF__PAGE_IDENTIFIER:
			setPageIdentifier(PAGE_IDENTIFIER_EDEFAULT);
			return;
		case DiPackage.PAGE_REF__OBJECT_PAGE_IDENTIFIER:
			setObjectPageIdentifier(OBJECT_PAGE_IDENTIFIER_EDEFAULT);
			return;
		case DiPackage.PAGE_REF__PARENT:
			setParent((TabFolder)null);
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
		case DiPackage.PAGE_REF__EMF_PAGE_IDENTIFIER:
			return emfPageIdentifier != null;
		case DiPackage.PAGE_REF__PAGE_IDENTIFIER:
			return PAGE_IDENTIFIER_EDEFAULT == null ? getPageIdentifier() != null : !PAGE_IDENTIFIER_EDEFAULT.equals(getPageIdentifier());
		case DiPackage.PAGE_REF__OBJECT_PAGE_IDENTIFIER:
			return OBJECT_PAGE_IDENTIFIER_EDEFAULT == null ? objectPageIdentifier != null : !OBJECT_PAGE_IDENTIFIER_EDEFAULT.equals(objectPageIdentifier);
		case DiPackage.PAGE_REF__PARENT:
			return getParent() != null;
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
		if(eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (objectPageIdentifier: ");
		result.append(objectPageIdentifier);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void setPageIdentifier(Object newPageIdentifier) {

		if(newPageIdentifier instanceof EObject) {
			setEmfPageIdentifier((EObject)newPageIdentifier);
			return;
		}

		// if null, unset all
		if(newPageIdentifier == null && getEmfPageIdentifier() != null) {
			setEmfPageIdentifier(null);
		}

		// By default, consider newPageIdentifier as an Object
		setObjectPageIdentifier(newPageIdentifier);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getObjectPageIdentifier() {
		return objectPageIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setObjectPageIdentifier(Object newObjectPageIdentifier) {
		Object oldObjectPageIdentifier = objectPageIdentifier;
		objectPageIdentifier = newObjectPageIdentifier;
		if(eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.PAGE_REF__OBJECT_PAGE_IDENTIFIER, oldObjectPageIdentifier, objectPageIdentifier));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public TabFolder getParent() {
		if(eContainerFeatureID() != DiPackage.PAGE_REF__PARENT) {
			return null;
		}
		return (TabFolder)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetParent(TabFolder newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, DiPackage.PAGE_REF__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setParent(TabFolder newParent) {
		if(newParent != eInternalContainer() || (eContainerFeatureID() != DiPackage.PAGE_REF__PARENT && newParent != null)) {
			if(EcoreUtil.isAncestor(this, newParent)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if(eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if(newParent != null) {
				msgs = ((InternalEObject)newParent).eInverseAdd(this, DiPackage.TAB_FOLDER__CHILDREN, TabFolder.class, msgs);
			}
			msgs = basicSetParent(newParent, msgs);
			if(msgs != null) {
				msgs.dispatch();
			}
		} else if(eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.PAGE_REF__PARENT, newParent, newParent));
		}
	}

} //PageRefImpl
