package org.eclipse.papyrus.diagram.statemachine.custom.helpers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.DoActivityStateBehaviorStateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.EntryStateBehaviorEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ExitStateBehaviorEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.InternalTransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEntryPointEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateExitPointEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNameEditPart;

/**
 *  Behaviors > Internal Transitions > Deferred Transition
 * @author adaussy
 *
 */
public class StateViewComparator implements Comparator<View> {

	private static Map<String,Integer> registry = new HashMap<String, Integer>();
	
	/**
	 * StateName > StateCompartment > Entry > DoActivity > Exit > Internal > Deferred
	 */
	static {
		registry.put(String.valueOf(StateNameEditPart.VISUAL_ID), new Integer(-200));
		registry.put(String.valueOf(StateCompartmentEditPart.VISUAL_ID), new Integer(-150));
		registry.put(String.valueOf(PseudostateEntryPointEditPart.VISUAL_ID), new Integer(-140));
		registry.put(String.valueOf(PseudostateExitPointEditPart.VISUAL_ID), new Integer(-130));
		registry.put(String.valueOf(ConnectionPointReferenceEditPart.VISUAL_ID), new Integer(-120));
		registry.put(String.valueOf(EntryStateBehaviorEditPart.VISUAL_ID), new Integer(-80));
		registry.put(String.valueOf(DoActivityStateBehaviorStateEditPart.VISUAL_ID), new Integer(-70));
		registry.put(String.valueOf(ExitStateBehaviorEditPart.VISUAL_ID), new Integer(-60));
		registry.put(String.valueOf(InternalTransitionEditPart.VISUAL_ID), new Integer(-50));
	}

	public int compare(View o1, View o2) {
		return getCode(o1).compareTo(getCode(o2));
	}
	
	private Integer getCode (View v){
		String type = v.getType();
		if (type == null){
			return 0;
		}
		Integer priority = registry.get(type);
		if (priority != null){
			return priority;
		}
		return 0;
	}


	
}
