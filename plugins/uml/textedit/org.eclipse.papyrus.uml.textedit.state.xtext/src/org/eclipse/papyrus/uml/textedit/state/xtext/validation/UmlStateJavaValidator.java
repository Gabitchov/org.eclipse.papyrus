/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.state.xtext.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.BehaviorKind;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.DoRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.EntryRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.ExitRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.StateRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.xtext.gmf.glue.edit.part.PopupXtextEditorHelper;
import org.eclipse.xtext.validation.Check;
 

public class UmlStateJavaValidator extends AbstractUmlStateJavaValidator {

	private static Namespace model ;
	private static Element contextElement ;
	private static boolean valid_StateName = true ;
	private static boolean valid_SubMachineRule = true ;
	
	public static void init(Element _contextElement) {
		contextElement = _contextElement ;
		if (contextElement != null) {
			Element elem = contextElement.getOwner() ;
			while (elem.getOwner() != null) {
				elem = elem.getOwner() ;
			}
			model = (Namespace)elem ;
		}
	}

	public static Namespace getModel() {
		return model ;
	}
	
	public static Element getContextElement() {
		return contextElement ;
	}
	
	public static boolean validate() {
		return valid_StateName && valid_SubMachineRule ;
	}
	
	/**
	 * First checks if the new name being attributed to the edited state is already used by another state in the region.
	 * Then, notifies (via warning) any of the potential Behavior deletion implied by the textual specification 
	 * (either DoActivity, Enty, or Exit behaviors)
	 * 
	 * @param stateRule
	 */
	@Check
	public void checkStateName (StateRule stateRule) {
		if (PopupXtextEditorHelper.context == null)
			return ;
		
		if (stateRule.getName() == null || stateRule.getName().equals(""))
			return ;
		
		//
		// first, checks if the new name of the State is already used by another state in the region
		//
		org.eclipse.uml2.uml.State editedState = (org.eclipse.uml2.uml.State) PopupXtextEditorHelper.context ;
		List<String> alreadyUsedNames = new ArrayList<String>() ;
		
		for (Vertex v : editedState.getContainer().getSubvertices()) {
			if (v instanceof org.eclipse.uml2.uml.State) {
				org.eclipse.uml2.uml.State s = (org.eclipse.uml2.uml.State) v ;
				if (s != editedState) {
					alreadyUsedNames.add("" + s.getName()) ;
				}
			}
		}
		
		String newName = "" + stateRule.getName() ;
		
		if (alreadyUsedNames.contains("" + newName))
			warning("Name " + newName + " is already used by another State in this Region", UmlStatePackage.eINSTANCE.getStateRule_Name()) ;
		
		
		// Check if ConnectionPointReference exist when one delete the submachine reference: not allowed!
		if((stateRule.getSubmachine() == null) && !editedState.getConnections().isEmpty()){
			error(getErrorMessageForSubmachineState(), UmlStatePackage.eINSTANCE.getStateRule_Submachine()) ;
			valid_StateName = false ;
		}
		else {
			valid_StateName = true ;
		}
		//
		// Then, checks if the textual specification implies deletion of the DoActivity, Entry or Exit behavior
		// and raises warnings accordingly
		//
		
		boolean deletionOfDoActivity = editedState.getDoActivity()!=null && stateRule.getDo()==null ;
		boolean deletionOfExit = editedState.getExit()!=null && stateRule.getExit()==null ;
		boolean deletionOfEntry = editedState.getEntry()!=null && stateRule.getEntry()==null;
		
		if (deletionOfDoActivity) {
			warning(getBehaviorKindAsString(
						getBehaviorKind(editedState.getDoActivity())
					)
					+ " "
					+ editedState.getDoActivity().getName()
					+ " will be deleted", UmlStatePackage.eINSTANCE.getStateRule_Name()) ;
		}
		
		if (deletionOfExit) {
			warning(getBehaviorKindAsString(
						getBehaviorKind(editedState.getExit())
					)
					+ " "
					+ editedState.getExit().getName()
					+ " will be deleted", UmlStatePackage.eINSTANCE.getStateRule_Name()) ;
		}
		
		if (deletionOfEntry) {
			warning(getBehaviorKindAsString(
						getBehaviorKind(editedState.getEntry())
					)
					+ " "
					+ editedState.getEntry().getName()
					+ " will be deleted", UmlStatePackage.eINSTANCE.getStateRule_Name()) ;
		}
	}
	
	/**
	 * Notifies (via a Warning) the potential impact of changing the kind (i.e., Activity, StateMachine or OpaqueBehavior) 
	 * of the DoActivity behavior.
	 * 
	 * @param doRule
	 */
	@Check
	public void checkDoRule (DoRule doRule) {
		if (PopupXtextEditorHelper.context == null)
			return ;
		if (doRule.getKind() == null)
			return ;
		if (doRule.getBehaviorName() == null || doRule.getBehaviorName().equals(""))
			return ;
		
		org.eclipse.uml2.uml.State editedState = (org.eclipse.uml2.uml.State) PopupXtextEditorHelper.context ;
		BehaviorKind oldDoKind = getBehaviorKind(editedState.getDoActivity()) ;
		BehaviorKind newDoKind = doRule.getKind() ;
		if (oldDoKind != null) {
			if (oldDoKind != newDoKind) {
				warning("Changing the kind of " 
						+ doRule.getBehaviorName() 
						+ " from <<" 
						+ getBehaviorKindAsString(oldDoKind)
						+ ">> to <<"
						+ getBehaviorKindAsString(newDoKind)
						+ ">> will cause the deletion of "
						+ getBehaviorKindAsString(oldDoKind)
						+ " "
						+ doRule.getBehaviorName()
						+ ". Any changes made to "
						+ getBehaviorKindAsString(oldDoKind)
						+ " "
						+ doRule.getBehaviorName()
						+ " will be lost", UmlStatePackage.eINSTANCE.getDoRule_Kind()) ;
			}
		}
	}
	
