/*
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.uml.diagram.profile.edit.parts;

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
import org.eclipse.papyrus.uml.diagram.profile.part.UMLVisualIDRegistry;
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

			case ConstraintBodyEditPart.VISUAL_ID:
				return new ConstraintBodyEditPart(view);

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

			case PrimitiveTypeEditPart.VISUAL_ID:
				return new PrimitiveTypeEditPart(view);

			case PrimitiveTypeNameEditPart.VISUAL_ID:
				return new PrimitiveTypeNameEditPart(view);

			case DataTypeEditPart.VISUAL_ID:
				return new DataTypeEditPart(view);

			case DataTypeNameEditPart.VISUAL_ID:
				return new DataTypeNameEditPart(view);

			case ShortCutDiagramEditPart.VISUAL_ID:
				return new ShortCutDiagramEditPart(view);

			case DiagramNameEditPart.VISUAL_ID:
				return new DiagramNameEditPart(view);

			case PrimitiveTypeEditPartCN.VISUAL_ID:
				return new PrimitiveTypeEditPartCN(view);

			case PrimitiveTypeNameEditPartCN.VISUAL_ID:
				return new PrimitiveTypeNameEditPartCN(view);

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

			case ConstraintBodyEditPartCN.VISUAL_ID:
				return new ConstraintBodyEditPartCN(view);

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

			case AssociationRoleTargetEditPart.VISUAL_ID:
				return new AssociationRoleTargetEditPart(view);

			case AssociationRoleSourceEditPart.VISUAL_ID:
				return new AssociationRoleSourceEditPart(view);

			case AssociationMultiplicitySourceEditPart.VISUAL_ID:
				return new AssociationMultiplicitySourceEditPart(view);

			case AssociationMultiplicityTargetEditPart.VISUAL_ID:
				return new AssociationMultiplicityTargetEditPart(view);


			case ProfileApplicationEditPart.VISUAL_ID:
				return new ProfileApplicationEditPart(view);


			case AssociationBranchEditPart.VISUAL_ID:
				return new AssociationBranchEditPart(view);

			case AssociationBranchRoleEditPart.VISUAL_ID:
				return new AssociationBranchRoleEditPart(view);

			case AssociationBranchMultiplicityEditPart.VISUAL_ID:
				return new AssociationBranchMultiplicityEditPart(view);


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


			case ContextLinkEditPart.VISUAL_ID:
				return new ContextLinkEditPart(view);

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
