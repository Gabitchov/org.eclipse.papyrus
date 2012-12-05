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
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.editpolicies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Handle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.gmfdiag.hyperlink.ui.AdvancedHLManager;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.helper.HyperLinkHelperFactory;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.ui.HyperLinkManagerShell;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkException;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkHelpersRegistrationUtil;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The Class HyperLinkPopupBarEditPolicy can be applied on edit part to display
 * shortcuts on sub-diagrams or to associate hyper-link of files
 */
public class HyperLinkPopupBarEditPolicy extends DiagramAssistantEditPolicy {

	/**
	 * Default tool placed on the popup bar.
	 * 
	 * @author affrantz@us.ibm.com modified by Patrick Tessier
	 */

	private class PopupBarLabelHandle extends Label implements Handle {

		/**
		 * flag to drawFocus rect around the handle when the mouse rolls over
		 * it.
		 */
		private boolean myMouseOver = false;

		/** The dragTracker CreationTool associated with the handle *. */
		private Object myObject = null;

		/**
		 * constructor.
		 * 
		 * @param theImage
		 *        the image to display
		 * @param anObject
		 *        the an object
		 */
		public PopupBarLabelHandle(Object anObject, Image theImage) {
			super(theImage);
			myObject = anObject;
			this.setOpaque(true);
			this.setBackgroundColor(ColorConstants.buttonLightest);
		}

		/**
		 * Dispose.
		 */
		public void dispose() {
			//Nothing. Do not dispose the Image, as it may be shared

			//			if(this.getIcon() != null && (!this.getIcon().isDisposed())) {
			//				this.getIcon().dispose();
			//			}
		}

		/**
		 * Gets the accessible location.
		 * 
		 * @return the accessible location
		 * 
		 * @see org.eclipse.gef.Handle#getAccessibleLocation()
		 */
		public Point getAccessibleLocation() {
			return null;
		}