	/**
	 * Notifies (via a Warning) the potential impact of changing the kind (i.e., Activity, StateMachine or OpaqueBehavior) 
	 * of the Entry behavior.
	 * 
	 * @param entryRule
	 */
	@Check
	public void checkEntryRule (EntryRule entryRule) {
		if (PopupXtextEditorHelper.context == null)
			return ;
		if (entryRule.getKind() == null)
			return ;
		if (entryRule.getBehaviorName() == null || entryRule.getBehaviorName().equals(""))
			return ;
		
		org.eclipse.uml2.uml.State editedState = (org.eclipse.uml2.uml.State) PopupXtextEditorHelper.context ;
		BehaviorKind oldDoKind = getBehaviorKind(editedState.getEntry()) ;
		BehaviorKind newDoKind = entryRule.getKind() ;
		if (oldDoKind != null) {
			if (oldDoKind != newDoKind) {
				warning("Changing the kind of " 
						+ entryRule.getBehaviorName() 
						+ " from <<" 
						+ getBehaviorKindAsString(oldDoKind)
						+ ">> to <<"
						+ getBehaviorKindAsString(newDoKind)
						+ ">> will cause the deletion of "
						+ getBehaviorKindAsString(oldDoKind)
						+ " "
						+ entryRule.getBehaviorName()
						+ ". Any changes made to "
						+ getBehaviorKindAsString(oldDoKind)
						+ " "
						+ entryRule.getBehaviorName()
						+ " will be lost", UmlStatePackage.eINSTANCE.getEntryRule_Kind()) ;
			}
		}
	}
	
	/**
	 * Notifies (via a Warning) the potential impact of changing the kind (i.e., Activity, StateMachine or OpaqueBehavior) 
	 * of the Entry behavior.
	 * 
	 * @param exitRule
	 */
	@Check
	public void checkExitRule (ExitRule exitRule) {
		if (PopupXtextEditorHelper.context == null)
			return ;
		if (exitRule.getKind() == null)
			return ;
		if (exitRule.getBehaviorName() == null || exitRule.getBehaviorName().equals(""))
			return ;
		
		org.eclipse.uml2.uml.State editedState = (org.eclipse.uml2.uml.State) PopupXtextEditorHelper.context ;
		BehaviorKind oldDoKind = getBehaviorKind(editedState.getExit()) ;
		BehaviorKind newDoKind = exitRule.getKind() ;
		if (oldDoKind != null) {
			if (oldDoKind != newDoKind) {
				warning("Changing the kind of " 
						+ exitRule.getBehaviorName() 
						+ " from <<" 
						+ getBehaviorKindAsString(oldDoKind)
						+ ">> to <<"
						+ getBehaviorKindAsString(newDoKind)
						+ ">> will cause the deletion of "
						+ getBehaviorKindAsString(oldDoKind)
						+ " "
						+ exitRule.getBehaviorName()
						+ ". Any changes made to "
						+ getBehaviorKindAsString(oldDoKind)
						+ " "
						+ exitRule.getBehaviorName()
						+ " will be lost", UmlStatePackage.eINSTANCE.getExitRule_Kind()) ;
			}
		}
	}
	
	@Check
	public void checkSubmachineRule(SubmachineRule rule) {
		if (contextElement == null || ! (contextElement instanceof org.eclipse.uml2.uml.State))
			return ;
		org.eclipse.uml2.uml.State contextState = (org.eclipse.uml2.uml.State)contextElement ;
		if (contextState.isOrthogonal()) {
			error(getErrorMessageForOrthogonalState(), UmlStatePackage.eINSTANCE.getSubmachineRule_Submachine()) ;
			valid_SubMachineRule = false ;
		}
		else {
			valid_SubMachineRule = true ;
		}
		if (contextState.isComposite()) {
			error(getErrorMessageForCompositeState(), UmlStatePackage.eINSTANCE.getSubmachineRule_Submachine()) ;
			valid_SubMachineRule = false ;
		}
		else {
			valid_SubMachineRule = true ;
		}
	}
	
	//*****************//
	// Utility methods //
	//*****************//
	
	private String getErrorMessageForOrthogonalState() {
		return "An orthogonal state cannot reference a submachine." ;
	}
	
	private String getErrorMessageForCompositeState() {
		return "A composite state cannot reference a submachine." ;
	}

	private String getErrorMessageForSubmachineState() {
		return "A simple state cannot have ConnectionPointReferences. You should delete them before removing the reference to the submachine." ;
	}

	private static BehaviorKind getBehaviorKind(Behavior behavior) {
		if (behavior == null)
			return null ;
		if (behavior instanceof Activity)
			return BehaviorKind.ACTIVITY ;
		if (behavior instanceof OpaqueBehavior)
			return BehaviorKind.OPAQUE_BEHAVIOR ;
		if (behavior instanceof StateMachine)
			return BehaviorKind.STATE_MACHINE ;
		return null ;
	}
	
	private static String getBehaviorKindAsString(BehaviorKind behaviorKind) {
		if (behaviorKind == BehaviorKind.ACTIVITY)
			return "Activity" ;
		if (behaviorKind == BehaviorKind.OPAQUE_BEHAVIOR)
			return "OpaqueBehavior" ;
		if (behaviorKind == BehaviorKind.STATE_MACHINE)
			return "StateMachine" ;
		return "" ;
	}
}
