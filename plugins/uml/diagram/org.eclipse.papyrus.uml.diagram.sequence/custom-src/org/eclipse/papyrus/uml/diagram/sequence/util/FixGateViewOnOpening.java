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

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateGateViewCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Message;

/**
 * This class fixes the missing view of gate for older version diagrams.
 * It also redirect the messages' ends to the new gate view if existed.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class FixGateViewOnOpening {

	public void fix(Diagram diagram) {
		TreeIterator<EObject> contents = diagram.eAllContents();
		while(contents.hasNext()) {
			EObject next = contents.next();
			if(!(next instanceof Shape)) {
				continue;
			}
			Shape shape = (Shape)next;
			EObject element = ViewUtil.resolveSemanticElement(shape);
			if(!isGateContainer(element)) {
				continue;
			}
			List<Gate> allGates = getAllGates(element);
			if(allGates.isEmpty()) {
				continue;
			}
			for(Gate gate : allGates) {
				doFix(diagram, shape, gate);
			}
		}
	}

	/**
	 * @param diagram
	 * @param gate
	 */
	private void doFix(Diagram diagram, Shape parent, Gate gate) {
		//Ignore CoRegion.
		if(UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID).equals(parent.getType())) {
			return;
		}
		View view = findPrimaryView(diagram, gate);
		if(view != null) {
			return;
		}
		Message message = gate.getMessage();
		//NPE happens.
		if(message == null) {
			return;
		}
		View messageView = findPrimaryView(diagram, message);
		Edge edge = null;
		if(messageView instanceof Edge) {
			edge = ((Edge)messageView);
		}
		Point location = null;
		Rectangle rect = getBounds(parent);
		if(message != null && edge != null) {
			if(gate == message.getReceiveEvent() && parent == edge.getTarget()) {
				location = getLocation(rect, edge.getTargetAnchor());
			} else if(gate == message.getSendEvent() && parent == edge.getSource()) {
				location = getLocation(rect, edge.getSourceAnchor());
			}
		}
		if(location == null) {
			int index = indexOfGate(gate);
			if(index != -1) {
				if(gate == message.getReceiveEvent()) {
					location = new Point(rect.x, rect.y + GateEditPart.DEFAULT_SIZE.height * index + 2);
				} else if(gate == message.getSendEvent()) {
					location = new Point(rect.right(), rect.y + GateEditPart.DEFAULT_SIZE.height * index + 2);
				}
			}
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
		CompositeCommand fixCommands = new CompositeCommand("Fix Gate View");
		CreateGateViewCommand command = new CreateGateViewCommand(editingDomain, new EObjectAdapter(parent), location, new EObjectAdapter(gate));
		fixCommands.add(command);
		if(message != null && edge != null) {
			SetConnectionEndsCommand redirectCommand = new SetConnectionEndsCommand(editingDomain, "Reset Message End");
			redirectCommand.setEdgeAdaptor(new EObjectAdapter(messageView));
			SetConnectionAnchorsCommand repairAnchorsCommand = new SetConnectionAnchorsCommand(editingDomain, "Repair Anchors on Gate");
			repairAnchorsCommand.setEdgeAdaptor(new EObjectAdapter(messageView));
			if(gate == message.getReceiveEvent() && parent == edge.getTarget()) {
				redirectCommand.setNewTargetAdaptor(command.getResult());
				repairAnchorsCommand.setNewTargetTerminal("(0,0.5)");
			} else if(gate == message.getSendEvent() && parent == edge.getSource()) {
				redirectCommand.setNewSourceAdaptor(command.getResult());
				repairAnchorsCommand.setNewSourceTerminal("(1,0.5)");
			}
			if(redirectCommand.canExecute()) {
				fixCommands.add(redirectCommand);
			}
			if(repairAnchorsCommand.canExecute()) {
				fixCommands.add(repairAnchorsCommand);
			}
		}
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(fixCommands));
	}

	private int indexOfGate(Gate gate) {
		if(gate == null || gate.eContainer() == null) {
			return -1;
		}
		EObject parent = gate.eContainer();
		if(parent instanceof CombinedFragment) {
			return ((CombinedFragment)parent).getCfragmentGates().indexOf(gate);
		} else if(parent instanceof InteractionUse) {
			return ((InteractionUse)parent).getActualGates().indexOf(gate);
		} else if(parent instanceof Interaction) {
			return ((Interaction)parent).getFormalGates().indexOf(gate);
		}
		return -1;
	}

	private Rectangle getBounds(Shape parent) {
		int width = ((Integer)getStructuralFeatureValue(parent, NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer)getStructuralFeatureValue(parent, NotationPackage.eINSTANCE.getSize_Height())).intValue();
		int x = ((Integer)getStructuralFeatureValue(parent, NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer)getStructuralFeatureValue(parent, NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		Dimension size = computePreferenceSize(parent);
		if(width <= 0) {
			width = size.width;
		}
		if(height <= 0) {
			height = size.height;
		}
		return new Rectangle(x, y, width, height);
	}

	private Dimension computePreferenceSize(Shape shape) {
		EObject element = ViewUtil.resolveSemanticElement(shape);
		String prefElementId = element.eClass().getName();
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(shape, prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(shape, prefElementId, PreferenceConstantHelper.HEIGHT);
		return new Dimension(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
	}

	private Object getStructuralFeatureValue(Shape shape, EStructuralFeature feature) {
		return ViewUtil.getPropertyValue(shape, feature, feature.getEContainingClass());
	}

	/**
	 * @param rect
	 * @param sourceAnchor
	 * @return
	 */
	private Point getLocation(Rectangle rect, Anchor sourceAnchor) {
		if(sourceAnchor instanceof IdentityAnchor) {
			String terminal = ((IdentityAnchor)sourceAnchor).getId();
			PrecisionPoint precise = SlidableAnchor.parseTerminalString(terminal);
			if(precise != null) {
				return new PrecisionPoint(rect.x + rect.width * precise.preciseX(), rect.y + rect.height * precise.preciseY());
			}
		}
		return null;
	}

	private View findPrimaryView(Diagram diagram, EObject target) {
		if(diagram == null || target == null) {
			return null;
		}
		TreeIterator<EObject> contents = diagram.eAllContents();
		while(contents.hasNext()) {
			EObject next = contents.next();
			if(!(next instanceof Shape || next instanceof Edge)) {
				continue;
			}
			View view = (View)next;
			EObject element = ViewUtil.resolveSemanticElement(view);
			if(target == element) {
				return findTopView(view, element);
			}
		}
		return null;
	}

	private View findTopView(View view, EObject element) {
		EObject eContainer = view.eContainer();
		if(eContainer instanceof View) {
			View containerView = (View)eContainer;
			EObject containerSemantic = ViewUtil.resolveSemanticElement(containerView);
			if(element == containerSemantic) {
				return findTopView(containerView, element);
			}
		}
		return view;
	}

	private List<Gate> getAllGates(EObject parent) {
		if(parent instanceof CombinedFragment) {
			return ((CombinedFragment)parent).getCfragmentGates();
		} else if(parent instanceof InteractionUse) {
			return ((InteractionUse)parent).getActualGates();
		} else if(parent instanceof Interaction) {
			return ((Interaction)parent).getFormalGates();
		}
		return Collections.emptyList();
	}

	private boolean isGateContainer(EObject eObject) {
		return eObject instanceof Interaction || eObject instanceof CombinedFragment || ((eObject instanceof InteractionUse));
	}
}
