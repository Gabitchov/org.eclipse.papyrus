/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.impl;

import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.di.DiPackage;
import org.eclipse.papyrus.di.GraphConnector;
import org.eclipse.papyrus.di.GraphEdge;
import org.eclipse.papyrus.di.GraphElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.impl.GraphEdgeImpl#getAnchor <em>Anchor</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.GraphEdgeImpl#getWaypoints <em>Waypoints</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GraphEdgeImpl extends GraphElementImpl implements GraphEdge {

	/**
	 * The cached value of the '{@link #getAnchor() <em>Anchor</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAnchor()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphConnector> anchor;

	/**
	 * The cached value of the '{@link #getWaypoints() <em>Waypoints</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getWaypoints()
	 * @generated
	 * @ordered
	 */
	protected EList<Point> waypoints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GraphEdgeImpl() {
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
		return DiPackage.Literals.GRAPH_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<GraphConnector> getAnchor() {
		if(anchor == null) {
			anchor = new EObjectWithInverseResolvingEList.ManyInverse<GraphConnector>(GraphConnector.class, this, DiPackage.GRAPH_EDGE__ANCHOR, DiPackage.GRAPH_CONNECTOR__GRAPH_EDGE);
		}
		return anchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Point> getWaypoints() {
		if(waypoints == null) {
			waypoints = new EDataTypeUniqueEList<Point>(Point.class, this, DiPackage.GRAPH_EDGE__WAYPOINTS);
		}
		return waypoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphElement getAnchorSource() {
		return ((GraphConnector)getAnchor().get(0)).getGraphElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphElement getAnchorTarget() {
		return ((GraphConnector)getAnchor().get(1)).getGraphElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAnchorSource(GraphElement value) {
		initConnectors();
		((GraphConnector)getAnchor().get(0)).setGraphElement(value);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAnchorTarget(GraphElement value) {
		initConnectors();
		((GraphConnector)getAnchor().get(1)).setGraphElement(value);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initConnectors() {
		if(!getAnchor().isEmpty())
			return;

		getAnchor().add(DiPackage.eINSTANCE.getDiFactory().createGraphConnector());
		getAnchor().add(DiPackage.eINSTANCE.getDiFactory().createGraphConnector());

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
		case DiPackage.GRAPH_EDGE__ANCHOR:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnchor()).basicAdd(otherEnd, msgs);
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
		case DiPackage.GRAPH_EDGE__ANCHOR:
			return ((InternalEList<?>)getAnchor()).basicRemove(otherEnd, msgs);
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
		case DiPackage.GRAPH_EDGE__ANCHOR:
			return getAnchor();
		case DiPackage.GRAPH_EDGE__WAYPOINTS:
			return getWaypoints();
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
		case DiPackage.GRAPH_EDGE__ANCHOR:
			getAnchor().clear();
			getAnchor().addAll((Collection<? extends GraphConnector>)newValue);
			return;
		case DiPackage.GRAPH_EDGE__WAYPOINTS:
			getWaypoints().clear();
			getWaypoints().addAll((Collection<? extends Point>)newValue);
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
		case DiPackage.GRAPH_EDGE__ANCHOR:
			getAnchor().clear();
			return;
		case DiPackage.GRAPH_EDGE__WAYPOINTS:
			getWaypoints().clear();
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
		case DiPackage.GRAPH_EDGE__ANCHOR:
			return anchor != null && !anchor.isEmpty();
		case DiPackage.GRAPH_EDGE__WAYPOINTS:
			return waypoints != null && !waypoints.isEmpty();
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
		result.append(" (waypoints: ");
		result.append(waypoints);
		result.append(')');
		return result.toString();
	}

} //GraphEdgeImpl
