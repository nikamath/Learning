/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sap.demo.mycomponent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBResult;
import javax.xml.bind.util.JAXBSource;

import org.apache.camel.Exchange;
import org.apache.camel.converter.jaxp.XmlConverter;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The www.Sample.com producer.
 */
public class MyComponentProducer extends DefaultProducer {
    private static final transient Logger LOG = LoggerFactory.getLogger(MyComponentProducer.class);
    private MyComponentEndpoint endpoint;

	public MyComponentProducer(MyComponentEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    @Override
    protected void doStart() throws Exception {
        super.doStart();
    }

    public void process(final Exchange exchange) throws Exception {
        String input = (String) exchange.getIn().getBody();
		/*String greetingMessage = endpoint.getGreetingsMessage();
		if(greetingMessage == null || greetingMessage.isEmpty()) {
			greetingMessage = "Hello!";
		}
		String messageInUpperCase = greetingMessage.toUpperCase();
		if (input != null) {
		    LOG.debug(input);
			messageInUpperCase = input + " : " + messageInUpperCase;
		}
		exchange.getIn().setBody(messageInUpperCase);*/
        
        XmlConverter  converter = new XmlConverter();
        JAXBResult result = new JAXBResult(JAXBContext.newInstance(SAP_SQL.class));
        System.out.println(result.getResult().toString());
    }

}
