/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Amine EL KOUHEN (CEA LIST/LIFL) & Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.edit.parts;

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
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;
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
			case ComponentDiagramEditPart.VISUAL_ID:
				return new ComponentDiagramEditPart(view);
			case DependencyNodeEditPart.VISUAL_ID:
				return new DependencyNodeEditPart(view);
			case MultiDependencyLabelEditPart.VISUAL_ID:
				return new MultiDependencyLabelEditPart(view);
			case ComponentEditPart.VISUAL_ID:
				return new ComponentEditPart(view);
			case ComponentNameEditPart.VISUAL_ID:
				return new ComponentNameEditPart(view);
			case ModelEditPart.VISUAL_ID:
				return new ModelEditPart(view);
			case ModelNameEditPart.VISUAL_ID:
				return new ModelNameEditPart(view);
			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);
			case PackageNameEditPart.VISUAL_ID:
				return new PackageNameEditPart(view);
			case RectangleInterfaceEditPart.VISUAL_ID:
				return new RectangleInterfaceEditPart(view);
			case RectangleInterfaceNameEditPart.VISUAL_ID:
				return new RectangleInterfaceNameEditPart(view);
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
			case DefaultNamedElementEditPart.VISUAL_ID:
				return new DefaultNamedElementEditPart(view);
			case DefaultNamedElementNameEditPart.VISUAL_ID:
				return new DefaultNamedElementNameEditPart(view);
			case InterfaceEditPart.VISUAL_ID:
				return new InterfaceEditPart(view);
			case InterfaceNameEditPart.VISUAL_ID:
				return new InterfaceNameEditPart(view);
			case PortEditPart.VISUAL_ID:
				return new PortEditPart(view);
			case PortNameEditPart.VISUAL_ID:
				return new PortNameEditPart(view);
			case PortAppliedStereotypeEditPart.VISUAL_ID:
				return new PortAppliedStereotypeEditPart(view);
			case ModelEditPartCN.VISUAL_ID:
				return new ModelEditPartCN(view);
			case ModelNameEditPartCN.VISUAL_ID:
				return new ModelNameEditPartCN(view);
			case PackageEditPartCN.VISUAL_ID:
				return new PackageEditPartCN(view);
			case PackageNameEditPartCN.VISUAL_ID:
				return new PackageNameEditPartCN(view);
			case ComponentEditPartCN.VISUAL_ID:
				return new ComponentEditPartCN(view);
			case ComponentNameEditPartCN.VISUAL_ID:
				return new ComponentNameEditPartCN(view);
			case ComponentEditPartPCN.VISUAL_ID:
				return new ComponentEditPartPCN(view);
			case ComponentNameEditPartPCN.VISUAL_ID:
				return new ComponentNameEditPartPCN(view);
			case InterfaceEditPartPCN.VISUAL_ID:
				return new InterfaceEditPartPCN(view);
			case InterfaceNameEditPartPCN.VISUAL_ID:
				return new InterfaceNameEditPartPCN(view);
			case CommentEditPartPCN.VISUAL_ID:
				return new CommentEditPartPCN(view);
			case CommentBodyEditPartPCN.VISUAL_ID:
				return new CommentBodyEditPartPCN(view);
			case ConstraintEditPartPCN.VISUAL_ID:
				return new ConstraintEditPartPCN(view);
			case ConstraintNameEditPartPCN.VISUAL_ID:
				return new ConstraintNameEditPartPCN(view);
			case ConstraintSpecificationEditPartPCN.VISUAL_ID:
				return new ConstraintSpecificationEditPartPCN(view);
			case PropertyForInterfaceEditPart.VISUAL_ID:
				return new PropertyForInterfaceEditPart(view);
			case ComponentCompositeCompartmentEditPart.VISUAL_ID:
				return new ComponentCompositeCompartmentEditPart(view);
			case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
				return new ModelPackageableElementCompartmentEditPart(view);
			case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
				return new PackagePackageableElementCompartmentEditPart(view);
			case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
				return new ModelPackageableElementCompartmentEditPartCN(view);
			case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
				return new PackagePackageableElementCompartmentEditPartCN(view);
			case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
				return new ComponentCompositeCompartmentEditPartCN(view);
			case ComponentCompositeCompartmentEditPartPCN.VISUAL_ID:
				return new ComponentCompositeCompartmentEditPartPCN(view);
			case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
				return new InterfaceAttributeCompartmentEditPart(view);
			case UsageEditPart.VISUAL_ID:
				return new UsageEditPart(view);
			case InterfaceRealizationEditPart.VISUAL_ID:
				return new InterfaceRealizationEditPart(view);
			case GeneralizationEditPart.VISUAL_ID:
				return new GeneralizationEditPart(view);
			case GeneralizationAppliedStereotypeEditPart.VISUAL_ID:
				return new GeneralizationAppliedStereotypeEditPart(view);
			case SubstitutionEditPart.VISUAL_ID:
				return new SubstitutionEditPart(view);
			case SubstitutionNameEditPart.VISUAL_ID:
				return new SubstitutionNameEditPart(view);
			case SubstitutionAppliedStereotypeEditPart.VISUAL_ID:
				return new SubstitutionAppliedStereotypeEditPart(view);
			case ManifestationEditPart.VISUAL_ID:
				return new ManifestationEditPart(view);
			case ManifestationNameEditPart.VISUAL_ID:
				return new ManifestationNameEditPart(view);
			case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
				return new ManifestationAppliedStereotypeEditPart(view);
			case ComponentRealizationEditPart.VISUAL_ID:
				return new ComponentRealizationEditPart(view);
			case ComponentRealizationNameEditPart.VISUAL_ID:
				return new ComponentRealizationNameEditPart(view);
			case ComponentRealizationAppliedStereotypeEditPart.VISUAL_ID:
				return new ComponentRealizationAppliedStereotypeEditPart(view);
			case AbstractionEditPart.VISUAL_ID:
				return new AbstractionEditPart(view);
			case AbstractionNameEditPart.VISUAL_ID:
				return new AbstractionNameEditPart(view);
			case AbstractionAppliedStereotypeEditPart.VISUAL_ID:
				return new AbstractionAppliedStereotypeEditPart(view);
			case LinkDescriptorEditPart.VISUAL_ID:
				return new LinkDescriptorEditPart(view);
			case CommentAnnotatedElementEditPart.VISUAL_ID:
				return new CommentAnnotatedElementEditPart(view);
			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);
			case DependencyEditPart.VISUAL_ID:
				return new DependencyEditPart(view);
			case DependencyNameEditPart.VISUAL_ID:
				return new DependencyNameEditPart(view);
			case DependencyAppliedStereotypeEditPart.VISUAL_ID:
				return new DependencyAppliedStereotypeEditPart(view);
			case DependencyBranchEditPart.VISUAL_ID:
				return new DependencyBranchEditPart(view);
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
