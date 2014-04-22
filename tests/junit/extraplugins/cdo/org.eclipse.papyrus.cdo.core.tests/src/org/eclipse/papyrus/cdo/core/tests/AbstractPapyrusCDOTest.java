/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 429242
 *   Christian W. Damus (CEA) - bug 430023
 *   
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.cdo.common.CDOCommonRepository;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.server.CDOServerUtil;
import org.eclipse.emf.cdo.server.IRepository.Props;
import org.eclipse.emf.cdo.server.mem.MEMStoreUtil;
import org.eclipse.emf.cdo.server.net4j.CDONet4jServerUtil;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.spi.server.InternalRepository;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * This is the AbstractPapyrusCDOTest type. Enjoy.
 */
public abstract class AbstractPapyrusCDOTest extends AbstractPapyrusTest {

	private static final Pattern LEADING_SLASHES = Pattern.compile("^/+");

	@Rule
	public final TestName name = new TestName();

	private String repoUUID;

	private String repoURL;

	private IManagedContainer container;

	private IPapyrusRepository repository;

	public AbstractPapyrusCDOTest() {
		super();
	}

	@Before
	public void createRepository() throws Exception {

		container = createServerContainer();
		InternalRepository repo = createRepository(container);

		repoUUID = repo.getUUID();
		repoURL = "jvm://default?repositoryName=" + repo.getName();

		if(needPapyrusRepository()) {
			repository = PapyrusRepositoryManager.INSTANCE.getRepository(repoURL);
			if(repository == null) {
				repository = PapyrusRepositoryManager.INSTANCE.createRepository(repoURL);
			}

			repository.setName(name.getMethodName());

			if(!repository.isConnected()) {
				repository.connect();
			}

			CDOSession session = ((IInternalPapyrusRepository)repository).getCDOSession();

			// ensure the test resource path
			CDOTransaction transaction = session.openTransaction();
			transaction.getOrCreateResourceFolder(getResourceFolder());
			transaction.commit();
			transaction.close();
		}
	}

	@After
	public void disposeRepository() throws Exception {

		if(repository != null) {
			repository.disconnect();
			PapyrusRepositoryManager.INSTANCE.removeRepository(repository);
			repository = null;

			// persist the removal (the new new repository saved its UUID when opened)
			PapyrusRepositoryManager.INSTANCE.saveRepositories();
		}

		LifecycleUtil.deactivate(container);
	}

	protected Map<String, String> getRepositoryProperties() {
		Map<String, String> result = Maps.newHashMap();

		addRepositoryProperties(result);

		return result;
	}

	protected void addRepositoryProperties(Map<String, String> props) {
		props.put(Props.OVERRIDE_UUID, ""); // use the name as the UUID
		props.put(Props.SUPPORTING_AUDITS, "false");
		props.put(Props.SUPPORTING_BRANCHES, "false");
		props.put(Props.ID_GENERATION_LOCATION, CDOCommonRepository.IDGenerationLocation.STORE.toString());
	}

	protected IManagedContainer createServerContainer() {
		IManagedContainer result = ContainerUtil.createContainer();

		prepareContainer(result);

		LifecycleUtil.activate(result);

		return result;
	}

	protected void prepareContainer(IManagedContainer container) {
		Net4jUtil.prepareContainer(container);
		CDONet4jUtil.prepareContainer(container);
		CDONet4jServerUtil.prepareContainer(container);
		JVMUtil.prepareContainer(container);
	}

	protected InternalRepository createRepository(IManagedContainer container) {
		InternalRepository result = (InternalRepository)CDOServerUtil.createRepository("MEM", MEMStoreUtil.createMEMStore(), getRepositoryProperties());

		CDOServerUtil.addRepository(container, result);
		LifecycleUtil.activate(JVMUtil.getAcceptor(container, "default"));
		return result;
	}

	protected IPapyrusRepository getPapyrusRepository() {
		return repository;
	}

	protected IInternalPapyrusRepository getInternalPapyrusRepository() {
		return (IInternalPapyrusRepository)getPapyrusRepository();
	}

	protected CDOTransaction createTransaction() {
		IInternalPapyrusRepository repo = getInternalPapyrusRepository();

		CDOTransaction result = getTransaction(repo.createTransaction(createResourceSet()));

		return result;
	}

	protected CDOView createView() {
		IInternalPapyrusRepository repo = getInternalPapyrusRepository();

		CDOView result = getInternalPapyrusRepository().getCDOView(repo.createReadOnlyView(createResourceSet()));

		return result;
	}

