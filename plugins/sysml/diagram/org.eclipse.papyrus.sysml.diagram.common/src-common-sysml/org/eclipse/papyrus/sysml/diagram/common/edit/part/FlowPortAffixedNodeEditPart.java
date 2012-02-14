/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.edit.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.ExternalLabelPrimaryDragRoleEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.sysml.diagram.common.Activator;
import org.eclipse.papyrus.sysml.diagram.common.figure.FlowPortFigure;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementBorderEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeIconlDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.locator.ExternalLabelPositionLocator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This class implements an edit part for FlowPort represented as border items.
 */
public class FlowPortAffixedNodeEditPart extends AbstractElementBorderEditPart {

	private LayoutListener.Stub layoutInitializationListener;

	public FlowPortAffixedNodeEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeIconlDisplayEditPolicy() {

			/**
			 * <pre>
			 * {@inheritDoc}
			 * 
			 * This modifies the edit policy in order to call refreshVisuals() whenever the stereotype image to show is null.
			 * (required to show the FlowPort default image correctly).
			 * </pre>
			 */
			@Override
			protected void refreshStereotypeDisplay() {
				if(getHost() instanceof IPapyrusEditPart) {
					IFigure figure = ((IPapyrusEditPart)getHost()).getPrimaryShape();

					if((figure instanceof IPapyrusUMLElementFigure) && (stereotypeIconToDisplay() != null)) {
						((IPapyrusUMLElementFigure)figure).setStereotypeDisplay(null, stereotypeIconToDisplay());
					} else {
						refreshVisuals();
					}
				}
			}

		});

		installEditPolicy(ShowHideLabelEditPolicy.SHOW_HIDE_LABEL_ROLE, new ShowHideLabelEditPolicy());
	}

	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if(child instanceof IBorderItemEditPart) { // External labels
					return new ExternalLabelPrimaryDragRoleEditPolicy() {

						@SuppressWarnings("rawtypes")
						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}

				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		IBorderItemLocator locator = new ExternalLabelPositionLocator(getMainFigure());
		borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		return;
	}

	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID);
	}

	protected void addSemanticListeners() {

		if(resolveSemanticElement() != null) {

			FlowPort flowPort = UMLUtil.getStereotypeApplication((Element)resolveSemanticElement(), FlowPort.class);
			if(flowPort != null) {
				addListenerFilter("FlowPort", this, flowPort); //$NON-NLS-1$
			}
		}

		super.addSemanticListeners();
	}

	protected void removeSemanticListeners() {
		removeListenerFilter("FlowPort"); //$NON-NLS-1$
		super.removeSemanticListeners();
	}

	/**
	 * <pre>
	 * Calls the figure refresh when a change event is detected on 
	 * UMLPackage.eINSTANCE.getProperty_Aggregation().
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {

		// When the flow port position changes, its position on parent side may change and requires a visual refresh.
		Object feature = event.getFeature();
		if(NotationPackage.eINSTANCE.getSize_Width().equals(feature) || NotationPackage.eINSTANCE.getSize_Height().equals(feature) || NotationPackage.eINSTANCE.getLocation_X().equals(feature) || NotationPackage.eINSTANCE.getLocation_Y().equals(feature)) {
			refreshVisuals();
		}

		// A visual refresh may also be needed when the following properties are changing : isAtomic (depend on the type), direction, isConjugated.
		if(resolveSemanticElement() != null) {
			Element element = (Element)resolveSemanticElement();
			FlowPort flowPort = UMLUtil.getStereotypeApplication(element, FlowPort.class);

			if((flowPort != null) && (flowPort.equals(event.getNotifier()))) {
				if(PortandflowsPackage.eINSTANCE.getFlowPort_Direction().equals(event.getFeature())
				//|| PortandflowsPackage.eINSTANCE.getFlowPort_IsAtomic().equals(event.getFeature())
				|| PortandflowsPackage.eINSTANCE.getFlowPort_IsConjugated().equals(event.getFeature())) {
					refreshVisuals();
				}
			}

			// IsAtomic change is triggered by a type change
			if(resolveSemanticElement().equals(event.getNotifier())) {
				if(UMLPackage.eINSTANCE.getTypedElement_Type().equals(event.getFeature())) {
					refreshVisuals();
				}
			}
		}

		super.handleNotificationEvent(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new FlowPortFigure();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FlowPortFigure getPrimaryShape() {
		return (FlowPortFigure)primaryShape;
	}

	/**
	 * <pre>
	 * Refresh the figure with the flow port image.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();

		int side = getBorderItemLocator().getCurrentSideOfParent();
		if (side == 0) {
			getBorderItemLocator().getCurrentSideOfParent();
		}

		Element element = (Element)resolveSemanticElement();
		FlowPort flowPort = UMLUtil.getStereotypeApplication(element, FlowPort.class);

		Image image = Activator.getInstance().getFlowPortImage(flowPort, side);
		getPrimaryShape().setImage(image);
	}

	/**
	 * <pre>
	 * A post layout listener is added during activate and remove the first time the layout occurs.
	 * This is required in order to be able to find the side of this border item on its parent when opening the model.
	 * Without this, the locator is unable to guess the parent side because the parent constraint is not set yet.
	 * 
	 * Once the initialization is done, the listener become useless and can be removed.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	public void activate() {

		layoutInitializationListener = new LayoutListener.Stub() {

			@Override
			public void postLayout(IFigure container) {
				refreshVisuals();
				//getBorderedFigure().getBorderItemContainer().removeLayoutListener(layoutInitializationListener);
				layoutInitializationListener = null;
			}
		};
		getBorderedFigure().getBorderItemContainer().addLayoutListener(layoutInitializationListener);

		super.activate();
	}

}
