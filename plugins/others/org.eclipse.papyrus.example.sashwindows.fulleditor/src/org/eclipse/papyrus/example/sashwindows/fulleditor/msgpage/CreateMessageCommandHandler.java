/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.example.sashwindows.fulleditor.msgpage;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.papyrus.sasheditor.contentprovider.IComponentModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * Command to create a new TextEditor.
 * The command create a new IEditorModel and add it to the Sashwindow repository model.
 * @author dumoulin
 */
public class CreateMessageCommandHandler extends AbstractHandler implements IHandler {

	/**
	 * Method called when the command is invoked.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Create the Editor Model
		IComponentModel model = new MessagePartModel( "Message !!!" );
		// Get the Sashwindow model
		ISashWindowsContentProvider contentProvider = getSashWindowsContentProvider();
		if(contentProvider==null)
		{
			showErrorDialog("Can't create Editor. Reason: Can't get current editor ContentProvider.");
		}
		// Add it to the current folder
		contentProvider.addPage(model);
		return null;
	}


	/**
	 * Show an ErrorDialog.
	 * @param string
	 */
	private void showErrorDialog(String text) {
		MessageBox dialog = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.ICON_WARNING |SWT.OK | SWT.APPLICATION_MODAL  );
		dialog.setText(text);
		dialog.open();
		return;
	}


	/**
	 * Get the current MultiDiagramEditor.
	 * 
	 * @return
	 */
	protected IEditorPart getMultiDiagramEditor() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editorPart = page.getActiveEditor();
		return editorPart;
	}

	/**
	 * Get the shared object.
	 * 
	 * @return
	 */
	protected ISashWindowsContentProvider getSashWindowsContentProvider() {
		IEditorPart editor = getMultiDiagramEditor();
		
		ISashWindowsContentProvider contentProvider = (ISashWindowsContentProvider)editor.getAdapter(ISashWindowsContentProvider.class);
		return contentProvider; 
	}

}
