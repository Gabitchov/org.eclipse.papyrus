/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		CEA LIST - Initial API and implementation
 *		Laurent Wouters (CEA LIST) laurent.wouters@cea.fr - Viewpoints application
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.edit.utils.GMFCommandUtils;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Represents the creation command for a SysML internal block diagram
 * @author Laurent Wouters
 */
public class InternalBlockDiagramCreateCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultDiagramName() {
		return "New Internal Block Diagram"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return ElementTypes.DIAGRAM_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return Activator.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Diagram doCreateDiagram(Resource diagramResource, EObject owner, EObject element, ViewPrototype prototype, String name) {
		// Start of user code Custom diagram creation
		Diagram diagram = null;

		if (element instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class cOwner = (org.eclipse.uml2.uml.Class)element;
			Block block = UMLUtil.getStereotypeApplication(cOwner, Block.class);

			if(block != null) {
				canvasDomainElement = (EObject)element;
				Package owningPackage = ((Element)element).getNearestPackage();
				diagram = super.doCreateDiagram(diagramResource, owner, owningPackage, prototype, name);
			}

		} else if (element instanceof Package) {

			try {
				canvasDomainElement = null;

				IEditCommandRequest request = new CreateElementRequest((Package)element, SysMLElementTypes.BLOCK);
				IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(element);
				if(commandService == null) {
					return null;
				}

				ICommand createElementCommand = commandService.getEditCommand(request);
				if((createElementCommand != null) && (createElementCommand.canExecute())) {
					createElementCommand.execute(new NullProgressMonitor(), null);
					EObject block = GMFCommandUtils.getCommandEObjectResult(createElementCommand);
					canvasDomainElement = block;
					diagram = super.doCreateDiagram(diagramResource, owner, (Package)element, prototype, name);
				}

			} catch (ExecutionException e) {
				e.printStackTrace();
			}

		}

		return diagram;
		// End of user code
	}

	// Start of user code Custom creation command
	/** Domain Element referenced by canvas if it differs from {@link Package} */
	protected EObject canvasDomainElement = null;

	/** Default margin for the display of Domain Element referenced by canvas */
	protected static int DEFAULT_MARGIN = 40;

	/** Default height for the display of Domain Element referenced by canvas */
	protected static int DEFAULT_HEIGHT = 250;

	/** Default width for the display of Domain Element referenced by canvas */
	protected static int DEFAULT_WIDTH = 500;

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
	 * Initialize the diagram with the canvas domain element shown.
	 * 
	 * @param diagram
	 *        the diagram to initialize
	 */
	protected void initializeDiagramContent(Diagram diagram) {

		// Create a view for the canvasDomainElement in the new diagram
		View view =
			ViewService.getInstance().createNode(new SemanticAdapter(canvasDomainElement, null), diagram, SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID, ViewUtil.APPEND, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		view.setElement(diagram.getElement());

		// Update the view position and size (should adapt to canvas current size)
		Bounds viewBounds = (Bounds)((Node)view).getLayoutConstraint();
		viewBounds.setX(DEFAULT_MARGIN);
		viewBounds.setY(DEFAULT_MARGIN);
		viewBounds.setHeight(DEFAULT_HEIGHT);
		viewBounds.setWidth(DEFAULT_WIDTH);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean isParentReassignable() {
		// Bug 374626: [Model Explorer] Moving an IBD from a block to another block shall be forbidden 
		return false;
	}

	// End of user code
}
