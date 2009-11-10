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
package org.eclipse.papyrus.diagram.sequence;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.core.adaptor.gmf.Activator;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.diagram.sequence.edit.commands.InteractionCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Define a command to create a new Sequence Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Sequence Diagram.
 */
public class CreateSequenceDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	private Element interaction = null;

	@Override
	protected String getDiagramNotationID() {
		return PackageEditPart.MODEL_ID;
	}

	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;

	}

	@Override
	protected BackboneContext getDefaultContext() {
		return super.getDefaultContext();
	}

	@Override
	protected void initializeDiagram(EObject diagram) {
		if (diagram != null) {
			if (diagram instanceof Diagram) {
				Diagram diag = (Diagram) diagram;
				if (interaction != null) {
					diag.setElement(interaction);
					createInteractionGraph(interaction, diag);
				}
			}

		}
	}

	@Override
	protected void initializeModel(EObject owner) {
		// Get the editing domain
		TransactionalEditingDomain editingdomain = getDefaultContext().getResourceSet().getTransactionalEditingDomain();

		EObject selectedElement = getSelectedElement();
		if (selectedElement != null) {
			// Create the request
			CreateElementRequest request = new CreateElementRequest(editingdomain, selectedElement,
					UMLElementTypes.Interaction_2001);

			// Create the command
			InteractionCreateCommand createCommand = InteractionCreateCommand.create(request, selectedElement);

			// Execute the command
			if (createCommand != null) {
				try {
					createCommand.execute(null, null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}

			}

			// retrieve the result
			if (request != null) {
				if (request.getNewElement() instanceof Interaction) {
					interaction = (Interaction) (request.getNewElement());
				}
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
		if (owner instanceof Package) {
			diagram = super.createDiagram(diagramResource, owner, name);
		} else {
			if (owner instanceof Element) {
				Element element = (Element) owner;
				diagram = super.createDiagram(diagramResource, element.getModel(), name);
			}
		}
		return diagram;
	}

	private void createInteractionGraph(Element interaction, Diagram diagram) {

		TransactionalEditingDomain editingdomain = getDefaultContext().getResourceSet().getTransactionalEditingDomain();
		IAdaptable elementAdapter = new EObjectAdapter(interaction);
		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, false,
				UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

		CreateCommand nodeCreationCommand = new CreateCommand(editingdomain, descriptor, diagram);

		try {
			OperationHistoryFactory.getOperationHistory().execute(nodeCreationCommand, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
			Activator.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		}
	}

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	@Override
	protected String getDefaultDiagramName() {
		return super.openDiagramNameDialog("SequenceDiagram");
	}

}
