/**
 * 
 */
package javagen.umlparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.uml2.uml.Package;

/**
 * Catalog used to find the package where an element should be created.
 * The catalog maintain a map of (java package prefixes, creation prefixes).
 * If no mapping is specified, the default creation package is used.
 * The catalog can be configured with:
 * <ul>
 *   <Li>defaultCreationPackage - The default path where packages are created when no matching 
 *   creation Paths can be found.</li>
 *   <Li>packageCreationPatterns - Pattern indicating in where a java package should be created according to its name. </li>
 *   <Li>packageSearchPatterns - Patterns used to search for an existing java patterns. Used by {@link ClassifierCatalog}</li>
 * </ul>
 * <br>
 * A packageCreationPatterns is made like that:
 * <ul>
 *   <li>packageCreationPatterns: includePattern excludePatterns creationPath</li>
 *   <li>includePattern: pathPattern | null</li>
 *   <li>excludePatterns: pathPattern*</li>
 *   <li>creationPath: pathPattern</li>
 *   <li>pathPattern: path*.'*' | path | '*'.path | path'.*.'path </li>
 *   <li>path: pathPart['.'pathPart]*</li>
 *   <li>pathPart: name</li>
 * </ul
 * <br>
 * A defaultCreationPackage is made like that:
 * <ul>
 *   <li>defaultCreationPackage: path</li>
 * </ul
 * <br>
 * A packageSearchPatterns is made like that:
 * <ul>
 *   <li>defaultCreationPackage: path*.'*'</li>
 * </ul
 * @author cedric dumoulin
 * 
 */
public class CreationPackageCatalog {

	public static final String WILDCARD = "*";

	/** package mapping */
	private List<CreationPattern> creationPatterns;

	/**
	 * Default package returned when no mapping is found.
	 */
	private Package defaultCreationPackage;

	private static String defaultCreationPath = "default";

	/** The model root package. Used to create mapped packages */
	private Package modelRootPackage;

	/**
	 * Default packageCreationPatterns.
	 */
	private static String[] defaultPackageCreationPatterns = {
			"java.*", null, "java",
			"org.eclipse.papyrus.*", null, "*",
			//			"org.eclipse.*", "org.eclipse.papyrus.*", "eclipse.*",
			"org.eclipse.*", "org.eclipse.papyrus.*", "*",
			"org.osgi.*", null, "osgi.*",
			"datatype.*", null, "datatype"
			};

	
	/**
	 * Constructor.
	 * Init the mappings
	 * format: ("p1.p2.p3", "p1.p2.p3", "pa/pb/pc")
	 * format: (include javaPackage, exclude javaPackage(or null), umlPackage)
	 * include and exclude package can start or (xor) end with '*'
	 * 
	 * @param modelRootPackage
	 *        Package used to create mapped packages
	 * @param defaultPackage
	 *        Default package returned when no mapping is found
	 * @param creationPatterns
	 *        mappings.
	 */
	public CreationPackageCatalog(Package modelRootPackage, Package defaultPackage, List<String> packageCreationPatterns) {
		this.defaultCreationPackage = defaultPackage;
		this.modelRootPackage = modelRootPackage;
		creationPatterns = new ArrayList<CreationPattern>();

		if( packageCreationPatterns == null || packageCreationPatterns.size() == 0)
		{
			// use default
			initPackageCreationPatterns(creationPatterns, defaultPackageCreationPatterns);
		}
		else {
			// Use provided array
			try {
				validateCreationPath(packageCreationPatterns);
			} catch (Exception e) {
				throw new IllegalArgumentException("Parameter initialMappings has bad format:", e);	
			}
			initPackageCreationPatterns(creationPatterns, packageCreationPatterns.toArray( new String[]{} ) );

		}

	}

	/**
	 * @param defaultPackage
	 *        the defaultPackage to set
	 */
	public void setDefaultPackage(Package defaultPackage) {
		this.defaultCreationPackage = defaultPackage;
	}

	/**
	 * Init the mappings
	 * format: ("p1.p2.p3", "p1.p2.p3", "pa/pb/pc")
	 * format: (include javaPackage, exclude javaPackage(or null), umlPackage)
	 * 
	 * @param mappings
	 */
	private void initPackageCreationPatterns(List<CreationPattern> mappings, String[] initialMappings) {
		if(initialMappings == null)
			return;

		for(int i = 0; i < initialMappings.length; i += 3) {
			String qname = initialMappings[i + 2];
			String excludeKey = initialMappings[i + 1];
			String[] excludeKeys = null;
			if(excludeKey != null) {
				excludeKeys = excludeKey.split(",");
			}
			mappings.add(new CreationPattern(initialMappings[i], excludeKeys, qname));
		}
	}

