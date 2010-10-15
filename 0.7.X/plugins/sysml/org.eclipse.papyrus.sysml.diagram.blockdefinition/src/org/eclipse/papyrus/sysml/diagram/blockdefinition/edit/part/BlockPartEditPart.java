package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.OperationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.policies.UMLTextNonResizableEditPolicy;
import org.eclipse.papyrus.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.DefaultItemSemanticEditPolicy;
import org.eclipse.uml2.uml.UMLPackage;


public class BlockPartEditPart extends PropertyEditPart {

	public BlockPartEditPart(View view) {
		super(view);
	}


}
