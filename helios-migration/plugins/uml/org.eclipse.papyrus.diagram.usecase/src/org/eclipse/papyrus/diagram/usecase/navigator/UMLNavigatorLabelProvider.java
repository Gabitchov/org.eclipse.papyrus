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
package org.eclipse.papyrus.diagram.usecase.navigator;

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
import org.eclipse.papyrus.diagram.usecase.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AbstractionNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypePackageImportEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypePackageMergeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBody2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Component2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Constraint3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendsLink_fixedEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeLink_fixedEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageNameEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.RealizationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UsageNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseNameEditPart;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.usecase.providers.UMLParserProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */
public class UMLNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if(element instanceof UMLNavigatorItem && !isOwnView(((UMLNavigatorItem)element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if(element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup)element;
			return UMLDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if(element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem)element;
			if(!isOwnView(navigatorItem.getView())) {
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
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case UseCaseDiagramEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_1000); //$NON-NLS-1$
		case ActorEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Actor", UMLElementTypes.Actor_2011); //$NON-NLS-1$
		case Actor2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Actor", UMLElementTypes.Actor_2012); //$NON-NLS-1$
		case UseCaseEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?UseCase", UMLElementTypes.UseCase_2013); //$NON-NLS-1$
		case UseCase2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?UseCase", UMLElementTypes.UseCase_2014); //$NON-NLS-1$
		case ComponentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Component", UMLElementTypes.Component_2015); //$NON-NLS-1$
		case PackageEditPartTN.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2016); //$NON-NLS-1$
		case ConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_2017); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Comment", UMLElementTypes.Comment_2018); //$NON-NLS-1$
		case ExtensionPointEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ExtensionPoint", UMLElementTypes.ExtensionPoint_3007); //$NON-NLS-1$
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ExtensionPoint", UMLElementTypes.ExtensionPoint_3008); //$NON-NLS-1$
		case UseCase3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?UseCase", UMLElementTypes.UseCase_3009); //$NON-NLS-1$
		case Component2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Component", UMLElementTypes.Component_3016); //$NON-NLS-1$
		case Comment2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Comment", UMLElementTypes.Comment_3015); //$NON-NLS-1$
		case Constraint2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_3017); //$NON-NLS-1$
		case Actor4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Actor", UMLElementTypes.Actor_3018); //$NON-NLS-1$
		case Constraint3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_3010); //$NON-NLS-1$
		case Actor3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Actor", UMLElementTypes.Actor_3011); //$NON-NLS-1$
		case UseCase4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?UseCase", UMLElementTypes.UseCase_3012); //$NON-NLS-1$
		case Component3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Component", UMLElementTypes.Component_3013); //$NON-NLS-1$
		case PackageEditPartCN.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_3014); //$NON-NLS-1$
		case IncludeEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Include", UMLElementTypes.Include_4008); //$NON-NLS-1$
		case ExtendEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Extend", UMLElementTypes.Extend_4009); //$NON-NLS-1$
		case GeneralizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Generalization", UMLElementTypes.Generalization_4010); //$NON-NLS-1$
		case AssociationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Association", UMLElementTypes.Association_4011); //$NON-NLS-1$
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Constraint?constrainedElement", UMLElementTypes.ConstraintConstrainedElement_4012); //$NON-NLS-1$
		case DependencyEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Dependency", UMLElementTypes.Dependency_4013); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_4014); //$NON-NLS-1$
		case AbstractionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Abstraction", UMLElementTypes.Abstraction_4015); //$NON-NLS-1$
		case UsageEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Usage", UMLElementTypes.Usage_4016); //$NON-NLS-1$
		case RealizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Realization", UMLElementTypes.Realization_4017); //$NON-NLS-1$
		case PackageMergeEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?PackageMerge", UMLElementTypes.PackageMerge_4018); //$NON-NLS-1$
		case PackageImportEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?PackageImport", UMLElementTypes.PackageImport_4019); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UMLDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if(image == null && elementType != null && UMLElementTypes.isKnownElementType(elementType)) {
			image = UMLElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if(image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if(element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup)element;
			return group.getGroupName();
		}

		if(element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem)element;
			if(!isOwnView(navigatorItem.getView())) {
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
		if(view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case UseCaseDiagramEditPart.VISUAL_ID:
			return getPackage_1000Text(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2011Text(view);
		case Actor2EditPart.VISUAL_ID:
			return getActor_2012Text(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2013Text(view);
		case UseCase2EditPart.VISUAL_ID:
			return getUseCase_2014Text(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2015Text(view);
		case PackageEditPartTN.VISUAL_ID:
			return getPackage_2016Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2017Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2018Text(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3007Text(view);
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3008Text(view);
		case UseCase3EditPart.VISUAL_ID:
			return getUseCase_3009Text(view);
		case Component2EditPart.VISUAL_ID:
			return getComponent_3016Text(view);
		case Comment2EditPart.VISUAL_ID:
			return getComment_3015Text(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3017Text(view);
		case Actor4EditPart.VISUAL_ID:
			return getActor_3018Text(view);
		case Constraint3EditPart.VISUAL_ID:
			return getConstraint_3010Text(view);
		case Actor3EditPart.VISUAL_ID:
			return getActor_3011Text(view);
		case UseCase4EditPart.VISUAL_ID:
			return getUseCase_3012Text(view);
		case Component3EditPart.VISUAL_ID:
			return getComponent_3013Text(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3014Text(view);
		case IncludeEditPart.VISUAL_ID:
			return getInclude_4008Text(view);
		case ExtendEditPart.VISUAL_ID:
			return getExtend_4009Text(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4010Text(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4011Text(view);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getConstraintConstrainedElement_4012Text(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4013Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_4014Text(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4015Text(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4016Text(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4017Text(view);
		case PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_4018Text(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_4019Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_1000Text(View view) {
		Package domainModelElement = (Package)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActor_2011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Actor_2011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActorNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActor_2012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Actor_2012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActorName2EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUseCase_2013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.UseCase_2013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UseCaseNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUseCase_2014Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.UseCase_2014, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UseCaseName2EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponent_2015Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Component_2015, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ComponentNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_2016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_2016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageNameEditPartTN.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_2017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_2017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5026); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_2018Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_2018, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExtensionPoint_3007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExtensionPoint_3007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExtensionPoint_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExtensionPoint_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ExtensionPoint2EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUseCase_3009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.UseCase_3009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UseCaseName3EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponent_3016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Component_3016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ComponentName2EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5030); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_3015Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_3015, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CommentBody2EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_3017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_3017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConstraintName2EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5029); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActor_3018Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Actor_3018, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActorName4EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_3010Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_3010, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConstraintName3EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActor_3011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Actor_3011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActorName3EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUseCase_3012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.UseCase_3012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UseCaseName4EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponent_3013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Component_3013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ComponentName3EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_3014Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_3014, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageNameEditPartCN.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInclude_4008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Include_4008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(IncludeLink_fixedEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExtend_4009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Extend_4009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ExtendsLink_fixedEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGeneralization_4010Text(View view) {
		Generalization domainModelElement = (Generalization)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.isSubstitutable());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociation_4011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Association_4011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(AssociationNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraintConstrainedElement_4012Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDependency_4013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Dependency_4013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_4014Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAbstraction_4015Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Abstraction_4015, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(AbstractionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUsage_4016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Usage_4016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UsageNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRealization_4017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Realization_4017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(RealizationNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackageMerge_4018Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.PackageMerge_4018, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(AppliedStereotypePackageMergeEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 0); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackageImport_4019Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.PackageImport_4019, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(AppliedStereotypePackageImportEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6017); //$NON-NLS-1$
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
		return UseCaseDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

}
