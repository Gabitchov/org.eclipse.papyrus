/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.common.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.actions.LabelHelper;
import org.eclipse.papyrus.diagram.common.ids.UMLDiagramEditorIDs;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// TODO: Auto-generated Javadoc
/**
 * Diagram initializers add initial elements to the diagram.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class UMLDiagramEditorInitializers {

	/** Class diagram initializer. */
	public static IDiagramInitializer ClassDiagramInitializer = new IDiagramInitializer() {

		public void init(Diagram diagram) {
			// XXX: no initialization
			return;
		};
	};

	/** Activity diagram initializer. */
	public static IDiagramInitializer ActivityDiagramInitializer = new IDiagramInitializer() {

		public void init(Diagram diagram) {
			EObject eObject = diagram.getElement();
			Activity activity = null;
			if (eObject instanceof Package) {
				activity = (Activity) createAndNameInPackage((Package) eObject, UMLPackage.eINSTANCE.getActivity());
			} else if (eObject instanceof Activity) {
				activity = (Activity) eObject;
			}
			if (activity != null) {
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, activity);
			}
		};
	};

	/** StateMachine diagram initializer. */
	public static IDiagramInitializer StateMachineDiagramInitializer = new IDiagramInitializer() {

		public void init(Diagram diagram) {
			EObject eObject = diagram.getElement();
			StateMachine stateMachine = null;
			if (eObject instanceof Package) {
				stateMachine = (StateMachine) createAndNameInPackage((Package) eObject, UMLPackage.eINSTANCE
						.getStateMachine());
				stateMachine.createRegion("Region");
			} else if (eObject instanceof StateMachine) {
				stateMachine = (StateMachine) eObject;
			}
			if (stateMachine != null) {
				PreferencesHint preferences = new PreferencesHint(diagram.getType());
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, stateMachine);
				View stateMachineNode = ViewService.createNode(diagram, stateMachine, null, preferences);
				for (Region region : stateMachine.getRegions()) {
					MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, region);
					ViewService.createNode(stateMachineNode, region, null, preferences);
				}
			}
		}
	};

	/** Usecase diagram initializer. */
	public static IDiagramInitializer UsecaseDiagramInitializer = new IDiagramInitializer() {

		public void init(Diagram diagram) {
			// XXX: no initialization
			return;
		}
	};

	/** Sequence diagram initializer. */
	public static IDiagramInitializer SequenceDiagramInitializer = new IDiagramInitializer() {

		public void init(Diagram diagram) {
			EObject eObject = diagram.getElement();
			Interaction interaction = null;
			if (eObject instanceof Package) {
				interaction = (Interaction) createAndNameInPackage((Package) eObject, UMLPackage.eINSTANCE
						.getInteraction());
			} else if (eObject instanceof Interaction) {
				interaction = (Interaction) eObject;
			}
			if (interaction != null) {
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, interaction);
			}
		}
	};

	/** Map diagramKind 2 Initializer. */
	public static Map<String, IDiagramInitializer> MapDiagramKindToDiagramInitializer = null;
	static {
		MapDiagramKindToDiagramInitializer = new HashMap<String, IDiagramInitializer>();
		MapDiagramKindToDiagramInitializer.put(UMLDiagramEditorIDs.ClazzModelID, ClassDiagramInitializer);
		MapDiagramKindToDiagramInitializer.put(UMLDiagramEditorIDs.ActivityModelID, ActivityDiagramInitializer);
		MapDiagramKindToDiagramInitializer.put(UMLDiagramEditorIDs.StateMachineModelID, StateMachineDiagramInitializer);
		MapDiagramKindToDiagramInitializer.put(UMLDiagramEditorIDs.SequenceModelID, SequenceDiagramInitializer);
		MapDiagramKindToDiagramInitializer.put(UMLDiagramEditorIDs.UseCaseModelID, UsecaseDiagramInitializer);
	}

	/**
	 * Helper class to create an element and give it a name.
	 * 
	 * @param pakage
	 *            the pakage
	 * @param eClass
	 *            the e class
	 * 
	 * @return the e object
	 */
	private static EObject createAndNameInPackage(Package pakage, EClass eClass) {
		EObject eObject = UMLFactory.eINSTANCE.create(eClass);
		if (eObject != null && eObject instanceof PackageableElement) {
			LabelHelper.INSTANCE.initName(pakage, eObject);
			EditingDomain domain = TransactionUtil.getEditingDomain(pakage);
			domain.getCommandStack().execute(
					new AddCommand(domain, pakage, UMLPackage.eINSTANCE.getPackage_PackagedElement(), eObject));
		}
		return eObject;
	}

	// // *********

	/**
	 * The Interface IDiagramInitializer.
	 */
	public interface IModelInitializer {

		/**
		 * Inits the.
		 * 
		 * @param diagram
		 *            the diagram
		 */
		Package init();
	}

	public static IModelInitializer ClazzModelInitializer = new IModelInitializer() {

		public Package init() {
			Package model = UMLFactory.eINSTANCE.createModel();
			model.setName("Model");
			return model;
		}
	};

	public static IModelInitializer ActivityModelInitializer = new IModelInitializer() {

		public Package init() {
			Package model = UMLFactory.eINSTANCE.createModel();
			model.setName("Model");
			return model;
		}
	};

	public static IModelInitializer UseCaseModelInitializer = new IModelInitializer() {

		public Package init() {
			Package model = UMLFactory.eINSTANCE.createModel();
			model.setName("Model");
			return model;
		}
	};

	public static IModelInitializer StateModelInitializer = new IModelInitializer() {

		public Package init() {
			Package model = UMLFactory.eINSTANCE.createModel();
			model.setName("Model");
			return model;
		}
	};

	public static IModelInitializer SequenceModelInitializer = new IModelInitializer() {

		public Package init() {
			Package model = UMLFactory.eINSTANCE.createModel();
			model.setName("Model");
			return model;
		}
	};

	public static IModelInitializer ProfileModelInitializer = new IModelInitializer() {

		public Package init() {
			Package package_ = UMLFactory.eINSTANCE.createProfile();
			package_.setName("Package");
			return package_;
		}
	};

	/** Map diagramKind 2 Initializer. */
	public static Map<String, IModelInitializer> MapDiagramKindToModelInitializer = null;
	static {
		MapDiagramKindToModelInitializer = new HashMap<String, IModelInitializer>();
		MapDiagramKindToModelInitializer.put(UMLDiagramEditorIDs.ClazzModelID, ClazzModelInitializer);
		MapDiagramKindToModelInitializer.put(UMLDiagramEditorIDs.ActivityModelID, ActivityModelInitializer);
		MapDiagramKindToModelInitializer.put(UMLDiagramEditorIDs.StateMachineModelID, StateModelInitializer);
		MapDiagramKindToModelInitializer.put(UMLDiagramEditorIDs.SequenceModelID, SequenceModelInitializer);
		MapDiagramKindToModelInitializer.put(UMLDiagramEditorIDs.UseCaseModelID, UseCaseModelInitializer);
		MapDiagramKindToModelInitializer.put(UMLDiagramEditorIDs.ProfileModelID, ProfileModelInitializer);
	}
}
