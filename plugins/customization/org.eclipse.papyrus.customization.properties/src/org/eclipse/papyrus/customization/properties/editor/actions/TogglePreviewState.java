/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.editor.actions;

import org.eclipse.core.commands.State;
import org.eclipse.papyrus.customization.properties.editor.preview.Preview;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * A State to determine if the Preview view is opened in the current perspective
 * The State should listen on the workbench an update itself when the perspective
 * changes, or when the preview is opened or closed
 * 
 * @FIXME : the state is not correctly retrieved
 * @author Camille Letavernier
 */
public class TogglePreviewState extends State implements IWindowListener, IPartListener {

	private boolean isPreviewOpen;

	public TogglePreviewState() {
		//		System.out.println("Building ToggleState");
		//
		//		IWorkbench workbench = PlatformUI.getWorkbench();
		//
		//		workbench.addWindowListener(this);
		//		for(IWorkbenchWindow window : workbench.getWorkbenchWindows()) {
		//			System.out.println("Listening on " + window);
		//			window.getPartService().addPartListener(this);
		//		}
		//		refreshState();
	}

	private void refreshState() {
		//		isPreviewOpen = false;
		//		System.out.println("Refresh state");
		//
		//		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		//		if(window != null) {
		//			IWorkbenchPage page = window.getActivePage();
		//
		//			if(page != null) {
		//				for(IViewReference reference : page.getViewReferences()) {
		//					if(reference.getId().equals(Activator.PREVIEW_ID)) {
		//						isPreviewOpen = true;
		//						break;
		//					}
		//				}
		//			}
		//		}
		//
		//		System.out.println("IsOpen : " + isPreviewOpen);
		//
		//		setValue(isPreviewOpen);
	}

	@Override
	public Object getValue() {
		return isPreviewOpen;
	}

	//IWindowListener

	public void windowOpened(IWorkbenchWindow window) {
		//System.out.println("Listening on " + window);
		window.getPartService().addPartListener(this);
		refreshState();
	}

	public void windowClosed(IWorkbenchWindow window) {
		//window.removePageListener(this);
		window.getPartService().removePartListener(this);
	}

	//IPageListener
	//
	//	public void pageOpened(IWorkbenchPage page) {
	//		page.addPartListener(this);
	//	}
	//
	//	public void pageClosed(IWorkbenchPage page) {
	//		page.removePartListener(this);
	//	}

	//IPartListener

	public void partOpened(IWorkbenchPart part) {
		if(part instanceof Preview) {
			//System.out.println("Closing preview");
			refreshState();
		}
	}

	public void partClosed(IWorkbenchPart part) {
		if(part instanceof Preview) {
			//System.out.println("Closing preview");
			refreshState();
		}
	}

	//Ignored methods

	public void partActivated(IWorkbenchPart part) {
		//		System.out.println("Part activated");
		//		refreshState();
	}

	public void partBroughtToTop(IWorkbenchPart part) {
		//Nothing
	}

	public void partDeactivated(IWorkbenchPart part) {
		//		System.out.println("Part activated");
		//		refreshState();
	}

	public void windowActivated(IWorkbenchWindow window) {
		//Nothing
	}

	public void windowDeactivated(IWorkbenchWindow window) {
		//Nothing
	}

	public void pageActivated(IWorkbenchPage page) {
		//Nothing
	}

}
