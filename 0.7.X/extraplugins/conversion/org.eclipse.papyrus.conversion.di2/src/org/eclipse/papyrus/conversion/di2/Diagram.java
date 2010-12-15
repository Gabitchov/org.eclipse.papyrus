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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Diagram</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Diagram#getOwner <em>Owner</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Diagram#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Diagram#getZoom <em>Zoom</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Diagram#getViewport <em>Viewport</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Diagram#getDiagramLink <em>Diagram Link</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Diagram#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends GraphNode {

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' containment reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' containment reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owner</em>' containment reference.
	 * @see #setOwner(SemanticModelBridge)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagram_Owner()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SemanticModelBridge getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Diagram#getOwner
	 * <em>Owner</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Owner</em>' containment reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(SemanticModelBridge value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagram_Name()
	 * @model dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Diagram#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagram_Zoom()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Double"
	 * @generated
	 */
	double getZoom();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Diagram#getZoom
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
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagram_Viewport()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Point"
	 * @generated
	 */
	Point getViewport();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Diagram#getViewport
	 * <em>Viewport</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Viewport</em>' attribute.
	 * @see #getViewport()
	 * @generated
	 */
	void setViewport(Point value);

	/**
	 * Returns the value of the '<em><b>Diagram Link</b></em>' reference list. The list contents are
	 * of type {@link org.eclipse.papyrus.conversion.di2.DiagramLink}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Link</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Diagram Link</em>' reference list.
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagram_DiagramLink()
	 * @model
	 * @generated
	 */
	EList<DiagramLink> getDiagramLink();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getDiagram_Type()
	 * @model dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Diagram#getType
	 * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // Diagram
