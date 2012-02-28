package org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.activitygroup.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.diagram.activity.edit.parts.StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.UMLPackage;


public class ActivityNodeContainment extends AbstractContainerNodeDescriptor {

	private List<EReference> parentReferences;

	@Override
	public EClass getContainerEClass() {
		return UMLPackage.Literals.ACTIVITY_NODE;
	}

	@Override
	public List<EReference> getChildrenReferences() {
		return Collections.emptyList();
	}

	@Override
	public List<EReference> getParentReferences() {
		if (parentReferences == null){
			parentReferences = new ArrayList<EReference>();		
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_INTERRUPTIBLE_REGION);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_PARTITION);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_STRUCTURED_NODE);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__ACTIVITY);
		}
		return parentReferences;
	}

	@Override
	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart) {
		return null;
	}

	public int getGroupPriority() {
		return IGroupPriority.ACTIVITY_NODE_PRIORITY;
	}

	

}
