package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;

public interface ILinkTestProvider extends IChildTestProvider {

	int getEdgesSize();

	Point getConnectionSourceLocation(EditPart source);

	Point getConnectionTargetLocation(EditPart target);

	void setUp();
}