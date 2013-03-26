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
package org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOTextResource;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.RepositoryManagerEventAdapter;
import org.eclipse.papyrus.cdo.core.util.CDOFunctions;
import org.eclipse.papyrus.cdo.core.util.CDOPredicates;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.storage.AbstractContextStorageProvider;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;


/**
 * This is the CDOContextStorageProvider type. Enjoy.
 */
public class CDOContextStorageProvider extends AbstractContextStorageProvider {

	public static final String CONTEXTS_PATH = Activator.PLUGIN_ID + ".contexts"; //$NON-NLS-1$

	public static final String CONTEXT_EXTENSION = "ctx"; //$NON-NLS-1$

	private final IInternalPapyrusRepositoryManager repoMan = PapyrusRepositoryManager.INSTANCE;

	private ResourceSet resourceSet;

	private CDOTextURIHandler uriHandler;

	private RepositoryManagerEventAdapter repositoryAdapter;

	private final Multimap<IPapyrusRepository, Context> contexts = HashMultimap.create();

	public CDOContextStorageProvider() {
		super();
	}

	@Override
	public void initialize(ResourceSet resourceSet) throws CoreException {
		this.resourceSet = resourceSet;

		uriHandler = CDOTextURIHandler.install(resourceSet);
		resourceSet.getURIConverter().getURIHandlers().add(uriHandler);

		repositoryAdapter = new RepositoryAdapter().install(repoMan);
	}

	@Override
	public void dispose() {
		if(repositoryAdapter != null) {
			repositoryAdapter.uninstall(repoMan);
			repositoryAdapter = null;

			uriHandler.uninstall();
			uriHandler = null;

			resourceSet = null;
		}

		super.dispose();
	}

	public boolean providesFor(Context context) {
		URI uri = EcoreUtil.getURI(context);
		return (uri != null) && CDOUtils.isCDOURI(uri) || CDOTextURIHandler.SCHEME.equals(uri.scheme());
	}

	public Collection<? extends Context> loadContexts() throws CoreException {
		return ImmutableList.copyOf(Iterables.concat(Iterables.transform(getRepositories(), getContexts())));
	}

	Iterable<? extends IInternalPapyrusRepository> getRepositories() {
		return Iterables.filter(repoMan.getRepositories(), IInternalPapyrusRepository.class);
	}

	Function<IInternalPapyrusRepository, Iterable<? extends Context>> getContexts() {
		return new Function<IInternalPapyrusRepository, Iterable<? extends Context>>() {

			public Iterable<? extends Context> apply(IInternalPapyrusRepository input) {
				return getContexts(input);
			}
		};
	}

	Iterable<? extends Context> getContexts(IInternalPapyrusRepository repository) {
		Iterable<? extends Context> result;

		if(!repository.isConnected()) {
			result = Collections.emptyList();
		} else {
			CDOResourceFolder folder = null;

			try {
				folder = repository.getMasterView().getResourceFolder(CONTEXTS_PATH);
			} catch (Exception e) {
				// normal consequence when the folder doesn't exist
			}

			if(folder == null) {
				result = Collections.emptyList();
			} else {
				Iterable<CDOTextResource> textNodes = Iterables.concat(Iterables.transform(folder.getNodes(), CDOFunctions.getFolderContents(CDOTextResource.class)));

				result = getContexts(textNodes);

				contexts.replaceValues(repository, result);
			}
		}

		return result;
	}

	Iterable<? extends Context> getContexts(Iterable<CDOTextResource> textResources) {
		return Iterables.filter( // null filter
		Iterables.transform( // root transform
		Iterables.transform( // resource transform
		Iterables.filter( // .ctx extension filter
		textResources, CDOPredicates.hasExtension(CONTEXT_EXTENSION)), // filter
			getContextResource()), // transform
			CDOFunctions.getRoot(Context.class)), // transform
			Predicates.notNull()); // filter
	}

	private Function<CDOTextResource, Resource> getContextResource() {
		return new Function<CDOTextResource, Resource>() {

			public Resource apply(CDOTextResource input) {
				return resourceSet.getResource(CDOTextURIHandler.createURI(input.getURI()), true);
			}
		};
	}

	@Override
	public void refreshContext(Context context) throws CoreException {
		// nothing to do
	}

	//
	// Nested types
	//

	private class RepositoryAdapter extends RepositoryManagerEventAdapter {

		RepositoryAdapter() {
			super(resourceSet);
		}

		@Override
		protected void onConnected(IPapyrusRepository repository) {
			if(repository instanceof IInternalPapyrusRepository) {
				// attach a view on this repository to the resource set
				repository.createReadOnlyView(resourceSet);

				Collection<? extends Context> added = ImmutableList.copyOf(getContexts((IInternalPapyrusRepository)repository));
				if(!added.isEmpty()) {
					fireContextsAdded(added);
				}
			}
		}

		@Override
		protected void onDisconnected(IPapyrusRepository repository) {
			Collection<? extends Context> removed = ImmutableList.copyOf(contexts.get(repository));
			if(!removed.isEmpty()) {
				contexts.removeAll(repository);
				fireContextsRemoved(removed);
			}
		}

		@Override
		protected void onInvalidation(IPapyrusRepository repository, CDOView view, CDOViewInvalidationEvent event) {
			if(view.hasResource(CONTEXTS_PATH)) {
				CDOResourceFolder folder = view.getResourceFolder(CONTEXTS_PATH);
				URI prefix = folder.getURI();
				if(!prefix.isPrefix()) {
					prefix = prefix.appendSegment(""); // add a trailing slash
				}

				// usually, it is XWT resources that change, so we have to find the contexts that own them
				Collection<CDOTextResource> contextResources = Lists.newArrayList();
				Iterable<CDOTextResource> textResources = Iterables.filter(Iterables.filter(event.getDirtyObjects(), CDOTextResource.class), CDOPredicates.hasURIPrefix(prefix));
				for(CDOTextResource next : textResources) {
					// get the context resource
					URI relative = next.getURI().deresolve(prefix);
					URI contextURI = prefix.appendSegment(relative.segment(0)).appendSegment(relative.segment(0)).appendFileExtension(CONTEXT_EXTENSION);
					String path = CDOURIUtil.extractResourcePath(contextURI);
					if(view.hasResource(path)) {
						try {
							contextResources.add(view.getTextResource(path));
						} catch (Exception e) {
							// it's not a text resource.  OK, there's something going on that we don't understand
						}
					}
				}

				Collection<Context> changed = ImmutableList.copyOf(getContexts(contextResources));
				if(!changed.isEmpty()) {
					fireContextsChanged(changed);
				}
			}
		}
	}
}
