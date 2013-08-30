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
package org.eclipse.papyrus.cdo.internal.core.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionFinishedEvent;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.net4j.util.container.ContainerEventAdapter;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IResourceSetDisposalApprover;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.IRepositoryModelStorage;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.uml2.uml.UMLFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This is the PapyrusRepositoryManagerTest type. Enjoy.
 */
public class PapyrusRepositoryManagerTest extends AbstractPapyrusCDOTest {

	private PapyrusRepositoryManager fixture;

	public PapyrusRepositoryManagerTest() {
		super();
	}

	@Test
	public void createAndRemoveRepository() throws Exception {

		ContainerListener<IPapyrusRepository> listener = new ContainerListener<IPapyrusRepository>();
		fixture.addListener(listener);

		assertThat(fixture.isEmpty(), is(true));

		IPapyrusRepository repo = fixture.createRepository(getRepositoryURL());

		assertThat(fixture.isEmpty(), is(false));
		assertThat(repo, notNullValue());

		repo.setName("My Repository");

		assertThat(listener.getAdded(), equalTo(Collections.singletonList(repo)));
		assertThat(listener.getRemoved(), equalTo(Collections.<IPapyrusRepository> emptyList()));

		assertArrayEquals(new IPapyrusRepository[]{ repo }, fixture.getElements());
		assertThat(ImmutableSet.copyOf(fixture.getRepositories()), equalTo(ImmutableSet.of((IInternalPapyrusRepository)repo)));

		repo.connect();

		assertThat(repo.isConnected(), is(true));

		repo.disconnect();

		assertThat(repo.isConnected(), is(false));

		fixture.removeRepository(repo);
		assertThat(listener.getRemoved(), equalTo(Collections.singletonList(repo)));
	}

	@Test
	public void createTransaction_ResourceSet() throws Exception {

		PapyrusRepository repo = (PapyrusRepository)fixture.createRepository(getRepositoryURL());

		ContainerListener<CDOResourceNode> listener = new ContainerListener<CDOResourceNode>();
		repo.addListener(listener);

		assertThat(repo.isEmpty(), is(true));

		repo.connect();

		ResourceSet rset = new ResourceSetImpl();
		assertThat(repo.createTransaction(rset), sameInstance(rset));

		CDOTransaction transaction = (CDOTransaction)repo.getCDOView(rset);
		assertThat(transaction.isClosed(), is(false));
		assertThat(transaction.isDirty(), is(false));

		Resource res = rset.createResource(getTestResourceURI("model.uml"));
		res.getContents().add(UMLFactory.eINSTANCE.createModel());
		assertThat(transaction.isDirty(), is(true));

		assertThat(fixture.getRepositoryForURI(res.getURI()), sameInstance((IPapyrusRepository)repo));

		repo.commit(rset);
		assertThat(transaction.isDirty(), is(false));

		// passive update of the view reports the new resource folder
		assertThat(listener.getAdded(1).size(), equalTo(1));
		assertThat(listener.getRemoved().size(), equalTo(0));

		assertThat(repo.isEmpty(), is(false));
		assertThat(repo.getElements().length, equalTo(1));

		repo.close(rset);
		assertThat(transaction.isClosed(), is(true));

		repo.disconnect();

		assertThat(listener.getRemoved(1).size(), equalTo(1));
	}

	@Test
	public void loadAndSave() throws Exception {
		StringStorage storage = new StringStorage();

		PapyrusRepositoryManager mgr = new PapyrusRepositoryManager(storage);
		assertThat(mgr.getRepositories().size(), equalTo(0));

		mgr.createRepository(getRepositoryURL()).setName("My Repository");

		mgr.saveRepositories();

		mgr.dispose();

		mgr = new PapyrusRepositoryManager(storage);

		try {
			assertThat(mgr.getRepositories().size(), equalTo(1));
			PapyrusRepository repo = (PapyrusRepository)Iterables.getOnlyElement(mgr.getRepositories());
			assertThat(repo.getName(), equalTo("My Repository"));
			assertThat(repo.getURL(), equalTo(getRepositoryURL()));
			assertThat(repo.isConnected(), is(false));
			assertThat(repo.isEmpty(), is(true));
		} finally {
			mgr.dispose();
		}
	}

	@Test
	public void disposalNoAction() throws Exception {

		PapyrusRepository repo = (PapyrusRepository)fixture.createRepository(getRepositoryURL());
		repo.connect();

		repo.addResourceSetDisposalApprover(new IResourceSetDisposalApprover() {

			public DisposeAction disposalRequested(IPapyrusRepository repository, Collection<ResourceSet> resourceSets) {

				return DisposeAction.NONE;
			}
		});

		ResourceSet rset = repo.createTransaction(new ResourceSetImpl());
		CommitListener listener = new CommitListener();
		repo.getCDOView(rset).addListener(listener);

		// dirty the transaction
		rset.createResource(getTestResourceURI("model.uml"));

		repo.disconnect();

		// still connected and transaction dirty
		assertThat(repo.isConnected(), is(true));
		assertThat(repo.getCDOView(rset).isDirty(), is(true));
		assertThat(listener.testAndClearCommitted(), is(false));
	}

