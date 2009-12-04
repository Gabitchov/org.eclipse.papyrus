/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editparts;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactoryRegistry;
import org.eclipse.papyrus.diagram.common.figure.node.DiagramNodeFigure;

/**
 * this class is used to constraint the behavior of a node to obtain the behavior a short cut
 */
public abstract class AbstractShortCutDiagramEditPart extends AbstractBorderedShapeEditPart {

	private IEditorFactoryRegistry editorRegistry;

	public AbstractShortCutDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should implements this
	 * method in order to return the registry associated to the extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 * 
	 */
	protected IEditorFactoryRegistry createEditorRegistry() {
		return new EditorFactoryRegistry(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
	}

	/**
	 * Get the EditorRegistry used to create editor instances. This default implementation return
	 * the singleton eINSTANCE. This method can be subclassed to return another registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 * 
	 */
	protected IEditorFactoryRegistry getEditorRegistry() {
		if(editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}

	/**
	 * get the figure
	 * 
	 * @return
	 */
	public abstract DiagramNodeFigure getPrimaryShape();

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void refresh() {

		refreshIcons();
		super.refresh();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void refreshBounds() {
		int width = 34;
		int height = 20;
		Dimension size = new Dimension(width, height);
		int x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		Point loc = new Point(x, y);
		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(loc, size));
	}

	/**
	 * refresh the icon by taking in account the type of the diagram
	 */
	private void refreshIcons() {
		getPrimaryShape().setIcon(getEditorRegistry().getEditorIcon((Diagram)resolveSemanticElement()));
	}

}
