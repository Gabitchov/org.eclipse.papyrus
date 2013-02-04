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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
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
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetAttributeColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.table.controlmode.helpers.TableMoveHelper;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.profilefacet.Activator;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;

/**
 * Helper used to move the tables into the right resources when controlling a package.
 */
@SuppressWarnings({ "restriction", "deprecation" })
public final class ProfileFacetSetMoveHelper {

	private ProfileFacetSetMoveHelper() {
		//to prevent instanciation
	}

	/**
	 * returns all the tables taht should be moved for the given semantic object
	 * 
	 * @param semanticObject
	 *        the object which is related to tables
	 * @return the list of tables that are linked to the object
	 */
	public static Collection<PapyrusTableInstance> getTablesToMove(EObject semanticObject) {
		return TableMoveHelper.getPapyrusTableInstances(semanticObject);
	}

	public static Command createMergeFacetSetsCommand(EditingDomain domain, EObject selection, Resource sourceResource, Resource targetResource) {
		final Collection<PapyrusTableInstance> pTables = TableMoveHelper.getPapyrusTableInstances(selection);
//		if(pTables == null || pTables.isEmpty()) {
//			return null;
//		}
		return createMergeFacetSetsCommand(domain, pTables, sourceResource, targetResource); 
	}
	
	public static Command createMergeFacetSetsCommand(EditingDomain domain, Collection<PapyrusTableInstance> pTables, Resource sourceResource, Resource targetResource) {
		if(!(domain instanceof TransactionalEditingDomain)) {
			Activator.log.error("the editing domain is not transactional", null);
			return UnexecutableCommand.INSTANCE;
		}
		if(!(sourceResource instanceof XMIResource && targetResource instanceof XMIResource)) {
			Activator.log.error("Resources are not XMI resources", null);
			return UnexecutableCommand.INSTANCE;
		}
		
		if(!pTables.isEmpty()) {
			CompoundCommand compoundCommand = new CompoundCommand();
			for(PapyrusTableInstance papyrusTableInstance : pTables) {
				MergeFacetSetsCommand mergeCommand = new MergeFacetSetsCommand((TransactionalEditingDomain)domain, papyrusTableInstance, (XMIResource)sourceResource, (XMIResource)targetResource);
				compoundCommand.append(new GMFtoEMFCommandWrapper(mergeCommand));	
			}
			return compoundCommand;	
		}
		return null;
	}

