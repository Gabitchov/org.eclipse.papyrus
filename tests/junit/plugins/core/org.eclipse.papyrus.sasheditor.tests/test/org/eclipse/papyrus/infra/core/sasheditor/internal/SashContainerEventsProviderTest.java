/**
 *
 */
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * Tests for the class {@link SashContainerEventsProvider}.
 *
 * @author dumoulin
 *
 */
public class SashContainerEventsProviderTest /* extends AbstractPapyrusTest */{

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsProvider#addListener(org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsListener)}
	 * .
	 */
	@Test
	public void testAddActiveEditorChangedListener() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();

		FakePageLifeCycleEventsListener listener = new FakePageLifeCycleEventsListener();
		provider.addListener(listener);

		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;

		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageAboutToBeClosedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsProvider#removeListener(org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsListener)}
	 * .
	 */
	@Test
	public void testRemoveActiveEditorChangedListener() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();

		FakePageLifeCycleEventsListener listener = new FakePageLifeCycleEventsListener();
		provider.addListener(listener);
		provider.removeListener(listener);

		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;

		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageAboutToBeClosedEvent(page);
		assertEquals("event not fired", 0, listener.getEventCount());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsProvider#firePageOpenedEvent(org.eclipse.papyrus.infra.core.sasheditor.internal.PagePart)}
	 * .
	 */
	@Test
	public void testFirePageOpenedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();

		FakePageLifeCycleEventsListener listener = new FakePageLifeCycleEventsListener();
		provider.addListener(listener);

		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;

		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageOpenedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakePageLifeCycleEventsListener.PAGE_OPENED, listener.getTraces().get(0));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsProvider#firePageClosedEvent(org.eclipse.papyrus.infra.core.sasheditor.internal.PagePart)}
	 * .
	 */
	@Test
	public void testFirePageClosedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();

		FakePageLifeCycleEventsListener listener = new FakePageLifeCycleEventsListener();
		provider.addListener(listener);

		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;

		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageClosedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakePageLifeCycleEventsListener.PAGE_CLOSED, listener.getTraces().get(0));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsProvider#firePageAboutToBeOpenedEvent(org.eclipse.papyrus.infra.core.sasheditor.internal.PagePart)}
	 * .
	 */
	@Test
	public void testFirePageAboutToBeOpenedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();

		FakePageLifeCycleEventsListener listener = new FakePageLifeCycleEventsListener();
		provider.addListener(listener);

		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;

		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageAboutToBeOpenedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakePageLifeCycleEventsListener.PAGE_ABOUTTOBEOPENED, listener.getTraces().get(0));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsProvider#firePageAboutToBeClosedEvent(org.eclipse.papyrus.infra.core.sasheditor.internal.PagePart)}
	 * .
	 */
	@Test
	public void testFirePageAboutToBeClosedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();

		FakePageLifeCycleEventsListener listener = new FakePageLifeCycleEventsListener();
		provider.addListener(listener);

		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;

		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageAboutToBeClosedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakePageLifeCycleEventsListener.PAGE_ABOUTTOBECLOSED, listener.getTraces().get(0));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsProvider#firePageActivatedEvent(org.eclipse.papyrus.infra.core.sasheditor.internal.PagePart)}
	 * .
	 */
	@Test
	public void testFirePageActivatedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();

		FakePageLifeCycleEventsListener listener = new FakePageLifeCycleEventsListener();
		provider.addListener(listener);

		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;

		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageActivatedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakePageLifeCycleEventsListener.PAGE_ACTIVATED, listener.getTraces().get(0));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.internal.SashContainerEventsProvider#firePageDeactivatedEvent(org.eclipse.papyrus.infra.core.sasheditor.internal.PagePart)}
	 * .
	 */
	@Test
	public void testFirePageDeactivatedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();

		FakePageLifeCycleEventsListener listener = new FakePageLifeCycleEventsListener();
		provider.addListener(listener);

		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;

		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageDeactivatedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakePageLifeCycleEventsListener.PAGE_DEACTIVATED, listener.getTraces().get(0));
	}

}
