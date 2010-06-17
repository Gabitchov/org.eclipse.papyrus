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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.edit.parts;

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
import org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure;
import org.eclipse.papyrus.diagram.profile.part.UMLVisualIDRegistry;
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

			case ProfileDiagramEditPart.VISUAL_ID:
				return new ProfileDiagramEditPart(view);

			case DependencyNodeEditPart.VISUAL_ID:
				return new DependencyNodeEditPart(view);

			case MultiDependencyLabelEditPart.VISUAL_ID:
				return new MultiDependencyLabelEditPart(view);

			case AssociationNodeEditPart.VISUAL_ID:
				return new AssociationNodeEditPart(view);

			case StereotypeEditPart.VISUAL_ID:
				return new StereotypeEditPart(view);

			case StereotypeNameEditPart.VISUAL_ID:
				return new StereotypeNameEditPart(view);

			case MetaclassEditPart.VISUAL_ID:
				return new MetaclassEditPart(view);

			case MetaclassNameEditPart.VISUAL_ID:
				return new MetaclassNameEditPart(view);

			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);

			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);

			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);

			case ConstraintNameEditPart.VISUAL_ID:
				return new ConstraintNameEditPart(view);

			case ModelEditPartTN.VISUAL_ID:
				return new ModelEditPartTN(view);

			case ModelNameEditPart.VISUAL_ID:
				return new ModelNameEditPart(view);

			case ProfileEditPartTN.VISUAL_ID:
				return new ProfileEditPartTN(view);

			case ProfileNameEditPartTN.VISUAL_ID:
				return new ProfileNameEditPartTN(view);

			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);

			case PackageNameEditPart.VISUAL_ID:
				return new PackageNameEditPart(view);

			case EnumerationEditPart.VISUAL_ID:
				return new EnumerationEditPart(view);

			case EnumerationNameEditPart.VISUAL_ID:
				return new EnumerationNameEditPart(view);

			case DataTypeEditPart.VISUAL_ID:
				return new DataTypeEditPart(view);

			case DataTypeNameEditPart.VISUAL_ID:
				return new DataTypeNameEditPart(view);

			case ShortCutDiagramEditPart.VISUAL_ID:
				return new ShortCutDiagramEditPart(view);

			case DiagramNameEditPart.VISUAL_ID:
				return new DiagramNameEditPart(view);

			case DataTypeOperationEditPart.VISUAL_ID:
				return new DataTypeOperationEditPart(view);

			case EnumerationLiteralEditPart.VISUAL_ID:
				return new EnumerationLiteralEditPart(view);

			case DataTypePropertyEditPart.VISUAL_ID:
				return new DataTypePropertyEditPart(view);

			case ClassPropertyEditPart.VISUAL_ID:
				return new ClassPropertyEditPart(view);

			case ClassOperationEditPart.VISUAL_ID:
				return new ClassOperationEditPart(view);

			case StereotypeEditPartCN.VISUAL_ID:
				return new StereotypeEditPartCN(view);

			case StereotypeNameEditPartCN.VISUAL_ID:
				return new StereotypeNameEditPartCN(view);

			case MetaclassEditPartCN.VISUAL_ID:
				return new MetaclassEditPartCN(view);

			case MetaclassNameEditPartCN.VISUAL_ID:
				return new MetaclassNameEditPartCN(view);

			case CommentEditPartCN.VISUAL_ID:
				return new CommentEditPartCN(view);

			case CommentBodyEditPartCN.VISUAL_ID:
				return new CommentBodyEditPartCN(view);

			case ModelEditPartCN.VISUAL_ID:
				return new ModelEditPartCN(view);

			case ModelNameEditPartCN.VISUAL_ID:
				return new ModelNameEditPartCN(view);

			case ProfileEditPartCN.VISUAL_ID:
				return new ProfileEditPartCN(view);

			case ProfileNameEditPartCN.VISUAL_ID:
				return new ProfileNameEditPartCN(view);

			case PackageEditPartCN.VISUAL_ID:
				return new PackageEditPartCN(view);

			case PackageNameEditPartCN.VISUAL_ID:
				return new PackageNameEditPartCN(view);

			case ConstraintEditPartCN.VISUAL_ID:
				return new ConstraintEditPartCN(view);

			case ConstraintNameEditPartCN.VISUAL_ID:
				return new ConstraintNameEditPartCN(view);

			case EnumerationEditPartCN.VISUAL_ID:
				return new EnumerationEditPartCN(view);

			case EnumerationNameEditPartCN.VISUAL_ID:
				return new EnumerationNameEditPartCN(view);

			case DataTypeEditPartCN.VISUAL_ID:
				return new DataTypeEditPartCN(view);

			case DataTypeNameEditPartCN.VISUAL_ID:
				return new DataTypeNameEditPartCN(view);

			case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
				return new PackagePackageableElementCompartmentEditPart(view);

			case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
				return new PackagePackageableElementCompartmentEditPartCN(view);

			case ProfilePackageableElementCompartmentEditPartTN.VISUAL_ID:
				return new ProfilePackageableElementCompartmentEditPartTN(view);

			case ProfilePackageableElementCompartmentEditPartCN.VISUAL_ID:
				return new ProfilePackageableElementCompartmentEditPartCN(view);

			case StereotypeAttributeCompartmentEditPart.VISUAL_ID:
				return new StereotypeAttributeCompartmentEditPart(view);

			case StereotypeAttributeCompartmentEditPartCN.VISUAL_ID:
				return new StereotypeAttributeCompartmentEditPartCN(view);

			case StereotypeOperationCompartmentEditPart.VISUAL_ID:
				return new StereotypeOperationCompartmentEditPart(view);

			case StereotypeOperationCompartmentEditPartCN.VISUAL_ID:
				return new StereotypeOperationCompartmentEditPartCN(view);

			case ModelPackageableElementCompartmentEditPartTN.VISUAL_ID:
				return new ModelPackageableElementCompartmentEditPartTN(view);

			case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
				return new ModelPackageableElementCompartmentEditPartCN(view);

			case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartmentEditPartCN(view);

			case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartmentEditPart(view);

			case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
				return new DataTypeAttributeCompartmentEditPart(view);

			case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
				return new DataTypeAttributeCompartmentEditPartCN(view);

			case DataTypeOperationCompartmentEditPart.VISUAL_ID:
				return new DataTypeOperationCompartmentEditPart(view);

			case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
				return new DataTypeOperationCompartmentEditPartCN(view);

			case ExtensionEditPart.VISUAL_ID:
				return new ExtensionEditPart(view);

			case AssociationEditPart.VISUAL_ID:
				return new AssociationEditPart(view);

			case AssociationAppliedStereotypeEditPart.VISUAL_ID:
				return new AssociationAppliedStereotypeEditPart(view);

			case AssociationNameEditPart.VISUAL_ID:
				return new AssociationNameEditPart(view);

			case AssociationRoleSourceLabelEditPart.VISUAL_ID:
				return new AssociationRoleSourceLabelEditPart(view);

			case AssociationMultiplicityTargetLabelEditPart.VISUAL_ID:
				return new AssociationMultiplicityTargetLabelEditPart(view);

			case ProfileApplicationEditPart.VISUAL_ID:
				return new ProfileApplicationEditPart(view);

			case AssociationBranchEditPart.VISUAL_ID:
				return new AssociationBranchEditPart(view);

			case AssociationBranchRoleEditPart.VISUAL_ID:
				return new AssociationBranchRoleEditPart(view);

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

			case DependencyBranchEditPart.VISUAL_ID:
				return new DependencyBranchEditPart(view);

			case ElementImportEditPart.VISUAL_ID:
				return new ElementImportEditPart(view);

			case ElementImportAliasEditPart.VISUAL_ID:
				return new ElementImportAliasEditPart(view);

			case AppliedStereotypeElementImportEditPart.VISUAL_ID:
				return new AppliedStereotypeElementImportEditPart(view);

			case PackageImportEditPart.VISUAL_ID:
				return new PackageImportEditPart(view);

			case PackageImportAppliedStereotypeEditPart.VISUAL_ID:
				return new PackageImportAppliedStereotypeEditPart(view);

			case CommentAnnotatedElementEditPart.VISUAL_ID:
				return new CommentAnnotatedElementEditPart(view);

			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);

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
		if(source.getFigure() instanceof HTMLCornerBentFigure)
			return new CommentCellEditorLocator((HTMLCornerBentFigure)source.getFigure());
		else if(source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel)source.getFigure());
		else {
			return new LabelCellEditorLocator((Label)source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class CommentCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private HTMLCornerBentFigure commentFigure;

		/**
		 * @generated
		 */
		public CommentCellEditorLocator(HTMLCornerBentFigure commentFigure) {
			this.commentFigure = commentFigure;
		}

		/**
		 * @generated
		 */
		public HTMLCornerBentFigure getCommentFigure() {
			return commentFigure;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getCommentFigure().getBounds().getCopy();
			getCommentFigure().translateToAbsolute(rect);
			if(getCommentFigure().getText().length() > 0) {
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
