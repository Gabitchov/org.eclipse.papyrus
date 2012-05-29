/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.helper;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * Helper to convert from the implementation-based Diagram Type (e.g. PapyrusUMLClassDiagram) to a more
 * user-readable (and consistent) Diagram name, used in CSS Stylesheets (e.g. ClassDiagram)
 * 
 * @author Camille Letavernier
 */
//TODO : Replace with an extension point, so that it is possible to use this kind of Label
//anywhere in Papyrus (Preferences, CSS Stylesheets, property view, ...)
//See org.eclipse.papyrus.infra.gmfdiag.css.GMFElementAdapter
public class DiagramTypeHelper {

	public static String getDiagramType(Diagram diagram) {
		String type = diagram.getType();
		return diagramNameMappings.containsKey(type) ? diagramNameMappings.get(type) : type;
	}

	private static Map<String, String> diagramNameMappings = new HashMap<String, String>();

	static {
		//UML
		diagramNameMappings.put("CompositeStructure", "CompositeDiagram");
		diagramNameMappings.put("Package", "PackageDiagram");
		diagramNameMappings.put("PapyrusUMLActivityDiagram", "ActivityDiagram");
		diagramNameMappings.put("PapyrusUMLClassDiagram", "ClassDiagram");
		diagramNameMappings.put("PapyrusUMLCommunicationDiagram", "CommunicationDiagram");
		diagramNameMappings.put("PapyrusUMLComponentDiagram", "ComponentDiagram");
		diagramNameMappings.put("PapyrusUMLDeploymentDiagram", "DeploymentDiagram");
		diagramNameMappings.put("PapyrusUMLProfileDiagram", "ProfileDiagram");
		diagramNameMappings.put("PapyrusUMLSequenceDiagram", "SequenceDiagram");
		diagramNameMappings.put("PapyrusUMLStateMachineDiagram", "StateMachineDiagram");
		diagramNameMappings.put("UseCase", "UseCaseDiagram");

		//SysML
		diagramNameMappings.put("BlockDefinition", "BlockDiagram");
		diagramNameMappings.put("InternalBlock", "InternalBlockDiagram");
		diagramNameMappings.put("PapyrusSysMLRequirement", "RequirementDiagram");
		diagramNameMappings.put("Parametric", "ParametricDiagram");
	}
}
