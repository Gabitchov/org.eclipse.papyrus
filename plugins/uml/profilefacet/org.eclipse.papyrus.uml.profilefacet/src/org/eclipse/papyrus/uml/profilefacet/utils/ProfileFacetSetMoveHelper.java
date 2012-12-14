/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Melois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetAttributeColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.exception.SashEditorException;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.infra.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.infra.table.controlmode.helpers.TableMoveHelper;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.utils.AdditionalContentsUtils;
import org.eclipse.papyrus.uml.profilefacet.utils.ModelQuerySetUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

/**
 * Helper used to move the tables into the right resources when controlling a package.
 */
public final class ProfileFacetSetMoveHelper {


	private ProfileFacetSetMoveHelper() {
		//to prevent instanciation
	}

//	public static void addAllPageRefTableMoveCommands(final TransactionalEditingDomain domain, final EObject selection, final Resource source, final Resource target, final SashWindowsMngr windowsMngr, final CompoundCommand commandToModify) {
//		//1. we get the PapyrusTable to move
//		final Collection<PapyrusTableInstance> tables = getPapyrusTableInstances(selection);
//
//		//2. add pages to the page list
//		for(final PapyrusTableInstance pTable : tables) {
//			final PageRef pageRef = DiUtils.getPageRef(source, pTable);
//			final ICommand addPageCommand = new AbstractTransactionalCommand(domain, "Add Page Command", null) { //$NON-NLS-1$
//
//				@Override
//				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
//					windowsMngr.getPageList().addPage(pageRef.getPageIdentifier());
//					try {
//						DiUtils.addPageToTabFolder(windowsMngr, pageRef);
//					} catch (final SashEditorException e) {
//						//						Activator.log.error(e);
//						return CommandResult.newErrorCommandResult(e);
//					}
//					return CommandResult.newOKCommandResult();
//				}
//			};
//
//			commandToModify.append(new GMFtoEMFCommandWrapper(addPageCommand));
//		}
//	}
//
//	/**
//	 * Adds commands to move every table that descend from the selection to the target resource.
//	 */
//	public static void addAllTableMoveCommands(EditingDomain domain, EObject selection, final Resource source, final Resource target, CompoundCommand commandToModify) {
//
//		/*
//		 * All the tables in the tables that descend from the selection.
//		 */
//		//		Iterable<EObject> allDescendingPapyrusTables = createDescendantTablesIterable(selection);
//
//		/*
//		 * Making sure the editing domain is transactional.
//		 */
//		if(!(domain instanceof TransactionalEditingDomain)) {
//			throw new RuntimeException("Unable to retrieve the transactional editing domain");////$NON-NLS-1$
//		}
//		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)domain;
//
//		/*
//		 * Moving every table from the new resource.
//		 */
//
//		final Collection<PapyrusTableInstance> pTables = getPapyrusTableInstances(selection);
//		final Collection<TableInstance2> tablesInstances = new ArrayList<TableInstance2>();
//		for(PapyrusTableInstance papyrusTableInstance : pTables) {
//			tablesInstances.add(papyrusTableInstance.getTable());
//		}
//
//		final ICommand changeResourceCommand = new AbstractTransactionalCommand(editingDomain, "", Collections.emptyList()) { //$NON-NLS-1$
//
//			@Override
//			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
//				target.getContents().addAll(pTables);
//				target.getContents().addAll(tablesInstances);
//				return CommandResult.newOKCommandResult();
//			}
//		};
//		commandToModify.append(new GMFtoEMFCommandWrapper(changeResourceCommand));
//	}
//
//
//	/**
//	 * 
//	 * @param selection
//	 *        the current selection
//	 * @return
//	 *         the list of the papyrus table instance which have the selection has context
//	 */
//	protected static Collection<PapyrusTableInstance> getPapyrusTableInstances(final EObject selection) {
//		final Collection<PapyrusTableInstance> pTables = new ArrayList<PapyrusTableInstance>();
//		Iterable<EObject> allDescendingPapyrusTables = createDescendantTablesIterable(selection);
//		for(EObject eObject : allDescendingPapyrusTables) {
//			if(eObject instanceof PapyrusTableInstance) {
//				pTables.add((PapyrusTableInstance)eObject);
//			}
//		}
//		return pTables;
//
//	}
//
//	/**
//	 * Creates an iterable containing all the Papyrus Tables that are descending from the context.
//	 * 
//	 * @author olivier melois (Atos)
//	 */
//	public static Iterable<EObject> createDescendantTablesIterable(EObject context) {
//
//		Set<EObject> result = Sets.newHashSet();
//
//		TreeIterator<EObject> eAllContents = EcoreUtil.getAllProperContents(context, true); // was context.eAllContents().
//		Iterator<EObject> contextAndDescendants = Iterators.concat(eAllContents, Iterators.singletonIterator(context));
//
//		final Predicate<Setting> keepPapyrusTableInstances = new Predicate<Setting>() {
//
//			public boolean apply(Setting setting) {
//				boolean result = true;
//				if(setting != null) {
//					EObject settingEObject = setting.getEObject();
//					result &= settingEObject instanceof PapyrusTableInstance;
//					result &= PapyrustableinstancePackage.Literals.PAPYRUS_TABLE_INSTANCE__TABLE == setting.getEStructuralFeature();
//				} else {
//					result = false;
//				}
//				return result;
//			}
//		};
//
//		/*
//		 * Predicate used to keep the usages which are PapyrusTableInstances
//		 */
//		Predicate<Setting> keepTableInstances = new Predicate<Setting>() {
//
//			public boolean apply(Setting setting) {
//				boolean result = true;
//				if(setting != null) {
//					EObject settingEObject = setting.getEObject();
//					result &= settingEObject instanceof TableInstance;
//					result &= setting.getEStructuralFeature() == TableinstancePackage.Literals.TABLE_INSTANCE__CONTEXT;
//
//					Collection<Setting> references = PapyrusEcoreUtils.getUsages(settingEObject);
//					Iterable<Setting> papyrusTableInstances = Iterables.filter(references, keepPapyrusTableInstances);
//					//Veryfing that there is at least one papyrusTableInstance
//					result = result && !Iterables.isEmpty(papyrusTableInstances);
//
//				} else {
//					result = false;
//				}
//				return result;
//			}
//		};
//
//		/*
//		 * Function to get the eObject from a setting
//		 */
//		Function<Setting, EObject> getEObject = new Function<Setting, EObject>() {
//
//			public EObject apply(Setting input) {
//				EObject settingEObject = input.getEObject();
//				Collection<Setting> references = PapyrusEcoreUtils.getUsages(settingEObject);
//				Iterable<Setting> papyrusTableInstances = Iterables.filter(references, keepPapyrusTableInstances);
//				//Getting the eobject of thie first element of this iterable.
//				return Iterables.get(papyrusTableInstances, 0).getEObject();
//			}
//
//		};
//
//		/*
//		 * For the context and his descendants :
//		 */
//		while(contextAndDescendants.hasNext()) {
//			EObject current = contextAndDescendants.next();
//			//Usages
//			Iterable<Setting> usages = PapyrusEcoreUtils.getUsages(current);
//			//Filtering to keep only papyrus table instances.
//			Iterable<Setting> tableInstanceSettings = Iterables.filter(usages, keepTableInstances);
//			//Getting the eObjects 
//			Iterable<EObject> papyrusTableInstances = Iterables.transform(tableInstanceSettings, getEObject);
//			//Adding all the kept usages.
//			Iterables.addAll(result, papyrusTableInstances);
//		}
//
//		return result;
//	}

