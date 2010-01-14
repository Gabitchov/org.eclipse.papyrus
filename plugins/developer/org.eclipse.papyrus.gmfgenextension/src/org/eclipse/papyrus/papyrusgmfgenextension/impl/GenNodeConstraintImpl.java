/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Node Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl#getGenNode <em>Gen Node</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl#getGenConstraint <em>Gen Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GenNodeConstraintImpl extends CommentedElementImpl implements GenNodeConstraint {

	/**
	 * The cached value of the '{@link #getGenNode() <em>Gen Node</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGenNode()
	 * @generated
	 * @ordered
	 */
	protected EList<GenNode> genNode;

	/**
	 * The cached value of the '{@link #getGenConstraint() <em>Gen Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGenConstraint()
	 * @generated
	 * @ordered
	 */
	protected GenConstraint genConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GenNodeConstraintImpl() {
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
		return PapyrusgmfgenextensionPackage.Literals.GEN_NODE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<GenNode> getGenNode() {
		if(genNode == null) {
			genNode = new EObjectResolvingEList<GenNode>(GenNode.class, this, PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_NODE);
		}
		return genNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenConstraint getGenConstraint() {
		if(genConstraint != null && genConstraint.eIsProxy()) {
			InternalEObject oldGenConstraint = (InternalEObject)genConstraint;
			genConstraint = (GenConstraint)eResolveProxy(oldGenConstraint);
			if(genConstraint != oldGenConstraint) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_CONSTRAINT, oldGenConstraint, genConstraint));
			}
		}
		return genConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenConstraint basicGetGenConstraint() {
		return genConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGenConstraint(GenConstraint newGenConstraint) {
		GenConstraint oldGenConstraint = genConstraint;
		genConstraint = newGenConstraint;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_CONSTRAINT, oldGenConstraint, genConstraint));
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
		case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_NODE:
			return getGenNode();
		case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_CONSTRAINT:
			if(resolve)
				return getGenConstraint();
			return basicGetGenConstraint();
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
		case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_NODE:
			getGenNode().clear();
			getGenNode().addAll((Collection<? extends GenNode>)newValue);
			return;
		case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_CONSTRAINT:
			setGenConstraint((GenConstraint)newValue);
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
		case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_NODE:
			getGenNode().clear();
			return;
		case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_CONSTRAINT:
			setGenConstraint((GenConstraint)null);
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
		case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_NODE:
			return genNode != null && !genNode.isEmpty();
		case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT__GEN_CONSTRAINT:
			return genConstraint != null;
		}
		return super.eIsSet(featureID);
	}

} //GenNodeConstraintImpl
