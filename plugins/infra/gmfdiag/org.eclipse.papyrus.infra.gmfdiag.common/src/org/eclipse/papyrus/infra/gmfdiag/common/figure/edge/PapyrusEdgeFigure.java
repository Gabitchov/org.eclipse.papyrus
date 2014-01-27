/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.figure.edge;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.common.ui.services.editor.EditorService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This class should be the super class of all Papyrus figure.
 * Its provides the way to draw common bendpoints bigger than others
 * 
 */
public abstract class PapyrusEdgeFigure extends PolylineConnectionEx {

	/**
	 * Diameter to use for the bendpoints
	 */
	private int bendpointDiameter;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PapyrusEdgeFigure() {
		super();
		setBendPointDiameter(7);
	}

	/**
	 * We override this method to circle on bendpoints when a segment of the link is shared with another link of the same kind
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx#outlineShape(org.eclipse.draw2d.Graphics)
	 * 
	 * @param g
	 */
	protected void outlineShape(Graphics g) {
		super.outlineShape(g);
		drawConnectionPoint(g);
	}

	/**
	 * Resets the style of this figure to its default implementation
	 */
	public void resetStyle() {

	}

	/**
	 * 
	 * @param g
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected void drawConnectionPoint(final Graphics g) {
		final PointList bendPoints = getPoints();
		if(getDrawBendpointPreferenceValue() && bendPoints.size() > 2 && getBendPointDiameter() > 1) {
			final Map<?, ?> visualPartMap = getVisualPartMap(this);
			if(visualPartMap != null) {
				final EditPart currentEditPart = (EditPart)visualPartMap.get(this);
				EClass eClass = null;
				if(currentEditPart instanceof IGraphicalEditPart) {
					final EObject el = ((IGraphicalEditPart)currentEditPart).resolveSemanticElement();
					if(el != null) {
						eClass = el.eClass();
					}
				}
				if(currentEditPart instanceof ConnectionEditPart && eClass != null) {
					final EditPart sourceEP = ((ConnectionEditPart)currentEditPart).getSource();
					final EditPart targetEP = ((ConnectionEditPart)currentEditPart).getTarget();
					final Set<Object> allConnectionsEP = new HashSet<Object>();
					//1. get all potential editpart connections
					if(sourceEP instanceof AbstractGraphicalEditPart && targetEP instanceof AbstractGraphicalEditPart) {
						allConnectionsEP.addAll(((AbstractGraphicalEditPart)sourceEP).getSourceConnections());
						allConnectionsEP.addAll(((AbstractGraphicalEditPart)targetEP).getSourceConnections());
						allConnectionsEP.addAll(((AbstractGraphicalEditPart)sourceEP).getTargetConnections());
						allConnectionsEP.addAll(((AbstractGraphicalEditPart)targetEP).getTargetConnections());
						allConnectionsEP.remove(currentEditPart);
					}

					//2. get the figure for these connections
					final Set<Connection> allConnections = new HashSet<Connection>();
					if(allConnectionsEP.size() > 0) {
						for(final Object current : allConnectionsEP) {
							//the editpart be instance of the same class
							if(current.getClass().isInstance(currentEditPart) && currentEditPart.getClass().isInstance(current) && current instanceof IGraphicalEditPart) {
								final EObject resolvedElement = ((IGraphicalEditPart)current).resolveSemanticElement();
								if(resolvedElement != null && eClass != null && resolvedElement.eClass() != eClass) {
									continue;//we draw ben point only for elements which have the same eClass, when this eClass is not null
								}
								final IFigure currentFig = ((IGraphicalEditPart)current).getFigure();
								if(currentFig instanceof Connection) {
									allConnections.add((Connection)currentFig);
								}
							}
						}
					}

					//3. find and draw big bendpoints
					if(allConnections.size() > 0) {
						final Map<Point, Boolean> visibility = new HashMap<Point, Boolean>();
						visibility.put(bendPoints.getFirstPoint(), Boolean.FALSE);
						visibility.put(bendPoints.getLastPoint(), Boolean.FALSE);
						for(int i = 1; i < bendPoints.size() - 1; i++) {
							final Point currentPt = bendPoints.getPoint(i);
							visibility.put(currentPt, isACommonBendpoint(this, i, allConnections));
						}

						//clear the map : remove all unnecessary true value
						//01110 -> 01010
						int indexFirstOne = -1;
						for(int i = 0; i < bendPoints.size(); i++) {
							boolean first = visibility.get(bendPoints.getPoint(i));
							if(first && indexFirstOne < 0) {
								indexFirstOne = i;
							}
							if((!first) && indexFirstOne >= 0) {
								for(int j = (indexFirstOne + 1); j < i - 1; j++) {
									visibility.put(bendPoints.getPoint(j), false);
								}
								indexFirstOne = -1;
							}
						}


						//initialize the graphics
						if(getBackgroundColor() != null) {
							g.setForegroundColor(getBackgroundColor());
						}
						if(getForegroundColor() != null) {
							g.setBackgroundColor(getForegroundColor());
						}

						//paint the connection points
						//we don't allow to draw connection point on the start AND on the end of the figure (even if this case is possible in case of 2 full lines fully superimposed
						final int diameter = getBendPointDiameter();
						for(int i = 1; i < bendPoints.size() - 1; i++) {
							final Point currentPt = bendPoints.getPoint(i);
							if(visibility.get(currentPt)) {
								g.fillOval(currentPt.x - ((diameter - 1) / 2), currentPt.y - ((diameter - 1) / 2), diameter, diameter);
							}
						}
						//reset the graphics
						if(getBackgroundColor() != null) {
							g.setBackgroundColor(getBackgroundColor());
						}
						if(getForegroundColor() != null) {
							g.setForegroundColor(getForegroundColor());
						}
					}
				}

			}
		}

	}

	/**
	 * 
	 * @return
	 *         <code>true</code> according to the preference store
	 */
	protected boolean getDrawBendpointPreferenceValue() {
		return false;
	}

