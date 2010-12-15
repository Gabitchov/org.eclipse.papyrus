/**
 * @author: Manel Fredj - CEA
 * This class  in meant to centralize all the values of global variables that are used in the QVTO transformation
 * At the current stage of implementation it is duplicated in ElementType.qvto
 * As a future evolution, this class should be generated automatically from di plugin
 */

package org.eclipse.papyrus.conversion.di2todi.blackboxes;


public class ElementType {
	//diagram types in notation (Papyrus MDT-- P2)
	public static String ClassDiagram_P2 = "PapyrusUMLClassDiagram";
	public static String CompositeStructure_P2 = "CompositeStructure";
	public static String ActivityDiagram_P2 = "PapyrusUMLActivityDiagram";
	public static String SequenceDiagram_P2 = "";   //todo: check for papyrus 2 the actual name
	public static String ComponentDiagram_P2 = "";  //todo: check for papyrus 1 the actual name
	
	//diagram types in di2(Papyrus 1-- P1) 
	public static String ClassDiagram_P1 = "ClassDiagram";
	public static String CompositeStructure_P1 = "CompositeStructure";
	public static String ActivityDiagram_P1 = "ActivityDiagram"; 
	public static String SequenceDiagram_P1 = "SequenceDiagram"; 
	public static String ComponentDiagram_P1 = "ComponentDiagram";
	
}
