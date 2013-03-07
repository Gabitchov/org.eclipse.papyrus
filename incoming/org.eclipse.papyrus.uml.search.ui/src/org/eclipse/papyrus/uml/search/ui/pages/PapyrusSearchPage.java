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
package org.eclipse.papyrus.uml.search.ui.pages;

import java.util.Collection;
import java.util.HashSet;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.papyrus.uml.search.ui.CheckBoxFilteredTree;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.actions.ReplaceAction;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeContentProvider;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeLabelProvider;
import org.eclipse.papyrus.uml.search.ui.query.PapyrusQuery;
import org.eclipse.papyrus.views.search.regex.PatternHelper;
import org.eclipse.papyrus.views.search.scope.ScopeCollector;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.search.ui.IReplacePage;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * Papyrus specific search page
 * 
 */
public class PapyrusSearchPage extends DialogPage implements ISearchPage, IReplacePage {

	private static final String REGULAR_EXPRESSION_ILLFORMED = Messages.PapyrusSearchPage_0;

	private static final String SEARCH_ISSUE = Messages.PapyrusSearchPage_1;

	private static final String SEARCH_IN_ALL_STRINGS = Messages.PapyrusSearchPage_2;

	private static final String SEARCH_IN_STEREOTYPE_ATTRIBUTES = Messages.PapyrusSearchPage_3;

	private Text searchQueryText;

	private ISearchPageContainer container;

	private CheckBoxFilteredTree participantTypesTree;

	private CheckboxTreeViewer participantTypesTreeViewer;

	private Label searchQueryExplanatoryLabel;

	private Button btnRegularExpression;

	private Button btnCaseSensitive;

	private Button btnSearchAllStringAttributes;

	private Button btnSearchInStereotypeAttributes;

