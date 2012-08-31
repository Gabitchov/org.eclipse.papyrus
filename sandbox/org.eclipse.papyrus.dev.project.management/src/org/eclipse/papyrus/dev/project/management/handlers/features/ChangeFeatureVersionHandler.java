package org.eclipse.papyrus.dev.project.management.handlers.features;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.dev.project.management.handlers.AbstractChangeProjectVersionHandler;
import org.eclipse.papyrus.dev.project.management.utils.Utils;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IFeatureProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.FeatureProjectEditor;
import org.xml.sax.SAXException;


public class ChangeFeatureVersionHandler extends AbstractChangeProjectVersionHandler {


	@Override
	protected void setVersionNumber(final IProject project, final String newVersion, String notManagedProjectNames) {
		if(project.isOpen()) {
			try {
				if(project.hasNature(Utils.FEATURE_NATURE)) {//for features
					try {
						final IFeatureProjectEditor editor = new FeatureProjectEditor(project);
						editor.init();
						editor.setVersion(newVersion);
						editor.save();
					} catch (final ParserConfigurationException e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					} catch (final SAXException e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					} catch (final IOException e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					} catch (final Throwable e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					}

				} else {
					notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
				}
			} catch (final CoreException e) {
				Activator.log.error(e);
			}
		} else {
			notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
		}
	}

}
