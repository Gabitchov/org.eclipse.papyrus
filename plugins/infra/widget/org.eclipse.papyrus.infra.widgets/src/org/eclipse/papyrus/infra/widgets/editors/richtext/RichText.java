/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors.richtext;

import java.io.StringWriter;

import org.eclipse.epf.common.utils.XMLUtil;
import org.eclipse.epf.common.xml.XSLTProcessor;
import org.eclipse.epf.richtext.actions.CopyAction;
import org.eclipse.epf.richtext.actions.CutAction;
import org.eclipse.epf.richtext.actions.PastePlainTextAction;
import org.eclipse.papyrus.infra.widgets.editors.richtext.actions.PasteAction;
import org.eclipse.papyrus.infra.widgets.editors.richtext.actions.PasteTextOnlyAction;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * The default rich text control implementation.
 * <p>
 * The default rich text editor uses XHTML as the underlying markup language for the rich text content. It is implemented using a SWT
 * <code>Browser</code> control and DHTML (HTML, CSS and JavaScript).
 * 
 * @author Nguyen
 */
public class RichText extends org.eclipse.epf.richtext.RichText {

	/**
	 * Creates a new instance.
	 * 
	 * @param parent
	 *        the parent composite
	 * @param style
	 *        the style for this control
	 * @param basePath
	 *        the path used for resolving links
	 */
	public RichText(Composite parent, int style, String basePath) {
		super(parent, style, basePath);


	}

	/**
	 * Creates a new instance.
	 * 
	 * @param parent
	 *        the parent composite
	 * @param style
	 *        the style for this control
	 */
	public RichText(Composite parent, int style) {
		this(parent, style, null);
	}

	/**
	 * Fills the context menu with menu items.
	 * 
	 * @param contextMenu
	 *        a context menu containing rich text actions
	 */
	protected void fillContextMenu(Menu contextMenu) {
		final MenuItem cutItem = new MenuItem(contextMenu, 8);
		cutItem.setText(RichTextResources.cutAction_text);
		cutItem.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				CutAction action = new CutAction(RichText.this);
				action.execute(RichText.this);
			}
		});
		final MenuItem copyItem = new MenuItem(contextMenu, 8);
		copyItem.setText(RichTextResources.copyAction_text);
		copyItem.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				CopyAction action = new CopyAction(RichText.this);
				action.execute(RichText.this);
			}
		});
		final MenuItem pasteItem = new MenuItem(contextMenu, 8);
		pasteItem.setText(RichTextResources.pasteAction_text);
		pasteItem.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				PasteAction action = new PasteAction(RichText.this);
				action.execute(RichText.this);
			}
		});
		final MenuItem pastePlainTextItem = new MenuItem(contextMenu, 8);
		pastePlainTextItem.setText(RichTextResources.pasteKeepTextOnlyAction_text);
		pastePlainTextItem.setImage(RichTextImages.IMG_PASTE_PLAIN_TEXT);
		pastePlainTextItem.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				PastePlainTextAction action = new PastePlainTextAction(RichText.this);
				action.execute(RichText.this);
			}
		});
		final MenuItem pasteTextOnlyItem = new MenuItem(contextMenu, 8);
		pasteTextOnlyItem.setText(RichTextResources.pasteMergeFormattingAction_toolTipText);
		pasteTextOnlyItem.setImage(RichTextImages.IMG_PASTE_TEXT_ONLY);
		pasteTextOnlyItem.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				PasteTextOnlyAction action = new PasteTextOnlyAction(RichText.this);
				action.execute(RichText.this);
			}
		});
		contextMenu.addMenuListener(new MenuListener() {

			public void menuHidden(MenuEvent e) {
			}

			public void menuShown(MenuEvent e) {
				RichText.this.getSelectedText();
				cutItem.setEnabled((RichText.this.editable) && (RichText.this.hasSelection));
				copyItem.setEnabled(RichText.this.hasSelection);
				pasteItem.setEnabled(RichText.this.editable);
				pastePlainTextItem.setEnabled(RichText.this.editable);
				pasteTextOnlyItem.setEnabled(RichText.this.editable);
			}
		});
	}

	/**
	 * Generates the HTML source for the editor.
	 * 
	 * @return the HTML source for the editor
	 */
	protected String generateEditorHTML() throws Exception {
		this.debug = RichPlugin.getDefault().isDebugging();
		this.logger = RichPlugin.getDefault().getLogger();
		this.rteFolder = (RichPlugin.getDefault().getInstallPath() + "rte/");
		this.rteURL = XMLUtil.escape("file://" + this.rteFolder);
		String escapedBasePath = this.basePath;
		if(escapedBasePath.startsWith("\\\\"))
			escapedBasePath = escapedBasePath.replaceFirst("^\\\\\\\\", "\\\\\\\\\\\\\\\\");
		escapedBasePath = XMLUtil.escape("file://" + escapedBasePath.replaceAll("'", "\\\\'"));
		String escapedRteUTL = this.rteURL.replaceAll("&apos;", "%27");

		StringBuffer rteXML = new StringBuffer();
		rteXML.append("<rte id=\"").append("rte").append("\" css=\"").append(escapedRteUTL + "rte.css").append("\" js=\"").append(escapedRteUTL + "rte.js").append("\" baseURL=\"").append(escapedBasePath).append("\"/>");
		StringWriter result = new StringWriter();
		XSLTProcessor.transform(this.rteFolder + "rte.xsl", rteXML.toString(), result);
		return result.toString();
	}
}
