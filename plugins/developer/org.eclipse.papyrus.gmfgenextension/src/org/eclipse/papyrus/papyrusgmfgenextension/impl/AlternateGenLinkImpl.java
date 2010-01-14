/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alternate Gen Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl#getGenLinkNode <em>Gen Link Node</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl#getTypeModelFacet <em>Type Model Facet</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AlternateGenLinkImpl extends CommentedElementImpl implements AlternateGenLink {

	/**
	 * The cached value of the '{@link #getGenLinkNode() <em>Gen Link Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGenLinkNode()
	 * @generated
	 * @ordered
	 */
	protected GenLink genLinkNode;

	/**
	 * The cached value of the '{@link #getTypeModelFacet() <em>Type Model Facet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTypeModelFacet()
	 * @generated
	 * @ordered
	 */
	protected TypeModelFacet typeModelFacet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AlternateGenLinkImpl() {
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
		return PapyrusgmfgenextensionPackage.Literals.ALTERNATE_GEN_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenLink getGenLinkNode() {
		if(genLinkNode != null && genLinkNode.eIsProxy()) {
			InternalEObject oldGenLinkNode = (InternalEObject)genLinkNode;
			genLinkNode = (GenLink)eResolveProxy(oldGenLinkNode);
			if(genLinkNode != oldGenLinkNode) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__GEN_LINK_NODE, oldGenLinkNode, genLinkNode));
			}
		}
		return genLinkNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenLink basicGetGenLinkNode() {
		return genLinkNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGenLinkNode(GenLink newGenLinkNode) {
		GenLink oldGenLinkNode = genLinkNode;
		genLinkNode = newGenLinkNode;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__GEN_LINK_NODE, oldGenLinkNode, genLinkNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeModelFacet getTypeModelFacet() {
		return typeModelFacet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTypeModelFacet(TypeModelFacet newTypeModelFacet, NotificationChain msgs) {
		TypeModelFacet oldTypeModelFacet = typeModelFacet;
		typeModelFacet = newTypeModelFacet;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__TYPE_MODEL_FACET, oldTypeModelFacet, newTypeModelFacet);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypeModelFacet(TypeModelFacet newTypeModelFacet) {
		if(newTypeModelFacet != typeModelFacet) {
			NotificationChain msgs = null;
			if(typeModelFacet != null)
				msgs = ((InternalEObject)typeModelFacet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__TYPE_MODEL_FACET, null, msgs);
			if(newTypeModelFacet != null)
				msgs = ((InternalEObject)newTypeModelFacet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__TYPE_MODEL_FACET, null, msgs);
			msgs = basicSetTypeModelFacet(newTypeModelFacet, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__TYPE_MODEL_FACET, newTypeModelFacet, newTypeModelFacet));
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
		case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__TYPE_MODEL_FACET:
			return basicSetTypeModelFacet(null, msgs);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__GEN_LINK_NODE:
			if(resolve)
				return getGenLinkNode();
			return basicGetGenLinkNode();
		case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__TYPE_MODEL_FACET:
			return getTypeModelFacet();
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
		case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__GEN_LINK_NODE:
			setGenLinkNode((GenLink)newValue);
			return;
		case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__TYPE_MODEL_FACET:
			setTypeModelFacet((TypeModelFacet)newValue);
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
		case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__GEN_LINK_NODE:
			setGenLinkNode((GenLink)null);
			return;
		case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__TYPE_MODEL_FACET:
			setTypeModelFacet((TypeModelFacet)null);
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
		case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__GEN_LINK_NODE:
			return genLinkNode != null;
		case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK__TYPE_MODEL_FACET:
			return typeModelFacet != null;
		}
		return super.eIsSet(featureID);
	}

} //AlternateGenLinkImpl
