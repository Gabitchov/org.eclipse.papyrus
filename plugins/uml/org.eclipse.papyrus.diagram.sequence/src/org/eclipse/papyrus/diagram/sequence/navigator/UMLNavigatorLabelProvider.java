/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
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
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Package;

import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentInteractionOperatorEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Interaction2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.providers.UMLParserProvider;

/**
 * @generated
 */
public class UMLNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UMLDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		UMLDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof UMLNavigatorItem
				&& !isOwnView(((UMLNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return UMLDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.eclipse.org/uml2/2.1.0/UML?Package", UMLElementTypes.Package_79); //$NON-NLS-1$
		case InteractionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Interaction", UMLElementTypes.Interaction_1001); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Comment", UMLElementTypes.Comment_2005); //$NON-NLS-1$
		case Interaction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Interaction", UMLElementTypes.Interaction_2001); //$NON-NLS-1$
		case LifelineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Lifeline", UMLElementTypes.Lifeline_2002); //$NON-NLS-1$
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?BehaviorExecutionSpecification", UMLElementTypes.BehaviorExecutionSpecification_2003); //$NON-NLS-1$
		case CombinedFragmentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?CombinedFragment", UMLElementTypes.CombinedFragment_2004); //$NON-NLS-1$
		case MessageEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Message", UMLElementTypes.Message_3001); //$NON-NLS-1$
		case Message2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Message", UMLElementTypes.Message_3002); //$NON-NLS-1$
		case Message3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Message", UMLElementTypes.Message_3003); //$NON-NLS-1$
		case Message4EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Message", UMLElementTypes.Message_3004); //$NON-NLS-1$
		case Message5EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Message", UMLElementTypes.Message_3005); //$NON-NLS-1$
		case Message6EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Message", UMLElementTypes.Message_3006); //$NON-NLS-1$
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Element?ownedComment", UMLElementTypes.ElementOwnedComment_3007); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_3008); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UMLDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& UMLElementTypes.isKnownElementType(elementType)) {
			image = UMLElementTypes.getImage(elementType);
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
	@Override
	public String getText(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
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
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_79Text(view);
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_1001Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2005Text(view);
		case Interaction2EditPart.VISUAL_ID:
			return getInteraction_2001Text(view);
		case LifelineEditPart.VISUAL_ID:
			return getLifeline_2002Text(view);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getBehaviorExecutionSpecification_2003Text(view);
		case CombinedFragmentEditPart.VISUAL_ID:
			return getCombinedFragment_2004Text(view);
		case MessageEditPart.VISUAL_ID:
			return getMessage_3001Text(view);
		case Message2EditPart.VISUAL_ID:
			return getMessage_3002Text(view);
		case Message3EditPart.VISUAL_ID:
			return getMessage_3003Text(view);
		case Message4EditPart.VISUAL_ID:
			return getMessage_3004Text(view);
		case Message5EditPart.VISUAL_ID:
			return getMessage_3005Text(view);
		case Message6EditPart.VISUAL_ID:
			return getMessage_3006Text(view);
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return getElementOwnedComment_3007Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_3008Text(view);
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
			UMLDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 79); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteraction_1001Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Interaction_1001,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(InteractionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInteraction_2001Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Interaction_2001,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(InteractionName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getLifeline_2002Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Lifeline_2002,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getBehaviorExecutionSpecification_2003Text(View view) {
		BehaviorExecutionSpecification domainModelElement = (BehaviorExecutionSpecification) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCombinedFragment_2004Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.CombinedFragment_2004,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(CombinedFragmentInteractionOperatorEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getComment_2005Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Comment_2005, (view.getElement() != null ? view
						.getElement() : view), UMLVisualIDRegistry
						.getType(CommentBodyEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMessage_3001Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Message_3001, (view.getElement() != null ? view
						.getElement() : view), UMLVisualIDRegistry
						.getType(MessageNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMessage_3002Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Message_3002, (view.getElement() != null ? view
						.getElement() : view), UMLVisualIDRegistry
						.getType(MessageName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMessage_3003Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Message_3003, (view.getElement() != null ? view
						.getElement() : view), UMLVisualIDRegistry
						.getType(MessageName3EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMessage_3004Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Message_3004, (view.getElement() != null ? view
						.getElement() : view), UMLVisualIDRegistry
						.getType(MessageName4EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMessage_3005Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Message_3005, (view.getElement() != null ? view
						.getElement() : view), UMLVisualIDRegistry
						.getType(MessageName5EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMessage_3006Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Message_3006, (view.getElement() != null ? view
						.getElement() : view), UMLVisualIDRegistry
						.getType(MessageName6EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getElementOwnedComment_3007Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_3008Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
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
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry
				.getModelID(view));
	}

}
