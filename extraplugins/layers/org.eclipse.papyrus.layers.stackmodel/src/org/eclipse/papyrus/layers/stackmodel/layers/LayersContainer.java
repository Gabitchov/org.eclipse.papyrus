/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Layers implementing this interface can contains others layers.
 * The interface provide one method allowing to add a LayerExpression to the container.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayersContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LayersContainer extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model layerRequired="true" layerOrdered="false"
	 * @generated
	 */
	void addLayer(LayerExpression layer);

} // LayersContainer
