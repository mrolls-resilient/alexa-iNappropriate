package io.igu.meetup.v2.model

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

case class Metadata(next: String,
                    method: String,
                    total_count: Int,
                    link: String,
                    count: Int,
                    description: String,
                    lon: String,
                    title: String,
                    url: String,
                    signed_url: String,
                    id: String,
                    updated: Int,
                    lat: String)

object Metadata {
  implicit val encoder: Encoder[Metadata] = deriveEncoder[Metadata]
  implicit val decoder: Decoder[Metadata] = deriveDecoder[Metadata]
}