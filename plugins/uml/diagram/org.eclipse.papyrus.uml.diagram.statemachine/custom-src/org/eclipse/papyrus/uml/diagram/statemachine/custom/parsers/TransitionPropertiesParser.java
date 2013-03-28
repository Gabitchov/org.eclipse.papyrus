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
package org.eclipse.papyrus.uml.diagram.statemachine.custom.parsers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class TransitionPropertiesParser implements IParser, ISemanticParser {

	private static final String ONE_SPACE_STRING = " "; //$NON-NLS-1$

	protected Constraint guardConstraint = null;

	private static String EMPTY_STRING = ""; //$NON-NLS-1$

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		return EMPTY_STRING;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		final Transition transition = ((Transition)((EObjectAdapter)element).getRealObject());
		final String result = newString;

		final TransactionalEditingDomain editingDomain;
		try {
			editingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(transition);
		} catch (ServiceException ex) {
			return null;
		}

		AbstractTransactionalCommand tc = new AbstractTransactionalCommand(editingDomain, "Edit Transition Properties", (List)null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				SafeRunnable.run(new SafeRunnable() {

					public void run() {
						RecordingCommand rc = new RecordingCommand(getEditingDomain()) {

							@Override
							protected void doExecute() {
								// 1. Cherchez dans le model, si une contrainst
								// avec le meme nom existe

								EList<Element> elements = (transition.getModel()).allOwnedElements();
								Iterator<Element> modelElement = elements.iterator();
								while(modelElement.hasNext()) {
									Element pElement = modelElement.next();
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
						getEditingDomain().getCommandStack().execute(rc);
					}
				});
				return CommandResult.newOKCommandResult();

			}
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
				if(((Notification)event).getNewValue() instanceof Constraint) {
					guardConstraint = (Constraint)((Notification)event).getNewValue();
				}
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
				result.append("/\n").append(textForEffect); //$NON-NLS-1$
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
		StringBuilder result = new StringBuilder();
		Behavior effect = trans.getEffect();
		if(effect != null) {
			EClass eClass = effect.eClass();
			if(effect instanceof OpaqueBehavior) {
				OpaqueBehavior ob = (OpaqueBehavior)effect;
				if(ob.getBodies().size() > 0) {
					// return body of behavior (only handle case of a single body)
					result.append(ob.getBodies().get(0));
					return result.toString();
				}
			}
			if(eClass != null) {
				result.append(eClass.getName()).append(": ").append(effect.getName()); //$NON-NLS-1$
			}
		}
		return result.toString();
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
		for(Trigger t : trans.getTriggers()) {
			if(t != null) {
				if(!isFirstTrigger) {
					result.append(", "); //$NON-NLS-1$
				} else {
					isFirstTrigger = false;
				}
				Event e = t.getEvent();
				if(e instanceof CallEvent) {
					if(((CallEvent)e).getOperation() != null) {
						result.append(((CallEvent)e).getOperation().getName());
					} else {
						result.append(((CallEvent)e).getName());
					}

				} else if(e instanceof SignalEvent) {
					if(((SignalEvent)e).getSignal() != null) {
						result.append(((SignalEvent)e).getSignal().getName());
					} else {
						result.append(((SignalEvent)e).getName());
					}
				} else if(e instanceof ChangeEvent) {
					ValueSpecification vs = ((ChangeEvent) e).getChangeExpression();
					String value;
					if (vs instanceof OpaqueExpression) {
						value = "\"" + retrieveBody((OpaqueExpression) vs, "Natural language") + "\""; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					}
					else {
						value = vs.stringValue();
					}
					result.append(value);
				} else if(e instanceof TimeEvent) {
					TimeEvent timeEvent= (TimeEvent) e; 
					//absRelPrefix
					result.append(timeEvent.isRelative() ? "after " : "at "); //$NON-NLS-1$ //$NON-NLS-2$
					// body
					TimeExpression te = timeEvent.getWhen();
					String value;
					if (te != null) {
						ValueSpecification vs = te.getExpr();
						if (vs instanceof OpaqueExpression) {
							value = "\"" + retrieveBody((OpaqueExpression) vs, "Natural language") + "\""; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						}
						else {
							value = vs.stringValue();
						}
					}
					else {
						value = "undefined"; //$NON-NLS-1$
					}
					result.append(value);
				} else { // any receive event
					result.append("all"); //$NON-NLS-1$
				}
			}
		}
		return result.toString();
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {

		return new ParserEditStatus(org.eclipse.papyrus.uml.diagram.statemachine.part.UMLDiagramEditorPlugin.ID, IParserEditStatus.OK, ""); //$NON-NLS-1$
	}

	public List getSemanticElementsBeingParsed(EObject element) {
		Element umlElement = (Element)element;
		List<EObject> result = new LinkedList<EObject>();
		if(umlElement instanceof Transition) {
			Transition trans = (Transition)umlElement;
			if(trans != null) {
				result.add(trans);
				/**
				 * Listen constraint modification
				 */
				Constraint constraint = trans.getGuard();
				if(constraint != null) {
					result.add(constraint);
					ValueSpecification specification = constraint.getSpecification();
					if(specification != null) {
						result.add(specification);
					}
				}
				/**
				 * Listen trigger modification
				 */
				for(Trigger t : trans.getTriggers()) {
					if(t != null) {
						result.add(t);
					}
				}
				/**
				 * Listen effect modification
				 */
				Behavior effect = trans.getEffect();
				if(effect != null) {
					result.add(effect);
				}
			}

			//			if(constraint.getSpecification() != null) {
			//				ValueSpecification value = constraint.getSpecification();
			//				result.add(value);
			//			}
		}
		return result;
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}

	private String retrieveBody(OpaqueExpression exp, String languageName) {
		String body = EMPTY_STRING;
		if(exp == null) {
			return body;
		}
		int index = 0;
		for(String _languageName : exp.getLanguages()) {
			if(_languageName.equals(languageName)) {
				if(index < exp.getBodies().size()) {
					return exp.getBodies().get(index);
				} else {
					return EMPTY_STRING;
				}
			}
			index++;
		}
		return body;
	}

}