	private ResourceSet createResourceSet() {
		ResourceSet result = null;

		Method factory = getAnnotatedMethod(ResourceSetFactory.class);
		if(factory != null) {
			try {
				result = (ResourceSet)factory.invoke(this);
			} catch (InvocationTargetException e) {
				e.getTargetException().printStackTrace();
				fail("Failed to create resource set for test case: " + e.getTargetException().getLocalizedMessage());
			} catch (IllegalAccessException e) {
				fail("Resource-set factory method not accessible: " + factory.getName());
			}
		}

		if(result == null) {
			// default
			result = new ResourceSetImpl();
		}

		return result;
	}

	protected CDOTransaction getTransaction(ResourceSet resourceSet) {
		return cast(getInternalPapyrusRepository().getCDOView(resourceSet), CDOTransaction.class);
	}

	protected final Method getAnnotatedMethod(Class<? extends Annotation> annotationType) {
		Method result = null;

		for(Method next : getClass().getMethods()) {
			if(next.isAnnotationPresent(annotationType)) {
				result = next;
				break;
			}
		}

		return result;
	}

	protected String getRepositoryURL() {
		return repoURL;
	}

	protected boolean needPapyrusRepository() {
		return true;
	}

	protected String getResourceFolder() {
		return String.format("/%s/%s", getClass().getSimpleName(), name.getMethodName());
	}

	protected String getResourcePath(String path) {
		java.util.regex.Matcher m = LEADING_SLASHES.matcher(path);
		if(m.find()) {
			path = path.substring(m.end());
		}
		return String.format("%s/%s", getResourceFolder(), path);
	}

	protected URI getTestResourceURI(String path) {
		return URI.createURI("cdo://" + repoUUID + getResourcePath(path), false);
	}

	protected URI getRepositoryURI() {
		return getInternalPapyrusRepository().getMasterView().getRootResource().getURI();
	}

	protected URI getTestFolderURI() {
		// last segment adds the trailing separator
		return getRepositoryURI().appendSegment(getClass().getSimpleName()).appendSegment(name.getMethodName()).appendSegment("");
	}

	protected static <T> T cast(Object object, Class<T> type) {
		assertThat(object, instanceOf(type));
		return type.cast(object);
	}

	protected URI getTemplateResourceURI(String templateName, String resourceName, String extension) {
		return URI.createPlatformPluginURI(String.format("/org.eclipse.papyrus.cdo.core.tests/resources/%s/%s.%s", templateName, resourceName, extension), true);
	}

	protected void loadTemplate(String templateName, String resourceName, Resource... resource) {
		ResourceSet rset = new ResourceSetImpl();

		// load all the templates
		Resource[] templates = new Resource[resource.length];
		for(int i = 0; i < templates.length; i++) {
			templates[i] = rset.getResource(getTemplateResourceURI(templateName, resourceName, resource[i].getURI().fileExtension()), true);
		}

		// resolve their cross-references
		for(int i = 0; i < templates.length; i++) {
			EcoreUtil.resolveAll(templates[i]);
		}

		// move them into the destination resources
		for(int i = 0; i < resource.length; i++) {
			resource[i].getContents().addAll(templates[i].getContents());
		}

		// unload the now empty template resources
		for(Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}
		rset.getResources().clear();
		rset.eAdapters().clear();
	}

	protected <T extends EObject> T getMasterViewObject(T object) {
		CDOView view = getInternalPapyrusRepository().getMasterView();
		return view.getObject(object);
	}

	public static <T extends Number & Comparable<T>> Matcher<T> lessThan(final T max) {
		return new BaseMatcher<T>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("< ").appendValue(max);
			}

			@Override
			@SuppressWarnings("unchecked")
			public boolean matches(Object item) {
				return ((T)item).compareTo(max) < 0;
			}
		};
	}

	public static <T extends Number & Comparable<T>> Matcher<T> lessThanOrEqualTo(final T max) {
		return new BaseMatcher<T>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("<= ").appendValue(max);
			}

			@Override
			@SuppressWarnings("unchecked")
			public boolean matches(Object item) {
				return ((T)item).compareTo(max) <= 0;
			}
		};
	}

	public static <T> Matcher<Iterable<T>> hasSize(final int size) {
		return new BaseMatcher<Iterable<T>>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("has size ").appendValue(size);
			}

			@Override
			public boolean matches(Object item) {
				return Iterables.size((Iterable<?>)item) == size;
			}
		};
	}
}
