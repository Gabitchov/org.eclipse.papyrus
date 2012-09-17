/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.services.controlmode.mm.history.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.historyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Controled Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.impl.ControledResourceImpl#getChildren <em>Children</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.impl.ControledResourceImpl#getParent <em>Parent</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.impl.ControledResourceImpl#getResourceURL <em>Resource URL</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ControledResourceImpl extends EObjectImpl implements ControledResource {

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<ControledResource> children;

	/**
	 * The default value of the '{@link #getResourceURL() <em>Resource URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getResourceURL()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceURL() <em>Resource URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getResourceURL()
	 * @generated
	 * @ordered
	 */
	protected String resourceURL = RESOURCE_URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ControledResourceImpl() {
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
		return historyPackage.Literals.CONTROLED_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ControledResource> getChildren() {
		if(children == null) {
			children = new EObjectContainmentWithInverseEList<ControledResource>(ControledResource.class, this, historyPackage.CONTROLED_RESOURCE__CHILDREN, historyPackage.CONTROLED_RESOURCE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ControledResource getParent() {
		if(eContainerFeatureID() != historyPackage.CONTROLED_RESOURCE__PARENT)
			return null;
		return (ControledResource)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(ControledResource newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, historyPackage.CONTROLED_RESOURCE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(ControledResource newParent) {
		if(newParent != eInternalContainer() || (eContainerFeatureID() != historyPackage.CONTROLED_RESOURCE__PARENT && newParent != null)) {
			if(EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, historyPackage.CONTROLED_RESOURCE__CHILDREN, ControledResource.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, historyPackage.CONTROLED_RESOURCE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getResourceURL() {
		return resourceURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setResourceURL(String newResourceURL) {
		String oldResourceURL = resourceURL;
		resourceURL = newResourceURL;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, historyPackage.CONTROLED_RESOURCE__RESOURCE_URL, oldResourceURL, resourceURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case historyPackage.CONTROLED_RESOURCE__CHILDREN:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
		case historyPackage.CONTROLED_RESOURCE__PARENT:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParent((ControledResource)otherEnd, msgs);
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
		case historyPackage.CONTROLED_RESOURCE__CHILDREN:
			return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		case historyPackage.CONTROLED_RESOURCE__PARENT:
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
		case historyPackage.CONTROLED_RESOURCE__PARENT:
			return eInternalContainer().eInverseRemove(this, historyPackage.CONTROLED_RESOURCE__CHILDREN, ControledResource.class, msgs);
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
		case historyPackage.CONTROLED_RESOURCE__CHILDREN:
			return getChildren();
		case historyPackage.CONTROLED_RESOURCE__PARENT:
			return getParent();
		case historyPackage.CONTROLED_RESOURCE__RESOURCE_URL:
			return getResourceURL();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case historyPackage.CONTROLED_RESOURCE__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends ControledResource>)newValue);
			return;
		case historyPackage.CONTROLED_RESOURCE__PARENT:
			setParent((ControledResource)newValue);
			return;
		case historyPackage.CONTROLED_RESOURCE__RESOURCE_URL:
			setResourceURL((String)newValue);
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
		case historyPackage.CONTROLED_RESOURCE__CHILDREN:
			getChildren().clear();
			return;
		case historyPackage.CONTROLED_RESOURCE__PARENT:
			setParent((ControledResource)null);
			return;
		case historyPackage.CONTROLED_RESOURCE__RESOURCE_URL:
			setResourceURL(RESOURCE_URL_EDEFAULT);
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
		case historyPackage.CONTROLED_RESOURCE__CHILDREN:
			return children != null && !children.isEmpty();
		case historyPackage.CONTROLED_RESOURCE__PARENT:
			return getParent() != null;
		case historyPackage.CONTROLED_RESOURCE__RESOURCE_URL:
			return RESOURCE_URL_EDEFAULT == null ? resourceURL != null : !RESOURCE_URL_EDEFAULT.equals(resourceURL);
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
		result.append(" (resourceURL: ");
		result.append(resourceURL);
		result.append(')');
		return result.toString();
	}

} //ControledResourceImpl
