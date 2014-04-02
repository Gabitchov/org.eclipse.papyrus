/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.LifelineCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.PartDecomposition;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomLifelineCreateCommand extends LifelineCreateCommand {

	/**
	 * The list of the available properties
	 */
	private List<Property> availableProperties;

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomLifelineCreateCommand(CreateElementRequest req, EObject eObject, Diagram diagram) {
		super(req, eObject, diagram);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomLifelineCreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
	}

	/**
	 * Add generated NOT to constrain the creation of a lifeline
	 * 
	 * @Override
	 */
	@Override
	public boolean canExecute() {
		return !(getElementToEdit() instanceof InteractionOperand);
	}

	/**
	 * Generated not for add lifelines on lifeline
	 * 
	 * @Override
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		EObject object = getElementToEdit();
		Interaction interactionOwner = null;
		Property property = null;
		Lifeline newElement = UMLFactory.eINSTANCE.createLifeline();
		if(object instanceof Lifeline) {
			Lifeline parentLifeline = (Lifeline)object;
			property = CommandHelper.getProperties(availableProperties);
			if(property == null) {
				return CommandResult.newCancelledCommandResult();
			}
			newElement.setRepresents(property);
			interactionOwner = parentLifeline.getInteraction();
			// create or retrieve a PartDecomposition
			PartDecomposition partDecomposition = parentLifeline.getDecomposedAs();
			if(partDecomposition == null) {
				List<InteractionFragment> ifts = interactionOwner.getFragments();
				partDecomposition = UMLFactory.eINSTANCE.createPartDecomposition();
				partDecomposition.setName(ElementInitializers.getNextNumberedName(ifts, partDecomposition.eClass().getName()));
				ifts.add(partDecomposition);
				parentLifeline.setDecomposedAs(partDecomposition);
			}
			partDecomposition.getCovereds().add(newElement);
		} else {
			interactionOwner = (Interaction)getElementToEdit();
		}
		interactionOwner.getLifelines().add(newElement);
		ElementInitializers.getInstance().init_Lifeline_3001(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @Override
	 */
	@Override
	protected void doConfigure(Lifeline newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		// fix bug 364696(https://bugs.eclipse.org/bugs/show_bug.cgi?id=364696) 
		Object object = getRequest().getParameters().get(SequenceRequestConstant.CONNECTABLE_ELEMENT);
		if(object instanceof ConnectableElement) {
			newElement.setRepresents((ConnectableElement)object);
		}
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	 * Set available property
	 * 
	 * @param availableProperties
	 *        The available properties
	 */
	public void setAvailableProperties(List<Property> availableProperties) {
		this.availableProperties = availableProperties;
	}
}
