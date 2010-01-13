//------------------------------------------------------------------------------
// Copyright (c) 2005, 2007 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.eclipse.papyrus.tabbedproperties.comments;

import java.io.UnsupportedEncodingException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.epf.richtext.RichText;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.uml2.uml.Comment;

/**
 * A Method Editor Rich Text control.
 * 
 * @author Kelvin Low
 * @author Jeff Hardy
 * @since 1.0
 */
public class CommentRichText extends RichText {

	// The method element associated with this rich text control.
	private Comment comment;

	// The modal object associated with this rich text control.
	private EObject modalObject;

	// The modal object feature associated with this rich text control.
	private EStructuralFeature modalObjectFeature;

	// The resource being edited
	protected Resource resource;

	// the decoratedField label
	protected Label label;

	protected ControlDecoration controlDecoration;

	protected final Image errorFieldDecorationImage = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage();

	// Field name being edited
	protected String fieldName = ""; //$NON-NLS-1$

	// Field name being edited with the trailing : removed
	protected String fieldNameTrim;

	// marker helper
	// protected MethodRichTextMarkerHelper markerHelper;

	// // marker attribute
	// private static String METHOD_FIELDNAME = "MethodFieldName";

	// // marker ID
	//	protected static final String MARKER_ID = "org.eclipse.epf.authoring.ui.methodRichText"; //$NON-NLS-1$

	/**
	 * Creates a new instance.
	 * 
	 * @param parent
	 *        The parent control.
	 * @param style
	 *        The initial style for the editor.
	 * @param basePath
	 *        The base path used for resolving hrefs.
	 */
	public CommentRichText(Composite parent, int style, String basePath) {
		super(parent, style, basePath);
	}

	/**
	 * Updates the presentation names of all element links.
	 * 
	 * @param text
	 *        Rich text encoded in HTML format.
	 */
	@Override
	protected String tidyText(String text) {
		/*
		 * this will do the following to the HTML: 1. update Element Links 2. change <A ..> to <a
		 * ..> 3. change </A> to </a> 4. add double-quotes (") around all attribute values if they
		 * are missing
		 */

		// return ResourceHelper.validateRichTextContent(comment, text, new
		// RichTextContentValidator());
		return text;
	}

	/**
	 * Adds listeners to manage the activation and focus events.
	 */
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
		if(comment != null) {

			// check save must be done (comment is perhaps not modified)
			if(getText().equals(comment.getBody())) {
				// do not save
				return;
			}

			TransactionalEditingDomain domain = EditorUtils.getTransactionalEditingDomain();
			// open transaction to save the comment body
			// retrieve editing domain
			if(domain != null) {
				RecordingCommand command = new RecordingCommand(domain, "Set Comment Body") {

					@Override
					protected void doExecute() {
						comment.setBody(getText());

					}

				};
				domain.getCommandStack().execute(command);
			} else {
				Activator.log.error("impossible to find the editing domain", null);
			}

		}
	}

	/**
	 * Sets the method element associated with this rich text control.
	 * 
	 * @param comment
	 */
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
	 * Returns the method element associated with this rich text control.
	 */
	public Comment getComment() {
		return comment;
	}

	/**
	 * Returns the modal object associated with this rich text control.
	 */
	public EObject getModalObject() {
		return modalObject;
	}

	/**
	 * Sets the modal object associated with this rich text control.
	 */
	public void setModalObject(EObject modalObject) {
		this.modalObject = modalObject;
	}

	/**
	 * Returns modal object feature associated with this rich text control.
	 */
	public EStructuralFeature getModalObjectFeature() {
		return modalObjectFeature;
	}

	/**
	 * Sets the modal object feature associated with this rich text control.
	 */
	public void setModalObjectFeature(EStructuralFeature modalObjectFeature) {
		this.modalObjectFeature = modalObjectFeature;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setDecoratedFieldLabel(Label label) {
		this.label = label;
		if(label != null) {
			// Object data = label.getData(BaseFormPage.LABEL_DECORATOR_KEY);
			// if (data instanceof ControlDecoration) {
			// controlDecoration = (ControlDecoration) data;
			// controlDecoration.setImage(errorFieldDecorationImage);
			// controlDecoration.hide();
			// }
			updateFieldNameFromLabel(label);
		}
	}

	private boolean updateFieldNameFromLabel(Label label) {
		if(label != null) {
			String fieldName = label.getText();
			if(!this.fieldName.equals(fieldName)) {
				this.fieldName = fieldName;
				int colonIndex = fieldName.indexOf(':');
				if(colonIndex == -1)
					colonIndex = fieldName.length();
				this.fieldNameTrim = fieldName.substring(0, colonIndex).trim();
				return true;
			}
		}
		return false;
	}

	public void init(Comment comment, Label label) {
		setComment(comment);
		setDecoratedFieldLabel(label);
		// markerHelper = MethodRichTextMarkerHelper.INSTANCE;
	}

	@Override
	protected String formatHTML(String text) {
		String formattedText;
		try {
			// clear markers first
			clearMarkers();
			// Call JTidy to format the source to XHTML.
			formattedText = htmlFormatter.formatHTML(text);
			// if (htmlFormatter.getLastErrorStr() != null) {
			// String errorString = htmlFormatter.getLastErrorStr();
			// // create markers
			// try {
			// createMarker(errorString);
			// } catch (CoreException cex) {
			// logger.logError(cex);
			// }
			// }
			return formattedText;
		} catch (UnsupportedEncodingException e) {
			logger.logError(e);
		}
		return text;
	}

	protected void clearMarkers() {
		// markerHelper.deleteMarkers(contentDescription, fieldNameTrim);
		setErrorDescription(""); //$NON-NLS-1$
		hideErrorDecoration();
		refreshDecorators();
	}

	protected void setErrorDescription(String text) {
		if(controlDecoration != null) {
			controlDecoration.setDescriptionText(text);
		}
	}

	protected void refreshDecorators() {
		// refresh
		// PlatformUI.getWorkbench().getDecoratorManager().update(MethodElementLightweightLabelDecorator.DECORATOR_ID);
	}

	@Override
	public void dispose() {
		super.dispose();
		clearMarkers();
		refreshDecorators();
	}

	public void showErrorDecoration() {
		if(controlDecoration != null) {
			controlDecoration.show();
		}
	}

	public void hideErrorDecoration() {
		if(controlDecoration != null) {
			controlDecoration.hide();
		}
	}

	@Override
	public void setText(String text) {
		// check if label text was changed (this happens when RTE is expanded)
		// this is called when RTE is toggled in editor - read new fieldName
		if(updateFieldNameFromLabel(label))
			hideErrorDecoration();
		super.setText(text);
	}
}
