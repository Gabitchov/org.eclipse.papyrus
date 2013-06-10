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

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.notation.View;


public class DiagramUtils {

	public static final String DIAGRAM_ANNOTATION = "diagramAnnotation";

	public static final String UUID = "uuid";

	public static void setUUID(final View diagramView, final String uuidDiagram) {
		EAnnotation annotation = diagramView.getEAnnotation(DIAGRAM_ANNOTATION);
		if(annotation == null) {
			annotation = EcoreFactory.eINSTANCE.createEAnnotation();
			annotation.setSource(DIAGRAM_ANNOTATION);
			diagramView.getEAnnotations().add(annotation);
		}
		if(annotation.getDetails().get(UUID) != null) {
			annotation.getDetails().clear();
		}
		annotation.getDetails().put(UUID, uuidDiagram);
	}

	public static String getUUIDForSnapshot(final View diagramView) {

		final EAnnotation annotation = diagramView.getEAnnotation(DIAGRAM_ANNOTATION);
		if(annotation != null) {
			return annotation.getDetails().get(UUID);
		}
		return "";
	}

}
