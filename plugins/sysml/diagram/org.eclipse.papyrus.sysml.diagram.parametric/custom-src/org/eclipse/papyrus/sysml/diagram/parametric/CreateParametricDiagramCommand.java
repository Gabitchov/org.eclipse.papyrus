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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ParametricEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlDiagramEditorPlugin;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;

public class CreateParametricDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/** the Block containing the diagram */
	private Class selectedElement = null;

	@Override
	protected String getDiagramNotationID() {
		return ParametricEditPart.MODEL_ID;
	}

	@Override
	protected PreferencesHint getPreferenceHint() {
		return SysmlDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected String getDefaultDiagramName() {
		return "ParametricDiagram";
	}

	//	@Override
	//	protected EObject createRootElement() {
	//		return UMLFactory.eINSTANCE.createModel();
	//	}
	//
	//	@Override
	//	protected void initializeModel(EObject owner) {
	//		EObject eObject = getSelectedElement();
	//		if(eObject == null) {
	//			eObject = owner;
	//		}
	//
	//		if(eObject instanceof Class) {
	//			this.selectedElement = (Class)eObject;
	//		}
	//	}

	@Override
	protected void initializeDiagram(EObject diagram) {
		if(diagram instanceof Diagram) {
			Diagram diag = (Diagram)diagram;
			// test if the selected class is a block
			if(selectedElement != null && selectedElement.getAppliedStereotype(SysmlResource.BLOCK_ID) != null) {
				// YT : Not sure to understand why the selected element is tested to be a Block instead of Block || BlockConstraint
				diag.setElement(selectedElement);
				createParametricGraph(selectedElement, diag);
			}
		}
	}

	@Override
	protected Diagram createDiagram(Resource diagramResource, EObject owner, String name) {
		Diagram diagram = null;

		// FIXME : Dead code below, owner cannot be a Model due to ParametricDiagramCondition 
		// which restricts possible owner to Class only (Block or ConstraintBlock).
		if(owner instanceof Model) {
			Model model = (Model)owner;

			if((model.getAppliedProfile(SysmlResource.SYSML_ID, true) == null) || (model.getAppliedProfile(SysmlResource.BLOCKS_ID, true) == null)) {
				// Retrieve SysML profile and apply with sub-profiles
				Profile sysml = (Profile)PackageUtil.loadPackage(URI.createURI(SysmlResource.SYSML_PROFILE_URI), model.eResource().getResourceSet());
				PackageUtil.applyProfile(model, sysml, true);
			}

			Class ownedClass = model.createOwnedClass("Parametric", false);
			ownedClass.applyStereotype(ownedClass.getApplicableStereotype(SysmlResource.BLOCK_ID));
			diagram = super.createDiagram(diagramResource, ownedClass, name);

		} else if(owner instanceof Class) {
			diagram = super.createDiagram(diagramResource, owner, name);
		}
		return diagram;
	}

	/**
	 * Complete a Parametric diagram with required graphical elements.
	 * 
	 * @param element
	 *        the element to which the diagram is associated
	 * @param diagram
	 *        the diagram to complete
	 */
	private void createParametricGraph(Element element, Diagram diagram) {
		/*
		 * This method implementation allow you to create graphical nodes if required. You may
		 * delete it if not necessary.
		 */
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		IAdaptable elementAdapter = new EObjectAdapter(element);
		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, true, SysmlDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

		CreateCommand nodeCreationCommand = new CreateCommand(editingdomain, descriptor, diagram);

		editingdomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(nodeCreationCommand));
	}
}
