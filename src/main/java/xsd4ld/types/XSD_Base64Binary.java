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

package xsd4ld.types;

import javax.xml.bind.DatatypeConverter ;

import xsd4ld.XSDConst ;

public class XSD_Base64Binary extends BaseBinary {

    public XSD_Base64Binary() {
        // @@ Collapse not handled by regex.
        super(XSDConst.xsd_base64Binary, XSDConst.xsd_atomic, null /*XSDTypeRegex.getRegex(XSDConst.xsd_base64Binary)*/) ;
    }
    
    @Override
    protected byte[] valueOrException(String lex) {
        // Collapse facet.
        lex = collapse(lex) ;
        return DatatypeConverter.parseBase64Binary(lex) ;
    }
}