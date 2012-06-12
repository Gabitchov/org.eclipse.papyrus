package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

interface IChildTestProvider extends ITestProvider {

	boolean hasSemanticChild();

	Point getChildLocation(GraphicalEditPart parentEditPart);
}