	@Test
	public void disposalSaveAction() throws Exception {

		PapyrusRepository repo = (PapyrusRepository)fixture.createRepository(getRepositoryURL());
		repo.connect();

		repo.addResourceSetDisposalApprover(new IResourceSetDisposalApprover() {

			public DisposeAction disposalRequested(IPapyrusRepository repository, Collection<ResourceSet> resourceSets) {

				return DisposeAction.SAVE;
			}
		});

		ResourceSet rset = repo.createTransaction(new ResourceSetImpl());
		CDOView view = repo.getCDOView(rset);
		CommitListener listener = new CommitListener();
		view.addListener(listener);

		// dirty the transaction
		rset.createResource(getTestResourceURI("model.uml"));

		repo.disconnect();

		// not connected and transaction closed, but committed
		assertThat(repo.isConnected(), is(false));
		assertThat(view.isClosed(), is(true));
		assertThat(listener.testAndClearCommitted(), is(true));
	}

	@Test
	public void disposalCloseAction() throws Exception {

		PapyrusRepository repo = (PapyrusRepository)fixture.createRepository(getRepositoryURL());
		repo.connect();

		repo.addResourceSetDisposalApprover(new IResourceSetDisposalApprover() {

			public DisposeAction disposalRequested(IPapyrusRepository repository, Collection<ResourceSet> resourceSets) {

				return DisposeAction.CLOSE;
			}
		});

		ResourceSet rset = repo.createTransaction(new ResourceSetImpl());
		CDOView view = repo.getCDOView(rset);
		CommitListener listener = new CommitListener();
		view.addListener(listener);

		// dirty the transaction
		rset.createResource(getTestResourceURI("model.uml"));

		repo.disconnect();

		// not connected and transaction closed, but *not* committed
		assertThat(repo.isConnected(), is(false));
		assertThat(view.isClosed(), is(true));
		assertThat(listener.testAndClearCommitted(), is(false));
	}

	//
	// Test framework
	//

	@Override
	protected boolean needPapyrusRepository() {
		return false; // I create my own repository manager for testing
	}

	@Before
	public void createRepositoryManager() throws Exception {

		fixture = new PapyrusRepositoryManager();
	}

	@After
	public void disposeRepositoryManager() throws Exception {

		if(fixture != null) {
			fixture.dispose();
			fixture = null;
		}
	}

	static class ContainerListener<T> extends ContainerEventAdapter<T> {

		private List<T> added = Lists.newArrayListWithExpectedSize(1);

		private boolean addedChanged;

		private List<T> removed = Lists.newArrayListWithExpectedSize(1);

		private boolean removedChanged;

		List<T> getAdded() {
			synchronized(added) {
				// clear the flag
				addedChanged = false;
				return added;
			}
		}

		List<T> getAdded(long seconds) {
			synchronized(added) {
				long timeout = TimeUnit.SECONDS.toMillis(seconds);
				while(!addedChanged && (timeout > 0L)) {
					timeout = waitFor(added, timeout);
				}

				assertThat("No element added.", addedChanged, is(true));

				addedChanged = false;
				return added;
			}
		}

		private long waitFor(Object monitor, long millis) {
			long before = System.currentTimeMillis();

			try {
				monitor.wait(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Assert.fail("Interrupted while waiting for " + monitor);
			}

			return millis - (System.currentTimeMillis() - before);
		}

		List<T> getRemoved() {
			synchronized(added) {
				// clear the flag
				removedChanged = false;
				return removed;
			}
		}

		List<T> getRemoved(long seconds) {
			synchronized(removed) {
				long timeout = TimeUnit.SECONDS.toMillis(seconds);
				while(!removedChanged && (timeout > 0L)) {
					timeout = waitFor(removed, timeout);
				}

				assertThat("No element removed.", removedChanged, is(true));

				removedChanged = false;
				return removed;
			}
		}

		@Override
		protected void onAdded(IContainer<T> container, T element) {
			synchronized(added) {
				added.add(element);
				addedChanged = true;
				added.notifyAll();
			}
		}

		@Override
		protected void onRemoved(IContainer<T> container, T element) {
			synchronized(removed) {
				removed.add(element);
				removedChanged = true;
				removed.notifyAll();
			}
		}
	}

	static class CommitListener implements IListener {

		private volatile boolean committed;

		boolean testAndClearCommitted() {
			boolean result = committed;
			committed = false;
			return result;
		}

		public void notifyEvent(IEvent event) {
			if(event instanceof CDOTransactionFinishedEvent) {
				committed = true;
			}
		}
	}

	static class StringStorage implements IRepositoryModelStorage {

		String storage = null;

		public InputStream createInputStream() throws IOException {

			return (storage == null ? null : new ByteArrayInputStream(storage.getBytes("UTF-8")));
		}

		public OutputStream createOutputStream() throws IOException {

			return new ByteArrayOutputStream() {

				@Override
				public void close() throws IOException {

					super.close();

					storage = toString("UTF-8");
				}
			};
		}
	}
}
