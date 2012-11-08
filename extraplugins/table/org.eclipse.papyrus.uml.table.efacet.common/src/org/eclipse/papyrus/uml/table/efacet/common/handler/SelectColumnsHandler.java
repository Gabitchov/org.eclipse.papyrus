/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.common.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.IFacetManagerFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetInternal;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ENamedElementComparator;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractTableEditor;
import org.eclipse.papyrus.infra.table.efacet.common.utils.AdditionalContentsFacetSetUtils;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.TableContentsUtils;
import org.eclipse.papyrus.uml.table.efacet.common.Activator;
import org.eclipse.papyrus.uml.table.efacet.common.dialog.ColumnsToShowDialog;
import org.eclipse.papyrus.uml.table.efacet.common.factory.ITableCommandFactory;
import org.eclipse.papyrus.uml.table.efacet.common.factory.TableCommandFactory;
import org.eclipse.papyrus.uml.table.efacet.common.factory.TableInstanceCommandFactory;
import org.eclipse.papyrus.uml.table.efacet.common.provider.AbstractAdditionalContentsProvider;
import org.eclipse.papyrus.uml.table.efacet.common.provider.EMFFacetColumnsProvider;
import org.eclipse.papyrus.uml.table.efacet.common.provider.ProfileFacetSetProvider;
import org.eclipse.papyrus.uml.table.efacet.common.provider.SortedFeaturesContentProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * Handler for the Show/Hide columns Papyrus version
 * A FacetSet called in this class AdditionContentsFacetSet is registered in the .notation. It is used to store created facet sets to display
 * additional columns
 * 
 * FIXME : the show/hide additional contents should be tested
 * in the facetset AdditionContentsFacetSet :
 * - the facetset used by any table should be remove from it and destroyed
 * - the facetset created should be registered in it
 * - this facetset should be created if needed
 * - this facetset should be destroyed if it is not used
 * - facetset not used should be removed from the table#getFacetSets referencesS
 * 
 */
public class SelectColumnsHandler extends AbstractHandler {

	/** all direct features available in the table */
	final protected SortedSet<ETypedElement> allDirectFeatures = new TreeSet<ETypedElement>(new ENamedElementComparator());

	/** all additional possible contents */
	final protected Collection<FacetSet> allAdditionalContents = new HashSet<FacetSet>();

	/** the initial direct features visibles in the table */
	final protected Collection<ETypedElement> initialDirectFeatureSelected = new HashSet<ETypedElement>();

	/** the initial additional features visibles in the table */
	final protected Collection<ETypedElement> initialAdditionalFeatureSelected = new HashSet<ETypedElement>();

	/** the list of the facetSet used in the current table */
	final protected Collection<FacetSet> facetSetsUsedInTheTable = new HashSet<FacetSet>();

	/** the map between existing columns (visible or not) and the feature */
	final protected Map<ETypedElement, Column> columnsFeatureMap = new HashMap<ETypedElement, Column>();

	//	final protected Collection<AbstractAdditionalContentsProvider> additionalContentProviders = new ArrayList<AbstractAdditionalContentsProvider>();

	//TODO remove it
	//	final StereotypeManagement management = new StereotypeManagement();

	/**
	 * clear the fields
	 */
	protected void clearFields() {
		this.allDirectFeatures.clear();
		this.initialDirectFeatureSelected.clear();
		this.initialAdditionalFeatureSelected.clear();
		this.facetSetsUsedInTheTable.clear();
		this.columnsFeatureMap.clear();
		this.allAdditionalContents.clear();
		//		this.additionalContentProviders.clear();
	}

	private FacetSet getRootFacetSet(final FacetElement facetElement) {
		EObject container = facetElement;
		while(container.eContainer() != null) {
			container = container.eContainer();
		}
		if(container instanceof FacetSet) {
			return (FacetSet)container;
		}
		return null;
	}

