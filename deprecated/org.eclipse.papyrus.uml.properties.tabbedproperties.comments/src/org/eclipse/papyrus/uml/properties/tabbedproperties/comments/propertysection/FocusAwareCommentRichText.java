/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.properties.tabbedproperties.comments.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


/**
 * Comment rich text that listens for focus lost events to save the content of the comment.
 */
public class FocusAwareCommentRichText extends CommentRichText {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 * @param basePath
	 */
	public FocusAwareCommentRichText(Composite parent, int style, String basePath) {
		super(parent, style, basePath);
	}

	/**
	 * Adds listeners to manage the activation and focus events.
	 */
	@Override
	protected void addListeners() {
		editorControl = getControlSite(editor);

		editorControl.addListener(SWT.FocusOut, new Listener() {

			public void handleEvent(Event event) {
				if(debug) {
					printDebugMessage("focusOutListener"); //$NON-NLS-1$
				}
				focusLostAction(event);
				notifyListeners(SWT.FocusOut, event);
			}

		});

		super.addListeners();
	}

	/**
	 * Action to take when the focus is lost
	 * 
	 * @param event
	 *        the focus lost event
	 */
	protected void focusLostAction(Event event) {
		saveCommentBody();
	}

	/**
	 * Saves the body of the current comment
	 */
	public void saveCommentBody() {
		if(getComment() != null) {

			// check save must be done (comment is perhaps not modified)
			if(getText().equals(getComment().getBody())) {
				// do not save
				return;
			}

			TransactionalEditingDomain domain;
			try {
				domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(getComment());
			} catch (ServiceException ex) {
				Activator.log.error(ex);
				return;
			}

			// open transaction to save the comment body
			// retrieve editing domain
			if(domain != null) {
				RecordingCommand command = new RecordingCommand(domain, "Set Comment Body") {

					@Override
					protected void doExecute() {
						getComment().setBody(getText());

					}

				};
				domain.getCommandStack().execute(command);
			} else {
				Activator.log.error("impossible to find the editing domain", null);
			}

		}
	}

}
