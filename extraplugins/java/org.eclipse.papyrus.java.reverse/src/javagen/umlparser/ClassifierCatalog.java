/**
 * 
 */
package javagen.umlparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;

/**
 * Instance of this class allows to lookup for a Classifier.
 * Lookup is done in the provided paths.
 * Classifier or Package are not created. An error is thrown when not found.
 * 
 * @author dumoulin
 * 
 * @TODO rename to ClasspathCatalog
 */
public class ClassifierCatalog {

	/** Model containing the paths */
	protected Resource model;

	/** model Package used as root of all searchpaths */
	private Package modelRootPackage;

	/** The package containing the current compilation unit. First package searched */
	private Package currentCompilationUnitPackage;

	/**
	 * List of packages from where the lookup is done.
	 */
	protected List<SearchPackage> paths = new ArrayList<SearchPackage>();;

	/**
	 * Constructor.
	 */
	public ClassifierCatalog(Resource model) {
		this.model = model;
		paths.add(new ResourceSearcPackage());
	}

	/**
	 * Constructor.
	 */
	public ClassifierCatalog(Resource model, List<String> packageNames) {
		this.model = model;
		for(String name : packageNames) {
			if("/".equals(name)) {
				paths.add(new ResourceSearcPackage());
			} else {
				List<String> qualifiedName = dirToQualifiedName(name);
				// Get corresponding package if any
				paths.add(new AbsoluteSearchPackage(qualifiedName));
			}

		}
	}

	/**
	 * Constructor.
	 * search paths are relative to the specified package.
	 */
	public ClassifierCatalog(Package modelRootPackage, List<String> packageNames) {
		this.modelRootPackage = modelRootPackage;
		for(String name : packageNames) {
			if("/".equals(name)) {
				paths.add(new ResourceSearcPackage());
			} else {
				List<String> qualifiedName = dirToQualifiedName(name);
				// Get corresponding package if any
				paths.add(new RelativeSearchPackage(qualifiedName));
			}

		}
	}

	/**
	 * @param currentCompilationUnitPackage
	 *        the currentCompilationUnitPackage to set
	 */
	public void setCurrentCompilationUnitPackage(Package currentCompilationUnitPackage) {
		this.currentCompilationUnitPackage = currentCompilationUnitPackage;
	}

	/**
	 * Get the qualified name from a directory like name.
	 * Name is splitted arround '/'
	 * 
	 * @param name
	 * @return
	 */
	private List<String> dirToQualifiedName(String qname) {
		String[] splittedName = qname.split("/");
		return Arrays.asList(splittedName);
	}


	/**
	 * Get the classifier by its qname.
	 * 
	 * @param qualifiedName
	 * @return
	 */
	public Classifier getClassifier(String qualifiedName) {
		List<String> qname = UmlUtils.toQualifiedName(qualifiedName);
		return getClassifier(qname);
	}

	/**
	 * Get the classifier by its qualified name.
	 * 
	 * @param qualifiedName
	 * @return
	 */
	public Classifier getClassifier(List<String> qualifiedName) {
		return lookupNamedElement(qualifiedName, null);
		//		for( Package path : paths)
		//		{
		//			NamedElement res = getNamedElement(path, qualifiedName);
		//			if(res != null )
		//				return (Classifier)res;
		//		}
		//		
		//		return null;
	}

	/**
	 * Look for the specified element in each of the path of the model.
	 * Return the first corresponding element found in paths.
	 * 
	 * @param qualifiedName
	 *        Expected name.
	 * @param type
	 *        Expected type or null.
	 * @return
	 */
	private Classifier lookupNamedElement(List<String> qualifiedName, EClass type) {

		// search on current CU
		if(currentCompilationUnitPackage != null) {
			Classifier res = UmlUtils.lookupClassifier(currentCompilationUnitPackage, qualifiedName, type);
			if(res != null)
				return res;
		}

		// loop on searchpaths
		for(SearchPackage path : paths) {
			Classifier res = path.getUmlClassifier(qualifiedName, type);
			if(res != null)
				return res;
		}

		return null;
	}


	/**
	 * Class corresponding to one searchpath.
	 * 
	 * @author dumoulin
	 * 
	 */
	abstract private class SearchPackage {

		protected Package umlPackage;

		protected List<String> packageQualifiedName;

		/**
		 * @param qualifiedName
		 */
		public SearchPackage(List<String> qualifiedName) {
			super();
			this.packageQualifiedName = qualifiedName;
		}

		abstract public Classifier getUmlClassifier(List<String> qualifiedName, EClass expectedType);
	}

	/**
	 * This represent a searchpackage whose name is absolute from the resource.
	 * 
	 * @author dumoulin
	 * 
	 */
	private class AbsoluteSearchPackage extends SearchPackage {

		public AbsoluteSearchPackage(List<String> qualifiedName) {
			super(qualifiedName);
		}

		/**
		 * Get the uml package corresponding to the path.
		 * 
		 * @return
		 */
		private Package getPathPackage() {
			if(umlPackage != null)
				return umlPackage;

			// Try to find package
			umlPackage = UmlUtils.lookupPackage(model, packageQualifiedName);
			return umlPackage;
		}

		/**
		 * lookup for the classifier in this searchpath.
		 */
		@Override
		public Classifier getUmlClassifier(List<String> qualifiedName, EClass expectedType) {
			Package p = getPathPackage();
			if(p == null)
				return null;

			return UmlUtils.lookupClassifier(p, qualifiedName, expectedType);
		}
	}

	/**
	 * This represent search package relative to the modelRootPackage..
	 * 
	 * @author dumoulin
	 * 
	 */
	private class RelativeSearchPackage extends SearchPackage {

		public RelativeSearchPackage(List<String> qualifiedName) {
			super(qualifiedName);
		}

		/**
		 * Get the uml package corresponding to the path.
		 * Search from the modelRootPackage.
		 * 
		 * @return
		 */
		private Package getPathPackage() {
			if(umlPackage != null)
				return umlPackage;

			// Try to find package
			umlPackage = UmlUtils.lookupPackage(modelRootPackage, packageQualifiedName);
			return umlPackage;
		}

		/**
		 * lookup for the classifier in this searchpath.
		 */
		@Override
		public Classifier getUmlClassifier(List<String> qualifiedName, EClass expectedType) {
			Package p = getPathPackage();
			if(p == null)
				return null;

			return UmlUtils.lookupClassifier(p, qualifiedName, expectedType);
		}

	}

	/**
	 * Search is done in the resource directly.
	 * 
	 * @author dumoulin
	 * 
	 */
	private class ResourceSearcPackage extends SearchPackage {

		public ResourceSearcPackage() {
			super(null);
			// TODO Auto-generated constructor stub
		}

		/**
		 * lookup for the classifier in this searchpath.
		 */
		@Override
		public Classifier getUmlClassifier(List<String> qualifiedName, EClass expectedType) {
			return UmlUtils.lookupClassifier(model, qualifiedName, expectedType);
		}

	}
}
