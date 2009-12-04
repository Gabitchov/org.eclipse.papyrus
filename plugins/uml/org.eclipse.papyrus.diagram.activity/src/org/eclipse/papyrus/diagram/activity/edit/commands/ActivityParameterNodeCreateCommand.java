package org.eclipse.papyrus.diagram.activity.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ActivityParameterNodeCreateCommand extends CreateElementCommand {

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
	public ActivityParameterNodeCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static ActivityParameterNodeCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new ActivityParameterNodeCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public ActivityParameterNodeCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		if (container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * @generated
	 */
	@Override
	protected EClass getEClassToEdit() {

		EObject eObject = getElementToEdit();
		if (eObject != null) {
			return eObject.eClass();
		}
		if (eClass != null) {
			return eClass;
		}
		return UMLPackage.eINSTANCE.getActivity();
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
		ActivityParameterNode newElement = (ActivityParameterNode) super.doDefaultElementCreation();
		if (newElement != null) {
			Activity owner = (Activity) getElementToEdit();
			owner.getNodes().add(newElement);

			UMLElementTypes.init_ActivityParameterNode_2029(newElement);

			Diagram diagram = getDiagramFromRequest();
			if (diagram != null) {
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement);
			} else {
				MultiDiagramUtil.addEAnnotationReferenceToDiagram(UMLDiagramEditorPlugin.getInstance(), newElement);
			}
		}
		return newElement;
	}
}
