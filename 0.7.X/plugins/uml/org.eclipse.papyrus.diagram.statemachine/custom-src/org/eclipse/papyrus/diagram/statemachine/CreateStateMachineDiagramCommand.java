/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin Cedric.Dumoulin@lifl.fr - Initial API and implementation
 *  Obeo 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.CreateBehavioredClassifierDiagramCommand;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.statemachine.providers.ElementInitializers;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Define a command to create a new StateMachine Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new StateMachine Diagram.
 */
public class CreateStateMachineDiagramCommand extends CreateBehavioredClassifierDiagramCommand {

	private StateMachine stateMachine = null;

	public final static int defaultX = 30;

	public final static int defaultY = 30;

	public final static int defaultWidth = 700;

	public final static int defaultHeight = 300;

	public final static int defaultHeader = 13;

	@Override
	protected EClass getBehaviorEClass() {
		return UMLPackage.eINSTANCE.getStateMachine();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultDiagramName() {
		return "SmDiagram";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return PackageEditPart.MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}


	@Override
	protected void initializeDiagram(EObject diagram) {
		if(diagram instanceof Diagram) {
			Diagram diag = (Diagram)diagram;
			if(stateMachine != null) {
				diag.setElement(stateMachine);
				View stateMachineView = ViewService.getInstance().createView(Node.class, new EObjectAdapter(stateMachine), diag, null, ViewUtil.APPEND, true, getPreferenceHint());
				Zone.setX(stateMachineView, defaultX);
				Zone.setY(stateMachineView, defaultY);
				Zone.setWidth(stateMachineView, defaultWidth);
				Zone.setHeight(stateMachineView, defaultHeight);

				View compartmentView = null;

				Iterator<Node> it = stateMachineView.getChildren().iterator();

				while(it.hasNext()) {
					Node currentNode = it.next();
					if(currentNode.getLayoutConstraint() == null) {
						currentNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
					}
					if(UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateMachineNameEditPart.VISUAL_ID) {
						Zone.setWidth(currentNode, defaultWidth);
						Zone.setHeight(currentNode, defaultHeader);
					} else if(UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateMachineCompartmentEditPart.VISUAL_ID) {
						Zone.setY(currentNode, defaultHeader);
						Zone.setWidth(currentNode, defaultWidth);
						Zone.setHeight(currentNode, defaultHeight - defaultHeader);
						compartmentView = currentNode;
					}
				}
				Region region = stateMachine.getRegions().get(0);

				IAdaptable regionAdaptable = new SemanticAdapter(region, null);
				String semanticHint = ((IHintedType)UMLElementTypes.Region_3000).getSemanticHint();

				if(compartmentView != null) {
					Node regionNode = ViewService.getInstance().createNode(regionAdaptable, compartmentView, semanticHint, -1, getPreferenceHint());
					if(regionNode.getLayoutConstraint() == null) {
						regionNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
					}
					// add region specifics
					Zone.createRegionDefaultAnnotation(regionNode);
					Zone.setWidth(regionNode, defaultWidth);
					Zone.setHeight(regionNode, defaultHeight - defaultHeader);

				}
			}
			diag.setName(getName());
		}
	}


	@Override
	protected void initializeModel(EObject owner) {
		if(owner.eClass() == getBehaviorEClass()) {
			stateMachine = (StateMachine)owner;

		} else {
			stateMachine = UMLFactory.eINSTANCE.createStateMachine();

			if(owner instanceof BehavioredClassifier) {
				BehavioredClassifier behaviorClassifier = (BehavioredClassifier)owner;
				behaviorClassifier.getOwnedBehaviors().add(stateMachine);

			} else if(owner instanceof Package) {
				org.eclipse.uml2.uml.Package pack = (org.eclipse.uml2.uml.Package)owner;
				pack.getPackagedElements().add(stateMachine);

			}
			ElementInitializers.getInstance().init_StateMachine_2000(stateMachine);
		}
	}


}
