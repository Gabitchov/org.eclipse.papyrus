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
package org.eclipse.papyrus.cdo.internal.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.model.CDOPackageRegistry;
import org.eclipse.emf.cdo.common.model.CDOPackageRegistryPopulator;
import org.eclipse.emf.cdo.common.protocol.CDOProtocolConstants;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.spi.common.model.InternalCDOPackageRegistry;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.spi.cdo.CDOMergingConflictResolver;
import org.eclipse.equinox.security.storage.EncodingUtils;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.net4j.signal.RemoteException;
import org.eclipse.net4j.util.container.Container;
import org.eclipse.net4j.util.container.ContainerEvent;
import org.eclipse.net4j.util.container.IContainerDelta;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.net4j.util.lifecycle.LifecycleException;
import org.eclipse.net4j.util.security.CredentialsProviderFactory;
import org.eclipse.net4j.util.security.ICredentialsProvider2;
import org.eclipse.net4j.util.security.NotAuthenticatedException;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.CommitException;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryListener;
import org.eclipse.papyrus.cdo.core.IResourceSetDisposalApprover;
import org.eclipse.papyrus.cdo.core.PapyrusRepositoryEvent;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareModelSet;
import org.eclipse.papyrus.cdo.core.resource.PapyrusCDOResourceFactory;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.core.repositories.Repository;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * This is the PapyrusRepository type. Enjoy.
 */
public class PapyrusRepository extends Container<CDOResourceNode> implements IInternalPapyrusRepository, IAdaptable {

	private static final String SECURE_STORE_PATH = "/" + Activator.PLUGIN_ID //$NON-NLS-1$
		+ "/repositories"; //$NON-NLS-1$

	private static final CDOResourceNode[] NO_RESOURCE_NODES = new CDOResourceNode[0];

	private final IManagedContainer container;

	private final Repository model;

	private CDOSession session;

	private final BiMap<ResourceSet, CDOView> readOnlyViews = HashBiMap.create();

	private final BiMap<ResourceSet, CDOTransaction> transactions = HashBiMap.create();

	private IListener viewListener;

	private CDOView masterView;

	private volatile CDOResourceNode[] topResourceNodes;

	private IListener masterViewListener;

	private final CompositeResourceSetDisposalApprover approvers = new CompositeResourceSetDisposalApprover();

	private final CopyOnWriteArrayList<IPapyrusRepositoryListener> listeners = new CopyOnWriteArrayList<IPapyrusRepositoryListener>();

	public PapyrusRepository(IManagedContainer container, Repository model) {
		this.container = container;
		this.model = model;

		activate();
	}

	@Override
	public String getName() {
		return model.getName();
	}

	@Override
	public void setName(String name) {
		if(Strings.isNullOrEmpty(name)) {
			throw new IllegalArgumentException("null or empty name"); //$NON-NLS-1$
		}

		model.setName(name);
	}

	@Override
	public String getURL() {
		return model.getURL();
	}

	@Override
	public String getUsername() {
		return getSecureStorageValue("username"); //$NON-NLS-1$
	}

	@Override
	public void setUsername(String username) {
		if(username != null) {
			username = username.trim();
			if(username.length() == 0) {
				username = null;
			}
		}

		setSecureStorageValue("username", username, false); //$NON-NLS-1$
	}

	@Override
	public String getPassword() {
		return getSecureStorageValue("password"); //$NON-NLS-1$
	}

	private String getSecureStorageValue(String key) {
		String result = null;

		ISecurePreferences store = SecurePreferencesFactory.getDefault();
		String path = getSecureStorePath();
		if(store.nodeExists(path)) {
			store = store.node(path);

			try {
				result = store.get(key, null);
			} catch (StorageException e) {
				Activator.log.error(String.format("Failed to load repository %s from secure storage.", key), //$NON-NLS-1$
					e);
			}
		}

		return result;
	}

	private String getSecureStorePath() {
		return String.format("%s/%s", SECURE_STORE_PATH, //$NON-NLS-1$
			EncodingUtils.encodeSlashes(getURL()));
	}

	@Override
	public void setPassword(String password) {
		setSecureStorageValue("password", password, true); //$NON-NLS-1$
	}

	private void setSecureStorageValue(String key, String value, boolean encrypt) {
		ISecurePreferences store = SecurePreferencesFactory.getDefault().node(getSecureStorePath());
		try {
			if(value == null) {
				store.remove(key);
			} else {
				store.put(key, value, encrypt);
			}
		} catch (StorageException e) {
			Activator.log.error(String.format("Failed to store repository %s in secure storage.", key), e); //$NON-NLS-1$
		}
	}

