/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.diagram.common.figure.node.IMultilineEditableFigure;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
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

			case UseCaseDiagramEditPart.VISUAL_ID:
				return new UseCaseDiagramEditPart(view);

			case ActorEditPartTN.VISUAL_ID:
				return new ActorEditPartTN(view);

			case ActorNameEditPartTN.VISUAL_ID:
				return new ActorNameEditPartTN(view);

			case ActorAppliedStereotypeEditPartTN.VISUAL_ID:
				return new ActorAppliedStereotypeEditPartTN(view);

			case ActorAsRectangleEditPartTN.VISUAL_ID:
				return new ActorAsRectangleEditPartTN(view);

			case ActorAsRectangleNameEditPartTN.VISUAL_ID:
				return new ActorAsRectangleNameEditPartTN(view);

			case UseCaseEditPartTN.VISUAL_ID:
				return new UseCaseEditPartTN(view);

			case UseCaseNameEditPartTN.VISUAL_ID:
				return new UseCaseNameEditPartTN(view);

			case UseCaseAsRectangleEditPartTN.VISUAL_ID:
				return new UseCaseAsRectangleEditPartTN(view);

			case UseCaseAsRectangleNameEditPartTN.VISUAL_ID:
				return new UseCaseAsRectangleNameEditPartTN(view);

			case ComponentEditPartTN.VISUAL_ID:
				return new ComponentEditPartTN(view);

			case ComponentNameEditPartTN.VISUAL_ID:
				return new ComponentNameEditPartTN(view);

			case PackageEditPartTN.VISUAL_ID:
				return new PackageEditPartTN(view);

			case PackageNameEditPartTN.VISUAL_ID:
				return new PackageNameEditPartTN(view);

			case ConstraintEditPartTN.VISUAL_ID:
				return new ConstraintEditPartTN(view);

			case ConstraintNameEditPartTN.VISUAL_ID:
				return new ConstraintNameEditPartTN(view);

			case CommentEditPartTN.VISUAL_ID:
				return new CommentEditPartTN(view);

			case CommentBodyEditPartTN.VISUAL_ID:
				return new CommentBodyEditPartTN(view);

			case ShortCutDiagramEditPart.VISUAL_ID:
				return new ShortCutDiagramEditPart(view);

			case DiagramNameEditPart.VISUAL_ID:
				return new DiagramNameEditPart(view);

			case ExtensionPointEditPart.VISUAL_ID:
				return new ExtensionPointEditPart(view);

			case ExtensionPointInRectangleEditPart.VISUAL_ID:
				return new ExtensionPointInRectangleEditPart(view);

			case UseCaseInComponentEditPart.VISUAL_ID:
				return new UseCaseInComponentEditPart(view);

			case UseCaseInComponentNameEditPart.VISUAL_ID:
				return new UseCaseInComponentNameEditPart(view);

			case ComponentInComponentEditPart.VISUAL_ID:
				return new ComponentInComponentEditPart(view);

			case ComponentInComponentNameEditPart.VISUAL_ID:
				return new ComponentInComponentNameEditPart(view);

			case CommentEditPartCN.VISUAL_ID:
				return new CommentEditPartCN(view);

			case CommentBodyEditPartCN.VISUAL_ID:
				return new CommentBodyEditPartCN(view);

			case ConstraintInComponentEditPart.VISUAL_ID:
				return new ConstraintInComponentEditPart(view);

			case ConstraintInComponentNameEditPart.VISUAL_ID:
				return new ConstraintInComponentNameEditPart(view);

			case ActorInComponentEditPart.VISUAL_ID:
				return new ActorInComponentEditPart(view);

			case ActorInComponentNameEditPart.VISUAL_ID:
				return new ActorInComponentNameEditPart(view);

			case ActorInComponentAppliedStereotypeEditPart.VISUAL_ID:
				return new ActorInComponentAppliedStereotypeEditPart(view);

			case ConstraintInPackageEditPart.VISUAL_ID:
				return new ConstraintInPackageEditPart(view);

			case ConstraintInPackageNameEditPart.VISUAL_ID:
				return new ConstraintInPackageNameEditPart(view);

			case ActorInPackageEditPart.VISUAL_ID:
				return new ActorInPackageEditPart(view);

			case ActorInPackageNameEditPart.VISUAL_ID:
				return new ActorInPackageNameEditPart(view);

			case ActorInPackageAppliedStereotypeEditPart.VISUAL_ID:
				return new ActorInPackageAppliedStereotypeEditPart(view);

			case UseCaseInPackageEditPart.VISUAL_ID:
				return new UseCaseInPackageEditPart(view);

			case UseCaseInPackageNameEditPart.VISUAL_ID:
				return new UseCaseInPackageNameEditPart(view);

			case ComponentInPackageEditPart.VISUAL_ID:
				return new ComponentInPackageEditPart(view);

			case ComponentInPackageNameEditPart.VISUAL_ID:
				return new ComponentInPackageNameEditPart(view);

			case PackageEditPartCN.VISUAL_ID:
				return new PackageEditPartCN(view);

			case PackageNameEditPartCN.VISUAL_ID:
				return new PackageNameEditPartCN(view);

			case UseCasePointsEditPartTN.VISUAL_ID:
				return new UseCasePointsEditPartTN(view);

			case UseCasePointsInRectangleEditPart.VISUAL_ID:
				return new UseCasePointsInRectangleEditPart(view);

			case ComponentUsecasesEditPart.VISUAL_ID:
				return new ComponentUsecasesEditPart(view);

			case UseCasePointsInComponentEditPart.VISUAL_ID:
				return new UseCasePointsInComponentEditPart(view);

			case ComponentUsecases2EditPart.VISUAL_ID:
				return new ComponentUsecases2EditPart(view);

			case UseCasePointsInPackageEditPart.VISUAL_ID:
				return new UseCasePointsInPackageEditPart(view);

			case ComponentUsecases3EditPart.VISUAL_ID:
				return new ComponentUsecases3EditPart(view);

			case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
				return new PackagePackageableElementCompartment2EditPart(view);

			case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
				return new PackagePackageableElementCompartmentEditPart(view);

			case IncludeEditPart.VISUAL_ID:
				return new IncludeEditPart(view);

			case IncludeLink_fixedEditPart.VISUAL_ID:
				return new IncludeLink_fixedEditPart(view);

			case IncludeAppliedStereotypeEditPart.VISUAL_ID:
				return new IncludeAppliedStereotypeEditPart(view);


			case ExtendEditPart.VISUAL_ID:
				return new ExtendEditPart(view);

			case ExtendsLink_fixedEditPart.VISUAL_ID:
				return new ExtendsLink_fixedEditPart(view);

			case ExtendAppliedStereotypeEditPart.VISUAL_ID:
				return new ExtendAppliedStereotypeEditPart(view);


			case GeneralizationEditPart.VISUAL_ID:
				return new GeneralizationEditPart(view);

			case GeneralizationAppliedStereotypeEditPart.VISUAL_ID:
				return new GeneralizationAppliedStereotypeEditPart(view);


			case AssociationEditPart.VISUAL_ID:
				return new AssociationEditPart(view);

			case AssociationNameEditPart.VISUAL_ID:
				return new AssociationNameEditPart(view);

			case AssociationAppliedStereotypeEditPart.VISUAL_ID:
				return new AssociationAppliedStereotypeEditPart(view);


			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);


			case DependencyEditPart.VISUAL_ID:
				return new DependencyEditPart(view);

			case DependencyNameEditPart.VISUAL_ID:
				return new DependencyNameEditPart(view);

			case DependencyAppliedStereotypeEditPart.VISUAL_ID:
				return new DependencyAppliedStereotypeEditPart(view);


			case CommentAnnotatedElementEditPart.VISUAL_ID:
				return new CommentAnnotatedElementEditPart(view);


			case AbstractionEditPart.VISUAL_ID:
				return new AbstractionEditPart(view);

			case AbstractionNameEditPart.VISUAL_ID:
				return new AbstractionNameEditPart(view);

			case AppliedStereotypeAbstractionEditPart.VISUAL_ID:
				return new AppliedStereotypeAbstractionEditPart(view);


			case UsageEditPart.VISUAL_ID:
				return new UsageEditPart(view);

			case UsageNameEditPart.VISUAL_ID:
				return new UsageNameEditPart(view);

			case AppliedStereotypeUsageEditPart.VISUAL_ID:
				return new AppliedStereotypeUsageEditPart(view);


			case RealizationEditPart.VISUAL_ID:
				return new RealizationEditPart(view);

			case RealizationNameEditPart.VISUAL_ID:
				return new RealizationNameEditPart(view);

			case RealizationAppliedStereotypeEditPart.VISUAL_ID:
				return new RealizationAppliedStereotypeEditPart(view);


			case PackageMergeEditPart.VISUAL_ID:
				return new PackageMergeEditPart(view);

			case AppliedStereotypePackageMergeEditPart.VISUAL_ID:
				return new AppliedStereotypePackageMergeEditPart(view);


			case PackageImportEditPart.VISUAL_ID:
				return new PackageImportEditPart(view);

			case PackageImportVisibilityEditPart.VISUAL_ID:
				return new PackageImportVisibilityEditPart(view);

			case PackageImportAppliedStereotypeEditPart.VISUAL_ID:
				return new PackageImportAppliedStereotypeEditPart(view);

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
		if(source.getFigure() instanceof IMultilineEditableFigure)
			return new MultilineCellEditorLocator((IMultilineEditableFigure)source.getFigure());
		else if(source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel)source.getFigure());
		else {
			return new LabelCellEditorLocator((Label)source.getFigure());
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

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if(!text.getFont().isDisposed()) {
				if(getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
					rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
				} else {
					int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
					rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
				}
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			if(!text.getFont().isDisposed()) {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
