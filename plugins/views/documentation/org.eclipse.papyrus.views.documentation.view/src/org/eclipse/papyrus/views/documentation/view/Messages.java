package org.eclipse.papyrus.views.documentation.view;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.views.documentation.view.messages"; //$NON-NLS-1$

	public static String AbstractDocPage_commentsTitle;

	public static String AbstractDocPage_resourcesTitle;

	public static String AddElementLinkAction_text;

	public static String CommentsComposite_docCurrent;

	public static String DeleteTableColumnAction_text;

	public static String DeleteTableColumnAction_title;

	public static String DeleteTableRowAction_text;

	public static String DeleteTableRowAction_title;

	public static String EmptyDocPage_noDoc;
	public static String InsertTableColumnAction_text;

	public static String InsertTableColumnAction_title;

	public static String InsertTableRowAction_text;

	public static String InsertTableRowAction_title;

	public static String ResourcesComposite_add;

	public static String ResourcesComposite_deleteResourcesConfirmation;

	public static String ResourcesComposite_edit;

	public static String ResourcesComposite_remove;

	public static String ResourcesComposite_resourcesRemoving;

	public static String RichTextEditorDialog_useRichText;
	public static String SpellingTextComposite_copy;

	public static String SpellingTextComposite_cut;

	public static String SpellingTextComposite_paste;

	public static String SpellingTextComposite_selectAll;

	public static String TextColorAction_title;

	public static String TextHighlightAction_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