	@Override
	public void clearCredentials() {
		ISecurePreferences store = SecurePreferencesFactory.getDefault();
		String path = getSecureStorePath();
		if(store.nodeExists(path)) {
			store.node(path).removeNode();
		}
	}

	@Override
	public boolean isConnected() {
		return (session != null) && !session.isClosed();
	}

	@Override
	public IStatus connect() {
		IStatus result = Status.OK_STATUS;

		if(!isConnected()) {
			ICredentialsProvider2 creds = getCredentialsProvider();
			Object oldCreds = null;
			if(creds != null) {
				oldCreds = container.putElement(CredentialsProviderFactory.PRODUCT_GROUP, "interactive", //$NON-NLS-1$
					null, creds);
			}

			try {
				for(;;) {
					try {
						session = (CDOSession)container.getElement("org.eclipse.emf.cdo.sessions", "cdo", getURL()); //$NON-NLS-1$ //$NON-NLS-2$
					} catch (LifecycleException e) {
						// most probably we simply failed to connect to the repository
						result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.PapyrusRepository_connectFailed, e);
					} catch (RemoteException e) {
						// most probably we connected to the CDO server but the repository is not available
						result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(Messages.PapyrusRepository_badRepo, getName()), e.getCause());
					} catch (NotAuthenticatedException e) {
						// user cancelled the credentials dialog. That's OK
						result = Status.CANCEL_STATUS;
						break;
					} catch (SecurityException e) {
						// wrong credentials. If the user stored them, purge and
						// try again
						clearCredentials();

						if(creds instanceof IInteractiveCredentialsProvider) {
							((IInteractiveCredentialsProvider)creds).reportCredentialsFailure(e);
						}

						continue;
					}
					break;
				}

				if(session != null) {
					configure(session);

					// open the master view for the UI
					createReadOnlyView(new ResourceSetImpl());

					fireRepositoryEvent(PapyrusRepositoryEvent.CONNECTED);

					// update the last known UUID in the model
					String uuid = session.getRepositoryInfo().getUUID();
					if(!Objects.equal(uuid, model.getUUID())) {
						model.setUUID(uuid);
						getManager().saveRepositories();
					}
				}
			} finally {
				if(creds != null) {
					if(oldCreds != null) {
						container.putElement(CredentialsProviderFactory.PRODUCT_GROUP, "interactive", null, oldCreds); //$NON-NLS-1$
					} else {
						container.removeElement(CredentialsProviderFactory.PRODUCT_GROUP, "interactive", null); //$NON-NLS-1$
					}
				}
			}
		}

		return result;
	}

	protected final IInternalPapyrusRepositoryManager getManager() {
		return (IInternalPapyrusRepositoryManager)container.getElement(IInternalPapyrusRepositoryManager.PRODUCT_GROUP, IInternalPapyrusRepositoryManager.MANAGER_FACTORY, null);
	}

	private ICredentialsProvider2 getCredentialsProvider() {
		ICredentialsProvider2 result = null;

		ICredentialsProviderFactory factory = getManager().getCredentialsProviderFactory();

		if(factory != null) {
			result = factory.createCredentialsProvider(this);
		}

		return result;
	}

	@Override
	public void disconnect() throws CommitException {
		if(isConnected()) {
			ImmutableList<ResourceSet> dirty = ImmutableList.copyOf(Iterables.filter(transactions.keySet(), new Predicate<ResourceSet>() {

				@Override
				public boolean apply(ResourceSet input) {
					return transactions.get(input).isDirty();
				}
			}));

			switch(approvers.disposalRequested(this, dirty)) {
			case SAVE:
				for(ResourceSet next : dirty) {
					commit(next);
				}

				// intentional fall-through (save then close)
			case CLOSE:
				for(CDOView next : ImmutableList.copyOf(transactions.values())) {

					doClose(next);
				}
				for(CDOView next : ImmutableList.copyOf(readOnlyViews.values())) {

					doClose(next);
				}

				session.close();
				session = null;

				fireRepositoryEvent(PapyrusRepositoryEvent.DISCONNECTED);
				break;
			default: // NONE
				break;
			}
		}
	}

	protected void checkConnected() {
		if(!isConnected()) {
			throw new IllegalStateException("not connected"); //$NON-NLS-1$
		}
	}

	@Override
	public Collection<ResourceSet> getReadOnlyViews() {
		return Collections.unmodifiableCollection(readOnlyViews.keySet());
	}

	@Override
	public ResourceSet createReadOnlyView(ResourceSet resourceSet) {
		checkConnected();

		CDOView view = session.openView(resourceSet);
		configure(view);
		ResourceSet result = view.getResourceSet();
		readOnlyViews.put(result, view);

		if(masterView == null) {
			masterView = view;
			topResourceNodes = getElements();
			adaptMasterView(view);

			if(topResourceNodes.length > 0) {
				fireElementsAddedEvent(topResourceNodes);
			} else {
				fireEvent(); // just refresh my presentation
			}
		}

		return result;
	}

	@Override
	public Collection<ResourceSet> getTransactions() {
		return Collections.unmodifiableCollection(transactions.keySet());
	}

	@Override
	public ResourceSet createTransaction(ResourceSet resourceSet) {
		checkConnected();

		CDOTransaction transaction = session.openTransaction(resourceSet);
		configure(transaction);
		ResourceSet result = transaction.getResourceSet();
		transactions.put(result, transaction);

		return result;
	}

	@Override
	public CDOSession getCDOSession() {
		return session;
	}

	@Override
	public CDOView getMasterView() {
		return masterView;
	}

	@Override
	public CDOView getCDOView(ResourceSet resourceSet) {
		CDOView result = readOnlyViews.get(resourceSet);

		if(result == null) {
			result = transactions.get(resourceSet);
		}

		return result;
	}

	protected void removeCDOView(ResourceSet resourceSet) {
		readOnlyViews.remove(resourceSet);
		transactions.remove(resourceSet);
	}

	CDOTransaction checkTransaction(CDOView view) {
		if(!(view instanceof CDOTransaction)) {
			throw new IllegalArgumentException("not a transaction"); //$NON-NLS-1$
		}

		return (CDOTransaction)view;
	}

	@Override
	public void commit(ResourceSet transaction) throws CommitException {
		CDOView cdoView = getCDOView(transaction);

		try {
			checkTransaction(cdoView).commit();
		} catch (org.eclipse.emf.cdo.util.CommitException e) {
			throw new CommitException(e);
		}
	}

	@Override
	public void rollback(ResourceSet transaction) {
		CDOView cdoView = getCDOView(transaction);
		checkTransaction(cdoView).rollback();
	}

	@Override
	public void close(ResourceSet view) {
		CDOView cdoView = getCDOView(view);

		if(cdoView != null) {
			doClose(cdoView);
		}
	}

	protected void doClose(CDOView view) {
		try {
			if(view == masterView) {
				unadaptMasterView(view);
				masterView = null;
				CDOResourceNode[] removedNodes = topResourceNodes;
				topResourceNodes = null;
				if((removedNodes != null) && (removedNodes.length > 0)) {
					fireElementsRemovedEvent(removedNodes);
				} else {
					fireEvent(); // just refresh my presentation
				}
			}
		} finally {
			unadaptView(view);
			removeCDOView(view.getResourceSet());
			view.close();
		}
	}

	public Repository getModel() {
		return model;
	}

	protected void configure(CDOSession newSession) {
		CDOPackageRegistry registry = newSession.getPackageRegistry();
		CDOPackageRegistryPopulator.populate(registry);

		if(registry instanceof InternalCDOPackageRegistry) {
			InternalCDOPackageRegistry internalRegistry = (InternalCDOPackageRegistry)registry;
			internalRegistry.setPackageProcessor(new GMFSafePackageProcessor(internalRegistry.getPackageProcessor()));
		}
	}

	protected void configure(CDOView newReadOnlyView) {
		adaptView(newReadOnlyView);

		commonViewConfiguration(newReadOnlyView);

		// TODO: Do we need to set any other options?
	}

	protected void commonViewConfiguration(CDOView newView) {
		// CDO's default resource factory inspects the current thread's stack
		// trace to see whether the getResource(...) method of a set of known
		// ResourceSet implementation classes is in progress. We have a
		// ResourceSet implementation that CDO doesn't know about, so we need
		// our own factory
		ResourceSet rset = newView.getResourceSet();
		if(rset instanceof CDOAwareModelSet) {
			rset.getResourceFactoryRegistry().getProtocolToFactoryMap().put(CDOProtocolConstants.PROTOCOL_NAME, new PapyrusCDOResourceFactory((CDOAwareModelSet)rset));
		}
	}

	protected void configure(CDOTransaction newTransaction) {
		adaptView(newTransaction);

		commonViewConfiguration(newTransaction);

		newTransaction.options().addConflictResolver(new CDOMergingConflictResolver());
		// TODO: Do we need to set any other options?
	}

	private IListener getViewListener() {
		if(viewListener == null) {
			viewListener = new LifecycleEventAdapter() {

				@Override
				protected void onDeactivated(ILifecycle lifecycle) {
					readOnlyViews.inverse().remove(lifecycle);
					transactions.inverse().remove(lifecycle);
				}
			};
		}

		return viewListener;
	}

	private void adaptView(CDOView view) {
		view.addListener(getViewListener());
	}

	private void unadaptView(CDOView view) {
		view.removeListener(getViewListener());
	}

	private IListener getMasterViewListener() {
		if(masterViewListener == null) {
			masterViewListener = new IListener() {

				@Override
				public void notifyEvent(IEvent event) {
					if(event instanceof CDOViewInvalidationEvent) {
						CDOViewInvalidationEvent inval = (CDOViewInvalidationEvent)event;
						translateMasterViewInvalidationEvent(inval);
					}
				}
			};
		}

		return masterViewListener;
	}

	private void adaptMasterView(CDOView view) {
		view.addListener(getMasterViewListener());
	}

	private void unadaptMasterView(CDOView view) {
		view.removeListener(getMasterViewListener());
	}

	@Override
	public void addResourceSetDisposalApprover(IResourceSetDisposalApprover approver) {
		approvers.addApprover(approver);
	}

	@Override
	public void removeResourceSetDisposalApprover(IResourceSetDisposalApprover approver) {
		approvers.removeApprover(approver);
	}

	@Override
	public void addPapyrusRepositoryListener(IPapyrusRepositoryListener listener) {
		listeners.addIfAbsent(listener);
	}

	@Override
	public void removePapyrusRepositoryListener(IPapyrusRepositoryListener listener) {
		listeners.remove(listener);
	}

	protected void fireRepositoryEvent(int eventType) {
		if(!listeners.isEmpty()) {
			PapyrusRepositoryEvent event = new PapyrusRepositoryEvent(this, eventType);
			for(IPapyrusRepositoryListener next : listeners) {
				try {
					next.papyrusRepositoryChanged(event);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in repository event listener.", e); //$NON-NLS-1$
				}
			}
		}
	}

	//
	// IContainer protocol
	//

	@Override
	public boolean isEmpty() {
		return !isActive() || !isConnected() || (masterView == null) || masterView.isEmpty();
	}

	@Override
	public CDOResourceNode[] getElements() {
		CDOResourceNode[] result = NO_RESOURCE_NODES;

		if(masterView != null) {
			if(topResourceNodes == null) {
				topResourceNodes = masterView.getElements();
			}
			result = topResourceNodes;
		}

		return result;
	}

	@Override
	protected void doAfterActivate() throws Exception {
		super.doAfterActivate();

		model.eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				fireEvent();
			}

			@Override
			public boolean isAdapterForType(Object type) {
				return type == PapyrusRepository.class;
			}
		});
	}

	@Override
	protected void doBeforeDeactivate() throws Exception {
		Adapter adapter = EcoreUtil.getExistingAdapter(model, PapyrusRepository.class);
		if(adapter != null) {
			model.eAdapters().remove(adapter);
		}

		super.doBeforeDeactivate();
	}

	private void translateMasterViewInvalidationEvent(CDOViewInvalidationEvent event) {
		for(Map.Entry<CDOObject, CDORevisionDelta> next : event.getRevisionDeltas().entrySet()) {

			if(next.getKey() instanceof CDOResourceNode) {
				CDOResourceNode resNode = (CDOResourceNode)next.getKey();

				if(resNode.isRoot()) {
					// the event doesn't provide a revision delta, so calculate
					// a delta

					Set<CDOResourceNode> currentNodes = Sets.newLinkedHashSet(Arrays.asList(getElements()));
					Set<CDOResourceNode> newNodes = Sets.newLinkedHashSet(Iterables.filter(((CDOResource)resNode).getContents(), CDOResourceNode.class));

					Set<CDOResourceNode> removed = Sets.difference(currentNodes, newNodes);
					Set<CDOResourceNode> added = Sets.difference(newNodes, currentNodes);

					ContainerEvent<CDOResourceNode> cEvent = new ContainerEvent<CDOResourceNode>(this);
					for(CDOResourceNode r : removed) {
						cEvent.addDelta(r, IContainerDelta.Kind.REMOVED);
					}
					for(CDOResourceNode a : added) {
						cEvent.addDelta(a, IContainerDelta.Kind.ADDED);
					}

					// re-calculate elements from the view
					topResourceNodes = resNode.cdoView().getElements();

					fireEvent(cEvent);
					break;
				}
			}
		}

	}

	//
	// IAdaptable protocol
	//

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		Object result = null;

		if((adapter == CDOResourceNode.class) || (adapter == CDOResource.class)) {
			CDOView view = getMasterView();
			if((view != null) && !view.isClosed()) {
				result = view.getRootResource();
			}
		} else if(adapter == CDOSession.class) {
			result = getCDOSession();
		} else {
			result = Platform.getAdapterManager().getAdapter(this, adapter);
		}

		return result;
	}
}
