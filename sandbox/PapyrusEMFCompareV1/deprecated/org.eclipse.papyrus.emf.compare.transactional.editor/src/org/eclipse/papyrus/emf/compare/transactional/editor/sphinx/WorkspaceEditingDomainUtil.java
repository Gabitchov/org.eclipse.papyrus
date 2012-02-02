/**
 * <copyright>
 * 
 * Copyright (c) 2008-2010 See4sys, BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     See4sys - Initial API and implementation
 *     BMW Car IT - Added/Updated javadoc
 * 
 * </copyright>
 */
package org.eclipse.papyrus.emf.compare.transactional.editor.sphinx;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.sphinx.emf.domain.IContainerEditingDomainProvider;
import org.eclipse.sphinx.emf.edit.TransientItemProvider;
import org.eclipse.sphinx.emf.metamodel.IMetaModelDescriptor;
import org.eclipse.sphinx.emf.model.IModelDescriptor;

/**
 * This utility class is intended to retrieve an {@linkplain EditingDomain} in various ways.
 */
public final class WorkspaceEditingDomainUtil {

	// Prevent from instantiation
	private WorkspaceEditingDomainUtil() {
	}

	/**
	 * Returns the {@link TransactionalEditingDomain editing domain} which currently contains the given {@link IFile
	 * file} in its {@link ResourceSet resource set}.
	 * 
	 * @param file
	 *            The {@link IFile file} whose current {@link TransactionalEditingDomain editing domain} is to be
	 *            retrieved.
	 * @return The {@link TransactionalEditingDomain editing domain} which contains the given {@link IFile file}, or
	 *         <code>null</code> if given {@link IFile file} isn't contained in any {@link TransactionalEditingDomain
	 *         editing domain}.
	 */
	public static TransactionalEditingDomain getCurrentEditingDomain(IFile file) {
		for (TransactionalEditingDomain editingDomain : getEditingDomains(ResourcesPlugin.getWorkspace().getRoot())) {
			if (EcorePlatformUtil.isFileLoaded(editingDomain, file)) {
				return editingDomain;
			}
		}
		return null;
	}

