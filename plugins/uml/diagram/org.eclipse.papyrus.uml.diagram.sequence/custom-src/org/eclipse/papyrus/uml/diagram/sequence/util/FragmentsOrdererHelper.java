/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * Ordering InteractionFragments of Interaction or InteractionOperand.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=403233
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class FragmentsOrdererHelper {

	private static final List<String> INTERACTION_FRAGMENT_HINTS = new ArrayList<String>();
	static {
		INTERACTION_FRAGMENT_HINTS.add(((IHintedType)UMLElementTypes.ActionExecutionSpecification_3006).getSemanticHint());
		INTERACTION_FRAGMENT_HINTS.add(((IHintedType)UMLElementTypes.BehaviorExecutionSpecification_3003).getSemanticHint());
		INTERACTION_FRAGMENT_HINTS.add(((IHintedType)UMLElementTypes.CombinedFragment_3004).getSemanticHint());
		INTERACTION_FRAGMENT_HINTS.add(((IHintedType)UMLElementTypes.CombinedFragment_3018).getSemanticHint());
		INTERACTION_FRAGMENT_HINTS.add(((IHintedType)UMLElementTypes.InteractionUse_3002).getSemanticHint());
		INTERACTION_FRAGMENT_HINTS.add(((IHintedType)UMLElementTypes.StateInvariant_3017).getSemanticHint());
	}

	/**
	 * Constructor.
	 * 
	 */
	private FragmentsOrdererHelper() {
	}

	private static boolean isCreatingFragments(EditPart parentEditPart, CreateViewAndElementRequest request) {
		if(request == null) {
			return false;
		}
		ViewAndElementDescriptor desc = request.getViewAndElementDescriptor();
		if(desc == null) {
			return false;
		}
		String semanticHint = desc.getSemanticHint();
		if(semanticHint == null) {
			return false;
		}
		if(INTERACTION_FRAGMENT_HINTS.contains(semanticHint)) {
			return true;
		}
		//PartDecomposition
		else if(parentEditPart instanceof LifelineEditPart && ((IHintedType)UMLElementTypes.Lifeline_3001).getSemanticHint().equals(semanticHint)) {
			return true;
		}
		return false;
	}

	private static TransactionalEditingDomain getEditingDomain(EditPart editPart) {
		if(editPart == null) {
			return null;
		}
		IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart)editPart.getAdapter(IGraphicalEditPart.class);
		if(graphicalEditPart != null) {
			return graphicalEditPart.getEditingDomain();
		}
		return null;
	}

	public static Command createOrderingFragmentsCommand(final EditPart anyEditPart, final ReconnectRequest request) {
		if(anyEditPart == null || request == null || request.getConnectionEditPart() == null) {
			return null;
		}
		return new ICommandProxy(new AbstractTransactionalCommand(getEditingDomain(anyEditPart), "", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				final Map<View, Float[]> viewPositions = new HashMap<View, Float[]>();
				ConnectionEditPart conn = request.getConnectionEditPart();
				if(conn != null) {
					//					View view = (View)conn.getAdapter(View.class);
					//					if(RequestConstants.REQ_RECONNECT_SOURCE.equals(request.getType())) {
					//						Point location = request.getLocation().getCopy();
					//						Float[] positions = new Float[2];
					//						positions[0] = Float.valueOf(location.y);
					//						viewPositions.put(view, positions);
					//					} else if(RequestConstants.REQ_RECONNECT_SOURCE.equals(request.getType())) {
					//						Point location = request.getLocation().getCopy();
					//						Float[] positions = new Float[2];
					//						positions[1] = Float.valueOf(location.y);
					//						viewPositions.put(view, positions);
					//					}
					orderingFragments(conn, viewPositions);
				}
				return CommandResult.newOKCommandResult();
			}
		});
	}

	public static Command createOrderingFragmentsCommand(final EditPart anyEditPart, final CreateConnectionViewAndElementRequest request) {
		if(anyEditPart == null || request == null) {
			return null;
		}
		return new ICommandProxy(new AbstractTransactionalCommand(getEditingDomain(anyEditPart), "", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				final Map<View, Float[]> viewPositions = new HashMap<View, Float[]>();
				ConnectionViewAndElementDescriptor desc = request.getConnectionViewAndElementDescriptor();
				if(desc != null) {
					View view = (View)desc.getAdapter(View.class);
					if(view instanceof Edge) {
						Point location = request.getLocation().getCopy();
						Float[] positions = new Float[2];
						positions[1] = Float.valueOf(location.y);
						Object sourceLoc = request.getExtendedData().get(SequenceRequestConstant.SOURCE_LOCATION_DATA);
						if(sourceLoc instanceof Point) {
							positions[0] = Float.valueOf(((Point)sourceLoc).y);
						}
						viewPositions.put(view, positions);
					}
					orderingFragments(DiagramEditPartsUtil.getEditPartFromView(view, anyEditPart), viewPositions);
				}
				return CommandResult.newOKCommandResult();
			}
		});
	}

	public static ICommand createOrderingFragmentsCommand(final EditPart parentEditPart, final CreateViewAndElementRequest request) {
		if(parentEditPart == null || request == null || !isCreatingFragments(parentEditPart, request)) {
			return null;
		}
		return new AbstractTransactionalCommand(getEditingDomain(parentEditPart), "", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				final Map<View, Float[]> viewPositions = new HashMap<View, Float[]>();
				ViewAndElementDescriptor desc = request.getViewAndElementDescriptor();
				if(desc != null) {
					View view = (View)desc.getAdapter(View.class);
					if(view != null) {
						Point location = request.getLocation().getCopy();
						if(parentEditPart instanceof IGraphicalEditPart) {
							((IGraphicalEditPart)parentEditPart).getFigure().translateToRelative(location);
							location.y -= ((IGraphicalEditPart)parentEditPart).getFigure().getBounds().y;
						}
						viewPositions.put(view, new Float[]{ Float.valueOf(location.y) });
					}
				}
				orderingFragments(parentEditPart, viewPositions);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private static Set<IGraphicalEditPart> getFragmentRootEditPart(EditPart editPart) {
		if(editPart == null) {
			return null;
		}
		IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart)editPart.getAdapter(IGraphicalEditPart.class);
		if(graphicalEditPart instanceof InteractionEditPart || graphicalEditPart instanceof InteractionOperandEditPart) {
			Set<IGraphicalEditPart> rootEditParts = new HashSet<IGraphicalEditPart>();
			rootEditParts.add(graphicalEditPart);
			return rootEditParts;
		} else if(graphicalEditPart instanceof AbstractMessageEditPart) {
			Set<IGraphicalEditPart> rootEditParts = new HashSet<IGraphicalEditPart>();
			EObject element = graphicalEditPart.resolveSemanticElement();
			Set<EObject> enclosingParents = new HashSet<EObject>();
			if(element instanceof Message) {
				MessageEnd receiveEvent = ((Message)element).getReceiveEvent();
				if(receiveEvent instanceof OccurrenceSpecification) {
					Interaction enclosingInteraction = ((OccurrenceSpecification)receiveEvent).getEnclosingInteraction();
					if(enclosingInteraction != null) {
						enclosingParents.add(enclosingInteraction);
					}
					InteractionOperand enclosingOperand = ((OccurrenceSpecification)receiveEvent).getEnclosingOperand();
					if(enclosingOperand != null) {
						enclosingParents.add(enclosingOperand);
					}
				}
				MessageEnd sendEvent = ((Message)element).getSendEvent();
				if(sendEvent instanceof OccurrenceSpecification) {
					Interaction enclosingInteraction = ((OccurrenceSpecification)sendEvent).getEnclosingInteraction();
					if(enclosingInteraction != null) {
						enclosingParents.add(enclosingInteraction);
					}
					InteractionOperand enclosingOperand = ((OccurrenceSpecification)sendEvent).getEnclosingOperand();
					if(enclosingOperand != null) {
						enclosingParents.add(enclosingOperand);
					}
				}
			}
			if(enclosingParents != null) {
				for(EObject eObject : enclosingParents) {
					List<?> views = DiagramEditPartsUtil.getEObjectViews(eObject);
					for(Object object : views) {
						View view = (View)object;
						EditPart root = DiagramEditPartsUtil.getEditPartFromView(view, editPart);
						if(root instanceof IGraphicalEditPart) {
							rootEditParts.add((IGraphicalEditPart)root);
						}
					}
				}
			}
			return rootEditParts;
		}
		return getFragmentRootEditPart(editPart.getParent());
	}

	public static void orderingFragments(EditPart anyEditPart, Map<View, Float[]> viewPositions) {
		Set<IGraphicalEditPart> fragmentRootEditParts = getFragmentRootEditPart(anyEditPart);
		if(fragmentRootEditParts == null || fragmentRootEditParts.isEmpty()) {
			return;
		}
		for(IGraphicalEditPart fragmentRootEditPart : fragmentRootEditParts) {
			FragmentsOrderer fragmentsOrderer = new FragmentsOrderer(fragmentRootEditPart);
			if(viewPositions != null) {
				Set<Entry<View, Float[]>> entrySet = viewPositions.entrySet();
				for(Entry<View, Float[]> entry : entrySet) {
					fragmentsOrderer.addCachePosition(entry.getKey(), entry.getValue());
				}
			}
			fragmentsOrderer.ordering();
		}
	}
}
