package org.eclipse.papyrus.uml.diagram.statemachine.edit.commands;

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
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.EMFCustomTransitionRetargetContainerCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.ElementInitializers;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Vertex;

/**
 * @generated
 */
public class TransitionCreateCommand extends EditElementCommand {

	/**
	 * Default approach is to traverse ancestors of the source to find instance
	 * of container. Modify with appropriate logic.
	 * 
	 * @generated NOT
	 */
	protected Region deduceContainer(EObject source, EObject target) {
		// TODO: avoid modification of generated code, problem is that model needs to be changed at many places ... 
		return EMFCustomTransitionRetargetContainerCommand.deduceContainer(source, target);
	}

	/**
	 * @generated
	 */
	protected final EObject source;

	/**
	 * @generated
	 */
	protected final EObject target;

	/**
	 * @generated
	 */
	protected Region container;

	/**
	 * @generated
	 */
	public TransitionCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
		container = deduceContainer(source, target);
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof Vertex) {
			return false;
		}
		if(target != null && false == target instanceof Vertex) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if(getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canCreateTransition_7000(getContainer(), getSource(), getTarget());
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Transition newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		Transition newElement = UMLFactory.eINSTANCE.createTransition();
		getContainer().getTransitions().add(newElement);
		newElement.setSource(getSource());
		newElement.setTarget(getTarget());
		ElementInitializers.getInstance().init_Transition_7000(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	public Region getContainer() {
		return container;
	}

	/**
	 * @generated
	 */
	protected Vertex getSource() {
		return (Vertex)source;
	}

	/**
	 * @generated
	 */
	protected Vertex getTarget() {
		return (Vertex)target;
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}
}
