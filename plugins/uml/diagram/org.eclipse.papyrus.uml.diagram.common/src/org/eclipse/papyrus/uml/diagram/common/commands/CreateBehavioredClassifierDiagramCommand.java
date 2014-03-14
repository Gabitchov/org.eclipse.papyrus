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
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Define a command to create a new Behavioral Diagram. This command is used by
 * all UI (toolbar, outline, creation wizards) to create a new Behavioral
 * Diagram. This class should be extended by behavioral diagram only.
 */
public abstract class CreateBehavioredClassifierDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

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
	 * 
	 * @return
	 */
	protected Behavior createBehavior() {
		Behavior newBehavior = (Behavior)UMLFactory.eINSTANCE.create(getBehaviorEClass());

		return newBehavior;
	}

	/**
	 * Get the kind of behavior associated to the diagram
	 * 
	 * @return the EClass of the behavior supposed to own the diagram.
	 */
	protected abstract EClass getBehaviorEClass();

	/**
	 * {@inheritDoc}
	 */
	protected void initializeModel(EObject owner) {

		if(owner.eClass() == getBehaviorEClass()) {
			behavior = (Behavior)owner;

		} else {
			behavior = (Behavior)UMLFactory.eINSTANCE.create(getBehaviorEClass());

			if(owner instanceof BehavioredClassifier) {
				BehavioredClassifier behaviorClassifier = (BehavioredClassifier)owner;
				behaviorClassifier.getOwnedBehaviors().add(behavior);

			} else if(owner instanceof Package) {
				org.eclipse.uml2.uml.Package pack = (org.eclipse.uml2.uml.Package)owner;
				pack.getPackagedElements().add(behavior);

			}
			behavior.setName(NamedElementUtil.getName(behavior));
		}
	}

	private void createBehaviorView(Diagram diagram) {
		ViewService.getInstance().createView(Node.class, new EObjectAdapter(behavior), diagram, null, ViewUtil.APPEND, true, getPreferenceHint());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Diagram doCreateDiagram(Resource diagramResource, EObject owner, EObject element, ViewPrototype prototype, String name) {
		Diagram diagram = null;
		if(element instanceof org.eclipse.uml2.uml.Package) {
			diagram = ViewService.createDiagram(element, getDiagramNotationID(), getPreferenceHint());
		} else if(element instanceof BehavioredClassifier) {
			diagram = ViewService.createDiagram(((BehavioredClassifier)element).getNearestPackage(), getDiagramNotationID(), getPreferenceHint());
		}
		// create diagram
		if(diagram != null) {
			setName(name);
			diagram.setElement(element);
			DiagramUtils.setOwner(diagram, owner);
			if (!prototype.isNatural())
				DiagramUtils.setPrototype(diagram, prototype);
			initializeModel(element);
			initializeDiagram(diagram);
			diagramResource.getContents().add(diagram);
		}
		return diagram;
	}

	/**
	 * Set the name of the diagram and its containing element
	 * 
	 * @param newName
	 */
	protected void setName(String newName) {
		if(newName == null || newName.equals(name)) {
			return;
		}
		name = newName;
	}

	protected String getName() {
		return name;
	}
}
