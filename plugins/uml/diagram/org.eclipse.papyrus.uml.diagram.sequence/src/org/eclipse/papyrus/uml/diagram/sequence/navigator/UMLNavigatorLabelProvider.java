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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.navigator;

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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLParserProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.InteractionOperand;
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
		case Message5EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Message", UMLElementTypes.Message_4007); //$NON-NLS-1$
		case MessageEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Message", UMLElementTypes.Message_4003); //$NON-NLS-1$
		case ConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Constraint", UMLElementTypes.Constraint_3008); //$NON-NLS-1$
		case TimeObservationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?TimeObservation", UMLElementTypes.TimeObservation_3020); //$NON-NLS-1$
		case CombinedFragment2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?CombinedFragment", UMLElementTypes.CombinedFragment_3018); //$NON-NLS-1$
		case GeneralOrderingEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?GeneralOrdering", UMLElementTypes.GeneralOrdering_4012); //$NON-NLS-1$
		case StateInvariantEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?StateInvariant", UMLElementTypes.StateInvariant_3017); //$NON-NLS-1$
		case InteractionUseEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InteractionUse", UMLElementTypes.InteractionUse_3002); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Comment", UMLElementTypes.Comment_3009); //$NON-NLS-1$
		case Message3EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Message", UMLElementTypes.Message_4005); //$NON-NLS-1$
		case DurationConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?DurationConstraint", UMLElementTypes.DurationConstraint_3021); //$NON-NLS-1$
		case TimeConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?TimeConstraint", UMLElementTypes.TimeConstraint_3019); //$NON-NLS-1$
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ConsiderIgnoreFragment", UMLElementTypes.ConsiderIgnoreFragment_3007); //$NON-NLS-1$
		case ContinuationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Continuation", UMLElementTypes.Continuation_3016); //$NON-NLS-1$
		case LifelineEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Lifeline", UMLElementTypes.Lifeline_3001); //$NON-NLS-1$
		case Message4EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Message", UMLElementTypes.Message_4006); //$NON-NLS-1$
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?BehaviorExecutionSpecification", UMLElementTypes.BehaviorExecutionSpecification_3003); //$NON-NLS-1$
		case InteractionOperandEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InteractionOperand", UMLElementTypes.InteractionOperand_3005); //$NON-NLS-1$
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Constraint?constrainedElement", UMLElementTypes.ConstraintConstrainedElement_4011); //$NON-NLS-1$
		case Message6EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Message", UMLElementTypes.Message_4008); //$NON-NLS-1$
		case Message7EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Message", UMLElementTypes.Message_4009); //$NON-NLS-1$
		case DurationObservationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?DurationObservation", UMLElementTypes.DurationObservation_3024); //$NON-NLS-1$
		case PackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/4.0.0/UML?Package", UMLElementTypes.Package_1000); //$NON-NLS-1$
		case Message2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Message", UMLElementTypes.Message_4004); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_4010); //$NON-NLS-1$
		case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?DestructionOccurrenceSpecification", UMLElementTypes.DestructionOccurrenceSpecification_3022); //$NON-NLS-1$
		case InteractionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/4.0.0/UML?Interaction", UMLElementTypes.Interaction_2001); //$NON-NLS-1$
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActionExecutionSpecification", UMLElementTypes.ActionExecutionSpecification_3006); //$NON-NLS-1$
		case DurationConstraintInMessageEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?DurationConstraint", UMLElementTypes.DurationConstraint_3023); //$NON-NLS-1$
		case CombinedFragmentEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?CombinedFragment", UMLElementTypes.CombinedFragment_3004); //$NON-NLS-1$
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
		case Message5EditPart.VISUAL_ID:
			return getMessage_4007Text(view);
		case MessageEditPart.VISUAL_ID:
			return getMessage_4003Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3008Text(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_3020Text(view);
		case CombinedFragment2EditPart.VISUAL_ID:
			return getCombinedFragment_3018Text(view);
		case GeneralOrderingEditPart.VISUAL_ID:
			return getGeneralOrdering_4012Text(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getStateInvariant_3017Text(view);
		case InteractionUseEditPart.VISUAL_ID:
			return getInteractionUse_3002Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3009Text(view);
		case Message3EditPart.VISUAL_ID:
			return getMessage_4005Text(view);
		case DurationConstraintEditPart.VISUAL_ID:
			return getDurationConstraint_3021Text(view);
		case TimeConstraintEditPart.VISUAL_ID:
			return getTimeConstraint_3019Text(view);
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return getConsiderIgnoreFragment_3007Text(view);
		case ContinuationEditPart.VISUAL_ID:
			return getContinuation_3016Text(view);
		case LifelineEditPart.VISUAL_ID:
			return getLifeline_3001Text(view);
		case Message4EditPart.VISUAL_ID:
			return getMessage_4006Text(view);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getBehaviorExecutionSpecification_3003Text(view);
		case InteractionOperandEditPart.VISUAL_ID:
			return getInteractionOperand_3005Text(view);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getConstraintConstrainedElement_4011Text(view);
		case Message6EditPart.VISUAL_ID:
			return getMessage_4008Text(view);
		case Message7EditPart.VISUAL_ID:
			return getMessage_4009Text(view);
		case DurationObservationEditPart.VISUAL_ID:
			return getDurationObservation_3024Text(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000Text(view);
		case Message2EditPart.VISUAL_ID:
			return getMessage_4004Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_4010Text(view);
		case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
			return getDestructionOccurrenceSpecification_3022Text(view);
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_2001Text(view);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return getActionExecutionSpecification_3006Text(view);
		case DurationConstraintInMessageEditPart.VISUAL_ID:
			return getDurationConstraint_3023Text(view);
		case CombinedFragmentEditPart.VISUAL_ID:
			return getCombinedFragment_3004Text(view);
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
	private String getInteraction_2001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Interaction_2001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InteractionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLifeline_3001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Lifeline_3001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBehaviorExecutionSpecification_3003Text(View view) {
		BehaviorExecutionSpecification domainModelElement = (BehaviorExecutionSpecification)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStateInvariant_3017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.StateInvariant_3017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(StateInvariantNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCombinedFragment_3018Text(View view) {
		CombinedFragment domainModelElement = (CombinedFragment)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTimeConstraint_3019Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.TimeConstraint_3019, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(TimeConstraintLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTimeObservation_3020Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.TimeObservation_3020, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(TimeObservationLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDurationConstraint_3021Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DurationConstraint_3021, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DurationConstraintLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionExecutionSpecification_3006Text(View view) {
		ActionExecutionSpecification domainModelElement = (ActionExecutionSpecification)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteractionUse_3002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InteractionUse_3002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InteractionUseNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCombinedFragment_3004Text(View view) {
		CombinedFragment domainModelElement = (CombinedFragment)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteractionOperand_3005Text(View view) {
		InteractionOperand domainModelElement = (InteractionOperand)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getContinuation_3016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Continuation_3016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ContinuationNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_3009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_3009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDurationConstraint_3023Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DurationConstraint_3023, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DurationConstraintInMessageLabelEditPart.VISUAL_ID));
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
	private String getDurationObservation_3024Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DurationObservation_3024, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DurationObservationLabelEditPart.VISUAL_ID));
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
	private String getConsiderIgnoreFragment_3007Text(View view) {
		ConsiderIgnoreFragment domainModelElement = (ConsiderIgnoreFragment)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_4003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_4003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(MessageNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_4004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_4004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(MessageName2EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_4005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_4005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(MessageName3EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_4006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_4006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(MessageName4EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_4007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_4007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(MessageName5EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_4008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_4008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(MessageName6EditPart.VISUAL_ID));
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
	private String getMessage_4009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_4009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(MessageName7EditPart.VISUAL_ID));
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
	private String getCommentAnnotatedElement_4010Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDestructionOccurrenceSpecification_3022Text(View view) {
		DestructionOccurrenceSpecification domainModelElement = (DestructionOccurrenceSpecification)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGeneralOrdering_4012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.GeneralOrdering_4012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(GeneralOrderingAppliedStereotypeEditPart.VISUAL_ID));
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
	private String getConstraintConstrainedElement_4011Text(View view) {
		return ""; //$NON-NLS-1$
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
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}
}
