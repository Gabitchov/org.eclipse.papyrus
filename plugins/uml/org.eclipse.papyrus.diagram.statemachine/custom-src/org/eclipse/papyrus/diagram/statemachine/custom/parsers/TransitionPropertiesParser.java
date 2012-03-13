/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Arthur daussy (Atos) arthur.daussy@atos.net - Bug 361643: [StateMachine Diagram] Display of Guards doesn't work.
 *
 *****************************************************************************/
/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Arthur daussy (Atos) arthur.daussy@atos.net - Bug 361643: [StateMachine Diagram] Display of Guards doesn't work.
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.parsers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.umlutils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;


public class TransitionPropertiesParser implements IParser, ISemanticParser {

	private static final String ONE_SPACE_STRING = " "; //$NON-NLS-1$

	protected Constraint guardConstraint = null;

	private static String EMPTY_STRING = ""; //$NON-NLS-1$

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		if(element instanceof EObjectAdapter) {
			final Transition transition = ((Transition)((EObjectAdapter)element).getRealObject());
		}
		return EMPTY_STRING;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		final Transition transition = ((Transition)((EObjectAdapter)element).getRealObject());
		final String result = newString;

		AbstractTransactionalCommand tc = new AbstractTransactionalCommand(EditorUtils.getTransactionalEditingDomain(), "Edit Transition Properties", (List)null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				SafeRunnable.run(new SafeRunnable() {

					public void run() {
						RecordingCommand rc = new RecordingCommand(EditorUtils.getTransactionalEditingDomain()) {

							protected void doExecute() {
								// 1. Cherchez dans le model, si une contrainst
								// avec le meme nom existe

								EList<Element> elements = (transition.getModel()).allOwnedElements();
								Iterator<Element> modelElement = elements.iterator();
								while(modelElement.hasNext()) {
									Element pElement = (Element)modelElement.next();
									if(pElement instanceof Constraint && (result.equals(((NamedElement)pElement).getName()))) {
										guardConstraint = (Constraint)pElement;
										transition.setGuard(guardConstraint);
									}
								}

								// 2.Si aucune constraint n'existe deja
								if(guardConstraint == null) {
									guardConstraint = UMLFactory.eINSTANCE.createConstraint();
									guardConstraint.setName(result);
									guardConstraint.setContext(transition.getNamespace());
									transition.setGuard(guardConstraint);
								}
								// transition.setName(result);
							}
						};
						EditorUtils.getTransactionalEditingDomain().getCommandStack().execute(rc);
					}
				});
				return CommandResult.newOKCommandResult();

			};
		};
		return tc;
	}

	public String getPrintString(IAdaptable element, int flags) {
		String label = getValueString(element, flags);
		if(label == null || label.length() == 0) {
			label = ONE_SPACE_STRING;
		}
		return label;
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if(event instanceof Notification) {
			int notificationType = ((Notification)event).getEventType();
			if(Notification.SET == notificationType) {
				if(((Notification)event).getNewValue() instanceof Constraint)
					guardConstraint = (Constraint)((Notification)event).getNewValue();
				return true;

			}
		}
		return false;
	}

	/**
	 * Get the unformatted registered string value which shall be displayed
	 */
	protected String getValueString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);
		if(obj instanceof Transition) {
			Transition trans = (Transition)obj;
			StringBuilder result = new StringBuilder();
			String textForTrigger = getTextForTrigger(trans);
			if(textForTrigger != null && !EMPTY_STRING.equals(textForTrigger)) {
				result.append(textForTrigger).append(ONE_SPACE_STRING);
			}
			result.append(getTextForGuard(trans));
			String textForEffect = getTextForEffect(trans);
			if(textForEffect != null && !EMPTY_STRING.equals(textForEffect)) {
				result.append("/ ").append(textForEffect); //$NON-NLS-1$
			}
			return result.toString();
		}
		return EMPTY_STRING;
	}

	/**
	 * get the text concerning guard
	 * 
	 * @param trans
	 * @return
	 */
	protected String getTextForGuard(Transition trans) {
		Constraint valueSpec = trans.getGuard();
		if(valueSpec != null) {
			String value = ValueSpecificationUtil.getConstraintnValue(valueSpec);
			if(value != null) {
				return String.format("[%s]", value); //$NON-NLS-1$
			}
		}
		return EMPTY_STRING;
	}

	/**
	 * get the text concerning Effects
	 * 
	 * @param trans
	 * @return
	 */
	protected String getTextForEffect(Transition trans) {
		StringBuilder text = new StringBuilder();
		String result = EMPTY_STRING;
		Behavior effect = trans.getEffect();
		if(effect != null) {
			if (effect instanceof OpaqueBehavior){
				result = ((OpaqueBehavior) effect).getBodies().get(0);
			} else {
				EClass eClass = effect.eClass();
				if(eClass != null) {
					text.append(eClass.getName()).append(" :").append(effect.getName()); //$NON-NLS-1$
					result = String.format("%s", text.toString()); //$NON-NLS-1$
				}				
			}
		}
		return result;
	}

	/**
	 * Get the text concerning Trigger
	 * 
	 * @param trans
	 * @return
	 */
	protected String getTextForTrigger(Transition trans) {
		StringBuilder result = new StringBuilder();
		boolean isFirstTrigger = true;
		TriggerTextGetter triggerTextGetter = new TriggerTextGetter();
		for(Trigger t : trans.getTriggers()) {
			if(t != null && t.getEvent() != null) {
				Event e = t.getEvent();
				String tText = triggerTextGetter.doSwitch(e);
				if(tText != null && !tText.equals("")) {
					//Appending comas if the trigger is not the first one.
					if(!isFirstTrigger) {
						result.append(", "); //$NON-NLS-1$
					} else {
						isFirstTrigger = false;
					}
					result.append(tText);
				}
			}
		}
		return result.toString();
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return new ParserEditStatus(org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin.ID, IParserEditStatus.OK, ""); //$NON-NLS-1$
	}

	public List getSemanticElementsBeingParsed(EObject element) {
		SemanticElementsToParseGetter getter = new SemanticElementsToParseGetter();
		return getter.doSwitch(element);
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}
}

