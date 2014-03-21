/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.layers.stackmodel.layers.AllViewsDerivedLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.util.DiagramViewToListSynchronizer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>All Views Derived Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AllViewsDerivedLayerImpl extends AbstractLayerImpl implements AllViewsDerivedLayer {
	
	/**
	 * Object used to synchronize a list with the diagram's views.
	 * 
	 */
	protected DiagramViewToListSynchronizer viewsListSynchronizer;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected AllViewsDerivedLayerImpl() {
		super();
		// init the synchronizer
		viewsListSynchronizer = new DiagramViewToListSynchronizer(getViews());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.ALL_VIEWS_DERIVED_LAYER;
	}

	/**
	 * This layer has just been added to a LayerStack.
	 * Set the root of the expression.
	 * Set the views to match the result of the expression.
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#initLayer(org.eclipse.papyrus.layers.stackmodel.layers.LayersStack)
	 *
	 * @param owningLayersStack
	 */
	@Override
	public void initLayer(LayersStack owningLayersStack) {
		super.initLayer(owningLayersStack);
		
		System.err.println(this.getClass().getSimpleName() + ".initLayer(" + owningLayersStack + ")");
		// Set the diagram associated to this tree of layers
		viewsListSynchronizer.setDiagram(owningLayersStack.getDiagram());
	}
} //AllViewsDerivedLayerImpl
