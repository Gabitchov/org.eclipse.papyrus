package org.eclipse.papyrus.diagram.activity.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.activity.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ObjectFlowCreateCommand extends CreateElementCommand {

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
	private Activity container;

	/**
	 * @generated
	 */
	public ObjectFlowCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request);
		this.source = source;
		this.target = target;
		if (request.getContainmentFeature() == null) {
			setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Edge());
		}

		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element.eContainer()) {
			if (element instanceof Activity) {
				container = (Activity) element;
				super.setElementToEdit(container);
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof ActivityNode) {
			return false;
		}
		if (target != null && false == target instanceof ActivityNode) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateObjectFlow_3002(getContainer(), getSource(), getTarget());
	}

	/**
	 * @generated
	 */
	protected Diagram getDiagramFromRequest() {

		if (getRequest().getParameters().get(MultiDiagramUtil.BelongToDiagramSource) != null) {
			Object parameter = getRequest().getParameters().get(MultiDiagramUtil.BelongToDiagramSource);
			if (parameter instanceof Diagram) {
				return (Diagram) parameter;
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		ObjectFlow newElement = UMLFactory.eINSTANCE.createObjectFlow();
		getContainer().getEdges().add(newElement);
		newElement.setSource(getSource());
		newElement.setTarget(getTarget());
		UMLElementTypes.init_ObjectFlow_3002(newElement);

		Diagram diagram = getDiagramFromRequest();
		if (diagram != null) {
			MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement);
		} else {
			MultiDiagramUtil.addEAnnotationReferenceToDiagram(UMLDiagramEditorPlugin.getInstance(), newElement);
		}
		return newElement;
	}

	/**
	 * @generated
	 */
	@Override
	protected EClass getEClassToEdit() {
		return UMLPackage.eINSTANCE.getActivity();
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		return super.doExecuteWithResult(monitor, info);
	}

	/**
	 * @generated
	 */
	@Override
	protected ConfigureRequest createConfigureRequest() {
		ConfigureRequest request = super.createConfigureRequest();
		request.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		request.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		return request;
	}

	/**
	 * @generated
	 */
	@Override
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected ActivityNode getSource() {
		return (ActivityNode) source;
	}

	/**
	 * @generated
	 */
	protected ActivityNode getTarget() {
		return (ActivityNode) target;
	}

	/**
	 * @generated
	 */
	public Activity getContainer() {
		return container;
	}
}
