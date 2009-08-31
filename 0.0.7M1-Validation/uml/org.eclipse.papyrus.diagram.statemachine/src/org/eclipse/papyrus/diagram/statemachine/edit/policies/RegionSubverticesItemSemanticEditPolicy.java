package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.FinalStateCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.Pseudostate2CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.Pseudostate3CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.Pseudostate4CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.Pseudostate5CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.Pseudostate6CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.Pseudostate7CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.Pseudostate8CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.State2CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.State3CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.State4CreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.StateCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class RegionSubverticesItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

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
		if (UMLElementTypes.State_2002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new StateCreateCommand(req));
		}
		if (UMLElementTypes.State_2003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new State2CreateCommand(req));
		}
		if (UMLElementTypes.State_2005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new State3CreateCommand(req));
		}
		if (UMLElementTypes.FinalState_2008 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new FinalStateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_2009 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new PseudostateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_2010 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new Pseudostate2CreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_2011 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new Pseudostate3CreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_2012 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new Pseudostate4CreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_2013 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new Pseudostate5CreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_2014 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new Pseudostate6CreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_2015 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new Pseudostate7CreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_2016 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new Pseudostate8CreateCommand(req));
		}
		if (UMLElementTypes.State_2017 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Subvertex());
			}
			return getGEFWrapper(new State4CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getHost().getParent().getCommand(
				new EditCommandRequestWrapper(req));
	}

}
