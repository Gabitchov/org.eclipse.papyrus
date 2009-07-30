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
package org.eclipse.papyrus.diagram.common.editpolicies;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Handle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.l10n.DiagramUIPluginImages;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactoryRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.common.ui.HyperLinkManagerShell;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.papyrus.umlutils.ui.helper.HyperlinkHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.Element;

/**
 * The Class HyperLinkPopupBarEditPolicy can be applied on edit part to display shortcuts on
 * sub-diagrams or to associate hyper-link of files
 */
public class HyperLinkPopupBarEditPolicy extends DiagramAssistantEditPolicy {

	/**
	 * Default tool placed on the popup bar.
	 * 
	 * @author affrantz@us.ibm.com modified by Patrick Tessier
	 */

	private class PopupBarLabelHandle extends Label implements Handle {

		/** flag to drawFocus rect around the handle when the mouse rolls over it. */
		private boolean myMouseOver = false;

		/** The dragTracker CreationTool associated with the handle *. */
		private Object myObject = null;

		/**
		 * constructor.
		 * 
		 * @param theImage
		 *            the image to display
		 * @param anObject
		 *            the an object
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
			if (this.getIcon() != null && (!this.getIcon().isDisposed())) {
				this.getIcon().dispose();
			}

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
		 *            the event
		 * 
		 * @see org.eclipse.draw2d.IFigure#handleMouseEntered(org.eclipse.draw2d.MouseEvent) flip
		 *      myMouseOver bit and repaint
		 */
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
		 *            the event
		 * 
		 * @see org.eclipse.draw2d.IFigure#handleMouseExited(org.eclipse.draw2d.MouseEvent) flip
		 *      myMouseOver bit and repaint
		 */
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
		 *            the event
		 * 
		 * @see org.eclipse.draw2d.IFigure#handleMousePressed(org.eclipse.draw2d.MouseEvent) set
		 *      PopupBarEditPolicy.myActionMoveFigure bit so the popup bar is not dismissed after
		 *      creating an item in the editpart
		 */
		public void handleMousePressed(MouseEvent event) {

			if (1 == event.button) {

			}

			super.handleMousePressed(event);
		}

