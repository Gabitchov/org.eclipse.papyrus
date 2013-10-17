/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.diagram.common.utils.ConstraintBlockHelper;
import org.eclipse.papyrus.uml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/**
 * 
 */
public class CustomBindingConnectorCreateCommand extends EditElementCommand {

	private final EObject source;
	private final EObject target;

	public CustomBindingConnectorCreateCommand(final CreateRelationshipRequest request) {
		super(request.getLabel(), null, request);
		this.source = request.getSource();
		this.target = request.getTarget();
	}

	/**
	 * A BindingConnector could be created in Parametric only if at least one end is a ConstraintParameter.
	 * Also check Block.isEncapsulated (could not cross a Block which is encapsulted)
	 * @return 
	 */
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
			
			boolean hasEncapsulationViolation = !checkEncapsulationCrossing();		
			
			return hasEncapsulationViolation ? false :
					// one of the end must be a ConstraintParameter	
					ConstraintBlockHelper.isConstraintParameter((Element)source, RequestParameterUtils.getSourceView(getRequest()))
					|| ConstraintBlockHelper.isConstraintParameter((Element)target, RequestParameterUtils.getTargetView(getRequest()));
		}
		return false;
	}

	/**
	 * Check that BindingConnector do not cross a "Block.isEncapsulated" Part/Reference/ConstraintProperty
	 * @return true no encapsulation problem, false else
	 */
	private boolean checkEncapsulationCrossing() {
		org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils util = new org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils();

		// source end - get the nestedPath	
		List<Property> nestedPropertyPath = util.getNestedPropertyPath(RequestParameterUtils.getSourceView(getRequest()), RequestParameterUtils.getTargetView(getRequest()));
		// check for each level of path if crossing an isEncapsultaed Block 
		for (Property property : nestedPropertyPath) {
			Type type = property.getType();
			Block stereotypeApplication = UMLUtil.getStereotypeApplication(type, Block.class);
			if (stereotypeApplication != null) {
				if (stereotypeApplication.isEncapsulated()) {
					return false;
				}
			}
		}
		
		// target end - get the nestedPath
		nestedPropertyPath = util.getNestedPropertyPath(RequestParameterUtils.getTargetView(getRequest()), RequestParameterUtils.getSourceView(getRequest()));
		// check for each level of path if crossing an isEncapsultaed Block
		for (Property property : nestedPropertyPath) {
			Type type = property.getType();
			Block stereotypeApplication = UMLUtil.getStereotypeApplication(type, Block.class);
			if (stereotypeApplication != null) {
				if (stereotypeApplication.isEncapsulated()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Create the connector, affect its owner, calculate nestedPath
	 * @param monitor
	 * @param info
	 * @return CommandResult contains the created Connector
	 */
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
