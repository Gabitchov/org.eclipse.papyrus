/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.uml.search.internal.ui.query;

import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Iterables.filter;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.net4j.util.collection.Pair;
import org.eclipse.net4j.util.collection.Triplet;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareModelSet;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.uml.search.internal.ui.Activator;
import org.eclipse.papyrus.cdo.uml.search.internal.ui.open.CDOOpenElementService;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceInitializerService;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeAttribute;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeElement;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.query.CompositePapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.query.IPapyrusQueryProvider;
import org.eclipse.papyrus.uml.search.ui.query.QueryInfo;
import org.eclipse.papyrus.views.search.utils.DefaultServiceRegistryTracker;
import org.eclipse.papyrus.views.search.utils.IServiceRegistryTracker;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;


/**
 * A search-query provider for CDO model repositories.
 */
public class CDOSearchQueryProvider implements IPapyrusQueryProvider {

	public CDOSearchQueryProvider() {
		super();
	}

	@Override
	public boolean canProvideFor(URI scope) {
		return CDOUtils.isCDOURI(scope);
	}

	@Override
	public AbstractPapyrusQuery createSimpleSearchQuery(QueryInfo queryInfo) {
		Pair<String, Boolean> _searchPattern = getSearchPattern(queryInfo);
		final String searchPattern = _searchPattern.getElement1();
		final boolean isRegexMatch = _searchPattern.getElement2();

		return createOCLSearchQuery(queryInfo, new Function<Triplet<QueryInfo, CDOView, Collection<URI>>, CDOQuery>() {

			@Override
			public CDOQuery apply(Triplet<QueryInfo, CDOView, Collection<URI>> input) {
				Map<String, Object> parameters = Maps.newHashMap();
				String ocl = createOCLExpression(searchPattern, isRegexMatch, input.getElement1().isSearchAllStringAttributes(), input.getElement3(), parameters);
				CDOQuery result = input.getElement2().createQuery("ocl", ocl, UMLPackage.Literals.NAMED_ELEMENT);

				// variables referenced by the OCL query expression
				for(Map.Entry<String, ?> next : parameters.entrySet()) {
					result.setParameter(next.getKey(), next.getValue());
				}

				return result;
			}
		});
	}

	@Override
	public AbstractPapyrusQuery createAdvancedSearchQuery(QueryInfo queryInfo) {
		Pair<String, Boolean> _searchPattern = getSearchPattern(queryInfo);
		final String searchPattern = _searchPattern.getElement1();
		final boolean isRegexMatch = _searchPattern.getElement2();

		// build a multi-map of EClasses to EAttributes.  For any EClass that doesn't have
		// attributes specifically selected, add all of its attributes
		final Multimap<EClass, EAttribute> attributes = ArrayListMultimap.create();
		for(ParticipantTypeAttribute next : filter(queryInfo.getParticipantTypes(), ParticipantTypeAttribute.class)) {
			EAttribute attr = (EAttribute)next.getElement();
			attributes.put(attr.getEContainingClass(), attr);
		}
		for(ParticipantTypeElement next : filter(queryInfo.getParticipantTypes(), not(instanceOf(ParticipantTypeAttribute.class)))) {
			if(next.getElement() instanceof EClass) {
				EClass eclass = (EClass)next.getElement();
				if(!attributes.containsKey(eclass)) {
					// don't bother looking for instances of classes that have no attributes to search anyways
					if(!eclass.getEAllAttributes().isEmpty()) {
						attributes.putAll(eclass, eclass.getEAllAttributes());
					}
				}
			}
		}

		return createOCLSearchQuery(queryInfo, new Function<Triplet<QueryInfo, CDOView, Collection<URI>>, CDOQuery>() {

			@Override
			public CDOQuery apply(Triplet<QueryInfo, CDOView, Collection<URI>> input) {
				Map<String, Object> parameters = Maps.newHashMap();
				String ocl = createOCLExpression(searchPattern, isRegexMatch, attributes, input.getElement3(), parameters);
				CDOQuery result = input.getElement2().createQuery("ocl", ocl, UMLPackage.Literals.NAMED_ELEMENT);

				// variables referenced by the OCL query expression
				for(Map.Entry<String, ?> next : parameters.entrySet()) {
					result.setParameter(next.getKey(), next.getValue());
				}

				return result;
			}
		});
	}

	protected Pair<String, Boolean> getSearchPattern(QueryInfo queryInfo) {
		String searchPattern = PatternUtil.wrap(queryInfo.getQueryText(), queryInfo.isCaseSensitive(), queryInfo.isRegularExpression());
		boolean isRegexMatch = searchPattern != null;
		if(!isRegexMatch) {
			searchPattern = queryInfo.getQueryText();
		}

		return Pair.create(searchPattern, isRegexMatch);
	}

