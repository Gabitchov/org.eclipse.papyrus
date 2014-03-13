/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite;

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
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * Define a command to create a new Composite Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Composite Diagram.
 * 
 */
public class CreateCompositeDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/** Domain Element referenced by canvas if it differs from {@link Package} */
	protected EObject canvasDomainElement = null;

	/** Default margin for the display of Domain Element referenced by canvas */
	protected static int DEFAULT_MARGIN = 40;

	/** Default height for the display of Domain Element referenced by canvas */
	protected static int DEFAULT_HEIGHT = 250;

	/** Default width for the display of Domain Element referenced by canvas */
	protected static int DEFAULT_WIDTH = 500;

	/**
	 * Name of the Diagram
	 */
	protected static final String CSD_DEFAULT_NAME = "CompositeDiagram"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultDiagramName() {
		return CSD_DEFAULT_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return CompositeStructureDiagramEditPart.MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * Initialize the diagram. The diagram is attached to the element selected on creation.
	 * Possible element types are: Class or Collaboration
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

		if(owner instanceof org.eclipse.uml2.uml.Class || (owner instanceof Collaboration)) {
			canvasDomainElement = (EObject)owner;
			Package owningPackage = ((Element)owner).getNearestPackage();
			diagram = super.createDiagram(diagramResource, owningPackage, name);

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

		if (view instanceof Node) {
			// Update the view position and size (should adapt to canvas current size)
			Bounds viewBounds = (Bounds)((Node)view).getLayoutConstraint();
			viewBounds.setX(DEFAULT_MARGIN);
			viewBounds.setY(DEFAULT_MARGIN);
			viewBounds.setHeight(DEFAULT_HEIGHT);
			viewBounds.setWidth(DEFAULT_WIDTH);
		}
	}
}
