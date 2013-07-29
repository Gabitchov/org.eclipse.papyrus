/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.uml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/**
 * Creates a Message between MessageOccurrenceSpecifications. Converts OccurrenceSpecifications to
 * MessageOccurrenceSpecifications if needed
 */
public class CustomBindingConnectorCreateCommand extends EditElementCommand {

	private final EObject source;
	private final EObject target;

	public CustomBindingConnectorCreateCommand(final CreateRelationshipRequest request) {
		super(request.getLabel(), null, request);
		this.source = request.getSource();
		this.target = request.getTarget();
		
	}

	@Override
	public boolean canExecute() {
		if(this.source == null) {
			return false;
		}
		if(this.target == null) {
			return true;
		}
		if(this.source == this.target) {
			return false;
		}
		if (this.source != null && this.target != null) {
			return isConstraintParameter((Element)source, RequestParameterUtils.getSourceView(getRequest())) 
					|| isConstraintParameter((Element)target, RequestParameterUtils.getTargetView(getRequest()));
		}
		return false;
	}

	private boolean isConstraintParameter(Element element, View view) {
		if (element instanceof Property) {
			Property property = (Property) element;
			Element ownerConstraintBlock = property.getOwner();
			if (ownerConstraintBlock instanceof org.eclipse.uml2.uml.Class && UMLUtil.getStereotypeApplication(ownerConstraintBlock, ConstraintBlock.class) != null) {
				// check for graphics : owned by a constraintProperty
				View containerView = ViewUtil.getContainerView(view);
				Element containerElement = (Element)containerView.getElement();
				return containerElement instanceof Property 
						&& UMLUtil.getStereotypeApplication(containerElement, ConstraintProperty.class) != null 
						&& ((Property)containerElement).getType() == ownerConstraintBlock;
			}
		}
		return false;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		// Create the Connector and its ConnectorEnd. Correct container are set and paths are set in case of <<NestedConnectorEnd>>.
		StructuredClassifier deducedContainer = new ConnectorUtils().deduceContainer(RequestParameterUtils.getSourceView(getRequest()), RequestParameterUtils.getTargetView(getRequest()));
		((CreateRelationshipRequest)getRequest()).setContainer(deducedContainer);
		IElementEditService commandProvider = ElementEditServiceUtils.getCommandProvider(deducedContainer);
		ICommand editCommand = commandProvider.getEditCommand(getRequest());
		
		if (editCommand.canExecute()) {
			editCommand.execute(monitor, info);
			Object newObject = editCommand.getCommandResult().getReturnValue();
			
			if (newObject instanceof Connector) {
				Connector connector = (Connector)newObject;
				// Apply the <<BindingConnector>> stereotype
				StereotypeApplicationHelper.INSTANCE.applyStereotype(connector, BlocksPackage.eINSTANCE.getBindingConnector());
			}

			return CommandResult.newOKCommandResult(newObject);
		}
		return CommandResult.newErrorCommandResult("Invalid arguments in create link command");
	}
	
}
