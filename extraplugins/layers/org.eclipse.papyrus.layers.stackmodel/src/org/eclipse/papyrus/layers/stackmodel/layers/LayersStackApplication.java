/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stack Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getLayersStacks <em>Layers Stacks</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getLayerStackRegistry <em>Layer Stack Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getPropertyRegistry <em>Property Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getLayerDescriptorRegistry <em>Layer Descriptor Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getFactory <em>Factory</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getPropertySetterRegistry <em>Property Setter Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getLayerOperatorDescriptorRegistry <em>Layer Operator Descriptor Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayersStackApplication()
 * @model
 * @generated
 */
public interface LayersStackApplication extends FolderElement {
	/**
	 * Returns the value of the '<em><b>Layers Stacks</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStack}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers Stacks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layers Stacks</em>' containment reference list.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayersStackApplication_LayersStacks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<LayersStack> getLayersStacks();

	/**
	 * Returns the value of the '<em><b>Layer Stack Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Stack Registry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Stack Registry</em>' containment reference.
	 * @see #setLayerStackRegistry(LayerStackDescriptorRegistry)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayersStackApplication_LayerStackRegistry()
	 * @model containment="true" required="true" transient="true" ordered="false"
	 * @generated
	 */
	LayerStackDescriptorRegistry getLayerStackRegistry();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getLayerStackRegistry <em>Layer Stack Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Stack Registry</em>' containment reference.
	 * @see #getLayerStackRegistry()
	 * @generated
	 */
	void setLayerStackRegistry(LayerStackDescriptorRegistry value);

	/**
	 * Returns the value of the '<em><b>Property Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Registry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Registry</em>' containment reference.
	 * @see #setPropertyRegistry(PropertyRegistry)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayersStackApplication_PropertyRegistry()
	 * @model containment="true" required="true" transient="true" ordered="false"
	 * @generated
	 */
	PropertyRegistry getPropertyRegistry();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getPropertyRegistry <em>Property Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Registry</em>' containment reference.
	 * @see #getPropertyRegistry()
	 * @generated
	 */
	void setPropertyRegistry(PropertyRegistry value);

	/**
	 * Returns the value of the '<em><b>Layer Descriptor Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Descriptor Registry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Descriptor Registry</em>' containment reference.
	 * @see #setLayerDescriptorRegistry(LayerDescriptorRegistry)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayersStackApplication_LayerDescriptorRegistry()
	 * @model containment="true" required="true" transient="true" ordered="false"
	 * @generated
	 */
	LayerDescriptorRegistry getLayerDescriptorRegistry();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getLayerDescriptorRegistry <em>Layer Descriptor Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Descriptor Registry</em>' containment reference.
	 * @see #getLayerDescriptorRegistry()
	 * @generated
	 */
	void setLayerDescriptorRegistry(LayerDescriptorRegistry value);

	/**
	 * Returns the value of the '<em><b>Factory</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerApplicationFactory#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factory</em>' containment reference.
	 * @see #setFactory(LayerApplicationFactory)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayersStackApplication_Factory()
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayerApplicationFactory#getApplication
	 * @model opposite="application" containment="true" required="true" transient="true" ordered="false"
	 * @generated
	 */
	LayerApplicationFactory getFactory();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getFactory <em>Factory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factory</em>' containment reference.
	 * @see #getFactory()
	 * @generated
	 */
	void setFactory(LayerApplicationFactory value);

	/**
	 * Returns the value of the '<em><b>Property Setter Registry</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Setter Registry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Setter Registry</em>' containment reference.
	 * @see #setPropertySetterRegistry(PropertySetterRegistry)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayersStackApplication_PropertySetterRegistry()
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry#getApplication
	 * @model opposite="application" containment="true" transient="true" ordered="false"
	 * @generated
	 */
	PropertySetterRegistry getPropertySetterRegistry();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getPropertySetterRegistry <em>Property Setter Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Setter Registry</em>' containment reference.
	 * @see #getPropertySetterRegistry()
	 * @generated
	 */
	void setPropertySetterRegistry(PropertySetterRegistry value);

	/**
	 * Returns the value of the '<em><b>Layer Operator Descriptor Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Operator Descriptor Registry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Operator Descriptor Registry</em>' containment reference.
	 * @see #setLayerOperatorDescriptorRegistry(LayerOperatorDescriptorRegistry)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayersStackApplication_LayerOperatorDescriptorRegistry()
	 * @model containment="true" transient="true" ordered="false"
	 * @generated
	 */
	LayerOperatorDescriptorRegistry getLayerOperatorDescriptorRegistry();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication#getLayerOperatorDescriptorRegistry <em>Layer Operator Descriptor Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Operator Descriptor Registry</em>' containment reference.
	 * @see #getLayerOperatorDescriptorRegistry()
	 * @generated
	 */
	void setLayerOperatorDescriptorRegistry(LayerOperatorDescriptorRegistry value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" diagramRequired="true" diagramOrdered="false"
	 * @generated
	 */
	LayersStack getLayersStackFor(Diagram diagram);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model diagramRequired="true" diagramOrdered="false"
	 * @generated
	 */
	void removeLayersStackFor(Diagram diagram);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false" diagramRequired="true" diagramOrdered="false"
	 * @generated
	 */
	boolean isLayersStackAttachedFor(Diagram diagram);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" diagramRequired="true" diagramOrdered="false"
	 * @generated
	 */
	LayersStack createLayersStackFor(Diagram diagram);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.NotFoundException" diagramRequired="true" diagramOrdered="false"
	 * @generated
	 */
	LayersStack lookupLayersStackFor(Diagram diagram) throws NotFoundException;

} // LayersStackApplication