	/**
	 * Inits the fields of this class
	 * 
	 * @param widget
	 *        the table widget
	 * @param papyrusTable
	 *        the papyrus table
	 */
	protected void initField(final ITableWidget widget, final PapyrusTable papyrusTable) {
		clearFields();
		//the contents of the table
		final List<EObject> contents = TableContentsUtils.getTableContents(papyrusTable, papyrusTable.getTable().getContext(), false);

		//1. Get all direct features
		for(final EObject current : contents) {
			this.allDirectFeatures.addAll(current.eClass().getEAllStructuralFeatures());
		}

		//2. we build the list of the initialSelection
		final List<Column> visibleColumns = widget.getVisibleColumns(false);
		final Set<ETypedElement> visibleFeatures = new HashSet<ETypedElement>();
		for(final Column current : visibleColumns) {
			if(current instanceof FeatureColumn) {
				final ETypedElement feature = ((FeatureColumn)current).getFeature();
				if(feature instanceof FacetElement) {
					this.initialAdditionalFeatureSelected.add(feature);
				} else {
					this.initialDirectFeatureSelected.add(feature);
				}
			}
		}

		for(final Column current : papyrusTable.getTable().getColumns()) {
			if(current instanceof FeatureColumn) {
				final FeatureColumn col = (FeatureColumn)current;
				final ETypedElement feature = col.getFeature();
				//3. we associate each features to each columns
				this.columnsFeatureMap.put(feature, col);

				//3 bis. we build the list of the initialSelection
				if(feature instanceof FacetElement) {
					final FacetSet set = getRootFacetSet((FacetElement)feature);
					this.facetSetsUsedInTheTable.add(set);
				}
			}
		}

		//4. get the additional features
		final FacetSet additionFeatureRootFacetSet = getAdditionalContentsFacetSet(papyrusTable);
		if(additionFeatureRootFacetSet != null) {
			//TODO waiting for he patch of 392413: FacetSet metamodel : FacetSet#getFacetSets always return a new list
			final List<EPackage> sets = additionFeatureRootFacetSet.getESubpackages();
			for(final EPackage ePackage : sets) {
				if(ePackage instanceof FacetSet) {
					this.allAdditionalContents.add((FacetSet)ePackage);
				}
			}
		}
		this.allAdditionalContents.addAll(this.facetSetsUsedInTheTable);

		AbstractAdditionalContentsProvider provider = new EMFFacetColumnsProvider();
		provider.setPapyrusTable(papyrusTable);
		this.allAdditionalContents.addAll(provider.getAdditionalFeatures());

		provider = new ProfileFacetSetProvider();
		provider.setPapyrusTable(papyrusTable);
		this.allAdditionalContents.addAll(provider.getAdditionalFeatures());

		//		this.additionalContentProviders.addAll(AdditionalColumnsProviderRegistry.INSTANCE.getContributions(papyrusTable, contents, this.facetSetsUsedInTheTable, this.initialAdditionalFeatureSelected));
		//		for(final AbstractAdditionalContentsProvider provider : this.additionalContentProviders) {
		//			this.allAdditionalContents.addAll(provider.getAdditionalFeatures());
		//		}

	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final CompoundCommand compoundCmd = new CompoundCommand("Papyrus Show/Hide columns command"); //$NON-NLS-1$
		final PapyrusTable papyrusTable = getPapyrusTable();
		final ITableWidget widget = getTableWidget();
		final TransactionalEditingDomain domain = getEditingDomain();
		final FacetSet additionFeatureRootFacetSet = getAdditionalContentsFacetSet(papyrusTable);
		if(papyrusTable != null && widget != null) {
			initField(widget, papyrusTable);
			final Collection<ETypedElement> initialSelection = new ArrayList<ETypedElement>();
			initialSelection.addAll(this.initialDirectFeatureSelected);
			initialSelection.addAll(this.initialAdditionalFeatureSelected);
			final Collection<ENamedElement> allFacetSets = new TreeSet<ENamedElement>(new ENamedElementComparator());
			allFacetSets.addAll(this.facetSetsUsedInTheTable);
			allFacetSets.addAll(this.allAdditionalContents);
			final FacetSet set = getAdditionalContentsFacetSet(papyrusTable);
			if(set != null) {
				allFacetSets.remove(set);
			}
			SortedFeaturesContentProvider contentProvider = new SortedFeaturesContentProvider();
			//			contentProvider.setInitialSelection((Collection<?>)initialSelection);
			final ColumnsToShowDialog dialog = new ColumnsToShowDialog(Display.getCurrent().getActiveShell(), this.allDirectFeatures, allFacetSets, initialSelection, getLabelProvider(), contentProvider);
			if(dialog.open() == Window.OK) {
				final Object[] result = dialog.getResult();
				final Set<ETypedElement> directFeatures = (Set<ETypedElement>)result[0];
				final Set<ETypedElement> additionalFeatures = (Set<ETypedElement>)result[1];
				if(!directFeatures.equals(this.initialDirectFeatureSelected)) {
					//1. get command to show/hide direct features
					final Command cmd = getShowHideDirectFeatureColumnsCommand(papyrusTable, (ITableWidgetInternal)widget, directFeatures);
					if(cmd != null) {
						compoundCmd.append(cmd);
					}
				}

				if(!additionalFeatures.equals(this.initialAdditionalFeatureSelected)) {
					// 2. get the command to show/hide additional contents
					final Command cmd2 = getCreateDestroyAdditonalFeatureColumnsCommand(papyrusTable, (ITableWidgetInternal)widget, additionalFeatures);
					if(cmd2 != null) {
						compoundCmd.append(cmd2);
					}
				}
				if(!compoundCmd.isEmpty()) {
					domain.getCommandStack().execute(compoundCmd);
				}

			}
		}
		//we clear the fields
		clearFields();
		return null;
	}

