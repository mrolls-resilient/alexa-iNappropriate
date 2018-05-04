package io.igu.meetup.v2.model

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}





case class Event(utc_offset: Int,
                 venue: Venue,
                 headcount: Int,
                 visibility: String,
                 waitlist_count: Int,
                 created: Int,
                 maybe_rsvp_count: Int,
                 description: String,
                 event_url: String,
                 yes_rsvp_count: Int,
                 duration: Int,
                 name: String,
                 id: String,
                 photo_url: String,
                 time: Int,
                 updated: Int,
                 group: Group,
                 status: String,
                 rsvp_limit: Int,
                 how_to_find_us: String,
                 fee: Fee)

object Event {
  implicit val encoder: Encoder[Event] = deriveEncoder[Event]
  implicit val decoder: Decoder[Event] = deriveDecoder[Event]
}