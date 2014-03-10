/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.search.ui.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.console.messages.ConsoleMessages;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocument;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.results.PapyrusSearchResult;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.results.ModelElementMatch;
import org.eclipse.papyrus.views.search.results.ModelMatch;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * 
 * Papyrus specific search query
 * 
 */
public class PapyrusOCLQuery extends AbstractPapyrusQuery {


	private EObject contextObject;

	private PapyrusSearchResult results;

	private ScopeEntry scopeEntry;

	private BaseDocument queryEditorDocument;

	private ParserContext parserContext;

	private MetaModelManager metaModelManager;

	private DomainModelManager modelManager;

	protected Set<AbstractResultEntry> fResults = null;

	public PapyrusOCLQuery(BaseDocument queryEditorDocument, ParserContext parserContext, MetaModelManager metaModelManager, DomainModelManager modelManager, EObject contextObject, ScopeEntry scopeEntry) {
		this.queryEditorDocument = queryEditorDocument;
		this.contextObject = contextObject;
		this.scopeEntry = scopeEntry;
		this.parserContext = parserContext;
		this.metaModelManager = metaModelManager;
		this.modelManager = modelManager;

		Collection<ScopeEntry> scopeEntries = new ArrayList<ScopeEntry>();
		scopeEntries.add(scopeEntry);
		results = new PapyrusSearchResult(this);
		fResults = new HashSet<AbstractResultEntry>();
	}