	//TODO should be moved in another classes to be used by the stereotypemanager?
	protected FacetSet getAdditionalContentsFacetSet(final PapyrusTable table) {
		FacetSet set = null;
		final Resource resource = table.eResource();
		final Iterator<EObject> iter = resource.getContents().iterator();
		while(iter.hasNext() && set == null) {
			final EObject current = iter.next();
			if(current instanceof FacetSet) {
				final FacetSet tmp = (FacetSet)current;
				if(AdditionalContentsFacetSetUtils.ADDITIONAL_CONTENTS_FACET_SET_NS_URI.equals(tmp.getNsURI())) {
					set = tmp;
				}
			}
		}

		return set;
	}

	/**
	 * 
	 * @param papyrusTable
	 *        the papyrus table
	 * @param widget
	 *        the widget
	 * @param selectedFeatures
	 *        the direct features selected
	 * @return
	 *         the command to show/hide the required columns (we doesn't destroy columns, because EMF-Facet will cerate it, if they are required, for
	 *         the next added element in the table)
	 */
	protected Command getShowHideDirectFeatureColumnsCommand(final PapyrusTable papyrusTable, final ITableWidgetInternal widget, final Collection<ETypedElement> selectedFeatures) {
		final CompoundCommand compoundCmd = new CompoundCommand("Show/Hide direct features command"); //$NON-NLS-1$

		//1. calculus of the columns to show/add
		final List<ETypedElement> featuresToAdd = new ArrayList<ETypedElement>(selectedFeatures);
		featuresToAdd.removeAll(this.initialDirectFeatureSelected);
		//these columns should be set To Visible OR created

		//2. calculus of the columns to hide
		final List<Object> directFeaturesToHide = new ArrayList<Object>(this.initialDirectFeatureSelected);
		directFeaturesToHide.removeAll(selectedFeatures);

		//these columns should be hidden
		final List<Column> columnsToHide = new ArrayList<Column>();
		for(final Object current : directFeaturesToHide) {
			final Column toHide = this.columnsFeatureMap.get(current);
			if(toHide != null) {
				columnsToHide.add(toHide);
			}
		}

		final List<Column> columnsToShow = new ArrayList<Column>();

		//not useful for direct features
		final List<ETypedElement> columnsToCreate = new ArrayList<ETypedElement>();

		for(final Object currentColumn : featuresToAdd) {
			if(this.columnsFeatureMap.containsKey(currentColumn)) {
				columnsToShow.add(this.columnsFeatureMap.get(currentColumn));
			} else {
				columnsToCreate.add((ETypedElement)currentColumn);
			}
		}

		final TransactionalEditingDomain domain = getEditingDomain();
		final ITableWidgetInternal widgetController = widget;
		final ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(domain);
		final boolean putOnTheTop = false;

		final Command showHideCommand = TableInstanceCommandFactory.createShowHideColumnCommand(widgetController, domain, commandFactory, papyrusTable.getTable(), columnsToShow, columnsToHide, putOnTheTop);

		if(showHideCommand != null && showHideCommand.canExecute()) {
			compoundCmd.append(showHideCommand);
		}

		//columns to create should always be null with direct features!
		assert columnsToCreate.isEmpty();
		if(!compoundCmd.isEmpty() && compoundCmd.canExecute()) {
			return compoundCmd;
		}
		return null;

	}

