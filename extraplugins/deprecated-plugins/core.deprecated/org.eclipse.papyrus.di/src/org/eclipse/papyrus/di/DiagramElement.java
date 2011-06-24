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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getProperty <em>Property</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#isIsVisible <em>Is Visible</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getReference <em>Reference</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getContainer <em>Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getFontFamily <em>Font Family</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getFontSize <em>Font Size</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getLineStyle <em>Line Style</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getLineThickness <em>Line Thickness</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getFontColor <em>Font Color</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getForegroundColor <em>Foreground Color</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getBackgroundColor <em>Background Color</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getBorderColor <em>Border Color</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#isTranslucent <em>Translucent</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getSemanticParent <em>Semantic Parent</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.DiagramElement#getSemanticChild <em>Semantic Child</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement()
 * @model
 * @generated
 */
public interface DiagramElement extends EObject {

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.di.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_Property()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperty();

	/**
	 * Returns the value of the '<em><b>Is Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Visible</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Visible</em>' attribute.
	 * @see #setIsVisible(boolean)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_IsVisible()
	 * @model dataType="org.eclipse.uml2.uml.Boolean"
	 * @generated
	 */
	boolean isIsVisible();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#isIsVisible <em>Is Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Visible</em>' attribute.
	 * @see #isIsVisible()
	 * @generated
	 */
	void setIsVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.di.Reference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reference</em>' reference list.
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_Reference()
	 * @model
	 * @generated
	 */
	EList<Reference> getReference();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.di.GraphElement#getContained <em>Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(GraphElement)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_Container()
	 * @see org.eclipse.papyrus.di.GraphElement#getContained
	 * @model opposite="contained" transient="false"
	 * @generated
	 */
	GraphElement getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(GraphElement value);

	/**
	 * Returns the value of the '<em><b>Font Family</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Family</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Font Family</em>' attribute.
	 * @see #setFontFamily(String)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_FontFamily()
	 * @model default="" dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getFontFamily();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getFontFamily <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Font Family</em>' attribute.
	 * @see #getFontFamily()
	 * @generated
	 */
	void setFontFamily(String value);

	/**
	 * Returns the value of the '<em><b>Font Size</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Size</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Font Size</em>' attribute.
	 * @see #setFontSize(int)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_FontSize()
	 * @model default="10" dataType="org.eclipse.uml2.uml.Integer"
	 * @generated
	 */
	int getFontSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getFontSize <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Font Size</em>' attribute.
	 * @see #getFontSize()
	 * @generated
	 */
	void setFontSize(int value);

	/**
	 * Returns the value of the '<em><b>Line Style</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Style</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Line Style</em>' attribute.
	 * @see #setLineStyle(String)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_LineStyle()
	 * @model default="" dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getLineStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getLineStyle <em>Line Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Line Style</em>' attribute.
	 * @see #getLineStyle()
	 * @generated
	 */
	void setLineStyle(String value);

	/**
	 * Returns the value of the '<em><b>Line Thickness</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Thickness</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Line Thickness</em>' attribute.
	 * @see #setLineThickness(int)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_LineThickness()
	 * @model default="1" dataType="org.eclipse.uml2.uml.Integer"
	 * @generated
	 */
	int getLineThickness();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getLineThickness <em>Line Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Line Thickness</em>' attribute.
	 * @see #getLineThickness()
	 * @generated
	 */
	void setLineThickness(int value);

	/**
	 * Returns the value of the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Color</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Font Color</em>' attribute.
	 * @see #setFontColor(RGB)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_FontColor()
	 * @model dataType="org.eclipse.papyrus.di.RGB"
	 * @generated
	 */
	RGB getFontColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getFontColor <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Font Color</em>' attribute.
	 * @see #getFontColor()
	 * @generated
	 */
	void setFontColor(RGB value);

