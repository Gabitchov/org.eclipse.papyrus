package org.eclipse.papyrus.diagram.statemachine.navigator;

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
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReference2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate10EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate11EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate12EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate13EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate14EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate8EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate9EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Region2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachine2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLParserProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;


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
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		UMLDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if(element instanceof UMLNavigatorItem
				&& !isOwnView(((UMLNavigatorItem)element).getView())) {
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
		if(element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup)element;
			return UMLDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if(element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem)element;
			if(!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if(element instanceof IAdaptable) {
			View view = (View)((IAdaptable)element).getAdapter(View.class);
			if(view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/2.1.0/UML?Package", UMLElementTypes.Package_79); //$NON-NLS-1$
		case StateMachine2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?StateMachine", UMLElementTypes.StateMachine_1001); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Comment", UMLElementTypes.Comment_2024); //$NON-NLS-1$
		case RegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Region", UMLElementTypes.Region_2001); //$NON-NLS-1$
		case StateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?State", UMLElementTypes.State_2002); //$NON-NLS-1$
		case State2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?State", UMLElementTypes.State_2003); //$NON-NLS-1$
		case Region2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Region", UMLElementTypes.Region_2004); //$NON-NLS-1$
		case State3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?State", UMLElementTypes.State_2005); //$NON-NLS-1$
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ConnectionPointReference", UMLElementTypes.ConnectionPointReference_2006); //$NON-NLS-1$
		case ConnectionPointReference2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ConnectionPointReference", UMLElementTypes.ConnectionPointReference_2007); //$NON-NLS-1$
		case FinalStateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?FinalState", UMLElementTypes.FinalState_2008); //$NON-NLS-1$
		case PseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2009); //$NON-NLS-1$
		case Pseudostate2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2010); //$NON-NLS-1$
		case Pseudostate3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2011); //$NON-NLS-1$
		case Pseudostate4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2012); //$NON-NLS-1$
		case Pseudostate5EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2013); //$NON-NLS-1$
		case Pseudostate6EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2014); //$NON-NLS-1$
		case Pseudostate7EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2015); //$NON-NLS-1$
		case Pseudostate8EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2016); //$NON-NLS-1$
		case State4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?State", UMLElementTypes.State_2017); //$NON-NLS-1$
		case Pseudostate9EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2018); //$NON-NLS-1$
		case Pseudostate10EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2019); //$NON-NLS-1$
		case Pseudostate11EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2020); //$NON-NLS-1$
		case Pseudostate12EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2021); //$NON-NLS-1$
		case Pseudostate13EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2022); //$NON-NLS-1$
		case Pseudostate14EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_2023); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Transition", UMLElementTypes.Transition_3001); //$NON-NLS-1$
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Element?ownedComment", UMLElementTypes.ElementOwnedComment_3002); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_3003); //$NON-NLS-1$
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
		if(image == null && elementType != null
				&& UMLElementTypes.isKnownElementType(elementType)) {
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
	@Override
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

		// Due to plugin.xml content will be called only for "own" views
		if(element instanceof IAdaptable) {
			View view = (View)((IAdaptable)element).getAdapter(View.class);
			if(view != null && isOwnView(view)) {
				return getText(view);
			}
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
		case StateMachineEditPart.VISUAL_ID:
			return getPackage_79Text(view);
		case StateMachine2EditPart.VISUAL_ID:
			return getStateMachine_1001Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2024Text(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_2002Text(view);
		case State2EditPart.VISUAL_ID:
			return getState_2003Text(view);
		case Region2EditPart.VISUAL_ID:
			return getRegion_2004Text(view);
		case State3EditPart.VISUAL_ID:
			return getState_2005Text(view);
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_2006Text(view);
		case ConnectionPointReference2EditPart.VISUAL_ID:
			return getConnectionPointReference_2007Text(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_2008Text(view);
		case PseudostateEditPart.VISUAL_ID:
			return getPseudostate_2009Text(view);
		case Pseudostate2EditPart.VISUAL_ID:
			return getPseudostate_2010Text(view);
		case Pseudostate3EditPart.VISUAL_ID:
			return getPseudostate_2011Text(view);
		case Pseudostate4EditPart.VISUAL_ID:
			return getPseudostate_2012Text(view);
		case Pseudostate5EditPart.VISUAL_ID:
			return getPseudostate_2013Text(view);
		case Pseudostate6EditPart.VISUAL_ID:
			return getPseudostate_2014Text(view);
		case Pseudostate7EditPart.VISUAL_ID:
			return getPseudostate_2015Text(view);
		case Pseudostate8EditPart.VISUAL_ID:
			return getPseudostate_2016Text(view);
		case State4EditPart.VISUAL_ID:
			return getState_2017Text(view);
		case Pseudostate9EditPart.VISUAL_ID:
			return getPseudostate_2018Text(view);
		case Pseudostate10EditPart.VISUAL_ID:
			return getPseudostate_2019Text(view);
		case Pseudostate11EditPart.VISUAL_ID:
			return getPseudostate_2020Text(view);
		case Pseudostate12EditPart.VISUAL_ID:
			return getPseudostate_2021Text(view);
		case Pseudostate13EditPart.VISUAL_ID:
			return getPseudostate_2022Text(view);
		case Pseudostate14EditPart.VISUAL_ID:
			return getPseudostate_2023Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_3001Text(view);
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return getElementOwnedComment_3002Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_3003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_79Text(View view) {
		Package domainModelElement = (Package)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 79); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStateMachine_1001Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.StateMachine_1001,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(StateMachineNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getComment_2024Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Comment_2024, (view.getElement() != null ? view
				.getElement() : view), UMLVisualIDRegistry
				.getType(CommentBodyEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getRegion_2001Text(View view) {
		Region domainModelElement = (Region)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_2002Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.State_2002, (view.getElement() != null ? view
				.getElement() : view), UMLVisualIDRegistry
				.getType(StateNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getState_2003Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.State_2003, (view.getElement() != null ? view
				.getElement() : view), UMLVisualIDRegistry
				.getType(StateName3EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getRegion_2004Text(View view) {
		Region domainModelElement = (Region)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_2005Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.State_2005, (view.getElement() != null ? view
				.getElement() : view), UMLVisualIDRegistry
				.getType(StateName5EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getConnectionPointReference_2006Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ConnectionPointReference_2006,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
				.getType(ConnectionPointReferenceNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getConnectionPointReference_2007Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ConnectionPointReference_2007,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
				.getType(ConnectionPointReferenceName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getFinalState_2008Text(View view) {
		FinalState domainModelElement = (FinalState)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_2009Text(View view) {
		Pseudostate domainModelElement = (Pseudostate)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_2010Text(View view) {
		Pseudostate domainModelElement = (Pseudostate)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_2011Text(View view) {
		Pseudostate domainModelElement = (Pseudostate)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_2012Text(View view) {
		Pseudostate domainModelElement = (Pseudostate)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_2013Text(View view) {
		Pseudostate domainModelElement = (Pseudostate)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_2014Text(View view) {
		Pseudostate domainModelElement = (Pseudostate)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_2015Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Pseudostate_2015,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(PseudostateName7EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPseudostate_2016Text(View view) {
		Pseudostate domainModelElement = (Pseudostate)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_2017Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.State_2017, (view.getElement() != null ? view
				.getElement() : view), UMLVisualIDRegistry
				.getType(StateName7EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPseudostate_2018Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Pseudostate_2018,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(PseudostateNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPseudostate_2019Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Pseudostate_2019,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(PseudostateName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPseudostate_2020Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Pseudostate_2020,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(PseudostateName3EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPseudostate_2021Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Pseudostate_2021,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(PseudostateName4EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPseudostate_2022Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Pseudostate_2022,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(PseudostateName5EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPseudostate_2023Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Pseudostate_2023,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(PseudostateName6EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getTransition_3001Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Transition_3001,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(TransitionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if(parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getElementOwnedComment_3002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_3003Text(View view) {
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
		return StateMachineEditPart.MODEL_ID.equals(UMLVisualIDRegistry
				.getModelID(view));
	}

}
