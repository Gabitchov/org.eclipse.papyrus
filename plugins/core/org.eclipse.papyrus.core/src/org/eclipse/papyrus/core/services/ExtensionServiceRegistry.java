/**
 * 
 */
package org.eclipse.papyrus.core.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.core.extension.editorcontext.ContextDescriptorExtensionFactory;


/**
 * ServiceRegistry reading and registering services declared in Eclipse Extensions.
 * 
 * @author dumoulin
 *
 */
public class ExtensionServiceRegistry extends ServicesRegistry {

	/** ID of the extension (schema filename) */
	public static final String SERVICE_EXTENSION_ID = "service";

	/** Namespace where to look for the extension points. */
	protected String extensionPointNamespace;
	
	/** Extension point name inside the extension description **/
	public final static String SERVICE_EXTENSIONPOINT = "service";

	/** constant for the attribute factoryClass **/
	public final static String CONTEXTCLASS_ATTRIBUTE = "contextClass";

	/** extension point propertyname */
	private final static String STARTKIND_PROPERTY = "startKind";
	/**
	 * Constructor.
	 * @throws Exception 
	 */
	public ExtensionServiceRegistry(String extensionPointNamespace) throws ServiceException {
		this.extensionPointNamespace = extensionPointNamespace;
		registerDeclaredExtensions();
	}

	/**
	 * Register the services declared in Eclipse Extension.
	 * @throws Exception 
	 */
	private void registerDeclaredExtensions() throws ServiceException {
		
		List<ServiceDescriptor> descriptors = new ArrayList<ServiceDescriptor>();
		List<ServiceException> exceptions = null;
		
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, SERVICE_EXTENSION_ID);

		for (IConfigurationElement ele : configElements) {
			ServiceDescriptor desc;
			if (SERVICE_EXTENSIONPOINT.equals(ele.getName())) {
				// Read value from extension
				try {
					desc = readServiceDescriptor(ele);
					// Add created desc
					descriptors.add( desc);
				} catch (ServiceException e) {
					// record exceptions
					if(exceptions==null)
						exceptions = new ArrayList<ServiceException>();
					exceptions.add(e);
				}
			}
		}
		
		// Add found descriptors
		for( ServiceDescriptor desc : descriptors)
		{
			add(desc);
		}
		
		// Throw exceptions if pb encountered
		if(exceptions != null)
		{
			if(exceptions.size() == 1)
			  throw  exceptions.get(0);
			else
			  throw new ServiceException("Somme services are not started (first is shown)", exceptions.get(0));
				
		}
			
	}

	/**
	 * Read descriptor values from provided element.
	 * @param ele
	 * @return
	 * @throws ServiceException 
	 */
	private ServiceDescriptor readServiceDescriptor(IConfigurationElement ele) throws ServiceException
	{
		//
		String useTypeAsKeyStr = ele.getAttribute("useClassTypeAsKey");
		boolean useTypeAsKey = Boolean.valueOf(useTypeAsKeyStr);
		
		// classname
		String serviceClassname = ele.getAttribute("classname");
		
		// key
		String key = ele.getAttribute("id");
		if( key == null || key.length() == 0)
		{
			key = serviceClassname;
		}
		
		// Service start kind
		ServiceStartKind serviceStartKind = ServiceStartKind.LAZY;
		String serviceStartKindStr = ele.getAttribute(STARTKIND_PROPERTY);
		if( serviceStartKindStr != null && serviceStartKindStr.length()>0)
		{
			try {
				serviceStartKind = ServiceStartKind.valueOf(serviceStartKindStr.toUpperCase());
			} catch (IllegalArgumentException e) {
				// Can't convert property
				throw new ServiceException("Can't convert property "+ STARTKIND_PROPERTY 
						+ "(plugin=" + ele.getContributor() 
						+ "declaringExtension=" + ele.getDeclaringExtension()
						+ ")"
						, e);
			}
		}
		
		// priority
		int priority = 1;
		String priorityStr = ele.getAttribute("priority");
		if( priorityStr == null || priorityStr.length() == 0)
		{
			try {
				priority = Integer.parseInt(priorityStr);
			} catch (NumberFormatException e) {
			}
		}
		
		
		ServiceDescriptor desc = new ServiceDescriptor(key, serviceClassname, serviceStartKind, priority);
		desc.setClassBundleID( ele.getContributor().getName() );
		desc.setUseClassTypeAsKey(useTypeAsKey);
		return desc;
	}
}
