/*****************************************************************************
 * Copyright (c) 2010 CEA
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
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.locator.GateLocator;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class GateHelper {

	private static final String CF_GATE_DATA = "CombinedFragment.InnerGate";

	private static final String CF_GATE_INSIDE = "insideCF";

	private static final String CF_GATE_OUTSIDE = "outsideCF";

	/**
	 * Constructor.
	 * 
	 */
	private GateHelper() {
	}

	/**
	 * Create and add View for Gate.
	 * 
	 * @param containerView
	 * @param gate
	 * @param innerGate
	 *        for CombinedFragment.
	 * @return
	 */
	public static View createView(View containerView, Gate gate) {
		if(containerView == null || gate == null) {
			return null;
		}
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setType(GateEditPart.GATE_TYPE);
		node.setElement(gate);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		ViewUtil.insertChildView(containerView, node, ViewUtil.APPEND, true);
		//label
		DecorationNode label = NotationFactory.eINSTANCE.createDecorationNode();
		label.setType(GateNameEditPart.GATE_NAME_TYPE);
		ViewUtil.insertChildView(node, label, ViewUtil.APPEND, true);
		return node;
	}

	/**
	 * Constraints:
	 * 1. The message leading to/from an actualGate of an InteractionUse must correspond to the message leading from/to the
	 * formalGate with the same name of the Interaction referenced by the InteractionUse.
	 * 2. The message leading to/from an (expression) Gate within a CombinedFragment must correspond to the message leading
	 * from/to the CombinedFragment on its outside.
	 */
	public static Gate createGate(Element parent, boolean createInnerCFGate) {
		if(parent == null) {
			return null;
		}
		String name = generateGateName(parent, "gate");
		Gate gate = null;
		if(parent instanceof Interaction) {
			gate = ((Interaction)parent).getFormalGate(name, false, true);
		} else if(parent instanceof CombinedFragment) {
			gate = ((CombinedFragment)parent).getCfragmentGate(name, false, true);
			if(createInnerCFGate) {
				Gate innerGate = ((CombinedFragment)parent).createCfragmentGate(generateGateName(parent, "gate"));
				EAnnotation ann = innerGate.createEAnnotation(CF_GATE_DATA);
				ann.getDetails().put(CF_GATE_OUTSIDE, getIdentification(gate));
				ann = gate.createEAnnotation(CF_GATE_DATA);
				ann.getDetails().put(CF_GATE_INSIDE, getIdentification(innerGate));
			}
		} else if(parent instanceof InteractionUse) {
			InteractionUse interactionUse = (InteractionUse)parent;
			Interaction refersTo = interactionUse.getRefersTo();
			if(refersTo != null) {
				refersTo.getFormalGate(name, false, true);
				gate = interactionUse.getActualGate(name, false, true);
			}
		}
		return gate;
	}

	protected static String getIdentification(Gate gate) {
		if(gate == null) {
			return null;
		}
		if(gate.eResource() != null) {
			return gate.eResource().getURIFragment(gate);
		} else {
			return gate.getName();
		}
	}

	protected static Gate findGate(CombinedFragment cf, String identification) {
		if(cf == null || identification == null) {
			return null;
		}
		if(cf.eResource() != null) {
			EObject eObject = cf.eResource().getEObject(identification);
			if(eObject instanceof Gate) {
				return (Gate)eObject;
			}
		}
		return cf.getCfragmentGate(identification);
	}

	public static Gate getInnerCFGate(Gate outerGate) {
		if(outerGate == null || !(outerGate.eContainer() instanceof CombinedFragment)) {
			return null;
		}
		CombinedFragment cf = (CombinedFragment)outerGate.eContainer();
		EAnnotation ann = outerGate.getEAnnotation(CF_GATE_DATA);
		if(ann != null) {
			String name = ann.getDetails().get(CF_GATE_INSIDE);
			return findGate(cf, name);
		}
		return null;
	}

	public static Gate getOuterCFGate(Gate innerGate) {
		if(innerGate == null || !(innerGate.eContainer() instanceof CombinedFragment)) {
			return null;
		}
		CombinedFragment cf = (CombinedFragment)innerGate.eContainer();
		EAnnotation ann = innerGate.getEAnnotation(CF_GATE_DATA);
		if(ann != null) {
			String name = ann.getDetails().get(CF_GATE_OUTSIDE);
			return findGate(cf, name);
		}
		return null;
	}

	public static boolean isInnerCFGate(Gate gate) {
		if(gate == null || !(gate.eContainer() instanceof CombinedFragment)) {
			return false;
		}
		CombinedFragment cf = (CombinedFragment)gate.eContainer();
		EAnnotation ann = gate.getEAnnotation(CF_GATE_DATA);
		if(ann != null) {
			String name = ann.getDetails().get(CF_GATE_OUTSIDE);
			return findGate(cf, name) != null;
		}
		return false;
	}

	public static Message getOuterCFMessage(Message message) {
		if(message == null) {
			return null;
		}
		MessageEnd sendEvent = message.getSendEvent();
		if(sendEvent instanceof Gate) {
			Gate gate = (Gate)sendEvent;
			if(!isInnerCFGate(gate)) {
				return null;
			}
			Gate outerGate = getOuterCFGate(gate);
			if(outerGate != null) {
				return outerGate.getMessage();
			}
		}
		MessageEnd receiveEvent = message.getReceiveEvent();
		if(receiveEvent instanceof Gate) {
			Gate gate = (Gate)receiveEvent;
			if(!isInnerCFGate(gate)) {
				return null;
			}
			Gate outerGate = getOuterCFGate(gate);
			if(outerGate != null) {
				return outerGate.getMessage();
			}
		}
		return null;
	}

	public static Gate getActualGate(Gate gate) {
		if(gate == null || !(gate.eContainer() instanceof Interaction)) {
			return null;
		}
		Interaction interaction = (Interaction)gate.eContainer();
		List<InteractionUse> refersToBy = findRefersToBy(interaction);
		for(InteractionUse interactionUse : refersToBy) {
			Gate actualGate = interactionUse.getActualGate(gate.getName());
			if(actualGate != null) {
				return actualGate;
			}
		}
		return null;
	}

	public static List<InteractionUse> findRefersToBy(Interaction interaction) {
		if(interaction == null) {
			return Collections.emptyList();
		}
		List<InteractionUse> refersToBy = new ArrayList<InteractionUse>();
		Resource eResource = interaction.eResource();
		if(eResource != null) {
			ResourceSet resourceSet = eResource.getResourceSet();
			if(resourceSet != null) {
				EList<Resource> resources = resourceSet.getResources();
				for(Resource resource : resources) {
					TreeIterator<EObject> contents = resource.getAllContents();
					while(contents.hasNext()) {
						EObject next = contents.next();
						if(next instanceof InteractionUse && interaction == ((InteractionUse)next).getRefersTo()) {
							refersToBy.add((InteractionUse)next);
						}
					}
				}
			} else {
				TreeIterator<EObject> contents = eResource.getAllContents();
				while(contents.hasNext()) {
					EObject next = contents.next();
					if(next instanceof InteractionUse && interaction == ((InteractionUse)next).getRefersTo()) {
						refersToBy.add((InteractionUse)next);
					}
				}
			}
		} else {
			EList<InteractionFragment> fragments = interaction.getFragments();
			for(InteractionFragment fragment : fragments) {
				if(!(fragment instanceof InteractionUse)) {
					continue;
				}
				if(interaction == ((InteractionUse)fragment).getRefersTo()) {
					refersToBy.add(((InteractionUse)fragment));
				}
			}
		}
		return refersToBy;
	}

	/**
	 * Generate name for Gate.
	 * 
	 * @param container
	 * @param object
	 * @param direction
	 * @return
	 */
	public static String generateGateName(EObject container, String suffix) {
		String name = suffix;
		if(container instanceof Interaction) {
			Interaction interaction = (Interaction)container;
			if(interaction.getFormalGate(name) != null) {
				int index = 0;
				String gateName = name + index;
				while(interaction.getFormalGate(gateName = name + index) != null) {
					index++;
				}
				name = gateName;
			}
		} else if(container instanceof InteractionUse) {
			InteractionUse iUse = (InteractionUse)container;
			if(iUse.getActualGate(name) != null) {
				int index = 0;
				String gateName = name + index;
				while(iUse.getActualGate(gateName = name + index) != null) {
					index++;
				}
				name = gateName;
			}
		} else if(container instanceof CombinedFragment) {
			CombinedFragment cf = (CombinedFragment)container;
			if(cf.getCfragmentGate(name) != null) {
				int index = 0;
				String gateName = name + index;
				while(cf.getCfragmentGate(gateName = name + index) != null) {
					index++;
				}
				name = gateName;
			}
		}
		return name;
	}

	public static Point computeGateLocation(Point pt, IFigure hostFigure, IFigure gateFigure) {
		if(pt == null || hostFigure == null) {
			return pt;
		}
		Point location = pt.getCopy();
		Rectangle bounds = new Rectangle(location, GateEditPart.DEFAULT_SIZE);
		hostFigure.translateToRelative(bounds);
		GateLocator locator = new GateLocator(hostFigure);
		locator.getValidLocation(bounds, gateFigure);
		return bounds.getLocation().getTranslated(0, -GateEditPart.DEFAULT_SIZE.height / 2 - 1);
	}
}
