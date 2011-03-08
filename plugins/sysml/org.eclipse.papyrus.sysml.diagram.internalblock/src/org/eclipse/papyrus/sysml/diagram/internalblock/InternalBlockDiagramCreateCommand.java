/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.papyrus.umlutils.ElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public class InternalBlockDiagramCreateCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/** Domain Element referenced by canvas if it differs from {@link Package} */
	protected EObject canvasDomainElement = null;

	/** Default margin for the display of Domain Element referenced by canvas */
	protected static int DEFAULT_MARGIN = 40;

	/** Default height for the display of Domain Element referenced by canvas */
	protected static int DEFAULT_HEIGHT = 250;

	/** Default width for the display of Domain Element referenced by canvas */
	protected static int DEFAULT_WIDTH = 500;

	@Override
	protected String getDefaultDiagramName() {
		return "IBDiagram";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return InternalBlockDiagramEditPart.DIAGRAM_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return Activator.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * Initialize the diagram. The diagram is attached to the element selected on creation.
	 * Possible element types are: Block.
	 */
	@Override
	protected void initializeDiagram(EObject diagram) {
		if(diagram instanceof Diagram) {
			Diagram currentDiagram = (Diagram)diagram;
			if(canvasDomainElement != null) {
				currentDiagram.setElement(canvasDomainElement);
				initializeDiagramContent(currentDiagram);
			}
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Diagram createDiagram(Resource diagramResource, EObject owner, String name) {
		Diagram diagram = null;

		if(owner instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class cOwner = (org.eclipse.uml2.uml.Class)owner;
			Block block = ElementUtil.getStereotypeApplication(cOwner, Block.class);

			if(block != null) {
				canvasDomainElement = (EObject)owner;
				Package owningPackage = ((Element)owner).getNearestPackage();
				diagram = super.createDiagram(diagramResource, owningPackage, name);
			}

		} else if(owner instanceof Package) {
			canvasDomainElement = null;
			diagram = super.createDiagram(diagramResource, owner, name);
		}
		return diagram;
	}

	/**
	 * Initialize the diagram with the canvas domain element shown.
	 * 
	 * @param diagram
	 *        the diagram to initialize
	 */
	protected void initializeDiagramContent(Diagram diagram) {

		// Create a view for the canvasDomainElement in the new diagram
		View view = ViewService.getInstance().createView(Node.class, new EObjectAdapter(canvasDomainElement), diagram, null, ViewUtil.APPEND, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

		// Update the view position and size (should adapt to canvas current size)
		Bounds viewBounds = (Bounds)((Node)view).getLayoutConstraint();
		viewBounds.setX(DEFAULT_MARGIN);
		viewBounds.setY(DEFAULT_MARGIN);
		viewBounds.setHeight(DEFAULT_HEIGHT);
		viewBounds.setWidth(DEFAULT_WIDTH);
	}
}
