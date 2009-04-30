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
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class InputPin3CreateCommand extends CreateElementCommand {

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
	public InputPin3CreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static InputPin3CreateCommand create(CreateElementRequest req,
			EObject eObject) {
		return new InputPin3CreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public InputPin3CreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
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
		return UMLPackage.eINSTANCE.getSendSignalAction();
	}

	/**
	 * @generated
	 */
	protected Diagram getDiagramFromRequest() {

		if (getRequest().getParameters().get(
				MultiDiagramUtil.BelongToDiagramSource) != null) {
			Object parameter = getRequest().getParameters().get(
					MultiDiagramUtil.BelongToDiagramSource);
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
		InputPin newElement = (InputPin) super.doDefaultElementCreation();
		if (newElement != null) {
			SendSignalAction owner = (SendSignalAction) getElementToEdit();
			owner.setTarget(newElement);

			UMLElementTypes.init_InputPin_2006(newElement);

			Diagram diagram = getDiagramFromRequest();
			if (diagram != null) {
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram,
						newElement);
			} else {
				MultiDiagramUtil.addEAnnotationReferenceToDiagram(
						UMLDiagramEditorPlugin.getInstance(), newElement);
			}
		}
		return newElement;
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		SendSignalAction container = (SendSignalAction) getElementToEdit();
		if (container.getTarget() != null) {
			return false;
		}
		return true;
	}
}
