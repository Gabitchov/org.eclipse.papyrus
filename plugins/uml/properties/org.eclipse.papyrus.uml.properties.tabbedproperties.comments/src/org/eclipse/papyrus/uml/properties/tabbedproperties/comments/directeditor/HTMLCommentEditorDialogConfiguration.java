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
package org.eclipse.papyrus.uml.properties.tabbedproperties.comments.directeditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.ILabelEditorDialog;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.properties.tabbedproperties.comments.Messages;
import org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection.CommentRichTextEditor;
import org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection.CommentRichTextFormToolkit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.uml2.uml.Comment;


/**
 *
 */
public class HTMLCommentEditorDialogConfiguration extends DefaultDirectEditorConfiguration implements IAdvancedEditorConfiguration {

	/**
	 * Constructor.
	 */
	public HTMLCommentEditorDialogConfiguration() {
		super();
	}

	/**
	 * @see org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration#getTextToEdit(java.lang.Object)
	 * 
	 * @param objectToEdit
	 * @return
	 */

	@Override
	public String getTextToEdit(Object objectToEdit) {
		if(objectToEdit instanceof Comment) {
			return ((Comment)objectToEdit).getBody();
		}
		return super.getTextToEdit(objectToEdit);
	}

	/**
	 * @see org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration#createDialog(org.eclipse.swt.widgets.Shell,
	 *      org.eclipse.emf.ecore.EObject, java.lang.String)
	 * 
	 * @param shell
	 * @param objectToEdit
	 * @param textToEdit
	 * @return
	 */

	public Dialog createDialog(Shell shell, EObject objectToEdit, String textToEdit) {
		if(objectToEdit instanceof Comment) {
			return new CommentEditorDialog(shell, (Comment)objectToEdit, textToEdit);
		}
		return null;
	}

	public class CommentEditorDialog extends TrayDialog implements ILabelEditorDialog {

		/** text to edit */
		private String textToEdit;

		/** object to edit */
		private Comment commentToEdit;

		/** return value */
		String returnValue = ""; //$NON-NLS-1$

		private CommentRichTextEditor richText;

		/**
		 * Creates a new Comment editor dialog.
		 * 
		 * @param parentShell
		 *        the parent shell of this dialog
		 */
		public CommentEditorDialog(Shell parentShell, Comment commentToEdit, String textToEdit) {
			super(parentShell);
			this.commentToEdit = commentToEdit;
			this.textToEdit = textToEdit;
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected void createButtonsForButtonBar(Composite parent) {
			// create OK and Cancel buttons by default
			// remove the OK button as default button, so Carriage Return key pressed does not close the dialog
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, false);
			createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		}


		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void configureShell(Shell newShell) {
			super.configureShell(newShell);
			newShell.setText(Messages.HTMLCommentEditorDialogConfiguration_CommentDialogTitle);
		}

		/**
		 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
		 * 
		 * @param parent
		 *        the parent composite to contain the dialog area
		 * @return the dialog area control
		 */
		@Override
		protected Control createDialogArea(Composite parent) {
			Composite parentComposite = (Composite)super.createDialogArea(parent);

			richText = CommentRichTextFormToolkit.createRichTextEditor(new FormToolkit(Display.getCurrent()), parent, textToEdit, commentToEdit, SWT.NONE, EditorUtils.getMultiDiagramEditor().getEditorSite());
			return parentComposite;
		}

		/**
		 * @see org.eclipse.papyrus.extensionpoints.editors.ui.ILabelEditorDialog#getValue()
		 * 
		 * @return
		 */
		public String getValue() {
			return returnValue;
		}

		/**
		 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
		 * 
		 */

		@Override
		protected void okPressed() {
			if(richText != null && !richText.isDisposed()) {
				returnValue = richText.getText();
			}
			super.okPressed();
		}

	}

	/**
	 * @see org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration#postEditAction(java.lang.Object,
	 *      java.lang.String)
	 * 
	 * @param objectToEdit
	 * @param newText
	 * @return
	 */

	@Override
	public Object postEditAction(Object objectToEdit, String newText) {
		if(objectToEdit instanceof Comment) {
			((Comment)objectToEdit).setBody(newText);
		}
		return objectToEdit;
	}

}
