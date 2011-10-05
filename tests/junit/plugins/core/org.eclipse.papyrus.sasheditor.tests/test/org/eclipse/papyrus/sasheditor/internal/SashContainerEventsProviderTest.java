/**
 * 
 */
package org.eclipse.papyrus.sasheditor.internal;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class SashContainerEventsProviderTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashContainerEventsProvider#addListener(org.eclipse.papyrus.sasheditor.internal.SashContainerEventsListener)}.
	 */
	@Test
	public void testAddActiveEditorChangedListener() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();
		
		FakeSashContainerEventsListener listener = new FakeSashContainerEventsListener();
		provider.addListener(listener);
		
		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;
		
		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageAboutToBeClosedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashContainerEventsProvider#removeListener(org.eclipse.papyrus.sasheditor.internal.SashContainerEventsListener)}.
	 */
	@Test
	public void testRemoveActiveEditorChangedListener() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();
		
		FakeSashContainerEventsListener listener = new FakeSashContainerEventsListener();
		provider.addListener(listener);
		provider.removeListener(listener);
		
		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;
		
		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageAboutToBeClosedEvent(page);
		assertEquals("event not fired", 0, listener.getEventCount());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashContainerEventsProvider#firePageOpenedEvent(org.eclipse.papyrus.sasheditor.internal.PagePart)}.
	 */
	@Test
	public void testFirePageOpenedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();
		
		FakeSashContainerEventsListener listener = new FakeSashContainerEventsListener();
		provider.addListener(listener);
		
		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;
		
		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageOpenedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakeSashContainerEventsListener.PAGE_OPENED, listener.getTraces().get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashContainerEventsProvider#firePageClosedEvent(org.eclipse.papyrus.sasheditor.internal.PagePart)}.
	 */
	@Test
	public void testFirePageClosedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();
		
		FakeSashContainerEventsListener listener = new FakeSashContainerEventsListener();
		provider.addListener(listener);
		
		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;
		
		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageClosedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakeSashContainerEventsListener.PAGE_CLOSED, listener.getTraces().get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashContainerEventsProvider#firePageAboutToBeOpenedEvent(org.eclipse.papyrus.sasheditor.internal.PagePart)}.
	 */
	@Test
	public void testFirePageAboutToBeOpenedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();
		
		FakeSashContainerEventsListener listener = new FakeSashContainerEventsListener();
		provider.addListener(listener);
		
		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;
		
		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageAboutToBeOpenedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakeSashContainerEventsListener.PAGE_ABOUTTOBEOPENED, listener.getTraces().get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashContainerEventsProvider#firePageAboutToBeClosedEvent(org.eclipse.papyrus.sasheditor.internal.PagePart)}.
	 */
	@Test
	public void testFirePageAboutToBeClosedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();
		
		FakeSashContainerEventsListener listener = new FakeSashContainerEventsListener();
		provider.addListener(listener);
		
		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;
		
		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageAboutToBeClosedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakeSashContainerEventsListener.PAGE_ABOUTTOBECLOSED, listener.getTraces().get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashContainerEventsProvider#firePageActivatedEvent(org.eclipse.papyrus.sasheditor.internal.PagePart)}.
	 */
	@Test
	public void testFirePageActivatedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();
		
		FakeSashContainerEventsListener listener = new FakeSashContainerEventsListener();
		provider.addListener(listener);
		
		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;
		
		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageActivatedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakeSashContainerEventsListener.PAGE_ACTIVATED, listener.getTraces().get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.internal.SashContainerEventsProvider#firePageDeactivatedEvent(org.eclipse.papyrus.sasheditor.internal.PagePart)}.
	 */
	@Test
	public void testFirePageDeactivatedEvent() {
		SashContainerEventsProvider provider = new SashContainerEventsProvider();
		
		FakeSashContainerEventsListener listener = new FakeSashContainerEventsListener();
		provider.addListener(listener);
		
		// Use a null page, as it is not possible to instanciate a fake page.
		PagePart page = null;
		
		// Send an event and check that it is received. If received, the listener is register !
		provider.firePageDeactivatedEvent(page);
		assertEquals("event fired", 1, listener.getEventCount());
		assertEquals("right event", FakeSashContainerEventsListener.PAGE_DEACTIVATED, listener.getTraces().get(0));
	}

}
