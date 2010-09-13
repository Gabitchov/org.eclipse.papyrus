/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.core.modelsetquery.ModelSetQuery;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.common.actions.LabelHelper;
import org.eclipse.papyrus.diagram.common.util.MessageDirection;
import org.eclipse.papyrus.diagram.sequence.part.Messages;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.ElementInitializers;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ExecutionEvent;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A helper class for the command.
 * 
 */
public class CommandHelper {


	/**
	 * Title for dialog of no referenced interaction error
	 */
	private static final String NO_REFERENCED_INTERACTION_DIALOG_TITLE = "No referenced interaction"; //$NON-NLS-1$

	/**
	 * Message for dialog of no referenced interaction error
	 */
	private static final String NO_REFERENCED_INTERACTION_DIALOG_MSG = "Couldn't had message if there isn't referenced interaction"; //$NON-NLS-1$

	/**
	 * Message for wrong gate container type error
	 */
	private static final String WRONG_GATE_CONTAINER_TYPE_ERROR_MSG = "Wrong element UML type for create a gate"; //$NON-NLS-1$

	/**
	 * Title for dialog of choose actual gate
	 */
	private static final String CHOOSE_GATE_DIALOG_TITLE = "Actual gates of the interaction use"; //$NON-NLS-1$

	/**
	 * Message for dialog of choose actual gate
	 */
	private static final String CHOOSE_GATE_DIALOG_MSG = "Choose the gate to attach the message"; //$NON-NLS-1$



	/**
	 * Create a message on the given interaction. It only creates the message and not its messages end.
	 * 
	 * @param interaction
	 *        the containing interaction
	 * @param messageSort
	 *        the messageSort.
	 * @return the created message
	 */
	public static Message doCreateMessage(Interaction interaction, MessageSort messageSort, NamedElement signature) {
		Message message = interaction.createMessage(null);

		// Set the interaction that will contain the message
		message.setInteraction(interaction);

		// Set MessageSort
		message.setMessageSort(messageSort);

		// Init Name
		if (signature == null) {
			ElementInitializers.init_NamedElement(message);
		} else {
			message.setName(signature.getName());
		}

		return message;
	}

	/**
	 * Create message occurence specification
	 * 
	 * @param interaction
	 *        The interaction
	 * @param event
	 *        The event to attach
	 * @return The message occurence specification
	 */
	public static MessageOccurrenceSpecification doCreateMessageOccurrence(InteractionFragment fragment, Event event, Lifeline lifeline) {

		// Create the MOS
		MessageOccurrenceSpecification mos = UMLFactory.eINSTANCE.createMessageOccurrenceSpecification();

		// Configure the MOS
		doConfigureOccurenceSpecification(mos, event, fragment, lifeline);

		return mos;
	}


	/**
	 * Create an ExecutionOccurrenceSpecification
	 * 
	 * @param es
	 *        the ExecutionSpecification associated with this ExecutionOccurrenceSpecification.
	 * @param event
	 *        the event associated with this OccurrenceSpecification. It must be of type ExecutionEvent.
	 * @param fragment
	 *        the fragment enclosing this OccurenceSpecifcation. It must be an Interaction or an Operand.
	 * @return the Execution Occurrence Specification
	 */
	public static ExecutionOccurrenceSpecification doCreateExecutionOccurenceSpecification(ExecutionSpecification es, ExecutionEvent event, InteractionFragment fragment, Lifeline lifeline) {

		// Create the ExecutionOccurrenceSpecification
		ExecutionOccurrenceSpecification eos = UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification();

		// Configure the EOS. 
		// The event is an ExecutionEvent
		doConfigureOccurenceSpecification(eos, event, fragment, lifeline);

		// Set the executionSpecification of the ExecutionOccurrenceSpecification
		eos.setExecution(es);

		return eos;
	}