	public void createControl(Composite parent) {

		initializeDialogUnits(parent);
		Composite searchComposite = new Composite(parent, SWT.NONE);
		searchComposite.setFont(parent.getFont());
		searchComposite.setLayout(new GridLayout(1, false));
		searchComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label lblSearchString = new Label(searchComposite, SWT.NONE);
		lblSearchString.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		lblSearchString.setText(Messages.PapyrusSearchPage_4);

		Composite queryComposite = new Composite(searchComposite, SWT.NONE);
		queryComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		queryComposite.setLayout(new GridLayout(2, false));

		searchQueryText = new Text(queryComposite, SWT.BORDER);
		searchQueryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		searchQueryText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				validateRegex();
			}
		});
		searchQueryText.setFocus();

		Composite compositeParameters = new Composite(queryComposite, SWT.NONE);
		compositeParameters.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		compositeParameters.setLayout(new GridLayout(1, false));

		btnCaseSensitive = new Button(compositeParameters, SWT.CHECK);
		btnCaseSensitive.setText(Messages.PapyrusSearchPage_5);

		btnRegularExpression = new Button(compositeParameters, SWT.CHECK);
		btnRegularExpression.setText(Messages.PapyrusSearchPage_6);
		btnRegularExpression.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				btnCaseSensitive.setEnabled(!btnRegularExpression.getSelection());
				validateRegex();
				searchQueryText.forceFocus();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		searchQueryExplanatoryLabel = new Label(queryComposite, SWT.NONE);
		searchQueryExplanatoryLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		Group grpSearchFor = new Group(searchComposite, SWT.NONE);
		grpSearchFor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpSearchFor.setLayout(new GridLayout(4, false));
		grpSearchFor.setText(Messages.PapyrusSearchPage_8);

		participantTypesTree = new CheckBoxFilteredTree(grpSearchFor, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL, new PatternFilter(), true);
		participantTypesTree.setLayout(new GridLayout());
		GridData chechboxTreeViewerGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1);
		chechboxTreeViewerGridData.heightHint = 150;
		participantTypesTree.setLayoutData(chechboxTreeViewerGridData);

		participantTypesTreeViewer = (CheckboxTreeViewer)participantTypesTree.getViewer();
		participantTypesTreeViewer.setContentProvider(new ParticipantTypeContentProvider(this));
		participantTypesTreeViewer.setLabelProvider(new ParticipantTypeLabelProvider());

		Button btnSelectAll = new Button(grpSearchFor, SWT.PUSH);
		btnSelectAll.setText(Messages.PapyrusSearchPage_9);
		btnSelectAll.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				participantTypesTreeViewer.setAllChecked(true);
			}
		});

		Button btnDeselectAll = new Button(grpSearchFor, SWT.PUSH);
		btnDeselectAll.setText(Messages.PapyrusSearchPage_10);
		btnDeselectAll.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				participantTypesTreeViewer.setAllChecked(false);
			}
		});

		btnSearchAllStringAttributes = new Button(grpSearchFor, SWT.CHECK);
		btnSearchAllStringAttributes.setText(SEARCH_IN_ALL_STRINGS);
		btnSearchAllStringAttributes.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 0, 0));
		btnSearchAllStringAttributes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				participantTypesTreeViewer.refresh();
			}
		});

		btnSearchInStereotypeAttributes = new Button(grpSearchFor, SWT.CHECK);
		btnSearchInStereotypeAttributes.setText(SEARCH_IN_STEREOTYPE_ATTRIBUTES);
		btnSearchInStereotypeAttributes.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 0, 0));
		btnSearchInStereotypeAttributes.setSelection(true);

		participantTypesTreeViewer.setInput(UMLPackage.eINSTANCE);
		participantTypesTreeViewer.setAllChecked(true);

		setControl(parent);
	}

	public boolean getSearchAllStringAttributes() {
		if(btnSearchAllStringAttributes != null) {
			return btnSearchAllStringAttributes.getSelection();
		} else {
			return false;
		}
	}

	/**
	 * Validate syntax of the regular expression of the search query text.
	 * 
	 * @return true, if successful
	 */
	private boolean validateRegex() {

		try {
			PatternHelper.getInstance().createPattern(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection());
			searchQueryExplanatoryLabel.setForeground(getControl().getForeground());
			searchQueryExplanatoryLabel.setText(""); //$NON-NLS-1$
			return true;

		} catch (PatternSyntaxException e) {
			searchQueryExplanatoryLabel.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			searchQueryExplanatoryLabel.setText(e.getDescription());

			return false;
		}
	}

	/**
	 * Create scopeEntries based on an IResources
	 * 
	 * @return the created scopeEntries
	 */
	private Collection<ScopeEntry> createScopeEntries(Collection<IResource> scope) {
		Collection<ScopeEntry> results = new HashSet<ScopeEntry>();

		for(IResource resource : scope) {

			ScopeEntry scopeEntry = new ScopeEntry(resource);

			results.add(scopeEntry);

		}

		return results;
	}

	public boolean performAction() {

		if(validateRegex()) {
			Collection<IResource> scope = ScopeCollector.getInstance().computeSearchScope(container);

			Collection<ScopeEntry> scopeEntries = createScopeEntries(scope);

			ISearchQuery query = new PapyrusQuery(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), btnSearchInStereotypeAttributes.getSelection(), scopeEntries, participantTypesTreeViewer.getCheckedElements(), btnSearchAllStringAttributes.getSelection());

			if(query.canRunInBackground()) {
				NewSearchUI.runQueryInBackground(query);
			}
			return true;
		} else {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), SEARCH_ISSUE, REGULAR_EXPRESSION_ILLFORMED);
			return false;
		}
	}

	public void setContainer(ISearchPageContainer container) {
		this.container = container;
		this.container.setPerformActionEnabled(true);
	}

	public boolean performReplace() {

		if(validateRegex()) {
			Collection<IResource> scope = ScopeCollector.getInstance().computeSearchScope(container);

			Collection<ScopeEntry> scopeEntries = createScopeEntries(scope);

			PapyrusQuery query = new PapyrusQuery(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), btnSearchInStereotypeAttributes.getSelection(), scopeEntries, participantTypesTreeViewer.getCheckedElements(), btnSearchAllStringAttributes.getSelection());

			NewSearchUI.runQueryInForeground(container.getRunnableContext(), query);

			Display.getCurrent().syncExec(new Runnable() {

				public void run() {
					ISearchResultViewPart view = NewSearchUI.activateSearchResultView();
					if(view != null) {
						ISearchResultPage page = view.getActivePage();

						if(page instanceof PapyrusSearchResultPage) {
							PapyrusSearchResultPage resultPage = (PapyrusSearchResultPage)page;
							ReplaceAction replaceAction = new ReplaceAction(resultPage.getSite().getShell(), resultPage, null);
							replaceAction.run();
						}
					}
				}
			});

			NewSearchUI.runQueryInForeground(container.getRunnableContext(), query);

			return true;
		} else {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), SEARCH_ISSUE, REGULAR_EXPRESSION_ILLFORMED);
			return false;
		}

	}
}