	/**
	 * 
	 * - when the AddtionalContentsfacetSet is empty -> it should be removed from the resource
	 * - when the AddtionalContentsfacetSet is not erquired by a table -> it should be remove of the facetSet referenced by the table
	 * - when a subfacetset is required by any table -> it should be removed of the list of the subfacetset owned by the AddtionalContentsFacetSet
	 * 
	 * /!\We assume that the facet used for columns are not used in the same time for others things!
	 * 
	 * @param papyrusTable
	 *        the papyrus table
	 * @param widget
	 *        the widget
	 * @param selectedAdditionalFeatures
	 *        the addtional features selected
	 * @return
	 *         the command to create and destroy the required columns (can be <code>null</code>)
	 *         /!\ EMF-Facet allows to hide EMF-Facet columns, so if such column already exists but are not visible, we show them
	 */
	private Command getCreateDestroyAdditonalFeatureColumnsCommand(final PapyrusTable papyrusTable, final ITableWidgetInternal widget, final Collection<ETypedElement> selectedAdditionalFeatures) {
		final CompoundCommand compoundCmd = new CompoundCommand("Show/Hide additional features command"); //$NON-NLS-1$
		final Resource resource = papyrusTable.eResource();
		final ResourceSet resourceSet = resource.getResourceSet();
		final TransactionalEditingDomain domain = getEditingDomain();
		final ITableCommandFactory factory = getTableCmdFactory(domain, resourceSet, papyrusTable.getTable());
		FacetSet additionFeatureRootFacetSet = getAdditionalContentsFacetSet(papyrusTable);

		//0. determine which current facetset are uszed for columns and which facetset are used for other things
		final Set<FacetSet> setForOtherThings = new HashSet<FacetSet>(papyrusTable.getTable().getFacetSets());
		for(final Column current : papyrusTable.getTable().getColumns()) {
			if(current instanceof FeatureColumn) {
				final ETypedElement element = ((FeatureColumn)current).getFeature();
				if(element instanceof FacetElement) {
					setForOtherThings.remove(getRootFacetSet((FacetElement)element));
				}
			}
		}


		//1. calculus of the columns to show/add
		//these columns should be set to visible or created
		final List<ETypedElement> featuresToAdd = new ArrayList<ETypedElement>(selectedAdditionalFeatures);
		featuresToAdd.removeAll(this.initialAdditionalFeatureSelected);

		//we should take into account that EMF-Facet allows to destroy AND hide columns, so some columns can already exists but are currently not visible
		final List<ETypedElement> columnsToCreate = new ArrayList<ETypedElement>();
		columnsToCreate.addAll(featuresToAdd);
		final List<Column> existingColumnsToShow = new ArrayList<Column>();

		final ListIterator<ETypedElement> iter = columnsToCreate.listIterator();
		while(iter.hasNext()) {
			final ETypedElement current = iter.next();
			if(this.columnsFeatureMap.containsKey(current)) {
				existingColumnsToShow.add(this.columnsFeatureMap.get(current));
				//the current column already exists, so we should not create it
				iter.remove();
			}
		}

		//2. calculus of the columns to hide/destroy
		final List<ETypedElement> additionalFeaturesToHide = new ArrayList<ETypedElement>(this.initialAdditionalFeatureSelected);
		additionalFeaturesToHide.removeAll(selectedAdditionalFeatures);

		//3. determine which FacetSet for columns are required by the table
		final Set<FacetSet> facetSetColumnsUsedInTable = new HashSet<FacetSet>();

		//4. determine which subfacetset for additional contents are useful
		//4bis. determine which subfacet set for additional contents should be added to the additionalcontents facetset
		final Set<FacetSet> requiredSubFacetSets = new HashSet<FacetSet>();
		final Set<FacetSet> toAddToResource = new HashSet<FacetSet>();
		for(final ETypedElement current : selectedAdditionalFeatures) {
			final FacetSet root = getRootFacetSet((FacetElement)current);
			if(root.eResource() == null) {
				toAddToResource.add(root);
				EObject container = current;
				while(container != null) {
					if(container instanceof FacetSet) {
						requiredSubFacetSets.add((FacetSet)container);
					}
					container = container.eContainer();
				}
			} else if(root == additionFeatureRootFacetSet) {
				facetSetColumnsUsedInTable.add(additionFeatureRootFacetSet);
				EObject container = current;
				while(container != null) {
					if(container instanceof FacetSet && container != additionFeatureRootFacetSet) {
						requiredSubFacetSets.add((FacetSet)container);
					}
					container = container.eContainer();
				}
			} else {
				facetSetColumnsUsedInTable.add(root);
			}
		}

		//5. determine which subfacetset for additional contents are not useful in the current table
		//5 bis. determine which subfacetset for additional contents are never used in the whole model.
		final Set<FacetSet> uselessFacetSetsInAllExistingTable = new HashSet<FacetSet>();
		final Set<FacetSet> uselessFacetSetsInCurrentTable = new HashSet<FacetSet>();
		if(additionFeatureRootFacetSet != null) {
			for(final EPackage set : additionFeatureRootFacetSet.getESubpackages()) {
				if(set instanceof FacetSet && !requiredSubFacetSets.contains(set)) {
					uselessFacetSetsInCurrentTable.add((FacetSet)set);
					final TreeIterator<EObject> it = set.eAllContents();
					boolean useless = true;
					while(it.hasNext() && useless) {
						final EObject value = it.next();
						if(value instanceof FacetElement) {
							final ECrossReferenceAdapter eCrossReference = CrossReferenceAdapter.getCrossReferenceAdapter(papyrusTable.eResource().getResourceSet());
							final Collection<Setting> references = eCrossReference.getInverseReferences(value, false);
							final Iterator<Setting> settingIter = references.iterator();
							while(settingIter.hasNext() && useless) {
								final EObject ref = settingIter.next().getEObject();
								//TODO check with memory analyzer! because we can found existing columns with no resources and no container
								if(ref instanceof Column && ref.eContainer() != null && ref.eResource() != null) {
									useless = papyrusTable.getTable().getColumns().contains(ref);
								}
							}
						}
					}
					if(useless) {
						uselessFacetSetsInAllExistingTable.add((FacetSet)set);
					}
				}
			}
		}


		//6.we calculate the new registered FacetSet for the addition contents facetset
		final Collection<FacetSet> newRegisteredSubFacetSet = new HashSet<FacetSet>();
		final Collection<FacetSet> oldSubRegisteredFacetSet = new HashSet<FacetSet>();
		if(additionFeatureRootFacetSet != null) {
			//TODO waiting for he patch of 392413: FacetSet metamodel : FacetSet#getFacetSets always return a new list
			for(final EPackage current : additionFeatureRootFacetSet.getESubpackages()) {
				if(current instanceof FacetSet) {
					oldSubRegisteredFacetSet.add((FacetSet)current);
				}
			}
		}
		newRegisteredSubFacetSet.addAll(oldSubRegisteredFacetSet);
		newRegisteredSubFacetSet.addAll(toAddToResource);
		newRegisteredSubFacetSet.removeAll(uselessFacetSetsInAllExistingTable);



		//7.we calculate the usage of the additional facet set contents in the current table
		final Collection<FacetSet> usedInCurrentTable = new HashSet<FacetSet>();
		usedInCurrentTable.addAll(oldSubRegisteredFacetSet);
		usedInCurrentTable.addAll(toAddToResource);
		usedInCurrentTable.removeAll(uselessFacetSetsInCurrentTable);


		//8.boolean value to know if we can destroy the additional contents facetset
		final boolean destroyAdditionalContentsFacetSet = newRegisteredSubFacetSet.size() == 0 && additionFeatureRootFacetSet != null;

		//9.boolean value to know if we can remove the additional contents FacetSet reference from the current table
		final boolean removeAdditionalContentsFacetSetFromTheCurrentTable = usedInCurrentTable.isEmpty() && additionFeatureRootFacetSet != null;


		//10. register the new value for the sub facetset registred by the additional content facetset
		if(additionFeatureRootFacetSet == null && newRegisteredSubFacetSet.size() != 0) {
			additionFeatureRootFacetSet = createAdditionalContentsFacetSet();
			compoundCmd.append(addFacetSetToResourceCommand(domain, resource, additionFeatureRootFacetSet));
			final FacetSet additionFeatureRootFacetSet2 = additionFeatureRootFacetSet;
			final ICommand cmd = new AbstractTransactionalCommand(domain, null, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					additionFeatureRootFacetSet2.getESubpackages().addAll(newRegisteredSubFacetSet);
					return null;
				}
			};
			compoundCmd.append(new GMFtoEMFCommandWrapper(cmd));

		} else if(additionFeatureRootFacetSet != null && !newRegisteredSubFacetSet.equals(oldSubRegisteredFacetSet)) {
			final FacetSet localSet = additionFeatureRootFacetSet;
			final ICommand addNewFacetSetToResource = new AbstractTransactionalCommand(domain, "Set new value for sub facetset Additional Contents", null) { //$NON-NLS-1$

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					localSet.getESubpackages().clear();
					localSet.getESubpackages().addAll(newRegisteredSubFacetSet);
					return CommandResult.newOKCommandResult();
				}
			};
			compoundCmd.append(new GMFtoEMFCommandWrapper(addNewFacetSetToResource));
		}

		if(destroyAdditionalContentsFacetSet) {
			facetSetColumnsUsedInTable.remove(additionFeatureRootFacetSet);
		} else if(additionFeatureRootFacetSet != null) {
			facetSetColumnsUsedInTable.add(additionFeatureRootFacetSet);
		}


		//all facetSet used in the table
		final Set<FacetSet> allFacetSets = new HashSet<FacetSet>();
		allFacetSets.addAll(facetSetColumnsUsedInTable);
		allFacetSets.addAll(setForOtherThings);

		// get the command to create columns
		if(columnsToCreate.size() != 0) {
			final Command createColumns = factory.createAddColumnCommand(columnsToCreate, new ArrayList<FacetSet>(allFacetSets));
			if(createColumns != null && createColumns.canExecute()) {
				compoundCmd.append(createColumns);
			}
		}

		// get the command to destroy columns (only if the AdditionContentsFacetSet continues to be referenced by the current table. If not, the columns will be automatically destroyed
		if(additionalFeaturesToHide.size() != 0 && !removeAdditionalContentsFacetSetFromTheCurrentTable) {
			final Command removeColumns = factory.createRemoveColumnsCommand(additionalFeaturesToHide);
			if(removeColumns != null && removeColumns.canExecute()) {
				compoundCmd.append(removeColumns);
			}
		}

		// register all facets sets used in the current table
		final Command setUsedFacetSetCommand = factory.createSetLoadedFacetSetsCommand(new ArrayList<FacetSet>(allFacetSets));
		if(setUsedFacetSetCommand != null && setUsedFacetSetCommand.canExecute()) {
			compoundCmd.append(setUsedFacetSetCommand);
		}

		final ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(domain);

		//exiting hidden columns are selected to be shown
		if(existingColumnsToShow.size() != 0) {
			final Command showHideCommand = TableInstanceCommandFactory.createShowHideColumnCommand(widget, domain, commandFactory, papyrusTable.getTable(), existingColumnsToShow, new ArrayList<Column>(), true);
			if(showHideCommand != null && showHideCommand.canExecute()) {
				compoundCmd.append(showHideCommand);
			}
		}

		// the additional contents facet set is useless in the current table. , we remove it from the list of the referenced facetset
		if(removeAdditionalContentsFacetSetFromTheCurrentTable) {
			final List<FacetSet> set = new ArrayList<FacetSet>(papyrusTable.getTable().getFacetSets());
			set.remove(additionFeatureRootFacetSet);
			compoundCmd.append(factory.createSetLoadedFacetSetsCommand(set));
		}

		// the additional contents facet set is useless in all table, we remove it of the resource
		if(destroyAdditionalContentsFacetSet) {
			compoundCmd.append(removeFacetSetToResourceCommand(domain, resource, additionFeatureRootFacetSet));
		}

		if(!compoundCmd.isEmpty()) {
			return compoundCmd;
		}
		return null;
	}

	private Command removeFacetSetToResourceCommand(final TransactionalEditingDomain domain, final Resource resource, final FacetSet setToRemove) {
		final ICommand removeFacetSet = new AbstractTransactionalCommand(domain, "Remove FacetSet from the resource", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				resource.getContents().remove(setToRemove);
				return CommandResult.newOKCommandResult();
			}
		};
		return new GMFtoEMFCommandWrapper(removeFacetSet);
	}

	private Command addFacetSetToResourceCommand(final TransactionalEditingDomain domain, final Resource resource, final FacetSet setToAdd) {
		final ICommand removeFacetSet = new AbstractTransactionalCommand(domain, "Add FacetSet from the resource", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				resource.getContents().add(setToAdd);
				return CommandResult.newOKCommandResult();
			}
		};
		return new GMFtoEMFCommandWrapper(removeFacetSet);
	}

	private FacetSet createAdditionalContentsFacetSet() {
		final FacetSet additionFeatureRootFacetSet = EFacetFactory.eINSTANCE.createFacetSet();
		additionFeatureRootFacetSet.setName(AdditionalContentsFacetSetUtils.ADDITIONAL_CONTENTS_FACET_SET_NAME);
		additionFeatureRootFacetSet.setNsPrefix(AdditionalContentsFacetSetUtils.ADDITIONAL_CONTENTS_FACET_SET_PREFIX);
		additionFeatureRootFacetSet.setNsURI(AdditionalContentsFacetSetUtils.ADDITIONAL_CONTENTS_FACET_SET_NS_URI);
		additionFeatureRootFacetSet.setDocumentation(AdditionalContentsFacetSetUtils.ADDITIONAL_CONTENTS_FACET_SET_DOCUMENTATION);
		return additionFeatureRootFacetSet;
	}

	/**
	 * 
	 * @return
	 *         the editing domain used by this handler or <code>null</code> if not found
	 */
	private TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain domain = null;
		domain = TransactionUtil.getEditingDomain(getPapyrusTable());
		return domain;
	}

	/**
	 * 
	 * @return
	 *         the current table editor, or <code>null</code> if not found
	 */
	private AbstractTableEditor getCurrentTableEditor() {
		final IStructuredSelection selection = (IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		final Object current = selection.getFirstElement();
		if(current instanceof EObject) {

			IEditorPart part = null;
			try {
				part = ServiceUtilsForResource.getInstance().getNestedActiveIEditorPart(((EObject)current).eResource());
			} catch (final ServiceException e) {
				Activator.log.error(e);
			}
			if(part instanceof AbstractTableEditor) {
				return (AbstractTableEditor)part;
			}

		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the papyrus table
	 */
	private PapyrusTable getPapyrusTable() {
		final IEditorPart part = getCurrentTableEditor();
		if(part != null) {
			return (PapyrusTable)part.getAdapter(PapyrusTable.class);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the table widget
	 */
	private ITableWidget getTableWidget() {
		final IAdaptable editor = getCurrentTableEditor();
		final ITableWidgetProvider provider = (ITableWidgetProvider)editor.getAdapter(ITableWidgetProvider.class);
		if(provider != null) {
			return provider.getTableWidget();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the label provider by for the dialog
	 */
	private ILabelProvider getLabelProvider() {
		final AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(factory);
		return labelProvider;
	}

	/**
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param resourceSet
	 *        the resource set
	 * @param table
	 *        the table
	 * @return
	 *         the command factory for these parameters
	 */
	//TODO duplicated code from the AbstractTriggerListener
	private static ITableCommandFactory getTableCmdFactory(final TransactionalEditingDomain editingDomain, final ResourceSet resourceSet, final Table table) {
		final IFacetManager facetManager = IFacetManagerFactory.DEFAULT.getOrCreateFacetManager(resourceSet);
		final ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(editingDomain);
		return new TableCommandFactory(table, editingDomain, commandFactory, facetManager);
	}
}
