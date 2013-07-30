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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ICheckable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.context.EObjectContext;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerListener;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.console.xtfo.EmbeddedXtextEditor;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocument;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLPlugin;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.CheckBoxFilteredTree;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.actions.ReplaceAction;
import org.eclipse.papyrus.uml.search.ui.providers.OCLContextContentProvider;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeAttribute;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeContentProvider;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeElement;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeLabelProvider;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.query.PapyrusAdvancedQuery;
import org.eclipse.papyrus.uml.search.ui.query.PapyrusOCLQuery;
import org.eclipse.papyrus.uml.search.ui.query.PapyrusQuery;
import org.eclipse.papyrus.uml.stereotypecollector.StereotypeCollector;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
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
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

/**
 * 
 * Papyrus specific search page
 * 
 */
public class PapyrusSearchPage extends DialogPage implements ISearchPage, IReplacePage, MetaModelManagerListener {

	public PapyrusSearchPage() {
	}


	private HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>> participantsList = new HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>>();

	private ArrayList<ParticipantTypeElement> result = new ArrayList<ParticipantTypeElement>();

	private Collection<Stereotype> availableStereotypes;

	private static final String REGULAR_EXPRESSION_ILLFORMED = Messages.PapyrusSearchPage_0;

	private static final String OCL_QUERY_ILLFORMED = Messages.PapyrusSearchPage_0;

	private static final String SEARCH_ISSUE = Messages.PapyrusSearchPage_1;

	private static final String SEARCH_IN_ALL_STRINGS = Messages.PapyrusSearchPage_2;

	private static final String SEARCH_IN_STEREOTYPE_ATTRIBUTES = Messages.PapyrusSearchPage_3;

	private Text searchQueryText;

	private Text oclContext;

	private ISearchPageContainer container;

	private CheckBoxFilteredTree participantTypesTree;

	private CheckboxTreeViewer participantTypesTreeViewer;

	private Label searchQueryExplanatoryLabel;

	private Button btnRegularExpression;

	private Button btnCaseSensitive;


	private Button btnSearchAllStringAttributes;

	private Button btnSearchInName;

	private Combo queryKind;

	private Combo searchKind;

	private EmbeddedXtextEditor oclEditor;

	private Composite queryComposite;

	private EObject contextObject;

	private static final int TEXT_QUERY_KIND = 0;

	private static final int OCL_QUERY_KIND = 1;

	private static final int SIMPLE_SEARCH = 0;

	private static final int ADVANCED_SEARCH = 1;

	private ParserContext parserContext;

	private MetaModelManager nullMetaModelManager = null;

	private DomainModelManager modelManager = null;

	protected Composite textQueryComposite;

	protected Composite textQueryComposite2;



	private Composite advancedSearchComposite;

	protected Group grpSearchFor;

	private Composite textQueryFieldsComposite;

	protected Set<EObject> umlMetaClasses = new HashSet<EObject>();

	protected ParticipantTypeContentProvider participantTypeContentProvider = new ParticipantTypeContentProvider();




