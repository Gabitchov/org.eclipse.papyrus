package org.eclipse.papyrus.uml.diagram.sequence.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.DestructionOccurrenceUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * This class is a validator which ensures that :<br/>
 * <li>
 * <ul>
 * In the order Interaction's fragment property, the order is kept as a valid trace,
 * </ul>
 * <ul>
 * Or at least, when there is no valid trace, that the order is kept for each lifeline (not to loose sequence information on a lifeline, which is
 * contained only graphically otherwise).
 * </ul>
 * </li> <br/>
 * Note that this class contains an algorithm which computes a valid trace. With little adaptation, it could easily provide all valid traces, hence,
 * compare two lifelines to know whether they are equivalent.
 * 
 * @author vhemery
 */
public class FragmentOrderingKeeper {

	/** A constant equals to half the smallest location delta */
	private static final float HALF_UNIT = (float)0.5;

	/** Format for displaying an element's name */
	private static final String NAME_FORMAT = "<{0}> {1}";

	/** map with, for a given index, the fragments which have been put with an optional order (may change) */
	private Map<Integer, List<InteractionFragment>> optionallyOrderedFragments;

	private EList<InteractionFragment> orderedFragments;

	private Set<Lifeline> constrainingNotRepresentedLifelines;

	private Set<LifelineEditPart> constrainingLifelineParts;

	private Set<Message> constrainingMessages;

	private Set<ExecutionSpecification> constrainingExecutions;

	private Set<GeneralOrdering> constrainingGeneralOrderings;

	/* private Set<CombinedFragment> constrainingCombinedFragments; */

	private List<List<InteractionFragment>> orderConstraints;

	private Set<InteractionFragment> conflictingFragments;

	/**
	 * Validate modification and update the interaction's fragments order if necessary.
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 * 
	 * @param target
	 *        the target to validate
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	public IStatus validate(EObject target, IValidationContext ctx) {
		if(target instanceof Interaction) {
			Interaction interaction = (Interaction)target;
			boolean valid = validateOrder(interaction);
			if(!valid) {
				IStatus status = ctx.createFailureStatus(getConflictingFragmentsFormattedString());
				removeModelReferences();
				return status;
			}
		} else if(target instanceof InteractionOperand) {
			InteractionOperand interactionOp = (InteractionOperand)target;
			boolean valid = validateOrder(interactionOp);
			if(!valid) {
				IStatus status = ctx.createFailureStatus(getConflictingFragmentsFormattedString());
				removeModelReferences();
				return status;
			}
		} else if(target instanceof InteractionFragment) {
			InteractionFragment fragment = (InteractionFragment)target;
			boolean valid = validateOrder(fragment.getEnclosingInteraction());
			if(!valid) {
				IStatus status = ctx.createFailureStatus(getConflictingFragmentsFormattedString());
				removeModelReferences();
				return status;
			}
		}
		removeModelReferences();
		return ctx.createSuccessStatus();
	}

	/**
	 * Get a formatted string with names of all conflicting fragments
	 * 
	 * @return formatted string
	 */
	private String getConflictingFragmentsFormattedString() {
		StringBuffer buff = new StringBuffer();
		for(InteractionFragment frag : conflictingFragments) {
			buff.append(System.getProperty("line.separator"));
			String name = NLS.bind(NAME_FORMAT, frag.eClass().getName(), frag.getQualifiedName());
			buff.append(name);
		}
		return buff.toString();
	}

	/**
	 * Remove any reference to model elements to avoid memory loss
	 */
	private void removeModelReferences() {
		// orderedFragments is an EList, hence, we must not empty it.
		orderedFragments = null;
		// other lists can be cleared.
		if(constrainingLifelineParts != null) {
			constrainingLifelineParts.clear();
		}
		if(constrainingMessages != null) {
			constrainingMessages.clear();
		}
		if(constrainingExecutions != null) {
			constrainingExecutions.clear();
		}
		if(constrainingGeneralOrderings != null) {
			constrainingGeneralOrderings.clear();
		}
		//constrainingCombinedFragments.clear();
		if(orderConstraints != null) {
			orderConstraints.clear();
		}
		if(conflictingFragments != null) {
			conflictingFragments.clear();
		}
		if(optionallyOrderedFragments != null) {
			optionallyOrderedFragments.clear();
		}
	}

