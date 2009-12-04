/**
 * 
 */
package javagen.umlparser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Catalog managing the imports names.
 * This catalog allows to lookup the qualified name of a type.
 * 
 * @author dumoulin
 * 
 */
public class ImportedTypeCatalog {

	private Map<String, List<String>> map = new HashMap<String, List<String>>();

	/**
	 * Default mapping to be set
	 */
	public String[] defaultMappingNames = {
			"String", "java.lang.String",
			"Class", "java.lang.Class",
			"Object", "java.lang.Object",
			"Exception", "java.lang.Exception",
			"Integer", "datatype.Integer",
			"Boolean", "datatype.Boolean",
			"Long", "datatype.Long",
			"Char", "datatype.Char"
			};

	/**
	 * Constructor.
	 */
	public ImportedTypeCatalog() {
		// Set default mapping
		setDefaultMapping(defaultMappingNames);
	}

	/**
	 * Set the default mappings
	 * 
	 * @param defaultMappingNames
	 */
	private void setDefaultMapping(String[] defaultMappingNames) {
		for(int i = 0; i < defaultMappingNames.length; i += 2) {
			map.put(defaultMappingNames[i], UmlUtils.toQualifiedName(defaultMappingNames[i + 1]));
			System.out.println("setDefaultMapping().add(" + defaultMappingNames[i] + ", " + UmlUtils.toQualifiedName(defaultMappingNames[i + 1]) + ")");
		}
	}

	/**
	 * Get the associated qualified name from the imports.
	 * Return the translation or the name itself, as a qualifiedName.
	 * 
	 * @param name
	 * @return
	 */
	public List<String> getQualifiedName(String name) {

		List<String> res = map.get(name);
		if(res == null)
			res = UmlUtils.toQualifiedName(name);
		return res;
	}

	/**
	 * Lookup the associated qualified name from the imports.
	 * 
	 * @param name
	 * @return
	 */
	private List<String> lookupQualifiedName(String name) {

		List<String> res = map.get(name);
		return res;
	}

	/**
	 * Get the qualified name of the provided [qualifiedName].
	 * If the provided name size is one, lookup for its full name.
	 * Otherwise, return the imput.
	 * 
	 * @param typeQualifiedName
	 * @return
	 */
	public List<String> getQualifiedName(List<String> possiblyQualifiedName) {
		if(possiblyQualifiedName.size() == 1) {
			List<String> res = lookupQualifiedName(possiblyQualifiedName.get(0));
			if(res == null)
				res = possiblyQualifiedName;
			return res;
		} else
			return possiblyQualifiedName;
	}

	/**
	 * Add an import
	 * 
	 * @param qualifiedName
	 */
	public void addImport(List<String> qualifiedName) {

		String lastName = qualifiedName.get(qualifiedName.size() - 1);
		System.out.println("ImportedCatalog.add(" + qualifiedName + ")");
		if("*".equals(lastName)) {
			addPackageClasses(qualifiedName);
		} else {
			map.put(lastName, qualifiedName);
		}
	}

	/**
	 * Add all the class from the package.
	 * Last name is '*'
	 * 
	 * @param qualifiedName
	 */
	private void addPackageClasses(List<String> qualifiedName) {
		// TODO Auto-generated method stub
		//		throw new UnsupportedOperationException("not yet implmeented");
		System.err.println(this.getClass().getName()
				+ ".addPackageClasses() - Not yet implemented - can't process import with 'p1.p2.*;'");
	}

	/**
	 * Clear all mappings
	 */
	public void clear() {
		map.clear();
		setDefaultMapping(defaultMappingNames);

	}

}
