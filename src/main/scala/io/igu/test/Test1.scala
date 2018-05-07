package io.igu.test

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import com.typesafe.scalalogging.LazyLogging
import io.igu.meetup.v2.ConciergeClientComponent
import io.igu.whatson.WhatsOnRequestStreamHandler

object Test1 extends App with ConciergeClientComponent with LazyLogging {
  override val conciergeClient = new ConciergeClient {}

  logger.info("Hello")

  new WhatsOnRequestStreamHandler().handleRequest(
    new ByteArrayInputStream("".getBytes()),
    new ByteArrayOutputStream(),
    null
  )

}