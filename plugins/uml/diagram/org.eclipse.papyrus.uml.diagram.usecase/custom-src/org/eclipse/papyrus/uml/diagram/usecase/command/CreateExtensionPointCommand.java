/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.diagram.usecase.edit.commands.ExtensionPointCreateCommand;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.UseCase;

public class CreateExtensionPointCommand extends Command {

	/** The command to create the extension point */
	private ICommandProxy elementCreationCommand = null;

	/** The command to create corresponding view */
	private CompoundCommand viewsCreationCommand = null;

	/** The command to set the property extension point in extend element */
	private ICommandProxy setExtensionPropertyCmd;

	/** The compartment which graphically contains the extension point to create */
	private AbstractEditPart compartment = null;

	/** The e object container of the extension point */
	private EObject containerObject;

	/** the element type */
	private IHintedType type;

	/** adapter to get the extend element */
	private IAdaptable adapter;

	public CreateExtensionPointCommand(IHintedType elementType, AbstractEditPart compartmentPart, EObject container, IAdaptable adapter) {
		elementCreationCommand = getElementCreationCommand(container, elementType);
		type = elementType;
		compartment = compartmentPart;
		containerObject = container;
		this.adapter = adapter;
	}

	/**
	 * Get the Command to create the extension point element
	 * 
	 * @param container
	 *        the use case which owns the extension point
	 * @param elementType
	 *        the type of the extension point
	 * @return the command to create model element or null
	 */
	private static ICommandProxy getElementCreationCommand(EObject container, IHintedType elementType) {
		CreateElementRequest createElementReq = new CreateElementRequest(container, elementType);
		if(UMLElementTypes.ExtensionPoint_3007.equals(elementType)) {
			ExtensionPointCreateCommand cmd = new ExtensionPointCreateCommand(createElementReq);
			return new ICommandProxy(cmd);
		} else {
			return null;
		}
	}

	/**
	 * Get the Command to create the extension point element
	 * 
	 * @param container
	 *        the use case which owns the extension point
	 * @param elementType
	 *        the type of the extension point
	 * @return the command to create model element or null
	 */
	private ICommandProxy getExtensionPointAddCommand(Extend extend, ExtensionPoint extPoint) {
		TransactionalEditingDomain editingDomain;
		try {
			editingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(extend);
		} catch (ServiceException ex) {
			UMLDiagramEditorPlugin.getInstance().logError(ex.getMessage(), ex);
			return null;
		}

		SetExtensionPropertyCmd cmd = new SetExtensionPropertyCmd(editingDomain, extend, extPoint);
		return new ICommandProxy(cmd);
	}

	/**
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return elementCreationCommand != null && elementCreationCommand.canExecute();
	}

	/**
	 * Execute the command : create the model element, then the corresponding view
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.execute();
		Object extensionPoint = getExtensionPoint();
		// create the view for the extension point
		if(extensionPoint instanceof ExtensionPoint && compartment != null && type != null) {
			// set the property of extend element with the extension point
			Object object = adapter.getAdapter(Extend.class);
			if(object instanceof Extend) {
				Extend extend = (Extend)object;
				setExtensionPropertyCmd = getExtensionPointAddCommand(extend, (ExtensionPoint)extensionPoint);
				if(setExtensionPropertyCmd.canExecute()) {
					setExtensionPropertyCmd.execute();
				}
			}
			createExtensionPointView((ExtensionPoint)extensionPoint);
		}
	}

	/**
	 * @return the first extension point if exists, create a new one any
	 */
	private Object getExtensionPoint() {
		Object extensionPoint = null;
		if(containerObject instanceof UseCase) {
			UseCase useCase = (UseCase)containerObject;
			if(useCase.getExtensionPoints() != null && !useCase.getExtensionPoints().isEmpty()) {
				extensionPoint = useCase.getExtensionPoints().get(0);
			}
		}
		// or create a new extension point if needed
		if(elementCreationCommand != null && extensionPoint == null) {
			elementCreationCommand.execute();
			extensionPoint = elementCreationCommand.getICommand().getCommandResult().getReturnValue();
		}
		return extensionPoint;
	}

	/**
	 * Creates the extension point view if needed
	 * 
	 * @param extensionPoint
	 *        the extension point element
	 */
	private void createExtensionPointView(ExtensionPoint extensionPoint) {
		viewsCreationCommand = new CompoundCommand();
		IGraphicalEditPart useCasePointEP = null;
		for(Object ep : compartment.getChildren()) {
			if(ep instanceof UseCasePointsEditPartTN) {
				useCasePointEP = (IGraphicalEditPart)ep;
				break;
			} else if(ep instanceof UseCasePointsInComponentEditPart) {
				useCasePointEP = (IGraphicalEditPart)ep;
				break;
			} else if(ep instanceof UseCasePointsInPackageEditPart) {
				useCasePointEP = (IGraphicalEditPart)ep;
				break;
			}
		}
		if(useCasePointEP != null) {
			// check if extension point is already drawn
			boolean alreadyDrawn = false;
			for(Object obj : useCasePointEP.getChildren()) {
				if((obj instanceof ExtensionPointEditPart) && extensionPoint.equals(((ExtensionPointEditPart)obj).resolveSemanticElement())) {
					alreadyDrawn = true;
					break;
				}
			}
			if(!alreadyDrawn) {
				ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(new EObjectAdapter(extensionPoint), Node.class, type.getSemanticHint(), useCasePointEP.getDiagramPreferencesHint());
				CreateViewRequest request = new CreateViewRequest(descriptor);
				Command nodeCreationCommand = useCasePointEP.getCommand(request);
				viewsCreationCommand.add(nodeCreationCommand);
				viewsCreationCommand.execute();
			}
		}
	}

	/**
	 * Undo model and views creation
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		if(viewsCreationCommand != null) {
			viewsCreationCommand.undo();
		}
		if(setExtensionPropertyCmd != null) {
			setExtensionPropertyCmd.undo();
		}
		if(elementCreationCommand != null) {
			elementCreationCommand.undo();
		}
	}

	/**
	 * Custom command to set the property extension points in extend element
	 */
	private class SetExtensionPropertyCmd extends AbstractTransactionalCommand {

		private ExtensionPoint extPoint;

		private Extend extend;

		public SetExtensionPropertyCmd(TransactionalEditingDomain editingDomain, Extend extend, ExtensionPoint extensionPoint) {
			super(editingDomain, "Set extension point property", null);
			this.extend = extend;
			this.extPoint = extensionPoint;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			extend.getExtensionLocations().add(extPoint);
			return CommandResult.newOKCommandResult();
		}
	}
}
