/**
 * 
 */
package org.eclipse.papyrus.example.lifecycleevents;

import org.eclipse.papyrus.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.core.lifecycleevents.ISaveEventListener;
import org.eclipse.papyrus.core.lifecycleevents.LifeCycleEventsProvider;
import org.eclipse.papyrus.core.services.IService;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;


/**
 * A simple example of a class monitoring the life cycle events from the mlti editor.
 * This class is registered as a Papyrus service.
 * It then registered itself to the {@link LifeCycleEventsProvider}.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class LifeCycleEventsMonitorService implements IService {

	protected ServicesRegistry servicesRegistry;
	
	/**
	 * Listener on aboutToSave events.
	 */
	protected ISaveEventListener aboutToSaveListener = new ISaveEventListener() {
		
		public void doSaveAs(DoSaveEvent event) {
			System.out.println("event received: aboutToSaveAs");
		}
		
		public void doSave(DoSaveEvent event) {
			System.out.println("event received: aboutToSave");
		}
	};
	
	/**
	 * Listener on doSave events.
	 */
	protected ISaveEventListener saveListener= new ISaveEventListener() {
		
		public void doSaveAs(DoSaveEvent event) {
			System.out.println("event received: doSaveAs");
		}
		
		public void doSave(DoSaveEvent event) {
			System.out.println("event received: doSave");
		}
	};
	
	/**
	 * Listener on postSave events.
	 */
	protected ISaveEventListener postSaveListener= new ISaveEventListener() {
		
		public void doSaveAs(DoSaveEvent event) {
			System.out.println("event received: postSaveAs");
		}
		
		public void doSave(DoSaveEvent event) {
			System.out.println("event received: postSave");
		}
	};
	
	/**
	 * Constructor.
	 * This constructor is called by the ServiceRegistry when this service is created. The 
	 * parameter is provided by the ServiceRegistry itself.
	 * 
	 * @param servicesRegistry
	 */
	public LifeCycleEventsMonitorService() {
		System.out.println("LifeCycleEventsMonitorService created");
	}

	/**
	 * @see org.eclipse.papyrus.core.services.IService#disposeService()
	 *
	 */
	public void disposeService() {
		deactivate();
		System.out.println("LifeCycleEventsMonitorService disposed");
		
	}

	/**
	 * Initialize the service.
	 * @see org.eclipse.papyrus.core.services.IService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 */
	public void init(ServicesRegistry servicesRegistry) {
		this.servicesRegistry = servicesRegistry;
	}

	/**
	 * @see org.eclipse.papyrus.core.services.IService#startService()
	 *
	 */
	public void startService() {
		System.out.println("LifeCycleEventsMonitorService started");
		activate();
	}
	
	/**
	 * Activate listeners.
	 */
	private void activate() {
		try {
			ILifeCycleEventsProvider eventProvider = servicesRegistry.getService(ILifeCycleEventsProvider.class);
			eventProvider.addAboutToDoSaveListener(aboutToSaveListener);
			eventProvider.addDoSaveListener(saveListener);
			eventProvider.addPostDoSaveListener(postSaveListener);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * Deactivate listeners
	 */
	private void deactivate() {
		try {
			ILifeCycleEventsProvider eventProvider = servicesRegistry.getService(ILifeCycleEventsProvider.class);
			eventProvider.removeAboutToDoSaveListener(aboutToSaveListener);
			eventProvider.removeDoSaveListener(saveListener);
			eventProvider.removePostDoSaveListener(postSaveListener);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}


}
