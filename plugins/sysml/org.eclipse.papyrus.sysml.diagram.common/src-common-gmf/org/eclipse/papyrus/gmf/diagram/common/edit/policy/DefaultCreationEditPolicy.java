/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;


public class DefaultCreationEditPolicy extends CreationEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		// Forbid re-parent in this edit policy (to be used by compartment)
		// in order to avoid node to be moved in compartments.
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateViewRequest request) {

		// Ensure that a provider is really able to provide the desired view before 
		// building the command.

		Iterator descriptors = request.getViewDescriptors().iterator();
		while(descriptors.hasNext()) {
			CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor)descriptors.next();

			//
			// Warning : 
			//		do not test ViewService providers passing the a SemanticAdapter (descriptor.getElementAdapter()). The problem is that doing this,
			//		the ViewService look for a ViewProvider with a that provides for CreateViewForKindOperation, but the GMF tooling always implement 
			//		this method as returning true without taking care of the concerned diagram. As a workaround, a SemanticAdapter is used here, that
			//		contain an EObject for drop from model explorer purpose, and use the provided semantic hint (descriptor.getSemanticHint()) if no
			//		EObject is provided (on creation for instance).
			//		
			// Boolean isViewProvided = ViewService.getInstance().provides(Node.class, descriptor.getElementAdapter(), (View)(getHost().getModel()), descriptor.getSemanticHint(), -1, true, new PreferencesHint(""));
			//
			EObject eObject = (EObject)descriptor.getElementAdapter().getAdapter(EObject.class);
			Boolean isViewProvided = ViewService.getInstance().provides(Node.class, new SemanticAdapter(eObject, null), (View)(getHost().getModel()), descriptor.getSemanticHint(), -1, true, new PreferencesHint(""));
			if(!isViewProvided) {
				return UnexecutableCommand.INSTANCE;
			}
		}

		// A provider exists for the view, return the default creation command.
		return super.getCreateCommand(request);

	}

}
