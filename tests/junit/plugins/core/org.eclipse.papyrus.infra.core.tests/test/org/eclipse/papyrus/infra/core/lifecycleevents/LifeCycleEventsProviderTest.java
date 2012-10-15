/**
 * 
 */
package org.eclipse.papyrus.infra.core.lifecycleevents;

import junit.framework.TestCase;

import org.junit.Before;


/**
 * @author cedric dumoulin
 * 
 */
public class LifeCycleEventsProviderTest extends TestCase {

	/**
	 * Object under test.
	 */
	protected LifeCycleEventsProvider eventProvider;

	/**
	 * @see junit.framework.TestCase#setUp()
	 * 
	 * @throws Exception
	 */
	@Override
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		eventProvider = new LifeCycleEventsProvider();
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#addDoSaveListener(org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener)}
	 * .
	 */
	public void testAddSaveListener() {

		ISaveEventListener listener = new FakeSaveEventListener();

		try {
			eventProvider.addDoSaveListener(listener);
		} catch (Exception e) {
			fail("Add listener");
		}

	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#removeDoSaveListener(org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener)}
	 * .
	 */
	public void testRemoveSaveListener() {
		ISaveEventListener listener = new FakeSaveEventListener();

		try {
			eventProvider.addDoSaveListener(listener);
			eventProvider.removeDoSaveListener(listener);
		} catch (Exception e) {
			fail("Remove listener");
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#addAboutToDoSaveListener(org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener)}
	 * .
	 */
	public void testAddAboutToSaveListener() {
		ISaveEventListener listener = new FakeSaveEventListener();

		try {
			eventProvider.addAboutToDoSaveListener(listener);
		} catch (Exception e) {
			fail("Add listener");
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#removeAboutToDoSaveListener(org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener)}
	 * .
	 */
	public void testRemoveAboutToSaveListener() {
		ISaveEventListener listener = new FakeSaveEventListener();

		try {
			eventProvider.addAboutToDoSaveListener(listener);
			eventProvider.removeAboutToDoSaveListener(listener);
		} catch (Exception e) {
			fail("Remove listener");
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#addPostDoSaveListener(org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener)}
	 * .
	 */
	public void testAddPostSaveListener() {
		ISaveEventListener listener = new FakeSaveEventListener();

		try {
			eventProvider.addPostDoSaveListener(listener);
		} catch (Exception e) {
			fail("Add listener");
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#removePostDoSaveListener(org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener)}
	 * .
	 */
	public void testRemovePostSaveListener() {
		ISaveEventListener listener = new FakeSaveEventListener();

		try {
			eventProvider.addPostDoSaveListener(listener);
			eventProvider.removePostDoSaveListener(listener);
		} catch (Exception e) {
			fail("Remove listener");
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#fireAboutToDoSaveEvent(org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent)}
	 * .
	 */
	public void testFireAboutToSaveEvent() {
		FakeSaveEventListener listener = new FakeSaveEventListener();

		eventProvider.addAboutToDoSaveListener(listener);
		DoSaveEvent event = new FakeSaveEvent();
		eventProvider.fireAboutToDoSaveEvent(event);

		assertTrue("event received", listener.isEventReceived(event));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#fireAboutToDoSaveAsEvent(org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent)}
	 * .
	 */
	public void testFireAboutToSaveAsEvent() {
		FakeSaveEventListener listener = new FakeSaveEventListener();

		eventProvider.addAboutToDoSaveListener(listener);
		DoSaveEvent event = new FakeSaveEvent();
		eventProvider.fireAboutToDoSaveAsEvent(event);

		assertTrue("event received", listener.isEventReceived(event));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#fireDoSaveEvent(org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent)}
	 * .
	 */
	public void testFireSaveEvent() {
		FakeSaveEventListener listener = new FakeSaveEventListener();

		eventProvider.addDoSaveListener(listener);
		DoSaveEvent event = new FakeSaveEvent();
		eventProvider.fireDoSaveEvent(event);

		assertTrue("event received", listener.isEventReceived(event));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#fireDoSaveAsEvent(org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent)}
	 * .
	 */
	public void testFireSaveAsEvent() {
		FakeSaveEventListener listener = new FakeSaveEventListener();

		eventProvider.addDoSaveListener(listener);
		DoSaveEvent event = new FakeSaveEvent();
		eventProvider.fireDoSaveAsEvent(event);

		assertTrue("event received", listener.isEventReceived(event));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#firePostDoSaveEvent(org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent)}
	 * .
	 */
	public void testFirePostSaveEvent() {
		FakeSaveEventListener listener = new FakeSaveEventListener();

		eventProvider.addPostDoSaveListener(listener);
		DoSaveEvent event = new FakeSaveEvent();
		eventProvider.firePostDoSaveEvent(event);

		assertTrue("event received", listener.isEventReceived(event));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#firePostDoSaveAsEvent(org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent)}
	 * .
	 */
	public void testFirePostSaveAsEvent() {
		FakeSaveEventListener listener = new FakeSaveEventListener();

		eventProvider.addPostDoSaveListener(listener);
		DoSaveEvent event = new FakeSaveEvent();
		eventProvider.firePostDoSaveAsEvent(event);

		assertTrue("event received", listener.isEventReceived(event));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#fireAllDoSaveEvent(org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent)}
	 * .
	 */
	public void testFireAllSaveEvent() {
		FakeSaveEventListener preListener = new FakeSaveEventListener();
		FakeSaveEventListener listener = new FakeSaveEventListener();
		FakeSaveEventListener postListener = new FakeSaveEventListener();

		eventProvider.addAboutToDoSaveListener(preListener);
		eventProvider.addDoSaveListener(listener);
		eventProvider.addPostDoSaveListener(postListener);

		DoSaveEvent event = new FakeSaveEvent();
		eventProvider.fireAllDoSaveEvent(event);

		assertTrue("event received", preListener.isEventReceived(event));
		assertTrue("event received", listener.isEventReceived(event));
		assertTrue("event received", postListener.isEventReceived(event));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProvider#fireAllDoSaveAsEvent(org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent)}
	 * .
	 */
	public void testFireAllSaveAsEvent() {
		FakeSaveEventListener preListener = new FakeSaveEventListener();
		FakeSaveEventListener listener = new FakeSaveEventListener();
		FakeSaveEventListener postListener = new FakeSaveEventListener();

		eventProvider.addAboutToDoSaveListener(preListener);
		eventProvider.addDoSaveListener(listener);
		eventProvider.addPostDoSaveListener(postListener);

		DoSaveEvent event = new FakeSaveEvent();
		eventProvider.fireAllDoSaveAsEvent(event);

		assertTrue("event received", preListener.isEventReceived(event));
		assertTrue("event received", listener.isEventReceived(event));
		assertTrue("event received", postListener.isEventReceived(event));
	}

}
