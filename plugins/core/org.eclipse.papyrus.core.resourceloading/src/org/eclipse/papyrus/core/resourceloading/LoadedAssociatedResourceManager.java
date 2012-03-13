package org.eclipse.papyrus.core.resourceloading;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.preferences.Activator;

public class LoadedAssociatedResourceManager implements IPropertyChangeListener {

	public static class LoadedAssociatedResource {
		private String fileExtension;
		private String description;
		private boolean autoLoad;

		public LoadedAssociatedResource(String fileExtension, String description, boolean autoLoad) {
			this.fileExtension = fileExtension;
			this.description = description;
			this.autoLoad = autoLoad;
		}

		public String getFileExtension() {
			return fileExtension;
		}

		public String getDescription() {
			return description;
		}

		public boolean isAutoLoad() {
			return autoLoad;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof LoadedAssociatedResource && fileExtension != null) {
				return fileExtension.equals(((LoadedAssociatedResource)obj).fileExtension);
			}
			return false;
		}

		@Override
		public int hashCode() {
			if(fileExtension != null) {
				return fileExtension.hashCode();
			}
			return 0;
		}
	}

	private static final String LOADED_ASSOCIATED_RESOURCE_ELEMENT_ID = "loadedAssociatedResource";

	private static final String LOADED_ASSOCIATED_RESOURCE_EXTENSION_POINT_ID = "org.eclipse.papyrus.core.resourceloading." + LOADED_ASSOCIATED_RESOURCE_ELEMENT_ID;

	private static final String AUTOLOAD_ID = "autoLoad";
	
	private static final String PREFERENCE_PREFIX = LOADED_ASSOCIATED_RESOURCE_ELEMENT_ID + ".";
	
	public static final String AUTOLOAD_PREF_PREFIX = PREFERENCE_PREFIX + AUTOLOAD_ID + ".";

	private static class Holder {

		static final LoadedAssociatedResourceManager instance = new LoadedAssociatedResourceManager();
	}

	public static LoadedAssociatedResourceManager getInstance() {
		return Holder.instance;
	}

	private IPreferenceStore prefStore;

	private Map<String, LoadedAssociatedResource> loadedAssociatedResources = null;

	public LoadedAssociatedResourceManager() {
		prefStore = Activator.getDefault().getPreferenceStore();
		prefStore.addPropertyChangeListener(this);
	}

	public synchronized Map<String, LoadedAssociatedResource> getLoadedAssociatedResources() {
		readExtensions();
		return loadedAssociatedResources;
	}

	public synchronized void propertyChange(PropertyChangeEvent event) {
		Object newValue = event.getNewValue();

		if(event.getProperty().startsWith(AUTOLOAD_PREF_PREFIX) && newValue instanceof Boolean) {
			String fileExtension = event.getProperty().replaceFirst(AUTOLOAD_PREF_PREFIX, "");
			LoadedAssociatedResource loadedAssociatedResource = getLoadedAssociatedResources().get(fileExtension);
			if (loadedAssociatedResource != null) {
				loadedAssociatedResource.autoLoad = (Boolean)newValue;
			}
		}
	}

	private void readExtensions() {
		if(loadedAssociatedResources == null) {
			loadedAssociatedResources = new HashMap<String, LoadedAssociatedResourceManager.LoadedAssociatedResource>();

			IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(LOADED_ASSOCIATED_RESOURCE_EXTENSION_POINT_ID);
			for(IConfigurationElement element : extensions) {
				if(LOADED_ASSOCIATED_RESOURCE_ELEMENT_ID.equals(element.getName())) {

					String fileExtension = element.getAttribute("fileExtension");
					String description = element.getAttribute("description");

					boolean autoLoad = getBooleanPrefOrInitialize(AUTOLOAD_PREF_PREFIX + fileExtension, Boolean.parseBoolean(element.getAttribute(AUTOLOAD_ID)));

					loadedAssociatedResources.put(fileExtension, new LoadedAssociatedResource(fileExtension, description, autoLoad));
				}
			}
		}
	}

	private boolean getBooleanPrefOrInitialize(String prefKey, boolean defaultValue) {
		if(prefStore.contains(prefKey)) {
			return prefStore.getBoolean(prefKey);
		} else {
			prefStore.setDefault(prefKey, defaultValue);
			return defaultValue;
		}
	}
}