	/**
	 * Configure an OccurrenceSpecification
	 * 
	 * @param os
	 *        the occurrenceSpecification to configure
	 * @param event
	 *        the event to associated with the {@link OccurrenceSpecification}
	 * @param fragment
	 *        the fragment containing the {@link OccurrenceSpecification}. It can be an {@link Interaction} or an {@link InteractionOperand}
	 * @param lifeline
	 *        the covered lifeline
	 */
	private static void doConfigureOccurenceSpecification(OccurrenceSpecification os, Event event, InteractionFragment fragment, Lifeline lifeline) {

		// Set the Container of the OccurrenceSpecification
		if(fragment instanceof Interaction) {
			os.setEnclosingInteraction((Interaction)fragment);
		} else if(fragment instanceof InteractionOperand) {
			os.setEnclosingOperand((InteractionOperand)fragment);
		}

		// Set the covered lifeline
		os.getCovereds().add(lifeline);

		// Set the event of the OccurrenceSpecification
		os.setEvent(event);

	}

	/**
	 * Attach an Interaction on a Lifeline
	 * 
	 * @param lifeline
	 *        The lifeline
	 * @param fragment
	 *        The interaction fragment
	 */
	public static void setSingleCovered(Lifeline lifeline, InteractionFragment fragment) {
		if(!fragment.getCovereds().contains(lifeline)) {
			fragment.getCovereds().add(lifeline);
		}
	}



	/**
	 * Get the signature of the message. Opens a dialog box to select a signature.
	 * 
	 * @param model
	 *        The model
	 * @param source
	 *        The source of the message
	 * @param target
	 *        The target of the message
	 * @return null, if cancel has been pressed. An empty list if the null Element has been
	 *         selected, or a list with the selected element.
	 */
	public static List<NamedElement> getSignature(Element model, Element source, Element target) {
		return getSignature(model, source, target, null);
	}

	/**
	 * Get the signature of the message. Opens a dialog box to select a signature. Inputs depends on
	 * the messageSort, if any.
	 * 
	 * @param model
	 *        The model
	 * @param source
	 *        The source of the message
	 * @param target
	 *        The target of the message
	 * @param messageSort
	 *        true if message sort is set
	 * @return null, if cancel has been pressed. An empty list if the null Element has been
	 *         selected, or a list with the selected element.
	 */
	public static List<NamedElement> getSignature(Element model, Element source, Element target, MessageSort messageSort) {

		if(model == null) {
			return null;
		}

		// element where to look for parents
		Element parentsOwner = target;

		// default values
		// used for asynch message where messageSort = null
		boolean useOperations = true;
		boolean useSignals = true;

		// according to the type of the message
		// choose which types we should care of
		if(MessageSort.SYNCH_CALL_LITERAL.equals(messageSort)) {
			useSignals = false;
		} else if(MessageSort.CREATE_MESSAGE_LITERAL.equals(messageSort) || MessageSort.DELETE_MESSAGE_LITERAL.equals(messageSort)) {
			useOperations = false;
		} else if(MessageSort.REPLY_LITERAL.equals(messageSort)) {
			parentsOwner = source;
			useSignals = false;
		}

		LinkedHashMap<EClass, List<EObject>> mapTypesPossibleParents = new LinkedHashMap<EClass, List<EObject>>();

		if(useSignals) {
			mapTypesPossibleParents.put(UMLPackage.eINSTANCE.getSignal(), new LinkedList<EObject>());
		}
		if(useOperations) {
			mapTypesPossibleParents.put(UMLPackage.eINSTANCE.getOperation(), new LinkedList<EObject>());
		}

		// add the parents we can find
		boolean existingParent = false;

		if(parentsOwner instanceof InteractionFragment) {
			EList<Lifeline> lifelines = ((InteractionFragment)parentsOwner).getCovereds();
			for(Lifeline l : lifelines) {
				boolean result = addParentsFromLifeline(l, mapTypesPossibleParents);
				if (result) {
					existingParent = true;
				}
			}
		} else if(parentsOwner instanceof Lifeline) {
			existingParent = addParentsFromLifeline((Lifeline)parentsOwner, mapTypesPossibleParents);
		}


		// if no parent available => no signature
		if(!existingParent) {
			return new ArrayList<NamedElement>();
		}

		Set<EObject> existingElements = getExistingElementsFromParents(mapTypesPossibleParents);

		// Open the selection dialog
		SelectOrCreateDialog dialog = new SelectOrCreateDialog(Display.getCurrent().getActiveShell(), Messages.CommandHelper_CreateMessage, createTypeLabelProvider(), new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()), EditorUtils.getTransactionalEditingDomain(), existingElements, mapTypesPossibleParents);

