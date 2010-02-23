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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric;

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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagramprofile.utils.StereotypeUtils;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ResourceEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlDiagramEditorPlugin;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

public class CreateParametricDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/** the Block containing the diagram */
	private Class selectedElement = null;

	@Override
	protected String getDiagramNotationID() {
		return ResourceEditPart.MODEL_ID;
	}

	@Override
	protected PreferencesHint getPreferenceHint() {
		return SysmlDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected String getDefaultDiagramName() {
		return super.openDiagramNameDialog("ParametricDiagram");
	}

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	@Override
	protected void initializeModel(EObject owner) {
		EObject eObject = getSelectedElement();
		if (eObject == null) {
			eObject = owner;
		}

		if (eObject instanceof Class) {
			this.selectedElement = (Class) eObject;
		}
	}

	@Override
	protected void initializeDiagram(EObject diagram) {
		if (diagram instanceof Diagram) {
			Diagram diag = (Diagram) diagram;
			// test if the selected class is a block
			if (selectedElement != null && StereotypeUtils.isStereotypeApplied("SysML::Blocks::Block", selectedElement)) {
				diag.setElement(selectedElement);
				createParametricGraph(selectedElement, diag);
			}
		}
	}

	@Override
	protected Diagram createDiagram(Resource diagramResource, EObject owner, String name) {
		Diagram diagram = null;
		if (owner instanceof Model) {
			Model model = (Model) owner;
			Profile sysmlProfile = StereotypeUtils.loadProfile(StereotypeUtils.SYSML_URI, model.eResource().getResourceSet());
			if (!StereotypeUtils.isProfileApplied("SysML", model)) {
				model.applyProfile(sysmlProfile);
			}
			
			Class ownedClass = model.createOwnedClass("Parametric", false);
			Profile blockProfile = (Profile) sysmlProfile.getOwnedMember("Blocks");
			if (blockProfile != null) {
				if (!model.isProfileApplied(blockProfile)) {
					model.applyProfile(blockProfile);					
				}
				ownedClass.applyStereotype(blockProfile.getOwnedStereotype("Block"));				
				diagram = super.createDiagram(diagramResource, ownedClass, name);
			}
		} else if (owner instanceof Class) {
			diagram = super.createDiagram(diagramResource, owner, name);
		}
		return diagram;
	}

	/**
	 * Complete a Parametric diagram with required graphical elements.
	 * 
	 * @param element
	 *            the element to which the diagram is associated
	 * @param diagram
	 *            the diagram to complete
	 */
	private void createParametricGraph(Element element, Diagram diagram) {
		/*
		 * This method implementation allow you to create graphical nodes if required. You may
		 * delete it if not necessary.
		 */
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		IAdaptable elementAdapter = new EObjectAdapter(element);
		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, false,
				SysmlDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

		CreateCommand nodeCreationCommand = new CreateCommand(editingdomain, descriptor, diagram);

		try {
			OperationHistoryFactory.getOperationHistory().execute(nodeCreationCommand, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
			SysmlDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		}
	}
}
