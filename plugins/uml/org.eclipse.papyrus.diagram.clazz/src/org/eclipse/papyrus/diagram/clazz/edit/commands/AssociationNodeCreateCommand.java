package org.eclipse.papyrus.diagram.clazz.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class AssociationNodeCreateCommand extends CreateElementCommand {

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
	public AssociationNodeCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static AssociationNodeCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new AssociationNodeCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public AssociationNodeCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
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
	protected EClass getEClassToEdit() {

		EObject eObject = getElementToEdit();
		if (eObject != null) {
			return eObject.eClass();
		}
		if (eClass != null) {
			return eClass;
		}
		return UMLPackage.eINSTANCE.getPackage();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		Association newElement = (Association) super.doDefaultElementCreation();
		// code used in MOSKitt approach in order to manage "delete from diagram"
		// if (newElement != null) {
		//	
		// org.eclipse.gmf.runtime.notation.Diagram diagram = es.cv.gvcase.mdt.common.util.MDTUtil.getDiagramFromRequest(getRequest());
		// if (diagram != null) {
		// es.cv.gvcase.mdt.common.util.MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement);
		// }
		// else {
		// es.cv.gvcase.mdt.common.util.MultiDiagramUtil.
		// addEAnnotationReferenceToDiagram(
		// org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.getInstance(), newElement);
		// }
		// }
		return newElement;
	}

}
