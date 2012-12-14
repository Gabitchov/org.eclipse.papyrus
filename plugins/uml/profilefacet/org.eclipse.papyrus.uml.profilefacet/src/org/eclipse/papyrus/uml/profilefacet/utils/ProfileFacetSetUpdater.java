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
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.infra.query.QueryPackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.StringArgument;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.profilefacet.Activator;
import org.eclipse.papyrus.uml.profilefacet.generation.factory.ProfileFacetGenericFactory;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.uml2.uml.Profile;


public class ProfileFacetSetUpdater {

	final private ProfileFacetSet source;

	final private Profile profile;

	private Map<String, EObjectFacetRepresentation> currentMap;

	private Map<String, EObjectFacetRepresentation> newMap;

	final private TransactionalEditingDomain domain;

	final private ModelQuerySet sourceQuerySet;

	public ProfileFacetSetUpdater(final Profile profile, final ProfileFacetSet source) {
		this.source = source;
		this.profile = profile;
		this.sourceQuerySet = getModelQuerySet(source);
		domain = (TransactionalEditingDomain)EMFHelper.resolveEditingDomain(profile);
	}


	public static final ModelQuerySet getModelQuerySet(final EObject obj) {
		if(obj instanceof FacetStructuralFeature) {
			return ((FacetStructuralFeature)obj).getValueQuery().getModelQuerySet();
		}
		if(obj instanceof Facet) {
			return ((Facet)obj).getConditionQuery().getModelQuerySet();
		}
		if(obj instanceof FacetSet) {
			if(((FacetSet)obj).getFacets().size() != 0) {
				return getModelQuerySet(((FacetSet)obj).getFacets().get(0));
			}
		}
		return null;
	}

	public Command getUpdateCommand() {
		final CompoundCommand cmd = new CompoundCommand("Update ProfileFacetSet command");
		final ProfileFacetGenericFactory factory = new ProfileFacetGenericFactory();
		final ProfileFacetSet generatedFacetSet = factory.createProfileFacetSet(this.profile);

		this.currentMap = createMapping(this.source);
		this.newMap = createMapping(generatedFacetSet);

		//1. we update the name changes
		Command tmp = getRenameElementCommand();
		if(tmp != null) {
			if(tmp.canExecute()) {
				cmd.append(tmp);
			} else {
				Activator.log.warn("Rename ProfileFacetSet Command according to reapplied profile is not executable");
			}
		}

//		tmp = getAddElementCommand();
//		if(tmp != null) {
//			if(tmp.canExecute()) {
//				cmd.append(tmp);
//			} else {
//				Activator.log.warn("Add ProfileFacetSet element command according to reapplied profile is not executable");
//			}
//		}

		EcoreUtil.delete(generatedFacetSet);
		return cmd;
	}


	private Map<String, EObjectFacetRepresentation> createMapping(final ProfileFacetSet set) {
		final Map<String, EObjectFacetRepresentation> map = new HashMap<String, EObjectFacetRepresentation>();
		map.put(set.getRepresentedElement_XMI_ID(), set);
		final TreeIterator<EObject> iter = set.eAllContents();
		while(iter.hasNext()) {
			final EObject current = iter.next();
			if(current instanceof EObjectFacetRepresentation) {
				final String representedEObjectID = ((EObjectFacetRepresentation)current).getRepresentedElement_XMI_ID();
				map.put(representedEObjectID, (EObjectFacetRepresentation)current);
			}
		}
		return map;
	}

