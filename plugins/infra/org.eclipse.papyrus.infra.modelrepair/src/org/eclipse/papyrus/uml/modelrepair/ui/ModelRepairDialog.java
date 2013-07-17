/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelrepair.ui;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class ModelRepairDialog extends TrayDialog {

	private ResourceSet resourceSet;

	public ModelRepairDialog(Shell shell, ResourceSet resourceSet) {
		super(shell);

		this.resourceSet = resourceSet;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);

		Composite self = new Composite(contents, SWT.BORDER);
		self.setLayout(new GridLayout(4, true));

		EcoreUtil.resolveAll(resourceSet);

		Map<Resource, Set<URI>> allLinks = allLinks();

		for(Resource resource : allLinks.keySet()) {
			Label label = new Label(self, SWT.NONE);
			String displayLabel = String.format("%s (%s)", resource.getURI().lastSegment(), allLinks.get(resource).size()); //$NON-NLS-1$

			label.setText(displayLabel);
		}

		return contents;
	}

	protected Map<Resource, Set<URI>> allLinks() {
		Map<Resource, Set<URI>> result = new HashMap<Resource, Set<URI>>();
		for(Resource resource : resourceSet.getResources()) {

			Set<URI> allReferencedURIs = new HashSet<URI>();
			result.put(resource, allReferencedURIs);

			Iterator<EObject> allContents = resource.getAllContents();

			while(allContents.hasNext()) {
				EObject nextElement = allContents.next();
				List<EObject> allReferencedEObjects = nextElement.eCrossReferences();
				for(EObject referencedEObject : allReferencedEObjects) {
					allReferencedURIs.add(referencedEObject.eResource().getURI());
				}
			}
		}

		return result;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public boolean isHelpAvailable() {
		return false;
	}

}
