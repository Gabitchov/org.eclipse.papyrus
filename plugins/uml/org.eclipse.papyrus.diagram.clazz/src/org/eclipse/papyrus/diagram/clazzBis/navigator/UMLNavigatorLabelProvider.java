package org.eclipse.papyrus.diagram.clazzBis.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;

/**
 * @generated
 */
public class UMLNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem && !isOwnView(((org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup) {
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup group = (org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup) element;
			return org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem) {
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem navigatorItem = (org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/2.1.0/UML?Package", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_79); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Dependency", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?AssociationClass", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Association", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?InstanceSpecification", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Component", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Signal", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Interface", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Model", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Enumeration", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Package", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Class", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?PrimitiveType", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?DataType", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Constraint", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Comment", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_1015); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Property", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2001); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Slot", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Slot_2002); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Operation", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2003); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Class", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2004); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?RedefinableTemplateSignature", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?TemplateParameter", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateParameter_2006); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Property", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2007); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Property", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2008); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Operation", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2009); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Class", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2010); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?InstanceSpecification", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Component", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Signal", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Interface", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Model", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Enumeration", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?EnumerationLiteral", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.EnumerationLiteral_2017); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Package", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Class", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Reception", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Reception_2020); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Property", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2021); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Operation", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2022); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Class", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2023); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?PrimitiveType", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?DataType", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Property", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2026); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Operation", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2027); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Comment", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Constraint", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID:
			return getImage("Navigator?Link?CommentLinkDescriptor", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Link_3001); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?AssociationClass", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Association", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Association", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Generalization", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?InterfaceRealization", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Substitution", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Realization", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Abstraction", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Usage", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Dependency", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Dependency", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?ElementImport", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?PackageImport", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?PackageMerge", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageMerge_3015); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?ProfileApplication", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ProfileApplication_3016); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Comment?annotatedElement", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Constraint?constrainedElement", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018); //$NON-NLS-1$
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?TemplateBinding", org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.isKnownElementType(elementType)) {
			image = org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup) {
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup group = (org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem) {
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem navigatorItem = (org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID:
			return getPackage_79Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_1001Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
			return getAssociationClass_1002Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_1003Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_1004Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponent_1005Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			return getSignal_1006Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			return getInterface_1007Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			return getModel_1008Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
			return getEnumeration_1009Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			return getPackage_1010Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_1011Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_1012Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			return getDataType_1013Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
			return getConstraint_1014Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
			return getComment_1015Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
			return getProperty_2001Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID:
			return getSlot_2002Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_2003Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
			return getClass_2004Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_2005Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_2006Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
			return getProperty_2007Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
			return getProperty_2008Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
			return getOperation_2009Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
			return getClass_2010Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
			return getInstanceSpecification_2011Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			return getComponent_2012Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			return getSignal_2013Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			return getInterface_2014Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			return getModel_2015Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_2016Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_2017Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			return getPackage_2018Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			return getClass_2019Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
			return getReception_2020Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
			return getProperty_2021Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
			return getOperation_2022Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
			return getClass_2023Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
			return getPrimitiveType_2024Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			return getDataType_2025Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
			return getProperty_2026Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
			return getOperation_2027Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
			return getComment_2028Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
			return getConstraint_2029Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID:
			return getLink_3001Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
			return getAssociationClass_3002Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_3003Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_3004Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_3005Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_3006Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_3007Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			return getRealization_3008Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			return getAbstraction_3009Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			return getUsage_3010Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			return getDependency_3011Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			return getDependency_3012Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			return getElementImport_3013Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			return getPackageImport_3014Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_3015Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_3016Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_3017Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getConstraintConstrainedElement_3018Text(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			return getTemplateBinding_3019Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_79Text(View view) {
		Package domainModelElement = (Package) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 79); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDependency_1001Text(View view) {
		Dependency domainModelElement = (Dependency) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociationClass_1002Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociation_1003Text(View view) {
		Association domainModelElement = (Association) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInstanceSpecification_1004Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponent_1005Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSignal_1006Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterface_1007Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModel_1008Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4048); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEnumeration_1009Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4051); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_1010Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4054); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_1011Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4057); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPrimitiveType_1012Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4060); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataType_1013Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4063); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_1014Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4066); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_1015Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_1015,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBodyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4067); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_2001Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2001,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSlot_2002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOperation_2003Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2003,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_2004Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2004,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRedefinableTemplateSignature_2005Text(View view) {
		RedefinableTemplateSignature domainModelElement = (RedefinableTemplateSignature) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTemplateParameter_2006Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateParameter_2006, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_2007Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2007,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_2008Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2008,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_2009Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2009,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_2010Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2010,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInstanceSpecification_2011Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponent_2012Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSignal_2013Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterface_2014Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModel_2015Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4045); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEnumeration_2016Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEnumerationLiteral_2017Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.EnumerationLiteral_2017, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_2018Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4042); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_2019Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getReception_2020Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Reception_2020,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_2021Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2021,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_2022Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2022,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_2023Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2023,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPrimitiveType_2024Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4034); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataType_2025Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4037); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_2026Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2026,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2026); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_2027Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2027,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_2028Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBody2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_2029Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4041); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLink_3001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAssociationClass_3002Text(View view) {
		AssociationClass domainModelElement = (AssociationClass) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociation_3003Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4068); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociation_3004Text(View view) {
		Association domainModelElement = (Association) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGeneralization_3005Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationIsSubstitutableEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4074); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterfaceRealization_3006Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4075); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSubstitution_3007Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4077); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRealization_3008Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4079); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAbstraction_3009Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4081); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUsage_3010Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4083); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDependency_3011Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4085); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDependency_3012Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012,
				view.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4087); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getElementImport_3013Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAliasEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4089); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackageImport_3014Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportVisibilityEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4091); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackageMerge_3015Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProfileApplication_3016Text(View view) {
		ProfileApplication domainModelElement = (ProfileApplication) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isStrict());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_3017Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getConstraintConstrainedElement_3018Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTemplateBinding_3019Text(View view) {
		IParser parser = org.eclipse.papyrus.diagram.clazzBis.providers.UMLParserProvider.getParser(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019, view
				.getElement() != null ? view.getElement() : view, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4092); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getModelID(view));
	}

}
