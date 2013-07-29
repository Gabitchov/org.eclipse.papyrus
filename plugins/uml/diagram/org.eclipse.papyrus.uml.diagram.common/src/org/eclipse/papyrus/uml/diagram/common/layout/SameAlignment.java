/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.layout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

/**
 * 
 * This class allows to regroup all the nodes which are linked by the selected
 * links.
 * 
 */
public class SameAlignment {

	/** the alignment */
	private int alignment;

	/** list of the links representation */
	private List<LinkRepresentation> linksRepresentation;

	/** list of the editpart representation */
	private List<EditPartRepresentation> editpartRepresentation;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param align
	 */
	public SameAlignment(int align) {
		this.alignment = align;
		this.linksRepresentation = new ArrayList<LinkRepresentation>();
		this.editpartRepresentation = new ArrayList<EditPartRepresentation>();
	}

	/**
	 * Returns the command to align all the selected {@linkplain EditPart}
	 * 
	 * @return the command to align all the selected {@linkplain EditPart}
	 */
	public Command getCommand() {
		Collections.sort(linksRepresentation, new LinkComparator());
		if(this.alignment == PositionConstants.RIGHT || this.alignment == PositionConstants.BOTTOM) {// we need to
																										// inverse the
																										// selection to
																										// do the
																										// correct
																										// action
			Collections.reverse(linksRepresentation);
		}
		// we remove the selected link which are not interesting
		removeBadSideLink();

		CompoundCommand cmd = new CompoundCommand("command for alignment"); //$NON-NLS-1$
		if(isCorrectSelection()) {
			Command tmp;
			for(LinkRepresentation currentLink : linksRepresentation) {
				tmp = currentLink.getCommand();
				if(tmp != null) {
					cmd.add(tmp);
				}
			}
		}
		return cmd;
	}

	/**
	 * Returns a list with the link linked to the {@link EditPartRepresentation} {@code epRepresentation}
	 * 
	 * @param epRepresentation
	 *        an {@linkplain EditPartRepresentation}
	 * @return a list with the link linked to the {@link EditPartRepresentation} {@code epRepresentation}
	 */
	protected List<LinkRepresentation> getLinkFor(EditPartRepresentation epRepresentation) {
		List<LinkRepresentation> list = new ArrayList<LinkRepresentation>();
		for(LinkRepresentation link : linksRepresentation) {
			if(link.getSource() == epRepresentation || link.getTarget() == epRepresentation) {
				list.add(link);
			}
		}
		return list;
	}

