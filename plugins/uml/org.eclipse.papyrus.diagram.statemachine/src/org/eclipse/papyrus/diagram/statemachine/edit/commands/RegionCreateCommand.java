package org.eclipse.papyrus.diagram.statemachine.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class RegionCreateCommand extends CreateElementCommand {

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
	public RegionCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static RegionCreateCommand create(CreateElementRequest req,
			EObject eObject) {
		return new RegionCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public RegionCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest)getRequest())
				.getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
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
		if(eObject != null) {
			return eObject.eClass();
		}
		if(eClass != null) {
			return eClass;
		}
		return UMLPackage.eINSTANCE.getStateMachine();
	}

	/**
	 * @generated
	 */
	protected Diagram getDiagramFromRequest() {

		if(getRequest().getParameters().get(
				MultiDiagramUtil.BelongToDiagramSource) != null) {
			Object parameter = getRequest().getParameters().get(
					MultiDiagramUtil.BelongToDiagramSource);
			if(parameter instanceof Diagram) {
				return (Diagram)parameter;
			}
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		Region newElement = (Region)super.doDefaultElementCreation();
		if(newElement != null) {
			Diagram diagram = getDiagramFromRequest();
			if(diagram != null) {
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram,
						newElement);
			} else {
				MultiDiagramUtil.addEAnnotationReferenceToDiagram(
						UMLDiagramEditorPlugin.getInstance(), newElement);
			}
		}
		return newElement;
	}
}
