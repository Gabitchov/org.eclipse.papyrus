/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.uml.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.uml.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomPackageItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomPackageEditPart extends PackageEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomPackageEditPart(View view) {
		super(view);
	}

	/**
	 * Remove the two policies dealing with the popup menu
	 * 
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomPackageItemSemanticEditPolicy());
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		//fix https://bugs.eclipse.org/bugs/show_bug.cgi?id=364688
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// do not handle connection event
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ContainerNodeEditPolicy() {

			@Override
			protected Command getConnectionAndEndCommands(CreateConnectionRequest request) {
				return UnexecutableCommand.INSTANCE;
			}
		});
	}

	private EditPolicy createLayoutEditPolicy() {
		return new XYLayoutEditPolicy() {

			@Override
			protected Command createAddCommand(EditPart child, Object constraint) {
				if(child instanceof LifelineEditPart) {
					if(!SequenceUtil.isCreateMessageEndLifeline((LifelineEditPart)child)) {
						return null;
					}
				}
				return super.createAddCommand(child, constraint);
			}
		};
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		if(event.getNotifier() instanceof EAnnotation) {
			EAnnotation eAnnotation = (EAnnotation)event.getNotifier();
			if(eAnnotation.getSource() != null && eAnnotation.getSource().equals(MDTUtil.FilterViewAndLabelsSource)) {
				//modification form MOSKitt approach, canonical policies are not called
				MDTUtil.filterDiagramViews(this.getDiagramView());
			}
		}
	}

	@Override
	public Object getAdapter(Class adapter) {
		if(adapter != null && adapter.equals(ViewInfo.class)) {
			return getDiagramViewInfo();
		}
		return super.getAdapter(adapter);
	}

	private static ViewInfo diagramViewInfo = null;

	public static ViewInfo getDiagramViewInfo() {
		if(diagramViewInfo == null) {
			diagramViewInfo = getPackage_1000ViewInfo();
		}
		return diagramViewInfo;
	}

	protected static ViewInfo getPackage_1000ViewInfo() {
		ViewInfo root = new BaseViewInfo(1000, ViewInfo.Head, "", null, null);
		ViewInfo viewInfo = null;
		ViewInfo labelInfo = null;
		viewInfo = new BaseViewInfo(2001, ViewInfo.Node, "Interaction");
		root.addNode(1000, viewInfo);
		viewInfo = new BaseViewInfo(4003, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		labelInfo = new BaseViewInfo(6001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo(6008, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo(4004, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		labelInfo = new BaseViewInfo(6002, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo(6009, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo(4005, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		labelInfo = new BaseViewInfo(6003, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo(6010, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo(4006, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		labelInfo = new BaseViewInfo(6004, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo(6011, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo(4007, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		labelInfo = new BaseViewInfo(6005, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo(6012, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo(4008, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		labelInfo = new BaseViewInfo(6006, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo(6013, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo(4009, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		labelInfo = new BaseViewInfo(6007, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo(6014, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo(4010, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		viewInfo = new BaseViewInfo(4011, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		viewInfo = new BaseViewInfo(4012, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);
		labelInfo = new BaseViewInfo(6015, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo(3007, ViewInfo.Node, "ConsiderIgnoreFragment");
		root.addNode(7001, viewInfo);
		root.addNode(3005, viewInfo);
		viewInfo = new BaseViewInfo(3004, ViewInfo.Node, "CombinedFragment");
		root.addNode(3005, viewInfo);
		root.addNode(7001, viewInfo);
		viewInfo = new BaseViewInfo(3005, ViewInfo.Node, "InteractionOperand");
		root.addNode(7004, viewInfo);
		viewInfo = new BaseViewInfo(3002, ViewInfo.Node, "InteractionUse");
		root.addNode(3005, viewInfo);
		root.addNode(7001, viewInfo);
		viewInfo = new BaseViewInfo(3016, ViewInfo.Node, "Continuation");
		root.addNode(3005, viewInfo);
		viewInfo = new BaseViewInfo(3001, ViewInfo.Node, "Lifeline");
		root.addNode(7001, viewInfo);
		viewInfo = new BaseViewInfo(3006, ViewInfo.Node, "ActionExecutionSpecification");
		root.addNode(3001, viewInfo);
		viewInfo = new BaseViewInfo(3003, ViewInfo.Node, "BehaviorExecutionSpecification");
		root.addNode(3001, viewInfo);
		viewInfo = new BaseViewInfo(3017, ViewInfo.Node, "StateInvariant");
		root.addNode(3001, viewInfo);
		viewInfo = new BaseViewInfo(3018, ViewInfo.Node, "CombinedFragment");
		root.addNode(3001, viewInfo);
		viewInfo = new BaseViewInfo(3019, ViewInfo.Node, "TimeConstraint");
		root.addNode(3001, viewInfo);
		viewInfo = new BaseViewInfo(3020, ViewInfo.Node, "TimeObservation");
		root.addNode(3001, viewInfo);
		viewInfo = new BaseViewInfo(3021, ViewInfo.Node, "DurationConstraint");
		root.addNode(3001, viewInfo);
		viewInfo = new BaseViewInfo(3022, ViewInfo.Node, "DestructionOccurrenceSpecification");
		root.addNode(3001, viewInfo);
		viewInfo = new BaseViewInfo(3008, ViewInfo.Node, "Constraint");
		root.addNode(7001, viewInfo);
		viewInfo = new BaseViewInfo(3009, ViewInfo.Node, "Comment");
		root.addNode(7001, viewInfo);
		viewInfo = new BaseViewInfo(3023, ViewInfo.Node, "DurationConstraint");
		root.addNode(2001, viewInfo);
		viewInfo = new BaseViewInfo(3024, ViewInfo.Node, "DurationObservation");
		root.addNode(2001, viewInfo);
		return root;
	}
}
