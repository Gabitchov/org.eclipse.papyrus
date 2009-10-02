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
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.diagram.sequence.edit.commands.InteractionCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;

/**
 * Define a command to create a new Sequence Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Sequence Diagram.
 */
public class CreateSequenceDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	private Interaction ownerIntreaction = null;

	private UseCase ownerUsecase = null;

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

	/**
	 * create a sequence Diagram
	 * 
	 * @retrun the created diagram
	 */
	protected Diagram createDiagram(Resource diagramResource, EObject umlOwner, String name) {

		Diagram diagram = null;

		boolean exist = false;

		Element createdInteraction = null;

		diagram = super.createDiagram(diagramResource, umlOwner, name);// create the default diagram
		// in the default package
		if (ownerIntreaction != null) { // the object interaction existe
			diagram.setElement(ownerIntreaction);

			createInteractionGraph(ownerIntreaction, diagram);

		} else if (ownerUsecase != null) {// the diagram is createad from a Usecase
			try {
				createdInteraction = createNewInteraction(ownerUsecase);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			diagram.setElement(createdInteraction);
			createInteractionGraph(createdInteraction, diagram);
		}

		else {
			try {

				createdInteraction = createNewInteraction(umlOwner);
				diagram.setElement(createdInteraction);// associate the diagram to
				// the
				// interaction created for .

				createInteractionGraph(createdInteraction, diagram);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		return diagram;

	}

	@Override
	public void createDiagram(DiResourceSet diResourceSet, EObject container, String name) {
		if (container instanceof Interaction) {// the sequence diagram is created from an
			// interaction
			ownerIntreaction = (Interaction) container;
		} else if (container instanceof UseCase) {// the sequence diagram is created from a Usecase
			ownerUsecase = (UseCase) container;
		}
		super.createDiagram(diResourceSet, container, name);
	}

	/**
	 * 
	 * @param umlOwner
	 *            , the model .
	 * @return the interaction where the Sequence diagram will be created
	 * @throws ExecutionException
	 * 
	 */
	protected Interaction createNewInteraction(EObject umlOwner) throws ExecutionException {

		Interaction result = null;

		TransactionalEditingDomain editingdomain = getDefaultContext().getResourceSet().getTransactionalEditingDomain();

		CreateElementRequest request = new CreateElementRequest(editingdomain, umlOwner,
				UMLElementTypes.Interaction_2001);

		InteractionCreateCommand createCommand = InteractionCreateCommand.create(request, umlOwner);

		if (createCommand != null) {
			createCommand.execute(null, null);

		}

		if (request != null) {
			if (request.getNewElement() instanceof Interaction) {// get the object interaction
				// created by the request.
				result = (Interaction) (request.getNewElement());

			}
		}

		return result;

	}

	void createInteractionGraph(Element interaction, Diagram diagram) {

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
