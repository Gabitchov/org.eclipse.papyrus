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
package org.eclipse.papyrus.uml.search.ui.dialogs;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.pages.PapyrusSearchResultPage;
import org.eclipse.papyrus.views.search.regex.PatternHelper;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.results.AttributeMatch;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.papyrus.views.search.utils.MatchUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

import com.swtdesigner.ResourceManager;

public class ReplaceDialog extends Dialog {

	PapyrusSearchResultPage fResultPage;

	org.eclipse.papyrus.uml.search.ui.query.PapyrusQuery fQuery;

	Object[] fSelection;

	Text replaceText;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        the parent shell, or <code>null</code> to create a top-level
	 *        shell
	 * @param fSelection
	 * @param fResult
	 * @param page
	 *        the result page whose results while be filtered
	 */
	public ReplaceDialog(Shell parentShell, PapyrusSearchResultPage fResultPage, Object[] selection) {
		super(parentShell);

		this.fResultPage = fResultPage;
		this.fSelection = selection;
		this.fQuery = (org.eclipse.papyrus.uml.search.ui.query.PapyrusQuery)fResultPage.getInput().getQuery();

	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.ReplaceDialog_0);
		shell.setImage(ResourceManager.getPluginImage(Activator.PLUGIN_ID, "icons/PapyrusSearch.png")); //$NON-NLS-1$)
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		parent.setLayout(new GridLayout(1, true));

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(2, false));

		Label labelQueryText = new Label(composite, SWT.NONE);
		labelQueryText.setText(Messages.ReplaceDialog_1);

		Text queyText = new Text(composite, SWT.BORDER);
		queyText.setEnabled(false);
		queyText.setText(fQuery.getSearchQueryText());
		queyText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 0, 0));

		Label labelReplace = new Label(composite, SWT.NONE);
		labelReplace.setText(Messages.ReplaceDialog_2);

		replaceText = new Text(composite, SWT.BORDER);
		replaceText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 0, 0));

		Label warningLabel = new Label(composite, SWT.NONE);
		warningLabel.setText(Messages.ReplaceDialog_3);
		warningLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 0));

		return parent;
	}

	private String computeReplacementString(Pattern pattern, String originalText, String replacementText) throws PatternSyntaxException {
		if(pattern != null) {
			try {

				Matcher matcher = pattern.matcher(originalText);
				StringBuffer sb = new StringBuffer();
				matcher.reset();
				if(matcher.find()) {
					matcher.appendReplacement(sb, replacementText);
				} else {
					return null;
				}
				matcher.appendTail(sb);
				return sb.toString();
			} catch (IndexOutOfBoundsException ex) {
				throw new PatternSyntaxException(ex.getLocalizedMessage(), replacementText, -1);
			}
		}
		return replacementText;
	}

	private void change(AttributeMatch match) {
		if(match.getTarget() instanceof EObject) {

			EObject target = (EObject)match.getTarget();

			if(match.getSource() instanceof EAttribute) {
				Object value = target.eGet((EAttribute)match.getSource());
				if(value != null) {
					if(value instanceof String) {
						String originalvalue = (String)value;
						Pattern pattern = PatternHelper.getInstance().createPattern(fQuery.getSearchQueryText(), fQuery.isCaseSensitive(), fQuery.isRegularExpression());

						String newValue = computeReplacementString(pattern, originalvalue, replaceText.getText());

						target.eSet((EAttribute)match.getSource(), newValue);

					}
				}
			} else if(match.getSource() instanceof Property) {
				Property source = (Property)match.getSource();
				Class containingClass = source.getClass_();
				if(containingClass instanceof Stereotype) {
					if(target instanceof Element) {
						Object tagValue = ((Element)target).getValue((Stereotype)containingClass, source.getName());
						if(tagValue instanceof String) {
							Object value = tagValue;

							if(value != null) {
								if(value instanceof String) {
									String originalvalue = (String)value;
									Pattern pattern = PatternHelper.getInstance().createPattern(fQuery.getSearchQueryText(), fQuery.isCaseSensitive(), fQuery.isRegularExpression());

									String newValue = computeReplacementString(pattern, originalvalue, replaceText.getText());

									((Element)target).setValue((Stereotype)containingClass, source.getName(), newValue);

								}
							}

						}
					}
				}
			}

		}

	}

	@Override
	protected void okPressed() {

		Set<AbstractResultEntry> toProcess = new HashSet<AbstractResultEntry>();
		Set<ScopeEntry> toSave = new HashSet<ScopeEntry>();

		if(fSelection == null) {
			toProcess.addAll(MatchUtils.getMatches(fResultPage.getInput(), false));

		} else {
			for(Object selected : Arrays.asList(fSelection)) {
				if(selected instanceof AbstractResultEntry) {
					toProcess.add((AbstractResultEntry)selected);
				}
			}
		}

		for(AbstractResultEntry match : toProcess) {

			if(match instanceof AttributeMatch) {
				final AttributeMatch attributeMatch = (AttributeMatch)match;

				EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(attributeMatch.getTarget());

				Object element = match.getElement();

				if(editingDomain != null) {
					if(editingDomain instanceof TransactionalEditingDomain) {
						editingDomain.getCommandStack().execute(new RecordingCommand((TransactionalEditingDomain)editingDomain) {

							@Override
							protected void doExecute() {
								change(attributeMatch);
							}
						});
					}
				} else {
					if(element instanceof ScopeEntry) {

						change(attributeMatch);

						toSave.add((ScopeEntry)element);

					}
				}
			}
		}

		for(ScopeEntry scopeEntry : toSave) {
			try {
				scopeEntry.getModelSet().save(new NullProgressMonitor());
			} catch (IOException e) {
				Activator.log.error(Messages.ReplaceDialog_4 + scopeEntry.getModelSet(), e);
			}
		}

		super.okPressed();
	}
}
