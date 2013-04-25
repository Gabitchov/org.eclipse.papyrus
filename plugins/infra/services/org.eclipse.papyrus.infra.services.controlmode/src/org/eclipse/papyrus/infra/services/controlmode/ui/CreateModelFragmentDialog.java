/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.ui;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * Dialog that will ask the user the target URI for th new resource holding the new controlled element
 * 
 * @author adaussy
 * 
 */
public class CreateModelFragmentDialog extends ResourceDialog {

	private URI uri;

	private Resource currentResource;

	private String defaultName;

	/**
	 * The constructor
	 * 
	 * @param parent
	 * @param theDomain
	 * @param theCurrentResource
	 * @param defaultName
	 */
	public CreateModelFragmentDialog(Shell parent, Resource theCurrentResource, String defaultName) {
		super(parent, EMFEditUIPlugin.INSTANCE.getString("_UI_ControlDialog_title"), SWT.SAVE); //$NON-NLS-1$
		this.currentResource = theCurrentResource;
		this.defaultName = defaultName;
	}

	private String computeDefaultURI() {
		String ext = currentResource.getURI().fileExtension();
		URI uri = currentResource.getURI().trimSegments(1);
		uri = uri.appendSegment(defaultName).appendFileExtension(ext);
		return uri.toString();
	}

	@Override
	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);
		this.uriField.setText(computeDefaultURI());
		return result;
	}

	/**
	 * Creates and, if it already exists, loads the specified resource. This implementation verifies
	 * that a resource can be opened for that URI, that the resource is not the object's current
	 * container, and that it is not read-only in the editing domain. If there is an existing
	 * resource with that URI, it prompts before overriding or adding to it.
	 * 
	 * @see org.eclipse.emf.common.ui.dialogs.ResourceDialog#processResources()
	 */
	protected boolean processResources() {
		URI uri = URI.createURI(getURIText());
		this.uri = uri;
		return true;
	}

	/**
	 * Return the created Resource
	 * 
	 * @return the Resource
	 */
	public URI getURI() {
		return uri;
	}
}