	/**
	 * Returns the value of the '<em><b>Foreground Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreground Color</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Foreground Color</em>' attribute.
	 * @see #setForegroundColor(RGB)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_ForegroundColor()
	 * @model dataType="org.eclipse.papyrus.di.RGB"
	 * @generated
	 */
	RGB getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getForegroundColor <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Foreground Color</em>' attribute.
	 * @see #getForegroundColor()
	 * @generated
	 */
	void setForegroundColor(RGB value);

	/**
	 * Returns the value of the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Color</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Background Color</em>' attribute.
	 * @see #setBackgroundColor(RGB)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_BackgroundColor()
	 * @model dataType="org.eclipse.papyrus.di.RGB"
	 * @generated
	 */
	RGB getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getBackgroundColor <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Background Color</em>' attribute.
	 * @see #getBackgroundColor()
	 * @generated
	 */
	void setBackgroundColor(RGB value);

	/**
	 * Returns the value of the '<em><b>Border Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Color</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Border Color</em>' attribute.
	 * @see #setBorderColor(RGB)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_BorderColor()
	 * @model dataType="org.eclipse.papyrus.di.RGB"
	 * @generated
	 */
	RGB getBorderColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getBorderColor <em>Border Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Border Color</em>' attribute.
	 * @see #getBorderColor()
	 * @generated
	 */
	void setBorderColor(RGB value);

	/**
	 * Returns the value of the '<em><b>Translucent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translucent</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Translucent</em>' attribute.
	 * @see #setTranslucent(boolean)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_Translucent()
	 * @model dataType="org.eclipse.uml2.uml.Boolean"
	 * @generated
	 */
	boolean isTranslucent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#isTranslucent <em>Translucent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Translucent</em>' attribute.
	 * @see #isTranslucent()
	 * @generated
	 */
	void setTranslucent(boolean value);

	/**
	 * Returns the value of the '<em><b>Semantic Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.di.DiagramElement#getSemanticChild <em>Semantic Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Parent</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Semantic Parent</em>' reference.
	 * @see #setSemanticParent(DiagramElement)
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_SemanticParent()
	 * @see org.eclipse.papyrus.di.DiagramElement#getSemanticChild
	 * @model opposite="semanticChild"
	 * @generated
	 */
	DiagramElement getSemanticParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.DiagramElement#getSemanticParent <em>Semantic Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Semantic Parent</em>' reference.
	 * @see #getSemanticParent()
	 * @generated
	 */
	void setSemanticParent(DiagramElement value);

	/**
	 * Returns the value of the '<em><b>Semantic Child</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.di.DiagramElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.di.DiagramElement#getSemanticParent <em>Semantic Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Child</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Semantic Child</em>' reference list.
	 * @see org.eclipse.papyrus.di.DiPackage#getDiagramElement_SemanticChild()
	 * @see org.eclipse.papyrus.di.DiagramElement#getSemanticParent
	 * @model opposite="semanticParent"
	 * @generated
	 */
	EList<DiagramElement> getSemanticChild();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model keyDataType="org.eclipse.uml2.uml.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='java.util.Iterator it = getProperty().iterator();\r\nwhile (it.hasNext()) {\r\n\tProperty element = (Property) it.next();\r\n\tif(key.equals(element.getKey())) {\r\n\t\treturn element;\r\n\t}\r\n}\r\nreturn null;'"
	 * @generated
	 */
	Property getProperty(String key);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model dataType="org.eclipse.papyrus.di.String" keyDataType="org.eclipse.uml2.uml.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=' if(this.getProperty(key)!=null){\r\n\treturn this.getProperty(key).getValue();}\r\nreturn null;\r\n\t'"
	 * @generated
	 */
	String getPropertyValue(String key);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * it is used to obtain the name of the good editpart
	 * <!-- end-model-doc -->
	 * 
	 * @model kind="operation" dataType="org.eclipse.uml2.uml.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getPropertyValue(org.eclipse.papyrus.di.PapyrusKeyEnumeration.PAPYRUSEDITPART.getLiteral());'"
	 * @generated
	 */
	String getEditpartName();

} // DiagramElement
