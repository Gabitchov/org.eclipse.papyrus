/*
 * 
 */

package org.eclipse.papyrus.diagram.deployment.edit.commands;

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
import org.eclipse.papyrus.diagram.deployment.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.UMLFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class GeneralizationCreateCommand.
 *
 * @generated
 */
public class GeneralizationCreateCommand extends EditElementCommand {

	/** The source. @generated */
	protected final EObject source;

	/** The target. @generated */
	protected final EObject target;


	/** The container. @generated */
	protected Classifier container;

	/**
	 * Instantiates a new generalization create command.
	 *
	 * @param request the request
	 * @param source the source
	 * @param target the target
	 * @generated
	 */
	public GeneralizationCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
		container = deduceContainer(source, target);
	}

	/**
	 * Can execute.
	 *
	 * @return true, if successful
	 * @generated
	 */
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof Classifier) {
			return false;
		}
		if(target != null && false == target instanceof Classifier) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if(getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canCreateGeneralization_4003(getContainer(), getSource(), getTarget());
	}


	/**
	 * Do execute with result.
	 *
	 * @param monitor the monitor
	 * @param info the info
	 * @return the command result
	 * @throws ExecutionException the execution exception
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		Generalization newElement = UMLFactory.eINSTANCE.createGeneralization();
		getContainer().getGeneralizations().add(newElement);
		newElement.setSpecific(getSource());
		newElement.setGeneral(getTarget());
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);

	}


	/**
	 * Do configure.
	 *
	 * @param newElement the new element
	 * @param monitor the monitor
	 * @param info the info
	 * @throws ExecutionException the execution exception
	 * @generated
	 */
	protected void doConfigure(Generalization newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
	 * Sets the element to edit.
	 *
	 * @param element the new element to edit
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Gets the source.
	 *
	 * @return the source
	 * @generated
	 */
	protected Classifier getSource() {
		return (Classifier)source;
	}

	/**
	 * Gets the target.
	 *
	 * @return the target
	 * @generated
	 */
	protected Classifier getTarget() {
		return (Classifier)target;
	}

	/**
	 * Gets the container.
	 *
	 * @return the container
	 * @generated
	 */
	public Classifier getContainer() {
		return container;
	}

	/**
	 * Default approach is to traverse ancestors of the source to find instance of container.
	 * Modify with appropriate logic.
	 *
	 * @param source the source
	 * @param target the target
	 * @return the classifier
	 * @generated
	 */
	protected Classifier deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null; element = element.eContainer()) {
			if(element instanceof Classifier) {
				return (Classifier)element;
			}
		}
		return null;
	}

}
