/**
 * 
 */
package org.eclipse.papyrus.java.reverse.ui.dialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javagen.umlparser.CreationPackageCatalog;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.papyrus.java.reverse.ui.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author dumoulin
 * 
 */
public class ReverseCodeDialog extends InputDialog {

	/** Internal dialog to show list of searchpaths */
	private InputListDialog listDialog;

	/** Internal dialog to show list of creation paths */
	private InputListDialog creationPathsDialog;

	/** Returned searchpaths */
	private String[] searchPath;
	/** creationPaths read by the list. One line pattern by element*/
	private String[] creationPaths;
	/** splitted creationPaths. pattern lines are splitted in small path */
	private List<String> splittedCreationPaths;

	private String SEARCHPATHS_UID = ":searchpaths";
	private String CREATIONPATHS_UID = ":creationpaths";
	private static String DEFAULT_PACKAGE_NAME_UID = ":defaultpackagename";
	private String MODEL_UID = "nomodeluid";

	private static String textMsg = "Default creation package.";
	private static String creationPackageTooltips = "The default creation package is used when no matching creation package are found.";
	

	private static String dialogTitle = "Reverse Code";

	private static String listMsg = "search paths  - list of model packages used to search for already existing classes (ex: p1/p2)";
	private static String listTooltips = "search paths  - list of model packages used to search for already existing classes (ex: p1/p2)";

	private static String creationPathMsg = "creation paths \n"
		+ "pattern: includePath ; excludePath ; destination (use ';' as separator)\n";

	private static String creationPathTooltips = "creation paths  - list of path describing the models inside which reversed classes will be generated.\n"
		+ "pattern: includeJavaPackage ; excludeJavaPackage ; destinationPath (use ';' as separator)\n"
		+ "includeJavaPackage: the java package that should be mapped. Can contain a '*'.\n"
		+ "excludeJavaPackage: the java package that should be excluded. Can contain a '*'.\n"
		+ "destinationPath: the uml model inside which matching java packages will be created. Can contain a '*'.\n"
		+ "if destinationPath contains a '*', it will be replaced by the partname found at the place of '*'\n"
		+ "in the includeJavaPackage\n"
		+ "\n"
	    + "ex: eclipse.org.* ; eclipse.org.papyrus ; *" ;


	/**
	 * @param parentShell
	 * @param dialogTitle
	 * @param dialogMessage
	 * @param initialValue
	 * @param validator
	 */
	public ReverseCodeDialog(Shell parentShell, String modelUid, String initialValue, List<String> searchPathsInitialValues) {
		super(parentShell, dialogTitle, textMsg, getInitialValue(modelUid, initialValue), null);
		// TODO Auto-generated constructor stub
		IDialogSettings settings = Activator.getDefault().getDialogSettings();

		MODEL_UID = modelUid;
		
		// Look for generationPackageName if none is provided.
		//		if(initialValue == null)
		//		{
		//			String generationPackageName = settings.get("generationPackageName");
		//			getText().setText(generationPackageName);
		//			
		//		}
		// Look for saved searchpaths if none is provided.
		if(searchPathsInitialValues == null) {
			String[] savedSearchPath = settings.getArray( MODEL_UID + SEARCHPATHS_UID);
			if(savedSearchPath != null)
				searchPathsInitialValues = Arrays.asList(savedSearchPath);
			else
			{
				searchPathsInitialValues = CreationPackageCatalog.getDefaultSearchPath();
			}
		}

		// Look for saved creationPaths if none is provided.
		if(creationPaths == null ) {
			String[] savedSearchPath = settings.getArray( MODEL_UID + CREATIONPATHS_UID);
			if(savedSearchPath != null)
				creationPaths = savedSearchPath;
			else
				creationPaths = CreationPackageCatalog.getDefaultPackageCreationPatterns(" ; ");
		}

		listDialog = new InputListDialog(listMsg, searchPathsInitialValues);
		listDialog.setTooltips(listTooltips);
		creationPathsDialog = new InputListDialog(creationPathMsg, Arrays.asList(creationPaths));
		creationPathsDialog.setTooltips(creationPathTooltips);
	}

