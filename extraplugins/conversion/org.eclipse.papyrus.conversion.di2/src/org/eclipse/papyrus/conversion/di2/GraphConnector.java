/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Graph Connector</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.GraphConnector#getPosition <em>Position</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.GraphConnector#getGraphEdge <em>Graph Edge
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.GraphConnector#getGraphElement <em>Graph
 * Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphConnector()
 * @model
 * @generated
 */
public interface GraphConnector extends EObject {

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(Point)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphConnector_Position()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Point"
	 * @generated
	 */
	Point getPosition();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphConnector#getPosition <em>Position</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Point value);

	/**
	 * Returns the value of the '<em><b>Graph Edge</b></em>' reference list. The list contents are
	 * of type {@link org.eclipse.papyrus.conversion.di2.GraphEdge}. It is bidirectional and
	 * its opposite is '{@link org.eclipse.papyrus.conversion.di2.GraphEdge#getAnchor
	 * <em>Anchor</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Edge</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Graph Edge</em>' reference list.
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphConnector_GraphEdge()
	 * @see org.eclipse.papyrus.conversion.di2.GraphEdge#getAnchor
	 * @model opposite="anchor"
	 * @generated
	 */
	EList<GraphEdge> getGraphEdge();

	/**
	 * Returns the value of the '<em><b>Graph Element</b></em>' container reference. It is
	 * bidirectional and its opposite is '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphElement#getAnchorage <em>Anchorage</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Element</em>' container reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Graph Element</em>' container reference.
	 * @see #setGraphElement(GraphElement)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphConnector_GraphElement()
	 * @see org.eclipse.papyrus.conversion.di2.GraphElement#getAnchorage
	 * @model opposite="anchorage" required="true" transient="false"
	 * @generated
	 */
	GraphElement getGraphElement();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphConnector#getGraphElement
	 * <em>Graph Element</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Graph Element</em>' container reference.
	 * @see #getGraphElement()
	 * @generated
	 */
	void setGraphElement(GraphElement value);

} // GraphConnector
