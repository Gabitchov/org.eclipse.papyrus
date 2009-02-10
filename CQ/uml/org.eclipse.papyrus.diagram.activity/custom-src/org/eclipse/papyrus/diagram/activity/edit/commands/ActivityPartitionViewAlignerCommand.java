/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Mu�oz (Prodevelop) - Initial API implementation.
 * 				 Marc Gil Sendra (Prodevelop) - Lets to reorder the activity partitions.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.commands;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ActivityPartition;

// TODO: Auto-generated Javadoc
/**
 * A command to set the bounds (location/size) of a <code>View</code>.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @author <a href="mailto:mgil@prodevelop.es">Marc Gil Sendra</a>
 */
public class ActivityPartitionViewAlignerCommand extends AbstractTransactionalCommand {

	/** The adapter. */
	private IAdaptable adapter;

	/** The location. */
	private Point locationDelta;

	/** The size. */
	private Dimension sizeDelta;

	/** Reorder ActivityPartitions */
	private boolean reorder;

	/**
	 * Creates a <code>SetBoundsCommand</code> for the given view adapter with a given bounds.
	 * 
	 * @param editingDomain
	 *            the editing domain through which model changes are made
	 * @param label
	 *            The command label
	 * @param adapter
	 *            An adapter to the <code>View</code>
	 * @param bounds
	 *            The new bounds
	 */
	public ActivityPartitionViewAlignerCommand(TransactionalEditingDomain editingDomain, String label, IAdaptable adapter, Rectangle boundsDelta) {
		super(editingDomain, label, null);
		this.adapter = adapter;
		this.locationDelta = boundsDelta.getLocation();
		this.sizeDelta = boundsDelta.getSize();
		this.reorder = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (adapter == null)
			return CommandResult.newErrorCommandResult("SetBoundsCommand: viewAdapter does not adapt to IView.class"); //$NON-NLS-1$

		List<GraphicalEditPart> activityPartitions = getAllActivityPartitions();
		activityPartitions = SortActivitiesPartitionsByX(activityPartitions);

		GraphicalEditPart apep = (GraphicalEditPart) adapter.getAdapter(GraphicalEditPart.class);

		if (activityPartitions.size() == 0)
			return CommandResult.newCancelledCommandResult();

		// if the ActivityPartition is the first and we move left or
		// if the ActivityPartition is the last and we move right, only move
		if ((apep == activityPartitions.get(0) && locationDelta.x < 0) || (apep == activityPartitions.get(activityPartitions.size() - 1) && locationDelta.x > 0)) {
			RelocateActivitiesPartitions(activityPartitions);
			return CommandResult.newOKCommandResult();
		}

		// otherwise, try to move o reorder ActivityPartitions
		activityPartitions = SortActivitiesPartitionsReorderedByX(activityPartitions);
		RelocateActivitiesPartitions(activityPartitions);

		return CommandResult.newOKCommandResult();
	}

