//------------------------------------------------------------------------------
// Copyright (c) 2009 Anyware Technologies and others
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
//      Anyware Technologies - initial API and implementation
//------------------------------------------------------------------------------
package org.eclipse.papyrus.views.documentation.view.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.RichTextCommand;
import org.eclipse.epf.richtext.RichTextImages;
import org.eclipse.epf.richtext.actions.RichTextAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.views.documentation.view.DocViewPlugin;
import org.eclipse.papyrus.views.documentation.view.DocumentionPartHandlerRegistry;
import org.eclipse.papyrus.views.documentation.view.IDocumentationPartHandler;
import org.eclipse.papyrus.views.documentation.view.Messages;
import org.eclipse.ui.IEditorPart;

/**
 * Adds a link to a topcased model element.
 * 
 * @author Jose Alfredo Serrano
 */
public class AddElementLinkAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public AddElementLinkAction(IRichText richText) {
		super(richText, IAction.AS_PUSH_BUTTON);
		setImageDescriptor(DocViewPlugin.getDefault().getImageRegistry().getDescriptor("MODEL_LINK")); //$NON-NLS-1$
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_ADD_LINK);
		setToolTipText(Messages.AddElementLinkAction_text);
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *            a rich text control
	 */
	public void execute(IRichText richText)
	{
		if (richText != null)
		{
			String linkURL = createURL();
			if (linkURL != null && linkURL.length() > 0) {
				richText.executeCommand(RichTextCommand.ADD_LINK, linkURL);
			}
		}
	}
	
	public boolean disableInSourceMode() {
		return false;
	}

	private String createURL()
	{
		EObject selection = null;
		IEditorPart activeEditor = DocViewPlugin.getActiveEditor();
		IDocumentationPartHandler documentationPartHandler = DocumentionPartHandlerRegistry.getInstance().getDocumentationPartHandler(activeEditor);
		if (documentationPartHandler != null) {
			selection = documentationPartHandler.openElementSelectionDialog(activeEditor);
		}
		
		if (selection != null)
		{
			// XXX : HACK Extreme hacking on... 
			// there should be a proper way to handle with spaces and URIs.
			String uri = EcoreUtil.getURI(selection).toString();
			return "http://" + uri.replace(" ", "%20"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		
		return null;
	}
}