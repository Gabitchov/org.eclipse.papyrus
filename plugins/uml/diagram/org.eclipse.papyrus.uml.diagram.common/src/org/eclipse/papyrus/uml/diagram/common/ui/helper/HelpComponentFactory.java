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

import java.io.IOException;

import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * A factory for creating HelpComponent object.
 */
public class HelpComponentFactory {

	/** The image. */
	public static Image image = null;

	// Load only one time the help icon
	static {
		try {
			image = new Image(Display.getDefault(), Activator.getDefault().getBundle().getResource("icons/help/help_contents-1.gif").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates help component that insert a new hyperlink icon to display
	 * additional help description if tooltip is null, default value is "Help"
	 * 
	 * ParseTags parameter must be used if you want to define rich text content
	 * for the helpText. For example use <form> tag to format your text
	 * 
	 * @param parent
	 *        the parent
	 * @param toolkit
	 *        the toolkit
	 * @param helpText
	 *        the help text
	 * @param pToolTip
	 *        the tool tip
	 * @param parseTags
	 *        enables tags parsing on the description content
	 * @return the hyperlink image
	 */
	public static ImageHyperlink createHelpComponent(final Composite parent, FormToolkit toolkit, final String helpText, String pToolTip, final boolean parseTags) {
		ImageHyperlink helpImage = toolkit.createImageHyperlink(parent, SWT.NONE);
		helpImage.setImage(image);
		helpImage.setBackground(null);
		final String toolTip = (pToolTip == null) ? "Help" : pToolTip;
		helpImage.setToolTipText(toolTip);
		helpImage.addHyperlinkListener(new IHyperlinkListener() {

			// create the HelpDialog that displays the help description
			public void linkActivated(HyperlinkEvent e) {
				HelpDialog dialog = new HelpDialog(parent.getShell(), Display.getDefault().getCursorLocation(), toolTip, helpText, parseTags);
				dialog.open();
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}

		});
		return helpImage;
	}

	/**
	 * Creates a new HelpComponent object. ParseTags parameter must be used if
	 * you want to define rich text content for the helpText. For example use
	 * <form> tag to format your text
	 * 
	 * @param parent
	 *        the parent
	 * @param toolkit
	 *        the toolkit
	 * @param helpText
	 *        the help text
	 * @param parseTags
	 *        enables tags parsing on the description content
	 * @return the image hyperlink
	 */
	public static ImageHyperlink createHelpComponent(final Composite parent, FormToolkit toolkit, final String helpText, boolean parseTags) {
		return createHelpComponent(parent, toolkit, helpText, null, parseTags);
	}

	/**
	 * Creates a new HelpComponent object. You must use method with parseTags
	 * parameter if you want to define rich text content for the helpText
	 * 
	 * @param parent
	 *        the parent
	 * @param toolkit
	 *        the toolkit
	 * @param helpText
	 *        the help text
	 * @return the image hyperlink
	 */
	public static ImageHyperlink createHelpComponent(final Composite parent, FormToolkit toolkit, final String helpText) {
		return createHelpComponent(parent, toolkit, helpText, null, false);
	}

}
