/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Diagram Link</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.DiagramLink#getDiagram <em>Diagram</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.DiagramLink#getZoom <em>Zoom</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.DiagramLink#getViewport <em>Viewport</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.DiagramLink#getGraphElement <em>Graph Element
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagramLink()
 * @model
 * @generated
 */
public interface DiagramLink extends EObject {

	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Diagram</em>' reference.
	 * @see #setDiagram(Diagram)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagramLink_Diagram()
	 * @model required="true"
	 * @generated
	 */
	Diagram getDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.DiagramLink#getDiagram
	 * <em>Diagram</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Diagram</em>' reference.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(Diagram value);

	/**
	 * Returns the value of the '<em><b>Zoom</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zoom</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Zoom</em>' attribute.
	 * @see #setZoom(double)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagramLink_Zoom()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Double"
	 * @generated
	 */
	double getZoom();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.DiagramLink#getZoom
	 * <em>Zoom</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Zoom</em>' attribute.
	 * @see #getZoom()
	 * @generated
	 */
	void setZoom(double value);

	/**
	 * Returns the value of the '<em><b>Viewport</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewport</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Viewport</em>' attribute.
	 * @see #setViewport(Point)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagramLink_Viewport()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Point"
	 * @generated
	 */
	Point getViewport();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramLink#getViewport <em>Viewport</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Viewport</em>' attribute.
	 * @see #getViewport()
	 * @generated
	 */
	void setViewport(Point value);

	/**
	 * Returns the value of the '<em><b>Graph Element</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Element</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Graph Element</em>' reference.
	 * @see #setGraphElement(GraphElement)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagramLink_GraphElement()
	 * @model required="true"
	 * @generated
	 */
	GraphElement getGraphElement();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramLink#getGraphElement
	 * <em>Graph Element</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Graph Element</em>' reference.
	 * @see #getGraphElement()
	 * @generated
	 */
	void setGraphElement(GraphElement value);

} // DiagramLink
