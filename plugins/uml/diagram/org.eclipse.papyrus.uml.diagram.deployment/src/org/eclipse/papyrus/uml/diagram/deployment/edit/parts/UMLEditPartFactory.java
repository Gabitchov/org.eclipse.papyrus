/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST) Amine.Elkouhen@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.edit.parts;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

/**
 * @generated
 */
public class UMLEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {

			case DeploymentDiagramEditPart.VISUAL_ID:
				return new DeploymentDiagramEditPart(view);

			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);

			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);

			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);

			case ConstraintNameEditPart.VISUAL_ID:
				return new ConstraintNameEditPart(view);

			case ConstraintSpecificationEditPart.VISUAL_ID:
				return new ConstraintSpecificationEditPart(view);

			case ExecutionEnvironmentEditPart.VISUAL_ID:
				return new ExecutionEnvironmentEditPart(view);

			case ExecutionEnvironmentNameEditPart.VISUAL_ID:
				return new ExecutionEnvironmentNameEditPart(view);

			case DeviceEditPart.VISUAL_ID:
				return new DeviceEditPart(view);

			case DeviceNameEditPart.VISUAL_ID:
				return new DeviceNameEditPart(view);

			case ArtifactEditPart.VISUAL_ID:
				return new ArtifactEditPart(view);

			case ArtifactNameEditPart.VISUAL_ID:
				return new ArtifactNameEditPart(view);

			case NodeEditPart.VISUAL_ID:
				return new NodeEditPart(view);

			case NodeNameEditPart.VISUAL_ID:
				return new NodeNameEditPart(view);

			case NodeEditPartCN.VISUAL_ID:
				return new NodeEditPartCN(view);

			case NodeNameEditPartCN.VISUAL_ID:
				return new NodeNameEditPartCN(view);

			case DeviceEditPartCN.VISUAL_ID:
				return new DeviceEditPartCN(view);

			case DeviceNameEditPartCN.VISUAL_ID:
				return new DeviceNameEditPartCN(view);

			case ExecutionEnvironmentEditPartCN.VISUAL_ID:
				return new ExecutionEnvironmentEditPartCN(view);

			case ExecutionEnvironmentNameEditPartCN.VISUAL_ID:
				return new ExecutionEnvironmentNameEditPartCN(view);

			case ArtifactEditPartCN.VISUAL_ID:
				return new ArtifactEditPartCN(view);

			case ArtifactNameEditPartCN.VISUAL_ID:
				return new ArtifactNameEditPartCN(view);

			case ArtifactEditPartACN.VISUAL_ID:
				return new ArtifactEditPartACN(view);

			case ArtifactNameEditPartACN.VISUAL_ID:
				return new ArtifactNameEditPartACN(view);

			case DeviceCompositeCompartmentEditPart.VISUAL_ID:
				return new DeviceCompositeCompartmentEditPart(view);

			case ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID:
				return new ExecutionEnvironmentCompositeCompartmentEditPart(view);

			case NodeCompositeCompartmentEditPart.VISUAL_ID:
				return new NodeCompositeCompartmentEditPart(view);

			case ArtifactCompositeCompartmentEditPart.VISUAL_ID:
				return new ArtifactCompositeCompartmentEditPart(view);

			case DeviceCompositeCompartmentEditPartCN.VISUAL_ID:
				return new DeviceCompositeCompartmentEditPartCN(view);

			case ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID:
				return new ExecutionEnvironmentCompositeCompartmentEditPartCN(view);

			case NodeCompositeCompartmentEditPartCN.VISUAL_ID:
				return new NodeCompositeCompartmentEditPartCN(view);

			case ArtifactCompositeCompartmentEditPartCN.VISUAL_ID:
				return new ArtifactCompositeCompartmentEditPartCN(view);

			case ArtifactCompositeCompartmentEditPartACN.VISUAL_ID:
				return new ArtifactCompositeCompartmentEditPartACN(view);

			case LinkDescriptorEditPart.VISUAL_ID:
				return new LinkDescriptorEditPart(view);

			case CommentAnnotatedElementEditPart.VISUAL_ID:
				return new CommentAnnotatedElementEditPart(view);

			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);

			case DeploymentEditPart.VISUAL_ID:
				return new DeploymentEditPart(view);

			case DeploymentNameEditPart.VISUAL_ID:
				return new DeploymentNameEditPart(view);

			case DeploymentAppliedStereotypeEditPart.VISUAL_ID:
				return new DeploymentAppliedStereotypeEditPart(view);

			case ManifestationEditPart.VISUAL_ID:
				return new ManifestationEditPart(view);

			case ManifestationNameEditPart.VISUAL_ID:
				return new ManifestationNameEditPart(view);

			case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
				return new ManifestationAppliedStereotypeEditPart(view);

			case GeneralizationEditPart.VISUAL_ID:
				return new GeneralizationEditPart(view);

			case GeneralizationAppliedStereotypeEditPart.VISUAL_ID:
				return new GeneralizationAppliedStereotypeEditPart(view);

			case DependencyEditPart.VISUAL_ID:
				return new DependencyEditPart(view);

			case DependencyNameEditPart.VISUAL_ID:
				return new DependencyNameEditPart(view);

			case DependencyAppliedStereotypeEditPart.VISUAL_ID:
				return new DependencyAppliedStereotypeEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if(source.getFigure() instanceof IMultilineEditableFigure) {
			return new MultilineCellEditorLocator((IMultilineEditableFigure)source.getFigure());
		} else {
			return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);

		}
	}

	/**
	 * @generated
	 */
	static private class MultilineCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private IMultilineEditableFigure multilineEditableFigure;

		/**
		 * @generated
		 */
		public MultilineCellEditorLocator(IMultilineEditableFigure figure) {
			this.multilineEditableFigure = figure;
		}

		/**
		 * @generated
		 */
		public IMultilineEditableFigure getMultilineEditableFigure() {
			return multilineEditableFigure;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getMultilineEditableFigure().getBounds().getCopy();
			rect.x = getMultilineEditableFigure().getEditionLocation().x;
			rect.y = getMultilineEditableFigure().getEditionLocation().y;
			getMultilineEditableFigure().translateToAbsolute(rect);
			if(getMultilineEditableFigure().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
