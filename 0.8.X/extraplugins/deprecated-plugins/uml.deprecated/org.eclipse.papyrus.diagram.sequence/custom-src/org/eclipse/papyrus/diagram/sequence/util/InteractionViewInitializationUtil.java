/***************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz - Initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Package;

import org.eclipse.papyrus.diagram.common.commands.AddEObjectReferencesToDiagram;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.commands.GMFToEMFCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Interaction2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.part.UMLLinkDescriptor;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

public class InteractionViewInitializationUtil {

	/**
	 * Helper classes for location and size data
	 */
	public class InitDataFigure {
		EObject eObject = null;
		List<InitDataFigure> children = null;
	}

	/**
	 * A <Node> size and location data.
	 * 
	 * @author fjcano
	 * 
	 */
	public class NodeInitDataFigure extends InitDataFigure {
		Point size = null;
		Point location = null;
	}

	/**
	 * An <Edge> start and end data.
	 * 
	 * @author fjcano
	 * 
	 */
	public class EdgeInitDataFigure extends InitDataFigure {
		Point start = null;
		Point end = null;
	}

	/*
	 * 
	 */

	// //** Constants and fixed values **////
	protected static final int Interaction_Minimun_Size_X = 400;
	protected static final int Interaction_Minimun_Size_Y = 250;
	protected static final int Interaction_Offset_X = 40;
	protected static final int Interaction_Offset_Y = 40;
	protected static final int Interaction_Title_Size = 20;

	protected static final int Lifeline_Minimun_Size_X = 100;
	protected static final int Lifeline_Minimun_Size_Y = 100;
	protected static final int Lifeline_Offset_X = 20;
	protected static final int Lifeline_Title_Size = 20;

	protected static final int BES_Minimun_Size_X = 16;
	protected static final int BES_Minimun_Size_Y = 60;
	protected static final int BES_Offset_X = 20;

	protected static final int Message_Slot_Size_Y = 40;
	protected static final int Message_BES_Offset = 10;

	// //** General, auxiliary functions and methods for initializing an
	// interaction with Lifelines, Behaviour Execution Specifications and
	// Messages **////

	private static final InteractionViewInitializationUtil INSTANCE = new InteractionViewInitializationUtil();

	protected static int getTotalMessagesSize(
			List<List<Message>> orderedMessages) {
		if (orderedMessages == null) {
			return 0;
		}
		return orderedMessages.size();
	}

	/**
	 * Main size initialization method.
	 * 
	 * @param interaction
	 * @param orderedMessages
	 * @return
	 */
	public static NodeInitDataFigure calculateInteractionInitData(
			Interaction interaction, List<List<Message>> orderedMessages,
			Point offset) {
		// Interaction initialization data.
		NodeInitDataFigure interactionInitDataFigure = INSTANCE.new NodeInitDataFigure();
		// set Interaction
		interactionInitDataFigure.eObject = interaction;
		// prepare children's list
		interactionInitDataFigure.children = new ArrayList<InitDataFigure>();
		// set Interaction real size
		Point size = new Point(0, 0);
		size.x = calculateInterationWidth(interaction, orderedMessages);
		size.y = calculateInteractionHeight(interaction, orderedMessages);
		interactionInitDataFigure.size = size;
		interactionInitDataFigure.location = new Point(0, 0);
		// add Lifelines initialization data.
		addLifelinesToInteraction(interactionInitDataFigure, orderedMessages);
		// add Messages and BES
		addMessagesAndBESToInteraction(interactionInitDataFigure,
				orderedMessages);
		addOffsetToDataFigure(interactionInitDataFigure, offset);
		return interactionInitDataFigure;
	}

	protected static void addOffsetToDataFigure(InitDataFigure dataFigure,
			Point offset) {
		if (dataFigure == null || offset == null
				|| (offset.x == 0 && offset.y == 0)) {
			return;
		}
		if (dataFigure instanceof NodeInitDataFigure) {
			NodeInitDataFigure nodeData = (NodeInitDataFigure) dataFigure;
			nodeData.location.x += offset.x;
			nodeData.location.y += offset.y;
		}
		if (dataFigure instanceof EdgeInitDataFigure) {
			EdgeInitDataFigure edgeData = (EdgeInitDataFigure) dataFigure;
			edgeData.start.x += offset.x;
			edgeData.start.y += offset.y;
			edgeData.end.x += offset.x;
			edgeData.end.y += offset.y;
		}
		if (dataFigure.children != null) {
			for (InitDataFigure childFigure : dataFigure.children) {
				addOffsetToDataFigure(childFigure, offset);
			}
		}
	}

	/**
	 * Calculates <Interaction> height.
	 * 
	 * @param interaction
	 * @param orderedMessages
	 * @return
	 */
	protected static int calculateInteractionHeight(Interaction interaction,
			List<List<Message>> orderedMessages) {
		int height = 0;
		height = calculateLifelineHeight(interaction, orderedMessages);
		height += Interaction_Offset_Y * 2;
		height += Interaction_Title_Size;
		return height >= Interaction_Minimun_Size_Y ? height
				: Interaction_Minimun_Size_Y;
	}

	/**
	 * Calculates <Interaction> width.
	 * 
	 * @param interaction
	 * @param orderedMessages
	 * @return
	 */
	protected static int calculateInterationWidth(Interaction interaction,
			List<List<Message>> orderedMessages) {
		int width = 0;
		if (interaction.getLifelines() != null
				&& interaction.getLifelines().size() > 0) {
			int nLifelines = interaction.getLifelines().size();
			width += nLifelines
					* calculateLifelineWidth(interaction, orderedMessages);
			width += (nLifelines - 1) * Lifeline_Offset_X;
			width += Interaction_Offset_X * 2;
		}
		return width >= Interaction_Minimun_Size_X ? width
				: Interaction_Minimun_Size_X;
	}

	/**
	 * Calculates <Lifeline> height.
	 * 
	 * @param interaction
	 * @param orderedMessages
	 * @return
	 */
	protected static int calculateLifelineHeight(Interaction interaction,
			List<List<Message>> orderedMessages) {
		int height = 0;
		height = getTotalMessagesSize(orderedMessages);
		height *= Message_Slot_Size_Y;
		height += Message_BES_Offset * 2;
		height += Lifeline_Title_Size;
		return height >= Lifeline_Minimun_Size_Y ? height
				: Lifeline_Minimun_Size_Y;
	}

	/**
	 * Calculates <Lifeline> width.
	 * 
	 * @param interaction
	 * @param orderedMessages
	 * @return
	 */
	protected static int calculateLifelineWidth(Interaction interaction,
			List<List<Message>> orderedMessages) {
		int width = 0;
		return width >= Lifeline_Minimun_Size_X ? width
				: Lifeline_Minimun_Size_X;
	}

	protected static int calculateBESXOffset(NodeInitDataFigure rootData,
			Lifeline lifeline) {
		return calculateLifelineXCenter(lifeline, rootData);
	}

	/**
	 * Modified by gmerin
	 */
	protected static int calculateLifelineXCenter(Lifeline lifeline,
			NodeInitDataFigure rootData) {
		if (lifeline == null || rootData == null) {
			return -1;
		}
		NodeInitDataFigure lifelineData = findElementNodeData(rootData,
				lifeline);
		if (lifelineData.location == null || lifelineData.size == null) {
			return -1;
		}
		return (lifelineData.location.x + (lifelineData.size.x / 2));
	}

	/**
	 * Added
	 * 
	 * @author gmerin
	 */
	protected static int calculateBESXEdge(BehaviorExecutionSpecification bes,
			NodeInitDataFigure rootData, Boolean isSourceEnd) {
		if (bes == null || rootData == null || isSourceEnd == null) {
			return -1;
		}
		NodeInitDataFigure besData = findElementNodeData(rootData, bes);
		if (besData == null || besData.location == null || besData.size == null) {
			return -1;
		}
		if (isSourceEnd)
			return (besData.location.x + besData.size.x - 1);
		else
			return (besData.location.x);
	}

	/**
	 * Modified by gmerin
	 */
	protected static int calculateMessageEndXOffset(Element element,
			NodeInitDataFigure rootData, Boolean isSourceEnd) {
		if (element instanceof Lifeline) {
			return calculateLifelineXCenter((Lifeline) element, rootData);
		} else if (element instanceof BehaviorExecutionSpecification) {
			BehaviorExecutionSpecification bes = ((BehaviorExecutionSpecification) element);
			if (bes.getCovereds().size() > 0) {
				// Lifeline lifeline = bes.getCovereds().get(0);
				// return calculateLifelineXCenter(lifeline, rootData);
				return calculateBESXEdge(bes, rootData, isSourceEnd);
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

	protected static void addLifelinesToInteraction(
			NodeInitDataFigure interactionData,
			List<List<Message>> orderedMessages) {
		// sanity check
		if (interactionData == null || orderedMessages == null
				|| orderedMessages.size() <= 0) {
			return;
		}
		Interaction interaction = interactionData.eObject instanceof Interaction ? (Interaction) interactionData.eObject
				: null;
		if (interaction == null) {
			return;
		}
		int xOffset = Interaction_Offset_X, yOffset = Interaction_Offset_Y
				+ Interaction_Title_Size;
		int width = calculateLifelineWidth(interaction, orderedMessages);
		int height = calculateLifelineHeight(interaction, orderedMessages);
		for (Lifeline lifeline : interaction.getLifelines()) {
			NodeInitDataFigure lifelineData = initLifelineData(xOffset,
					yOffset, width, height, lifeline);
			if (lifelineData != null) {
				interactionData.children.add(lifelineData);
				xOffset += width + Lifeline_Offset_X;
			}
		}
	}

	/**
	 * Adds Messages and BES to the Lifelines.
	 * 
	 * @param interactionData
	 * @param orderedMessages
	 */
	protected static void addMessagesAndBESToInteraction(
			NodeInitDataFigure interactionData,
			List<List<Message>> orderedMessages) {
		// sanity check
		if (interactionData == null || orderedMessages == null
				|| orderedMessages.size() <= 0) {
			return;
		}
		Interaction interaction = interactionData.eObject instanceof Interaction ? (Interaction) interactionData.eObject
				: null;
		if (interaction == null) {
			return;
		}
		int yOffset = Interaction_Title_Size + Interaction_Offset_Y
				+ Lifeline_Title_Size + Message_Slot_Size_Y
				+ Message_BES_Offset;
		
		// added by gmerin
		// To store the BES that added to the interactionData as ends of the
		// messages
		List<BehaviorExecutionSpecification> addedBESList = new BasicEList<BehaviorExecutionSpecification>();
		// end gmerin
		
		for (List<Message> messages : orderedMessages) {
			// a slot/position can have more than one Message
			for (Message message : messages) {
				// Message source and target MOS
				MessageOccurrenceSpecification sourceMOS = message
						.getSendEvent() instanceof MessageOccurrenceSpecification ? (MessageOccurrenceSpecification) message
						.getSendEvent()
						: null;
				MessageOccurrenceSpecification targetMOS = message
						.getReceiveEvent() instanceof MessageOccurrenceSpecification ? (MessageOccurrenceSpecification) message
						.getReceiveEvent()
						: null;
				// sanity check
				if (sourceMOS == null || targetMOS == null) {
					continue;
				}
				// Message source and target
				Element source = MessageCommonUtil.getMessageSrc(message);
				Element target = MessageCommonUtil.getMessageDst(message);
				// source and target Lifelines - to calculate x offsets
				Lifeline sourceLifeline = getMOSLifeline(sourceMOS);
				Lifeline targetLifeline = getMOSLifeline(targetMOS);
				// do we have to create any BES figure at source ?
				if (source instanceof BehaviorExecutionSpecification) {
					BehaviorExecutionSpecification sourceBES = (BehaviorExecutionSpecification) source;
					
					// added by gmerin
					addedBESList.add(sourceBES);
					// end gmerin
					
					// is this the first Message of a BES ?
					if (sourceBES.getStart() != null
							&& sourceBES.getStart().equals(sourceMOS)) {
						int y = yOffset;
						int x = calculateBESXOffset(interactionData,
								sourceLifeline)
								- (BES_Minimun_Size_X / 2);
						addStartBES(x, y, sourceBES, sourceLifeline,
								interactionData);
					}
					// is this the last Message of a BES ?
					if (sourceBES.getFinish() != null
							&& sourceBES.getFinish().equals(sourceMOS)) {
						int y = yOffset;
						addEndBES(BES_Minimun_Size_X, y, sourceBES,
								sourceLifeline, interactionData);
					}
				} // end source BES
				// do we have to create any BES at target ?
				if (target instanceof BehaviorExecutionSpecification) {
					BehaviorExecutionSpecification targetBES = (BehaviorExecutionSpecification) target;
					
					// added by gmerin
					addedBESList.add(targetBES);
					// end gmerin
					
					// is the first Message of a BES ?
					if (targetBES.getStart() != null
							&& targetBES.getStart().equals(targetMOS)) {
						int y = yOffset;
						int x = calculateBESXOffset(interactionData,
								targetLifeline)
								- (BES_Minimun_Size_X / 2);
						addStartBES(x, y, targetBES, targetLifeline,
								interactionData);
					}
					// is the last Message of a BES ?
					if (targetBES.getFinish() != null
							&& targetBES.getFinish().equals(targetMOS)) {
						int y = yOffset;
						addEndBES(BES_Minimun_Size_X, y, targetBES,
								targetLifeline, interactionData);
					}
				} // end target BES
				// init edge figure data
				EdgeInitDataFigure messageData = INSTANCE.new EdgeInitDataFigure();
				messageData.eObject = message;
				// a message won't have children
				messageData.children = Collections.EMPTY_LIST;
				// y will be the same for source and target
				int y = yOffset;
				int xOffsetSrc = 0, xOffsetDst = 0;
				// Modified by gmerin
				xOffsetSrc = calculateMessageEndXOffset(source,
						interactionData, true);
				xOffsetDst = calculateMessageEndXOffset(target,
						interactionData, false);
				// start and end point of the Message edge.
				messageData.start = new Point(xOffsetSrc, y);
				messageData.end = new Point(xOffsetDst, y);
				// add Message figure data
				interactionData.children.add(messageData);
			}
			// increase y offset
			yOffset += Message_Slot_Size_Y;
		}
		
		// Added by gmerin
		// All the BES that are ends of messages have been considered in the
		// above
		// code. Now is the turn of the BES that do not have messages anchored
		// to them
		int auxMaxYOffset = yOffset;
		for(Lifeline lifeline : interaction.getLifelines()) {
			int auxYOffset = yOffset;
			int auxXOffset = calculateLifelineXCenter(lifeline, interactionData)
					- BES_Minimun_Size_X / 2;
			
			List<BehaviorExecutionSpecification> notAddedBESList = MessageCommonUtil
					.getLifelineBESList(lifeline);
			notAddedBESList.removeAll(addedBESList);

			for (BehaviorExecutionSpecification bes : notAddedBESList) {
					addStartBES(auxXOffset, auxYOffset, bes, lifeline,
							interactionData);
					addEndBES(BES_Minimun_Size_X, auxYOffset, bes, lifeline,
						interactionData);
				auxYOffset += Message_Slot_Size_Y;
			}
			
			// Increase the height of the lifeline
			if (auxYOffset - yOffset > 0) {
				NodeInitDataFigure node = findElementNodeData(interactionData,
						lifeline);
				if (node != null && node.size != null)
					node.size.y += (auxYOffset - yOffset) + Message_BES_Offset
							* 2;
				// Update the auxMaxYOffset in case is bigger than before
				auxMaxYOffset = auxYOffset > auxMaxYOffset ? auxYOffset
						: auxMaxYOffset; 
			}
		}
		// Increase the height of the Interaction
		if (auxMaxYOffset - yOffset > 0) {
			if (interactionData.size != null)
				interactionData.size.y += (auxMaxYOffset - yOffset);
		}
		// end gmerin
	}

	/**
	 * Modified by gmerin
	 */
	protected static void addStartBES(int x, int y,
			BehaviorExecutionSpecification bes, Lifeline lifeline,
			NodeInitDataFigure interactionData) {
		NodeInitDataFigure BESData = startInitBESData(x, y, bes);
		NodeInitDataFigure lifelineData = findElementNodeData(interactionData,
				lifeline);
		if (lifelineData != null) {
			if (lifelineData.children == null) {
				lifelineData.children = new ArrayList<InitDataFigure>();
			}
			lifelineData.children.add(BESData);
		}
	}

	/**
	 * Modified by gmerin
	 */
	protected static void addEndBES(int width, int y,
			BehaviorExecutionSpecification bes, Lifeline lifeline,
			NodeInitDataFigure interactionData) {
		// get the NodeInitDataFigure corresponding to the Lifeline
		NodeInitDataFigure lifelineData = findElementNodeData(interactionData,
				lifeline);
		if (lifelineData == null || lifelineData.children == null
				|| lifelineData.children.size() <= 0) {
			return;
		}
		// look in that Lifeline children figures for a corresponding BES figure
		for (InitDataFigure dataFigure : lifelineData.children) {
			if (dataFigure != null && dataFigure.eObject != null
					&& dataFigure.eObject.equals(bes)) {
				if (dataFigure instanceof NodeInitDataFigure) {
					// correct BES figure found -> set size
					int initialY = ((NodeInitDataFigure) dataFigure).location.y;
					((NodeInitDataFigure) dataFigure).size = new Point(width,
							(y - initialY) + Message_BES_Offset);
				}
			}
		}
	}

	protected static NodeInitDataFigure initLifelineData(int xOffset,
			int yOffset, int width, int height, Lifeline lifeline) {
		NodeInitDataFigure lifelineData = INSTANCE.new NodeInitDataFigure();
		lifelineData.eObject = lifeline;
		lifelineData.location = new Point(xOffset, yOffset);
		lifelineData.size = new Point(width, height);
		lifelineData.children = new ArrayList<InitDataFigure>();
		return lifelineData;
	}

	protected static NodeInitDataFigure startInitBESData(int xOffset,
			int yOffset, BehaviorExecutionSpecification bes) {
		NodeInitDataFigure BESData = INSTANCE.new NodeInitDataFigure();
		BESData.eObject = bes;
		BESData.location = new Point(xOffset, yOffset - Message_BES_Offset);
		BESData.children = new ArrayList<InitDataFigure>();
		// no size, as we don't know yet the height
		BESData.size = new Point(0, 0);
		return BESData;
	}

	protected static NodeInitDataFigure endInitBESData(int width, int height,
			NodeInitDataFigure BESData) {
		if (BESData != null) {
			BESData.size = new Point(width, height);
		}
		return BESData;
	}

	/**
	 * Modified by gmerin
	 */
	protected static NodeInitDataFigure findElementNodeData(
			InitDataFigure rootData, Element element) {
		// sanity check
		if (rootData == null || element == null) {
			return null;
		}
		if (rootData.eObject != null && rootData.eObject.equals(element)) {
			return rootData instanceof NodeInitDataFigure ? (NodeInitDataFigure) rootData
					: null;
		}
		if (rootData.children == null || rootData.children.size() <= 0) {
			return null;
		}
		for (InitDataFigure dataFigure : rootData.children) {
			InitDataFigure elementDataFigure = findElementNodeData(dataFigure,
					element);
			if (elementDataFigure instanceof NodeInitDataFigure) {
				return (NodeInitDataFigure) elementDataFigure;
			}
		}
		return null;
	}

	protected static Lifeline getMOSLifeline(MessageOccurrenceSpecification mos) {
		if (mos == null) {
			return null;
		}
		if (mos.getCovereds().size() <= 0) {
			return null;
		}
		return mos.getCovereds().get(0);
	}

	// //** View creation **////

	public static void createViews(IGraphicalEditPart parentEditPart,
			NodeInitDataFigure interactionData) {
		// Map relating the EObjects and their EditParts
		Map<EObject, IGraphicalEditPart> mapEObject2EditPart = new HashMap<EObject, IGraphicalEditPart>();
		// create nodes views
		// - create Interaction View
		createInteractionView(interactionData, parentEditPart,
				mapEObject2EditPart);
		IGraphicalEditPart interactionEditPart = mapEObject2EditPart
				.get(interactionData.eObject);
		// - create Lifelines Views
		createLifelineViews(interactionData, interactionEditPart,
				mapEObject2EditPart);
		// - create BES Views
		createBESViews(interactionData, mapEObject2EditPart);
		// - create Message Views
		TransactionalEditingDomain domain = parentEditPart.getEditingDomain();
		createMessageViews(interactionData, parentEditPart, mapEObject2EditPart);
		// add element's created views to the Diagram list of references.
		if (parentEditPart.getNotationView() instanceof Diagram) {
			Diagram diagram = (Diagram) parentEditPart.getNotationView();
			Set<EObject> elements = mapEObject2EditPart.keySet();
			addReferencesToDiagram(diagram, elements, domain);
		}
	}

	protected static void createInteractionView(
			NodeInitDataFigure interactionData,
			IGraphicalEditPart parentEditPart,
			Map<EObject, IGraphicalEditPart> mapEObject2EditPart) {
		// - create Interaction View
		Interaction interaction = interactionData.eObject instanceof Interaction ? (Interaction) interactionData.eObject
				: null;
		String semanticHint = getInteractionSemanticHint(parentEditPart);
		ViewDescriptor interactionViewDescriptor = new ViewDescriptor(
				new EObjectAdapter(interactionData.eObject), Node.class,
				semanticHint, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		CreateViewRequest createInteractionViewRequest = new CreateViewRequest(
				interactionViewDescriptor);
		createInteractionViewRequest.setLocation(interactionData.location);
		createInteractionViewRequest.setSize(new Dimension(
				interactionData.size.x, interactionData.size.y));
		IGraphicalEditPart interactionEditPart = createView(parentEditPart,
				createInteractionViewRequest);
		if (interactionEditPart != null) {
			interactionEditPart.getFigure().getUpdateManager().performUpdate();
			mapEObject2EditPart.put(interactionData.eObject,
					interactionEditPart);
		}
	}

	protected static String getInteractionSemanticHint(
			IGraphicalEditPart parentEditPart) {
		if (parentEditPart == null
				|| parentEditPart.resolveSemanticElement() == null) {
			return null;
		}
		EObject element = parentEditPart.resolveSemanticElement();
		if (element instanceof Package) {
			return String.valueOf(InteractionEditPart.VISUAL_ID);
		} else if (element instanceof Interaction) {
			return String.valueOf(Interaction2EditPart.VISUAL_ID);
		}
		return null;
	}

	protected static void createLifelineViews(InitDataFigure interactionData,
			IGraphicalEditPart interactionEditPart,
			Map<EObject, IGraphicalEditPart> mapEObject2EditPart) {
		IGraphicalEditPart parentEditPart = null;
		for (Object child : interactionEditPart.getChildren()) {
			// careful here, a CompartmentEditPart is looked for here because we
			// know that it is applicable to the Interaction figure; other
			// figures may need other logic
			if (child instanceof CompartmentEditPart) {
				parentEditPart = (CompartmentEditPart) child;
			}
		}

		for (InitDataFigure dataFigure : interactionData.children) {
			if (dataFigure instanceof NodeInitDataFigure
					&& dataFigure.eObject instanceof Lifeline) {
				Lifeline lifeline = (Lifeline) dataFigure.eObject;
				IGraphicalEditPart createdEditPart = findLifelineEditPart(
						lifeline, mapEObject2EditPart);
				NodeInitDataFigure nodeDataFigure = (NodeInitDataFigure) dataFigure;
				if (createdEditPart != null) {
					// the view and its editpart already existed; we
					// destroy them to recreate them with the proper
					// location and size
					DeleteCommand deleteCommand = new DeleteCommand(
							createdEditPart.getNotationView());
					parentEditPart.getEditingDomain().getCommandStack()
							.execute(new GMFToEMFCommand(deleteCommand));
				}
				ViewDescriptor viewDescriptor = new ViewDescriptor(
						new EObjectAdapter(lifeline), Node.class, String
								.valueOf(LifelineEditPart.VISUAL_ID),
						UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				CreateViewRequest createViewRequest = new CreateViewRequest(
						viewDescriptor);
				createViewRequest.setLocation(nodeDataFigure.location);
				createViewRequest.setSize(new Dimension(nodeDataFigure.size.x,
						nodeDataFigure.size.y));
				createdEditPart = createView(parentEditPart, createViewRequest);
				if (createdEditPart != null) {
					createdEditPart.getFigure().getUpdateManager()
							.performUpdate();
					mapEObject2EditPart.put(nodeDataFigure.eObject,
							createdEditPart);
				}
			}
		}
	}

	protected static IGraphicalEditPart findLifelineEditPart(Lifeline lifeline,
			Map<EObject, IGraphicalEditPart> mapEObject2EditPart) {
		if (lifeline != null && mapEObject2EditPart != null) {
			Interaction interaction = lifeline.getInteraction();
			IGraphicalEditPart interactionEditPart = mapEObject2EditPart
					.get(interaction);
			if (interactionEditPart != null) {
				return searchEObjectInEditPart(lifeline, interactionEditPart);
			}
		}
		return null;
	}

	protected static Point calculateLocationDelta(IGraphicalEditPart editPart,
			Point finalLocation) {
		Point locationDelta = new Point(0, 0);
		if (editPart != null && finalLocation != null) {
			Rectangle bounds = editPart.getFigure().getBounds();
			locationDelta.x = finalLocation.x - bounds.x;
			locationDelta.y = finalLocation.y - bounds.y;
		}
		return locationDelta;
	}

	protected static Dimension calculateSizeDelta(IGraphicalEditPart editPart,
			Point finalSize) {
		Dimension dimensionDelta = new Dimension(0, 0);
		if (editPart != null && finalSize != null) {
			Rectangle bounds = editPart.getFigure().getBounds();
			dimensionDelta.width = finalSize.x - bounds.width;
			dimensionDelta.height = finalSize.y - bounds.height;
		}
		return dimensionDelta;
	}

	protected static IGraphicalEditPart searchEObjectInEditPart(
			EObject eObject, IGraphicalEditPart editPart) {
		if (eObject != null && editPart != null) {
			if (eObject.equals(editPart.resolveSemanticElement())) {
				return editPart;
			}
			for (Object childEditPart : editPart.getChildren()) {
				if (childEditPart instanceof IGraphicalEditPart) {
					IGraphicalEditPart foundEditPart = searchEObjectInEditPart(
							eObject, (IGraphicalEditPart) childEditPart);
					if (foundEditPart != null) {
						return foundEditPart;
					}
				}
			}
		}
		return null;
	}

	protected static void createBESViews(InitDataFigure interactionData,
			Map<EObject, IGraphicalEditPart> mapEObject2EditPart) {
		for (InitDataFigure dataFigure : interactionData.children) {
			if (dataFigure instanceof NodeInitDataFigure
					&& dataFigure.eObject instanceof Lifeline) {
				NodeInitDataFigure lifelineData = (NodeInitDataFigure) dataFigure;
				for (InitDataFigure initFigure : lifelineData.children) {
					if (initFigure instanceof NodeInitDataFigure
							&& initFigure.eObject instanceof BehaviorExecutionSpecification) {
						NodeInitDataFigure BESData = (NodeInitDataFigure) initFigure;
						BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) BESData.eObject;
						IGraphicalEditPart createdEditPart = findBESEditPart(
								bes, mapEObject2EditPart);
						IGraphicalEditPart parentEditPart = null;
						if (mapEObject2EditPart
								.containsKey(lifelineData.eObject)) {
							parentEditPart = mapEObject2EditPart
									.get(lifelineData.eObject);
						}
						if (createdEditPart != null) {
							// the view and its editpart already existed; we
							// destroy them to recreate them with the proper
							// location and size
							DeleteCommand deleteCommand = new DeleteCommand(
									createdEditPart.getNotationView());
							parentEditPart
									.getEditingDomain()
									.getCommandStack()
									.execute(new GMFToEMFCommand(deleteCommand));
						}
						ViewDescriptor viewDescriptor = new ViewDescriptor(
								new EObjectAdapter(BESData.eObject),
								Node.class,
								String
										.valueOf(BehaviorExecutionSpecificationEditPart.VISUAL_ID),
								UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
						CreateViewRequest createRequest = new CreateViewRequest(
								viewDescriptor);
						createRequest.setLocation(BESData.location);
						createRequest.setSize(new Dimension(BESData.size.x,
								BESData.size.y));
						if (parentEditPart != null) {
							createdEditPart = createView(parentEditPart,
									createRequest);
						}
						if (createdEditPart != null) {
							createdEditPart.getFigure().getUpdateManager()
									.performUpdate();
							mapEObject2EditPart.put(BESData.eObject,
									createdEditPart);
						}
					}
				}
			}
		}
	}

	protected static IGraphicalEditPart findBESEditPart(
			BehaviorExecutionSpecification bes,
			Map<EObject, IGraphicalEditPart> mapEObject2EditPart) {
		if (bes != null && bes.getCovereds().size() > 0
				&& mapEObject2EditPart != null) {
			Lifeline lifeline = bes.getCovereds().get(0);
			IGraphicalEditPart lifelineEditPart = mapEObject2EditPart
					.get(lifeline);
			if (lifelineEditPart != null) {
				return searchEObjectInEditPart(bes, lifelineEditPart);
			}
		}
		return null;
	}

	protected static Lifeline findContainerLifeline(Interaction interaction,
			BehaviorExecutionSpecification bes) {
		if (interaction == null || bes == null) {
			return null;
		}
		for (Lifeline lifeline : interaction.getLifelines()) {
			for (BehaviorExecutionSpecification childBes : MessageCommonUtil
					.getLifelineBESList(lifeline)) {
				if (bes.equals(childBes)) {
					return lifeline;
				}
			}
		}
		return null;
	}

	protected static void createMessageViews(InitDataFigure interactionData,
			IGraphicalEditPart parentEditPart,
			Map<EObject, IGraphicalEditPart> mapEObject2EditPart) {
		TransactionalEditingDomain domain = parentEditPart.getEditingDomain();
		if (domain != null) {
			for (InitDataFigure dataFigure : interactionData.children) {
				if (dataFigure instanceof EdgeInitDataFigure
						&& dataFigure.eObject instanceof Message) {
					EdgeInitDataFigure edgeFigure = (EdgeInitDataFigure) dataFigure;
					Message message = (Message) dataFigure.eObject;
					Element source = MessageCommonUtil.getMessageSrc(message);
					Element target = MessageCommonUtil.getMessageDst(message);
					String semanticHint = getMessageSemanticHint(message);
					IElementType type = getMessageElementType(message);
					UMLLinkDescriptor linkDescriptor = new UMLLinkDescriptor(
							source, target, message, type, Integer
									.valueOf(semanticHint));
					ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(
							linkDescriptor.getSemanticAdapter(), semanticHint,
							ViewUtil.APPEND, false,
							UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
					CreateConnectionViewRequest createRequest = new CreateConnectionViewRequest(
							viewDescriptor);
					createRequest.setLocation(edgeFigure.start);
					createRequest
							.setType(RequestConstants.REQ_CONNECTION_START);

					IGraphicalEditPart sourceEditPart = mapEObject2EditPart
							.get(source);
					if (sourceEditPart != null) {
						createRequest.setSourceEditPart(sourceEditPart);
						sourceEditPart.getCommand(createRequest);
						createRequest.setLocation(edgeFigure.end);
						createRequest
								.setType(RequestConstants.REQ_CONNECTION_END);
						IGraphicalEditPart targetEditPart = mapEObject2EditPart
								.get(target);
						if (targetEditPart != null) {
							createRequest.setTargetEditPart(targetEditPart);
							Command command = targetEditPart
									.getCommand(createRequest);
							if (command.canExecute() == false) {
								continue;
							}
							domain.getCommandStack().execute(
									new GEFtoEMFCommandWrapper(command));
							refreshEditPart(interactionData,
									mapEObject2EditPart);
							View view = getCreatedViewFromRequest(createRequest);
							if (view != null) {
								IGraphicalEditPart editPart = (IGraphicalEditPart) parentEditPart
										.getViewer().getEditPartRegistry().get(
												view);
								if (editPart != null) {
									mapEObject2EditPart.put(message, editPart);
								}
							}
						}
					}
				}
			} // for (figures)
		} // if (domain != null)
	}

	protected static void addReferencesToDiagram(Diagram diagram,
			Set<EObject> elements, TransactionalEditingDomain domain) {
		if (diagram == null || elements == null || elements.size() <= 0
				|| domain == null) {
			return;
		}
		List<EObject> eObjects = new ArrayList<EObject>(elements);
		AddEObjectReferencesToDiagram command = new AddEObjectReferencesToDiagram(
				domain, diagram, eObjects, false);
		domain.getCommandStack().execute(new GMFToEMFCommand(command));
	}

	protected static IGraphicalEditPart createView(
			IGraphicalEditPart parentEditPart, CreateViewRequest request) {
		if (getAndExecuteCommand(parentEditPart, request)) {
			View view = getCreatedViewFromRequest(request);
			if (view != null) {
				if (parentEditPart.getViewer().getEditPartRegistry()
						.containsKey(view)) {
					Object value = parentEditPart.getViewer()
							.getEditPartRegistry().get(view);
					if (value instanceof IGraphicalEditPart) {
						return (IGraphicalEditPart) value;
					}
				}
			}
		}
		return null;
	}

	protected static View getCreatedViewFromRequest(CreateViewRequest request) {
		View view = null;
		Object newObject = request.getNewObject();
		if (newObject instanceof List) {
			List<Object> adaptersList = ((List) newObject);
			for (int i = 0; i < adaptersList.size(); i++) {
				Object object = adaptersList.get(i);
				if (object instanceof IAdaptable) {
					Object adapted = ((IAdaptable) object)
							.getAdapter(View.class);
					if (adapted instanceof View) {
						view = (View) adapted;
					}
				}
			}
		}
		return view;
	}

	protected static View getCreatedViewFromRequest(
			CreateConnectionViewRequest request) {
		View view = null;
		Object newObject = request.getNewObject();
		if (newObject instanceof IAdaptable) {
			Object object = ((IAdaptable) newObject).getAdapter(View.class);
			if (object instanceof View) {
				view = ((View) object);
			}
		}
		return view;
	}

	protected static boolean getAndExecuteCommand(
			IGraphicalEditPart parentEditPart, Request request) {
		if (parentEditPart == null || parentEditPart.getEditingDomain() == null
				|| request == null) {
			return false;
		}
		Command command = parentEditPart.getCommand(request);
		if (command == null) {
			return false;
		}
		TransactionalEditingDomain domain = parentEditPart.getEditingDomain();
		domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		parentEditPart.refresh();
		return true;
	}

	protected static String getMessageSemanticHint(Message message) {
		String hint = "";
		if (message != null) {
			switch (message.getMessageSort().getValue()) {
			case MessageSort.SYNCH_CALL:
				hint = String.valueOf(MessageEditPart.VISUAL_ID);
				break;
			case MessageSort.ASYNCH_CALL:
				hint = String.valueOf(Message2EditPart.VISUAL_ID);
				break;
			case MessageSort.REPLY:
				hint = String.valueOf(Message3EditPart.VISUAL_ID);
				break;
			case MessageSort.ASYNCH_SIGNAL:
				hint = String.valueOf(Message4EditPart.VISUAL_ID);
				break;
			case MessageSort.CREATE_MESSAGE:
				hint = String.valueOf(Message5EditPart.VISUAL_ID);
				break;
			case MessageSort.DELETE_MESSAGE:
				hint = String.valueOf(Message6EditPart.VISUAL_ID);
				break;
			default:
				break;
			}
		}
		return hint;
	}

	protected static IElementType getMessageElementType(Message message) {
		IElementType type = null;
		if (message != null) {
			switch (message.getMessageSort().getValue()) {
			case MessageSort.SYNCH_CALL:
				type = UMLElementTypes.Message_3001;
				break;
			case MessageSort.ASYNCH_CALL:
				type = UMLElementTypes.Message_3002;
				break;
			case MessageSort.REPLY:
				type = UMLElementTypes.Message_3003;
				break;
			case MessageSort.ASYNCH_SIGNAL:
				type = UMLElementTypes.Message_3004;
				break;
			case MessageSort.CREATE_MESSAGE:
				type = UMLElementTypes.Message_3005;
				break;
			case MessageSort.DELETE_MESSAGE:
				type = UMLElementTypes.Message_3006;
				break;
			default:
				break;
			}
		}
		return type;
	}

	protected static void refreshEditPart(InitDataFigure dataFigure,
			Map<EObject, IGraphicalEditPart> mapEObject2EditPart) {
		if (dataFigure == null) {
			return;
		}
		IGraphicalEditPart editPart = null;
		if (dataFigure.eObject != null) {
			editPart = mapEObject2EditPart.get(dataFigure.eObject);
			if (editPart != null) {
				editPart.refresh();
			}
		}
		if (dataFigure.children == null) {
			return;
		}
		for (InitDataFigure childFigure : dataFigure.children) {
			refreshEditPart(childFigure, mapEObject2EditPart);
		}
	}
}
