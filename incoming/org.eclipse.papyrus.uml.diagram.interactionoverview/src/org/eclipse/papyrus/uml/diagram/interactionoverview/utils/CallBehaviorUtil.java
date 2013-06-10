/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CallBehaviorActionAsInteractionEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CustomInteractionUseEditPartCN;
import org.eclipse.uml2.uml.CallBehaviorAction;


public class CallBehaviorUtil {

	public enum CallBehaviorActionType {
		use, snapshot
	}

	/** The key for the EAnnotation on a Lifeline that indicates whether the Lifeline is a compact or full lifeline */
	private static final String CALL_BEHAVIOR_ACTION_ANNOTATION = "org.eclipse.papyrus.uml.diagram.interactionoverview.callbehavioraction"; //$NON-NLS-1$

	private static final String CALL_BEHAVIOR_ACTION_TYPE = "type"; //$NON-NLS-1$

	public static final String DIAGRAM_UUID_AS_INTERACTION_SNAPSHOT = "diagramUUIDForSnapshot";

	public static final String LIFELINE_QUALIFIED_NAME = "lifelineQualifiedNames";

	public static final String IS_BEHAVIOR_NEW = "isBehaviorNew";

	private CallBehaviorUtil() {
		// utility class
	}

	/**
	 * Get the type of the given lifeline
	 * 
	 * @param callBehaviorAction
	 *        the lifeline whose type to get
	 * @return the type
	 */
	public static CallBehaviorActionType getCallBehaviorType(final CallBehaviorAction callBehaviorAction) {
		final EAnnotation eAnnotation = callBehaviorAction.getEAnnotation(CALL_BEHAVIOR_ACTION_ANNOTATION);
		if(eAnnotation != null) {
			final String type = eAnnotation.getDetails().get(CALL_BEHAVIOR_ACTION_TYPE);
			if(type != null) {
				return CallBehaviorActionType.valueOf(type);
			}
		}
		// a non-annotated Lifeline is full by default
		return CallBehaviorActionType.snapshot;
	}

	public static void setLifelineType(final CallBehaviorAction callBehaviorAction, final CallBehaviorActionType callBehaviorActionType) {
		EAnnotation eAnnotation = callBehaviorAction.getEAnnotation(CALL_BEHAVIOR_ACTION_ANNOTATION);
		if(eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(CALL_BEHAVIOR_ACTION_ANNOTATION);
			callBehaviorAction.getEAnnotations().add(eAnnotation);
		}
		eAnnotation.getDetails().put(CALL_BEHAVIOR_ACTION_TYPE, callBehaviorActionType.name());
	}

	public static boolean isCallBehaviorActionEditPart(final int visualID) {
		return visualID == CallBehaviorActionEditPart.VISUAL_ID || visualID == CallBehaviorActionAsInteractionEditPart.VISUAL_ID;
	}

	public static boolean isCallBehaviorActionEditPart(final EditPart editPart) {
		return editPart instanceof CustomInteractionUseEditPartCN || editPart instanceof CallBehaviorActionAsInteractionEditPart;
	}

	public static boolean isCallBehaviorActionView(final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		if(visualID == -1) {
			visualID = UMLVisualIDRegistry.getVisualID(view);
		}
		return isCallBehaviorActionEditPart(visualID);
	}



	public static String getDiagramLinked(final View callBehaviorActionView) {

		final EAnnotation annotation = callBehaviorActionView.getEAnnotation(CALL_BEHAVIOR_ACTION_ANNOTATION);
		if(annotation != null) {
			return annotation.getDetails().get(DIAGRAM_UUID_AS_INTERACTION_SNAPSHOT);
		}
		return "";
	}

	public static void setDiagramLinked(final View callBehaviorActionView, final View diagramView) {

		EAnnotation annotation = callBehaviorActionView.getEAnnotation(CALL_BEHAVIOR_ACTION_ANNOTATION);
		if(annotation == null) {
			annotation = EcoreFactory.eINSTANCE.createEAnnotation();
			annotation.setSource(CALL_BEHAVIOR_ACTION_ANNOTATION);
			callBehaviorActionView.getEAnnotations().add(annotation);
		}
		if(annotation.getDetails().get(DIAGRAM_UUID_AS_INTERACTION_SNAPSHOT) != null) {
			annotation.getDetails().clear();
		}

		String uuidDiagram = DiagramUtils.getUUIDForSnapshot(diagramView);
		if(uuidDiagram == null || uuidDiagram.equals("")) {
			uuidDiagram = EcoreUtil.generateUUID();
			DiagramUtils.setUUID(diagramView, uuidDiagram);
		}
		annotation.getDetails().put(DIAGRAM_UUID_AS_INTERACTION_SNAPSHOT, uuidDiagram);
	}

	public static List<String> getRemovedLifelinesQualifiedNames(final View callBehaviorActionView) {
		final EAnnotation eAnnotation = callBehaviorActionView.getEAnnotation(LIFELINE_QUALIFIED_NAME);
		if(eAnnotation != null) {
			return new ArrayList<String>(eAnnotation.getDetails().keySet());
		}
		return new ArrayList<String>();
	}

	public static void addLifelineQualifiedNames(final View callBehaviorActionView, final String qualifiedName) {
		EAnnotation eAnnotation = callBehaviorActionView.getEAnnotation(LIFELINE_QUALIFIED_NAME);
		if(eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(LIFELINE_QUALIFIED_NAME);
			callBehaviorActionView.getEAnnotations().add(eAnnotation);
		}
		eAnnotation.getDetails().put(qualifiedName, "");
	}

	public static boolean isBehaviorNew(final View callBehaviorActionView) {
		return callBehaviorActionView.getEAnnotation(IS_BEHAVIOR_NEW) == null;
	}

	public static void setBehaviorAsNonNew(final View callBehaviorActionView) {
		EAnnotation eAnnotation = callBehaviorActionView.getEAnnotation(IS_BEHAVIOR_NEW);
		if(eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(IS_BEHAVIOR_NEW);
			callBehaviorActionView.getEAnnotations().add(eAnnotation);
		}
	}

}
