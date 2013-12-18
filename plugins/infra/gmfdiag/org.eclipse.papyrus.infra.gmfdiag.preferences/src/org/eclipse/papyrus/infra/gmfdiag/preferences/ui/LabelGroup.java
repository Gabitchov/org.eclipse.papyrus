/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.TreeMap;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Activator;
import org.eclipse.papyrus.infra.gmfdiag.preferences.messages.Messages;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor.CLabelBooleanFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * The class LabelGroup to manage the property of the label
 * 
 * 
 * 
 */
public class LabelGroup extends AbstractGroup {

	/**
	 * the map owning the roles and their icons
	 */
	private TreeMap<String, String> myRoles;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        the parent composite
	 * @param preferenceKey
	 *        the preference key
	 * @param dialogPage
	 *        the dialog page
	 * @param roles
	 *        the roles for the labels
	 */
	public LabelGroup(Composite parent, String preferenceKey, DialogPage dialogPage, TreeMap<String, String> roles) {
		super(parent, preferenceKey, dialogPage);
		this.myRoles = roles;
		createContent(parent);
	}

	/**
	 * create the content.
	 * 
	 * @param parent
	 *        : the parent composite
	 */
	protected void createContent(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setText(Messages.LabelGroup_Labels_To_Display);
		for(String role : myRoles.keySet()) {
			String key = PreferencesConstantsHelper.getLabelElementConstant(getKey(), role, PreferencesConstantsHelper.LABEL_VISIBILITY);
			Image im = null;
			String iconPath = myRoles.get(role);
			if(iconPath != null && iconPath != "") { //$NON-NLS-1$
				try {
					im = ImageDescriptor.createFromURL(new URL(iconPath)).createImage();
				} catch (MalformedURLException e) {
					Activator.log.error("I can't find the following image " + myRoles.get(role), e); //$NON-NLS-1$
				}
			}
			CLabelBooleanFieldEditor editor = new CLabelBooleanFieldEditor(key, role, im, group);
			editor.setPage(dialogPage);
			addFieldEditor(editor);
		}
	}
}
