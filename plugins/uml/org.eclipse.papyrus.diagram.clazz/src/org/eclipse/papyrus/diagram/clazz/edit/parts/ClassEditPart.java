/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.ClassItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.ConstrainedItemBorderLayoutEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.node.CClassifierFigure;
import org.eclipse.papyrus.diagram.common.figure.node.ClassifierFigure;
import org.eclipse.papyrus.diagram.common.locator.TemplateClassifierBorderItemLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class ClassEditPart extends AbstractBorderedShapeEditPart {

	static final Color THIS_GRADIENT = new Color(null, 177, 207, 229);

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2008;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public ClassEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ClassNameEditPart) {
			((ClassNameEditPart) childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if (childEditPart instanceof ClassAttributeCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ClassAttributeCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ClassOperationCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ClassOperationCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ClassNestedClassifierCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ClassNestedClassifierCompartment2EditPart) childEditPart).getFigure());
			return true;
		}

		// Papyrus Gencode :precise the locator for a template signature
		if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
			BorderItemLocator locator = new TemplateClassifierBorderItemLocator(getMainFigure(), PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(((RedefinableTemplateSignatureEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ClassItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		// in Papyrus diagrams are not strongly synchronised
		// installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.clazz.edit.policies.ClassCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy("RESIZE_BORDER_ITEMS", new ConstrainedItemBorderLayoutEditPolicy()); //$NON-NLS-1$
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (UMLVisualIDRegistry.getVisualID(childView)) {
				case RedefinableTemplateSignatureEditPart.VISUAL_ID:

					// done in GMF gen code
					// return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy();
					// done in papyrus gencode to have borderItem resizeable
					return new BorderItemResizableEditPolicy();

				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
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

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new ClassifierFigure();
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof ClassAttributeCompartment2EditPart) {
			return getPrimaryShape().getAttributeCompartmentFigure();
		}
		if (editPart instanceof ClassOperationCompartment2EditPart) {
			return getPrimaryShape().getOperationCompartmentFigure();
		}
		if (editPart instanceof ClassNestedClassifierCompartment2EditPart) {
			return getPrimaryShape().getNestedClassifierFigure();
		}
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated not
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public ClassifierFigure getPrimaryShape() {
		return (ClassifierFigure) primaryShape;
	}

	/**
	 *Papyrus codeGen
	 * 
	 * @generated
	 **/
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the figure active when the feature of the of a class is true
		if (resolveSemanticElement() != null) {
			if (resolveSemanticElement().equals(event.getNotifier()) && (event.getFeature() instanceof EAttribute) && ((EAttribute) (event.getFeature())).getName().equals("isActive")) {
				((ClassifierFigure) getFigure()).setActive(event.getNewBooleanValue());
				refreshVisuals();
			}
		}
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ClassNameEditPart) {
			return true;
		}
		if (childEditPart instanceof ClassAttributeCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ClassAttributeCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ClassOperationCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ClassOperationCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ClassNestedClassifierCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ClassNestedClassifierCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((RedefinableTemplateSignatureEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

}
