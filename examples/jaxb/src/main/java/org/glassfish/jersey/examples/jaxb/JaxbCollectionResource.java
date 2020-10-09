/*
 * Copyright (c) 2010, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package org.glassfish.jersey.examples.jaxb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * An example resource utilizing collections of JAXB beans.
 *
 * @author Paul Sandoz
 */
@Path("jaxb/collection")
@Produces("application/xml")
@Consumes("application/xml")
public class JaxbCollectionResource {

    @Path("XmlRootElement")
    @GET
    public List<JaxbXmlRootElement> getRootElement() {
        List<JaxbXmlRootElement> el = new ArrayList<JaxbXmlRootElement>();
        el.add(new JaxbXmlRootElement("one root element"));
        el.add(new JaxbXmlRootElement("two root element"));
        el.add(new JaxbXmlRootElement("three root element"));
        return el;
    }

    @Path("XmlRootElement")
    @POST
    public Collection<JaxbXmlRootElement> postRootElement(List<JaxbXmlRootElement> el) {
        return el;
    }

    @Path("XmlType")
    @POST
    public List<JaxbXmlRootElement> postXmlType(List<JaxbXmlType> tl) {
        List<JaxbXmlRootElement> el = new ArrayList<JaxbXmlRootElement>();

        for (JaxbXmlType t : tl) {
            el.add(new JaxbXmlRootElement(t.value));
        }

        return el;
    }
}