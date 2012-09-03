/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.dev.project.management.handlers.features;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.dev.project.management.dialog.TwoInputDialog;
import org.eclipse.papyrus.dev.project.management.utils.Utils;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IFeatureProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.FeatureProjectEditor;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * set the Copyright and the URL only if it not yet set.
 * 
 */
public class SetCopyrightNoticeHandler extends AbstractHandler {

	final static String OPTIONAL_URL = "url";

	final static String TEXT = "text";

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		Utils.getSelectedOpenProject();
		final TwoInputDialog dialog = new TwoInputDialog(Display.getDefault().getActiveShell(), "Set Copyright Notice", "Licence url", "text", OPTIONAL_URL, TEXT, null);
		if(dialog.open() == Window.OK) {
			final String newVersion = dialog.getValue();
			final List<IProject> featureProjects = Utils.getOpenedFeatureProject();
			for(final IProject current : featureProjects) {
				try {
					setCopyrightNotice(current, dialog.getValue(), dialog.getValue_2());
				} catch (final Throwable e) {
					Activator.log.error(e);
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param featureProject
	 * @param url
	 * @param text
	 * @throws Throwable
	 * 
	 *         TODO : doesn't erase existing value!
	 *         TODO : add a checkbox in the dialog to erase existing value
	 */
	protected void setCopyrightNotice(final IProject featureProject, final String url, final String text) throws Throwable {
		final IFeatureProjectEditor editor = new FeatureProjectEditor(featureProject);
		editor.init();
		final String copyrirghtText = editor.getCopyrightText();
		final String copyrightURL = editor.getCopyrightURL();
		String settedURL = null;
		String settedText = null;
		//TODO improve these tests
		if((copyrightURL == null) || copyrightURL.equals("")) {
			settedURL = url;
		} else {
			settedURL = copyrightURL;
		}

		if((copyrirghtText == null) || copyrirghtText.equals("")) {
			settedText = text;
		}
		if(settedText.equals(copyrirghtText) && settedURL.equals(copyrightURL)) {
			//do nothing
		} else {
			editor.setCopyright(settedURL, settedText);
			editor.save();
		}

	}

}
