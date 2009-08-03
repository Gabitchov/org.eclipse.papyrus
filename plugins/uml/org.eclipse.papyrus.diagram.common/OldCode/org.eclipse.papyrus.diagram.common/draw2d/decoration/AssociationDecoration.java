/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.draw2d.decoration;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

public class AssociationDecoration extends CompositeDecoration {

	private static final PointList RHOMB = new PointList(new int[] { //
			//
					-1, 1, // 
					0, 0, //
					-1, -1, //
					-2, 0, //
					-1, 1, //
			});

	private static final PointList ARROW = new PointList(new int[] { //
			//
					-1, 1, // 
					0, 0, //
					-1, -1, //
					0, 0, // 
					-1, 1, //
			});

	private static final PointList CROSS = new PointList(new int[] { //
			//
					-1, 0, // 
					-2, -1, // 
					-1, 0, //
					-2, 1, //
					-1, 0, // 
					0, 1, //
					-1, 0, // 
					0, -1, //
					-1, 0, // 
			});

	private ComposablePolygonDecoration myCompositeAggrecationDecoration;

	private ComposablePolygonDecoration mySharedAggrecationDecoration;

	private ComposablePolygonDecoration myNavigableDecoration;

	private ComposablePolygonDecoration myNonNavigableDecoration;

	private DotDecoration myOwnedEndDecoration;

	public AssociationDecoration() {
		initAggregationDecorations();
		initNavigabilityDecorations();
		initOwnedEndDecorations();
	}

	private void initAggregationDecorations() {
		myCompositeAggrecationDecoration = new ComposablePolygonDecoration();
		myCompositeAggrecationDecoration.setTemplate(RHOMB.getCopy());
		myCompositeAggrecationDecoration.setBoundPoint(new Point(-2, 0));
		myCompositeAggrecationDecoration.setFill(true);
		if (getParent() != null && getParent().getForegroundColor() != null) {
			myCompositeAggrecationDecoration.setBackgroundColor(getParent().getForegroundColor());
		}
		mySharedAggrecationDecoration = new ComposablePolygonDecoration();
		mySharedAggrecationDecoration.setTemplate(RHOMB.getCopy());
		mySharedAggrecationDecoration.setBoundPoint(new Point(-2, 0));
		mySharedAggrecationDecoration.setFill(true);
		mySharedAggrecationDecoration.setBackgroundColor(ColorConstants.white);
	}

	private void initNavigabilityDecorations() {
		myNavigableDecoration = new ComposablePolygonDecoration();
		myNavigableDecoration.setTemplate(ARROW.getCopy());
		myNavigableDecoration.setBoundPoint(new Point(-1, 0));

		myNonNavigableDecoration = new ComposablePolygonDecoration();
		myNonNavigableDecoration.setScale(4, 3);
		myNonNavigableDecoration.setTemplate(CROSS.getCopy());
		myNonNavigableDecoration.setBoundPoint(new Point(-2, 0));
	}

	private void initOwnedEndDecorations() {
		myOwnedEndDecoration = new DotDecoration();
		myOwnedEndDecoration.setRadius(1);
		myOwnedEndDecoration.setFill(true);
	}

	public void updateAggregationKind(AggregationKind kind) {
		if (kind == AggregationKind.COMPOSITE_LITERAL) {
			addDecoration(myCompositeAggrecationDecoration);
			removeDecoration(mySharedAggrecationDecoration);
		} else if (kind == AggregationKind.SHARED_LITERAL) {
			addDecoration(mySharedAggrecationDecoration);
			removeDecoration(myCompositeAggrecationDecoration);
		} else {
			removeDecoration(mySharedAggrecationDecoration);
			removeDecoration(myCompositeAggrecationDecoration);
		}
	}

	public void updateNavigability(Property associationEnd, Property otherEnd, IPreferenceStore store) {
		String navigability = store.getString(UMLPreferencesConstants.NAVIGATION_ARROWS_OPTION);
		if (UMLPreferencesConstants.SHOW_ALL_ARROWS.equals(navigability)) {
			if (!associationEnd.isNavigable()) {
				removeDecoration(myNavigableDecoration);
				addDecoration(myNonNavigableDecoration);
			} else {
				removeDecoration(myNonNavigableDecoration);
				addDecoration(myNavigableDecoration);
			}
			return;
		}
		if (UMLPreferencesConstants.SUPRESS_ALL_ARROWS.equals(navigability)) {
			removeDecoration(myNavigableDecoration);
			removeDecoration(myNonNavigableDecoration);
			return;
		}
		// show one way navigability only
		if (associationEnd.isNavigable() && !otherEnd.isNavigable()) {
			addDecoration(myNavigableDecoration);
			removeDecoration(myNonNavigableDecoration);
			return;
		}
		if (!associationEnd.isNavigable() && otherEnd.isNavigable()) {
			addDecoration(myNonNavigableDecoration);
			removeDecoration(myNavigableDecoration);
			return;
		}
		removeDecoration(myNavigableDecoration);
		removeDecoration(myNonNavigableDecoration);
	}

	public void updateOwnedEnd(Association association, Property end) {
		// dots are shown for property ends that are owned by source/target
		// classifier, not the association itself.
		if (association.getOwnedEnds().contains(end)) {
			removeDecoration(myOwnedEndDecoration);
		} else {
			addDecoration(myOwnedEndDecoration);
		}

	}

	public void update(Association association, Property end, Property otherEnd, IPreferenceStore store) {
		updateOwnedEnd(association, end);
		updateAggregationKind(otherEnd.getAggregation());
		updateNavigability(end, otherEnd, store);
	}

}