	/**
	 * Validate the order of interaction operand's fragments
	 * 
	 * @param interactionOperand
	 *        the interaction operand
	 * @return true if a valid trace has been computed, false if none exists
	 */
	private boolean validateOrder(InteractionOperand interactionOperand) {
		orderedFragments = interactionOperand.getFragments();
		computeConstraints();
		return reorderFragmentsInAValidTrace();
	}

	/**
	 * Validate the order of interaction's fragments
	 * 
	 * @param interaction
	 *        the interaction
	 * @return true if a valid trace has been computed, false if none exists
	 */
	private boolean validateOrder(Interaction interaction) {
		orderedFragments = interaction.getFragments();
		computeConstraints();
		return reorderFragmentsInAValidTrace();
	}

	/**
	 * Compute constraints defined on fragments.<br/>
	 * These are given by (by priority order):<br/>
	 * <li>
	 * <ul>
	 * Lifelines (graphical location and previous order of elements not drawn)
	 * </ul>
	 * <ul>
	 * Combined Fragments (graphical order of InteractionOperands in case no Lifeline is covered)
	 * </ul>
	 * <ul>
	 * Messages (send > receive)
	 * </ul>
	 * ExecutionSpecifications (start > execution > finish)
	 * <ul>
	 * <ul>
	 * General Orderings (before > after)
	 * </ul>
	 * </li>
	 */
	private void computeConstraints() {
		IEditorPart editor = MDTUtil.getActiveEditor();
		DiagramEditPart diagram = null;
		if(editor instanceof IDiagramWorkbenchPart) {
			diagram = ((IDiagramWorkbenchPart)editor).getDiagramEditPart();
		}

		// reset constraints
		constrainingNotRepresentedLifelines = new HashSet<Lifeline>();
		constrainingLifelineParts = new HashSet<LifelineEditPart>();
		/* constrainingCombinedFragments = new HashSet<CombinedFragment>(); */
		constrainingMessages = new HashSet<Message>();
		constrainingExecutions = new HashSet<ExecutionSpecification>();
		constrainingGeneralOrderings = new HashSet<GeneralOrdering>();
		// get new constraining objects
		for(InteractionFragment fragment : orderedFragments) {
			// get Lifelines
			for(Lifeline lifeline : fragment.getCovereds()) {
				boolean lifelineRepresented = false;
				List<?> lifelineViews = DiagramEditPartsUtil.getEObjectViews(lifeline);
				for(Object lifelineView : lifelineViews) {
					if(lifelineView instanceof View && diagram != null) {
						int visualID = UMLVisualIDRegistry.getVisualID((View)lifelineView);
						if(visualID == LifelineEditPart.VISUAL_ID) {
							EditPart part = DiagramEditPartsUtil.getEditPartFromView((View)lifelineView, diagram);
							if(part instanceof LifelineEditPart) {
								constrainingLifelineParts.add((LifelineEditPart)part);
								lifelineRepresented = true;
							}
						}
					}
				}
				if(!lifelineRepresented) {
					// rely on old order for the lifeline
					constrainingNotRepresentedLifelines.add(lifeline);
				}
			}
			// get usefull Combined Fragments. Removed, since Combined Fragments own themselves their operands
			/*
			 * if(fragment.getCovereds().isEmpty()) {
			 * if(fragment instanceof CombinedFragment) {
			 * constrainingCombinedFragments.add((CombinedFragment)fragment);
			 * } else if(fragment instanceof InteractionOperand) {
			 * Element owningCF = fragment.getOwner();
			 * if(owningCF instanceof CombinedFragment) {
			 * constrainingCombinedFragments.add((CombinedFragment)owningCF);
			 * }
			 * }
			 * }
			 */
			// get Messages
			if(fragment instanceof MessageOccurrenceSpecification) {
				Message mess = ((MessageOccurrenceSpecification)fragment).getMessage();
				if(mess != null) {
					constrainingMessages.add(mess);
				}
			}
			// get ExecutionSpecifications
			if(fragment instanceof ExecutionSpecification) {
				constrainingExecutions.add((ExecutionSpecification)fragment);
			} else if(fragment instanceof ExecutionOccurrenceSpecification) {
				ExecutionSpecification exe = ((ExecutionOccurrenceSpecification)fragment).getExecution();
				if(exe != null) {
					constrainingExecutions.add(exe);
				}
			}
			// get General Orderings
			if(fragment instanceof OccurrenceSpecification) {
				EList<GeneralOrdering> orderings = ((OccurrenceSpecification)fragment).getToAfters();
				constrainingGeneralOrderings.addAll(orderings);
				orderings = ((OccurrenceSpecification)fragment).getToBefores();
				constrainingGeneralOrderings.addAll(orderings);
			}
		}

		// construct constrained partial orders
		constructPartialOrders();
	}