	public static void addAllFacetSetMoveCommands(EditingDomain domain, EObject selection, Resource source, final Resource target, CompoundCommand commandToModify) {
		// warning: cast is not checked here. Some tests should be performed to be more stable
		Command command = createMergeFacetSetsCommand(domain, selection, (XMIResource)source, (XMIResource)target);
		if(command != null) {
			commandToModify.append(command);
		}
	}

//	/**
//	 * 
//	 * @param domain
//	 *        the editing domain
//	 * @param sourceResource
//	 *        the sourceResource resource
//	 * @param targetResource
//	 *        the target resource
//	 * @param tables
//	 *        the list of the controlled tables
//	 * @param sourceFacetSets
//	 *        the facetsets referenced by the sourceResource resource
//	 * @param targetFacetSets
//	 *        the facetsets referenced by the target resource
//	 * @param sourceResource
//	 *        the additional contents EPackage sourceResource
//	 * @param target
//	 *        the additional contents EPackage target
//	 * @return
//	 *         the command to merge the contents of the Epakche sourceResource into the EPackage target AND duplicating the required ModelQuerySet
//	 *         referenced
//	 *         by the sourceResource FacetSets
//	 */
//	private static Command getMergeAdditionalContentsEPackageCommand(final TransactionalEditingDomain domain, final XMIResource sourceResource, final XMIResource targetResource, final Collection<PapyrusTableInstance> tables, final Collection<FacetSet> sourceFacetSets, Collection<FacetSet> targetFacetSets, EPackage source) {
//		final CompoundCommand compoundCommand = new CompoundCommand("Merge additional epackage contents"); //$NON-NLS-1$
//		//1. we init the maps
//		final Map<ModelQuerySet, ModelQuerySet> sourceVSTargetModelQuerySet = new HashMap<ModelQuerySet, ModelQuerySet>();
//		final Map<String, FacetSet> sourceMap = new HashMap<String, FacetSet>();
//		for(final FacetSet current : sourceFacetSets) {
//			final String XMI_ID = sourceResource.getID(current);
//			sourceMap.put(XMI_ID, current);
//		}
//		final Map<String, FacetSet> targeteMap = new HashMap<String, FacetSet>();
//		for(final FacetSet current : targetFacetSets) {
//			final String XMI_ID = targetResource.getID(current);
//			targeteMap.put(XMI_ID, current);
//		}
//
//		//2. we look for the facet set to create
//		for(final String XMI_ID : sourceMap.keySet()) {
//			final FacetSet sourceFacetSet = sourceMap.get(XMI_ID);
//			final FacetSet targetFacetSet = targeteMap.get(XMI_ID);
//			if(targetFacetSet == null) {
//				//we create the facetset
//				final Copier copier = new Copier();
//				final FacetSet copy = (FacetSet)copier.copy(sourceFacetSet);
//				final ModelQuerySet modelQuerySet = ModelQuerySetUtil.getModelQuerySet(sourceFacetSet);
//				if(!sourceVSTargetModelQuerySet.containsKey(modelQuerySet)) {
//					final ModelQuerySet duplicatedQuerySet = (ModelQuerySet)copier.copy(modelQuerySet);
//					sourceVSTargetModelQuerySet.put(modelQuerySet, duplicatedQuerySet);
//					final ICommand addModelQuerySetToResource = new AbstractTransactionalCommand(domain, null, null) {
//
//						@Override
//						protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
//							targetResource.getContents().add(duplicatedQuerySet);
//							return CommandResult.newOKCommandResult();
//						}
//					};
//					compoundCommand.append(new GMFtoEMFCommandWrapper(addModelQuerySetToResource));
//				}
//
//				copier.copyReferences();
//				targeteMap.put(XMI_ID, copy);
//				final ICommand addFacetSetToAdditionalContentsFacetSet = new AbstractTransactionalCommand(domain, null, null) {
//
//					@Override
//					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
//						EPackage target =  AdditionalContentsUtils.getAdditionalContentsEPackage(targetResource); 
//						if(target == null) {
//							target = AdditionalContentsUtils.createAdditionalContentsEPackage();
//							targetResource.getContents().add(target);
//						}
//						target.getESubpackages().add(copy);
//						return CommandResult.newOKCommandResult();
//					}
//				};
//				compoundCommand.append(new GMFtoEMFCommandWrapper(addFacetSetToAdditionalContentsFacetSet));
//				compoundCommand.append(getCopyXMI_IDCommand(domain, copier));
//				final Command tmp = getUpdateFacetElementReferencesCommand(domain, tables, copier);
//				if(tmp != null) {
//					compoundCommand.append(tmp);
//				}
//			}
//		}
//		if(compoundCommand.isEmpty()) {
//			return null;
//		} else {
//			return compoundCommand;
//		}
//	}

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

//	/**
//	 * Gets the copy xm i_ id command.
//	 * 
//	 * @param domain
//	 *        the editing domain for the command
//	 * @param map
//	 *        the map with the sourceResource object as key and the target object as value
//	 * @return the copy xm i_ id command
//	 *         the command set the XMI_ID of the sourceResource eobject to the target eobject
//	 */
//	private static Command getCopyXMI_IDCommand(final TransactionalEditingDomain domain, final Map<EObject, EObject> map) {
//		final ICommand copyXMI_ID_Command = new AbstractTransactionalCommand(domain, "Copy XMI_ID Command", null) { //$NON-NLS-1$
//
//			@Override
//			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
//				copyXMI_ID(map);
//				return CommandResult.newOKCommandResult();
//			}
//		};
//		return new GMFtoEMFCommandWrapper(copyXMI_ID_Command);
//	}

