/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Graph Element</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.GraphElement#getContained <em>Contained</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.GraphElement#getLink <em>Link</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.GraphElement#getSemanticModel <em>Semantic
 * Model</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.GraphElement#getPosition <em>Position</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.GraphElement#getAnchorage <em>Anchorage</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphElement()
 * @model
 * @generated
 */
public interface GraphElement extends DiagramElement {

	/**
	 * Returns the value of the '<em><b>Contained</b></em>' containment reference list. The list
	 * contents are of type {@link org.eclipse.papyrus.conversion.di2.DiagramElement}. It is
	 * bidirectional and its opposite is '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getContainer
	 * <em>Container</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contained</em>' containment reference list.
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphElement_Contained()
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<DiagramElement> getContained();

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference list. The list contents
	 * are of type {@link org.eclipse.papyrus.conversion.di2.DiagramLink}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link</em>' containment reference list.
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphElement_Link()
	 * @model containment="true"
	 * @generated
	 */
	EList<DiagramLink> getLink();

	/**
	 * Returns the value of the '<em><b>Semantic Model</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Model</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Semantic Model</em>' containment reference.
	 * @see #setSemanticModel(SemanticModelBridge)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphElement_SemanticModel()
	 * @model containment="true"
	 * @generated
	 */
	SemanticModelBridge getSemanticModel();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphElement#getSemanticModel
	 * <em>Semantic Model</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Semantic Model</em>' containment reference.
	 * @see #getSemanticModel()
	 * @generated
	 */
	void setSemanticModel(SemanticModelBridge value);

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
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphElement_Position()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Point"
	 * @generated
	 */
	Point getPosition();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphElement#getPosition <em>Position</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Point value);

	/**
	 * Returns the value of the '<em><b>Anchorage</b></em>' containment reference list. The list
	 * contents are of type {@link org.eclipse.papyrus.conversion.di2.GraphConnector}. It is
	 * bidirectional and its opposite is '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphConnector#getGraphElement
	 * <em>Graph Element</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anchorage</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Anchorage</em>' containment reference list.
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getGraphElement_Anchorage()
	 * @see org.eclipse.papyrus.conversion.di2.GraphConnector#getGraphElement
	 * @model opposite="graphElement" containment="true"
	 * @generated
	 */
	EList<GraphConnector> getAnchorage();

} // GraphElement
