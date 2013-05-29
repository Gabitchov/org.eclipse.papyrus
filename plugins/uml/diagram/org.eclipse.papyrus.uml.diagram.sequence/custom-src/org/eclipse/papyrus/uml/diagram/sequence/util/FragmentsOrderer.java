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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.PartDecomposition;

/**
 * Ordering InteractionFragments of Interaction or InteractionOperand.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=403233
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class FragmentsOrderer {

	private static final float HALF_UNIT = 0.5f;

	private static final float CONVERT_UNIT = 1.0f;

	/**
	 * Interaction or InteractionOperand.
	 */
	private InteractionFragment fragmentRoot;

	private IGraphicalEditPart fragmentRootEditPart;

	private Map<InteractionFragment, Float> fragmentPositions;

	private Map<InteractionFragment, Integer> fragmentIndexes;

	private Map<View, Float[]> cachePositions;

	/**
	 * Constructor.
	 * 
	 */
	public FragmentsOrderer(IGraphicalEditPart fragmentRootEditPart) {
		this.fragmentRootEditPart = fragmentRootEditPart;
	}

	public void addCachePosition(View view, Float[] position) {
		if(cachePositions == null) {
			cachePositions = new HashMap<View, Float[]>(1);
		}
		cachePositions.put(view, position);
	}

	private boolean prepared() {
		if(fragmentRootEditPart == null) {
			return false;
		}
		EObject element = fragmentRootEditPart.resolveSemanticElement();
		if(element instanceof Interaction || element instanceof InteractionOperand) {
			fragmentRoot = (InteractionFragment)element;
		} else {
			return false;
		}
		//compute fragment position;
		fragmentPositions = new HashMap<InteractionFragment, Float>();
		//compute new indexes.
		fragmentIndexes = new HashMap<InteractionFragment, Integer>();
		EList<InteractionFragment> orderingFragments = getOrderingFragments();
		return orderingFragments != null && !orderingFragments.isEmpty();
	}

	/**
	 * Compute indexes with vertical position.
	 */
	private void computeNewIndexes() {
		fragmentIndexes.clear();
		computePositions();
		List<Entry<InteractionFragment, Float>> positionalEntries = new ArrayList<Map.Entry<InteractionFragment, Float>>(fragmentPositions.entrySet());
		Collections.sort(positionalEntries, new Comparator<Map.Entry<InteractionFragment, Float>>() {

			public int compare(Entry<InteractionFragment, Float> o1, Entry<InteractionFragment, Float> o2) {
				Float v1 = o1.getValue();
				Float v2 = o2.getValue();
				if(v1 != null && v2 != null) {
					if(v1 < v2) {
						return -1;
					} else if(v1 > v2) {
						return 1;
					}
				}
				return 0;
			}
		});
		for(int i = 0; i < positionalEntries.size(); i++) {
			Entry<InteractionFragment, Float> entry = positionalEntries.get(i);
			fragmentIndexes.put(entry.getKey(), i);
		}
	}

	private EList<InteractionFragment> getOrderingFragments() {
		EList<InteractionFragment> fragments = null;
		if(fragmentRoot instanceof Interaction) {
			fragments = ((Interaction)fragmentRoot).getFragments();
		} else if(fragmentRoot instanceof InteractionOperand) {
			fragments = ((InteractionOperand)fragmentRoot).getFragments();
		}
		return fragments;
	}

	private View getGraphicalView(EObject eObj) {
		if(eObj instanceof ExecutionOccurrenceSpecification) {
			ExecutionSpecification execution = ((ExecutionOccurrenceSpecification)eObj).getExecution();
			return getGraphicalView(execution);
		} else if(eObj instanceof MessageOccurrenceSpecification) {
			return getGraphicalView(((MessageOccurrenceSpecification)eObj).getMessage());
		} else if(eObj instanceof PartDecomposition) {
			EList<Lifeline> covereds = ((PartDecomposition)eObj).getCovereds();
			if(covereds.size() == 1) {
				return getGraphicalView(covereds.get(0));
			}
		} else if(eObj != null) {
			List<?> views = DiagramEditPartsUtil.getEObjectViews(eObj);
			if(views.size() == 1) {
				return (View)views.get(0);
			}
			return null;
		}
		return null;
	}

	private Float getPosition(InteractionFragment fragment) {
		if(fragment == null) {
			return null;
		}
		View view = getGraphicalView(fragment);
		if(view == null) {
			return null;
		}
		Float[] preferPosition = cachePositions != null ? cachePositions.get(view) : null;
		EObject hostElement = ViewUtil.resolveSemanticElement(view);
		EditPart editPart = DiagramEditPartsUtil.getEditPartFromView(view, fragmentRootEditPart);
		if(fragment instanceof MessageOccurrenceSpecification && hostElement instanceof Message && editPart instanceof ConnectionNodeEditPart) {
			boolean isStart = fragment == ((Message)hostElement).getSendEvent();
			Point location = getAbsoluteEdgeExtremity((ConnectionNodeEditPart)editPart, isStart, preferPosition);
			if(location != null) {
				return isStart ? location.y - HALF_UNIT : location.y + HALF_UNIT;
			}
		} else if(fragment instanceof ExecutionOccurrenceSpecification && hostElement instanceof ExecutionSpecification && editPart instanceof IGraphicalEditPart) {
			Rectangle bounds = getAbsoluteBounds((IGraphicalEditPart)editPart, preferPosition);
			if(bounds != null) {
				if(bounds.height <= 0) {
					bounds.height = 50;//LifelineXYLayoutEditPolicy.EXECUTION_INIT_HEIGHT;
				}
				if(fragment == ((ExecutionSpecification)hostElement).getStart()) {
					return bounds.y - HALF_UNIT;
				} else {
					return bounds.bottom() + HALF_UNIT;
				}
			}
		} else if(view instanceof Shape && editPart instanceof IGraphicalEditPart) {
			Rectangle bounds = getAbsoluteBounds((IGraphicalEditPart)editPart, preferPosition);
			if(bounds != null) {
				return bounds.y * CONVERT_UNIT;
			}
		}
		return null;
	}

	private Point getAbsoluteEdgeExtremity(ConnectionNodeEditPart editPart, boolean isStart, Float[] preferPosition) {
		if(editPart == null) {
			return null;
		}
		PointList points = editPart.getConnectionFigure().getPoints().getCopy();
		if(points.size() == 2 && new Point(0, 0).equals(points.getFirstPoint()) && new Point(100, 100).equals(points.getLastPoint())) {
			//not display yet.
			if(preferPosition != null) {
				if(isStart && preferPosition[0] != null) {
					return new Point(0, preferPosition[0].intValue());
				} else if(!isStart && preferPosition[1] != null) {
					return new Point(0, preferPosition[1].intValue());
				}
			}
			return SequenceUtil.getAbsoluteEdgeExtremity(editPart, isStart, false);
		}
		return SequenceUtil.getAbsoluteEdgeExtremity(editPart, isStart, true);
	}

	private Rectangle getAbsoluteBounds(IGraphicalEditPart editPart, Float[] preferPosition) {
		if(editPart == null) {
			return null;
		}
		Rectangle rect = editPart.getFigure().getBounds().getCopy();
		if(rect.isEmpty() && rect.x == 0 && rect.y == 0) {//Not displayed yet.
			View view = editPart.getNotationView();
			if(view instanceof Node) {
				LayoutConstraint constraint = ((Node)view).getLayoutConstraint();
				if(constraint instanceof Bounds) {
					Bounds bounds = (Bounds)constraint;
					if(bounds.getX() > 0) {
						rect.x = bounds.getX();
					}
					if(bounds.getY() > 0) {
						rect.y = bounds.getY();
					} else if(preferPosition != null && preferPosition.length > 0 && preferPosition[0] != null) {
						rect.y = preferPosition[0].intValue();
					}
					if(bounds.getWidth() != -1) {
						rect.width = bounds.getWidth();
					}
					if(bounds.getHeight() != -1) {
						rect.height = bounds.getHeight();
					}
				}
			}
			Rectangle parentRect = getAbsoluteBounds((IGraphicalEditPart)editPart.getParent(), null);
			rect.x += parentRect.x;
			rect.y += parentRect.y;
		} else {
			rect = SequenceUtil.getAbsoluteBounds(editPart);
		}
		return rect;
	}

	public void ordering() {
		if(prepared()) {
			safelyChangeOrder();
		}
		clear();
	}

	/**
	 * @param orderingFragments
	 */
	protected void computePositions() {
		final EList<InteractionFragment> orderingFragments = getOrderingFragments();
		if(orderingFragments == null || orderingFragments.isEmpty()) {
			return;
		}
		for(InteractionFragment fragment : orderingFragments) {
			Float newPos = getPosition(fragment);
			fragmentPositions.put(fragment, newPos);
		}
	}

	private void clear() {
		if(fragmentIndexes != null) {
			fragmentIndexes.clear();
			fragmentIndexes = null;
		}
		if(fragmentPositions != null) {
			fragmentPositions.clear();
			fragmentPositions = null;
		}
		fragmentRoot = null;
	}

	/**
	 * This method should be called with write Transaction.
	 */
	protected void safelyChangeOrder() {
		EList<InteractionFragment> orderingFragments = getOrderingFragments();
		synchronized(orderingFragments) {
			computeNewIndexes();
			for(InteractionFragment fragment : new ArrayList<InteractionFragment>(orderingFragments)) {
				int oldPos = orderingFragments.indexOf(fragment);
				if(oldPos == -1) {
					continue;
				}
				Integer newPos = fragmentIndexes.get(fragment);
				if(newPos == null || oldPos == newPos.intValue() || newPos.intValue() < 0 || newPos.intValue() >= orderingFragments.size()) {
					continue;
				}
				orderingFragments.move(newPos.intValue(), oldPos);
			}
		}
	}
}
