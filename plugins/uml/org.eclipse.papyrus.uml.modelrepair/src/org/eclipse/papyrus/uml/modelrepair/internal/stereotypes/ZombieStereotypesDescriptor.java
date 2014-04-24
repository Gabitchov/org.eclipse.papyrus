/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.uml.modelrepair.internal.stereotypes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;


/**
 * This is the ZombieStereotypesDescriptor type. Enjoy.
 */
public class ZombieStereotypesDescriptor {

	private final Resource resource;

	private final Element root;

	private final Set<EPackage> appliedProfileDefinitions;

	private final Multimap<EPackage, EObject> zombies = ArrayListMultimap.create();

	private final Map<EPackage, IRepairAction> suggestedActions = Maps.newHashMap();

	private final Supplier<Profile> dynamicProfileSupplier;

	private Map<EPackage, Map<IRepairAction.Kind, IRepairAction>> repairActions = Maps.newHashMap();

	public ZombieStereotypesDescriptor(Resource resource, Element root, Set<EPackage> appliedProfileDefinitions, Supplier<Profile> dynamicProfileSupplier) {
		this.resource = resource;
		this.root = root;
		this.appliedProfileDefinitions = appliedProfileDefinitions;
		this.dynamicProfileSupplier = dynamicProfileSupplier;
	}

	public void analyze(EObject stereotypeApplication) {
		EPackage schema = getEPackage(stereotypeApplication);
		if((schema == null) || !appliedProfileDefinitions.contains(schema)) {
			// It's a zombie
			zombies.put(schema, stereotypeApplication);

			if((schema != null) && !suggestedActions.containsKey(schema)) {
				suggestedActions.put(schema, computeSuggestedAction(schema));
			}
		}
	}

	public boolean hasZombies() {
		return !zombies.isEmpty();
	}

	public Resource getResource() {
		return resource;
	}

	public Collection<? extends EPackage> getZombiePackages() {
		return zombies.keySet();
	}

	public int getZombieCount(EPackage schema) {
		return zombies.get(schema).size();
	}

	public boolean repair(EPackage schema, IRepairAction repairAction, DiagnosticChain diagnostics, IProgressMonitor monitor) {
		return repairAction.repair(resource, schema, zombies.get(schema), diagnostics, monitor);
	}

	protected EPackage getEPackage(EObject object) {
		EClass eclass = object.eClass();
		return (eclass == null) ? null : eclass.getEPackage();
	}

	protected IRepairAction computeSuggestedAction(EPackage schema) {
		// Try options in our preferred order
		IRepairAction result = getRepairAction(schema, IRepairAction.Kind.APPLY_LATEST_PROFILE_DEFINITION);
		if(result.isNull()) {
			// This one is always available
			result = getRepairAction(schema, IRepairAction.Kind.NO_OP);
		}

		return result;
	}

	protected Map<IRepairAction.Kind, IRepairAction> computeFeasibleRepairActions(EPackage schema) {
		Map<IRepairAction.Kind, IRepairAction> result = Maps.newEnumMap(IRepairAction.Kind.class);

		// Always available
		result.put(IRepairAction.NO_OP.kind(), IRepairAction.NO_OP);
		result.put(DeleteAction.INSTANCE.kind(), DeleteAction.INSTANCE);
		result.put(CreateMarkersAction.INSTANCE.kind(), CreateMarkersAction.INSTANCE);

		Profile profile = findProfile(schema);
		Supplier<Profile> supplier = (profile == null) ? dynamicProfileSupplier : Suppliers.ofInstance(profile);
		IRepairAction applyProfile = new ApplyProfileAction(root, supplier);
		result.put(applyProfile.kind(), applyProfile);

		return result;
	}

	public IRepairAction getSuggestedRepairAction(EPackage schema) {
		return suggestedActions.get(schema);
	}

	public IRepairAction getRepairAction(EPackage schema, IRepairAction.Kind kind) {
		Map<IRepairAction.Kind, IRepairAction> available = repairActions.get(schema);
		if(available == null) {
			available = computeFeasibleRepairActions(schema);
			repairActions.put(schema, available);
		}

		return available.get(kind);
	}

	public List<IRepairAction> getAvailableRepairActions(EPackage schema) {
		Map<IRepairAction.Kind, IRepairAction> actions = repairActions.get(schema);
		return (actions == null) ? Collections.<IRepairAction> emptyList() : ImmutableList.copyOf(Iterables.filter(actions.values(), IRepairAction.NOT_NULL));
	}

	protected Profile findProfile(EPackage definition) {
		return UMLUtil.getProfile(definition, root);
	}
}
