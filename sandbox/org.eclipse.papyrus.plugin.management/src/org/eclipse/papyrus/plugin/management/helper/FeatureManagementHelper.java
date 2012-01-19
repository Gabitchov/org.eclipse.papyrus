package org.eclipse.papyrus.plugin.management.helper;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IFeatureProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.FeatureProjectEditor;
import org.xml.sax.SAXException;


public class FeatureManagementHelper extends AbstractProjectManagementHelper{


	public static final String EPL_HTML_SOURCE_PATH = "/resources/epl-v10.html.file";

	public static final String EPL_HTML_PATH = "epl-v10.html";

	public static final String LICENCE_SOURCE_HTML_PATH = "/resources/license.html.file";

	public static final String LICENCE_HTML_PATH = "license.html";


	public FeatureManagementHelper(final String version, final String provider, final boolean testMarkIncubation) {
		super("org.eclipse.pde.FeatureNature", version, provider, testMarkIncubation);
	}

	@Override
	protected void handleProject(IProject project) throws CoreException, IOException, Throwable {
		checkFile(project, EPL_HTML_SOURCE_PATH, EPL_HTML_PATH);
		checkFile(project, LICENCE_SOURCE_HTML_PATH, LICENCE_HTML_PATH);
		checkIncubation(project);
		setDescription(project);
	}

	@Override
	protected void checkIncubation(IProject project) throws Throwable {
		IFeatureProjectEditor editor = getFeatureEditor(project);
		String label = editor.getLabel();
//		if(!label.endsWith(INCUBATION)){
			label = askNewName(label);
			editor.setLabel(label);
			
		
			
			((FeatureProjectEditor)editor).save();
//		}
	
		
	}
	
	protected IFeatureProjectEditor getFeatureEditor(final IProject project) throws ParserConfigurationException, SAXException, IOException, CoreException{
		FeatureProjectEditor editor = new FeatureProjectEditor(project);
		editor.init();
		return editor;
	}
	
	protected void setDescription(final IProject project) throws Throwable{
		IFeatureProjectEditor editor = getFeatureEditor(project);
		editor.setCopyright("http://www.google.fr/myOwnURLNicest", "ma description perso");
		((FeatureProjectEditor)editor).save();
	}
}
