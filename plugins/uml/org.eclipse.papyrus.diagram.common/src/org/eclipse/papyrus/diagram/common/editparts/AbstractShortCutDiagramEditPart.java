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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.common.figure.node.DiagramNodeFigure;
import org.eclipse.papyrus.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.ui.IWorkbenchPart;

/**
 * this class is used to constraint the behavior of a node to obtain the behavior a short cut
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
	 * 
	 * @return the service registry from the backbone.
	 *         it can return null if it does not found the {@link DiagramEditDomain}
	 */
	public ServicesRegistry getServicesRegistry() {
		IDiagramEditDomain domain = getDiagramEditDomain();
		if(domain instanceof DiagramEditDomain) {
			IWorkbenchPart part = ((DiagramEditDomain)domain).getEditorPart().getEditorSite().getPart();
			if(part instanceof UmlGmfDiagramEditor) {
				return ((UmlGmfDiagramEditor)part).getServicesRegistry();
			}
		}
		return null;
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should implements this
	 * method in order to return the registry associated to the extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 * 
	 */
	protected IPageIconsRegistry createEditorRegistry() {
		try {
			ServicesRegistry servicesRegistry = getServicesRegistry();

			if(servicesRegistry != null) {
				return servicesRegistry.getService(IPageIconsRegistry.class);
			} else {
				return EditorUtils.getServiceRegistry().getService(IPageIconsRegistry.class);
			}
		} catch (ServiceException e) {
			// Not found, return an empty one which return null for each request.
			return new PageIconsRegistry();
		} catch (NullPointerException e) {
			//if the editor is null null pointer exception is raised
			// Not found, return an empty one which return null for each request.
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
	 * Get the EditorRegistry used to create editor instances. This default implementation return
	 * the singleton eINSTANCE. This method can be subclassed to return another registry.
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
	public void refresh() {

		refreshIcons();
		super.refresh();
	}

	@Override
	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		super.notifyChanged(notification);
		refreshIcons();
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
		if(resolveSemanticElement() instanceof Diagram && resolveSemanticElement().eResource() != null) {
			getPrimaryShape().setIcon(getEditorRegistry().getEditorIcon((Diagram)resolveSemanticElement()));
		} else {
			getPrimaryShape().setIcon(org.eclipse.papyrus.diagram.common.Activator.getPluginIconImage(org.eclipse.papyrus.diagram.common.Activator.ID, DELETE_ICON));
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
