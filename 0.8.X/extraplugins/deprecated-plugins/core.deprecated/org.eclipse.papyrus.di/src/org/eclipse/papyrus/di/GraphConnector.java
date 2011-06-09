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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Connector</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.GraphConnector#getPosition <em>Position</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.GraphConnector#getGraphEdge <em>Graph Edge</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.GraphConnector#getGraphElement <em>Graph Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.di.DiPackage#getGraphConnector()
 * @model
 * @generated
 */
public interface GraphConnector extends EObject {

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(Point)
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphConnector_Position()
	 * @model dataType="org.eclipse.papyrus.di.Point"
	 * @generated
	 */
	Point getPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.GraphConnector#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Point value);

	/**
	 * Returns the value of the '<em><b>Graph Edge</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.di.GraphEdge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.di.GraphEdge#getAnchor <em>Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Edge</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Graph Edge</em>' reference list.
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphConnector_GraphEdge()
	 * @see org.eclipse.papyrus.di.GraphEdge#getAnchor
	 * @model opposite="anchor"
	 * @generated
	 */
	EList<GraphEdge> getGraphEdge();

	/**
	 * Returns the value of the '<em><b>Graph Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.di.GraphElement#getAnchorage <em>Anchorage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Element</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Graph Element</em>' container reference.
	 * @see #setGraphElement(GraphElement)
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphConnector_GraphElement()
	 * @see org.eclipse.papyrus.di.GraphElement#getAnchorage
	 * @model opposite="anchorage" required="true" transient="false"
	 * @generated
	 */
	GraphElement getGraphElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.GraphConnector#getGraphElement <em>Graph Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Graph Element</em>' container reference.
	 * @see #getGraphElement()
	 * @generated
	 */
	void setGraphElement(GraphElement value);

} // GraphConnector
