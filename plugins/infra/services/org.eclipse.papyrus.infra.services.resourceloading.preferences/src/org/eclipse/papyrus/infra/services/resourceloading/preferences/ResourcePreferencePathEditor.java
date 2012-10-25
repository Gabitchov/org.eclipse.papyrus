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

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.PathEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class ResourcePreferencePathEditor extends PathEditor {

	public ResourcePreferencePathEditor() {
		super();
	}

	public ResourcePreferencePathEditor(String name, String labelText, String dirChooserLabelText, Composite parent) {
		super(name, labelText, dirChooserLabelText, parent);
	}

	@Override
	protected String getNewInputObject() {
		String labelText = getLabelText();
		ResourceDialog dialog = new ResourceDialog(getShell(), labelText, SWT.OPEN | SWT.SINGLE);
		dialog.open();
		String uriTexte = dialog.getURIText();
		URI uri = URI.createURI(uriTexte);
		return uri.trimFileExtension().toString();
	}

	@Override
	protected void doLoad() {
		if(getList() != null) {
			getList().removeAll();
		}
		super.doLoad();
	}

	@Override
	protected void doLoadDefault() {
		if(getList() != null) {
			getList().removeAll();
		}
		super.doLoadDefault();
	}



}