	public static void addAllFacetSetMoveCommands(EditingDomain domain, EObject selection, Resource source, final Resource target, CompoundCommand commandToModify) {
		final Collection<PapyrusTableInstance> pTables = TableMoveHelper.getPapyrusTableInstances(selection);
		if(!pTables.isEmpty()) {
			final Set<Facet> facetsUsed = new HashSet<Facet>();
			for(PapyrusTableInstance papyrusTableInstance : pTables) {
				facetsUsed.addAll(papyrusTableInstance.getTable().getFacets2());
			}

			//1.we get the list of the facetset to move
			final Set<FacetSet> facetsets = new HashSet<FacetSet>();
			for(Facet facet : facetsUsed) {
				final FacetSet facetset = getRootFacetSet(facet);
				if(facetset.eResource() == source) {
					facetsets.add(facetset);
				}
			}
			if(!facetsets.isEmpty()) {

				//3. we look for the additionalFacetSet
				final EPackage additionalEPackageSource = AdditionalContentsUtils.getAdditionalContentsEPackage(source);
				final EPackage additionalEPackageTarget = AdditionalContentsUtils.getAdditionalContentsEPackage(target);

				//indicate if we should move the additionalFacetSet from the source to the target
				boolean moveAdditionalFacetSet = facetsets.size() != 0;
				if(additionalEPackageSource == null && additionalEPackageTarget == null) {
					//nothing to do
				} else if(additionalEPackageSource == null && additionalEPackageTarget != null) {
					//nothing to do
				} else if(additionalEPackageSource != null) {
					if(moveAdditionalFacetSet) {
						if(additionalEPackageTarget != null) {
							Command tmp = getMergeAdditionalContentsEPackageCommand((TransactionalEditingDomain)domain, (XMIResource)source, (XMIResource)target, pTables, facetsets, facetsets, additionalEPackageSource, additionalEPackageTarget);
							if(tmp != null) {
								commandToModify.append(tmp);
							}
						} else {
							//we should copy the AdditionalContentsEPackage
							final Copier copier = new Copier();
							final EPackage copy = (EPackage)copier.copy(additionalEPackageSource);

							//we copy only the required facetSet, that why we do a clear on the epackage contents
							copy.getEClassifiers().clear();
							copy.getESubpackages().clear();
							final Collection<FacetSet> duplicatedFacetSets = copier.copyAll(facetsets);
							copy.getESubpackages().addAll(duplicatedFacetSets);

							final Collection<ModelQuerySet> sets = new HashSet<ModelQuerySet>();
							for(final FacetSet current : facetsets) {
								final ModelQuerySet tmp = ModelQuerySetUtil.getModelQuerySet(current);
								if(tmp != null) {
									sets.add(tmp);
								}
							}

							final Collection<ModelQuerySet> duplicatedQuerySet = copier.copyAll(sets);
							copier.copyReferences();
							final ICommand addToResource = new AbstractTransactionalCommand((TransactionalEditingDomain)domain, "Add the copy of the Additional Content EPackage to the resource", null) { //$NON-NLS-1$

								@Override
								protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
									target.getContents().add(copy);
									target.getContents().addAll(duplicatedQuerySet);
									return CommandResult.newOKCommandResult();
								}
							};
							commandToModify.append(new GMFtoEMFCommandWrapper(addToResource));

							Command tmp2 = getUpdateFacetElementReferencesCommand((TransactionalEditingDomain)domain, pTables, copier);
							if(tmp2 != null) {
								commandToModify.append(tmp2);
							}

							commandToModify.append(getCopyXMI_IDCommand((TransactionalEditingDomain)domain, copier));
						}
					}
				}
			} else {
				throw new RuntimeException();
			}
		}
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param sourceResource
	 *        the source resource
	 * @param targetResource
	 *        the target resource
	 * @param tables
	 *        the list of the controlled tables
	 * @param sourceFacetSets
	 *        the facetsets referenced by the source resource
	 * @param targetFacetSets
	 *        the facetsets referenced by the target resource
	 * @param source
	 *        the additional contents EPackage source
	 * @param target
	 *        the additional contents EPackage target
	 * @return
	 *         the command to merge the contents of the Epakche source into the EPackage target AND duplicating the required ModelQuerySet referenced
	 *         by the source FacetSets
	 */
	private static Command getMergeAdditionalContentsEPackageCommand(final TransactionalEditingDomain domain, final XMIResource sourceResource, final XMIResource targetResource, final Collection<PapyrusTableInstance> tables, final Collection<FacetSet> sourceFacetSets, Collection<FacetSet> targetFacetSets, EPackage source, final EPackage target) {
		final CompoundCommand compoundCommand = new CompoundCommand("Merge additional epackage contents"); //$NON-NLS-1$
		//1. we init the maps
		final Map<ModelQuerySet, ModelQuerySet> sourceVSTargetModelQuerySet = new HashMap<ModelQuerySet, ModelQuerySet>();
		final Map<String, FacetSet> sourceMap = new HashMap<String, FacetSet>();
		for(final FacetSet current : sourceFacetSets) {
			final String XMI_ID = sourceResource.getID(current);
			sourceMap.put(XMI_ID, current);
		}
		final Map<String, FacetSet> targeteMap = new HashMap<String, FacetSet>();
		for(final FacetSet current : targetFacetSets) {
			final String XMI_ID = targetResource.getID(current);
			targeteMap.put(XMI_ID, current);
		}

		//2. we look for the facet set to create
		for(final String XMI_ID : sourceMap.keySet()) {
			final FacetSet sourceFacetSet = sourceMap.get(XMI_ID);
			final FacetSet targetFacetSet = targeteMap.get(XMI_ID);
			if(targetFacetSet == null) {
				//we create the facetset
				final Copier copier = new Copier();
				final FacetSet copy = (FacetSet)copier.copy(sourceFacetSet);
				final ModelQuerySet modelQuerySet = ModelQuerySetUtil.getModelQuerySet(sourceFacetSet);
				if(!sourceVSTargetModelQuerySet.containsKey(modelQuerySet)) {
					final ModelQuerySet duplicatedQuerySet = (ModelQuerySet)copier.copy(modelQuerySet);
					sourceVSTargetModelQuerySet.put(modelQuerySet, duplicatedQuerySet);
					final ICommand addModelQuerySetToResource = new AbstractTransactionalCommand(domain, null, null) {

						@Override
						protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
							targetResource.getContents().add(duplicatedQuerySet);
							return CommandResult.newOKCommandResult();
						}
					};
					compoundCommand.append(new GMFtoEMFCommandWrapper(addModelQuerySetToResource));
				}

				copier.copyReferences();
				targeteMap.put(XMI_ID, copy);
				final ICommand addFacetSetToAdditionalContentsFacetSet = new AbstractTransactionalCommand(domain, null, null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						target.getESubpackages().add(copy);
						return CommandResult.newOKCommandResult();
					}
				};
				compoundCommand.append(new GMFtoEMFCommandWrapper(addFacetSetToAdditionalContentsFacetSet));
				compoundCommand.append(getCopyXMI_IDCommand(domain, copier));
				final Command tmp = getUpdateFacetElementReferencesCommand(domain, tables, copier);
				if(tmp != null) {
					compoundCommand.append(tmp);
				}
			}
		}
		if(compoundCommand.isEmpty()) {
			return null;
		} else {
			return compoundCommand;
		}
	}


	/**
	 * 
	 * @param facet
	 *        a facet
	 * @return
	 *         the root facetset for this facet (the root facetset is maybe not the high level container)
	 */
	public static final FacetSet getRootFacetSet(final Facet facet) {
		FacetSet set = (FacetSet)facet.eContainer();
		while(set.eContainer() != null && set.eContainer() instanceof FacetSet) {
			set = (FacetSet)set.eContainer();
		}
		return set;
	}


	/**
	 * Gets the copy xm i_ id command.
	 * 
	 * @param domain
	 *        the editing domain for the command
	 * @param map
	 *        the map with the source object as key and the target object as value
	 * @return the copy xm i_ id command
	 *         the command set the XMI_ID of the source eobject to the target eobject
	 */
	private static Command getCopyXMI_IDCommand(final TransactionalEditingDomain domain, final Map<EObject, EObject> map) {
		final ICommand copyXMI_ID_Command = new AbstractTransactionalCommand(domain, "Copy XMI_ID Command", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				for(final EObject sourceValue : map.keySet()) {
					final EObject targetValue = map.get(sourceValue);
					Assert.isNotNull(targetValue);
					final XMIResource sourceRes = (XMIResource)sourceValue.eResource();
					final XMIResource targetRes = (XMIResource)targetValue.eResource();

					assert sourceRes != null;
					assert targetRes != null;
					final String XMI_ID = sourceRes.getID(sourceValue);
					targetRes.setID(targetValue, XMI_ID);
				}
				return CommandResult.newOKCommandResult();
			}
		};
		return new GMFtoEMFCommandWrapper(copyXMI_ID_Command);
	}

	/**
	 * Gets the update facet element references command.
	 * 
	 * @param domain
	 *        the editing domain
	 * @param papyrusTables
	 *        the list of the controlled tables
	 * @param sourceToTarget
	 *        the map with the source element as key and the target element as value
	 * @return the update facet element references command
	 *         the command to replace each call to source element by a call to target element in the managed tables or <code>null</code> if there is
	 *         nothing to do
	 */
	private static Command getUpdateFacetElementReferencesCommand(final TransactionalEditingDomain domain, final Collection<PapyrusTableInstance> papyrusTables, final Map<EObject, EObject> sourceToTarget) {
		final CompoundCommand updateCommand = new CompoundCommand("Update References To facet Element Command"); //$NON-NLS-1$
		final Collection<TableInstance2> tableInstances = new ArrayList<TableInstance2>();
		for(final PapyrusTableInstance pTable : papyrusTables) {
			tableInstances.add(pTable.getTable());
		}
		for(final PapyrusTableInstance pTable : papyrusTables) {
			for(final EObject eobjectSource : sourceToTarget.keySet()) {
				final EObject eobjectTarget = sourceToTarget.get(eobjectSource);
				if(eobjectSource instanceof StereotypePropertyElement) {
					final ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(eobjectSource);
					for(final Setting setting : adapter.getNonNavigableInverseReferences(eobjectSource)) {
						final EObject eobject = setting.getEObject();
						if(eobject instanceof FacetAttributeColumn || eobject instanceof FacetReferenceColumn) {
							final TableInstance t = (TableInstance)eobject.eContainer();
							if(tableInstances.contains(t)) {
								final ICommand cmd = new AbstractTransactionalCommand(domain, null, null) {

									@Override
									protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
										EcoreUtil.replace(setting, eobjectSource, eobjectTarget);
										return CommandResult.newOKCommandResult();
									}
								};
								updateCommand.append(new GMFtoEMFCommandWrapper(cmd));
							}
						}
					}
				} else if(eobjectSource instanceof Facet) {
					final ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(eobjectSource);
					for(final Setting setting : adapter.getNonNavigableInverseReferences(eobjectSource)) {
						final EObject eobject = setting.getEObject();
						if(eobject instanceof TableInstance2 && tableInstances.contains(eobject)) {
							final ICommand cmd = new AbstractTransactionalCommand(domain, null, null) {

								@Override
								protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
									EcoreUtil.replace(setting, eobjectSource, eobjectTarget);
									return CommandResult.newOKCommandResult();
								}
							};
							updateCommand.append(new GMFtoEMFCommandWrapper(cmd));
						}
					}
				}
			}
		}
		if(updateCommand.isEmpty()) {
			return null;
		}
		return updateCommand;
	}


	/**
	 * Creates the mapping between facet sets.
	 * 
	 * @param source
	 *        the source FacetSet (should be the AdditionalContentsFacetSet source
	 * @param target
	 *        the target FacetSet (should be the AdditionalContentsFacetSet target
	 * @return the map
	 *         a map with the source elements as key and the target elements as values
	 */
	private static Map<EObject, EObject> createMappingBetweenFacetSets(final EPackage source, final EPackage target) {
		final Map<String, EObject> sourceMap = createXMI_ID_MapForFacetSetContents(source);
		final Map<String, EObject> targetMap = createXMI_ID_MapForFacetSetContents(target);
		final Map<EObject, EObject> mapping = new HashMap<EObject, EObject>();

		for(final String xmi_id : sourceMap.keySet()) {
			final EObject key = sourceMap.get(xmi_id);
			final EObject value = targetMap.get(xmi_id);
			if(value != null) {
				mapping.put(key, value);
			}
		}
		return mapping;
	}

	/**
	 * Creates the xm i_ i d_ map_ for first facet sets.
	 * 
	 * @param set
	 *        a facetset
	 * @return the map
	 *         a map with the XMI_ID of the owned subFacetSet (first level only) as key and the corresponding FacetSet as value
	 */
	private static Map<String, FacetSet> createXMI_ID_Map_ForFirstFacetSets(final EPackage set) {
		final Map<String, FacetSet> map = new HashMap<String, FacetSet>();
		final XMIResource sourceRes = (XMIResource)set.eResource();
		for(final EPackage current : set.getESubpackages()) {
			if(current instanceof FacetSet) {
				final String XMI_ID = sourceRes.getID(current);
				map.put(XMI_ID, (FacetSet)current);
			}
		}
		return map;
	}

	/**
	 * Creates the xm i_ i d_ map for facet set contents.
	 * 
	 * @param set
	 *        a facetset
	 * @return the map
	 *         a map with the XMI_ID of the facet as key and its eobject as value
	 */
	private static Map<String, EObject> createXMI_ID_MapForFacetSetContents(final EPackage set) {
		final Map<String, EObject> map = new HashMap<String, EObject>();
		final XMIResource resource = (XMIResource)set.eResource();
		final Iterator<EObject> iter = set.eAllContents();
		while(iter.hasNext()) {
			final EObject key = iter.next();
			final String XMI_ID = resource.getID(key);
			map.put(XMI_ID, key);
		}
		return map;
	}

}
