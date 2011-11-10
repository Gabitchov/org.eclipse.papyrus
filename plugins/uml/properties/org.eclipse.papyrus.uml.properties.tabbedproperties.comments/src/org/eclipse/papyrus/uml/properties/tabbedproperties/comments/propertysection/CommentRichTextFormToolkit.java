/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection;

//------------------------------------------------------------------------------
//Copyright (c) 2005, 2006 IBM Corporation and others.
//All rights reserved. This program and the accompanying materials
//are made available under the terms of the Eclipse Public License v1.0
//which accompanies this distribution, and is available at
//http://www.eclipse.org/legal/epl-v10.html
//
//Contributors:
//IBM Corporation - initial implementation
//------------------------------------------------------------------------------

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.uml2.uml.Comment;

/**
 * A helper toolkit for creating a rich text control and editor that can be added to an Eclipse
 * form.
 * 
 * @author Kelvin Low
 * @since 1.0
 */
public class CommentRichTextFormToolkit {

	//	/**
	//	 * Creates a rich text control and adapts it to be used in a form.
	//	 * 
	//	 * @param toolkit
	//	 *            the form toolkit
	//	 * @param parent
	//	 *            the parent control
	//	 * @param text
	//	 *            the initial text for the viewer
	//	 * @param style
	//	 *            the initial style for the viewer
	//	 * @param basePath
	//	 *            the base path used for resolving hrefs
	//	 * @return a new <code>IRichText</code> instance
	//	 */
	//	public static CommentRichText createRichText(FormToolkit toolkit, Composite parent, String text, int style) {
	//		CommentRichText richText = new CommentRichText(parent, toolkit.getBorderStyle() | style
	//				| toolkit.getOrientation(), null);
	//		richText.getControl().setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	//		if (text != null) {
	//			richText.setText(text);
	//		}
	//		return richText;
	//	}

	/**
	 * Creates a rich text editor and adapts it to be used in a form.
	 * 
	 * @param toolkit
	 *        the form toolkit
	 * @param parent
	 *        the parent control
	 * @param text
	 *        the initial text for the viewer
	 * @param style
	 *        the initial style for the viewer
	 * @param basePath
	 *        the base path used for resolving hrefs
	 * @return a new <code>IRichText</code> instance
	 */
	public static CommentRichTextEditor createRichTextEditor(FormToolkit toolkit, Composite parent, String text, Comment comment, int style, IEditorSite editorSite) {
		CommentRichTextEditor richTextEditor = new CommentRichTextEditor(parent, toolkit.getBorderStyle() | style | toolkit.getOrientation(), null, comment, null, editorSite);
		// richTextEditor.getControl().setData(FormToolkit.KEY_DRAW_BORDER,
		// FormToolkit.TREE_BORDER);
		if(text != null) {
			richTextEditor.setInitialText(text);
		}
		return richTextEditor;
	}

	/**
	 * Creates a rich text editor and adapts it to be used in a form.
	 * 
	 * @param toolkit
	 *        the form toolkit
	 * @param parent
	 *        the parent control
	 * @param text
	 *        the initial text for the viewer
	 * @param style
	 *        the initial style for the viewer
	 * @param basePath
	 *        the base path used for resolving hrefs
	 * @return a new <code>IRichText</code> instance
	 */
	public static CommentRichTextEditor createFocusAwareRichTextEditor(FormToolkit toolkit, Composite parent, String text, Comment comment, int style, IEditorSite editorSite) {
		CommentRichTextEditor richTextEditor = new FocusAwareCommentRichTextEditor(parent, toolkit.getBorderStyle() | style | toolkit.getOrientation(), null, comment, null, editorSite);
		// richTextEditor.getControl().setData(FormToolkit.KEY_DRAW_BORDER,
		// FormToolkit.TREE_BORDER);
		if(text != null) {
			richTextEditor.setInitialText(text);
		}
		return richTextEditor;
	}
}
