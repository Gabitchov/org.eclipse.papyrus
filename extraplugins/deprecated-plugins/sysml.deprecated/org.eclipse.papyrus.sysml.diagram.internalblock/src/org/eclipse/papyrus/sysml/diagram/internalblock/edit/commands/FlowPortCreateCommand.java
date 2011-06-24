/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.resource.Resource;
import org.eclipse.papyrus.resource.util.ResourceUtil;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysmlPaletteFactory;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;

/**
 * @generated
 */
public class FlowPortCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	public FlowPortCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		return true;

	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Resource owner = ResourceUtil.getResource(getElementToEdit());
		FlowPort newElement = PortandflowsFactory.eINSTANCE.createFlowPort();
		owner.getEobjects().add(newElement);
		Port port = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPort();
		newElement.setBase_Port(port);
		// set type
		IEditCommandRequest request = getRequest();
		Object type = request.getParameter(SysmlPaletteFactory.FLOW_PORT_TOOL_TYPE);
		if (type instanceof SysmlPaletteFactory.PORT_TYPE) {
			SysmlPaletteFactory.PORT_TYPE portType = (SysmlPaletteFactory.PORT_TYPE) type;
			switch (portType) {
			case IN:
				newElement.setDirection(FlowDirection.IN);
				break;
			case OUT:
				newElement.setDirection(FlowDirection.OUT);
				break;
			case INOUT:
				newElement.setDirection(FlowDirection.INOUT);
				break;
			}
		}
		if (getElementToEdit() instanceof Class) {
			Class aClass = (Class) getElementToEdit();
			aClass.getOwnedPorts().add(port);
		}
		doConfigure(newElement, monitor, info);

		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(FlowPort newElement, IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

}
