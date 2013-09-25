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
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.DiagramNodeFigure;

/**
 * this class is used to constraint the behavior of a node to obtain the
 * behavior a short cut
 */
public abstract class AbstractShortCutDiagramEditPart extends AbstractBorderedShapeEditPart implements Adapter {

	protected static final String DELETE_ICON = "icons/delete.gif";

	private IPageIconsRegistry editorRegistry;

	private Notifier target;

	protected Resource resourceToListen;

	public AbstractShortCutDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should
	 * implements this method in order to return the registry associated to the
	 * extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 * 
	 */
	protected IPageIconsRegistry createEditorRegistry() {
		try {
			return ServiceUtilsForEditPart.getInstance().getService(IPageIconsRegistry.class, this);
		} catch (ServiceException e) {
			// Not found, return an empty one which return null for each
			// request.
			return new PageIconsRegistry();
		} catch (NullPointerException e) {
			// if the editor is null null pointer exception is raised
			// Not found, return an empty one which return null for each
			// request.
			return new PageIconsRegistry();
		}
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		super.activate();
		EObject eObject = resolveSemanticElement();
		resourceToListen = eObject.eResource();
		resourceToListen.eAdapters().add(this);

	}

	/**
	 * Get the EditorRegistry used to create editor instances. This default
	 * implementation return the singleton eINSTANCE. This method can be
	 * subclassed to return another registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 * 
	 */
	protected IPageIconsRegistry getEditorRegistry() {
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
	@Override
	public void refreshVisuals() {
		super.refreshVisuals();
		refreshIcons();
		refreshTransparency();
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		refreshIcons();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
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
		if(resolveSemanticElement() instanceof Diagram && resolveSemanticElement().eResource() != null) {
			getPrimaryShape().setIcon(getEditorRegistry().getEditorIcon(resolveSemanticElement()));
		} else {
			getPrimaryShape().setIcon(org.eclipse.papyrus.uml.diagram.common.Activator.getPluginIconImage(org.eclipse.papyrus.uml.diagram.common.Activator.ID, DELETE_ICON));
		}
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		super.deactivate();
		resourceToListen.eAdapters().remove(this);
	}

	public void setTarget(Notifier target) {
		this.target = target;
	}

	public Notifier getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return (getModel().getClass() == type);
	}
}
