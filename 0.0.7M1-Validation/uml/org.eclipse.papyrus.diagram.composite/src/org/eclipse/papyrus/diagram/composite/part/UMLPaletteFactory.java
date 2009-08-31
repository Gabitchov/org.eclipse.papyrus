/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createEdges2Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createClass1CreationTool());
		paletteContainer.add(createProperty2CreationTool());
		paletteContainer.add(createPort3CreationTool());
		paletteContainer.add(createCollaboration4CreationTool());
		paletteContainer.add(createOtherClassifiers5CreationTool());
		paletteContainer.add(createBehaviors6CreationTool());
		paletteContainer.add(createDataType7CreationTool());
		paletteContainer.add(createPrimitiveType8CreationTool());
		paletteContainer.add(createEnumeration9CreationTool());
		paletteContainer.add(createEnumerationLiteral10CreationTool());
		paletteContainer.add(createInterface11CreationTool());
		paletteContainer.add(createReception12CreationTool());
		paletteContainer.add(createOperation13CreationTool());
		paletteContainer.add(createComment14CreationTool());
		paletteContainer.add(createContraint15CreationTool());
		paletteContainer.add(createCollaborationUse16CreationTool());
		paletteContainer.add(createOtherNamedElements17CreationTool());
		paletteContainer.add(createEvents18CreationTool());
		paletteContainer.add(createObservations19CreationTool());
		paletteContainer.add(createLiterals20CreationTool());
		paletteContainer.add(createValueSpecifications21CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Edges" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createEdges2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Edges2Group_title);
		paletteContainer.setId("createEdges2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Edges2Group_desc);
		paletteContainer.add(createLink1CreationTool());
		paletteContainer.add(createConnector2CreationTool());
		paletteContainer.add(createRealizations3CreationTool());
		paletteContainer.add(createDependencies4CreationTool());
		paletteContainer.add(createGeneralization5CreationTool());
		paletteContainer.add(createInformationFlow6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(4);
		types.add(UMLElementTypes.Class_2073);
		types.add(UMLElementTypes.Class_3085);
		types.add(UMLElementTypes.Activity_3103);
		types.add(UMLElementTypes.Class_3114);
		NodeToolEntry entry = new NodeToolEntry(Messages.Class1CreationTool_title, Messages.Class1CreationTool_desc,
				types);
		entry.setId("createClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Class_2073));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProperty2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Property_3070);
		types.add(UMLElementTypes.Property_3101);
		NodeToolEntry entry = new NodeToolEntry(Messages.Property2CreationTool_title,
				Messages.Property2CreationTool_desc, types);
		entry.setId("createProperty2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_3070));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Port_3069);
		NodeToolEntry entry = new NodeToolEntry(Messages.Port3CreationTool_title, Messages.Port3CreationTool_desc,
				types);
		entry.setId("createPort3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Port_3069));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollaboration4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(3);
		types.add(UMLElementTypes.Collaboration_3086);
		types.add(UMLElementTypes.Collaboration_3109);
		types.add(UMLElementTypes.Collaboration_2075);
		NodeToolEntry entry = new NodeToolEntry(Messages.Collaboration4CreationTool_title,
				Messages.Collaboration4CreationTool_desc, types);
		entry.setId("createCollaboration4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Collaboration_3086));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOtherClassifiers5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(21);
		types.add(UMLElementTypes.Component_2069);
		types.add(UMLElementTypes.Device_2070);
		types.add(UMLElementTypes.ExecutionEnvironment_2071);
		types.add(UMLElementTypes.Node_2072);
		types.add(UMLElementTypes.Component_3081);
		types.add(UMLElementTypes.Device_3082);
		types.add(UMLElementTypes.ExecutionEnvironment_3083);
		types.add(UMLElementTypes.Node_3084);
		types.add(UMLElementTypes.Actor_3091);
		types.add(UMLElementTypes.DeploymentSpecification_3092);
		types.add(UMLElementTypes.Artifact_3093);
		types.add(UMLElementTypes.InformationItem_3094);
		types.add(UMLElementTypes.Signal_3095);
		types.add(UMLElementTypes.UseCase_3096);
		types.add(UMLElementTypes.Class_2074);
		types.add(UMLElementTypes.Actor_2077);
		types.add(UMLElementTypes.DeploymentSpecification_2078);
		types.add(UMLElementTypes.Artifact_2079);
		types.add(UMLElementTypes.InformationItem_2080);
		types.add(UMLElementTypes.Signal_2081);
		types.add(UMLElementTypes.UseCase_2082);
		NodeToolEntry entry = new NodeToolEntry(Messages.OtherClassifiers5CreationTool_title,
				Messages.OtherClassifiers5CreationTool_desc, types);
		entry.setId("createOtherClassifiers5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Component_2069));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBehaviors6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(17);
		types.add(UMLElementTypes.Activity_2060);
		types.add(UMLElementTypes.Interaction_2061);
		types.add(UMLElementTypes.ProtocolStateMachine_2062);
		types.add(UMLElementTypes.StateMachine_2063);
		types.add(UMLElementTypes.FunctionBehavior_2064);
		types.add(UMLElementTypes.OpaqueBehavior_2065);
		types.add(UMLElementTypes.Activity_3072);
		types.add(UMLElementTypes.Interaction_3073);
		types.add(UMLElementTypes.ProtocolStateMachine_3074);
		types.add(UMLElementTypes.StateMachine_3075);
		types.add(UMLElementTypes.FunctionBehavior_3076);
		types.add(UMLElementTypes.OpaqueBehavior_3077);
		types.add(UMLElementTypes.Interaction_3104);
		types.add(UMLElementTypes.ProtocolStateMachine_3105);
		types.add(UMLElementTypes.StateMachine_3106);
		types.add(UMLElementTypes.FunctionBehavior_3107);
		types.add(UMLElementTypes.OpaqueBehavior_3108);
		NodeToolEntry entry = new NodeToolEntry(Messages.Behaviors6CreationTool_title,
				Messages.Behaviors6CreationTool_desc, types);
		entry.setId("createBehaviors6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Activity_2060));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataType7CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(3);
		types.add(UMLElementTypes.DataType_2068);
		types.add(UMLElementTypes.DataType_3080);
		types.add(UMLElementTypes.DataType_3113);
		NodeToolEntry entry = new NodeToolEntry(Messages.DataType7CreationTool_title,
				Messages.DataType7CreationTool_desc, types);
		entry.setId("createDataType7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DataType_2068));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPrimitiveType8CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(3);
		types.add(UMLElementTypes.PrimitiveType_2066);
		types.add(UMLElementTypes.PrimitiveType_3078);
		types.add(UMLElementTypes.PrimitiveType_3112);
		NodeToolEntry entry = new NodeToolEntry(Messages.PrimitiveType8CreationTool_title,
				Messages.PrimitiveType8CreationTool_desc, types);
		entry.setId("createPrimitiveType8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.PrimitiveType_2066));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumeration9CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(3);
		types.add(UMLElementTypes.Enumeration_2067);
		types.add(UMLElementTypes.Enumeration_3079);
		types.add(UMLElementTypes.Enumeration_3111);
		NodeToolEntry entry = new NodeToolEntry(Messages.Enumeration9CreationTool_title,
				Messages.Enumeration9CreationTool_desc, types);
		entry.setId("createEnumeration9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Enumeration_2067));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumerationLiteral10CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.EnumerationLiteral_3066);
		NodeToolEntry entry = new NodeToolEntry(Messages.EnumerationLiteral10CreationTool_title,
				Messages.EnumerationLiteral10CreationTool_desc, types);
		entry.setId("createEnumerationLiteral10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.EnumerationLiteral_3066));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface11CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(3);
		types.add(UMLElementTypes.Interface_3087);
		types.add(UMLElementTypes.Interface_3110);
		types.add(UMLElementTypes.Interface_2076);
		NodeToolEntry entry = new NodeToolEntry(Messages.Interface11CreationTool_title,
				Messages.Interface11CreationTool_desc, types);
		entry.setId("createInterface11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Interface_3087));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReception12CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Reception_3100);
		NodeToolEntry entry = new NodeToolEntry(Messages.Reception12CreationTool_title,
				Messages.Reception12CreationTool_desc, types);
		entry.setId("createReception12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Reception_3100));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOperation13CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Operation_3102);
		NodeToolEntry entry = new NodeToolEntry(Messages.Operation13CreationTool_title,
				Messages.Operation13CreationTool_desc, types);
		entry.setId("createOperation13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Operation_3102));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment14CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Comment_3097);
		types.add(UMLElementTypes.Comment_2109);
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment14CreationTool_title,
				Messages.Comment14CreationTool_desc, types);
		entry.setId("createComment14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_3097));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createContraint15CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(6);
		types.add(UMLElementTypes.DurationConstraint_3098);
		types.add(UMLElementTypes.DurationConstraint_2110);
		types.add(UMLElementTypes.TimeConstraint_2111);
		types.add(UMLElementTypes.IntervalConstraint_2112);
		types.add(UMLElementTypes.InteractionConstraint_2113);
		types.add(UMLElementTypes.Constraint_2114);
		NodeToolEntry entry = new NodeToolEntry(Messages.Contraint15CreationTool_title,
				Messages.Contraint15CreationTool_desc, types);
		entry.setId("createContraint15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DurationConstraint_3098));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollaborationUse16CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.CollaborationUse_3071);
		NodeToolEntry entry = new NodeToolEntry(Messages.CollaborationUse16CreationTool_title,
				Messages.CollaborationUse16CreationTool_desc, types);
		entry.setId("createCollaborationUse16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CollaborationUse_3071));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOtherNamedElements17CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.OtherNamedElements17CreationTool_title,
				Messages.OtherNamedElements17CreationTool_desc, null, null) {
		};
		entry.setId("createOtherNamedElements17CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEvents18CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(10);
		types.add(UMLElementTypes.SignalEvent_2083);
		types.add(UMLElementTypes.CallEvent_2084);
		types.add(UMLElementTypes.AnyReceiveEvent_2085);
		types.add(UMLElementTypes.SendSignalEvent_2086);
		types.add(UMLElementTypes.SendOperationEvent_2087);
		types.add(UMLElementTypes.ChangeEvent_2088);
		types.add(UMLElementTypes.TimeEvent_2089);
		types.add(UMLElementTypes.CreationEvent_2090);
		types.add(UMLElementTypes.DestructionEvent_2091);
		types.add(UMLElementTypes.ExecutionEvent_2092);
		NodeToolEntry entry = new NodeToolEntry(Messages.Events18CreationTool_title,
				Messages.Events18CreationTool_desc, types);
		entry.setId("createEvents18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.SignalEvent_2083));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createObservations19CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.DurationObservation_2093);
		types.add(UMLElementTypes.TimeObservation_2094);
		NodeToolEntry entry = new NodeToolEntry(Messages.Observations19CreationTool_title,
				Messages.Observations19CreationTool_desc, types);
		entry.setId("createObservations19CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DurationObservation_2093));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLiterals20CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(5);
		types.add(UMLElementTypes.LiteralBoolean_2095);
		types.add(UMLElementTypes.LiteralInteger_2096);
		types.add(UMLElementTypes.LiteralNull_2097);
		types.add(UMLElementTypes.LiteralString_2098);
		types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
		NodeToolEntry entry = new NodeToolEntry(Messages.Literals20CreationTool_title,
				Messages.Literals20CreationTool_desc, types);
		entry.setId("createLiterals20CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.LiteralBoolean_2095));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createValueSpecifications21CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(9);
		types.add(UMLElementTypes.StringExpression_2100);
		types.add(UMLElementTypes.OpaqueExpression_2101);
		types.add(UMLElementTypes.TimeExpression_2102);
		types.add(UMLElementTypes.Expression_2103);
		types.add(UMLElementTypes.Duration_2104);
		types.add(UMLElementTypes.TimeInterval_2105);
		types.add(UMLElementTypes.DurationInterval_2106);
		types.add(UMLElementTypes.Interval_2107);
		types.add(UMLElementTypes.InstanceValue_2108);
		NodeToolEntry entry = new NodeToolEntry(Messages.ValueSpecifications21CreationTool_title,
				Messages.ValueSpecifications21CreationTool_desc, types);
		entry.setId("createValueSpecifications21CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.StringExpression_2100));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLink1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.Link1CreationTool_title, Messages.Link1CreationTool_desc,
				types);
		entry.setId("createLink1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnector2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Connector_4013);
		LinkToolEntry entry = new LinkToolEntry(Messages.Connector2CreationTool_title,
				Messages.Connector2CreationTool_desc, types);
		entry.setId("createConnector2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Connector_4013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRealizations3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(4);
		types.add(UMLElementTypes.ComponentRealization_4004);
		types.add(UMLElementTypes.InterfaceRealization_4005);
		types.add(UMLElementTypes.Substitution_4011);
		types.add(UMLElementTypes.Realization_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.Realizations3CreationTool_title,
				Messages.Realizations3CreationTool_desc, types);
		entry.setId("createRealizations3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ComponentRealization_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependencies4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(5);
		types.add(UMLElementTypes.Manifestation_4012);
		types.add(UMLElementTypes.Abstraction_4007);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.Deployment_4009);
		types.add(UMLElementTypes.Dependency_4010);
		LinkToolEntry entry = new LinkToolEntry(Messages.Dependencies4CreationTool_title,
				Messages.Dependencies4CreationTool_desc, types);
		entry.setId("createDependencies4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Manifestation_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Generalization_4015);
		LinkToolEntry entry = new LinkToolEntry(Messages.Generalization5CreationTool_title,
				Messages.Generalization5CreationTool_desc, types);
		entry.setId("createGeneralization5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Generalization_4015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInformationFlow6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.InformationFlow_4016);
		LinkToolEntry entry = new LinkToolEntry(Messages.InformationFlow6CreationTool_title,
				Messages.InformationFlow6CreationTool_desc, types);
		entry.setId("createInformationFlow6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InformationFlow_4016));
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
		private NodeToolEntry(String title, String description, List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
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
		private LinkToolEntry(String title, String description, List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
