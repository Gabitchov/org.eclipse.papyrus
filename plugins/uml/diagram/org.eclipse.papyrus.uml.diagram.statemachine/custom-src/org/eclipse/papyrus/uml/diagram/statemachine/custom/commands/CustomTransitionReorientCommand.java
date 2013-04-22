package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.TransitionReorientCommand;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * Customized transition-reorient command, takes changing of container into account.
 * 
 * @author ansgar
 *
 */
public class CustomTransitionReorientCommand extends TransitionReorientCommand {

	/**
	 * @generated
	 */
	protected final EObject newEnd;

	public CustomTransitionReorientCommand(ReorientRelationshipRequest request) {
		super(request);
		newEnd = request.getNewRelationshipEnd();
	}

	@Override
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSource(getNewSource());
		changeContainer(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	@Override
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		changeContainer(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}
	
	@Override
	protected boolean canReorientSource() {
		Vertex target = getLink().getTarget();
		if (!CustomTransitionReorientCommand.isValid(newEnd, target)) {
			return false;
		}
		return super.canReorientSource();
	}

	@Override
	protected boolean canReorientTarget() {
		Vertex source = getLink().getSource();
		if (!CustomTransitionReorientCommand.isValid(source, newEnd)) {
			return false;
		}
		return super.canReorientTarget();
	}

	
	/**
	 * change the container of a transition, if necessary
	 */
	public static boolean changeContainer(Transition transition) {
		// now change container
		Region region = deduceContainer(transition.getSource(), transition.getTarget());
		if (region == null) {
			return false;	// transition is not valid
		}
		if (region != transition.getOwner()) {
			region.getTransitions().add(transition);	// will remove transition automatically from original region
		}
		return true;
	}

	/**
	 * Check whether a transition from source to target is valid
	 */
	public static boolean isValid(EObject sourceE, EObject targetE) {
		if (targetE == null) {
			return true;		// don't judge before knowing the target
		}
		NamedElement source = getNearestStateOrSM(sourceE);
		NamedElement target = getNearestStateOrSM(targetE);
		Region sourceRegion = getNearestRegion(source);
		Region targetRegion = getNearestRegion(target);
		
		if (isChild(source, targetRegion)) {
			// transition starts from a composite state (or state-machine) to a vertex within this state
			// assure that source is not an exit point
			if (isExitPoint(sourceE)) {
				return false;	// source is an exit point, but target is within the inner part of a class (inverse condition)
			}
			if (isExitPoint(targetE)) {
				return false;	// standard condition
			}
			return true;
		}
		else if (isChild(target, sourceRegion)) {
			// transition from a vertex within the target points to target composite state (or state-machine)
			// assure that target is not an entry point
			if (isEntryPoint(sourceE)) {
				return false;	// standard condition
			}
			if (isEntryPoint(targetE)) {
				return false;	// source is an entry point, but target is outside the composite state
					
			}
			return true;
		}
		else if (source == target) {
			// source and target are on same state or state machine. Could be either an external or internal transition
			// Allow transitions from entry to exit (internal) as well as from exit to entry (external)
			// => only disallow from entry to entry and from exit to exit
			if (
				(isEntryPoint(sourceE) && isEntryPoint(targetE)) || 
				(isExitPoint(sourceE) && isExitPoint(targetE))) {
				return false;
			}
			return true;
		}
		
		// standard conditions for external connections: start may not be a entry point, target not an exit point
		if (isEntryPoint(sourceE)) {
			return false;
		}
		if (isExitPoint(targetE)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Calculate the container. Also checks whether a transition is possible
	 * 
	 * @param sourceE
	 * @param targetE
	 * @return
	 */
	public static Region deduceContainer(EObject sourceE, EObject targetE) {
		// Find container element for the new link.
		NamedElement source = getNearestStateOrSM(sourceE);
		if (targetE == null) {
			// don't constraint until both source and target are given.
			if (getNearestRegion(source) != null) {
				return getNearestRegion(source);
			}
			else {
				return firstRegion(source);
			}
		}
		NamedElement target = getNearestStateOrSM(targetE);
		Region sourceRegion = getNearestRegion(source);
		Region targetRegion = getNearestRegion(target);

		if (isChild(source, targetRegion)) {
			// transition starts from a composite state (or state-machine) to a vertex within this state
			return childRegion(sourceRegion, source, targetRegion, target);
		}
		else if (isChild(target, sourceRegion)) {
			// transition from a vertex within the target points to target composite state (or state-machine)
			return childRegion(targetRegion, target, sourceRegion, source);
		}
		else if (source == target) {
			// source and target are on same state or state machine. Could be either an external or internal transition
			// Allow transitions from entry to exit (internal) as well as from exit to entry (external)
			// => only disallow from entry to entry and from exit to exit
			if (isEntryPoint(sourceE) || isExitPoint(targetE)) {
				// is a local or internal transition, return first owned region
				return firstRegion(source);
			}
			return sourceRegion;
		}
		
		if (isChild(sourceRegion, targetRegion)) {
			// region of target state is a child of region of source state, choose the letter as "more global" region
			// also include standard case, a transition between two states within same region
			return sourceRegion;
		}
		else {
			return targetRegion;
		}
	}
	
	public static Region childRegion(Region sourceRegion, NamedElement source, Region targetRegion, NamedElement target) {
		// source state is parent of targetRegion => transition from composite state
		// (or entry point of this state) to a target within composite
		// need to choose a region of the state depending on target
		EList<Region> regions = null;
		if (source instanceof State) {
			regions = ((State) source).getRegions();
		}
		else if (source instanceof StateMachine) {
			regions = ((StateMachine) source).getRegions();
		}
		if (regions != null) {
			// should always be true, since we called getNearsetStateOrSM before
			for (Region region : regions) {
				if (isChild(region, targetRegion)) {
					return region;
				}
			}
		}
		return null;
	}
	
	/**
	 * Return the first region of a state or statemachine.
	 * @param source
	 * @return
	 */
	public static Region firstRegion(EObject source) {
		EList<Region> regions = null;
		if (source instanceof State) {
			regions = ((State) source).getRegions();
		}
		else if (source instanceof StateMachine) {
			regions = ((StateMachine) source).getRegions();
		}
		if ((regions != null) && (regions.size() > 0)) {
			return regions.get(0);
		}
		else {
			return null;
		}	
	}
	
	public static boolean isChild(EObject parent, EObject child) {
		for(EObject element = child; element != null; element = element.eContainer()) {
			if(element == parent) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isEntryPoint(EObject vertex) {
		if (vertex instanceof Pseudostate) {
			Pseudostate ps = (Pseudostate) vertex;
			if (ps.getKind() == PseudostateKind.ENTRY_POINT_LITERAL) {
				return true;
			}
		}
		return false;
	}

	public static boolean isExitPoint(EObject vertex) {
		if (vertex instanceof Pseudostate) {
			Pseudostate ps = (Pseudostate) vertex;
			if (ps.getKind() == PseudostateKind.EXIT_POINT_LITERAL) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * Climb up by containment hierarchy starting from a given element
	 * and return the first region (as in default policy)
	 */
	public static Region getNearestRegion(EObject startFrom) {
		for(EObject element = startFrom; element != null; element = element.eContainer()) {
			if(element instanceof Region) {
				return (Region) element;
			}
		}
		return null;
	}
	
	
	/**
	 * Returns the nearest state or statemachine, if the passed element is a pseudo-state.
	 * This simplifies the calculation of a suitable container;
	 * @param vertex
	 * @return Return type is named element, since state and region have no other common superclass
	 */
	public static NamedElement getNearestStateOrSM(EObject vertex) {
		if (vertex instanceof Pseudostate) {
			Pseudostate ps = (Pseudostate) vertex;
			if ((ps.getKind() == PseudostateKind.ENTRY_POINT_LITERAL) ||
				(ps.getKind() == PseudostateKind.EXIT_POINT_LITERAL)) {
				State state = ps.getState();
				if (state != null) {
					return state;
				}
				StateMachine sm = ps.getStateMachine();
				if (sm != null) {
					return sm;
				}
			}
		}
		if (vertex instanceof Vertex) {
			return (Vertex) vertex;
		}
		return null;
	}
 }
