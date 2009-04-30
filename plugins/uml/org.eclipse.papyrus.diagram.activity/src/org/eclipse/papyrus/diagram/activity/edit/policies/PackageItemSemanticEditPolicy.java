package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.commands.DuplicateAnythingCommand;
import org.eclipse.papyrus.diagram.common.part.DiagramCanvasSwitch;
import org.eclipse.papyrus.diagram.common.util.BasicEcoreSwitch;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * @generated
 */
public class PackageItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated NOT
	 * 
	 *            modified to handle an Activity as a canvas element.
	 */
	static class EReferenceDiagramSwitch extends
			BasicEcoreSwitch<EReference, IElementType> {

		@Override
		public EReference doSwitch(EObject modelElement) {
			final IElementType type = getInfo();
			if (type == null) {
				return null;
			}
			UMLSwitch<EReference> aSwitch = new UMLSwitch<EReference>() {
				@Override
				public EReference casePackage(Package modelElement) {
					EReference reference = null;
					if (type.equals(UMLElementTypes.Activity_1001)) {
						reference = UMLPackage.eINSTANCE
								.getPackage_PackagedElement();
					}
					if (type.equals(UMLElementTypes.Comment_2034)) {
						reference = UMLPackage.eINSTANCE
								.getElement_OwnedComment();
					}
					return reference;
				}

				@Override
				public EReference caseActivity(Activity modelElement) {
					EReference reference = null;
					if (type.equals(UMLElementTypes.Comment_2034)) {
						reference = UMLPackage.eINSTANCE
								.getElement_OwnedComment();
					}
					return reference;
				}
			};
			return aSwitch.doSwitch(modelElement);
		}
	}

	/**
	 * @generated
	 */
	private EReferenceDiagramSwitch aSwitch = new EReferenceDiagramSwitch();

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		Diagram diagram = DiagramEditPartsUtil
				.findDiagramFromEditPart(getHost());
		if (diagram != null) {
			req.getParameters().put(MultiDiagramUtil.BelongToDiagramSource,
					diagram);
		}
		EObject canvasElement = DiagramCanvasSwitch.getCanvasElement(this);
		if (canvasElement == null) {
			return null;
		}
		aSwitch.setInfo(req.getElementType());
		req.setContainmentFeature(aSwitch.doSwitch(canvasElement));
		if (UMLElementTypes.Activity_1001 == req.getElementType()) {
			return getGEFWrapper(ActivityCreateCommand.create(req,
					canvasElement));
		}
		if (UMLElementTypes.Comment_2034 == req.getElementType()) {
			return getGEFWrapper(CommentCreateCommand
					.create(req, canvasElement));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		Diagram currentDiagram = null;
		if (getHost() instanceof IGraphicalEditPart) {
			currentDiagram = ((IGraphicalEditPart) getHost()).getNotationView()
					.getDiagram();
		}
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req,
				currentDiagram));
	}

}