	/**
	 * Compute partial orders given by constraining elements (ordered by priority).<br/>
	 * <li>
	 * <ul>
	 * Lifelines (graphical location and previous order of elements not drawn)
	 * </ul>
	 * <ul>
	 * Combined Fragments (graphical order of InteractionOperands in case no Lifeline is covered)
	 * </ul>
	 * <ul>
	 * Messages (send > receive)
	 * </ul>
	 * ExecutionSpecifications (start > execution > finish)
	 * <ul>
	 * <ul>
	 * General Orderings (before > after)
	 * </ul>
	 * </li>
	 */
	private void constructPartialOrders() {
		optionallyOrderedFragments = new HashMap<Integer, List<InteractionFragment>>();
		int numberOfConstraints = constrainingNotRepresentedLifelines.size() + constrainingLifelineParts.size() + constrainingMessages.size() + constrainingExecutions.size() + constrainingGeneralOrderings.size();
		/*
		 * + constrainingCombinedFragments.size();
		 */
		orderConstraints = new ArrayList<List<InteractionFragment>>(numberOfConstraints);
		int indexConstraint = 0;
		// construct lifelines constraints (model only)
		for(Lifeline lifeline : constrainingNotRepresentedLifelines) {
			List<InteractionFragment> constraint = new ArrayList<InteractionFragment>();
			//fill constraint : previous order for elements of lifeline not drawn
			for(InteractionFragment fragment : orderedFragments) {
				if(lifeline.getCoveredBys().contains(fragment)) {
					constraint.add(fragment);
				}
			}
			DestructionOccurrenceUtil.reorderDestructionOccurrence(constraint);
			// store constraint
			orderConstraints.add(indexConstraint, constraint);
			indexConstraint++;
		}
		// construct lifelines constraints (graphical and model)
		for(LifelineEditPart part : constrainingLifelineParts) {
			TreeMap<Float, InteractionFragment> constraint = new TreeMap<Float, InteractionFragment>();
			//fill constraint : graphical location and previous order of elements not drawn
			fillConstraintWithLifelineEvents(constraint, part, indexConstraint);
			// store constraint
			ArrayList<InteractionFragment> list = new ArrayList<InteractionFragment>(constraint.values());
			DestructionOccurrenceUtil.reorderDestructionOccurrence(list);
			orderConstraints.add(indexConstraint, list);
			indexConstraint++;
		}
		// construct general orderings constraints. Removed, since Combined Fragments own themselves their operands
		/*
		 * for(CombinedFragment combFrag : constrainingCombinedFragments) {
		 * List<InteractionFragment> constraint = new ArrayList<InteractionFragment>();
		 * //fill constraint : graphical order of InteractionOperands
		 * // take model order of InteractionOperands, we ensure it is coherent with graphical order
		 * constraint.addAll(combFrag.getOperands());
		 * // store constraint
		 * orderConstraints.add(indexConstraint, constraint);
		 * indexConstraint++;
		 * }
		 */
		// construct messages constraints
		for(Message mess : constrainingMessages) {
			List<InteractionFragment> constraint = new ArrayList<InteractionFragment>(2);
			//fill constraint : send > receive
			MessageEnd frag = mess.getSendEvent();
			if(frag instanceof InteractionFragment && orderedFragments.contains(frag)) {
				constraint.add((InteractionFragment)frag);
			}
			frag = mess.getReceiveEvent();
			if(frag instanceof InteractionFragment && orderedFragments.contains(frag)) {
				constraint.add((InteractionFragment)frag);
			}
			
			DestructionOccurrenceUtil.constraintDestructionOccurrence(mess, constraint);
			// store constraint
			orderConstraints.add(indexConstraint, constraint);
			indexConstraint++;
		}
		// construct executions constraints
		for(ExecutionSpecification exe : constrainingExecutions) {
			List<InteractionFragment> constraint = new ArrayList<InteractionFragment>(3);
			//fill constraint : start > execution > finish
			InteractionFragment frag = exe.getStart();
			if(frag != null && orderedFragments.contains(frag)) {
				constraint.add(frag);
			}
			frag = exe;
			if(orderedFragments.contains(frag)) {
				constraint.add(frag);
			}
			frag = exe.getFinish();
			if(frag != null && orderedFragments.contains(frag)) {
				constraint.add(frag);
			}
			// store constraint
			orderConstraints.add(indexConstraint, constraint);
			indexConstraint++;
		}
		// construct general orderings constraints
		for(GeneralOrdering genOrd : constrainingGeneralOrderings) {
			List<InteractionFragment> constraint = new ArrayList<InteractionFragment>(2);
			//fill constraint : before > after
			InteractionFragment frag = genOrd.getBefore();
			if(frag != null && orderedFragments.contains(frag)) {
				constraint.add(frag);
			}
			frag = genOrd.getAfter();
			if(frag != null && orderedFragments.contains(frag)) {
				constraint.add(frag);
			}
			// store constraint
			orderConstraints.add(indexConstraint, constraint);
			indexConstraint++;
		}
	}

