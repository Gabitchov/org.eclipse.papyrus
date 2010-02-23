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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Link</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.DiagramLink#getDiagram <em>Diagram</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramLink#getZoom <em>Zoom</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramLink#getViewport <em>Viewport</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramLink#getGraphElement <em>Graph Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.di.DiPackage#getDiagramLink()
 * @model
 * @generated
 */
public interface DiagramLink extends EObject {

	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Diagram</em>' reference.
	 * @see #setDiagram(Diagram)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramLink_Diagram()
	 * @model required="true"
	 * @generated
	 */
	Diagram getDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramLink#getDiagram <em>Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Diagram</em>' reference.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(Diagram value);

	/**
	 * Returns the value of the '<em><b>Zoom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zoom</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Zoom</em>' attribute.
	 * @see #setZoom(double)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramLink_Zoom()
	 * @model dataType="org.eclipse.papyrus.di.Double"
	 * @generated
	 */
	double getZoom();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramLink#getZoom <em>Zoom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Zoom</em>' attribute.
	 * @see #getZoom()
	 * @generated
	 */
	void setZoom(double value);

	/**
	 * Returns the value of the '<em><b>Viewport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewport</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Viewport</em>' attribute.
	 * @see #setViewport(Point)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramLink_Viewport()
	 * @model dataType="org.eclipse.papyrus.di.Point"
	 * @generated
	 */
	Point getViewport();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramLink#getViewport <em>Viewport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Viewport</em>' attribute.
	 * @see #getViewport()
	 * @generated
	 */
	void setViewport(Point value);

	/**
	 * Returns the value of the '<em><b>Graph Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Element</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Graph Element</em>' reference.
	 * @see #setGraphElement(GraphElement)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramLink_GraphElement()
	 * @model required="true"
	 * @generated
	 */
	GraphElement getGraphElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramLink#getGraphElement <em>Graph Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Graph Element</em>' reference.
	 * @see #getGraphElement()
	 * @generated
	 */
	void setGraphElement(GraphElement value);

} // DiagramLink