	protected AbstractPapyrusQuery createOCLSearchQuery(QueryInfo queryInfo, Function<Triplet<QueryInfo, CDOView, Collection<URI>>, CDOQuery> queryFunction) {
		IServiceRegistryTracker tracker = new DefaultServiceRegistryTracker();

		Multimap<CDOView, URI> views = getViews(queryInfo.getScope());
		List<AbstractPapyrusQuery> result = Lists.newArrayListWithCapacity(views.keySet().size());
		for(CDOView view : views.keySet()) {
			CDOQuery query = queryFunction.apply(new Triplet<QueryInfo, CDOView, Collection<URI>>(queryInfo, view, views.get(view)));

			// parameters for the server-side OCL query handler
			query.setParameter("cdoImplicitRootClass", EcorePackage.Literals.EOBJECT);

			AbstractPapyrusQuery searchQuery = new CDOPapyrusQuery(queryInfo.getQueryText(), view, query);
			result.add(searchQuery);

			try {
				// automatically clean up the view and services registry when no longer needed
				tracker.track(searchQuery, ServiceUtilsForResourceSet.getInstance().getServiceRegistry(view.getResourceSet()));
			} catch (ServiceException e) {
				Activator.log.error("Cannot track services registry for automatic clean-up.", e); //$NON-NLS-1$
			}
		}

		return CompositePapyrusQuery.compose(result);
	}

	protected Multimap<CDOView, URI> getViews(Collection<URI> scope) {
		Multimap<CDOView, URI> result = HashMultimap.create();
		Map<IInternalPapyrusRepository, CDOView> views = Maps.newHashMap();

		try {
			for(URI uri : scope) {
				IInternalPapyrusRepository repo = PapyrusRepositoryManager.INSTANCE.getRepositoryForURI(uri);
				if((repo != null) && repo.isConnected()) {
					CDOView view = views.get(repo);
					if(view == null) {
						// no view, yet, for this repo

						ServicesRegistry services = new ServicesRegistry();
						services.add(LabelProviderService.class, 10, new LabelProviderServiceImpl());
						services.add(OpenElementService.class, 10, new CDOOpenElementService());
						services.startRegistry();

						services.add(ModelSet.class, 10, new CDOAwareModelSet(PapyrusRepositoryManager.INSTANCE));
						services.add(ServiceUtilsForResourceInitializerService.class, 10, new ServiceUtilsForResourceInitializerService());
						services.startServicesByClassKeys(ModelSet.class, ServiceUtilsForResourceInitializerService.class);

						// create our own transaction for the model-set
						view = repo.getCDOView(repo.createTransaction(ServiceUtils.getInstance().getModelSet(services)));
						views.put(repo, view);
					}
					result.put(view, uri);
				}
			}
		} catch (ServiceException e) {
			Activator.log.error("Failed to initialize service registry for CDO search query.", e); //$NON-NLS-1$
		}

		return result;
	}

	/**
	 * Create the OCL query expression for a "basic" (from the user's perspective) search.
	 */
	protected String createOCLExpression(String searchPattern, boolean isRegexMatch, boolean isAllStringAttributes, Collection<URI> scope, Map<String, Object> parameters) {
		StringBuilder result = new StringBuilder();

		// parameters to pass through to OCL
		parameters.put("searchPattern", searchPattern); //$NON-NLS-1$

		// first, build the CDOResource.allInstances() select clause for the scope
		StringBuilder scopeClause = getScopeClause(scope);

		// based on the CDOResource scope clause, find the candidate NamedElements
		if(scopeClause.length() == 0) {
			// easy case.  Do an allInstances() query
			result.append("NamedElement.allInstances()"); //$NON-NLS-1$
		} else {
			// iterate the contents of resources matching the scope criteria
			result.append("eresource::CDOResource.allInstances()->select(r | ");

			result.append(scopeClause);

			// close the CDOResource.allInstances()->select(...) scope clause
			result.append(")"); //$NON-NLS-1$

			// and collect all of the NamedElements within those resources
			result.append("->collect(r | r.cdoAllProperContents(NamedElement))"); //$NON-NLS-1$
		}

		// from our candidate NamedElements, select those that match
		if(isAllStringAttributes) {
			result.append("->select(e | e.cdoMatches(searchPattern))"); //$NON-NLS-1$
		} else {
			result.append("->select(e | not e.name.oclIsUndefined() and e.name."); //$NON-NLS-1$
			if(isRegexMatch) {
				result.append("matches(searchPattern)"); //$NON-NLS-1$
			} else {
				result.append("indexOf(searchPattern) > 0"); //$NON-NLS-1$
			}

			// close the ->select(...)
			result.append(")"); //$NON-NLS-1$
		}

		return result.toString();
	}

