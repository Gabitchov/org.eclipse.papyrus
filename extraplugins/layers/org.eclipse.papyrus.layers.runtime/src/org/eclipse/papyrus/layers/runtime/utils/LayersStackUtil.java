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
package org.eclipse.papyrus.layers.runtime.utils;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;

/**
 * Utility methods allowing to manipulate Layers.
 * 
 * @author cedric dumoulin
 *
 */
public class LayersStackUtil {
	
	/**
	 * Global instance of the class.
	 */
	public static LayersStackUtil instance = new LayersStackUtil();

	public static final String LAYER_STACK_ID = "layersStack";
	
	/**
	 * @return the instance
	 */
	public static LayersStackUtil getInstance() {
		return instance;
	}

	/**
	 * Get the {@link LayersStack} style associated to the diagram. Create it if not found.
	 * Return the associated LayersStack.
	 * @param diagram
	 * @return
	 */
	public LayersStack getLayersStack(Diagram diagram)
	{
		LayersStack layerStyle = lookupLayersStack(diagram);
		 if( layerStyle == null)
		 {
			 // Create a new one
			 layerStyle = createLayersStack(diagram);
		 }
		 return layerStyle;
	}
	
	/**
	 * Search the {@link LayersStack} style associated to the diagram if any.
	 * Return the associated LayersStack or null.
	 * @param diagram
	 * @return
	 */
	public LayersStack lookupLayersStack(Diagram diagram)
	{
		 Style layerStyle = diagram.getNamedStyle(LayersPackage.Literals.LAYERS_STACK, LAYER_STACK_ID);
		 return (LayersStack)layerStyle;
	}
	
	/**
	 * Create a {@link LayersStack} for the existing diagram.
	 * @param diagram The diagram to which the layer is associated.
	 * @return The created Layer.
	 */
	protected LayersStack createLayersStack(Diagram diagram)
	{
		LayersStack style = (LayersStack)diagram.createStyle(LayersPackage.Literals.LAYERS_STACK);
		 style.setName( LAYER_STACK_ID);	
		 return style;
	}

	/**
	 * Detach the LayersStack from its Diagram.
	 * @return The created Layer.
	 */
	public void removeLayersStack(Diagram diagram)
	{
		LayersStack style = lookupLayersStack(diagram);
		if( style != null)
		{
			diagram.getStyles().remove(style);
		}
	}

	/**
	 * Return True if a {@link LayersStack} is attached to the specified diagram.
	 * @param diagram Diagram to check.
	 * @return True if a {@link LayersStack} is attached to the specified diagram.
	 */
	public boolean isLayersStackAttached( Diagram diagram ) {
		return lookupLayersStack(diagram)!=null;
	}

//
//	/**
//	 * <!-- begin-user-doc -->
//	 * Visit all Views accessible from the associated diagram.
//	 * Call the visitAttachedLayer() on each of these Views. The method is called once for each Views.
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void visitAllViews(Diagram diagram, Accumulator visitor) {
//		
//		// Iterate over all View contained in the diagram
//		TreeIterator<EObject> iter = diagram.eAllContents();
//		while(iter.hasNext())
//		{
//			EObject cur = iter.next();
//			if(cur instanceof View)
//			{
//				// This is a View. Check if there is an attached LayerViewStyle
//				LayerViewStyle viewStyle = ViewUtil.getInstance().lookupLayerViewStyle((View)cur);
//				if(viewStyle != null)
//				{
//					// Visit the ViewStyle to compute the new values
//					viewStyle.visitAttachedLayers(visitor);
//				}
//			}
//		}
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * Visit all Views Visit all Views provided as parameters.
//	 * Call the visitAttachedLayer() on each of these Views. The method is called once for each 
//	 * specified Views.
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void visitViews(List<View> views, Accumulator visitor) {
//		
//		for( View view : views)
//		{
//			if(view instanceof View)
//			{
//				// This is a View. Check if there is an attached LayerViewStyle
//				LayerViewStyle viewStyle = ViewUtil.getInstance().lookupLayerViewStyle((View)view);
//				if(viewStyle != null)
//				{
//					// Visit the ViewStyle to compute the new values
//					viewStyle.visitAttachedLayers(visitor);
//				}
//			}
//		}
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * Visit all Views Visit all Views provided as parameters.
//	 * Call the visitAttachedLayer() on each of these Views. The method is called once for each 
//	 * specified Views.
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void visitViewStyles(List<LayerViewStyle> viewStyles, Accumulator visitor) {
//		
//		// Iterate over all LayerViewStyle
//		for( LayerViewStyle viewStyle : viewStyles)
//		{
//				if(viewStyle != null)
//				{
//					// Visit the ViewStyle to compute the new values
//					viewStyle.visitAttachedLayers(visitor);
//				}
//	
//		}
//	}
//
//
//	
//	/**
//	 * Create a default layer (SimpleLayer) on top of existing layers for the provided diagram.
//	 * @param diagram The diagram to which the layer is associated.
//	 * @return The created Layer.
//	 */
//	public Layer createLayer(Diagram diagram)
//	{
//		 throw new UnsupportedOperationException("Not yet implemented");	
//	}
//
//	/**
//	 * Remove the specified Layer from its diagram.
//	 * @param diagram
//	 * @param layer
//	 * @return The removed Layer.
//	 */
//	public Layer removeLayer(Diagram diagram, Layer layer)
//	{
//		 throw new UnsupportedOperationException("Not yet implemented");	
//		
//	}
//	
//	/**
//	 * Add the specified View to the specified Layer. Return the View.
//	 * The view must belong to the Diagram associated to the Layer.
//	 * Return the Layer counterpart (LayerViewStyle).
//	 * 
//	 * @param diagram The diagram to wich the view belong TODO remove ? The Diagram can be found from the view ?
//	 * @param layer The layer to which the view should be attached.
//	 * @param view The view to associate to the Layer
//	 * @return The LayerViewStyle associated to the attached View.
//	 */
//	public LayerViewStyle addView(Diagram diagram, Layer layer, View view)
//	{
//		 throw new UnsupportedOperationException("Not yet implemented");	
//		
//	}
//	
//	public LayerViewStyle removeView(Layer layer, View view)
//	{
//		 throw new UnsupportedOperationException("Not yet implemented");	
//
//	}
//	
//	/**
//	 * Get the currently selected {@link Layer} or null if none can be found.
//	 * @param diagram
//	 * @return
//	 */
//	public Layer lookupSelectedLayer(Diagram diagram)
//	{
//		LayersStack stack = lookupLayersStack(diagram);
//		 if( stack == null)
//		 {
//			 return null;
//		 }
//		 
//		 try {
//			return stack.getSelectedLayerManager().getSelectedLayer();
//		} catch (NoLayerSelectedException e) {
//			return null;
//		}
//	}
//	

}
