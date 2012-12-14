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
package org.eclipse.papyrus.uml.profilefacet.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Column;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetAttributeColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FeatureColumn;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.commands.RemoveFromResourcecommand;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.profilefacet.messages.Messages;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Profile;

/**
 * 
 * This class provides the command to destroy all columns, ProfileFacetSet and ModelQuerySet in a ResourceSet for a profile
 * 
 */
public class ProfileFacetSetDestroyer {

	/** the reapply profile */
	final private Profile profile;

	/** the editing domain for the command */
	final private TransactionalEditingDomain domain;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param profile
	 *        tha managed profile
	 */
	public ProfileFacetSetDestroyer(final Profile profile) {
		this.profile = profile;
		domain = (TransactionalEditingDomain)EMFHelper.resolveEditingDomain(profile);
	}

	/**
	 * 
	 * @return
	 *         the command to destroy all existing querySet and facetset referecing the reapply profile
	 */
	public Command getDestroyFacetSetCommand() {
		final CompoundCommand cmd = new CompoundCommand(Messages.ProfileFacetSetDestroyer_DestroyProfileFacetSetCommand);

		if(!AdditionalContentsUtils.areAllFacetSetUniqueByResource((profile.eResource().getResourceSet()))) {
			MessageDialog.openError(Display.getDefault().getActiveShell(), Messages.ProfileFacetSetDestroyer_RemoveProfileFacetSetForReappliedProfile, Messages.ProfileFacetSetDestroyer_ErrorMessageOnDeleteProfileFacetSet);
			return null;
		}

		//1. get the list of all ProfileFacetSet for this profile
		final Collection<ProfileFacetSet> facetSets = AdditionalContentsUtils.getAllFacetSet(profile);

		//2. get the list of all StereotypeFacet owned by the previous ProfileFacetSet
		final Collection<StereotypeFacet> facets = new HashSet<StereotypeFacet>();
		for(ProfileFacetSet profileFacetSet : facetSets) {
			facets.addAll(AdditionalContentsUtils.getAllStereotypeFacets(profileFacetSet));
		}

		//3. find all PapyrusTableInstance using StereotypeFacet of the previous list
		final Map<PapyrusTableInstance, Collection<StereotypeFacet>> map = getAllPapyrusTableInstanceToManaged(profile.eResource().getResourceSet(), facets);

		//4. we build the command to destroy all Column referencing FacetStructuralFeature owned by one of the managed StereotypeFacet
		for(final PapyrusTableInstance current : map.keySet()) {
			for(final Column column : current.getTable().getColumns()) {
				if(column instanceof FacetAttributeColumn || column instanceof FacetReferenceColumn) {
					final EObject featureContainer = ((FeatureColumn)column).getFeature().eContainer();
					if(facets.contains(featureContainer)) {
						ICommand cc = new AbstractTransactionalCommand(domain, Messages.ProfileFacetSetDestroyer_RemoveColumns, null) {

							@Override
							protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								current.getTable().getColumns().remove(column);
								return null;
							}
						};
						cmd.append(new GMFtoEMFCommandWrapper(cc));
						cc = null;
					}
				}
			}

			//4.1 remove the application of the facet for the current table
			ICommand cc = new AbstractTransactionalCommand(domain, Messages.ProfileFacetSetDestroyer_RemoveFacetSetAppliedOnTheTable, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					current.getTable().getFacets2().removeAll(map.get(current));
					return null;
				}
			};
			cmd.append(new GMFtoEMFCommandWrapper(cc));


		}

		//5. we build a map, with the EPackage additional contents as key and the list of ProfileFacetSet that they own and that we should remove as value
		final Map<EPackage, Collection<ProfileFacetSet>> ePackage_ProfileFacetSet = new HashMap<EPackage, Collection<ProfileFacetSet>>();
		for(final ProfileFacetSet set : facetSets) {
			final EPackage pack = (EPackage)set.eContainer();
			if(!ePackage_ProfileFacetSet.containsKey(pack)) {
				ePackage_ProfileFacetSet.put(pack, new ArrayList<ProfileFacetSet>());
			}
			ePackage_ProfileFacetSet.get(pack).add(set);
		}

		//6. we build the command to unreference the ProfileFacetSet and their associated QuerySet
		for(final EPackage pack : ePackage_ProfileFacetSet.keySet()) {
			final Collection<ProfileFacetSet> value = ePackage_ProfileFacetSet.get(pack);

			//6.1 : remove the facetset of the EPackage
			ICommand cc = new AbstractTransactionalCommand(domain, null, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					pack.getESubpackages().removeAll(value);
					return CommandResult.newOKCommandResult();
				}
			};


			cmd.append(new GMFtoEMFCommandWrapper(cc));

			//6.2 we remove the additional contents EPackage if needed. We can't know before to execute the method in case of SEVERAL profile re-application
			cc = new AbstractTransactionalCommand(domain, null, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					if(pack.getESubpackages().size() == 0) {
						new RemoveFromResourcecommand(domain, pack.eResource(), pack).execute();
					}
					return CommandResult.newOKCommandResult();
				}
			};
			cmd.append(new GMFtoEMFCommandWrapper(cc));
			cc = null;

			//6.3 remove the QuerySet from the resource
			for(final ProfileFacetSet set : value) {
				final ModelQuerySet querySet = ModelQuerySetUtil.getModelQuerySet(set);
				if(querySet != null) {
					cmd.append(new RemoveFromResourcecommand(domain, querySet.eResource(), querySet));
				}
			}
		}
		return cmd;
	}

	/**
	 * 
	 * @param resourceSet
	 *        a {@link ResourceSet}
	 * @param allKnownFacets
	 *        the collection of the know StereotypeFacet
	 * @return
	 *         a map with {@link PapyrusTableInstance} as key and a collection of the referenced {@link StereotypeFacet} contained by allKnownFacets
	 *         that they reference
	 */
	public Map<PapyrusTableInstance, Collection<StereotypeFacet>> getAllPapyrusTableInstanceToManaged(final ResourceSet resourceSet, final Collection<StereotypeFacet> allKnownFacets) {
		final Map<PapyrusTableInstance, Collection<StereotypeFacet>> map = new HashMap<PapyrusTableInstance, Collection<StereotypeFacet>>();
		for(final PapyrusTableInstance pTable : getAllPapyrusTableInstances(resourceSet)) {
			if(!domain.isReadOnly(pTable.eResource())) {
				final Collection<StereotypeFacet> usedStereotypeFacets = new ArrayList<StereotypeFacet>();
				for(final Facet current : pTable.getTable().getFacets2()) {
					if(current instanceof StereotypeFacet && allKnownFacets.contains(current)) {
						usedStereotypeFacets.add((StereotypeFacet)current);
					}
				}
				if(!usedStereotypeFacets.isEmpty()) {
					map.put(pTable, usedStereotypeFacets);
				}
			}
		}
		return map;
	}


	/**
	 * 
	 * @param resourceSet
	 *        a resourceSet
	 * @return
	 *         a collection owning all {@link PapyrusTableInstance} owned by {@link Resource} of the {@link ResourceSet}
	 */
	public static final Collection<PapyrusTableInstance> getAllPapyrusTableInstances(final ResourceSet resourceSet) {
		final Collection<PapyrusTableInstance> allTables = new ArrayList<PapyrusTableInstance>();
		for(final Resource resource : resourceSet.getResources()) {
			for(final EObject current : resource.getContents()) {
				if(current instanceof PapyrusTableInstance) {
					allTables.add((PapyrusTableInstance)current);
				}
			}
		}
		return allTables;
	}
}
