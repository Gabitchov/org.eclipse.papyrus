/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.toolbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.editparts.ZoomListener;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.util.IUIConstants;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.menu.actions.ZoomAction;
import org.eclipse.papyrus.uml.diagram.menu.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This class provides a Combo box in the toolbar for the Zoom Action
 * This Combo is automatically refresh when the zoom changed
 * 
 * A part of this code comes from {@link ZoomContributionItem}
 */
@SuppressWarnings("restriction")
public class ZoomToolbar extends ContributionItem implements ZoomListener, Listener, org.eclipse.papyrus.infra.core.sasheditor.editor.IPageChangedListener {

	/** the combo box */
	protected Combo combo = null;

	/**
	 * the part service
	 */
	private IPartService partService = null;

	/**
	 * the listener for the part service
	 */

	private IPartListener partListener = null;


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ZoomToolbar() {
		this(""); //$NON-NLS-1$
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param id
	 */
	public ZoomToolbar(String id) {
		super(id);
		init();
	}

	/**
	 * 
	 * @see org.eclipse.jface.action.ContributionItem#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		super.dispose();
		if(this.partService != null) {
			this.partService.removePartListener(this.partListener);
		}
	}

	/**
	 * Adds a listener on the part Service and refresh the value displayed in the Combo
	 * 
	 */
	protected void init() {
		addPartListener();
		refreshCombo();
	}

	/**
	 * adds the part listener
	 */
	protected void addPartListener() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWorkbench = workbench.getActiveWorkbenchWindow();
		if(activeWorkbench != null) {
			partService = activeWorkbench.getPartService();
			if(partService != null) {
				this.partListener = new CustomPartListener();
				partService.addPartListener(this.partListener);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.ToolBar, int)
	 * 
	 * @param parent
	 * @param index
	 */
	@Override
	public void fill(ToolBar parent, int index) {

		ToolItem toolItem = new ToolItem(parent, SWT.SEPARATOR);
		Image zoomImage = Activator.getPluginIconImage("org.eclipse.papyrus.uml.diagram.menu", "/icons/zoomplus.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		/*
		 * TODO : the image is not set, when we use SWT.SEPARATOR.
		 * It's a SWT bug.
		 * This image is used in the Perspective Customization
		 * That works fine with SWT.PUSH, SWT.PULL_DOWN, ..., but in this case it's the zoom which doesn't work
		 */
		toolItem.setImage(zoomImage);
		//this text is used in the perspective customization
		toolItem.setToolTipText(Messages.ZoomToolbar_Zoom);

		combo = new Combo(parent, SWT.DROP_DOWN);
		combo.setItems(getZoomLevelsAsText(getZoomManager()));
		combo.setVisibleItemCount(IUIConstants.DEFAULT_DROP_DOWN_SIZE);
		combo.pack();
		toolItem.setWidth(combo.getSize().x);
		toolItem.setControl(combo);
		combo.addListener(SWT.Selection, this);
		combo.addListener(SWT.KeyDown, this);

		//the combo is created each time that we change table!
		combo.setEnabled(getDiagramEditPart() != null);

		refreshCombo();
		parent.pack();
	}

	/**
	 * 
	 * @see org.eclipse.jface.action.ContributionItem#isDynamic()
	 * 
	 * @return
	 */
	@Override
	public boolean isDynamic() {
		return true;
	}


	/**
	 * Get the zoom levels as text string array from the zoom manager.
	 * 
	 * @return String array with zoom levels.
	 * 
	 * @see org.eclipse.gef.editparts.ZoomManager#getZoomLevelsAsText()
	 */
	public String[] getZoomLevelsAsText(ZoomManager manager) {
		int nNumericZoomLevels = 0;
		if(manager != null) {
			nNumericZoomLevels = manager.getZoomLevels().length;
		}
		String[] allZoomLevels = new String[nNumericZoomLevels + 6];
		allZoomLevels[0] = ZoomAction.ZOOM_IN;
		allZoomLevels[1] = ZoomAction.ZOOM_OUT;
		allZoomLevels[2] = ZoomAction.ZOOM_FIT;
		allZoomLevels[3] = ZoomAction.ZOOM_WIDTH;
		allZoomLevels[4] = ZoomAction.ZOOM_HEIGHT;
		allZoomLevels[5] = ZoomAction.ZOOM_SELECTION;

		if(manager != null) {
			String[] numericZoomLevels = manager.getZoomLevelsAsText();
			for(int i = 0; i < manager.getZoomLevels().length; i++) {
				allZoomLevels[i + 6] = numericZoomLevels[i];
			}
		}
		return allZoomLevels;
	}

	/**
	 * Retrieves the value of the <code>workbenchPart</code> instance
	 * variable.
	 * 
	 * @return The value of the <code>workbenchPart</code> instance variable.
	 */
	protected IDiagramWorkbenchPart getWorkbenchPart() {
		IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();

		if(part instanceof IDiagramWorkbenchPart) {
			return (IDiagramWorkbenchPart)part;
		}
		return null;
	}

	/**
	 * A utility method to return the active part if it implements the <code>IDiagramWorkbenchPart</code> interface
	 * 
	 * @return The current part if it implements <code>IDiagramWorkbenchPart</code>; <code>null</code> otherwise
	 */
	protected IDiagramWorkbenchPart getDiagramWorkbenchPart() {
		return getWorkbenchPart() instanceof IDiagramWorkbenchPart ? (IDiagramWorkbenchPart)getWorkbenchPart() : null;
	}

	/**
	 * A utility method to return the active <code>DiagramEditPart</code> if the current part implements <code>IDiagramWorkbenchPart</code>
	 * 
	 * @return The current diagram if the parts implements <code>IDiagramWorkbenchPart</code>; <code>null</code> otherwise
	 */
	protected DiagramEditPart getDiagramEditPart() {
		IDiagramWorkbenchPart editor = getDiagramWorkbenchPart();
		return editor != null ? editor.getDiagramEditPart() : null;
	}


	/**
	 * Returns the current zoom manager
	 * 
	 * @return
	 *         the current zoom manager
	 */
	protected ZoomManager getZoomManager() {
		if(getDiagramWorkbenchPart() != null) {
			return (ZoomManager)getDiagramWorkbenchPart().getAdapter(ZoomManager.class);
		}
		return null;
	}


	/**
	 * 
	 * @see org.eclipse.gef.editparts.ZoomListener#zoomChanged(double)
	 * 
	 * @param zoom
	 */
	public void zoomChanged(double zoom) {
		refreshCombo();
	}

	/**
	 * refresh the combo status
	 */
	public void refreshCombo() {
		if(combo != null && !combo.isDisposed() && combo.isEnabled()) {
			ZoomManager zoomManager = getZoomManager();
			if(getZoomManager() != null) {
				combo.setItems(getZoomLevelsAsText(zoomManager));
				if(zoomManager != null) {
					String zoomText = zoomManager.getZoomAsText();
					int index = combo.indexOf(zoomText);
					if(index != -1) {
						combo.select(index);
					} else {
						combo.setText(zoomText);
					}
				}
			}
		}
	}

	/**
	 * Sets the zoom level to the zoom string using the zoom manager. First, it
	 * checks for the special cases. If it isn't one of the special cases, it
	 * uses the zoom manager to do the zooming. There are six special cases,
	 * zoom to fit, zoom in, zoom out, zoom to width, zoom to height, and zoom
	 * to selected shapes.
	 * 
	 * @param zoomText
	 *        the zoom string which we will zoom to.
	 * @see org.eclipse.gef.editparts.ZoomManager#setZoomAsText(java.lang.String)
	 */
	public void setZoomAsText(String zoomText) {
		String parameter = null;
		if(zoomText.equals(ZoomAction.ZOOM_IN)) {
			parameter = ZoomAction.ZOOM_IN_PARAMETER;
		} else if(zoomText.equals(ZoomAction.ZOOM_OUT)) {
			parameter = ZoomAction.ZOOM_OUT_PARAMETER;
		} else if(zoomText.equals(ZoomAction.ZOOM_100)) {
			parameter = ZoomAction.ZOOM_100_PARAMETER;
		} else if(zoomText.equals(ZoomAction.ZOOM_FIT)) {
			parameter = ZoomAction.ZOOM_FIT_PARAMETER;
		} else if(zoomText.equals(ZoomAction.ZOOM_WIDTH)) {
			parameter = ZoomAction.ZOOM_WIDTH_PARAMETER;
		} else if(zoomText.equals(ZoomAction.ZOOM_WIDTH)) {
			parameter = ZoomAction.ZOOM_HEIGHT_PARAMETER;
		} else if(zoomText.equals(ZoomAction.ZOOM_SELECTION)) {
			parameter = ZoomAction.ZOOM_SELECTION_PARAMETER;
		} else {
			parameter = zoomText;
			ZoomManager manager = getZoomManager();
			if(manager != null) {
				manager.setZoomAsText(parameter);//to set a specific value to zoom
			}
		}

		ZoomAction action = new ZoomAction(parameter, getSelectedElements());
		if(action.isEnabled()) {
			action.doRun(null);
		} else {
			refreshCombo();
		}
	}




	/**
	 * 
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 * 
	 * @param event
	 */
	public void handleEvent(Event event) {
		if(event.type == SWT.KeyDown && event.character != '\r') {
			return;
		}
		setZoomAsText(combo.getText());

	}

	/**
	 * Iterate over current selection and build a list of the {@link IGraphicalEditPart} contained in
	 * the selection.
	 * 
	 * @return the currently selected {@link IGraphicalEditPart}
	 */
	protected List<IGraphicalEditPart> getSelectedElements() {
		List<IGraphicalEditPart> editparts = new ArrayList<IGraphicalEditPart>();

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow!=null){
			ISelection selection = activeWorkbenchWindow.getSelectionService().getSelection();
			if(selection instanceof IStructuredSelection) {

				IStructuredSelection structuredSelection = (IStructuredSelection)selection;

				Iterator<?> it = structuredSelection.iterator();
				while(it.hasNext()) {
					Object object = it.next();
					if(object instanceof IGraphicalEditPart) {
						editparts.add((IGraphicalEditPart)object);
					}
				}

			} else if(selection instanceof IGraphicalEditPart) {
				editparts.add((IGraphicalEditPart)selection);
			}			
		}
		return editparts;
	}



	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.editor.IPageChangedListener#pageChanged(org.eclipse.papyrus.sasheditor.editor.IPage)
	 * 
	 * @param newPage
	 */
	public void pageChanged(IPage newPage) {
		refreshCombo();

		//we update the listeners
		removeListeners(partService.getActivePart());
		addListeners(partService.getActivePart());
	}

	/**
	 * Removes the listeners on the zoom manager and on the ISashWindowsContainer
	 * 
	 * @param part
	 *        the part owning the listener to remove
	 */
	protected void removeListeners(IWorkbenchPart part) {
		//we remove the zoom listener
		ZoomManager manager = (ZoomManager)part.getAdapter(ZoomManager.class);
		if(manager != null) {
			manager.removeZoomListener(getInstance());
		}

		//we remove the page changed listener
		ISashWindowsContainer windowContainer = (ISashWindowsContainer)part.getAdapter(ISashWindowsContainer.class);
		if(windowContainer != null) {
			windowContainer.removePageChangedListener(getInstance());
		}
		refreshStatusCombo(part);

	}

	/**
	 * Adds the listeners on the zoom manager and on the ISashWindowsContainer
	 * 
	 * @param part
	 *        the part owning the listener to add
	 */
	protected void addListeners(IWorkbenchPart part) {
		//we add listener on the zoom manager
		ZoomManager manager = (ZoomManager)part.getAdapter(ZoomManager.class);
		if(manager != null) {
			manager.addZoomListener(getInstance());
		}

		//we add listener on the window container
		ISashWindowsContainer windowContainer = (ISashWindowsContainer)part.getAdapter(ISashWindowsContainer.class);
		if(windowContainer != null) {
			windowContainer.addPageChangedListener(getInstance());
		}
		refreshStatusCombo(part);
	}



	/**
	 * 
	 * @param part
	 *        refresh the state of the combo
	 */
	protected void refreshStatusCombo(IWorkbenchPart part) {
		ZoomManager zoomManager = (ZoomManager)part.getAdapter(ZoomManager.class);

		if(combo != null && !combo.isDisposed()) {
			if(zoomManager == null) {
				combo.setEnabled(false);
			} else {
				combo.setEnabled(true && getDiagramEditPart() != null);
				refreshCombo();
			}
		}
	}

	/**
	 * Returns the current instance of {@link ZoomToolbar} (this)
	 * 
	 * @return
	 *         the current instance of {@link ZoomToolbar} (this)
	 */
	protected ZoomToolbar getInstance() {
		return this;
	}

	/**
	 * 
	 * This listener is used to listen the part changes
	 * 
	 * 
	 */
	public class CustomPartListener implements IPartListener {

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partActivated(IWorkbenchPart part) {
			if(part instanceof CoreMultiDiagramEditor) {
				removeListeners(part);
				addListeners(part);
			}
			refreshStatusCombo(part);
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partBroughtToTop(IWorkbenchPart part) {
			refreshStatusCombo(part);
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partClosed(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partClosed(IWorkbenchPart part) {
			refreshStatusCombo(part);
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partDeactivated(IWorkbenchPart part) {
			if(part instanceof CoreMultiDiagramEditor) {

			}
			refreshStatusCombo(part);
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partOpened(IWorkbenchPart part) {
			if(part instanceof CoreMultiDiagramEditor) {
				removeListeners(part);
				addListeners(part);
			}
			refreshStatusCombo(part);
		}

	}
}
