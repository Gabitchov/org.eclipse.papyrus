package org.eclipse.papyrus.uml.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;

/**
 * @generated
 */
public class DestructionOccurrenceSpecificationCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public DestructionOccurrenceSpecificationCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static DestructionOccurrenceSpecificationCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new DestructionOccurrenceSpecificationCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public DestructionOccurrenceSpecificationCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated
	 */
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * A DestructionEvent on a lifeline can only be created if it doesn't exist yet a destructionEvent on that lifeline.
	 * 
	 * @generated NOT
	 */
	public boolean canExecute() {

		// Get the lifeline
		Lifeline lifeline = (Lifeline)getElementToEdit();

		for(InteractionFragment ift : lifeline.getCoveredBys()) {
			if(ift instanceof DestructionOccurrenceSpecification) {
				// For each occurenceSpecification which covered the lifeline, check the associated event.
				return false;

			}
		}

		return true;

	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// Get the model container
		Object modelContainer = ((CreateElementRequest)getRequest()).getParameters().get(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER);

		DestructionOccurrenceSpecification destructionSpecification = (DestructionOccurrenceSpecification)CommandHelper.doCreateDestructionOccurrenceSpecification((Lifeline)getElementToEdit(), modelContainer);

		ElementInitializers.getInstance().init_DestructionOccurrenceSpecification_3022(destructionSpecification);

		doConfigure(destructionSpecification, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(destructionSpecification);
		return CommandResult.newOKCommandResult(destructionSpecification);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(DestructionOccurrenceSpecification newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

}
