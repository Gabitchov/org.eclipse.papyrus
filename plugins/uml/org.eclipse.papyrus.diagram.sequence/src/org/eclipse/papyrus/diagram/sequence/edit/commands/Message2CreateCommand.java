package org.eclipse.papyrus.diagram.sequence.edit.commands;

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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.providers.ElementInitializers;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class Message2CreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	private final Interaction container;

	/**
	 * @generated
	 */
	public Message2CreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
		container = deduceContainer(source, target);
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof Element) {
			return false;
		}
		if (target != null && false == target instanceof Element) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateMessage_4004(getContainer(), getSource(),
				getTarget());
	}

	/**
	 * added code to create the gate , message occurence and event when a Async message is created.
	 * 
	 * @generated-Not
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		Interaction interaction = getContainer();
		CallEvent callevent = UMLFactory.eINSTANCE.createCallEvent();
		CallEvent newCallevent = (CallEvent) ((Model) (interaction.getOwner())).createPackagedElement("", callevent
				.eClass());
		ElementInitializers.init_CallEvent_4003(newCallevent);

		Message newElement = interaction.createMessage("");
		newElement.setMessageSort(MessageSort.ASYNCH_CALL_LITERAL);
		interaction.getMessages().add(newElement);

		MessageEnd startMsg = null;
		MessageEnd endMsg = null;

		Element diagramSource = getSource();
		Element diagramTarget = getTarget();
		if ((diagramSource instanceof ExecutionSpecification || diagramSource instanceof Lifeline)
				&& (diagramTarget instanceof ExecutionSpecification || diagramTarget instanceof Lifeline)) {
			startMsg = doCreateMessageOccurrence(interaction, newCallevent);
			endMsg = doCreateMessageOccurrence(interaction, newCallevent);
			setupMessage(diagramSource, startMsg, endMsg);
			setupMessage(diagramTarget, endMsg, startMsg);
		} else if ((diagramSource instanceof ExecutionSpecification || diagramSource instanceof Lifeline)
				&& (diagramTarget instanceof Interaction || diagramTarget instanceof CombinedFragment || diagramTarget instanceof InteractionUse)) {
			startMsg = doCreateMessageOccurrence(interaction, newCallevent);
			setupMessage(diagramSource, startMsg, null);

			endMsg = doCreateGate(diagramTarget);
		} else if ((diagramSource instanceof Interaction || diagramSource instanceof CombinedFragment || diagramSource instanceof InteractionUse)
				&& (diagramTarget instanceof ExecutionSpecification || diagramTarget instanceof Lifeline)) {
			startMsg = doCreateGate(diagramSource);

			endMsg = doCreateMessageOccurrence(interaction, newCallevent);
			setupMessage(diagramTarget, endMsg, null);
		}

		if (startMsg != null && endMsg != null) {
			configureMessage(newElement, startMsg, endMsg);

			ElementInitializers.init_Message_4004(newElement);
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
			return CommandResult.newOKCommandResult(newElement);
		} else {
			return CommandResult.newCancelledCommandResult();
		}
	}

	/**
	 * Setup message and the element
	 * 
	 * @genereated NOT
	 * @param element
	 *            The element
	 * @param startMsg
	 *            Start of the message
	 * @param endMsg
	 *            End of the message
	 */
	private void setupMessage(Element element, MessageEnd startMsg, MessageEnd endMsg) {
		// create the relationship betwen the messageOccurence and the source
		if (element instanceof ExecutionSpecification) {
			ExecutionSpecification start = (ExecutionSpecification) element;

			// get the lifeline associated to the BehaviorExecutionSpecification
			Lifeline sourceLL = start.getCovereds().get(0);

			// set the relationship between the messageOccurence specificaition, the
			// ExecutionSpecification and the lifeline
			setupExecutionSpec(start, sourceLL, (OccurrenceSpecification) startMsg, (OccurrenceSpecification) endMsg);
		} else {
			setupMesssageOccu((Lifeline) element, (OccurrenceSpecification) startMsg, (OccurrenceSpecification) endMsg);
		}
	}

	/**
	 * @generated NOT
	 * @param interaction
	 * @param newCallevent
	 * @return
	 */
	private static MessageOccurrenceSpecification doCreateMessageOccurrence(Interaction interaction, Event event) {
		MessageOccurrenceSpecification result = UMLFactory.eINSTANCE.createMessageOccurrenceSpecification();
		ElementInitializers.init_MessageSpecificationOccurence_4003(result);
		result.setEnclosingInteraction(interaction);
		result.setEvent(event);
		return result;
	}

	/**
	 * @generated NOT
	 * @param spec
	 * @param lifeline
	 * @param start
	 * @param finish
	 */
	private void setupExecutionSpec(ExecutionSpecification spec, Lifeline lifeline, OccurrenceSpecification start,
			OccurrenceSpecification finish) {
		setSingleCovered(spec, lifeline);

		if (start != null) {
			setSingleCovered(start, lifeline);
			spec.setStart(start);
		}

		if (finish != null) {
			setSingleCovered(finish, lifeline);
			spec.setFinish(finish);
		}
	}

	/**
	 * @generated NOT
	 * @param lifeline
	 * @param start
	 * @param finish
	 */
	private void setupMesssageOccu(Lifeline lifeline, OccurrenceSpecification start, OccurrenceSpecification finish) {
		if (start != null) {
			setSingleCovered(start, lifeline);
		}

		if (finish != null) {
			setSingleCovered(finish, lifeline);
		}
	}

	/**
	 * @generated NOT
	 * @param fragment
	 * @param lifeline
	 */
	private void setSingleCovered(InteractionFragment fragment, Lifeline lifeline) {
		if (!fragment.getCovereds().contains(lifeline)) {
			fragment.getCovereds().add(lifeline);
		}
	}

	/**
	 * Create gate if element is a Interaction, a Combined Fragment or a Interaction Use
	 * 
	 * @generated NOT
	 * @param element
	 *            The element
	 * @return The gate
	 * @throws IllegalArgumentException
	 *             if the element is not a right element type
	 */
	private Gate doCreateGate(Element element) {
		Gate gate = null;

		if (element instanceof Interaction) {
			gate = ((Interaction) element).createFormalGate("");
		} else if (element instanceof CombinedFragment) {
			gate = ((CombinedFragment) element).createCfragmentGate("");
		} else if (element instanceof InteractionUse) {
			gate = ((InteractionUse) element).createActualGate("");
		} else {
			throw new IllegalArgumentException("Wrong element UML type for create a gate");
		}

		ElementInitializers.init_Gate_4003(gate);

		return gate;
	}

	/**
	 * Configure message
	 * 
	 * @generated NOT
	 * @param newElement
	 * @param startMsg
	 * @param endMsg
	 */
	private void configureMessage(Message newElement, MessageEnd startMsg, MessageEnd endMsg) {
		newElement.setSendEvent(startMsg);
		newElement.setReceiveEvent(endMsg);
		endMsg.setMessage(newElement);
		startMsg.setMessage(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Message newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected Element getSource() {
		return (Element) source;
	}

	/**
	 * @generated
	 */
	protected Element getTarget() {
		return (Element) target;
	}

	/**
	 * @generated
	 */
	public Interaction getContainer() {
		return container;
	}

	/**
	 * Default approach is to traverse ancestors of the source to find instance of container. Modify
	 * with appropriate logic.
	 * 
	 * @generated
	 */
	private static Interaction deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element.eContainer()) {
			if (element instanceof Interaction) {
				return (Interaction) element;
			}
		}
		return null;
	}

}
