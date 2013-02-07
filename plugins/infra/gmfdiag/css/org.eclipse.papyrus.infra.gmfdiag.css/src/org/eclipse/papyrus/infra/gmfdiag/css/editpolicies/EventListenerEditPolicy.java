/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.editpolicies;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.StatefulView;
import org.w3c.dom.Element;

/**
 * An EditPolicy to handle events on EditParts
 * 
 * @author Camille Letavernier
 * @see StatefulView
 */
public class EventListenerEditPolicy extends AbstractEditPolicy implements EditPolicy, FocusListener, EditPartListener, MouseMotionListener {

	public static final String ROLE = "EVENT_LISTENER";

	public EventListenerEditPolicy() {
		//Nothing
	}

	/**
	 * Does nothing by default.
	 * 
	 * @see org.eclipse.gef.EditPolicy#activate()
	 */
	@Override
	public void activate() {
		getHost().getFigure().addFocusListener(this);
		getHost().getFigure().addMouseMotionListener(this);
		getHost().addEditPartListener(this);
	}

	/**
	 * Does nothing by default.
	 * 
	 * @see org.eclipse.gef.EditPolicy#deactivate()
	 */
	@Override
	public void deactivate() {
		getHost().getFigure().removeFocusListener(this);
		getHost().getFigure().removeMouseMotionListener(this);
		getHost().removeEditPartListener(this);
	}


	//Event support

	private final Set<String> state = new HashSet<String>();

	private void removeState(String... states) {
		Set<String> statesToRemove = new HashSet<String>();
		for(String state : states) {
			statesToRemove.add(state);
		}

		this.state.removeAll(statesToRemove);
		StatefulView view = getDomElement();
		if(view != null) {
			view.removeStates(statesToRemove);
		}
	}

	private void addState(String... states) {
		Set<String> newStates = new HashSet<String>();
		for(String state : states) {
			newStates.add(state);
		}

		this.state.addAll(newStates);
		StatefulView view = getDomElement();
		if(view != null) {
			view.addStates(newStates);
		}
	}

	private StatefulView getDomElement() {
		EventListenerEditPolicy primaryEditPolicy = getPrimaryEditPolicy();

		if(primaryEditPolicy == this) {
			View view = getSemanticView();
			if(view.getDiagram() instanceof CSSDiagram) {
				Element domElement = ((CSSDiagram)view.getDiagram()).getEngine().getElement(view);
				if(domElement instanceof StatefulView) {
					return (StatefulView)domElement;
				}
			}
		} else if(primaryEditPolicy != null) {
			return primaryEditPolicy.getDomElement();
		}
		return null;
	}

	protected View getSemanticView() {
		return (View)getHost().getModel();
	}

	private EventListenerEditPolicy getPrimaryEditPolicy() {
		EditPart current = getHost();
		EditPart parent = current.getParent();

		while(parent != null && semanticCompareEditParts(parent, getHost())) {
			current = parent;
			parent = parent.getParent();
		}

		return (EventListenerEditPolicy)current.getEditPolicy(ROLE);
	}

	private boolean semanticCompareEditParts(EditPart one, EditPart other) {
		if(one.getModel() instanceof View && other.getModel() instanceof View) {
			View view1 = (View)one.getModel();
			View view2 = (View)other.getModel();
			return view1 != null && view2 != null && view1.getElement() == view2.getElement();
		}
		return false;
	}

	//The state is the union of all children states (e.g. if my compartment is hovered, then I am hovered)
	//Only children edit parts related to the same semantic element are taken into account
	//e.g. if a Class' property is hovered, the Class is *not* hovered
	public Set<String> getState() {
		Set<String> state = this.state;

		Collection<EditPart> childEditParts = getChildEditParts();

		for(EditPart editPart : childEditParts) {
			EventListenerEditPolicy childEditPolicy = getEditPolicy(editPart);
			if(childEditPolicy != null) {
				Set<String> childState = childEditPolicy.getState();
				state.addAll(childState);
			}
		}

		return state;
	}

	private EventListenerEditPolicy getEditPolicy(EditPart editPart) {
		return (EventListenerEditPolicy)editPart.getEditPolicy(ROLE);
	}

	private Collection<EditPart> getChildEditParts() {
		List<EditPart> result = new LinkedList<EditPart>();
		for(Object editPart : getHost().getChildren()) {
			if(semanticCompareEditParts(getHost(), (EditPart)editPart)) {
				result.add((EditPart)editPart);
			}
		}
		return result;
	}

	//Helper method: casts the host edit part to the right type.
	@Override
	public GraphicalEditPart getHost() {
		return (GraphicalEditPart)super.getHost();
	}

	/*
	 * Events support
	 */
	public void selectedStateChanged(EditPart editpart) {
		if((editpart.getSelected() & (EditPart.SELECTED_PRIMARY | EditPart.SELECTED)) != 0) {
			addState(StatefulView.ACTIVE, StatefulView.FOCUS);
		} else {
			removeState(StatefulView.ACTIVE, StatefulView.FOCUS);
		}
	}

	public void focusGained(FocusEvent fe) {
		addState(StatefulView.FOCUS);
	}

	public void focusLost(FocusEvent fe) {
		removeState(StatefulView.FOCUS);
	}

	public void mouseEntered(MouseEvent me) {
		addState(StatefulView.HOVER);
	}

	public void mouseExited(MouseEvent me) {
		removeState(StatefulView.HOVER);
	}

	public void mouseHover(MouseEvent me) {
		addState(StatefulView.HOVER);
	}


	/*
	 * Ignored events
	 */

	public void mouseMoved(MouseEvent me) {
		//Ignore
	}

	public void mouseDragged(MouseEvent me) {
		//Ignore
	}

	public void childAdded(EditPart child, int index) {
		//Ignore
	}

	public void partActivated(EditPart editpart) {
		//Ignore
	}

	public void partDeactivated(EditPart editpart) {
		//Ignore
	}

	public void removingChild(EditPart child, int index) {
		//Ignore
	}

}