	/**
	 * Sets the view location.
	 * 
	 * @param view
	 *            the view
	 * @param location
	 *            the location
	 */
	private void SetViewLocation(View view, Point location) {
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X(), new Integer(location.x));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y(), new Integer(location.y));
	}

	/**
	 * Sets the view size.
	 * 
	 * @param view
	 *            the view
	 * @param size
	 *            the size
	 */
	private void SetViewSize(View view, Dimension size) {
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width(), new Integer(size.width));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height(), new Integer(size.height));
	}

	/**
	 * Sets the edit part location and size.
	 * 
	 * @param apep
	 *            the apep
	 * @param location
	 *            the location
	 * @param size
	 *            the size
	 */
	private void SetEditPartLocationAndSize(GraphicalEditPart apep, Point location, Dimension size) {
		IAdaptable adapter = apep;

		if (apep == null)
			return;

		View view = (View) apep.getAdapter(View.class);

		if (view == null)
			return;

		SetViewLocation(view, location);

		SetViewSize(view, size);
	}

	/**
	 * Gets the all activity partitions.
	 * 
	 * @return the all activity partitions
	 */
	private List<GraphicalEditPart> getAllActivityPartitions() {
		List<GraphicalEditPart> activities = new LinkedList<GraphicalEditPart>();

		GraphicalEditPart apep = (GraphicalEditPart) adapter.getAdapter(GraphicalEditPart.class);

		if (apep != null) {
			EditPart container = apep.getParent();

			if (container == null)
				return activities;

			for (Iterator<EditPart> it = container.getChildren().iterator(); it.hasNext();) {
				EditPart ep = it.next();
				if (((View) ep.getModel()).getElement() instanceof ActivityPartition) {
					activities.add((GraphicalEditPart) ep);
				}
			}
		}

		return activities;
	}

	/**
	 * Sort activities partitions by x.
	 * 
	 * @param activities
	 *            the activities
	 * 
	 * @return the list< graphical edit part>
	 */
	private List<GraphicalEditPart> SortActivitiesPartitionsByX(List<GraphicalEditPart> activities) {
		// Compare two ActivityPartitionEditParts by their x coordinate
		Comparator<GraphicalEditPart> comp = new Comparator<GraphicalEditPart>() {

			public int compare(GraphicalEditPart o1, GraphicalEditPart o2) {

				int o1x, o2x;
				o1x = o1.getFigure().getBounds().x;
				o2x = o2.getFigure().getBounds().x;

				if (o1x > o2x) {
					return 1;
				} else if (o1x < o2x) {
					return -1;
				} else
					return 0;
			}

		};

		GraphicalEditPart[] activitiesArray = new GraphicalEditPart[activities.size()];
		activities.toArray(activitiesArray);

		Arrays.sort(activitiesArray, comp);

		List<GraphicalEditPart> sortedActivities = new LinkedList<GraphicalEditPart>();

		for (GraphicalEditPart ap : activitiesArray) {
			sortedActivities.add(ap);
		}

		return sortedActivities;
	}

	/**
	 * Sort activities partitions by x.
	 * 
	 * @param activities
	 *            the activities
	 * 
	 * @return the list< graphical edit part>
	 */
	private List<GraphicalEditPart> SortActivitiesPartitionsReorderedByX(List<GraphicalEditPart> activities) {
		// Compare two ActivityPartitionEditParts by their x coordinate
		Comparator<GraphicalEditPart> comp = new Comparator<GraphicalEditPart>() {

			GraphicalEditPart apep = (GraphicalEditPart) adapter.getAdapter(GraphicalEditPart.class);

			public int compare(GraphicalEditPart o1, GraphicalEditPart o2) {

				int o1x, o2x;
				o1x = o1.getFigure().getBounds().x;
				o2x = o2.getFigure().getBounds().x;

				// o1 is the Activity Partition we want to move
				if (o1 == apep) {
					// move to right
					if (locationDelta.x > 0 && (o1.getFigure().getBounds().x < o2.getFigure().getBounds().x)) {
						if ((o1.getFigure().getBounds().getTopLeft().x + locationDelta.x) > (o2.getFigure().getBounds().x + o2.getFigure().getBounds().width)) {
							reorder = true;
							return 1;
						} else if ((o1.getFigure().getBounds().getTopLeft().x + locationDelta.x) == (o2.getFigure().getBounds().x + o2.getFigure().getBounds().width))
							return 0;
						else
							return -1;
					}
					// move to left
					else if (locationDelta.x < 0 && (o1.getFigure().getBounds().x > o2.getFigure().getBounds().x)) {
						if ((o1.getFigure().getBounds().getTopLeft().x + locationDelta.x) < o2.getFigure().getBounds().x) {
							reorder = true;
							return -1;
						} else if ((o1.getFigure().getBounds().getTopLeft().x + locationDelta.x) == o2.getFigure().getBounds().x)
							return 0;
						else
							return 1;
					} else {
						if (o1x > o2x) {
							return 1;
						} else if (o1x < o2x) {
							return -1;
						} else
							return 0;
					}
				}
				// o2 is the Activity Partition we want to move
				else if (o2 == apep) {
					// move to right
					if (locationDelta.x > 0 && (o2.getFigure().getBounds().x < o1.getFigure().getBounds().x)) {
						if ((o2.getFigure().getBounds().x + locationDelta.x) > (o1.getFigure().getBounds().x + o1.getFigure().getBounds().width)) {
							reorder = true;
							return -1;
						} else if ((o2.getFigure().getBounds().x + locationDelta.x) == (o1.getFigure().getBounds().x + o1.getFigure().getBounds().width))
							return 0;
						else
							return 1;
					}
					// move to left
					else if (locationDelta.x < 0 && (o2.getFigure().getBounds().x > o1.getFigure().getBounds().x)) {
						if ((o2.getFigure().getBounds().x + locationDelta.x) < o1.getFigure().getBounds().x) {
							reorder = true;
							return 1;
						} else if ((o2.getFigure().getBounds().x + locationDelta.x) == o1.getFigure().getBounds().x)
							return 0;
						else
							return -1;
					} else {
						if (o1x > o2x) {
							return 1;
						} else if (o1x < o2x) {
							return -1;
						} else
							return 0;
					}
				} else {
					if (o1x > o2x) {
						return 1;
					} else if (o1x < o2x) {
						return -1;
					} else
						return 0;
				}
			}

		};

		GraphicalEditPart[] activitiesArray = new GraphicalEditPart[activities.size()];
		activities.toArray(activitiesArray);

		Arrays.sort(activitiesArray, comp);

		List<GraphicalEditPart> sortedActivities = new LinkedList<GraphicalEditPart>();

		for (GraphicalEditPart ap : activitiesArray) {
			sortedActivities.add(ap);
		}

		return sortedActivities;
	}

	/**
	 * Relocate activities partitions.
	 * 
	 * @param activities
	 *            the activities
	 */
	private void RelocateActivitiesPartitions(List<GraphicalEditPart> activities) {

		GraphicalEditPart apep = (GraphicalEditPart) adapter.getAdapter(GraphicalEditPart.class);

		if (reorder) {
			int minX = activities.get(0).getFigure().getBounds().x;
			for (int i = 1; i < activities.size(); i++) {
				if (activities.get(i).getFigure().getBounds().x < minX) {
					minX = activities.get(i).getFigure().getBounds().x;
				}
			}

			GraphicalEditPart gep = activities.get(0);
			Rectangle previousBounds = gep.getFigure().getBounds().getCopy();
			previousBounds.x = minX;
			SetEditPartLocationAndSize(activities.get(0), new Point(previousBounds.x, previousBounds.y), new Dimension(previousBounds.width, previousBounds.height));

			Rectangle thisBounds;
			for (int i = 1; i < activities.size(); i++, previousBounds = thisBounds.getCopy()) {
				gep = activities.get(i);
				thisBounds = gep.getFigure().getBounds().getCopy();
				thisBounds.x = previousBounds.x + previousBounds.width;
				SetEditPartLocationAndSize(activities.get(i), new Point(thisBounds.x, thisBounds.y), new Dimension(thisBounds.width, thisBounds.height));
			}

			reorder = false;
		} else {
			int actual = -1;

			for (int i = 0; i < activities.size(); i++) {
				if (activities.get(i) == apep) {
					actual = i;
					break;
				}
			}

			if (actual <= -1) {
				return;
			}

			GraphicalEditPart gep = activities.get(actual);
			Rectangle newBounds = gep.getFigure().getBounds().getCopy();
			newBounds.x += locationDelta.x;
			newBounds.y += locationDelta.y;
			newBounds.height += sizeDelta.height;
			newBounds.width += sizeDelta.width;
			SetEditPartLocationAndSize(gep, new Point(newBounds.x, newBounds.y), new Dimension(newBounds.width, newBounds.height));

			Rectangle previousBounds = newBounds.getCopy(), thisBounds = null;
			for (int i = actual - 1; i >= 0; i--, previousBounds = thisBounds.getCopy()) {
				gep = activities.get(i);
				thisBounds = gep.getFigure().getBounds().getCopy();
				thisBounds.x = previousBounds.x - thisBounds.width;
				thisBounds.y = previousBounds.y;
				thisBounds.height = previousBounds.height;
				SetEditPartLocationAndSize(gep, new Point(thisBounds.x, thisBounds.y), new Dimension(thisBounds.width, thisBounds.height));
			}
			previousBounds = newBounds.getCopy();
			for (int i = actual + 1; i < activities.size(); i++, previousBounds = thisBounds.getCopy()) {
				gep = activities.get(i);
				thisBounds = gep.getFigure().getBounds().getCopy();
				thisBounds.x = previousBounds.x + previousBounds.width;
				thisBounds.y = previousBounds.y;
				thisBounds.height = previousBounds.height;
				SetEditPartLocationAndSize(gep, new Point(thisBounds.x, thisBounds.y), new Dimension(thisBounds.width, thisBounds.height));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#getAffectedFiles()
	 */
	@Override
	public List getAffectedFiles() {
		if (adapter != null) {
			View view = (View) adapter.getAdapter(View.class);
			if (view != null) {
				return getWorkspaceFiles(view);
			}
		}
		return super.getAffectedFiles();
	}
}
