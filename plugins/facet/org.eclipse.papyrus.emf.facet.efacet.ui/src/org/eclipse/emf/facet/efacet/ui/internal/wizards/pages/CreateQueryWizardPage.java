/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *  Gregoire Dupe (Mia-Software) - Bug 373248 - Clean PMD errors
 */
package org.eclipse.emf.facet.efacet.ui.internal.wizards.pages;

import java.util.Map;

import org.eclipse.emf.facet.efacet.Facet;
import org.eclipse.emf.facet.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.emf.facet.widgets.celleditors.core.composite.registries.ICompositeEditorFactoriesRegistry;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class CreateQueryWizardPage extends WizardPage {

	private static final int NUMBER_COLUMN = 3;

	private Map<String, IQueryCreationPagePart> queryTypeNameToQueryCreationPage;

	private Text queryNameText;
	private boolean canChangeQueryName = true;

	private Button canBeCachedButton;
	private boolean canChangeCanBeCached = true;

	private Button hasSideEffectButton;
	private boolean canChangeHasSideEffect = true;

	private AbstractCellEditorComposite<Integer> lowerBoundText;
	private boolean canChangeLowerBound = true;

	private AbstractCellEditorComposite<Integer> upperBoundText;
	private boolean canChangeUpperBound = true;

	private String queryName;
	private FacetSet facetSet;
	private Facet facet;
	private String queryType;

	private Composite parentComposite;
	private IQueryCreationPagePart queryCreationPage;

	public CreateQueryWizardPage(final Map<String, IQueryCreationPagePart> queryTypeNameToQueryCreationPage,
			final FacetSet facetSet, final Facet facet) {
		this("Whatever", facetSet); //$NON-NLS-1$
		this.facet = facet;
		this.queryTypeNameToQueryCreationPage = queryTypeNameToQueryCreationPage;
	}

	@Override
	public void setVisible(final boolean visible) {
		if (visible) {
			setFocus();
			IWizardPage previousPage = getPreviousPage();
			if (previousPage instanceof AbstractFacetWizardPage) {
				AbstractFacetWizardPage createFacetInFacetSetWizardPage = (AbstractFacetWizardPage) getPreviousPage();
				this.queryType = createFacetInFacetSetWizardPage.getSelectedQueryType();
				String childrenName = createFacetInFacetSetWizardPage.getChildrenName();
				String childrenNameFirstLetterToUpperCase = childrenName.substring(0, 1).toUpperCase()
						+ childrenName.substring(1);
				if (previousPage instanceof CreateFacetInFacetSetWizardPage) {
					setQueryName("is" + childrenNameFirstLetterToUpperCase); //$NON-NLS-1$	
				} else if (previousPage instanceof AddReferenceInFacetWizardPage
						|| previousPage instanceof AddAttributeInFacetWizardPage) {
					setQueryName("get" + childrenNameFirstLetterToUpperCase); //$NON-NLS-1$
				} else {
					setQueryName(childrenNameFirstLetterToUpperCase);
				}
				deleteAllControls(this.parentComposite);
				createControl2(this.parentComposite);
				this.parentComposite.layout();
			}
		}
		super.setVisible(visible);
	}

	private void setFocus() {
		this.queryNameText.setFocus();
	}

	public CreateQueryWizardPage(final String pageName, final FacetSet facetSet) {
		super(pageName);
		setTitle(Messages.Create_Query);
		this.facetSet = facetSet;
	}

	private static void deleteAllControls(final Composite comp) {
		for (Control c : comp.getChildren()) {
			c.dispose();
		}
	}

	@Override
	public boolean isPageComplete() {
		if (this.queryCreationPage != null) {
			if (!this.queryCreationPage.isCompositeComplete()) {
				setErrorMessage(this.queryCreationPage.getErrorMessage());
				return false;
			}
			setErrorMessage(null);
		}
		return super.isPageComplete();
	}

	private void createControl2(final Composite parent) {
		Composite threeColumnContainer = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(CreateQueryWizardPage.NUMBER_COLUMN, false);
		threeColumnContainer.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		threeColumnContainer.setLayoutData(gridData);
		Label label = new Label(threeColumnContainer, SWT.NONE);
		label.setText(Messages.JavaQueryWizardPage_Query_name);
		this.queryNameText = new Text(threeColumnContainer, SWT.BORDER);
		this.queryNameText.setEditable(this.canChangeQueryName);
		this.queryNameText.setLayoutData(gridData);
		if (this.queryName != null) {
			this.queryNameText.setText(this.queryName);
		}
		this.queryNameText.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				updateQueryName();
			}
		});
		Label dummyLabel = new Label(threeColumnContainer, SWT.NONE);
		dummyLabel.setText(""); //$NON-NLS-1$
		Label canBeCachedLabel = new Label(threeColumnContainer, SWT.NONE);
		canBeCachedLabel.setText(Messages.JavaQueryWizardPage_Can_be_cached);
		this.canBeCachedButton = new Button(threeColumnContainer, SWT.CHECK);
		this.canBeCachedButton.setEnabled(this.canChangeCanBeCached);

		Label dummyLabel1 = new Label(threeColumnContainer, SWT.NONE);
		dummyLabel1.setText(""); //$NON-NLS-1$

		Label hasSideEffectLabel = new Label(threeColumnContainer, SWT.NONE);
		hasSideEffectLabel.setText(Messages.JavaQueryWizardPage_has_side_effect);
		this.hasSideEffectButton = new Button(threeColumnContainer, SWT.CHECK);
		this.hasSideEffectButton.setEnabled(this.canChangeHasSideEffect);

		Label dummyLabel2 = new Label(threeColumnContainer, SWT.NONE);
		dummyLabel2.setText(""); //$NON-NLS-1$
		ICompositeEditorFactory<Integer> compositeFactory = ICompositeEditorFactoriesRegistry.INSTANCE
				.getCompositeEditorFactory(Integer.class);

		Label lowerBoundLabel = new Label(threeColumnContainer, SWT.NONE);
		lowerBoundLabel.setText(Messages.Lower_bound);
		this.lowerBoundText = compositeFactory.createCompositeEditor(threeColumnContainer, SWT.BORDER | SWT.SINGLE);
		this.lowerBoundText.setLayoutData(gridData);
		this.lowerBoundText.setEnabled(this.canChangeLowerBound);
		this.lowerBoundText.setValue(Integer.valueOf(1));
		Label dummyLabel3 = new Label(threeColumnContainer, SWT.NONE);
		dummyLabel3.setText(""); //$NON-NLS-1$

		Label upperBoundLabel = new Label(threeColumnContainer, SWT.NONE);
		upperBoundLabel.setText(Messages.Upper_bound);
		this.upperBoundText = compositeFactory.createCompositeEditor(threeColumnContainer, SWT.BORDER | SWT.SINGLE);
		this.upperBoundText.setLayoutData(gridData);
		this.upperBoundText.setEnabled(this.canChangeUpperBound);
		this.upperBoundText.setValue(Integer.valueOf(1));
		Label dummyLabel4 = new Label(threeColumnContainer, SWT.NONE);
		dummyLabel4.setText(""); //$NON-NLS-1$

		// Add the composite provided by extension point for the chosen Query type
		if (this.queryTypeNameToQueryCreationPage != null) {
			this.queryCreationPage = this.queryTypeNameToQueryCreationPage.get(this.queryType);
			if (this.queryCreationPage != null) {
				this.queryCreationPage.completeComposite(threeColumnContainer);
				this.queryCreationPage.setFacetSet(getFacetSet());
				this.queryCreationPage.setQueryType(this.facet.getExtendedMetaclass());
				this.queryCreationPage.setQueryName(this.queryName);
				this.queryCreationPage.addModifyListener(new ModifyListener() {

					public void modifyText(final ModifyEvent e) {
						updateButtons();
					}
				});
			}
		}

		setControl(threeColumnContainer);
	}

	private FacetSet getFacetSet() {
		return this.facetSet;
	}

	public void createControl(final Composite parent) {
		this.parentComposite = new Composite(parent, SWT.NONE);
		this.parentComposite.setLayout(new GridLayout(1, false));
		createControl2(this.parentComposite);
	}

	protected void updateButtons() {
		if (getContainer() != null && getContainer().getCurrentPage() != null) {
			getContainer().updateButtons();
			this.queryNameText.setFocus();
		}
	}

	protected void updateQueryName() {
		if (this.queryNameText != null) {
			this.queryName = this.queryNameText.getText();
			this.queryNameText.setFocus();
		}
	}

	public void setQueryName(final String queryName) {
		this.queryName = queryName;
		if (this.queryNameText != null) {
			this.queryNameText.setText(queryName);
			this.queryNameText.redraw();
		}
	}

	public String getQueryName() {
		return this.queryName;
	}

	public void canChangeUpperBound(final boolean canChange) {
		this.canChangeUpperBound = canChange;
	}

	public void canChangeQueryName(final boolean canChange) {
		this.canChangeQueryName = canChange;
	}

	public void canChangeLowerBound(final boolean canChange) {
		this.canChangeLowerBound = canChange;
	}

	public void canChangeHasSideEffect(final boolean canChange) {
		this.canChangeHasSideEffect = canChange;
	}

	public void canChangeCanBeCached(final boolean canChange) {
		this.canChangeCanBeCached = canChange;
	}

	public boolean getCanBeCached() {
		return this.canBeCachedButton.getSelection();
	}

	public boolean getHasSideEffect() {
		return this.hasSideEffectButton.getSelection();
	}

	public int getLowerBound() {
		return this.lowerBoundText.getValue().intValue();
	}

	public int getUpperBound() {
		return this.upperBoundText.getValue().intValue();
	}

	public IQueryCreationPagePart getQueryCreationPage() {
		return this.queryCreationPage;
	}

	public void setFacetSet(final FacetSet facetSet) {
		this.facetSet = facetSet;
	}
}