	/**
	 * 
	 * @param modelUid
	 * @param initialValue
	 * @return
	 */
	private static String getInitialValue(String modelUid, String initialValue) {
		IDialogSettings settings = Activator.getDefault().getDialogSettings();

		// Look for generationPackageName if none is provided.
		if(initialValue == null) {
	//		String generationPackageName = settings.get(MODEL_UID + SEARCHPATH_UID);
			String generationPackageName = settings.get(modelUid + DEFAULT_PACKAGE_NAME_UID);
			return generationPackageName;

		}
		return initialValue;
	}

	/**
	 * Allows resizing.
	 */
	@Override
	protected boolean isResizable() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Get the returned searchpaths.
	 * 
	 * @return
	 */
	public String[] getSearchPath() {
		return searchPath;
	}

	/**
	 * Get the returned creationPaths, one pattern for each entry, separated by ';'.
	 * 
	 * @return
	 */
	public List<String> getCreationPaths() {
		
		return splittedCreationPaths;
	}


	/**
	 * Create additional list of searchpaths.
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// create composite
		Composite composite = (Composite)super.createDialogArea(parent);

		listDialog.createDialogArea(composite);
		creationPathsDialog.createDialogArea(composite);
		return composite;
	}

	/**
	 * Save the searchpath after the button is pressed.
	 */
	@Override
	protected void okPressed() {
		// Save the list before the control is disposed
		searchPath = listDialog.getList();
		creationPaths = creationPathsDialog.getList();
		String defaultCreationPath = getValue();
		if(defaultCreationPath == null || defaultCreationPath.length() == 0)
			defaultCreationPath = CreationPackageCatalog.getDefaultCreationPath();
		
		// Check inputs
		try {
			// Check paths
			splittedCreationPaths = computeCreationPaths(creationPaths);
			CreationPackageCatalog.validateCreationPath(splittedCreationPaths);
			// add default searchPaths
			searchPath = addDefaultSearchPaths(Arrays.asList(searchPath), splittedCreationPaths).toArray(new String[0]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			showError( e.getMessage() );
			return;
		}
		
		
		// save values
		IDialogSettings settings = Activator.getDefault().getDialogSettings();
		settings.put(MODEL_UID + SEARCHPATHS_UID, searchPath);
		settings.put(MODEL_UID + CREATIONPATHS_UID, creationPaths);
		settings.put(MODEL_UID + DEFAULT_PACKAGE_NAME_UID, getValue());

		super.okPressed();
	}
	

	/**
	 * Add the defaultSearchPath extracted from the splittedCreationPath to the searchPath.
	 * @param splittedCreationPaths2
	 */
	private List<String> addDefaultSearchPaths(List<String>  searchPath, List<String> splittedCreationPaths) {


		List<String> result = new ArrayList<String>(searchPath.size()+splittedCreationPaths.size());
		result.addAll(searchPath);
		
		List<String> additionalPaths = CreationPackageCatalog.extractCreationPaths(splittedCreationPaths.toArray(new String[0]));
		for( String toAdd : additionalPaths) {
			if( ! result.contains(toAdd)) {
				result.add(toAdd);
			}
		}
		
		return result;
	}

	/**
	 * Show an error message
	 * @param message
	 */
	private void showError(String message) {
		System.err.println("Error: " + message);
		
	}

	
	/**
	 * Compute and check the creationsPaths
	 * @param creationPaths An array with one creationPattern by element
	 * @return An array with one path by elements
	 * @throws Exception 
	 */
	private List<String> computeCreationPaths(String[] creationPaths) throws Exception {
		
		List<String> result = new ArrayList<String>();
		
		// Iterate line by line
		// For each line, separate the 3 patterns
		// If a pattern is empty, put a null
		for( String line : creationPaths) {
			String[] eles = line.split(";");
			if(eles.length != 3) 
				throw new Exception("A line must contains 3 pattern separated by ';' :" + line);
			for( String ele : eles)
			{
				ele = ele.trim();
				if(ele.length() == 0)
					ele = null;
				// add ele
				result.add( ele );
			}
		}
		return result;
	}
	

}
