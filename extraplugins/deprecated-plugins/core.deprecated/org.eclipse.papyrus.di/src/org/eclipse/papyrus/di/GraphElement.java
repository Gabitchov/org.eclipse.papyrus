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
 * A representation of the model object '<em><b>Graph Element</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.GraphElement#getContained <em>Contained</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.GraphElement#getLink <em>Link</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.GraphElement#getSemanticModel <em>Semantic Model</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.GraphElement#getPosition <em>Position</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.GraphElement#getAnchorage <em>Anchorage</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.di.DiPackage#getGraphElement()
 * @model
 * @generated
 */
public interface GraphElement extends DiagramElement {

	/**
	 * Returns the value of the '<em><b>Contained</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.di.DiagramElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.di.DiagramElement#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contained</em>' containment reference list.
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphElement_Contained()
	 * @see org.eclipse.papyrus.di.DiagramElement#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<DiagramElement> getContained();

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.di.DiagramLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link</em>' containment reference list.
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphElement_Link()
	 * @model containment="true"
	 * @generated
	 */
	EList<DiagramLink> getLink();

	/**
	 * Returns the value of the '<em><b>Semantic Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Model</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Semantic Model</em>' containment reference.
	 * @see #setSemanticModel(SemanticModelBridge)
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphElement_SemanticModel()
	 * @model containment="true"
	 * @generated
	 */
	SemanticModelBridge getSemanticModel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.GraphElement#getSemanticModel <em>Semantic Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Semantic Model</em>' containment reference.
	 * @see #getSemanticModel()
	 * @generated
	 */
	void setSemanticModel(SemanticModelBridge value);

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
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphElement_Position()
	 * @model dataType="org.eclipse.papyrus.di.Point"
	 * @generated
	 */
	Point getPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.GraphElement#getPosition <em>Position</em>}' attribute.
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
	 * Returns the value of the '<em><b>Anchorage</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.di.GraphConnector}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.di.GraphConnector#getGraphElement <em>Graph Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anchorage</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Anchorage</em>' containment reference list.
	 * @see org.eclipse.papyrus.di.DiPackage#getGraphElement_Anchorage()
	 * @see org.eclipse.papyrus.di.GraphConnector#getGraphElement
	 * @model opposite="graphElement" containment="true"
	 * @generated
	 */
	EList<GraphConnector> getAnchorage();

} // GraphElement
