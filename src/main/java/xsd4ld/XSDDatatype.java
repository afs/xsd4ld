/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xsd4ld;

import java.util.regex.Pattern ;

public abstract class XSDDatatype {
    /** The xsd namespace */
    public static final String XSD = "http://www.w3.org/2001/XMLSchema";
    /** The xsd namespace */
    public static final String XSDns = XSD+"#" ;
    
    protected final String shortName ;
    protected final String uri ;
    protected final Pattern regex ;
    protected final String derivedFrom ;
    
    protected XSDDatatype(String shortName, String derivedFrom, Pattern regex) {
        this.shortName = shortName ;
        this.uri = XSDns+shortName ;
        this.regex = regex ;
        this.derivedFrom = derivedFrom ;
    }
    
    /** Return a value object if the lexical form is valid
     * for the type else return null. 
     * @param lex   lexcial form
     * @return Object ornull, if the lexcial form is not valid for this datatype.
     */
    
    public Object value(String lex) {
        try { return valueOrException(lex) ; }
        catch (Exception ex) { return null; }
    }
    
    /** Test the lexical form and the value it represents.
     * This involves calculating the value, so calling {@link #value}
     * and testign for {@code null}
     * is more efficient if the value obkect is required. 
     * @param lex
     * @return boolean
     */
    public boolean isValid(String lex) {
        return value(lex) != null ;
    }

    /** Return the value, null or throw an exception.
     * Exceptions are converted to nulls by {@link #value}  
     * @param lex
     * @return
     */
    protected abstract Object valueOrException(String lex) ;
    
    /** Full facet collapse. Usually not needed because 
     * internal whitespace is illegal.  
     * @param lex
     * @return
     */
    static protected String collapse(String lex) {
        lex = lex.replace("  ", " ") ;
        return trim(lex) ;
    }

    static protected String trim(String lex) {
        return lex.trim() ;
    }

    /** Get the XSD name for this type */
    public String getName() {
        return shortName ;
    }

    /** Get the URI for this type */
    public String getURIName() {
        return uri ;
    }

    public final String isDerivedFrom() {
        return derivedFrom ;
    }
    
    /** Get the "best" regex for this type.
     *  "Best" is the regex of this type or the first "derived from"
     *  type in the hierarchy.
     *  Conforming to the regex is necessary but not sufficient for a valid lexical form.
     */  
    public Pattern getRegex() {
        return regex ;
    }
    
    /** Get the "best" regex for this type.
     *  "Best" is the regex of this type or the first "derived from"
     *  type in the hierarchy.
     *  Conforming to the regex is necessary but not sufficient for a valid lexical form.
     */  
    public String getRegexStr() {
        return regex.toString() ;
    }
    
//    @Override
//    public abstract int hashCode( );
//    @Override
//    public abstract boolean equals(Object other) ;
}