	/**
	 * Get the creation Package for the specified qualifiedName.
	 * The returned package is the Model from where the specified element should be created. 
	 * The package denoted by the qualifiedName are not created.
	 * 
	 * The modelPath is the model where specified element should be created.
	 * <br>
	 * Create any missing intermediate packages or models.
	 * 
	 * @param qualifiedName The fully qualified name of the element to create.
	 * @return The package where the element should be created, according to its qualified name. The 
	 */
	public Package getCreationPackage(List<String> qualifiedName) {
		String qname = toFlatQualifiedName(qualifiedName);
		for(CreationPattern p : creationPatterns) {
			if(p.isFor(qname)) {
				return p.getPackage(qualifiedName);
			}
		}

		// not found
		return defaultCreationPackage;
	}

	
	/**
	 * Used by the UI to show the default values.
	 * Return one line for each packageCreationPatterns
	 * @return the defaultPackageCreationPatterns
	 */
	public static String[] getDefaultPackageCreationPatterns(String separator) {
		
		return toLineCreationPattern(defaultPackageCreationPatterns, separator);
	}

	
	/**
	 * @return the defaultCreationPath
	 */
	public static String getDefaultCreationPath() {
		return defaultCreationPath;
	}

	/**
	 * Transform a String with dot in a List of String
	 * @param key
	 * @return
	 */
	private List<String> dotToListOfString(String key) {
		return Arrays.asList(key.split("\\."));
	}

	/**
	 * Transform the qname into a string representation.
	 * 
	 * @param qualifiedName
	 * @return
	 */
	private String toFlatQualifiedName(List<String> qualifiedName) {
		if(qualifiedName.size() == 1)
			return qualifiedName.get(0);
		// Compute full name
		StringBuffer buff = new StringBuffer();

		buff.append(qualifiedName.get(0));
		for(int i = 1; i < qualifiedName.size(); i++) {
			String part = qualifiedName.get(i);
			buff.append(".").append(part);
		}
		return buff.toString();
	}

	/**
	 * A pattern mapping java packages to path representing the model where the java package should be created
	 * 
	 * @author dumoulin
	 * 
	 */
	protected class CreationPattern {

		private CreationModelPathEntry creationModelPathEntry;

		private StringFilter includeFilter;

		private StringFilter[] excludeFilters;

		/**
		 * 
		 * @param key
		 * @param excludekey
		 *        comma separated list of keys to exclude.
		 * @param qualifiedName
		 */
		public CreationPattern(String key, String[] excludekeys, String qualifiedName) {
			this.includeFilter = createFilter(key);
			this.excludeFilters = createFilters(excludekeys);
			this.creationModelPathEntry = createCreationModelPathEntry(key, qualifiedName);
		}


		/**
		 * Create a list of filters
		 * 
		 * @param excludekeys
		 * @return
		 */
		private StringFilter[] createFilters(String[] excludekeys) {
			if(excludekeys == null)
				return null;

			StringFilter[] filters = new StringFilter[excludekeys.length];

			for(int i = 0; i < excludekeys.length; i++) {
				filters[i] = createFilter(excludekeys[i]);
			}
			return null;
		}


		/**
		 * Create appropriate filter by looking up the stars positions.
		 * 
		 * @param name
		 * @return
		 */
		private StringFilter createFilter(String name) {
			if(name.startsWith("*")) {
				return new EndWithFilter(name.substring(1, name.length()));
			} else if(name.endsWith("*")) {
				return new StartWithFilter(name.substring(0, name.length() - 1));
			} else {
				return new IsEqualsFilter(name);
			}

		}

