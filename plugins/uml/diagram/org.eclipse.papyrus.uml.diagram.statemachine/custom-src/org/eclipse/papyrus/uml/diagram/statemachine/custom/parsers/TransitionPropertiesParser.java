/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
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
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.preferences.PreferenceConstants;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.tools.utils.OpaqueBehaviorUtil;
import org.eclipse.papyrus.uml.tools.utils.OpaqueExpressionUtil;
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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class TransitionPropertiesParser implements IParser, ISemanticParser {
	public static final String ONE_SPACE_STRING = " "; //$NON-NLS-1$
	public static final String EMPTY_STRING = ""; //$NON-NLS-1$
	public static final String DOTS = "..."; //$NON-NLS-1$
	public static final String PARAM_DOTS = "(...)"; //$NON-NLS-1$
	protected Constraint guardConstraint = null;

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		return EMPTY_STRING;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		final Transition transition = ((Transition) ((EObjectAdapter) element).getRealObject());
		final String result = newString;
		final TransactionalEditingDomain editingDomain;
		try {
			editingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(transition);
		} catch (ServiceException ex) {
			return null;
		}
		AbstractTransactionalCommand tc = new AbstractTransactionalCommand(editingDomain, "Edit Transition Properties", (List<?>) null) { //$NON-NLS-1$
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				SafeRunnable.run(new SafeRunnable() {
					public void run() {
						RecordingCommand rc = new RecordingCommand(getEditingDomain()) {
							@Override
							protected void doExecute() {
								// 1. Search, if a constraint with the same name exists
								EList<Element> elements = (transition.getModel()).allOwnedElements();
								Iterator<Element> modelElement = elements.iterator();
								while (modelElement.hasNext()) {
									Element pElement = modelElement.next();
									if (pElement instanceof Constraint && (result.equals(((NamedElement) pElement).getName()))) {
										guardConstraint = (Constraint) pElement;
										transition.setGuard(guardConstraint);
									}
								}
								// 2. no constraint exists already
								if (guardConstraint == null) {
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
		if (label == null || label.length() == 0) {
			label = ONE_SPACE_STRING;
		}
		return label;
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			int notificationType = ((Notification) event).getEventType();
			if (Notification.SET == notificationType) {
				if (((Notification) event).getNewValue() instanceof Constraint) {
					guardConstraint = (Constraint) ((Notification) event).getNewValue();
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
		if (obj instanceof Transition) {
			Transition trans = (Transition) obj;
			StringBuilder result = new StringBuilder();
			String textForTrigger = getTextForTrigger(trans);
			if (textForTrigger != null && !EMPTY_STRING.equals(textForTrigger)) {
				result.append(textForTrigger);
			}
			result.append(getTextForGuard(trans));
			String textForEffect = getTextForEffect(trans);
			if (textForEffect != null && !EMPTY_STRING.equals(textForEffect)) {
				if (textForEffect != null && !EMPTY_STRING.equals(textForEffect)) {
					result.append("/"); //$NON-NLS-1$
					if (lineBreakBeforeEffect()) {
						result.append("\n"); //$NON-NLS-1$
					}
					result.append(textForEffect);
				}
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
		if (valueSpec != null) {
			String value = ValueSpecificationUtil.getConstraintnValue(valueSpec);
			if (value != null) {
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
		if (effect != null) {
			EClass eClass = effect.eClass();
			if (effect instanceof OpaqueBehavior) {
				OpaqueBehavior ob = (OpaqueBehavior) effect;
				if (ob.getBodies().size() > 0) {
					// return body of behavior (only handle case of a single body)
					result.append(retrieveBody(ob));
					return result.toString();
				}
			}
			if (eClass != null) {
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
		for (Trigger t : trans.getTriggers()) {
			if (t != null) {
				if (!isFirstTrigger) {
					result.append(", "); //$NON-NLS-1$
				} else {
					isFirstTrigger = false;
				}
				Event e = t.getEvent();
				if (e instanceof CallEvent) {
					Operation op = ((CallEvent) e).getOperation();
					if (op != null) {
						result.append(op.getName());
						if ((op.getOwnedParameters().size() > 0) && displayParamDots()) {
							result.append(PARAM_DOTS);
						}
					} else {
						result.append(((CallEvent) e).getName());
					}
				} else if (e instanceof SignalEvent) {
					Signal signal = ((SignalEvent) e).getSignal();
					if (signal != null) {
						result.append(signal.getName());
						if ((signal.getAttributes().size() > 0) && displayParamDots()) {
							result.append(PARAM_DOTS);
						}
					} else {
						result.append(((SignalEvent) e).getName());
					}
				} else if (e instanceof ChangeEvent) {
					ValueSpecification vs = ((ChangeEvent) e).getChangeExpression();
					String value;
					if (vs instanceof OpaqueExpression) {
						value = retrieveBody((OpaqueExpression) vs);
					}
					else {
						value = vs.stringValue();
					}
					result.append(value);
				} else if (e instanceof TimeEvent) {
					TimeEvent timeEvent = (TimeEvent) e;
					// absRelPrefix
					result.append(timeEvent.isRelative() ? "after " : "at "); //$NON-NLS-1$ //$NON-NLS-2$
					// body
					TimeExpression te = timeEvent.getWhen();
					String value;
					if (te != null) {
						ValueSpecification vs = te.getExpr();
						if (vs instanceof OpaqueExpression) {
							value = retrieveBody((OpaqueExpression) vs);
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

	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		Element umlElement = (Element) element;
		List<EObject> result = new LinkedList<EObject>();
		if (umlElement instanceof Transition) {
			Transition trans = (Transition) umlElement;
			if (trans != null) {
				result.add(trans);
				/**
				 * Listen constraint modification
				 */
				Constraint constraint = trans.getGuard();
				if (constraint != null) {
					result.add(constraint);
					ValueSpecification specification = constraint.getSpecification();
					if (specification != null) {
						result.add(specification);
					}
				}
				/**
				 * Listen trigger modification
				 */
				for (Trigger t : trans.getTriggers()) {
					if (t != null) {
						result.add(t);
					}
				}
				/**
				 * Listen effect modification
				 */
				Behavior effect = trans.getEffect();
				if (effect != null) {
					result.add(effect);
				}
			}
			// if(constraint.getSpecification() != null) {
			// ValueSpecification value = constraint.getSpecification();
			// result.add(value);
			// }
		}
		return result;
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}

	/**
	 * Return the body of an expression. Retrieve the "Natural Language" body with priority,
	 * i.e. return this body if it exists, otherwise return the first body.
	 * 
	 * @param exp
	 *            an opaque expression
	 * @return the associated body
	 */
	public static String retrieveBody(OpaqueExpression exp) {
		String body = OpaqueExpressionUtil.getBodyForLanguage(exp, "Natural Language"); //$NON-NLS-1$
		if (body.equals(EMPTY_STRING)) {
			body = OpaqueExpressionUtil.getBodyForLanguage(exp, null);
		}
		return cutBodyString(body);
	}

	/**
	 * Return the body of an opaque behavior. Retrieve the "Natural Language" body with priority,
	 * i.e. return this body if it exists, otherwise return the first body.
	 * 
	 * @param exp
	 *            an opaque expression
	 * @return the associated body
	 */
	public static String retrieveBody(OpaqueBehavior ob) {
		String body = OpaqueBehaviorUtil.getBody(ob, "Natural Language"); //$NON-NLS-1$
		if (body.equals(EMPTY_STRING) && ob.getBodies().size() > 0) {
			body = ob.getBodies().get(0);
		}
		return cutBodyString(body);
	}

	/**
	 * Cut a body string after a predefined number of lines (taken from preference store).
	 * 
	 * @param body
	 *            the body string
	 * @return
	 */
	public static String cutBodyString(String body) {
		IPreferenceStore preferenceStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		int cutLength = preferenceStore.getInt(PreferenceConstants.BODY_CUT_LENGTH);
		if (cutLength == 0) {
			return DOTS;
		}
		else {
			int start = 0;
			int newStart = 0;
			while (cutLength > 0) {
				// use "\n" instead of System.lineSeparator, since code embedded into a model
				// might not be destined for the development machine, e.g. contain eventually only
				// \n, although the model is opened on a windows machine.
				newStart = body.indexOf("\n", start); //$NON-NLS-1$
				if (newStart > 0) {
					cutLength--;
					start = newStart + 1;
				}
				else {
					return body;
				}
			}
			if (newStart > 0) {
				// handle case that \n is preceded by a \r
				if (newStart >= 1 && body.charAt(newStart - 1) == '\r') {
					return body.substring(0, start - 1) + DOTS;
				}
				return body.substring(0, newStart) + DOTS;
			}
			return body;
		}
	}

	/**
	 * 
	 * @return true, if the presence of parameters should be indicated by (...)
	 */
	public static boolean displayParamDots() {
		IPreferenceStore preferenceStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		return preferenceStore.getBoolean(PreferenceConstants.INDICATE_PARAMETERS);
	}

	/**
	 * 
	 * @return true, if the presence of parameters should be indicated by (...)
	 */
	public static boolean lineBreakBeforeEffect() {
		IPreferenceStore preferenceStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		return preferenceStore.getBoolean(PreferenceConstants.LINEBREAK_BEFORE_EFFECT);
	}
}
