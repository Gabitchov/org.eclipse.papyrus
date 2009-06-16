/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfoRegistry;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReference2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate10EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate11EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate12EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate13EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate14EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate8EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate9EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Region2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubvertices2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubverticesEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachine2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName8EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.statemachine.expressions.UMLOCLFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented by
 * a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.statemachine/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static UMLAbstractExpression State_2002_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression State_2003_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression State_2005_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression ConnectionPointReference_2006_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression ConnectionPointReference_2007_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2009_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2010_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2011_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2012_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2013_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2014_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2015_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2016_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression State_2017_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2018_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2019_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2020_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2021_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2022_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Pseudostate_2023_Constraint;

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (StateMachineEditPart.MODEL_ID.equals(view.getType())) {
				return StateMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Package) domainElement)) {
			return StateMachineEditPart.VISUAL_ID;
		}

		if (UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((StateMachine) domainElement)) {
			return StateMachineEditPart.VISUAL_ID;
		}

		if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Class) domainElement)) {
			return StateMachineEditPart.VISUAL_ID;
		}

		return -1;
	}

	/**
	 * Modified to return the correct VisualID for <ConnectionPointReference>
	 * elements. Modified to check FinalState before any State.
	 * 
	 * @generated NOT
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
				.getModelID(containerView);
		if (!StateMachineEditPart.MODEL_ID.equals(containerModelID)
				&& !"UMLStatemachine".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (StateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StateMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case StateMachine2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())) {
				return RegionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2022((Pseudostate) domainElement)) {
				return Pseudostate13EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2023((Pseudostate) domainElement)) {
				return Pseudostate14EditPart.VISUAL_ID;
			}
			break;
		case State2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())) {
				return Region2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2020((Pseudostate) domainElement)) {
				return Pseudostate11EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2021((Pseudostate) domainElement)) {
				return Pseudostate12EditPart.VISUAL_ID;
			}
			break;
		case State3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())) {
				return Region2EditPart.VISUAL_ID;
			}
			// fjcano : modified to give the correct ID for a
			// ConnectionPointReference
			if (UMLPackage.eINSTANCE.getConnectionPointReference()
					.isSuperTypeOf(domainElement.eClass())
					&& domainElement instanceof ConnectionPointReference
					&& checkDomainElementIsEntryConnectionPointReference(domainElement)) {
				return ConnectionPointReferenceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnectionPointReference()
					.isSuperTypeOf(domainElement.eClass())
					&& checkDomainElementIsExitConnectionPointReference(domainElement)) {
				return ConnectionPointReference2EditPart.VISUAL_ID;
			}
			break;
		case State4EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2018((Pseudostate) domainElement)) {
				return Pseudostate9EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2019((Pseudostate) domainElement)) {
				return Pseudostate10EditPart.VISUAL_ID;
			}
			break;
		case RegionSubverticesEditPart.VISUAL_ID:
			// fjcano :: check FinalState before any State
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2002((State) domainElement)) {
				return StateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2003((State) domainElement)) {
				return State2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2005((State) domainElement)) {
				return State3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2017((State) domainElement)) {
				return State4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2009((Pseudostate) domainElement)) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2010((Pseudostate) domainElement)) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2011((Pseudostate) domainElement)) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2012((Pseudostate) domainElement)) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2013((Pseudostate) domainElement)) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2014((Pseudostate) domainElement)) {
				return Pseudostate6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2015((Pseudostate) domainElement)) {
				return Pseudostate7EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2016((Pseudostate) domainElement)) {
				return Pseudostate8EditPart.VISUAL_ID;
			}
			break;
		case RegionSubvertices2EditPart.VISUAL_ID:
			// fjcano :: check FinalState before eny State
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2002((State) domainElement)) {
				return StateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2003((State) domainElement)) {
				return State2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2005((State) domainElement)) {
				return State3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2017((State) domainElement)) {
				return State4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2009((Pseudostate) domainElement)) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2010((Pseudostate) domainElement)) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2011((Pseudostate) domainElement)) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2012((Pseudostate) domainElement)) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2013((Pseudostate) domainElement)) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2014((Pseudostate) domainElement)) {
				return Pseudostate6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2015((Pseudostate) domainElement)) {
				return Pseudostate7EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2016((Pseudostate) domainElement)) {
				return Pseudostate8EditPart.VISUAL_ID;
			}
			break;
		case StateMachineEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(
					domainElement.eClass())) {
				return StateMachine2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(
					domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	private static boolean checkDomainElementIsEntryConnectionPointReference(
			EObject element) {
		if (element == null) {
			return false;
		}
		if (element instanceof ConnectionPointReference == false) {
			return false;
		}
		ConnectionPointReference point = (ConnectionPointReference) element;
		java.util.List<Pseudostate> entries = point.getEntries();
		if (entries.size() <= 0) {
			return false;
		}
		for (Pseudostate ps : entries) {
			if (ps.getKind() != PseudostateKind.ENTRY_POINT_LITERAL) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkDomainElementIsExitConnectionPointReference(
			EObject element) {
		if (element == null) {
			return false;
		}
		if (element instanceof ConnectionPointReference == false) {
			return false;
		}
		ConnectionPointReference point = (ConnectionPointReference) element;
		java.util.List<Pseudostate> exits = point.getExits();
		if (exits.size() <= 0) {
			return false;
		}
		for (Pseudostate ps : exits) {
			if (ps.getKind() != PseudostateKind.EXIT_POINT_LITERAL) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
				.getModelID(containerView);
		if (!StateMachineEditPart.MODEL_ID.equals(containerModelID)
				&& !"UMLStatemachine".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (StateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StateMachineEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case StateMachine2EditPart.VISUAL_ID:
			if (StateMachineNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateMachineName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate13EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate14EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if (CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionEditPart.VISUAL_ID:
			if (RegionSubverticesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case State2EditPart.VISUAL_ID:
			if (StateName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Region2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate11EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate12EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Region2EditPart.VISUAL_ID:
			if (RegionSubvertices2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case State3EditPart.VISUAL_ID:
			if (StateName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateName6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConnectionPointReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConnectionPointReference2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			if (ConnectionPointReferenceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConnectionPointReference2EditPart.VISUAL_ID:
			if (ConnectionPointReferenceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Pseudostate7EditPart.VISUAL_ID:
			if (PseudostateName7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case State4EditPart.VISUAL_ID:
			if (StateName7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateName8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate10EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Pseudostate9EditPart.VISUAL_ID:
			if (PseudostateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Pseudostate10EditPart.VISUAL_ID:
			if (PseudostateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Pseudostate11EditPart.VISUAL_ID:
			if (PseudostateName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Pseudostate12EditPart.VISUAL_ID:
			if (PseudostateName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Pseudostate13EditPart.VISUAL_ID:
			if (PseudostateName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Pseudostate14EditPart.VISUAL_ID:
			if (PseudostateName6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionSubverticesEditPart.VISUAL_ID:
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionSubvertices2EditPart.VISUAL_ID:
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateMachineEditPart.VISUAL_ID:
			if (StateMachine2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransitionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getTransition().isSuperTypeOf(
				domainElement.eClass())) {
			return TransitionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isDiagram(StateMachine element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isDiagram(Class element) {
		return true;
	}

	/**
	 * Modified to check the <State> is simple.
	 * 
	 * @generated NOT
	 */
	private static boolean isState_2002(State domainElement) {
		if (domainElement == null) {
			return false;
		}
		// fjcano : check that this is a simple <State>.
		if (domainElement.getRegions().size() == 0
				&& domainElement.getSubmachine() == null) {
			return true;
		}
		return false;
	}

	/**
	 * Modified to check this is a composite <State>.
	 * 
	 * @generated NOT
	 */
	private static boolean isState_2003(State domainElement) {
		if (domainElement == null) {
			return false;
		}
		// fjcano : modified to check this <State> is a composite.
		if (domainElement.getRegions().size() > 0
				&& domainElement.getSubmachine() == null) {
			return true;
		}
		return false;
	}

	/**
	 * Modified to check this is a submachine <State>.
	 * 
	 * @generated NOT
	 */
	private static boolean isState_2005(State domainElement) {
		if (domainElement == null) {
			return false;
		}
		// fjcano : check that this is a submachine <State>.
		if (domainElement.getRegions().size() == 0
				&& domainElement.getSubmachine() != null) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static boolean isConnectionPointReference_2006(
			ConnectionPointReference domainElement) {
		if (ConnectionPointReference_2006_Constraint == null) { // lazy initialization
			ConnectionPointReference_2006_Constraint = UMLOCLFactory
					.getExpression(
							"entry->notEmpty() implies entry->forAll(e | e.kind =  PseudostateKind::entryPoint)", UMLPackage.eINSTANCE.getConnectionPointReference()); //$NON-NLS-1$
		}
		Object result = ConnectionPointReference_2006_Constraint
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isConnectionPointReference_2007(
			ConnectionPointReference domainElement) {
		if (ConnectionPointReference_2007_Constraint == null) { // lazy initialization
			ConnectionPointReference_2007_Constraint = UMLOCLFactory
					.getExpression(
							"exit->notEmpty() implies exit->forAll(e | e.kind =  PseudostateKind::exitPoint)", UMLPackage.eINSTANCE.getConnectionPointReference()); //$NON-NLS-1$
		}
		Object result = ConnectionPointReference_2007_Constraint
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2009(Pseudostate domainElement) {
		if (Pseudostate_2009_Constraint == null) { // lazy initialization
			Pseudostate_2009_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::initial", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2009_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2010(Pseudostate domainElement) {
		if (Pseudostate_2010_Constraint == null) { // lazy initialization
			Pseudostate_2010_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::shallowHistory", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2010_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2011(Pseudostate domainElement) {
		if (Pseudostate_2011_Constraint == null) { // lazy initialization
			Pseudostate_2011_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::deepHistory", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2011_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2012(Pseudostate domainElement) {
		if (Pseudostate_2012_Constraint == null) { // lazy initialization
			Pseudostate_2012_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::fork", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2012_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2013(Pseudostate domainElement) {
		if (Pseudostate_2013_Constraint == null) { // lazy initialization
			Pseudostate_2013_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::join", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2013_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2014(Pseudostate domainElement) {
		if (Pseudostate_2014_Constraint == null) { // lazy initialization
			Pseudostate_2014_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::junction", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2014_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2015(Pseudostate domainElement) {
		if (Pseudostate_2015_Constraint == null) { // lazy initialization
			Pseudostate_2015_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::choice", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2015_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2016(Pseudostate domainElement) {
		if (Pseudostate_2016_Constraint == null) { // lazy initialization
			Pseudostate_2016_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::terminate", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2016_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * 
	 * Modified to check this <State> is a composite.
	 * 
	 * @generated NOT
	 */
	private static boolean isState_2017(State domainElement) {
		if (domainElement == null) {
			return false;
		}
		// fjcano : check this <State> is a composite.
		if (domainElement.getRegions().size() > 0
				&& domainElement.getSubmachine() == null) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2018(Pseudostate domainElement) {
		if (Pseudostate_2018_Constraint == null) { // lazy initialization
			Pseudostate_2018_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::entryPoint", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2018_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2019(Pseudostate domainElement) {
		if (Pseudostate_2019_Constraint == null) { // lazy initialization
			Pseudostate_2019_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::exitPoint", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2019_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2020(Pseudostate domainElement) {
		if (Pseudostate_2020_Constraint == null) { // lazy initialization
			Pseudostate_2020_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::entryPoint", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2020_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2021(Pseudostate domainElement) {
		if (Pseudostate_2021_Constraint == null) { // lazy initialization
			Pseudostate_2021_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::exitPoint", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2021_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2022(Pseudostate domainElement) {
		if (Pseudostate_2022_Constraint == null) { // lazy initialization
			Pseudostate_2022_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::entryPoint", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2022_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPseudostate_2023(Pseudostate domainElement) {
		if (Pseudostate_2023_Constraint == null) { // lazy initialization
			Pseudostate_2023_Constraint = UMLOCLFactory
					.getExpression(
							"self.kind = PseudostateKind::exitPoint", UMLPackage.eINSTANCE.getPseudostate()); //$NON-NLS-1$
		}
		Object result = Pseudostate_2023_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	protected static boolean hasViewChild(View containerView,
			EObject domainElement, int visualId) {
		if (domainElement == null) {
			return false;
		}
		for (Object next : containerView.getChildren()) {
			View nextView = (View) next;
			if (domainElement.equals(nextView.getElement())
					&& getType(visualId).equals(nextView.getType())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getChildDescriptorVisualID(UMLNodeDescriptor container,
			EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		switch (container.getVisualID()) {
		case StateMachine2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())) {
				return RegionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2022((Pseudostate) domainElement)) {
				return Pseudostate13EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2023((Pseudostate) domainElement)) {
				return Pseudostate14EditPart.VISUAL_ID;
			}
			break;
		case RegionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2002((State) domainElement)) {
				return StateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2003((State) domainElement)) {
				return State2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2005((State) domainElement)) {
				return State3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2009((Pseudostate) domainElement)) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2010((Pseudostate) domainElement)) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2011((Pseudostate) domainElement)) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2012((Pseudostate) domainElement)) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2013((Pseudostate) domainElement)) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2014((Pseudostate) domainElement)) {
				return Pseudostate6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2015((Pseudostate) domainElement)) {
				return Pseudostate7EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2016((Pseudostate) domainElement)) {
				return Pseudostate8EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2017((State) domainElement)) {
				return State4EditPart.VISUAL_ID;
			}
			break;
		case State2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())) {
				return Region2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2020((Pseudostate) domainElement)) {
				return Pseudostate11EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2021((Pseudostate) domainElement)) {
				return Pseudostate12EditPart.VISUAL_ID;
			}
			break;
		case Region2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2002((State) domainElement)) {
				return StateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2003((State) domainElement)) {
				return State2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2005((State) domainElement)) {
				return State3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2009((Pseudostate) domainElement)) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2010((Pseudostate) domainElement)) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2011((Pseudostate) domainElement)) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2012((Pseudostate) domainElement)) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2013((Pseudostate) domainElement)) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2014((Pseudostate) domainElement)) {
				return Pseudostate6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2015((Pseudostate) domainElement)) {
				return Pseudostate7EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2016((Pseudostate) domainElement)) {
				return Pseudostate8EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2017((State) domainElement)) {
				return State4EditPart.VISUAL_ID;
			}
			break;
		case State3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getConnectionPointReference()
					.isSuperTypeOf(domainElement.eClass())
					&& isConnectionPointReference_2006((ConnectionPointReference) domainElement)) {
				return ConnectionPointReferenceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnectionPointReference()
					.isSuperTypeOf(domainElement.eClass())
					&& isConnectionPointReference_2007((ConnectionPointReference) domainElement)) {
				return ConnectionPointReference2EditPart.VISUAL_ID;
			}
			break;
		case State4EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2018((Pseudostate) domainElement)) {
				return Pseudostate9EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2019((Pseudostate) domainElement)) {
				return Pseudostate10EditPart.VISUAL_ID;
			}
			break;
		case StateMachineEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(
					domainElement.eClass())) {
				return StateMachine2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(
					domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2002((State) domainElement)) {
				return StateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2003((State) domainElement)) {
				return State2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2005((State) domainElement)) {
				return State3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2009((Pseudostate) domainElement)) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2010((Pseudostate) domainElement)) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2011((Pseudostate) domainElement)) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2012((Pseudostate) domainElement)) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2013((Pseudostate) domainElement)) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2014((Pseudostate) domainElement)) {
				return Pseudostate6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2015((Pseudostate) domainElement)) {
				return Pseudostate7EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2016((Pseudostate) domainElement)) {
				return Pseudostate8EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2017((State) domainElement)) {
				return State4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2002((State) domainElement)) {
				return StateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2003((State) domainElement)) {
				return State2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2005((State) domainElement)) {
				return State3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2009((Pseudostate) domainElement)) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2010((Pseudostate) domainElement)) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2011((Pseudostate) domainElement)) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2012((Pseudostate) domainElement)) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2013((Pseudostate) domainElement)) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2014((Pseudostate) domainElement)) {
				return Pseudostate6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2015((Pseudostate) domainElement)) {
				return Pseudostate7EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_2016((Pseudostate) domainElement)) {
				return Pseudostate8EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())
					&& isState_2017((State) domainElement)) {
				return State4EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	private static ViewInfo diagramViewInfo = null;

	/**
	 * @generated
	 */
	public static ViewInfo getDiagramViewInfo() {
		if (diagramViewInfo == null) {
			diagramViewInfo = ViewInfoRegistry.getInstance()
					.getHeadViewInfoForEditor(UMLDiagramEditor.ID);
		}
		return diagramViewInfo;
	}

}