		/**
		 * Create appropriate CreationModelPathEntry by looking up the #WILDCARD positions.
		 * 
		 * @param name
		 * @return
		 */
		private CreationModelPathEntry createCreationModelPathEntry(String key, String qualifiedNameWithDot) {

			List<String> qname = dotToListOfString(qualifiedNameWithDot);

			// Create the appropriate QualifiedNameGenerator
			if(qname.contains("*")) {
				if(key.contains("*")) {
					// Both string contains '*'
					return new PatternCreationModelPathEntry(key, qname);
				} else {
					// key have no pattern, but qualified name has.
					// No solution: remove '*' from qualifiedName 
					qname.remove("*");
					return new SimpleCreationModelPathEntry(qname);
				}
			} else {
				// the qualified name has no pattern
				return new SimpleCreationModelPathEntry(qname);
			}


		}

		/**
		 * Return true if this mapping is for the provided qname.
		 * 
		 * @param packageQualifiedName
		 * @return
		 */
		public boolean isFor(String flatQualifiedName) {
			//            System.out.println("isFor(" + filter.filter + "==" + flatQualifiedName + ")");
			if(includeFilter.accept(flatQualifiedName)) {
				if(!isExcluded(flatQualifiedName))
					return true;
			}


			return false;
		}

		/**
		 * Is the name in the exclude list ?
		 * 
		 * @param flatQualifiedName
		 * @return
		 */
		private boolean isExcluded(String flatQualifiedName) {
			if(excludeFilters == null)
				return false;

			for(StringFilter exclude : excludeFilters) {
				if(exclude.accept(flatQualifiedName))
					return true;
			}

			return false;
		}

		/**
		 * Get the uml Package. Create it if needed.
		 * Create a Model that will contains the created elements
		 * 
		 * @param proposedPath
		 *        The proposedPath for which the creation Package is requested.
		 * @return
		 */
		public Package getPackage(List<String> proposedPath) {

			//			umlPackage = UmlUtils.getPackage(modelRootPackage, qualifiedName);
			Package cachedPackage = UmlUtils.getModel(modelRootPackage, creationModelPathEntry.getCreationModelPath(proposedPath));
			return cachedPackage;
		}
	}

	abstract private class StringFilter {

		protected String filter;

		/**
		 * @param filter
		 */
		public StringFilter(String filter) {
			this.filter = filter;
		}

		abstract public boolean accept(String name);
	}

	private class StartWithFilter extends StringFilter {

		public StartWithFilter(String filter) {
			super(filter);
		}

		@Override
		public boolean accept(String name) {
			return name.startsWith(filter);
		}

	}

	private class EndWithFilter extends StringFilter {

		public EndWithFilter(String filter) {
			super(filter);
		}

		@Override
		public boolean accept(String name) {
			return name.endsWith(filter);
		}

	}

	private class IsEqualsFilter extends StringFilter {

		public IsEqualsFilter(String filter) {
			super(filter);
		}

		@Override
		public boolean accept(String name) {
			return name.equals(filter);
		}

	}

	/**
	 * A CreationModelPathEntry is used get the model path for a given elementPath.
	 *  
	 * @author dumoulin
	 *
	 */
	private abstract class CreationModelPathEntry {

		/**
		 * Return the path for the model in wich the specified element should be created.
		 * 
		 * @param elementName
		 *        The fully qualified name of the element to create.
		 * @return
		 */
		abstract public List<String> getCreationModelPath(List<String> pattern);
	}

	/**
	 * A {@link CreationModelPathEntry} returning the registered path.
	 * The path should not contain {@value #WILDCARD}
	 * @author dumoulin
	 *
	 */
	private class SimpleCreationModelPathEntry extends CreationModelPathEntry {

		/**
		 * The qualified name of the model where element are created
		 */
		private List<String> modelPath;

		/**
		 * 
		 * Constructor.
		 *
		 * @param modelPath The qualified name of the model where element are created
		 */
		public SimpleCreationModelPathEntry(List<String> modelPath) {
			this.modelPath = modelPath;
		}

		/**
		 * Return the patt for the model in wich the specified element should be created.
		 * 
		 * @see javagen.umlparser.CreationPackageCatalog.CreationModelPathEntry#getCreationModelPath(java.util.List)
		 * 
		 * @param elementName
		 *        The fully qualified name of the element to create.
		 * @return
		 */
		@Override
		public List<String> getCreationModelPath(List<String> elementName) {
			// Return the registered path 
			return modelPath;
		}

	}

	/**
	 * This {@link CreationModelPathEntry} allows to create Models giving a pattern containing a wildcard.
	 * 
	 * @author dumoulin
	 * 
	 */
	private class PatternCreationModelPathEntry extends CreationModelPathEntry {