	protected boolean evaluate(final String expression) {

		if((expression == null) || (expression.trim().length() <= 0)) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusOCLQuery_0, Messages.PapyrusOCLQuery_1);
			return false;
		}

		boolean result = true;
		try {


			IDocument doc = queryEditorDocument;

			final BaseDocument editorDocument = queryEditorDocument;
			Object value = null;
			try {

				value = editorDocument.readOnly(new IUnitOfWork<Object, XtextResource>() {

					public Object exec(XtextResource state) throws Exception {
						assert state != null;
						IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
						EvaluationRunnable runnable = new EvaluationRunnable((BaseResource)state, expression);
						runnable.run(new NullProgressMonitor());
						//						progressService.busyCursorWhile(runnable);
						return runnable.getValue();
					}
				});
			} catch (Exception e) {
				//				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", e.getMessage());
			}
			if(value instanceof InvalidValueException) {
				InvalidValueException exception = (InvalidValueException)value;
				//				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", exception.getMessage());
				Throwable cause = exception.getCause();
				if((cause != null) && (cause != exception)) {
					//					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", cause.getMessage());
				}
			} else if(value != null) {
				CollectionValue collectionValue = ValuesUtil.isCollectionValue(value);
				if(collectionValue != null) {
					for(Object elementValue : collectionValue.iterable()) {
						if(elementValue instanceof EObject) {
							ModelMatch match = new ModelElementMatch(elementValue, scopeEntry);
							fResults.add(match);
						}
						//						System.err.println("Found : " + ValuesUtil.stringValueOf(elementValue));
					}
				} else {
					if(value instanceof EObject) {
						ModelMatch match = new ModelElementMatch(value, scopeEntry);
						fResults.add(match);
					}
					//					System.err.println("Found : " + ValuesUtil.stringValueOf(value));
				}
			} else {
				//				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", ValuesUtil.stringValueOf(value));

			}

		} catch (Exception e) {
			result = false;

			if(e.getLocalizedMessage() == null) {
				//				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", e.getClass().getName());
			} else {
				//				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", e.getLocalizedMessage());
			}
		}

		return result;
	}

	private class EvaluationRunnable implements IRunnableWithProgress {

		private final @NonNull
		BaseResource resource;

		private final @NonNull
		String expression;

		private Object value = null;

		public EvaluationRunnable(@NonNull BaseResource resource, @NonNull String expression) {
			this.resource = resource;
			this.expression = expression;
		}

		public Object getValue() {
			return value;
		}

		public void run(final IProgressMonitor monitor) {
			monitor.beginTask(NLS.bind(ConsoleMessages.Progress_Title, expression), 10);
			monitor.subTask(ConsoleMessages.Progress_Synchronising);
			monitor.worked(1);


			ExpressionInOCL expressionInOCL;
			try {
				PivotUtil.checkResourceErrors("", resource); //$NON-NLS-1$
				expressionInOCL = parserContext.getExpression(resource);
			} catch (ParserException e) {
				value = new InvalidValueException(e, ConsoleMessages.Result_ParsingFailure);
				return;
			}
			if(expressionInOCL != null) {
				// monitor.worked(2);
				monitor.subTask(ConsoleMessages.Progress_Extent);
				PivotEnvironmentFactory envFactory = new PivotEnvironmentFactory(null, metaModelManager);
				PivotEnvironment environment = envFactory.createEnvironment();
				EvaluationEnvironment evaluationEnvironment = envFactory.createEvaluationEnvironment();
				Object contextValue = metaModelManager.getIdResolver().boxedValueOf(contextObject);
				evaluationEnvironment.add(DomainUtil.nonNullModel(expressionInOCL.getContextVariable()), contextValue);
				// if (modelManager == null) {
				// let the evaluation environment create one
				@NonNull
				DomainModelManager modelManager2 = modelManager = evaluationEnvironment.createModelManager(contextObject);
				// }
				monitor.worked(2);
				monitor.subTask(ConsoleMessages.Progress_Evaluating);
				try {
					// metaModelManager.setMonitor(monitor);
					CancelableEvaluationVisitor evaluationVisitor = new CancelableEvaluationVisitor(monitor, environment, evaluationEnvironment, modelManager2);
					//					evaluationVisitor.setLogger(new DomainLogger() {
					//
					//						public void append(final @NonNull String message) {
					//							OCLConsolePage.this.getControl().getDisplay().asyncExec(new Runnable() {
					//
					//								public void run() {
					//									OCLConsolePage.this.append(message, ColorManager.DEFAULT, false);
					//								}
					//							});
					//						}
					//					});
					value = evaluationVisitor.visitExpressionInOCL(expressionInOCL);
				} catch (InvalidValueException e) {
					value = e;
				} catch (Exception e) {
					value = new InvalidValueException(e, ConsoleMessages.Result_EvaluationFailure);
				} finally {
					// metaModelManager.setMonitor(null);
				}
			}
			monitor.worked(4);
		}
	}

	/**
	 * CancelableEvaluationVisitor refines the EvaluationVisitor to poll the
	 * monitor foer cancelation at a variety of significant
	 * evaluation events, such as feature vists and {@link #getValueFactory()}.
	 */
	protected static class CancelableEvaluationVisitor extends EvaluationVisitorImpl {

		private final @NonNull
		IProgressMonitor monitor;

		protected CancelableEvaluationVisitor(@NonNull IProgressMonitor monitor, @NonNull Environment env, @NonNull EvaluationEnvironment evalEnv, @NonNull DomainModelManager modelManager) {
			super(env, evalEnv, modelManager);
			this.monitor = monitor;
		}

		@Override
		public @NonNull
		EvaluationVisitor createNestedEvaluator() {
			EnvironmentFactory factory = environment.getFactory();
			EvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(evaluationEnvironment);
			CancelableEvaluationVisitor nestedVisitor = new CancelableEvaluationVisitor(monitor, environment, nestedEvalEnv, modelManager);
			nestedVisitor.setLogger(getLogger());
			return nestedVisitor;
		}
	}

	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
		results.removeAll();
		fResults.clear();

		evaluate(queryEditorDocument.get().trim());

		monitor.done();

		return Status.OK_STATUS;
	}

	/**
	 * Evaluate if the value matches the pattern
	 * 
	 * @param value
	 *        the value to evaluate
	 * @param attribute
	 *        the attribute has the value
	 * @param pattern
	 *        the pattern that is searched
	 * @param participant
	 *        the element that contains the value
	 * @param scopeEntry
	 *        the scopeEntry that contains the participant
	 */
	protected void evaluateAndAddToResult(String value, Object attribute, Pattern pattern, Object participant, ScopeEntry scopeEntry) {

		value = value != null ? value : ""; //$NON-NLS-1$

		Matcher m = pattern.matcher(value);

		//		if(isRegularExpression) {
		//			if(m.matches()) {
		//				int start = m.start();
		//				int end = m.end();
		//				ModelMatch match = new AttributeMatch(start, end, participant, scopeEntry, attribute);
		//
		//				fResults.add(match);
		//			}
		//		} else {
		//			while(m.find()) {
		//				int start = m.start();
		//				int end = m.end();
		//				AttributeMatch match = new AttributeMatch(start, end, participant, scopeEntry, attribute);
		//				fResults.add(match);
		//			}
		//		}


	}

	/**
	 * Try to find elements that match in the participants
	 * 
	 * @param participants
	 * @param scopeEntry
	 */
	protected void evaluate(Collection<EObject> participants, ScopeEntry scopeEntry) {

		//		for(EObject participant : participants) {
		//
		//			String query = searchQueryText;
		//			if(searchQueryText.equals("")) { //$NON-NLS-1$
		//				query = ".*"; //$NON-NLS-1$
		//			}
		//
		//			Pattern pattern = PatternHelper.getInstance().createPattern(query, isCaseSensitive, isRegularExpression);
		//
		//			if(pattern != null) {
		//				if(searchAllStringAttributes) {
		//
		//					for(EAttribute attribute : participant.eClass().getEAllAttributes()) {
		//						Object value = participant.eGet(attribute);
		//
		//						if(value instanceof String) {
		//							String stringValue = (String)value;
		//							evaluateAndAddToResult(stringValue, attribute, pattern, participant, scopeEntry);
		//						}
		//					}
		//
		//				} else {
		//					if(participant instanceof NamedElement) {
		//						String umlElementName = ((NamedElement)participant).getName();
		//						umlElementName = umlElementName != null ? umlElementName : ""; //$NON-NLS-1$
		//
		//						evaluateAndAddToResult(umlElementName, UMLPackage.eINSTANCE.getNamedElement_Name(), pattern, participant, scopeEntry);
		//					}
		//				}
		//				if(searchStereotypeAttributes) {
		//					if(participant instanceof Element) {
		//						EList<Stereotype> stereotypes = ((Element)participant).getAppliedStereotypes();
		//						for(Stereotype stereotype : stereotypes) {
		//							for(Property stereotypeProperty : stereotype.getAllAttributes()) {
		//								if(!stereotypeProperty.getName().startsWith("base_")) {
		//									Object value = ((Element)participant).getValue(stereotype, stereotypeProperty.getName());
		//									if(value != null) {
		//
		//										if(value instanceof String) {
		//											String stringValue = (String)value;
		//											evaluateAndAddToResult(stringValue, stereotypeProperty, pattern, participant, scopeEntry);
		//										}
		//									}
		//								}
		//							}
		//
		//						}
		//					}
		//				}
		//
		//			}
		//		}
		//
		//		//Now, find in diagram and others the elements we found
		//		ViewerSearchService viewerSearcherService = new ViewerSearchService();
		//		try {
		//			viewerSearcherService.startService();
		//
		//			//Get sources elements that matched
		//			Set<Object> sources = new HashSet<Object>();
		//			for(AbstractResultEntry match : fResults) {
		//				if(match instanceof AttributeMatch) {
		//					sources.add(((AttributeMatch)match).getTarget());
		//				} else {
		//					sources.add(match.getSource());
		//				}
		//			}
		//
		//			//Get viewer of these sources
		//			Map<Object, Map<Object, Object>> viewersMappings = viewerSearcherService.getViewers(sources, scopeEntry.getModelSet());
		//
		//			//Add viewers to results
		//			for(Object containingModelSet : viewersMappings.keySet()) {
		//				for(Object view : viewersMappings.get(containingModelSet).keySet()) {
		//					Object semanticElement = viewersMappings.get(containingModelSet).get(view);
		//					ViewerMatch viewMatch = new ViewerMatch(view, scopeEntry, semanticElement);
		//					fResults.add(viewMatch);
		//				}
		//			}
		//
		//		} catch (ServiceException e) {
		//			Activator.log.error(Messages.PapyrusQuery_5 + scopeEntry.getModelSet(), e);
		//		}
	}

	public String getLabel() {
		return Messages.PapyrusQuery_6;
	}

	public boolean canRerun() {
		return false;
	}

	public boolean canRunInBackground() {
		return true;
	}

	public ISearchResult getSearchResult() {
		for(AbstractResultEntry match : fResults) {
			results.addMatch(match);
		}
		return results;
	}

	/**
	 * Getter for the text query
	 * 
	 * @return the the query text
	 */
	public String getSearchQueryText() {
		if(queryEditorDocument.get().length() > 25) {
			return queryEditorDocument.get().subSequence(0, 25) + "..."; //$NON-NLS-1$
		} else {
			return queryEditorDocument.get();
		}
	}

}
