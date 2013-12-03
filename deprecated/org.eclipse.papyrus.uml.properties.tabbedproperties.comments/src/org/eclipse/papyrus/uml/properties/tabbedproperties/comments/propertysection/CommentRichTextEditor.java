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
package org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.IRichTextToolBar;
import org.eclipse.epf.richtext.RichTextEditor;
import org.eclipse.epf.richtext.actions.AddOrderedListAction;
import org.eclipse.epf.richtext.actions.AddTableAction;
import org.eclipse.epf.richtext.actions.AddUnorderedListAction;
import org.eclipse.epf.richtext.actions.BoldAction;
import org.eclipse.epf.richtext.actions.ClearContentAction;
import org.eclipse.epf.richtext.actions.CopyAction;
import org.eclipse.epf.richtext.actions.CutAction;
import org.eclipse.epf.richtext.actions.FindReplaceAction;
import org.eclipse.epf.richtext.actions.FontNameAction;
import org.eclipse.epf.richtext.actions.FontSizeAction;
import org.eclipse.epf.richtext.actions.FontStyleAction;
import org.eclipse.epf.richtext.actions.IndentAction;
import org.eclipse.epf.richtext.actions.ItalicAction;
import org.eclipse.epf.richtext.actions.OutdentAction;
import org.eclipse.epf.richtext.actions.PasteAction;
import org.eclipse.epf.richtext.actions.SubscriptAction;
import org.eclipse.epf.richtext.actions.SuperscriptAction;
import org.eclipse.epf.richtext.actions.TidyActionGroup;
import org.eclipse.epf.richtext.actions.UnderlineAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.uml2.uml.Comment;

/**
 * A Rich Text editor with added extensions to support Method browsing and authoring. Includes a
 * tool bar and an integrated HTML source editor.
 * 
 * @author Kelvin Low
 * @author Jeff Hardy
 * @since 1.0
 */
public class CommentRichTextEditor extends RichTextEditor {

	// The method element associated with this rich text control.
	private Comment comment;

	// The modal object associated with this rich text control.
	private EObject modalObject;

	// The modal object feature associated with this rich text control.
	private EStructuralFeature modalObjectFeature;

	protected FormToolkit toolkit;

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
	public CommentRichTextEditor(Composite parent, int style, String basePath, Comment comment, Label label, IEditorSite editorSite) {
		super(parent, style, editorSite, basePath);
		this.comment = comment;
		init(comment, label);
	}

	/**
	 * Creates the underlying rich text control.
	 * 
	 * @param parent
	 *        The parent composite.
	 * @param style
	 *        The style for this control.
	 * @param basePath
	 *        The path used for resolving links.
	 */
	protected IRichText createRichTextControl(Composite parent, int style, String basePath) {
		CommentRichText commentRichText = new CommentRichText(parent, style, basePath);
		org.eclipse.swt.layout.GridData gridData = new org.eclipse.swt.layout.GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = 200;
		commentRichText.setLayoutData(gridData);
		return commentRichText;
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected void createUndoRedoActions() {
		// removes these actions, as they are already provided by the editor site 
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected void createActions() {
		// removes these actions, as they are already provided by the editor site 
	}



	/**
	 * Fills the Rich Text editor tool bar with action items.
	 * 
	 * @param toolBar
	 *        The Rich text editor tool bar.
	 */
	public void fillToolBar(IRichTextToolBar toolBar) {
		toolBar.addAction(new FontStyleAction(this));
		toolBar.addAction(new FontNameAction(this));
		toolBar.addAction(new FontSizeAction(this));
		toolBar.addSeparator();
		toolBar.addAction(new CutAction(this));
		toolBar.addAction(new CopyAction(this));
		toolBar.addAction(new PasteAction(this));
		toolBar.addSeparator();
		toolBar.addAction(new ClearContentAction(this));
		toolBar.addSeparator();
		toolBar.addAction(new BoldAction(this));
		toolBar.addAction(new ItalicAction(this));
		toolBar.addAction(new UnderlineAction(this));
		toolBar.addSeparator();
		toolBar.addAction(new SubscriptAction(this));
		toolBar.addAction(new SuperscriptAction(this));
		toolBar.addSeparator();
		toolBar.addAction(new TidyActionGroup(this));
		toolBar.addSeparator();
		toolBar.addAction(new AddOrderedListAction(this));
		toolBar.addAction(new AddUnorderedListAction(this));
		toolBar.addSeparator();
		toolBar.addAction(new OutdentAction(this));
		toolBar.addAction(new IndentAction(this));
		toolBar.addSeparator();
		toolBar.addAction(new FindReplaceAction(this) {

			@Override
			public void execute(IRichText richText) {
				richText.getFindReplaceAction().execute(richText);
			}
		});
		toolBar.addSeparator();
		// toolBar.addAction(new MethodAddLinkAction(this));
		// toolBar.addAction(new MethodAddImageAction(this));
		toolBar.addAction(new AddTableAction(this));
	}

	/**
	 * Returns the comment associated with this rich text control.
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

	public void init(Comment comment, Label label) {
		if(richText instanceof CommentRichText)
			((CommentRichText)richText).init(comment, label);
	}

	/**
	 * Returns the rich text control embedded within this editor.
	 */
	public FocusAwareCommentRichText getRichTextControl() {
		return (FocusAwareCommentRichText)richText;
	}

}
