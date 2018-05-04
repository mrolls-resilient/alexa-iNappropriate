package io.igu.test

import io.igu.meetup.v2.ConciergeClientComponent

object Test1 extends App with ConciergeClientComponent {
  override val conciergeClient = new ConciergeClient {}

  println(conciergeClient.concierge)
}