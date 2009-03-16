/**
 * 
 */
package javagen.umlparser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Package;

/**
 * Catalog used to find the package where an element should be created.
 * The catalog maintain a map of (java package prefixes, creation prefixes).
 * If no mapping is specified, the default creation package is used.
 * 
 * @author dumoulin
 *
 */
public class CreationPackageCatalog {

    
    /** package mapping */ 
    private List<LazyPackage> packageMap;
    /**
     * Default package returned when no mapping is found.
     */
    private Package defaultPackage;
     /** The model root package. Used to create mapped packages */ 
    private Package modelRootPackage;

    /**
     * Default mappings
     */
    private String[] defaultMappings = {
      "java.*", null, "java",
      "org.eclipse.*", "org.eclipse.papyrus.*", "eclipse",
      "org.osgi.*", null, "eclipse",
      "datatype.*", null, "datatype"
    };
    
    /**
     * Constructor.
     * Init the mappings
     * format: ("p1.p2.p3", "p1.p2.p3", "pa/pb/pc")
     * format: (include javaPackage, exclude javaPackage(or null), umlPackage)
     * include and exclude package can start or (xor) end with '*'
     * 
     * @param modelRootPackage Package used to create mapped packages
     * @param defaultPackage Default package returned when no mapping is found
     * @param packageMap mappings.
     */
    public CreationPackageCatalog(Package modelRootPackage, Package defaultPackage, String[] initialMappings) {
        this.defaultPackage = defaultPackage;
        this.modelRootPackage = modelRootPackage;
        packageMap = new ArrayList<LazyPackage>();
        
        initMappings(packageMap, defaultMappings);
        initMappings(packageMap, initialMappings);
    }

    /**
     * @param defaultPackage the defaultPackage to set
     */
    public void setDefaultPackage(Package defaultPackage) {
        this.defaultPackage = defaultPackage;
    }

    /**
     * Init the mappings
     * format: ("p1.p2.p3", "p1.p2.p3", "pa/pb/pc")
     * format: (include javaPackage, exclude javaPackage(or null), umlPackage)
     * @param mappings
     */
    private void initMappings(List<LazyPackage> mappings, String[] initialMappings)
    {
        if(initialMappings == null)
            return;
        
        for(int i=0; i<initialMappings.length; i+=3)
        {
            List<String> qname = UmlUtils.slashNameToQualifiedName(initialMappings[i+2]);
            String excludeKey = initialMappings[i+1];
            String[] excludeKeys = null;
            if(excludeKey != null)
            {
                excludeKeys = excludeKey.split(",");
            }
            mappings.add(new LazyPackage(initialMappings[i], excludeKeys, qname) );
        }
    }
    
    /**
     * Get the creation package for the specified qname.
     * @param qualifiedName
     * @return
     */
    public Package getCreationPackage( List<String> qualifiedName )
    {
        String qname = toFlatQualifiedName(qualifiedName);
        for(LazyPackage p : packageMap )
        {
            if(p.isFor(qname))
            {
                return p.getPackage();
            }
        }

        // not found
        return defaultPackage;
     }

    /**
     * Transform the qname into a string representation.
     * @param qualifiedName
     * @return
     */
    private String toFlatQualifiedName(List<String> qualifiedName) {
        if(qualifiedName.size() == 1)
            return qualifiedName.get(0);
        // Compute full name
        StringBuffer buff = new StringBuffer();
        
        buff.append(qualifiedName.get(0));
        for(int i=1; i<qualifiedName.size(); i++)
        {
            String part = qualifiedName.get(i);
            buff.append(".").append(part);
        }
        return buff.toString();
    }
    
    /**
     * Class to create package lazilly when requested.
     * @author dumoulin
     *
     */
    protected class LazyPackage {
        
        private Package umlPackage = null;
        private List<String> qualifiedName;
        
        private StringFilter filter;
        private StringFilter[] excludeFilters;
        
        /**
         * 
         * @param key
         * @param excludekey comma separated list of keys to exclude.
         * @param qualifiedName
         */
        public LazyPackage(String key, String[] excludekeys, List<String> qualifiedName) {
            this.filter = createFilter(key);
            this.excludeFilters = createFilters(excludekeys);
            this.qualifiedName = qualifiedName;
        }

        
        /**
         * Create a list of filters
         * @param excludekeys
         * @return
         */
        private StringFilter[] createFilters(String[] excludekeys) {
            if(excludekeys == null)
                return null;
            
            StringFilter[] filters = new StringFilter[excludekeys.length];
            
            for(int i=0; i<excludekeys.length; i++)
            {
               filters[i] = createFilter(excludekeys[i]);   
            }
            return null;
        }


        /**
         * Create appropriate filter by looking up the stars positions.
         * @param name
         * @return
         */
        private StringFilter createFilter(String name)
        {
            if(name.startsWith("*") )
            {
                return new EndWithFilter(name.substring(1, name.length()));
            }
            else if(name.endsWith("*") )
            {
                return new StartWithFilter(name.substring(0, name.length()-1));
            }
            else
            {
                return new IsEqualsFilter(name);
            }
            
        }
         /**
         * Return true if this mapping is for the provided qname.
         * @param packageQualifiedName
         * @return
         */
        public boolean isFor( String flatQualifiedName)
        {
//            System.out.println("isFor(" + filter.filter + "==" + flatQualifiedName + ")");
            if(filter.accept(flatQualifiedName) )
            {
                if(! isExcluded(flatQualifiedName))
                    return true;
            }
                
            
            return false;
        }

        /**
         * Is the name in the exclude list ?
         * @param flatQualifiedName
         * @return
         */
        private boolean isExcluded(String flatQualifiedName) {
            if(excludeFilters == null)
                return false;
            
            for(StringFilter exclude : excludeFilters)
            {
                if(exclude.accept(flatQualifiedName))
                    return true;
            }
            
            return false;
        }

        /**
         * Get the uml Package. Create it if needed.
         * @return
         */
        public Package getPackage()
        {
            if(umlPackage != null)
                return umlPackage;
            
            umlPackage = UmlUtils.getPackage(modelRootPackage, qualifiedName);
            return umlPackage;
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
}
