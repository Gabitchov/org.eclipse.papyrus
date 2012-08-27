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
package org.eclipse.papyrus.sysml.diagram.internalblock.utils;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ViewDescriptorUtil;
import org.eclipse.papyrus.infra.services.edit.commands.ConfigureFeatureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This class provides convenience methods to create Type specific drop action (Set new Type, Port creation, ...).
 */
public class TypeDropHelper extends ElementHelper {

	public TypeDropHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	public Command getDropAsTypedElementType(DropObjectsRequest request, GraphicalEditPart host) {
		CompoundCommand cc = new CompoundCommand("Set a new Type");
		ICommand setCommand = null;

		// The dropped object must be a Type and the target a TypedElement
		Type newType = (request.getObjects().get(0) instanceof Type) ? (Type)request.getObjects().get(0) : null;
		TypedElement typedElementDropTarget = (getHostEObject(host) instanceof TypedElement) ? (TypedElement)getHostEObject(host) : null;

		if((newType == null) || (typedElementDropTarget == null)) {
			return UnexecutableCommand.INSTANCE;
		}

		if(newType == typedElementDropTarget.getType()) {
			setCommand = IdentityCommand.INSTANCE;
		}

		// Prepare a command to set the new type
		SetRequest req = new SetRequest(typedElementDropTarget, UMLPackage.eINSTANCE.getTypedElement_Type(), newType);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(UMLElementTypes.TYPED_ELEMENT);
		if(provider != null) {
			setCommand = provider.getEditCommand(req);
		}

		cc.add(new ICommandProxy(setCommand));

		return cc;
	}

