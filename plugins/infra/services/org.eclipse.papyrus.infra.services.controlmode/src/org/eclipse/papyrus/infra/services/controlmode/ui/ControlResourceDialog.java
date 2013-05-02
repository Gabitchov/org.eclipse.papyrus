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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * A save-type {@link ResourceDialog resource dialog} that attempts to create the specified resource
 * and load it, if it already exists.
 * 
 */
public class ControlResourceDialog extends ResourceDialog {

	private EditingDomain domain;

	private Resource controlResource;

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
	public ControlResourceDialog(Shell parent, EditingDomain theDomain, Resource theCurrentResource, String defaultName) {
		super(parent, EMFEditUIPlugin.INSTANCE.getString("_UI_ControlDialog_title"), SWT.SAVE);
		this.domain = theDomain;
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
		ResourceSet resourceSet = domain.getResourceSet();
		Resource resource = resourceSet.getResource(uri, false);
		boolean resourceInSet = resource != null;

		if(resource == currentResource) {
			MessageDialog.openError(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_AlreadyInResource"));
			return false;
		}
		if(domain.isReadOnly(resource)) {
			MessageDialog.openError(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_ReadOnlyResource"));
			return false;
		}

		boolean resourceExists = resourceSet.getURIConverter().exists(uri, null);

		boolean resourceBad = false;
		if(!resourceInSet) {
			resource = resourceSet.createResource(uri);
			if(resource == null) {
				MessageDialog.openError(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_CannotCreateResource"));
				return false;
			}

			if(resourceExists) {
				try {
					resource = resourceSet.getResource(uri, true);
				} catch (RuntimeException exception) {
					EMFEditUIPlugin.INSTANCE.log(exception);
					resourceBad = resource.getContents().isEmpty();
				}
			}
		}

		boolean result = true;
		if(resourceBad) {
			result = MessageDialog.openQuestion(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_ExistingResource_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_ReplaceResource"));
		} else if(resourceExists) {
			result = MessageDialog.openQuestion(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_ExistingResource_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_AddToResource"));
		}

		if(!result && !resourceInSet && resource != null) {
			resource.unload();
			resourceSet.getResources().remove(resource);
		} else {
			this.controlResource = resource;
		}
		return result;
	}

	/**
	 * Return the created Resource
	 * 
	 * @return the Resource
	 */
	public Resource getControlResource() {
		return controlResource;
	}
}
