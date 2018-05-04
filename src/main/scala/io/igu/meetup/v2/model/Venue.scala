package io.igu.meetup.v2.model

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

case class Venue(country: String,
                 localized_country_name: String,
                 city: String,
                 address_1: String,
                 name: String,
                 lon: Double,
                 id: Int,
                 lat: Double,
                 repinned: Boolean)

object Venue {
  implicit val encoder: Encoder[Venue] = deriveEncoder[Venue]
  implicit val decoder: Decoder[Venue] = deriveDecoder[Venue]
}

