
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part;

import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramUpdater;


public class CustomUMLDiagramUpdater extends UMLDiagramUpdater {
	
	public static final CustomUMLDiagramUpdater INSTANCE = new CustomUMLDiagramUpdater();
	
	private CustomUMLDiagramUpdater(){
		//to prevent instantiation
		super();
	}
	
}