		// Get the selected result
		if(dialog.open() == Window.OK) {
			// list to return
			List<NamedElement> returnElements = new ArrayList<NamedElement>();
			EObject element = dialog.getSelected();
			if(element instanceof NamedElement) {

				returnElements.add((NamedElement)element);
				return returnElements;
			}
			return returnElements;
		}

		return null;
	}

	/**
	 * find the existing elements from the possible parents
	 * 
	 * @param mapTypesPossibleParents
	 *        map of list containing the possible parents
	 * @return
	 */
	private static Set<EObject> getExistingElementsFromParents(Map<EClass, List<EObject>> mapTypesPossibleParents) {
		// find the existing elements using the parents we just found
		Set<EObject> existingElements = new HashSet<EObject>();
		for(EClass eClass : mapTypesPossibleParents.keySet()) {
			List<EObject> parents = mapTypesPossibleParents.get(eClass);
			for(EObject parent : parents) {
				if(parent instanceof Classifier) {
					existingElements.addAll(((Classifier)parent).getAllOperations());
				} else if(parent instanceof Package) {
					EList<Element> ownedElements = ((Package)parent).allOwnedElements();
					for(Element e : ownedElements) {
						if(e instanceof Signal) {
							existingElements.add(e);
						}
					}
				}
			}
		}
		return existingElements;
	}

	/**
	 * Create a specific label provider for types
	 * which remove everything after the first space
	 * 
	 * @return the label provider
	 */
	private static AdapterFactoryLabelProvider createTypeLabelProvider() {
		AdapterFactoryLabelProvider typeLabelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()) {

			@Override
			public String getText(Object object) {
				// remove the supertypes from the label
				// => keep only the first word
				String text = super.getText(object);
				int index = text.indexOf(" "); //$NON-NLS-1$
				if(index != -1) {
					text = text.substring(0, index);
				}
				return text;
			}
		};
		return typeLabelProvider;
	}

	/**
	 * add to the map the possible parents (classes, packages)
	 * founded "in" the lifeline
	 * 
	 * @param l
	 *        The lifeline where to look for possible parents
	 * @param mapTypesPossibleParents
	 *        The map where to store this parents
	 * @return true if at least one parent was added
	 */
	private static boolean addParentsFromLifeline(Lifeline l, Map<EClass, List<EObject>> mapTypesPossibleParents) {
		ConnectableElement e = l.getRepresents();

		boolean existingParent = false;

		// If there is no connectable element (ie : lifeline doesn't have a represents property yet)
		if(e == null) {
			return false;
		}

		Type type = e.getType();
		if(type == null) {
			return false;
		}

		// the classes are related to operation
		List<EObject> possibleClassifier = mapTypesPossibleParents.get(UMLPackage.eINSTANCE.getOperation());
		if(possibleClassifier != null) {
			if(type instanceof Classifier) {
				Classifier classifier = (Classifier)type;
				possibleClassifier.add(classifier);

				// add the supertypes of the class
				possibleClassifier.addAll(classifier.allParents());
				existingParent = true;
			}
		}

		// and the packages to signal
		List<EObject> possiblePackages = mapTypesPossibleParents.get(UMLPackage.eINSTANCE.getSignal());
		if(possiblePackages != null) {
		    possiblePackages.addAll(ModelSetQuery.getObjectsOfType(type, UMLPackage.eINSTANCE.getPackage()));
			existingParent = true;
		}

		return existingParent;
	}

	/**
	 * Get the signature of the message. Opens a dialog box to select a signature. Inputs depends on
	 * the messageSort, if any.
	 * 
	 * @param availableProperties
	 *        list of available properties
	 * @return null, if cancel has been pressed. An empty list if the null Element has been
	 *         selected, or a list with the selected element.
	 */
	public static Property getProperties(List<Property> availableProperties) {

		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(Display.getCurrent().getActiveShell(), labelProvider);
		dialog.setTitle("Property Selection"); //$NON-NLS-1$
		dialog.setMessage("Select a property (* = any string, ? = any char):"); //$NON-NLS-1$

		if(availableProperties == null || availableProperties.isEmpty()) {
			return null;
		}

		dialog.setElements(availableProperties.toArray());

		Property element = null;
		int dialogResult = dialog.open();
		if(dialogResult == Window.OK) {
			if(!"".equals(dialog.getFirstResult())) { //$NON-NLS-1$
				element = (Property)dialog.getFirstResult();
			}
		}
		return element;
	}

	/**
	 * Execute a EMF command without history (cancelation usage)
	 * 
	 * @param editingDomain
	 *        The editing domain
	 * @param command
	 *        The command
	 */
	public static void executeCommandWithoutHistory(EditingDomain editingDomain, org.eclipse.emf.common.command.Command command) {
		try {
			CommandStack commandStack = editingDomain.getCommandStack();
			if(commandStack instanceof TransactionalCommandStack) {
				((TransactionalCommandStack)commandStack).execute(command, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
			} else {
				commandStack.execute(command);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieve the Lifeline associated with an ExecutionSpecification.
	 * According to the UML Specification, an ExecutionSpecification must have a start and a finish.
	 * 
	 * In Papyrus, an ExecutionSpecification may not have a start and finish.
	 * To handle this specific case, we return the first lifeline that the ES covered.
	 * 
	 * @param es
	 *        the targeted execution specification
	 * @return the associated lifeline, or null if the ES has no start, no finish, no covered lifelines.
	 */
	public static Lifeline getExecutionSpecificationLifeline(ExecutionSpecification es) {
		Lifeline lifeline = null;
		if(es.getStart() != null) {
			lifeline = es.getStart().getCovereds().get(0);
		} else if(es.getFinish() != null) {
			lifeline = es.getFinish().getCovereds().get(0);
		}

		if(lifeline == null) {
			if(!es.getCovereds().isEmpty()) {
				lifeline = es.getCovereds().get(0);
			}
		}
		return lifeline;
	}

	/**
	 * Create an DestructionEvent and an occurrenceSpecification bounds to the lifeline
	 * 
	 * @param destructionEvent
	 *        the destructionEvent
	 * @param lifeline
	 *        the lifeline associated with the destructionEvent
	 * @param modelContainer
	 *        the container of the occurrenceSpecification that will bound the lifeline and the destructionEvent.
	 * @return
	 */
	public static DestructionEvent doCreateDestructionEvent(Lifeline lifeline, Object modelContainer) {

		// Get the nearest package
		Package pack = lifeline.getNearestPackage();

		EClass destructionEventEClass = UMLPackage.eINSTANCE.getDestructionEvent();
		// Add the destructionEvent to the Package
		DestructionEvent destructionEvent = (DestructionEvent)pack.createPackagedElement(LabelHelper.INSTANCE.findName(pack, destructionEventEClass), destructionEventEClass);

		// Create an occurrenceSpecification
		Element element = createElement(modelContainer, UMLPackage.eINSTANCE.getOccurrenceSpecification());
		OccurrenceSpecification os = null;
		if(element instanceof OccurrenceSpecification) {
			os = (OccurrenceSpecification)element;
			doConfigureOccurenceSpecification(os, destructionEvent, (InteractionFragment)modelContainer, lifeline);
		}

		return destructionEvent;
	}

	/**
	 * Create an StateInvariant
	 * 
	 * @param lifeline
	 *        the lifeline on which the stateInvariant is created (or which is covered by the StateInvariant).
	 * @param modelContainer
	 *        the model container
	 * @return the created stateInvariant or null
	 */
	public static StateInvariant doCreateStateInvariant(Lifeline lifeline, Object modelContainer) {
		StateInvariant stateInvariant = null;

		Element element = createElement(modelContainer, UMLPackage.eINSTANCE.getStateInvariant());

		if(element instanceof StateInvariant) {
			stateInvariant = (StateInvariant)element;
			// Get the covered lifeline
			stateInvariant.getCovereds().add(lifeline);

			// Create the associated invariant
			stateInvariant.createInvariant(LabelHelper.INSTANCE.findName(stateInvariant, UMLPackage.eINSTANCE.getConstraint()));
		}

		return stateInvariant;
	}

	private static Element createElement(Object modelContainer, EClass eClass) {

		// Get the enclosing interaction fragment
		if(modelContainer instanceof InteractionOperand) {
			InteractionOperand interactionOperand = (InteractionOperand)modelContainer;
			// Create the ES 
			return interactionOperand.createFragment(LabelHelper.INSTANCE.findName(interactionOperand, eClass), eClass);
		} else if(modelContainer instanceof Interaction) {
			Interaction interaction = (Interaction)modelContainer;
			// Create the ES 
			return interaction.createFragment(LabelHelper.INSTANCE.findName(interaction, eClass), eClass);
		}
		return null;
	}


	/**
	 * Create a CombinedFragment and its associated interaction Operand
	 * 
	 * @param modelContainer
	 *        the container of the CF. It could be an InteractionOperand or an Interaction.
	 * @param operatorKind
	 *        the operatorKind of the combinedFragment
	 * @return the created CombinedFragment or null
	 */
	public static CombinedFragment doCreateCombinedFragment(Object modelContainer, InteractionOperatorKind operatorKind) {
		CombinedFragment combinedFragment = null;

		Element element = createElement(modelContainer, UMLPackage.eINSTANCE.getCombinedFragment());
		if(element instanceof CombinedFragment) {
			combinedFragment = (CombinedFragment)element;

			// Set the operator kind
			combinedFragment.setInteractionOperator(operatorKind);

			// Create the operand
			combinedFragment.createOperand(LabelHelper.INSTANCE.findName(combinedFragment, UMLPackage.eINSTANCE.getInteractionOperand()));

		}
		return combinedFragment;
	}

	/**
	 * Create a CoRegion element :
	 * a CombinedFragment with InteractionOperator set to 'Parallel' and with at least two InteractionOperand
	 * 
	 * @param modelContainer
	 *        the parent element of the CoRegion
	 * @param coveredLifeline
	 *        the lifeline on which the CoRegion is created
	 * @return the created CoRegion or null
	 */
	public static CombinedFragment doCreateCoRegion(Object modelContainer, Lifeline coveredLifeline) {

		// Create a Parallel CombinedFragment
		CombinedFragment combinedFragment = doCreateCombinedFragment(modelContainer, InteractionOperatorKind.PAR_LITERAL);

		if(combinedFragment != null) {
			// Create a second operand
			combinedFragment.createOperand(LabelHelper.INSTANCE.findName(combinedFragment, UMLPackage.eINSTANCE.getInteractionOperand()));

			// Add the lifeline where the CoRegion is drawn as a covered lifeline.
			combinedFragment.getCovereds().add(coveredLifeline);

			// Each operand must covered the same lifeline
			for(InteractionOperand operand : combinedFragment.getOperands()) {
				operand.getCovereds().add(coveredLifeline);
			}
		}
		return combinedFragment;
	}


	/**
	 * Create an ExecutionSpecification. It also creates the start and finish ExecutionOccurenceSpecification of the ExecutionSpecification, and their
	 * corresponding events.
	 * 
	 * @param es
	 *        the executionSpecification to create.
	 * @param lifeline
	 *        the lifeline covered by the ExecutionSpecification.
	 * @return the created executionSpecification
	 */
	public static ExecutionSpecification doCreateExecutionSpecification(ExecutionSpecification es, Lifeline lifeline, Object modelContainer) {

		InteractionFragment interactionFragment = null;
		// Get the enclosing interaction fragment
		if(modelContainer instanceof InteractionOperand) {
			InteractionOperand interactionOperand = (InteractionOperand)modelContainer;
			// Create the ES 
			es = (ExecutionSpecification)interactionOperand.createFragment(null, es.eClass());

			interactionFragment = interactionOperand;
		} else {
			Interaction interaction = lifeline.getInteraction();
			// Create the ES 
			es = (ExecutionSpecification)interaction.createFragment(null, es.eClass());

			interactionFragment = interaction;
		}

		// Get the covered lifeline
		es.getCovereds().add(lifeline);

		org.eclipse.uml2.uml.Package eventContainer = interactionFragment.getNearestPackage();

		ExecutionEvent startingExecutionEvent = EventHelper.doCreateExecutionEvent(eventContainer);
		ExecutionEvent finishingExecutionEvent = EventHelper.doCreateExecutionEvent(eventContainer);

		// Get the start and the finish ExecutionOccurrenceSpecification
		es.setStart(CommandHelper.doCreateExecutionOccurenceSpecification(es, startingExecutionEvent, interactionFragment, lifeline));
		es.setFinish(CommandHelper.doCreateExecutionOccurenceSpecification(es, finishingExecutionEvent, interactionFragment, lifeline));

		// Init the name of the ES and its EOS
		initExecutionSpecificationName(es);

		return es;
	}


	private static void initExecutionSpecificationName(ExecutionSpecification es) {

		String body = ""; //$NON-NLS-1$
		if(es instanceof ActionExecutionSpecification) {
			body = "ActionExecSpec"; //$NON-NLS-1$
		} else {
			body = "BehaviorExecSpec"; //$NON-NLS-1$
		}
		// Init the name
		ElementInitializers.init_NamedElement(es, "", body, ""); //$NON-NLS-1$ //$NON-NLS-2$

		// Init the name of the related executionOccurrenceSpecification
		ElementInitializers.init_NamedElement(es.getStart(), "", es.getName(), "Start"); //$NON-NLS-1$ //$NON-NLS-2$
		ElementInitializers.init_NamedElement(es.getFinish(), "", es.getName(), "Finish"); //$NON-NLS-1$ //$NON-NLS-2$
	}


	/**
	 * Create a MessageEnd
	 * 
	 * @param interaction
	 *        fragment
	 *        The Interaction fragment
	 * @param callEvent
	 *        The call event
	 * @param element
	 *        The element
	 * @param direction
	 *        The message direction
	 * @return A MessageOccurrenceSpecification if element is ExecutionSpecification or Lifeline. A
	 *         Gate if element is Interaction or CombinedFragment or InteractionUse
	 */
	public static MessageEnd createMessageEnd(InteractionFragment interactionFragment, Event event, Element element, MessageDirection direction) {
		MessageEnd endMsg = null;
		if(element instanceof Lifeline) {
			endMsg = doCreateMessageOccurrence(interactionFragment, event, (Lifeline)element);
		} else if(element instanceof ExecutionSpecification) {
			Lifeline lifeline = getExecutionSpecificationLifeline((ExecutionSpecification)element);
			endMsg = doCreateMessageOccurrence(interactionFragment, event, lifeline);
		} else if(element instanceof Interaction || element instanceof CombinedFragment || element instanceof InteractionUse) {
			endMsg = doCreateGate(element, direction);
		}
		return endMsg;
	}

	/**
	 * Create gate if element is a Interaction, a Combined Fragment or a Interaction Use
	 * 
	 * @param element
	 *        The element
	 * @param direction
	 *        The message direction
	 * @return The gate
	 * @throws IllegalArgumentException
	 *         if the element is not a right element type
	 */
	public static Gate doCreateGate(Element element, MessageDirection direction) {
		Gate gate = null;

		if(element instanceof Interaction) {
			gate = ((Interaction)element).createFormalGate(null);
		} else if(element instanceof CombinedFragment) {
			gate = ((CombinedFragment)element).createCfragmentGate(null);
		} else if(element instanceof InteractionUse) {
			Shell shell = Display.getCurrent().getActiveShell();
			InteractionUse interactionUse = (InteractionUse)element;

			if(interactionUse.getRefersTo() == null) {
				MessageDialog.openError(shell, NO_REFERENCED_INTERACTION_DIALOG_TITLE, NO_REFERENCED_INTERACTION_DIALOG_MSG);
				return null;
			}

			ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
			dialog.setTitle(CHOOSE_GATE_DIALOG_TITLE);
			dialog.setMessage(CHOOSE_GATE_DIALOG_MSG);
			dialog.setMultipleSelection(false);

			List<Gate> gates = new ArrayList<Gate>();
			for(Gate actualGate : ((InteractionUse)element).getActualGates()) {
				if(actualGate.getName().startsWith(direction.getName())) {
					gates.add(actualGate);
				}
			}
			dialog.setElements(gates.toArray());
			if(dialog.open() == Window.OK) {
				gate = (Gate)dialog.getFirstResult();
			}
		} else {
			throw new IllegalArgumentException(WRONG_GATE_CONTAINER_TYPE_ERROR_MSG);
		}

		if(gate != null) {
			ElementInitializers.init_NamedElement(gate, direction.toString().toLowerCase() + "_"); //$NON-NLS-1$
		}

		return gate;
	}

	/**
	 * Creates a message and manage the creation of a message from/to a CoRegion
	 * 
	 * @param interaction
	 *        the interaction containing the message.
	 * @param messageSort
	 *        the messageSort of the message, it can be null
	 * @param source
	 *        the source of the message, it can be null
	 * @param target
	 *        the target of the message, it can be null
	 * @param params
	 *        a map of params. It must at least contain the source and target container;
	 * @return the created message.
	 */
	public static Message doCreateMessage(Interaction interaction, MessageSort messageSort, Element source, Element target, Map<Object, Object> params) {
		InteractionFragment sourceContainer = (InteractionFragment)params.get(SequenceRequestConstant.SOURCE_MODEL_CONTAINER);
		InteractionFragment targetContainer = (InteractionFragment)params.get(SequenceRequestConstant.TARGET_MODEL_CONTAINER);

		Object lifeline = params.get(SequenceRequestConstant.LIFELINE_GRAPHICAL_CONTAINER);
		if(lifeline != null) {
			if(source instanceof CombinedFragment) {
				CombinedFragment cf = (CombinedFragment)source;
				if(InteractionOperatorKind.PAR_LITERAL.equals(cf.getInteractionOperator())) {
					InteractionOperand interactionOperand = getCoRegionInteractionOperand(cf);
					sourceContainer = interactionOperand;
					targetContainer = interactionOperand;
					source = (Lifeline)lifeline;
				}
			} else if(target instanceof CombinedFragment) {
				CombinedFragment cf = (CombinedFragment)target;
				if(InteractionOperatorKind.PAR_LITERAL.equals(cf.getInteractionOperator())) {
					InteractionOperand interactionOperand = getCoRegionInteractionOperand(cf);
					sourceContainer = interactionOperand;
					targetContainer = interactionOperand;
					target = (Lifeline)lifeline;
				}
			}
		}
		return doCreateMessage(interaction, messageSort, source, target, sourceContainer, targetContainer);
	}

	/**
	 * Get the interactionOperand where the occurrenceSpecification will be created
	 */
	private static InteractionOperand getCoRegionInteractionOperand(CombinedFragment cf) {
		InteractionOperand interactionOperand = null;

		// Search in the existing operands if there are any operand without fragments.
		for(InteractionOperand existingOperand : cf.getOperands()) {
			if(existingOperand.getFragments().size() == 0) {
				interactionOperand = existingOperand;
				break;
			}
		}

		// If the operand is still null, we create a new operand in the combinedFragment.
		if(interactionOperand == null) {
			interactionOperand = cf.createOperand(LabelHelper.INSTANCE.findName(cf, UMLPackage.eINSTANCE.getInteractionOperand()));
		}
		return interactionOperand;
	}

	/**
	 * Create a message. It also creates its message end, their corresponding events and updates the signature of the message.
	 * 
	 * @param container
	 *        the interaction containing the message.
	 * @param messageSort
	 *        the messageSort of the message, it can be null
	 * @param source
	 *        the source of the message, it can be null
	 * @param target
	 *        the target of the message, it can be null
	 * @return the created message
	 */
	public static Message doCreateMessage(Interaction container, MessageSort messageSort, Element source, Element target, InteractionFragment sourceContainer, InteractionFragment targetContainer) {
		return doCreateMessage(container, messageSort, source, target, sourceContainer, targetContainer, null, null);
	}

	/**
	 * Create a message. It also creates its message end (if not provided), their corresponding events and updates the signature of the message.
	 * 
	 * @param container
	 *        the interaction containing the message.
	 * @param messageSort
	 *        the messageSort of the message, it can be null
	 * @param source
	 *        the source of the message, it can be null
	 * @param target
	 *        the target of the message, it can be null
	 * @param sendMessageEnd
	 *        the existing Send MessageEnd of the message
	 * @param receiveMessageEnd
	 *        the existing Receive MessageEnd of the message
	 * @return the created message
	 */
	public static Message doCreateMessage(Interaction container, MessageSort messageSort, Element source, Element target, InteractionFragment sourceContainer, InteractionFragment targetContainer, MessageEnd sendMessageEnd, MessageEnd receiveMessageEnd) {

		List<NamedElement> signatures = getSignature(container.getModel(), source, target, messageSort);

		// If signatures == null, means the user click on cancel button during selection --> Cancel the whole process of creation
		if(signatures == null) {
			return null;
		}

		NamedElement signature = null;
		if(!signatures.isEmpty()) {
			signature = signatures.get(0);
		}

		// Get the correct MessageSort
		messageSort = getMessageSort(signature, messageSort);

		// Create the message
		Message message = doCreateMessage(container, messageSort, signature);

		// Create the two message ends
		if(sendMessageEnd == null && source != null) {
			sendMessageEnd = createMessageEnd(sourceContainer, EventHelper.doCreateSendEvent(messageSort, container, signature), source, MessageDirection.OUT);
		}
		if(receiveMessageEnd == null && target != null) {
			receiveMessageEnd = createMessageEnd(targetContainer, EventHelper.doCreateReceiveEvent(messageSort, container, signature), target, MessageDirection.IN);
		}

		// Update the messages end with the message
		if(sendMessageEnd != null) {
			sendMessageEnd.setMessage(message);
			ElementInitializers.init_NamedElement(sendMessageEnd, "", message.getName(), "Send"); //$NON-NLS-1$ //$NON-NLS-2$
			// Update the message with the messages end
			message.setSendEvent(sendMessageEnd);
		}
		if(receiveMessageEnd != null) {
			receiveMessageEnd.setMessage(message);
			ElementInitializers.init_NamedElement(receiveMessageEnd, "", message.getName(), "Recv"); //$NON-NLS-1$ //$NON-NLS-2$
			// Update the message with the messages end
			message.setReceiveEvent(receiveMessageEnd);
		}

		return message;
	}


	/**
	 * Get the messageSort of a message if it doesn't exist yet depending of the messageSignature.
	 * If no messageSort exists, and if the signature is null, then return a MessageSort.ASYNCH_CALL_LITERAL
	 * 
	 * @param signature
	 *        the signature of the message or null
	 * @param messageSort
	 *        a messageSort or null
	 * @return the messageSort
	 */
	private static MessageSort getMessageSort(NamedElement signature, MessageSort messageSort) {
		if(messageSort == null) {
			if(signature instanceof Signal) {
				return MessageSort.ASYNCH_SIGNAL_LITERAL;
			} else {
				return MessageSort.ASYNCH_CALL_LITERAL;
			}
		}
		return messageSort;
	}

	/**
	 * A method to validate that both source and target of a request have valid container for the creation of a message.
	 * 
	 * @param request
	 *        the request
	 * @return false if the container of the source or the target is null and if the two container are not equals
	 */
	public static boolean hasValidContainer(IEditCommandRequest request) {
		if(request.getParameter(SequenceRequestConstant.SOURCE_MODEL_CONTAINER) == null) {
			return false;
		}
		if(request.getParameter(SequenceRequestConstant.TARGET_MODEL_CONTAINER) == null) {
			return false;
		}
		// Message cannot cross InteractionFragment. The two mos must be contained into the same InteractionFragment
		if(!request.getParameter(SequenceRequestConstant.SOURCE_MODEL_CONTAINER).equals(request.getParameter(SequenceRequestConstant.TARGET_MODEL_CONTAINER))) {
			return false;
		}

		return true;
	}


}
