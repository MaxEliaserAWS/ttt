/*
 * Copyright 2014 Skynav, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY SKYNAV, INC. AND ITS CONTRIBUTORS “AS IS” AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL SKYNAV, INC. OR ITS CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.skynav.cap2tt.app;

import java.net.URL;
import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.skynav.xml.helpers.Documents;
import  com.skynav.xml.helpers.XML;

import static com.skynav.ttv.model.ttml.TTML.Constants.*;


public class Configuration extends com.skynav.ttv.util.Configuration {

    private static final QName ttTimedTextEltName               = new QName(NAMESPACE_TT, "tt");
    private static final QName ttInitialEltName                 = new QName(NAMESPACE_TT, "initial");
    private static final QName ttRegionEltName                  = new QName(NAMESPACE_TT, "region");

    private List<Attr> parameters;
    private List<Element> initials;
    private List<Element> regions;

    public Configuration() {
        this(new ConfigurationDefaults());
    }

    public Configuration(com.skynav.ttv.util.ConfigurationDefaults defaults) {
        this(defaults, null);
    }

    public Configuration(com.skynav.ttv.util.ConfigurationDefaults defaults, Document d) {
        super(defaults, d);
    }

    @Override
    protected void populate(Document d) {
        super.populate(d);
        populateParameters(d);
        populateInitials(d);
        populateRegions(d);
    }

    public List<Attr> getParameters() {
        return parameters;
    }

    public List<Element> getInitials() {
        return initials;
    }

    public List<Element> getRegions() {
        return regions;
    }

    public Element getRegion(String id) {
        String ns = XML.getNamespaceUri();
        String ln = "id";
        for (Element r : regions) {
            if (r.hasAttributeNS(ns, ln)) {
                String rId = r.getAttributeNS(ns, ln);
                if (rId.equals(id))
                    return r;
            }
        }
        return null;
    }

    private void populateParameters(Document d) {
        List<Attr> attributes = new java.util.ArrayList<Attr>();
        if (d != null) {
            Element e = Documents.findElementByName(d, ttTimedTextEltName);
            if (e != null) {
                NamedNodeMap attrs = e.getAttributes();
                for (int i = 0, n = attrs.getLength(); i < n; ++i) {
                    Node node = attrs.item(i);
                    if (node instanceof Attr) {
                        Attr a = (Attr) node;
                        String ns = a.getNamespaceURI();
                        if ((ns != null) && ns.equals(NAMESPACE_TT_PARAMETER)) {
                            attributes.add(a);
                        }
                    }
                }
            }
        }
        this.parameters = Collections.unmodifiableList(attributes);
    }

    private void populateInitials(Document d) {
        List<Element> elts;
        if (d != null)
            elts = Documents.findElementsByName(d, ttInitialEltName);
        else
            elts = new java.util.ArrayList<Element>();
        this.initials = Collections.unmodifiableList(elts);
    }

    private void populateRegions(Document d) {
        List<Element> elts;
        if (d != null)
            elts = Documents.findElementsByName(d, ttRegionEltName);
        else
            elts = new java.util.ArrayList<Element>();
        this.regions = Collections.unmodifiableList(elts);
    }

    public static URL getDefaultConfigurationLocator() {
        return getDefaultConfigurationLocator(Configuration.class, null);
    }

}
