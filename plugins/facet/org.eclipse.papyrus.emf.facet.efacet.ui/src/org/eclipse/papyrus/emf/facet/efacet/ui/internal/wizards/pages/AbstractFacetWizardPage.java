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
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.pages;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.QueryFacetElement;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.composites.SelectETypeComposite;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.composites.SelectETypeComposite.ETypeSelectionOptions;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.composites.SelectQueryTypeComposite;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.core.composite.registries.ICompositeEditorFactoriesRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
// @SuppressWarnings("PMD.ConstructorCallsOverridableMethod") This class is
// deprecated, we won't then spend to many time to conforms to PMD rules.
@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public abstract class AbstractFacetWizardPage extends WizardPage {

	private static final int QUERY_SELECTION_GROUP_COLUMN_NUMBER = 4;
	private static final int NUMBER_COLUMN_PROPERTY = 3;
	protected static final int NUMBER_COLUMN = 3;
	protected static final int VERTICAL_SPACING = 9;

	private ISelection selection;
	private EditingDomain editingDomain;

	// USER PERMISSION
	private boolean canChangeParentName = true;
	private boolean canChangeChildrenName = true;
	private boolean canChangeUpperBound = true;
	private boolean canChangeLowerBound = true;
	private boolean canChangeType = true;
	private final boolean canChangeVolatile = false;
	private final boolean canChangeChangeable = false;
	private final boolean canChangeDerived = false;
	private final boolean canChangeTransient = false;
	private final boolean canChangeOrdered = true;
	private final boolean canChangeUnique = true;
	private boolean canChangeEPackage = true;

	private boolean showUpperBound = true;
	private boolean showLowerBound = true;
	private boolean showParentName = true;
	private boolean showChildrenName = true;
	private boolean showQueryTypeSelection = true;
	private boolean showEType = true;
	private boolean showVolatile = true;
	private boolean showChangeable = true;
	private boolean showDerived = true;
	private boolean showTransient = true;
	private boolean showOrdered = true;
	private boolean showUnique = true;

	// DATA
	private FacetSet facetSet;
	private Facet facet;
	private String facetName;
	private QueryFacetElement queryFacetElement;
	private EClass type;
	private String parentName = ""; //$NON-NLS-1$
	private String childrenName = ""; //$NON-NLS-1$
	private int lowerBound;
	private int upperBound;
	private boolean fVolatile = true;
	private boolean fChangeable = false;
	private boolean fDerived = true;
	private boolean fTransient = true;
	private boolean fOrdered = false;
	private boolean fUnique = false;

	// COMPOSITE
	private Label parentNameLabel;
	private Label childrenNameLabel;
	private Label lowerBoundLabel;
	private Label upperBoundLabel;
	private SelectETypeComposite selectETypeComposite;
	private Text parentNameTextField;
	private Text childrenNameTextField;
	private AbstractCellEditorComposite<Integer> lowerBoundTextField;
	private AbstractCellEditorComposite<Integer> upperBoundTextField;
	private SelectQueryTypeComposite selectQueryTypeComposite;
	private Button subClassingQueryButton;

	private Map<String, IQueryCreationPagePart> queryTypeNameToWizardPage;
	private boolean wizardNeedsQuery = true;
	private ETypeSelectionOptions eTypeSelectionOption;

	public AbstractFacetWizardPage(final ISelection selection, final EditingDomain editingDomain,
			final Map<String, IQueryCreationPagePart> queryTypeNameToWizardPage,
			final ETypeSelectionOptions eTypeSelectionOption) {
		this(selection, editingDomain);
		this.queryTypeNameToWizardPage = queryTypeNameToWizardPage;
		this.eTypeSelectionOption = eTypeSelectionOption;
	}

	public AbstractFacetWizardPage(final ISelection selection, final EditingDomain editingDomain) {
		super("whatever"); //$NON-NLS-1$
		this.selection = selection;
		this.editingDomain = editingDomain;
		initializeWithSelection();
	}

	@Override
	public void setVisible(final boolean visible) {
		updatePageButtons();
		super.setVisible(visible);
	}

	protected Composite createControlParts(final Composite parent) {

		final Composite threeColumnContainer = new Composite(parent, SWT.NONE);
		GridLayout layout3Column = new GridLayout(AbstractFacetWizardPage.NUMBER_COLUMN, false);
		threeColumnContainer.setLayout(layout3Column);
		GridData fillGridData = new GridData(GridData.FILL_HORIZONTAL);

		threeColumnContainer.setLayoutData(fillGridData);

		if (this.showParentName) {
			this.parentNameLabel = new Label(threeColumnContainer, SWT.NONE);
			this.parentNameTextField = new Text(threeColumnContainer, SWT.BORDER | SWT.SINGLE);
			this.parentNameTextField.setText(this.parentName);
			this.parentNameTextField.setEnabled(this.canChangeParentName);
			this.parentNameTextField.setLayoutData(fillGridData);
			this.parentNameTextField.addModifyListener(new ModifyListener() {
				public void modifyText(final ModifyEvent e) {
					setParentName(((Text) e.getSource()).getText(), false);
					updatePageButtons();
				}
			});
			Label dummyLabel = new Label(threeColumnContainer, SWT.NONE);
			dummyLabel.setText(""); //$NON-NLS-1$
		}

		if (this.showChildrenName) {
			this.childrenNameLabel = new Label(threeColumnContainer, SWT.NONE);
			this.childrenNameTextField = new Text(threeColumnContainer, SWT.BORDER | SWT.SINGLE);
			this.childrenNameTextField.setText(this.childrenName);
			this.childrenNameTextField.setEnabled(canChangeChildrenName());
			this.childrenNameTextField.setLayoutData(fillGridData);
			this.childrenNameTextField.addModifyListener(new ModifyListener() {
				public void modifyText(final ModifyEvent e) {
					setChildrenName(((Text) e.getSource()).getText());
					updatePageButtons();
				}
			});
			Label dummyLabel2 = new Label(threeColumnContainer, SWT.NONE);
			dummyLabel2.setText(""); //$NON-NLS-1$
		}
		ICompositeEditorFactory<Integer> compositeFactory = ICompositeEditorFactoriesRegistry.INSTANCE
				.getCompositeEditorFactory(Integer.class);
		if (this.showLowerBound) {
			this.lowerBoundLabel = new Label(threeColumnContainer, SWT.NONE);
			this.lowerBoundTextField = compositeFactory.createCompositeEditor(threeColumnContainer, SWT.BORDER
					| SWT.SINGLE);
			this.lowerBoundTextField.setLayoutData(fillGridData);
			this.lowerBoundTextField.setEnabled(canChangeLowerBound());
			setLowerBound(this.lowerBound);
			Label dummyLabel5 = new Label(threeColumnContainer, SWT.NONE);
			dummyLabel5.setText(""); //$NON-NLS-1$
		}
		if (this.showUpperBound) {
			this.upperBoundLabel = new Label(threeColumnContainer, SWT.NONE);
			this.upperBoundTextField = compositeFactory.createCompositeEditor(threeColumnContainer, SWT.BORDER
					| SWT.SINGLE);
			this.upperBoundTextField.setLayoutData(fillGridData);
			this.upperBoundTextField.setEnabled(this.canChangeUpperBound);
			setUpperBound(this.upperBound);
			Label dummyLabel6 = new Label(threeColumnContainer, SWT.NONE);
			dummyLabel6.setText(""); //$NON-NLS-1$
		}
		if (this.showEType) {
			this.selectETypeComposite = new SelectETypeComposite(parent, SWT.NONE, this.eTypeSelectionOption,
					this.canChangeEPackage, this.facetSet) {
				@Override
				protected void createCompositeWidget() {
					setETypeLabel(new Label(threeColumnContainer, SWT.NULL));
					setETypedTextField(new Text(threeColumnContainer, SWT.BORDER | SWT.SINGLE | SWT.READ_ONLY));
					setSelectButton(new Button(threeColumnContainer, SWT.PUSH));
				}

				@Override
				protected void eTypeSelected() {
					updatePageButtons();
				}
			};
			if (this.type != null) {
				this.selectETypeComposite.setEType(this.type);
			}
			this.selectETypeComposite.setEditingDomain(getEditingDomain());
			this.selectETypeComposite.canChangeEType(this.canChangeType);
		}

		createPropertyControls(threeColumnContainer);

		if (this.wizardNeedsQuery) {
			createQueryComposite(parent, threeColumnContainer);
		}
		return threeColumnContainer;
	}

	/**
	 * @param parent
	 * @param threeColumnContainer
	 */
	protected void createQueryComposite(final Composite parent, final Composite threeColumnContainer) {
		if (this.showQueryTypeSelection) {
			final Group group = new Group(threeColumnContainer, SWT.SHADOW_ETCHED_OUT);
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, AbstractFacetWizardPage.NUMBER_COLUMN, 1));
			group.setLayout(new GridLayout(AbstractFacetWizardPage.QUERY_SELECTION_GROUP_COLUMN_NUMBER, false));
			Label subClassingQueryButtonText = new Label(group, SWT.NONE);
			subClassingQueryButtonText.setText(Messages.CreateFacetInFacetSetWizardPage_Sub_Typing_Facet);

			this.subClassingQueryButton = new Button(group, SWT.CHECK);
			this.subClassingQueryButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			this.subClassingQueryButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(final SelectionEvent e) {
					setQueryTypeSelectionVisible(getSubClassingQueryButton().getSelection());
					updatePageButtons();
				}

				public void widgetDefaultSelected(final SelectionEvent e) {
					// nothing
				}
			});

			// Query Type Composite
			this.selectQueryTypeComposite = new SelectQueryTypeComposite(parent, SWT.NONE) {
				@Override
				protected void createCompositeWidget() {
					setQueryTypeLabel(new Label(group, SWT.NONE));
					setQueryTypeComboBox(new Combo(group, SWT.DROP_DOWN));
				}

				@Override
				protected void queryTypeSelected() {
					updatePageButtons();
				}
			};

			setQueryTypeSelectionVisible(false);
		} else {
			// Query Type Composite
			this.selectQueryTypeComposite = new SelectQueryTypeComposite(parent, SWT.NONE) {
				@Override
				protected void createCompositeWidget() {
					setQueryTypeLabel(new Label(threeColumnContainer, SWT.NONE));
					setQueryTypeComboBox(new Combo(threeColumnContainer, SWT.DROP_DOWN | SWT.READ_ONLY));
				}

				@Override
				protected void queryTypeSelected() {
					updatePageButtons();
				}
			};
		}
	}

	/**
	 * @param threeColumnContainer
	 */
	protected void createPropertyControls(final Composite threeColumnContainer) {
		Label dummyLabel = new Label(threeColumnContainer, SWT.NONE);
		dummyLabel.setText(""); //$NON-NLS-1$
		Composite composite = new Composite(threeColumnContainer, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = AbstractFacetWizardPage.NUMBER_COLUMN_PROPERTY;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		if (this.showVolatile) {
			final Button button = new Button(composite, SWT.CHECK);
			button.setText(Messages.Volatile);
			button.setEnabled(this.canChangeVolatile);
			button.setSelection(this.fVolatile);
			button.addSelectionListener(new SelectionListener() {
				public void widgetSelected(final SelectionEvent e) {
					setVolatile(button.getSelection());
				}

				public void widgetDefaultSelected(final SelectionEvent e) {
					// Nothing
				}
			});
		}
		if (this.showChangeable) {
			final Button button = new Button(composite, SWT.CHECK);
			button.setText(Messages.Changeable);
			button.setSelection(this.fChangeable);
			button.setEnabled(this.canChangeChangeable);
			button.addSelectionListener(new SelectionListener() {
				public void widgetSelected(final SelectionEvent e) {
					setChangeable(button.getSelection());
				}

				public void widgetDefaultSelected(final SelectionEvent e) {
					// Nothing
				}
			});
		}
		if (this.showDerived) {
			final Button button = new Button(composite, SWT.CHECK);
			button.setText(Messages.Derived);
			button.setEnabled(this.canChangeDerived);
			button.setSelection(this.fDerived);
			button.addSelectionListener(new SelectionListener() {
				public void widgetSelected(final SelectionEvent e) {
					setDerived(button.getSelection());
				}

				public void widgetDefaultSelected(final SelectionEvent e) {
					// Nothing
				}
			});
		}
		if (this.showTransient) {
			final Button button = new Button(composite, SWT.CHECK);
			button.setText(Messages.Transient);
			button.setEnabled(this.canChangeTransient);
			button.setSelection(this.fTransient);
			button.addSelectionListener(new SelectionListener() {
				public void widgetSelected(final SelectionEvent e) {
					setTransient(button.getSelection());
				}

				public void widgetDefaultSelected(final SelectionEvent e) {
					// Nothing
				}
			});
		}
		if (this.showOrdered) {
			final Button button = new Button(composite, SWT.CHECK);
			button.setText(Messages.Ordered);
			button.setSelection(this.fOrdered);
			button.setEnabled(this.canChangeOrdered);
			button.addSelectionListener(new SelectionListener() {
				public void widgetSelected(final SelectionEvent e) {
					setOrdered(button.getSelection());
				}

				public void widgetDefaultSelected(final SelectionEvent e) {
					// Nothing
				}
			});
		}
		if (this.showUnique) {
			final Button button = new Button(composite, SWT.CHECK);
			button.setText(Messages.Unique);
			button.setSelection(this.fUnique);
			button.setEnabled(this.canChangeUnique);
			button.addSelectionListener(new SelectionListener() {
				public void widgetSelected(final SelectionEvent e) {
					setUnique(button.getSelection());
				}

				public void widgetDefaultSelected(final SelectionEvent e) {
					// Nothing
				}
			});
		}
	}

	public boolean isSubTypingFacet() {
		if (getSubClassingQueryButton() == null) {
			return true;
		}
		return getSubClassingQueryButton().getSelection();
	}

	protected void initializeWithSelection() {
		if (getSelection() != null && !getSelection().isEmpty() && getSelection() instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) getSelection();
			if (ssel.size() > 1) {
				return;
			}
			Object obj = ssel.getFirstElement();
			if (obj instanceof Facet) {
				setFacet((Facet) obj);
				setFacetSet(((Facet) obj).getFacetSet());
				if (((Facet) obj).getName() != null) {
					setParentName(((Facet) obj).getName(), true);
				}
			}
		}
	}

	@Override
	public IWizardPage getNextPage() {
		if (this.showQueryTypeSelection) {
			if (this.queryTypeNameToWizardPage != null && this.subClassingQueryButton != null) {
				if (this.subClassingQueryButton.getSelection()) {
					IQueryCreationPagePart wizard = this.queryTypeNameToWizardPage.get(getSelectedQueryType());
					if (wizard != null) {
						return super.getNextPage();
					}
					setErrorMessage(Messages.SelectQueryTypeWizardPage_No_wizard_found);
				}
			}
		} else {
			if (this.queryTypeNameToWizardPage != null) {
				IQueryCreationPagePart wizard = this.queryTypeNameToWizardPage.get(getSelectedQueryType());
				if (wizard != null) {
					return super.getNextPage();
				}
				setErrorMessage(Messages.SelectQueryTypeWizardPage_No_wizard_found);
			}
		}
		return null;
	}

	@Override
	protected void setControl(final Control newControl) {
		updatePageButtons();
		super.setControl(newControl);
	}

	protected void setQueryTypeSelectionVisible(final boolean visible) {
		this.selectQueryTypeComposite.setEnabled(visible);
	}

	public String getSelectedQueryType() {
		return this.selectQueryTypeComposite.getSelectedQueryType();
	}

	protected void updatePageButtons() {
		if (getContainer() != null && getContainer().getCurrentPage() != null) {
			getContainer().updateButtons();
		}
	}

	public void initializeTextContent(final String parentName2, final String childrenName2) {
		if (parentName2 != null) {
			this.parentNameLabel.setText(parentName2);
		}
		this.childrenNameLabel.setText(childrenName2);
		if (this.showLowerBound) {
			this.lowerBoundLabel.setText(Messages.Lower_bound);
		}
		if (this.showUpperBound) {
			this.upperBoundLabel.setText(Messages.Upper_bound);
		}
	}

	@Override
	public boolean isPageComplete() {
		if (getChildrenName() == null) {
			return false;
		}
		if (this.showChildrenName && getChildrenName().length() == 0) {
			setErrorMessage(NLS.bind(Messages.Please_enter_value_for, this.childrenNameLabel.getText()));
			return false;
		}
		if (this.showLowerBound && this.lowerBoundTextField.getValue() == null) {
			setErrorMessage(NLS.bind(Messages.Please_enter_value_for, this.lowerBoundLabel.getText()));
			return false;
		}
		if (this.showUpperBound && this.upperBoundTextField.getValue() == null) {
			setErrorMessage(NLS.bind(Messages.Please_enter_value_for, this.upperBoundLabel.getText()));
			return false;
		}
		if (this.showEType && getType() == null) {
			setErrorMessage(NLS.bind(Messages.Please_enter_value_for, "Type")); //$NON-NLS-1$
			return false;
		}
		if (this.wizardNeedsQuery) {
			if (this.subClassingQueryButton != null && !this.subClassingQueryButton.getSelection()) {
				setErrorMessage(null);
				return true;
			}
			if (getNextPage() == null) {
				setErrorMessage(Messages.CreateFacetInFacetSetWizardPage_could_not_find_wizard_page);
				return false;
			}
		}
		setErrorMessage(null);
		return true;
	}

	// CanChange section
	public void canChangeParentName(final boolean canChange) {
		this.canChangeParentName = canChange;
	}

	public boolean canChangeParentName() {
		return this.canChangeParentName;
	}

	public void canChangeChildrenName(final boolean canChange) {
		this.canChangeChildrenName = canChange;
	}

	public boolean canChangeChildrenName() {
		return this.canChangeChildrenName;
	}

	public void canChangeUpperBound(final boolean canChange) {
		this.canChangeUpperBound = canChange;
	}

	public boolean canChangeUpperBound() {
		return this.canChangeUpperBound;
	}

	public void canChangeLowerBound(final boolean canChange) {
		this.canChangeLowerBound = canChange;
	}

	public boolean canChangeLowerBound() {
		return this.canChangeLowerBound;
	}

	public void canChangeType(final boolean canChange) {
		this.canChangeType = canChange;
	}

	public boolean canChangeType() {
		return this.canChangeType;
	}

	public void canChangeEPackage(final boolean canChangeEPackage2) {
		this.canChangeEPackage = canChangeEPackage2;
	}

	public EditingDomain getEditingDomain() {
		return this.editingDomain;
	}

	public void setEditingDomain(final EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	public final ISelection getSelection() {
		return this.selection;
	}

	public void setSelection(final ISelection selection) {
		this.selection = selection;
	}

	public final FacetSet getFacetSet() {
		return this.facetSet;
	}

	public final void setFacetSet(final FacetSet facetSet) {
		this.facetSet = facetSet;
	}

	public Facet getFacet() {
		return this.facet;
	}

	public final void setFacet(final Facet facet) {
		this.facet = facet;
	}

	public String getFacetName() {
		return this.facetName;
	}

	public void setFacetName(final String facetName) {
		this.facetName = facetName;
	}

	public int getLowerBound() {
		try {
			return (this.lowerBoundTextField.getValue()).intValue();
		} catch (Exception e) {
			Logger.logError(e, Activator.getDefault());
		}
		return 0;
	}

	public void setLowerBound(final int lowerBound) {
		this.lowerBound = lowerBound;
		if (this.lowerBoundTextField != null) {
			(this.lowerBoundTextField).setValue(Integer.valueOf(lowerBound));
		}
	}

	public int getUpperBound() {
		try {
			return (this.upperBoundTextField.getValue()).intValue();
		} catch (Exception e) {
			Logger.logError(e, Activator.getDefault());
		}
		return 0;
	}

	public void setUpperBound(final int upperBound) {
		this.upperBound = upperBound;
		if (this.upperBoundTextField != null) {
			this.upperBoundTextField.setValue(Integer.valueOf(upperBound));
		}
	}

	public EClassifier getType() {
		return this.selectETypeComposite.getEType();
	}

	public void setType(final EClass eType) {
		this.type = eType;
		if (this.selectETypeComposite != null) {
			this.selectETypeComposite.setEType(eType);
		}
	}

	public String getParentName() {
		return this.parentName;
	}

	/**
	 * Set the parent(container) name
	 * 
	 * @param parentName
	 *            the new parent's name
	 * @param updateTextField
	 *            whether to update the corresponding textField
	 */
	public final void setParentName(final String parentName2, final boolean updateTextField) {
		this.parentName = parentName2;
		if (this.parentNameTextField != null) {
			if (updateTextField) {
				this.parentNameTextField.setText(parentName2);
			}
		}
	}

	public String getChildrenName() {
		return this.childrenName;
	}

	public void setChildrenName(final String childrenName) {
		this.childrenName = childrenName;
	}

	public Button getSubClassingQueryButton() {
		return this.subClassingQueryButton;
	}

	public void showUpperBound(final boolean showUpperBound2) {
		this.showUpperBound = showUpperBound2;
	}

	public void showLowerBound(final boolean showLOwerBound2) {
		this.showLowerBound = showLOwerBound2;
	}

	public void showParentName(final boolean showParentName2) {
		this.showParentName = showParentName2;
	}

	public void showChildrenName(final boolean showChildrenName2) {
		this.showChildrenName = showChildrenName2;
	}

	public void showQueryTypeSelection(final boolean showQueryTypeSelection2) {
		this.showQueryTypeSelection = showQueryTypeSelection2;
	}

	public void showEType(final boolean showEType2) {
		this.showEType = showEType2;
	}

	public boolean isVolatile() {
		return this.fVolatile;
	}

	public void showVolatile(final boolean fVolatile1) {
		this.showVolatile = fVolatile1;
	}

	public boolean isChangeable() {
		return this.fChangeable;
	}

	public void showChangeable(final boolean fChangeable1) {
		this.showChangeable = fChangeable1;
	}

	public boolean isDerived() {
		return this.fDerived;
	}

	public void showDerived(final boolean fDerived1) {
		this.showDerived = fDerived1;
	}

	public boolean isTransient() {
		return this.fTransient;
	}

	public void showTransient(final boolean fTransient1) {
		this.showTransient = fTransient1;
	}

	public boolean isOrdered() {
		return this.fOrdered;
	}

	public void showOrdered(final boolean fOrdered1) {
		this.showOrdered = fOrdered1;
	}

	public boolean isUnique() {
		return this.fUnique;
	}

	public void showUnique(final boolean fUnique1) {
		this.showUnique = fUnique1;
	}

	public void setVolatile(final boolean fVolatile2) {
		this.fVolatile = fVolatile2;
	}

	public void setChangeable(final boolean fChangeable2) {
		this.fChangeable = fChangeable2;
	}

	public void setDerived(final boolean fDerived2) {
		this.fDerived = fDerived2;
	}

	public void setTransient(final boolean fTransient2) {
		this.fTransient = fTransient2;
	}

	public void setOrdered(final boolean ordered) {
		this.fOrdered = ordered;
	}

	public void setUnique(final boolean fUnique2) {
		this.fUnique = fUnique2;
	}

	public void setWizardNeedsQuery(final boolean wizardNeedsQuery) {
		this.wizardNeedsQuery = wizardNeedsQuery;
	}

	public QueryFacetElement getQueryFacetElement() {
		return this.queryFacetElement;
	}

	public void setQueryFacetElement(final QueryFacetElement queryFacetElement) {
		this.queryFacetElement = queryFacetElement;
	}
}
