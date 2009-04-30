package org.eclipse.papyrus.diagram.activity.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createActivities1Group());
		paletteRoot.add(createActions2Group());
		paletteRoot.add(createControlNodes3Group());
		paletteRoot.add(createObjects4Group());
		paletteRoot.add(createEdges5Group());
		paletteRoot.add(createComments6Group());
	}

	/**
	 * Creates "Activities" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createActivities1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Activities1Group_title);
		paletteContainer.setDescription(Messages.Activities1Group_desc);
		paletteContainer.add(createActivity1CreationTool());
		paletteContainer.add(createActivityPartition2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Actions" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createActions2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Actions2Group_title);
		paletteContainer.setDescription(Messages.Actions2Group_desc);
		paletteContainer.add(createSendObjectAction1CreationTool());
		paletteContainer.add(createSendSignalAction2CreationTool());
		paletteContainer.add(createAcceptEventAction3CreationTool());
		paletteContainer.add(createOpaqueAction4CreationTool());
		paletteContainer.add(createCallBehaviorAction5CreationTool());
		paletteContainer.add(createCallOperationAction6CreationTool());
		paletteContainer.add(createCreateObjectAction7CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Control Nodes" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createControlNodes3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.ControlNodes3Group_title);
		paletteContainer.setDescription(Messages.ControlNodes3Group_desc);
		paletteContainer.add(createActivityFinalNode1CreationTool());
		paletteContainer.add(createInitialNode2CreationTool());
		paletteContainer.add(createFlowFinalNode3CreationTool());
		paletteContainer.add(createDecisionNode4CreationTool());
		paletteContainer.add(createMergeNode5CreationTool());
		paletteContainer.add(createForkNode6CreationTool());
		paletteContainer.add(createJoinNode7CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Objects" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createObjects4Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects4Group_title);
		paletteContainer.setDescription(Messages.Objects4Group_desc);
		paletteContainer.add(createDatastore1CreationTool());
		paletteContainer.add(createPin2CreationTool());
		paletteContainer.add(createValuePin3CreationTool());
		paletteContainer.add(createOutputPin4CreationTool());
		paletteContainer.add(createInputPin5CreationTool());
		paletteContainer.add(createActivityParameter6CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Edges" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createEdges5Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Edges5Group_title);
		paletteContainer.setDescription(Messages.Edges5Group_desc);
		paletteContainer.add(createControlFlow1CreationTool());
		paletteContainer.add(createObjectFlow2CreationTool());
		paletteContainer.add(createExceptionHandler3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Comments" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createComments6Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Comments6Group_title);
		paletteContainer.add(createComment1CreationTool());
		paletteContainer.add(createCommentLink2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivity1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Activity_1001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Activity1CreationTool_title,
				Messages.Activity1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Activity_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivityPartition2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.ActivityPartition_2030);
		types.add(UMLElementTypes.ActivityPartition_2031);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ActivityPartition2CreationTool_title,
				Messages.ActivityPartition2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ActivityPartition_2030));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSendObjectAction1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.SendObjectAction_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SendObjectAction1CreationTool_title,
				Messages.SendObjectAction1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.SendObjectAction_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSendSignalAction2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.SendSignalAction_2005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SendSignalAction2CreationTool_title,
				Messages.SendSignalAction2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.SendSignalAction_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAcceptEventAction3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.AcceptEventAction_2007);
		types.add(UMLElementTypes.AcceptEventAction_2033);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.AcceptEventAction3CreationTool_title,
				Messages.AcceptEventAction3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.AcceptEventAction_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOpaqueAction4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.OpaqueAction_2014);
		types.add(UMLElementTypes.OpaqueAction_2032);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OpaqueAction4CreationTool_title,
				Messages.OpaqueAction4CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.OpaqueAction_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCallBehaviorAction5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CallBehaviorAction_2024);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CallBehaviorAction5CreationTool_title,
				Messages.CallBehaviorAction5CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.CallBehaviorAction_2024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCallOperationAction6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CallOperationAction_2027);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CallOperationAction6CreationTool_title,
				Messages.CallOperationAction6CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.CallOperationAction_2027));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCreateObjectAction7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CreateObjectAction_2022);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CreateObjectAction7CreationTool_title,
				Messages.CreateObjectAction7CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.CreateObjectAction_2022));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivityFinalNode1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ActivityFinalNode_2009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ActivityFinalNode1CreationTool_title,
				Messages.ActivityFinalNode1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ActivityFinalNode_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitialNode2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.InitialNode_2012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InitialNode2CreationTool_title,
				Messages.InitialNode2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.InitialNode_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFlowFinalNode3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.FlowFinalNode_2018);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.FlowFinalNode3CreationTool_title,
				Messages.FlowFinalNode3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.FlowFinalNode_2018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDecisionNode4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.DecisionNode_2010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DecisionNode4CreationTool_title,
				Messages.DecisionNode4CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.DecisionNode_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMergeNode5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.MergeNode_2011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.MergeNode5CreationTool_title,
				Messages.MergeNode5CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.MergeNode_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createForkNode6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ForkNode_2019);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ForkNode6CreationTool_title,
				Messages.ForkNode6CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ForkNode_2019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createJoinNode7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.JoinNode_2020);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.JoinNode7CreationTool_title,
				Messages.JoinNode7CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.JoinNode_2020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDatastore1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.DataStoreNode_2013);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Datastore1CreationTool_title,
				Messages.Datastore1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.DataStoreNode_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPin2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pin_2021);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Pin2CreationTool_title,
				Messages.Pin2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Pin_2021));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createValuePin3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.ValuePin_2004);
		types.add(UMLElementTypes.ValuePin_2017);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ValuePin3CreationTool_title,
				Messages.ValuePin3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ValuePin_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOutputPin4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(UMLElementTypes.OutputPin_2008);
		types.add(UMLElementTypes.OutputPin_2015);
		types.add(UMLElementTypes.OutputPin_2023);
		types.add(UMLElementTypes.OutputPin_2025);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OutputPin4CreationTool_title,
				Messages.OutputPin4CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.OutputPin_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputPin5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(6);
		types.add(UMLElementTypes.InputPin_2002);
		types.add(UMLElementTypes.InputPin_2003);
		types.add(UMLElementTypes.InputPin_2006);
		types.add(UMLElementTypes.InputPin_2016);
		types.add(UMLElementTypes.InputPin_2026);
		types.add(UMLElementTypes.InputPin_2028);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InputPin5CreationTool_title,
				Messages.InputPin5CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.InputPin_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivityParameter6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ActivityParameterNode_2029);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ActivityParameter6CreationTool_title,
				Messages.ActivityParameter6CreationTool_desc, types);
		entry
				.setSmallIcon(UMLElementTypes
						.getImageDescriptor(UMLElementTypes.ActivityParameterNode_2029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createControlFlow1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ControlFlow_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ControlFlow1CreationTool_title,
				Messages.ControlFlow1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ControlFlow_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createObjectFlow2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ObjectFlow_3002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ObjectFlow2CreationTool_title,
				Messages.ObjectFlow2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ObjectFlow_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExceptionHandler3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ExceptionHandler_3004);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ExceptionHandler3CreationTool_title,
				Messages.ExceptionHandler3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ExceptionHandler_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Comment_2034);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Comment1CreationTool_title,
				Messages.Comment1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Comment_2034));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommentLink2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.ElementOwnedComment_3005);
		types.add(UMLElementTypes.CommentAnnotatedElement_3006);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.CommentLink2CreationTool_title,
				Messages.CommentLink2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ElementOwnedComment_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		@Override
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		@Override
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