	protected void createSimpleSearchQueryField() {

		textQueryComposite = new Composite(queryComposite, SWT.NONE);
		textQueryComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		textQueryComposite.setLayout(new GridLayout(2, false));

		textQueryFieldsComposite = new Composite(textQueryComposite, SWT.NONE);
		textQueryFieldsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		textQueryFieldsComposite.setLayout(new GridLayout(1, false));

		searchQueryText = new Text(textQueryFieldsComposite, SWT.BORDER);
		searchQueryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		searchQueryText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				validateRegex();
			}
		});
		searchQueryText.setFocus();

		searchQueryExplanatoryLabel = new Label(textQueryFieldsComposite, SWT.NONE);
		searchQueryExplanatoryLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));


		Composite compositeParameters = new Composite(textQueryComposite, SWT.NONE);
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



		grpSearchFor = new Group(textQueryComposite, SWT.NONE);
		grpSearchFor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		grpSearchFor.setLayout(new GridLayout(1, false));
		grpSearchFor.setText(Messages.PapyrusSearchPage_8);

		Composite groupComposite = new Composite(grpSearchFor, SWT.NONE);
		groupComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		groupComposite.setLayout(new GridLayout(2, false));

		Label lblSearchKind = new Label(groupComposite, SWT.NONE);
		lblSearchKind.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblSearchKind.setText(Messages.PapyrusSearchPage_7);

		searchKind = new Combo(groupComposite, SWT.VERTICAL | SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		searchKind.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		searchKind.add(Messages.PapyrusSearchPage_11);
		searchKind.add(Messages.PapyrusSearchPage_12);
		searchKind.select(SIMPLE_SEARCH);
		searchKind.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				for(Control childControl : advancedSearchComposite.getChildren()) {
					childControl.dispose();
				}

				if(searchKind.getSelectionIndex() == ADVANCED_SEARCH) {
					if(participantsList.size() == 0) {
						createResultList();
					}
					createAdvancedSearch();
				} else {
					simpleSearch();
				}
				advancedSearchComposite.layout();
			}
		});

		advancedSearchComposite = new Composite(groupComposite, SWT.NONE);
		//		gd_advancedSearchComposite.widthHint = 479;
		advancedSearchComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		advancedSearchComposite.setLayout(new GridLayout(2, false));

		simpleSearch();



	}

	protected void createResultList() {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(getShell());
		IRunnableWithProgress computeAvailableTypes = new IRunnableWithProgress() {

			public void run(IProgressMonitor thePM) throws InterruptedException {

				//UML metaclasses
				for(EClassifier eClassifier : UMLPackage.eINSTANCE.getEClassifiers()) {
					if(eClassifier instanceof EClass) {
						ParticipantTypeElement parentElement = new ParticipantTypeElement(eClassifier);
						if(parentElement.getElement() instanceof EClass) {
							List<ParticipantTypeAttribute> attributeList = new ArrayList<ParticipantTypeAttribute>();
							for(EObject eAttribute : ((EClass)(parentElement).getElement()).getEAllAttributes()) {
								ParticipantTypeAttribute attribute = new ParticipantTypeAttribute(eAttribute, ((ParticipantTypeElement)parentElement));
								attributeList.add(attribute);


							}
							participantsList.put(parentElement, attributeList);
						}
					}
				}


				//Find available stereotypes
				availableStereotypes = StereotypeCollector.getInstance().computeAvailableStereotypes(container);
				for(Stereotype stereotype : availableStereotypes) {
					ParticipantTypeElement parentElement = new ParticipantTypeElement(stereotype);
					List<ParticipantTypeAttribute> attributeList = new ArrayList<ParticipantTypeAttribute>();
					for(Property property : ((Stereotype)((ParticipantTypeElement)parentElement).getElement()).getAllAttributes()) {
						if(!property.getName().startsWith("base_")) { //$NON-NLS-1$
							if(property.getType() instanceof Element) {
								if(UMLUtil.isBoolean(property.getType()) || UMLUtil.isString(property.getType()) || UMLUtil.isInteger(property.getType()) || UMLUtil.isReal(property.getType()) || UMLUtil.isUnlimitedNatural(property.getType()) || property.getType() instanceof Enumeration) {
									ParticipantTypeAttribute attribute = new ParticipantTypeAttribute(property, (ParticipantTypeElement)parentElement);
									attributeList.add(attribute);
								}

							}
						}

					}
					boolean test = ((Stereotype)parentElement.getElement()).isAbstract();
					participantsList.put(parentElement, attributeList);


				}


			}

		};

		try {
			dialog.run(true, true, computeAvailableTypes);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	protected void createAdvancedSearch() {




		participantTypesTree = new CheckBoxFilteredTree(advancedSearchComposite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.SINGLE, new PatternFilter(), true);
		participantTypesTree.setLayout(new GridLayout());
		GridData chechboxTreeViewerGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		chechboxTreeViewerGridData.heightHint = 150;
		participantTypesTree.setLayoutData(chechboxTreeViewerGridData);

		participantTypesTreeViewer = (CheckboxTreeViewer)participantTypesTree.getViewer();
		participantTypesTreeViewer.setContentProvider(participantTypeContentProvider);
		participantTypesTreeViewer.setLabelProvider(new ParticipantTypeLabelProvider());
		participantTypesTreeViewer.setSorter(new ViewerSorter());
		participantTypesTreeViewer.setCheckStateProvider(new ICheckStateProvider() {

			public boolean isGrayed(Object element) {
				return false;
			}

			public boolean isChecked(Object element) {
				if(element instanceof ParticipantTypeElement) {

					return ((ParticipantTypeElement)element).isChecked();

				}
				return false;
			}
		});
		Composite participantManipualtionComposite = new Composite(advancedSearchComposite, SWT.NONE);
		participantManipualtionComposite.setLayout(new GridLayout(1, false));
		participantManipualtionComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));




		Button btnSelectSub = new Button(participantManipualtionComposite, SWT.PUSH);
		btnSelectSub.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSelectSub.setText(Messages.PapyrusSearchPage_14);
		btnSelectSub.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = participantTypesTreeViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					Object selectedElement = ((IStructuredSelection)selection).getFirstElement();

					if(selectedElement instanceof ParticipantTypeElement) {
						List<ParticipantTypeAttribute> attributeParentList = new ArrayList<ParticipantTypeAttribute>();

						for(Object attribute : participantsList.get(selectedElement)) {
							if(attribute instanceof ParticipantTypeAttribute) {
								if(((ParticipantTypeAttribute)attribute).isChecked()) {
									attributeParentList.add(((ParticipantTypeAttribute)attribute));
								}

							}
						}
						if(((ParticipantTypeElement)selectedElement).getElement() instanceof EClass) {

							selectAllSubUML((ParticipantTypeElement)selectedElement, attributeParentList);

						} else if(((ParticipantTypeElement)selectedElement).getElement() instanceof Stereotype) {

							selectAllSubSter((ParticipantTypeElement)selectedElement, attributeParentList);

						}
					}
				}

				participantTypesTreeViewer.refresh();
			}
		});

		Button btnSelectAll = new Button(participantManipualtionComposite, SWT.PUSH);
		btnSelectAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSelectAll.setText(Messages.PapyrusSearchPage_9);

		btnSelectAll.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				for(ParticipantTypeElement element : participantsList.keySet()) {
					if(!element.isChecked()) {
						element.setChecked(true);

						for(ParticipantTypeAttribute attribute : participantsList.get(element)) {
							attribute.setChecked(true);

						}
					}
				}
				participantTypesTreeViewer.refresh();

			}
		});

		Button btnDeselectAll = new Button(participantManipualtionComposite, SWT.PUSH);
		btnDeselectAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnDeselectAll.setText(Messages.PapyrusSearchPage_10);
		btnDeselectAll.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				for(ParticipantTypeElement element : participantsList.keySet()) {
					if(element.isChecked()) {
						element.setChecked(false);

						for(ParticipantTypeAttribute attribute : participantsList.get(element)) {
							attribute.setChecked(false);


						}
					}
				}
				participantTypesTreeViewer.refresh();
			}
		});


		Button btnRefreshTypes = new Button(participantManipualtionComposite, SWT.PUSH);
		btnRefreshTypes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnRefreshTypes.setText(Messages.PapyrusSearchPage_15);
		btnRefreshTypes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {

				createAdvancedSearch();

			}
		});


		participantTypesTreeViewer.setInput(participantsList);

		//		participantTypesTreeViewer.setAllChecked(true);
		((ICheckable)participantTypesTreeViewer).addCheckStateListener(new ICheckStateListener() {


			public void checkStateChanged(CheckStateChangedEvent event) {
				if(event.getElement() instanceof ParticipantTypeElement) {


					// If the item is checked . . .
					if(event.getChecked()) {
						Object selectedElement = event.getElement();

						((ParticipantTypeElement)selectedElement).setChecked(true);
						participantTypesTreeViewer.refresh(selectedElement);

						if(selectedElement instanceof ParticipantTypeAttribute) {
							ParticipantTypeElement parent = ((ParticipantTypeAttribute)selectedElement).getParent();
							if(parent != null) {
								//								participantTypesTreeViewer.setChecked(parent, true);
								((ParticipantTypeElement)parent).setChecked(true);
								participantTypesTreeViewer.refresh(parent);
							}
						}
					} else {
						Object selectedElement = event.getElement();
						((ParticipantTypeElement)selectedElement).setChecked(false);
						participantTypesTreeViewer.refresh(selectedElement);

						if(((ParticipantTypeElement)selectedElement).getElement() instanceof Stereotype || ((ParticipantTypeElement)selectedElement).getElement() instanceof EClassImpl) {
							for(Object attribute : participantTypesTreeViewer.getCheckedElements()) {
								if(attribute instanceof ParticipantTypeAttribute) {
									if(((ParticipantTypeAttribute)attribute).getParent().equals(selectedElement)) {
										//										participantTypesTreeViewer.setChecked(attribute, false);
										((ParticipantTypeElement)attribute).setChecked(false);
										participantTypesTreeViewer.refresh(attribute);
									}
								}
							}
						}
					}
				}


			}
		});
	}

	protected void selectAllSubSter(final ParticipantTypeElement elementParent, final List<ParticipantTypeAttribute> attributeParentList) {
		//		for(Object element : result) {
		//			if(element instanceof Stereotype) {
		//				List<Class> superTypes = ((Stereotype)element).getSuperClasses();
		//				for(Class type : superTypes) {
		//					((Stereotype)elementParent).getName();
		//
		//					if(((Class)type).getName().equals(((Stereotype)elementParent).getName())) {
		//						participantTypesTreeViewer.setChecked(element, true);
		//
		//					}
		//				}
		//			}
		//		}
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(getShell());
		IRunnableWithProgress computeAvailableTypes = new IRunnableWithProgress() {

			public void run(IProgressMonitor thePM) throws InterruptedException {
				for(Object element : participantsList.keySet()) {
					if(element instanceof ParticipantTypeElement) {
						if(((ParticipantTypeElement)element).getElement() instanceof Stereotype) {
							List<Class> superTypes = ((Class)((ParticipantTypeElement)element).getElement()).getSuperClasses();

							if(superTypes.contains(elementParent.getElement())) {
								//					participantTypesTreeViewer.setChecked(element, true);
								((ParticipantTypeElement)element).setChecked(true);


								//Proceed with attributes 
								for(ParticipantTypeAttribute attributeParent : attributeParentList) {
									for(ParticipantTypeAttribute attributeToEvaluate : participantsList.get(element)) {
										if(attributeParent.getElement() == attributeToEvaluate.getElement()) {

											attributeToEvaluate.setChecked(true);


										}

									}
								}
							}
						}
					}
				}


			}

		};

		try {
			dialog.run(true, true, computeAvailableTypes);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	protected void selectAllSubUML(final ParticipantTypeElement elementParent, final List<ParticipantTypeAttribute> attributeParentList) {

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(getShell());
		IRunnableWithProgress computeAvailableTypes = new IRunnableWithProgress() {

			public void run(IProgressMonitor thePM) throws InterruptedException {
				for(Object element : participantsList.keySet()) {
					if(element instanceof ParticipantTypeElement) {
						if(((ParticipantTypeElement)element).getElement() instanceof EClass) {
							List<EClass> superTypes = ((EClass)((ParticipantTypeElement)element).getElement()).getEAllSuperTypes();

							if(superTypes.contains(elementParent.getElement())) {
								//					participantTypesTreeViewer.setChecked(element, true);
								((ParticipantTypeElement)element).setChecked(true);


								//Proceed with attributes 
								for(ParticipantTypeAttribute attributeParent : attributeParentList) {
									for(ParticipantTypeAttribute attributeToEvaluate : participantsList.get(element)) {
										if(attributeParent.getElement() == attributeToEvaluate.getElement()) {

											attributeToEvaluate.setChecked(true);


										}

									}
								}
							}
						}
					}
				}


			}

		};

		try {
			dialog.run(true, true, computeAvailableTypes);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}





		//		for(Object element : participantsList.keySet()) {
		//			if(element instanceof ParticipantTypeElement) {
		//				if(((ParticipantTypeElement)element).getElement() instanceof EClass) {
		//					List<EClass> superTypes = ((EClass)((ParticipantTypeElement)element).getElement()).getEAllSuperTypes();
		//
		//					if(superTypes.contains(elementParent.getElement())) {
		//						//					participantTypesTreeViewer.setChecked(element, true);
		//						((ParticipantTypeElement)element).setChecked(true);
		//
		//						//Proceed with attributes 
		//						for(ParticipantTypeAttribute attributeParent : attributeParentList) {
		//							for(ParticipantTypeAttribute attributeToEvaluate : participantsList.get(element)) {
		//								if(attributeParent.getElement() == attributeToEvaluate.getElement()) {
		//
		//									attributeToEvaluate.setChecked(true);
		//
		//
		//								}
		//
		//							}
		//						}
		//					}
		//				}
		//			}
		//		}
		//		
	}


	protected void simpleSearch() {


		Composite participantManipualtionComposite = new Composite(advancedSearchComposite, SWT.NONE);
		participantManipualtionComposite.setLayout(new GridLayout(1, false));
		participantManipualtionComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 1, 1));


		btnSearchInName = new Button(participantManipualtionComposite, SWT.RADIO);
		btnSearchInName.setText(Messages.PapyrusSearchPage_16);
		btnSearchInName.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 0, 1));
		btnSearchInName.setSelection(true);


		btnSearchAllStringAttributes = new Button(participantManipualtionComposite, SWT.RADIO);
		btnSearchAllStringAttributes.setText(Messages.PapyrusSearchPage_17);
		btnSearchAllStringAttributes.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
	}

	public void initMetaClasses() {

		for(EClassifier eClassifier : UMLPackage.eINSTANCE.getEClassifiers()) {
			if(eClassifier instanceof EClass) {
				umlMetaClasses.add(eClassifier);
			}
		}

	}


	protected void createOCLSearchQueryField(EObject root) {

		Composite client = queryComposite;

		Composite oclContextComposite = new Composite(client, SWT.NONE);
		oclContextComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		oclContextComposite.setLayout(new GridLayout(2, false));

		oclContext = new Text(oclContextComposite, SWT.BORDER);
		oclContext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		oclContext.setEnabled(false);
		oclContext.setFocus();

		Button btnSelectContext = new Button(oclContextComposite, SWT.PUSH);
		btnSelectContext.setText(Messages.PapyrusSearchPage_18);
		btnSelectContext.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {

				LabelProviderService labelProviderService = new LabelProviderServiceImpl();
				ILabelProvider labelProvider = labelProviderService.getLabelProvider();

				ScopeEntry currentScope = getCurrentScopeEntry();

				if(currentScope != null) {

					try {
						EObject root = ((UmlModel)currentScope.getModelSet().getModel(UmlModel.MODEL_ID)).lookupRoot();

						ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(Display.getCurrent().getActiveShell(), labelProvider, new OCLContextContentProvider());
						dialog.setTitle(Messages.PapyrusSearchPage_19);
						dialog.setMessage(Messages.PapyrusSearchPage_20);
						dialog.setInput(currentScope.getModelSet());
						dialog.setAllowMultiple(false);
						dialog.open();
						Object selection = dialog.getFirstResult();

						if(selection instanceof EObject) {

							refreshSelection(selection);

							if(contextObject instanceof NamedElement) {
								oclContext.setText(((NamedElement)contextObject).getQualifiedName());
							} else {
								oclContext.setText(labelProvider.getText(contextObject));
							}
						}

					} catch (NotFoundException notFoundException) {

						Activator.log.error(Messages.PapyrusQuery_0 + currentScope.getModelSet(), notFoundException);
					}
				}

			}
		});
		btnSelectContext.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		Injector injector = Activator.getInstance().getInjector(EssentialOCLPlugin.LANGUAGE_ID);
		Composite editorComposite = client;
		oclEditor = new EmbeddedXtextEditor(editorComposite, injector, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);

		oclEditor.getViewer().getTextWidget().addVerifyKeyListener(new VerifyKeyListener() {

			public void verifyKey(VerifyEvent e) {
				// System.out.println("verifyKey: " + e.keyCode);
				if(e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {
					if((e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {
						e.doit = false;
					}
				}
			}
		});

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		data.heightHint = convertHeightInCharsToPixels(3);
		editorComposite.setLayoutData(data);

		refreshSelection(root);
	}

	protected ScopeEntry getCurrentScopeEntry() {
		if(container.getSelectedScope() == ISearchPageContainer.SELECTION_SCOPE) {
			Collection<IResource> scope = ScopeCollector.getInstance().computeSearchScope(container);

			Collection<ScopeEntry> scopeEntries = createScopeEntries(scope);

			if(scopeEntries.size() == 1) {
				Object[] entries = scopeEntries.toArray();
				ScopeEntry selectedResource = (ScopeEntry)entries[0];

				return selectedResource;
			}
		}
		return null;
	}

	public void createControl(Composite parent) {

		initializeDialogUnits(parent);
		Composite searchComposite = new Composite(parent, SWT.NONE);
		searchComposite.setFont(parent.getFont());
		searchComposite.setLayout(new GridLayout(2, false));
		searchComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label lblSearchString = new Label(searchComposite, SWT.NONE);
		lblSearchString.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblSearchString.setText(Messages.PapyrusSearchPage_4);

		queryKind = new Combo(searchComposite, SWT.VERTICAL | SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		queryKind.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1));
		queryKind.add(Messages.PapyrusSearchPage_21);
		queryKind.add(Messages.PapyrusSearchPage_22);



		queryKind.select(TEXT_QUERY_KIND);

		queryKind.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				for(Control childControl : queryComposite.getChildren()) {
					childControl.dispose();
				}

				if(queryKind.getSelectionIndex() == TEXT_QUERY_KIND) {
					createSimpleSearchQueryField();




				} else {
					if(container.getSelectedScope() == ISearchPageContainer.SELECTION_SCOPE) {

						ScopeEntry currentScope = getCurrentScopeEntry();
						if(currentScope != null) {
							if(currentScope.getModelSet() != null) {

								try {
									EObject root = ((UmlModel)currentScope.getModelSet().getModel(UmlModel.MODEL_ID)).lookupRoot();
									createOCLSearchQueryField(root);

									if(contextObject instanceof NamedElement) {
										oclContext.setText(((NamedElement)contextObject).getQualifiedName());
									} else {
										LabelProviderService labelProviderService = new LabelProviderServiceImpl();
										ILabelProvider labelProvider = labelProviderService.getLabelProvider();
										oclContext.setText(labelProvider.getText(contextObject));
									}
								} catch (NotFoundException notFoundException) {

									Activator.log.error(Messages.PapyrusQuery_0 + currentScope.getModelSet(), notFoundException);
								}
							} else {
								MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_23, Messages.PapyrusSearchPage_24);
								createSimpleSearchQueryField();
								queryKind.select(TEXT_QUERY_KIND);
							}
						} else {
							MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_25, Messages.PapyrusSearchPage_26);
							createSimpleSearchQueryField();
							queryKind.select(TEXT_QUERY_KIND);
						}
					} else {
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_27, Messages.PapyrusSearchPage_28);
						createSimpleSearchQueryField();
						queryKind.select(TEXT_QUERY_KIND);
					}
				}
				queryComposite.layout();
			}
		});


		queryComposite = new Composite(searchComposite, SWT.NONE);
		queryComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		queryComposite.setLayout(new GridLayout(1, false));

		createSimpleSearchQueryField();

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

	protected void refreshSelection(final Object selected) {
		final BaseDocument editorDocument = (BaseDocument)oclEditor.getDocument();
		editorDocument.modify(new IUnitOfWork<Object, XtextResource>() {

			public Value exec(XtextResource resource) throws Exception {
				Object selectedObject = selected;
				if(selectedObject instanceof IOutlineNode) {
					if(selectedObject instanceof EObjectNode) {
						EObjectNode selectedObjectNode = (EObjectNode)selectedObject;
						@SuppressWarnings("unused")
						URI eObjectURI = selectedObjectNode.getEObjectURI();
						contextObject = null; // FIXME
												// metaModelManager.loadResource(eObjectURI,
												// null, null);
					} else if(selectedObject instanceof EStructuralFeatureNode) {
						contextObject = null;
					} else {
						contextObject = null;
					}
				} else {
					if(selectedObject instanceof IAdaptable) {
						selectedObject = ((IAdaptable)selectedObject).getAdapter(EObject.class);
					}
					if(selectedObject instanceof EObject) {
						contextObject = (EObject)selectedObject;
					} else {
						contextObject = null;
					}
				}
				MetaModelManager metaModelManager = getMetaModelManager(contextObject);
				parserContext = new EObjectContext(metaModelManager, null, contextObject);
				EssentialOCLCSResource csResource = (EssentialOCLCSResource)resource;
				if(csResource != null) {
					if(contextObject != null) {
						CS2PivotResourceAdapter.getAdapter(csResource, metaModelManager);
					}
					ResourceSet resourceSet = oclEditor.getResourceSet();
					if(resourceSet != null) {
						MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
					}
					csResource.setParserContext(parserContext);
				}

				return null;
			}
		});
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

		if(queryKind.getSelectionIndex() == TEXT_QUERY_KIND) {
			if(validateRegex()) {
				Collection<IResource> scope = ScopeCollector.getInstance().computeSearchScope(container);

				Collection<ScopeEntry> scopeEntries = createScopeEntries(scope);
				ISearchQuery query;
				if(searchKind.getSelectionIndex() == SIMPLE_SEARCH) {
					if(searchQueryText.getText().length() == 0) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_29, Messages.PapyrusSearchPage_30);
						return false;
					} else {
						initMetaClasses();
						query = new PapyrusQuery(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), scopeEntries, umlMetaClasses.toArray(), btnSearchAllStringAttributes.getSelection());
					}
				} else {


					List<ParticipantTypeElement> participantsToEvaluate = new ArrayList<ParticipantTypeElement>();
					for(ParticipantTypeElement element : this.participantsList.keySet()) {
						if(element.isChecked()) {
							participantsToEvaluate.add(element);
							for(ParticipantTypeAttribute attributesToEvaluate : participantsList.get(element)) {
								if(attributesToEvaluate.isChecked()) {
									participantsToEvaluate.add(attributesToEvaluate);
								}
							}
						}
					}
					if(participantsToEvaluate.size() == 0) {

						MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_31, Messages.PapyrusSearchPage_32);
						return false;
					} else {
						if(searchQueryText.getText().length() == 0) {
							for(Object participantChecked : participantTypesTreeViewer.getCheckedElements()) {
								if(participantChecked instanceof ParticipantTypeAttribute) {
									MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_33, Messages.PapyrusSearchPage_34);
									return false;
								}
							}
						}

						query = new PapyrusAdvancedQuery(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), scopeEntries, participantsToEvaluate.toArray());

					}

				}
				if(query.canRunInBackground()) {
					NewSearchUI.runQueryInBackground(query);
				}

				return true;
			} else {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), SEARCH_ISSUE, REGULAR_EXPRESSION_ILLFORMED);
				return false;
			}
		} else {

			ScopeEntry scopeEntry = getCurrentScopeEntry();

			if(scopeEntry != null) {

				try {

					PivotUtil.checkResourceErrors("", oclEditor.getResource()); //$NON-NLS-1$
					ExpressionInOCL expressionInOCL = parserContext.getExpression((BaseResource)oclEditor.getResource());
					ISearchQuery query = new PapyrusOCLQuery((BaseDocument)oclEditor.getDocument(), parserContext, getMetaModelManager(contextObject), modelManager, contextObject, scopeEntry);


					if(query.canRunInBackground()) {
						NewSearchUI.runQueryInBackground(query);
					}
				} catch (ParserException e) {
					Object value = new InvalidValueException(e, Messages.PapyrusSearchPage_35);
					MessageDialog.openError(Display.getCurrent().getActiveShell(), SEARCH_ISSUE, OCL_QUERY_ILLFORMED);
					return false;
				}

				return true;
			} else {
				return false;
			}
		}
	}

	public void setContainer(ISearchPageContainer container) {
		this.container = container;
		this.container.setPerformActionEnabled(true);
	}

	public boolean performReplace() {
		if(queryKind.getSelectionIndex() == TEXT_QUERY_KIND) {
			if(validateRegex()) {
				if(searchQueryText.getText().length() == 0) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_36, Messages.PapyrusSearchPage_37);
					return false;
				}

				Collection<IResource> scope = ScopeCollector.getInstance().computeSearchScope(container);

				Collection<ScopeEntry> scopeEntries = createScopeEntries(scope);
				AbstractPapyrusQuery query;
				if(searchKind.getSelectionIndex() == SIMPLE_SEARCH) {
					initMetaClasses();

					query = new PapyrusQuery(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), scopeEntries, umlMetaClasses.toArray(), btnSearchAllStringAttributes.getSelection());
				} else {
					List<ParticipantTypeElement> participantsToEvaluate = new ArrayList<ParticipantTypeElement>();
					for(ParticipantTypeElement element : this.participantsList.keySet()) {
						if(element.isChecked()) {
							participantsToEvaluate.add(element);
							if(participantsList.get(element).size() == 0) {
								MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_38, Messages.PapyrusSearchPage_39);
								return false;

							} else {
								for(ParticipantTypeAttribute attributesToEvaluate : participantsList.get(element)) {
									if(attributesToEvaluate.isChecked()) {
										participantsToEvaluate.add(attributesToEvaluate);
										Object value = element.getElement().eGet((EAttribute)attributesToEvaluate.getElement());
										if(!(value instanceof String)) {
											MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_40, Messages.PapyrusSearchPage_41);
											return false;
										}
									}
								}
							}
						}
					}
					query = new PapyrusAdvancedQuery(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), scopeEntries, participantsToEvaluate.toArray());

				}
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
		} else {
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_42, Messages.PapyrusSearchPage_43);
			return false;
		}

	}




	public @NonNull
	MetaModelManager getMetaModelManager(@Nullable EObject contextObject) {
		MetaModelManager metaModelManager = contextObject != null ? PivotUtil.findMetaModelManager(contextObject) : null;
		if(metaModelManager != null) {
			return metaModelManager;
		}
		MetaModelManager nullMetaModelManager2 = nullMetaModelManager;
		if(nullMetaModelManager2 == null) {
			nullMetaModelManager2 = nullMetaModelManager = new MetaModelManager();
			nullMetaModelManager2.addListener(this);
		}
		return nullMetaModelManager2;
	}

	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		metaModelManager.removeListener(this);
		reset();

	}

	protected void flushEvents() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		while(workbench.getDisplay().readAndDispatch());
	}

	public void reset() {
		if(oclEditor != null) {
			IXtextDocument document = oclEditor.getDocument();
			MetaModelManager metaModelManager = document.modify(new IUnitOfWork<MetaModelManager, XtextResource>() { // Cancel

				// validation

				public MetaModelManager exec(XtextResource state) throws Exception {
					if(state == null) {
						return null;
					}
					if(state instanceof BaseResource) {
						((BaseResource)state).setParserContext(null);
					}
					return PivotUtil.findMetaModelManager(state);
				}
			});
			flushEvents();
			// editor.close(false);
			flushEvents();
			if(metaModelManager != null) {
				metaModelManager.dispose();
			}
		}
		if(modelManager != null) {
			// modelManager.dispose();
			modelManager = null;
		}
		if(nullMetaModelManager != null) {
			nullMetaModelManager.dispose();
			nullMetaModelManager = null;
		}
		parserContext = null;
		contextObject = null;
	}
}