	/**
	 * Tests if each editpart is linked with only one or two other editparts
	 * 
	 * @return <ul>
	 *         <li>{@code true}</li> all the node are linked with only one or two other editparts
	 *         <li> {@code false}</li> if not
	 * 
	 *         </ul>
	 */
	protected boolean isCorrectSelection() {
		for(EditPartRepresentation current : editpartRepresentation) {
			if(getLinkFor(current).size() > 2) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Adds a link, with its source and target to the {@link SameAlignment}
	 * 
	 * @param link
	 *        the link
	 * @param sourceRep
	 *        the source representation for this link
	 * @param targetRep
	 *        the target representation for this link
	 */
	public void addTriplet(EditPart link, EditPartRepresentation sourceRep, EditPartRepresentation targetRep) {
		addEditPartRepresentation(sourceRep);
		addEditPartRepresentation(targetRep);
		linksRepresentation.add(new LinkRepresentation(link, sourceRep, targetRep, alignment));

	}

	/**
	 * Adds an {@link EditPartRepresentation} to the {@link SameAlignment}
	 * 
	 * @param rep
	 *        the {@link EditPartRepresentation} to add
	 */
	protected void addEditPartRepresentation(EditPartRepresentation rep) {
		if(!editpartRepresentation.contains(rep)) {
			editpartRepresentation.add(rep);
		}
	}

	/**
	 * Adds {@code family} to this family
	 * 
	 * @param family
	 *        adds this {@code family} to the family
	 */
	public void addFamily(SameAlignment family) {
		for(LinkRepresentation currentLink : family.getLinks()) {
			addEditPartRepresentation(currentLink.getSource());
			addEditPartRepresentation(currentLink.getTarget());
		}

		linksRepresentation.addAll(family.getLinks());

	}

	/**
	 * Getter for {@link #alignment}
	 * 
	 * @return
	 * @link {@link #alignment}
	 */
	public int getAlignment() {
		return this.alignment;
	}

	/**
	 * Getter for {@link #linksRepresentation}
	 * 
	 * @return {@link #linksRepresentation}
	 */
	public List<LinkRepresentation> getLinks() {
		return this.linksRepresentation;
	}

	/**
	 * 
	 * @param representedEditPart
	 *        the {@linkplain EditPart} that we are looking for
	 * @return <ul>
	 *         <li>the {@linkplain EditPartRepresentation} for this editpart if it exists</li>
	 *         <li>{@code null}if the representation for this editpart doesn't exist</li>
	 *         </ul>
	 * 
	 */
	public EditPartRepresentation getEditPartRepresentationFor(EditPart representedEditPart) {
		for(EditPartRepresentation currentRepresentation : editpartRepresentation) {
			if(currentRepresentation.getRepresentedEditPart() == representedEditPart) {
				return currentRepresentation;
			}
		}
		return null;
	}

	/**
	 * This method removes the following links :
	 * <ul>
	 * <li>links which are not on a correct side to do the action</li>
	 * <li>links whose Figure is not an instanceof PolylineConnectionEx</li>
	 * </ul>
	 */
	protected void removeBadSideLink() {
		List<LinkRepresentation> linksToRemove = new ArrayList<LinkRepresentation>();

		// we test if the tow anchors for the selected link are opposite or not
		for(LinkRepresentation link : linksRepresentation) {
			int side1 = link.getLinkSideOnSource();
			int side2 = link.getLinkSideOnTarget();
			if(alignment == PositionConstants.LEFT || alignment == PositionConstants.RIGHT) {
				if(!DistributionConstants.verticalValuesList.contains(side1) || !DistributionConstants.verticalValuesList.contains(side2)) {
					linksToRemove.add(link);
				}

			} else if(alignment == PositionConstants.TOP || alignment == PositionConstants.BOTTOM) {
				if(!DistributionConstants.horizontalValuesList.contains(side1) || !DistributionConstants.horizontalValuesList.contains(side2)) {
					linksToRemove.add(link);
				}
			}
			if(!(((AbstractConnectionEditPart)link.getLink()).getFigure() instanceof PolylineConnectionEx)) {
				linksToRemove.add(link);
			}
		}
		linksRepresentation.removeAll(linksToRemove);
	}

	/**
	 * 
	 * This class provides a comparator for the {@link EditPart}, using the
	 * coordinates of the representing {@link EditPart} The used coordinate is
	 * the top left corner
	 */
	protected class LinkComparator implements Comparator<Object> {

		/**
		 * 
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 * 
		 * @param o1
		 * @param o2
		 * @return
		 */
		public int compare(Object o1, Object o2) {
			// the two figures to compare
			PolylineConnectionEx figure1 = (PolylineConnectionEx)((AbstractConnectionEditPart)((LinkRepresentation)o1).getLink()).getFigure();
			PolylineConnectionEx figure2 = (PolylineConnectionEx)((AbstractConnectionEditPart)((LinkRepresentation)o2).getLink()).getFigure();

			// the point for the first figure
			Point pt11;
			Point pt12;

			// the point for the second figure
			Point pt21;
			Point pt22;

			// we want pt11.x<pt12.x<pt21.x<pt22.x
			if(alignment == PositionConstants.LEFT || alignment == PositionConstants.RIGHT) {
				pt11 = (figure1.getStart().x < figure1.getEnd().x) ? figure1.getStart() : figure1.getEnd();
				if(pt11.equals(figure1.getStart())) {
					pt12 = figure1.getEnd();
				} else {
					pt12 = figure1.getStart();
				}

				pt21 = (figure2.getStart().x < figure2.getEnd().x) ? figure2.getStart() : figure2.getEnd();
				if(pt21.equals(figure2.getStart())) {
					pt22 = figure2.getEnd();
				} else {
					pt22 = figure2.getStart();
				}

				if(pt11.x < pt21.x && pt12.x < pt22.x) {
					return -1;
				} else if(pt11.equals(pt21) && pt12.equals(pt22)) {
					return 0;
				} else if(pt11.x > pt21.x && pt12.x > pt22.x) {
					return 1;
				} else {
					return 0; // it's a strange model, if we come here
				}

			} else if(alignment == PositionConstants.TOP || alignment == PositionConstants.BOTTOM) {
				pt11 = (figure1.getStart().y < figure1.getEnd().y) ? figure1.getStart() : figure1.getEnd();
				if(pt11.equals(figure1.getStart())) {
					pt12 = figure1.getEnd();
				} else {
					pt12 = figure1.getStart();
				}

				pt21 = (figure2.getStart().y < figure2.getEnd().y) ? figure2.getStart() : figure2.getEnd();
				if(pt21.equals(figure2.getStart())) {
					pt22 = figure2.getEnd();
				} else {
					pt22 = figure2.getStart();
				}
				if(pt11.y < pt21.y && pt12.y < pt22.y) {
					return -1;
				} else if(pt11.equals(pt21) && pt12.equals(pt22)) {
					return 0;
				} else if(pt11.y > pt21.y && pt12.y > pt22.y) {
					return 1;
				} else {
					return 0; // it's a strange model, if we come here
				}

			}
			return 0;
		}
	}

}
