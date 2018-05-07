package io.igu.test

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import com.typesafe.scalalogging.LazyLogging
import io.igu.meetup.v2.ConciergeClientComponent
import io.igu.whatson.WhatsOnRequestStreamHandler

object Test1 extends App with ConciergeClientComponent with LazyLogging {
  override val conciergeClient = new ConciergeClient {}

  val input = """{
                |		"type": "IntentRequest",
                |		"requestId": "amzn1.echo-api.request.28de9e0d-13d8-4517-bf61-a6d637cbee25",
                |		"timestamp": "2018-05-07T15:49:31Z",
                |		"locale": "en-GB",
                |		"intent": {
                |			"name": "AMAZON.HelpIntent",
                |			"confirmationStatus": "NONE"
                |		}
                |	}""".stripMargin

  new WhatsOnRequestStreamHandler().handleRequest(
    new ByteArrayInputStream(input.getBytes()),
    new ByteArrayOutputStream(),
    null
  )

}