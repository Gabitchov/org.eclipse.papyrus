/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.activity;

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
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Define a command to create a new Activity Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Activity Diagram.
 */
public class CreateActivityDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/** the activity containing the diagram */
	private Activity activity = null;

	@Override
	protected String getDiagramNotationID() {
		return ActivityDiagramEditPart.MODEL_ID;
	}

	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected String getDefaultDiagramName() {
		return super.openDiagramNameDialog("ActivityDiagram");
	}

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	@Override
	protected void initializeDiagram(EObject diagram) {
		if(diagram instanceof Diagram) {
			Diagram diag = (Diagram)diagram;
			if(activity != null) {
				diag.setElement(activity);
				createActivityGraph(activity, diag);
			}
		}
	}

	@Override
	protected void initializeModel(EObject owner) {
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();

		EObject selectedElement = getSelectedElement();
		if(selectedElement == null) {
			selectedElement = owner;
		}
		if(selectedElement != null) {
			if(selectedElement instanceof Activity) {
				activity = (Activity)selectedElement;
			} else if(selectedElement instanceof Package) {
				// Create the request
				CreateElementRequest request = new CreateElementRequest(editingdomain, selectedElement, UMLElementTypes.Activity_2001);

				// Create the command
				ActivityCreateCommand createCommand = ActivityCreateCommand.create(request, selectedElement);

				// Execute the command
				if(createCommand != null) {
					try {
						createCommand.execute(null, null);
					} catch (ExecutionException e) {
						e.printStackTrace();
					}

				}

				// retrieve the result
				if(request != null) {
					if(request.getNewElement() instanceof Activity) {
						activity = (Activity)(request.getNewElement());
					}
				}
			}
		}
	}

	@Override
	protected Diagram createDiagram(Resource diagramResource, EObject owner, String name) {
		Diagram diagram = null;
		if(owner instanceof Package) {
			diagram = super.createDiagram(diagramResource, owner, name);
		} else {
			if(owner instanceof Element) {
				Element element = (Element)owner;
				diagram = super.createDiagram(diagramResource, element.getModel(), name);
			}
		}
		return diagram;
	}

	/**
	 * Complete an activity diagram with required graphical elements.
	 * 
	 * @param activity
	 *        the activity to which the diagram is associated
	 * @param diagram
	 *        the diagram to complete
	 */
	private void createActivityGraph(Element activity, Diagram diagram) {

		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		IAdaptable elementAdapter = new EObjectAdapter(activity);
		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, false, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

		CreateCommand nodeCreationCommand = new CreateCommand(editingdomain, descriptor, diagram);

		try {
			OperationHistoryFactory.getOperationHistory().execute(nodeCreationCommand, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
			Activator.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		}
	}

}
