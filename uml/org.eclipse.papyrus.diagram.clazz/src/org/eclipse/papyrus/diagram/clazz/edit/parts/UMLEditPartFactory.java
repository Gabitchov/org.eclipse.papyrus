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
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
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
		if (model instanceof View) {
			View view = (View) model;
			switch (UMLVisualIDRegistry.getVisualID(view)) {

			case ModelEditPart.VISUAL_ID:
				return new ModelEditPart(view);

			case Dependency2EditPart.VISUAL_ID:
				return new Dependency2EditPart(view);

			case AssociationClassEditPart.VISUAL_ID:
				return new AssociationClassEditPart(view);

			case AssociationClassNameEditPart.VISUAL_ID:
				return new AssociationClassNameEditPart(view);

			case AssociationClassName2EditPart.VISUAL_ID:
				return new AssociationClassName2EditPart(view);

			case AssociationClassQualifiedNameEditPart.VISUAL_ID:
				return new AssociationClassQualifiedNameEditPart(view);

			case Association2EditPart.VISUAL_ID:
				return new Association2EditPart(view);

			case InstanceSpecificationEditPart.VISUAL_ID:
				return new InstanceSpecificationEditPart(view);

			case InstanceSpecificationNameEditPart.VISUAL_ID:
				return new InstanceSpecificationNameEditPart(view);

			case InstanceSpecificationName2EditPart.VISUAL_ID:
				return new InstanceSpecificationName2EditPart(view);

			case InstanceSpecificationQualifiedNameEditPart.VISUAL_ID:
				return new InstanceSpecificationQualifiedNameEditPart(view);

			case ComponentEditPart.VISUAL_ID:
				return new ComponentEditPart(view);

			case ComponentNameEditPart.VISUAL_ID:
				return new ComponentNameEditPart(view);

			case ComponentName2EditPart.VISUAL_ID:
				return new ComponentName2EditPart(view);

			case ComponentQualifiedNameEditPart.VISUAL_ID:
				return new ComponentQualifiedNameEditPart(view);

			case SignalEditPart.VISUAL_ID:
				return new SignalEditPart(view);

			case SignalNameEditPart.VISUAL_ID:
				return new SignalNameEditPart(view);

			case SignalName2EditPart.VISUAL_ID:
				return new SignalName2EditPart(view);

			case SignalQualifiedNameEditPart.VISUAL_ID:
				return new SignalQualifiedNameEditPart(view);

			case InterfaceEditPart.VISUAL_ID:
				return new InterfaceEditPart(view);

			case InterfaceNameEditPart.VISUAL_ID:
				return new InterfaceNameEditPart(view);

			case InterfaceName2EditPart.VISUAL_ID:
				return new InterfaceName2EditPart(view);

			case InterfaceQualifiedNameEditPart.VISUAL_ID:
				return new InterfaceQualifiedNameEditPart(view);

			case Model2EditPart.VISUAL_ID:
				return new Model2EditPart(view);

			case ModelNameEditPart.VISUAL_ID:
				return new ModelNameEditPart(view);

			case ModelName2EditPart.VISUAL_ID:
				return new ModelName2EditPart(view);

			case ModelQualifiedNameEditPart.VISUAL_ID:
				return new ModelQualifiedNameEditPart(view);

			case EnumerationEditPart.VISUAL_ID:
				return new EnumerationEditPart(view);

			case EnumerationNameEditPart.VISUAL_ID:
				return new EnumerationNameEditPart(view);

			case EnumerationName2EditPart.VISUAL_ID:
				return new EnumerationName2EditPart(view);

			case EnumerationQualifiedNameEditPart.VISUAL_ID:
				return new EnumerationQualifiedNameEditPart(view);

			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);

			case PackageNameEditPart.VISUAL_ID:
				return new PackageNameEditPart(view);

			case PackageName2EditPart.VISUAL_ID:
				return new PackageName2EditPart(view);

			case PackageQualifiedNameEditPart.VISUAL_ID:
				return new PackageQualifiedNameEditPart(view);

			case ClassEditPart.VISUAL_ID:
				return new ClassEditPart(view);

			case ClassNameEditPart.VISUAL_ID:
				return new ClassNameEditPart(view);

			case ClassName2EditPart.VISUAL_ID:
				return new ClassName2EditPart(view);

			case ClassQualifiedNameEditPart.VISUAL_ID:
				return new ClassQualifiedNameEditPart(view);

			case PrimitiveTypeEditPart.VISUAL_ID:
				return new PrimitiveTypeEditPart(view);

			case PrimitiveTypeNameEditPart.VISUAL_ID:
				return new PrimitiveTypeNameEditPart(view);

			case PrimitiveTypeName2EditPart.VISUAL_ID:
				return new PrimitiveTypeName2EditPart(view);

			case PrimitiveTypeQualifiedNameEditPart.VISUAL_ID:
				return new PrimitiveTypeQualifiedNameEditPart(view);

			case DataTypeEditPart.VISUAL_ID:
				return new DataTypeEditPart(view);

			case DataTypeNameEditPart.VISUAL_ID:
				return new DataTypeNameEditPart(view);

			case DataTypeName2EditPart.VISUAL_ID:
				return new DataTypeName2EditPart(view);

			case DataTypeQualifiedNameEditPart.VISUAL_ID:
				return new DataTypeQualifiedNameEditPart(view);

			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);

			case ConstraintNameEditPart.VISUAL_ID:
				return new ConstraintNameEditPart(view);

			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);

			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);

			case PropertyEditPart.VISUAL_ID:
				return new PropertyEditPart(view);

			case SlotEditPart.VISUAL_ID:
				return new SlotEditPart(view);

			case OperationEditPart.VISUAL_ID:
				return new OperationEditPart(view);

			case Class2EditPart.VISUAL_ID:
				return new Class2EditPart(view);

			case RedefinableTemplateSignatureEditPart.VISUAL_ID:
				return new RedefinableTemplateSignatureEditPart(view);

			case TemplateParameterEditPart.VISUAL_ID:
				return new TemplateParameterEditPart(view);

			case Property2EditPart.VISUAL_ID:
				return new Property2EditPart(view);

			case Property3EditPart.VISUAL_ID:
				return new Property3EditPart(view);

			case Operation2EditPart.VISUAL_ID:
				return new Operation2EditPart(view);

			case Class3EditPart.VISUAL_ID:
				return new Class3EditPart(view);

			case InstanceSpecification2EditPart.VISUAL_ID:
				return new InstanceSpecification2EditPart(view);

			case InstanceSpecificationName3EditPart.VISUAL_ID:
				return new InstanceSpecificationName3EditPart(view);

			case InstanceSpecificationName4EditPart.VISUAL_ID:
				return new InstanceSpecificationName4EditPart(view);

			case InstanceSpecificationQualifiedName2EditPart.VISUAL_ID:
				return new InstanceSpecificationQualifiedName2EditPart(view);

			case Component2EditPart.VISUAL_ID:
				return new Component2EditPart(view);

			case ComponentName3EditPart.VISUAL_ID:
				return new ComponentName3EditPart(view);

			case ComponentName4EditPart.VISUAL_ID:
				return new ComponentName4EditPart(view);

			case ComponentQualifiedName2EditPart.VISUAL_ID:
				return new ComponentQualifiedName2EditPart(view);

			case Signal2EditPart.VISUAL_ID:
				return new Signal2EditPart(view);

			case SignalName3EditPart.VISUAL_ID:
				return new SignalName3EditPart(view);

			case SignalName4EditPart.VISUAL_ID:
				return new SignalName4EditPart(view);

			case SignalQualifiedName2EditPart.VISUAL_ID:
				return new SignalQualifiedName2EditPart(view);

			case Interface2EditPart.VISUAL_ID:
				return new Interface2EditPart(view);

			case InterfaceName3EditPart.VISUAL_ID:
				return new InterfaceName3EditPart(view);

			case InterfaceName4EditPart.VISUAL_ID:
				return new InterfaceName4EditPart(view);

			case InterfaceQualifiedName2EditPart.VISUAL_ID:
				return new InterfaceQualifiedName2EditPart(view);

			case Model3EditPart.VISUAL_ID:
				return new Model3EditPart(view);

			case ModelName3EditPart.VISUAL_ID:
				return new ModelName3EditPart(view);

			case ModelName4EditPart.VISUAL_ID:
				return new ModelName4EditPart(view);

			case ModelQualifiedName2EditPart.VISUAL_ID:
				return new ModelQualifiedName2EditPart(view);

			case Enumeration2EditPart.VISUAL_ID:
				return new Enumeration2EditPart(view);

			case EnumerationName3EditPart.VISUAL_ID:
				return new EnumerationName3EditPart(view);

			case EnumerationName4EditPart.VISUAL_ID:
				return new EnumerationName4EditPart(view);

			case EnumerationQualifiedName2EditPart.VISUAL_ID:
				return new EnumerationQualifiedName2EditPart(view);

			case EnumerationLiteralEditPart.VISUAL_ID:
				return new EnumerationLiteralEditPart(view);

			case Package2EditPart.VISUAL_ID:
				return new Package2EditPart(view);

			case PackageName3EditPart.VISUAL_ID:
				return new PackageName3EditPart(view);

			case PackageName4EditPart.VISUAL_ID:
				return new PackageName4EditPart(view);

			case PackageQualifiedName2EditPart.VISUAL_ID:
				return new PackageQualifiedName2EditPart(view);

			case Class4EditPart.VISUAL_ID:
				return new Class4EditPart(view);

			case ClassName3EditPart.VISUAL_ID:
				return new ClassName3EditPart(view);

			case ClassName4EditPart.VISUAL_ID:
				return new ClassName4EditPart(view);

			case ClassQualifiedName2EditPart.VISUAL_ID:
				return new ClassQualifiedName2EditPart(view);

			case ReceptionEditPart.VISUAL_ID:
				return new ReceptionEditPart(view);

			case Property4EditPart.VISUAL_ID:
				return new Property4EditPart(view);

			case Operation3EditPart.VISUAL_ID:
				return new Operation3EditPart(view);

			case Class5EditPart.VISUAL_ID:
				return new Class5EditPart(view);

			case PrimitiveType2EditPart.VISUAL_ID:
				return new PrimitiveType2EditPart(view);

			case PrimitiveTypeName3EditPart.VISUAL_ID:
				return new PrimitiveTypeName3EditPart(view);

			case PrimitiveTypeName4EditPart.VISUAL_ID:
				return new PrimitiveTypeName4EditPart(view);

			case PrimitiveTypeQualifiedName2EditPart.VISUAL_ID:
				return new PrimitiveTypeQualifiedName2EditPart(view);

			case DataType2EditPart.VISUAL_ID:
				return new DataType2EditPart(view);

			case DataTypeName3EditPart.VISUAL_ID:
				return new DataTypeName3EditPart(view);

			case DataTypeName4EditPart.VISUAL_ID:
				return new DataTypeName4EditPart(view);

			case DataTypeQualifiedName2EditPart.VISUAL_ID:
				return new DataTypeQualifiedName2EditPart(view);

			case Property5EditPart.VISUAL_ID:
				return new Property5EditPart(view);

			case Operation4EditPart.VISUAL_ID:
				return new Operation4EditPart(view);

			case Comment2EditPart.VISUAL_ID:
				return new Comment2EditPart(view);

			case CommentBody2EditPart.VISUAL_ID:
				return new CommentBody2EditPart(view);

			case Constraint2EditPart.VISUAL_ID:
				return new Constraint2EditPart(view);

			case ConstraintName2EditPart.VISUAL_ID:
				return new ConstraintName2EditPart(view);

			case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
				return new AssociationClassAttributeCompartmentEditPart(view);

			case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
				return new InstanceSpecificationSlotCompartmentEditPart(view);

			case ComponentAttributeCompartmentEditPart.VISUAL_ID:
				return new ComponentAttributeCompartmentEditPart(view);

			case ComponentOperationCompartmentEditPart.VISUAL_ID:
				return new ComponentOperationCompartmentEditPart(view);

			case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new ComponentNestedClassifierCompartmentEditPart(view);

			case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
				return new RedefinableTemplateSignatureTemplateParameterCompartmentEditPart(view);

			case SignalAttributeCompartmentEditPart.VISUAL_ID:
				return new SignalAttributeCompartmentEditPart(view);

			case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
				return new InterfaceAttributeCompartmentEditPart(view);

			case InterfaceOperationCompartmentEditPart.VISUAL_ID:
				return new InterfaceOperationCompartmentEditPart(view);

			case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new InterfaceNestedClassifierCompartmentEditPart(view);

			case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
				return new ModelPackageableElementCompartmentEditPart(view);

			case InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
				return new InstanceSpecificationSlotCompartment2EditPart(view);

			case ComponentAttributeCompartment2EditPart.VISUAL_ID:
				return new ComponentAttributeCompartment2EditPart(view);

			case ComponentOperationCompartment2EditPart.VISUAL_ID:
				return new ComponentOperationCompartment2EditPart(view);

			case ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
				return new ComponentNestedClassifierCompartment2EditPart(view);

			case SignalAttributeCompartment2EditPart.VISUAL_ID:
				return new SignalAttributeCompartment2EditPart(view);

			case InterfaceAttributeCompartment2EditPart.VISUAL_ID:
				return new InterfaceAttributeCompartment2EditPart(view);

			case InterfaceOperationCompartment2EditPart.VISUAL_ID:
				return new InterfaceOperationCompartment2EditPart(view);

			case InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
				return new InterfaceNestedClassifierCompartment2EditPart(view);

			case ModelPackageableElementCompartment2EditPart.VISUAL_ID:
				return new ModelPackageableElementCompartment2EditPart(view);

			case EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartment2EditPart(view);

			case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
				return new PackagePackageableElementCompartmentEditPart(view);

			case ClassAttributeCompartmentEditPart.VISUAL_ID:
				return new ClassAttributeCompartmentEditPart(view);

			case ClassOperationCompartmentEditPart.VISUAL_ID:
				return new ClassOperationCompartmentEditPart(view);

			case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
				return new ClassNestedClassifierCompartmentEditPart(view);

			case DataTypeAttributeCompartment2EditPart.VISUAL_ID:
				return new DataTypeAttributeCompartment2EditPart(view);

			case DataTypeOperationCompartment2EditPart.VISUAL_ID:
				return new DataTypeOperationCompartment2EditPart(view);

			case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartmentEditPart(view);

			case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
				return new PackagePackageableElementCompartment2EditPart(view);

			case ClassAttributeCompartment2EditPart.VISUAL_ID:
				return new ClassAttributeCompartment2EditPart(view);

			case ClassOperationCompartment2EditPart.VISUAL_ID:
				return new ClassOperationCompartment2EditPart(view);

			case ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
				return new ClassNestedClassifierCompartment2EditPart(view);

			case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
				return new DataTypeAttributeCompartmentEditPart(view);

			case DataTypeOperationCompartmentEditPart.VISUAL_ID:
				return new DataTypeOperationCompartmentEditPart(view);

			case CommentLinkDescriptorEditPart.VISUAL_ID:
				return new CommentLinkDescriptorEditPart(view);

			case AssociationClass2EditPart.VISUAL_ID:
				return new AssociationClass2EditPart(view);

			case AssociationEditPart.VISUAL_ID:
				return new AssociationEditPart(view);

			case AssociationNameEditPart.VISUAL_ID:
				return new AssociationNameEditPart(view);

			case AssociationName2EditPart.VISUAL_ID:
				return new AssociationName2EditPart(view);

			case AssociationName3EditPart.VISUAL_ID:
				return new AssociationName3EditPart(view);

			case AssociationName4EditPart.VISUAL_ID:
				return new AssociationName4EditPart(view);

			case AssociationName5EditPart.VISUAL_ID:
				return new AssociationName5EditPart(view);

			case AssociationName6EditPart.VISUAL_ID:
				return new AssociationName6EditPart(view);

			case Association3EditPart.VISUAL_ID:
				return new Association3EditPart(view);

			case GeneralizationEditPart.VISUAL_ID:
				return new GeneralizationEditPart(view);

			case GeneralizationIsSubstitutableEditPart.VISUAL_ID:
				return new GeneralizationIsSubstitutableEditPart(view);

			case InterfaceRealizationEditPart.VISUAL_ID:
				return new InterfaceRealizationEditPart(view);

			case InterfaceRealizationNameEditPart.VISUAL_ID:
				return new InterfaceRealizationNameEditPart(view);

			case InterfaceRealizationName2EditPart.VISUAL_ID:
				return new InterfaceRealizationName2EditPart(view);

			case SubstitutionEditPart.VISUAL_ID:
				return new SubstitutionEditPart(view);

			case SubstitutionNameEditPart.VISUAL_ID:
				return new SubstitutionNameEditPart(view);

			case SubstitutionName2EditPart.VISUAL_ID:
				return new SubstitutionName2EditPart(view);

			case RealizationEditPart.VISUAL_ID:
				return new RealizationEditPart(view);

			case RealizationNameEditPart.VISUAL_ID:
				return new RealizationNameEditPart(view);

			case RealizationName2EditPart.VISUAL_ID:
				return new RealizationName2EditPart(view);

			case AbstractionEditPart.VISUAL_ID:
				return new AbstractionEditPart(view);

			case AbstractionNameEditPart.VISUAL_ID:
				return new AbstractionNameEditPart(view);

			case AbstractionName2EditPart.VISUAL_ID:
				return new AbstractionName2EditPart(view);

			case UsageEditPart.VISUAL_ID:
				return new UsageEditPart(view);

			case UsageNameEditPart.VISUAL_ID:
				return new UsageNameEditPart(view);

			case UsageName2EditPart.VISUAL_ID:
				return new UsageName2EditPart(view);

			case DependencyEditPart.VISUAL_ID:
				return new DependencyEditPart(view);

			case DependencyNameEditPart.VISUAL_ID:
				return new DependencyNameEditPart(view);

			case DependencyName2EditPart.VISUAL_ID:
				return new DependencyName2EditPart(view);

			case Dependency3EditPart.VISUAL_ID:
				return new Dependency3EditPart(view);

			case DependencyName3EditPart.VISUAL_ID:
				return new DependencyName3EditPart(view);

			case DependencyName4EditPart.VISUAL_ID:
				return new DependencyName4EditPart(view);

			case ElementImportEditPart.VISUAL_ID:
				return new ElementImportEditPart(view);

			case ElementImportAliasEditPart.VISUAL_ID:
				return new ElementImportAliasEditPart(view);

			case ElementImportAlias2EditPart.VISUAL_ID:
				return new ElementImportAlias2EditPart(view);

			case PackageImportEditPart.VISUAL_ID:
				return new PackageImportEditPart(view);

			case PackageImportVisibilityEditPart.VISUAL_ID:
				return new PackageImportVisibilityEditPart(view);

			case PackageMergeEditPart.VISUAL_ID:
				return new PackageMergeEditPart(view);

			case ProfileApplicationEditPart.VISUAL_ID:
				return new ProfileApplicationEditPart(view);

			case CommentAnnotatedElementEditPart.VISUAL_ID:
				return new CommentAnnotatedElementEditPart(view);

			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);

			case TemplateBindingEditPart.VISUAL_ID:
				return new TemplateBindingEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);
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
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
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
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
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
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