	private Command getRenameElementCommand() {
		final CompoundCommand cmd = new CompoundCommand("Rename Element Command");
		for(final String xmi_id : currentMap.keySet()) {
			final ENamedElement current = (ENamedElement)currentMap.get(xmi_id);
			final ENamedElement new_ = (ENamedElement)newMap.get(xmi_id);
			if(!current.getName().equals(new_.getName())) {

				//1. update the name
				CommandParameter commandParameter = new CommandParameter(current, EcorePackage.eINSTANCE.getENamedElement_Name(), new_.getName());
				cmd.append(domain.createCommand(SetCommand.class, commandParameter));

				if(current instanceof EPackage) {
					//2. update the nsURI
					commandParameter = new CommandParameter(current, EcorePackage.eINSTANCE.getEPackage_NsURI(), ((EPackage)new_).getNsURI());
					cmd.append(domain.createCommand(SetCommand.class, commandParameter));
					//3. update the nsPrefix
					commandParameter = new CommandParameter(current, EcorePackage.eINSTANCE.getEPackage_NsPrefix(), ((EPackage)new_).getNsPrefix());
					cmd.append(domain.createCommand(SetCommand.class, commandParameter));
				}
				//4. update the profile qualified name
				if(current instanceof ProfileFacetSet) {
					commandParameter = new CommandParameter(current, ProfileFacetPackage.eINSTANCE.getProfileFacetSet_ProfileQualifiedName(), ((ProfileFacetSet)new_).getProfileQualifiedName());
					cmd.append(domain.createCommand(SetCommand.class, commandParameter));
				}

				//5. update the stereotype qualified name
				if(current instanceof StereotypeFacet) {
					commandParameter = new CommandParameter(current, ProfileFacetPackage.eINSTANCE.getStereotypeFacet_StereotypeQualifiedName(), ((StereotypeFacet)new_).getStereotypeQualifiedName());
					cmd.append(domain.createCommand(SetCommand.class, commandParameter));

					final StereotypeFacet facet = (StereotypeFacet)current;
					final ModelQuery query = facet.getConditionQuery();
					final ModelQuery newQuery = ((StereotypeFacet)new_).getConditionQuery();

					//5.1 we update the query
					final Command tmp = getUpdateQueryCommand(newQuery, query);
					if(tmp != null) {
						cmd.append(tmp);
					}
				}

				//6. update the represented property
				if(current instanceof StereotypePropertyElement) {
					//we update the property qualified name
					commandParameter = new CommandParameter(current, ProfileFacetPackage.eINSTANCE.getStereotypePropertyElement_PropertyQualifiedName(), ((StereotypePropertyElement)new_).getPropertyQualifiedName());
					cmd.append(domain.createCommand(SetCommand.class, commandParameter));


					//we should update the set queries
					final ModelQuery currentSetQuery = ((StereotypePropertyElement)current).getSetQuery();
					final ModelQuery newSetQuery = ((StereotypePropertyElement)new_).getSetQuery();
					Command tmp = getUpdateQueryCommand(newSetQuery, currentSetQuery);
					if(tmp != null) {
						cmd.append(tmp);
					}

					//we should update the value queries
					final ModelQuery currentValueQuery = ((StereotypePropertyElement)current).getValueQuery();
					final ModelQuery newValueQuery = ((StereotypePropertyElement)new_).getValueQuery();

					tmp = getUpdateQueryCommand(newValueQuery, currentValueQuery);
					if(tmp != null) {
						cmd.append(tmp);
					}

				}
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}

	private Command getUpdateQueryCommand(final ModelQuery source, final ModelQuery target) {
		assert source.eResource() == null;
		assert target.eResource() != null;
		final CompoundCommand cmd = new CompoundCommand("Update Query Command");
		//5.1 update the name of the query
		CommandParameter commandParameter = new CommandParameter(target, QueryPackage.eINSTANCE.getModelQuery_Name(), source.getName());
		cmd.append(domain.createCommand(SetCommand.class, commandParameter));

		//5.2. we update the description of the setQuery
		commandParameter = new CommandParameter(target, QueryPackage.eINSTANCE.getModelQuery_Description(), source.getDescription());
		cmd.append(domain.createCommand(SetCommand.class, commandParameter));

		//5.3 update the value of the argument
		if(target instanceof ParametricQuery) {
			final ParametricQuery targetParamQuery = (ParametricQuery)target;
			final ParametricQuery sourceParamQuery = (ParametricQuery)source;

			//4. update the stereotype qualified name
			final Argument sourceArg = getArgument(sourceParamQuery, ArgumentUtils.STEREOTYPE_QUALIFIED_NAME);
			final Argument targetArg = getArgument(targetParamQuery, ArgumentUtils.STEREOTYPE_QUALIFIED_NAME);
			if(sourceArg != null) {
				assert targetArg != null;
				assert sourceArg instanceof StringArgument;
				assert targetArg instanceof StringArgument;
				commandParameter = new CommandParameter(targetArg, ParametricqueryPackage.eINSTANCE.getStringArgument_Value(), ((StringArgument)sourceArg).getValue());
				cmd.append(domain.createCommand(SetCommand.class, commandParameter));
			}
		}
		return cmd;
	}

	private Argument getArgument(final ParametricQuery query, final String argumentName) {
		for(Argument argument : query.getArguments()) {
			if(argumentName.equals(argument.getArgumentName())) {
				return argument;
			}
		}
		return null;

	}

	private Command getMultiplicityPropertyChangeCommand() {
		final CompoundCommand cmd = new CompoundCommand("Rename Element Command");
		return cmd;
	}

	private Command getPropertyTypeChangeCommand() {
		final CompoundCommand cmd = new CompoundCommand("Rename Element Command");
		//FIXME warning between reference and attribute 
		return cmd;
	}

	private Command getAddElementCommand() {
		final CompoundCommand cmd = new CompoundCommand("Add Elements Command");
		final Collection<String> currentElements = currentMap.keySet();
		final Collection<String> newElements = newMap.keySet();
		newElements.removeAll(currentElements);
		
		final Collection<ProfileFacetSet> newFacetSets = new ArrayList<ProfileFacetSet>();
		for(final String element : newElements) {
			final EObjectFacetRepresentation newElement = newMap.get(element);
			final EObjectFacetRepresentation parent = (EObjectFacetRepresentation)newElement.eContainer();
			
			
			
			
			final String parentElementId = parent.getRepresentedElement_XMI_ID();
			if(currentMap.containsKey(parentElementId)) {//we should manage it
				if(parent instanceof Facet && newElement instanceof FacetStructuralFeature) {
					CommandParameter param = new CommandParameter(parent, EcorePackage.eINSTANCE.getEClass_EStructuralFeatures(), newElement);
					cmd.append(domain.createCommand(AddCommand.class, param));
				} else if(parent instanceof FacetSet && newElement instanceof Facet) {
					CommandParameter param = new CommandParameter(parent, EcorePackage.eINSTANCE.getEPackage_EClassifiers(), newElement);
					cmd.append(domain.createCommand(AddCommand.class, param));
				} else if(parent instanceof FacetSet && newElement instanceof FacetSet) {
					CommandParameter param = new CommandParameter(parent, EcorePackage.eINSTANCE.getEPackage_ESubpackages(), newElement);
					cmd.append(domain.createCommand(AddCommand.class, param));
				}
				final Collection<ModelQuery> unsavedQueries = getAllUnsavedQueries(newElement);
				if(unsavedQueries.size() != 0) {
					CommandParameter param = new CommandParameter(this.sourceQuerySet, QueryPackage.eINSTANCE.getModelQuerySet_Queries(), unsavedQueries);
					cmd.append(domain.createCommand(AddCommand.class, param));
				}
			} else {
				//we do nothing, this element we be added in the same time as its parent
			}
		}
		return cmd;
	}

	private Command getDestroyElementCommand() {
		final CompoundCommand cmd = new CompoundCommand("Rename Element Command");
		return cmd;
	}

	private Command getMoveElementCommand() {
		final CompoundCommand cmd = new CompoundCommand("Rename Element Command");
		return cmd;
	}


	public static Collection<ModelQuery> getAllUnsavedQueries(final EObject object) {
		final Collection<ModelQuery> queries = new ArrayList<ModelQuery>();
		if(object instanceof StereotypePropertyElement) {
			final ModelQuery setQuery = ((StereotypePropertyElement)object).getSetQuery();
			if(setQuery.eResource() == null) {
				queries.add(setQuery);
			}
			final ModelQuery getQuery = ((StereotypePropertyElement)object).getValueQuery();
			if(getQuery.eResource() == null) {
				queries.add(getQuery);
			}
		} else if(object instanceof StereotypeFacet) {
			final ModelQuery conditionQuery = ((StereotypeFacet)object).getConditionQuery();
			if(conditionQuery.eResource() == null) {
				queries.add(conditionQuery);
			}
			for(final StereotypePropertyElement feature : ((StereotypeFacet)object).getStereotypePropertyElements()) {
				queries.addAll(getAllUnsavedQueries(feature));
			}
		} else if(object instanceof ProfileFacetSet) {
			for(final StereotypeFacet steFacet : ((ProfileFacetSet)object).getStereotypeFacets()) {
				queries.addAll(getAllUnsavedQueries(steFacet));
			}
			for(final ProfileFacetSet profileFacetSet : ((ProfileFacetSet)object).getSubProfileFacetSet()) {
				queries.addAll(getAllUnsavedQueries(profileFacetSet));
			}
		}
		return queries;
	}




}
