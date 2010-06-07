/*******************************************************************************
 * Copyright (c) 2010 AtosOrigin.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     AtosOrigin - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Define a command to create a new Behavioral Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Behavioral Diagram.
 * This class should be extended by behavioral diagram only. 
 */
public abstract class CreateBehavioredClassifierDiagramCommand extends AbstractUMLCreateDiagramCommand {

	private Behavior behavior = null;
	
	private String name = ""; //$NON-NLS-1$
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeDiagram(EObject diagram) {
		if(diagram instanceof Diagram) {
			Diagram diag = (Diagram)diagram;
			if(behavior != null) {
				diag.setElement(behavior);
				createBehaviorView(diag);
			}
			diag.setName(getName());
		}
		
	}
	
	/**
	 * Create the associated behavior
	 * @return
	 */
	protected abstract Behavior createBehavior();

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		if(behavior == null){
			behavior = createBehavior();
		}
		if(owner.eClass().equals(behavior.eClass())){
			behavior = (Behavior)owner;
		}
		else if(owner instanceof BehavioredClassifier){
			BehavioredClassifier behaviorClassifier = (BehavioredClassifier)owner;
			behavior = (Behavior)behaviorClassifier.createClassifierBehavior(getName(), behavior.eClass());
		}else if (owner instanceof Package){
			org.eclipse.uml2.uml.Package pack = (org.eclipse.uml2.uml.Package)owner;
			behavior = (Behavior)pack.createPackagedElement(getName(), behavior.eClass());
		}
	}
	
	private void createBehaviorView(Diagram diagram) {
		ViewService.getInstance().createView(Node.class, new EObjectAdapter(behavior), diagram, null, ViewUtil.APPEND, true, getPreferenceHint());
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Diagram createDiagram(Resource diagramResource, EObject owner, String name) {
		Diagram diagram = null;
		if(owner instanceof org.eclipse.uml2.uml.Package){
			diagram = ViewService.createDiagram(owner, getDiagramNotationID(), getPreferenceHint());
		}else if (owner instanceof BehavioredClassifier){
			diagram = ViewService.createDiagram(((BehavioredClassifier)owner).getNearestPackage(), getDiagramNotationID(), getPreferenceHint());
		}
		// create diagram
		if(diagram != null) {
			setName(name);	

			diagramResource.getContents().add(diagram);
			initializeModel(owner);
			initializeDiagram(diagram);
		}
		return diagram;
	}
	
	/**
	 * Set the name of the diagram and its containing element
	 * @param newName
	 */
	protected void setName(String newName){
		if(newName == null || newName.equals(name)){
			return;
		}
		name = newName;
	}
	
	private String getName(){
		return name;
	}
	

	@Override
	protected void runAsTransaction(DiResourceSet diResourceSet, EObject container, String name) {
		if(name == null && container instanceof NamedElement) {
			setName(((NamedElement)container).getName());
			if(!"".equals(getName())) {
				// initialize name with activity's name
				name = openDiagramNameDialog(getName());
				if(name == null) {
					// operation canceled
					return;
				}
			}
		}
		super.runAsTransaction(diResourceSet, container, name);
	}
}
