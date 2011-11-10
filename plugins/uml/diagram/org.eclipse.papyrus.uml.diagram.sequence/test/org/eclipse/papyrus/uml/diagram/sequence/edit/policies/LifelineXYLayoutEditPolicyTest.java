/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.junit.Test;

public class LifelineXYLayoutEditPolicyTest {

	@Test
	public void testAdaptSizeDeltaToMaxHeight() {
		Figure figure = new Figure();
		figure.setBounds(new Rectangle(1, 2, 10, 20));
		figure.setMaximumSize(new Dimension(100, 200));
		figure.setMinimumSize(new Dimension(0, 30));

		Dimension sizeDelta = new Dimension(30, 40);
		Dimension newSizeDelta = LifelineXYLayoutEditPolicy.adaptSizeDeltaToMaxHeight(figure, sizeDelta);
		assertFalse("Original dimension modified", sizeDelta == newSizeDelta);
		assertEquals("Width can't change", 30, newSizeDelta.width);
		assertEquals("Height change", 40, newSizeDelta.height);

		sizeDelta = new Dimension(30, 190);
		newSizeDelta = LifelineXYLayoutEditPolicy.adaptSizeDeltaToMaxHeight(figure, sizeDelta);
		assertFalse("Original dimension modified", sizeDelta == newSizeDelta);
		assertEquals("Width can't change", 30, newSizeDelta.width);
		assertEquals("Height don't change", 180, newSizeDelta.height);

		sizeDelta = new Dimension(30, 0);
		newSizeDelta = LifelineXYLayoutEditPolicy.adaptSizeDeltaToMaxHeight(figure, sizeDelta);
		assertFalse("Original dimension modified", sizeDelta == newSizeDelta);
		assertEquals("Width can't change", 30, newSizeDelta.width);
		assertEquals("Height don't change", 10, newSizeDelta.height);
	}

	@Test
	public void testIsAffixedToRight() {
		Rectangle leftFigure = new Rectangle(10, 10, 10, 10);
		Rectangle rightFigure = new Rectangle(15, 15, 10, 10);
		assertTrue("Left figure is not on the left of the right figure", LifelineXYLayoutEditPolicy.isAffixedToRight(leftFigure, rightFigure));
		assertFalse("Right figure is on the left of the left figure", LifelineXYLayoutEditPolicy.isAffixedToRight(rightFigure, leftFigure));
	}

	@Test
	public void testGetRealMoveDelta() {
		Rectangle oldRelativeBounds = new Rectangle(10, 10, 10, 10);
		Rectangle newRelativeBounds = new Rectangle(15, 20, 25, 30);
		Rectangle absoluteBounds = LifelineXYLayoutEditPolicy.getRealMoveDelta(oldRelativeBounds, newRelativeBounds);
		assertEquals("Wrong x", 5, absoluteBounds.x);
		assertEquals("Wrong y", 10, absoluteBounds.y);
		assertEquals("Wrong width", 15, absoluteBounds.width);
		assertEquals("Wrong height", 20, absoluteBounds.height);
	}

	@Test
	public void testGetRelativeBounds() {
		Figure parentFigure = new Figure();
		parentFigure.setBounds(new Rectangle(10, 20, 100, 100));

		Figure childFigure = new Figure();
		childFigure.setBounds(new Rectangle(20, 30, 50, 50));
		childFigure.setParent(parentFigure);

		Rectangle absoluteChild = LifelineXYLayoutEditPolicy.getRelativeBounds(childFigure);
		assertEquals("Wrong x", 10, absoluteChild.x);
		assertEquals("Wrong y", 10, absoluteChild.y);
		assertEquals("Wrong width", 50, absoluteChild.width);
		assertEquals("Wrong height", 50, absoluteChild.height);
	}

}
