/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Devernay (Atos) laurent.devernay@atos.net
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.resourceloading.preferences;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.AbstractGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class LoadedAuthorizedResourceGroup extends AbstractGroup {

	public LoadedAuthorizedResourceGroup(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
		createContent(parent);
	}

	public void createContent(Composite parent) {
		Group group = new Group(parent, SWT.SCROLL_PAGE);
		group.setLayout(new GridLayout());
		group.setText(Messages.LoadedAuthorizedResourceGroup_0);

		ResourcePreferencePathEditor pathEditor = new ResourcePreferencePathEditor(LoadedAuthorizedResourceManager.URI_PREF_PREFIX, Messages.LoadedAuthorizedResourceGroup_1, Messages.LoadedAuthorizedResourceGroup_2, group);

		addFieldEditor(pathEditor);
	}
}
