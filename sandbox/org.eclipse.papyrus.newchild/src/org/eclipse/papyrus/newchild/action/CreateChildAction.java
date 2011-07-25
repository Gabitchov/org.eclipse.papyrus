/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.newchild.action;

import java.net.URL;
import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CommandActionDelegate;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction;
import org.eclipse.jface.resource.ImageDescriptor;


public class CreateChildAction extends StaticSelectionCommandAction {

	private EObject parent;

	private EReference createIn;

	private EClass createAs;

	private EditingDomain domain;

	public CreateChildAction(EditingDomain domain, EObject parent, EReference createIn, EClass createAs) {
		super(domain);
		this.domain = domain;
		this.parent = parent;
		this.createIn = createIn;
		this.createAs = createAs;
	}

	@Override
	protected Command createActionCommand(EditingDomain editingDomain, Collection<?> collection) {
		EObject createdEObject = createAs.getEPackage().getEFactoryInstance().create(createAs);

		CommandParameter creationParameter = new CommandParameter(parent, createIn, createdEObject);

		Command createInFeature = CreateChildCommand.create(domain, parent, creationParameter, collection);

		super.setText(createInFeature.getLabel());
		super.setDescription(createInFeature.getDescription());
		if(createInFeature instanceof CommandActionDelegate) {

			Object image = ((CommandActionDelegate)createInFeature).getImage();
			if(image instanceof URL) {
				ImageDescriptor descriptor = ImageDescriptor.createFromURL((URL)image);
				super.setImageDescriptor(descriptor);
			}
		}

		return createInFeature;
	}
}