		private List<String> qname;

		private int srcPartIndex;

		private int targetPartIndex;

		public PatternCreationModelPathEntry(String key, List<String> qname) {

			// 
			List<String> qualifiedKey = dotToListOfString(key);
			// Get the index of the '*'
			srcPartIndex = qualifiedKey.indexOf("*");
			targetPartIndex = qname.indexOf("*");
			if( targetPartIndex <0 || srcPartIndex < 0)
			{
				System.err.println("getCreationModelPath() - index problem for " + key + ", " + qname);
			}
			this.qname = qname;
		}

		/**
		 * Return the name of the model for the specified qualifiedname.
		 * 
		 * @see javagen.umlparser.CreationPackageCatalog.CreationModelPathEntry#getCreationModelPath(java.util.List)
		 * 
		 * @param elementName
		 *        The fully qualified name of the element to create.
		 * @return
		 */
		@Override
		public List<String> getCreationModelPath(List<String> elementName) {
			List<String> result = new ArrayList<String>(qname);
			// Replace the '*' in the requested path by the name found at the star index in the provided pattern
			if( targetPartIndex <0 || srcPartIndex < 0)
			{
				System.err.println("getCreationModelPath() - index problem for " + elementName);
			}
			result.set(targetPartIndex, elementName.get(srcPartIndex));
			return result;
		}

	}

	/**
	 * Validate the creation paths. The list contains one pattern by element
	 * @param paths
	 * @throws Exception If the path is not valid. The message describes the error.
	 */
	public static void validateCreationPath(List<String> paths) throws Exception {
		
		for( int i=0; i< paths.size(); i+=3)
		{
			String includePattern = paths.get(i);
			String excludePattern = paths.get(i+1);
			String targetPath = paths.get(i+2);
			String errorLine = "[" + includePattern + " ; " + excludePattern + " ; " + targetPath + "]";
			checkNotEmptyPattern( includePattern,  errorLine);
			checkNotEmptyPattern( targetPath,  errorLine );
			checkSizeNotZero( excludePattern,  errorLine );
		}
		
	}

	private static void checkSizeNotZero(String pattern, String errorLine) throws Exception {
		if( !(pattern ==null) && pattern.length() == 0)
			throw new Exception("Pattern should not be null or empty" + errorLine);
	}

	private static void checkNotEmptyPattern(String pattern, String errorLine) throws Exception {

		if(pattern==null || pattern.length() == 0)
			throw new Exception("Pattern should not be null or empty" + errorLine);
		
	}

	/**
	 * Transform a creation package with one single pattern by element to 
	 * an array of creationPatterns (one creationPattern by line).
	 * @return the defaultPackageCreationPatterns
	 */
	public static String[] toLineCreationPattern(String[] elements, String separator) {
		
		int size = elements.length/3;
		String[] result = new String[size];
		
		int index = 0;
		for(int i = 0; i < elements.length; i += 3) {
			String includePattern = elements[i];
			String excludePattern = elements[i + 1];
			String creationPath = elements[i + 2];
			
			if(excludePattern == null)
				excludePattern = "";

			result[index] = includePattern + separator + excludePattern + separator + creationPath;
			index++;
		}
		return result;
	}

	/**
	 * Get all the creationPath of the specified creation patterns (one path by element);
	 * @param creationPattern A splitted creation pattern array
	 * @return
	 */
	public static List<String> extractCreationPaths(String[] creationPattern) {
		
		int size = creationPattern.length/3;
		List<String> result = new ArrayList<String>(size);
		
		for(int i = 0; i < creationPattern.length; i += 3) {
			String element = creationPattern[i+2];
			if( !result.contains(element))
				result.add(element);
		}
		return result;
	}
	
	/**
	 * Get an array containing the specified colon of the provided array
	 * @return the defaultPackageCreationPatterns
	 */
	private static String[] extractColumn(String[] inputArray, int columnCount, int extractedColumn) {
		
		int size = inputArray.length/columnCount;
		String[] result = new String[size];
		
		int index = 0;
		for(int i = 0; i < inputArray.length; i += 3) {
			String element = inputArray[i+extractedColumn];
			result[index] = element;
			index++;
		}
		return result;
	}

	public static List<String> getDefaultSearchPath() {
		// TODO Auto-generated method stub
		return extractCreationPaths(defaultPackageCreationPatterns);
	}


}