		/**
		 * Paint border.
		 * 
		 * @param graphics
		 *            the graphics
		 * 
		 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics) paint a focus
		 *      rectangle for the label if the mouse is inside the label
		 */
		protected void paintBorder(Graphics graphics) {
			super.paintBorder(graphics);

			if (myMouseOver) {

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
		 *            the graphics
		 * 
		 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		protected void paintFigure(Graphics graphics) {
			if (!isEnabled()) {
				Image theImage = this.getIcon();
				if (theImage != null) {
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
			super(null, AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
					"/icons/obj16/Plus.gif").createImage());
			// TODO Auto-generated constructor stub
		}
	}

	/**
	 * Listens for mouse key presses so the popup bar can be dismissed if the context menu is
	 * displayed.
	 * 
	 * @author affrantz@us.ibm.com
	 */
	private class PopupBarMouseListener extends MouseListener.Stub {

		/**
		 * Mouse pressed.
		 * 
		 * @param me
		 *            the me
		 * 
		 * @see org.eclipse.draw2d.MouseListener#mousePressed(org.eclipse.draw2d.MouseEvent)
		 */
		public void mousePressed(MouseEvent me) {
			if (3 == me.button) // context menu, hide the popup bar
			{
				hideDiagramAssistant();
			}
			if (1 == me.button) // context menu, hide the popup bar
			{
				IPageMngr pageMngr = EditorUtils.getIPageMngr();
				if (me.getSource() instanceof PopupBarLabelPlusHandle) {
					hyperLinkManagerShell = new HyperLinkManagerShell((Element) ((GraphicalEditPart) getHost())
							.getNotationView().getElement(), ((GraphicalEditPart) getHost()).getNotationView(),
							getEditorRegistry(), ((GraphicalEditPart) getHost()).getEditingDomain());
					hyperLinkManagerShell.createShell();

				} else if (me.getSource() instanceof PopupBarLabelHandle) {
					if ((((PopupBarLabelHandle) me.getSource()).getReferencedObject()) instanceof Diagram) {
						// better to set focus on existing page than close and open
						if (pageMngr.isOpen(((PopupBarLabelHandle) me.getSource()).getReferencedObject())) {
							pageMngr.closePage(((PopupBarLabelHandle) me.getSource()).getReferencedObject());
						}
						pageMngr.openPage(((PopupBarLabelHandle) me.getSource()).getReferencedObject());
					}
					if ((((PopupBarLabelHandle) me.getSource()).getReferencedObject()) instanceof String) {
						try {

							String url = (String) (((PopupBarLabelHandle) me.getSource()).getReferencedObject());
							// this is an url
							if (url.startsWith("http")) {
								PlatformUI.getWorkbench().getBrowserSupport().createBrowser(
										IWorkbenchBrowserSupport.AS_EXTERNAL, "aCustomId", "url", "url").openURL(
										new URL(url));
							} else {
								// this is a file try to open it
								IEditorDescriptor eDesc = PlatformUI.getWorkbench().getEditorRegistry().findEditor(
										IEditorRegistry.SYSTEM_EXTERNAL_EDITOR_ID);

								// creation of a phantom workspace
								IWorkspace ws = ResourcesPlugin.getWorkspace();
								IProject project = ws.getRoot().getProject("External Files");
								if (!project.exists())
									project.create(null);
								if (!project.isOpen())
									project.open(null);
								IPath location = new Path(url);
								IFile file = project.getFile(location.lastSegment());
								if (!file.exists()) {
									file.createLink(location, IResource.NONE, null);
								}
								IEditorInput editorInput = new FileEditorInput(file);
								IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
								IWorkbenchPage page = window.getActivePage();
								page.openEditor(editorInput, eDesc.getId());
							}
						} catch (Exception e) {
							System.err.println(e);
						}
					}

					hideDiagramAssistant();

				}
			}
			super.mousePressed(me);
			// setPopupBarOnDiagramActivated(true);
		}

		/**
		 * {@inheritedDoc}
		 */
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

		/** The b is init. */
		private boolean bIsInit = false;

		/** The my corner dimension. */
		private int myCornerDimension = 3;

		/** The my tail image. */
		private Image myTailImage = null;

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

		/**
		 * Gets the tail.
		 * 
		 * @return the tail
		 */
		private Image getTail() {
			if (!bIsInit) {
				if (myTailImage == null) {
					myTailImage = IMAGE_POPUPBAR_PLUS;
					bIsInit = true;
				}

			}
			return myTailImage;

		}

	}

	/** The IMAG e_ popupba r_ plus. */
	private static Image IMAGE_POPUPBAR_PLUS = DiagramUIPluginImages.get(DiagramUIPluginImages.IMG_POPUPBAR_PLUS);

	/** The POPUPBA r_ mov e_ figure. */
	static private int POPUPBAR_MOVE_FIGURE = 0x02; /*
													 * Ignore the first figureMoved event when
													 * creating elements inside a shape via a popup
													 * bar
													 */

	/** The POPUPBA r_ ondiagramactivated. */
	static private int POPUPBAR_ONDIAGRAMACTIVATED = 0x10; /*
															 * For popup bars on diagram and machine
															 * edit parts, where we
															 * POPUPBAR_DISPLAYATMOUSEHOVERLOCATION,
															 * don't display popup bar until user
															 * clicks on surface
															 */

	/** The editor registry. */
	private IEditorFactoryRegistry editorRegistry;

	/** The figure bar. */
	private IFigure figureBar;

	/** The hyper link manager shell. */
	private HyperLinkManagerShell hyperLinkManagerShell;

	/** Images created that must be deleted when popup bar is removed. */
	protected List<Image> imagesToBeDisposed = new ArrayList<Image>();

	/** mouse keys listener for the owner shape. */
	private PopupBarMouseListener myMouseKeyListener = new PopupBarMouseListener();

	/**
	 * {@inheritedDoc}
	 */
	public void activate() {
		super.activate();
	}

	/**
	 * Adds the object list in the popup bar.
	 * 
	 * @param imageLocation
	 *            the image location that will represent the object
	 * @param positonwidth
	 *            the positonwidth to display the icon into the popup
	 * @param objectList
	 *            the object list to add
	 * 
	 * @return the int the new position after adding all objects in the list
	 */
	public int addObjectList(String imageLocation, int positonwidth, List<String> objectList) {
		for (int i = 0; i < objectList.size(); i++) {
			PopupBarLabelHandle handle = new PopupBarLabelHandle(objectList.get(i), AbstractUIPlugin
					.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", imageLocation).createImage());

			Rectangle r1 = new Rectangle();
			r1.setLocation(positonwidth, 5);
			positonwidth += 20;
			r1.setSize(16, 16);

			Label l = new Label();
			l.setText(objectList.get(i));

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
	 * Return the EditorRegistry for nested editor descriptors. Subclass should implements this
	 * method in order to return the registry associated to the extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 * 
	 * @generated NOT
	 */
	protected IEditorFactoryRegistry createEditorRegistry() {
		return new EditorFactoryRegistry(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
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
	 * @generated NOT Get the EditorRegistry used to create editor instances. This default
	 *            implementation return the singleton eINSTANCE. This method can be subclassed to
	 *            return another registry.
	 */
	protected IEditorFactoryRegistry getEditorRegistry() {
		if (editorRegistry == null) {
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
	 * getAll diag in relation with this element or subelements.
	 * 
	 * @return the sub diagrams
	 */
	protected ArrayList<Diagram> getSubDiagrams() {
		Element host = (Element) ((GraphicalEditPart) getHost()).getNotationView().getElement();
		ArrayList<Diagram> result = new ArrayList<Diagram>();
		if (host != null) {
			try {
				IPageMngr iPageMngr = (IPageMngr) EditorUtils.getIPageMngr();
				Iterator<Object> iterator = iPageMngr.allPages().iterator();
				while (iterator.hasNext()) {
					Object current = iterator.next();
					if (current instanceof Diagram) {
						Element diagElement = (Element) ((Diagram) current).getElement();
						if (host.equals(diagElement) || host.allOwnedElements().contains(diagElement)) {
							result.add((Diagram) current);
						}
					}
				}
			} catch (Exception e) {
			}

		}
		return result;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected void hideDiagramAssistant() {
		if (getFigureBar() != null) {
			getFigureBar().removeMouseMotionListener(this);
			getFigureBar().removeMouseListener(myMouseKeyListener);
			IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
			if (getFigureBar().getParent() != null) {
				layer.remove(getFigureBar());
			}

			if (imagesToBeDisposed != null) {
				for (Iterator iter = figureBar.getChildren().iterator(); iter.hasNext();) {
					Object current = iter.next();
					if (current instanceof PopupBarLabelHandle) {
						((PopupBarLabelHandle) current).dispose();
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
	protected boolean isDiagramAssistantShowing() {

		return true;
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @return true, if checks if is preference on
	 */
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
		if (getFigureBar() != null) {
			// add all subdiagrams
			List<Diagram> diagramList = getSubDiagrams();
			for (int i = 0; i < diagramList.size(); i++) {

				// Button b = new Button(theDesc.myButtonIcon);
				PopupBarLabelHandle handle = new PopupBarLabelHandle(diagramList.get(i), getEditorRegistry()
						.getEditorIcon(diagramList.get(i)));

				Rectangle r1 = new Rectangle();
				r1.setLocation(xLoc, 5);
				xLoc += 20;
				r1.setSize(16, 16);

				Label l = new Label();
				l.setText(diagramList.get(i).getName());

				handle.setToolTip(l);
				handle.setPreferredSize(16, 16);
				handle.setBounds(r1);
				handle.setBackgroundColor(ColorConstants.white);
				getFigureBar().add(handle);
				handle.addMouseListener(this.myMouseKeyListener);
				handle.addMouseMotionListener(this);

			}
			// add all hyperlinks
			List<String> hyperLinkList = HyperlinkHelper.getAllHyperLink(((GraphicalEditPart) getHost())
					.getNotationView());
			xLoc = addObjectList("/icons/obj16/hyperlink.gif", xLoc, hyperLinkList);
			// add all documents
			List<String> documentList = HyperlinkHelper.getAllreferencedDocument(((GraphicalEditPart) getHost())
					.getNotationView());
			xLoc = addObjectList("/icons/obj16/file.gif", xLoc, documentList);
			// add the PLUS button
			PopupBarLabelHandle handle = new PopupBarLabelPlusHandle();
			Rectangle r1 = new Rectangle();
			r1.setLocation(xLoc, 5);
			xLoc += 20;
			r1.setSize(16, 16);

			Label l = new Label();
			l.setText("Add Diagram");

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
	 *            the reference point
	 */
	protected void showDiagramAssistant(Point referencePoint) {
		if (getFigureBar() == null) {
			createPopupBarFigure();
			int width = populatePopup();
			IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
			layer.add(getFigureBar());
			if (referencePoint == null) {
				referencePoint = getHostFigure().getBounds().getCenter();
			}
			getFigureBar().setSize(width, 30);
			getFigureBar().setLocation(getHostFigure().getBounds().getBottomLeft());
			getFigureBar().setBackgroundColor(ColorConstants.white);
			getFigureBar().setForegroundColor(ColorConstants.orange);

			// dismiss the popup bar after a delay
			if (!shouldAvoidHidingDiagramAssistant()) {
				hideDiagramAssistantAfterDelay(getDisappearanceDelay());
			}
		}
	}
}