	public Command getDropAsTypedPort(DropObjectsRequest request, GraphicalEditPart host) {
		CompoundCommand cc = new CompoundCommand("Create a new Port");

		Object droppedEObject = request.getObjects().get(0);
		if(!isValidPortType(droppedEObject)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Prepare a command for the FlowPort creation and the drop in diagram

		// 1. Prepare creation command
		ICommand createElementCommand = null;
		CreateElementRequest createElementRequest = new CreateElementRequest(getEditingDomain(), getHostEObject(host), UMLElementTypes.PORT);
		createElementRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), request.getObjects().get(0)));
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getHostEObject(host));
		if(provider != null) {
			createElementCommand = provider.getEditCommand(createElementRequest);
		}
		IAdaptable createElementRequestAdapter = new CreateElementRequestAdapter(createElementRequest);

		// 2. Prepare the drop command
		ViewDescriptor descriptor = new ViewDescriptor(createElementRequestAdapter, Node.class, /* explicit semantic hint is mandatory */ null, ViewDescriptorUtil.PERSISTED, host.getDiagramPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
		createViewRequest.setLocation(request.getLocation().getCopy());
		Command viewCreateCommand = host.getCommand(createViewRequest);

		// 3. Create the compound command
		cc.add(new ICommandProxy(createElementCommand));
		cc.add(viewCreateCommand);

		return cc;
	}

	public Command getDropAsTypedPortOnPart(DropObjectsRequest request, GraphicalEditPart host) {
		CompoundCommand cc = new CompoundCommand("Create a new Port");

		Object droppedEObject = request.getObjects().get(0);
		if(!isValidPortType(droppedEObject)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Verify target nature
		EObject target = getHostEObject(host);
		if((!(target instanceof TypedElement)) || (((TypedElement)target).getType() == null)) {
			return UnexecutableCommand.INSTANCE;
		}

		// The target type has to be a Block (will hold the created Port)
		Type targetType = ((TypedElement)target).getType();
		if(!((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(targetType)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Prepare a command for the FlowPort creation and the drop in diagram

		// 1. Prepare creation command
		ICommand createElementCommand = null;
		CreateElementRequest createElementRequest = new CreateElementRequest(getEditingDomain(), targetType, UMLElementTypes.PORT);
		createElementRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), request.getObjects().get(0)));
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetType);
		if(provider != null) {
			createElementCommand = provider.getEditCommand(createElementRequest);
		}
		IAdaptable createElementRequestAdapter = new CreateElementRequestAdapter(createElementRequest);

		// 2. Prepare the drop command
		ViewDescriptor descriptor = new ViewDescriptor(createElementRequestAdapter, Node.class, /* explicit semantic hint is mandatory */ null, ViewDescriptorUtil.PERSISTED, host.getDiagramPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
		createViewRequest.setLocation(request.getLocation().getCopy());
		Command viewCreateCommand = host.getCommand(createViewRequest);

		// 3. Create the compound command
		cc.add(new ICommandProxy(createElementCommand));
		cc.add(viewCreateCommand);

		return cc;
	}

	public Command getDropAsTypedFlowPort(DropObjectsRequest request, GraphicalEditPart host, IElementType elementType) {
		CompoundCommand cc = new CompoundCommand("Create a new FlowPort (" + elementType.getDisplayName() + ")");

		Object droppedEObject = request.getObjects().get(0);
		if(!isValidFlowPortType(droppedEObject, elementType)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Prepare a command for the FlowPort creation and the drop in diagram

		// 1. Prepare creation command
		ICommand createElementCommand = null;
		CreateElementRequest createElementRequest = new CreateElementRequest(getEditingDomain(), getHostEObject(host), elementType);
		createElementRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), request.getObjects().get(0)));
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getHostEObject(host));
		if(provider != null) {
			createElementCommand = provider.getEditCommand(createElementRequest);
		}
		IAdaptable createElementRequestAdapter = new CreateElementRequestAdapter(createElementRequest);

		// 2. Prepare the drop command
		ViewDescriptor descriptor = new ViewDescriptor(createElementRequestAdapter, Node.class, /* explicit semantic hint is mandatory */ null, ViewDescriptorUtil.PERSISTED, host.getDiagramPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
		createViewRequest.setLocation(request.getLocation().getCopy());
		Command viewCreateCommand = host.getCommand(createViewRequest);

		// 3. Create the compound command
		cc.add(new ICommandProxy(createElementCommand));
		cc.add(viewCreateCommand);

		return cc;
	}

	public Command getDropAsTypedFlowPortOnPart(DropObjectsRequest request, GraphicalEditPart host, IElementType elementType) {
		CompoundCommand cc = new CompoundCommand("Create a new FlowPort (" + elementType.getDisplayName() + ")");

		Object droppedEObject = request.getObjects().get(0);
		if(!isValidFlowPortType(droppedEObject, elementType)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Verify target nature
		EObject target = getHostEObject(host);
		if((!(target instanceof TypedElement)) || (((TypedElement)target).getType() == null)) {
			return UnexecutableCommand.INSTANCE;
		}

		// The target type has to be a Block (will hold the created Port)
		Type targetType = ((TypedElement)target).getType();
		if(!((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(targetType)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Prepare a command for the FlowPort creation and the drop in diagram

		// 1. Prepare creation command
		ICommand createElementCommand = null;
		CreateElementRequest createElementRequest = new CreateElementRequest(getEditingDomain(), targetType, elementType);
		createElementRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), request.getObjects().get(0)));
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetType);
		if(provider != null) {
			createElementCommand = provider.getEditCommand(createElementRequest);
		}
		IAdaptable createElementRequestAdapter = new CreateElementRequestAdapter(createElementRequest);

		// 2. Prepare the drop command
		ViewDescriptor descriptor = new ViewDescriptor(createElementRequestAdapter, Node.class, /* explicit semantic hint is mandatory */ null, ViewDescriptorUtil.PERSISTED, host.getDiagramPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
		createViewRequest.setLocation(request.getLocation().getCopy());
		Command viewCreateCommand = host.getCommand(createViewRequest);

		// 3. Create the compound command
		cc.add(new ICommandProxy(createElementCommand));
		cc.add(viewCreateCommand);

		return cc;
	}

	private boolean isValidFlowPortType(Object object, IElementType elementType) {
		boolean isValid = false;

		if((object != null) && (object instanceof Type)) {
			Type type = (Type)object;

			// Test valid type
			if(type instanceof DataType) {
				isValid = true;
			}

			if(type instanceof Signal) {
				isValid = true;
			}

			if(((ISpecializationType)SysMLElementTypes.FLOW_SPECIFICATION).getMatcher().matches(type)) {
				// Non-atomic flow port, the direction is meaningless in this case
				if(elementType == SysMLElementTypes.FLOW_PORT) {
					isValid = true;
				}
			}

			if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(type)) {
				isValid = true;
			}

			if(((ISpecializationType)SysMLElementTypes.VALUE_TYPE).getMatcher().matches(type)) {
				isValid = true;
			}

		}

		return isValid;
	}

	private boolean isValidPortType(Object object) {
		boolean isValid = false;

		if((object != null) && (object instanceof Type)) {
			isValid = true;
		}

		return isValid;
	}

	/**
	 * return the host Edit Part's semantic element, if the semantic element
	 * is <code>null</code> or unresolvable it will return <code>null</code>
	 * 
	 * @return EObject
	 */
	protected EObject getHostEObject(GraphicalEditPart host) {
		return ViewUtil.resolveSemanticElement((View)host.getModel());
	}
}