	/**
	 * Fill the constraint imposed by a lifeline
	 * 
	 * @param constraint
	 *        the tree map for hosting the constraint
	 * @param lifelinePart
	 *        the lifeline edit part
	 * @param indexConstraint
	 *        index of constraint
	 */
	private void fillConstraintWithLifelineEvents(TreeMap<Float, InteractionFragment> constraint, LifelineEditPart lifelinePart, int indexConstraint) {
		EObject lifeline = lifelinePart.resolveSemanticElement();
		if(lifeline instanceof Lifeline) {
			List<InteractionFragment> nonLocalizedEvents = new ArrayList<InteractionFragment>();
			// sort fragments according to their location on the lifeline
			for(InteractionFragment event : ((Lifeline)lifeline).getCoveredBys()) {
				if(orderedFragments.contains(event)) {
					Point loc = SequenceUtil.findLocationOfEvent(lifelinePart, event);
					if(loc != null) {
						float index = findNonConflictingYIndexOnLifeline(loc.y, constraint, event);
						constraint.put(index, event);
					} else {
						nonLocalizedEvents.add(event);
					}
				}
				// else, it is not in the list, must be in a child element.
			}
			optionallyOrderedFragments.put(indexConstraint, nonLocalizedEvents);
			// add not drawn events according to their old order in the valid trace
			InteractionFragment lastMetSortedFragment = null;
			for(InteractionFragment fragment : orderedFragments) {
				if(((Lifeline)lifeline).getCoveredBys().contains(fragment)) {
					// this is a fragment of the lifeline.
					if(constraint.containsValue(fragment)) {
						lastMetSortedFragment = fragment;
					} else if(nonLocalizedEvents.contains(fragment) && lastMetSortedFragment == null) {
						// insert it at the very beginning
						constraint.put((float)0, fragment);
						lastMetSortedFragment = fragment;
					} else if(nonLocalizedEvents.contains(fragment)) {
						// insert it just after lastMetSortedFragment
						Iterator<Entry<Float, InteractionFragment>> entryIt = constraint.entrySet().iterator();
						// find float key of lastMetSortedFragment
						while(entryIt.hasNext()) {
							Entry<Float, InteractionFragment> entry = entryIt.next();
							if(entry.getValue().equals(lastMetSortedFragment)) {
								if(entryIt.hasNext()) {
									// insert between the two fragments
									float key = (entry.getKey() + entryIt.next().getKey()) / 2;
									constraint.put(key, fragment);
									lastMetSortedFragment = fragment;
									break;
								} else {
									// insert at the end
									float key = entry.getKey() + 1;
									constraint.put(key, fragment);
									lastMetSortedFragment = fragment;
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Find a float index corresponding approximatively to the location of event on the lifeline.
	 * 
	 * @param y
	 *        real location of event on the lifeline
	 * @param eventsMap
	 *        map containing other events of the lifeline
	 * @param event
	 *        event to find a float index for
	 * @return unused float index for the map
	 */
	private float findNonConflictingYIndexOnLifeline(int y, TreeMap<Float, InteractionFragment> eventsMap, InteractionFragment event) {
		float index = Integer.valueOf(y).floatValue();
		float delta = HALF_UNIT;
		while(eventsMap.containsKey(index)) {
			InteractionFragment otherEvent = eventsMap.get(index);
			if(simulatenousEventsHappenInThisOrder(otherEvent, event)) {
				// other event must happen before the event
				index += delta;
			} else {
				// event must happen before the other event
				index -= delta;
			}
			delta = delta * HALF_UNIT;
		}
		return index;
	}

	/**
	 * Gives the order between two fragments which virtually happen at the same time
	 * 
	 * @param firstFragment
	 *        first InteractionFragment
	 * @param secondFragment
	 *        second InteractionFragment
	 * @return true if firstEvent should happen before secondEvent, false if the contrary.
	 */
	private boolean simulatenousEventsHappenInThisOrder(InteractionFragment firstFragment, InteractionFragment secondFragment) {
		// DestructionEvent comes last
		if(firstFragment instanceof DestructionOccurrenceSpecification) {
			return false;
		} else if(secondFragment instanceof DestructionOccurrenceSpecification) {
			return true;
		}
		// a receiving message event should trigger any other event
		if(firstFragment instanceof MessageOccurrenceSpecification && EcoreUtil.equals(((MessageOccurrenceSpecification)firstFragment).getMessage().getReceiveEvent(), firstFragment)) {
			return true;
		}
		if(secondFragment instanceof MessageOccurrenceSpecification && EcoreUtil.equals(((MessageOccurrenceSpecification)secondFragment).getMessage().getReceiveEvent(), secondFragment)) {
			return false;
		}
		// a starting execution event should happen before subsequent execution's events (except creation message receive)
		if(firstFragment instanceof ExecutionOccurrenceSpecification && EcoreUtil.equals(((ExecutionOccurrenceSpecification)firstFragment).getExecution().getStart(), firstFragment)) {
			return true;
		}
		if(secondFragment instanceof ExecutionOccurrenceSpecification && EcoreUtil.equals(((ExecutionOccurrenceSpecification)secondFragment).getExecution().getStart(), secondFragment)) {
			return false;
		}
		// an execution event should happen before subsequent execution's events (except starting)
		if(firstFragment instanceof ExecutionSpecification) {
			return true;
		}
		if(secondFragment instanceof ExecutionSpecification) {
			return false;
		}
		// a finishing execution event should happen after terminated execution's events
		if(firstFragment instanceof ExecutionOccurrenceSpecification && EcoreUtil.equals(((ExecutionOccurrenceSpecification)firstFragment).getExecution().getFinish(), firstFragment)) {
			return false;
		}
		if(secondFragment instanceof ExecutionOccurrenceSpecification && EcoreUtil.equals(((ExecutionOccurrenceSpecification)secondFragment).getExecution().getFinish(), secondFragment)) {
			return true;
		}
		// a sending message event should happen preferably after an unspecified event
		if(firstFragment instanceof MessageOccurrenceSpecification && EcoreUtil.equals(((MessageOccurrenceSpecification)firstFragment).getMessage().getSendEvent(), firstFragment)) {
			return false;
		}
		if(secondFragment instanceof MessageOccurrenceSpecification && EcoreUtil.equals(((MessageOccurrenceSpecification)secondFragment).getMessage().getSendEvent(), secondFragment)) {
			return true;
		}
		// otherwise, no importance
		return true;
	}

	/**
	 * Reorder the fragments according to constraints to make a valid trace.
	 * 
	 * NOTE : this algorithm could easily be adapted to compute all valid traces.
	 * 
	 * @return true if a valid trace has been computed, false if there is no valid trace
	 */
	private boolean reorderFragmentsInAValidTrace() {
		List<InteractionFragment> initialFragmentsList = new ArrayList<InteractionFragment>(orderedFragments);
		List<InteractionFragment> reorderedFragments = new ArrayList<InteractionFragment>(orderedFragments.size());
		/*
		 * This algorithm merges constraints to compute a valid trace.
		 * With little adaptation, it could compute all valid traces.
		 */
		// n : number of constraint lists
		int n = orderConstraints.size();
		// whether computed trace is valid (also whether a valid trace exists)
		boolean valid = true;
		// pointers to first elements to handle in each constraint list
		int[] pointers = new int[n];
		Arrays.fill(pointers, 0);
		while(getFragmentToInspect(-1, pointers) != null) {
			// inspect each constraint list to know whether fragment is mature enough, in such a case, store it with constraint index
			Map<Integer, InteractionFragment> matureFragments = new HashMap<Integer, InteractionFragment>(n);
			for(int i = 0; i < n; i++) {

				InteractionFragment fragmentToInspect = getFragmentToInspect(i, pointers);
				// if no more fragment in this constraint (fragmentToInspect == null), nothing to do
				if(fragmentToInspect != null) {
					/*
					 * Check whether fragment is mature enough :
					 * Fragment can happen only if other constraints do not impose it to happen after their current fragment.
					 */
					boolean wait = false;
					for(int j = 0; j < n; j++) {
						if(i != j) {
							// check that current fragment of constraint j must not occur before
							if(pointers[j] < orderConstraints.get(j).size()) {
								List<InteractionFragment> waitingList = orderConstraints.get(j).subList(pointers[j] + 1, orderConstraints.get(j).size());
								if(waitingList.contains(fragmentToInspect)) {
									wait = true;
									break;
								}
							}
						}
					}
					if(!wait) {
						//Fragment is ready to happen.
						matureFragments.put(i, fragmentToInspect);
					}
				}
			}
			if(matureFragments.isEmpty()) {
				//FIXME duplicated code : try again, without optional order
				// inspect each constraint list to know whether fragment is mature enough, in such a case, store it with constraint index
				matureFragments = new HashMap<Integer, InteractionFragment>(n);
				for(int i = 0; i < n; i++) {

					InteractionFragment fragmentToInspect = getFragmentToInspect(i, pointers);
					// if no more fragment in this constraint (fragmentToInspect == null), nothing to do
					if(fragmentToInspect != null) {
						/*
						 * Check whether fragment is mature enough :
						 * Fragment can happen only if other constraints do not impose it to happen after their current fragment.
						 */
						boolean wait = false;
						for(int j = 0; j < n; j++) {
							if(i != j) {
								// check that current fragment of constraint j must not occur before
								if(pointers[j] < orderConstraints.get(j).size()) {
									// only difference : ignore order for fragments in optionallyOrderedFragments
									int updatedPointer = pointers[j];
									if(optionallyOrderedFragments.containsKey(j)) {
										List<InteractionFragment> ignore = optionallyOrderedFragments.get(j);
										/*
										 * // hack for coregion
										 * while(ignore.contains(orderConstraints.get(j).get(updatedPointer)) ||
										 * (orderConstraints.get(j).get(updatedPointer) instanceof CombinedFragment &&
										 * InteractionOperatorKind.PAR_LITERAL
										 * .equals(((CombinedFragment)orderConstraints.get(j).get(updatedPointer)).getInteractionOperator()))) {
										 * updatedPointer++;
										 * }
										 */
										while(ignore.contains(orderConstraints.get(j).get(updatedPointer))) {
											updatedPointer++;
										}
									}
									List<InteractionFragment> waitingList = orderConstraints.get(j).subList(updatedPointer + 1, orderConstraints.get(j).size());

									if(waitingList.contains(fragmentToInspect)) {
										wait = true;
										break;
									}
								}
							}
						}
						if(!wait) {
							//Fragment is ready to happen.
							matureFragments.put(i, fragmentToInspect);
						}
					}
				}
				if(matureFragments.isEmpty()) {
					// no valid trace.
					if(valid) {
						// store first conflicting fragments for user explanation
						conflictingFragments = new HashSet<InteractionFragment>(n);
						for(int k = 0; k < n; k++) {
							InteractionFragment frag = getFragmentToInspect(k, pointers);
							if(frag != null) {
								conflictingFragments.add(frag);
							}
						}
					}
					valid = false;
					/*
					 * We must at least keep order of constraints with higher priority.
					 * Take the next event in the first available constraint.
					 */
					InteractionFragment addedFragment = getFragmentToInspect(-1, pointers);
					reorderedFragments.add(addedFragment);
					// increment pointers of constraints whose fragment has been added.
					for(int k = 0; k < n; k++) {
						InteractionFragment frag = getFragmentToInspect(k, pointers);
						while(reorderedFragments.contains(frag)) {
							// either frag == addedFragment and has just been added, or it has been added earlier after a conflict
							pointers[k]++;
							frag = getFragmentToInspect(k, pointers);
						}
					}
				} else {
					/*
					 * NOTE : to compute every traces, fork here by making fragmentsSet.size() branches, adding only one mature fragment for each
					 * branch and continuing the algorithm.
					 */
					// All matureFragments can happen in any order. Add them all (without doubles).
					Set<InteractionFragment> fragmentsSet = new HashSet<InteractionFragment>(matureFragments.values());
					reorderedFragments.addAll(fragmentsSet);
					// increment pointers of constraints whose fragment has been added.
					for(int incrementingPointerIndex : matureFragments.keySet()) {
						InteractionFragment frag = getFragmentToInspect(incrementingPointerIndex, pointers);
						while(reorderedFragments.contains(frag)) {
							// either frag == addedFragment and has just been added, or it has been added earlier after a conflict
							pointers[incrementingPointerIndex]++;
							frag = getFragmentToInspect(incrementingPointerIndex, pointers);
						}
					}
				}

				//				// no valid trace.
				//				if(valid) {
				//					// store first conflicting fragments for user explanation
				//					conflictingFragments = new HashSet<InteractionFragment>(n);
				//					for(int k = 0; k < n; k++) {
				//						InteractionFragment frag = getFragmentToInspect(k, pointers);
				//						if(frag != null) {
				//							conflictingFragments.add(frag);
				//						}
				//					}
				//				}
				//				valid = false;
				//				/*
				//				 * We must at least keep order of constraints with higher priority.
				//				 * Take the next event in the first available constraint.
				//				 */
				//				InteractionFragment addedFragment = getFragmentToInspect(-1, pointers);
				//				reorderedFragments.add(addedFragment);
				//				// increment pointers of constraints whose fragment has been added.
				//				for(int k = 0; k < n; k++) {
				//					InteractionFragment frag = getFragmentToInspect(k, pointers);
				//					while(reorderedFragments.contains(frag)) {
				//						// either frag == addedFragment and has just been added, or it has been added earlier after a conflict
				//						pointers[k]++;
				//						frag = getFragmentToInspect(k, pointers);
				//					}
				//				}
			} else {
				/*
				 * NOTE : to compute every traces, fork here by making fragmentsSet.size() branches, adding only one mature fragment for each
				 * branch and continuing the algorithm.
				 */
				// All matureFragments can happen in any order. Add them all (without doubles).
				Set<InteractionFragment> fragmentsSet = new HashSet<InteractionFragment>(matureFragments.values());
				reorderedFragments.addAll(fragmentsSet);
				// increment pointers of constraints whose fragment has been added.
				for(int incrementingPointerIndex : matureFragments.keySet()) {
					InteractionFragment frag = getFragmentToInspect(incrementingPointerIndex, pointers);
					while(reorderedFragments.contains(frag)) {
						// either frag == addedFragment and has just been added, or it has been added earlier after a conflict
						pointers[incrementingPointerIndex]++;
						frag = getFragmentToInspect(incrementingPointerIndex, pointers);
					}
				}
			}
		}
		// Add fragments which were not in any constraint
		/*
		 * NOTE : to compute every traces, these can be added wherever in the list.
		 */
		initialFragmentsList.removeAll(reorderedFragments);
		reorderedFragments.addAll(initialFragmentsList);
		
		DestructionOccurrenceUtil.reorderDestructionOccurrence(reorderedFragments);
		
		/*
		 * Now that we have a valid trace, apply it on orderedFragments.
		 * Only move operations must be performed on the EList, since others strongly affect the model.
		 */
		int size = reorderedFragments.size();
		for(int i = 0; i < size; i++) {
			orderedFragments.move(i, reorderedFragments.get(i));
		}
		return valid;
	}	

	/**
	 * Get the fragment to inspect for the trace computing algorithm.
	 * 
	 * @param i
	 *        index of constraint to take in account, or -1 for taking the first available one with the highest priority
	 * @param pointers
	 *        pointers indicating fragments to inspect in each constraint
	 * @return fragment which must be inspected or null if none left
	 */
	private InteractionFragment getFragmentToInspect(int i, int[] pointers) {
		if(orderConstraints.size() != pointers.length) {
			// should not happen, incorrect pointers argument
			return null;
		}
		if(i < 0 || i >= orderConstraints.size()) {
			i = -1;
			// compute best i with highest priority
			int j = 0;
			while(j < orderConstraints.size() && i == -1) {
				if(pointers[j] < orderConstraints.get(j).size()) {
					// elements left in constraint j. Best constraint index found.
					i = j;
				}
				j++;
			}
		}
		if(0 <= i && i < orderConstraints.size() && pointers[i] < orderConstraints.get(i).size()) {
			// return next fragment in constraint
			return orderConstraints.get(i).get(pointers[i]);
		} else {
			// no fragment left to inspect
			return null;
		}
	}
}
