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
package org.eclipse.papyrus.di;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Edge</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.GraphEdge#getAnchor <em>Anchor</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.GraphEdge#getWaypoints <em>Waypoints</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.di.DiPackage#getGraphEdge()
 * @model
 * @generated
 */
public interface GraphEdge extends GraphElement {

	/**
	 * Returns the value of the '<em><b>Anchor</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.di.GraphConnector}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.di.GraphConnector#getGraphEdge <em>Graph Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anchor</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Anchor</em>' reference list.
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphEdge_Anchor()
	 * @see org.eclipse.papyrus.di.GraphConnector#getGraphEdge
	 * @model opposite="graphEdge" upper="2"
	 * @generated
	 */
	EList<GraphConnector> getAnchor();

	/**
	 * Returns the value of the '<em><b>Waypoints</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.draw2d.geometry.Point}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waypoints</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Waypoints</em>' attribute list.
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphEdge_Waypoints()
	 * @model default="" dataType="org.eclipse.papyrus.di.Point"
	 * @generated
	 */
	EList<Point> getWaypoints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((GraphConnector)getAnchor().get(0)).getGraphElement();'"
	 * @generated
	 */
	GraphElement getAnchorSource();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((GraphConnector)getAnchor().get(1)).getGraphElement();'"
	 * @generated
	 */
	GraphElement getAnchorTarget();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='initConnectors();\r\n((GraphConnector)getAnchor().get(0)).setGraphElement(value);'"
	 * @generated
	 */
	void setAnchorSource(GraphElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='initConnectors();\r\n((GraphConnector)getAnchor().get(1)).setGraphElement(value);'"
	 * @generated
	 */
	void setAnchorTarget(GraphElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(!getAnchor().isEmpty())\r\n    return;\r\n    \t\r\ngetAnchor().add( DiPackage.eINSTANCE.getDiFactory().createGraphConnector() ) ;\r\ngetAnchor().add( DiPackage.eINSTANCE.getDiFactory().createGraphConnector() ) ;\r\n'"
	 * @generated
	 */
	void initConnectors();

} // GraphEdge
