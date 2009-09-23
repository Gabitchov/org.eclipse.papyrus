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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.diagram.sequence.edit.commands.InteractionCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;

/**
 * Define a command to create a new Sequence Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Sequence Diagram.
 */
public class CreateSequenceDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	private Interaction diagramOwner = null;
	
	@Override
	protected String getDiagramNotationID() {
		return PackageEditPart.MODEL_ID;
	}

	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;

	}

	@Override
	protected String getDiagramName() {
		return super.openDiagramNameDialog("SequenceDiagram");

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
	protected Diagram createDiagram(Resource diagramResource, Element umlOwner, String name) {

		Diagram diagram = null;

		boolean exist = false;

		if (diagramOwner != null)
		{
			// FIXME : search if this code can be refactored
			for (EObject element : diagramResource.getContents()) {
				if (element instanceof Diagram) {
					EObject owner = ((Diagram) element).getElement();
					if (diagramOwner.equals(owner)) {
						exist = true;
					}
				}
			}
		}

		if (!exist) {
			diagram = super.createDiagram(diagramResource, umlOwner, name);// crate the default
			// diagram
			if (diagramOwner != null) {
				diagram.setElement(diagramOwner);
			} else {
				try {
					diagram.setElement(createNewInteraction(umlOwner));// associate the diagram to
					// the
					// interaction created for .
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		return diagram;

	}

	@Override
	public void createDiagram(DiResourceSet diResourceSet, EObject container, String name) {
		if (container instanceof Interaction) {
			diagramOwner = (Interaction) container;
		}
		super.createDiagram(diResourceSet, container, name);
	}

	/**
	 * 
	 * @param umlOwner
	 *            , the model .
	 * @return the interaction where the Sequence diagram will be created
	 * @throws ExecutionException
	 */

	protected Interaction createNewInteraction(Element umlOwner) throws ExecutionException {

		Interaction result = null;
		
		TransactionalEditingDomain editingdomain = getDefaultContext().getResourceSet().getTransactionalEditingDomain();


		CreateElementRequest request = new CreateElementRequest(editingdomain, umlOwner,
				UMLElementTypes.Interaction_2001);

		InteractionCreateCommand createCommand = InteractionCreateCommand.create(request, umlOwner);

		if (createCommand != null) {
			createCommand.execute(null, null);
		}

		if (request != null)
		{
			if (request.getNewElement() instanceof Interaction)
			{
				result = (Interaction) (request.getNewElement());
			}
		}
		return result;

	}

}
