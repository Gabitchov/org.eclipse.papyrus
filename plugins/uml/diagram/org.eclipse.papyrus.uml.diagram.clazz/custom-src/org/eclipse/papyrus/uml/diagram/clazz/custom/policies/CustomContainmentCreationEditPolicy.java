/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.ContainmentDragDropHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.NestedClassForClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;


/**
 * The Class CustomContainmentCreationEditPolicy.
 */
public class CustomContainmentCreationEditPolicy extends PapyrusCreationEditPolicy {

	private static List<Integer> ourCanHaveContainmentLinks = Arrays.asList(new Integer[]{ NestedClassForClassEditPart.VISUAL_ID, ClassEditPartCN.VISUAL_ID, PackageEditPartCN.VISUAL_ID, ModelEditPartCN.VISUAL_ID, ModelEditPartTN.VISUAL_ID, ClassEditPart.VISUAL_ID, PackageEditPart.VISUAL_ID });

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getReparentCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		Iterator editParts = request.getEditParts().iterator();
		View container = (View)getHost().getAdapter(View.class);
		EObject context = container == null ? null : ViewUtil.resolveSemanticElement(container);
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		while(editParts.hasNext()) {
			EditPart ep = (EditPart)editParts.next();
			if(ep instanceof LabelEditPart) {
				continue;
			}
			if(ep instanceof GroupEditPart) {
				cc.compose(getReparentGroupCommand((GroupEditPart)ep));
			}
			View view = (View)ep.getAdapter(View.class);
			if(view == null) {
				continue;
			}

			EObject semantic = ViewUtil.resolveSemanticElement(view);
			if(semantic == null) {
				cc.compose(getReparentViewCommand((IGraphicalEditPart)ep));
			} else if(context != null && hasContainmentLink(view)) {
				View hostView = (View)getHost().getModel();
				View movedView = (View)ep.getModel();
				Command customCommand = new ContainmentDragDropHelper(((IGraphicalEditPart)ep).getEditingDomain()).getDropWithContainmentCommand(hostView, movedView);
				if(customCommand != null) {
					return customCommand;
				}
			}
			if(semantic != null && context != null && shouldReparent(semantic, context)) {
				cc.compose(getReparentCommand((IGraphicalEditPart)ep));
			}
		}
		return cc.isEmpty() ? null : new ICommandProxy(cc.reduce());
	}

	private boolean hasContainmentLink(View movedView) {
		return ourCanHaveContainmentLinks.contains(UMLVisualIDRegistry.getVisualID(movedView));
	}

}
