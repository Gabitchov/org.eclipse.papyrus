/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.ui.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormText;

/**
 * The Class HelpDialog.
 */
public class HelpDialog extends CustomPopupDialog {

	/** The description. */
	private String description;

	/** if true, description content is parsed to perform tags */
	private boolean parseTags;

	/**
	 * Instantiates a new help dialog. You must use constructor with parseTags
	 * parameter if you want to define rich text content in your description
	 * 
	 * @param parent
	 *        the parent
	 * @param point
	 *        the point
	 * @param title
	 *        the title
	 * @param description
	 *        the description
	 */
	public HelpDialog(Shell parent, Point point, String title, String description) {
		super(parent, point, title);
		this.description = description;
		this.parseTags = false;
	}

	/**
	 * Instantiates a new help dialog. ParseTags parameter must be used if you
	 * want to define rich text content for the description. For example use
	 * <form> tag to format your text
	 * 
	 * @param parent
	 *        the parent
	 * @param point
	 *        the point
	 * @param title
	 *        the title
	 * @param description
	 *        the description
	 * @param parseTags
	 *        enables tags parsing on the description content
	 */
	public HelpDialog(Shell parent, Point point, String title, String description, boolean parseTags) {
		super(parent, point, title);
		this.description = description;
		this.parseTags = parseTags;
	}

	/**
	 * @see org.topcased.doc2model.requirement.component.CustomPopupDialog#createSubsection()
	 */
	@Override
	public void createSubsection() {
		// Set the description
		FormText text = toolkit.createFormText(formHead.getBody(), false);
		text.addHyperlinkListener(new IHyperlinkListener() {

			public void linkExited(HyperlinkEvent e) {
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkActivated(HyperlinkEvent e) {
				try {
					IWebBrowser externalBrowser = PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser();
					externalBrowser.openURL(new URL((String)e.getHref()));
				} catch (PartInitException e1) {
					errorBrowser();
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					errorBrowser();
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					errorBrowser();
					e1.printStackTrace();
				}
			}

			private void errorBrowser() {
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", "The browser can't be opened");
			}
		});
		text.setText(description, parseTags, true);
	}

	/**
	 * @see org.topcased.doc2model.requirement.component.CustomPopupDialog#getActions()
	 */
	@Override
	protected Collection<Action> getActions() {
		return new LinkedList<Action>();
	}

}