	/**
	 * Returns the {@link TransactionalEditingDomain editing domain} to which the given {@link IFile file} is mapped.
	 * The mapped {@link TransactionalEditingDomain editing domain} is the {@link TransactionalEditingDomain editing
	 * domain} which is used as target when loading the {@link IFile file} from the workspace.
	 * <p>
	 * Even though the mapped {@link TransactionalEditingDomain editing domain} represents the primary
	 * {@link TransactionalEditingDomain editing domain} for the given {@link IFile file} it still may happen that the
	 * {@link IFile file} gets loaded in another or "foreign" {@link TransactionalEditingDomain editing domain}. Typical
	 * reasons for this are e.g. lazy loading of one file from multiple other files which are in different
	 * {@link TransactionalEditingDomain editing domain}s or programatic action by some application.
	 * <p>
	 * 
	 * @param file
	 *            The {@link IFile file} whose mapped {@link TransactionalEditingDomain editing domain} is to be
	 *            retrieved.
	 * @return The {@link TransactionalEditingDomain editing domain} to which the given {@link IFile file} is mapped, or
	 *         <code>null</code> if given {@link IFile file} isn't mapped to any {@link TransactionalEditingDomain
	 *         editing domain}.
	 */
	public static TransactionalEditingDomain getMappedEditingDomain(IFile file) {
		if (file != null) {
			IEditingDomainProvider provider = (IEditingDomainProvider) Platform.getAdapterManager().loadAdapter(file,
					IEditingDomainProvider.class.getName());
			if (provider != null) {
				EditingDomain editingDomain = provider.getEditingDomain();
				if (editingDomain instanceof TransactionalEditingDomain) {
					return (TransactionalEditingDomain) editingDomain;
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves the {@link TransactionalEditingDomain editing domain} which the given {@link Object object} belongs to.
	 * The following types of {@link Object object}s are supported:
	 * <p>
	 * <ul>
	 * <li>{@linkplain EObject}</li>
	 * <li>{@linkplain FeatureMap.Entry}</li>
	 * <li>{@linkplain IEditingDomainProvider}</li>
	 * <li>{@linkplain IFile}</li>
	 * <li>{@linkplain IModelDescriptor}</li>
	 * <li>{@linkplain IWrapperProviderItem}</li>
	 * <li>{@linkplain Resource}</li>
	 * <li>{@linkplain ResourceSet}</li>
	 * <li>{@linkplain Transaction}</li>
	 * <li>{@linkplain TransactionalEditingDomain}</li>
	 * <li>{@linkplain URI}</li>
	 * </ul>
	 * <p>
	 * Note that it is not possible to obtain a single {@link TransactionalEditingDomain editing domain} from a
	 * {@linkplain IContainer}. You can however retrieve the collection of {@link TransactionalEditingDomain editing
	 * domain}s available on a {@linkplain IContainer} by calling {@linkplain #getEditingDomains(IContainer)}.
	 * 
	 * @param object
	 *            The object whose corresponding {@link TransactionalEditingDomain editing domain} must be returned.
	 * @return The EditingDomain the <code>object</code> corresponds with or <code>null</code> if the
	 *         <code>object</code> cannot be mapped to an {@link TransactionalEditingDomain editing domain}.
	 * @see org.eclipse.sphinx.emf.workspace.domain.WorkspaceEditingDomainManager#getEditingDomainMapping()
	 * @see #getEditingDomains(IContainer)
	 */
	public static TransactionalEditingDomain getEditingDomain(Object object) {
		if (object instanceof IModelDescriptor) {
			return getEditingDomain((IModelDescriptor) object);
		} else if (object instanceof IFile) {
			return getEditingDomain((IFile) object);
		} else if (object instanceof URI) {
			return getEditingDomain((URI) object);
		} else if (object instanceof Resource) {
			// If resource is not yet or not anymore in a resource set, then try to figure out which editing domain it
			// would belong to if it were in a resource set
			Resource resource = (Resource) object;
			if (resource.getResourceSet() == null) {
				return getEditingDomain(EcorePlatformUtil.getFile(resource));
			}
		} else if (object instanceof IWrapperItemProvider) {
			return getEditingDomain((IWrapperItemProvider) object);
		} else if (object instanceof FeatureMap.Entry) {
			return getEditingDomain((FeatureMap.Entry) object);
		} else if (object instanceof TransientItemProvider) {
			return getEditingDomain((TransientItemProvider) object);
		}

		return object != null ? TransactionUtil.getEditingDomain(object) : null;
	}

	/**
	 * Retrieves the {@link TransactionalEditingDomain editing domain} behind given {@link IModelDescriptor model
	 * descriptor}.
	 * 
	 * @param modelDescriptor
	 *            The {@link IModelDescriptor model descriptor} whose {@link TransactionalEditingDomain editing domain}
	 *            is to be retrieved.
	 * @return The {@link TransactionalEditingDomain editing domain} behind given {@link IModelDescriptor model
	 *         descriptor} or <code>null</code> if no such could be retrieved.
	 */
	public static TransactionalEditingDomain getEditingDomain(IModelDescriptor modelDescriptor) {
		if (modelDescriptor != null) {
			return modelDescriptor.getEditingDomain();
		}
		return null;
	}

	/**
	 * Retrieves the {@link TransactionalEditingDomain editing domain} corresponding to the given {@link IFile file}.
	 * Tries at first to determine the {@link TransactionalEditingDomain editing domain} which currently contains the
	 * given {@link IFile file} in its {@link ResourceSet resource set} and returns it if successful. Otherwise, the
	 * {@link TransactionalEditingDomain editing domain} to which the given {@link IFile file} is mapped is returned.
	 * 
	 * @param file
	 *            The {@link IFile file} whose {@link TransactionalEditingDomain is to be retrieved}.
	 * @return The {@link TransactionalEditingDomain editing domain} the given file belongs to, or <code>null</code> if
	 *         given {@link IFile file} doesn't belong to any {@link TransactionalEditingDomain editing domain}.
	 * @see #getCurrentEditingDomain(IFile)
	 * @see #getMappedEditingDomain(IFile)
	 */
	public static TransactionalEditingDomain getEditingDomain(IFile file) {
		TransactionalEditingDomain editingDomain = getCurrentEditingDomain(file);
		if (editingDomain != null) {
			return editingDomain;
		}
		return getMappedEditingDomain(file);
	}

	/**
	 * Retrieves the EditingDomain by a URI. Consults the active mapping to map a resource to its
	 * {@link TransactionalEditingDomain editing domain}.
	 * 
	 * @param uri
	 *            An URI (file, EMF Object's URI)
	 * @return The {@link TransactionalEditingDomain editing domain} associated with the given URI. Returns
	 *         <code>null</code> if the URI cannot be resolved to workspace file or no
	 *         {@link TransactionalEditingDomain editing domain} can be mapped through the active mapping.
	 */
	public static TransactionalEditingDomain getEditingDomain(URI uri) {
		IFile file = EcorePlatformUtil.getFile(uri);
		return getEditingDomain(file);
	}

	/**
	 * Retrieves the {@link TransactionalEditingDomain editing domain} corresponding to the object wrapped in the given
	 * IWrapperItemProvider.
	 * 
	 * @param wrapperItemProvider
	 *            The IWrapperItemProvider wrapping the Object for which the {@link TransactionalEditingDomain editing
	 *            domain} is to be retrieved.
	 * @return The {@link TransactionalEditingDomain editing domain} the wrapped Object is associated with or
	 *         <code>null</code> if the Object cannot be mapped to an {@link TransactionalEditingDomain editing domain}.
	 */
	public static TransactionalEditingDomain getEditingDomain(IWrapperItemProvider wrapperItemProvider) {
		if (wrapperItemProvider != null) {
			Object unwrapped = AdapterFactoryEditingDomain.unwrap(wrapperItemProvider);
			TransactionalEditingDomain editingDomain = getEditingDomain(unwrapped);
			if (editingDomain != null) {
				return editingDomain;
			}
			return getEditingDomain(wrapperItemProvider.getOwner());
		}
		return null;
	}

	/**
	 * Returns the {@link TransactionalEditingDomain editing domain} for the value Object of the given FeatureMap.Entry.
	 * 
	 * @param entry
	 *            A FeatureMap.Entry holding the Object for which the {@link TransactionalEditingDomain editing domain}
	 *            is to be retrieved.
	 * @return The EditingDomain the Object held by the given <code>entry</entry> corresponds with or <code>null</code>
	 *         if the Object cannot be mapped to an {@link TransactionalEditingDomain editing domain}.
	 */
	public static TransactionalEditingDomain getEditingDomain(FeatureMap.Entry entry) {
		Object unwrapped = AdapterFactoryEditingDomain.unwrap(entry);
		return getEditingDomain(unwrapped);
	}

	/**
	 * Returns the {@link TransactionalEditingDomain editing domain} for the value Object of the given
	 * ItemProviderAdapter.
	 * 
	 * @param provider
	 *            An ItemProviderAdapter holding the Object for which the {@link TransactionalEditingDomain editing
	 *            domain} is to be retrieved.
	 * @return The EditingDomain the Target held by the given
	 *         <code>provider</entry> corresponds with or <code>null</code> if the Object cannot be mapped to an
	 *         {@link TransactionalEditingDomain editing domain}.
	 */
	public static TransactionalEditingDomain getEditingDomain(TransientItemProvider provider) {
		Object target = provider.getTarget();
		return getEditingDomain(target);
	}

	/**
	 * Retrieves the {@link TransactionalEditingDomain editing domain} corresponding to the specified meta-model
	 * descriptor for the given context container.
	 * 
	 * @param container
	 *            The container to consider as context object in order to retrieve the right
	 *            {@link TransactionalEditingDomain editing domain}.
	 * @param mmDescriptor
	 *            A meta-model descriptor.
	 * @return The {@link TransactionalEditingDomain editing domain} for the specified meta-model descriptor and the
	 *         specified context container or <code>null</code> if it cannot be mapped to any
	 *         {@link TransactionalEditingDomain editing domain}.
	 */
	public static TransactionalEditingDomain getEditingDomain(IContainer container, IMetaModelDescriptor mmDescriptor) {
		if (container != null) {
			IContainerEditingDomainProvider provider = (IContainerEditingDomainProvider) Platform.getAdapterManager().loadAdapter(container,
					IContainerEditingDomainProvider.class.getName());
			if (provider != null) {
				return provider.getEditingDomain(mmDescriptor);
			}
		}
		return null;
	}

	/**
	 * Returns all {@link TransactionalEditingDomain editing domain}s in the given {@link IContainer container} (i.e.
	 * {@link IWorkspaceRoot workspace root}, {@link IProject project} or {@link IFolder folder}).
	 * 
	 * @return The collection of {@link TransactionalEditingDomain editing domain}s in given {@link IContainer
	 *         container}.
	 */
	public static Collection<TransactionalEditingDomain> getEditingDomains(IContainer container) {
		IContainerEditingDomainProvider provider = (IContainerEditingDomainProvider) Platform.getAdapterManager().loadAdapter(container,
				IContainerEditingDomainProvider.class.getName());
		if (provider != null) {
			return provider.getEditingDomains();
		}
		return Collections.emptyList();
	}

	/**
	 * Returns all {@link TransactionalEditingDomain editing domain}s that exist in the workspace.
	 * <p>
	 * This is a convenience method, fully equivalent to:
	 * 
	 * <pre>
	 * WorkspaceEditingDomainUtil.getEditingDomains(ResourcesPlugin.getWorkspace().getRoot());
	 * </pre>
	 * 
	 * </p>
	 * * @return The collection of {@link TransactionalEditingDomain editing domain}s in the workspace.
	 */
	public static Collection<TransactionalEditingDomain> getAllEditingDomains() {
		return getEditingDomains(ResourcesPlugin.getWorkspace().getRoot());
	}
}
