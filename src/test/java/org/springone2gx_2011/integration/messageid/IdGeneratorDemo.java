/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springone2gx_2011.integration.messageid;

import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.MessageHeaders.IdGenerator;
import org.springframework.integration.message.GenericMessage;

/**
 * @author Oleg Zhurakousky
 * SpringOne2GX, Chicago 2011
 */
public class IdGeneratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("idgenerator-config.xml", IdGeneratorDemo.class);
		new GenericMessage<String>("");

	}
	
	
	public static class SampleIdGenerator implements IdGenerator {
		public UUID generateId() {
			System.out.println("### Generating ID");
			return UUID.nameUUIDFromBytes(((System.currentTimeMillis() - System.nanoTime()) + "").getBytes());
		}
	}

}
