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
package org.eclipse.papyrus.uml.table.common.handler;

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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetAttribute;
import org.eclipse.emf.facet.infra.facet.FacetReference;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.infra.query.QueryFactory;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.AttributeColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Column;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetAttributeColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FeatureColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.ReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstanceFactory;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.internal.TableInstanceCommandFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.editor.AbstractMultiPageSashEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ENamedElementComparator;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.table.common.editor.AbstractNattableEditor;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.utils.AdditionalContentsUtils;
import org.eclipse.papyrus.uml.table.common.Activator;
import org.eclipse.papyrus.uml.table.common.dialog.ColumnsToShowDialog;
import org.eclipse.papyrus.uml.table.common.editor.AbstractUMLTableEditor;
import org.eclipse.papyrus.uml.table.common.provider.AbstractAdditionalContentsProvider;
import org.eclipse.papyrus.uml.table.common.provider.EMFFacetColumnsProvider;
import org.eclipse.papyrus.uml.table.common.provider.ProfileFacetSetProvider;
import org.eclipse.papyrus.uml.table.common.provider.SortedFeaturesContentProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.UMLPackage;

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
	final private SortedSet<ETypedElement> allDirectFeatures = new TreeSet<ETypedElement>(new ENamedElementComparator());

	/** all additional possible contents */
	final private Collection<FacetSet> allAdditionalContents = new HashSet<FacetSet>();

	/** the initial direct features visibles in the table */
	final private Collection<ETypedElement> initialDirectFeatureSelected = new HashSet<ETypedElement>();

	/** the initial additional features visibles in the table */
	final private Collection<ETypedElement> initialAdditionalFeatureSelected = new HashSet<ETypedElement>();

	/** the list of the facetSet used in the current table */
	final private Collection<FacetSet> facetSetsUsedInTheTable = new HashSet<FacetSet>();

	/** the map between existing columns (visible or not) and the feature */
	final private Map<ETypedElement, Column> columnsFeatureMap = new HashMap<ETypedElement, Column>();


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


	private FacetSet getRootFacetSet(final EObject facetElement) {

		EObject container = facetElement;
		while(container.eContainer() != null) {
			container = container.eContainer();
		}
		if(container instanceof FacetSet) {
			return (FacetSet)container;
		}

		if(facetElement instanceof FacetStructuralFeature) {
			container = facetElement.eContainer().eContainer();
		}
		if(facetElement instanceof Facet) {
			container = facetElement.eContainer();
		}
		if(facetElement instanceof FacetSet) {
			container = facetElement;
		}
		assert container instanceof FacetSet;
		while(container.eContainer() != null && container.eContainer() instanceof FacetSet) {
			container = container.eContainer();
		}

		return (FacetSet)container;
	}

	/**
	 * Inits the fields of this class
	 * 
	 * @param widget
	 *        the table widget
	 * @param papyrusTable
	 *        the papyrus table
	 */
	protected void initField(final NatTableWidget widget, final PapyrusTableInstance papyrusTable) {
		clearFields();
		//the contents of the table
		final List<EObject> contents = papyrusTable.getTable().getElements();

		//1. Get all direct features
		for(final EObject current : contents) {
			this.allDirectFeatures.addAll(current.eClass().getEAllStructuralFeatures());
		}

		//2. we build the list of the initialSelection
		final List<Column> visibleColumns = widget.getVisibleColumns(false);
		final Set<ETypedElement> visibleFeatures = new HashSet<ETypedElement>();
		for(final Column current : visibleColumns) {
			if(current instanceof AttributeColumn) {
				this.initialDirectFeatureSelected.add(((AttributeColumn)current).getFeature());
			} else if(current instanceof ReferenceColumn) {
				this.initialDirectFeatureSelected.add(((ReferenceColumn)current).getFeature());
			} else if(current instanceof FacetAttributeColumn) {
				this.initialAdditionalFeatureSelected.add(((FacetAttributeColumn)current).getAttribute());
			} else if(current instanceof FacetReferenceColumn) {
				this.initialAdditionalFeatureSelected.add(((FacetReferenceColumn)current).getReference());
			}
			//FIXME : others kinds of columns are not managed

		}

		for(final Column current : papyrusTable.getTable().getColumns()) {
			if(current instanceof FeatureColumn) { //FIXME and other columns ?
				final EStructuralFeature feature = ((FeatureColumn)current).getFeature();
				//3. we associate each features to each columns
				assert feature != null;
				this.columnsFeatureMap.put(feature, current);

				//3 bis. we build the list of the initialSelection
				if(feature instanceof FacetStructuralFeature) {
					final FacetSet set = getRootFacetSet(feature);
					this.facetSetsUsedInTheTable.add(set);
				}
			}
		}

		//4. get the additional features
		final EPackage additionalContentsPackageRoot = AdditionalContentsUtils.getAdditionalContentsEPackage(papyrusTable);
		if(additionalContentsPackageRoot != null) {
			final List<EPackage> sets = additionalContentsPackageRoot.getESubpackages();
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
		final PapyrusTableInstance papyrusTable = getPapyrusTable();
		final NatTableWidget widget = getTableWidget();
		final TransactionalEditingDomain domain = getEditingDomain();
		if(papyrusTable != null && widget != null) {
			initField(widget, papyrusTable);
			final Collection<ETypedElement> initialSelection = new ArrayList<ETypedElement>();
			initialSelection.addAll(this.initialDirectFeatureSelected);
			initialSelection.addAll(this.initialAdditionalFeatureSelected);
			final Collection<ENamedElement> allFacetSets = new TreeSet<ENamedElement>(new ENamedElementComparator());
			allFacetSets.addAll(this.facetSetsUsedInTheTable);
			allFacetSets.addAll(this.allAdditionalContents);

			SortedFeaturesContentProvider contentProvider = new SortedFeaturesContentProvider();
			//			contentProvider.setInitialSelection((Collection<?>)initialSelection);
			final ColumnsToShowDialog dialog = new ColumnsToShowDialog(Display.getCurrent().getActiveShell(), this.allDirectFeatures, allFacetSets, initialSelection, getLabelProvider(), contentProvider);
			if(dialog.open() == Window.OK) {
				final Object[] result = dialog.getResult();
				final Set<ETypedElement> directFeatures = (Set<ETypedElement>)result[0];
				final Set<ETypedElement> additionalFeatures = (Set<ETypedElement>)result[1];
				if(!directFeatures.equals(this.initialDirectFeatureSelected)) {
					//1. get command to show/hide direct features
					final Command cmd = getShowHideDirectFeatureColumnsCommand(papyrusTable, (NatTableWidget)widget, directFeatures);
					if(cmd != null) {
						compoundCmd.append(cmd);
					}
				}

				if(!additionalFeatures.equals(this.initialAdditionalFeatureSelected)) {
					// 2. get the command to show/hide additional contents
					final Command cmd2 = getCreateDestroyAdditonalFeatureColumnsCommand(papyrusTable, (NatTableWidget)widget, additionalFeatures);
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
	protected Command getShowHideDirectFeatureColumnsCommand(final PapyrusTableInstance papyrusTable, final NatTableWidget widget, final Collection<ETypedElement> selectedFeatures) {
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

		Command showHideColumnsCommand = TableInstanceCommandFactory.createShowHideColumnCommand(widget, columnsToShow, columnsToHide, false);
		if(showHideColumnsCommand != null && showHideColumnsCommand.canExecute()) {
			compoundCmd.append(showHideColumnsCommand);
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
	 * - when the AddtionalContentsfacetSet is not required by a table -> it should be remove of the facetSet referenced by the table
	 * - when a subfacetset is required by any table -> it should be removed of the list of the subfacetset owned by the AddtionalContentsFacetSet
	 * 
	 * /!\We assume that the facet used for columns are not used in the same time for others things!
	 * 
	 * 
	 * This method is complex because, we should manage :
	 * <ul>
	 * <li>the new-selected facet feature used to create new columns</li>
	 * <li>the non-selected facet feature used to remove new columns</li>
	 * <li>the facets of the selected facet features to apply them to the table</li>
	 * <li>the facets of the non-selected facet features to unapply them to the table</li>
	 * <li>the facetset useful to store them in the additional contents EPcakge</li>
	 * <li>the facetset useless to unstore them in the additional contents EPcakge</li>
	 * <li>the creation/destruction of the additional contents EPackage</li>
	 * </ul>
	 * 
	 * 
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
	protected Command getCreateDestroyAdditonalFeatureColumnsCommand(final PapyrusTableInstance papyrusTable, final NatTableWidget widget, final Collection<ETypedElement> selectedAdditionalFeatures) {

		final CompoundCommand compoundCmd = new CompoundCommand("Show/Hide additional features command"); //$NON-NLS-1$
		final ModelSet resourceSet = (ModelSet)papyrusTable.eResource().getResourceSet();
		final Resource notationResource = resourceSet.getAssociatedResource(papyrusTable.eResource(), NotationModel.NOTATION_FILE_EXTENSION);
		final TransactionalEditingDomain domain = getEditingDomain();
		EPackage additionFeatureRootEPackage = AdditionalContentsUtils.getAdditionalContentsEPackage(papyrusTable);

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


		//3. determine which subfacet and subfacetset for additional contents are useful
		final Set<FacetSet> requiredSubFacetSets = new HashSet<FacetSet>();
		final Set<Facet> requiredFacets = new HashSet<Facet>();
		final Set<FacetSet> requiredRootFacetSet = new HashSet<FacetSet>();
		for(final ETypedElement current : selectedAdditionalFeatures) {
			if(current instanceof FacetStructuralFeature) {
				final Facet facet = (Facet)current.eContainer();
				requiredFacets.add(facet);
				requiredSubFacetSets.add((FacetSet)facet.eContainer());
				requiredRootFacetSet.add(getRootFacetSet(current));
			}
		}

		//4. determine which subfacet set for additional contents should be added to the additionalcontents epackage
		final Collection<FacetSet> facetSetsToStore = getFacetSetToStore(requiredSubFacetSets);


		//5. determine which subfacetset for additional contents are not useful in the current table
		//5 bis. determine which subfacetset for additional contents are never used in the whole model.
		final Set<FacetSet> uselessRootFacetSetsInAllExistingTable = new HashSet<FacetSet>();
		final Set<FacetSet> uselessRootFacetSetsInCurrentTable = new HashSet<FacetSet>();
		if(additionFeatureRootEPackage != null) {
			for(final EPackage set : additionFeatureRootEPackage.getESubpackages()) {
				if(set instanceof FacetSet && !requiredRootFacetSet.contains(set)) {
					uselessRootFacetSetsInCurrentTable.add((FacetSet)set);
					final TreeIterator<EObject> it = set.eAllContents();
					boolean useless = true;
					while(it.hasNext() && useless) {
						final EObject value = it.next();
						if(value instanceof FacetStructuralFeature) {
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
						uselessRootFacetSetsInAllExistingTable.add((FacetSet)set);
					}
				}
			}
		}

		// 6.we calculate the new registered FacetSet for the addition contents facetset
		final Collection<FacetSet> newRegisteredRootFacetSetValue = new HashSet<FacetSet>();
		final Collection<FacetSet> oldRegisteredRootFacetSetValue = new HashSet<FacetSet>();
		if(additionFeatureRootEPackage != null) {
			for(final EPackage current : additionFeatureRootEPackage.getESubpackages()) {
				if(current instanceof FacetSet) {
					oldRegisteredRootFacetSetValue.add((FacetSet)current);
				}
			}
		}
		newRegisteredRootFacetSetValue.addAll(oldRegisteredRootFacetSetValue);
		newRegisteredRootFacetSetValue.addAll(facetSetsToStore);
		newRegisteredRootFacetSetValue.removeAll(uselessRootFacetSetsInAllExistingTable);


		// 7.store/unstore the generated facetsets used by columns
		if(additionFeatureRootEPackage == null && newRegisteredRootFacetSetValue.size() != 0) {
			additionFeatureRootEPackage = AdditionalContentsUtils.createAdditionalContentsEPackage();
			compoundCmd.append(addToResourceAdditionalContentsEPackage(domain, notationResource, additionFeatureRootEPackage));
			compoundCmd.append(storeProfileFacetSet(domain, notationResource, additionFeatureRootEPackage, facetSetsToStore));
		} else if(additionFeatureRootEPackage != null && !newRegisteredRootFacetSetValue.equals(oldRegisteredRootFacetSetValue)) {
			compoundCmd.append(storeProfileFacetSet(domain, notationResource, additionFeatureRootEPackage, facetSetsToStore));
			compoundCmd.append(unstoreProfileFacetSet(domain, notationResource, additionFeatureRootEPackage, uselessRootFacetSetsInAllExistingTable));
		}


		//8. get the command to create columns
		if(columnsToCreate.size() != 0) {
			final Command createColumns = createAddColumnsCommand(domain, papyrusTable, columnsToCreate);
			if(createColumns != null && createColumns.canExecute()) {
				compoundCmd.append(createColumns);
			}
		}

		//9. get the command to destroy columns (only if the AdditionContentsFacetSet continues to be referenced by the current table. If not, the columns will be automatically destroyed
		if(additionalFeaturesToHide.size() != 0) {//&& !removeAdditionalContentsFacetSetFromTheCurrentTable) {
			final Command removeColumns = createRemoveColumnsCommand(domain, papyrusTable, additionalFeaturesToHide);
			if(removeColumns != null && removeColumns.canExecute()) {
				compoundCmd.append(removeColumns);
			}
		}


		//10. if the addition contents epackage is useless, we destroy it
		if(newRegisteredRootFacetSetValue.size() == 0 && additionFeatureRootEPackage != null) {
			compoundCmd.append(removeFromNotationResourceAdditionalContentsEPackage(domain, notationResource, additionFeatureRootEPackage));
		}


		//11. we add the command to apply the required facet to the table
		final Collection<Facet> facetsToSetInTableContext = getFacetsToApplyOnTheTable(papyrusTable, requiredFacets);
		compoundCmd.append(updateFacetsAppliedToTheTable(domain, papyrusTable, facetsToSetInTableContext));//the selected facets

		if(!compoundCmd.isEmpty()) {
			return compoundCmd;
		}
		return null;
	}

	private Collection<Facet> getFacetsToApplyOnTheTable(final PapyrusTableInstance papyrusTable, final Collection<Facet> requiredFacets) {
		final Collection<Facet> facetsForOtherThings = getFacetUsedForOtherThingsThanColumns(papyrusTable);
		final Collection<Facet> facetsToSetInTableContext = new ArrayList<Facet>();
		facetsToSetInTableContext.addAll(facetsForOtherThings);
		facetsToSetInTableContext.addAll(requiredFacets);
		return facetsToSetInTableContext;
	}

	private Collection<FacetSet> getFacetSetToStore(Set<FacetSet> requiredSubFacetSets) {
		final Set<FacetSet> toAddToResource = new HashSet<FacetSet>();
		for(final FacetSet set : requiredSubFacetSets) {
			if(set.eResource() == null) {
				toAddToResource.add(getRootFacetSet(set));
			}
		}
		return toAddToResource;
	}

	private Collection<FacetSet> getAllOwnedFacetSet(final FacetSet set) {
		final Collection<FacetSet> coll = new ArrayList<FacetSet>();
		if(set instanceof ProfileFacetSet) {
			for(final ProfileFacetSet profileSet : ((ProfileFacetSet)set).getSubProfileFacetSet()) {
				coll.add(profileSet);
				coll.addAll(getAllOwnedFacetSet(profileSet));
			}
		}
		return coll;
	}

	private Collection<FacetSet> getOwnedFacetSets(EPackage additionFeatureRootFacetSet) {
		final Collection<FacetSet> ownedFacetSets = new ArrayList<FacetSet>();
		for(final EPackage pack : additionFeatureRootFacetSet.getESubpackages()) {
			if(pack instanceof FacetSet) {
				ownedFacetSets.add((FacetSet)pack);
			}
		}
		return ownedFacetSets;
	}




	/**
	 * 
	 * @return
	 *         the editing domain used by this handler or <code>null</code> if not found
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain domain = null;
		domain = TransactionUtil.getEditingDomain(getPapyrusTable());
		return domain;
	}

	/**
	 * 
	 * @return
	 *         the current table editor, or <code>null</code> if not found
	 */
	private AbstractNattableEditor getCurrentTableEditor() {
		ISelection platformSelection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(platformSelection instanceof IStructuredSelection) {
			final IStructuredSelection selection = (IStructuredSelection)platformSelection;
			final Object current = selection.getFirstElement();
			if(current instanceof EObject) {

				IEditorPart part = null;
				try {
					part = ServiceUtilsForResource.getInstance().getNestedActiveIEditorPart(((EObject)current).eResource());
				} catch (final ServiceException e) {
					Activator.log.error(e);
				}
				if(part instanceof AbstractNattableEditor) {
					return (AbstractNattableEditor)part;
				}

			} else {//there is not select when click on a gray part of the table
				final IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(part instanceof AbstractMultiPageSashEditor) {
					final IEditorPart editorPart = ((AbstractMultiPageSashEditor)part).getActiveEditor();
					if(editorPart instanceof AbstractNattableEditor) {
						return (AbstractNattableEditor)editorPart;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the papyrus table
	 */
	protected PapyrusTableInstance getPapyrusTable() {
		final IEditorPart part = getCurrentTableEditor();
		if(part != null) {
			return (PapyrusTableInstance)part.getAdapter(PapyrusTableInstance.class);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the table widget
	 */
	protected NatTableWidget getTableWidget() {
		final IAdaptable editor = getCurrentTableEditor();
		if(editor != null) {
			final INatTableWidgetProvider provider = (INatTableWidgetProvider)editor.getAdapter(INatTableWidgetProvider.class);
			if(provider != null) {
				return (NatTableWidget)provider.getNatTableWidget();
			}
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



	private Command createAddColumnsCommand(final TransactionalEditingDomain domain, final PapyrusTableInstance pTable, final Collection<ETypedElement> columnsToAdd) {
		final CompoundCommand cmd = new CompoundCommand("Create New Columns");
		final ICommandFactory factory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(domain);
		final int width = 100;
		for(final ETypedElement current : columnsToAdd) {
			if(current instanceof FacetAttribute) {
				FacetAttributeColumn col = TableinstanceFactory.eINSTANCE.createFacetAttributeColumn();
				col.setAttribute((FacetAttribute)current);
				col.setWidth(width);
				Command addCommand = factory.createAddCommand(domain, pTable.getTable(), TableinstancePackage.eINSTANCE.getTableInstance_Columns(), col);
				if(addCommand.canExecute()) {
					cmd.append(addCommand);
				}
			} else if(current instanceof FacetReference) {
				FacetReferenceColumn col = TableinstanceFactory.eINSTANCE.createFacetReferenceColumn();
				col.setReference((FacetReference)current);
				col.setWidth(width);
				Command addCommand = factory.createAddCommand(domain, pTable.getTable(), TableinstancePackage.eINSTANCE.getTableInstance_Columns(), col);
				if(addCommand.canExecute()) {
					cmd.append(addCommand);
				}
			}
			//FIXME : and others kind of columns?
		}
		if(cmd.canExecute()) {
			return cmd;
		}
		return null;
	}

	private Command createRemoveColumnsCommand(final TransactionalEditingDomain domain, final PapyrusTableInstance pTable, final Collection<ETypedElement> columnsToDestroy) {
		final CompoundCommand cmd = new CompoundCommand("Destroy existing Columns");
		final ICommandFactory factory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(domain);
		for(final ETypedElement current : columnsToDestroy) {
			if(current instanceof EStructuralFeature) {
				Column column = columnsFeatureMap.get(current);
				Command rmColumnCmd = factory.createRemoveCommand(domain, pTable.getTable(), TableinstancePackage.eINSTANCE.getTableInstance_Columns(), column);
				if(rmColumnCmd.canExecute()) {
					cmd.append(rmColumnCmd);
				}
			}
		}
		if(cmd.canExecute()) {
			return cmd;
		}
		return null;
	}


	/**
	 * 
	 * @param papyrusTable
	 *        the papyrus table
	 * @return
	 *         the collection of FacetSet which are not used for columns, but for other stuff
	 */
	private Collection<Facet> getFacetUsedForOtherThingsThanColumns(final PapyrusTableInstance papyrusTable) {
		final Set<Facet> setForOtherThings = new HashSet<Facet>();
		for(final Facet current : papyrusTable.getTable().getFacets2()) {
			//setForOtherThings.add(getRootFacetSet(current));
			setForOtherThings.add(current);
		}
		for(final Column current : papyrusTable.getTable().getColumns()) {
			if(current instanceof FeatureColumn) {
				final ETypedElement element = ((FeatureColumn)current).getFeature();
				if(element instanceof FacetStructuralFeature) {
					setForOtherThings.remove(((FacetStructuralFeature)element).eContainer());
				}
			}
		}
		return setForOtherThings;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param res
	 *        a resource
	 * @param pack
	 *        the package to remove from resource
	 * @return
	 *         the command to remove the packge from the resource
	 */
	public static final Command removeFromNotationResourceAdditionalContentsEPackage(final TransactionalEditingDomain domain, final Resource resource, final EPackage pack) {
		final ICommand removeFacetSet = new AbstractTransactionalCommand(domain, "Remove FacetSet from the resource", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				resource.getContents().remove(pack);
				return CommandResult.newOKCommandResult();
			}
		};
		return new GMFtoEMFCommandWrapper(removeFacetSet);
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param resource
	 *        the resource
	 * @param ePackage
	 *        the package to add to the resource
	 * @return
	 *         the command to add the package from the resource
	 */
	public static final Command addToResourceAdditionalContentsEPackage(final TransactionalEditingDomain domain, final Resource resource, final EPackage ePackage) {
		final ICommand removeFacetSet = new AbstractTransactionalCommand(domain, "Add FacetSet from the resource", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				resource.getContents().add(ePackage);
				return CommandResult.newOKCommandResult();
			}
		};
		return new GMFtoEMFCommandWrapper(removeFacetSet);
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param resource
	 *        the resource
	 * @param additionFeatureRootEPackage
	 *        the package container for the facetsets
	 * @param newRegisteredSubFacetSet
	 *        the facetsets to register
	 * @return
	 *         tehc command to register the facetset AND register their associated queries
	 */
	public static final Command storeProfileFacetSet(final TransactionalEditingDomain domain, final Resource resource, final EPackage additionFeatureRootEPackage, final Collection<FacetSet> newRegisteredSubFacetSet) {
		final CompoundCommand cc = new CompoundCommand("Store Generated facetSet and Queries");
		final ModelSet modelSet = (ModelSet)resource.getResourceSet();
		final Resource notationResource = modelSet.getAssociatedResource(resource, NotationModel.NOTATION_FILE_EXTENSION);
		for(final FacetSet set : newRegisteredSubFacetSet) {
			final Collection<ModelQuery> queriesToSave = getAllUnregisteredQueries(set);
			if(!queriesToSave.isEmpty()) {
				final ModelQuerySet querySet = QueryFactory.eINSTANCE.createModelQuerySet();
				querySet.setName("QueriesFor_" + set.getName());
				querySet.setDescription(NLS.bind("Queries used by the generated facetset {0}", set.getName()));
				querySet.getAssociatedMetamodels().add(UMLPackage.eINSTANCE);
				querySet.getAssociatedMetamodels().add(EcorePackage.eINSTANCE);
				querySet.getQueries().addAll(queriesToSave);
				final ICommand addQuerySet = new AbstractTransactionalCommand(domain, "Add QuerySetToResource", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						notationResource.getContents().add(querySet);
						return CommandResult.newOKCommandResult();
					}
				};
				cc.append(new GMFtoEMFCommandWrapper(addQuerySet));
			}

		}

		final ICommand cmd = new AbstractTransactionalCommand(domain, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				additionFeatureRootEPackage.getESubpackages().addAll(newRegisteredSubFacetSet);
				return CommandResult.newOKCommandResult();
			}
		};
		cc.append(new GMFtoEMFCommandWrapper(cmd));
		return cc;
	}

	/**
	 * 
	 * @param eobject
	 *        an eobject
	 * @return
	 *         the list of the unregistered queries referenced by the eobject
	 */
	public static final Collection<ModelQuery> getAllUnregisteredQueries(final EObject eobject) {
		final Collection<ModelQuery> allQueries = getAllQueries(eobject);
		final Collection<ModelQuery> notYetRegistered = new ArrayList<ModelQuery>();
		for(ModelQuery modelQuery : allQueries) {
			if(modelQuery.eResource() == null) {
				notYetRegistered.add(modelQuery);
			}
		}
		return notYetRegistered;
	}

	/**
	 * 
	 * @param eobject
	 *        an eobject
	 * @return
	 *         the list owning all the queries referenced by the eobject
	 */
	public static final Collection<ModelQuery> getAllQueries(final EObject eobject) {
		final Collection<ModelQuery> queries = new HashSet<ModelQuery>();
		if(eobject instanceof ProfileFacetSet) {
			for(final FacetSet set : ((ProfileFacetSet)eobject).getSubProfileFacetSet()) {
				queries.addAll(getAllQueries(set));
			}
			for(final Facet facet : ((ProfileFacetSet)eobject).getStereotypeFacets()) {
				queries.addAll(getAllQueries(facet));
			}
		} else if(eobject instanceof StereotypeFacet) {
			for(final StereotypePropertyElement feature : ((StereotypeFacet)eobject).getStereotypePropertyElements()) {
				queries.addAll(getAllQueries(feature));
			}
			queries.add(((StereotypeFacet)eobject).getConditionQuery());
		} else if(eobject instanceof FacetStructuralFeature) {
			final FacetStructuralFeature feature = (FacetStructuralFeature)eobject;
			final ModelQuery setQuery = feature.getSetQuery();
			final ModelQuery getQuery = feature.getValueQuery();
			if(setQuery != null) {
				queries.add(setQuery);
			}
			if(getQuery != null) {
				queries.add(getQuery);
			}
		}
		return queries;
	}

	/**
	 * 
	 * @param domain
	 *        the domain
	 * @param resource
	 *        the resource where the the epackage is stored
	 * @param additionFeatureRootEPackage
	 *        the epackage owning the facetset
	 * @param toRemove
	 *        the facetset to remove
	 * @return
	 *         the command to remove the facetset from the epackage AND to remove the associated queries from the resource
	 */
	public static final Command unstoreProfileFacetSet(final TransactionalEditingDomain domain, final Resource resource, final EPackage additionFeatureRootEPackage, final Collection<FacetSet> toRemove) {
		final CompoundCommand cc = new CompoundCommand("Unstore Generated facetSet and Queries");

		for(final FacetSet set : toRemove) {
			final Collection<ModelQuery> allQueries = getAllQueries(set);
			final Collection<ModelQuerySet> querySets = new ArrayList<ModelQuerySet>();
			for(final ModelQuery modelQuery : allQueries) {
				querySets.add(modelQuery.getModelQuerySet());
				final ICommand removeQuerySet = new AbstractTransactionalCommand(domain, "Add QuerySetToResource", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						resource.getContents().removeAll(querySets);
						return CommandResult.newOKCommandResult();
					}
				};
				cc.append(new GMFtoEMFCommandWrapper(removeQuerySet));
			}
		}


		final ICommand cmd = new AbstractTransactionalCommand(domain, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				additionFeatureRootEPackage.getESubpackages().removeAll(toRemove);
				return CommandResult.newOKCommandResult();
			}
		};
		cc.append(new GMFtoEMFCommandWrapper(cmd));

		return cc;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param pTable
	 *        the papyrus table
	 * @param facets
	 *        the facets to set to the table context
	 * @return
	 *         // * the command to update (clear, then addAll) the facets referenced by the table
	 */
	public static final Command updateFacetsAppliedToTheTable(final TransactionalEditingDomain domain, final PapyrusTableInstance pTable, final Collection<Facet> facets) {
		ICommand updateContext = new AbstractTransactionalCommand(domain, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				EList<Facet> currentFacets = pTable.getTable().getFacets2();
				currentFacets.clear();
				currentFacets.addAll(facets);
				return CommandResult.newOKCommandResult();
			}
		};

		return new GMFtoEMFCommandWrapper(updateContext);
	}

	@Override
	public boolean isEnabled() {
		if(getPapyrusTable() != null) {
			if(getCurrentTableEditor() instanceof AbstractUMLTableEditor) {
				return true;
			}
		}
		return false;
	}



	/**
	 * @return the allDirectFeatures
	 */
	public final SortedSet<ETypedElement> getAllDirectFeatures() {
		return allDirectFeatures;
	}



	/**
	 * @return the allAdditionalContents
	 */
	public final Collection<FacetSet> getAllAdditionalContents() {
		return allAdditionalContents;
	}



	/**
	 * @return the initialDirectFeatureSelected
	 */
	public final Collection<ETypedElement> getInitialDirectFeatureSelected() {
		return initialDirectFeatureSelected;
	}



	/**
	 * @return the initialAdditionalFeatureSelected
	 */
	public final Collection<ETypedElement> getInitialAdditionalFeatureSelected() {
		return initialAdditionalFeatureSelected;
	}



	/**
	 * @return the facetSetsUsedInTheTable
	 */
	public final Collection<FacetSet> getFacetSetsUsedInTheTable() {
		return facetSetsUsedInTheTable;
	}



	/**
	 * @return the columnsFeatureMap
	 */
	public final Map<ETypedElement, Column> getColumnsFeatureMap() {
		return columnsFeatureMap;
	}
}
