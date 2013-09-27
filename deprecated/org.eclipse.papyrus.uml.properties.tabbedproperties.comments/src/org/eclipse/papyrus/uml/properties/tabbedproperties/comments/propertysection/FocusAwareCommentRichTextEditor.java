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

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorSite;
import org.eclipse.uml2.uml.Comment;


/**
 *
 */
public class FocusAwareCommentRichTextEditor extends CommentRichTextEditor {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 * @param basePath
	 * @param comment
	 * @param label
	 * @param editorSite
	 */
	public FocusAwareCommentRichTextEditor(Composite parent, int style, String basePath, Comment comment, Label label, IEditorSite editorSite) {
		super(parent, style, basePath, comment, label, editorSite);
	}

	/**
	 * @see org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection.CommentRichTextEditor#createRichTextControl(org.eclipse.swt.widgets.Composite,
	 *      int, java.lang.String)
	 * 
	 * @param parent
	 * @param style
	 * @param basePath
	 * @return
	 */

	@Override
	protected IRichText createRichTextControl(Composite parent, int style, String basePath) {
		FocusAwareCommentRichText commentRichText = new FocusAwareCommentRichText(parent, style, basePath);
		org.eclipse.swt.layout.GridData gridData = new org.eclipse.swt.layout.GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = 200;
		commentRichText.setLayoutData(gridData);
		return commentRichText;
	}

}
