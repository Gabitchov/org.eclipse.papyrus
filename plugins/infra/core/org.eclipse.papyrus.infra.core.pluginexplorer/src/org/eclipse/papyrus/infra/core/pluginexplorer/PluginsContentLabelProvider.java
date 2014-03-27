package org.eclipse.papyrus.infra.core.pluginexplorer;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class PluginsContentLabelProvider extends LabelProvider {
	@Override
	public Image getImage(Object element) {
	ImageRegistry registry = Activator.getDefault().getImageRegistry();
		if (element instanceof Plugin) {
			return registry.get("plugin");
		} else if (element instanceof PluginEntry) {
			if (((PluginEntry) element).hasChildren())
				return registry.get("folder");
			String name = ((PluginEntry) element).getName();
			if (name.endsWith(".class"))
				return registry.get("class");
			else if (name.endsWith(".jar"))
				return registry.get("jar");
		}
		return registry.get("file");
	}
	@Override
	public String getText(Object element) {
		if (element instanceof Plugin) {
			return ((Plugin)element).getName();
		} else if (element instanceof PluginEntry) {
			return ((PluginEntry)element).getName();
		}
		return element.toString();
	}
}
