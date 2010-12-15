/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2.impl;


import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.conversion.di2.Di2Package;
import org.eclipse.papyrus.conversion.di2.GraphConnector;
import org.eclipse.papyrus.conversion.di2.GraphEdge;
import org.eclipse.papyrus.conversion.di2.GraphElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Graph Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.GraphConnectorImpl#getPosition <em>
 * Position</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.GraphConnectorImpl#getGraphEdge <em>Graph
 * Edge</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.GraphConnectorImpl#getGraphElement <em>
 * Graph Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GraphConnectorImpl extends EObjectImpl implements GraphConnector {

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final Point POSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Point position = POSITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGraphEdge() <em>Graph Edge</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGraphEdge()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphEdge> graphEdge;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GraphConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Di2Package.Literals.GRAPH_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPosition(Point newPosition) {
		Point oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.GRAPH_CONNECTOR__POSITION, oldPosition,
					position));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<GraphEdge> getGraphEdge() {
		if (graphEdge == null) {
			graphEdge = new EObjectWithInverseResolvingEList.ManyInverse<GraphEdge>(GraphEdge.class, this,
					Di2Package.GRAPH_CONNECTOR__GRAPH_EDGE, Di2Package.GRAPH_EDGE__ANCHOR);
		}
		return graphEdge;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphElement getGraphElement() {
		if (eContainerFeatureID != Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT)
			return null;
		return (GraphElement) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGraphElement(GraphElement newGraphElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newGraphElement, Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGraphElement(GraphElement newGraphElement) {
		if (newGraphElement != eInternalContainer()
				|| (eContainerFeatureID != Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT && newGraphElement != null)) {
			if (EcoreUtil.isAncestor(this, newGraphElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraphElement != null)
				msgs = ((InternalEObject) newGraphElement).eInverseAdd(this, Di2Package.GRAPH_ELEMENT__ANCHORAGE,
						GraphElement.class, msgs);
			msgs = basicSetGraphElement(newGraphElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT,
					newGraphElement, newGraphElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Di2Package.GRAPH_CONNECTOR__GRAPH_EDGE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getGraphEdge()).basicAdd(otherEnd, msgs);
		case Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetGraphElement((GraphElement) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Di2Package.GRAPH_CONNECTOR__GRAPH_EDGE:
			return ((InternalEList<?>) getGraphEdge()).basicRemove(otherEnd, msgs);
		case Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT:
			return basicSetGraphElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
		case Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT:
			return eInternalContainer().eInverseRemove(this, Di2Package.GRAPH_ELEMENT__ANCHORAGE, GraphElement.class,
					msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Di2Package.GRAPH_CONNECTOR__POSITION:
			return getPosition();
		case Di2Package.GRAPH_CONNECTOR__GRAPH_EDGE:
			return getGraphEdge();
		case Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT:
			return getGraphElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Di2Package.GRAPH_CONNECTOR__POSITION:
			setPosition((Point) newValue);
			return;
		case Di2Package.GRAPH_CONNECTOR__GRAPH_EDGE:
			getGraphEdge().clear();
			getGraphEdge().addAll((Collection<? extends GraphEdge>) newValue);
			return;
		case Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT:
			setGraphElement((GraphElement) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Di2Package.GRAPH_CONNECTOR__POSITION:
			setPosition(POSITION_EDEFAULT);
			return;
		case Di2Package.GRAPH_CONNECTOR__GRAPH_EDGE:
			getGraphEdge().clear();
			return;
		case Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT:
			setGraphElement((GraphElement) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Di2Package.GRAPH_CONNECTOR__POSITION:
			return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
		case Di2Package.GRAPH_CONNECTOR__GRAPH_EDGE:
			return graphEdge != null && !graphEdge.isEmpty();
		case Di2Package.GRAPH_CONNECTOR__GRAPH_ELEMENT:
			return getGraphElement() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (position: ");
		result.append(position);
		result.append(')');
		return result.toString();
	}

} // GraphConnectorImpl
