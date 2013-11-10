/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression#isLayerEnabledInternal <em>Is Layer Enabled Internal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression#isLayerEnabled <em>Is Layer Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerExpression()
 * @model abstract="true"
 * @generated
 */
public interface LayerExpression extends ApplicationDependantElement {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerExpression_Name()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerExpression_Description()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Layer Enabled Internal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Layer Enabled Internal</em>' attribute.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerExpression_IsLayerEnabledInternal()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isLayerEnabledInternal();

	/**
	 * Returns the value of the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Layer Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Layer Enabled</em>' attribute.
	 * @see #setIsLayerEnabled(boolean)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerExpression_IsLayerEnabled()
	 * @model default="true" dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isLayerEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression#isLayerEnabled <em>Is Layer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Layer Enabled</em>' attribute.
	 * @see #isLayerEnabled()
	 * @generated
	 */
	void setIsLayerEnabled(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.ComputePropertyValueCommand" required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException" viewRequired="true" viewOrdered="false" propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	ComputePropertyValueCommand getComputePropertyValueCommand(View view, Property property) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.ComputePropertyValueCommand" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException" viewMany="true" propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	EList<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(EList<View> view, Property property) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.ComputePropertyValueCommand" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException" viewRequired="true" viewOrdered="false" propertyRequired="true" propertyMany="true"
	 * @generated
	 */
	EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, EList<Property> property) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.NotFoundException"
	 * @generated
	 */
	LayersStack getLayersStack() throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws LayersException 
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.ComputePropertyValueCommand" viewMany="true" propertyRequired="true" propertyOrdered="false"
	 * @generated NOT
	 */
	EList<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(List<View> view, Property property) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws LayersException 
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.ComputePropertyValueCommand" viewRequired="true" viewOrdered="false" propertyRequired="true" propertyMany="true"
	 * @generated NOT
	 */
	EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, List<Property> property) throws LayersException;
} // LayerExpression
