package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.uml2.uml.Element;

interface ITestProvider {

	int getEditPartChildrenSize();

	Element getDropElement();

	int getSemanticChildrenSize();

	int getViewChildrenSize();

	GraphicalEditPart getParentEditPart();

	GraphicalEditPart getDestroyEditPart();
}
