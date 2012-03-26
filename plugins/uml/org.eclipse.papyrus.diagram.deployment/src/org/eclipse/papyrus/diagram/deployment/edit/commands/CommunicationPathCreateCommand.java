package org.eclipse.papyrus.diagram.deployment.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.deployment.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class CommunicationPathCreateCommand extends EditElementCommand {

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
	protected Package container;

	/**
	 * @generated
	 */
	public CommunicationPathCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
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
		if(source != null && false == source instanceof Type) {
			return false;
		}
		if(target != null && false == target instanceof Type) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if(getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canCreateCommunicationPath_4010(getContainer(), getSource(), getTarget());
	}

	/**
	 * @generated
	 */
	protected void doConfigure(CommunicationPath newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected Type getSource() {
		return (Type)source;
	}

	/**
	 * @generated
	 */
	protected Type getTarget() {
		return (Type)target;
	}

	/**
	 * @generated
	 */
	public Package getContainer() {
		return container;
	}

	/**
	 * Default approach is to traverse ancestors of the source to find instance of container.
	 * Modify with appropriate logic.
	 * 
	 * @generated
	 */
	protected Package deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null; element = element.eContainer()) {
			if(element instanceof Package) {
				return (Package)element;
			}
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		if(source instanceof Type && target instanceof Type && container instanceof Package) {
			CommunicationPath newElement = createCommunicationPath(getEditingDomain(), (Type)source, (Type)target, (Package)container);
			((CreateElementRequest)getRequest()).setNewElement(newElement);
			return CommandResult.newOKCommandResult(newElement);
		}
		return null;
	}

	public static CommunicationPath createCommunicationPath(TransactionalEditingDomain domain, Type source, Type target, Package container) {
		CommunicationPath communicationPath = UMLFactory.eINSTANCE.createCommunicationPath();
		String targetString = target.getName().substring(0, 1).toLowerCase() + target.getName().substring(1, target.getName().length());
		String sourceString = source.getName().substring(0, 1).toLowerCase() + source.getName().substring(1, source.getName().length());
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(communicationPath);
		if(provider != null) {
			createProperty(domain, provider, communicationPath, target, targetString);
			createProperty(domain, provider, communicationPath, source, sourceString);
		}
		container.getPackagedElements().add(communicationPath);
		String name = NamedElementUtil.getDefaultNameWithIncrement(communicationPath);
		communicationPath.setName(name);
		return communicationPath;
	}

	protected static Property createProperty(TransactionalEditingDomain domain, IElementEditService provider, EObject container, Type type, String name) {
		CreateElementRequest request = new CreateElementRequest(domain, container, UMLElementTypes.PROPERTY, UMLPackage.eINSTANCE.getAssociation_OwnedEnd());
		ICommand c = provider.getEditCommand(request);
		if(c != null) {
			try {
				c.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(c.getCommandResult() != null && c.getCommandResult().getReturnValue() instanceof Property) {
				Property property = (Property)c.getCommandResult().getReturnValue();
				property.setType(type);
				property.setName(name);
				property.setLower(1);
				property.setUpper(1);
				return property;
			}
		}
		return null;
	}
}