	/**
	 * Gets the update facet element references command.
	 * 
	 * @param domain
	 *        the editing domain
	 * @param papyrusTables
	 *        the list of the controlled tables
	 * @param sourceToTarget
	 *        the map with the sourceResource element as key and the target element as value
	 * @return the update facet element references command
	 *         the command to replace each call to sourceResource element by a call to target element in the managed tables or <code>null</code> if
	 *         there is
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

//	/**
//	 * Creates the mapping between facet sets.
//	 * 
//	 * @param sourceResource
//	 *        the sourceResource FacetSet (should be the AdditionalContentsFacetSet sourceResource
//	 * @param target
//	 *        the target FacetSet (should be the AdditionalContentsFacetSet target
//	 * @return the map
//	 *         a map with the sourceResource elements as key and the target elements as values
//	 */
//	private static Map<EObject, EObject> createMappingBetweenFacetSets(final EPackage source, final EPackage target) {
//		final Map<String, EObject> sourceMap = createXMI_ID_MapForFacetSetContents(source);
//		final Map<String, EObject> targetMap = createXMI_ID_MapForFacetSetContents(target);
//		final Map<EObject, EObject> mapping = new HashMap<EObject, EObject>();
//
//		for(final String xmi_id : sourceMap.keySet()) {
//			final EObject key = sourceMap.get(xmi_id);
//			final EObject value = targetMap.get(xmi_id);
//			if(value != null) {
//				mapping.put(key, value);
//			}
//		}
//		return mapping;
//	}
//
//	/**
//	 * Creates the xm i_ i d_ map_ for first facet sets.
//	 * 
//	 * @param set
//	 *        a facetset
//	 * @return the map
//	 *         a map with the XMI_ID of the owned subFacetSet (first level only) as key and the corresponding FacetSet as value
//	 */
//	private static Map<String, FacetSet> createXMI_ID_Map_ForFirstFacetSets(final EPackage set) {
//		final Map<String, FacetSet> map = new HashMap<String, FacetSet>();
//		final XMIResource sourceRes = (XMIResource)set.eResource();
//		for(final EPackage current : set.getESubpackages()) {
//			if(current instanceof FacetSet) {
//				final String XMI_ID = sourceRes.getID(current);
//				map.put(XMI_ID, (FacetSet)current);
//			}
//		}
//		return map;
//	}
//
//	/**
//	 * Creates the xm i_ i d_ map for facet set contents.
//	 * 
//	 * @param set
//	 *        a facetset
//	 * @return the map
//	 *         a map with the XMI_ID of the facet as key and its eobject as value
//	 */
//	private static Map<String, EObject> createXMI_ID_MapForFacetSetContents(final EPackage set) {
//		final Map<String, EObject> map = new HashMap<String, EObject>();
//		final XMIResource resource = (XMIResource)set.eResource();
//		final Iterator<EObject> iter = set.eAllContents();
//		while(iter.hasNext()) {
//			final EObject key = iter.next();
//			final String XMI_ID = resource.getID(key);
//			map.put(XMI_ID, key);
//		}
//		return map;
//	}

	public static class MergeFacetSetsCommand extends AbstractTransactionalCommand {

		/** table instance to move */
		private PapyrusTableInstance papyrusTableInstance;

		/** sourceResource resource */
		private XMIResource sourceResource;

		/** target resource, where the table instance will be located */
		private XMIResource targetResource;

