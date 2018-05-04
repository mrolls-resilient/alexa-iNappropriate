package io.igu.meetup.v2.model

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

case class Fee(amount: Int,
               currency: String,
               label: String,
               accepts: String,
               required: String)

object Fee {
  implicit val encoder: Encoder[Fee] = deriveEncoder[Fee]
  implicit val decoder: Decoder[Fee] = deriveDecoder[Fee]
}