		/**
		 * {@inheritedDoc}
		 */
		public DragTracker getDragTracker() {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * Gets the referenced object.
		 * 
		 * @return the referenced object
		 * 
		 * @see org.eclipse.gef.Handle#getDragTracker()
		 */
		public Object getReferencedObject() {
			return myObject;
		}

		/**
		 * Handle mouse entered.
		 * 
		 * @param event
		 *        the event
		 * 
		 * @see org.eclipse.draw2d.IFigure#handleMouseEntered(org.eclipse.draw2d.MouseEvent)
		 *      flip myMouseOver bit and repaint
		 */
		@Override
		public void handleMouseEntered(MouseEvent event) {

			super.handleMouseEntered(event);
			this.setBackgroundColor(ColorConstants.button);
			myMouseOver = true;
			// repaint();
		}

		/**
		 * Handle mouse exited.
		 * 
		 * @param event
		 *        the event
		 * 
		 * @see org.eclipse.draw2d.IFigure#handleMouseExited(org.eclipse.draw2d.MouseEvent)
		 *      flip myMouseOver bit and repaint
		 */
		@Override
		public void handleMouseExited(MouseEvent event) {

			super.handleMouseExited(event);
			this.setBackgroundColor(ColorConstants.white);
			myMouseOver = false;
			// repaint();
		}

		/**
		 * Handle mouse pressed.
		 * 
		 * @param event
		 *        the event
		 * 
		 * @see org.eclipse.draw2d.IFigure#handleMousePressed(org.eclipse.draw2d.MouseEvent)
		 *      set PopupBarEditPolicy.myActionMoveFigure bit so the popup bar
		 *      is not dismissed after creating an item in the editpart
		 */
		@Override
		public void handleMousePressed(MouseEvent event) {
			if(1 == event.button) {
			}
			super.handleMousePressed(event);
		}

		/**
		 * Paint border.
		 * 
		 * @param graphics
		 *        the graphics
		 * 
		 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
		 *      paint a focus rectangle for the label if the mouse is inside the
		 *      label
		 */
		@Override
		protected void paintBorder(Graphics graphics) {
			super.paintBorder(graphics);

			if(myMouseOver) {

				Rectangle area = getClientArea();
				graphics.setForegroundColor(ColorConstants.black);
				graphics.setBackgroundColor(ColorConstants.white);

				graphics.drawFocus(area.x, area.y, area.width - 1, area.height - 1);

			}

		}

		/**
		 * Paint figure.
		 * 
		 * @param graphics
		 *        the graphics
		 * 
		 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		@Override
		protected void paintFigure(Graphics graphics) {
			if(!isEnabled()) {
				Image theImage = this.getIcon();
				if(theImage != null) {
					graphics.translate(bounds.x, bounds.y);
					graphics.drawImage(theImage, getIconLocation());
					graphics.translate(-bounds.x, -bounds.y);
					return;
				}

			}
			super.paintFigure(graphics);

		}
	}

	/**
	 * The Class PopupBarLabelPlusHandle.
	 */
	private class PopupBarLabelPlusHandle extends PopupBarLabelHandle {

		/**
		 * Instantiates a new popup bar label plus handle.
		 */
		public PopupBarLabelPlusHandle() {
			super(null, AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.uml.diagram.common", "/icons/obj16/Plus.gif").createImage());
			// TODO Auto-generated constructor stub
		}
	}

	/**
	 * Listens for mouse key presses so the popup bar can be dismissed if the
	 * context menu is displayed.
	 * 
	 * @author affrantz@us.ibm.com
	 */
	private class PopupBarMouseListener extends MouseListener.Stub {

		/**
		 * Mouse pressed.
		 * 
		 * @param me
		 *        the me
		 * 
		 * @see org.eclipse.draw2d.MouseListener#mousePressed(org.eclipse.draw2d.MouseEvent)
		 */
		@Override
		public void mousePressed(MouseEvent me) {
			if(3 == me.button) // context menu, hide the popup bar
			{
				hideDiagramAssistant();
			}
			if(1 == me.button) // context menu, hide the popup bar
			{
				if(me.getSource() instanceof PopupBarLabelPlusHandle) {
					hyperLinkManagerShell = new AdvancedHLManager(getEditorRegistry(), ((IGraphicalEditPart)getHost()).getEditingDomain(), (EModelElement)((IGraphicalEditPart)getHost()).getNotationView().getElement(), ((IGraphicalEditPart)getHost()).getNotationView(), hyperlinkHelperFactory);
					hyperLinkManagerShell.setInput(hyperLinkObjectList);
					hyperLinkManagerShell.open();

				} else if(me.getSource() instanceof PopupBarLabelHandle) {
					if((((PopupBarLabelHandle)me.getSource()).getReferencedObject()) instanceof HyperLinkObject) {
						HyperLinkObject hyperLinkObject = (HyperLinkObject)(((PopupBarLabelHandle)me.getSource()).getReferencedObject());
						hyperLinkObject.executeSelectPressed();
					}
				}

				hideDiagramAssistant();

			}
			super.mousePressed(me);
			// setPopupBarOnDiagramActivated(true);
		}

		/**
		 * {@inheritedDoc}
		 */
		@Override
		public void mouseReleased(MouseEvent me) {
			super.mouseReleased(me);

		}
	}

	/**
	 * This is the figure that represents the ballon portion of the popup bar.
	 * 
	 * @author affrantz@us.ibm.com
	 */
	private class RoundedRectangleWithTail extends RoundedRectangle {

		/**
		 * constructor.
		 */
		public RoundedRectangleWithTail() {
			// we do not make the myActionTailFigue opaque because it
			// doesn't look good when magnification is set.
			this.setFill(true);
			this.setBackgroundColor(ColorConstants.yellow);
			this.setForegroundColor(ColorConstants.orange);
			this.setVisible(true);
			this.setEnabled(true);
			this.setOpaque(true);

		}

	}

	/** The editor registry. */
	private IPageIconsRegistry editorRegistry;

	/** The figure bar. */
	private IFigure figureBar;

	/** The hyper link manager shell. */
	private HyperLinkManagerShell hyperLinkManagerShell;

	/** Images created that must be deleted when popup bar is removed. */
	protected List<Image> imagesToBeDisposed = new ArrayList<Image>();

	/** mouse keys listener for the owner shape. */
	private final PopupBarMouseListener myMouseKeyListener = new PopupBarMouseListener();

	protected ArrayList<HyperLinkObject> hyperLinkObjectList;

	protected HyperLinkHelperFactory hyperlinkHelperFactory;

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void activate() {
		super.activate();
	}

	public HyperLinkPopupBarEditPolicy() {
		super();
		ArrayList<AbstractHyperLinkHelper> hyperLinkHelpers = new ArrayList<AbstractHyperLinkHelper>();
		//TODO 
		//		hyperLinkHelpers.add(new DiagramHyperLinkHelper());
		//		hyperLinkHelpers.add(new DocumentHyperLinkHelper());
		//		hyperLinkHelpers.add(new WebHyperLinkHelper());
		hyperLinkHelpers.addAll(HyperLinkHelpersRegistrationUtil.INSTANCE.getAllRegisteredHyperLinkHelper());
		hyperlinkHelperFactory = new HyperLinkHelperFactory(hyperLinkHelpers);
	}

	/**
	 * Adds the object list in the popup bar.
	 * 
	 * @param imageLocation
	 *        the image location that will represent the object
	 * @param positonwidth
	 *        the positonwidth to display the icon into the popup
	 * @param objectList
	 *        the object list to add
	 * 
	 * @return the int the new position after adding all objects in the list
	 */
	public int addObjectList(int positonwidth, List<?> objectList) {
		for(int i = 0; i < objectList.size(); i++) {
			PopupBarLabelHandle handle = null;

			ILabelProvider labelProvider = null;
			try {
				EObject contextElement = EMFHelper.getEObject(getHost());
				labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, contextElement).getLabelProvider();
			} catch (ServiceException ex) {
				Activator.log.error(ex);
			}

			if(labelProvider == null) {
				labelProvider = new LabelProvider();
			}

			handle = new PopupBarLabelHandle(hyperLinkObjectList.get(i), labelProvider.getImage(objectList.get(i)));

			Rectangle r1 = new Rectangle();
			r1.setLocation(positonwidth, 5);
			positonwidth += 20;
			r1.setSize(16, 16);

			Label l = new Label();
			if(labelProvider instanceof CellLabelProvider) {
				l.setText(((CellLabelProvider)labelProvider).getToolTipText(hyperLinkObjectList.get(i)));
			} else {
				l.setText(labelProvider.getText(hyperLinkObjectList.get(i)));
			}
			handle.setToolTip(l);

			handle.setPreferredSize(16, 16);
			handle.setBounds(r1);
			handle.setBackgroundColor(ColorConstants.white);
			getFigureBar().add(handle);
			handle.addMouseListener(this.myMouseKeyListener);
			handle.addMouseMotionListener(this);

		}
		return positonwidth;

	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should
	 * implements this method in order to return the registry associated to the
	 * extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 * 
	 * @generated NOT
	 */
	protected IPageIconsRegistry createEditorRegistry() {
		try {
			return ServiceUtilsForEditPart.getInstance().getService(IPageIconsRegistry.class, getHost());
		} catch (ServiceException e) {
			// Return an empty registry always providing null;
			return new PageIconsRegistry();
		}
	}

	/**
	 * Creates the popup bar figure.
	 * 
	 * @return the i figure
	 */
	protected IFigure createPopupBarFigure() {
		figureBar = new RoundedRectangleWithTail();
		return figureBar;
	}

	/**
	 * Gets the editor registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 * 
	 * @generated NOT Get the EditorRegistry used to create editor instances.
	 *            This default implementation return the singleton eINSTANCE.
	 *            This method can be subclassed to return another registry.
	 */
	protected IPageIconsRegistry getEditorRegistry() {
		if(editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}

	/**
	 * Gets the figure bar.
	 * 
	 * @return the figure bar
	 */
	protected IFigure getFigureBar() {

		return figureBar;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected void hideDiagramAssistant() {
		if(getFigureBar() != null) {
			getFigureBar().removeMouseMotionListener(this);
			getFigureBar().removeMouseListener(myMouseKeyListener);
			IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
			if(getFigureBar().getParent() != null) {
				layer.remove(getFigureBar());
			}

			if(imagesToBeDisposed != null) {
				for(Iterator iter = figureBar.getChildren().iterator(); iter.hasNext();) {
					Object current = iter.next();
					if(current instanceof PopupBarLabelHandle) {
						((PopupBarLabelHandle)current).dispose();
					}
				}
				imagesToBeDisposed.clear();
			}
		}
		figureBar = null;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected boolean isDiagramAssistant(Object object) {
		return object instanceof RoundedRectangleWithTail || object instanceof PopupBarLabelHandle;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected boolean isDiagramAssistantShowing() {

		return true;
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @return true, if checks if is preference on
	 */
	@Override
	protected boolean isPreferenceOn() {
		return true;
	}

	/**
	 * fill the popup bar.
	 * 
	 * @return the width of popup bar
	 */
	protected int populatePopup() {
		int xLoc = 5;
		if(getFigureBar() != null) {
			// add all subdiagrams

			try {
				hyperLinkObjectList = (ArrayList<HyperLinkObject>)hyperlinkHelperFactory.getAllreferenced(((IGraphicalEditPart)getHost()).getNotationView());
			} catch (HyperLinkException e) {
				e.printStackTrace();
			}
			xLoc = addObjectList(xLoc, hyperLinkObjectList);
			// add the PLUS button
			PopupBarLabelHandle handle = new PopupBarLabelPlusHandle();
			Rectangle r1 = new Rectangle();
			r1.setLocation(xLoc, 5);
			xLoc += 20;
			r1.setSize(16, 16);

			Label l = new Label();
			l.setText("Add hyperlink");

			handle.setToolTip(l);
			handle.setPreferredSize(16, 16);
			handle.setBounds(r1);
			handle.setBackgroundColor(ColorConstants.white);
			getFigureBar().add(handle);
			handle.addMouseListener(this.myMouseKeyListener);
			handle.addMouseMotionListener(this);
		}
		return xLoc;
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param referencePoint
	 *        the reference point
	 */
	@Override
	protected void showDiagramAssistant(Point referencePoint) {
		if(getFigureBar() == null) {
			createPopupBarFigure();
			int width = populatePopup();
			IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
			layer.add(getFigureBar());
			if(referencePoint == null) {
				referencePoint = getHostFigure().getBounds().getCenter();
			}
			Point position = getHostFigure().getBounds().getBottomLeft();
			getHostFigure().translateToAbsolute(position);
			EditPartViewer viewer = getHost().getRoot().getViewer();
			Viewport viewport = null;
			if(viewer instanceof DiagramGraphicalViewer) {
				viewport = ((FigureCanvas)((DiagramGraphicalViewer)viewer).getControl()).getViewport();
			}
			if(viewport != null) {
				position.x = position.x + viewport.getClientArea().x;
				position.y = position.y + viewport.getClientArea().y;
			}
			getFigureBar().setSize(width, 30);
			getFigureBar().setLocation(position);
			getFigureBar().setBackgroundColor(ColorConstants.white);
			getFigureBar().setForegroundColor(ColorConstants.orange);

			// dismiss the popup bar after a delay
			if(!shouldAvoidHidingDiagramAssistant()) {
				hideDiagramAssistantAfterDelay(getDisappearanceDelay());
			}
		}
	}

	@Override
	protected boolean shouldShowDiagramAssistant() {
		return getHost().isActive() && isPreferenceOn() && isHostEditable() && isHostResolvable() && isDiagramPartActive();
	}

	/**
	 * Checks if the diagram part is active.
	 * 
	 * @return True if the diagram part is active; false otherwise.
	 */
	private boolean isDiagramPartActive() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		if(window != null) {
			IWorkbenchPage page = window.getActivePage();
			if(page != null) {
				IWorkbenchPart activePart = page.getActivePart();

				IDiagramWorkbenchPart editorPart = null;

				if(activePart instanceof IDiagramWorkbenchPart) {
					editorPart = (IDiagramWorkbenchPart)activePart;
				} else if(activePart instanceof IAdaptable) {
					editorPart = (IDiagramWorkbenchPart)((IAdaptable)activePart).getAdapter(IDiagramWorkbenchPart.class);
				}

				if(editorPart == null) {
					return false;
				}

				return editorPart.getDiagramEditPart().getRoot().equals(((IGraphicalEditPart)getHost()).getRoot());
			}
		}
		return false;
	}

	/**
	 * Checks if the host editpart is editable.
	 * 
	 * @return True if the host is editable; false otherwise.
	 */
	private boolean isHostEditable() {
		if(getHost() instanceof GraphicalEditPart) {
			return ((GraphicalEditPart)getHost()).isEditModeEnabled();
		}
		return true;
	}

	/**
	 * Is the host's semantic reference resolvable (if applicable)?
	 * 
	 * @return true if the semantic reference is resolvable, true if there is no
	 *         semantic reference, and false otherwise
	 */
	private boolean isHostResolvable() {
		final View view = (View)getHost().getModel();
		EObject element = view.getElement();
		if(element != null) {
			return !element.eIsProxy();
		}
		return true;
	}
}