		/**
		 * Constructor.
		 * 
		 * @param domain
		 * @param label
		 * @param options
		 * @param affectedFiles
		 */
		public MergeFacetSetsCommand(TransactionalEditingDomain domain, PapyrusTableInstance papyrusTableInstance, XMIResource sourceResource, final XMIResource targetResource) {
			super(domain, "Merge Facet Sets", null, Arrays.asList(WorkspaceSynchronizer.getFile(sourceResource), WorkspaceSynchronizer.getFile(targetResource)));
			this.papyrusTableInstance = papyrusTableInstance;
			this.sourceResource = sourceResource;
			this.targetResource = targetResource;

		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// init... 
			final Set<Facet> facetsUsed = new HashSet<Facet>(papyrusTableInstance.getTable().getFacets2());
			final Set<FacetSet> facetsets = new HashSet<FacetSet>();
			final Map<ModelQuerySet, ModelQuerySet> sourceVSTargetModelQuerySet = new HashMap<ModelQuerySet, ModelQuerySet>();
			final Map<String, FacetSet> sourceMap = new HashMap<String, FacetSet>();
			final Map<String, FacetSet> targetMap = new HashMap<String, FacetSet>();

			for(Facet facet : facetsUsed) {
				final FacetSet facetset = getRootFacetSet(facet);
				if(facetset.eResource() == sourceResource) {
					facetsets.add(facetset);
				}
			}
			if(!facetsets.isEmpty()) {

				for(final FacetSet current : facetsets) {
					final String XMI_ID = sourceResource.getID(current);
					sourceMap.put(XMI_ID, current);
				}

				for(final FacetSet current : facetsets) {
					final String XMI_ID = targetResource.getID(current);
					targetMap.put(XMI_ID, current);
				}
			} else {
				// no facet sets to migrate: end of the command
				return CommandResult.newOKCommandResult();
			}

			EPackage additionalEPackageTarget = AdditionalContentsUtils.getAdditionalContentsEPackage(targetResource);

			// if target EPackage does not exists => migrate
			if(additionalEPackageTarget == null) {
				// create additional EPackge in target
				additionalEPackageTarget = AdditionalContentsUtils.createAdditionalContentsEPackage();
				// append to the resource
				targetResource.getContents().add(additionalEPackageTarget);
			}

			CompoundCommand compoundCommand = new CompoundCommand();
			for(final String XMI_ID : sourceMap.keySet()) {
				final FacetSet sourceFacetSet = sourceMap.get(XMI_ID);
				final FacetSet targetFacetSet = targetMap.get(XMI_ID);

				// the facet se tdoes not exists in the target resource
				if(targetFacetSet == null) {

					// duplication of the facet set from the sourceResource
					final Copier copier = new Copier();
					final FacetSet copy = (FacetSet)copier.copy(sourceFacetSet);
					final ModelQuerySet modelQuerySet = ModelQuerySetUtil.getModelQuerySet(sourceFacetSet);
					if(!sourceVSTargetModelQuerySet.containsKey(modelQuerySet)) {
						final ModelQuerySet duplicatedQuerySet = (ModelQuerySet)copier.copy(modelQuerySet);
						sourceVSTargetModelQuerySet.put(modelQuerySet, duplicatedQuerySet);
						targetResource.getContents().add(duplicatedQuerySet);
					}

					copier.copyReferences();
					targetMap.put(XMI_ID, copy);
					additionalEPackageTarget.getESubpackages().add(copy);

					copyXMI_ID(copier);
					final Command tmp = getUpdateFacetElementReferencesCommand(getEditingDomain(), Arrays.asList(papyrusTableInstance), copier);
					if(tmp != null) {
						compoundCommand.append(tmp);
					}
				}
			}

			if(compoundCommand.canExecute()) {
				compoundCommand.execute();
			}

			return CommandResult.newOKCommandResult();
		}
	}

	/**
	 * Copy the xmi for each couple key/value, copying the identifier of the key as the identifier of the target
	 * 
	 * @param map
	 *        the map that contains all source and target objects
	 */
	public static void copyXMI_ID(Map<EObject, EObject> map) {
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
	}

}