	/**
	 * 
	 * @param figure
	 *        a figure
	 * @return
	 *         the visual part map for this figure or <code>null</code> if not found
	 */
	protected Map<?, ?> getVisualPartMap(final IFigure figure) {
		IEditorPart part = EditorHelper.getCurrentEditor();
		if(part instanceof CoreMultiDiagramEditor) {
			final List<IEditorPart> visibleEditors = ((CoreMultiDiagramEditor)part).getISashWindowsContainer().getVisibleIEditorParts();
			for(final IEditorPart current : visibleEditors) {
				final GraphicalViewer viewer = (GraphicalViewer)current.getAdapter(GraphicalViewer.class);
				final Map<?, ?> visualPartMap = viewer.getVisualPartMap();
				if(visualPartMap.containsKey(figure)) {
					return visualPartMap;
				}
			}
		} else {
			//used when papyrus has been "unsashified"
			final IWorkbench workbench = PlatformUI.getWorkbench();
			if(workbench != null) {
				final IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
				if(window != null) {
					final List<?> editors = EditorService.getInstance().getRegisteredEditorParts();
					for(Iterator<?> j = editors.iterator(); j.hasNext();) {
						final IEditorPart editor = (IEditorPart)j.next();
						if(editor.getEditorSite().getWorkbenchWindow() == window) {
							if(editor instanceof IDiagramWorkbenchPart) {
								final IDiagramWorkbenchPart de = (IDiagramWorkbenchPart)editor;
								final GraphicalViewer viewer = de.getDiagramGraphicalViewer();
								final Map<?, ?> visualPartMap = viewer.getVisualPartMap();
								if(visualPartMap.containsKey(figure)) {
									return visualPartMap;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param figure
	 *        the figure owning this point
	 * @param indexOfTheTestedPoint
	 * @param connections
	 *        the collection of others connections which could share the bendpoint
	 * @return
	 *         true if the tested point is common with others connections
	 */
	public boolean isACommonBendpoint(final Connection figure, final int indexOfTheTestedPoint, final Collection<Connection> connections) {
		final PointList list = ((Connection)figure).getPoints();
		final Point thePoint = list.getPoint(indexOfTheTestedPoint);
		//we need to verify if this point is a common bendpoint with another one

		for(final Connection current : connections) {
			//to be a common bendpoints, the point AND (the point Before it OR the point After it) MUST be on the same segment
			final PointList localList = ((Connection)current).getPoints();
			for(int i = 0; i < localList.size() - 1; i++) {
				final Point tmp1 = localList.getPoint(i);
				final Point tmp2 = localList.getPoint(i + 1);

				boolean isOnSegment = isOnSegment(thePoint, tmp1, tmp2);
				if(isOnSegment) {
					boolean isOnSegment2 = isOnSegment(list.getPoint(indexOfTheTestedPoint + 1), tmp1, tmp2);
					if(isOnSegment2) {
						return true;
					}

					isOnSegment2 = isOnSegment(list.getPoint(indexOfTheTestedPoint - 1), tmp1, tmp2);
					if(isOnSegment2) {
						return true;
					}
				}
			}
		}
		return false;
	}


	/**
	 * 
	 * @param pt
	 *        a point to test
	 * @param pt1
	 *        the first point of a segment
	 * @param pt2
	 *        the second point of a segment
	 * @return
	 *         true if the point pt is on the segment [pt1, pt2]
	 */
	public static final boolean isOnSegment(final Point pt, final Point pt1, final Point pt2) {
		final Point first;
		final Point second;
		if(pt1.x < pt2.x) {
			first = pt1;
			second = pt2;
		} else {
			first = pt2;
			second = pt1;
		}
		if(pt.x >= first.x && pt.x <= second.x) {
			if((pt.y <= first.y && pt.y >= second.y) || (pt.y >= first.y && pt.y <= second.y)) {
				//y = ax+b;
				//we determine a;
				double firstX = first.preciseX();
				double secondX = second.preciseX();
				double firstY = first.preciseY();
				double secondY = second.preciseY();
				if(secondX == firstX) {
					return pt.preciseX() == secondX;
				}
				double a = (secondY - firstY) / (secondX - firstX);

				//we determine b;
				double b = firstY - a * firstX;

				return pt.preciseY() == a * pt.preciseX() + b;
			}
		}
		return false;
	}


	/**
	 * Calculate the best diameter and set the diameter value
	 * 
	 * @param diameter
	 *        the diameter of the bendpoints (if diameter<=1, we set the diameter to 0)
	 */
	public void setBendPointDiameter(final int diameter) {
		if(diameter <= 1) {
			this.bendpointDiameter = 0;
		}
		if(diameter % 2 == 1) {
			this.bendpointDiameter = diameter;
		} else {
			setBendPointDiameter(diameter + 1);
		}
	}

	/**
	 * 
	 * @return
	 *         the bendpoint diameter
	 */
	protected final int getBendPointDiameter() {
		return this.bendpointDiameter;
	}
}
