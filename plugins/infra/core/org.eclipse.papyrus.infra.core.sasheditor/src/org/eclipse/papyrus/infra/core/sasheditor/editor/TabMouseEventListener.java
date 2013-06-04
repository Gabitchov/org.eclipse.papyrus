/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.editor;

import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.handlers.IHandlerService;


/**
 * This class is used to listen on double click events from the sash tabs.
 * It then call any command registered with the id {@value #RENAME_COMMAND_ID}
 * <br>
 * This class require the {@link ISashWindowsContainer}, and the editor site (to search
 * for the command handler).
 * 
 * TODO Let it dispose itself by listening on container.dispose event ?
 * 
 * @author cedric dumoulin
 *
 */
public class TabMouseEventListener implements ITabMouseEventsListener {

	private static final String RENAME_COMMAND_ID = "org.eclipse.papyrus.infra.core.sasheditor.command.tabdoubleclick";

	/**
	 * Site of the editor.
	 */
	protected IWorkbenchPartSite site;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param container The {@link ISashWindowsContainer}
	 * @param site The site of the main editor.
	 */
	public TabMouseEventListener(ISashWindowsContainer container, IWorkbenchPartSite site) {

		this.site = site;
		initialize(container);
	}
	
	/**
	 * Register this class as a listener of {@link ISashWindowsContainerChangedListener}
	 * @param container
	 */
	private void initialize(ISashWindowsContainer container) {
		
		// Register itself
		// This will allow this class to be informed of double click events
		container.addFolderTabMouseEventListener(this);
	}

	/**
	 * Dispose this listener. Unregister all pages, and itself.
	 * @param container The container used to register this listener.
	 * 
	 */
	public void dispose(ISashWindowsContainer container) {
		
		if(container!=null) {
			container.removeFolderTabMouseEventListener(this);
		}
		dispose();
	}
	
	/**
	 * Dispose this listener. Unregister all pages. Do not unregister
	 * itself
	 * 
	 */
	public void dispose() {
		site = null;
	}

	
	
	/**
	 * @return the site
	 */
	protected IWorkbenchPartSite getSite() {
		return site;
	}

	/**
	 * Execute the command associated to double click.
	 */
	protected void executeCommand(ITabMouseEvent event) {
		// From a view you get the site which allow to get the service
		IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);

		try {
			handlerService.executeCommand(RENAME_COMMAND_ID, null);
		} catch (Exception ex) {
//			throw new RuntimeException(RENAME_COMMAND_ID + " not found");
			// Silently fail
//			ex.printStackTrace();
		}

	}
	
	/**
	 * Execute the command associated to double click.
	 */
	protected void executeCommandWithContext(ITabMouseEvent event) {
		
//		IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
//
//		ICommandService commandService = (ICommandService) getSite().getService(ICommandService.class);
//		try {
//			IEclipseContext staticContext = EclipseContextFactory.create();
//
//			final Command command = commandService.getCommand(commandId);
//			handlerService.executeCommandInContext(ParameterizedCommand.generateCommand(command, null), (Event)null, staticContext);
//			
//		} catch (Exception ex) {
////			throw new RuntimeException(RENAME_COMMAND_ID + " not found");
//			// Silently fail
//			ex.printStackTrace();
//		}
//
//		
//		
//		EHandlerService hs = eclipseContext.get(EHandlerService.class);
//		IEclipseContext staticContext = EclipseContextFactory.create();
//		if (event != null) {
//			staticContext.set(Event.class, event);
//		}
//		try {
//			final Object rc = hs.executeHandler(command, staticContext);
///			throw new RuntimeException(RENAME_COMMAND_ID + " not found");
//			// Silently fail
//			ex.printStackTrace();
//		}

	}
	
	
	
	/**
	 * Double click event detected. Call the associated command.
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.ITabMouseEventsListener#mouseDoubleClick(org.eclipse.papyrus.infra.core.sasheditor.editor.ITabMouseEvent)
	 *
	 * @param event
	 */
	public void mouseDoubleClick(ITabMouseEvent event) {
		executeCommand(event);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.ITabMouseEventsListener#mouseUp(org.eclipse.papyrus.infra.core.sasheditor.editor.ITabMouseEvent)
	 *
	 * @param event
	 */
	public void mouseUp(ITabMouseEvent event) {
//		System.err.println("mouseUp from " + event.getPage().getPageTitle());
//		System.err.println("mouseUp on " + event.getMouseEvent().button );
		
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.ITabMouseEventsListener#mouseDown(org.eclipse.papyrus.infra.core.sasheditor.editor.ITabMouseEvent)
	 *
	 * @param event
	 */
	public void mouseDown(ITabMouseEvent event) {
//		System.err.println("mouseDown from " + event.getPage().getPageTitle());
//		System.err.println("mouseDown on " + event.getMouseEvent().button );
		
	}

}
