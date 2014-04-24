/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import com.google.common.base.Optional;


/**
 * Tests for the {@link AdapterUtils} class.
 */
public class AdapterUtilsTest extends AbstractPapyrusTest {

	@Test
	public void testAdaptInstanceOptionalPresent() {
		String foo = "foo";

		assertThat(AdapterUtils.adapt(foo, String.class), isPresent(String.class));
	}

	@Test
	public void testAdaptAdaptableOptionalPresent() {
		String foo = "foo";

		assertThat(AdapterUtils.adapt(new AdaptableWrapper(foo), String.class), isPresent(String.class));
	}

	@Test
	public void testAdaptEMFOptionalPresent() {
		EObject obj = EcoreFactory.eINSTANCE.createEObject();
		new EMFAdapter(obj);

		assertThat(AdapterUtils.adapt(obj, EMFAdapter.class), isPresent(EMFAdapter.class));
	}

	@Test
	public void testAdaptInstanceOptionalNull() {
		String foo = "foo";

		assertThat(AdapterUtils.adapt(foo, Integer.class), isNull(Integer.class));
	}

	@Test
	public void testAdaptAdaptableOptionalNull() {
		String foo = "foo";

		assertThat(AdapterUtils.adapt(new AdaptableWrapper(foo), Integer.class), isNull(Integer.class));
	}

	@Test
	public void testAdaptEMFOptionalNull() {
		EObject obj = EcoreFactory.eINSTANCE.createEObject();

		assertThat(AdapterUtils.adapt(obj, EMFAdapter.class), isNull(EMFAdapter.class));
	}

	@Test
	public void testAdaptInstanceDefaultPresent() {
		String foo = "foo";

		assertThat(AdapterUtils.adapt(foo, String.class, null), is(foo));
	}

	@Test
	public void testAdaptAdaptableDefaultPresent() {
		String foo = "foo";

		assertThat(AdapterUtils.adapt(new AdaptableWrapper(foo), String.class, null), is(foo));
	}

	@Test
	public void testAdaptEMFDefaultPresent() {
		EObject obj = EcoreFactory.eINSTANCE.createEObject();
		EMFAdapter emf = new EMFAdapter(obj);

		assertThat(AdapterUtils.adapt(obj, EMFAdapter.class, null), is(emf));
	}

	@Test
	public void testAdaptAdaptableDefaultDefault() {
		String foo = "foo";

		assertThat(AdapterUtils.adapt(new AdaptableWrapper(foo), Integer.class, 42), is(42));
	}

	@Test
	public void testAdaptAdaptableDefaultNull() {
		String foo = "foo";

		assertThat(AdapterUtils.adapt(new AdaptableWrapper(foo), Integer.class, null), nullValue());
	}

	//
	// Test framework
	//

	static <T> Matcher<Optional<T>> isPresent(Class<T> type) {
		return new BaseMatcher<Optional<T>>() {

			public void describeTo(Description description) {
				description.appendText("optional value is present");
			}

			public boolean matches(Object item) {
				return (item instanceof Optional<?>) && ((Optional<?>)item).isPresent();
			}
		};
	}

	static <T> Matcher<Optional<T>> isNull(Class<T> type) {
		return not(isPresent(type));
	}

	public static class AdaptableWrapper implements IAdaptable {

		private final Class<?> type;

		private final Object instance;

		public <T> AdaptableWrapper(T instance, Class<? super T> type) {
			this.type = type;
			this.instance = instance;
		}

		public AdaptableWrapper(Object instance) {
			this.type = instance.getClass();
			this.instance = instance;
		}

		public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
			return (adapter == type) ? instance : null;
		}
	}

	public static class EMFAdapter extends AdapterImpl {

		public EMFAdapter(Notifier obj) {
			obj.eAdapters().add(this);
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == EMFAdapter.class;
		}
	}
}
