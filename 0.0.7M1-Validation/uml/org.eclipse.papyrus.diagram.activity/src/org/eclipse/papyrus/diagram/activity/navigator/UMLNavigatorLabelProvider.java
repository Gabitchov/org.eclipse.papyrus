package org.eclipse.papyrus.diagram.activity.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
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
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventAction2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartition2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CreateObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CreateObjectActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin5EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin6EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName5EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName6EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectNodeSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueAction2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinNameEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.activity.providers.UMLParserProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.Package;

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
		case ActivityEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Activity", UMLElementTypes.Activity_1001); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?Comment", UMLElementTypes.Comment_2034); //$NON-NLS-1$
		case SendObjectActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?SendObjectAction", UMLElementTypes.SendObjectAction_2001); //$NON-NLS-1$
		case InputPinEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?InputPin", UMLElementTypes.InputPin_2002); //$NON-NLS-1$
		case InputPin2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?InputPin", UMLElementTypes.InputPin_2003); //$NON-NLS-1$
		case ValuePinEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ValuePin", UMLElementTypes.ValuePin_2004); //$NON-NLS-1$
		case SendSignalActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?SendSignalAction", UMLElementTypes.SendSignalAction_2005); //$NON-NLS-1$
		case InputPin3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?InputPin", UMLElementTypes.InputPin_2006); //$NON-NLS-1$
		case AcceptEventActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_2007); //$NON-NLS-1$
		case OutputPinEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?OutputPin", UMLElementTypes.OutputPin_2008); //$NON-NLS-1$
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ActivityFinalNode", UMLElementTypes.ActivityFinalNode_2009); //$NON-NLS-1$
		case DecisionNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?DecisionNode", UMLElementTypes.DecisionNode_2010); //$NON-NLS-1$
		case MergeNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?MergeNode", UMLElementTypes.MergeNode_2011); //$NON-NLS-1$
		case InitialNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?InitialNode", UMLElementTypes.InitialNode_2012); //$NON-NLS-1$
		case DataStoreNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?DataStoreNode", UMLElementTypes.DataStoreNode_2013); //$NON-NLS-1$
		case OpaqueActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?OpaqueAction", UMLElementTypes.OpaqueAction_2014); //$NON-NLS-1$
		case OutputPin2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?OutputPin", UMLElementTypes.OutputPin_2015); //$NON-NLS-1$
		case InputPin4EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?InputPin", UMLElementTypes.InputPin_2016); //$NON-NLS-1$
		case ValuePin2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ValuePin", UMLElementTypes.ValuePin_2017); //$NON-NLS-1$
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?FlowFinalNode", UMLElementTypes.FlowFinalNode_2018); //$NON-NLS-1$
		case ForkNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ForkNode", UMLElementTypes.ForkNode_2019); //$NON-NLS-1$
		case JoinNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?JoinNode", UMLElementTypes.JoinNode_2020); //$NON-NLS-1$
		case PinEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pin", UMLElementTypes.Pin_2021); //$NON-NLS-1$
		case CreateObjectActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?CreateObjectAction", UMLElementTypes.CreateObjectAction_2022); //$NON-NLS-1$
		case OutputPin3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?OutputPin", UMLElementTypes.OutputPin_2023); //$NON-NLS-1$
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?CallBehaviorAction", UMLElementTypes.CallBehaviorAction_2024); //$NON-NLS-1$
		case OutputPin4EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?OutputPin", UMLElementTypes.OutputPin_2025); //$NON-NLS-1$
		case InputPin5EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?InputPin", UMLElementTypes.InputPin_2026); //$NON-NLS-1$
		case CallOperationActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?CallOperationAction", UMLElementTypes.CallOperationAction_2027); //$NON-NLS-1$
		case InputPin6EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?InputPin", UMLElementTypes.InputPin_2028); //$NON-NLS-1$
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ActivityParameterNode", UMLElementTypes.ActivityParameterNode_2029); //$NON-NLS-1$
		case ActivityPartitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ActivityPartition", UMLElementTypes.ActivityPartition_2030); //$NON-NLS-1$
		case ActivityPartition2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ActivityPartition", UMLElementTypes.ActivityPartition_2031); //$NON-NLS-1$
		case OpaqueAction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?OpaqueAction", UMLElementTypes.OpaqueAction_2032); //$NON-NLS-1$
		case AcceptEventAction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_2033); //$NON-NLS-1$
		case ControlFlowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?ControlFlow", UMLElementTypes.ControlFlow_3001); //$NON-NLS-1$
		case ObjectFlowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?ObjectFlow", UMLElementTypes.ObjectFlow_3002); //$NON-NLS-1$
		case ObjectNodeSelectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?ObjectNode?selection", UMLElementTypes.ObjectNodeSelection_3003); //$NON-NLS-1$
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?ExceptionHandler", UMLElementTypes.ExceptionHandler_3004); //$NON-NLS-1$
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Element?ownedComment", UMLElementTypes.ElementOwnedComment_3005); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_3006); //$NON-NLS-1$
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
		case ActivityEditPart.VISUAL_ID:
			return getActivity_1001Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2034Text(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_2001Text(view);
		case InputPinEditPart.VISUAL_ID:
			return getInputPin_2002Text(view);
		case InputPin2EditPart.VISUAL_ID:
			return getInputPin_2003Text(view);
		case ValuePinEditPart.VISUAL_ID:
			return getValuePin_2004Text(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_2005Text(view);
		case InputPin3EditPart.VISUAL_ID:
			return getInputPin_2006Text(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_2007Text(view);
		case OutputPinEditPart.VISUAL_ID:
			return getOutputPin_2008Text(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_2009Text(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_2010Text(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_2011Text(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_2012Text(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_2013Text(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_2014Text(view);
		case OutputPin2EditPart.VISUAL_ID:
			return getOutputPin_2015Text(view);
		case InputPin4EditPart.VISUAL_ID:
			return getInputPin_2016Text(view);
		case ValuePin2EditPart.VISUAL_ID:
			return getValuePin_2017Text(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_2018Text(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_2019Text(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_2020Text(view);
		case PinEditPart.VISUAL_ID:
			return getPin_2021Text(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_2022Text(view);
		case OutputPin3EditPart.VISUAL_ID:
			return getOutputPin_2023Text(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_2024Text(view);
		case OutputPin4EditPart.VISUAL_ID:
			return getOutputPin_2025Text(view);
		case InputPin5EditPart.VISUAL_ID:
			return getInputPin_2026Text(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_2027Text(view);
		case InputPin6EditPart.VISUAL_ID:
			return getInputPin_2028Text(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_2029Text(view);
		case ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_2030Text(view);
		case ActivityPartition2EditPart.VISUAL_ID:
			return getActivityPartition_2031Text(view);
		case OpaqueAction2EditPart.VISUAL_ID:
			return getOpaqueAction_2032Text(view);
		case AcceptEventAction2EditPart.VISUAL_ID:
			return getAcceptEventAction_2033Text(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_3001Text(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_3002Text(view);
		case ObjectNodeSelectionEditPart.VISUAL_ID:
			return getObjectNodeSelection_3003Text(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_3004Text(view);
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return getElementOwnedComment_3005Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_3006Text(view);
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
	private String getActivity_1001Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Activity_1001,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(ActivityNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4042); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getSendObjectAction_2001Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.SendObjectAction_2001,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(SendObjectActionNameEditPart.VISUAL_ID));
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
	private String getInputPin_2002Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.InputPin_2002,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(InputPinNameEditPart.VISUAL_ID));
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
	private String getInputPin_2003Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.InputPin_2003,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(InputPinName2EditPart.VISUAL_ID));
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
	private String getValuePin_2004Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ValuePin_2004,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(ValuePinNameEditPart.VISUAL_ID));
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
	private String getSendSignalAction_2005Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.SendSignalAction_2005,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(SendSignalActionNameEditPart.VISUAL_ID));
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
	private String getInputPin_2006Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.InputPin_2006,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(InputPinName3EditPart.VISUAL_ID));
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
	private String getAcceptEventAction_2007Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.AcceptEventAction_2007,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(AcceptEventActionNameEditPart.VISUAL_ID));
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
	private String getOutputPin_2008Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.OutputPin_2008,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(OutputPinNameEditPart.VISUAL_ID));
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
	private String getActivityFinalNode_2009Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ActivityFinalNode_2009,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(ActivityFinalNodeNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getDecisionNode_2010Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.DecisionNode_2010,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(DecisionNodeNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMergeNode_2011Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.MergeNode_2011,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(MergeNodeNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInitialNode_2012Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.InitialNode_2012,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(InitialNodeNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getDataStoreNode_2013Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.DataStoreNode_2013,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(DataStoreNodeNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getOpaqueAction_2014Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.OpaqueAction_2014,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(OpaqueActionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getOutputPin_2015Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.OutputPin_2015,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(OutputPinName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInputPin_2016Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.InputPin_2016,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(InputPinName4EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getValuePin_2017Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ValuePin_2017,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(ValuePinName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getFlowFinalNode_2018Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.FlowFinalNode_2018,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(FlowFinalNodeNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getForkNode_2019Text(View view) {
		ForkNode domainModelElement = (ForkNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getJoinNode_2020Text(View view) {
		JoinNode domainModelElement = (JoinNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPin_2021Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Pin_2021, (view.getElement() != null ? view
						.getElement() : view), UMLVisualIDRegistry
						.getType(PinNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCreateObjectAction_2022Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.CreateObjectAction_2022,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(CreateObjectActionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getOutputPin_2023Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.OutputPin_2023,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(OutputPinName3EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCallBehaviorAction_2024Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.CallBehaviorAction_2024,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(CallBehaviorActionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4029); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getOutputPin_2025Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.OutputPin_2025,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(OutputPinName4EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInputPin_2026Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.InputPin_2026,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(InputPinName5EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCallOperationAction_2027Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.CallOperationAction_2027,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(CallOperationActionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4032); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInputPin_2028Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.InputPin_2028,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(InputPinName6EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActivityParameterNode_2029Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ActivityParameterNode_2029,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(ActivityParameterNodeNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4034); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActivityPartition_2030Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ActivityPartition_2030,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(ActivityPartitionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4041); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActivityPartition_2031Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ActivityPartition_2031,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(ActivityPartitionName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getOpaqueAction_2032Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.OpaqueAction_2032,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(OpaqueActionName3EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4035); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_2033Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.AcceptEventAction_2033,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry
						.getType(AcceptEventActionName3EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4037); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getComment_2034Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.Comment_2034, (view.getElement() != null ? view
						.getElement() : view), UMLVisualIDRegistry
						.getType(CommentBodyEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4039); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getControlFlow_3001Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ControlFlow_3001,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(ControlFlowNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4043); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getObjectFlow_3002Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ObjectFlow_3002,
				(view.getElement() != null ? view.getElement() : view),
				UMLVisualIDRegistry.getType(ObjectFlowNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4044); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getObjectNodeSelection_3003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getExceptionHandler_3004Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(
				UMLElementTypes.ExceptionHandler_3004,
				(view.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4045); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getElementOwnedComment_3005Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_3006Text(View view) {
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