	protected StringBuilder getScopeClause(Iterable<URI> scope) {
		StringBuilder result = new StringBuilder();

		boolean first = true;
		for(URI uri : scope) {
			String path = CDOURIUtil.extractResourcePath(uri);
			if(uri.hasTrailingPathSeparator() && !path.endsWith("/")) { //$NON-NLS-1$
				path = path + "/"; //$NON-NLS-1$
			}
			if((path.length() > 1) || (!path.startsWith("/") && (path.length() > 0))) { //$NON-NLS-1$
				if(first) {
					first = false;
				} else {
					result.append(" or "); //$NON-NLS-1$
				}

				result.append("r.path.startsWith('"); //$NON-NLS-1$
				result.append(oclQuoteString(path));
				result.append("')"); //$NON-NLS-1$
			}
		}

		return result;
	}

	/**
	 * Create the OCL query expression for an "advanced" (from the user's perspective) search.
	 */
	protected String createOCLExpression(String searchPattern, boolean isRegexMatch, Multimap<EClass, EAttribute> attributes, Collection<URI> scope, Map<String, Object> parameters) {
		StringBuilder result = new StringBuilder();

		// parameters to pass through to OCL
		parameters.put("searchPattern", searchPattern); //$NON-NLS-1$

		// first, build the CDOResource.allInstances() select clause for the scope
		StringBuilder scopeClause = getScopeClause(scope);

		// based on the CDOResource scope clause, find the candidate NamedElements
		if(scopeClause.length() == 0) {
			// easy case.  Do an allInstances() query
			result.append("NamedElement.allInstances()"); //$NON-NLS-1$
		} else {
			// iterate the contents of resources matching the scope criteria
			result.append("eresource::CDOResource.allInstances()->select(r | ");

			result.append(scopeClause);

			// close the CDOResource.allInstances()->select(...) scope clause
			result.append(")"); //$NON-NLS-1$

			// and collect all of the NamedElements within those resources
			result.append("->collect(r | r.cdoAllProperContents(NamedElement))"); //$NON-NLS-1$
		}

		// from our candidate elements, select those that match the attribute criteria
		result.append("->select(e | "); //$NON-NLS-1$

		for(EClass next : attributes.keySet()) {
			result.append("e.oclIsKindOf(").append(next.getName()).append(") and ("); //$NON-NLS-1$ //$NON-NLS-2$
			result.append("let s : ").append(next.getName()).append(" = e.oclAsType(").append(next.getName()).append(") in "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

			boolean first = true;
			for(EAttribute attr : attributes.get(next)) {
				if(first) {
					first = false;
				} else {
					result.append(" or ");
				}

				if(isString(attr)) {
					if(attr.isMany()) {
						result.append("s.").append(attr.getName()).append("->excluding(null)->exists(v | v"); //$NON-NLS-1$ //$NON-NLS-2$
					} else {
						result.append("(not s.").append(attr.getName()).append(".oclIsUndefined() and s.").append(attr.getName()); //$NON-NLS-1$ //$NON-NLS-2$
					}

					if(isRegexMatch) {
						result.append(".matches(searchPattern)"); //$NON-NLS-1$
					} else {
						result.append(" = searchPattern"); //$NON-NLS-1$
					}

					// close the exists iterator (many case) or 'and' group (scalar case)
					result.append(")"); //$NON-NLS-1$
				} else {
					// need toString() conversions.  For simplicity, because we're doing extra conversions anyways, coerce scalars to sets.
					// N.B.: toString() can produce nulls that need to be filtered out!
					result.append("s.").append(attr.getName()).append("->excluding(null).toString()->excluding(null)->exists(v | v"); //$NON-NLS-1$ //$NON-NLS-2$

					if(isRegexMatch) {
						result.append(".matches(searchPattern)"); //$NON-NLS-1$
					} else {
						result.append(" = searchPattern"); //$NON-NLS-1$
					}

					// close the exists iterator
					result.append(")"); //$NON-NLS-1$
				}
			}

			// close the let expression
			result.append(")"); //$NON-NLS-1$
		}

		// close select clause
		result.append(")"); //$NON-NLS-1$

		return result.toString();
	}

	static String oclQuoteString(String s) {
		return s.replace("'", "\\'") //$NON-NLS-1$ //$NON-NLS-2$
		.replace("\\", "\\\\"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	static boolean isString(ETypedElement element) {
		EClassifier type = element.getEType();
		return (type != null) && (type.getInstanceClass() == String.class);
	}
}
